package io.onsense.universe;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * @author Koen Rooijmans
 */
public class Moments {

    public static Moment valueOfObject(Object date) {
        if (date == null) {
            return Moment.EMPTY;
        }
        if (date instanceof CharSequence) {
            return Moments.valueOf((CharSequence) date);
        } else if (date instanceof Number) {
            return Moments.valueOf((Number) date);
        } else if (date instanceof Date) {
            return Moments.valueOf((Date) date);
        } else if (date instanceof Boolean) {
            throw new UniversalException(UniversalException.ErrorType.NUM);
        } else if (date instanceof Logical) {
            throw new UniversalException(UniversalException.ErrorType.NUM);
        } else {
            throw new UniversalException(UniversalException.ErrorType.NUM);
        }
    }

    public static Moment valueOf(CharSequence date) {
        if (date == null) {
            throw new UniversalException("date", 0, UniversalException.ErrorType.VALUE);
        }
        return Moment.valueOf(date);
    }

    public static Moment valueOf(Number date) {
        if (date == null) {
            throw new UniversalException("date", 0, UniversalException.ErrorType.VALUE);
        }
        // NOTE: magic constant based on a moment of clarity, should be tested..
        if (Formulas.valueOf(date).compareTo(BigDecimal.ONE) < 0) {
            final Moment moment = Moment.valueOf(new Date(Formulas.valueOf(date).multiply(Formulas.valueOf(86400000L)).longValue()));
            return Moment.valueOf(1900, 1, 0, moment.hour().intValue(), moment.minute().intValue(), moment.second().intValue() == 0 ? 0 : moment.second().intValue() + 1);
        } else {
            if (date.intValue() <= 60) {
                return Moment.valueOf(1900, 1, date.intValue());
            } else {
                return Moment.valueOf(1900, 1, date.intValue() - 1);
            }
        }
    }

    public static Moment valueOf(Date date) {
        if (date == null) {
            throw new UniversalException("date", 0, UniversalException.ErrorType.VALUE);
        }
        return Moment.valueOf(date);
    }

    public static Moment date() {
        return now();
    }

    public static Moment date(CharSequence year, CharSequence month, CharSequence day) {
        if (year == null) {
            throw new UniversalException("year", 0, UniversalException.ErrorType.VALUE);
        }
        if (month == null) {
            throw new UniversalException("month", 1, UniversalException.ErrorType.VALUE);
        }
        if (day == null) {
            throw new UniversalException("day", 2, UniversalException.ErrorType.VALUE);
        }
        return date(Formulas.valueOf(year).intValue(),
                Formulas.valueOf(month).intValue(),
                Formulas.valueOf(day).intValue());
    }

    public static Moment date(Number year, Number month, Number day) {
        return date(year, month, day, 0, 0);
    }

    public static Moment date(Number year, Number month, Number day, Number hours, Number minutes) {
        if (year == null) {
            throw new UniversalException("year", 0, UniversalException.ErrorType.VALUE);
        }
        if (month == null) {
            throw new UniversalException("month", 1, UniversalException.ErrorType.VALUE);
        }
        if (day == null) {
            throw new UniversalException("day", 2, UniversalException.ErrorType.VALUE);
        }
        if (hours == null) {
            throw new UniversalException("hours", 3, UniversalException.ErrorType.VALUE);
        }
        if (minutes == null) {
            throw new UniversalException("minutes", 4, UniversalException.ErrorType.VALUE);
        }
        return date(year.intValue(), month.intValue(), day.intValue(), hours.intValue(), minutes.intValue(), 0);
    }

    public static Moment date(Number year, Number month, Number day, Number hours, Number minutes, Number seconds) {
        if (year == null) {
            throw new UniversalException("year", 0, UniversalException.ErrorType.VALUE);
        }
        if (month == null) {
            throw new UniversalException("month", 1, UniversalException.ErrorType.VALUE);
        }
        if (day == null) {
            throw new UniversalException("day", 2, UniversalException.ErrorType.VALUE);
        }
        if (hours == null) {
            throw new UniversalException("hours", 3, UniversalException.ErrorType.VALUE);
        }
        if (minutes == null) {
            throw new UniversalException("minutes", 4, UniversalException.ErrorType.VALUE);
        }
        if (seconds == null) {
            throw new UniversalException("seconds", 5, UniversalException.ErrorType.VALUE);
        }

        // The DATE function returns the sequential serial number that represents a particular date.
        // The DATE function returns the sequential serial number that represents a particular date.
        // @see https://support.office.com/en-us/article/date-function-e36c0c8c-4104-49da-ab83-82328b832349
        if (year.intValue() < 0 || year.intValue() > 10000) {
            throw new UniversalException("year", 0, UniversalException.ErrorType.NUM);
        }

        final int y;
        final int m;
        final int d;
        final int h;
        final int min;
        final int sec;

        if (year.intValue() <= 1899) {
            y = 1900 + year.intValue();
        } else {
            y = year.intValue();
        }

        if (month.intValue() > 12) {
            m = month.intValue();
        } else if (month.intValue() < 0) {
            m = month.intValue();
        } else {
            m = month.intValue();
        }

        d = day.intValue();
        h = hours.intValue();
        min = minutes.intValue();
        sec = seconds.intValue();

        return Moment.valueOf(y, m, d, h, min, sec);
    }

    public static FormulaDecimal datedif(Number startDate, Date endDate, CharSequence unit) {
        return datedif(Moments.valueOf(startDate), Moments.valueOf(endDate), unit);
    }

    public static FormulaDecimal datedif(Date startDate, Number endDate, CharSequence unit) {
        return datedif(Moments.valueOf(startDate), Moments.valueOf(endDate), unit);
    }

    public static FormulaDecimal datedif(CharSequence startDate, Date endDate, CharSequence unit) {
        return datedif(Moments.valueOf(startDate), Moments.valueOf(endDate), unit);
    }

    public static FormulaDecimal datedif(Date startDate, CharSequence endDate, CharSequence unit) {
        return datedif(Moments.valueOf(startDate), Moments.valueOf(endDate), unit);
    }

    public static FormulaDecimal datedif(CharSequence startDate, Number endDate, CharSequence unit) {
        return datedif(Moments.valueOf(startDate), Moments.valueOf(endDate), unit);
    }

    public static FormulaDecimal datedif(Number startDate, CharSequence endDate, CharSequence unit) {
        return datedif(Moments.valueOf(startDate), Moments.valueOf(endDate), unit);
    }

    public static FormulaDecimal datedif(Number startDate, Number endDate, CharSequence unit) {
        return datedif(Moments.valueOf(startDate), Moments.valueOf(endDate), unit);
    }

    public static FormulaDecimal datedif(CharSequence startDate, CharSequence endDate, CharSequence unit) {
        return datedif(Moments.valueOf(startDate), Moments.valueOf(endDate), unit);
    }

    public static FormulaDecimal datedif(Date startDate, Date endDate, CharSequence unit) {
        if (startDate == null) {
            throw new UniversalException("startDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (endDate == null) {
            throw new UniversalException("endDate", 1, UniversalException.ErrorType.VALUE);
        }
        if (unit == null) {
            throw new UniversalException("unit", 2, UniversalException.ErrorType.VALUE);
        }

        if (startDate.compareTo(endDate) > 0) {
            throw new UniversalException("startDate", 0, UniversalException.ErrorType.NUM);
        }

        // Calculates the number of days, months, or years between two dates.

        if (startDate.toInstant().isAfter(endDate.toInstant())) {
            throw new IllegalArgumentException("#NUM!");
        }

        switch (unit.toString()) {
            case "Y":
                // The number of complete years in the period.
                Calendar a = Moments.valueOf(startDate).getCalendar();
                Calendar b = Moments.valueOf(endDate).getCalendar();
                int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
                if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) || (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
                    diff--;
                }
                return Formulas.valueOf(diff);
            case "M":
                // The number of complete months in the period.
                return Formulas.valueOf(ChronoUnit.MONTHS.between(startDate.toInstant(), endDate.toInstant()));
            case "D":
                // The number of days in the period.
                return Formulas.valueOf(ChronoUnit.DAYS.between(startDate.toInstant(), endDate.toInstant()));
            case "MD":
                // The difference between the days in start_date and end_date. The months and years of the dates are ignored.
                return Formulas.valueOf(ChronoUnit.DAYS.between(
                        Moment.valueOf(0, 0, Moments.valueOf(startDate).dayOfMonth().intValue()).toInstant(),
                        Moment.valueOf(0, 0, Moments.valueOf(endDate).dayOfMonth().intValue()).toInstant()));
            case "YM":
                // The difference between the months in start_date and end_date. The days and years of the dates are ignored
                return Formulas.valueOf(ChronoUnit.MONTHS.between(
                        Moment.valueOf(0, Moments.valueOf(startDate).month().intValue(), 0).toInstant(),
                        Moment.valueOf(0, Moments.valueOf(endDate).month().intValue(), 0).toInstant()));
            case "YD":
                // The difference between the days of start_date and end_date. The years of the dates are ignored.
                return Formulas.valueOf(ChronoUnit.DAYS.between(
                        Moment.valueOf(0, Moments.valueOf(startDate).month().intValue(), Moments.valueOf(startDate).dayOfMonth().intValue()).toInstant(),
                        Moment.valueOf(0, Moments.valueOf(endDate).month().intValue(), Moments.valueOf(endDate).dayOfMonth().intValue()).toInstant()));
            default:
                throw new UniversalException("unit", 2, UniversalException.ErrorType.VALUE);
        }
    }

