package io.onsense.universe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author Koen Rooijmans
 */
public class FormulaDecimalTest {

    @Before
    public void setUp() throws Exception {
        System.setProperty("user.timezone", "UTC");
    }

    @Test(timeout = 4000)
    public void test000() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf((-1L), (-1));
        FormulaDecimal formulaDecimal1 = FormulaDecimal.valueOf((-458.1851429682346));
        Logical logical0 = formulaDecimal1.neq(formulaDecimal0);
        assertTrue(logical0.booleanValue());
    }

    @Test(timeout = 4000)
    public void test001() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf((-18L));
        FormulaDecimal formulaDecimal1 = new FormulaDecimal(895L);
        Logical logical0 = formulaDecimal0.eq(formulaDecimal1);
        assertFalse(logical0.booleanValue());
    }

    @Test(timeout = 4000)
    public void test002() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        MathContext mathContext0 = MathContext.DECIMAL64;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0, mathContext0);
        FormulaDecimal formulaDecimal1 = FormulaDecimal.valueOf((-1L), 0);
        Logical logical0 = formulaDecimal1.lte(formulaDecimal0);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertTrue(logical0.booleanValue());
    }

    @Test(timeout = 4000)
    public void test003() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf((-1.0));
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        FormulaDecimal formulaDecimal1 = formulaDecimal0.max(bigDecimal0);
        Logical logical0 = formulaDecimal1.gte(formulaDecimal0);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertEquals("true", logical0.toString());
    }

    @Test(timeout = 4000)
    public void test004() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf((-1L), 0);
        BigInteger bigInteger0 = BigInteger.ONE;
        MathContext mathContext0 = MathContext.DECIMAL32;
        FormulaDecimal formulaDecimal1 = new FormulaDecimal(bigInteger0, (-3182), mathContext0);
        FormulaDecimal formulaDecimal2 = formulaDecimal0.divideToIntegralValue(formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal2);
    }

    @Test(timeout = 4000)
    public void test005() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        RoundingMode roundingMode0 = RoundingMode.HALF_DOWN;
        MathContext mathContext0 = new MathContext(0, roundingMode0);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0, mathContext0);
        FormulaDecimal formulaDecimal1 = new FormulaDecimal(0.0, mathContext0);
        FormulaDecimal formulaDecimal2 = formulaDecimal0.multiply(formulaDecimal1);
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal1));
    }

    @Test(timeout = 4000)
    public void test006() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(0.0);
        FormulaDecimal formulaDecimal1 = new FormulaDecimal(1113);
        formulaDecimal0.concat(formulaDecimal1);
        FormulaDecimal formulaDecimal2 = new FormulaDecimal(0L);
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal1));
    }

    @Test(timeout = 4000)
    public void test007() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((double) (-1L));
    }

    @Test(timeout = 4000)
    public void test008() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);
        BigInteger bigInteger1 = formulaDecimal0.unscaledValue();
        assertSame(bigInteger0, bigInteger1);
    }

    @Test(timeout = 4000)
    public void test009() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        MathContext mathContext0 = MathContext.DECIMAL64;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0, (-255), mathContext0);
        BigInteger bigInteger1 = formulaDecimal0.unscaledValue();
        assertEquals((byte) 10, bigInteger1.byteValue());
    }

    @Test(timeout = 4000)
    public void test010() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        MathContext mathContext0 = MathContext.DECIMAL128;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0, 1118, mathContext0);
        BigInteger bigInteger1 = formulaDecimal0.toBigIntegerExact();
        assertSame(bigInteger0, bigInteger1);
    }

    @Test(timeout = 4000)
    public void test011() throws Throwable {
        MathContext mathContext0 = MathContext.DECIMAL128;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-2641), mathContext0);
        BigInteger bigInteger0 = formulaDecimal0.toBigIntegerExact();
        assertEquals((byte) (-81), bigInteger0.byteValue());
    }

    @Test(timeout = 4000)
    public void test012() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf((long) (-6213), (-6213));
        BigInteger bigInteger0 = formulaDecimal0.toBigInteger();
        assertEquals((short) 0, bigInteger0.shortValue());
    }

    @Test(timeout = 4000)
    public void test013() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0, 0);
        BigInteger bigInteger1 = formulaDecimal0.toBigInteger();
        assertSame(bigInteger1, bigInteger0);
    }

    @Test(timeout = 4000)
    public void test014() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0, 500);
        int int0 = formulaDecimal0.signum();
        assertEquals(1, int0);
    }

    @Test(timeout = 4000)
    public void test015() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-2654));
        int int0 = formulaDecimal0.signum();
        assertEquals((-1), int0);
    }

    @Test(timeout = 4000)
    public void test016() throws Throwable {
        Random Random0 = new Random(0);
        BigInteger bigInteger0 = new BigInteger(0, Random0);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);
        short short0 = formulaDecimal0.shortValueExact();
        assertEquals((short) 0, short0);
    }

    @Test(timeout = 4000)
    public void test017() throws Throwable {
        MathContext mathContext0 = MathContext.DECIMAL32;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-257), mathContext0);
        short short0 = formulaDecimal0.shortValueExact();
        assertEquals((short) (-257), short0);
    }

    @Test(timeout = 4000)
    public void test018() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(0L, 0);
        short short0 = formulaDecimal0.shortValue();
        assertEquals((short) 0, short0);
    }

    @Test(timeout = 4000)
    public void test019() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        MathContext mathContext0 = MathContext.DECIMAL64;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0, (-1), mathContext0);
        short short0 = formulaDecimal0.shortValue();
        assertEquals((short) 10, short0);
    }

    @Test(timeout = 4000)
    public void test020() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(0.0);
        int int0 = formulaDecimal0.scale();
        assertEquals(1, int0);
    }

    @Test(timeout = 4000)
    public void test021() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(547);
        MathContext mathContext0 = MathContext.DECIMAL32;
        FormulaDecimal formulaDecimal1 = formulaDecimal0.pow(547, mathContext0);
        int int0 = formulaDecimal1.scale();
        assertEquals((-1491), int0);
    }

    @Test(timeout = 4000)
    public void test022() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        MathContext mathContext0 = MathContext.DECIMAL64;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0, mathContext0);
        FormulaDecimal formulaDecimal1 = formulaDecimal0.remainder(formulaDecimal0, mathContext0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test023() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);
        long long0 = formulaDecimal0.longValueExact();
        assertEquals(0L, long0);
    }

    @Test(timeout = 4000)
    public void test024() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf((-1.0));
        long long0 = formulaDecimal0.longValueExact();
        assertEquals((-1L), long0);
    }

    @Test(timeout = 4000)
    public void test025() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(0.0);
        FormulaDecimal formulaDecimal1 = new FormulaDecimal(1113);
        MathContext mathContext0 = MathContext.UNLIMITED;
        FormulaDecimal formulaDecimal2 = formulaDecimal0.divideToIntegralValue(formulaDecimal1, mathContext0);
        long long0 = formulaDecimal2.longValue();
        assertEquals(0L, long0);
    }

    @Test(timeout = 4000)
    public void test026() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-1));
        long long0 = formulaDecimal0.longValue();
        assertEquals((-1L), long0);
    }

    @Test(timeout = 4000)
    public void test027() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0, 3452);
        int int0 = formulaDecimal0.intValueExact();
        assertEquals(0, int0);
    }

    @Test(timeout = 4000)
    public void test028() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf((-2613L));
        int int0 = formulaDecimal0.intValueExact();
        assertEquals((-2613), int0);
    }

    @Test(timeout = 4000)
    public void test029() throws Throwable {
        byte[] byteArray0 = new byte[5];
        byteArray0[2] = (byte) (-101);
        BigInteger bigInteger0 = new BigInteger(byteArray0);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);
        int int0 = formulaDecimal0.intValue();
        assertEquals(10158080, int0);
    }

    @Test(timeout = 4000)
    public void test030() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        MathContext mathContext0 = MathContext.DECIMAL64;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0, mathContext0);
        FormulaDecimal formulaDecimal1 = formulaDecimal0.remainder(formulaDecimal0);
        float float0 = formulaDecimal1.floatValue();
        assertEquals(0.0F, float0, 0.01F);
    }

    @Test(timeout = 4000)
    public void test031() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf((-18L));
        float float0 = formulaDecimal0.floatValue();
        assertEquals((-18.0F), float0, 0.01F);
    }

    @Test(timeout = 4000)
    public void test032() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(0.0);
        double double0 = formulaDecimal0.doubleValue();
        assertEquals(0.0, double0, 0.01);
    }

    @Test(timeout = 4000)
    public void test033() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf((-1328.0987));
        double double0 = formulaDecimal0.doubleValue();
        assertEquals((-1328.0987), double0, 0.01);
    }

    @Test(timeout = 4000)
    public void test034() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        RoundingMode roundingMode0 = RoundingMode.HALF_DOWN;
        MathContext mathContext0 = new MathContext(0, roundingMode0);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0, mathContext0);
        BigDecimal bigDecimal0 = BigDecimal.TEN;
        int int0 = formulaDecimal0.compareTo(bigDecimal0);
        assertEquals(0, int0);
    }

    @Test(timeout = 4000)
    public void test035() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        BigDecimal bigDecimal0 = BigDecimal.TEN;
        FormulaDecimal formulaDecimal1 = formulaDecimal0.max(bigDecimal0);
        MathContext mathContext0 = MathContext.DECIMAL128;
        FormulaDecimal formulaDecimal2 = formulaDecimal1.add(formulaDecimal0, mathContext0);
        int int0 = formulaDecimal2.compareTo(bigDecimal0);
        assertEquals(1, int0);
    }

    @Test(timeout = 4000)
    public void test036() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);
        MathContext mathContext0 = MathContext.DECIMAL64;
        FormulaDecimal formulaDecimal1 = new FormulaDecimal((-1.0), mathContext0);
        int int0 = formulaDecimal0.compareTo(formulaDecimal1);
        assertEquals(1, int0);
    }

    @Test(timeout = 4000)
    public void test037() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf((-2613L));
        FormulaDecimal formulaDecimal1 = formulaDecimal0.divide(formulaDecimal0);
        int int0 = formulaDecimal0.compareTo(formulaDecimal1);
        assertEquals((-1), int0);
    }

    @Test(timeout = 4000)
    public void test038() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        byte byte0 = formulaDecimal0.byteValueExact();
        assertEquals((byte) 1, byte0);
    }

    @Test(timeout = 4000)
    public void test039() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(0L, 0);
        byte byte0 = formulaDecimal0.byteValue();
        assertEquals((byte) 0, byte0);
    }

    @Test(timeout = 4000)
    public void test040() throws Throwable {
        MathContext mathContext0 = MathContext.DECIMAL128;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0L, mathContext0);
        BigDecimal bigDecimal0 = formulaDecimal0.asBigDecimal();
        assertEquals((short) 0, bigDecimal0.shortValue());
    }

    @Test(timeout = 4000)
    public void test041() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf((-1.0));
        BigDecimal bigDecimal0 = formulaDecimal0.asBigDecimal();
        assertEquals((byte) (-1), bigDecimal0.byteValue());
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test042() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-2338.34952));
        formulaDecimal0.toBigIntegerExact();
        fail("Expecting exception: ArithmeticException");
    }

    @Test(timeout = 4000)
    public void test043() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(0L);
        MathContext mathContext0 = MathContext.DECIMAL32;

        formulaDecimal0.subtract((FormulaDecimal) null, mathContext0);
    }

    @Test(timeout = 4000)
    public void test044() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1.0);
        formulaDecimal0.subtract((FormulaDecimal) null);
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test045() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(5103.83340420198);

        formulaDecimal0.shortValueExact();
        fail("Expecting exception: ArithmeticException");
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test046() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        RoundingMode roundingMode0 = RoundingMode.UNNECESSARY;

        formulaDecimal0.setScale((-555), roundingMode0);
        fail("Expecting exception: ArithmeticException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test047() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        MathContext mathContext0 = MathContext.DECIMAL64;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0, mathContext0);
        formulaDecimal0.setScale(0, (-1874));
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000)
    public void test048() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((BigDecimal) null);
        formulaDecimal0.scale();
    }

    @Test(timeout = 4000)
    public void test049() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1L);
        formulaDecimal0.round((MathContext) null);
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test050() throws Throwable {
        byte[] byteArray0 = new byte[6];
        BigInteger bigInteger0 = new BigInteger(byteArray0);
        MathContext mathContext0 = MathContext.DECIMAL128;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0, 1, mathContext0);
        formulaDecimal0.remainder((FormulaDecimal) null, mathContext0);
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test051() throws Throwable {
        RoundingMode roundingMode0 = RoundingMode.UNNECESSARY;
        MathContext mathContext0 = new MathContext(1, roundingMode0);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1, mathContext0);

        formulaDecimal0.remainder((FormulaDecimal) null);
    }

    @Test(timeout = 4000)
    public void test052() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((BigDecimal) null);

        formulaDecimal0.precision();
    }

    @Test(timeout = 4000)
    public void test053() throws Throwable {
        MathContext mathContext0 = MathContext.DECIMAL128;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(372.743, mathContext0);

        formulaDecimal0.pow((Number) formulaDecimal0, (MathContext) null);
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test054() throws Throwable {
        byte[] byteArray0 = new byte[2];
        BigInteger bigInteger0 = new BigInteger(byteArray0);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0, (byte) (-1));
        MathContext mathContext0 = MathContext.UNLIMITED;
        formulaDecimal0.pow((Number) (byte) (-1), mathContext0);
        fail("Expecting exception: ArithmeticException");
    }

    @Test(timeout = 4000)
    public void test055() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-1));

        formulaDecimal0.pow((Number) null);
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test056() throws Throwable {
        byte[] byteArray0 = new byte[4];
        byteArray0[0] = (byte) (-68);
        BigInteger bigInteger0 = new BigInteger(byteArray0);
        MathContext mathContext0 = MathContext.DECIMAL64;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0, mathContext0);

        formulaDecimal0.pow((Number) bigInteger0);
    }

    @Test(timeout = 4000)
    public void test057() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-1));

        formulaDecimal0.pow((int) (byte) (-1), (MathContext) null);
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test058() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(0.0);

        formulaDecimal0.pow((-1));
        fail("Expecting exception: ArithmeticException");
    }

    @Test(timeout = 4000)
    public void test059() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal((-6280L));
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);
        formulaDecimal0.plus((MathContext) null);
    }

    @Test(timeout = 4000)
    public void test060() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf((-1096L));

        formulaDecimal0.negate((MathContext) null);
    }

    @Test(timeout = 4000)
    public void test061() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf((-2018L));
        RoundingMode roundingMode0 = RoundingMode.HALF_DOWN;
        MathContext mathContext0 = new MathContext(1, roundingMode0);

        formulaDecimal0.multiply((FormulaDecimal) null, mathContext0);
    }

    @Test(timeout = 4000)
    public void test062() throws Throwable {
        byte[] byteArray0 = new byte[11];
        BigInteger bigInteger0 = new BigInteger(byteArray0);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);
        formulaDecimal0.min((BigDecimal) null);
    }

    @Test(timeout = 4000)
    public void test063() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(0.0);
        formulaDecimal0.max((BigDecimal) null);
    }

    @Test(timeout = 4000)
    public void test064() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(0L);
        formulaDecimal0.lte((FormulaDecimal) null);
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test065() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0, (-2544));

        formulaDecimal0.longValueExact();
        fail("Expecting exception: ArithmeticException");
    }

    @Test(timeout = 4000)
    public void test066() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((BigDecimal) null);
        formulaDecimal0.longValue();
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test067() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        MathContext mathContext0 = MathContext.UNLIMITED;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0, 1742, mathContext0);

        formulaDecimal0.intValueExact();
        fail("Expecting exception: ArithmeticException");
    }

    @Test(timeout = 4000)
    public void test068() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf((-999.38463));
        formulaDecimal0.gte((FormulaDecimal) null);
    }

    @Test(timeout = 4000)
    public void test069() throws Throwable {
        MathContext mathContext0 = MathContext.DECIMAL128;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0L, mathContext0);

        formulaDecimal0.gt((FormulaDecimal) null);
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test070() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0, 500);
        RoundingMode roundingMode0 = RoundingMode.DOWN;
        MathContext mathContext0 = new MathContext(233, roundingMode0);

        formulaDecimal0.divideToIntegralValue((FormulaDecimal) null, mathContext0);
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test071() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0.0);
        MathContext mathContext0 = MathContext.DECIMAL32;
        formulaDecimal0.divideToIntegralValue(formulaDecimal0, mathContext0);
        fail("Expecting exception: ArithmeticException");
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test072() throws Throwable {
        Random Random0 = new Random(0);
        BigInteger bigInteger0 = new BigInteger(0, Random0);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);

        formulaDecimal0.divideToIntegralValue(formulaDecimal0);
        fail("Expecting exception: ArithmeticException");

    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test073() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-1.0));
        RoundingMode roundingMode0 = RoundingMode.DOWN;

        formulaDecimal0.divide((FormulaDecimal) null, roundingMode0);
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test074() throws Throwable {
        MathContext mathContext0 = MathContext.DECIMAL128;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0, mathContext0);
        RoundingMode roundingMode0 = RoundingMode.HALF_UP;

        formulaDecimal0.divide(formulaDecimal0, roundingMode0);
        fail("Expecting exception: ArithmeticException");

    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test075() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0, 500);
        MathContext mathContext0 = MathContext.DECIMAL64;
        formulaDecimal0.divide((FormulaDecimal) null, mathContext0);
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test076() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);
        MathContext mathContext0 = MathContext.DECIMAL64;

        formulaDecimal0.divide(formulaDecimal0, mathContext0);
        fail("Expecting exception: ArithmeticException");
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test077() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        RoundingMode roundingMode0 = RoundingMode.UNNECESSARY;
        MathContext mathContext0 = new MathContext(3871, roundingMode0);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0, (-1993), mathContext0);
        formulaDecimal0.divide((FormulaDecimal) null, (-1993), roundingMode0);
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test078() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(0.0);
        RoundingMode roundingMode0 = RoundingMode.FLOOR;

        formulaDecimal0.divide(formulaDecimal0, 1113, roundingMode0);
        fail("Expecting exception: ArithmeticException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test079() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((BigDecimal) null);

        formulaDecimal0.divide(formulaDecimal0, (-1), 1609);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test080() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-6213));

        formulaDecimal0.divide(formulaDecimal0, 471, (-3643));
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test081() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf((-1328.0987));
        FormulaDecimal formulaDecimal1 = new FormulaDecimal(0);

        formulaDecimal0.divide(formulaDecimal1, 3477, 0);
        fail("Expecting exception: ArithmeticException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test082() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((BigDecimal) null);

        formulaDecimal0.divide((FormulaDecimal) null, (-92));
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test083() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0L);

        formulaDecimal0.divide(formulaDecimal0, 461);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test084() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);

        formulaDecimal0.divide((FormulaDecimal) null);
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test085() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(398L);
        FormulaDecimal formulaDecimal1 = formulaDecimal0.remainder(formulaDecimal0);

        formulaDecimal1.divide(formulaDecimal1);
        fail("Expecting exception: ArithmeticException");
    }

    @Test(timeout = 4000)
    public void test086() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);

        formulaDecimal0.concat((FormulaDecimal) null);
    }

    @Test(timeout = 4000)
    public void test087() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0.0);

        formulaDecimal0.compareTo((BigDecimal) null);
    }

    @Test(timeout = 4000)
    public void test088() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(0L, 0);

        formulaDecimal0.compareTo((FormulaDecimal) null);
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test089() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(2266.5);

        formulaDecimal0.byteValueExact();
        fail("Expecting exception: ArithmeticException");
    }

    @Test(timeout = 4000)
    public void test090() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf((-1.0));
        RoundingMode roundingMode0 = RoundingMode.CEILING;
        MathContext mathContext0 = new MathContext(1, roundingMode0);
        formulaDecimal0.add((FormulaDecimal) null, mathContext0);
    }

    @Test(timeout = 4000)
    public void test091() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf((-2246.0));

        formulaDecimal0.add((FormulaDecimal) null);
    }

    @Test(timeout = 4000)
    public void test092() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(1L, (-1889));

        formulaDecimal0.abs((MathContext) null);
    }

    @Test(timeout = 4000)
    public void test093() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((BigDecimal) null);

        formulaDecimal0.abs();
    }

    @Test(timeout = 4000, expected = NumberFormatException.class)
    public void test094() throws Throwable {
        char[] charArray0 = new char[2];
        MathContext mathContext0 = MathContext.UNLIMITED;
        FormulaDecimal formulaDecimal0 = null;
        formulaDecimal0 = new FormulaDecimal(charArray0, mathContext0);
        fail("Expecting exception: NumberFormatException");

    }

    @Test(timeout = 4000)
    public void test096() throws Throwable {
        FormulaDecimal formulaDecimal0 = null;

        formulaDecimal0 = new FormulaDecimal((char[]) null, 658, 658);
    }

    @Test(timeout = 4000)
    public void test097() throws Throwable {
        FormulaDecimal formulaDecimal0 = null;

        formulaDecimal0 = new FormulaDecimal((char[]) null);
    }

    @Test(timeout = 4000)
    public void test098() throws Throwable {
        MathContext mathContext0 = MathContext.UNLIMITED;
        FormulaDecimal formulaDecimal0 = null;
        formulaDecimal0 = new FormulaDecimal((BigInteger) null, mathContext0);
    }

    @Test(timeout = 4000)
    public void test099() throws Throwable {
        MathContext mathContext0 = MathContext.UNLIMITED;
        FormulaDecimal formulaDecimal0 = null;

        formulaDecimal0 = new FormulaDecimal((BigInteger) null, (-2871), mathContext0);
    }

    @Test(timeout = 4000)
    public void test100() throws Throwable {
        FormulaDecimal formulaDecimal0 = null;
        formulaDecimal0 = new FormulaDecimal((BigInteger) null, 1);
    }

    @Test(timeout = 4000)
    public void test101() throws Throwable {
        FormulaDecimal formulaDecimal0 = null;

        formulaDecimal0 = new FormulaDecimal((BigInteger) null);
    }

    @Test(timeout = 4000, expected = NumberFormatException.class)
    public void test102() throws Throwable {
        RoundingMode roundingMode0 = RoundingMode.CEILING;
        MathContext mathContext0 = new MathContext(4549, roundingMode0);
        FormulaDecimal formulaDecimal0 = null;

        formulaDecimal0 = new FormulaDecimal("", mathContext0);
        fail("Expecting exception: NumberFormatException");
    }

    @Test(timeout = 4000)
    public void test103() throws Throwable {
        MathContext mathContext0 = MathContext.DECIMAL64;
        FormulaDecimal formulaDecimal0 = null;

        formulaDecimal0 = new FormulaDecimal((String) null, mathContext0);
    }

    @Test(timeout = 4000, expected = NumberFormatException.class)
    public void test104() throws Throwable {
        FormulaDecimal formulaDecimal0 = null;
        formulaDecimal0 = new FormulaDecimal("+1j");
        fail("Expecting exception: NumberFormatException");
    }

    @Test(timeout = 4000)
    public void test105() throws Throwable {
        FormulaDecimal formulaDecimal0 = null;

        formulaDecimal0 = new FormulaDecimal((-1L), (MathContext) null);
    }

    @Test(timeout = 4000)
    public void test106() throws Throwable {
        FormulaDecimal formulaDecimal0 = null;

        formulaDecimal0 = new FormulaDecimal(0, (MathContext) null);
    }

    @Test(timeout = 4000)
    public void test107() throws Throwable {
        FormulaDecimal formulaDecimal0 = null;

        formulaDecimal0 = new FormulaDecimal(1116.4721202, (MathContext) null);
    }

    @Test(timeout = 4000)
    public void test108() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        RoundingMode roundingMode0 = RoundingMode.HALF_EVEN;
        MathContext mathContext0 = new MathContext(0, roundingMode0);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0, mathContext0);
        short short0 = formulaDecimal0.shortValueExact();
        assertEquals((short) 1, short0);
    }

    @Test(timeout = 4000)
    public void test109() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);
        String string0 = formulaDecimal0.toString();
        assertEquals("1", string0);
    }

    @Test(timeout = 4000)
    public void test110() throws Throwable {
        MathContext mathContext0 = MathContext.DECIMAL128;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal("2.0", mathContext0);
    }

    @Test(timeout = 4000)
    public void test111() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(2871.9);
        FormulaDecimal formulaDecimal1 = formulaDecimal0.setScale(1558);
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test112() throws Throwable {
        MathContext mathContext0 = MathContext.UNLIMITED;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(2129.43, mathContext0);
        String string0 = formulaDecimal0.toPlainString();
        FormulaDecimal formulaDecimal1 = new FormulaDecimal(string0);
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
    }

    @Test(timeout = 4000)
    public void test113() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf((-1.0));
        int int0 = formulaDecimal0.intValue();
        assertEquals((-1), int0);
    }

    @Test(timeout = 4000)
    public void test114() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(0.0);
        Logical logical0 = formulaDecimal0.neq(formulaDecimal0);
        assertEquals("false", logical0.toString());
    }

    @Test(timeout = 4000)
    public void test115() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0.0);
        Logical logical0 = formulaDecimal0.eq(formulaDecimal0);
        assertTrue(logical0.booleanValue());
    }

    @Test(timeout = 4000)
    public void test116() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        FormulaDecimal formulaDecimal1 = formulaDecimal0.movePointLeft((-555));
        Logical logical0 = formulaDecimal1.eq(formulaDecimal0);
        assertFalse(logical0.booleanValue());
    }

    @Test(timeout = 4000)
    public void test117() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(398L);
        Logical logical0 = formulaDecimal0.lte(formulaDecimal0);
        assertEquals("true", logical0.toString());
    }

    @Test(timeout = 4000)
    public void test118() throws Throwable {
        RoundingMode roundingMode0 = RoundingMode.HALF_EVEN;
        MathContext mathContext0 = new MathContext(0, roundingMode0);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(2.0, mathContext0);
        FormulaDecimal formulaDecimal1 = formulaDecimal0.movePointRight((-1));
        Logical logical0 = formulaDecimal0.lte(formulaDecimal1);
        assertFalse(logical0.booleanValue());
    }

    @Test(timeout = 4000)
    public void test119() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0.0);
        FormulaDecimal formulaDecimal1 = new FormulaDecimal(1);
        Logical logical0 = formulaDecimal0.lt(formulaDecimal1);
        assertEquals("true", logical0.toString());
    }

    @Test(timeout = 4000)
    public void test120() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(398L);
        Logical logical0 = formulaDecimal0.lt(formulaDecimal0);
        assertEquals("false", logical0.toString());
    }

    @Test(timeout = 4000)
    public void test121() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        Logical logical0 = formulaDecimal0.gte(formulaDecimal0);
        assertEquals("true", logical0.toString());
    }

    @Test(timeout = 4000)
    public void test122() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(815L, 1);
        BigDecimal bigDecimal0 = BigDecimal.TEN;
        FormulaDecimal formulaDecimal1 = formulaDecimal0.min(bigDecimal0);
        Logical logical0 = formulaDecimal1.gte(formulaDecimal0);
        assertEquals("false", logical0.toString());
    }

    @Test(timeout = 4000)
    public void test123() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(815L, 1);
        FormulaDecimal formulaDecimal1 = new FormulaDecimal(8);
        Logical logical0 = formulaDecimal0.gt(formulaDecimal1);
        assertEquals("true", logical0.toString());
    }

    @Test(timeout = 4000)
    public void test124() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(398L);
        Logical logical0 = formulaDecimal0.gt(formulaDecimal0);
        assertEquals("false", logical0.toString());
    }

    @Test(timeout = 4000)
    public void test126() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(398L);
        boolean boolean0 = formulaDecimal0.equals((Object) null);
        assertFalse(boolean0);
    }

    @Test(timeout = 4000)
    public void test127() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-6213));
        int int0 = formulaDecimal0.scale();
        assertEquals(0, int0);
    }

    @Test(timeout = 4000)
    public void test128() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        int int0 = formulaDecimal0.intValueExact();
        assertEquals(1, int0);
    }

    @Test(timeout = 4000)
    public void test129() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        FormulaDecimal formulaDecimal1 = formulaDecimal0.divide(formulaDecimal0, 0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }

    @Test(timeout = 4000)
    public void test131() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        FormulaDecimal formulaDecimal1 = formulaDecimal0.ulp();
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test132() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(398L);
        FormulaDecimal formulaDecimal1 = formulaDecimal0.subtract(formulaDecimal0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }

    @Test(timeout = 4000)
    public void test133() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        BigInteger bigInteger0 = formulaDecimal0.toBigIntegerExact();
        FormulaDecimal formulaDecimal1 = new FormulaDecimal(bigInteger0, 1);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
    }

    @Test(timeout = 4000)
    public void test134() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(398L);
        byte byte0 = formulaDecimal0.byteValue();
        assertEquals((byte) (-114), byte0);
    }

    @Test(timeout = 4000)
    public void test135() throws Throwable {
        MathContext mathContext0 = MathContext.DECIMAL128;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-2641), mathContext0);
        short short0 = formulaDecimal0.shortValue();
        assertEquals((short) (-2641), short0);
    }

    @Test(timeout = 4000)
    public void test136() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-6213));
        BigInteger bigInteger0 = formulaDecimal0.unscaledValue();
        assertEquals((short) (-6213), bigInteger0.shortValue());
    }

    @Test(timeout = 4000)
    public void test137() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        FormulaDecimal formulaDecimal1 = formulaDecimal0.stripTrailingZeros();
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }

    @Test(timeout = 4000)
    public void test138() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf((-1L));

        formulaDecimal0.eq((FormulaDecimal) null);
    }

    @Test(timeout = 4000)
    public void test139() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-6213));
        MathContext mathContext0 = MathContext.DECIMAL32;
        FormulaDecimal formulaDecimal1 = formulaDecimal0.pow((Number) formulaDecimal0, mathContext0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }

    @Test(timeout = 4000)
    public void test140() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        FormulaDecimal formulaDecimal1 = formulaDecimal0.setScale(1, 1);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
    }

    @Test(timeout = 4000)
    public void test141() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        RoundingMode roundingMode0 = RoundingMode.DOWN;
        FormulaDecimal formulaDecimal1 = formulaDecimal0.divide(formulaDecimal0, roundingMode0);
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
    }

    @Test(timeout = 4000)
    public void test142() throws Throwable {
        byte[] byteArray0 = new byte[4];
        BigInteger bigInteger0 = new BigInteger(byteArray0);
        MathContext mathContext0 = MathContext.DECIMAL64;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0, mathContext0);
        int int0 = formulaDecimal0.signum();
        assertEquals(0, int0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test143() throws Throwable {
        MathContext mathContext0 = MathContext.DECIMAL128;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-2641), mathContext0);
        formulaDecimal0.concat(formulaDecimal0);
        fail("Expecting exception: NumberFormatException");
    }

    @Test(timeout = 4000)
    public void test144() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(815L, 1);
        FormulaDecimal formulaDecimal1 = formulaDecimal0.plus();
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test145() throws Throwable {
        byte[] byteArray0 = new byte[4];
        BigInteger bigInteger0 = new BigInteger(byteArray0);
        MathContext mathContext0 = MathContext.DECIMAL64;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0, mathContext0);
        FormulaDecimal formulaDecimal1 = formulaDecimal0.round(mathContext0);
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
    }

    @Test(timeout = 4000)
    public void test146() throws Throwable {
        MathContext mathContext0 = MathContext.DECIMAL128;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        FormulaDecimal formulaDecimal1 = formulaDecimal0.divide(formulaDecimal0, mathContext0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }

    @Test(timeout = 4000, expected = NumberFormatException.class)
    public void test147() throws Throwable {
        char[] charArray0 = new char[4];
        FormulaDecimal formulaDecimal0 = null;
        formulaDecimal0 = new FormulaDecimal(charArray0);
        fail("Expecting exception: NumberFormatException");
    }

    @Test(timeout = 4000)
    public void test148() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-6213));
        BigInteger bigInteger0 = formulaDecimal0.toBigInteger();
        assertEquals((short) (-6213), bigInteger0.shortValue());
    }

    @Test(timeout = 4000)
    public void test149() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        FormulaDecimal formulaDecimal1 = formulaDecimal0.divide(formulaDecimal0, 1, 1);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
    }

    @Test(timeout = 4000)
    public void test150() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        long long0 = formulaDecimal0.longValue();
        assertEquals(1L, long0);
    }

    @Test(timeout = 4000)
    public void test151() throws Throwable {
        FormulaDecimal formulaDecimal0 = null;

        formulaDecimal0 = new FormulaDecimal((String) null);
    }

    @Test(timeout = 4000)
    public void test152() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        MathContext mathContext0 = MathContext.DECIMAL128;
        FormulaDecimal formulaDecimal1 = formulaDecimal0.subtract(formulaDecimal0, mathContext0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test153() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        BigDecimal bigDecimal0 = BigDecimal.TEN;
        FormulaDecimal formulaDecimal1 = formulaDecimal0.max(bigDecimal0);
        MathContext mathContext0 = MathContext.DECIMAL128;
        FormulaDecimal formulaDecimal2 = formulaDecimal0.divideToIntegralValue(formulaDecimal1, mathContext0);

        formulaDecimal0.divide(formulaDecimal2, 0);
        fail("Expecting exception: ArithmeticException");
    }

    @Test(timeout = 4000)
    public void test154() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        double double0 = formulaDecimal0.doubleValue();
        assertEquals(1.0, double0, 0.01);
    }

    @Test(timeout = 4000)
    public void test155() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        int int0 = formulaDecimal0.precision();
        assertEquals(1, int0);
    }

    @Test(timeout = 4000)
    public void test156() throws Throwable {
        MathContext mathContext0 = MathContext.DECIMAL64;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-1.0), mathContext0);
        byte byte0 = formulaDecimal0.byteValueExact();
        assertEquals((byte) (-1), byte0);
    }

    @Test(timeout = 4000)
    public void test157() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        String string0 = formulaDecimal0.toEngineeringString();
        assertEquals("1", string0);
    }

    @Test(timeout = 4000)
    public void test158() throws Throwable {
        MathContext mathContext0 = MathContext.DECIMAL128;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-2641), mathContext0);
        FormulaDecimal formulaDecimal1 = formulaDecimal0.negate();
        byte byte0 = formulaDecimal1.byteValue();
        assertEquals((byte) 81, byte0);
    }

    @Test(timeout = 4000)
    public void test159() throws Throwable {
        char[] charArray0 = new char[0];
        FormulaDecimal formulaDecimal0 = null;
        formulaDecimal0 = new FormulaDecimal(charArray0, 0, (-1));
        Assert.assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test160() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        Assert.assertNotNull(formulaDecimal0.hashCode());
    }

    @Test(timeout = 4000)
    public void test161() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        MathContext mathContext0 = MathContext.DECIMAL64;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0, (-1), mathContext0);
        float float0 = formulaDecimal0.floatValue();
        assertEquals(10.0F, float0, 0.01F);
    }

    @Test(timeout = 4000)
    public void test162() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        MathContext mathContext0 = MathContext.DECIMAL128;
        FormulaDecimal formulaDecimal1 = formulaDecimal0.plus(mathContext0);
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
    }

    @Test(timeout = 4000)
    public void test163() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        FormulaDecimal formulaDecimal1 = formulaDecimal0.pow((Number) formulaDecimal0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }

    @Test(timeout = 4000, expected = NumberFormatException.class)
    public void test164() throws Throwable {
        char[] charArray0 = new char[5];
        MathContext mathContext0 = MathContext.DECIMAL32;
        FormulaDecimal formulaDecimal0 = null;

        formulaDecimal0 = new FormulaDecimal(charArray0, 1214, 1103, mathContext0);
        fail("Expecting exception: NumberFormatException");

    }

    @Test(timeout = 4000)
    public void test165() throws Throwable {
        MathContext mathContext0 = MathContext.DECIMAL128;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-2641), mathContext0);
        FormulaDecimal formulaDecimal1 = formulaDecimal0.add(formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test166() throws Throwable {
        byte[] byteArray0 = new byte[4];
        BigInteger bigInteger0 = new BigInteger(byteArray0);
        MathContext mathContext0 = MathContext.DECIMAL64;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0, mathContext0);
        FormulaDecimal formulaDecimal1 = formulaDecimal0.abs();
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
    }

    @Test(timeout = 4000)
    public void test167() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        MathContext mathContext0 = MathContext.DECIMAL128;
        FormulaDecimal formulaDecimal1 = formulaDecimal0.multiply(formulaDecimal0, mathContext0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test168() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        long long0 = formulaDecimal0.longValueExact();
        assertEquals(1L, long0);
    }

    @Test(timeout = 4000)
    public void test169() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(815L, 1);
        FormulaDecimal formulaDecimal1 = formulaDecimal0.scaleByPowerOfTen(8);
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test170() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0);
        MathContext mathContext0 = MathContext.DECIMAL128;

        formulaDecimal0.remainder(formulaDecimal0, mathContext0);
        fail("Expecting exception: ArithmeticException");
    }

    @Test(timeout = 4000)
    public void test171() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(398L);
        FormulaDecimal formulaDecimal1 = formulaDecimal0.remainder(formulaDecimal0);
        Logical logical0 = formulaDecimal0.neq(formulaDecimal1);
        assertTrue(logical0.booleanValue());
    }

    @Test(timeout = 4000)
    public void test172() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0.0);
        byte byte0 = formulaDecimal0.byteValueExact();
        assertEquals((byte) 0, byte0);
    }

    @Test(timeout = 4000)
    public void test173() throws Throwable {
        MathContext mathContext0 = MathContext.DECIMAL64;
        FormulaDecimal formulaDecimal0 = null;
        formulaDecimal0 = new FormulaDecimal((char[]) null, mathContext0);

    }

    @Test(timeout = 4000)
    public void test174() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(398L);
        RoundingMode roundingMode0 = RoundingMode.HALF_UP;
        Integer integer0 = new Integer(0);
        FormulaDecimal formulaDecimal1 = formulaDecimal0.divide(formulaDecimal0, (int) integer0, roundingMode0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }

    @Test(timeout = 4000)
    public void test175() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0.0);
        RoundingMode roundingMode0 = RoundingMode.UP;
        FormulaDecimal formulaDecimal1 = formulaDecimal0.setScale((int) (short) 1, roundingMode0);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
    }

    @Test(timeout = 4000)
    public void test176() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(2.0);
        MathContext mathContext0 = MathContext.DECIMAL128;
        FormulaDecimal formulaDecimal1 = formulaDecimal0.abs(mathContext0);
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
    }

    @Test(timeout = 4000)
    public void test177() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0.0);
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        int int0 = formulaDecimal0.compareTo(bigDecimal0);
        assertEquals((-1), int0);
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test178() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0.0);
        MathContext mathContext0 = MathContext.DECIMAL128;

        formulaDecimal0.pow((-1849), mathContext0);
        fail("Expecting exception: ArithmeticException");
    }

    @Test(timeout = 4000)
    public void test179() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(2.0);
        BigDecimal bigDecimal0 = formulaDecimal0.asBigDecimal();
        assertEquals((byte) 2, bigDecimal0.byteValue());
    }

    @Test(timeout = 4000)
    public void test180() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf((long) (-2641), (-2641));
        FormulaDecimal formulaDecimal1 = formulaDecimal0.pow((-1));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
    }

    @Test(timeout = 4000)
    public void test181() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        MathContext mathContext0 = MathContext.DECIMAL128;
        FormulaDecimal formulaDecimal1 = formulaDecimal0.negate(mathContext0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test182() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-1195L));

        Assert.assertNotNull(formulaDecimal0.setScale((-1)));
    }

    @Test(timeout = 4000)
    public void test183() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((BigDecimal) null);
        formulaDecimal0.floatValue();
    }
}
