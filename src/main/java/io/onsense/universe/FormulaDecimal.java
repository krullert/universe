package io.onsense.universe;

import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @author Koen Rooijmans
 */
public class FormulaDecimal extends Number implements Comparable<FormulaDecimal> {

    public static final FormulaDecimal ZERO = new FormulaDecimal(BigDecimal.ZERO);
    public static final FormulaDecimal ONE = new FormulaDecimal(BigDecimal.ONE);
    public static final FormulaDecimal TEN = new FormulaDecimal(BigDecimal.TEN);

    protected final BigDecimal delegate;

    public FormulaDecimal(BigDecimal delegate) {
        this.delegate = delegate == null ? BigDecimal.ZERO : delegate;
    }

    public FormulaDecimal(char[] in, int offset, int len) {
        this((in == null || in.length == 0) ? BigDecimal.ZERO : new BigDecimal(in, offset, len));
    }

    public FormulaDecimal(char[] in, int offset, int len, MathContext mc) {
        this((in == null || in.length == 0) ? BigDecimal.ZERO : new BigDecimal(in, offset, len, mc == null ? MathContext.DECIMAL128 : mc));
    }

    public FormulaDecimal(char[] in) {
        this((in == null || in.length == 0) ? BigDecimal.ZERO : new BigDecimal(in));
    }


    public FormulaDecimal(char[] in, MathContext mc) {
        this((in == null || in.length == 0) ? BigDecimal.ZERO : new BigDecimal(in, mc == null ? MathContext.DECIMAL128 : mc));
    }

    public FormulaDecimal(String val) {
        this(val == null ? BigDecimal.ZERO : new BigDecimal(val));
    }

    public FormulaDecimal(String val, MathContext mc) {
        this(val == null ? BigDecimal.ZERO : new BigDecimal(val, mc == null ? MathContext.DECIMAL128 : mc));
    }

    public FormulaDecimal(double val) {
        this(new BigDecimal(val));
    }

    public FormulaDecimal(double val, MathContext mc) {
        this(new BigDecimal(val, mc == null ? MathContext.DECIMAL128 : mc));
    }

    public FormulaDecimal(BigInteger val) {
        this(new BigDecimal(val == null ? BigInteger.ZERO : val));
    }

    public FormulaDecimal(BigInteger val, MathContext mc) {
        this(new BigDecimal(val == null ? BigInteger.ZERO : val, mc == null ? MathContext.DECIMAL128 : mc));
    }

    public FormulaDecimal(BigInteger unscaledVal, int scale) {
        this(new BigDecimal(unscaledVal == null ? BigInteger.ZERO : unscaledVal, scale));
    }

    public FormulaDecimal(BigInteger unscaledVal, int scale, MathContext mc) {
        this(new BigDecimal(unscaledVal == null ? BigInteger.ZERO : unscaledVal, scale, mc == null ? MathContext.DECIMAL128 : mc));
    }

    public FormulaDecimal(int val) {
        this(new BigDecimal(val));
    }

    public FormulaDecimal(int val, MathContext mc) {
        this(new BigDecimal(val, mc == null ? MathContext.DECIMAL128 : mc));
    }

    public FormulaDecimal(long val) {
        this(new BigDecimal(val));
    }

    public FormulaDecimal(long val, MathContext mc) {
        this(new BigDecimal(val, mc == null ? MathContext.DECIMAL128 : mc));
    }

    public static FormulaDecimal valueOf(long unscaledVal, int scale) {
        return new FormulaDecimal(BigDecimal.valueOf(unscaledVal, scale));
    }

    public static FormulaDecimal valueOf(long val) {
        return new FormulaDecimal(BigDecimal.valueOf(val));
    }

    public static FormulaDecimal valueOf(double val) {
        return new FormulaDecimal(BigDecimal.valueOf(val));
    }

    public static FormulaDecimal valueOf(FormulaDecimal val) {
        if (val == null) {
            return ZERO;
        } else {
            return val;
        }
    }

    public ExpressionString add(CharSequence augend) {
        if (augend == null) {
            return ExpressionString.valueOf(delegate.toString());
        }
        return ExpressionString.valueOf(delegate.toString() + ExpressionString.valueOf(augend));
    }

