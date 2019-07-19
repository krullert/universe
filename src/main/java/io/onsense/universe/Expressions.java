package io.onsense.universe;

import io.onsense.universe.format.DataFormatter;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.CRC32;

/**
 * @author Koen Rooijmans
 */
public class Expressions {

    protected static final DataFormatter formatter = new DataFormatter();

    public static ExpressionString concat(CharSequence a, CharSequence b) {
        if (a == null && b == null) {
            return ExpressionString.EMPTY;
        }
        if (a != null && a.length() > Short.MAX_VALUE) {
            throw new UniversalException(a, "a", 0, UniversalException.ErrorType.VALUE);
        }
        if (b != null && b.length() > Short.MAX_VALUE) {
            throw new UniversalException(b, "b", 1, UniversalException.ErrorType.VALUE);
        }
        if (a == null) {
            return ExpressionString.valueOf(b);
        }
        if (b == null) {
            return ExpressionString.valueOf(a);
        }
        return ExpressionString.valueOf(a.toString() + b.toString());
    }

    public static FormulaDecimal concat(Number a, Number b) {
        if (a == null && b == null) {
            return FormulaDecimal.ZERO;
        }
        if (a == null) {
            return Formulas.valueOf(b);
        }
        if (b == null) {
            return Formulas.valueOf(a);
        }
        return Formulas.valueOf(Formulas.valueOf(a).toString() + Formulas.valueOf(b).toString());
    }

    public static ExpressionString concat(CharSequence value, CharSequence... values) {
        return concatenate(value, values);
    }

    public static ExpressionString concat(Number value, CharSequence... values) {
        return concatenate(value, values);
    }

    public static ExpressionString concat(Number value, String... values) {
        return concatenate(value, values);
    }

    public static ExpressionString concat(CharSequence value, Number... values) {
        return concatenate(value, values);
    }

    public static ExpressionString concat(String value, Number... values) {
        return concatenate(value, values);
    }

    public static ExpressionString concat(Number value, Number... values) {
        return concatenate(value, values);
    }

    public static ExpressionString concat(Logical value, Logical... values) {
        return concatenate(value, values);
    }

    public static ExpressionString concat(Logical value, Number... values) {
        return concatenate(value, values);
    }

    public static ExpressionString concat(Logical value, CharSequence... values) {
        return concatenate(value, values);
    }

    public static ExpressionString concat(Logical value, String... values) {
        return concatenate(value, values);
    }

    public static ExpressionString concat(CharSequence value, Logical... values) {
        return concatenate(value, values);
    }

    public static ExpressionString concat(String value, Logical... values) {
        return concatenate(value, values);
    }

    public static ExpressionString concat(Number value, Logical... values) {
        return concatenate(value, values);
    }

    public static ExpressionString lower(CharSequence value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return toLowerCase(value);
    }

    public static ExpressionString toLowerCase(CharSequence value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(value).toLowerCase(Locale.ENGLISH);
    }

    public static ExpressionString upper(CharSequence value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return toUpperCase(value);
    }

    public static ExpressionString toUpperCase(CharSequence value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(value).toUpperCase(Locale.ENGLISH);
    }

    public static ExpressionString chop(CharSequence value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return new ExpressionString(StringUtils.chop(ExpressionString.valueOf(value).toString()));
    }

    public static ExpressionString charr(CharSequence value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return charr(Formulas.valueOf(value));
    }

    public static ExpressionString charr(Number value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        return ExpressionString.valueOf(String.valueOf((char) Formulas.valueOf(value).intValue()));
    }