    public static FormulaDecimal datevalue(CharSequence date) {
        // The DATEVALUE function converts a date that is stored as text to a serial number that is recognizes as a date.
        return datevalue(Moments.valueOf(date));
    }

    public static FormulaDecimal datevalue(Date date) {
        return datevalue(Moment.valueOf(date));
    }

    public static FormulaDecimal datevalue(Number date) {
        return datevalue(Moments.valueOf(date.longValue()));
    }

    public static FormulaDecimal datevalue(Moment date) {
        if (date == null) {
            throw new UniversalException("date", 0, UniversalException.ErrorType.VALUE);
        }
        // The DATEVALUE function converts a date that is stored as text to a serial number.
        int offset;
        if (date.toInstant().isBefore(Moment.valueOf(1900, 1, 1, 23, 59, 59).toInstant())) {
            offset = 1;
        } else {
            offset = 2;
        }
        // The DATEVALUE function converts a date that is stored as text to a serial number that is recognizes as a date.
        if ((ChronoUnit.HALF_DAYS.between(Moment.valueOf(1900, 1, 1).toInstant(), date.toInstant()) % 2 == 0)) {
            return Formulas.valueOf((ChronoUnit.HALF_DAYS.between(Moment.valueOf(1900, 1, 1).toInstant(), date.toInstant())) / 2 + offset);
        } else {
            // NOTE: this simply 'floor's the date value for half-days (fractional parts are rounded up).
            return Formulas.valueOf((ChronoUnit.HALF_DAYS.between(Moment.valueOf(1900, 1, 1).toInstant(), date.toInstant()) + 1) / 2 + offset);
        }
    }

    public static FormulaDecimal day() {
        return day(now());
    }

    public static FormulaDecimal day(CharSequence date) {
        if (date == null) {
            throw new UniversalException("date", 0, UniversalException.ErrorType.VALUE);
        }
        if (date.toString().contains("/") || date.toString().contains("-") || date.toString().contains(":")) {
            return day(Moments.valueOf(date));
        } else {
            return day((Number) Formulas.valueOf(date.toString()));
        }
    }

    public static FormulaDecimal day(Number date) {
        if (date == null) {
            throw new UniversalException("date", 0, UniversalException.ErrorType.VALUE);
        }
        return day(Moments.valueOf(Formulas.valueOf(date.toString())));
    }

    public static FormulaDecimal day(Date date) {
        if (date == null) {
            throw new UniversalException("date", 0, UniversalException.ErrorType.VALUE);
        }
        return day(Moment.valueOf(date));
    }

    public static FormulaDecimal day(Moment date) {
        if (date == null) {
            throw new UniversalException("date", 0, UniversalException.ErrorType.VALUE);
        }
        return Formulas.valueOf(Moment.valueOf(date).dayOfMonth());
    }

    public static FormulaDecimal days(CharSequence endDate, CharSequence startDate) {
        return days(Moments.valueOf(endDate), Moments.valueOf(startDate));
    }

    public static FormulaDecimal days(Number endDate, CharSequence startDate) {
        return days(Moments.valueOf(endDate), Moments.valueOf(startDate));
    }

    public static FormulaDecimal days(CharSequence endDate, Number startDate) {
        return days(Moments.valueOf(endDate), Moments.valueOf(startDate));
    }

    public static FormulaDecimal days(CharSequence endDate, Date startDate) {
        return days(Moments.valueOf(endDate), Moments.valueOf(startDate));
    }

    public static FormulaDecimal days(Date endDate, CharSequence startDate) {
        return days(Moments.valueOf(endDate), Moments.valueOf(startDate));
    }

    public static FormulaDecimal days(Number endDate, Date startDate) {
        return days(Moments.valueOf(endDate), Moments.valueOf(startDate));
    }

    public static FormulaDecimal days(Date endDate, Number startDate) {
        return days(Moments.valueOf(endDate), Moments.valueOf(startDate));
    }

    public static FormulaDecimal days(Number endDate, Number startDate) {
        return days(Moments.valueOf(endDate), Moments.valueOf(startDate));
    }

