package io.onsense.universe;

import cern.jet.math.Bessel;
import ch.obermuhlner.math.big.BigDecimalMath;
import io.onsense.universe.convert.MetricConvert;
import org.apache.commons.math3.special.Erf;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;

/**
 * @author Koen Rooijmans
 */
public class Formulas {

    private static final long PARITY_MASK = 0xFFFFFFFFFFFFFFFEL;

    public static FormulaDecimal valueOfObject(Object number) {
        if (number == null) {
            return FormulaDecimal.valueOf(0);
        }
        if (number instanceof CharSequence) {
            return Formulas.valueOf(number.toString());
        } else if (number instanceof Number) {
            return Formulas.valueOf((Number) number);
        } else if (number instanceof Date) {
            return Moments.datevalue(Moments.valueOf((Date) number));
        } else if (number instanceof Boolean) {
            return (Boolean) number ? FormulaDecimal.ONE : FormulaDecimal.ZERO;
        } else if (number instanceof Logical) {
            return ((Logical) number).booleanValue() ? FormulaDecimal.ONE : FormulaDecimal.ZERO;
        } else {
            throw new UniversalException(UniversalException.ErrorType.NUM);
        }
    }

    public static FormulaDecimal valueOf(Number number) {
        if (number == null) {
            return FormulaDecimal.valueOf(0);
        }
        if (number instanceof Integer) {
            return FormulaDecimal.valueOf((long) (int) number);
        } else if (number instanceof Long) {
            return FormulaDecimal.valueOf((long) number);
        } else if (number instanceof Short) {
            return FormulaDecimal.valueOf((long) (short) number);
        } else if (number instanceof Float) {
            if (Float.isNaN((Float) number)) {
                throw new UniversalException(UniversalException.ErrorType.NA);
            } else if (Float.isInfinite((Float) number)) {
                throw new UniversalException(UniversalException.ErrorType.NA);
            } else {
                return FormulaDecimal.valueOf((double) (float) number);
            }
        } else if (number instanceof Double) {
            if (Double.isNaN((Double) number)) {
                throw new UniversalException(UniversalException.ErrorType.NA);
            } else if (Double.isInfinite((Double) number)) {
                throw new UniversalException(UniversalException.ErrorType.NA);
            } else {
                return FormulaDecimal.valueOf((double) number);
            }
        } else if (number instanceof BigDecimal) {
            return new FormulaDecimal((BigDecimal) number);
        } else if (number instanceof BigInteger) {
            return new FormulaDecimal((BigInteger) number);
        } else if (number instanceof FormulaDecimal) {
            return (FormulaDecimal) number;
        } else if (number instanceof Byte) {
            return FormulaDecimal.valueOf((long) (byte) number);
        } else {
            throw new UniversalException(UniversalException.ErrorType.NUM);
        }
    }

    public static FormulaDecimal valueOf(Date number) {
        if (number == null) {
            return FormulaDecimal.valueOf(0);
        }
        return Moments.datevalue(Moments.valueOf(number));
    }

    public static FormulaDecimal valueOf(CharSequence number) {
        if (number == null) {
            return FormulaDecimal.valueOf(0);
        }
        try {
            return valueOf(ExpressionString.valueOf(number).toString());
        } catch (IndexOutOfBoundsException e) {
            throw new UniversalException(number, "number", 0, UniversalException.ErrorType.VALUE, e);
        }
    }

    public static FormulaDecimal valueOf(String number) {
        if (number == null || number.isEmpty()) {
            return FormulaDecimal.valueOf(0);
        } else if (number.toLowerCase(Locale.ENGLISH).equals(Boolean.FALSE.toString().toLowerCase(Locale.ENGLISH))) {
            return FormulaDecimal.ZERO;
        } else if (number.toLowerCase(Locale.ENGLISH).equals(Boolean.TRUE.toString().toLowerCase(Locale.ENGLISH))) {
            return FormulaDecimal.ONE;
        } else if (number.contains("$")) {
            return valueOf(number.replace("$", ""));
        } else if (number.contains(",") || number.contains(".")) {
            if (countOccurrences(number, ',') > 1) {
                return valueOf(number.replace(",", ""));
            } else if (countOccurrences(number, '.') > 1) {
                return valueOf(number.replace(".", "").replace(",", "."));
            } else if (countOccurrences(number, ',') == 1 && countOccurrences(number, '.') == 1) {
                if (number.indexOf(',') > number.indexOf('.')) {
                    return valueOf(number.replace(".", "").replace(",", "."));
                } else {
                    return valueOf(number.replace(",", ""));
                }
            }
        }
        try {
            return new FormulaDecimal(number, MathContext.DECIMAL128);
        } catch (NumberFormatException e) {
            throw new UniversalException(number, "number", 0, UniversalException.ErrorType.VALUE, e);
        }
    }

