package io.onsense.universe.format;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Koen Rooijmans
 */
public class DataFormatter {

    private static final String defaultFractionWholePartFormat = "#";
    private static final String defaultFractionFractionPartFormat = "#/##";
    private static final Pattern numPattern = Pattern.compile("[0#]+");
    private static final Pattern daysAsText = Pattern.compile("([d]{3,})", Pattern.CASE_INSENSITIVE);
    private static final Pattern amPmPattern = Pattern.compile("(([AP])[M/P]*)", Pattern.CASE_INSENSITIVE);
    private static final Pattern localePatternGroup = Pattern.compile("(\\[\\$[^-\\]]*-[0-9A-Z]+\\])");
    private static final Pattern colorPattern =
            Pattern.compile("(\\[BLACK\\])|(\\[BLUE\\])|(\\[CYAN\\])|(\\[GREEN\\])|" +
                    "(\\[MAGENTA\\])|(\\[RED\\])|(\\[WHITE\\])|(\\[YELLOW\\])|" +
                    "(\\[COLOR\\s*\\d\\])|(\\[COLOR\\s*[0-5]\\d\\])", Pattern.CASE_INSENSITIVE);
    private static final Pattern fractionPattern = Pattern.compile("(?:([#\\d]+)\\s+)?(#+)\\s*\\/\\s*([#\\d]+)");
    private static final Pattern fractionStripper = Pattern.compile("(\"[^\"]*\")|([^ \\?#\\d\\/]+)");
    private static final Pattern alternateGrouping = Pattern.compile("([#0]([^.#0])[#0]{3})");
    private static final String invalidDateTimeString;