    public static FormulaDecimal code(CharSequence value) {
        if (value == null) {
            return FormulaDecimal.ZERO;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return Formulas.valueOf((int) (((Character) ExpressionString.valueOf(value).charAt(0)).charValue()));
    }

    public static ExpressionString clean(CharSequence value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        final StringBuilder result = new StringBuilder();
        for (final char c : ExpressionString.valueOf(value).toString().toCharArray()) {
            if (isPrintable(c)) {
                result.append(c);
            }
        }
        return ExpressionString.valueOf(result.toString());
    }

    public static ExpressionString concatenate(CharSequence value, CharSequence... values) {
        if (value != null && value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(value == null ? "" : String.valueOf(value) + (values == null ? "" : Arrays.stream(values)
                .filter(java.util.Objects::nonNull)
                .map(CharSequence::toString)
                .collect(Collectors.joining())));
    }

    public static ExpressionString concatenate(CharSequence value, String... values) {
        if (value != null && value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(value == null ? "" : String.valueOf(value) + (values == null ? "" : Arrays.stream(values)
                .filter(java.util.Objects::nonNull)
                .map(CharSequence::toString)
                .collect(Collectors.joining())));
    }

    public static ExpressionString concatenate(String value, String... values) {
        if (value != null && value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(value == null ? "" : String.valueOf(value) + (values == null ? "" : Arrays.stream(values)
                .filter(java.util.Objects::nonNull)
                .map(CharSequence::toString)
                .collect(Collectors.joining())));
    }

    public static ExpressionString concatenate(Number value, CharSequence... values) {
        return ExpressionString.valueOf(value == null ? "" : String.valueOf(value) + (values == null ? "" : Arrays.stream(values)
                .filter(java.util.Objects::nonNull)
                .map(CharSequence::toString)
                .collect(Collectors.joining())));
    }

    public static ExpressionString concatenate(Number value, String... values) {
        return ExpressionString.valueOf(value == null ? "" : String.valueOf(value) + (values == null ? "" : Arrays.stream(values)
                .filter(java.util.Objects::nonNull)
                .map(CharSequence::toString)
                .collect(Collectors.joining())));
    }

    public static ExpressionString concatenate(CharSequence value, Number... values) {
        if (value != null && value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(value == null ? "" : value + (values == null ? "" : Arrays.stream(values)
                .filter(java.util.Objects::nonNull)
                .map(number -> String.valueOf(value))
                .collect(Collectors.joining())));
    }

    public static ExpressionString concatenate(String value, Number... values) {
        if (value != null && value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(value == null ? "" : value + (values == null ? "" : Arrays.stream(values)
                .filter(java.util.Objects::nonNull)
                .map(number -> String.valueOf(value))
                .collect(Collectors.joining())));
    }

    public static ExpressionString concatenate(Number value, Number... values) {
        return ExpressionString.valueOf(value == null ? "" : String.valueOf(value) + (values == null ? "" : Arrays.stream(values)
                .filter(java.util.Objects::nonNull)
                .map(String::valueOf)
                .collect(Collectors.joining())));
    }

    public static ExpressionString concatenate(Logical value, Logical... values) {
        return ExpressionString.valueOf(value == null ? "" : String.valueOf(value).toUpperCase(Locale.ENGLISH) + (values == null ? "" : Arrays.stream(values)
                .filter(java.util.Objects::nonNull)
                .map(logical -> String.valueOf(logical).toUpperCase(Locale.ENGLISH))
                .collect(Collectors.joining())));
    }

    public static ExpressionString concatenate(Logical value, Number... values) {
        return ExpressionString.valueOf(value == null ? "" : String.valueOf(value).toUpperCase(Locale.ENGLISH) + (values == null ? "" : Arrays.stream(values)
                .filter(java.util.Objects::nonNull)
                .map(String::valueOf)
                .collect(Collectors.joining())));
    }

    public static ExpressionString concatenate(Logical value, CharSequence... values) {
        return ExpressionString.valueOf(value == null ? "" : String.valueOf(value).toUpperCase(Locale.ENGLISH) + (values == null ? "" : Arrays.stream(values)
                .filter(java.util.Objects::nonNull)
                .map(CharSequence::toString)
                .collect(Collectors.joining())));
    }

    public static ExpressionString concatenate(Logical value, String... values) {
        return ExpressionString.valueOf(value == null ? "" : String.valueOf(value).toUpperCase(Locale.ENGLISH) + (values == null ? "" : Arrays.stream(values)
                .filter(java.util.Objects::nonNull)
                .map(CharSequence::toString)
                .collect(Collectors.joining())));
    }

    public static ExpressionString concatenate(CharSequence value, Logical... values) {
        if (value != null && value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(value == null ? "" : String.valueOf(value) + (values == null ? "" : Arrays.stream(values)
                .filter(java.util.Objects::nonNull)
                .map(logical -> String.valueOf(logical).toUpperCase(Locale.ENGLISH))
                .collect(Collectors.joining())));
    }

    public static ExpressionString concatenate(String value, Logical... values) {
        if (value != null && value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(value == null ? "" : String.valueOf(value) + (values == null ? "" : Arrays.stream(values)
                .filter(java.util.Objects::nonNull)
                .map(logical -> String.valueOf(logical).toUpperCase(Locale.ENGLISH))
                .collect(Collectors.joining())));
    }

    public static ExpressionString concatenate(Number value, Logical... values) {
        return ExpressionString.valueOf(value == null ? "" : String.valueOf(value) + (values == null ? "" : Arrays.stream(values)
                .filter(java.util.Objects::nonNull)
                .map(logical -> String.valueOf(logical).toUpperCase(Locale.ENGLISH))
                .collect(Collectors.joining())));
    }

    public static ExpressionString dollar(Number value) {
        return dollar(value, 2);
    }

    public static ExpressionString dollar(Number value, Number decimals) {
        final DecimalFormat decimalFormat;
        if (Formulas.valueOf(decimals).intValue() < 0) {
            final ExpressionString intValue = ExpressionString.valueOf(Formulas.valueOf(value).intValue());
            final int dec = Math.abs(Formulas.valueOf(decimals).intValue());
            final Integer i = Integer.valueOf(intValue.substring(0, intValue.length() - dec).add(repeat("0", dec)).toString());
            return dollar(i, 0);
        } else if (Formulas.valueOf(decimals).intValue() == 0) {
            decimalFormat = new DecimalFormat("#,##0");
        } else {
            decimalFormat = new DecimalFormat("#,##0." + repeat("0", Formulas.valueOf(decimals).intValue()));
        }
        return ExpressionString.valueOf("$" + decimalFormat.format(value == null ? 0 : value));
    }

    public static Logical exact(CharSequence a, CharSequence b) {
        if (a != null && a.length() > Short.MAX_VALUE) {
            throw new UniversalException(a, "a", 0, UniversalException.ErrorType.VALUE);
        }
        if (b != null && b.length() > Short.MAX_VALUE) {
            throw new UniversalException(b, "b", 1, UniversalException.ErrorType.VALUE);
        }
        return Logical.valueOf(Objects.equals(a, b));
    }

    public static FormulaDecimal find(CharSequence findText, CharSequence withinText) {
        return find(findText, withinText, 0);
    }

    public static FormulaDecimal find(CharSequence findText, CharSequence withinText, Number startNum) {
        if (startNum == null) {
            throw new UniversalException("startNum", 1, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(startNum).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("startNum", 1, UniversalException.ErrorType.VALUE);
        }
        if (findText != null && findText.length() > Short.MAX_VALUE) {
            throw new UniversalException(findText, "findText", 0, UniversalException.ErrorType.VALUE);
        }
        if (withinText != null && withinText.length() > Short.MAX_VALUE) {
            throw new UniversalException(findText, "withinText", 1, UniversalException.ErrorType.VALUE);
        }
        return Formulas.valueOf(ExpressionString.valueOf(withinText).toString().indexOf(ExpressionString.valueOf(findText).toString(), Formulas.valueOf(startNum).intValue()) + 1);
    }

    public static ExpressionString fixed(Number value) {
        return fixed(value, 2);
    }

    public static ExpressionString fixed(Number value, Number decimals) {
        return fixed(value, decimals, Logical.FALSE);
    }

    public static ExpressionString fixed(Number value, Number decimals, Boolean noCommas) {
        return fixed(value, decimals, Logical.valueOf(noCommas));
    }

    public static ExpressionString fixed(Number value, Number decimals, Logical noCommas) {
        final DecimalFormat decimalFormat;
        if (Formulas.valueOf(decimals).intValue() < 0) {
            final ExpressionString intValue = ExpressionString.valueOf(Formulas.valueOf(value).intValue());
            final int dec = Math.abs(Formulas.valueOf(decimals).intValue());
            final Integer i = Integer.valueOf(intValue.substring(0, intValue.length() - dec).add(repeat("0", dec)).toString());
            return fixed(i, 0, noCommas);
        } else if (Formulas.valueOf(decimals).intValue() == 0) {
            if (Logical.valueOf(noCommas).booleanValue()) {
                decimalFormat = new DecimalFormat("##0");
            } else {
                decimalFormat = new DecimalFormat("#,##0");
            }
        } else {
            if (Logical.valueOf(noCommas).booleanValue()) {
                decimalFormat = new DecimalFormat("##0." + repeat("0", Formulas.valueOf(decimals).intValue()));
            } else {
                decimalFormat = new DecimalFormat("#,##0." + repeat("0", Formulas.valueOf(decimals).intValue()));
            }
        }
        return ExpressionString.valueOf(decimalFormat.format(value == null ? 0 : value));
    }


    public static ExpressionString left(CharSequence value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return left(value, 1);
    }

    public static ExpressionString left(CharSequence value, Number numChars) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (Formulas.valueOf(numChars).compareTo(BigDecimal.ZERO) <= 0) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(ExpressionString.valueOf(value).subSequence(0, Formulas.valueOf(numChars).intValue()));
    }

    public static ExpressionString right(CharSequence value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return right(value, 1);
    }

    public static ExpressionString right(CharSequence value, Number numChars) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (Formulas.valueOf(numChars).compareTo(BigDecimal.ZERO) <= 0) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(ExpressionString.valueOf(value).subSequence(ExpressionString.valueOf(value).length() - Formulas.valueOf(numChars).intValue(), ExpressionString.valueOf(value).length()));
    }

    public static FormulaDecimal len(CharSequence value) {
        if (value == null || value.length() == 0) {
            return FormulaDecimal.ZERO;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return Formulas.valueOf(ExpressionString.valueOf(value).length());
    }

    public static FormulaDecimal len(Number value, Number... values) {
        if (value == null && (values == null || values.length == 0)) {
            return FormulaDecimal.ZERO;
        }
        return Formulas.valueOf(1 + (values == null ? 0 : values.length));
    }

    public static ExpressionString mid(CharSequence value, Number startNum, Number numChars) {
        if (startNum == null) {
            throw new UniversalException("startNum", 1, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(startNum).compareTo(BigDecimal.ONE) < 0) {
            throw new UniversalException("startNum", 1, UniversalException.ErrorType.VALUE);
        }
        if (numChars == null) {
            throw new UniversalException("numChars", 2, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(numChars).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("numChars", 2, UniversalException.ErrorType.VALUE);
        }
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        if (Formulas.valueOf(startNum).compareTo(Formulas.valueOf(ExpressionString.valueOf(value).length())) > 0) {
            return ExpressionString.EMPTY;
        }
        // index 1 equals index 0 for compatibility reasons.
        return ExpressionString.valueOf(ExpressionString.valueOf(value).subSequence(Math.min(ExpressionString.valueOf(value).length(), Formulas.valueOf(startNum).intValue() - 1), Math.min(ExpressionString.valueOf(value).length(), Formulas.valueOf(numChars).intValue())));
    }

    public static FormulaDecimal numbervalue(CharSequence value) {
        if (value == null || value.length() == 0) {
            return FormulaDecimal.ZERO;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return numbervalue(value, String.valueOf(DecimalFormatSymbols.getInstance(Locale.ENGLISH).getDecimalSeparator()));
    }

    public static FormulaDecimal numbervalue(CharSequence value, CharSequence decimalSeparator) {
        if (value == null || value.length() == 0) {
            return FormulaDecimal.ZERO;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        if (decimalSeparator != null && decimalSeparator.length() > Short.MAX_VALUE) {
            throw new UniversalException(decimalSeparator, "decimalSeparator", 1, UniversalException.ErrorType.VALUE);
        }
        return numbervalue(value, decimalSeparator, String.valueOf(DecimalFormatSymbols.getInstance(Locale.ENGLISH).getGroupingSeparator()));
    }

    public static FormulaDecimal numbervalue(CharSequence value, CharSequence decimalSeparator, CharSequence groupSeparator) {
        if (value == null || value.length() == 0) {
            return FormulaDecimal.ZERO;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        if (decimalSeparator != null && decimalSeparator.length() > Short.MAX_VALUE) {
            throw new UniversalException(decimalSeparator, "decimalSeparator", 1, UniversalException.ErrorType.VALUE);
        }
        if (groupSeparator != null && groupSeparator.length() > Short.MAX_VALUE) {
            throw new UniversalException(groupSeparator, "groupSeparator", 1, UniversalException.ErrorType.VALUE);
        }
        // Converts text to a number, in a locale-independent way.
        final DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.ENGLISH);
        decimalFormatSymbols.setDecimalSeparator(decimalSeparator == null ? decimalFormatSymbols.getDecimalSeparator() : ExpressionString.valueOf(decimalSeparator).charAt(0));
        decimalFormatSymbols.setGroupingSeparator(groupSeparator == null ? decimalFormatSymbols.getGroupingSeparator() : ExpressionString.valueOf(groupSeparator).charAt(0));
        final DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
        if (trim(value).charAt(trim(value).length() - 1) == '%') {
            try {
                return Formulas.valueOf(decimalFormat.parse(value.toString())).divide(Formulas.valueOf(100));
            } catch (ParseException e) {
                return Formulas.valueOf(value).divide(Formulas.valueOf(100));
            }
        }
        try {
            return Formulas.valueOf(decimalFormat.parse(value.toString()));
        } catch (ParseException e) {
            return Formulas.valueOf(value);
        }
    }

    public static ExpressionString proper(Boolean value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        return proper(Logical.valueOf(value));
    }

    public static ExpressionString proper(Logical value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        return proper(ExpressionString.valueOf(value).toString().toUpperCase(Locale.ENGLISH));
    }

    public static ExpressionString proper(Number value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        return proper(String.valueOf(value));
    }

    public static ExpressionString proper(CharSequence value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return capitalizeFully(value);
    }

    public static FormulaDecimal search(CharSequence findText, CharSequence withinText) {
        return search(findText, withinText, 1);
    }

    public static FormulaDecimal search(CharSequence findText, CharSequence withinText, Number startNum) {
        if (Formulas.valueOf(startNum).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("startNum", 0, UniversalException.ErrorType.VALUE);
        }
        if (findText != null && findText.length() > Short.MAX_VALUE) {
            throw new UniversalException(findText, "findText", 0, UniversalException.ErrorType.VALUE);
        }
        if (withinText != null && withinText.length() > Short.MAX_VALUE) {
            throw new UniversalException(findText, "withinText", 1, UniversalException.ErrorType.VALUE);
        }
        if (withinText == null || withinText.length() == 0) {
            return FormulaDecimal.ONE.negate();
        }

//        if (Formulas.valueOf(startNum).compareTo(Formulas.valueOf(findText.length() + 1)) > 0) {
//            throw new UniversalException("startNum", 0, UniversalException.ErrorType.VALUE);
//        }

        // The SEARCH and SEARCHB functions locate one text string within a second text string,
        // and return the number of the starting position of the first text string from the first character of the second text string.
        // For example, to find the position of the letter "n" in the word "printer", you can use the following function:
        final FormulaDecimal result = Formulas.valueOf(withinText.toString().toLowerCase(Locale.ENGLISH).indexOf(ExpressionString.valueOf(findText).toString().toLowerCase(Locale.ENGLISH), Formulas.valueOf(startNum).intValue() - 1) + 1);

//        if (result.compareTo(BigDecimal.ZERO) < 0) {
//            throw new UniversalException("withinText", 1, UniversalException.ErrorType.VALUE);
//        }

        return result;
    }

    public static ExpressionString substitute(CharSequence text, CharSequence oldText, CharSequence newText) {
        if (oldText == null || oldText.length() == 0) {
            return ExpressionString.valueOf(text);
        }
        if (text != null && text.length() > Short.MAX_VALUE) {
            throw new UniversalException(text, "text", 0, UniversalException.ErrorType.VALUE);
        }
        if (oldText.length() > Short.MAX_VALUE) {
            throw new UniversalException(oldText, "oldText", 1, UniversalException.ErrorType.VALUE);
        }
        if (newText != null && newText.length() > Short.MAX_VALUE) {
            throw new UniversalException(newText, "newText", 1, UniversalException.ErrorType.VALUE);
        }

        return ExpressionString.valueOf(ExpressionString.valueOf(text).replace(oldText, newText));
    }

    public static ExpressionString substitute(CharSequence text, CharSequence oldText, CharSequence newText, Number instanceNum) {
        if (text != null && text.length() > Short.MAX_VALUE) {
            throw new UniversalException(text, "text", 0, UniversalException.ErrorType.VALUE);
        }
        if (oldText != null && oldText.length() > Short.MAX_VALUE) {
            throw new UniversalException(oldText, "oldText", 1, UniversalException.ErrorType.VALUE);
        }
        if (newText != null && newText.length() > Short.MAX_VALUE) {
            throw new UniversalException(newText, "newText", 1, UniversalException.ErrorType.VALUE);
        }

        final int indexOf = StringUtils.ordinalIndexOf(text, oldText, Formulas.valueOf(instanceNum).intValue());
        if (indexOf == -1) {
            return ExpressionString.valueOf(text);
        } else {
            return ExpressionString.valueOf(ExpressionString.valueOf(text).subSequence(0, indexOf) + ExpressionString.valueOf(newText).toString() + ExpressionString.valueOf(text).subSequence(indexOf + ExpressionString.valueOf(oldText).length(), ExpressionString.valueOf(text).length()));
        }
    }

    public static ExpressionString t(Boolean logical) {
        return t(Logical.valueOf(logical));
    }

    public static ExpressionString t(Logical logical) {
        return t("");
    }

    public static ExpressionString t(Number number) {
        return t("");
    }

    public static ExpressionString t(CharSequence text) {
        if (text == null) {
            return ExpressionString.EMPTY;
        }
        if (text.length() > Short.MAX_VALUE) {
            throw new UniversalException(text, "text", 0, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(text);
    }

    public static ExpressionString text(Boolean logical) {
        if (logical == null) {
            return ExpressionString.EMPTY;
        }
        return text(Logical.valueOf(logical));
    }

    public static ExpressionString text(Logical logical) {
        if (logical == null) {
            return ExpressionString.EMPTY;
        }
        return text(logical.toString().toUpperCase(Locale.ENGLISH));
    }

    public static ExpressionString text(Number number) {
        if (number == null) {
            return ExpressionString.EMPTY;
        }
        return text(number.toString());
    }

    public static ExpressionString text(Number number, CharSequence formatText) {
        if (number == null) {
            return ExpressionString.EMPTY;
        }
        if (formatText == null) {
            return ExpressionString.valueOf(number);
        }
        if (formatText.length() > Short.MAX_VALUE) {
            throw new UniversalException(formatText, "formatText", 0, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(formatter.formatRawCellContents(Formulas.valueOf(number).doubleValue(), -1, formatText.toString()));
    }

    public static ExpressionString text(Date date) {
        if (date == null) {
            return ExpressionString.EMPTY;
        }
        return text(date.toString());
    }

    public static ExpressionString text(Date date, CharSequence formatText) {
        if (date == null) {
            return ExpressionString.EMPTY;
        }
        if (formatText == null) {
            return ExpressionString.valueOf(date);
        }
        if (formatText.length() > Short.MAX_VALUE) {
            throw new UniversalException(formatText, "formatText", 0, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(formatter.getFormattedDateString(date, formatText.toString()));
    }

    public static ExpressionString text(CharSequence text) {
        if (text == null) {
            return ExpressionString.EMPTY;
        }
        if (text != null && text.length() > Short.MAX_VALUE) {
            throw new UniversalException(text, "text", 0, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(text);
    }

    public static ExpressionString text(CharSequence number, CharSequence formatText) {
        if (number == null) {
            return ExpressionString.EMPTY;
        }
        if (formatText == null) {
            return ExpressionString.valueOf(number);
        }
        if (number.length() > Short.MAX_VALUE) {
            throw new UniversalException(number, "number", 0, UniversalException.ErrorType.VALUE);
        }
        if (formatText.length() > Short.MAX_VALUE) {
            throw new UniversalException(formatText, "formatText", 1, UniversalException.ErrorType.VALUE);
        }
        return text(Formulas.valueOf(number.toString()), formatText);
    }

    public static ExpressionString unichar(Number number) {
        if (number == null) {
            return ExpressionString.EMPTY;
        }
        return ExpressionString.valueOf(Character.toString((char) Formulas.valueOf(number).longValue()));
    }

    public static FormulaDecimal unicode(CharSequence value) {
        if (value == null || value.length() == 0) {
            return FormulaDecimal.ZERO;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return FormulaDecimal.valueOf(((Character) value.charAt(0)).charValue());
    }

    public static FormulaDecimal value(CharSequence value) {
        if (value == null || value.length() == 0) {
            return FormulaDecimal.ZERO;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        if (value.chars().anyMatch(c -> Character.compare(':', (char) c) == 0)) {
            // TODO or date value? test this..
            return Moments.timevalue(Moments.valueOf(value));
        } else {
            return Formulas.valueOf(value.chars()
                    .filter(Character::isDigit)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString());
        }
    }

    /**
     * From Excel docs: The CLEAN function was designed to remove the first 32 nonprinting characters
     * in the 7-bit ASCII code (values 0 through 31) from text. In the Unicode character set,
     * there are additional nonprinting characters (values 127, 129, 141, 143, 144, and 157). By itself,
     * the CLEAN function does not remove these additional  nonprinting characters. To do this task,
     * use the SUBSTITUTE function to replace the higher value Unicode characters with the 7-bit ASCII
     * characters for which the TRIM and CLEAN functions were designed.
     *
     * @param c the character to test
     * @return whether the character is printable
     */
    protected static boolean isPrintable(char c) {
        return c >= 32;
    }

    public static ExpressionString trim(CharSequence value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(value).trim();
    }

    public static ExpressionString ltrim(CharSequence value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return trimLeft(value);
    }

    public static ExpressionString trimLeft(CharSequence value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        int i = 0;
        while (i < value.length() && Character.isWhitespace(value.charAt(i))) {
            i++;
        }
        return ExpressionString.valueOf(value).substring(i);
    }

    public static ExpressionString rtrim(CharSequence value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return trimRight(value);
    }

    public static ExpressionString trimRight(CharSequence value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        int i = value.length() - 1;
        while (i >= 0 && Character.isWhitespace(value.charAt(i))) {
            i--;
        }
        return ExpressionString.valueOf(value).substring(0, i + 1);
    }

    public static ExpressionString rept(CharSequence value, Number amount) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return repeat(value, amount);
    }

    public static ExpressionString repeat(CharSequence value, Number amount) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        if (value.length() * Formulas.valueOf(amount).intValue() > Short.MAX_VALUE) {
            throw new UniversalException(value, "amount", 1, UniversalException.ErrorType.VALUE);
        }
        return new ExpressionString(StringUtils.repeat(ExpressionString.valueOf(value).toString(), Formulas.valueOf(amount).intValue()));
    }

    public static ExpressionString prefix(CharSequence value, CharSequence prefix) {
        if (value == null && prefix == null) {
            return ExpressionString.EMPTY;
        }
        if (value != null && value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        if (prefix != null && prefix.length() > Short.MAX_VALUE) {
            throw new UniversalException(prefix, "prefix", 1, UniversalException.ErrorType.VALUE);
        }
        if (value == null) {
            return ExpressionString.valueOf(prefix);
        }
        if (prefix == null) {
            return ExpressionString.valueOf(value);
        }
        return new ExpressionString(StringUtils.prependIfMissing(ExpressionString.valueOf(value).toString(), prefix.toString()));
    }

    public static ExpressionString suffix(CharSequence value, CharSequence suffix) {
        if (value == null && suffix == null) {
            return ExpressionString.EMPTY;
        }
        if (value != null && value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        if (suffix != null && suffix.length() > Short.MAX_VALUE) {
            throw new UniversalException(suffix, "suffix", 1, UniversalException.ErrorType.VALUE);
        }
        if (value == null) {
            return ExpressionString.valueOf(suffix);
        }
        if (suffix == null) {
            return ExpressionString.valueOf(value);
        }
        return new ExpressionString(StringUtils.appendIfMissing(ExpressionString.valueOf(value).toString(), suffix.toString()));
    }

    public static ExpressionString capitalize(CharSequence value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return new ExpressionString(StringUtils.capitalize(ExpressionString.valueOf(value).toString()));
    }

    public static ExpressionString capitalizeFully(CharSequence value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return new ExpressionString(WordUtils.capitalizeFully(ExpressionString.valueOf(value).toString()));
    }

    public static ExpressionString capitalizeFully(CharSequence value, CharSequence delimiter) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        if (delimiter != null && delimiter.length() > Short.MAX_VALUE) {
            throw new UniversalException(delimiter, "delimiter", 1, UniversalException.ErrorType.VALUE);
        }
        return new ExpressionString(WordUtils.capitalizeFully(ExpressionString.valueOf(value).toString(), ExpressionString.valueOf(delimiter).toString().toCharArray()));
    }

    public static ExpressionString decapitalize(CharSequence value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return new ExpressionString(StringUtils.uncapitalize(ExpressionString.valueOf(value).toString()));
    }

    public static ExpressionString decapitalizeFully(CharSequence value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return new ExpressionString(WordUtils.uncapitalize(ExpressionString.valueOf(value).toString(), ' '));
    }

    public static ExpressionString decapitalizeFully(CharSequence value, CharSequence delimiter) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        if (delimiter != null && delimiter.length() > Short.MAX_VALUE) {
            throw new UniversalException(delimiter, "delimiter", 1, UniversalException.ErrorType.VALUE);
        }
        return new ExpressionString(WordUtils.uncapitalize(ExpressionString.valueOf(value).toString(), ExpressionString.valueOf(delimiter).toString().toCharArray()));
    }

    public static ExpressionString substring(CharSequence value, Number beginIndex) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(value).substring(Formulas.valueOf(beginIndex).intValue());
    }

    public static ExpressionString substring(CharSequence value, Number beginIndex, Number endIndex) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(value).substring(Formulas.valueOf(beginIndex).intValue(), Formulas.valueOf(endIndex).intValue());
    }

    public static ExpressionString remove(CharSequence value, CharSequence remove) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (remove == null) {
            return ExpressionString.valueOf(value);
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        if (remove.length() > Short.MAX_VALUE) {
            throw new UniversalException(remove, "remove", 1, UniversalException.ErrorType.VALUE);
        }
        return new ExpressionString(StringUtils.remove(ExpressionString.valueOf(value).toString(), remove.toString()));
    }

    public static ExpressionString removeFirst(CharSequence value, CharSequence remove) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (remove == null) {
            return ExpressionString.valueOf(value);
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        if (remove.length() > Short.MAX_VALUE) {
            throw new UniversalException(remove, "remove", 1, UniversalException.ErrorType.VALUE);
        }
        final int indexOf = ExpressionString.valueOf(value).indexOf(ExpressionString.valueOf(remove).toString());
        if (indexOf == -1) {
            return ExpressionString.valueOf(value);
        } else {
            return ExpressionString.valueOf(ExpressionString.valueOf(value).substring(0, indexOf).toString()
                    + ExpressionString.valueOf(ExpressionString.valueOf(value).substring(indexOf + ExpressionString.valueOf(remove).length())).toString());
        }
    }

    public static ExpressionString removeLast(CharSequence value, CharSequence remove) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (remove == null) {
            return ExpressionString.valueOf(value);
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        if (remove.length() > Short.MAX_VALUE) {
            throw new UniversalException(remove, "remove", 1, UniversalException.ErrorType.VALUE);
        }
        final int lastIndexOf = ExpressionString.valueOf(value).lastIndexOf(ExpressionString.valueOf(remove).toString());
        if (lastIndexOf == -1) {
            return ExpressionString.valueOf(value);
        } else {
            return ExpressionString.valueOf(ExpressionString.valueOf(value).substring(0, lastIndexOf).toString()
                    + ExpressionString.valueOf(ExpressionString.valueOf(value).substring(lastIndexOf + ExpressionString.valueOf(remove).length()).toString()));
        }
    }

    public static ExpressionString replace(CharSequence value, CharSequence searchString, CharSequence replacement) {
        if (searchString == null) {
            return ExpressionString.valueOf(value);
        }
        if (value == null || value.length() == 0) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        if (searchString.length() > Short.MAX_VALUE) {
            throw new UniversalException(searchString, "searchString", 1, UniversalException.ErrorType.VALUE);
        }
        if (replacement != null && replacement.length() > Short.MAX_VALUE) {
            throw new UniversalException(replacement, "replacement", 2, UniversalException.ErrorType.VALUE);
        }
        return new ExpressionString(StringUtils.replace(ExpressionString.valueOf(value).toString(), ExpressionString.valueOf(searchString).toString(), ExpressionString.valueOf(replacement).toString()));
    }

    public static ExpressionString replace(CharSequence oldText, Number startNum, Number numChars, CharSequence newText) {
        if (oldText == null) {
            return ExpressionString.EMPTY;
        }
        if (oldText.length() > Short.MAX_VALUE) {
            throw new UniversalException(oldText, "oldText", 0, UniversalException.ErrorType.VALUE);
        }
        if (newText != null && newText.length() > Short.MAX_VALUE) {
            throw new UniversalException(newText, "newText", 3, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(String.valueOf(ExpressionString.valueOf(oldText).subSequence(0, Formulas.valueOf(startNum).intValue() - 1))
                + ExpressionString.valueOf(newText)
                + String.valueOf(ExpressionString.valueOf(oldText).subSequence(Formulas.valueOf(startNum).intValue() + Formulas.valueOf(numChars).intValue() - 1, ExpressionString.valueOf(oldText).length())));
    }

    public static ExpressionString replaceFirst(CharSequence value, CharSequence searchString, CharSequence replacement) {
        if (searchString == null) {
            return ExpressionString.valueOf(value);
        }
        if (value == null || value.length() == 0) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        if (searchString.length() > Short.MAX_VALUE) {
            throw new UniversalException(searchString, "searchString", 1, UniversalException.ErrorType.VALUE);
        }
        if (replacement != null && replacement.length() > Short.MAX_VALUE) {
            throw new UniversalException(replacement, "replacement", 2, UniversalException.ErrorType.VALUE);
        }
        return new ExpressionString(StringUtils.replaceFirst(ExpressionString.valueOf(value).toString(), ExpressionString.valueOf(searchString).toString(), ExpressionString.valueOf(replacement).toString()));
    }

    public static ExpressionString replaceLast(CharSequence value, CharSequence searchString, CharSequence replacement) {
        if (searchString == null) {
            return ExpressionString.valueOf(value);
        }
        if (value == null || value.length() == 0) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        if (searchString.length() > Short.MAX_VALUE) {
            throw new UniversalException(searchString, "searchString", 1, UniversalException.ErrorType.VALUE);
        }
        if (replacement != null && replacement.length() > Short.MAX_VALUE) {
            throw new UniversalException(replacement, "replacement", 2, UniversalException.ErrorType.VALUE);
        }

        int lastIndex = ExpressionString.valueOf(value).lastIndexOf(searchString.toString());

        if (lastIndex == -1) {
            return ExpressionString.valueOf(value);
        }

        CharSequence beginString = ExpressionString.valueOf(value).substring(0, lastIndex);
        CharSequence endString = ExpressionString.valueOf(value).substring(lastIndex + ExpressionString.valueOf(searchString).length());

        return new ExpressionString(beginString.toString() + ExpressionString.valueOf(replacement).toString() + endString.toString());
    }

    public static CharSequence reverse(CharSequence value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return StringUtils.reverse(ExpressionString.valueOf(value).toString());
    }

    /**
     * Extracts the initial characters from each word in the CharSequence.
     *
     * @param value
     * @return
     */
    public static ExpressionString initials(CharSequence value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return new ExpressionString(WordUtils.initials(ExpressionString.valueOf(value).toString()));
    }

    /**
     * Extracts the initial characters from each word in the CharSequence.
     *
     * @param value
     * @param delimiter
     * @return
     */
    public static ExpressionString initials(CharSequence value, CharSequence delimiter) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        if (delimiter != null && delimiter.length() > Short.MAX_VALUE) {
            throw new UniversalException(delimiter, "delimiter", 1, UniversalException.ErrorType.VALUE);
        }
        return new ExpressionString(WordUtils.initials(ExpressionString.valueOf(value).toString(), ExpressionString.valueOf(delimiter).toString().toCharArray()));
    }

    public static ExpressionString swap(CharSequence value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return new ExpressionString(WordUtils.swapCase(ExpressionString.valueOf(value).toString()));
    }

    public static ExpressionString quote(CharSequence value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return new ExpressionString("\"" + ExpressionString.valueOf(value) + "\"");
    }

    public static ExpressionString unquote(CharSequence value) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        return new ExpressionString(Strings.removeQuotes(ExpressionString.valueOf(value).toString()));
    }

    public static ExpressionString format(CharSequence value, CharSequence format) {
        if (value == null) {
            return ExpressionString.EMPTY;
        }
        if (format == null) {
            return ExpressionString.valueOf(value);
        }
        if (value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        if (format.length() > Short.MAX_VALUE) {
            throw new UniversalException(format, "format", 1, UniversalException.ErrorType.VALUE);
        }
        try {
            return ExpressionString.format(ExpressionString.valueOf(format).toString(), value);
        } catch (IllegalArgumentException e) {
            throw new UniversalException(format, "format", 1, UniversalException.ErrorType.VALUE, e);
        }
    }

    public static ExpressionString format(Number decimal, CharSequence format) {
        if (format == null) {
            return ExpressionString.valueOf(decimal);
        }
        if (format.length() > Short.MAX_VALUE) {
            throw new UniversalException(format, "format", 1, UniversalException.ErrorType.VALUE);
        }
        try {
            return new ExpressionString(new DecimalFormat(ExpressionString.valueOf(format).toString(), DecimalFormatSymbols.getInstance(Locale.ENGLISH)).format(decimal));
        } catch (IllegalArgumentException e) {
            throw new UniversalException(format, "format", 1, UniversalException.ErrorType.VALUE, e);
        }
    }

    public static ExpressionString random(CharSequence characters, Number amount) {
        if (Formulas.valueOf(amount).compareTo(BigDecimal.ZERO) <= 0) {
            return ExpressionString.EMPTY;
        }
        if (characters == null || characters.length() == 0) {
            return ExpressionString.EMPTY;
        }
        if (characters.length() > Short.MAX_VALUE) {
            throw new UniversalException(characters, "characters", 0, UniversalException.ErrorType.VALUE);
        }
        if (Formulas.valueOf(amount).compareTo(BigDecimal.valueOf(Short.MAX_VALUE)) > 0) {
            throw new UniversalException(amount, "amount", 1, UniversalException.ErrorType.VALUE);
        }
        return new ExpressionString(RandomStringUtils.random(Formulas.valueOf(amount).intValue(), ExpressionString.valueOf(characters).toString()));
    }

    public static ExpressionString encode(CharSequence value) {
        if (value != null && value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        try {
            return new ExpressionString(URLEncoder.encode(ExpressionString.valueOf(value).toString(), StandardCharsets.UTF_8.name()));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static ExpressionString decode(CharSequence value) {
        if (value != null && value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        try {
            return new ExpressionString(URLDecoder.decode(ExpressionString.valueOf(value).toString(), StandardCharsets.UTF_8.name()));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * Decodes a charSequence of data which has been encoded using base-64 encoding.
     *
     * @param value
     * @return
     */
    public static ExpressionString atob(CharSequence value) {
        if (value != null && value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        try {
            return new ExpressionString(Base64.getDecoder().decode(ExpressionString.valueOf(value).toString()), StandardCharsets.UTF_8);
        } catch (IllegalArgumentException e) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE, e);
        }
    }

    /**
     * Creates a base-64 encoded ASCII charSequence from a "charSequence" of binary data.
     *
     * @param value
     * @return
     */
    public static ExpressionString btoa(CharSequence value) {
        if (value != null && value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        try {
            return new ExpressionString(Base64.getEncoder().encodeToString(ExpressionString.valueOf(value).getBytes(StandardCharsets.UTF_8)));
        } catch (IllegalArgumentException e) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE, e);
        }
    }

    public static ExpressionString hex(CharSequence value) {
        if (value != null && value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        try {
            return new ExpressionString(DatatypeConverter.printHexBinary(ExpressionString.valueOf(value).getBytes(StandardCharsets.UTF_8)));
        } catch (IllegalArgumentException e) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE, e);
        }
    }

    public static ExpressionString md2(CharSequence value) {
        if (value != null && value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        try {
            return new ExpressionString(DatatypeConverter.printHexBinary(MessageDigest.getInstance("MD2").digest(ExpressionString.valueOf(value).getBytes(StandardCharsets.UTF_8)))
                    .toUpperCase(Locale.ENGLISH));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static ExpressionString md5(CharSequence value) {
        if (value != null && value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        try {
            return new ExpressionString(DatatypeConverter.printHexBinary(MessageDigest.getInstance("MD5").digest(ExpressionString.valueOf(value).getBytes(StandardCharsets.UTF_8)))
                    .toUpperCase(Locale.ENGLISH));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static ExpressionString sha256(CharSequence value) {
        if (value != null && value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        try {
            return new ExpressionString(DatatypeConverter.printHexBinary(MessageDigest.getInstance("SHA-256").digest(ExpressionString.valueOf(value).getBytes(StandardCharsets.UTF_8)))
                    .toUpperCase(Locale.ENGLISH));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static ExpressionString crc32(CharSequence value) {
        if (value != null && value.length() > Short.MAX_VALUE) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE);
        }
        try {
            final CRC32 crc32 = new CRC32();
            crc32.update(ExpressionString.valueOf(value).getBytes(StandardCharsets.UTF_8));
            return ExpressionString.valueOf(crc32.getValue());
        } catch (IllegalArgumentException e) {
            throw new UniversalException(value, "value", 0, UniversalException.ErrorType.VALUE, e);
        }
    }
}