    protected static int countOccurrences(@Nullable CharSequence haystack, char needle) {
        if (haystack == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle) {
                count++;
            }
        }
        return count;
    }

    public static FormulaDecimal toInt(String number) {
        return toInt(Formulas.valueOf(number));
    }

    public static FormulaDecimal toInt(Number number) {
        // Rounds a number down to the nearest integer.
        return Formulas.valueOf(floor(number).intValue());
    }

    public static FormulaDecimal besseli(Number x, Number n) {
        if (n.intValue() == 0) {
            return Formulas.valueOf(Bessel.i0(x.doubleValue()));
        } else if (n.intValue() == 1) {
            return Formulas.valueOf(Bessel.i1(x.doubleValue()));
        }
        return new FormulaDecimal(Bessi.bessi(n.intValue(), Formulas.valueOf(x).asBigDecimal()));
    }

    public static FormulaDecimal besselj(Number x, Number n) {
        return Formulas.valueOf(Bessel.jn(n.intValue(), x.doubleValue()));
    }

    public static FormulaDecimal besselk(Number x, Number n) {
        return Formulas.valueOf(Bessel.kn(n.intValue(), x.doubleValue()));
    }

    public static FormulaDecimal bessely(Number x, Number n) {
        return Formulas.valueOf(Bessel.yn(n.intValue(), x.doubleValue()));
    }

    public static FormulaDecimal bin2dec(Number value) {
        return bin2dec(value.toString());
    }

    public static FormulaDecimal bin2dec(CharSequence value) {
        if (value.length() > 10) {
            throw new IllegalArgumentException();
        } else if (value.length() < 10) {
            return bin2dec(Expressions.repeat("0", 10 - value.length()) + value.toString());
        }
        int number = 0;
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == '0') {
                continue;
            }
            number += Math.pow(2, (value.length() - 1 - i));
        }
        return value.charAt(0) == '0' ? Formulas.valueOf(number) : Formulas.valueOf(number).negate();
    }

    public static ExpressionString bin2hex(Number value) {
        return bin2hex(value.toString());
    }

    public static ExpressionString bin2hex(CharSequence value) {
        return bin2hex(value, null);
    }

    public static ExpressionString bin2hex(Number value, Number places) {
        return bin2hex(value.toString(), places);
    }

    public static ExpressionString bin2hex(CharSequence number, @Nullable Number places) {
        if (number.length() == 10 && number.charAt(0) == '1') {
            if (places == null) {
                return ExpressionString.valueOf(new BigInteger(number.subSequence(1, number.length()).toString(), 2).add(BigInteger.valueOf(1099511627264L)).toString(16));
            } else {
                return ExpressionString.valueOf(String.format("%0" + places.intValue() + "x", new BigInteger(number.subSequence(1, number.length()).toString(), 2).add(BigInteger.valueOf(1099511627264L))));
            }
        } else {
            if (places == null) {
                return ExpressionString.valueOf(new BigInteger(number.toString(), 2).toString(16));
            } else {
                return ExpressionString.valueOf(String.format("%0" + places.intValue() + "x", new BigInteger(number.toString(), 2)));
            }
        }
    }

    public static ExpressionString bin2oct(Number value) {
        return bin2oct(value.toString());
    }

    public static ExpressionString bin2oct(CharSequence value) {
        return bin2oct(value, null);
    }

    public static ExpressionString bin2oct(Number value, Number places) {
        return bin2oct(value.toString(), places);
    }

    public static ExpressionString bin2oct(CharSequence number, @Nullable Number places) {
        if (number.length() == 10 && number.charAt(0) == '1') {
            if (places == null) {
                return ExpressionString.valueOf(new BigInteger(number.subSequence(1, number.length()).toString(), 2).add(BigInteger.valueOf(1073741312)).toString(8));
            } else {
                return ExpressionString.valueOf(String.format("%0" + places.intValue() + "o", new BigInteger(number.subSequence(1, number.length()).toString(), 2).add(BigInteger.valueOf(1073741312))));
            }
        } else {
            if (places == null) {
                return ExpressionString.valueOf(new BigInteger(number.toString(), 2).toString(8));
            } else {
                return ExpressionString.valueOf(String.format("%0" + places.intValue() + "o", new BigInteger(number.toString(), 2)));
            }
        }
    }

    public static FormulaDecimal bitand(Number a, Number b) {
        return Formulas.valueOf(Formulas.valueOf(a).toBigIntegerExact().and(Formulas.valueOf(b).toBigIntegerExact()));
    }

    public static FormulaDecimal bitlshift(Number value, Number shiftAmount) {
        return Formulas.valueOf(Formulas.valueOf(value).toBigIntegerExact().shiftLeft(shiftAmount.intValue()));
    }

    public static FormulaDecimal bitor(Number a, Number b) {
        return Formulas.valueOf(Formulas.valueOf(a).toBigIntegerExact().or(Formulas.valueOf(b).toBigIntegerExact()));
    }

    public static FormulaDecimal bitrshift(Number value, Number shiftAmount) {
        return Formulas.valueOf(Formulas.valueOf(value).toBigIntegerExact().shiftRight(shiftAmount.intValue()));
    }

    public static FormulaDecimal bitxor(Number a, Number b) {
        return Formulas.valueOf(Formulas.valueOf(a).toBigIntegerExact().xor(Formulas.valueOf(b).toBigIntegerExact()));
    }

    public static ExpressionString complex(Number real, Number imaginary) {
        return complex(real, imaginary, "i");
    }

    public static ExpressionString complex(CharSequence real, CharSequence imaginary) {
        return complex(Formulas.valueOf(real.toString()), Formulas.valueOf(imaginary.toString()), "i");
    }

    public static ExpressionString complex(CharSequence real, Number imaginary) {
        return complex(Formulas.valueOf(real.toString()), Formulas.valueOf(imaginary.toString()), "i");
    }

    public static ExpressionString complex(Number real, CharSequence imaginary) {
        return complex(Formulas.valueOf(real.toString()), Formulas.valueOf(imaginary.toString()), "i");
    }

    public static ExpressionString complex(CharSequence real, CharSequence imaginary, CharSequence suffix) {
        return complex(Formulas.valueOf(real.toString()), Formulas.valueOf(imaginary.toString()), suffix);
    }

    public static ExpressionString complex(CharSequence real, Number imaginary, CharSequence suffix) {
        return complex(Formulas.valueOf(real.toString()), Formulas.valueOf(imaginary.toString()), suffix);
    }

    public static ExpressionString complex(Number real, CharSequence imaginary, CharSequence suffix) {
        return complex(Formulas.valueOf(real.toString()), Formulas.valueOf(imaginary.toString()), suffix);
    }

    public static ExpressionString complex(Number real, Number imaginary, CharSequence suffix) {

        if (suffix.length() > 1 || (!(suffix.charAt(0) == 'i' || suffix.charAt(0) == 'j'))) {
            throw new UnsupportedOperationException();
        }

        if (Formulas.valueOf(real).compareTo(BigDecimal.ZERO) == 0 && Formulas.valueOf(imaginary).compareTo(BigDecimal.ZERO) == 0) {
            return ExpressionString.valueOf(Formulas.valueOf(0));
        } else if (Formulas.valueOf(real).compareTo(BigDecimal.ZERO) == 0) {
            return (Formulas.valueOf(imaginary).compareTo(BigDecimal.ONE) == 0) ? ExpressionString.valueOf(suffix) : ExpressionString.valueOf(imaginary.toString() + suffix);
        } else if (Formulas.valueOf(imaginary).compareTo(BigDecimal.ZERO) == 0) {
            return ExpressionString.valueOf(real.toString());
        } else {
            final String sign = Formulas.valueOf(imaginary).compareTo(BigDecimal.ZERO) > 0 ? "+" : "";
            return ExpressionString.valueOf(real.toString() + sign + ((Formulas.valueOf(imaginary).compareTo(BigDecimal.ONE) == 0) ? suffix : imaginary.toString() + suffix));
        }
    }

    public static FormulaDecimal combin(Number value, Number numberChosen) {
        // Returns the number of combinations for a given number of items. Use COMBIN to determine the total possible number of groups for a given number of items.
        if (Formulas.valueOf(value).compareTo(BigDecimal.ZERO) < 0
                || Formulas.valueOf(numberChosen).compareTo(BigDecimal.ZERO) < 0
                || Formulas.valueOf(value).compareTo(Formulas.valueOf(numberChosen).asBigDecimal()) < 0) {
            throw new IllegalArgumentException();
        } else {
            BigDecimal d = new BigDecimal(1);
            int minnk = Math.min(value.intValue() - numberChosen.intValue(), numberChosen.intValue());
            int maxnk = Math.max(value.intValue() - numberChosen.intValue(), numberChosen.intValue());
            for (int i = maxnk; i < value.intValue(); i++) {
                d = d.multiply(BigDecimal.valueOf(i + 1));
            }
            d = d.divide(factorial(minnk).asBigDecimal(), MathContext.DECIMAL128);
            return Formulas.valueOf(d);
        }
    }

    public static FormulaDecimal combina(Number value, Number numberChosen) {
        // Returns the number of combinations (with repetitions) for a given number of items.
        if (Formulas.valueOf(value).compareTo(BigDecimal.ZERO) == 0 &&
                Formulas.valueOf(numberChosen).compareTo(BigDecimal.ZERO) == 0) {
            return Formulas.valueOf(1);
        } else {
            return combin(value.intValue() + numberChosen.intValue() - 1, value.intValue() - 1);
        }
    }

    public static FormulaDecimal trunc(Number number) {
        return Formulas.valueOf(number.intValue());
    }

    public static FormulaDecimal trunc(Number number, Number numDigits) {
        // TODO test this.. (@see https://support.office.com/en-us/article/trunc-function-8b86a64c-3127-43db-ba14-aa5ceb292721)
        int sign = Formulas.valueOf(number).compareTo(BigDecimal.ZERO) > 0 ? 1 : -1;
        Formulas.valueOf(sign).multiply(floor(abs(number).multiply(power(10, numDigits)))).divide(power(10, numDigits));
        return Formulas.valueOf(number.intValue());
    }

    public static FormulaDecimal subtotal(Number functionNum, Number number, Number... numbers) {
        final int functionCode = functionNum.intValue();
        switch (functionCode) {
            case 1:
                return avg(number, numbers);
            case 2:
                return count(number, numbers);
            case 3:
                return counta(number, numbers);
            case 4:
                return max(number, numbers);
            case 5:
                return min(number, numbers);
            case 6:
                return product(number, numbers);
            case 7:
                throw new UnsupportedOperationException();
            case 8:
                throw new UnsupportedOperationException();
            case 9:
                return sum(number, numbers);
            case 10:
                throw new UnsupportedOperationException();
            case 11:
                throw new UnsupportedOperationException();
            case 101:
                return avg(number, numbers);
            case 102:
                return count(number, numbers);
            case 103:
                return counta(number, numbers);
            case 104:
                return max(number, numbers);
            case 105:
                return min(number, numbers);
            case 106:
                return product(number, numbers);
            case 107:
                throw new UnsupportedOperationException();
            case 108:
                throw new UnsupportedOperationException();
            case 109:
                return sum(number, numbers);
            case 110:
                throw new UnsupportedOperationException();
            case 111:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static FormulaDecimal sumif(Object... args) {
        int criteriaIndex = buildIfCriteriaIndex(args);
        final Number[] range = Arrays.stream(args, 0, criteriaIndex)
                .map(o -> (Number) o)
                .toArray(Number[]::new);
        final CharSequence criteria = (CharSequence) args[criteriaIndex];
        final Number[] sumRange = Arrays.stream(args, criteriaIndex + 1, args.length)
                .map(o -> (Number) o)
                .toArray(Number[]::new);
        return sumif(range, criteria, sumRange);
    }

    public static FormulaDecimal sumif(Number[] range, CharSequence criteria, Number... sumRange) {
        // TODO not totally according to spec (doesn't support criteria evaluation).
        final Predicate<Number> predicate = buildNumericIfPredicate(criteria);

        if (predicate == null) {
            return sum(range[0], ArrayHelper.join(Arrays.copyOfRange(range, 1, range.length), sumRange));
        } else {
            final Number[] rangeInCriteria = Arrays.stream(range)
                    .filter(predicate)
                    .toArray(Number[]::new);

            return sum(rangeInCriteria[0], ArrayHelper.join(Arrays.copyOfRange(rangeInCriteria, 1, rangeInCriteria.length), sumRange));
        }
    }

    protected static int buildIfCriteriaIndex(Object[] args) {
        int criteriaIndex = -1;
        for (int i = 0; i < args.length; i++) {
            Object arg = args[i];
            if (arg instanceof CharSequence) {
                if (criteriaIndex == -1) {
                    criteriaIndex = i;
                } else if (i > args.length / 2) {
                    throw new UnsupportedOperationException();
                } else {
                    criteriaIndex = i;
                }
            }
        }
        if (criteriaIndex == -1) {
            throw new UnsupportedOperationException();
        }
        return criteriaIndex;
    }


    protected static Predicate<Comparable<?>> buildIfPredicate(CharSequence criteria) {
        if (criteria == null || criteria.length() == 0) {
            return comparable -> false;
        }
        final String operator;
        final Comparable<?> value;
        final boolean hasWildcard;
        if (Character.isDigit(criteria.charAt(0))) {
            operator = "";
            value = String.valueOf(criteria);
            hasWildcard = false;
        } else if (Character.isDigit(criteria.charAt(1))) {
            operator = String.valueOf(criteria.charAt(0));
            value = String.valueOf(criteria.subSequence(1, criteria.length()));
            hasWildcard = false;
        } else if (Character.compare('*', criteria.charAt(1)) == 0) {
            operator = String.valueOf(criteria.charAt(0));
            value = String.valueOf(criteria.subSequence(2, criteria.length()));
            hasWildcard = true;
        } else if (Character.compare('*', criteria.charAt(2)) == 0) {
            operator = String.valueOf(criteria.charAt(0)) + String.valueOf(criteria.charAt(1));
            value = String.valueOf(criteria.subSequence(3, criteria.length()));
            hasWildcard = true;
        } else {
            operator = String.valueOf(criteria.charAt(0)) + String.valueOf(criteria.charAt(1));
            value = String.valueOf(criteria.subSequence(2, criteria.length()));
            hasWildcard = false;
        }
        if (!hasWildcard) {
            try {
                return (Predicate) buildNumericIfPredicate(criteria);
            } catch (IllegalArgumentException e) {
                return buildIfPredicate(operator, value, false);
            }
        }
        return buildIfPredicate(operator, value, hasWildcard);
    }

    @Nullable
    protected static Predicate<Comparable<?>> buildIfPredicate(String operator, Comparable<?> value, boolean hasWildcard) {
        final Predicate<Comparable<?>> predicate;
        switch (operator) {
            case "":
                predicate = null;
                break;
            case "=":
                if (hasWildcard) {
                    predicate = v -> v.toString().contains(value.toString());
                } else {
                    predicate = v -> Objects.equals(v, value);
                }
                break;
            case ">":
                predicate = v -> ((Comparable) v).compareTo((Comparable) value) > 0;
                break;
            case "<":
                predicate = v -> ((Comparable) v).compareTo((Comparable) value) < 0;
                break;
            case "<>":
                if (hasWildcard) {
                    predicate = v -> !v.toString().contains(value.toString());
                } else {
                    predicate = v -> !Objects.equals(v, value);
                }
                break;
            case ">=":
                predicate = v -> ((Comparable) v).compareTo((Comparable) value) >= 0;
                break;
            case "<=":
                predicate = v -> ((Comparable) v).compareTo((Comparable) value) <= 0;
                break;
            default:
                throw new UnsupportedOperationException();
        }
        return predicate;
    }

    protected static Predicate<Number> buildNumericIfPredicate(CharSequence criteria) {
        if (criteria == null || criteria.length() == 0) {
            return comparable -> false;
        }
        final String operator;
        final FormulaDecimal value;
        if (Character.isDigit(criteria.charAt(0))) {
            operator = "";
            value = Formulas.valueOf(String.valueOf(criteria));
        } else if (Character.isDigit(criteria.charAt(1))) {
            operator = String.valueOf(criteria.charAt(0));
            value = Formulas.valueOf(String.valueOf(criteria.subSequence(1, criteria.length())));
        } else {
            operator = String.valueOf(criteria.charAt(0) + criteria.charAt(1));
            value = Formulas.valueOf(String.valueOf(criteria.subSequence(2, criteria.length())));
        }
        return buildNumericIfPredicate(operator, value);
    }

    @Nullable
    protected static Predicate<Number> buildNumericIfPredicate(String operator, FormulaDecimal value) {
        final Predicate<Number> predicate;
        switch (operator) {
            case "":
                predicate = null;
                break;
            case "=":
                predicate = number -> Formulas.valueOf(number).compareTo(value.asBigDecimal()) == 0;
                break;
            case ">":
                predicate = number -> Formulas.valueOf(number).compareTo(value.asBigDecimal()) > 0;
                break;
            case "<":
                predicate = number -> Formulas.valueOf(number).compareTo(value.asBigDecimal()) < 0;
                break;
            case "<>":
                predicate = number -> Formulas.valueOf(number).compareTo(value.asBigDecimal()) != 0;
                break;
            case ">=":
                predicate = number -> Formulas.valueOf(number).compareTo(value.asBigDecimal()) >= 0;
                break;
            case "<=":
                predicate = number -> Formulas.valueOf(number).compareTo(value.asBigDecimal()) <= 0;
                break;
            default:
                throw new UnsupportedOperationException();
        }
        return predicate;
    }

    public static FormulaDecimal sumifs() {
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal sumproduct(Number number, Number... numbers) {
        // Multiplies corresponding components in the given arrays, and returns the sum of those products.
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);

        final int splitIndex;
        if (array.length % 2 == 0) {
            splitIndex = array.length / 2;
        } else {
            throw new UnsupportedOperationException();
        }

        final Number[] left = Arrays.copyOfRange(array, 0, splitIndex);
        final Number[] right = Arrays.copyOfRange(array, splitIndex, array.length);

        FormulaDecimal product = new FormulaDecimal(0);

        for (int i = 0; i < splitIndex; i++) {
            final Number l = left[i];
            final Number r = right[i];
            product = product.add(Formulas.valueOf(l).multiply(Formulas.valueOf(r)));
        }

        return product;
    }

    public static FormulaDecimal sumsq(Number number, Number... numbers) {
        // Returns the sum of the squares of the arguments.
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        return Formulas.valueOf(Arrays.stream(array)
                .map(n -> power(n, 2).asBigDecimal())
                .reduce(BigDecimal.ZERO, BigDecimal::add));
    }

    public static FormulaDecimal sumx2my2(Number number, Number... numbers) {
        // Returns the sum of the difference of squares of corresponding values in two arrays.
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        if (array.length % 2 != 0) {
            throw new IllegalArgumentException();
        }
        final FormulaDecimal[] arrayX = Arrays.asList(array).subList(0, array.length / 2).stream()
                .map(Formulas::valueOf)
                .toArray(FormulaDecimal[]::new);
        final FormulaDecimal[] arrayY = Arrays.asList(array).subList(array.length / 2, array.length).stream()
                .map(Formulas::valueOf)
                .toArray(FormulaDecimal[]::new);

        FormulaDecimal sum = new FormulaDecimal(0);

        for (int i = 0; i < array.length / 2; i++) {
            final FormulaDecimal x = arrayX[i];
            final FormulaDecimal y = arrayY[i];
            sum = sum.add(power(x, 2).subtract(power(y, 2)));
        }

        return sum;
    }

    public static FormulaDecimal sumx2py2(Number number, Number... numbers) {
        // Returns the sum of the sum of squares of corresponding values in two arrays.
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        if (array.length % 2 != 0) {
            throw new IllegalArgumentException();
        }
        final FormulaDecimal[] arrayX = Arrays.asList(array).subList(0, array.length / 2).stream()
                .map(Formulas::valueOf)
                .toArray(FormulaDecimal[]::new);
        final FormulaDecimal[] arrayY = Arrays.asList(array).subList(array.length / 2, array.length).stream()
                .map(Formulas::valueOf)
                .toArray(FormulaDecimal[]::new);

        FormulaDecimal sum = new FormulaDecimal(0);

        for (int i = 0; i < array.length / 2; i++) {
            final FormulaDecimal x = arrayX[i];
            final FormulaDecimal y = arrayY[i];
            sum = sum.add(power(x, 2).add(power(y, 2)));
        }

        return sum;
    }

    public static FormulaDecimal sumxmy2(Number number, Number... numbers) {
        // Returns the sum of squares of differences of corresponding values in two arrays.
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        if (array.length % 2 != 0) {
            throw new IllegalArgumentException();
        }
        final FormulaDecimal[] arrayX = Arrays.asList(array).subList(0, array.length / 2).stream()
                .map(Formulas::valueOf)
                .toArray(FormulaDecimal[]::new);
        final FormulaDecimal[] arrayY = Arrays.asList(array).subList(array.length / 2, array.length).stream()
                .map(Formulas::valueOf)
                .toArray(FormulaDecimal[]::new);

        FormulaDecimal sum = new FormulaDecimal(0);

        for (int i = 0; i < array.length / 2; i++) {
            final FormulaDecimal x = arrayX[i];
            final FormulaDecimal y = arrayY[i];
            sum = sum.add(power(x.subtract(y), 2));
        }

        return sum;
    }

    public static FormulaDecimal aggregate(Number functionNum, Number options, Number number, Number... numbers) {
        // Returns an aggregate in a list or database.
        // The AGGREGATE function can apply different aggregate functions to a list or database with the option to ignore hidden rows and error values.
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final int functionCode = functionNum.intValue();
        final int optionsCode = options.intValue();

        final Number[] range;

        switch (optionsCode) {
            case 0:
                range = array;
                break;
            case 1:
                range = array;
                break;
            case 2:
                range = array;
                break;
            case 3:
                range = array;
                break;
            case 4:
                range = array;
                break;
            case 5:
                range = array;
                break;
            case 6:
                range = array;
                break;
            case 7:
                range = array;
                break;
            default:
                throw new UnsupportedOperationException();
        }

        switch (functionCode) {
            case 1:
                return avg(range[0], Arrays.copyOfRange(range, 1, range.length));
            case 2:
                return count(range[0], Arrays.copyOfRange(range, 1, range.length));
            case 3:
                return counta(range[0], Arrays.copyOfRange(range, 1, range.length));
            case 4:
                return max(range[0], Arrays.copyOfRange(range, 1, range.length));
            case 5:
                return min(range[0], Arrays.copyOfRange(range, 1, range.length));
            case 6:
                return product(range[0], Arrays.copyOfRange(range, 1, range.length));
            case 7:
                throw new UnsupportedOperationException("STDEV.S");
            case 8:
                throw new UnsupportedOperationException("STDEV.P");
            case 9:
                return sum(range[0], Arrays.copyOfRange(range, 1, range.length));
            case 10:
                throw new UnsupportedOperationException("VAR.S");
            case 11:
                throw new UnsupportedOperationException("VAR.P");
            case 12:
                return median(range[0], Arrays.copyOfRange(range, 1, range.length));
            case 13:
                throw new UnsupportedOperationException("MODE.SNGL");
            case 14:
                return large(range[0], ArrayHelper.append(range[range.length - 1], Arrays.copyOfRange(range, 1, range.length - 1)));
            case 15:
                return small(range[0], ArrayHelper.append(range[range.length - 1], Arrays.copyOfRange(range, 1, range.length - 1)));
            case 16:
                throw new UnsupportedOperationException("PERCENTILE.INC");
            case 17:
                throw new UnsupportedOperationException("QUARTILE.INC");
            case 18:
                throw new UnsupportedOperationException("PERCENTILE.EXC");
            case 19:
                throw new UnsupportedOperationException("QUARTILE.EXC");
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static FormulaDecimal large(Number number, Number... numbers) {
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final Number k = array[array.length - 1];
        final Number[] range = Arrays.copyOfRange(array, 0, array.length - 1);
        if (Formulas.valueOf(k).compareTo(BigDecimal.ONE) == 0) {
            return max(range[0], Arrays.copyOfRange(range, 1, range.length));
        } else {
            final List<Number> sortedList = Arrays.asList(ArrayHelper.prepend(number, numbers));
            sortedList.sort(Comparator.nullsFirst(Comparator.comparing(o -> Formulas.valueOf(o).asBigDecimal())));
            return Formulas.valueOf(sortedList.get(k.intValue() - 1));
        }
    }

    public static FormulaDecimal small(Number number, Number... numbers) {
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final Number k = array[array.length - 1];
        final Number[] range = Arrays.copyOfRange(array, 0, array.length - 1);
        if (Formulas.valueOf(k).compareTo(BigDecimal.ONE) == 0) {
            return min(range[0], Arrays.copyOfRange(range, 1, range.length));
        } else {
            final List<Number> sortedList = Arrays.asList(ArrayHelper.prepend(number, numbers));
            sortedList.sort(Comparator.nullsFirst(Comparator.comparing(o -> Formulas.valueOf(o).asBigDecimal())));
            return Formulas.valueOf(sortedList.get(sortedList.size() - k.intValue()));
        }
    }

    public static FormulaDecimal decimal(Number value) {
        return Formulas.valueOf(value.intValue());
    }

    public static FormulaDecimal decimal(Number value, Number radix) {
        return decimal(value.toString(), radix);
    }

    public static FormulaDecimal decimal(CharSequence value) {
        return Formulas.valueOf(Formulas.valueOf(value.toString()).intValue());
    }

    public static FormulaDecimal decimal(CharSequence value, Number radix) {
        return Formulas.valueOf(Integer.parseInt(value.toString(), radix.intValue()));
    }

    public static FormulaDecimal convert(Number value) {
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal convert(Number value, CharSequence fromUnit, CharSequence toUnit) {
        // @see https://github.com/apache/openoffice/blob/c014b5f2b55cff8d4b0c952d5c16d62ecde09ca1/main/scaddins/source/analysis/analysishelper.cxx#L2743
        // @see https://github.com/apache/openoffice/blob/c014b5f2b55cff8d4b0c952d5c16d62ecde09ca1/main/scaddins/source/analysis/analysishelper.cxx#L2563

        return Formulas.valueOf(MetricConvert.convert(value, fromUnit, toUnit));
    }

    public static ExpressionString dec2bin(Number value) {
        return dec2bin(value.toString());
    }

    public static ExpressionString dec2bin(CharSequence value) {
        return dec2bin(value, null);
    }

    public static ExpressionString dec2bin(Number value, Number places) {
        return dec2bin(value.toString(), places);
    }

    public static ExpressionString dec2bin(CharSequence number, Number places) {
        if (Formulas.valueOf(number.toString()).compareTo(BigDecimal.ZERO) < 0) {
            return ExpressionString.valueOf("1" + Expressions.rept("0", 9 - Formulas.valueOf(number.toString()).add(Formulas.valueOf(512)).toBigInteger().toString(2).length()) + Formulas.valueOf(512).add(Formulas.valueOf(number.toString())).toBigInteger().toString(2));
        }

        if (places == null) {
            return ExpressionString.valueOf(new BigInteger(number.toString(), 10).toString(2));
        } else {
            final ExpressionString result = ExpressionString.valueOf(new BigInteger(number.toString(), 10).toString(2));
            if (result.length() < places.intValue()) {
                return Expressions.rept("0", places.intValue() - result.length()).add(result);
            } else {
                return result;
            }
        }
    }

    public static ExpressionString dec2hex(Number value) {
        return dec2hex(value.toString());
    }

    public static ExpressionString dec2hex(CharSequence value) {
        return dec2hex(value, null);
    }

    public static ExpressionString dec2hex(Number value, Number places) {
        return dec2hex(value.toString(), places);
    }

    public static ExpressionString dec2hex(CharSequence number, Number places) {
        if (Formulas.valueOf(number.toString()).compareTo(BigDecimal.ZERO) < 0) {
            return ExpressionString.valueOf(String.format("%10x", Formulas.valueOf(number.toString()).intValue())).replace(' ', 'f');
        }

        if (places == null) {
            return ExpressionString.valueOf(new BigInteger(number.toString(), 10).toString(16));
        } else {
            return ExpressionString.valueOf(String.format("%0" + places.intValue() + "x", new BigInteger(number.toString(), 10)));
        }
    }

    public static ExpressionString dec2oct(Number value) {
        return dec2oct(value.toString());
    }

    public static ExpressionString dec2oct(CharSequence value) {
        return dec2oct(value, null);
    }

    public static ExpressionString dec2oct(Number value, Number places) {
        return dec2oct(value.toString(), places);
    }

    public static ExpressionString dec2oct(CharSequence number, Number places) {
        if (Formulas.valueOf(number.toString()).compareTo(BigDecimal.ZERO) < 0) {
            return ExpressionString.valueOf(String.format("%10o", Formulas.valueOf(number.toString()).intValue() + 1073741824));
        }

        if (places == null) {
            return ExpressionString.valueOf(new BigInteger(number.toString(), 10).toString(8));
        } else {
            return ExpressionString.valueOf(String.format("%0" + places.intValue() + "o", new BigInteger(number.toString(), 10)));
        }
    }

    public static FormulaDecimal delta(Number value) {
        return delta(value, 0);
    }

    public static FormulaDecimal delta(Number first, Number second) {
        // Tests whether two values are equal. Returns 1 if number1 = number2; returns 0 otherwise.
        return Formulas.valueOf(first).compareTo(Formulas.valueOf(second)) == 0 ? Formulas.valueOf(1) : Formulas.valueOf(0);
    }

    public static FormulaDecimal erf(Number lowerLimit) {
        return erf(lowerLimit, 0);
    }

    public static FormulaDecimal erf(Number lowerLimit, Number upperLimit) {
        if (Formulas.valueOf(upperLimit).compareTo(BigDecimal.ZERO) == 0) {
            return Formulas.valueOf(Erf.erf(0d, lowerLimit.doubleValue()));
        } else {
            return Formulas.valueOf(Erf.erf(lowerLimit.doubleValue(), upperLimit.doubleValue()));
        }
    }

    public static FormulaDecimal erfc(Number x) {
        return Formulas.valueOf(Erf.erfc(x.doubleValue()));
    }

    public static FormulaDecimal erf_precise(Number x) {
        return Formulas.valueOf(Erf.erf(x.doubleValue()));
    }

    public static FormulaDecimal gestep(Number number) {
        return gestep(number, 0);
    }

    public static FormulaDecimal gestep(Number number, Number step) {
        return Formulas.valueOf(number).compareTo(Formulas.valueOf(step)) >= 0 ? Formulas.valueOf(1) : Formulas.valueOf(0);
    }

    public static ExpressionString hex2bin(char f, Number value) {
        return hex2bin(value.toString());
    }

    public static ExpressionString hex2bin(CharSequence value) {
        return hex2bin(value, null);
    }

    public static ExpressionString hex2bin(Number value, Number places) {
        return hex2bin(value.toString(), places);
    }

    public static ExpressionString hex2bin(CharSequence number, Number places) {
        return dec2bin(hex2dec(number), places);
    }

    public static FormulaDecimal hex2dec(Number value) {
        return hex2dec(value.toString());
    }

    public static FormulaDecimal hex2dec(CharSequence number) {
//        if (number.length() == 10 && number.charAt(0) == 'F') {
//            return Formulas.valueOf(new BigInteger(number.toString(), 16).longValue() - 1099511627264L);
//        } else {
        final FormulaDecimal decimal = Formulas.valueOf(new BigInteger(number.toString(), 16));
//            if (formulaDecimal.compareTo(Formulas.valueOf(1099511627264L)) >= 0) {
//                return Formulas.valueOf(new BigInteger(number.toString(), 16).longValue() - 1099511627264L);
//            }
//            return formulaDecimal;
//        }

        return (decimal.compareTo(Formulas.valueOf(549755813888L)) >= 0) ? decimal.subtract(Formulas.valueOf(1099511627776L)) : decimal;
    }

    public static ExpressionString hex2oct(Number value) {
        return hex2oct(value.toString());
    }

    public static ExpressionString hex2oct(CharSequence value) {
        return hex2oct(value, null);
    }

    public static ExpressionString hex2oct(Number value, Number places) {
        return hex2oct(value.toString(), places);
    }

    public static ExpressionString hex2oct(CharSequence value, Number places) {
        return dec2oct(hex2dec(value), places);
    }

    public static FormulaDecimal mround(Number value, Number multiple) {
        if (Formulas.valueOf(multiple).compareTo(BigDecimal.ZERO) == 0) {
            return Formulas.valueOf(0);
        } else {
            return Formulas.valueOf(multiple).multiply(round(Formulas.valueOf(value).divide(Formulas.valueOf(multiple))));
        }
    }

    public static FormulaDecimal multinomial(Number number, Number... numbers) {
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal divisor = BigDecimal.ONE;
        for (Number n : array) {
            sum = sum.add(Formulas.valueOf(n).asBigDecimal());
            divisor = divisor.multiply(fact(Formulas.valueOf(n)).asBigDecimal());
        }

        return Formulas.valueOf(fact(sum).divide(Formulas.valueOf(divisor)));
    }

    public static FormulaDecimal imabs(Number number) {
        return imabs(number.toString());
    }

    public static FormulaDecimal imabs(CharSequence number) {
        final FormulaDecimal x = imreal(number);
        final FormulaDecimal y = imaginary(number);

        return Formulas.sqrt(Formulas.power(x, 2).add(Formulas.power(y, 2)));
    }

    public static FormulaDecimal imaginary(Number value) {
        return imaginary(value.toString());
    }

    public static FormulaDecimal imaginary(CharSequence value) {
        // Return 0 if inumber is equal to 0
        if (value.length() == 1 && value.charAt(0) == '0') {
            return Formulas.valueOf(0);
        }

        // Handle special cases
        if (Arrays.asList("i", "j").indexOf(value.toString()) >= 0) {
            return Formulas.valueOf(1);
        }

        // Normalize imaginary coefficient
        String inumber = value.toString().replace("+i", "+1i").replace("-i", "-1i").replace("+j", "+1j").replace("-j", "-1j");

        // Lookup sign
        int plus = inumber.indexOf('+');
        int minus = inumber.indexOf('-');
        if (plus == 0) {
            plus = inumber.indexOf('+', 1);
        }

        if (minus == 0) {
            minus = inumber.indexOf('-', 1);
        }

        // Lookup imaginary unit
        final boolean unit = value.charAt(value.length() - 1) == 'i' || value.charAt(value.length() - 1) == 'j';

        if (plus >= 0 || minus >= 0) {
            // Return error if imaginary unit is neither i nor j
            if (!unit) {
                throw new UnsupportedOperationException();
            }

            // Return imaginary coefficient of complex number
            if (plus >= 0) {
                //                        error.num :
                if (isNaN(inumber.substring(0, plus)) || isNaN(inumber.substring(plus + 1, inumber.length() - 1))) {
                    throw new UnsupportedOperationException();
                } else {
                    return Formulas.valueOf(inumber.substring(plus + 1, inumber.length() - 1));
                }
//                return Formulas.valueOf(0);
            } else {
                //                        error.num :
                if (isNaN(inumber.substring(0, minus)) || isNaN(inumber.substring(minus + 1, inumber.length() - 1))) {
                    throw new UnsupportedOperationException();
                } else {
                    return Formulas.valueOf((inumber.substring(minus + 1, inumber.length() - 1))).negate();
                }
//                return Formulas.valueOf(0);
            }
        } else {
            if (unit) {
                if (isNaN(inumber.substring(0, inumber.length() - 1))) {
                    throw new UnsupportedOperationException();
                } else {
                    return Formulas.valueOf(inumber.substring(0, inumber.length() - 1));
                }
//                return Formulas.valueOf(0);
            } else {
                if (isNaN(inumber)) {
                    throw new UnsupportedOperationException();
                } else {
                    return Formulas.valueOf(0);
                }
//                return Formulas.valueOf(0);
            }
        }
    }

    protected static boolean isNaN(CharSequence value) {
        return isNaN(value.toString());
    }

    protected static boolean isNaN(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        try {
            final FormulaDecimal result = Formulas.valueOf(value);
            return result == null;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public static FormulaDecimal imargument(Number value) {
        return imargument(value.toString());
    }

    public static FormulaDecimal imargument(CharSequence value) {
        final FormulaDecimal x = imreal(value);
        final FormulaDecimal y = imaginary(value);

        if (x.compareTo(BigDecimal.ZERO) == 0 && y.compareTo(BigDecimal.ZERO) == 0) {
            throw new UnsupportedOperationException();
        }

        if (x.compareTo(BigDecimal.ZERO) == 0 && y.compareTo(BigDecimal.ZERO) > 0) {
            return Formulas.valueOf(BigDecimalMath.pi(MathContext.DECIMAL128).divide(new BigDecimal(2), MathContext.DECIMAL128));
        }

        if (x.compareTo(BigDecimal.ZERO) == 0 && y.compareTo(BigDecimal.ZERO) < 0) {
            return Formulas.valueOf(BigDecimalMath.pi(MathContext.DECIMAL128).negate().divide(new BigDecimal(2), MathContext.DECIMAL128));
        }

        if (y.compareTo(BigDecimal.ZERO) == 0 && x.compareTo(BigDecimal.ZERO) > 0) {
            return Formulas.valueOf(0);
        }

        if (y.compareTo(BigDecimal.ZERO) == 0 && x.compareTo(BigDecimal.ZERO) < 0) {
            return Formulas.valueOf(BigDecimalMath.pi(MathContext.DECIMAL128).negate());
        }

        if (x.compareTo(BigDecimal.ZERO) > 0) {
            return Formulas.atan(y.divide(x));
        } else if (x.compareTo(BigDecimal.ZERO) < 0 && y.compareTo(BigDecimal.ZERO) >= 0) {
            return Formulas.atan(y.divide(x)).add(Formulas.valueOf(BigDecimalMath.pi(MathContext.DECIMAL128)));
        } else {
            return Formulas.atan(y.divide(x)).subtract(Formulas.valueOf(BigDecimalMath.pi(MathContext.DECIMAL128)));
        }
    }

    public static ExpressionString imconjugate(Number value) {
        return imconjugate(value.toString());
    }

    public static ExpressionString imconjugate(CharSequence value) {
        final FormulaDecimal x = imreal(value);
        final FormulaDecimal y = imaginary(value);

        final char unit = value.charAt(value.length() - 1);

        return y.compareTo(BigDecimal.ZERO) == 0 ? ExpressionString.valueOf(value) : ExpressionString.valueOf(complex(x, y.negate(), (unit == 'i' || unit == 'j') ? String.valueOf(unit) : "i"));
    }

    public static ExpressionString imcos(Number value) {
        return imcos(value.toString());
    }

    public static ExpressionString imcos(CharSequence value) {
        final FormulaDecimal x = imreal(value);
        final FormulaDecimal y = imaginary(value);

        final char unit = value.charAt(value.length() - 1);

        return complex(Formulas.cos(x).multiply(Formulas.exp(y).add(Formulas.exp(y.negate())).divide(Formulas.valueOf(2))), Formulas.sin(x).negate().multiply(Formulas.exp(y).subtract(Formulas.exp(y.negate())).divide(Formulas.valueOf(2))), (unit == 'i' || unit == 'j') ? String.valueOf(unit) : "i");
    }

    public static ExpressionString imcosh(Number value) {
        return imcosh(value.toString());
    }

    public static ExpressionString imcosh(CharSequence value) {
        final FormulaDecimal x = imreal(value);
        final FormulaDecimal y = imaginary(value);

        final char unit = value.charAt(value.length() - 1);

        return complex(Formulas.cos(y).multiply(Formulas.exp(x).add(Formulas.exp(x.negate())).divide(Formulas.valueOf(2))), Formulas.sin(y).multiply(Formulas.exp(x).subtract(Formulas.exp(x.negate())).divide(Formulas.valueOf(2))), (unit == 'i' || unit == 'j') ? String.valueOf(unit) : "i");
    }

    public static ExpressionString imcot(Number value) {
        return imcosh(value.toString());
    }

    public static ExpressionString imcot(CharSequence value) {
        final FormulaDecimal x = imreal(value);
        final FormulaDecimal y = imaginary(value);

        return imdiv(imcos(value), imsin(value));
    }

    public static ExpressionString imcsc(Number value) {
        return imcsc(value.toString());
    }

    public static ExpressionString imcsc(CharSequence value) {
        final FormulaDecimal x = imreal(value);
        final FormulaDecimal y = imaginary(value);

        return imdiv(1, imsin(value));
    }

    public static ExpressionString imcsch(Number value) {
        return imcsch(value.toString());
    }

    public static ExpressionString imcsch(CharSequence value) {
        final FormulaDecimal x = imreal(value);
        final FormulaDecimal y = imaginary(value);

        return imdiv(1, imsinh(value));
    }

    public static ExpressionString imdiv(Number numerator, Number denominator) {
        return imdiv(numerator.toString(), denominator.toString());
    }

    public static ExpressionString imdiv(CharSequence numerator, Number denominator) {
        return imdiv(numerator.toString(), denominator.toString());
    }

    public static ExpressionString imdiv(Number numerator, CharSequence denominator) {
        return imdiv(numerator.toString(), denominator.toString());
    }

    public static ExpressionString imdiv(CharSequence numerator, CharSequence denominator) {
        final FormulaDecimal a = imreal(numerator); // nx
        final FormulaDecimal b = imaginary(numerator); // ny
        final FormulaDecimal c = imreal(denominator); // dx
        final FormulaDecimal d = imaginary(denominator); // dy
        // Lookup imaginary unit
        char unit1 = numerator.charAt(numerator.length() - 1);
        char unit2 = denominator.charAt(denominator.length() - 1);
        char unit = 'i';
        if (unit1 == 'j') {
            unit = 'j';
        } else if (unit2 == 'j') {
            unit = 'j';
        }

//        // Return error if inumber2 is null
//        if (c == 0 && d === 0) {
//            return error.num;
//        }
        if (c.compareTo(BigDecimal.ZERO) == 0 && d.compareTo(BigDecimal.ZERO) == 0) {
            throw new UnsupportedOperationException();
        }


        // Return exponential of complex number
        final FormulaDecimal den = c.multiply(c).add(d.multiply(d));
//        return complex((a * c + b * d) / den, (b * c - a * d) / den, unit);
        return complex(a.multiply(c).add(b.multiply(d)).divide(den), b.multiply(c).subtract(a.multiply(d)).divide(den), Character.toString(unit));
    }

    public static ExpressionString imexp(Number value) {
        return imexp(value.toString());
    }

    public static ExpressionString imexp(CharSequence value) {
        final FormulaDecimal x = imreal(value);
        final FormulaDecimal y = imaginary(value);

        final char unit = value.charAt(value.length() - 1);

        final FormulaDecimal e = Formulas.exp(x);
        return complex(e.multiply(Formulas.cos(y)), e.multiply(Formulas.sin(y)), (unit == 'i' || unit == 'j') ? String.valueOf(unit) : "i");
    }

    public static ExpressionString imln(Number value) {
        return imln(value.toString());
    }

    public static ExpressionString imln(CharSequence value) {
        final FormulaDecimal x = imreal(value);
        final FormulaDecimal y = imaginary(value);

        final char unit = value.charAt(value.length() - 1);

        return complex(Formulas.log(Formulas.sqrt(x.multiply(x).add(y.multiply(y)))), Formulas.atan(y.divide(x)), (unit == 'i' || unit == 'j') ? String.valueOf(unit) : "i");
    }

    public static ExpressionString imlog10(Number value) {
        return imlog10(value.toString());
    }

    public static ExpressionString imlog10(CharSequence value) {
        final FormulaDecimal x = imreal(value);
        final FormulaDecimal y = imaginary(value);

        final char unit = value.charAt(value.length() - 1);

        return complex(Formulas.log(Formulas.sqrt(x.multiply(x).add(y.multiply(y)))).divide(Formulas.log(10)), Formulas.atan(y.divide(x)).divide(Formulas.log(10)), (unit == 'i' || unit == 'j') ? String.valueOf(unit) : "i");
    }

    public static ExpressionString imlog2(Number value) {
        return imlog2(value.toString());
    }

    public static ExpressionString imlog2(CharSequence value) {
        final FormulaDecimal x = imreal(value);
        final FormulaDecimal y = imaginary(value);

        final char unit = value.charAt(value.length() - 1);

        return complex(Formulas.log(Formulas.sqrt(x.multiply(x).add(y.multiply(y)))).divide(Formulas.log(2)), Formulas.atan(y.divide(x)).divide(Formulas.log(2)), (unit == 'i' || unit == 'j') ? String.valueOf(unit) : "i");
    }

    public static ExpressionString impower(Number number, Number power) {
        return impower(number.toString(), power.toString());
    }

    public static ExpressionString impower(CharSequence number, Number power) {
        return impower(number.toString(), power.toString());
    }

    public static ExpressionString impower(Number number, CharSequence power) {
        return impower(number.toString(), power.toString());
    }

    public static ExpressionString impower(CharSequence number, CharSequence power) {
        final FormulaDecimal x = imreal(number);
        final FormulaDecimal y = imaginary(number);

        final char unit = number.charAt(number.length() - 1);

        final FormulaDecimal p = Formulas.power(imabs(number), Formulas.valueOf(power.toString()));

        final FormulaDecimal t = imargument(number);

        return complex(p.multiply(Formulas.cos(Formulas.valueOf(power.toString()).multiply(t))), p.multiply(Formulas.sin(Formulas.valueOf(power.toString()).multiply(t))), (unit == 'i' || unit == 'j') ? String.valueOf(unit) : "i");
    }

    public static ExpressionString improduct(Number number, Number... numbers) {
        return improduct(number.toString(), Arrays.stream(numbers).map(Object::toString).toArray(String[]::new));
    }

    public static ExpressionString improduct(CharSequence number, Number... numbers) {
        return improduct(number.toString(), Arrays.stream(numbers).map(Object::toString).toArray(String[]::new));
    }

    public static ExpressionString improduct(Number number, CharSequence... numbers) {
        return improduct(number.toString(), Arrays.stream(numbers).map(Object::toString).toArray(String[]::new));
    }

    public static ExpressionString improduct(CharSequence number, CharSequence... numbers) {
        final CharSequence[] array = ArrayHelper.prepend(CharSequence.class, number, numbers);

        CharSequence result = number;

        for (int i = 1; i < array.length; i++) {
            final FormulaDecimal a = imreal(result);
            final FormulaDecimal b = imaginary(result);
            final FormulaDecimal c = imreal(array[i]);
            final FormulaDecimal d = imaginary(array[i]);

            result = complex(a.multiply(c).subtract(b.multiply(d)), a.multiply(d).add(b.multiply(c)));
        }

        return ExpressionString.valueOf(result);
    }

    public static FormulaDecimal imreal(Number value) {
        return imreal(value.toString());
    }

    public static FormulaDecimal imreal(CharSequence value) {
        if (value.length() == 1 && value.charAt(0) == '0') {
            return Formulas.valueOf(0);
        }

        // Handle special cases
        if (Arrays.asList("i", "+i", "1i", "+1i", "-i", "-1i", "j", "+j", "1j", "+1j", "-j", "-1j").indexOf(value.toString()) >= 0) {
            return Formulas.valueOf(0);
        }

        // Lookup sign
        int plus = value.toString().indexOf('+');
        int minus = value.toString().indexOf('-');
        if (plus == 0) {
            plus = value.toString().indexOf('+', 1);
        }
        if (minus == 0) {
            minus = value.toString().indexOf('-', 1);
        }

        final String inumber = value.toString();

        // Lookup imaginary unit
        final boolean unit = value.charAt(value.length() - 1) == 'i' || value.charAt(value.length() - 1) == 'j';

        if (plus >= 0 || minus >= 0) {
            // Return error if imaginary unit is neither i nor j
            if (!unit) {
                throw new UnsupportedOperationException();
            }


            // Return real coefficient of complex number
            if (plus >= 0) {
                //                        error.num :
                if (isNaN(inumber.substring(0, plus)) || isNaN(inumber.substring(plus + 1, value.length() - 1))) {
                    throw new UnsupportedOperationException();
                } else {
                    return Formulas.valueOf(inumber.substring(0, plus));
                }
//                return Formulas.valueOf(0);
            } else {
                //                        error.num :
                if (isNaN(inumber.substring(0, minus)) || isNaN(inumber.substring(minus + 1, value.length() - 1))) {
                    throw new UnsupportedOperationException();
                } else {
                    return Formulas.valueOf(inumber.substring(0, minus));
                }
//                return Formulas.valueOf(0);
            }
        } else {
            if (unit) {
                if (isNaN(inumber.substring(0, inumber.length() - 1))) {
                    throw new UnsupportedOperationException();
                } else {
                    return Formulas.valueOf(0);
                }
//                return Formulas.valueOf(0);
            } else {
                if (isNaN(inumber)) {
                    throw new UnsupportedOperationException();
                } else {
                    return Formulas.valueOf(inumber);
                }
//                return Formulas.valueOf(0);
            }
        }
    }

    public static ExpressionString imsec(Number value) {
        return imsec(value.toString());
    }

    public static ExpressionString imsec(CharSequence value) {
        final FormulaDecimal x = imreal(value);
        final FormulaDecimal y = imaginary(value);

        return imdiv(1, imcos(value));
    }

    public static ExpressionString imsech(Number value) {
        return imsech(value.toString());
    }

    public static ExpressionString imsech(CharSequence value) {
        final FormulaDecimal x = imreal(value);
        final FormulaDecimal y = imaginary(value);

        return imdiv(1, imcosh(value));
    }

    public static ExpressionString imsin(Number value) {
        return imsin(value.toString());
    }

    public static ExpressionString imsin(CharSequence value) {
        final FormulaDecimal x = imreal(value);
        final FormulaDecimal y = imaginary(value);

        final char unit = value.charAt(value.length() - 1);

        return complex(Formulas.sin(x).multiply(Formulas.exp(y).add(Formulas.exp(y.negate())).divide(Formulas.valueOf(2))), Formulas.cos(x).multiply(Formulas.exp(y).subtract(Formulas.exp(y.negate())).divide(Formulas.valueOf(2))), (unit == 'i' || unit == 'j') ? String.valueOf(unit) : "i");
    }

    public static ExpressionString imsinh(Number value) {
        return imsinh(value.toString());
    }

    public static ExpressionString imsinh(CharSequence value) {
        final FormulaDecimal x = imreal(value);
        final FormulaDecimal y = imaginary(value);

        final char unit = value.charAt(value.length() - 1);

//        return complex(Formulas.cos(y).multiply(Formulas.exp(x).subtract(Formulas.exp(x.negate()))).divide(Formulas.valueOf(2)), Formulas.sin(y).multiply(Formulas.exp(x).add(Formulas.exp(x.negate()))).divide(Formulas.valueOf(2)), (unit == 'i' || unit == 'j') ? String.valueOf(unit) : "i");
        return complex(Math.cos(y.doubleValue()) * (Math.exp(x.doubleValue()) - Math.exp(-x.doubleValue())) / 2, Math.sin(y.doubleValue()) * (Math.exp(x.doubleValue()) + Math.exp(-x.doubleValue())) / 2, (unit == 'i' || unit == 'j') ? String.valueOf(unit) : "i");

    }

    public static ExpressionString imsqrt(Number value) {
        return imsqrt(value.toString());
    }

    public static ExpressionString imsqrt(CharSequence value) {
        final FormulaDecimal x = imreal(value);
        final FormulaDecimal y = imaginary(value);

        final char unit = value.charAt(value.length() - 1);

        final FormulaDecimal s = Formulas.sqrt(imabs(value));

        final FormulaDecimal t = imargument(value);

        return complex(s.multiply(Formulas.cos(t.divide(Formulas.valueOf(2)))), s.multiply(Formulas.sin(t.divide(Formulas.valueOf(2)))), (unit == 'i' || unit == 'j') ? String.valueOf(unit) : "i");
    }

    public static ExpressionString imsub(Number a, Number b) {
        return imsub(a.toString(), b.toString());
    }

    public static ExpressionString imsub(CharSequence a, Number b) {
        return imsub(a.toString(), b.toString());
    }

    public static ExpressionString imsub(Number a, CharSequence b) {
        return imsub(a.toString(), b.toString());
    }

    public static ExpressionString imsub(CharSequence first, CharSequence second) {
        // Returns the difference of two complex numbers in x + yi or x + yj text format.
        final FormulaDecimal a = imreal(first);
        final FormulaDecimal b = imaginary(first);
        final FormulaDecimal c = imreal(second);
        final FormulaDecimal d = imaginary(second);
        // Lookup imaginary unit
        char unit1 = first.charAt(first.length() - 1);
        char unit2 = second.charAt(second.length() - 1);
        char unit = 'i';
        if (unit1 == 'j') {
            unit = 'j';
        } else if (unit2 == 'j') {
            unit = 'j';
        }

        return complex(a.subtract(c), b.subtract(d), Character.toString(unit));
    }

    public static ExpressionString imsum(Number number, Number... numbers) {
        return improduct(number.toString(), Arrays.stream(numbers).map(Object::toString).toArray(String[]::new));
    }

    public static ExpressionString imsum(CharSequence number, Number... numbers) {
        return improduct(number.toString(), Arrays.stream(numbers).map(Object::toString).toArray(String[]::new));
    }

    public static ExpressionString imsum(Number number, CharSequence... numbers) {
        return improduct(number.toString(), Arrays.stream(numbers).map(Object::toString).toArray(String[]::new));
    }

    public static ExpressionString imsum(CharSequence number, CharSequence... numbers) {
        final CharSequence[] array = ArrayHelper.prepend(CharSequence.class, number, numbers);

        CharSequence result = number;

        for (int i = 1; i < array.length; i++) {
            final FormulaDecimal a = imreal(result);
            final FormulaDecimal b = imaginary(result);
            final FormulaDecimal c = imreal(array[i]);
            final FormulaDecimal d = imaginary(array[i]);

            result = complex(a.add(c), b.add(d));
        }

        return ExpressionString.valueOf(result);
    }

    public static ExpressionString imtan(Number value) {
        return imtan(value.toString());
    }

    public static ExpressionString imtan(CharSequence value) {
        final FormulaDecimal x = imreal(value);
        final FormulaDecimal y = imaginary(value);

        return imdiv(imsin(value), imcos(value));
    }

    public static ExpressionString oct2bin(Number value) {
        return oct2bin(value.toString());
    }

    public static ExpressionString oct2bin(CharSequence value) {
        return oct2bin(value, null);
    }

    public static ExpressionString oct2bin(Number value, Number places) {
        return oct2bin(value.toString(), places);
    }

    public static ExpressionString oct2bin(CharSequence value, Number places) {
        return dec2bin(oct2dec(value), places);
    }

    public static FormulaDecimal oct2dec(Number value) {
        return oct2dec(value.toString());
    }

    public static FormulaDecimal oct2dec(CharSequence number) {
        //        if (number.length() == 10 && number.charAt(0) == 'F') {
//            return Formulas.valueOf(new BigInteger(number.toString(), 16).longValue() - 1099511627264L);
//        } else {
        final FormulaDecimal decimal = Formulas.valueOf(new BigInteger(number.toString(), 8));
//            if (formulaDecimal.compareTo(Formulas.valueOf(1099511627264L)) >= 0) {
//                return Formulas.valueOf(new BigInteger(number.toString(), 16).longValue() - 1099511627264L);
//            }
//            return formulaDecimal;
//        }

        return (decimal.compareTo(Formulas.valueOf(536870912)) >= 0) ? decimal.subtract(Formulas.valueOf(1073741824)) : decimal;
    }

    public static ExpressionString oct2hex(Number value) {
        return oct2hex(value.toString());
    }

    public static ExpressionString oct2hex(CharSequence value) {
        return oct2hex(value, null);
    }

    public static ExpressionString oct2hex(Number value, Number places) {
        return oct2hex(value.toString(), places);
    }

    public static ExpressionString oct2hex(CharSequence value, Number places) {
        return dec2hex(oct2dec(value), places);
    }

    public static FormulaDecimal minus(Number decimal) {
        return new FormulaDecimal(Formulas.valueOf(decimal).delegate.negate());
    }

    public static FormulaDecimal plus(Number decimal) {
        return Formulas.valueOf(decimal);
    }

    public static FormulaDecimal cos(Number decimal) {
        return new FormulaDecimal(BigDecimalMath.cos(Formulas.valueOf(decimal).delegate, MathContext.DECIMAL128));
    }

    public static FormulaDecimal tan(Number decimal) {
        return new FormulaDecimal(BigDecimalMath.tan(Formulas.valueOf(decimal).delegate, MathContext.DECIMAL128));
    }

    public static FormulaDecimal sin(Number decimal) {
        return new FormulaDecimal(BigDecimalMath.sin(Formulas.valueOf(decimal).delegate, MathContext.DECIMAL128));
    }

    public static FormulaDecimal acos(Number decimal) {
        return new FormulaDecimal(BigDecimalMath.acos(Formulas.valueOf(decimal).delegate, MathContext.DECIMAL128));
    }

    public static FormulaDecimal acosh(Number decimal) {
        return new FormulaDecimal(BigDecimalMath.acosh(Formulas.valueOf(decimal).delegate, MathContext.DECIMAL128));
    }

    public static FormulaDecimal acot(Number decimal) {
        return new FormulaDecimal(BigDecimalMath.acot(Formulas.valueOf(decimal).delegate, MathContext.DECIMAL128));
    }

    public static FormulaDecimal acoth(Number decimal) {
        return new FormulaDecimal(BigDecimalMath.acoth(Formulas.valueOf(decimal).delegate, MathContext.DECIMAL128));
    }

    public static FormulaDecimal asinh(Number decimal) {
        return new FormulaDecimal(BigDecimalMath.asinh(Formulas.valueOf(decimal).delegate, MathContext.DECIMAL128));
    }

    public static FormulaDecimal atanh(Number decimal) {
        return new FormulaDecimal(BigDecimalMath.atanh(Formulas.valueOf(decimal).delegate, MathContext.DECIMAL128));
    }

    public static FormulaDecimal base(Number number, Number radix) {
        return base(number, radix, 0);
    }

    public static FormulaDecimal base(Number number, Number radix, Number minLength) {
        // Converts a number into a text representation with the given radix (base).
        if (radix.intValue() < 2 || radix.intValue() > 36) {
            throw new IllegalArgumentException("Radix must be an integer greater than or equal to 2 and less than or equal to 36");
        }
        if (minLength != null && minLength.intValue() < 0) {
            throw new IllegalArgumentException("MinLength must be an integer greater than or equal to 0.");
        }
        throw new UnsupportedOperationException();
    }

    public static ExpressionString choose(Number index, CharSequence value, CharSequence... values) {
        // Uses index_num to return a value from the list of value arguments.
        return ExpressionString.valueOf(ArrayHelper.prepend(CharSequence.class, value, values)[index.intValue()]);
    }

    public static ExpressionString choose(Number index, Date value, Date... values) {
        // Uses index_num to return a value from the list of value arguments.
        return ExpressionString.valueOf(ArrayHelper.prepend(Date.class, value, values)[index.intValue()]);
    }

    public static ExpressionString choose(Number index, Logical value, Logical... values) {
        // Uses index_num to return a value from the list of value arguments.
        return ExpressionString.valueOf(ArrayHelper.prepend(Logical.class, value, values)[index.intValue()]);
    }

    public static FormulaDecimal choose(Number index, Number number, Number... numbers) {
        // Uses index_num to return a value from the list of value arguments.
        return Formulas.valueOf(ArrayHelper.prepend(Number.class, number, numbers)[index.intValue()]);
    }

    public static FormulaDecimal count(Number number, Number... numbers) {
        // The COUNT function counts the number of cells that contain numbers, and counts numbers within the list of arguments.
        return Formulas.valueOf(1 + numbers.length);
    }

    public static FormulaDecimal counta(Number number, Number... numbers) {
        // The COUNTA function counts the number of cells that are not empty in a range.
        return Formulas.valueOf(1 + numbers.length);
    }

    public static FormulaDecimal counta(CharSequence value, CharSequence... values) {
        return Formulas.valueOf(1 + values.length);
    }

    public static FormulaDecimal counta(Date value, Date... values) {
        return Formulas.valueOf(1 + values.length);
    }

    public static FormulaDecimal counta(Logical value, Logical... values) {
        return Formulas.valueOf(1 + values.length);
    }

    public static FormulaDecimal counta(Boolean value, Boolean... values) {
        return Formulas.valueOf(1 + values.length);
    }

    public static FormulaDecimal counta(Number number, CharSequence... numbers) {
        return Formulas.valueOf(1 + numbers.length);
    }

    public static FormulaDecimal counta(Date value, CharSequence... values) {
        return Formulas.valueOf(1 + values.length);
    }

    public static FormulaDecimal counta(Logical value, CharSequence... values) {
        return Formulas.valueOf(1 + values.length);
    }

    public static FormulaDecimal counta(Boolean value, CharSequence... values) {
        return Formulas.valueOf(1 + values.length);
    }

    public static FormulaDecimal counta(Number number, Logical... numbers) {
        return Formulas.valueOf(1 + numbers.length);
    }

    public static FormulaDecimal counta(Date value, Logical... values) {
        return Formulas.valueOf(1 + values.length);
    }

    public static FormulaDecimal counta(CharSequence value, Logical... values) {
        return Formulas.valueOf(1 + values.length);
    }

    public static FormulaDecimal counta(Boolean value, Logical... values) {
        return Formulas.valueOf(1 + values.length);
    }

    public static FormulaDecimal counta(Number number, Boolean... numbers) {
        return Formulas.valueOf(1 + numbers.length);
    }

    public static FormulaDecimal counta(Date value, Boolean... values) {
        return Formulas.valueOf(1 + values.length);
    }

    public static FormulaDecimal counta(CharSequence value, Boolean... values) {
        return Formulas.valueOf(1 + values.length);
    }

    public static FormulaDecimal counta(Logical value, Boolean... values) {
        return Formulas.valueOf(1 + values.length);
    }

    public static FormulaDecimal counta(Boolean number, Number... numbers) {
        return Formulas.valueOf(1 + numbers.length);
    }

    public static FormulaDecimal counta(Date value, Number... values) {
        return Formulas.valueOf(1 + values.length);
    }

    public static FormulaDecimal counta(CharSequence value, Number... values) {
        return Formulas.valueOf(1 + values.length);
    }

    public static FormulaDecimal counta(Logical value, Number... values) {
        return Formulas.valueOf(1 + values.length);
    }

    public static FormulaDecimal counta(Boolean number, Date... numbers) {
        return Formulas.valueOf(1 + numbers.length);
    }

    public static FormulaDecimal counta(Number value, Date... values) {
        return Formulas.valueOf(1 + values.length);
    }

    public static FormulaDecimal counta(CharSequence value, Date... values) {
        return Formulas.valueOf(1 + values.length);
    }

    public static FormulaDecimal counta(Logical value, Date... values) {
        return Formulas.valueOf(1 + values.length);
    }

    public static FormulaDecimal convert(Number number, String fromUnit, String toUnit) {
        // Converts a number from one measurement system to another. For example, CONVERT can translate a table of distances in miles to a table of distances in kilometers.
        return convert(number, (CharSequence) fromUnit, (CharSequence) toUnit);
    }

    public static FormulaDecimal cot(Number decimal) {
        return new FormulaDecimal(BigDecimalMath.cot(Formulas.valueOf(decimal).delegate, MathContext.DECIMAL128));
    }

    public static FormulaDecimal coth(Number decimal) {
        return new FormulaDecimal(BigDecimalMath.coth(Formulas.valueOf(decimal).delegate, MathContext.DECIMAL128));
    }

    public static FormulaDecimal csc(Number decimal) {
        // Returns the cosecant of an angle specified in radians.
        return Formulas.valueOf(1).divide(sin(Formulas.valueOf(decimal)));
    }

    public static FormulaDecimal csch(Number decimal) {
        // Return the hyperbolic cosecant of an angle specified in radians.
        return Formulas.valueOf(1).divide(sinh(Formulas.valueOf(decimal)));
    }

    public static FormulaDecimal even(Number decimal) {
        // Returns number rounded up to the nearest even integer.
        return round(Formulas.valueOf(decimal).divide(Formulas.valueOf(2))).multiply(Formulas.valueOf(2));
    }

    public static FormulaDecimal odd(Number decimal) {
        // Returns number rounded up to the nearest odd integer.
        if (Formulas.valueOf(decimal).compareTo(BigDecimal.ZERO) == 0) {
            return Formulas.valueOf(1);
        }
        if (Formulas.valueOf(decimal).compareTo(BigDecimal.ZERO) > 0) {
            long d = ceil(Formulas.valueOf(decimal).add(Formulas.valueOf(1))).longValue();
            long x = ((long) d) & PARITY_MASK;
            return Formulas.valueOf((Long.compare(x, d) == 0) ? x - 1 : x + 1);
        } else {
            long d = floor(abs(Formulas.valueOf(decimal)).add(Formulas.valueOf(1))).longValue();
            long x = ((long) d) & PARITY_MASK;
            return Formulas.valueOf(-((Double.compare(x, d) == 0) ? x - 1 : x + 1));
        }
    }

    public static FormulaDecimal fact(Number decimal) {
        // Returns the factorial of a number. The factorial of a number is equal to 1*2*3*...* number.
        return Formulas.valueOf(BigDecimalMath.factorial(Formulas.valueOf(decimal).intValue()));
    }

    public static FormulaDecimal factdouble(Number decimal) {
        // Returns the double factorial of a number.
        long fact = 1;
        final long i;

        if (decimal.longValue() % 2 == 0) {
            i = 2;
        } else {
            i = 1;
        }
        for (long j = i; j <= decimal.longValue(); j += 2) {
            fact = fact * j;
        }
        return Formulas.valueOf(fact);
    }

    public static FormulaDecimal gcd(Number number, Number... numbers) {
        // Returns the greatest common divisor of two or more integers. The greatest common divisor is the largest integer that divides both number1 and number2 without a remainder.
        if (numbers.length == 0) {
            return Formulas.valueOf(number);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        BigInteger gcd = BigInteger.valueOf(number.longValue());
        for (Number n : array) {
            gcd = BigInteger.valueOf(n.longValue()).gcd(gcd);
        }
        return Formulas.valueOf(gcd);
    }

    public static FormulaDecimal lcm(Number number, Number... numbers) {
        // Returns the least common multiple of integers. The least common multiple is the smallest positive integer that is a multiple of all integer arguments number1, number2, and so on.
        if (numbers.length == 0) {
            return Formulas.valueOf(number);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        BigInteger lcm = BigInteger.valueOf(number.longValue());
        for (Number n : array) {
            lcm = lcmLcm(lcm, BigInteger.valueOf(n.longValue()));
        }
        return Formulas.valueOf(lcm);
    }

    public static BigInteger lcmGcd(BigInteger a, BigInteger b) {
        if (a.compareTo(b) == -1) {
            return lcmGcd(b, a);
        }
        if (a.longValue() % b.longValue() == 0) {
            return b;
        } else return lcmGcd(b, BigInteger.valueOf(a.longValue() % b.longValue()));
    }

    public static BigInteger lcmLcm(BigInteger a, BigInteger b) {
        return ((a.multiply(b)).divide(lcmGcd(a, b)));
    }

    public static FormulaDecimal geomean(Number number, Number... numbers) {
        // Returns the geometric mean of an array or range of positive data.
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal harmean(Number number, Number... numbers) {
        // Returns the harmonic mean of a data set. The harmonic mean is the reciprocal of the arithmetic mean of reciprocals.
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal product(Number number, Number... numbers) {
        // The PRODUCT function multiplies all the numbers given as arguments and returns the product.
        return new FormulaDecimal(Arrays.stream(ArrayHelper.prepend(Number.class, number, numbers))
                .map(new Function<Number, BigDecimal>() {
                    @Override
                    public BigDecimal apply(Number number) {
                        return new BigDecimal(number.toString());
                    }
                })
                .reduce(BigDecimal.ONE, BigDecimal::multiply));
    }

    public static FormulaDecimal sign(Number decimal) {
        // Determines the sign of a number. Returns 1 if the number is positive, zero (0) if the number is 0, and -1 if the number is negative.
        return Formulas.valueOf(Formulas.valueOf(decimal).compareTo(BigDecimal.ZERO));
    }

    public static FormulaDecimal sec(Number decimal) {
        // Returns the secant of an angle.
        return Formulas.valueOf(1).divide(cos(Formulas.valueOf(decimal)));
    }

    public static FormulaDecimal sech(Number decimal) {
        // Returns the hyperbolic secant of an angle.
        return Formulas.valueOf(1).divide(cosh(Formulas.valueOf(decimal)));
    }

    public static FormulaDecimal sqrtpi(Number decimal) {
        // Returns the square root of (number * pi).
        return sqrt(new FormulaDecimal(BigDecimalMath.pi(MathContext.DECIMAL128).multiply(Formulas.valueOf(decimal).asBigDecimal(), MathContext.DECIMAL128)));
    }

    public static FormulaDecimal atan(Number decimal) {
        return new FormulaDecimal(BigDecimalMath.atan(Formulas.valueOf(decimal).delegate, MathContext.DECIMAL128));
    }

    public static FormulaDecimal atan2(Number y, Number x) {
        return new FormulaDecimal(BigDecimalMath.atan2(Formulas.valueOf(y).delegate, Formulas.valueOf(x).delegate, MathContext.DECIMAL128));
    }

    public static FormulaDecimal asin(Number decimal) {
        return new FormulaDecimal(BigDecimalMath.asin(Formulas.valueOf(decimal).delegate, MathContext.DECIMAL128));
    }

    public static FormulaDecimal sinh(Number decimal) {
        return new FormulaDecimal(BigDecimalMath.sinh(Formulas.valueOf(decimal).delegate, MathContext.DECIMAL128));
    }

    public static FormulaDecimal tanh(Number decimal) {
        return new FormulaDecimal(BigDecimalMath.tanh(Formulas.valueOf(decimal).delegate, MathContext.DECIMAL128));
    }

    public static FormulaDecimal cosh(Number decimal) {
        return new FormulaDecimal(BigDecimalMath.cosh(Formulas.valueOf(decimal).delegate, MathContext.DECIMAL128));
    }

    public static FormulaDecimal log(Number decimal) {
        return new FormulaDecimal(BigDecimalMath.log(Formulas.valueOf(decimal).delegate, MathContext.DECIMAL128));
    }

    public static FormulaDecimal log(Number decimal, Number base) {
        if (Formulas.valueOf(base).compareTo(BigDecimal.TEN) == 0) {
            return log10(decimal);
        } else if (Formulas.valueOf(base).compareTo(BigDecimal.valueOf(2)) == 0) {
            return log2(decimal);
        } else {
            return new FormulaDecimal(BigDecimalMath.log(Formulas.valueOf(decimal).delegate, MathContext.DECIMAL128)
                    .divide(BigDecimalMath.log(Formulas.valueOf(base).delegate, MathContext.DECIMAL128), MathContext.DECIMAL128));
        }
    }

    public static FormulaDecimal log10(Number decimal) {
        return new FormulaDecimal(BigDecimalMath.log10(Formulas.valueOf(decimal).delegate, MathContext.DECIMAL128));
    }

    public static FormulaDecimal log2(Number decimal) {
        return new FormulaDecimal(BigDecimalMath.log2(Formulas.valueOf(decimal).delegate, MathContext.DECIMAL128));
    }

    public static FormulaDecimal ln(Number decimal) {
        return new FormulaDecimal(BigDecimalMath.log(Formulas.valueOf(decimal).delegate, MathContext.DECIMAL128));
    }

    public static FormulaDecimal sqrt(Number decimal) {
        return new FormulaDecimal(BigDecimalMath.sqrt(Formulas.valueOf(decimal).delegate, MathContext.DECIMAL128));
    }

    public static FormulaDecimal abs(Number decimal) {
        return new FormulaDecimal(Formulas.valueOf(decimal).delegate.abs(MathContext.DECIMAL128));
    }

    public static FormulaDecimal ceiling(Number decimal) {
        return ceil(decimal);
    }

    public static FormulaDecimal ceil(Number decimal) {
        return new FormulaDecimal(BigDecimal.valueOf(Math.ceil(decimal.doubleValue())));
    }

    public static FormulaDecimal ceiling(Number decimal, Number significance) {
        return ceil(decimal, significance);
    }

    public static FormulaDecimal ceil(Number decimal, Number significance) {
        if (Formulas.valueOf(decimal).compareTo(BigDecimal.ZERO) == 0 || Formulas.valueOf(significance).compareTo(BigDecimal.ZERO) == 0) {
            return Formulas.valueOf(BigDecimal.ZERO);
        }
        return Formulas.valueOf(decimal).divide(Formulas.valueOf(significance)).setScale(0, RoundingMode.CEILING).multiply(Formulas.valueOf(significance));
    }

    public static FormulaDecimal floor(Number decimal) {
        return new FormulaDecimal(BigDecimal.valueOf(Math.floor(decimal.doubleValue())));
    }

    public static FormulaDecimal floor(Number decimal, Number significance) {
        if (Formulas.valueOf(decimal).compareTo(BigDecimal.ZERO) == 0 || Formulas.valueOf(significance).compareTo(BigDecimal.ZERO) == 0) {
            return Formulas.valueOf(BigDecimal.ZERO);
        }
        return Formulas.valueOf(decimal).divide(Formulas.valueOf(significance)).setScale(0, RoundingMode.FLOOR).multiply(Formulas.valueOf(significance));
    }

    public static FormulaDecimal round(Number decimal) {
        return new FormulaDecimal(BigDecimal.valueOf(Math.round(decimal.doubleValue())));
    }

    public static FormulaDecimal round(Number decimal, Number numDigits) {
        return Formulas.valueOf(decimal).setScale(numDigits.intValue(), RoundingMode.HALF_EVEN);
    }

    public static FormulaDecimal rounddown(Number decimal) {
        return floor(decimal);
    }

    public static FormulaDecimal rounddown(Number decimal, Number numDigits) {
        return Formulas.valueOf(decimal).setScale(numDigits.intValue(), RoundingMode.DOWN);
    }

    public static FormulaDecimal roundup(Number decimal) {
        return ceil(decimal);
    }

    public static FormulaDecimal roundup(Number decimal, Number numDigits) {
        return Formulas.valueOf(decimal).setScale(numDigits.intValue(), RoundingMode.UP);
    }

    public static FormulaDecimal mdeterm(Number decimal, Number... decimals) {
        return mdeterm(ArrayHelper.prepend(decimal, decimals));
    }

    public static FormulaDecimal mdeterm(Number... decimals) {
        // Returns the matrix determinant of an array.
        return Formulas.valueOf(Matrix.det(Matrix.partitionDimensionsBigInteger(decimals)));
    }

    public static FormulaDecimal power(Number number, Number power) {
        // Returns the result of a number raised to a power.
        return Formulas.valueOf(BigDecimalMath.pow(Formulas.valueOf(number).delegate, Formulas.valueOf(power).delegate, MathContext.DECIMAL128));
    }

    public static FormulaDecimal quotient(Number numerator, Number denominator) {
        // Returns the integer portion of a division. Use this function when you want to discard the remainder of a division.
        return integral(Formulas.valueOf(numerator).divide(Formulas.valueOf(denominator)));
    }

    public static FormulaDecimal radians(Number decimal) {
        return rad(decimal);
    }

    public static FormulaDecimal rad(Number decimal) {
        return new FormulaDecimal(BigDecimal.valueOf(Math.toRadians(decimal.doubleValue())));
    }

    public static FormulaDecimal degrees(Number decimal) {
        return deg(decimal);
    }

    public static FormulaDecimal deg(Number decimal) {
        return new FormulaDecimal(BigDecimal.valueOf(Math.toDegrees(decimal.doubleValue())));
    }

    public static FormulaDecimal exp(Number decimal) {
        return new FormulaDecimal(BigDecimalMath.exp(Formulas.valueOf(decimal).delegate, MathContext.DECIMAL128));
    }

    public static FormulaDecimal cbrt(Number decimal) {
        return new FormulaDecimal(BigDecimal.valueOf(Math.cbrt(decimal.doubleValue())));
    }

    public static FormulaDecimal mod(Number number, Number divisor) {
        // Returns the remainder after number is divided by divisor. The result has the same sign as divisor.
        final FormulaDecimal mod = Formulas.valueOf(number).remainder(Formulas.valueOf(divisor));
        if (Formulas.valueOf(divisor).compareTo(BigDecimal.ZERO) >= 0) {
            if (mod.compareTo(BigDecimal.ZERO) > 0) {
                return mod;
            } else {
                return mod.negate();
            }
        } else {
            if (mod.compareTo(BigDecimal.ZERO) < 0) {
                return mod;
            } else {
                return mod.negate();
            }
        }
    }

    public static FormulaDecimal hypot(Number x, Number y) {
        return new FormulaDecimal(BigDecimal.valueOf(Math.hypot(x.doubleValue(), y.doubleValue())));
    }

    public static FormulaDecimal root(Number x, Number n) {
        return new FormulaDecimal(BigDecimalMath.root(Formulas.valueOf(x).delegate, Formulas.valueOf(n).delegate, MathContext.DECIMAL128));
    }

    public static FormulaDecimal factorial(Number number) {
        return new FormulaDecimal(BigDecimalMath.factorial(number.intValue()));
    }

    public static FormulaDecimal bernoulli(Number number) {
        return new FormulaDecimal(BigDecimalMath.bernoulli(number.intValue(), MathContext.DECIMAL128));
    }

    public static FormulaDecimal mantissa(Number decimal) {
        return new FormulaDecimal(BigDecimalMath.mantissa(Formulas.valueOf(decimal).delegate));
    }

    public static FormulaDecimal integral(Number decimal) {
        return new FormulaDecimal(BigDecimalMath.integralPart(Formulas.valueOf(decimal).delegate));
    }

    public static FormulaDecimal fraction(Number decimal) {
        return new FormulaDecimal(BigDecimalMath.fractionalPart(Formulas.valueOf(decimal).delegate));
    }

    public static FormulaDecimal min(Number number, Number... numbers) {
        return Formulas.valueOf(Collections.min(Arrays.asList(ArrayHelper.prepend(Number.class, number, numbers)),
                Comparator.nullsFirst(Comparator.comparing(o -> Formulas.valueOf(o).asBigDecimal()))));
    }

    public static FormulaDecimal max(Number number, Number... numbers) {
        return Formulas.valueOf(Collections.max(Arrays.asList(ArrayHelper.prepend(Number.class, number, numbers)),
                Comparator.nullsFirst(Comparator.comparing(o -> Formulas.valueOf(o).asBigDecimal()))));
    }

    public static FormulaDecimal sum(Number number, Number... numbers) {
        return new FormulaDecimal(Arrays.stream(ArrayHelper.prepend(Number.class, number, numbers))
                .map(n -> Formulas.valueOf(n).asBigDecimal())
                .reduce(BigDecimal.ZERO, BigDecimal::add));
    }

    public static FormulaDecimal avg(Number number, Number... numbers) {
        return new FormulaDecimal(Arrays.stream(ArrayHelper.prepend(Number.class, number, numbers))
                .map(n -> Formulas.valueOf(n).asBigDecimal())
                .collect(new BigDecimalAverageCollector()));
    }

    public static FormulaDecimal mean(Number number, Number... numbers) {
        return avg(number, numbers);
    }

    public static FormulaDecimal range(Number number, Number... numbers) {
        // TODO The difference between the largest and smallest data in a data set.
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal mode(Number number, Number... numbers) {
        // TODO The value which occures most frequently in a data set.
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static FormulaDecimal median(Number number, Number... numbers) {
        return new FormulaDecimal(median((BigDecimal[]) Arrays.stream(ArrayHelper.prepend(Number.class, number, numbers))
                .map(n -> Formulas.valueOf(n).asBigDecimal())
                .toArray(BigDecimal[]::new), 0, numbers.length));
    }

    protected static BigDecimal median(final BigDecimal[] bigDecimalNumbers, final int start, final int end) {
        final int size = end - start;

        if (size % 2 == 1) {
            return bigDecimalNumbers[start + (size + 1) / 2 - 1];
        } else {
            BigDecimal result = bigDecimalNumbers[start + (size) / 2 - 1];
            result = result.add(bigDecimalNumbers[start + (size) / 2]);
            return result.divide(BigDecimal.valueOf(2), MathContext.DECIMAL128);
        }
    }

    static class BigDecimalAverageCollector implements Collector<BigDecimal, BigDecimalAverageCollector.BigDecimalAccumulator, BigDecimal> {

        @Override
        public Supplier<BigDecimalAccumulator> supplier() {
            return BigDecimalAccumulator::new;
        }

        @Override
        public BiConsumer<BigDecimalAccumulator, BigDecimal> accumulator() {
            return BigDecimalAccumulator::add;
        }

        @Override
        public BinaryOperator<BigDecimalAccumulator> combiner() {
            return BigDecimalAccumulator::combine;
        }

        @Override
        public Function<BigDecimalAccumulator, BigDecimal> finisher() {
            return BigDecimalAccumulator::getAverage;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.emptySet();
        }

        static class BigDecimalAccumulator {
            private BigDecimal sum = BigDecimal.ZERO;
            private BigDecimal count = BigDecimal.ZERO;

            public BigDecimalAccumulator() {
                // default constructor
            }

            public BigDecimalAccumulator(BigDecimal sum, BigDecimal count) {
                this.sum = sum;
                this.count = count;
            }

            BigDecimal getAverage() {
                return BigDecimal.ZERO.compareTo(count) == 0 ?
                        BigDecimal.ZERO :
                        sum.divide(count, MathContext.DECIMAL128);
            }

            BigDecimalAccumulator combine(BigDecimalAccumulator another) {
                return new BigDecimalAccumulator(
                        sum.add(another.getSum()),
                        count.add(another.getCount())
                );
            }

            void add(BigDecimal successRate) {
                count = count.add(BigDecimal.ONE);
                sum = sum.add(successRate);
            }

            public BigDecimal getSum() {
                return sum;
            }

            public BigDecimal getCount() {
                return count;
            }
        }

    }
}
