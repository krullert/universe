package io.onsense.universe.format;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Pattern;

/**
 * @author Koen Rooijmans
 */
public class DateUtil {

    public static final int SECONDS_PER_MINUTE = 60;
    public static final int MINUTES_PER_HOUR = 60;
    public static final int HOURS_PER_DAY = 24;
    public static final int SECONDS_PER_DAY = (HOURS_PER_DAY * MINUTES_PER_HOUR * SECONDS_PER_MINUTE);
    public static final long DAY_MILLISECONDS = SECONDS_PER_DAY * 1000L;
    private static final Pattern date_ptrn1 = Pattern.compile("^\\[\\$\\-.*?\\]");
    private static final Pattern date_ptrn2 = Pattern.compile("^\\[[a-zA-Z]+\\]");
    private static final Pattern date_ptrn3a = Pattern.compile("[yYmMdDhHsS]");
    private static final Pattern date_ptrn3b = Pattern.compile("^[\\[\\]yYmMdDhHsS\\-T/\u5e74\u6708\u65e5,. :\"\\\\]+0*[ampAMP/]*$");
    private static final Pattern date_ptrn4 = Pattern.compile("^\\[([hH]+|[mM]+|[sS]+)\\]");
    private static final Pattern date_ptrn5 = Pattern.compile("^\\[DBNum(1|2|3)\\]");
    private static ThreadLocal<Integer> lastFormatIndex = new ThreadLocal<Integer>() {
        protected Integer initialValue() {
            return -1;
        }
    };
    private static ThreadLocal<String> lastFormatString = new ThreadLocal<>();
    private static ThreadLocal<Boolean> lastCachedResult = new ThreadLocal<>();

    protected DateUtil() {
        // default constructor
    }

    public static Date getJavaDate(double date, boolean use1904windowing, TimeZone tz, boolean roundSeconds) {
        Calendar calendar = getJavaCalendar(date, use1904windowing, tz, roundSeconds);
        return calendar == null ? null : calendar.getTime();
    }

    public static Date getJavaDate(double date, boolean use1904windowing) {
        return getJavaDate(date, use1904windowing, null, false);
    }

    public static void setCalendar(Calendar calendar, int wholeDays,
                                   int millisecondsInDay, boolean use1904windowing, boolean roundSeconds) {
        int startYear = 1900;
        int dayAdjust = -1;
        if (use1904windowing) {
            startYear = 1904;
            dayAdjust = 1;
        } else if (wholeDays < 61) {
            dayAdjust = 0;
        }
        calendar.set(startYear, 0, wholeDays + dayAdjust, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, millisecondsInDay);
        if (calendar.get(Calendar.MILLISECOND) == 0) {
            calendar.clear(Calendar.MILLISECOND);
        }
        if (roundSeconds) {
            calendar.add(Calendar.MILLISECOND, 500);
            calendar.clear(Calendar.MILLISECOND);
        }
    }

    public static Calendar getJavaCalendar(double date, boolean use1904windowing, TimeZone timeZone, boolean roundSeconds) {
        if (!isValidExcelDate(date)) {
            return null;
        }
        int wholeDays = (int) Math.floor(date);
        int millisecondsInDay = (int) ((date - wholeDays) * DAY_MILLISECONDS + 0.5);
        Calendar calendar;
        if (timeZone != null) {
            calendar = LocaleUtil.getLocaleCalendar(timeZone);
        } else {
            calendar = LocaleUtil.getLocaleCalendar(); // using default time-zone
        }
        setCalendar(calendar, wholeDays, millisecondsInDay, use1904windowing, roundSeconds);
        return calendar;
    }

    private static boolean isCached(String formatString, int formatIndex) {
        String cachedFormatString = lastFormatString.get();
        return cachedFormatString != null
                && formatIndex == lastFormatIndex.get()
                && formatString.equals(cachedFormatString);
    }

    private static void cache(String formatString, int formatIndex, boolean cached) {
        lastFormatIndex.set(formatIndex);
        lastFormatString.set(formatString);
        lastCachedResult.set(Boolean.valueOf(cached));
    }

    public static boolean isADateFormat(int formatIndex, String formatString) {

        if (isInternalDateFormat(formatIndex)) {
            cache(formatString, formatIndex, true);
            return true;
        }

        if (formatString == null || formatString.length() == 0) {
            return false;
        }

        if (isCached(formatString, formatIndex)) {
            return lastCachedResult.get();
        }

        String fs = formatString;
        final int length = fs.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char c = fs.charAt(i);
            if (i < length - 1) {
                char nc = fs.charAt(i + 1);
                if (c == '\\') {
                    switch (nc) {
                        case '-':
                        case ',':
                        case '.':
                        case ' ':
                        case '\\':
                            continue;
                    }
                } else if (c == ';' && nc == '@') {
                    i++;
                    continue;
                }
            }
            sb.append(c);
        }
        fs = sb.toString();

        if (date_ptrn4.matcher(fs).matches()) {
            cache(formatString, formatIndex, true);
            return true;
        }
        fs = date_ptrn5.matcher(fs).replaceAll("");
        fs = date_ptrn1.matcher(fs).replaceAll("");
        fs = date_ptrn2.matcher(fs).replaceAll("");
        final int separatorIndex = fs.indexOf(';');
        if (0 < separatorIndex && separatorIndex < fs.length() - 1) {
            fs = fs.substring(0, separatorIndex);
        }

        if (!date_ptrn3a.matcher(fs).find()) {
            return false;
        }

        boolean result = date_ptrn3b.matcher(fs).matches();
        cache(formatString, formatIndex, result);
        return result;
    }

    public static boolean isInternalDateFormat(int format) {
        switch (format) {
            case 0x0e:
            case 0x0f:
            case 0x10:
            case 0x11:
            case 0x12:
            case 0x13:
            case 0x14:
            case 0x15:
            case 0x16:
            case 0x2d:
            case 0x2e:
            case 0x2f:
                return true;
        }
        return false;
    }

    public static boolean isValidExcelDate(double value) {
        return (value > -Double.MIN_VALUE);
    }
}
