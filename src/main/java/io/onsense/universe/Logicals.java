package io.onsense.universe;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * @author Koen Rooijmans
 */
public class Logicals {

    public static final Logical logicalTrue = Logical.TRUE;
    public static final Logical logicalFalse = Logical.FALSE;

    public static FormulaDecimal logicalIf(Logical logical, Number resultForTrue, Number resultForFalse) {
        if (Logical.valueOf(logical).booleanValue()) {
            return Formulas.valueOf(resultForTrue);
        } else {
            if (resultForFalse == null) {
                throw new UniversalException("resultForFalse", 0, UniversalException.ErrorType.VALUE);
            } else {
                return Formulas.valueOf(resultForFalse);
            }
        }
    }

    public static ExpressionString logicalIf(Logical logical, Number resultForTrue, CharSequence resultForFalse) {
        return logicalIf(logical, ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Logical logical, CharSequence resultForTrue, Number resultForFalse) {
        return logicalIf(logical, ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static Moment logicalIf(Logical logical, Date resultForTrue, Date resultForFalse) {
        if (Logical.valueOf(logical).booleanValue()) {
            return Moments.valueOf(resultForTrue);
        } else {
            if (resultForFalse == null) {
                throw new UniversalException("resultForFalse", 0, UniversalException.ErrorType.VALUE);
            } else {
                return Moments.valueOf(resultForFalse);
            }
        }
    }

    public static ExpressionString logicalIf(Logical logical, CharSequence resultForTrue, Date resultForFalse) {
        return logicalIf(logical, ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Logical logical, Date resultForTrue, CharSequence resultForFalse) {
        return logicalIf(logical, ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Logical logical, Number resultForTrue, Date resultForFalse) {
        return logicalIf(logical, ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Logical logical, Date resultForTrue, Number resultForFalse) {
        return logicalIf(logical, ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static Logical logicalIf(Logical logical, Boolean resultForTrue, Boolean resultForFalse) {
        return logicalIf(logical, Logical.valueOf(resultForTrue), Logical.valueOf(resultForFalse));
    }

    public static Logical logicalIf(Logical logical, Logical resultForTrue, Logical resultForFalse) {
        if (Logical.valueOf(logical).booleanValue()) {
            return Logical.valueOf(resultForTrue);
        } else {
            if (resultForFalse == null) {
                throw new UniversalException("resultForFalse", 0, UniversalException.ErrorType.VALUE);
            } else {
                return Logical.valueOf(resultForFalse);
            }
        }
    }

    public static ExpressionString logicalIf(Logical logical, Date resultForTrue, Boolean resultForFalse) {
        return logicalIf(logical, ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Logical logical, Boolean resultForTrue, Date resultForFalse) {
        return logicalIf(logical, ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Logical logical, Number resultForTrue, Boolean resultForFalse) {
        return logicalIf(logical, ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Logical logical, Boolean resultForTrue, Number resultForFalse) {
        return logicalIf(logical, ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Logical logical, CharSequence resultForTrue, Boolean resultForFalse) {
        return logicalIf(logical, ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Logical logical, Boolean resultForTrue, CharSequence resultForFalse) {
        return logicalIf(logical, ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Boolean logical, Number resultForTrue, Number resultForFalse) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Boolean logical, Number resultForTrue, CharSequence resultForFalse) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Boolean logical, CharSequence resultForTrue, Number resultForFalse) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Boolean logical, Date resultForTrue, Date resultForFalse) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Boolean logical, CharSequence resultForTrue, Date resultForFalse) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Boolean logical, Date resultForTrue, CharSequence resultForFalse) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Boolean logical, Number resultForTrue, Date resultForFalse) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Boolean logical, Date resultForTrue, Number resultForFalse) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Boolean logical, Boolean resultForTrue, Boolean resultForFalse) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Boolean logical, Date resultForTrue, Boolean resultForFalse) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Boolean logical, Boolean resultForTrue, Date resultForFalse) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Boolean logical, Number resultForTrue, Boolean resultForFalse) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Boolean logical, Boolean resultForTrue, Number resultForFalse) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Boolean logical, CharSequence resultForTrue, Boolean resultForFalse) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Boolean logical, Boolean resultForTrue, CharSequence resultForFalse) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Boolean logical, Logical resultForTrue, Logical resultForFalse) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Boolean logical, Date resultForTrue, Logical resultForFalse) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Boolean logical, Logical resultForTrue, Date resultForFalse) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Boolean logical, Number resultForTrue, Logical resultForFalse) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Boolean logical, Logical resultForTrue, Number resultForFalse) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Boolean logical, CharSequence resultForTrue, Logical resultForFalse) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Boolean logical, Logical resultForTrue, CharSequence resultForFalse) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Boolean logical, Boolean resultForTrue, Logical resultForFalse) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Boolean logical, Logical resultForTrue, Boolean resultForFalse) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Logical logical, Date resultForTrue, Logical resultForFalse) {
        return logicalIf(logical, ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Logical logical, Logical resultForTrue, Date resultForFalse) {
        return logicalIf(logical, ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Logical logical, Number resultForTrue, Logical resultForFalse) {
        return logicalIf(logical, ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Logical logical, Logical resultForTrue, Number resultForFalse) {
        return logicalIf(logical, ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Logical logical, CharSequence resultForTrue, Logical resultForFalse) {
        return logicalIf(logical, ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Logical logical, Logical resultForTrue, CharSequence resultForFalse) {
        return logicalIf(logical, ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Logical logical, Boolean resultForTrue, Logical resultForFalse) {
        return logicalIf(logical, ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Logical logical, Logical resultForTrue, Boolean resultForFalse) {
        return logicalIf(logical, ExpressionString.valueOf(resultForTrue), ExpressionString.valueOf(resultForFalse));
    }

    public static ExpressionString logicalIf(Logical logical, CharSequence resultForTrue) {
        return logicalIf(logical, ExpressionString.valueOf(resultForTrue), (CharSequence) null);
    }

    public static ExpressionString logicalIf(Logical logical, Number resultForTrue) {
        return logicalIf(logical, ExpressionString.valueOf(resultForTrue), (CharSequence) null);
    }

    public static ExpressionString logicalIf(Logical logical, Boolean resultForTrue) {
        return logicalIf(logical, ExpressionString.valueOf(resultForTrue), (CharSequence) null);
    }

    public static ExpressionString logicalIf(Logical logical, Date resultForTrue) {
        return logicalIf(logical, ExpressionString.valueOf(resultForTrue), (CharSequence) null);
    }

    public static ExpressionString logicalIf(Logical logical, Logical resultForTrue) {
        return logicalIf(logical, ExpressionString.valueOf(resultForTrue), (CharSequence) null);
    }

    public static ExpressionString logicalIf(Boolean logical, CharSequence resultForTrue) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), (CharSequence) null);
    }

    public static ExpressionString logicalIf(Boolean logical, Number resultForTrue) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), (CharSequence) null);
    }

    public static ExpressionString logicalIf(Boolean logical, Boolean resultForTrue) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), (CharSequence) null);
    }

    public static ExpressionString logicalIf(Boolean logical, Date resultForTrue) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), (CharSequence) null);
    }

    public static ExpressionString logicalIf(Boolean logical, Logical resultForTrue) {
        return logicalIf(Logical.valueOf(logical), ExpressionString.valueOf(resultForTrue), (CharSequence) null);
    }

    public static ExpressionString logicalIf(Logical logical, CharSequence resultForTrue, CharSequence resultForFalse) {
        if (Logical.valueOf(logical).booleanValue()) {
            return ExpressionString.valueOf(resultForTrue);
        } else {
            if (resultForFalse == null) {
                return ExpressionString.valueOf(Logical.FALSE);
            } else {
                return ExpressionString.valueOf(resultForFalse);
            }
        }
    }

    public static Logical logicalTrue() {
        return Logical.TRUE;
    }

    public static Logical logicalFalse() {
        return Logical.FALSE;
    }

    public static Logical logicalNot(Logical logical) {
        return Logical.valueOf(!Logical.valueOf(logical).booleanValue());
    }

    public static Logical logicalAnd(Boolean logical) {
        return Logical.valueOf(Logical.valueOf(logical).booleanValue());
    }

    public static Logical logicalAnd(Logical logical) {
        return Logical.valueOf(Logical.valueOf(logical).booleanValue());
    }

    public static Logical logicalAnd(Boolean logical, Boolean... logicals) {
        return Logical.valueOf(Logical.valueOf(logical).booleanValue() && Arrays.stream(logicals)
                .map(Logical::valueOf)
                .allMatch(Logical::booleanValue));
    }

    public static Logical logicalAnd(Logical logical, Boolean... logicals) {
        return Logical.valueOf(Logical.valueOf(logical).booleanValue() && Arrays.stream(logicals)
                .map(Logical::valueOf)
                .allMatch(Logical::booleanValue));
    }

    public static Logical logicalAnd(Boolean logical, Logical... logicals) {
        return Logical.valueOf(Logical.valueOf(logical).booleanValue() && Arrays.stream(logicals)
                .map(Logical::valueOf)
                .allMatch(Logical::booleanValue));
    }

    public static Logical logicalAnd(Logical logical, Logical... logicals) {
        return Logical.valueOf(Logical.valueOf(logical).booleanValue() && Arrays.stream(logicals)
                .map(Logical::valueOf)
                .allMatch(Logical::booleanValue));
    }

    public static Logical logicalOr(Boolean logical) {
        return Logical.valueOf(Logical.valueOf(logical).booleanValue());
    }

    public static Logical logicalOr(Logical logical) {
        return Logical.valueOf(Logical.valueOf(logical).booleanValue());
    }

    public static Logical logicalOr(Boolean logical, Boolean... logicals) {
        return Logical.valueOf(Logical.valueOf(logical).booleanValue() || Arrays.stream(logicals)
                .map(Logical::valueOf)
                .anyMatch(Logical::booleanValue));
    }

    public static Logical logicalOr(Boolean logical, Logical... logicals) {
        return Logical.valueOf(Logical.valueOf(logical).booleanValue() || Arrays.stream(logicals)
                .map(Logical::valueOf)
                .anyMatch(Logical::booleanValue));
    }

    public static Logical logicalOr(Logical logical, Boolean... logicals) {
        return Logical.valueOf(Logical.valueOf(logical).booleanValue() || Arrays.stream(logicals)
                .map(Logical::valueOf)
                .anyMatch(Logical::booleanValue));
    }

    public static Logical logicalOr(Logical logical, Logical... logicals) {
        return Logical.valueOf(Logical.valueOf(logical).booleanValue() || Arrays.stream(logicals)
                .map(Logical::valueOf)
                .anyMatch(Logical::booleanValue));
    }

    public static Logical logicalXor(Boolean logical) {
        return Logical.valueOf(Informations.isOdd(Stream.of(logical)
                .map(Logical::valueOf)
                .map(Logical::booleanValue)
                .filter(b -> b)
                .count()).booleanValue());
    }

    public static Logical logicalXor(Logical logical) {
        return Logical.valueOf(Informations.isOdd(Stream.of(logical)
                .map(Logical::valueOf)
                .map(Logical::booleanValue)
                .filter(b -> b)
                .count()).booleanValue());
    }

    public static Logical logicalXor(Boolean logical, Boolean... logicals) {
        return Logical.valueOf(Informations.isOdd(Arrays.stream(ArrayHelper.prepend(Logical.class, Logical.valueOf(logical), Arrays.stream(logicals)
                .map(Logical::valueOf).toArray(Logical[]::new)))
                .map(Logical::valueOf)
                .map(Logical::booleanValue)
                .filter(b -> b)
                .count()).booleanValue());
    }

    public static Logical logicalXor(Boolean logical, Logical... logicals) {
        return Logical.valueOf(Informations.isOdd(Arrays.stream(ArrayHelper.prepend(Logical.class, Logical.valueOf(logical), logicals))
                .map(Logical::valueOf)
                .map(Logical::booleanValue)
                .filter(b -> b)
                .count()).booleanValue());
    }

    public static Logical logicalXor(Logical logical, Boolean... logicals) {
        return Logical.valueOf(Informations.isOdd(Arrays.stream(ArrayHelper.prepend(Logical.class, logical, Arrays.stream(logicals)
                .map(Logical::valueOf).toArray(Logical[]::new)))
                .map(Logical::valueOf)
                .map(Logical::booleanValue)
                .filter(b -> b)
                .count()).booleanValue());
    }

    public static Logical logicalXor(Logical logical, Logical... logicals) {
        return Logical.valueOf(Informations.isOdd(Arrays.stream(ArrayHelper.prepend(Logical.class, logical, logicals))
                .map(Logical::valueOf)
                .map(Logical::booleanValue)
                .filter(b -> b)
                .count()).booleanValue());
    }

    public static ExpressionString logicalSwitch(Number expression, Object... array) {
        return logicalSwitch((Object) expression, array);
    }

    public static ExpressionString logicalSwitch(Date expression, Object... array) {
        return logicalSwitch((Object) expression, array);
    }

    public static ExpressionString logicalSwitch(CharSequence expression, Object... array) {
        return logicalSwitch((Object) expression, array);
    }

    public static ExpressionString logicalSwitch(Object expression, Object... array) {
        return ExpressionString.valueOf(doLogicalSwitch(expression, array));
    }

    public static FormulaDecimal logicalSwitch(Object expression, Number... array) {
        return Formulas.valueOfObject(doLogicalSwitch((Object) expression, (Object[]) array));
    }

    public static Moment logicalSwitch(Object expression, Date... array) {
        return Moments.valueOfObject(doLogicalSwitch((Object) expression, (Object[]) array));
    }

    public static FormulaDecimal logicalSwitch(Number expression, Number... array) {
        return Formulas.valueOfObject(doLogicalSwitch((Object) expression, (Object[]) array));
    }

    public static Moment logicalSwitch(Date expression, Date... array) {
        return Moments.valueOfObject(doLogicalSwitch((Object) expression, (Object[]) array));
    }

    public static Object doLogicalSwitch(Object expression, Object... array) {
        // NOTE: array can be in the orm of:
        // value1…value126, result1…result126, default
        // or
        // value1…value126, result1…result126

        if (array == null || array.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.NA);
        }

        if (array.length == 1) {
            return array[0];
        }

        final boolean hasDefaultValue = array.length % 2 != 0;
        final Object defaultValue;
        final Object[] range;
        if (hasDefaultValue) {
            range = Arrays.copyOfRange(array, 0, array.length - 1);
            defaultValue = array[array.length - 1];
        } else {
            range = Arrays.copyOfRange(array, 0, array.length);
            defaultValue = null;
        }
        final Object[] values = new Object[range.length / 2];
        final Object[] results = new Object[range.length / 2];

        int j = 0;
        for (int i = 0; i < range.length; i += 2) {
            values[j] = range[i];
            results[j] = range[i + 1];
            j++;
        }

        for (int i = 0; i < values.length; i++) {
            final Object value = values[i];
            if (Objects.equals(expression, value)) {
                return results[i];
            }
        }
        if (hasDefaultValue) {
            return defaultValue;
        } else {
            throw new UniversalException(UniversalException.ErrorType.NA);
        }
    }
}