    public FormulaDecimal add(FormulaDecimal augend) {
        return new FormulaDecimal(delegate.add(Formulas.valueOf(augend).delegate));
    }

    public FormulaDecimal add(FormulaDecimal augend, MathContext mc) {
        if (mc == null) {
            return new FormulaDecimal(delegate.add(Formulas.valueOf(augend).delegate, MathContext.DECIMAL128));
        }
        return new FormulaDecimal(delegate.add(Formulas.valueOf(augend).delegate, mc));
    }

    public FormulaDecimal subtract(FormulaDecimal subtract) {
        return new FormulaDecimal(delegate.subtract(Formulas.valueOf(subtract).delegate));
    }

    public FormulaDecimal subtract(FormulaDecimal subtrahend, MathContext mc) {
        if (mc == null) {
            return new FormulaDecimal(delegate.subtract(Formulas.valueOf(subtrahend).delegate, MathContext.DECIMAL128));
        }
        return new FormulaDecimal(delegate.subtract(Formulas.valueOf(subtrahend).delegate, mc));
    }

    public FormulaDecimal multiply(FormulaDecimal multiplicand) {
        return new FormulaDecimal(delegate.multiply(Formulas.valueOf(multiplicand).delegate));
    }

    public FormulaDecimal multiply(FormulaDecimal multiplicand, MathContext mc) {
        if (mc == null) {
            return new FormulaDecimal(delegate.multiply(Formulas.valueOf(multiplicand).delegate, MathContext.DECIMAL128));
        }
        return new FormulaDecimal(delegate.multiply(Formulas.valueOf(multiplicand).delegate, mc));
    }

    public FormulaDecimal divide(FormulaDecimal divisor, int scale, int roundingMode) {
        return new FormulaDecimal(delegate.divide(Formulas.valueOf(divisor).delegate, scale, roundingMode));
    }

    public FormulaDecimal divide(FormulaDecimal divisor, int scale, RoundingMode roundingMode) {
        if (roundingMode == null) {
            return new FormulaDecimal(delegate.divide(Formulas.valueOf(divisor).delegate, scale, RoundingMode.HALF_EVEN));
        }
        return new FormulaDecimal(delegate.divide(Formulas.valueOf(divisor).delegate, scale, roundingMode));
    }

    public FormulaDecimal divide(FormulaDecimal divisor, int roundingMode) {
        return new FormulaDecimal(delegate.divide(Formulas.valueOf(divisor).delegate, roundingMode));
    }

    public FormulaDecimal divide(FormulaDecimal divisor, RoundingMode roundingMode) {
        if (roundingMode == null) {
            return new FormulaDecimal(delegate.divide(Formulas.valueOf(divisor).delegate, RoundingMode.HALF_EVEN));
        }
        return new FormulaDecimal(delegate.divide(Formulas.valueOf(divisor).delegate, roundingMode));
    }

    public FormulaDecimal divide(FormulaDecimal divisor) {
        return new FormulaDecimal(delegate.divide(Formulas.valueOf(divisor).delegate, MathContext.DECIMAL128));
    }

    public FormulaDecimal divide(FormulaDecimal divisor, MathContext mc) {
        if (mc == null) {
            return new FormulaDecimal(delegate.divide(Formulas.valueOf(divisor).delegate, MathContext.DECIMAL128));
        }
        return new FormulaDecimal(delegate.divide(Formulas.valueOf(divisor).delegate, mc));
    }

    public FormulaDecimal divideToIntegralValue(FormulaDecimal divisor) {
        return new FormulaDecimal(delegate.divideToIntegralValue(Formulas.valueOf(divisor).delegate));
    }

    public FormulaDecimal divideToIntegralValue(FormulaDecimal divisor, MathContext mc) {
        if (mc == null) {
            return new FormulaDecimal(delegate.divideToIntegralValue(Formulas.valueOf(divisor).delegate, MathContext.DECIMAL128));
        }
        return new FormulaDecimal(delegate.divideToIntegralValue(Formulas.valueOf(divisor).delegate, mc));
    }

