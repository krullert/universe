package io.onsense.universe;

import org.apache.commons.math3.exception.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.nio.CharBuffer;

import static org.junit.Assert.*;

/**
 * @author Koen Rooijmans
 */
public class StatisticsTest {

    @Before
    public void setUp() throws Exception {
        System.setProperty("user.timezone", "UTC");
    }

    @Test
    public void testPearson() {
        Assert.assertEquals(Statistics.pearson(new Integer[]{9, 7, 5, 3, 1}, new Integer[]{10, 6, 1, 5, 3}), Statistics.pearson(9, new Integer[]{7, 5, 3, 1, 10, 6, 1, 5, 3}));
    }

    @Test
    public void testPercentRankExc() {
        Assert.assertEquals(Statistics.percentrank_exc(new Integer[]{9, 7, 5, 3, 1, 10, 6, 1, 5}, 3), Statistics.percentrank_exc(9, new Integer[]{7, 5, 3, 1, 10, 6, 1, 5, 3}));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test000() throws Throwable {
        Float float0 = new Float(0.75);
        Number[] numberArray0 = new Number[7];
        Assert.assertNull(Statistics.t_test(float0, numberArray0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test001() throws Throwable {
        Number[] numberArray0 = new Number[4];
        Assert.assertNotNull(Statistics.slope((Number) null, numberArray0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test002() throws Throwable {
        Float float0 = new Float(0.0);
        Float[] floatArray0 = new Float[4];
        floatArray0[0] = float0;
        floatArray0[3] = float0;
        Assert.assertNotNull(Statistics.prob(floatArray0[1], floatArray0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test003() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal(1233);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);
        Number[] numberArray0 = new Number[1];
        numberArray0[0] = (Number) formulaDecimal0;
        Assert.assertNotNull(Statistics.large(bigDecimal0, numberArray0));
    }

    @Test(timeout = 4000)
    public void test004() throws Throwable {
        Integer integer0 = Integer.valueOf(1133);
        FormulaDecimal formulaDecimal0 = Statistics.standardize(integer0, integer0, integer0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test005() throws Throwable {
        Float float0 = new Float(0.0);
        Float[] floatArray0 = new Float[4];
        floatArray0[0] = float0;
        floatArray0[1] = float0;
        FormulaDecimal formulaDecimal0 = Statistics.prob(floatArray0[1], floatArray0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test006() throws Throwable {
        Short short0 = new Short((short) 0);
        Object[] objectArray0 = new Object[0];
        FormulaDecimal formulaDecimal0 = Statistics.mina((Object) short0, objectArray0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test007() throws Throwable {
        Object[] objectArray0 = new Object[1];
        FormulaDecimal formulaDecimal0 = Statistics.average("io.onsense.universe.Statistics$8", objectArray0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test008() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        BigDecimal bigDecimal0 = new BigDecimal(bigInteger0);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);
        Number[] numberArray0 = new Number[9];
        Assert.assertNotNull(Statistics.z_test(formulaDecimal0, numberArray0));
    }

    @Test(timeout = 4000)
    public void test009() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.countblank();
        Number[] numberArray0 = new Number[7];
        Statistics.var_s(formulaDecimal0, numberArray0);
    }

    @Test(timeout = 4000)
    public void test010() throws Throwable {
        Number[] numberArray0 = new Number[9];
        Assert.assertNotNull(Statistics.var_s((Number) null, numberArray0));
    }

    @Test(timeout = 4000)
    public void test011() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        Number[] numberArray0 = new Number[6];
        Assert.assertNotNull(Statistics.var_p(bigDecimal0, numberArray0));
    }

    @Test(timeout = 4000)
    public void test012() throws Throwable {
        Short short0 = new Short((short) 0);
        BigDecimal bigDecimal0 = BigDecimal.ZERO;
        Number[] numberArray0 = new Number[5];
        numberArray0[0] = (Number) bigDecimal0;
        Assert.assertNotNull(Statistics.trimmean(short0, numberArray0));
    }

    @Test(timeout = 4000)
    public void test013() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal(0.75);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);
        Boolean boolean0 = Boolean.valueOf(true);
        Assert.assertNotNull(Statistics.t_dist((Number) formulaDecimal0, (Number) bigDecimal0, boolean0));
    }

    @Test(timeout = 4000)
    public void test014() throws Throwable {
        Double double0 = new Double((-3413.7910782493723));
        Number[] numberArray0 = new Number[4];
        numberArray0[0] = (Number) double0;
        Assert.assertNotNull(Statistics.sumOfSquares(double0, numberArray0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test015() throws Throwable {
        BigDecimal[] bigDecimalArray0 = new BigDecimal[8];
        BigDecimal bigDecimal0 = new BigDecimal((-929));
        bigDecimalArray0[3] = bigDecimal0;
        Assert.assertNotNull(Statistics.steyx(bigDecimal0, bigDecimalArray0));
    }

    @Ignore
    @Test(timeout = 4000)
    public void test016() throws Throwable {
        Long long0 = new Long(1514L);
        Assert.assertNotNull(Statistics.steyx(long0, (Number[]) null));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test017() throws Throwable {
        Number[] numberArray0 = new Number[0];
        Assert.assertNotNull(Statistics.stdev_s((Number) null, numberArray0));
    }

    @Test(timeout = 4000)
    public void test018() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0L);
        Number[] numberArray0 = new Number[9];
        numberArray0[0] = (Number) formulaDecimal0;
        numberArray0[8] = (Number) formulaDecimal0;

        Assert.assertNotNull(Statistics.small(formulaDecimal0, numberArray0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test019() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.counta();
        Number[] numberArray0 = new Number[5];
        Assert.assertNotNull(Statistics.small(formulaDecimal0, numberArray0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test021() throws Throwable {
        Float float0 = new Float(823.1F);
        Assert.assertNotNull(Statistics.skew(float0, (Number[]) null));
    }

    @Test(timeout = 4000)
    public void test023() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal(1L);
        Number[] numberArray0 = new Number[2];
        numberArray0[0] = (Number) bigDecimal0;
        numberArray0[1] = (Number) bigDecimal0;

        Assert.assertNotNull(Statistics.quartile_inc(bigDecimal0, numberArray0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test026() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.TEN;
        Statistics.poisson_dist((Number) bigDecimal0, (Number) bigDecimal0, (Logical) null);
    }

    @Test(timeout = 4000)
    public void test027() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        Number[] numberArray0 = new Number[3];
        numberArray0[0] = (Number) bigInteger0;

        Assert.assertNotNull(Statistics.percentrank_exc(bigInteger0, numberArray0));

    }

    @Test(timeout = 4000)
    public void test028() throws Throwable {
        Number[] numberArray0 = new Number[11];
        BigInteger bigInteger0 = BigInteger.ZERO;
        Assert.assertNotNull(Statistics.percentrank_exc(bigInteger0, numberArray0));
    }

    @Test(timeout = 4000)
    public void test029() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.TEN;
        FormulaDecimal[] formulaDecimalArray0 = new FormulaDecimal[7];
        Assert.assertNotNull(Statistics.percentrank_exc(bigDecimal0, formulaDecimalArray0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test030() throws Throwable {
        Integer integer0 = new Integer(1243);
        Number[] numberArray0 = new Number[6];
        numberArray0[0] = (Number) integer0;
        Assert.assertNotNull(Statistics.percentile_inc(integer0, numberArray0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test031() throws Throwable {
        Number[] numberArray0 = new Number[9];

        Assert.assertNotNull(Statistics.percentile_inc(numberArray0[6], numberArray0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test032() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.TEN;
        Number[] numberArray0 = new Number[1];
        numberArray0[0] = (Number) bigDecimal0;
        Assert.assertNotNull(Statistics.percentile_inc(bigDecimal0, numberArray0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test033() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);
        Number[] numberArray0 = new Number[1];

        Assert.assertNotNull(Statistics.percentile_inc(formulaDecimal0, numberArray0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test034() throws Throwable {
        Number[] numberArray0 = new Number[6];

        Assert.assertNotNull(Statistics.percentile_exc(numberArray0[2], numberArray0));
    }

    @Ignore
    @Test(timeout = 4000)
    public void test035() throws Throwable {
        Object object0 = new Object();
        Object[] objectArray0 = new Object[6];

        Assert.assertNotNull(Statistics.min(object0, objectArray0));
    }

    @Test(timeout = 4000)
    public void test036() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.TEN;
        Object[] objectArray0 = new Object[3];
        objectArray0[0] = (Object) bigDecimal0;

        Assert.assertNotNull(Statistics.min((Object) bigDecimal0, objectArray0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test037() throws Throwable {
        Number[] numberArray0 = new Number[5];
        RoundingMode roundingMode0 = RoundingMode.HALF_DOWN;

        Assert.assertNotNull(Statistics.min((Object) roundingMode0, (Object[]) numberArray0));
    }

    @Test(timeout = 4000)
    public void test038() throws Throwable {
        Long long0 = new Long(460L);
        Object[] objectArray0 = new Object[1];
        objectArray0[0] = (Object) long0;

        Assert.assertNotNull(Statistics.maxa((Object) long0, objectArray0));
    }

    @Test(timeout = 4000)
    public void test039() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ZERO;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);
        Number[] numberArray0 = new Number[1];
        numberArray0[0] = (Number) formulaDecimal0;

        Assert.assertNotNull(Statistics.large(bigDecimal0, numberArray0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test040() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        Number[] numberArray0 = new Number[5];

        Assert.assertNotNull(Statistics.large(bigInteger0, numberArray0));
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test041() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ZERO;
        Number[] numberArray0 = new Number[1];
        numberArray0[0] = (Number) bigDecimal0;

        Assert.assertNotNull(Statistics.intercept(bigDecimal0, numberArray0));
    }

    @Test(timeout = 4000, expected = NotStrictlyPositiveException.class)
    public void test042() throws Throwable {
        byte[] byteArray0 = new byte[4];
        BigInteger bigInteger0 = new BigInteger(byteArray0);

        Assert.assertNotNull(Statistics.hypgeom_dist((Number) bigInteger0, (Number) (byte) 69, (Number) (byte) 69, (Number) (byte) 0, (Boolean) null));
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test043() throws Throwable {
        Number[] numberArray0 = new Number[3];

        Assert.assertNotNull(Statistics.harmean((Number) null, numberArray0));
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test044() throws Throwable {
        Float float0 = new Float(0.0F);
        Number[] numberArray0 = new Number[2];

        Assert.assertNotNull(Statistics.harmean(float0, numberArray0));
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test045() throws Throwable {
        Number[] numberArray0 = new Number[4];

        Assert.assertNotNull(Statistics.forecast((Number) null, numberArray0));
    }

    @Test(timeout = 4000)
    public void test046() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.count();

        Assert.assertNotNull(Statistics.fisher(formulaDecimal0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test047() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.valueOf(86L, 1487);

        Assert.assertNotNull(Statistics.f_dist((Number) bigDecimal0, (Number) null, (Number) bigDecimal0, (Logical) null));
    }

    @Test(timeout = 4000)
    public void test048() throws Throwable {

        Assert.assertNotNull(Statistics.expon_dist((Number) (byte) 10, (Number) (byte) 10, (Boolean) null));
    }

    @Test(timeout = 4000)
    public void test049() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.mina();
        Number[] numberArray0 = new Number[5];

        Assert.assertNotNull(Statistics.devsq(formulaDecimal0, numberArray0));
    }

    @Test(timeout = 4000)
    public void test050() throws Throwable {
        Object object0 = new Object();

        Assert.assertNotNull(Statistics.counta(object0, (Object[]) null));
    }

    @Test(timeout = 4000, expected = OutOfRangeException.class)
    public void test051() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-2219.5455762301));
        BigDecimal bigDecimal0 = new BigDecimal(1133L);

        Statistics.confidence_norm(formulaDecimal0, bigDecimal0, bigDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test052() throws Throwable {
        Number[] numberArray0 = new Number[5];

        Statistics.binom_dist_range(numberArray0[0], numberArray0[3], numberArray0[3], numberArray0[0]);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test053() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((BigDecimal) null);

        Statistics.binom_dist_range((Number) formulaDecimal0, (Number) null, (Number) null);
    }

    @Test(timeout = 4000)
    public void test054() throws Throwable {
        Byte byte0 = new Byte((byte) 0);
        Assert.assertNotNull(Statistics.binom_dist_range((Number) byte0, (Number) byte0, (Number) byte0));
    }

    @Test(timeout = 4000)
    public void test055() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        BigDecimal bigDecimal0 = new BigDecimal(bigInteger0);
        Assert.assertNotNull(Statistics.binom_dist((Number) bigDecimal0, (Number) bigDecimal0, (Number) bigInteger0, (Boolean) null));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test056() throws Throwable {
        Short short0 = new Short((short) 0);
        Statistics.binom_dist((Number) short0, (Number) short0, (Number) short0, (Logical) null);
    }

    @Ignore
    @Test(timeout = 4000)
    public void test058() throws Throwable {
        Object[] objectArray0 = new Object[1];
        Number[] numberArray0 = new Number[7];

        Assert.assertNotNull(Statistics.averageif(objectArray0, (CharSequence) "", numberArray0));
    }

    @Ignore
    @Test(timeout = 4000)
    public void test059() throws Throwable {
        Object[] objectArray0 = new Object[9];
        CharBuffer charBuffer0 = CharBuffer.allocate(0);
        Number[] numberArray0 = new Number[0];

        Assert.assertNotNull(Statistics.averageif(objectArray0, (CharSequence) charBuffer0, numberArray0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test061() throws Throwable {
        Number[] numberArray0 = new Number[6];

        Assert.assertNotNull(Statistics.averageif(numberArray0, (CharSequence) "io.onsense.universe.Statistics$8", numberArray0));
    }

    @Test(timeout = 4000)
    public void test062() throws Throwable {
        Object[] objectArray0 = new Object[4];

        Assert.assertNotNull(Statistics.averagea((Object) null, objectArray0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test063() throws Throwable {

        Statistics.avedev((Number) null, (Number[]) null);
    }

    @Test(timeout = 4000)
    public void test064() throws Throwable {
        Number[] numberArray0 = new Number[8];

        Assert.assertNotNull(Statistics.avedev((Number) null, numberArray0));
    }

    @Test(timeout = 4000)
    public void test067() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(1.0);
        Logical logical0 = formulaDecimal0.lte(formulaDecimal0);

        Assert.assertNotNull(Statistics.poisson_dist((Number) formulaDecimal0, (Number) formulaDecimal0, logical0));
    }

    @Test(timeout = 4000)
    public void test068() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.TEN;
        Logical logical0 = Logical.valueOf("");

        Assert.assertNotNull(Statistics.norm_dist((Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, logical0));
    }

    @Test(timeout = 4000, expected = NotStrictlyPositiveException.class)
    public void test069() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.max();
        Float float0 = new Float(0.0);
        Logical logical0 = formulaDecimal0.lte(formulaDecimal0);

        Statistics.norm_dist((Number) formulaDecimal0, (Number) float0, (Number) float0, logical0);
    }

    @Test(timeout = 4000, expected = NotStrictlyPositiveException.class)
    public void test070() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        Logical logical0 = new Logical(false);

        Statistics.gamma_dist((Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, logical0);
    }

    @Test(timeout = 4000, expected = NotStrictlyPositiveException.class)
    public void test071() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.counta();
        Logical logical0 = new Logical(false);

        Statistics.f_dist((Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, logical0);
    }

    @Test(timeout = 4000)
    public void test072() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0.0);
        Logical logical0 = Logical.TRUE;

        Assert.assertNotNull(Statistics.expon_dist((Number) formulaDecimal0, (Number) formulaDecimal0, logical0));
    }

    @Test(timeout = 4000)
    public void test073() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);

        Assert.assertNotNull(Statistics.binom_dist_range((Number) formulaDecimal0, (Number) formulaDecimal0, (Number) bigInteger0, (Number) bigInteger0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test074() throws Throwable {
        Logical logical0 = new Logical(false);

        Statistics.binom_dist((Number) null, (Number) null, (Number) null, logical0);
    }

    @Test(timeout = 4000)
    public void test075() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-1071.41));
        Number[] numberArray0 = new Number[3];

        Statistics.varpa(formulaDecimal0, numberArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test076() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.maxa();
        BigDecimal bigDecimal0 = BigDecimal.ZERO;

        Statistics.beta_inv((Number) formulaDecimal0, (Number) null, (Number) bigDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test077() throws Throwable {

        Statistics.max((Number) null, (Number[]) null);
    }

    @Test(timeout = 4000)
    public void test078() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.counta();
        Number[] numberArray0 = new Number[7];
        Assert.assertNotNull(Statistics.vara(formulaDecimal0, numberArray0));
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test079() throws Throwable {
        Logical logical0 = new Logical(false);

        Statistics.beta_dist((Number) null, (Number) null, (Number) null, logical0, (Number) null, (Number) null);
    }

    @Test(timeout = 4000, expected = NotStrictlyPositiveException.class)
    public void test081() throws Throwable {
        Float float0 = new Float(0.0F);
        // Undeclared exception!
        Statistics.norm_inv(float0, float0, float0);
        Assert.fail("expected NotStrictlyPositiveException");
    }

    @Test(timeout = 4000, expected = NotStrictlyPositiveException.class)
    public void test084() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        Logical logical0 = Logical.FALSE;

        Statistics.weibull_dist((Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, logical0);
    }

    @Test(timeout = 4000, expected = NotStrictlyPositiveException.class)
    public void test086() throws Throwable {
        byte[] byteArray0 = new byte[4];
        BigInteger bigInteger0 = new BigInteger(byteArray0);
        Logical logical0 = Logical.TRUE;

        Statistics.t_dist((Number) bigInteger0, (Number) (byte) 0, logical0);
    }

    @Test(timeout = 4000, expected = NotStrictlyPositiveException.class)
    public void test087() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal((-1));
        BigInteger bigInteger0 = BigInteger.ZERO;
        Logical logical0 = Logical.valueOf(false);

        Statistics.t_dist((Number) bigDecimal0, (Number) bigInteger0, logical0);
    }

    @Test(timeout = 4000)
    public void test088() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0L);
        Number[] numberArray0 = new Number[9];
        numberArray0[8] = (Number) formulaDecimal0;
        Assert.assertNotNull(Statistics.small(formulaDecimal0, numberArray0));
    }

    @Ignore
    @Test(timeout = 4000)
    public void test092() throws Throwable {
        Float float0 = new Float((-836.908983));
        Number[] numberArray0 = new Number[2];
        numberArray0[1] = (Number) float0;

        Statistics.quartile_exc(float0, numberArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test094() throws Throwable {
        Float[] floatArray0 = new Float[4];

        Assert.assertNotNull(Statistics.prob(floatArray0[1], floatArray0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test095() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.counta();
        Logical logical0 = formulaDecimal0.gt(formulaDecimal0);

        Statistics.poisson_dist((Number) null, (Number) formulaDecimal0, logical0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test096() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0);
        Logical logical0 = Logical.TRUE;
        Statistics.negbinom_dist((Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, logical0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test097() throws Throwable {
        Double double0 = new Double(0.0);
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        Logical logical0 = Logical.valueOf(false);
        Statistics.negbinom_dist((Number) double0, (Number) double0, (Number) bigDecimal0, logical0);
    }

    @Test(timeout = 4000)
    public void test098() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1.0);
        FormulaDecimal formulaDecimal1 = new FormulaDecimal(0L);
        Logical logical0 = formulaDecimal0.gt(formulaDecimal1);

        Assert.assertNotNull(Statistics.lognorm_dist((Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, logical0));
    }

    @Test(timeout = 4000, expected = NotStrictlyPositiveException.class)
    public void test099() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        Logical logical0 = Logical.TRUE;

        Statistics.hypgeom_dist((Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, logical0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test100() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        Number[] numberArray0 = new Number[4];
        numberArray0[0] = (Number) bigInteger0;
        numberArray0[1] = (Number) bigInteger0;
        numberArray0[2] = (Number) bigInteger0;
        numberArray0[3] = (Number) bigInteger0;
        FormulaDecimal formulaDecimal0 = Statistics.harmean(bigInteger0, numberArray0);
        Logical logical0 = new Logical(false);

        Statistics.hypgeom_dist((Number) formulaDecimal0, (Number) bigInteger0, (Number) formulaDecimal0, numberArray0[3], logical0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test101() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.counta();
        Logical logical0 = formulaDecimal0.eq(formulaDecimal0);

        Statistics.f_dist((Number) null, (Number) null, (Number) null, logical0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test102() throws Throwable {
        Logical logical0 = Logical.valueOf((String) null);

        Statistics.expon_dist((Number) null, (Number) null, logical0);
    }

    @Test(timeout = 4000)
    public void test103() throws Throwable {
        Integer integer0 = new Integer(739);
        Logical logical0 = Logical.FALSE;

        Assert.assertNotNull(Statistics.chisq_dist((Number) integer0, (Number) integer0, logical0));
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test104() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.TEN;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-464L));
        Boolean boolean0 = Boolean.valueOf(true);

        Statistics.beta_dist((Number) bigDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, boolean0);
    }

    @Test(timeout = 4000)
    public void test105() throws Throwable {
        Float float0 = new Float(0.0F);
        Number[] numberArray0 = new Number[6];
        numberArray0[0] = (Number) float0;
        numberArray0[1] = (Number) float0;
        numberArray0[2] = (Number) float0;
        numberArray0[3] = (Number) float0;
        numberArray0[4] = (Number) float0;
        numberArray0[5] = (Number) float0;
        FormulaDecimal formulaDecimal0 = Statistics.avedev(float0, numberArray0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000, expected = MathIllegalArgumentException.class)
    public void test106() throws Throwable {
        Number[] numberArray0 = new Number[5];

        Assert.assertNotNull(Statistics.covariance_p(numberArray0[4], numberArray0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test107() throws Throwable {
        Number[] numberArray0 = new Number[7];

        Assert.assertNotNull(Statistics.geomean((Number) null, numberArray0));
    }

    @Test(timeout = 4000)
    public void test108() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);

        Assert.assertNotNull(Statistics.gammaln_precise(formulaDecimal0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test109() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal(848L);
        Boolean boolean0 = new Boolean("io.onsense.universe.Statistics$5");

        Statistics.gamma_dist((Number) null, (Number) bigDecimal0, (Number) null, boolean0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test110() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);
        Number[] numberArray0 = new Number[1];
        numberArray0[0] = (Number) formulaDecimal0;
        FormulaDecimal formulaDecimal1 = Statistics.large(bigDecimal0, numberArray0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test111() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;

        Assert.assertNotNull(Statistics.fisherinv(bigInteger0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test112() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.maxa();
        Boolean boolean0 = Boolean.valueOf(true);

        Statistics.expon_dist((Number) formulaDecimal0, (Number) null, boolean0);
    }

    @Test(timeout = 4000)
    public void test113() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;

        Assert.assertNotNull(Statistics.t_dist_2t(bigInteger0, bigInteger0));
    }

    @Test(timeout = 4000)
    public void test114() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.max();

        Assert.assertNotNull(Statistics.permut(formulaDecimal0, formulaDecimal0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test115() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ZERO;

        Statistics.gammaln(bigDecimal0);
    }

    @Test(timeout = 4000, expected = MathIllegalArgumentException.class)
    public void test117() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.maxa();
        Number[] numberArray0 = new Number[4];

        Assert.assertNotNull(Statistics.covariance_s(formulaDecimal0, numberArray0));
    }

    @Test(timeout = 4000)
    public void test118() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal(1);

        Assert.assertNotNull(Statistics.chisq_dist_rt(bigDecimal0, bigDecimal0));
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test119() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.count();
        Boolean boolean0 = new Boolean(true);

        Statistics.beta_dist((Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, boolean0, (Number) formulaDecimal0, (Number) formulaDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test120() throws Throwable {
        Number[] numberArray0 = new Number[7];
        Statistics statistics0 = new Statistics();

        Statistics.average(statistics0, numberArray0);
    }

    @Test(timeout = 4000, expected = NotStrictlyPositiveException.class)
    public void test121() throws Throwable {
        Float float0 = new Float(0.0F);
        Boolean boolean0 = new Boolean((String) null);

        Statistics.norm_dist((Number) float0, (Number) float0, (Number) float0, boolean0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test122() throws Throwable {
        Number[] numberArray0 = new Number[7];

        Statistics.median((Number) null, numberArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test126() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal(0L);

        Assert.assertNotNull(Statistics.z_test(bigDecimal0, (Number[]) null));
    }

    @Test(timeout = 4000)
    public void test128() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;

        Assert.assertNotNull(Statistics.gauss(bigInteger0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test129() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal(1099511627776L);
        Number[] numberArray0 = new Number[2];

        Statistics.intercept(bigDecimal0, numberArray0);
    }

    @Test(timeout = 4000, expected = NotStrictlyPositiveException.class)
    public void test131() throws Throwable {
        Double double0 = new Double((-311.1959395));

        Statistics.gamma_inv(double0, double0, double0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test132() throws Throwable {

        Statistics.confidence_norm((Number) null, (Number) null, (Number) null);
    }

    @Test(timeout = 4000, expected = NotStrictlyPositiveException.class)
    public void test133() throws Throwable {
        BigInteger bigInteger0 = BigInteger.valueOf(0L);
        BigDecimal bigDecimal0 = new BigDecimal(bigInteger0);

        Statistics.chisq_inv(bigInteger0, bigDecimal0);
    }

    @Test(timeout = 4000)
    public void test134() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.TEN;
        Object[] objectArray0 = new Object[3];
        FormulaDecimal formulaDecimal0 = Statistics.min((Object) bigDecimal0, objectArray0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test135() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0L);

        Assert.assertNotNull(Statistics.phi(formulaDecimal0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test137() throws Throwable {
        Float[] floatArray0 = new Float[4];

        Statistics.skew(floatArray0[1], floatArray0);
    }

    @Test(timeout = 4000)
    public void test138() throws Throwable {
        Object[] objectArray0 = new Object[5];
        FormulaDecimal formulaDecimal0 = Statistics.counta((Object) "", objectArray0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000, expected = DimensionMismatchException.class)
    public void test139() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        Number[] numberArray0 = new Number[1];

        Statistics.correl(bigInteger0, numberArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test140() throws Throwable {
        Long long0 = new Long(1L);
        Boolean boolean0 = Boolean.TRUE;

        Statistics.chisq_dist((Number) null, (Number) long0, boolean0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test141() throws Throwable {

        Statistics.t_inv_2t((Number) null, (Number) null);
    }

    @Test(timeout = 4000)
    public void test144() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        Boolean boolean0 = new Boolean("b'`8s&51(sMR");

        Assert.assertNotNull(Statistics.binom_dist((Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, boolean0));
    }

    @Test(timeout = 4000, expected = NotStrictlyPositiveException.class)
    public void test145() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        Boolean boolean0 = Boolean.FALSE;

        Statistics.hypgeom_dist((Number) bigInteger0, (Number) bigDecimal0, (Number) bigInteger0, (Number) bigInteger0, boolean0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test147() throws Throwable {
        Float float0 = new Float(0.0);
        FormulaDecimal formulaDecimal0 = Statistics.countblank();

        Statistics.negbinom_dist((Number) float0, (Number) formulaDecimal0, (Number) float0, (Boolean) null);

    }

    @Test(timeout = 4000)
    public void test148() throws Throwable {
        BigInteger bigInteger0 = BigInteger.valueOf(1519L);
        Number[] numberArray0 = new Number[2];

        Assert.assertNotNull(Statistics.stdevpa(bigInteger0, numberArray0));
    }

    @Test(timeout = 4000)
    public void test150() throws Throwable {
        Long long0 = new Long(460L);
        Object[] objectArray0 = new Object[1];
        FormulaDecimal formulaDecimal0 = Statistics.maxa((Object) long0, objectArray0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000, expected = DimensionMismatchException.class)
    public void test151() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0.0);
        Number[] numberArray0 = new Number[0];

        Statistics.rsq(formulaDecimal0, numberArray0);
    }

    @Test(timeout = 4000)
    public void test152() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal(1);

        Assert.assertNotNull(Statistics.f_dist_rt(bigDecimal0, bigDecimal0, bigDecimal0));
    }

    @Test(timeout = 4000)
    public void test153() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        BigDecimal bigDecimal0 = new BigDecimal(bigInteger0);
        Number[] numberArray0 = new Number[2];

        Assert.assertNotNull(Statistics.stdev_s(bigDecimal0, numberArray0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test155() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.counta();

        Statistics.beta_inv((Number) formulaDecimal0, (Number) null, (Number) formulaDecimal0, (Number) null, (Number) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test156() throws Throwable {
        Object[] objectArray0 = new Object[0];

        Statistics.max((Object) null, objectArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test157() throws Throwable {
        Object object0 = new Object();
        Object[] objectArray0 = new Object[4];
        FormulaDecimal formulaDecimal0 = Statistics.count(object0, objectArray0);

        Statistics.gamma(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test159() throws Throwable {
        Double double0 = new Double((-1.0));
        Object[] objectArray0 = new Object[4];

        Assert.assertNotNull(Statistics.averagea(double0, objectArray0));
    }

    @Test(timeout = 4000)
    public void test160() throws Throwable {
        Float float0 = new Float((-140.8463F));
        Number[] numberArray0 = new Number[0];

        Assert.assertNotNull(Statistics.stdev_p(float0, numberArray0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test162() throws Throwable {
        Boolean boolean0 = new Boolean((String) null);

        Statistics.f_dist((Number) null, (Number) null, (Number) null, boolean0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test163() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.countblank();
        Number[] numberArray0 = new Number[1];

        Statistics.kurt(formulaDecimal0, numberArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test164() throws Throwable {

        Statistics.chisq_inv_rt((Number) null, (Number) null);
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test165() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0.0);

        Statistics.standardize(formulaDecimal0, formulaDecimal0, formulaDecimal0);
    }

    @Test(timeout = 4000, expected = NotStrictlyPositiveException.class)
    public void test166() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.maxa();
        Number[] numberArray0 = new Number[6];

        Statistics.chisq_test(formulaDecimal0, numberArray0);
    }

    @Test(timeout = 4000, expected = NotStrictlyPositiveException.class)
    public void test168() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.counta();

        Statistics.t_dist((Number) formulaDecimal0, (Number) formulaDecimal0, (Boolean) null);

    }

    @Test(timeout = 4000, expected = NotStrictlyPositiveException.class)
    public void test169() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.min();
        Boolean boolean0 = Boolean.FALSE;

        Statistics.lognorm_dist((Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, boolean0);
    }

    @Ignore
    @Test(timeout = 4000)
    public void test170() throws Throwable {
        Object[] objectArray0 = new Object[3];

        Assert.assertNotNull(Statistics.mina((Object) "", objectArray0));
    }

    @Test(timeout = 4000, expected = NotStrictlyPositiveException.class)
    public void test171() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ZERO;

        Statistics.t_dist_rt(bigDecimal0, bigDecimal0);
    }

    @Test(timeout = 4000, expected = NotStrictlyPositiveException.class)
    public void test172() throws Throwable {
        Long long0 = new Long((-1L));

        Statistics.f_inv(long0, long0, long0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test173() throws Throwable {

        Statistics.fisher((Number) null);
    }

    @Test(timeout = 4000)
    public void test174() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        BigDecimal bigDecimal0 = new BigDecimal(bigInteger0);
        Number[] numberArray0 = new Number[1];

        Assert.assertNotNull(Statistics.stdeva(bigDecimal0, numberArray0));
    }

    @Test(timeout = 4000, expected = OutOfRangeException.class)
    public void test175() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(2016);
        BigDecimal bigDecimal0 = new BigDecimal((long) 2016);

        Statistics.t_inv(bigDecimal0, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test177() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;

        Assert.assertNotNull(Statistics.binom_dist_range((Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0));
    }

    @Test(timeout = 4000)
    public void test179() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        Boolean boolean0 = Boolean.valueOf(true);

        Assert.assertNotNull(Statistics.weibull_dist((Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, boolean0));
    }

    @Test(timeout = 4000)
    public void test180() throws Throwable {
        byte[] byteArray0 = new byte[8];
        BigInteger bigInteger0 = new BigInteger(byteArray0);
        Boolean boolean0 = new Boolean("Sz>");

        Assert.assertNotNull(Statistics.beta_dist((Number) bigInteger0, (Number) (byte) 2, (Number) (byte) 109, boolean0));
    }

    @Test(timeout = 4000, expected = NotPositiveException.class)
    public void test181() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal((-1866L));
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);

        Statistics.binom_inv(formulaDecimal0, formulaDecimal0, bigDecimal0);
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test182() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((int) (byte) (-127));
        Boolean boolean0 = Boolean.TRUE;

        Statistics.beta_dist((Number) formulaDecimal0, (Number) formulaDecimal0, (Number) (byte) (-127), boolean0, (Number) null, (Number) null);
    }

    @Test(timeout = 4000)
    public void test183() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal(1L);
        Number[] numberArray0 = new Number[2];
        numberArray0[1] = (Number) bigDecimal0;

        Assert.assertNotNull(Statistics.quartile_inc(bigDecimal0, numberArray0));
    }

    @Test(timeout = 4000)
    public void test184() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.mina();
        CharBuffer charBuffer0 = CharBuffer.allocate(70);
        Object[] objectArray0 = new Object[2];
        objectArray0[0] = (Object) formulaDecimal0;
        FormulaDecimal formulaDecimal1 = Statistics.countblank((Object) charBuffer0, objectArray0);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
    }

    @Test(timeout = 4000, expected = NotStrictlyPositiveException.class)
    public void test185() throws Throwable {
        Double double0 = new Double((-1328.021596));
        Boolean boolean0 = new Boolean(true);

        Statistics.poisson_dist((Number) double0, (Number) double0, boolean0);
    }

    @Test(timeout = 4000)
    public void test186() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.min();

        Assert.assertNotNull(Statistics.permutationa(formulaDecimal0, formulaDecimal0));
    }

    @Test(timeout = 4000, expected = NotStrictlyPositiveException.class)
    public void test187() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.max();

        Statistics.lognorm_inv(formulaDecimal0, formulaDecimal0, formulaDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test190() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;

        Statistics.norm_s_inv(bigInteger0);
    }

    @Test(timeout = 4000)
    public void test191() throws Throwable {
        Float float0 = new Float(0.0);
        Boolean boolean0 = new Boolean(true);

        Assert.assertNotNull(Statistics.norm_s_dist((Number) float0, boolean0));
    }

    @Test(timeout = 4000, expected = NotStrictlyPositiveException.class)
    public void test193() throws Throwable {
        byte[] byteArray0 = new byte[4];
        BigInteger bigInteger0 = new BigInteger(byteArray0);
        BigDecimal bigDecimal0 = new BigDecimal(bigInteger0);

        Statistics.f_inv_rt(bigDecimal0, bigDecimal0, bigDecimal0);
    }

    @Test(timeout = 4000)
    public void test0000() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal(0L);
        BigInteger bigInteger0 = BigInteger.ZERO;
        Number[] numberArray0 = new Number[1];
        numberArray0[0] = (Number) bigDecimal0;
        FormulaDecimal formulaDecimal0 = Statistics.small(bigInteger0, numberArray0);
        assertNotNull(formulaDecimal0);
    }


    @Test(timeout = 4000)
    public void test0003() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        BigDecimal bigDecimal1 = new BigDecimal((double) 3);
        FormulaDecimal formulaDecimal0 = Statistics.chisq_inv_rt(bigDecimal0, bigDecimal0);
        Number[] numberArray0 = new Number[7];
        numberArray0[6] = (Number) bigDecimal1;
        FormulaDecimal formulaDecimal1 = Statistics.large(formulaDecimal0, numberArray0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test0004() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        FormulaDecimal formulaDecimal0 = FormulaDecimal.ZERO;
        Number[] numberArray0 = new Number[1];
        numberArray0[0] = (Number) formulaDecimal0;
        FormulaDecimal formulaDecimal1 = Statistics.large(bigInteger0, numberArray0);
        assertSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test0005() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0.5);
        FormulaDecimal formulaDecimal1 = FormulaDecimal.ONE;
        Number[] numberArray0 = new Number[5];
        numberArray0[0] = (Number) formulaDecimal1;
        numberArray0[1] = (Number) formulaDecimal1;
        numberArray0[2] = (Number) formulaDecimal0;
        numberArray0[3] = (Number) formulaDecimal1;
        numberArray0[4] = (Number) formulaDecimal1;
        FormulaDecimal formulaDecimal2 = Statistics.t_test(formulaDecimal1, numberArray0);
        assertNotSame(formulaDecimal1, formulaDecimal2);
    }

    @Test(timeout = 4000)
    public void test0006() throws Throwable {
        Float float0 = new Float(1.0F);
        Boolean boolean0 = Boolean.TRUE;
        FormulaDecimal formulaDecimal0 = Statistics.weibull_dist((Number) float0, (Number) float0, (Number) float0, boolean0);
        FormulaDecimal formulaDecimal1 = Statistics.t_inv(formulaDecimal0, float0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }

    @Test(timeout = 4000)
    public void test0007() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.countblank();
        Double double0 = new Double((-496.6024468));
        Number[] numberArray0 = new Number[5];
        numberArray0[4] = (Number) double0;
        FormulaDecimal formulaDecimal1 = Statistics.slope(formulaDecimal0, numberArray0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }

    @Test(timeout = 4000)
    public void test0008() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        BigDecimal bigDecimal0 = new BigDecimal(bigInteger0);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);
        Number[] numberArray0 = new Number[8];
        Float float0 = new Float((float) 0L);
        numberArray0[0] = (Number) float0;
        numberArray0[1] = (Number) formulaDecimal0;
        FormulaDecimal formulaDecimal1 = Statistics.skew(bigDecimal0, numberArray0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test0009() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0.75);
        FormulaDecimal formulaDecimal1 = Statistics.norm_s_inv(formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test0010() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal((-2459));
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(499.20634124);
        Logical logical0 = formulaDecimal0.lte(formulaDecimal0);
        FormulaDecimal formulaDecimal1 = Statistics.norm_s_dist((Number) bigDecimal0, logical0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }

    @Test(timeout = 4000)
    public void test0011() throws Throwable {
        byte[] byteArray0 = new byte[1];
        byteArray0[0] = (byte) 3;
        BigInteger bigInteger0 = new BigInteger(byteArray0);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);
        Logical logical0 = Logical.valueOf((String) null);
        FormulaDecimal formulaDecimal1 = Statistics.poisson_dist((Number) formulaDecimal0, (Number) formulaDecimal0, logical0);
        FormulaDecimal formulaDecimal2 = Statistics.norm_inv(formulaDecimal1, formulaDecimal1, formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal2);
    }

    @Test(timeout = 4000)
    public void test0012() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        FormulaDecimal formulaDecimal0 = FormulaDecimal.ZERO;
        Logical logical0 = Logical.FALSE;
        FormulaDecimal formulaDecimal1 = Statistics.lognorm_dist((Number) bigInteger0, (Number) formulaDecimal0, (Number) bigInteger0, logical0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test0013() throws Throwable {
        Byte byte0 = new Byte((byte) 56);
        FormulaDecimal formulaDecimal0 = Statistics.gauss(byte0);
        Number[] numberArray0 = new Number[5];
        numberArray0[0] = (Number) formulaDecimal0;
        numberArray0[1] = (Number) byte0;
        numberArray0[3] = (Number) formulaDecimal0;
        FormulaDecimal formulaDecimal1 = Statistics.kurt(numberArray0[3], numberArray0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test0014() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        Object[] objectArray0 = new Object[2];
        FormulaDecimal formulaDecimal0 = Statistics.mina((Object) bigDecimal0, objectArray0);
        FormulaDecimal formulaDecimal1 = Statistics.t_inv_2t(bigDecimal0, bigDecimal0);
        Boolean boolean0 = new Boolean("");
        FormulaDecimal formulaDecimal2 = Statistics.hypgeom_dist((Number) formulaDecimal1, (Number) bigDecimal0, (Number) bigDecimal0, (Number) formulaDecimal0, boolean0);
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal1));
    }

    @Test(timeout = 4000)
    public void test0015() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(649L);
        FormulaDecimal formulaDecimal1 = new FormulaDecimal(0);
        FormulaDecimal formulaDecimal2 = Statistics.f_inv(formulaDecimal1, formulaDecimal0, formulaDecimal0);
        assertNotSame(formulaDecimal2, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test0016() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        BigDecimal bigDecimal1 = bigDecimal0.negate();
        FormulaDecimal formulaDecimal0 = Statistics.chisq_inv_rt(bigDecimal0, bigDecimal0);
        Number[] numberArray0 = new Number[7];
        numberArray0[0] = (Number) bigDecimal0;
        numberArray0[1] = (Number) bigDecimal1;
        numberArray0[2] = (Number) bigDecimal0;
        numberArray0[3] = (Number) formulaDecimal0;
        numberArray0[4] = (Number) formulaDecimal0;
        numberArray0[5] = (Number) formulaDecimal0;
        numberArray0[6] = (Number) bigDecimal1;
        FormulaDecimal formulaDecimal1 = Statistics.correl(bigDecimal0, numberArray0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test0017() throws Throwable {
        Short short0 = new Short((short) 2);
        Number[] numberArray0 = new Number[9];
        numberArray0[0] = (Number) short0;
        numberArray0[1] = (Number) short0;
        numberArray0[2] = (Number) short0;
        numberArray0[3] = (Number) short0;
        numberArray0[4] = (Number) short0;
        numberArray0[5] = (Number) short0;
        numberArray0[6] = (Number) short0;
        numberArray0[7] = (Number) short0;
        numberArray0[8] = (Number) short0;
        FormulaDecimal formulaDecimal0 = Statistics.chisq_test(short0, numberArray0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test0018() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.countblank();
        FormulaDecimal formulaDecimal1 = Statistics.binom_inv(formulaDecimal0, formulaDecimal0, formulaDecimal0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }

    @Test(timeout = 4000)
    public void test0019() throws Throwable {
        Integer integer0 = new Integer(19);
        FormulaDecimal formulaDecimal0 = FormulaDecimal.ZERO;
        FormulaDecimal formulaDecimal1 = Statistics.beta_dist((Number) formulaDecimal0, (Number) formulaDecimal0, (Number) integer0, (Boolean) null, (Number) integer0, (Number) integer0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }

    @Test(timeout = 4000)
    public void test020() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);
        Logical logical0 = Logical.TRUE;
        FormulaDecimal formulaDecimal1 = Statistics.beta_dist((Number) formulaDecimal0, (Number) bigInteger0, (Number) bigInteger0, logical0, (Number) bigInteger0, (Number) bigInteger0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }

    @Test(timeout = 4000)
    public void test0138() throws Throwable {
        Byte byte0 = new Byte((byte) 62);
        FormulaDecimal formulaDecimal0 = Statistics.chisq_dist_rt(byte0, byte0);
        Logical logical0 = Logical.TRUE;
        FormulaDecimal formulaDecimal1 = Statistics.gamma_dist((Number) byte0, (Number) formulaDecimal0, (Number) formulaDecimal0, logical0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test0141() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0.5);
        Boolean boolean0 = Boolean.TRUE;
        Logical logical0 = new Logical(boolean0);
        FormulaDecimal formulaDecimal1 = Statistics.f_dist((Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, logical0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }


    @Test(timeout = 4000)
    public void test143() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.countblank();
        Boolean boolean0 = Boolean.FALSE;
        Logical logical0 = new Logical(boolean0);
        FormulaDecimal formulaDecimal1 = Statistics.expon_dist((Number) formulaDecimal0, (Number) formulaDecimal0, logical0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }

    @Test(timeout = 4000)
    public void test0144() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        FormulaDecimal formulaDecimal0 = Statistics.chisq_inv_rt(bigDecimal0, bigDecimal0);
        Logical logical0 = formulaDecimal0.eq(formulaDecimal0);
        FormulaDecimal formulaDecimal1 = Statistics.expon_dist((Number) bigDecimal0, (Number) formulaDecimal0, logical0);
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
    }

    @Test(timeout = 4000)
    public void test0145() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.TEN;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);
        Double double0 = new Double(304.3381606548);
        Logical logical0 = formulaDecimal0.lt(formulaDecimal0);
        FormulaDecimal formulaDecimal1 = Statistics.chisq_dist((Number) formulaDecimal0, (Number) double0, logical0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test0147() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.ONE;
        Logical logical0 = Logical.FALSE;
        FormulaDecimal formulaDecimal1 = Statistics.binom_dist((Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, logical0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test0150() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        Number[] numberArray0 = new Number[6];
        FormulaDecimal formulaDecimal0 = Statistics.median(bigInteger0, numberArray0);
        Logical logical0 = formulaDecimal0.lt(formulaDecimal0);
        FormulaDecimal formulaDecimal1 = Statistics.beta_dist((Number) bigInteger0, (Number) bigInteger0, (Number) formulaDecimal0, logical0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }


    @Test(timeout = 4000)
    public void test0162() throws Throwable {
        Number[] numberArray0 = new Number[6];
        FormulaDecimal formulaDecimal0 = Statistics.trimmean((Number) null, numberArray0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test0163() throws Throwable {
        Number[] numberArray0 = new Number[5];
        Float float0 = new Float(1054.7625485439155);
        FormulaDecimal formulaDecimal0 = Statistics.countblank((Object) float0, (Object[]) numberArray0);
        FormulaDecimal formulaDecimal1 = Statistics.trimmean(formulaDecimal0, numberArray0);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
    }


    @Test(timeout = 4000)
    public void test199() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.ONE;
        FormulaDecimal formulaDecimal1 = Statistics.standardize(formulaDecimal0, formulaDecimal0, formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test200() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal(1549.83);
        Number[] numberArray0 = new Number[2];
        FormulaDecimal formulaDecimal0 = FormulaDecimal.ZERO;
        numberArray0[1] = (Number) formulaDecimal0;
        FormulaDecimal formulaDecimal1 = Statistics.small(bigDecimal0, numberArray0);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
    }


    @Test(timeout = 4000)
    public void test224() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        BigDecimal bigDecimal0 = new BigDecimal(bigInteger0);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);
        Number[] numberArray0 = new Number[5];
        numberArray0[0] = (Number) bigDecimal0;
        numberArray0[3] = (Number) bigDecimal0;
        numberArray0[4] = (Number) formulaDecimal0;
        FormulaDecimal formulaDecimal1 = Statistics.prob(formulaDecimal0, numberArray0);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
    }

    @Test(timeout = 4000)
    public void test225() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        Number[] numberArray0 = new Number[5];
        numberArray0[4] = (Number) bigInteger0;
        FormulaDecimal formulaDecimal0 = Statistics.small(bigInteger0, numberArray0);
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        Number[] numberArray1 = new Number[5];
        numberArray1[0] = (Number) bigDecimal0;
        numberArray1[3] = (Number) bigDecimal0;
        numberArray1[4] = (Number) formulaDecimal0;
        FormulaDecimal formulaDecimal1 = Statistics.prob(formulaDecimal0, numberArray1);
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
    }

    @Test(timeout = 4000)
    public void test226() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.counta();
        BigInteger bigInteger0 = BigInteger.ONE;
        Number[] numberArray0 = new Number[2];
        numberArray0[1] = (Number) bigInteger0;
        FormulaDecimal formulaDecimal1 = Statistics.prob(formulaDecimal0, numberArray0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }


    @Test(timeout = 4000)
    public void test262() throws Throwable {
        Boolean boolean0 = new Boolean(false);
        Integer integer0 = new Integer((-5383));
        Object[] objectArray0 = new Object[4];
        objectArray0[0] = (Object) boolean0;
        FormulaDecimal formulaDecimal0 = Statistics.mina((Object) integer0, objectArray0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test263() throws Throwable {
        Long long0 = new Long(2147483648L);
        Object[] objectArray0 = new Object[0];
        FormulaDecimal formulaDecimal0 = Statistics.mina((Object) long0, objectArray0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test264() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        FormulaDecimal formulaDecimal0 = Statistics.mina((Object) bigDecimal0, (Object[]) null);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test267() throws Throwable {
        Byte byte0 = new Byte((byte) 83);
        Object[] objectArray0 = new Object[0];
        FormulaDecimal formulaDecimal0 = Statistics.min((Object) byte0, objectArray0);
        assertNotNull(formulaDecimal0);
    }


    @Test(timeout = 4000)
    public void test271() throws Throwable {
        Number[] numberArray0 = new Number[1];
        FormulaDecimal formulaDecimal0 = Statistics.min((Number) null, numberArray0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test272() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal(2791);
        Number[] numberArray0 = new Number[0];
        FormulaDecimal formulaDecimal0 = Statistics.min((Number) bigDecimal0, numberArray0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test273() throws Throwable {
        Integer integer0 = new Integer((-524));
        Object[] objectArray0 = new Object[0];
        FormulaDecimal formulaDecimal0 = Statistics.average(integer0, objectArray0);
        FormulaDecimal formulaDecimal1 = Statistics.min((Number) formulaDecimal0, (Number[]) null);
        assertSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test274() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal((-1.7658271111516935E-8));
        Number[] numberArray0 = new Number[5];
        FormulaDecimal formulaDecimal0 = Statistics.min((Number) bigDecimal0, numberArray0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test275() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        Number[] numberArray0 = new Number[0];
        FormulaDecimal formulaDecimal0 = Statistics.max((Number) bigInteger0, numberArray0);
        FormulaDecimal formulaDecimal1 = Statistics.median(formulaDecimal0, numberArray0);
        assertSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test276() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.TEN;
        FormulaDecimal formulaDecimal0 = Statistics.median(bigDecimal0, (Number[]) null);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test279() throws Throwable {
        Object[] objectArray0 = new Object[0];
        Float float0 = new Float((-3.4028235E38F));
        FormulaDecimal formulaDecimal0 = Statistics.maxa((Object) float0, objectArray0);
        assertNotNull(formulaDecimal0);
    }


    @Test(timeout = 4000)
    public void test281() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((BigDecimal) null);
        Number[] numberArray0 = new Number[2];
        FormulaDecimal formulaDecimal1 = Statistics.max((Object) formulaDecimal0, (Object[]) numberArray0);
        assertSame(formulaDecimal0, formulaDecimal1);
    }


    @Test(timeout = 4000)
    public void test283() throws Throwable {
        Double double0 = new Double((-496.6024468));
        FormulaDecimal formulaDecimal0 = Statistics.max((Object) double0, (Object[]) null);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test284() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.ZERO;
        FormulaDecimal formulaDecimal1 = Statistics.max((Number) formulaDecimal0, (Number[]) null);
        assertSame(formulaDecimal1, formulaDecimal0);
    }


    @Test(timeout = 4000)
    public void test295() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        FormulaDecimal formulaDecimal0 = Statistics.chisq_inv_rt(bigDecimal0, bigDecimal0);
        Number[] numberArray0 = new Number[7];
        numberArray0[6] = (Number) bigDecimal0;
        FormulaDecimal formulaDecimal1 = Statistics.large(formulaDecimal0, numberArray0);
        assertSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test296() throws Throwable {
        Double double0 = new Double(0.0);
        FormulaDecimal formulaDecimal0 = Statistics.phi(double0);
        FormulaDecimal formulaDecimal1 = Statistics.large(formulaDecimal0, (Number[]) null);
        assertSame(formulaDecimal0, formulaDecimal1);
    }


    @Test(timeout = 4000)
    public void test302() throws Throwable {
        Short short0 = new Short((short) 1752);
        Number[] numberArray0 = new Number[5];
        numberArray0[2] = (Number) short0;
        numberArray0[3] = (Number) short0;
        FormulaDecimal formulaDecimal0 = Statistics.geomean(short0, numberArray0);
        Logical logical0 = formulaDecimal0.gte(formulaDecimal0);
        FormulaDecimal formulaDecimal1 = Statistics.hypgeom_dist((Number) short0, numberArray0[3], (Number) formulaDecimal0, numberArray0[2], logical0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }

    @Test(timeout = 4000)
    public void test308() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);
        Number[] numberArray0 = new Number[6];
        numberArray0[0] = (Number) bigInteger0;
        numberArray0[1] = (Number) (byte) (-39);
        numberArray0[2] = (Number) formulaDecimal0;
        numberArray0[3] = (Number) (byte) (-39);
        numberArray0[4] = (Number) (byte) (-77);
        numberArray0[5] = (Number) (byte) (-39);
        FormulaDecimal formulaDecimal1 = Statistics.harmean(formulaDecimal0, numberArray0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test315() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1394.11986475);
        FormulaDecimal formulaDecimal1 = Statistics.gammaln(formulaDecimal0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }

    @Test(timeout = 4000)
    public void test319() throws Throwable {
        Byte byte0 = new Byte((byte) 62);
        FormulaDecimal formulaDecimal0 = Statistics.chisq_dist_rt(byte0, byte0);
        FormulaDecimal formulaDecimal1 = Statistics.gamma_inv(formulaDecimal0, formulaDecimal0, formulaDecimal0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }


    @Test(timeout = 4000)
    public void test353() throws Throwable {
        Object[] objectArray0 = new Object[8];
        StringWriter stringWriter0 = new StringWriter(4);
        StringWriter stringWriter1 = stringWriter0.append('N');
        StringBuffer stringBuffer0 = stringWriter1.getBuffer();
        CharBuffer charBuffer0 = CharBuffer.wrap((CharSequence) stringBuffer0);
        FormulaDecimal formulaDecimal0 = Statistics.counta((Object) charBuffer0, objectArray0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test354() throws Throwable {
        Byte byte0 = new Byte((byte) 10);
        Logical logical0 = Logical.TRUE;
        FormulaDecimal formulaDecimal0 = Statistics.t_dist((Number) byte0, (Number) byte0, logical0);
        Object[] objectArray0 = new Object[5];
        BigInteger bigInteger0 = formulaDecimal0.toBigInteger();
        objectArray0[1] = (Object) "";
        FormulaDecimal formulaDecimal1 = Statistics.counta((Object) bigInteger0, objectArray0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }


    @Test(timeout = 4000)
    public void test357() throws Throwable {
        Object[] objectArray0 = new Object[6];
        FormulaDecimal formulaDecimal0 = Statistics.count((Object) null, objectArray0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test358() throws Throwable {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.ZERO;
        FormulaDecimal formulaDecimal1 = Statistics.count((Object) formulaDecimal0, (Object[]) null);
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }

    @Test(timeout = 4000)
    public void test368() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.counta();
        BigInteger bigInteger0 = BigInteger.TEN;
        FormulaDecimal formulaDecimal1 = Statistics.chisq_inv(formulaDecimal0, bigInteger0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }

    @Test(timeout = 4000)
    public void test378() throws Throwable {
        Float float0 = new Float((float) 3L);
        FormulaDecimal formulaDecimal0 = FormulaDecimal.ZERO;
        FormulaDecimal formulaDecimal1 = Statistics.binom_dist_range((Number) float0, (Number) float0, (Number) float0, (Number) formulaDecimal0);
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
    }

    @Test(timeout = 4000)
    public void test409() throws Throwable {
        Number[] numberArray0 = new Number[1];
        FormulaDecimal formulaDecimal0 = Statistics.averagea((Object) null, numberArray0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test410() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        FormulaDecimal formulaDecimal0 = Statistics.f_dist_rt(bigInteger0, bigInteger0, bigInteger0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test416() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.count();
        FormulaDecimal formulaDecimal1 = Statistics.small(formulaDecimal0, (Number[]) null);
        assertSame(formulaDecimal0, formulaDecimal1);
    }

    @Test(timeout = 4000)
    public void test419() throws Throwable {
        FormulaDecimal formulaDecimal0 = Statistics.maxa();
        Number[] numberArray0 = new Number[0];
        FormulaDecimal formulaDecimal1 = Statistics.small(formulaDecimal0, numberArray0);
        assertSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test420() throws Throwable {
        Byte byte0 = new Byte((byte) 10);
        Logical logical0 = Logical.TRUE;
        FormulaDecimal formulaDecimal0 = Statistics.t_dist((Number) byte0, (Number) byte0, logical0);
        FormulaDecimal formulaDecimal1 = Statistics.gamma(formulaDecimal0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }


    @Test(timeout = 4000)
    public void test428() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.TEN;
        Logical logical0 = Logical.FALSE;
        Boolean boolean0 = Boolean.TRUE;
        FormulaDecimal formulaDecimal0 = Statistics.weibull_dist((Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, logical0);
        FormulaDecimal formulaDecimal1 = Statistics.f_dist((Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, boolean0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }


    @Test(timeout = 4000)
    public void test441() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        Boolean boolean0 = new Boolean("(QHk\"5}owi&jckt");
        FormulaDecimal formulaDecimal0 = Statistics.negbinom_dist((Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, boolean0);
        FormulaDecimal formulaDecimal1 = Statistics.poisson_dist((Number) bigInteger0, (Number) formulaDecimal0, boolean0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test443() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        BigDecimal bigDecimal0 = new BigDecimal(bigInteger0);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);
        Boolean boolean0 = Boolean.valueOf("{d.`5L\r1e4giUo9F");
        FormulaDecimal formulaDecimal1 = Statistics.chisq_dist((Number) bigInteger0, (Number) formulaDecimal0, boolean0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }

    @Test(timeout = 4000)
    public void test450() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        BigDecimal bigDecimal0 = new BigDecimal(bigInteger0);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);
        Boolean boolean0 = Boolean.valueOf("{d.`5L\r1e4giUo9F");
        FormulaDecimal formulaDecimal1 = Statistics.norm_s_dist((Number) formulaDecimal0, boolean0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test0035() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.TEN;
        Boolean boolean0 = new Boolean(true);
        FormulaDecimal formulaDecimal0 = Statistics.t_dist((Number) bigDecimal0, (Number) bigDecimal0, boolean0);
        Assert.assertEquals(BigDecimal.ZERO, Statistics.sumOfSquares(formulaDecimal0, (Number[]) null).asBigDecimal());
    }

    @Ignore
    @Test(timeout = 4000, expected = UniversalException.class)
    public void test0040() throws Throwable {
        Number[] numberArray0 = new Number[1];
        Statistics.quartile_inc((Number) null, numberArray0);
    }

    @Test(timeout = 4000)
    public void test0042() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((char[]) null);
        Number[] numberArray0 = new Number[7];
        numberArray0[0] = (Number) formulaDecimal0;
        numberArray0[1] = (Number) formulaDecimal0;
        numberArray0[5] = (Number) formulaDecimal0;
        Assert.assertEquals(BigDecimal.ZERO, Statistics.prob(formulaDecimal0, numberArray0).asBigDecimal());
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test0044() throws Throwable {
        Statistics.phi((Number) null);
    }


    @Test(timeout = 4000, expected = UniversalException.class)
    public void test0061() throws Throwable {
        Statistics.gamma((Number) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test0062() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal(0L);
        Statistics.forecast(bigDecimal0, (Number[]) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test0067() throws Throwable {
        Statistics.f_inv_rt((Number) null, (Number) null, (Number) null);
    }


    @Test(timeout = 4000, expected = UniversalException.class)
    public void test0070() throws Throwable {
        Statistics.f_inv((Number) null, (Number) null, (Number) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test0072() throws Throwable {
        Statistics.f_dist_rt((Number) null, (Number) null, (Number) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test0109() throws Throwable {
        Statistics.averageif((Object[]) null);
    }

    @Ignore
    @Test(timeout = 4000, expected = UniversalException.class)
    public void test223() throws Throwable {
        Number[] numberArray0 = new Number[6];
        Statistics.quartile_exc(numberArray0[5], numberArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test396() throws Throwable {
        Statistics.averageif((Number[]) null, (CharSequence) null, (Number[]) null);
    }

    @Test(expected = UniversalException.class)
    public void test397() {
        Statistics.average(null, null);
    }

    @Test(expected = UniversalException.class)
    public void test398() {
        Statistics.average(null);
    }

    @Test(expected = UniversalException.class)
    public void test399() {
        Statistics.averagea(null, null);
    }

    @Test(expected = UniversalException.class)
    public void test400() {
        Statistics.averagea(null);
    }

    @Test(expected = UniversalException.class)
    public void test401() {
        Statistics.averageif(null, null);
    }

    @Test(expected = UniversalException.class)
    public void test402() {
        Statistics.averageif(null);
    }

    @Test(expected = UniversalException.class)
    public void testProbNulls() {
        Statistics.prob(null, null);
    }

    @Test(expected = UniversalException.class)
    public void testProbNull() {
        Statistics.prob(null);
    }

    @Test(expected = UniversalException.class)
    public void testQuartileExcNulls() {
        Statistics.quartile_exc(null, null);
    }

    @Test(expected = UniversalException.class)
    public void testQuartileExcNull() {
        Statistics.quartile_exc(null);
    }

    @Test(expected = UniversalException.class)
    public void testQuartileIncNulls() {
        Statistics.quartile_inc(null, null);
    }

    @Test(expected = UniversalException.class)
    public void testQuartileIncNull() {
        Statistics.quartile_inc(null);
    }

    @Test(expected = UniversalException.class)
    public void testRankAvgNulls() {
        Statistics.rank_avg(null, null);
    }

    @Test(expected = UniversalException.class)
    public void testRankAvgNull() {
        Statistics.rank_avg(null);
    }

    @Test(expected = UniversalException.class)
    public void testRankEqNulls() {
        Statistics.rank_eq(null, null);
    }

    @Test(expected = UniversalException.class)
    public void testRankEqNull() {
        Statistics.rank_eq(null);
    }

    @Test(expected = UniversalException.class)
    public void testRsqNulls() {
        Statistics.rsq((Number) null, null);
    }

    @Test(expected = UniversalException.class)
    public void testRsqNull() {
        Statistics.rsq(null);
    }

    @Test(expected = UniversalException.class)
    public void testSkewNulls() {
        Statistics.skew(null, null);
    }

    @Test(expected = UniversalException.class)
    public void testSkewNull() {
        Statistics.skew(null);
    }

    @Test(expected = UniversalException.class)
    public void testSkewPNulls() {
        Statistics.skew_p(null, null);
    }

    @Test(expected = UniversalException.class)
    public void testSkewPNull() {
        Statistics.skew_p(null);
    }

    @Test(expected = UniversalException.class)
    public void testSlopeNulls() {
        Statistics.slope((Number) null, null);
    }

    @Test(expected = UniversalException.class)
    public void testSlopeNull() {
        Statistics.slope(null);
    }


    @Test(expected = UniversalException.class)
    public void testStDevPNulls() {
        Statistics.stdev_p(null, null);
    }

    @Test(expected = UniversalException.class)
    public void testStDevPNull() {
        Statistics.stdev_p(null);
    }

    @Test(expected = UniversalException.class)
    public void testStDevSNulls() {
        Statistics.stdev_s(null, null);
    }

    @Test(expected = UniversalException.class)
    public void testStDevSNull() {
        Statistics.stdev_s(null);
    }

    @Test(expected = UniversalException.class)
    public void testStDevPANulls() {
        Statistics.stdevpa(null, null);
    }

    @Test(expected = UniversalException.class)
    public void testStDevPANull() {
        Statistics.stdevpa(null);
    }

    @Test(expected = UniversalException.class)
    public void testSteyxNulls() {
        Statistics.steyx((Number) null, null);
    }

    @Test(expected = UniversalException.class)
    public void testSteyxNull() {
        Statistics.steyx(null);
    }

    @Test(expected = UniversalException.class)
    public void testTTestNulls() {
        Statistics.t_test(null, null);
    }

    @Test(expected = UniversalException.class)
    public void testTTestNull() {
        Statistics.t_test(null);
    }

    @Test(expected = UniversalException.class)
    public void testZTestNulls() {
        Statistics.z_test((Number) null, null);
    }

    @Test(expected = UniversalException.class)
    public void testZTestNull() {
        Statistics.z_test(null);
    }

    @Test(expected = UniversalException.class)
    public void testVarPNulls() {
        Statistics.var_p(null, null);
    }

    @Test(expected = UniversalException.class)
    public void testVarPNull() {
        Statistics.var_p(null);
    }


    @Test(expected = UniversalException.class)
    public void testVarSNulls() {
        Statistics.var_s(null, null);
    }

    @Test(expected = UniversalException.class)
    public void testVarSNull() {
        Statistics.var_s(null);
    }

    @Test(expected = UniversalException.class)
    public void testVaraNulls() {
        Statistics.vara(null, null);
    }

    @Test(expected = UniversalException.class)
    public void testVaraNull() {
        Statistics.vara(null);
    }

    @Test(expected = UniversalException.class)
    public void testVarpaNulls() {
        Statistics.varpa(null, null);
    }

    @Test(expected = UniversalException.class)
    public void testVarpaNull() {
        Statistics.vara(null);
    }


    @Test(expected = UniversalException.class)
    public void testBetaDistNullArgumentX() {
        Statistics.beta_dist(null, 1, 1, Logical.TRUE);
    }

    @Test(expected = UniversalException.class)
    public void testBetaDistNullArgumentAlpha() {
        Statistics.beta_dist(1, null, 1, Logical.TRUE);
    }

    @Test(expected = UniversalException.class)
    public void testBetaDistNullArgumentBeta() {
        Statistics.beta_dist(1, 1, null, Logical.TRUE);
    }

    @Test(expected = UniversalException.class)
    public void testBetaDistNullArgumentCumulative() {
        Statistics.beta_dist(1, 1, 1, (Logical) null);
    }

    @Test(expected = UniversalException.class)
    public void testBetaInvNullArgumentProbability() {
        Statistics.beta_inv(null, 1, 1);
    }

    @Test(expected = UniversalException.class)
    public void testBetaInvNullArgumentAlpha() {
        Statistics.beta_inv(1, null, 1);
    }

    @Test(expected = UniversalException.class)
    public void testBetaInvNullArgumentBeta() {
        Statistics.beta_inv(1, 1, null);
    }

    @Test(expected = UniversalException.class)
    public void testBinomDistNullArgumentSuccesses() {
        Statistics.binom_dist(null, 1, 1, Logical.TRUE);
    }

    @Test(expected = UniversalException.class)
    public void testBinomDistNullArgumentTrials() {
        Statistics.binom_dist(1, null, 1, Logical.TRUE);
    }

    @Test(expected = UniversalException.class)
    public void testBinomDistNullArgumentProbability() {
        Statistics.binom_dist(1, 1, null, Logical.TRUE);
    }

    @Test(expected = UniversalException.class)
    public void testBinomDistNullArgumentCumulative() {
        Statistics.binom_dist(1, 1, 1, (Logical) null);
    }

    @Test(expected = UniversalException.class)
    public void testBinomDistRangeNullArgumentTrials() {
        Statistics.binom_dist_range(null, 1, 1);
    }

    @Test(expected = UniversalException.class)
    public void testBinomDistRangeNullArgumentProbability() {
        Statistics.binom_dist_range(1, null, 1);
    }

    @Test(expected = UniversalException.class)
    public void testBinomDistRangeNullArgumentSuccesses() {
        Statistics.binom_dist_range(1, 1, null);
    }

    @Test(expected = UniversalException.class)
    public void testBinomInvNullArgumentTrials() {
        Statistics.binom_inv(null, 1, 1);
    }

    @Test(expected = UniversalException.class)
    public void testBinomInvNullArgumentProbability() {
        Statistics.binom_inv(1, null, 1);
    }

    @Test(expected = UniversalException.class)
    public void testBinomInvNullArgumentAlpha() {
        Statistics.binom_inv(1, 1, null);
    }
}
