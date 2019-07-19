package io.onsense.universe;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Koen Rooijmans
 */
public class Universals {

    @Nullable
    public static BigDecimal universal(@Nullable FormulaDecimal result) {
        if (result == null) {
            return null;
        }
        return result.asBigDecimal();
    }

    @Nullable
    public static <T extends Number> T universal(Class<T> expectedType, @Nullable FormulaDecimal result) {
        if (result == null) {
            return null;
        }
        if (expectedType.isAssignableFrom(Integer.class)) {
            return (T) (Integer) result.intValueExact();
        } else if (expectedType.isAssignableFrom(Long.class)) {
            return (T) (Long) result.longValueExact();
        } else if (expectedType.isAssignableFrom(Float.class)) {
            return (T) (Float) result.floatValue();
        } else if (expectedType.isAssignableFrom(Double.class)) {
            return (T) (Double) result.doubleValue();
        } else if (expectedType.isAssignableFrom(Short.class)) {
            return (T) (Short) result.shortValueExact();
        } else if (expectedType.isAssignableFrom(Byte.class)) {
            return (T) (Byte) result.byteValueExact();
        }
        return (T) result.asBigDecimal();
    }

    public static BigDecimal universal(@Nullable Number result) {
        if (result == null) {
            return null;
        }
        if (result instanceof FormulaDecimal) {
            return universal((FormulaDecimal) result);
        }
        return Formulas.valueOf(result).asBigDecimal();
    }

    public static <T extends Number> T universal(Class<T> expectedType, @Nullable Number result) {
        if (result == null) {
            return null;
        }
        if (result instanceof FormulaDecimal) {
            final BigDecimal unexpectedResult = universal((FormulaDecimal) result);

            if (expectedType.isAssignableFrom(Integer.class)) {
                return (T) (Integer) unexpectedResult.intValueExact();
            } else if (expectedType.isAssignableFrom(Long.class)) {
                return (T) (Long) unexpectedResult.longValueExact();
            } else if (expectedType.isAssignableFrom(Float.class)) {
                return (T) (Float) unexpectedResult.floatValue();
            } else if (expectedType.isAssignableFrom(Double.class)) {
                return (T) (Double) unexpectedResult.doubleValue();
            } else if (expectedType.isAssignableFrom(Short.class)) {
                return (T) (Short) unexpectedResult.shortValueExact();
            } else if (expectedType.isAssignableFrom(Byte.class)) {
                return (T) (Byte) unexpectedResult.byteValueExact();
            }

            return (T) unexpectedResult;
        }
        final BigDecimal unexpectedResult = Formulas.valueOf(result).asBigDecimal();

        if (expectedType.isAssignableFrom(Integer.class)) {
            return (T) (Integer) unexpectedResult.intValueExact();
        } else if (expectedType.isAssignableFrom(Long.class)) {
            return (T) (Long) unexpectedResult.longValueExact();
        } else if (expectedType.isAssignableFrom(Float.class)) {
            return (T) (Float) unexpectedResult.floatValue();
        } else if (expectedType.isAssignableFrom(Double.class)) {
            return (T) (Double) unexpectedResult.doubleValue();
        } else if (expectedType.isAssignableFrom(Short.class)) {
            return (T) (Short) unexpectedResult.shortValueExact();
        } else if (expectedType.isAssignableFrom(Byte.class)) {
            return (T) (Byte) unexpectedResult.byteValueExact();
        }

        return (T) unexpectedResult;
    }

    @Nullable
    public static String universal(@Nullable ExpressionString result) {
        if (result == null) {
            return null;
        }
        return result.getDelegate();
    }

    @Nullable
    public static String[] universal(@Nullable ExpressionString[] result) {
        if (result == null) {
            return null;
        }
        return Arrays.stream(result).map(ExpressionString::getDelegate).toArray(String[]::new);
    }

    @Nullable
    public static String[] universal(@Nullable String[] result) {
        if (result == null) {
            return null;
        }
        return result;
    }

    @Nullable
    public static String universal(@Nullable CharSequence result) {
        if (result == null) {
            return null;
        }
        if (result instanceof ExpressionString) {
            return universal((ExpressionString) result);
        }
        return result.toString();
    }

    @Nullable
    public static Date universal(@Nullable Moment result) {
        if (result == null) {
            return null;
        }
        return new Date(result.getTime());
    }

    @Nullable
    public static Date universal(@Nullable Date result) {
        if (result == null) {
            return null;
        }
        if (result instanceof Moment) {
            return universal((Moment) result);
        }
        return new Date(result.getTime());
    }

    @Nullable
    public static Boolean universal(@Nullable Logical result) {
        if (result == null) {
            return null;
        }
        return Logical.valueOf(result).booleanValue();
    }

    @Nullable
    public static Boolean universal(@Nullable Boolean result) {
        if (result == null) {
            return null;
        }
        return result;
    }
}