    public FormulaDecimal remainder(FormulaDecimal divisor) {
        return new FormulaDecimal(delegate.remainder(Formulas.valueOf(divisor).delegate));
    }

    public FormulaDecimal remainder(FormulaDecimal divisor, MathContext mc) {
        if (mc == null) {
            return new FormulaDecimal(delegate.remainder(Formulas.valueOf(divisor).delegate, MathContext.DECIMAL128));
        }
        return new FormulaDecimal(delegate.remainder(Formulas.valueOf(divisor).delegate, mc));
    }

//    public FormulaDecimal[] divideAndRemainder(BigDecimal divisor) {
//        return new FormulaDecimal(delegate.divideAndRemainder(divisor);
//    }
//
//    public FormulaDecimal[] divideAndRemainder(BigDecimal divisor, MathContext mc) {
//        return new FormulaDecimal(delegate.divideAndRemainder(divisor, mc);
//    }

    public FormulaDecimal pow(int n) {
        if (Formulas.valueOf(n).compareTo(BigDecimal.ZERO) == 0) {
            return ONE;
        }
        return new FormulaDecimal(delegate.pow(n, MathContext.DECIMAL128));
    }

    public FormulaDecimal pow(int n, MathContext mc) {
        if (Formulas.valueOf(n).compareTo(BigDecimal.ZERO) == 0) {
            return ONE;
        }
        if (mc == null) {
            return new FormulaDecimal(delegate.pow(n, MathContext.DECIMAL128));
        }
        return new FormulaDecimal(delegate.pow(n, mc));
    }

    public FormulaDecimal pow(Number n) {
        if (Formulas.valueOf(n).compareTo(BigDecimal.ZERO) == 0) {
            return ONE;
        }
        return new FormulaDecimal(delegate.pow(n.intValue(), MathContext.DECIMAL128));
    }

    public FormulaDecimal pow(Number n, MathContext mc) {
        if (Formulas.valueOf(n).compareTo(BigDecimal.ZERO) == 0) {
            return ONE;
        }
        if (mc == null) {
            return new FormulaDecimal(delegate.pow(n.intValue(), MathContext.DECIMAL128));
        }
        return new FormulaDecimal(delegate.pow(n.intValue(), mc));
    }

    public FormulaDecimal abs() {
        return new FormulaDecimal(delegate.abs());
    }

    public FormulaDecimal abs(MathContext mc) {
        if (mc == null) {
            return new FormulaDecimal(delegate.abs(MathContext.DECIMAL128));
        }
        return new FormulaDecimal(delegate.abs(mc));
    }

    public FormulaDecimal negate() {
        return new FormulaDecimal(delegate.negate());
    }

    public FormulaDecimal negate(MathContext mc) {
        if (mc == null) {
            return new FormulaDecimal(delegate.negate(MathContext.DECIMAL128));
        }
        return new FormulaDecimal(delegate.negate(mc));
    }

    public FormulaDecimal plus() {
        return new FormulaDecimal(delegate.plus());
    }

    public FormulaDecimal plus(MathContext mc) {
        if (mc == null) {
            return new FormulaDecimal(delegate.plus(MathContext.DECIMAL128));
        }
        return new FormulaDecimal(delegate.plus(mc));
    }

    public int signum() {
        return delegate.signum();
    }

    public int scale() {
        return delegate.scale();
    }

    public int precision() {
        return delegate.precision();
    }

    public BigInteger unscaledValue() {
        return delegate.unscaledValue();
    }

    public FormulaDecimal round(MathContext mc) {
        if (mc == null) {
            return new FormulaDecimal(delegate.round(MathContext.DECIMAL128));
        }
        return new FormulaDecimal(delegate.round(mc));
    }

    public FormulaDecimal setScale(int newScale, RoundingMode roundingMode) {
        if (roundingMode == null) {
            return new FormulaDecimal(delegate.setScale(newScale, BigDecimal.ROUND_HALF_EVEN));
        }
        return new FormulaDecimal(delegate.setScale(newScale, roundingMode));
    }

