package io.onsense.universe;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * @author Koen Rooijmans
 */
public class Moment extends Date {

    public static final Moment EMPTY = Moment.valueOf(1900, 1, 1);

    public Moment() {
        // default constructor
    }

    public Moment(long date) {
        super(date);
    }

    public Moment(Date date) {
        super(date == null ? EMPTY.getTime() : date.getTime());
    }

    public static Moment valueOf(Date date) {
        if (date == null) {
            return EMPTY;
        }
        if (date instanceof Moment) {
            return (Moment) date;
        }
        return new Moment(date);
    }

    public static Moment valueOf(long date) {
        return new Moment(date);
    }

    public static Moment valueOf(CharSequence date) {
        if (date == null || date.length() == 0) {
            return EMPTY;
        }
        final String dateString;
        try {
            dateString = date.toString();
        } catch (IndexOutOfBoundsException e) {
            throw new UniversalException("date", 0, UniversalException.ErrorType.VALUE, e);
        }
        if (dateString.contains("-") && dateString.split("-").length == 2) {
            final Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            return valueOf(dateString + "-" + cal.get(Calendar.YEAR));
        }
        return new Moment(parseDate(date));
    }

    protected static Date parseDate(CharSequence date) {
        if (date == null || date.length() == 0) {
            return EMPTY;
        }
        final String dateString;
        try {
            dateString = date.toString();
        } catch (IndexOutOfBoundsException e) {
            throw new UniversalException("date", 0, UniversalException.ErrorType.VALUE, e);
        }
        final List<Function<CharSequence, Date>> strategies = Arrays.asList(
                new Function<CharSequence, Date>() {

                    @Override
                    public Date apply(CharSequence charSequence) {
                        return new Moment(new Date(Date.parse(dateString)));
                    }
                }, new Function<CharSequence, Date>() {

                    @Override
                    public Date apply(CharSequence charSequence) {
                        try {
                            return DateFormat.getTimeInstance().parse(dateString);
                        } catch (ParseException e) {
                            throw new IllegalArgumentException(e);
                        }
                    }
                }, new Function<CharSequence, Date>() {

                    @Override
                    public Date apply(CharSequence charSequence) {
                        try {
                            return DateFormat.getDateInstance().parse(dateString);
                        } catch (ParseException e) {
                            throw new IllegalArgumentException(e);
                        }
                    }
                }, new Function<CharSequence, Date>() {

                    @Override
                    public Date apply(CharSequence charSequence) {
                        try {
                            return DateFormat.getDateTimeInstance().parse(dateString);
                        } catch (ParseException e) {
                            throw new IllegalArgumentException(e);
                        }
                    }
                }, new Function<CharSequence, Date>() {

                    @Override
                    public Date apply(CharSequence charSequence) {
                        try {
                            return DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL).parse(dateString);
                        } catch (ParseException e) {
                            throw new IllegalArgumentException(e);
                        }
                    }
                }, new Function<CharSequence, Date>() {

                    @Override
                    public Date apply(CharSequence charSequence) {
                        try {
                            return DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).parse(dateString);
                        } catch (ParseException e) {
                            throw new IllegalArgumentException(e);
                        }
                    }
                }, new Function<CharSequence, Date>() {

                    @Override
                    public Date apply(CharSequence charSequence) {
                        try {
                            return DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM).parse(dateString);
                        } catch (ParseException e) {
                            throw new IllegalArgumentException(e);
                        }
                    }
                }, new Function<CharSequence, Date>() {

                    @Override
                    public Date apply(CharSequence charSequence) {
                        try {
                            return DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).parse(dateString);
                        } catch (ParseException e) {
                            throw new IllegalArgumentException(e);
                        }
                    }
                }, new Function<CharSequence, Date>() {

                    @Override
                    public Date apply(CharSequence charSequence) {
                        try {
                            return DateFormat.getTimeInstance(DateFormat.FULL).parse(dateString);
                        } catch (ParseException e) {
                            throw new IllegalArgumentException(e);
                        }
                    }
                }, new Function<CharSequence, Date>() {

                    @Override
                    public Date apply(CharSequence charSequence) {
                        try {
                            return DateFormat.getTimeInstance(DateFormat.LONG).parse(dateString);
                        } catch (ParseException e) {
                            throw new IllegalArgumentException(e);
                        }
                    }
                }, new Function<CharSequence, Date>() {

                    @Override
                    public Date apply(CharSequence charSequence) {
                        try {
                            return DateFormat.getTimeInstance(DateFormat.MEDIUM).parse(dateString);
                        } catch (ParseException e) {
                            throw new IllegalArgumentException(e);
                        }
                    }
                }, new Function<CharSequence, Date>() {

                    @Override
                    public Date apply(CharSequence charSequence) {
                        try {
                            return DateFormat.getTimeInstance(DateFormat.SHORT).parse(dateString);
                        } catch (ParseException e) {
                            throw new IllegalArgumentException(e);
                        }
                    }
                }, new Function<CharSequence, Date>() {

                    @Override
                    public Date apply(CharSequence charSequence) {
                        try {
                            return DateFormat.getDateInstance(DateFormat.FULL).parse(dateString);
                        } catch (ParseException e) {
                            throw new IllegalArgumentException(e);
                        }
                    }
                }, new Function<CharSequence, Date>() {

                    @Override
                    public Date apply(CharSequence charSequence) {
                        try {
                            return DateFormat.getDateInstance(DateFormat.LONG).parse(dateString);
                        } catch (ParseException e) {
                            throw new IllegalArgumentException(e);
                        }
                    }
                }, new Function<CharSequence, Date>() {

                    @Override
                    public Date apply(CharSequence charSequence) {
                        try {
                            return DateFormat.getDateInstance(DateFormat.MEDIUM).parse(dateString);
                        } catch (ParseException e) {
                            throw new IllegalArgumentException(e);
                        }
                    }
                }, new Function<CharSequence, Date>() {

                    @Override
                    public Date apply(CharSequence charSequence) {
                        try {
                            return DateFormat.getDateInstance(DateFormat.SHORT).parse(dateString);
                        } catch (ParseException e) {
                            throw new IllegalArgumentException(e);
                        }
                    }
                }
        );

        for (Function<CharSequence, Date> strategy : strategies) {
            try {
                return strategy.apply(date);
            } catch (IllegalArgumentException e) {
                // no-op
            }
        }

        throw new UniversalException(UniversalException.ErrorType.NA);
    }

    public static Moment valueOf(int year, int month, int dayOfMonth) {
        // NOTE: Oracle's awesome spec-boyz said months start at 0, thus we normalize it here.
        // @see https://docs.oracle.com/javase/8/docs/api/java/util/Calendar.html#MONTH
        return new Moment(new GregorianCalendar(year, month - 1, dayOfMonth).getTime());
    }

    public static Moment valueOf(int year, int month, int dayOfMonth, int hourOfDay, int minute) {
        // NOTE: Oracle's awesome spec-boyz said months start at 0, thus we normalize it here.
        // @see https://docs.oracle.com/javase/8/docs/api/java/util/Calendar.html#MONTH
        return new Moment(new GregorianCalendar(year, month - 1, dayOfMonth, hourOfDay, minute).getTime());
    }

    public static Moment valueOf(int year, int month, int dayOfMonth, int hourOfDay, int minute, int second) {
        // NOTE: Oracle's awesome spec-boyz said months start at 0, thus we normalize it here.
        // @see https://docs.oracle.com/javase/8/docs/api/java/util/Calendar.html#MONTH
        return new Moment(new GregorianCalendar(year, month - 1, dayOfMonth, hourOfDay, minute, second).getTime());
    }

    public Number year() {
        final Calendar cal = getCalendar();
        return cal.get(Calendar.YEAR);
    }

    public Number month() {
        final Calendar cal = getCalendar();
        // NOTE: Oracle's awesome spec-boyz said months start at 0, thus we normalize it here.
        // @see https://docs.oracle.com/javase/8/docs/api/java/util/Calendar.html#MONTH
        return cal.get(Calendar.MONTH) + 1;
    }

    public Number week() {
        final Calendar cal = getCalendar();
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    public Number weeknum() {
        final Calendar cal = getCalendar();
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    public Number isoweeknum() {
        final Calendar cal = getCalendar();
        cal.setMinimalDaysInFirstWeek(4);
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    public Number weeknum(int firstDayOfWeek) {
        final Calendar cal = getCalendar();
        cal.setFirstDayOfWeek(firstDayOfWeek);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    public Number day() {
        final Calendar cal = getCalendar();
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public Number dayOfMonth() {
        final Calendar cal = getCalendar();
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public Number workday() {
        throw new UnsupportedOperationException();
    }

    public Number weekday() {
        final Calendar cal = getCalendar();
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    public Number weekday(int firstDayOfWeek) {
        final Calendar cal = getCalendar();
        cal.setFirstDayOfWeek(firstDayOfWeek);
        return cal.get(Calendar.DAY_OF_WEEK) - (firstDayOfWeek - 1);
    }

    public Number hour() {
        final Calendar cal = getCalendar();
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    public Number minute() {
        final Calendar cal = getCalendar();
        return cal.get(Calendar.MINUTE);
    }

    public Number second() {
        final Calendar cal = getCalendar();
        return cal.get(Calendar.SECOND);
    }

    public Moment subtract(FormulaDecimal subtrahend) {
        final Calendar cal = getCalendar();
        cal.add(Calendar.DATE, -Formulas.valueOf(subtrahend).intValue());
        final FormulaDecimal fractionalPart = Formulas.valueOf(subtrahend).remainder(new FormulaDecimal(BigDecimal.ONE));
        final BigDecimal millis = new BigDecimal(TimeUnit.DAYS.toMillis(1)).multiply(fractionalPart.asBigDecimal());
        cal.add(Calendar.MILLISECOND, -millis.intValue());
        return new Moment(cal.getTime());
    }

    public Moment add(FormulaDecimal augend) {
        final Calendar cal = getCalendar();
        cal.add(Calendar.DATE, Formulas.valueOf(augend).intValue());
        final FormulaDecimal fractionalPart = Formulas.valueOf(augend).remainder(new FormulaDecimal(BigDecimal.ONE));
        final BigDecimal millis = new BigDecimal(TimeUnit.DAYS.toMillis(1)).multiply(fractionalPart.asBigDecimal());
        cal.add(Calendar.MILLISECOND, millis.intValue());
        return new Moment(cal.getTime());
    }

    public Calendar getCalendar() {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(this);
        return cal;
    }

    public Logical gt(Moment other) {
        return new Logical(this.compareTo(other) == 1);
    }

    public Logical gte(Moment other) {
        return new Logical(this.compareTo(other) >= 0);
    }

    public Logical lt(Moment other) {
        return new Logical(this.compareTo(other) == -1);
    }

    public Logical lte(Moment other) {
        return new Logical(this.compareTo(other) <= 0);
    }

    public Logical eq(Moment other) {
        return new Logical(this.compareTo(other) == 0);
    }

    public Logical neq(Moment other) {
        return new Logical(this.compareTo(other) != 0);
    }

    public Logical gt(Date other) {
        return new Logical(this.compareTo(other) == 1);
    }

    public Logical gte(Date other) {
        return new Logical(this.compareTo(other) >= 0);
    }

    public Logical lt(Date other) {
        return new Logical(this.compareTo(other) == -1);
    }

    public Logical lte(Date other) {
        return new Logical(this.compareTo(other) <= 0);
    }

    public Logical eq(Date other) {
        return new Logical(this.compareTo(other) == 0);
    }

    public Logical neq(Date other) {
        return new Logical(this.compareTo(other) != 0);
    }
}