    public static FormulaDecimal days(Date endDate, Date startDate) {
        if (startDate == null) {
            throw new UniversalException("startDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (endDate == null) {
            throw new UniversalException("endDate", 1, UniversalException.ErrorType.VALUE);
        }

        // Returns the number of days between two dates.
        return Formulas.valueOf(ChronoUnit.DAYS.between(startDate.toInstant(), endDate.toInstant()));
    }

    public static FormulaDecimal days360(CharSequence startDate, CharSequence endDate) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate));
    }

    public static FormulaDecimal days360(Number startDate, CharSequence endDate) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate));
    }

    public static FormulaDecimal days360(CharSequence startDate, Number endDate) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate));
    }

    public static FormulaDecimal days360(CharSequence startDate, Date endDate) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate));
    }

    public static FormulaDecimal days360(Date startDate, CharSequence endDate) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate));
    }

    public static FormulaDecimal days360(Number startDate, Date endDate) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate));
    }

    public static FormulaDecimal days360(Date startDate, Number endDate) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate));
    }

    public static FormulaDecimal days360(Number startDate, Number endDate) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate));
    }

    public static FormulaDecimal days360(Date startDate, Date endDate) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate), false);
    }

    public static FormulaDecimal days360(CharSequence startDate, CharSequence endDate, Boolean method) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate), method);
    }

    public static FormulaDecimal days360(Number startDate, CharSequence endDate, Boolean method) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate), method);
    }

    public static FormulaDecimal days360(CharSequence startDate, Number endDate, Boolean method) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate), method);
    }

    public static FormulaDecimal days360(CharSequence startDate, Date endDate, Boolean method) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate), method);
    }

    public static FormulaDecimal days360(Date startDate, CharSequence endDate, Boolean method) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate), method);
    }

    public static FormulaDecimal days360(Number startDate, Date endDate, Boolean method) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate), method);
    }

    public static FormulaDecimal days360(Date startDate, Number endDate, Boolean method) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate), method);
    }

    public static FormulaDecimal days360(Number startDate, Number endDate, Boolean method) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate), method);
    }

    public static FormulaDecimal days360(CharSequence startDate, CharSequence endDate, Logical method) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate), method);
    }

    public static FormulaDecimal days360(Number startDate, CharSequence endDate, Logical method) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate), method);
    }

    public static FormulaDecimal days360(CharSequence startDate, Number endDate, Logical method) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate), method);
    }

    public static FormulaDecimal days360(CharSequence startDate, Date endDate, Logical method) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate), method);
    }

    public static FormulaDecimal days360(Date startDate, CharSequence endDate, Logical method) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate), method);
    }

    public static FormulaDecimal days360(Number startDate, Date endDate, Logical method) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate), method);
    }

    public static FormulaDecimal days360(Date startDate, Number endDate, Logical method) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate), method);
    }

    public static FormulaDecimal days360(Number startDate, Number endDate, Logical method) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate), method);
    }

    public static FormulaDecimal days360(Date startDate, Date endDate, Boolean method) {
        return days360(Moments.valueOf(startDate), Moments.valueOf(endDate), Logical.valueOf(method));
    }

    public static FormulaDecimal days360(Date startDate, Date endDate, Logical method) {
        if (startDate == null) {
            throw new UniversalException("startDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (endDate == null) {
            throw new UniversalException("endDate", 1, UniversalException.ErrorType.VALUE);
        }

        // The DAYS360 function returns the number of days between two dates based on a 360-day year (twelve 30-day months),
        // which is used in some accounting calculations. Use this function to help compute payments if your accounting system is based on twelve 30-day months.

        final int startMonth = Moments.valueOf(startDate).month().intValue();
        int endMonth = Moments.valueOf(endDate).month().intValue();
        final int startDay;
        final int endDay;

        if (Logical.valueOf(method).booleanValue()) {
            // European method.
            // Starting dates and ending dates that occur on the 31st day of a month become equal to the 30th day of the same month.
            startDay = Moments.valueOf(startDate).dayOfMonth().intValue() == 31 ? 30 : Moments.valueOf(startDate).dayOfMonth().intValue();
            endDay = Moments.valueOf(endDate).dayOfMonth().intValue() == 31 ? 30 : Moments.valueOf(endDate).dayOfMonth().intValue();
        } else {
            // U.S. (NASD) method.
            // If the starting date is the last day of a month, it becomes equal to the 30th day of the same month.
            // If the ending date is the last day of a month and the starting date is earlier than the 30th day of a month,
            // the ending date becomes equal to the 1st day of the next month; otherwise the ending date becomes equal to the 30th day of the same month.
            int smd = Moment.valueOf(Moments.valueOf(startDate).year().intValue(), startMonth + 1, 0).dayOfMonth().intValue();
            int emd = Moment.valueOf(Moments.valueOf(endDate).year().intValue(), endMonth + 1, 0).dayOfMonth().intValue();
            startDay = Moments.valueOf(startDate).dayOfMonth().intValue() == smd ? 30 : Moments.valueOf(startDate).dayOfMonth().intValue();
            if (Moments.valueOf(endDate).dayOfMonth().intValue() == emd) {
                if (startDay < 30) {
                    endMonth++;
                    endDay = 1;
                } else {
                    endDay = 30;
                }
            } else {
                endDay = Moments.valueOf(endDate).dayOfMonth().intValue();
            }
        }

        // 360 * (endDate.getYear() - startDate.getYear()) + 30 * (endMonth - startMonth) + (endDay - startDay))
        return Formulas.valueOf(360).multiply((Formulas.valueOf(Moments.valueOf(endDate).year()).subtract(Formulas.valueOf(Moments.valueOf(startDate).year()))))
                .add(Formulas.valueOf(30).multiply(Formulas.valueOf(endMonth).subtract(Formulas.valueOf(startMonth)))).add(Formulas.valueOf(endDay).subtract(Formulas.valueOf(startDay)));
    }

    public static FormulaDecimal edate(CharSequence startDate, Number months) {
        return edate(Moments.valueOf(startDate), months);
    }

    public static FormulaDecimal edate(Number startDate, Number months) {
        return edate(Moments.valueOf(startDate), months);
    }

    public static FormulaDecimal edate(Date startDate, Number months) {
        if (startDate == null) {
            throw new UniversalException("startDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (months == null) {
            throw new UniversalException("months", 1, UniversalException.ErrorType.VALUE);
        }

        // Returns the serial number that represents the date that is the indicated number of months before or after a specified date (the start_date).
        // Use EDATE to calculate maturity dates or due dates that fall on the same day of the month as the date of issue.
        final Calendar calendar = Moment.valueOf(startDate).getCalendar();
        calendar.add(Calendar.MONTH, months.intValue());
        return datevalue(Moment.valueOf(calendar.getTime()));
    }

    public static FormulaDecimal eomonth(CharSequence startDate, Number months) {
        return eomonth(Moments.valueOf(startDate), months);
    }

    public static FormulaDecimal eomonth(Number startDate, Number months) {
        return eomonth(Moments.valueOf(startDate), months);
    }

    public static FormulaDecimal eomonth(Date startDate, Number months) {
        if (startDate == null) {
            throw new UniversalException("startDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (months == null) {
            throw new UniversalException("months", 1, UniversalException.ErrorType.VALUE);
        }

        // Returns the serial number for the last day of the month that is the indicated number of months before or after start_date.
        // Use EOMONTH to calculate maturity dates or due dates that fall on the last day of the month.
        return datevalue(Moment.valueOf(Moment.valueOf(startDate).year().intValue(), Moment.valueOf(startDate).month().intValue() + months.intValue() + 1, 0));
    }

    public static FormulaDecimal hour() {
        return Formulas.valueOf(now().hour());
    }

    public static FormulaDecimal hour(CharSequence date) {
        if (date == null) {
            throw new UniversalException("date", 0, UniversalException.ErrorType.VALUE);
        }

        if (date.toString().contains("/") || date.toString().contains("-") || date.toString().contains(":")) {
            return hour(Moments.valueOf(date));
        } else {
            return hour((Number) Formulas.valueOf(date.toString()));
        }
    }

    public static FormulaDecimal hour(Number date) {
        if (date == null) {
            throw new UniversalException("date", 0, UniversalException.ErrorType.VALUE);
        }

        if (Formulas.valueOf(date).compareTo(BigDecimal.ZERO) == 0) {
            return Formulas.valueOf(0);
        } else if (Formulas.valueOf(date).compareTo(BigDecimal.ONE) < 0) {
            return Formulas.valueOf(24).multiply(Formulas.valueOf(date));
        } else {
            return hour(Moments.valueOf(date));
        }
    }

    public static FormulaDecimal hour(Date date) {
        return hour(Moment.valueOf(date));
    }

    public static FormulaDecimal hour(Moment date) {
        return Formulas.valueOf(Moment.valueOf(date).hour());
    }

    public static FormulaDecimal isoweeknum(Date date) {
        return isoweeknum(Moments.valueOf(date));
    }

    public static FormulaDecimal isoweeknum(Number date) {
        return isoweeknum(Moments.valueOf(date));
    }

    public static FormulaDecimal isoweeknum(CharSequence date) {
        return isoweeknum(Moment.valueOf(date));
    }

    public static FormulaDecimal isoweeknum(Moment date) {
        if (date == null) {
            throw new UniversalException("date", 0, UniversalException.ErrorType.VALUE);
        }

        // Returns number of the ISO week number of the year for a given date.
        return Formulas.valueOf(date.isoweeknum());
    }

    public static FormulaDecimal minute() {
        return Formulas.valueOf(now().minute());
    }

    public static FormulaDecimal minute(CharSequence date) {
        if (date == null) {
            throw new UniversalException("date", 0, UniversalException.ErrorType.VALUE);
        }

        if (date.toString().contains("/") || date.toString().contains("-") || date.toString().contains(":")) {
            return minute(Moments.valueOf(date));
        } else {
            return minute((Number) Formulas.valueOf(date.toString()));
        }
    }

    public static FormulaDecimal minute(Number date) {
        if (date == null) {
            throw new UniversalException("date", 0, UniversalException.ErrorType.VALUE);
        }

        if (Formulas.valueOf(date).compareTo(BigDecimal.ZERO) == 0) {
            return Formulas.valueOf(0);
//        } else if (Formulas.valueOf(date).compareTo(BigDecimal.ONE) < 0) {
//            return Formulas.valueOf(60).multiply(Formulas.valueOf(date));
        } else {
            return minute(Moments.valueOf(date));
        }
    }

    public static FormulaDecimal minute(Date date) {
        return minute(Moment.valueOf(date));
    }

    public static FormulaDecimal minute(Moment date) {
        return Formulas.valueOf(Moments.valueOf(date).minute());
    }

    public static FormulaDecimal month() {
        return Formulas.valueOf(now().month());
    }

    public static FormulaDecimal month(CharSequence date) {
        if (date == null) {
            throw new UniversalException("date", 0, UniversalException.ErrorType.VALUE);
        }

        if (date.toString().contains("/") || date.toString().contains("-")) {
            return month(Moments.valueOf(date));
        } else {
            return month((Number) Formulas.valueOf(date.toString()));
        }
    }

    public static FormulaDecimal month(Number date) {
        if (date == null) {
            throw new UniversalException("date", 0, UniversalException.ErrorType.VALUE);
        }

        if (Formulas.valueOf(date).compareTo(BigDecimal.ZERO) == 0) {
            return Formulas.valueOf(0);
        } else if (Formulas.valueOf(date).compareTo(BigDecimal.ONE) < 0) {
            return Formulas.valueOf(12).multiply(Formulas.valueOf(date));
        } else {
            return month(Moments.valueOf(date));
        }
    }

    public static FormulaDecimal month(Date date) {
        return month(Moment.valueOf(date));
    }

    public static FormulaDecimal month(Moment date) {
        return Formulas.valueOf(Moment.valueOf(date).month());
    }

    public static FormulaDecimal networkdays(CharSequence startDate, CharSequence endDate) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), new Date[0]);
    }

    public static FormulaDecimal networkdays(Number startDate, Number endDate) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), new Date[0]);
    }

    public static FormulaDecimal networkdays(Number startDate, CharSequence endDate) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), new Date[0]);
    }

    public static FormulaDecimal networkdays(CharSequence startDate, Number endDate) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), new Date[0]);
    }

    public static FormulaDecimal networkdays(Date startDate, CharSequence endDate) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), new Date[0]);
    }

    public static FormulaDecimal networkdays(CharSequence startDate, Date endDate) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), new Date[0]);
    }

    public static FormulaDecimal networkdays(Date startDate, Number endDate) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), new Date[0]);
    }

    public static FormulaDecimal networkdays(Number startDate, Date endDate) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), new Date[0]);
    }

    public static FormulaDecimal networkdays(Date startDate, Date endDate) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), new Date[0]);
    }

    public static FormulaDecimal networkdays(CharSequence startDate, CharSequence endDate, CharSequence... holidays) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays(Number startDate, Number endDate, Number... holidays) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays(Number startDate, CharSequence endDate, CharSequence... holidays) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays(CharSequence startDate, Number endDate, CharSequence... holidays) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays(CharSequence startDate, CharSequence endDate, Number... holidays) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays(Number startDate, Number endDate, CharSequence... holidays) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays(CharSequence startDate, Number endDate, Number... holidays) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays(Number startDate, CharSequence endDate, Number... holidays) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays(Date startDate, CharSequence endDate, CharSequence... holidays) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays(CharSequence startDate, Date endDate, CharSequence... holidays) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays(CharSequence startDate, CharSequence endDate, Date... holidays) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays(Date startDate, Date endDate, CharSequence... holidays) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays(CharSequence startDate, Date endDate, Date... holidays) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays(Date startDate, CharSequence endDate, Date... holidays) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays(Date startDate, Number endDate, Number... holidays) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays(Number startDate, Date endDate, Number... holidays) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays(Number startDate, Number endDate, Date... holidays) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays(Date startDate, Date endDate, Number... holidays) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays(Number startDate, Date endDate, Date... holidays) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays(Date startDate, Number endDate, Date... holidays) {
        return networkdays(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays(Date startDate, Date endDate, Date... holidays) {
        // Returns the number of whole working days between start_date and end_date. Working days exclude weekends and any dates identified in holidays.
        return networkdays_intl(startDate, endDate, 1, holidays);
    }

    public static FormulaDecimal networkdays_intl(CharSequence startDate, CharSequence endDate) {
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), new Date[0]);
    }

    public static FormulaDecimal networkdays_intl(Number startDate, Number endDate) {
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), new Date[0]);
    }

    public static FormulaDecimal networkdays_intl(Number startDate, CharSequence endDate) {
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), new Date[0]);
    }

    public static FormulaDecimal networkdays_intl(CharSequence startDate, Number endDate) {
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), new Date[0]);
    }

    public static FormulaDecimal networkdays_intl(Date startDate, CharSequence endDate) {
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), new Date[0]);
    }

    public static FormulaDecimal networkdays_intl(CharSequence startDate, Date endDate) {
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), new Date[0]);
    }

    public static FormulaDecimal networkdays_intl(Date startDate, Number endDate) {
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), new Date[0]);
    }

    public static FormulaDecimal networkdays_intl(Number startDate, Date endDate) {
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), new Date[0]);
    }

    public static FormulaDecimal networkdays_intl(Date startDate, Date endDate) {
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), new Date[0]);
    }

    public static FormulaDecimal networkdays_intl(CharSequence startDate, CharSequence endDate, CharSequence... holidays) {
        if (holidays != null && holidays.length > 0 && holidays[0].length() == 7 && holidays[0].chars().allMatch(value -> Character.getNumericValue(value) == 0 || Character.getNumericValue(value) == 1)) {
            return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays[0], Arrays.stream(Arrays.copyOfRange(holidays, 1, holidays.length)).map(Moments::valueOf).toArray(Date[]::new));
        }
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays_intl(Number startDate, Number endDate, Number... holidays) {
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays_intl(Number startDate, CharSequence endDate, CharSequence... holidays) {
        if (holidays != null && holidays.length > 0 && holidays[0].length() == 7 && holidays[0].chars().allMatch(value -> Character.getNumericValue(value) == 0 || Character.getNumericValue(value) == 1)) {
            return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays[0], Arrays.stream(Arrays.copyOfRange(holidays, 1, holidays.length)).map(Moments::valueOf).toArray(Date[]::new));
        }
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays_intl(CharSequence startDate, Number endDate, CharSequence... holidays) {
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays_intl(CharSequence startDate, CharSequence endDate, Number... holidays) {
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays_intl(Number startDate, Number endDate, CharSequence... holidays) {
        if (holidays != null && holidays.length > 0 && holidays[0].length() == 7 && holidays[0].chars().allMatch(value -> Character.getNumericValue(value) == 0 || Character.getNumericValue(value) == 1)) {
            return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays[0], Arrays.stream(Arrays.copyOfRange(holidays, 1, holidays.length)).map(Moments::valueOf).toArray(Date[]::new));
        }
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays_intl(CharSequence startDate, Number endDate, Number... holidays) {
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays_intl(Number startDate, CharSequence endDate, Number... holidays) {
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays_intl(Date startDate, CharSequence endDate, CharSequence... holidays) {
        if (holidays != null && holidays.length > 0 && holidays[0].length() == 7 && holidays[0].chars().allMatch(value -> Character.getNumericValue(value) == 0 || Character.getNumericValue(value) == 1)) {
            return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays[0], Arrays.stream(Arrays.copyOfRange(holidays, 1, holidays.length)).map(Moments::valueOf).toArray(Date[]::new));
        }
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays_intl(CharSequence startDate, Date endDate, CharSequence... holidays) {
        if (holidays != null && holidays.length > 0 && holidays[0].length() == 7 && holidays[0].chars().allMatch(value -> Character.getNumericValue(value) == 0 || Character.getNumericValue(value) == 1)) {
            return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays[0], Arrays.stream(Arrays.copyOfRange(holidays, 1, holidays.length)).map(Moments::valueOf).toArray(Date[]::new));
        }
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays_intl(CharSequence startDate, CharSequence endDate, Date... holidays) {
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays_intl(Date startDate, Date endDate, CharSequence... holidays) {
        if (holidays != null && holidays.length > 0 && holidays[0].length() == 7 && holidays[0].chars().allMatch(value -> Character.getNumericValue(value) == 0 || Character.getNumericValue(value) == 1)) {
            return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays[0], Arrays.stream(Arrays.copyOfRange(holidays, 1, holidays.length)).map(Moments::valueOf).toArray(Date[]::new));
        }
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays_intl(CharSequence startDate, Date endDate, Date... holidays) {
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays_intl(Date startDate, CharSequence endDate, Date... holidays) {
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays_intl(Date startDate, Number endDate, Number... holidays) {
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays_intl(Number startDate, Date endDate, Number... holidays) {
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays_intl(Number startDate, Number endDate, Date... holidays) {
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays_intl(Date startDate, Date endDate, Number... holidays) {
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays_intl(Number startDate, Date endDate, Date... holidays) {
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays_intl(Date startDate, Number endDate, Date... holidays) {
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays_intl(Date startDate, Date endDate, Date... holidays) {
        return networkdays_intl(startDate, endDate, 1, holidays);
    }

    public static FormulaDecimal networkdays_intl(Date startDate, Date endDate, Number weekend, CharSequence... holidays) {
        return networkdays_intl(startDate, endDate, weekend, holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays_intl(Date startDate, Date endDate, CharSequence weekend, CharSequence... holidays) {
        return networkdays_intl(startDate, endDate, weekend, holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays_intl(Date startDate, Date endDate, Number weekend, Date... holidays) {
        return networkdays_intl(startDate, endDate, String.valueOf(weekend), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static FormulaDecimal networkdays_intl(Date startDate, Date endDate, Number weekend) {
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), weekend, new Date[0]);
    }

    public static FormulaDecimal networkdays_intl(Date startDate, Date endDate, CharSequence weekend) {
        return networkdays_intl(Moments.valueOf(startDate), Moments.valueOf(endDate), weekend, new Date[0]);
    }

    public static FormulaDecimal networkdays_intl(Date startDate, Date endDate, CharSequence weekend, Date... holidays) {
        if (startDate == null) {
            throw new UniversalException("startDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (endDate == null) {
            throw new UniversalException("endDate", 1, UniversalException.ErrorType.VALUE);
        }
        if (weekend == null) {
            throw new UniversalException("weekend", 2, UniversalException.ErrorType.VALUE);
        }

        // TODO support weekend string values (@see https://support.office.com/en-us/article/networkdays-intl-function-a9b26239-4f20-46a1-9ab8-4e925bfd5e28?ui=en-US&rs=en-US&ad=US)
        // Returns the number of whole working days between start_date and end_date. Working days exclude weekends and any dates identified in holidays.

        final Predicate<Integer> isDayOfWeekWeekendPredicate;

        if (weekend.length() == 7) {
            isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                @Override
                public boolean test(Integer dayOfWeek) {
                    final boolean monday = Character.getNumericValue(weekend.charAt(0)) == 1;
                    final boolean tuesday = Character.getNumericValue(weekend.charAt(1)) == 1;
                    final boolean wednesday = Character.getNumericValue(weekend.charAt(2)) == 1;
                    final boolean thursday = Character.getNumericValue(weekend.charAt(3)) == 1;
                    final boolean friday = Character.getNumericValue(weekend.charAt(4)) == 1;
                    final boolean caturday = Character.getNumericValue(weekend.charAt(5)) == 1;
                    final boolean sunday = Character.getNumericValue(weekend.charAt(6)) == 1;

                    switch (dayOfWeek) {
                        case Calendar.SUNDAY:
                            return sunday;
                        case Calendar.MONDAY:
                            return monday;
                        case Calendar.TUESDAY:
                            return tuesday;
                        case Calendar.WEDNESDAY:
                            return wednesday;
                        case Calendar.THURSDAY:
                            return thursday;
                        case Calendar.FRIDAY:
                            return friday;
                        case Calendar.SATURDAY:
                            return caturday;
                        default:
                            throw new UnsupportedOperationException();
                    }
                }
            };
        } else {

            switch (Formulas.valueOf(weekend.toString()).intValue()) {
                case 1:
                    // Saturday, Sunday
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
                        }
                    };
                    break;
                case 2:
                    // Sunday, Monday
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.MONDAY;
                        }
                    };
                    break;
                case 3:
                    // Monday, Tuesday
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.MONDAY || dayOfWeek == Calendar.TUESDAY;
                        }
                    };
                    break;
                case 4:
                    // Tuesday, Wednesday
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.TUESDAY || dayOfWeek == Calendar.WEDNESDAY;
                        }
                    };
                    break;
                case 5:
                    // Wednesday, Thursday
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.WEDNESDAY || dayOfWeek == Calendar.THURSDAY;
                        }
                    };
                    break;
                case 6:
                    // Thursday, Friday
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.THURSDAY || dayOfWeek == Calendar.FRIDAY;
                        }
                    };
                    break;
                case 7:
                    // Friday, Saturday
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.FRIDAY || dayOfWeek == Calendar.SATURDAY;
                        }
                    };
                    break;
                case 8:
                    throw new UnsupportedOperationException();
                case 9:
                    throw new UnsupportedOperationException();
                case 10:
                    throw new UnsupportedOperationException();
                case 11:
                    // Sunday only
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.SUNDAY;
                        }
                    };
                    break;
                case 12:
                    // Monday only
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.MONDAY;
                        }
                    };
                    break;
                case 13:
                    // Tuesday only
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.TUESDAY;
                        }
                    };
                    break;
                case 14:
                    // Wednesday only
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.WEDNESDAY;
                        }
                    };
                    break;
                case 15:
                    // Thursday only
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.THURSDAY;
                        }
                    };
                    break;
                case 16:
                    // Friday only
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.FRIDAY;
                        }
                    };
                    break;
                case 17:
                    // Saturday only
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.SATURDAY;
                        }
                    };
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
        }
        final FormulaDecimal days = days(endDate, startDate);
        boolean negative = days.intValue() < 0;
        int result = negative ? (days.intValue() - 1) : (days.intValue() + 1);
        for (int i = 0; i < Formulas.abs(days).intValue(); i++) {
            final Moment day;
            if (negative) {
                day = Moments.valueOf(startDate).subtract(Formulas.valueOf(i));
            } else {
                day = Moments.valueOf(startDate).add(Formulas.valueOf(i));
            }
            if (isDayOfWeekWeekendPredicate.test(day.weekday().intValue())) {
                result += negative ? 1 : -1;
            } else if (Arrays.stream(holidays).anyMatch(new Predicate<Date>() {
                @Override
                public boolean test(Date holiday) {
                    return Moments.valueOf(holiday).dayOfMonth().intValue() == day.dayOfMonth().intValue()
                            && Moments.valueOf(holiday).month().intValue() == day.month().intValue()
                            && Moments.valueOf(holiday).year().intValue() == day.year().intValue();
                }
            })) {
                result += negative ? 1 : -1;
            }
        }

        return Formulas.valueOf(result);
    }

    public static Moment now() {
        // Returns the serial number of the current date and time.
        return new Moment();
    }

    public static FormulaDecimal second() {
        return Formulas.valueOf(now().second());
    }

    public static FormulaDecimal second(CharSequence date) {
        if (date == null) {
            throw new UniversalException("date", 0, UniversalException.ErrorType.VALUE);
        }

        if (date.toString().contains("/") || date.toString().contains("-") || date.toString().contains(":")) {
            return second(Moments.valueOf(date));
        } else {
            return second((Number) Formulas.valueOf(date.toString()));
        }
    }

    public static FormulaDecimal second(Number date) {
        if (date == null) {
            throw new UniversalException("date", 0, UniversalException.ErrorType.VALUE);
        }

        if (Formulas.valueOf(date).compareTo(BigDecimal.ZERO) == 0) {
            return Formulas.valueOf(0);
//        } else if (Formulas.valueOf(date).compareTo(BigDecimal.ONE) < 0) {
//            return Formulas.valueOf(60).multiply(Formulas.valueOf(date));
        } else {
            return second(Moments.valueOf(date));
        }
    }

    public static FormulaDecimal second(Date date) {
        return second(Moment.valueOf(date));
    }

    public static FormulaDecimal second(Moment date) {
        return Formulas.valueOf(Moment.valueOf(date).second());
    }

    public static FormulaDecimal time(CharSequence hours, CharSequence minutes, CharSequence seconds) {
        return time(Formulas.valueOf(hours), Formulas.valueOf(minutes), Formulas.valueOf(seconds));
    }

    public static FormulaDecimal time(CharSequence hours, CharSequence minutes) {
        return time(Formulas.valueOf(hours), Formulas.valueOf(minutes));
    }

    public static FormulaDecimal time(Number hours, Number minutes) {
        return time(hours, minutes, 0);
    }

    public static FormulaDecimal time(Number hours, Number minutes, Number seconds) {
        if (hours == null) {
            throw new UniversalException("hours", 0, UniversalException.ErrorType.VALUE);
        }
        if (minutes == null) {
            throw new UniversalException("minutes", 1, UniversalException.ErrorType.VALUE);
        }
        if (seconds == null) {
            throw new UniversalException("seconds", 2, UniversalException.ErrorType.VALUE);
        }

        // Returns the decimal number for a particular time.
        return Formulas.valueOf(3600).multiply(Formulas.valueOf(hours)).add(Formulas.valueOf(60).multiply(Formulas.valueOf(minutes))).add(Formulas.valueOf(seconds)).divide(Formulas.valueOf(86400));
    }

    public static FormulaDecimal timevalue(CharSequence date) {
        return timevalue(Moments.valueOf(date));
    }

    public static FormulaDecimal timevalue(Number date) {
        return timevalue(Moments.valueOf(date.longValue()));
    }

    public static FormulaDecimal timevalue(Date date) {
        return timevalue(Moments.valueOf(date));
    }

    public static FormulaDecimal timevalue(Moment date) {
        if (date == null) {
            throw new UniversalException("date", 0, UniversalException.ErrorType.VALUE);
        }

        // Returns the decimal number of the time represented by a text string.
        // The decimal number is a value ranging from 0 (zero) to 0.99988426,
        // representing the times from 0:00:00 (12:00:00 AM) to 23:59:59 (11:59:59 P.M.).
        return time(date.hour().intValue(), date.minute().intValue(), date.second().intValue());
    }

    public static Moment today() {
        // Returns the serial number of the current date.
        return new Moment();
    }

    public static FormulaDecimal weekday() {
        return Formulas.valueOf(now().weekday());
    }

    public static FormulaDecimal weekday(CharSequence date) {
        return weekday(Moments.valueOf(date));
    }

    public static FormulaDecimal weekday(Number date) {
        return weekday(Moments.valueOf(date));
    }

    public static FormulaDecimal weekday(Date date) {
        return weekday(Moments.valueOf(date));
    }

    public static FormulaDecimal weekday(Moment date) {
        return weekday(Moments.valueOf(date), 1);
    }

    public static FormulaDecimal weekday(Number date, Number firstDayOfWeek) {
        return weekday(Moments.valueOf(date), firstDayOfWeek);
    }

    public static FormulaDecimal weekday(CharSequence date, Number firstDayOfWeek) {
        return weekday(Moments.valueOf(date), firstDayOfWeek);
    }

    public static FormulaDecimal weekday(Date date, Number firstDayOfWeek) {
        return weekday(Moments.valueOf(date), firstDayOfWeek);
    }

    public static FormulaDecimal weekday(Moment date, Number firstDayOfWeek) {
        return Formulas.valueOf(Moment.valueOf(date).weekday(firstDayOfWeek.intValue()));
    }

    public static FormulaDecimal weeknum() {
        return Formulas.valueOf(now().weeknum());
    }

    public static FormulaDecimal weeknum(CharSequence date) {
        return weeknum(Moments.valueOf(date));
    }

    public static FormulaDecimal weeknum(Number date) {
        return weeknum(Moments.valueOf(date));
    }

    public static FormulaDecimal weeknum(Date date) {
        return weeknum(Moments.valueOf(date));
    }

    public static FormulaDecimal weeknum(Moment date) {
        return weeknum(Moments.valueOf(date), 1);
    }

    public static FormulaDecimal weeknum(Number date, Number firstDayOfWeek) {
        return weeknum(Moments.valueOf(date), firstDayOfWeek);
    }

    public static FormulaDecimal weeknum(CharSequence date, Number firstDayOfWeek) {
        return weeknum(Moments.valueOf(date), firstDayOfWeek);
    }

    public static FormulaDecimal weeknum(Date date, Number firstDayOfWeek) {
        return weeknum(Moments.valueOf(date), firstDayOfWeek);
    }

    public static FormulaDecimal weeknum(Moment date, Number firstDayOfWeek) {
        return Formulas.valueOf(Moment.valueOf(date).weeknum(firstDayOfWeek.intValue()));
    }

    public static Moment workday(CharSequence startDate, CharSequence days) {
        return workday(Moments.valueOf(startDate), Formulas.valueOf(days), new Date[0]);
    }

    public static Moment workday(Number startDate, Number days) {
        return workday(Moments.valueOf(startDate), Formulas.valueOf(days), new Date[0]);
    }

    public static Moment workday(Number startDate, CharSequence days) {
        return workday(Moments.valueOf(startDate), Formulas.valueOf(days), new Date[0]);
    }

    public static Moment workday(CharSequence startDate, Number days) {
        return workday(Moments.valueOf(startDate), Formulas.valueOf(days), new Date[0]);
    }

    public static Moment workday(Date startDate, CharSequence days) {
        return workday(Moments.valueOf(startDate), Formulas.valueOf(days), new Date[0]);
    }

    public static Moment workday(Date startDate, Number days) {
        return workday(Moments.valueOf(startDate), Formulas.valueOf(days), new Date[0]);
    }

    public static Moment workday(Number startDate, Date days) {
        return workday(Moments.valueOf(startDate), Formulas.valueOf(days), new Date[0]);
    }

    public static Moment workday(Date startDate, Date days) {
        return workday(Moments.valueOf(startDate), Formulas.valueOf(days), new Date[0]);
    }

    public static Moment workday(CharSequence startDate, CharSequence days, CharSequence... holidays) {
        return workday(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday(Number startDate, Number days, Number... holidays) {
        return workday(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday(Number startDate, CharSequence days, CharSequence... holidays) {
        return workday(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday(CharSequence startDate, Number days, CharSequence... holidays) {
        return workday(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday(CharSequence startDate, CharSequence days, Number... holidays) {
        return workday(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday(Number startDate, Number days, CharSequence... holidays) {
        return workday(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday(CharSequence startDate, Number days, Number... holidays) {
        return workday(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday(Number startDate, CharSequence days, Number... holidays) {
        return workday(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday(Date startDate, CharSequence days, CharSequence... holidays) {
        return workday(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday(CharSequence startDate, CharSequence days, Date... holidays) {
        return workday(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday(Date startDate, CharSequence days, Date... holidays) {
        return workday(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday(Date startDate, Number days, Number... holidays) {
        return workday(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday(Number startDate, Date days, Number... holidays) {
        return workday(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday(Number startDate, Number days, Date... holidays) {
        return workday(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday(Date startDate, Number days, Date... holidays) {
        // Returns the number of whole working days between start_date and end_date. Working days exclude weekends and any dates identified in holidays.
        return workday_intl(startDate, days, 1, holidays);
    }

    public static Moment workday_intl(CharSequence startDate, CharSequence days) {
        return workday_intl(Moments.valueOf(startDate), Formulas.valueOf(days), new Date[0]);
    }

    public static Moment workday_intl(Number startDate, Number days) {
        return workday_intl(Moments.valueOf(startDate), Formulas.valueOf(days), new Date[0]);
    }

    public static Moment workday_intl(Number startDate, CharSequence days) {
        return workday_intl(Moments.valueOf(startDate), Formulas.valueOf(days), new Date[0]);
    }

    public static Moment workday_intl(CharSequence startDate, Number days) {
        return workday_intl(Moments.valueOf(startDate), Formulas.valueOf(days), new Date[0]);
    }

    public static Moment workday_intl(Date startDate, CharSequence days) {
        return workday_intl(Moments.valueOf(startDate), Formulas.valueOf(days), new Date[0]);
    }

    public static Moment workday_intl(Date startDate, Number days) {
        return workday_intl(Moments.valueOf(startDate), Formulas.valueOf(days), new Date[0]);
    }

    public static Moment workday_intl(CharSequence startDate, CharSequence days, CharSequence... holidays) {
        if (holidays != null && holidays.length > 0 && holidays[0].length() == 7 && holidays[0].chars().allMatch(value -> Character.getNumericValue(value) == 0 || Character.getNumericValue(value) == 1)) {
            return workday_intl(Moments.valueOf(startDate), Formulas.valueOf(days), holidays[0], Arrays.stream(Arrays.copyOfRange(holidays, 1, holidays.length)).map(Moments::valueOf).toArray(Date[]::new));
        }
        return workday_intl(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday_intl(Number startDate, Number days, Number... holidays) {
        return workday_intl(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday_intl(Number startDate, CharSequence days, CharSequence... holidays) {
        if (holidays != null && holidays.length > 0 && holidays[0].length() == 7 && holidays[0].chars().allMatch(value -> Character.getNumericValue(value) == 0 || Character.getNumericValue(value) == 1)) {
            return workday_intl(Moments.valueOf(startDate), Formulas.valueOf(days), holidays[0], Arrays.stream(Arrays.copyOfRange(holidays, 1, holidays.length)).map(Moments::valueOf).toArray(Date[]::new));
        }
        return workday_intl(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday_intl(CharSequence startDate, Number days, CharSequence... holidays) {
        return workday_intl(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday_intl(CharSequence startDate, CharSequence days, Number... holidays) {
        return workday_intl(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday_intl(Number startDate, Number days, CharSequence... holidays) {
        if (holidays != null && holidays.length > 0 && holidays[0].length() == 7 && holidays[0].chars().allMatch(value -> Character.getNumericValue(value) == 0 || Character.getNumericValue(value) == 1)) {
            return workday_intl(Moments.valueOf(startDate), Formulas.valueOf(days), holidays[0], Arrays.stream(Arrays.copyOfRange(holidays, 1, holidays.length)).map(Moments::valueOf).toArray(Date[]::new));
        }
        return workday_intl(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday_intl(CharSequence startDate, Number days, Number... holidays) {
        return workday_intl(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday_intl(Number startDate, CharSequence days, Number... holidays) {
        return workday_intl(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday_intl(Date startDate, CharSequence days, CharSequence... holidays) {
        if (holidays != null && holidays.length > 0 && holidays[0].length() == 7 && holidays[0].chars().allMatch(value -> Character.getNumericValue(value) == 0 || Character.getNumericValue(value) == 1)) {
            return workday_intl(Moments.valueOf(startDate), Formulas.valueOf(days), holidays[0], Arrays.stream(Arrays.copyOfRange(holidays, 1, holidays.length)).map(Moments::valueOf).toArray(Date[]::new));
        }
        return workday_intl(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday_intl(CharSequence startDate, CharSequence days, Date... holidays) {
        return workday_intl(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday_intl(Date startDate, CharSequence days, Date... holidays) {
        return workday_intl(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday_intl(Date startDate, Number days, Number... holidays) {
        return workday_intl(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday_intl(Number startDate, Number days, Date... holidays) {
        return workday_intl(Moments.valueOf(startDate), Formulas.valueOf(days), holidays == null ? new Date[0] : Arrays.stream(holidays).map(Moments::valueOf).toArray(Date[]::new));
    }

    public static Moment workday_intl(Date startDate, Number days, Date... holidays) {
        return workday_intl(startDate, days, 1, holidays);
    }

    public static Moment workday_intl(Date startDate, Number days, Number weekend, Date... holidays) {
        return workday_intl(startDate, days, weekend.toString(), holidays);
    }

    public static Moment workday_intl(Date startDate, Number days, Number weekend) {
        return workday_intl(startDate, days, weekend, new Date[0]);
    }

    public static Moment workday_intl(Date startDate, Number days, CharSequence weekend, Date... holidays) {
        if (startDate == null) {
            throw new UniversalException("startDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (days == null) {
            throw new UniversalException("days", 1, UniversalException.ErrorType.VALUE);
        }
        if (weekend == null) {
            throw new UniversalException("weekend", 2, UniversalException.ErrorType.VALUE);
        }

        // TODO support weekend string values (@see https://support.office.com/en-us/article/networkdays-intl-function-a9b26239-4f20-46a1-9ab8-4e925bfd5e28?ui=en-US&rs=en-US&ad=US)
        // Returns the number of whole working days between start_date and end_date. Working days exclude weekends and any dates identified in holidays.

        final Predicate<Integer> isDayOfWeekWeekendPredicate;

        if (weekend.length() == 7) {
            isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                @Override
                public boolean test(Integer dayOfWeek) {
                    final boolean monday = Character.getNumericValue(weekend.charAt(0)) == 1;
                    final boolean tuesday = Character.getNumericValue(weekend.charAt(1)) == 1;
                    final boolean wednesday = Character.getNumericValue(weekend.charAt(2)) == 1;
                    final boolean thursday = Character.getNumericValue(weekend.charAt(3)) == 1;
                    final boolean friday = Character.getNumericValue(weekend.charAt(4)) == 1;
                    final boolean caturday = Character.getNumericValue(weekend.charAt(5)) == 1;
                    final boolean sunday = Character.getNumericValue(weekend.charAt(6)) == 1;

                    switch (dayOfWeek) {
                        case Calendar.SUNDAY:
                            return sunday;
                        case Calendar.MONDAY:
                            return monday;
                        case Calendar.TUESDAY:
                            return tuesday;
                        case Calendar.WEDNESDAY:
                            return wednesday;
                        case Calendar.THURSDAY:
                            return thursday;
                        case Calendar.FRIDAY:
                            return friday;
                        case Calendar.SATURDAY:
                            return caturday;
                        default:
                            throw new UnsupportedOperationException();
                    }
                }
            };
        } else {

            switch (Formulas.valueOf(weekend.toString()).intValue()) {
                case 1:
                    // Saturday, Sunday
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
                        }
                    };
                    break;
                case 2:
                    // Sunday, Monday
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.SUNDAY || dayOfWeek == Calendar.MONDAY;
                        }
                    };
                    break;
                case 3:
                    // Monday, Tuesday
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.MONDAY || dayOfWeek == Calendar.TUESDAY;
                        }
                    };
                    break;
                case 4:
                    // Tuesday, Wednesday
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.TUESDAY || dayOfWeek == Calendar.WEDNESDAY;
                        }
                    };
                    break;
                case 5:
                    // Wednesday, Thursday
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.WEDNESDAY || dayOfWeek == Calendar.THURSDAY;
                        }
                    };
                    break;
                case 6:
                    // Thursday, Friday
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.THURSDAY || dayOfWeek == Calendar.FRIDAY;
                        }
                    };
                    break;
                case 7:
                    // Friday, Saturday
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.FRIDAY || dayOfWeek == Calendar.SATURDAY;
                        }
                    };
                    break;
                case 8:
                    throw new UnsupportedOperationException();
                case 9:
                    throw new UnsupportedOperationException();
                case 10:
                    throw new UnsupportedOperationException();
                case 11:
                    // Sunday only
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.SUNDAY;
                        }
                    };
                    break;
                case 12:
                    // Monday only
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.MONDAY;
                        }
                    };
                    break;
                case 13:
                    // Tuesday only
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.TUESDAY;
                        }
                    };
                    break;
                case 14:
                    // Wednesday only
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.WEDNESDAY;
                        }
                    };
                    break;
                case 15:
                    // Thursday only
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.THURSDAY;
                        }
                    };
                    break;
                case 16:
                    // Friday only
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.FRIDAY;
                        }
                    };
                    break;
                case 17:
                    // Saturday only
                    isDayOfWeekWeekendPredicate = new Predicate<Integer>() {
                        @Override
                        public boolean test(Integer dayOfWeek) {
                            return dayOfWeek == Calendar.SATURDAY;
                        }
                    };
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
        }
        boolean negative = days.intValue() < 0;
        int result = 0;
        int d = 0;
        while (d < days.intValue()) {
            result++;
            final Moment day;
            if (negative) {
                day = Moments.valueOf(startDate).subtract(Formulas.valueOf(result));
            } else {
                day = Moments.valueOf(startDate).add(Formulas.valueOf(result));
            }
            if (isDayOfWeekWeekendPredicate.test(day.weekday().intValue())) {
                // d -= negative ? 1 : -1;
                d--;
            } else if (Arrays.stream(holidays).anyMatch(new Predicate<Date>() {
                @Override
                public boolean test(Date holiday) {
                    return Moments.valueOf(holiday).dayOfMonth().intValue() == day.dayOfMonth().intValue()
                            && Moments.valueOf(holiday).month().intValue() == day.month().intValue()
                            && Moments.valueOf(holiday).year().intValue() == day.year().intValue();
                }
            })) {
                // d -= negative ? 1 : -1;
                d--;
            }
            d++;
        }
        return Moments.valueOf(startDate).add(Formulas.valueOf(result));
    }

    public static FormulaDecimal year() {
        return Formulas.valueOf(now().year());
    }

    public static FormulaDecimal year(CharSequence date) {
        if (date == null) {
            throw new UniversalException("date", 0, UniversalException.ErrorType.VALUE);
        }

        if (date.toString().contains("/") || date.toString().contains("-") || date.toString().contains(":")) {
            return year(Moments.valueOf(date));
        } else {
            return year((Number) Formulas.valueOf(date.toString()));
        }
    }

    public static FormulaDecimal year(Number date) {
        if (date == null) {
            throw new UniversalException("date", 0, UniversalException.ErrorType.VALUE);
        }

        if (Formulas.valueOf(date).compareTo(BigDecimal.ZERO) == 0) {
            return Formulas.valueOf(0);
        } else if (Formulas.valueOf(date).compareTo(BigDecimal.ONE) < 0) {
            return Formulas.valueOf(60).multiply(Formulas.valueOf(date));
        } else {
            return year(Moments.valueOf(date));
        }
    }

    public static FormulaDecimal year(Date date) {
        return year(Moment.valueOf(date));
    }

    public static FormulaDecimal year(Moment date) {
        return Formulas.valueOf(Moment.valueOf(date).year());
    }

    public static FormulaDecimal yearfrac(Date startDate, Date endDate) {
        return yearfrac(startDate, endDate, 0);
    }

    public static FormulaDecimal yearfrac(Number startDate, Number endDate) {
        return yearfrac(Moments.valueOf(startDate), Moments.valueOf(endDate), 0);
    }

    public static FormulaDecimal yearfrac(CharSequence startDate, CharSequence endDate) {
        return yearfrac(Moments.valueOf(startDate), Moments.valueOf(endDate), 0);
    }

    public static FormulaDecimal yearfrac(Number startDate, Number endDate, Number basis) {
        return yearfrac(Moments.valueOf(startDate), Moments.valueOf(endDate), basis);
    }

    public static FormulaDecimal yearfrac(CharSequence startDate, CharSequence endDate, Number basis) {
        return yearfrac(Moments.valueOf(startDate), Moments.valueOf(endDate), basis);
    }

    public static FormulaDecimal yearfrac(Date startDate, Date endDate, Number basis) {
        if (startDate == null) {
            throw new UniversalException("startDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (endDate == null) {
            throw new UniversalException("endDate", 0, UniversalException.ErrorType.VALUE);
        }

        // YEARFRAC calculates the fraction of the year represented by the number of whole days between two dates (the start_date and the end_date).
        // For instance, you can use YEARFRAC to identify the proportion of a whole year's benefits, or obligations to assign to a specific term.

        int sd = Moments.valueOf(startDate).dayOfMonth().intValue();
        int sm = Moments.valueOf(startDate).month().intValue() + 1;
        int sy = Moments.valueOf(startDate).year().intValue();
        int ed = Moments.valueOf(endDate).dayOfMonth().intValue();
        int em = Moments.valueOf(endDate).month().intValue() + 1;
        int ey = Moments.valueOf(endDate).year().intValue();

        switch (basis.intValue()) {
            case 0:
                // US (NASD) 30/360
                if (sd == 31 && ed == 31) {
                    sd = 30;
                    ed = 30;
                } else if (sd == 31) {
                    sd = 30;
                } else if (sd == 30 && ed == 31) {
                    ed = 30;
                }
                // ((ed + em * 30 + ey * 360) - (sd + sm * 30 + sy * 360)) / 360;
                return Formulas.valueOf(ed).add(Formulas.valueOf(em).multiply(Formulas.valueOf(30))).add(Formulas.valueOf(ey).multiply(Formulas.valueOf(360)))
                        .subtract(Formulas.valueOf(sd).add(Formulas.valueOf(sm).multiply(Formulas.valueOf(30))).add(Formulas.valueOf(sy).multiply(Formulas.valueOf(360))))
                        .divide(Formulas.valueOf(360));
            case 1:
                // Actual/actual
                int ylength = 365;
                if (sy == ey || ((sy + 1) == ey) && ((sm > em) || ((sm == em) && (sd >= ed)))) {
                    if ((sy == ey && isLeapYear(sy)) || feb29Between(startDate, endDate) || (em == 1 && ed == 29)) {
                        ylength = 366;
                    }
                    return days(endDate, startDate).divide(Formulas.valueOf(ylength));
                }
                int years = (ey - sy) + 1;
                // TODO use days func
                long days = (new Date(ey + 1, 0, 1).getTime() - new Date(sy, 0, 1).getTime()) / 1000 / 60 / 60 / 24;
                FormulaDecimal average = Formulas.valueOf(days).divide(Formulas.valueOf(years));
                return days(endDate, startDate).divide(average);
            case 2:
                // Actual/360
                return days(endDate, startDate).divide(Formulas.valueOf(360));
//                return Formulas.ceil((endDate.getTime() - startDate.getTime()) / 1000 / 60 / 60 / 24).divide(Formulas.valueOf(360));
            case 3:
                // Actual/365
                return days(endDate, startDate).divide(Formulas.valueOf(365));
//                return Formulas.ceil((endDate.getTime() - startDate.getTime()) / 1000 / 60 / 60 / 24).divide(Formulas.valueOf(365));
            case 4:
                // European 30/360
                // ((ed + em * 30 + ey * 360) - (sd + sm * 30 + sy * 360)) / 360;
                return Formulas.valueOf(ed).add(Formulas.valueOf(em).multiply(Formulas.valueOf(30))).add(Formulas.valueOf(ey).multiply(Formulas.valueOf(360)))
                        .subtract(Formulas.valueOf(sd).add(Formulas.valueOf(sm).multiply(Formulas.valueOf(30))).add(Formulas.valueOf(sy).multiply(Formulas.valueOf(360))))
                        .divide(Formulas.valueOf(360));
            default:
                throw new UniversalException("basis", 2, UniversalException.ErrorType.VALUE);
        }
    }

    public static FormulaDecimal yearfrac2(Date startDate, Date endDate, Number basis) {
        if (startDate == null) {
            throw new UniversalException("startDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (endDate == null) {
            throw new UniversalException("endDate", 0, UniversalException.ErrorType.VALUE);
        }

        // YEARFRAC calculates the fraction of the year represented by the number of whole days between two dates (the start_date and the end_date).
        // For instance, you can use YEARFRAC to identify the proportion of a whole year's benefits, or obligations to assign to a specific term.

        int sd = Moments.valueOf(startDate).dayOfMonth().intValue();
        int sm = Moments.valueOf(startDate).month().intValue() + 1;
        int sy = Moments.valueOf(startDate).year().intValue();
        int ed = Moments.valueOf(endDate).dayOfMonth().intValue();
        int em = Moments.valueOf(endDate).month().intValue() + 1;
        int ey = Moments.valueOf(endDate).year().intValue();

        switch (basis.intValue()) {
            case 0:
                // US (NASD) 30/360
                if (sd == 31 && ed == 31) {
                    sd = 30;
                    ed = 30;
                } else if (sd == 31) {
                    sd = 30;
                } else if (sd == 30 && ed == 31) {
                    ed = 30;
                }
                // ((ed + em * 30 + ey * 360) - (sd + sm * 30 + sy * 360)) / 360;
                return Formulas.valueOf(ed).add(Formulas.valueOf(em).multiply(Formulas.valueOf(30))).add(Formulas.valueOf(ey).multiply(Formulas.valueOf(360)))
                        .subtract(Formulas.valueOf(sd).add(Formulas.valueOf(sm).multiply(Formulas.valueOf(30))).add(Formulas.valueOf(sy).multiply(Formulas.valueOf(360))))
                        .divide(Formulas.valueOf(360));
            case 1:
                // Actual/actual
                int ylength = 365;
                if (sy == ey || ((sy + 1) == ey) && ((sm > em) || ((sm == em) && (sd >= ed)))) {
                    if ((sy == ey && isLeapYear(sy)) || feb29Between(startDate, endDate) || (em == 1 && ed == 29)) {
                        ylength = 366;
                    }
                    return days(endDate, startDate).divide(Formulas.valueOf(ylength));
                }
                int years = (ey - sy) + 1;
                // TODO use days func
                long days = (new Date(ey + 1, 0, 1).getTime() - new Date(sy, 0, 1).getTime()) / 1000 / 60 / 60 / 24;
                FormulaDecimal average = Formulas.valueOf(days).divide(Formulas.valueOf(years));
                return days(endDate, startDate).add(Formulas.valueOf(1)).divide(average);
            case 2:
                // Actual/360
                return days(endDate, startDate).divide(Formulas.valueOf(360));
//                return Formulas.ceil((endDate.getTime() - startDate.getTime()) / 1000 / 60 / 60 / 24).divide(Formulas.valueOf(360));
            case 3:
                // Actual/365
                return days(endDate, startDate).divide(Formulas.valueOf(365));
//                return Formulas.ceil((endDate.getTime() - startDate.getTime()) / 1000 / 60 / 60 / 24).divide(Formulas.valueOf(365));
            case 4:
                // European 30/360
                // ((ed + em * 30 + ey * 360) - (sd + sm * 30 + sy * 360)) / 360;
                return Formulas.valueOf(ed).add(Formulas.valueOf(em).multiply(Formulas.valueOf(30))).add(Formulas.valueOf(ey).multiply(Formulas.valueOf(360)))
                        .subtract(Formulas.valueOf(sd).add(Formulas.valueOf(sm).multiply(Formulas.valueOf(30))).add(Formulas.valueOf(sy).multiply(Formulas.valueOf(360))))
                        .divide(Formulas.valueOf(360));
            default:
                throw new UniversalException("basis", 2, UniversalException.ErrorType.VALUE);
        }
    }

    public static boolean feb29Between(Date date1, Date date2) {
        return feb29Between().test(date1, date2);
    }

    protected static BiPredicate<Date, Date> feb29Between() {
        return new BiPredicate<Date, Date>() {
            @Override
            public boolean test(Date date1, Date date2) {
                int year1 = Moments.valueOf(date1).year().intValue();
                Date mar1year1 = Moment.valueOf(year1, 2, 1);
                if (isLeapYear(year1) && date1.getTime() < mar1year1.getTime() && date2.getTime() >= mar1year1.getTime()) {
                    return true;
                }
                int year2 = Moments.valueOf(date2).year().intValue();
                Date mar1year2 = Moment.valueOf(year2, 2, 1);
                return (isLeapYear(year2) && date2.getTime() >= mar1year2.getTime() && date1.getTime() < mar1year2.getTime());
            }
        };
    }

    protected static boolean isLeapYear(int year) {
        return Moment.valueOf(year, 1, 29).month().intValue() == 1;
    }

    public static Moment timenow() {
        return new Moment();
    }

    public static Moment datetimevalue(CharSequence date) {
        if (date == null) {
            return Moment.EMPTY;
        }
        return Moment.valueOf(date);
    }

    public static Moment datetimevalue(Date date) {
        if (date == null) {
            return Moment.EMPTY;
        }
        return datetimevalue(Moment.valueOf(date));
    }

    public static Moment datetimevalue(Moment date) {
        if (date == null) {
            return Moment.EMPTY;
        }
        return Moment.valueOf(date);
    }

    public static Moment datetimevalue(Number date) {
        if (date == null) {
            return Moment.EMPTY;
        }
        return Moment.valueOf(date.longValue());
    }

    public static FormulaDecimal week() {
        return Formulas.valueOf(now().week());
    }

    public static FormulaDecimal week(CharSequence date) {
        return week(Moments.valueOf(date));
    }

    public static FormulaDecimal week(Number date) {
        return week(Moments.valueOf(date));
    }

    public static FormulaDecimal week(Date date) {
        return week(Moment.valueOf(date));
    }

    public static FormulaDecimal week(Moment date) {
        return Formulas.valueOf(Moment.valueOf(date).week());
    }
}