    public FormulaDecimal setScale(int newScale, int roundingMode) {
        return new FormulaDecimal(delegate.setScale(newScale, roundingMode));
    }

    public FormulaDecimal setScale(int newScale) {
        return new FormulaDecimal(delegate.setScale(newScale, BigDecimal.ROUND_HALF_EVEN));
    }

    public FormulaDecimal movePointLeft(int n) {
        return new FormulaDecimal(delegate.movePointLeft(n));
    }

    public FormulaDecimal movePointRight(int n) {
        return new FormulaDecimal(delegate.movePointRight(n));
    }

    public FormulaDecimal scaleByPowerOfTen(int n) {
        return new FormulaDecimal(delegate.scaleByPowerOfTen(n));
    }

    public FormulaDecimal stripTrailingZeros() {
        return new FormulaDecimal(delegate.stripTrailingZeros());
    }

    public int compareTo(BigDecimal val) {
        return delegate.compareTo(val == null ? BigDecimal.ZERO : val);
    }

    @Override
    public boolean equals(Object x) {
        if (x instanceof FormulaDecimal) {
            return delegate.equals(((FormulaDecimal) x).delegate);
        }
        return delegate.equals(x);
    }

    public FormulaDecimal min(BigDecimal val) {
        return new FormulaDecimal(delegate.min(val == null ? BigDecimal.ZERO : val));
    }

    public FormulaDecimal max(BigDecimal val) {
        return new FormulaDecimal(delegate.max(val == null ? BigDecimal.ZERO : val));
    }

    @Override
    public int hashCode() {
        return delegate.hashCode();
    }

    @Override
    public String toString() {
        return delegate.toString();
    }

    public String toEngineeringString() {
        return delegate.toEngineeringString();
    }

    public String toPlainString() {
        return delegate.toPlainString();
    }

    public BigInteger toBigInteger() {
        return delegate.toBigInteger();
    }

    public BigInteger toBigIntegerExact() {
        return delegate.toBigIntegerExact();
    }

    @Override
    public long longValue() {
        return delegate.longValue();
    }

    public long longValueExact() {
        return delegate.longValueExact();
    }

    @Override
    public int intValue() {
        return delegate.intValue();
    }

    public int intValueExact() {
        return delegate.intValueExact();
    }

    public short shortValueExact() {
        return delegate.shortValueExact();
    }

    public byte byteValueExact() {
        return delegate.byteValueExact();
    }

    @Override
    public float floatValue() {
        return delegate.floatValue();
    }

    @Override
    public double doubleValue() {
        return delegate.doubleValue();
    }

    public FormulaDecimal ulp() {
        return new FormulaDecimal(delegate.ulp());
    }

    @Override
    public byte byteValue() {
        return delegate.byteValue();
    }

    @Override
    public short shortValue() {
        return delegate.shortValue();
    }

    public BigDecimal asBigDecimal() {
        return delegate;
    }

    public Logical gt(FormulaDecimal other) {
        return new Logical(delegate.compareTo(Formulas.valueOf(other).delegate) == 1);
    }

    public Logical gte(FormulaDecimal other) {
        return new Logical(delegate.compareTo(Formulas.valueOf(other).delegate) >= 0);
    }

    public Logical lt(FormulaDecimal other) {
        return new Logical(delegate.compareTo(Formulas.valueOf(other).delegate) == -1);
    }

    public Logical lte(FormulaDecimal other) {
        return new Logical(delegate.compareTo(Formulas.valueOf(other).delegate) <= 0);
    }

    public Logical eq(FormulaDecimal other) {
        return new Logical(delegate.compareTo(Formulas.valueOf(other).delegate) == 0);
    }

    public Logical neq(FormulaDecimal other) {
        return new Logical(delegate.compareTo(Formulas.valueOf(other).delegate) != 0);
    }

    public FormulaDecimal concat(FormulaDecimal other) {
        return Formulas.valueOf(this.toString() + Formulas.valueOf(other).toString());
    }

    @Override
    public int compareTo(@Nonnull FormulaDecimal o) {
        return delegate.compareTo(Formulas.valueOf(o).delegate);
    }
}
