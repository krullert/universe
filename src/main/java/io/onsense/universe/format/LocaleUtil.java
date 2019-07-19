package io.onsense.universe.format;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author Koen Rooijmans
 */
public class LocaleUtil {

    private static final ThreadLocal<TimeZone> userTimeZone = new ThreadLocal<>();
    private static final ThreadLocal<Locale> userLocale = new ThreadLocal<>();

    private LocaleUtil() {
        // default constructor
    }

    public static TimeZone getUserTimeZone() {
        TimeZone timeZone = userTimeZone.get();
        return (timeZone != null) ? timeZone : TimeZone.getDefault();
    }

    public static Locale getUserLocale() {
        Locale locale = userLocale.get();
        return (locale != null) ? locale : Locale.getDefault();
    }

    public static Calendar getLocaleCalendar() {
        return getLocaleCalendar(getUserTimeZone());
    }

    public static Calendar getLocaleCalendar(TimeZone timeZone) {
        return Calendar.getInstance(timeZone, getUserLocale());
    }
}