    static {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < 255; i++) buf.append('#');
        invalidDateTimeString = buf.toString();
    }

    private final Map<String, Format> formats = new HashMap<>();
    private final boolean emulateCSV;
    private DecimalFormatSymbols decimalSymbols = DecimalFormatSymbols.getInstance(Locale.ENGLISH);
    private DateFormatSymbols dateSymbols = DateFormatSymbols.getInstance(Locale.ENGLISH);
    private DateFormat defaultDateformat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", dateSymbols);
    private Format generalNumberFormat = new ExcelGeneralNumberFormat(Locale.ENGLISH);
    private Format defaultNumFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", dateSymbols);

    {
        defaultDateformat.setTimeZone(LocaleUtil.getUserTimeZone());
        Format zipFormat = ZipPlusFourFormat.instance;
        addFormat("00000\\-0000", zipFormat);
        addFormat("00000-0000", zipFormat);

        Format phoneFormat = PhoneFormat.instance;
        // allow for format string variations
        addFormat("[<=9999999]###\\-####;\\(###\\)\\ ###\\-####", phoneFormat);
        addFormat("[<=9999999]###-####;(###) ###-####", phoneFormat);
        addFormat("###\\-####;\\(###\\)\\ ###\\-####", phoneFormat);
        addFormat("###-####;(###) ###-####", phoneFormat);

        Format ssnFormat = SSNFormat.instance;
        addFormat("000\\-00\\-0000", ssnFormat);
        addFormat("000-00-0000", ssnFormat);
    }

    public DataFormatter() {
        this(false);
    }

    public DataFormatter(boolean emulateCSV) {
        this(Locale.ENGLISH, true, emulateCSV);
    }

    private DataFormatter(Locale locale, boolean localeIsAdapting, boolean emulateCSV) {
        this.emulateCSV = emulateCSV;
    }

    private static DecimalFormat createIntegerOnlyFormat(String fmt) {
        DecimalFormatSymbols dsf = DecimalFormatSymbols.getInstance(Locale.ROOT);
        DecimalFormat result = new DecimalFormat(fmt, dsf);
        result.setParseIntegerOnly(true);
        return result;
    }

    public static void setExcelStyleRoundingMode(DecimalFormat format) {
        setExcelStyleRoundingMode(format, RoundingMode.HALF_UP);
    }

    public static void setExcelStyleRoundingMode(DecimalFormat format, RoundingMode roundingMode) {
        format.setRoundingMode(roundingMode);
    }

    private Format getFormat(double cellValue, int formatIndex, String formatStrIn) {
        String formatStr = formatStrIn;

        if (emulateCSV && cellValue == 0.0 && formatStr.contains("#") && !formatStr.contains("0")) {
            formatStr = formatStr.replaceAll("#", "");
        }

        Format format = formats.get(formatStr);
        if (format != null) {
            return format;
        }

        if ("General".equalsIgnoreCase(formatStr) || "@".equals(formatStr)) {
            return generalNumberFormat;
        }

        format = createFormat(cellValue, formatIndex, formatStr);
        formats.put(formatStr, format);
        return format;
    }

    private Format createFormat(double cellValue, int formatIndex, String sFormat) {

        String formatStr = sFormat;

        Matcher colourM = colorPattern.matcher(formatStr);
        while (colourM.find()) {
            String colour = colourM.group();

            int at = formatStr.indexOf(colour);
            if (at == -1) break;
            String nFormatStr = formatStr.substring(0, at) +
                    formatStr.substring(at + colour.length());
            if (nFormatStr.equals(formatStr)) break;

            formatStr = nFormatStr;
            colourM = colorPattern.matcher(formatStr);
        }

        Matcher m = localePatternGroup.matcher(formatStr);
        while (m.find()) {
            String match = m.group();
            String symbol = match.substring(match.indexOf('$') + 1, match.indexOf('-'));
            if (symbol.indexOf('$') > -1) {
                symbol = symbol.substring(0, symbol.indexOf('$')) +
                        '\\' +
                        symbol.substring(symbol.indexOf('$'), symbol.length());
            }
            formatStr = m.replaceAll(symbol);
            m = localePatternGroup.matcher(formatStr);
        }

        if (formatStr == null || formatStr.trim().length() == 0) {
            return getDefaultFormat(cellValue);
        }

        if ("General".equalsIgnoreCase(formatStr) || "@".equals(formatStr)) {
            return generalNumberFormat;
        }

        if (DateUtil.isADateFormat(formatIndex, formatStr) &&
                DateUtil.isValidExcelDate(cellValue)) {
            return createDateFormat(formatStr, cellValue);
        }

        if (formatStr.contains("#/") || formatStr.contains("?/")) {
            String[] chunks = formatStr.split(";");
            for (String chunk1 : chunks) {
                String chunk = chunk1.replaceAll("\\?", "#");
                Matcher matcher = fractionStripper.matcher(chunk);
                chunk = matcher.replaceAll(" ");
                chunk = chunk.replaceAll(" +", " ");
                Matcher fractionMatcher = fractionPattern.matcher(chunk);
                if (fractionMatcher.find()) {
                    String wholePart = (fractionMatcher.group(1) == null) ? "" : defaultFractionWholePartFormat;
                    return new FractionFormat(wholePart, fractionMatcher.group(3));
                }
            }

            return new FractionFormat(defaultFractionWholePartFormat, defaultFractionFractionPartFormat);
        }

        if (numPattern.matcher(formatStr).find()) {
            return createNumberFormat(formatStr, cellValue);
        }

        if (emulateCSV) {
            return new ConstantStringFormat(cleanFormatForNumber(formatStr));
        }
        return null;
    }

    private Format createDateFormat(String pFormatStr, double cellValue) {
        String formatStr = pFormatStr;
        formatStr = formatStr.replaceAll("\\\\-", "-");
        formatStr = formatStr.replaceAll("\\\\,", ",");
        formatStr = formatStr.replaceAll("\\\\\\.", ".");
        formatStr = formatStr.replaceAll("\\\\ ", " ");
        formatStr = formatStr.replaceAll("\\\\/", "/");
        formatStr = formatStr.replaceAll(";@", "");
        formatStr = formatStr.replaceAll("\"/\"", "/");
        formatStr = formatStr.replace("\"\"", "'");
        formatStr = formatStr.replaceAll("\\\\T", "'T'");


        boolean hasAmPm = false;
        Matcher amPmMatcher = amPmPattern.matcher(formatStr);
        while (amPmMatcher.find()) {
            formatStr = amPmMatcher.replaceAll("@");
            hasAmPm = true;
            amPmMatcher = amPmPattern.matcher(formatStr);
        }
        formatStr = formatStr.replaceAll("@", "a");


        Matcher dateMatcher = daysAsText.matcher(formatStr);
        if (dateMatcher.find()) {
            String match = dateMatcher.group(0).toUpperCase(Locale.ROOT).replaceAll("D", "E");
            formatStr = dateMatcher.replaceAll(match);
        }

        StringBuilder sb = new StringBuilder();
        char[] chars = formatStr.toCharArray();
        boolean mIsMonth = true;
        List<Integer> ms = new ArrayList<>();
        boolean isElapsed = false;
        for (int j = 0; j < chars.length; j++) {
            char c = chars[j];
            if (c == '\'') {
                sb.append(c);
                j++;

                while (j < chars.length) {
                    c = chars[j];
                    sb.append(c);
                    if (c == '\'') {
                        break;
                    }
                    j++;
                }
            } else if (c == '[' && !isElapsed) {
                isElapsed = true;
                mIsMonth = false;
                sb.append(c);
            } else if (c == ']' && isElapsed) {
                isElapsed = false;
                sb.append(c);
            } else if (isElapsed) {
                if (c == 'h' || c == 'H') {
                    sb.append('H');
                } else if (c == 'm' || c == 'M') {
                    sb.append('m');
                } else if (c == 's' || c == 'S') {
                    sb.append('s');
                } else {
                    sb.append(c);
                }
            } else if (c == 'h' || c == 'H') {
                mIsMonth = false;
                if (hasAmPm) {
                    sb.append('h');
                } else {
                    sb.append('H');
                }
            } else if (c == 'm' || c == 'M') {
                if (mIsMonth) {
                    sb.append('M');
                    ms.add(sb.length() - 1);
                } else {
                    sb.append('m');
                }
            } else if (c == 's' || c == 'S') {
                sb.append('s');
                for (int index : ms) {
                    if (sb.charAt(index) == 'M') {
                        sb.replace(index, index + 1, "m");
                    }
                }
                mIsMonth = true;
                ms.clear();
            } else if (Character.isLetter(c)) {
                mIsMonth = true;
                ms.clear();
                if (c == 'y' || c == 'Y') {
                    sb.append('y');
                } else if (c == 'd' || c == 'D') {
                    sb.append('d');
                } else {
                    sb.append(c);
                }
            } else {
                if (Character.isWhitespace(c)) {
                    ms.clear();
                }
                sb.append(c);
            }
        }
        formatStr = sb.toString();

        try {
            return new ExcelStyleDateFormatter(formatStr, dateSymbols);
        } catch (IllegalArgumentException iae) {
            return getDefaultFormat(cellValue);
        }
    }

    private String cleanFormatForNumber(String formatStr) {
        StringBuilder sb = new StringBuilder(formatStr);

        if (emulateCSV) {
            for (int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                if (c == '_' || c == '*' || c == '?') {
                    if (i > 0 && sb.charAt((i - 1)) == '\\') {
                        continue;
                    }
                    if (c == '?') {
                        sb.setCharAt(i, ' ');
                    } else if (i < sb.length() - 1) {
                        if (c == '_') {
                            sb.setCharAt(i + 1, ' ');
                        } else {
                            sb.deleteCharAt(i + 1);
                        }
                        sb.deleteCharAt(i);
                        i--;
                    }
                }
            }
        } else {
            for (int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                if (c == '_' || c == '*') {
                    if (i > 0 && sb.charAt((i - 1)) == '\\') {
                        continue;
                    }
                    if (i < sb.length() - 1) {
                        sb.deleteCharAt(i + 1);
                    }
                    sb.deleteCharAt(i);
                    i--;
                }
            }
        }

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '\\' || c == '"') {
                sb.deleteCharAt(i);
                i--;

            } else if (c == '+' && i > 0 && sb.charAt(i - 1) == 'E') {
                sb.deleteCharAt(i);
                i--;
            }
        }

        return sb.toString();
    }

    private Format createNumberFormat(String formatStr, double cellValue) {
        String format = cleanFormatForNumber(formatStr);
        DecimalFormatSymbols symbols = decimalSymbols;

        Matcher agm = alternateGrouping.matcher(format);
        if (agm.find()) {
            char grouping = agm.group(2).charAt(0);
            if (grouping != ',') {
                symbols = DecimalFormatSymbols.getInstance(Locale.ENGLISH);

                symbols.setGroupingSeparator(grouping);
                String oldPart = agm.group(1);
                String newPart = oldPart.replace(grouping, ',');
                format = format.replace(oldPart, newPart);
            }
        }

        try {
            return new InternalDecimalFormatWithScale(format, symbols);
        } catch (IllegalArgumentException iae) {
            return getDefaultFormat(cellValue);
        }
    }

    private Format getDefaultFormat(double cellValue) {
        if (defaultNumFormat != null) {
            return defaultNumFormat;
        }
        return generalNumberFormat;
    }

    private String performDateFormatting(Date d, Format dateFormat) {
        return (dateFormat != null ? dateFormat : defaultDateformat).format(d);
    }

    public String getFormattedDateString(Date date, String formatString) {
        return performDateFormatting(date, new ExcelStyleDateFormatter(formatString, dateSymbols));
    }

    public String formatRawCellContents(double value, int formatIndex, String formatString) {
        return formatRawCellContents(value, formatIndex, formatString, false);
    }

    public String formatRawCellContents(double value, int formatIndex, String formatString, boolean use1904Windowing) {
        if (DateUtil.isADateFormat(formatIndex, formatString)) {
            if (DateUtil.isValidExcelDate(value)) {
                Format dateFormat = getFormat(value, formatIndex, formatString);
                if (dateFormat instanceof ExcelStyleDateFormatter) {
                    ((ExcelStyleDateFormatter) dateFormat).setDateToBeFormatted(value);
                }
                Date d = DateUtil.getJavaDate(value, use1904Windowing);
                return performDateFormatting(d, dateFormat);
            }
            if (emulateCSV) {
                return invalidDateTimeString;
            }
        }

        Format numberFormat = getFormat(value, formatIndex, formatString);
        if (numberFormat == null) {
            return String.valueOf(value);
        }

        String result;
        final String textValue = NumberToTextConverter.toText(value);
        if (textValue.indexOf('E') > -1) {
            result = numberFormat.format(Double.valueOf(value));
        } else {
            result = numberFormat.format(new BigDecimal(textValue));
        }

        if (result.indexOf('E') > -1 && !result.contains("E-")) {
            result = result.replaceFirst("E", "E+");
        }
        return result;
    }

    public void addFormat(String excelFormatStr, Format format) {
        formats.put(excelFormatStr, format);
    }

    private static class InternalDecimalFormatWithScale extends Format {

        private static final Pattern endsWithCommas = Pattern.compile("(,+)$");
        private static final BigDecimal ONE_THOUSAND = new BigDecimal(1000);
        private final DecimalFormat df;
        private BigDecimal divider;

        public InternalDecimalFormatWithScale(String pattern, DecimalFormatSymbols symbols) {
            df = new DecimalFormat(trimTrailingCommas(pattern), symbols);
            setExcelStyleRoundingMode(df);
            Matcher endsWithCommasMatcher = endsWithCommas.matcher(pattern);
            if (endsWithCommasMatcher.find()) {
                String commas = (endsWithCommasMatcher.group(1));
                BigDecimal temp = BigDecimal.ONE;
                for (int i = 0; i < commas.length(); ++i) {
                    temp = temp.multiply(ONE_THOUSAND);
                }
                divider = temp;
            } else {
                divider = null;
            }
        }

        private static String trimTrailingCommas(String s) {
            return s.replaceAll(",+$", "");
        }

        private Object scaleInput(Object obj) {
            if (divider != null) {
                if (obj instanceof BigDecimal) {
                    obj = ((BigDecimal) obj).divide(divider, RoundingMode.HALF_UP);
                } else if (obj instanceof Double) {
                    obj = (Double) obj / divider.doubleValue();
                } else {
                    throw new UnsupportedOperationException();
                }
            }
            return obj;
        }

        @Override
        public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
            obj = scaleInput(obj);
            return df.format(obj, toAppendTo, pos);
        }

        @Override
        public Object parseObject(String source, ParsePosition pos) {
            throw new UnsupportedOperationException();
        }
    }

    @SuppressWarnings("serial")
    private static final class SSNFormat extends Format {
        public static final Format instance = new SSNFormat();
        private static final DecimalFormat df = createIntegerOnlyFormat("000000000");

        private SSNFormat() {
            // default constructor
        }

        public static String format(Number num) {
            String result = df.format(num);
            return result.substring(0, 3) + '-' +
                    result.substring(3, 5) + '-' +
                    result.substring(5, 9);
        }

        @Override
        public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
            return toAppendTo.append(format((Number) obj));
        }

        @Override
        public Object parseObject(String source, ParsePosition pos) {
            return df.parseObject(source, pos);
        }
    }

    @SuppressWarnings("serial")
    private static final class ZipPlusFourFormat extends Format {

        public static final Format instance = new ZipPlusFourFormat();
        private static final DecimalFormat df = createIntegerOnlyFormat("000000000");

        private ZipPlusFourFormat() {
            // default constructor
        }

        public static String format(Number num) {
            String result = df.format(num);
            return result.substring(0, 5) + '-' +
                    result.substring(5, 9);
        }

        @Override
        public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
            return toAppendTo.append(format((Number) obj));
        }

        @Override
        public Object parseObject(String source, ParsePosition pos) {
            return df.parseObject(source, pos);
        }
    }

    @SuppressWarnings("serial")
    private static final class PhoneFormat extends Format {

        public static final Format instance = new PhoneFormat();
        private static final DecimalFormat df = createIntegerOnlyFormat("##########");

        private PhoneFormat() {
            // default constructor
        }

        public static String format(Number num) {
            String result = df.format(num);
            StringBuilder sb = new StringBuilder();
            String seg1, seg2, seg3;
            int len = result.length();
            if (len <= 4) {
                return result;
            }

            seg3 = result.substring(len - 4, len);
            seg2 = result.substring(Math.max(0, len - 7), len - 4);
            seg1 = result.substring(Math.max(0, len - 10), Math.max(0, len - 7));

            if (seg1.trim().length() > 0) {
                sb.append('(').append(seg1).append(") ");
            }
            if (seg2.trim().length() > 0) {
                sb.append(seg2).append('-');
            }
            sb.append(seg3);
            return sb.toString();
        }

        @Override
        public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
            return toAppendTo.append(format((Number) obj));
        }

        @Override
        public Object parseObject(String source, ParsePosition pos) {
            return df.parseObject(source, pos);
        }
    }

    @SuppressWarnings("serial")
    private static final class ConstantStringFormat extends Format {

        private static final DecimalFormat df = createIntegerOnlyFormat("##########");
        private final String str;

        public ConstantStringFormat(String s) {
            str = s;
        }

        @Override
        public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
            return toAppendTo.append(str);
        }

        @Override
        public Object parseObject(String source, ParsePosition pos) {
            return df.parseObject(source, pos);
        }
    }
}
