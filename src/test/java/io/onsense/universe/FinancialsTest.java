package io.onsense.universe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.time.Instant;
import java.util.Date;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author Koen Rooijmans
 */
public class FinancialsTest {

    @Before
    public void setUp() throws Exception {
        System.setProperty("user.timezone", "UTC");
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test001() throws Throwable {
        double[] doubleArray0 = new double[3];
        doubleArray0[0] = 1412.34655772234;

        Financials.irr_result(doubleArray0, doubleArray0, (-966.6838606));
        fail("Expecting exception: NumberFormatException");
    }

    @Test(timeout = 4000)
    public void test002() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.TEN;

        Financials.pv((Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test003() throws Throwable {
        Moment moment0 = new Moment((-1348L));
        Number number0 = moment0.year();
        Financials.coupdaysnc(number0, (Date) moment0, number0);
        assertEquals("Thu Dec 31 23:59:58 GMT 1970", moment0.toString());
    }

    @Test(timeout = 4000)
    public void test004() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        Moment moment0 = Moment.valueOf(2678, 0, 2678, 2678, 2678);
        FormulaDecimal formulaDecimal0 = Financials.pricedisc((Number) bigDecimal0, (Date) moment0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test005() throws Throwable {
        Moment moment0 = Moment.valueOf((-1278L));
        Moment moment1 = Financials.lcl_GetCouppcd(moment0, moment0, 439);
        assertNotNull(moment1.toString());
    }

    @Test(timeout = 4000)
    public void test006() throws Throwable {
        Moment moment0 = Moment.valueOf((-404), 0, (-404), 0, (-404));
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(7L);
        FormulaDecimal formulaDecimal1 = new FormulaDecimal(0L);

        Assert.assertNotNull(Financials.yieldmat((Date) moment0, (Number) formulaDecimal0, (Number) formulaDecimal1, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal1));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test007() throws Throwable {
        Object object0 = new Object();
        Object[] objectArray0 = new Object[6];
        objectArray0[5] = object0;

        Assert.assertNotNull(Financials.xirr(object0, objectArray0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test008() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        MathContext mathContext0 = MathContext.UNLIMITED;
        BigDecimal bigDecimal0 = new BigDecimal(bigInteger0, 3, mathContext0);

        Financials.pricemat((Number) bigDecimal0, (Date) null, (Date) null, (Number) bigDecimal0, (Number) bigInteger0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test009() throws Throwable {
        Short short0 = new Short((short) 2414);
        Moment moment0 = Moment.valueOf((int) (short) 2414, 2000, (int) (short) 2414);
        Financials.pricemat((Number) short0, (Date) moment0, (Number) null, (Number) short0, (Number) null);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test010() throws Throwable {
        Moment moment0 = new Moment();

        Financials.pricedisc((Date) moment0, (Date) moment0, (Number) null, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test011() throws Throwable {
        Double double0 = new Double(1.0);
        Number[] numberArray0 = new Number[3];
        numberArray0[0] = (Number) double0;
        numberArray0[2] = (Number) double0;

        Financials.mirr((Number) double0, numberArray0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Ignore
    @Test(timeout = 4000)
    public void test012() throws Throwable {

        Financials.lcl_GetCouppcd((Moment) null, (Moment) null, (-2352));
    }

    @Ignore
    @Test(timeout = 4000)
    public void test013() throws Throwable {
        Moment moment0 = Moment.valueOf(0, (-2178), 0, (-1069), 0, (-2178));
        // Undeclared exception!
        Financials.lcl_GetCoupncd(moment0, moment0, 0);
    }

    @Ignore
    @Test(timeout = 4000)
    public void test014() throws Throwable {

        Financials.lcl_GetCoupncd((Moment) null, (Moment) null, 685);
    }

    @Ignore
    @Test(timeout = 4000)
    public void test015() throws Throwable {
        double[] doubleArray0 = new double[3];
        double[] doubleArray1 = new double[2];

        Financials.irr_result(doubleArray0, doubleArray1, (-966.6838606));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test016() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal((-942));

        Financials.ipmt((Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test017() throws Throwable {
        byte[] byteArray0 = new byte[8];
        BigInteger bigInteger0 = new BigInteger(byteArray0);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);
        BigDecimal bigDecimal0 = BigDecimal.ZERO;

        Financials.ipmt((Number) bigInteger0, (Number) formulaDecimal0, (Number) (byte) 100, (Number) bigDecimal0, (Number) (byte) 64, (Number) (byte) 16);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test018() throws Throwable {
        Financials.fv((Number) null, (Number) null, (Number) null, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test019() throws Throwable {

        Financials.cumprinc((Number) null, (Number) null, (Number) null, (Number) null, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test020() throws Throwable {

        Financials.couppcd((Date) null, (Date) null, (Number) null, (Number) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test021() throws Throwable {
        Date Date0 = new Date(0, 50, 0, (-892), (-892), (-892));
        BigInteger bigInteger0 = BigInteger.ZERO;
        Financials.couppcd((Number) bigInteger0, (Date) Date0, (Number) bigInteger0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test022() throws Throwable {
        Moment moment0 = new Moment((-3271L));
        BigDecimal bigDecimal0 = BigDecimal.ZERO;
        CharBuffer charBuffer0 = CharBuffer.allocate(0);
        Boolean boolean0 = Boolean.TRUE;
        Financials.accrint((CharSequence) charBuffer0, (CharSequence) charBuffer0, (Date) moment0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, boolean0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test023() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        BigDecimal bigDecimal0 = BigDecimal.TEN;

        Financials.pmt((Number) bigInteger0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigInteger0, (Number) bigDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test024() throws Throwable {
        Moment moment0 = Moment.valueOf(0, 0, 0);
        Financials.pricemat((Date) moment0, (Date) moment0, (Date) moment0, (Number) null, (Number) null, (Number) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test025() throws Throwable {
        Date Date0 = new Date(0, 0, 8);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(2169);

        Financials.pricedisc((Date) Date0, (Date) Date0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0);
        fail("Expecting exception: UnsupportedOperationException");
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test026() throws Throwable {
        Moment moment0 = Moment.valueOf(134, 134, (-444), 360, (-1000));

        Financials.coupnum((Date) moment0, (Date) moment0, (Number) null, (Number) null);
    }

    @Test(timeout = 4000)
    public void test028() throws Throwable {
        double[] doubleArray0 = new double[3];
        FormulaDecimal formulaDecimal0 = Financials.irr_result(doubleArray0, doubleArray0, (-966.6838606));
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test029() throws Throwable {
        Object object0 = new Object();
        Object[] objectArray0 = new Object[6];

        Financials.xirr(object0, objectArray0);
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test030() throws Throwable {
        Number[] numberArray0 = new Number[1];
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1922L);
        numberArray0[0] = (Number) formulaDecimal0;

        Financials.mirr(numberArray0, (Number) formulaDecimal0, (Number) formulaDecimal0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test031() throws Throwable {
        StringWriter stringWriter0 = new StringWriter(360);
        StringBuffer stringBuffer0 = stringWriter0.getBuffer();
        Float float0 = new Float(0.0);

        Financials.accrintm((CharSequence) stringBuffer0, (CharSequence) stringBuffer0, (Number) float0, (Number) float0, (Number) float0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test032() throws Throwable {

        Financials.ipmt((Number) null, (Number) null, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test033() throws Throwable {
        Moment moment0 = new Moment();
        Float float0 = new Float((-1.0F));
        Financials.price((Date) moment0, (CharSequence) null, (Number) float0, (Number) float0, (Number) float0, (Number) float0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test034() throws Throwable {
        Date Date0 = new Date((-417), 4129, 2517, 10, 2517);

        Financials.yieldmat((Number) null, (Date) Date0, (Number) null, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test035() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ONE;

        Financials.coupdaysnc((CharSequence) null, (CharSequence) null, (Number) bigDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test036() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ZERO;
        Financials.oddfprice((Number) bigDecimal0, (CharSequence) null, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test037() throws Throwable {
        char[] charArray0 = new char[3];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        BigDecimal bigDecimal0 = BigDecimal.ONE;

        Financials.oddfyield((CharSequence) charBuffer0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test038() throws Throwable {
        Moment moment0 = Moment.valueOf((-2612), 100, 100, 100, (-3292), (-1451));
        Short short0 = Short.valueOf((short) (-1760));

        Financials.yieldmat((Date) moment0, (Date) moment0, (CharSequence) null, (Number) short0, (Number) short0, (Number) short0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test039() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal(0L);

        Financials.nominal(bigDecimal0, bigDecimal0);
        fail("Expecting exception: ArithmeticException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test040() throws Throwable {

        Financials.pricemat((Number) null, (Number) null, (Number) null, (Number) null, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test041() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((long) (-578));
        FormulaDecimal formulaDecimal1 = Financials.sln(formulaDecimal0, formulaDecimal0, formulaDecimal0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test042() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ZERO;
        CharBuffer charBuffer0 = CharBuffer.allocate(0);

        Financials.oddlprice((CharSequence) charBuffer0, (Date) null, (CharSequence) charBuffer0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test043() throws Throwable {
        char[] charArray0 = new char[6];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        BigInteger bigInteger0 = BigInteger.ONE;

        Financials.oddfprice((CharSequence) charBuffer0, (Date) null, (Date) null, (Date) null, (Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test044() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);

        Financials.pricedisc((Number) formulaDecimal0, (Date) null, (Number) bigInteger0, (Number) formulaDecimal0, (Number) formulaDecimal0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test045() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(10);
        Double double0 = new Double(0.0);

        Financials.coupncd((CharSequence) charBuffer0, (CharSequence) charBuffer0, (Number) double0, (Number) double0);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test046() throws Throwable {
        Moment moment0 = new Moment();
        BigDecimal bigDecimal0 = new BigDecimal(2.5);
        // Undeclared exception!
        Financials.coupdaysnc((Date) moment0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test047() throws Throwable {
        Moment moment0 = new Moment(0L);
        BigInteger bigInteger0 = BigInteger.ZERO;

        Financials.coupncd((Date) moment0, (Date) null, (Number) bigInteger0);

    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test048() throws Throwable {
        Moment moment0 = new Moment((-3271L));
        CharBuffer charBuffer0 = CharBuffer.allocate(0);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((long) 0);

        Financials.oddlyield((Date) moment0, (CharSequence) charBuffer0, (CharSequence) charBuffer0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test049() throws Throwable {
        Moment moment0 = new Moment();
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(1L, (-1));
        char[] charArray0 = new char[1];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);

        Financials.coupnum((Date) moment0, (CharSequence) charBuffer0, (Number) formulaDecimal0, (Number) formulaDecimal0);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test050() throws Throwable {
        Long long0 = new Long(0L);
        Date Date0 = new Date(2791, 4, (-1751), (-1751), (-1751));

        Financials.amordegrc((Number) long0, (Number) long0, (Date) Date0, (Number) long0, (Number) long0, (Number) long0);
        fail("Expecting exception: ArithmeticException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test051() throws Throwable {
        StringWriter stringWriter0 = new StringWriter(0);
        StringBuffer stringBuffer0 = stringWriter0.getBuffer();

        Financials.yielddisc((CharSequence) stringBuffer0, (CharSequence) stringBuffer0, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test052() throws Throwable {
        char[] charArray0 = new char[5];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        Moment moment0 = Moment.valueOf(0, (-3427), (-3427), 0, 0);
        byte[] byteArray0 = new byte[3];
        BigInteger bigInteger0 = new BigInteger(byteArray0);

        Financials.amorlinc((Number) (byte) (-56), (CharSequence) charBuffer0, (Date) moment0, (Number) (byte) 116, (Number) (byte) (-56), (Number) bigInteger0);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test053() throws Throwable {
        Date Date0 = new Date(0L);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(2000);

        Financials.oddlprice((Number) null, (Number) null, (Date) Date0, (Number) null, (Number) null, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test054() throws Throwable {
        char[] charArray0 = new char[2];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        Moment moment0 = Moment.valueOf(100, (-871), (-908), 100, 0);

        Financials.mduration((CharSequence) charBuffer0, (Date) moment0, (Number) null, (Number) null, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test055() throws Throwable {
        Date Date0 = new Date(0, (-952), (-952), (-952), 4, 234);
        CharBuffer charBuffer0 = CharBuffer.allocate(88);

        Financials.tbillyield((Date) Date0, (CharSequence) charBuffer0, (Number) null);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test056() throws Throwable {
        Moment moment0 = Moment.valueOf(0L);

        Financials.pricemat((Date) moment0, (Number) null, (Date) moment0, (Number) null, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test057() throws Throwable {
        Date Date0 = new Date((-1354), (-2506), (-2506));
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((double) (-1354));

        Financials.yieldmat((Date) Date0, (Number) formulaDecimal0, (Date) Date0, (Number) null, (Number) formulaDecimal0, (Number) formulaDecimal0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test058() throws Throwable {
        Charset charset0 = Charset.defaultCharset();
        ByteBuffer byteBuffer0 = ByteBuffer.allocate(0);
        CharBuffer charBuffer0 = charset0.decode(byteBuffer0);

        Financials.tbillprice((Number) null, (CharSequence) charBuffer0, (Number) null);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test059() throws Throwable {
        Date Date0 = new Date(0, (-1061), (-1061), 0, 0, 0);

        Financials.oddlprice((Date) Date0, (Date) Date0, (Number) null, (Number) null, (Number) null, (Number) null, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Ignore
    @Test(timeout = 4000)
    public void test060() throws Throwable {
        Moment moment0 = Moment.valueOf(15, 16, 50, 16, 0);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((long) 0);

        Financials.oddfprice((Date) moment0, (Date) moment0, (Date) moment0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test061() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(3728);
        Byte byte0 = new Byte((byte) (-89));

        Financials.coupdays((CharSequence) charBuffer0, (Number) byte0, (Number) byte0, (Number) byte0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000)
    public void test062() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal(2898L);
        Moment moment0 = Moment.valueOf((-1278L));
        Assert.assertNotNull(Financials.intrate((Number) bigDecimal0, (Date) moment0, (Number) bigDecimal0, (Number) bigDecimal0));
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test063() throws Throwable {
        Financials.amordegrc((Number) null, (Number) null, (CharSequence) null, (Number) null, (Number) null, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test064() throws Throwable {
        byte[] byteArray0 = new byte[1];
        BigInteger bigInteger0 = new BigInteger(byteArray0);
        BigDecimal bigDecimal0 = new BigDecimal(bigInteger0);

        Financials.pricemat((Date) null, (Number) bigDecimal0, (Number) (byte) 101, (Number) (byte) 101, (Number) bigInteger0);
    }

    @Ignore
    @Test(timeout = 4000)
    public void test065() throws Throwable {
        Moment moment0 = Moment.valueOf((-242), 363, 363);
        BigDecimal bigDecimal0 = new BigDecimal((double) 363);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-242));

        Financials.oddfyield((Date) moment0, (Date) moment0, (Number) bigDecimal0, (Date) moment0, (Number) formulaDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) formulaDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test066() throws Throwable {
        Date Date0 = new Date(2181, 0, 0, 1323, 15, (-1097));
        Moment moment0 = new Moment(Date0);
        BigDecimal bigDecimal0 = new BigDecimal(1323);

        Financials.pricedisc((Date) moment0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test067() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;

        Financials.oddlprice((Date) null, (Number) bigInteger0, (Date) null, (Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test068() throws Throwable {
        Charset charset0 = Charset.defaultCharset();
        byte[] byteArray0 = new byte[5];
        ByteBuffer byteBuffer0 = ByteBuffer.wrap(byteArray0);
        CharBuffer charBuffer0 = charset0.decode(byteBuffer0);

        Financials.pricedisc((CharSequence) charBuffer0, (Number) (byte) 0, (Number) (byte) 0, (Number) (byte) 14, (Number) (byte) 0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test069() throws Throwable {
        Date Date0 = new Date(1534, 11, (-3326), (-672), 11);
        Moment moment0 = new Moment(Date0);
        StringWriter stringWriter0 = new StringWriter();
        StringBuffer stringBuffer0 = stringWriter0.getBuffer();
        BigDecimal bigDecimal0 = BigDecimal.ZERO;

        Financials.oddlprice((Date) moment0, (CharSequence) stringBuffer0, (Date) moment0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test070() throws Throwable {

        Financials.syd((Number) null, (Number) null, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test071() throws Throwable {
        char[] charArray0 = new char[0];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);

        Financials.accrint((Date) null, (Date) null, (CharSequence) charBuffer0, (Number) null, (Number) null, (Number) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test072() throws Throwable {
        Moment moment0 = Moment.valueOf((-2970), (-2970), (-2970));
        BigDecimal bigDecimal0 = BigDecimal.TEN;
        FormulaDecimal formulaDecimal0 = Financials.pricedisc((Date) moment0, (Date) moment0, (Number) bigDecimal0, (Number) bigDecimal0);

        Financials.disc((Date) moment0, (Number) formulaDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test073() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(0);

        Financials.yieldmat((Number) null, (Number) null, (CharSequence) charBuffer0, (Number) null, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test074() throws Throwable {
        StringWriter stringWriter0 = new StringWriter(2363);
        StringBuffer stringBuffer0 = stringWriter0.getBuffer();
        Float float0 = new Float((float) 2363);
        Moment moment0 = Moment.valueOf((-2574L));

        Financials.mduration((Date) moment0, (CharSequence) stringBuffer0, (Number) float0, (Number) float0, (Number) float0, (Number) float0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test075() throws Throwable {
        Charset charset0 = Charset.defaultCharset();
        ByteBuffer byteBuffer0 = ByteBuffer.allocateDirect(7);
        CharBuffer charBuffer0 = charset0.decode(byteBuffer0);
        Moment moment0 = new Moment();
        BigDecimal bigDecimal0 = new BigDecimal((long) 7);
        Number number0 = moment0.weekday();

        Financials.mduration((Number) bigDecimal0, (CharSequence) charBuffer0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, number0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test076() throws Throwable {
        StringWriter stringWriter0 = new StringWriter(100);
        char[] charArray0 = new char[3];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        StringBuffer stringBuffer0 = stringWriter0.getBuffer();

        Financials.oddfyield((Number) null, (Number) null, (CharSequence) stringBuffer0, (CharSequence) charBuffer0, (Number) null, (Number) null, (Number) null, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test077() throws Throwable {
        Date Date0 = new Date((byte) 16, (-3248), 3, (byte) 0, 3, 3);

        Financials.couppcd((Number) (byte) 0, (Date) Date0, (Number) (byte) 16);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test078() throws Throwable {
        Long long0 = new Long(1072L);
        FormulaDecimal formulaDecimal0 = Financials.oddlprice((Number) long0, (Number) long0, (Number) long0, (Number) long0, (Number) long0, (Number) long0, (Number) long0, (Number) long0);
        Financials.amorlinc((Number) long0, (Number) long0, (Date) null, (Number) long0, (Number) long0, (Number) formulaDecimal0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test079() throws Throwable {
        char[] charArray0 = new char[7];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        Float float0 = new Float(0.0);

        Financials.yieldmat((CharSequence) charBuffer0, (CharSequence) charBuffer0, (Number) float0, (Number) float0, (Number) float0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test080() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((long) 0);
        FormulaDecimal formulaDecimal1 = Financials.couppcd((Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test081() throws Throwable {
        Long long0 = Long.valueOf(1249L);
        CharBuffer charBuffer0 = CharBuffer.allocate(1739);

        Financials.oddlprice((CharSequence) charBuffer0, (CharSequence) charBuffer0, (Number) long0, (Number) long0, (Number) long0, (Number) long0, (Number) long0);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test082() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(100);
        Moment moment0 = Moment.valueOf(6, (-1326), (-1326), 764, 2179);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(764);

        Financials.oddfyield((Date) moment0, (Date) moment0, (Date) moment0, (CharSequence) charBuffer0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test083() throws Throwable {
        StringWriter stringWriter0 = new StringWriter(3);
        StringBuffer stringBuffer0 = stringWriter0.getBuffer();
        Date Date0 = new Date(328, 7, 7, 7, 100);
        BigDecimal bigDecimal0 = BigDecimal.ONE;

        Financials.yieldmat((CharSequence) stringBuffer0, (Number) bigDecimal0, (Date) Date0, (Number) bigDecimal0, (Number) bigDecimal0);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test084() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0L);

        Financials.accrintm((Number) null, (Number) null, (Number) null, (Number) formulaDecimal0);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test085() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(2000);

        Financials.yielddisc((CharSequence) charBuffer0, (Number) null, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test086() throws Throwable {
        char[] charArray0 = new char[1];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        Float float0 = new Float(1910.6826792258);

        Financials.oddlprice((Date) null, (CharSequence) charBuffer0, (CharSequence) charBuffer0, (Number) null, (Number) null, (Number) null, (Number) float0);
    }

    @Ignore
    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test087() throws Throwable {
        StringWriter stringWriter0 = new StringWriter();
        StringBuffer stringBuffer0 = stringWriter0.getBuffer();
        Moment moment0 = Moment.valueOf(0, 2689, (-3830), 2689, 2689);
        CharBuffer charBuffer0 = CharBuffer.wrap((CharSequence) stringBuffer0);
        Long long0 = new Long(0);

        Financials.oddfprice((CharSequence) charBuffer0, (CharSequence) charBuffer0, (Date) moment0, (CharSequence) charBuffer0, (Number) null, (Number) null, (Number) long0, (Number) long0, (Number) long0);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Ignore
    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test088() throws Throwable {
        Moment moment0 = Moment.valueOf(0L);
        CharBuffer charBuffer0 = CharBuffer.allocate(0);
        BigInteger bigInteger0 = BigInteger.ONE;

        Financials.oddfprice((Date) moment0, (CharSequence) charBuffer0, (CharSequence) charBuffer0, (CharSequence) charBuffer0, (Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test089() throws Throwable {
        Date Date0 = new Date(2305, (-1336), 0, (-1336), 0);

        Financials.accrintm((Date) Date0, (Number) null, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test090() throws Throwable {
        Date Date0 = new Date(1636, 0, 1636, 2141, 2141, (-2519));
        char[] charArray0 = new char[1];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        Short short0 = new Short((short) 2392);

        Financials.yieldmat((Date) Date0, (CharSequence) charBuffer0, (CharSequence) charBuffer0, (Number) short0, (Number) short0, (Number) short0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test091() throws Throwable {
        Date Date0 = new Date(0L);
        Moment moment0 = Moment.valueOf((Date) Date0);

        Financials.amordegrc((Number) null, (Date) moment0, (Number) null, (Number) null, (Number) null, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test092() throws Throwable {
        Float float0 = new Float(1.0F);
        Moment moment0 = Moment.valueOf((-720), 2954, (-720), (-720), 1079, 2954);
        FormulaDecimal formulaDecimal0 = Financials.coupdays((Number) float0, (Number) float0, (Number) float0, (Number) float0);
        Financials.oddfyield((Number) float0, (Date) moment0, (Number) float0, (Number) float0, (Number) float0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) float0, (Number) float0);
    }

    @Ignore
    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test093() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal((-3368L));
        char[] charArray0 = new char[1];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0, 0, 0);

        Financials.oddfyield((Number) bigDecimal0, (CharSequence) charBuffer0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test094() throws Throwable {
        char[] charArray0 = new char[9];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        Moment moment0 = new Moment(3930L);
        BigDecimal bigDecimal0 = new BigDecimal((double) 3930L);

        Financials.oddfprice((CharSequence) charBuffer0, (CharSequence) charBuffer0, (Date) moment0, (Date) moment0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test095() throws Throwable {
        char[] charArray0 = new char[6];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0L);

        Financials.oddfprice((CharSequence) charBuffer0, (CharSequence) charBuffer0, (CharSequence) charBuffer0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) null);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test096() throws Throwable {
        Date Date0 = new Date();
        BigDecimal bigDecimal0 = BigDecimal.ZERO;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);
        Boolean boolean0 = Boolean.valueOf("");
        Financials.accrint((CharSequence) null, (CharSequence) null, (Date) Date0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, boolean0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test097() throws Throwable {
        Moment moment0 = Moment.valueOf(0, 0, 0, 200, 200, 200);

        Financials.coupdaysnc((CharSequence) null, (Date) moment0, (Number) null);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test098() throws Throwable {
        Moment moment0 = new Moment();
        CharBuffer charBuffer0 = CharBuffer.allocate(0);
        Float float0 = new Float((float) 0);

        Financials.oddlprice((CharSequence) charBuffer0, (CharSequence) charBuffer0, (Date) moment0, (Number) float0, (Number) float0, (Number) float0, (Number) float0, (Number) float0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test099() throws Throwable {
        char[] charArray0 = new char[9];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1.0);

        Financials.oddfyield((CharSequence) charBuffer0, (Number) formulaDecimal0, (CharSequence) charBuffer0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test100() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        Financials.coupdaybs((Number) bigInteger0, (CharSequence) null, (Number) bigInteger0);
        fail("Expecting exception: NullPointerException");

    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test101() throws Throwable {
        Long long0 = Long.valueOf((-373L));
        Financials.rri(long0, long0, long0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test102() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        BigDecimal bigDecimal0 = new BigDecimal(bigInteger0);
        char[] charArray0 = new char[3];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        Float float0 = new Float((float) (-2689L));

        Financials.oddlyield((CharSequence) charBuffer0, (Number) bigDecimal0, (Number) bigInteger0, (Number) bigInteger0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) float0);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test103() throws Throwable {
        Integer integer0 = Integer.getInteger("P+p7Fj?r9Tnp@~M+", (-2830));
        Moment moment0 = Moment.valueOf(2045L);
        FormulaDecimal formulaDecimal0 = Financials.accrint((Date) moment0, (Date) moment0, (Date) moment0, (Number) integer0, (Number) integer0, (Number) integer0);

        Financials.oddfyield((Number) integer0, (Date) moment0, (Number) integer0, (Number) integer0, (Number) integer0, (Number) integer0, (Number) formulaDecimal0, (Number) formulaDecimal0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test104() throws Throwable {
        Charset charset0 = Charset.defaultCharset();
        byte[] byteArray0 = new byte[7];
        ByteBuffer byteBuffer0 = ByteBuffer.wrap(byteArray0);
        CharBuffer charBuffer0 = charset0.decode(byteBuffer0);
        Date Date0 = new Date();
        Moment moment0 = new Moment(Date0);

        Financials.accrint((CharSequence) charBuffer0, (Date) moment0, (Date) moment0, (Number) (byte) (-24), (Number) (byte) (-39), (Number) (byte) (-84), (Number) (byte) (-84));
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test105() throws Throwable {
        Moment moment0 = new Moment();
        BigDecimal bigDecimal0 = BigDecimal.valueOf((-1007L), 12);

        Financials.intrate((CharSequence) null, (Date) moment0, (Number) bigDecimal0, (Number) null, (Number) bigDecimal0);
    }

    @Ignore
    @Test(timeout = 4000)
    public void test106() throws Throwable {
        Moment moment0 = Moment.valueOf((-2745), (-2745), (-2745), (-1135), (-2745));
        Financials.oddfprice((Date) moment0, (Date) moment0, (Date) moment0, (Date) moment0, (Number) null, (Number) null, (Number) null, (Number) null);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test107() throws Throwable {
        Moment moment0 = Moment.valueOf(11, 11, 0, 0, 0, 0);
        Boolean boolean0 = new Boolean("m");
        Financials.accrint((Date) moment0, (Number) null, (Number) null, (Number) null, (Number) null, (Number) null, (Number) null, boolean0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test108() throws Throwable {
        Moment moment0 = new Moment();
        Number number0 = moment0.hour();
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf(1L, (-1));
        char[] charArray0 = new char[1];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);

        Financials.intrate((CharSequence) charBuffer0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, number0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test109() throws Throwable {
        char[] charArray0 = new char[7];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        Moment moment0 = new Moment(0L);
        BigInteger bigInteger0 = BigInteger.ONE;
        BigDecimal bigDecimal0 = new BigDecimal(bigInteger0);
        Logical logical0 = Logical.valueOf("S?S");

        Financials.accrint((CharSequence) charBuffer0, (CharSequence) charBuffer0, (Date) moment0, (Number) bigDecimal0, (Number) bigInteger0, (Number) bigDecimal0, (Number) bigDecimal0, logical0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test110() throws Throwable {
        Moment moment0 = Moment.valueOf((-1652), (-1652), (-1652), (-1652), 7);
        BigInteger bigInteger0 = BigInteger.ZERO;

        Financials.yieldmat((Date) moment0, (Number) bigInteger0, (Date) moment0, (Number) bigInteger0, (Number) bigInteger0);
        fail("Expecting exception: NumberFormatException");
    }

    @Ignore
    @Test(timeout = 4000)
    public void test111() throws Throwable {
        Moment moment0 = Moment.valueOf(2643, 2643, 2643);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(143);

        Financials.oddfprice((Date) moment0, (Date) moment0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test112() throws Throwable {
        Long long0 = new Long((-1788L));

        Financials.coupdaysnc((Number) long0, (CharSequence) null, (Number) long0, (Number) long0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test113() throws Throwable {
        Moment moment0 = Moment.valueOf(0, (-436), (-757));
        byte[] byteArray0 = new byte[3];
        BigInteger bigInteger0 = new BigInteger(byteArray0);
        FormulaDecimal formulaDecimal0 = Financials.couppcd((Date) moment0, (Date) moment0, (Number) bigInteger0, (Number) (byte) 124);
        FormulaDecimal formulaDecimal1 = Financials.coupnum((Number) formulaDecimal0, (Date) moment0, (Number) (byte) (-1), (Number) (byte) (-23));
        assertNotSame(formulaDecimal0, formulaDecimal1);
    }

    @Test(timeout = 4000)
    public void test114() throws Throwable {
        Financials financials0 = new Financials();
        Assert.assertNotNull(financials0);
    }

    @Ignore
    @Test(timeout = 4000)
    public void test115() throws Throwable {
        Moment moment0 = Moment.valueOf(0, 0, 0, 0, 0);
        Random mockRandom0 = new Random(0);
        BigInteger bigInteger0 = new BigInteger(5, mockRandom0);
        Financials.oddfprice((Date) moment0, (Date) moment0, (Date) moment0, (Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test116() throws Throwable {
        StringWriter stringWriter0 = new StringWriter();
        StringBuffer stringBuffer0 = stringWriter0.getBuffer();

        Financials.yielddisc((Number) null, (CharSequence) stringBuffer0, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test117() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0L);
        Date Date0 = new Date((-1), 3, 2767, 0, 2767, (-1));
        CharBuffer charBuffer0 = CharBuffer.allocate(2767);
        Financials.disc((Date) Date0, (CharSequence) charBuffer0, (Number) formulaDecimal0, (Number) formulaDecimal0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test118() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-4820));
        Financials.pv((Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test119() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        BigDecimal bigDecimal0 = new BigDecimal(bigInteger0);
        Moment moment0 = Moment.valueOf((-2689L));

        Financials.yield((Number) bigInteger0, (Date) moment0, (Number) bigInteger0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test120() throws Throwable {
        Moment moment0 = Moment.valueOf(0, (-3427), (-3427), 0, 0);
        byte[] byteArray0 = new byte[3];
        BigInteger bigInteger0 = new BigInteger(byteArray0);

        Financials.duration((Number) (byte) 116, (Date) moment0, (Number) bigInteger0, (Number) (byte) (-56), (Number) (byte) (-56), (Number) (byte) (-56));
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test121() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal(2893L);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);

        Financials.amorlinc((Number) formulaDecimal0, (CharSequence) null, (CharSequence) null, (Number) bigDecimal0, (Number) formulaDecimal0, (Number) bigDecimal0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test122() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        BigDecimal bigDecimal0 = new BigDecimal(bigInteger0);
        Moment moment0 = Moment.valueOf(40, (-1), 16);
        FormulaDecimal formulaDecimal0 = Financials.pricedisc((Number) bigDecimal0, (Date) moment0, (Number) bigInteger0, (Number) bigInteger0);
        StringWriter stringWriter0 = new StringWriter(2617);
        StringBuffer stringBuffer0 = stringWriter0.getBuffer();

        Financials.oddfyield((CharSequence) stringBuffer0, (CharSequence) stringBuffer0, (Date) moment0, (CharSequence) stringBuffer0, (Number) bigInteger0, (Number) bigInteger0, (Number) bigDecimal0, (Number) formulaDecimal0, (Number) bigInteger0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test123() throws Throwable {
        Moment moment0 = new Moment(1L);

        Financials.oddlyield((Date) moment0, (Date) moment0, (Number) null, (Number) null, (Number) null, (Number) null, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test124() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ZERO;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);
        char[] charArray0 = new char[9];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        Financials.couppcd((Number) formulaDecimal0, (CharSequence) charBuffer0, (Number) formulaDecimal0, (Number) bigDecimal0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test125() throws Throwable {
        Charset charset0 = Charset.defaultCharset();
        byte[] byteArray0 = new byte[0];
        ByteBuffer byteBuffer0 = ByteBuffer.wrap(byteArray0, 0, 0);
        CharBuffer charBuffer0 = charset0.decode(byteBuffer0);

        Financials.tbilleq((CharSequence) charBuffer0, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000)
    public void test126() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal(1006);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);

        Financials.ipmt((Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) bigDecimal0, (Number) bigDecimal0);
    }

    @Ignore
    @Test(timeout = 4000)
    public void test127() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ZERO;
        Date Date0 = new Date(0L);
        FormulaDecimal formulaDecimal0 = Financials.pricemat((Number) bigDecimal0, (Date) Date0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0);
        Long long0 = new Long((-2271L));

        Financials.oddfprice((Number) bigDecimal0, (Number) bigDecimal0, (Number) formulaDecimal0, (Number) bigDecimal0, (Number) long0, (Number) long0, (Number) long0, (Number) long0, (Number) long0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test128() throws Throwable {
        char[] charArray0 = new char[2];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);

        Financials.duration((CharSequence) charBuffer0, (Date) null, (Number) null, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test130() throws Throwable {
        Date Date0 = new Date(3, 3, 8);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1609);

        Financials.pricemat((Date) Date0, (Date) Date0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test131() throws Throwable {
        char[] charArray0 = new char[4];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        BigDecimal bigDecimal0 = BigDecimal.TEN;

        Financials.oddlyield((CharSequence) charBuffer0, (CharSequence) charBuffer0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Ignore
    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test133() throws Throwable {
        Moment moment0 = Moment.valueOf(2, 1383, 1383, (-149), (-149), (-149));
        Byte byte0 = new Byte((byte) 104);

        Financials.oddfprice((Date) moment0, (Number) byte0, (Date) moment0, (Date) moment0, (Number) byte0, (Number) byte0, (Number) byte0, (Number) byte0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test134() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(2205);
        Moment moment0 = Moment.valueOf(2205, 2343, 0, 728, 1458, (-3344));
        Float float0 = new Float((-435.1362F));

        Financials.oddlprice((CharSequence) charBuffer0, (Date) moment0, (Date) moment0, (Number) float0, (Number) float0, (Number) float0, (Number) float0, (Number) float0);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test135() throws Throwable {
        Moment moment0 = Moment.valueOf(1548, 6, 1548);

        Financials.oddlyield((Number) null, (Date) moment0, (Date) moment0, (Number) null, (Number) null, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test136() throws Throwable {
        char[] charArray0 = new char[4];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        BigDecimal bigDecimal0 = new BigDecimal((long) 3);

        Financials.accrint((CharSequence) charBuffer0, (CharSequence) charBuffer0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test137() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;

        Financials.coupdaybs((CharSequence) null, (CharSequence) null, (Number) bigInteger0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test138() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.TEN;

        Financials.nper((Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test139() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal(365.0);
        FormulaDecimal formulaDecimal0 = Financials.received((Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test140() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal(0L);
        BigInteger bigInteger0 = BigInteger.ZERO;
        Financials.yielddisc((Number) bigDecimal0, (Number) bigInteger0, (Number) bigDecimal0, (Number) bigDecimal0);
        fail("Expecting exception: NumberFormatException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test141() throws Throwable {

        Financials.coupdays((Number) null, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test142() throws Throwable {
        Moment moment0 = new Moment((-312L));
        char[] charArray0 = new char[3];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-3909));

        Financials.tbilleq((Date) moment0, (CharSequence) charBuffer0, (Number) formulaDecimal0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test143() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);
        CharBuffer charBuffer0 = CharBuffer.allocate(1562);

        Financials.oddlyield((Number) formulaDecimal0, (Number) bigInteger0, (CharSequence) charBuffer0, (Number) formulaDecimal0, (Number) bigInteger0, (Number) formulaDecimal0, (Number) bigInteger0, (Number) formulaDecimal0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Ignore
    @Test(timeout = 4000)
    public void test144() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal((-557));
        Date Date0 = new Date((-557), 50, (-557), 0, 0, 100);
        BigInteger bigInteger0 = BigInteger.ZERO;

        Financials.oddfyield((Number) bigDecimal0, (Date) Date0, (Date) Date0, (Number) bigDecimal0, (Number) bigInteger0, (Number) bigDecimal0, (Number) bigInteger0, (Number) bigInteger0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test145() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        char[] charArray0 = new char[2];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);

        Financials.coupdaysnc((CharSequence) charBuffer0, (CharSequence) charBuffer0, (Number) bigDecimal0, (Number) bigDecimal0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test146() throws Throwable {
        char[] charArray0 = new char[6];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        BigInteger bigInteger0 = BigInteger.TEN;
        BigDecimal bigDecimal0 = new BigDecimal(bigInteger0);
        FormulaDecimal formulaDecimal0 = Financials.couppcd((Number) bigDecimal0, (Number) bigDecimal0, (Number) bigInteger0, (Number) bigDecimal0);

        Financials.couppcd((CharSequence) charBuffer0, (CharSequence) charBuffer0, (Number) formulaDecimal0, (Number) formulaDecimal0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test147() throws Throwable {
        char[] charArray0 = new char[3];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        Instant instant0 = Instant.ofEpochSecond((-822L), (-822L));
        Date date0 = Date.from(instant0);
        BigInteger bigInteger0 = BigInteger.ONE;
        BigDecimal bigDecimal0 = new BigDecimal(bigInteger0);

        Financials.oddlprice((CharSequence) charBuffer0, (CharSequence) charBuffer0, date0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigInteger0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test148() throws Throwable {
        Byte byte0 = new Byte((byte) 3);
        StringWriter stringWriter0 = new StringWriter((byte) 3);
        StringBuffer stringBuffer0 = stringWriter0.getBuffer();

        Financials.mduration((Number) byte0, (CharSequence) stringBuffer0, (Number) byte0, (Number) byte0, (Number) byte0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test151() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal(0);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);
        Charset charset0 = Charset.defaultCharset();
        byte[] byteArray0 = new byte[3];
        ByteBuffer byteBuffer0 = ByteBuffer.wrap(byteArray0);
        CharBuffer charBuffer0 = charset0.decode(byteBuffer0);
        BigInteger bigInteger0 = BigInteger.ZERO;
        Financials.oddfyield((Number) formulaDecimal0, (Number) formulaDecimal0, (CharSequence) charBuffer0, (Number) (byte) 14, (Number) formulaDecimal0, (Number) (byte) 2, (Number) formulaDecimal0, (Number) bigInteger0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test152() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal(365.0);
        CharBuffer charBuffer0 = CharBuffer.allocate(0);
        Financials.coupnum((Number) bigDecimal0, (CharSequence) charBuffer0, (Number) bigDecimal0, (Number) bigDecimal0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test153() throws Throwable {
        StringWriter stringWriter0 = new StringWriter();
        StringBuffer stringBuffer0 = stringWriter0.getBuffer();
        Moment moment0 = Moment.valueOf((-99), 147, 147, 147, 2681);
        Financials.yieldmat((CharSequence) stringBuffer0, (Number) null, (Date) moment0, (Number) null, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test154() throws Throwable {
        Short short0 = new Short((short) 9);
        char[] charArray0 = new char[7];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        Financials.yieldmat((CharSequence) charBuffer0, (CharSequence) charBuffer0, (CharSequence) charBuffer0, (Number) short0, (Number) short0, (Number) short0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test155() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal(10000);
        Moment moment0 = new Moment(10000);
        Financials.price((Number) bigDecimal0, (Date) moment0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test156() throws Throwable {
        Moment moment0 = new Moment((-1348L));
        Number number0 = moment0.weeknum(100);
        FormulaDecimal formulaDecimal0 = Financials.coupdaysnc(number0, (Date) moment0, number0);

        Financials.intrate((Number) null, (Date) moment0, (Number) null, (Number) formulaDecimal0, (Number) formulaDecimal0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000)
    public void test157() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);

        Financials.ppmt((Number) formulaDecimal0, (Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test158() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        CharBuffer charBuffer0 = CharBuffer.allocate(12);

        Financials.couppcd((Number) bigInteger0, (CharSequence) charBuffer0, (Number) bigInteger0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000)
    public void test159() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.TEN;
        Moment moment0 = new Moment();
        FormulaDecimal formulaDecimal0 = Financials.pricemat((Number) bigDecimal0, (Date) moment0, (Date) moment0, (Number) bigDecimal0, (Number) bigDecimal0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test160() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(0);

        Financials.coupdaybs((CharSequence) charBuffer0, (Number) null, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test162() throws Throwable {
        Float float0 = new Float(282.50146F);

        Financials.disc((CharSequence) null, (Number) float0, (Number) float0, (Number) float0, (Number) float0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test163() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(4043L);
        Moment moment0 = Moment.valueOf(1, 1, 4, (-822), 1, (-3011));

        Financials.yieldmat((Number) formulaDecimal0, (Date) moment0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test164() throws Throwable {
        Float float0 = new Float(0.0F);
        BigInteger bigInteger0 = BigInteger.ZERO;

        Financials.disc((Date) null, (Date) null, (Number) float0, (Number) bigInteger0);
        fail("Expecting exception: ArithmeticException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test165() throws Throwable {
        Moment moment0 = Moment.valueOf(0, 0, (-1933));
        Byte byte0 = new Byte((byte) 0);

        Financials.accrint((Number) byte0, (Date) moment0, (Date) moment0, (Number) byte0, (Number) byte0, (Number) byte0, (Number) byte0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test166() throws Throwable {
        Moment moment0 = new Moment(2235L);
        FormulaDecimal formulaDecimal0 = FormulaDecimal.valueOf((-168L));

        Financials.pricedisc((CharSequence) null, (Date) moment0, (Number) formulaDecimal0, (Number) formulaDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test167() throws Throwable {
        Short short0 = new Short((short) 2414);
        BigDecimal bigDecimal0 = BigDecimal.ONE;

        Financials.pmt((Number) short0, (Number) bigDecimal0, (Number) null, (Number) bigDecimal0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test168() throws Throwable {
        StringWriter stringWriter0 = new StringWriter(3);
        StringBuffer stringBuffer0 = stringWriter0.getBuffer();
        Double double0 = new Double(3);

        Financials.intrate((CharSequence) stringBuffer0, (Date) null, (Number) double0, (Number) double0);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test169() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.TEN;

        Financials.intrate((Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0);
        fail("Expecting exception: ArithmeticException");
    }

    @Test(timeout = 4000)
    public void test170() throws Throwable {
        Moment moment0 = Moment.valueOf((-1549), (-3494), (-3494));
        Byte byte0 = new Byte((byte) 0);
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);

        Assert.assertNotNull(Financials.yielddisc((Date) moment0, (Number) byte0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) bigDecimal0));

    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test171() throws Throwable {
        char[] charArray0 = new char[7];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0, 0, 0);

        Financials.intrate((CharSequence) charBuffer0, (Number) null, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test172() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(1158);
        Date Date0 = new Date();
        Byte byte0 = new Byte((byte) (-75));

        Financials.oddfyield((CharSequence) charBuffer0, (Date) Date0, (Date) Date0, (CharSequence) charBuffer0, (Number) byte0, (Number) byte0, (Number) byte0, (Number) byte0, (Number) byte0);
        fail("Expecting exception: IllegalArgumentException");

    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test173() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-2278L));

        Financials.mduration((Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test174() throws Throwable {
        Moment moment0 = Moment.valueOf(0, (-288), 0, (-578), (-1148));
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((long) (-578));

        Financials.oddlyield((Date) moment0, (CharSequence) null, (Date) moment0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test175() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.TEN;
        Logical logical0 = Logical.FALSE;

        Financials.accrint((Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) bigDecimal0, logical0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test176() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1.0);
        FormulaDecimal formulaDecimal1 = Financials.oddlprice((Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test177() throws Throwable {
        Financials.oddlprice((Number) null, (Number) null, (Number) null, (Number) null, (Number) null, (Number) null, (Number) null, (Number) null);
        fail("Expecting exception: IllegalArgumentException");
    }

    @Test(timeout = 4000)
    public void test178() throws Throwable {
        Moment moment0 = new Moment();
        assertNotNull(moment0);

        Moment moment1 = new Moment();
        assertTrue(moment1.equals((Object) moment0));
        assertNotNull(moment1);

        byte[] byteArray0 = new byte[10];
        byteArray0[0] = (byte) 1;
        byteArray0[2] = (byte) 89;
        byteArray0[3] = (byte) 89;
        BigInteger bigInteger0 = new BigInteger(byteArray0);
        assertEquals(10, byteArray0.length);
        assertNotNull(bigInteger0);
        assertEquals((byte) 0, bigInteger0.byteValue());
        assertEquals((short) 0, bigInteger0.shortValue());
        assertArrayEquals(new byte[]{(byte) 1, (byte) 0, (byte) 89, (byte) 89, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, byteArray0);

        BigDecimal bigDecimal0 = new BigDecimal(bigInteger0);
        assertEquals(10, byteArray0.length);
        assertNotNull(bigDecimal0);
        assertEquals((byte) 0, bigInteger0.byteValue());
        assertEquals((short) 0, bigInteger0.shortValue());
        assertEquals((short) 0, bigDecimal0.shortValue());
        assertEquals((byte) 0, bigDecimal0.byteValue());
        assertArrayEquals(new byte[]{(byte) 1, (byte) 0, (byte) 89, (byte) 89, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, byteArray0);

        FormulaDecimal formulaDecimal0 = Financials.accrint((Number) bigDecimal0, (Number) (byte) 1, (Number) bigInteger0, (Number) (byte) 0, (Number) (byte) 89, (Number) bigInteger0, (Number) bigDecimal0);
        assertEquals(10, byteArray0.length);
        assertNotNull(formulaDecimal0);
        assertEquals((byte) 0, bigInteger0.byteValue());
        assertEquals((short) 0, bigInteger0.shortValue());
        assertEquals((short) 0, bigDecimal0.shortValue());
        assertEquals((byte) 0, bigDecimal0.byteValue());
        assertArrayEquals(new byte[]{(byte) 1, (byte) 0, (byte) 89, (byte) 89, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, byteArray0);
    }

    @Test
    public void test179() {
        Moment moment0 = Moment.valueOf((-1537L));
        assertNotNull(moment0);
//        // assertEquals("Wed Dec 31 23:59:58 GMT 1969", moment0.toString());

        FormulaDecimal formulaDecimal0 = FormulaDecimal.ONE;
        assertNotNull(formulaDecimal0);

        FormulaDecimal formulaDecimal1 = Financials.syd(formulaDecimal0, formulaDecimal0, formulaDecimal0, formulaDecimal0);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);

        CharSequence charSequence0 = null;
        Number number0 = null;
        BigInteger bigInteger0 = BigInteger.ZERO;
        assertNotNull(bigInteger0);
        assertEquals((byte) 0, bigInteger0.byteValue());
        assertEquals((short) 0, bigInteger0.shortValue());
    }

    @Test
    public void test180() {
        int int0 = 40;
        CharBuffer charBuffer0 = CharBuffer.allocate(40);
        assertNotNull(charBuffer0);
        assertEquals(40, charBuffer0.capacity());
        assertEquals(40, charBuffer0.remaining());
        assertTrue(charBuffer0.hasArray());
        assertEquals(0, charBuffer0.position());
        assertFalse(charBuffer0.isDirect());
        assertEquals(0, charBuffer0.arrayOffset());
        assertEquals("\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000", charBuffer0.toString());
        assertFalse(charBuffer0.isReadOnly());
        assertEquals(40, charBuffer0.length());
        assertEquals(40, charBuffer0.limit());
        assertTrue(charBuffer0.hasRemaining());

        Moment moment0 = Moment.valueOf(40, 2455, 2455);
        assertNotNull(moment0);
//        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        Moment moment1 = Financials.lcl_GetCouppcd(moment0, moment0, 40);
        assertNotNull(moment1);
        assertSame(moment0, moment1);
        assertSame(moment1, moment0);
//        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
//        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());

        Object object0 = moment1.clone();
        assertTrue(object0.equals((Object) moment0));
        assertTrue(object0.equals((Object) moment1));
        assertNotNull(object0);
        assertNotSame(moment0, object0);
        assertSame(moment0, moment1);
        assertSame(moment1, moment0);
        assertNotSame(moment1, object0);
        assertNotSame(object0, moment1);
        assertNotSame(object0, moment0);
//        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
//        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());
//        // assertEquals("Thu Jan01 00:00:00 GMT 1970", object0.toString());

        Byte byte0 = new Byte((byte) 16);
        assertEquals((byte) 16, (byte) byte0);
        assertNotNull(byte0);

        FormulaDecimal formulaDecimal0 = Financials.amorlinc((Number) byte0, (Date) moment0, (Date) moment1, (Number) byte0, (Number) byte0, (Number) byte0);
        assertTrue(moment0.equals((Object) object0));
        assertTrue(moment1.equals((Object) object0));
        assertNotNull(formulaDecimal0);
        assertNotSame(moment0, object0);
        assertSame(moment0, moment1);
        assertSame(moment1, moment0);
        assertNotSame(moment1, object0);
//        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
//        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());

        byte byte1 = (byte) 43;
        int int1 = Byte.compare((byte) 43, (byte) 43);
        assertEquals(0, int1);
        assertFalse(int1 == int0);

        int int2 = formulaDecimal0.precision();
        assertEquals(1, int2);
        assertTrue(moment0.equals((Object) object0));
        assertTrue(moment1.equals((Object) object0));
        assertFalse(byte0.equals((Object) byte1));
        assertFalse(int2 == int1);
        assertFalse(int2 == int0);
        assertNotSame(moment0, object0);
        assertSame(moment0, moment1);
        assertSame(moment1, moment0);
        assertNotSame(moment1, object0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());
    }

    @Test
    public void test181() {
        CharSequence charSequence0 = null;
        double[] doubleArray0 = new double[9];
        doubleArray0[0] = 558.646072979393;
        doubleArray0[1] = 4657.4707472820555;
        doubleArray0[3] = 5.402485143165856E-4;
        doubleArray0[4] = (-573.098390528043);
        doubleArray0[5] = 4657.4707472820555;
        doubleArray0[6] = (-65.595116165233);
        doubleArray0[7] = (-97.658746);
        doubleArray0[8] = (-573.098390528043);
        FormulaDecimal formulaDecimal0 = Financials.irr_result(doubleArray0, doubleArray0, 4657.4707472820555);
        assertEquals(9, doubleArray0.length);
        assertNotNull(formulaDecimal0);
        assertArrayEquals(new double[]{558.646072979393, 4657.4707472820555, 0.0, 5.402485143165856E-4, (-573.098390528043), 4657.4707472820555, (-65.595116165233), (-97.658746), (-573.098390528043)}, doubleArray0, 0.01);

    }

    @Ignore
    @Test
    public void test182() {
        StringWriter stringWriter0 = new StringWriter(50);
        assertNotNull(stringWriter0);
        assertEquals("", stringWriter0.toString());

        StringWriter stringWriter1 = stringWriter0.append('g');
        assertNotNull(stringWriter1);
        assertSame(stringWriter0, stringWriter1);
        assertSame(stringWriter1, stringWriter0);
        assertEquals("g", stringWriter0.toString());
        assertEquals("g", stringWriter1.toString());

        StringBuffer stringBuffer0 = stringWriter1.getBuffer();
        assertNotNull(stringBuffer0);
        assertSame(stringWriter0, stringWriter1);
        assertSame(stringWriter1, stringWriter0);
        assertEquals("g", stringWriter0.toString());
        assertEquals("g", stringWriter1.toString());
        assertEquals(1, stringBuffer0.length());
        assertEquals("g", stringBuffer0.toString());

        CharBuffer charBuffer0 = CharBuffer.wrap((CharSequence) stringBuffer0);
        assertNotNull(charBuffer0);
        assertSame(stringWriter0, stringWriter1);
        assertSame(stringWriter1, stringWriter0);
        assertEquals("g", stringWriter0.toString());
        assertEquals("g", stringWriter1.toString());
        assertEquals(1, stringBuffer0.length());
        assertEquals("g", stringBuffer0.toString());
        assertEquals("g", charBuffer0.toString());
        assertEquals(1, charBuffer0.limit());
        assertEquals(1, charBuffer0.remaining());
        assertTrue(charBuffer0.isReadOnly());
        assertEquals(1, charBuffer0.length());
        assertTrue(charBuffer0.hasRemaining());
        assertEquals(1, charBuffer0.capacity());
        assertEquals(0, charBuffer0.position());
        assertFalse(charBuffer0.hasArray());
        assertFalse(charBuffer0.isDirect());

        int int0 = (-765);
        Moment moment0 = Moment.valueOf((-765), 50, (-2483), (-765), 12);
        assertNotNull(moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        Moment moment1 = Financials.lcl_GetCouppcd(moment0, moment0, 48);
        assertNotNull(moment1);
        assertSame(moment0, moment1);
        assertSame(moment1, moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());
    }

    @Test
    public void test183() {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.ONE;
        assertNotNull(formulaDecimal0);

        FormulaDecimal formulaDecimal1 = FormulaDecimal.valueOf(2693.482);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);

        Logical logical0 = formulaDecimal1.neq(formulaDecimal0);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(logical0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertTrue(logical0.booleanValue());
        assertEquals("true", logical0.toString());

        String string0 = "IeTgs:_2";
        Boolean boolean0 = new Boolean("IeTgs:_2");
        assertFalse(boolean0);
        assertNotNull(boolean0);

        int int0 = 19;
        Moment moment0 = Moment.valueOf(33248516, 2693, (-390), 10, 33248516, 19);
        assertNotNull(moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        Moment moment1 = moment0.add(formulaDecimal0);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal1));
        assertFalse(moment1.equals((Object) moment0));
        assertNotNull(moment1);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(moment0, moment1);
        assertNotSame(moment1, moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // // assertEquals("Fri 02 00:00:00 GMT 1970", moment1.toString());

        FormulaDecimal formulaDecimal2 = Financials.coupnum((Number) formulaDecimal0, (Date) moment1, (Number) formulaDecimal0);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal1));
        assertFalse(moment0.equals((Object) moment1));
        assertFalse(moment1.equals((Object) moment0));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal1));
        assertNotNull(formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(moment0, moment1);
        assertNotSame(moment1, moment0);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // // assertEquals("Fri 02 00:00:00 GMT 1970", moment1.toString());
    }

    @Test
    public void test184() {
        Moment moment0 = Moment.valueOf((-1537L));
        assertNotNull(moment0);
        // assertEquals("Wed Dec 31 23:59:58 GMT 1969", moment0.toString());

        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0L);
        assertNotNull(formulaDecimal0);

        Moment moment1 = moment0.add(formulaDecimal0);
        assertTrue(moment1.equals((Object) moment0));
        assertNotNull(moment1);
        assertNotSame(moment0, moment1);
        assertNotSame(moment1, moment0);
        // assertEquals("Wed Dec 31 23:59:58 GMT 1969", moment0.toString());
        // assertEquals("Wed Dec 31 23:59:58 GMT 1969", moment1.toString());

        Instant instant0 = moment1.toInstant();
        assertTrue(moment0.equals((Object) moment1));
        assertTrue(moment1.equals((Object) moment0));
        assertNotNull(instant0);
        assertNotSame(moment0, moment1);
        assertNotSame(moment1, moment0);
        // assertEquals("Wed Dec 31 23:59:58 GMT 1969", moment0.toString());
        // assertEquals("Wed Dec 31 23:59:58 GMT 1969", moment1.toString());

        Date date0 = Date.from(instant0);
        assertTrue(moment0.equals((Object) moment1));
        assertTrue(moment1.equals((Object) moment0));
        assertNotNull(date0);
        assertNotSame(moment0, moment1);
        assertNotSame(moment1, moment0);
        // assertEquals("Wed Dec 31 23:59:58 GMT 1969", moment0.toString());
        // assertEquals("Wed Dec 31 23:59:58 GMT 1969", moment1.toString());
        // assertEquals("Wed Dec 31 23:59:58 GMT 1969", date0.toString());

        FormulaDecimal formulaDecimal1 = FormulaDecimal.ONE;
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);

        FormulaDecimal formulaDecimal2 = Financials.syd(formulaDecimal1, formulaDecimal1, formulaDecimal1, formulaDecimal1);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal1));
        assertNotNull(formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        assertNotSame(formulaDecimal2, formulaDecimal1);
    }

    @Test
    public void test185() {
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        assertNotNull(bigDecimal0);
        assertEquals((short) 1, bigDecimal0.shortValue());
        assertEquals((byte) 1, bigDecimal0.byteValue());

        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);
        assertNotNull(formulaDecimal0);
        assertEquals((short) 1, bigDecimal0.shortValue());
        assertEquals((byte) 1, bigDecimal0.byteValue());

        FormulaDecimal formulaDecimal1 = formulaDecimal0.ulp();
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertEquals((short) 1, bigDecimal0.shortValue());
        assertEquals((byte) 1, bigDecimal0.byteValue());

        FormulaDecimal formulaDecimal2 = formulaDecimal1.ulp();
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        assertEquals((short) 1, bigDecimal0.shortValue());
        assertEquals((byte) 1, bigDecimal0.byteValue());

        CharSequence charSequence0 = null;
        int int0 = formulaDecimal0.intValue();
        assertEquals(1, int0);
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal2));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal1));
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertEquals((short) 1, bigDecimal0.shortValue());
        assertEquals((byte) 1, bigDecimal0.byteValue());

        FormulaDecimal formulaDecimal3 = Financials.amorlinc((Number) bigDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal1, (Number) bigDecimal0, (Number) formulaDecimal0, (Number) bigDecimal0);
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal2));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal2));
        assertNotNull(formulaDecimal3);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal3);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal3);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal3, formulaDecimal1);
        assertNotSame(formulaDecimal3, formulaDecimal0);
        assertNotSame(formulaDecimal3, formulaDecimal2);
        assertEquals((short) 1, bigDecimal0.shortValue());
        assertEquals((byte) 1, bigDecimal0.byteValue());

        Moment moment0 = new Moment();
        assertNotNull(moment0);

        FormulaDecimal formulaDecimal4 = Financials.yieldmat((Number) formulaDecimal3, (Date) moment0, (Date) moment0, (Number) formulaDecimal2, (Number) formulaDecimal1, (Number) formulaDecimal1);
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal2));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal3));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal3));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal3));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal3));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal1));
        assertNotNull(formulaDecimal4);
        assertNotSame(formulaDecimal0, formulaDecimal4);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal3);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal4);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal3);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        assertNotSame(formulaDecimal2, formulaDecimal3);
        assertNotSame(formulaDecimal2, formulaDecimal4);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        assertNotSame(formulaDecimal3, formulaDecimal1);
        assertNotSame(formulaDecimal3, formulaDecimal4);
        assertNotSame(formulaDecimal3, formulaDecimal0);
        assertNotSame(formulaDecimal3, formulaDecimal2);
        assertNotSame(formulaDecimal4, formulaDecimal0);
        assertNotSame(formulaDecimal4, formulaDecimal3);
        assertNotSame(formulaDecimal4, formulaDecimal2);
        assertNotSame(formulaDecimal4, formulaDecimal1);
        assertEquals((short) 1, bigDecimal0.shortValue());
        assertEquals((byte) 1, bigDecimal0.byteValue());
        // assertEquals("Fri Feb 14 20:21:21 GMT 2014", moment0.toString());

        Moment moment1 = new Moment(moment0);
        assertTrue(moment1.equals((Object) moment0));
        assertNotNull(moment1);

        Logical logical0 = formulaDecimal1.gte(formulaDecimal4);
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal2));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal4));
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal3));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal4));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal3));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal3));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal4));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal4));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal2));
        assertTrue(moment0.equals((Object) moment1));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal3));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal1));
        assertNotNull(logical0);
        assertNotSame(formulaDecimal0, formulaDecimal4);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal3);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal4);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal3);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        assertNotSame(formulaDecimal2, formulaDecimal3);
        assertNotSame(formulaDecimal2, formulaDecimal4);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        assertNotSame(formulaDecimal3, formulaDecimal1);
        assertNotSame(formulaDecimal3, formulaDecimal4);
        assertNotSame(formulaDecimal3, formulaDecimal0);
        assertNotSame(formulaDecimal3, formulaDecimal2);
        assertNotSame(moment0, moment1);
        assertNotSame(formulaDecimal4, formulaDecimal0);
        assertNotSame(formulaDecimal4, formulaDecimal3);
        assertNotSame(formulaDecimal4, formulaDecimal2);
        assertNotSame(formulaDecimal4, formulaDecimal1);
        assertEquals((short) 1, bigDecimal0.shortValue());
        assertEquals((byte) 1, bigDecimal0.byteValue());
        // assertEquals("Fri Feb 14 20:21:21 GMT 2014", moment0.toString());
        assertTrue(logical0.booleanValue());
        assertEquals("true", logical0.toString());
    }

    @Test
    public void test186() {
        Moment moment0 = Moment.valueOf((-2140L));
        assertNotNull(moment0);
        // assertEquals("Wed Dec 31 23:59:57 GMT 1969", moment0.toString());

        Moment moment1 = Financials.lcl_GetCouppcd(moment0, moment0, 518);
        assertNotNull(moment1);
        assertSame(moment0, moment1);
        assertSame(moment1, moment0);
        // assertEquals("Wed Dec 31 23:59:57 GMT 1969", moment0.toString());
        // assertEquals("Wed Dec 31 23:59:57 GMT 1969", moment1.toString());

        Moment moment2 = Moment.EMPTY;
        assertFalse(moment2.equals((Object) moment1));
        assertFalse(moment2.equals((Object) moment0));
        assertNotNull(moment2);
        assertNotSame(moment2, moment1);
        assertNotSame(moment2, moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment2.toString());

        BigDecimal bigDecimal0 = new BigDecimal(0L);
        assertNotNull(bigDecimal0);
        assertEquals((short) 0, bigDecimal0.shortValue());
        assertEquals((byte) 0, bigDecimal0.byteValue());

        Number number0 = moment2.dayOfMonth();
        assertEquals(1, number0);
        assertFalse(moment2.equals((Object) moment1));
        assertFalse(moment2.equals((Object) moment0));
        assertNotNull(number0);
        assertNotSame(moment2, moment1);
        assertNotSame(moment2, moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment2.toString());

        FormulaDecimal formulaDecimal0 = new FormulaDecimal(512);
        assertNotNull(formulaDecimal0);

        Number number1 = moment0.weeknum();
        assertEquals(1, number1);
        assertFalse(moment0.equals((Object) moment2));
        assertNotNull(number1);
        assertNotSame(moment0, moment2);
        assertSame(moment0, moment1);
        // assertEquals("Wed Dec 31 23:59:57 GMT 1969", moment0.toString());
    }

    @Test
    public void test187() {
        BigInteger bigInteger0 = BigInteger.ZERO;
        assertNotNull(bigInteger0);
        assertEquals((short) 0, bigInteger0.shortValue());
        assertEquals((byte) 0, bigInteger0.byteValue());

        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);
        assertNotNull(formulaDecimal0);
        assertEquals((short) 0, bigInteger0.shortValue());
        assertEquals((byte) 0, bigInteger0.byteValue());

        Object[] objectArray0 = new Object[2];
        Object object0 = new Object();
        assertNotNull(object0);

        objectArray0[0] = (Object) bigInteger0;
        objectArray0[1] = (Object) formulaDecimal0;
        FormulaDecimal formulaDecimal1 = Financials.xnpv((Number) formulaDecimal0, objectArray0);
        assertEquals(2, objectArray0.length);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertEquals((short) 0, bigInteger0.shortValue());
        assertEquals((byte) 0, bigInteger0.byteValue());

        Boolean boolean0 = Boolean.FALSE;
        assertFalse(boolean0);
        assertNotNull(boolean0);

        StringWriter stringWriter0 = new StringWriter();
        assertNotNull(stringWriter0);
        assertEquals("", stringWriter0.toString());

        StringWriter stringWriter1 = stringWriter0.append('k');
        assertNotNull(stringWriter1);
        assertSame(stringWriter0, stringWriter1);
        assertSame(stringWriter1, stringWriter0);
        assertEquals("k", stringWriter0.toString());
        assertEquals("k", stringWriter1.toString());

        StringBuffer stringBuffer0 = stringWriter1.getBuffer();
        assertNotNull(stringBuffer0);
        assertSame(stringWriter0, stringWriter1);
        assertSame(stringWriter1, stringWriter0);
        assertEquals("k", stringWriter0.toString());
        assertEquals("k", stringWriter1.toString());
        assertEquals(1, stringBuffer0.length());
        assertEquals("k", stringBuffer0.toString());

        Moment moment0 = new Moment();
        assertNotNull(moment0);

        String string0 = null;
        Logical logical0 = Logical.valueOf((String) null);
        assertNotNull(logical0);
        assertEquals("false", logical0.toString());
        assertFalse(logical0.booleanValue());

        Logical logical1 = Logical.valueOf(logical0);
        assertNotNull(logical1);
        assertSame(logical0, logical1);
        assertSame(logical1, logical0);
        assertEquals("false", logical0.toString());
        assertFalse(logical0.booleanValue());
        assertEquals("false", logical1.toString());
        assertFalse(logical1.booleanValue());
    }

    @Test
    public void test188() {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.ONE;
        assertNotNull(formulaDecimal0);

        FormulaDecimal formulaDecimal1 = FormulaDecimal.valueOf(2693.482);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);

        Boolean boolean0 = new Boolean("IeTgs:_2");
        assertFalse(boolean0);
        assertNotNull(boolean0);

        Moment moment0 = Moment.valueOf(33248516, 2693, (-390), 10, 33248516, 19);
        assertNotNull(moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        Moment moment1 = moment0.add(formulaDecimal0);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal1));
        assertFalse(moment1.equals((Object) moment0));
        assertNotNull(moment1);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(moment0, moment1);
        assertNotSame(moment1, moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // // assertEquals("Fri 02 00:00:00 GMT 1970", moment1.toString());

        Moment moment2 = moment1.subtract(formulaDecimal1);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertFalse(moment0.equals((Object) moment1));
        assertFalse(moment1.equals((Object) moment0));
        assertFalse(moment2.equals((Object) moment1));
        assertFalse(moment2.equals((Object) moment0));
        assertNotNull(moment2);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(moment0, moment1);
        assertNotSame(moment0, moment2);
        assertNotSame(moment1, moment2);
        assertNotSame(moment1, moment0);
        assertNotSame(moment2, moment1);
        assertNotSame(moment2, moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // // assertEquals("Fri 02 00:00:00 GMT 1970", moment1.toString());
        // assertEquals("Sat Aug 18 12:25:55 GMT 1962", moment2.toString());

        FormulaDecimal formulaDecimal2 = Financials.coupnum((Number) formulaDecimal0, (Date) moment1, (Number) formulaDecimal0);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal1));
        assertFalse(moment0.equals((Object) moment1));
        assertFalse(moment0.equals((Object) moment2));
        assertFalse(moment1.equals((Object) moment2));
        assertFalse(moment1.equals((Object) moment0));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal1));
        assertNotNull(formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(moment0, moment1);
        assertNotSame(moment0, moment2);
        assertNotSame(moment1, moment2);
        assertNotSame(moment1, moment0);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // // assertEquals("Fri 02 00:00:00 GMT 1970", moment1.toString());
    }

    @Test
    public void test189() {
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        assertNotNull(bigDecimal0);
        assertEquals((byte) 1, bigDecimal0.byteValue());
        assertEquals((short) 1, bigDecimal0.shortValue());

        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);
        assertNotNull(formulaDecimal0);
        assertEquals((byte) 1, bigDecimal0.byteValue());
        assertEquals((short) 1, bigDecimal0.shortValue());

        FormulaDecimal formulaDecimal1 = formulaDecimal0.ulp();
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertEquals((byte) 1, bigDecimal0.byteValue());
        assertEquals((short) 1, bigDecimal0.shortValue());

        FormulaDecimal formulaDecimal2 = FormulaDecimal.ONE;
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal2);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        assertNotSame(formulaDecimal2, formulaDecimal1);

        CharSequence charSequence0 = null;
        int int0 = formulaDecimal0.intValue();
        assertEquals(1, int0);
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal2));
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertEquals((byte) 1, bigDecimal0.byteValue());
        assertEquals((short) 1, bigDecimal0.shortValue());

        FormulaDecimal formulaDecimal3 = Financials.amorlinc((Number) bigDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal1, (Number) bigDecimal0, (Number) formulaDecimal0, (Number) bigDecimal0);
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal2));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal2));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal2));
        assertNotNull(formulaDecimal3);
        assertNotSame(formulaDecimal0, formulaDecimal3);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal3);
        assertNotSame(formulaDecimal3, formulaDecimal0);
        assertNotSame(formulaDecimal3, formulaDecimal1);
        assertNotSame(formulaDecimal3, formulaDecimal2);
        assertEquals((byte) 1, bigDecimal0.byteValue());
        assertEquals((short) 1, bigDecimal0.shortValue());
    }

    @Test
    public void test190() {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.ONE;
        assertNotNull(formulaDecimal0);

        FormulaDecimal formulaDecimal1 = FormulaDecimal.valueOf(2693.482);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);

        char[] charArray0 = new char[5];
        charArray0[0] = ')';
        charArray0[1] = 'U';
        charArray0[2] = '5';
        charArray0[3] = 'O';
        charArray0[4] = '\"';
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        assertEquals(5, charArray0.length);
        assertNotNull(charBuffer0);
        assertEquals(0, charBuffer0.position());
        assertFalse(charBuffer0.isReadOnly());
        assertEquals(5, charBuffer0.limit());
        assertTrue(charBuffer0.hasArray());
        assertFalse(charBuffer0.isDirect());
        assertEquals(5, charBuffer0.remaining());
        assertTrue(charBuffer0.hasRemaining());
        assertEquals(0, charBuffer0.arrayOffset());
        assertEquals(5, charBuffer0.capacity());
        assertEquals(5, charBuffer0.length());
        assertEquals(")U5O\"", charBuffer0.toString());
        assertArrayEquals(new char[]{')', 'U', '5', 'O', '\"'}, charArray0);

        Boolean boolean0 = new Boolean("IeTgs:_2");
        assertFalse(boolean0);
        assertNotNull(boolean0);

        Moment moment0 = Moment.valueOf(33248516, 2693, (-390), 10, 33248516, 19);
        assertNotNull(moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        Moment moment1 = moment0.add(formulaDecimal0);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal1));
        assertFalse(moment1.equals((Object) moment0));
        assertNotNull(moment1);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(moment0, moment1);
        assertNotSame(moment1, moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // // assertEquals("Fri 02 00:00:00 GMT 1970", moment1.toString());

        FormulaDecimal formulaDecimal2 = Financials.coupnum((Number) formulaDecimal0, (Date) moment1, (Number) formulaDecimal0);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal1));
        assertFalse(moment0.equals((Object) moment1));
        assertFalse(moment1.equals((Object) moment0));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(moment0, moment1);
        assertNotSame(moment1, moment0);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // // assertEquals("Fri 02 00:00:00 GMT 1970", moment1.toString());
    }

    @Test
    public void test191() {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.ONE;
        assertNotNull(formulaDecimal0);

        Moment moment0 = Moment.valueOf((-4197), (-4197), (-4197), (-4197), (-4197));
        assertNotNull(moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        FormulaDecimal formulaDecimal1 = Financials.accrintm((Date) moment0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        FormulaDecimal formulaDecimal2 = FormulaDecimal.valueOf((double) (-4197));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal2);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        assertNotSame(formulaDecimal2, formulaDecimal0);

        FormulaDecimal formulaDecimal3 = new FormulaDecimal((-4197));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal3);

        Moment moment1 = new Moment((-4197));
        assertFalse(moment1.equals((Object) moment0));
        assertNotNull(moment1);
    }

    @Test
    public void test192() {
        Moment moment0 = new Moment();
        assertNotNull(moment0);

        FormulaDecimal formulaDecimal0 = FormulaDecimal.ONE;
        assertNotNull(formulaDecimal0);

        FormulaDecimal formulaDecimal1 = Financials.syd(formulaDecimal0, formulaDecimal0, formulaDecimal0, formulaDecimal0);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);

        Logical logical0 = formulaDecimal0.gt(formulaDecimal1);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(logical0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertTrue(logical0.booleanValue());
        assertEquals("true", logical0.toString());
    }

    @Test
    public void test193() {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.ONE;
        assertNotNull(formulaDecimal0);

        FormulaDecimal formulaDecimal1 = FormulaDecimal.valueOf(2693.482);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);

        char[] charArray0 = new char[5];
        charArray0[0] = ')';
        charArray0[1] = 'U';
        charArray0[2] = '5';
        charArray0[3] = 'O';
        charArray0[4] = '\"';
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        assertEquals(5, charArray0.length);
        assertNotNull(charBuffer0);
        assertEquals(")U5O\"", charBuffer0.toString());
        assertFalse(charBuffer0.isReadOnly());
        assertEquals(5, charBuffer0.limit());
        assertEquals(0, charBuffer0.arrayOffset());
        assertEquals(5, charBuffer0.capacity());
        assertEquals(5, charBuffer0.length());
        assertTrue(charBuffer0.hasArray());
        assertFalse(charBuffer0.isDirect());
        assertEquals(0, charBuffer0.position());
        assertEquals(5, charBuffer0.remaining());
        assertTrue(charBuffer0.hasRemaining());
        assertArrayEquals(new char[]{')', 'U', '5', 'O', '\"'}, charArray0);

        Boolean boolean0 = new Boolean("IeTgs:_2");
        assertFalse(boolean0);
        assertNotNull(boolean0);

        Moment moment0 = Moment.valueOf(33248516, 2693, (-390), 10, 33248516, 19);
        assertNotNull(moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        Moment moment1 = moment0.add(formulaDecimal0);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal1));
        assertFalse(moment1.equals((Object) moment0));
        assertNotNull(moment1);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(moment0, moment1);
        assertNotSame(moment1, moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // // assertEquals("Fri 02 00:00:00 GMT 1970", moment1.toString());

        FormulaDecimal formulaDecimal2 = Financials.coupnum((Number) formulaDecimal0, (Date) moment1, (Number) formulaDecimal0);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal1));
        assertFalse(moment0.equals((Object) moment1));
        assertFalse(moment1.equals((Object) moment0));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(moment0, moment1);
        assertNotSame(moment1, moment0);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // // assertEquals("Fri 02 00:00:00 GMT 1970", moment1.toString());

        Integer integer0 = new Integer(2301);
        assertEquals(2301, (int) integer0);
        assertNotNull(integer0);
    }

    @Test
    public void test194() {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.ONE;
        assertNotNull(formulaDecimal0);

        FormulaDecimal formulaDecimal1 = FormulaDecimal.valueOf(2693.482);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);

        char[] charArray0 = new char[5];
        charArray0[0] = ')';
        charArray0[1] = 'U';
        charArray0[2] = '5';
        charArray0[3] = 'O';
        charArray0[4] = '\"';
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        assertEquals(5, charArray0.length);
        assertNotNull(charBuffer0);
        assertEquals(")U5O\"", charBuffer0.toString());
        assertEquals(0, charBuffer0.arrayOffset());
        assertEquals(5, charBuffer0.limit());
        assertEquals(5, charBuffer0.length());
        assertEquals(5, charBuffer0.capacity());
        assertTrue(charBuffer0.hasRemaining());
        assertFalse(charBuffer0.isDirect());
        assertTrue(charBuffer0.hasArray());
        assertEquals(0, charBuffer0.position());
        assertEquals(5, charBuffer0.remaining());
        assertFalse(charBuffer0.isReadOnly());
        assertArrayEquals(new char[]{')', 'U', '5', 'O', '\"'}, charArray0);

        Boolean boolean0 = new Boolean("IeTgs:_2");
        assertFalse(boolean0);
        assertNotNull(boolean0);

        Moment moment0 = Moment.valueOf(33248516, 2693, (-390), 10, 33248516, 19);
        assertNotNull(moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        Moment moment1 = moment0.add(formulaDecimal0);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal1));
        assertFalse(moment1.equals((Object) moment0));
        assertNotNull(moment1);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(moment0, moment1);
        assertNotSame(moment1, moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // // assertEquals("Fri 02 00:00:00 GMT 1970", moment1.toString());

        FormulaDecimal formulaDecimal2 = Financials.coupnum((Number) formulaDecimal0, (Date) moment1, (Number) formulaDecimal0);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal1));
        assertFalse(moment0.equals((Object) moment1));
        assertFalse(moment1.equals((Object) moment0));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(moment0, moment1);
        assertNotSame(moment1, moment0);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // // assertEquals("Fri 02 00:00:00 GMT 1970", moment1.toString());

        Moment moment2 = Moment.valueOf((Date) moment0);
        assertFalse(moment0.equals((Object) moment1));
        assertFalse(moment2.equals((Object) moment1));
        assertNotNull(moment2);
        assertSame(moment0, moment2);
        assertNotSame(moment0, moment1);
        assertNotSame(moment2, moment1);
        assertSame(moment2, moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment2.toString());
    }

    @Test
    public void test195() {
        double[] doubleArray0 = new double[2];
        doubleArray0[0] = (-310.4028682);
        doubleArray0[1] = 1400.051261419;
        FormulaDecimal formulaDecimal0 = Financials.irr_result_deriv(doubleArray0, doubleArray0, 1361.8795);
        assertEquals(2, doubleArray0.length);
        assertNotNull(formulaDecimal0);
        assertArrayEquals(new double[]{(-310.4028682), 1400.051261419}, doubleArray0, 0.01);

        int int0 = 0;
        int int1 = Integer.MAX_VALUE;
        int int2 = 8287;
        BigInteger bigInteger0 = BigInteger.TEN;
        assertNotNull(bigInteger0);
        assertEquals((byte) 10, bigInteger0.byteValue());
        assertEquals((short) 10, bigInteger0.shortValue());

        FormulaDecimal formulaDecimal1 = new FormulaDecimal((char[]) null);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);

        MathContext mathContext0 = MathContext.DECIMAL32;
        assertNotNull(mathContext0);

        FormulaDecimal formulaDecimal2 = new FormulaDecimal(bigInteger0, mathContext0);
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal2);
        assertEquals((byte) 10, bigInteger0.byteValue());
        assertEquals((short) 10, bigInteger0.shortValue());

        BigInteger bigInteger1 = formulaDecimal2.toBigInteger();
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal0));
        assertNotNull(bigInteger1);
        assertSame(bigInteger0, bigInteger1);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        assertSame(bigInteger1, bigInteger0);
        assertEquals((byte) 10, bigInteger0.byteValue());
        assertEquals((short) 10, bigInteger0.shortValue());
        assertEquals((short) 10, bigInteger1.shortValue());
        assertEquals((byte) 10, bigInteger1.byteValue());
    }

    @Test
    public void test196() {
        Short short0 = new Short((short) 3);
        assertEquals((short) 3, (short) short0);
        assertNotNull(short0);

        Object[] objectArray0 = new Object[2];
        objectArray0[0] = (Object) short0;
        long long0 = Short.toUnsignedLong((short) 3);
        assertEquals(3L, long0);

        int int0 = Short.toUnsignedInt((short) 3);
        assertEquals(3, int0);

        Moment moment0 = Moment.valueOf((-1886), 3, (-1886), (-2147483647), 53);
        assertNotNull(moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        Moment moment1 = Moment.valueOf((long) 3);
        assertFalse(moment1.equals((Object) moment0));
        assertNotNull(moment1);
        assertNotSame(moment1, moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());

        Moment moment2 = new Moment(moment1);
        assertFalse(moment1.equals((Object) moment0));
        assertTrue(moment2.equals((Object) moment1));
        assertFalse(moment2.equals((Object) moment0));
        assertNotNull(moment2);

        FormulaDecimal formulaDecimal0 = Financials.received((Number) short0, (Date) moment2, (Number) short0, (Number) short0, (Number) short0);
        assertTrue(moment1.equals((Object) moment2));
        assertFalse(moment1.equals((Object) moment0));
        assertTrue(moment2.equals((Object) moment1));
        assertFalse(moment2.equals((Object) moment0));
        assertNotNull(formulaDecimal0);
        assertNotSame(moment1, moment0);
        assertNotSame(moment1, moment2);
        assertNotSame(moment2, moment0);
        assertNotSame(moment2, moment1);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment2.toString());
    }

    @Test
    public void test197() {
        short short0 = (short) 1025;
        Short short1 = new Short((short) 1025);
        assertEquals((short) 1025, (short) short1);
        assertTrue(short1.equals((Object) short0));
        assertNotNull(short1);

        Object[] objectArray0 = new Object[2];
        objectArray0[1] = (Object) short1;
        objectArray0[1] = (Object) short1;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((int) (short) 1025);
        assertNotNull(formulaDecimal0);

        Moment moment0 = Moment.valueOf((long) (short) 1025);
        assertNotNull(moment0);
        // assertEquals("Thu Jan01 00:00:01 GMT 1970", moment0.toString());

        Moment moment1 = Financials.lcl_GetCouppcd(moment0, moment0, (short) 1025);
        assertNotNull(moment1);
        assertSame(moment0, moment1);
        assertSame(moment1, moment0);
        // assertEquals("Thu Jan01 00:00:01 GMT 1970", moment0.toString());
        // assertEquals("Thu Jan01 00:00:01 GMT 1970", moment1.toString());
    }

    @Test
    public void test198() {
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        assertNotNull(bigDecimal0);
        assertEquals((byte) 1, bigDecimal0.byteValue());
        assertEquals((short) 1, bigDecimal0.shortValue());

        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);
        assertNotNull(formulaDecimal0);
        assertEquals((byte) 1, bigDecimal0.byteValue());
        assertEquals((short) 1, bigDecimal0.shortValue());

        FormulaDecimal formulaDecimal1 = formulaDecimal0.ulp();
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertEquals((byte) 1, bigDecimal0.byteValue());
        assertEquals((short) 1, bigDecimal0.shortValue());

        FormulaDecimal formulaDecimal2 = formulaDecimal1.ulp();
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        assertEquals((byte) 1, bigDecimal0.byteValue());
        assertEquals((short) 1, bigDecimal0.shortValue());

        CharSequence charSequence0 = null;
        int int0 = formulaDecimal0.intValue();
        assertEquals(1, int0);
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal2));
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertEquals((byte) 1, bigDecimal0.byteValue());
        assertEquals((short) 1, bigDecimal0.shortValue());

        FormulaDecimal formulaDecimal3 = Financials.amorlinc((Number) bigDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal1, (Number) bigDecimal0, (Number) formulaDecimal0, (Number) bigDecimal0);
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal2));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal3);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal3);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal3);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal3, formulaDecimal2);
        assertNotSame(formulaDecimal3, formulaDecimal1);
        assertNotSame(formulaDecimal3, formulaDecimal0);
        assertEquals((byte) 1, bigDecimal0.byteValue());
        assertEquals((short) 1, bigDecimal0.shortValue());

        Moment moment0 = new Moment();
        assertNotNull(moment0);

        Moment moment1 = new Moment(moment0);
        assertTrue(moment1.equals((Object) moment0));
        assertNotNull(moment1);

        float float0 = formulaDecimal3.floatValue();
        assertEquals(0.0F, float0, 0.01F);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal3));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal3));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal0));
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal3);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal3);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal3, formulaDecimal2);
        assertNotSame(formulaDecimal3, formulaDecimal1);
        assertNotSame(formulaDecimal3, formulaDecimal0);
        assertEquals((byte) 1, bigDecimal0.byteValue());
        assertEquals((short) 1, bigDecimal0.shortValue());

        FormulaDecimal formulaDecimal4 = new FormulaDecimal((long) 1);
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal3));
        assertTrue(formulaDecimal4.equals((Object) formulaDecimal2));
        assertTrue(formulaDecimal4.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal4.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal4);

        StringWriter stringWriter0 = new StringWriter();
        assertNotNull(stringWriter0);
        assertEquals("", stringWriter0.toString());

        StringWriter stringWriter1 = stringWriter0.append((CharSequence) null);
        assertNotNull(stringWriter1);
        assertSame(stringWriter0, stringWriter1);
        assertSame(stringWriter1, stringWriter0);
        assertEquals("null", stringWriter0.toString());
        assertEquals("null", stringWriter1.toString());

        StringBuffer stringBuffer0 = stringWriter1.getBuffer();
        assertNotNull(stringBuffer0);
        assertSame(stringWriter0, stringWriter1);
        assertSame(stringWriter1, stringWriter0);
        assertEquals("null", stringWriter0.toString());
        assertEquals("null", stringWriter1.toString());
        assertEquals(4, stringBuffer0.length());
        assertEquals("null", stringBuffer0.toString());
    }

    @Test
    public void test199() {
        FormulaDecimal formulaDecimal0 = FormulaDecimal.ONE;
        assertNotNull(formulaDecimal0);

        FormulaDecimal formulaDecimal1 = FormulaDecimal.ZERO;
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);

        char[] charArray0 = new char[5];
        charArray0[0] = ')';
        charArray0[1] = 'U';
        charArray0[2] = '5';
        charArray0[3] = 'O';
        charArray0[4] = '\"';
        CharBuffer charBuffer0 = CharBuffer.allocate('U');
        assertNotNull(charBuffer0);
        assertEquals("\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000", charBuffer0.toString());
        assertFalse(charBuffer0.isDirect());
        assertEquals(85, charBuffer0.remaining());
        assertTrue(charBuffer0.hasRemaining());
        assertTrue(charBuffer0.hasArray());
        assertEquals(0, charBuffer0.position());
        assertFalse(charBuffer0.isReadOnly());
        assertEquals(85, charBuffer0.length());
        assertEquals(85, charBuffer0.limit());
        assertEquals(0, charBuffer0.arrayOffset());
        assertEquals(85, charBuffer0.capacity());

        Boolean boolean0 = new Boolean("IeTgs:_2");
        assertFalse(boolean0);
        assertNotNull(boolean0);

        Moment moment0 = Moment.valueOf(33248516, 2693, (-390), 10, 33248516, 17);
        assertNotNull(moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        Moment moment1 = moment0.add(formulaDecimal0);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal1));
        assertFalse(moment1.equals((Object) moment0));
        assertNotNull(moment1);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(moment0, moment1);
        assertNotSame(moment1, moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // // assertEquals("Fri 02 00:00:00 GMT 1970", moment1.toString());

        FormulaDecimal formulaDecimal2 = Financials.coupnum((Number) formulaDecimal0, (Date) moment1, (Number) formulaDecimal0);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal1));
        assertFalse(moment0.equals((Object) moment1));
        assertFalse(moment1.equals((Object) moment0));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal1));
        assertNotNull(formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(moment0, moment1);
        assertNotSame(moment1, moment0);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // // assertEquals("Fri 02 00:00:00 GMT 1970", moment1.toString());

        FormulaDecimal formulaDecimal3 = new FormulaDecimal((long) 17);
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal2));
        assertNotNull(formulaDecimal3);
    }

    @Test
    public void test200() {
        double[] doubleArray0 = new double[2];
        doubleArray0[0] = (-310.4028682);
        doubleArray0[1] = 1400.051261419;
        FormulaDecimal formulaDecimal0 = Financials.irr_result_deriv(doubleArray0, doubleArray0, 1361.8795);
        assertEquals(2, doubleArray0.length);
        assertNotNull(formulaDecimal0);
        assertArrayEquals(new double[]{(-310.4028682), 1400.051261419}, doubleArray0, 0.01);

        int int0 = 8287;
        BigInteger bigInteger0 = BigInteger.TEN;
        assertNotNull(bigInteger0);
        assertEquals((byte) 10, bigInteger0.byteValue());
        assertEquals((short) 10, bigInteger0.shortValue());

        FormulaDecimal formulaDecimal1 = new FormulaDecimal((char[]) null);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);

        MathContext mathContext0 = MathContext.DECIMAL32;
        assertNotNull(mathContext0);

        FormulaDecimal formulaDecimal2 = new FormulaDecimal(bigInteger0, mathContext0);
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal2);
        assertEquals((byte) 10, bigInteger0.byteValue());
        assertEquals((short) 10, bigInteger0.shortValue());

        BigInteger bigInteger1 = formulaDecimal2.toBigInteger();
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal0));
        assertNotNull(bigInteger1);
        assertSame(bigInteger0, bigInteger1);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        assertSame(bigInteger1, bigInteger0);
        assertEquals((byte) 10, bigInteger0.byteValue());
        assertEquals((short) 10, bigInteger0.shortValue());
        assertEquals((byte) 10, bigInteger1.byteValue());
        assertEquals((short) 10, bigInteger1.shortValue());

        Moment moment0 = Moment.valueOf((Date) null);
        assertNotNull(moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        Number number0 = moment0.dayOfMonth();
        assertEquals(1, number0);
        assertFalse(number0.equals((Object) int0));
        assertNotNull(number0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        Moment moment1 = moment0.subtract(formulaDecimal1);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal2));
        assertTrue(moment1.equals((Object) moment0));
        assertNotNull(moment1);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(moment0, moment1);
        assertNotSame(moment1, moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());

        boolean boolean0 = bigInteger0.equals(moment1);
        assertFalse(boolean0);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal2));
        assertTrue(moment0.equals((Object) moment1));
        assertTrue(moment1.equals((Object) moment0));
        assertSame(bigInteger0, bigInteger1);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(moment0, moment1);
        assertNotSame(moment1, moment0);
        assertEquals((byte) 10, bigInteger0.byteValue());
        assertEquals((short) 10, bigInteger0.shortValue());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());

        Logical logical0 = formulaDecimal0.gte(formulaDecimal2);
        assertEquals(2, doubleArray0.length);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal0));
        assertNotNull(logical0);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertSame(bigInteger0, bigInteger1);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        assertEquals((byte) 10, bigInteger0.byteValue());
        assertEquals((short) 10, bigInteger0.shortValue());
        assertFalse(logical0.booleanValue());
        assertEquals("false", logical0.toString());
        assertArrayEquals(new double[]{(-310.4028682), 1400.051261419}, doubleArray0, 0.01);

        float float0 = formulaDecimal2.floatValue();
        assertEquals(10.0F, float0, 0.01F);
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal0));
        assertSame(bigInteger0, bigInteger1);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        assertEquals((byte) 10, bigInteger0.byteValue());
        assertEquals((short) 10, bigInteger0.shortValue());

        FormulaDecimal formulaDecimal3 = Financials.fv((Number) formulaDecimal1, (Number) formulaDecimal1, (Number) (-310.4028682));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal2));
        assertNotNull(formulaDecimal3);
        assertNotSame(formulaDecimal3, formulaDecimal1);
        assertNotSame(formulaDecimal3, formulaDecimal2);
        assertNotSame(formulaDecimal3, formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal3);
    }

    @Test
    public void test201() {
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        assertNotNull(bigDecimal0);
        assertEquals((byte) 1, bigDecimal0.byteValue());
        assertEquals((short) 1, bigDecimal0.shortValue());

        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);
        assertNotNull(formulaDecimal0);
        assertEquals((byte) 1, bigDecimal0.byteValue());
        assertEquals((short) 1, bigDecimal0.shortValue());

        FormulaDecimal formulaDecimal1 = formulaDecimal0.ulp();
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertEquals((byte) 1, bigDecimal0.byteValue());
        assertEquals((short) 1, bigDecimal0.shortValue());

        FormulaDecimal formulaDecimal2 = formulaDecimal1.ulp();
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        assertEquals((byte) 1, bigDecimal0.byteValue());
        assertEquals((short) 1, bigDecimal0.shortValue());

        CharSequence charSequence0 = null;
        int int0 = new Integer(102);
        assertEquals(102, int0);

        FormulaDecimal formulaDecimal3 = Financials.amorlinc((Number) bigDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal1, (Number) bigDecimal0, (Number) formulaDecimal0, (Number) bigDecimal0);
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal2));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal3);
        assertNotSame(formulaDecimal0, formulaDecimal3);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal3);
        assertNotSame(formulaDecimal3, formulaDecimal2);
        assertNotSame(formulaDecimal3, formulaDecimal1);
        assertNotSame(formulaDecimal3, formulaDecimal0);
        assertEquals((byte) 1, bigDecimal0.byteValue());
        assertEquals((short) 1, bigDecimal0.shortValue());

        Moment moment0 = new Moment();
        assertNotNull(moment0);

        FormulaDecimal formulaDecimal4 = Financials.yieldmat((Number) formulaDecimal3, (Date) moment0, (Date) moment0, (Number) formulaDecimal2, (Number) formulaDecimal1, (Number) formulaDecimal1);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal3));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal2));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal3));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal3));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal3));
        assertNotNull(formulaDecimal4);
        assertNotSame(formulaDecimal0, formulaDecimal3);
        assertNotSame(formulaDecimal0, formulaDecimal4);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal4);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal3);
        assertNotSame(formulaDecimal2, formulaDecimal3);
        assertNotSame(formulaDecimal2, formulaDecimal4);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        assertNotSame(formulaDecimal3, formulaDecimal2);
        assertNotSame(formulaDecimal3, formulaDecimal4);
        assertNotSame(formulaDecimal3, formulaDecimal1);
        assertNotSame(formulaDecimal3, formulaDecimal0);
        assertNotSame(formulaDecimal4, formulaDecimal1);
        assertNotSame(formulaDecimal4, formulaDecimal0);
        assertNotSame(formulaDecimal4, formulaDecimal2);
        assertNotSame(formulaDecimal4, formulaDecimal3);
        assertEquals((byte) 1, bigDecimal0.byteValue());
        assertEquals((short) 1, bigDecimal0.shortValue());
        // assertEquals("Fri Feb 14 20:21:21 GMT 2014", moment0.toString());

        Moment moment1 = moment0.add(formulaDecimal1);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal3));
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal4));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal2));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal4));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal3));
        assertFalse(moment1.equals((Object) moment0));
        assertNotNull(moment1);
        assertNotSame(formulaDecimal0, formulaDecimal3);
        assertNotSame(formulaDecimal0, formulaDecimal4);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal4);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal3);
        assertNotSame(moment0, moment1);
        assertNotSame(moment1, moment0);
        assertEquals((byte) 1, bigDecimal0.byteValue());
        assertEquals((short) 1, bigDecimal0.shortValue());
        // assertEquals("Fri Feb 14 20:21:21 GMT 2014", moment0.toString());
        // assertEquals("Sat Feb 15 20:21:21 GMT 2014", moment1.toString());

        FormulaDecimal formulaDecimal5 = FormulaDecimal.ZERO;
        assertFalse(formulaDecimal5.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal5.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal5.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal5.equals((Object) formulaDecimal3));
        assertFalse(formulaDecimal5.equals((Object) formulaDecimal4));
        assertNotNull(formulaDecimal5);
        assertNotSame(formulaDecimal5, formulaDecimal2);
        assertNotSame(formulaDecimal5, formulaDecimal0);
        assertNotSame(formulaDecimal5, formulaDecimal1);
        assertNotSame(formulaDecimal5, formulaDecimal3);
        assertNotSame(formulaDecimal5, formulaDecimal4);
    }

    @Ignore
    @Test
    public void test202() {
        Moment moment0 = Moment.valueOf(2, 2, 2, 32, 2);
        assertNotNull(moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        Number number0 = moment0.dayOfMonth();
        assertEquals(3, number0); // 32 = 1day + 12 hours
        assertNotNull(number0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        FormulaDecimal formulaDecimal0 = Financials.amorlinc(number0, (Date) moment0, (Date) moment0, number0, number0, number0, number0);
        assertNotNull(formulaDecimal0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        CharBuffer charBuffer0 = CharBuffer.allocate(2);
        assertNotNull(charBuffer0);
        assertEquals(2, charBuffer0.length());
        assertEquals("\u0000\u0000", charBuffer0.toString());
        assertFalse(charBuffer0.isDirect());
        assertTrue(charBuffer0.hasRemaining());
        assertTrue(charBuffer0.hasArray());
        assertEquals(2, charBuffer0.remaining());
        assertEquals(0, charBuffer0.position());
        assertFalse(charBuffer0.isReadOnly());
        assertEquals(2, charBuffer0.limit());
        assertEquals(2, charBuffer0.capacity());
        assertEquals(0, charBuffer0.arrayOffset());
    }

    @Test
    public void test203() {
        Moment moment0 = Moment.EMPTY;
        assertNotNull(moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        Moment moment1 = Financials.lcl_GetCouppcd(moment0, moment0, 2954);
        assertNotNull(moment1);
        assertSame(moment0, moment1);
        assertSame(moment1, moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());

        Moment moment2 = new Moment(moment1);
        assertTrue(moment2.equals((Object) moment0));
        assertTrue(moment2.equals((Object) moment1));
        assertNotNull(moment2);

        char[] charArray0 = new char[0];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        assertEquals(0, charArray0.length);
        assertNotNull(charBuffer0);
        assertEquals(0, charBuffer0.arrayOffset());
        assertFalse(charBuffer0.isReadOnly());
        assertTrue(charBuffer0.hasArray());
        assertEquals(0, charBuffer0.remaining());
        assertEquals("", charBuffer0.toString());
        assertEquals(0, charBuffer0.limit());
        assertFalse(charBuffer0.hasRemaining());
        assertEquals(0, charBuffer0.length());
        assertEquals(0, charBuffer0.capacity());
        assertEquals(0, charBuffer0.position());
        assertFalse(charBuffer0.isDirect());
        assertArrayEquals(new char[]{}, charArray0);

        Byte byte0 = new Byte((byte) (-3));
        assertEquals((byte) (-3), (byte) byte0);
        assertNotNull(byte0);
    }

    @Test
    public void test204() {
        int int0 = 365;
        CharBuffer charBuffer0 = CharBuffer.allocate(365);
        assertNotNull(charBuffer0);
        assertEquals(0, charBuffer0.position());
        assertEquals(365, charBuffer0.limit());
        assertTrue(charBuffer0.hasArray());
        assertEquals("\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000", charBuffer0.toString());
        assertEquals(365, charBuffer0.remaining());
        assertEquals(0, charBuffer0.arrayOffset());
        assertFalse(charBuffer0.isDirect());
        assertTrue(charBuffer0.hasRemaining());
        assertEquals(365, charBuffer0.capacity());
        assertFalse(charBuffer0.isReadOnly());
        assertEquals(365, charBuffer0.length());

        FormulaDecimal formulaDecimal0 = FormulaDecimal.ZERO;
        assertNotNull(formulaDecimal0);

        Moment moment0 = Moment.EMPTY;
        assertNotNull(moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        Moment moment1 = Moment.valueOf((Date) moment0);
        assertNotNull(moment1);
        assertSame(moment0, moment1);
        assertSame(moment1, moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());

        Moment moment2 = Financials.lcl_GetCouppcd(moment1, moment1, 365);
        assertNotNull(moment2);
        assertSame(moment0, moment1);
        assertSame(moment0, moment2);
        assertSame(moment1, moment0);
        assertSame(moment1, moment2);
        assertSame(moment2, moment0);
        assertSame(moment2, moment1);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment2.toString());
    }

    @Test
    public void test205() {
        byte[] byteArray0 = new byte[4];
        byteArray0[0] = (byte) 100;
        byteArray0[1] = (byte) 7;
        byteArray0[2] = (byte) 10;
        byteArray0[3] = (byte) (-92);
        BigInteger bigInteger0 = BigInteger.ZERO;
        assertNotNull(bigInteger0);
        assertEquals((short) 0, bigInteger0.shortValue());
        assertEquals((byte) 0, bigInteger0.byteValue());

        FormulaDecimal formulaDecimal0 = Financials.ddb((Number) bigInteger0, (Number) (byte) 7, (Number) (byte) 7, (Number) bigInteger0, (Number) (byte) 100);
        assertNotNull(formulaDecimal0);
        assertEquals((short) 0, bigInteger0.shortValue());
        assertEquals((byte) 0, bigInteger0.byteValue());

        char[] charArray0 = new char[6];
        charArray0[0] = 'q';
        charArray0[1] = '?';
        charArray0[2] = 'Z';
        charArray0[3] = 'T';
        charArray0[4] = 'x';
        charArray0[5] = 'l';
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        assertEquals(6, charArray0.length);
        assertNotNull(charBuffer0);
        assertEquals(6, charBuffer0.limit());
        assertEquals(0, charBuffer0.arrayOffset());
        assertFalse(charBuffer0.isReadOnly());
        assertEquals(6, charBuffer0.capacity());
        assertTrue(charBuffer0.hasRemaining());
        assertTrue(charBuffer0.hasArray());
        assertEquals(0, charBuffer0.position());
        assertEquals(6, charBuffer0.length());
        assertEquals(6, charBuffer0.remaining());
        assertFalse(charBuffer0.isDirect());
        assertEquals("q?ZTxl", charBuffer0.toString());
        assertArrayEquals(new char[]{'q', '?', 'Z', 'T', 'x', 'l'}, charArray0);

        Moment moment0 = Moment.valueOf(603, (int) (byte) 10, (int) (byte) 10);
        assertNotNull(moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        Moment moment1 = Moment.valueOf((Date) moment0);
        assertNotNull(moment1);
        assertSame(moment1, moment0);
        assertSame(moment0, moment1);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
    }

    @Test
    public void test206() {
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        assertNotNull(bigDecimal0);
        assertEquals((byte) 1, bigDecimal0.byteValue());
        assertEquals((short) 1, bigDecimal0.shortValue());

        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);
        assertNotNull(formulaDecimal0);
        assertEquals((byte) 1, bigDecimal0.byteValue());
        assertEquals((short) 1, bigDecimal0.shortValue());

        RoundingMode roundingMode0 = RoundingMode.UNNECESSARY;
        FormulaDecimal formulaDecimal1 = formulaDecimal0.setScale(102, roundingMode0);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertEquals((byte) 1, bigDecimal0.byteValue());
        assertEquals((short) 1, bigDecimal0.shortValue());

        FormulaDecimal formulaDecimal2 = FormulaDecimal.ZERO;
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal2);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        assertNotSame(formulaDecimal2, formulaDecimal0);

        int int0 = formulaDecimal1.intValue();
        assertEquals(1, int0);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertEquals((byte) 1, bigDecimal0.byteValue());
        assertEquals((short) 1, bigDecimal0.shortValue());

        Moment moment0 = Moment.valueOf(1025, 801, 801);
        assertNotNull(moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        Moment moment1 = Moment.valueOf((Date) moment0);
        assertNotNull(moment1);
        assertSame(moment0, moment1);
        assertSame(moment1, moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());

        Boolean boolean0 = Boolean.FALSE;
        assertFalse(boolean0);
        assertNotNull(boolean0);

        Logical logical0 = new Logical(boolean0);
        assertNotNull(logical0);
        assertFalse(logical0.booleanValue());
        assertEquals("false", logical0.toString());

        FormulaDecimal formulaDecimal3 = Financials.accrint((Date) moment1, (Number) formulaDecimal0, (Date) moment1, (Number) formulaDecimal1, (Number) bigDecimal0, (Number) formulaDecimal1, (Number) formulaDecimal0, logical0);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal2));
        assertNotNull(formulaDecimal3);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal3);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal3);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertSame(moment0, moment1);
        assertSame(moment1, moment0);
        assertNotSame(formulaDecimal3, formulaDecimal0);
        assertNotSame(formulaDecimal3, formulaDecimal1);
        assertNotSame(formulaDecimal3, formulaDecimal2);
        assertEquals((byte) 1, bigDecimal0.byteValue());
        assertEquals((short) 1, bigDecimal0.shortValue());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());
        assertFalse(logical0.booleanValue());
        assertEquals("false", logical0.toString());

        FormulaDecimal formulaDecimal4 = FormulaDecimal.ZERO;
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal3));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal1));
        assertNotNull(formulaDecimal4);
        assertNotSame(formulaDecimal4, formulaDecimal0);
        assertSame(formulaDecimal4, formulaDecimal2);
        assertNotSame(formulaDecimal4, formulaDecimal3);
        assertNotSame(formulaDecimal4, formulaDecimal1);

        Moment moment2 = moment0.subtract(formulaDecimal4);
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal3));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal1));
        assertTrue(moment2.equals((Object) moment0));
        assertTrue(moment2.equals((Object) moment1));
        assertNotNull(moment2);
        assertNotSame(moment0, moment2);
        assertSame(moment0, moment1);
        assertNotSame(formulaDecimal4, formulaDecimal0);
        assertSame(formulaDecimal4, formulaDecimal2);
        assertNotSame(formulaDecimal4, formulaDecimal3);
        assertNotSame(formulaDecimal4, formulaDecimal1);
        assertNotSame(moment2, moment0);
        assertNotSame(moment2, moment1);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment2.toString());

        Moment moment3 = Moment.valueOf((Date) moment0);
        assertTrue(moment0.equals((Object) moment2));
        assertTrue(moment3.equals((Object) moment2));
        assertNotNull(moment3);
        assertSame(moment0, moment3);
        assertNotSame(moment0, moment2);
        assertSame(moment0, moment1);
        assertSame(moment3, moment0);
        assertSame(moment3, moment1);
        assertNotSame(moment3, moment2);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment3.toString());
    }

    @Test
    public void test207() {
        double[] doubleArray0 = new double[2];
        doubleArray0[0] = (-310.4028682);
        doubleArray0[1] = 1400.051261419;
        FormulaDecimal formulaDecimal0 = Financials.irr_result_deriv(doubleArray0, doubleArray0, 1361.8795);
        assertEquals(2, doubleArray0.length);
        assertNotNull(formulaDecimal0);
        assertArrayEquals(new double[]{(-310.4028682), 1400.051261419}, doubleArray0, 0.01);

        int int0 = 8287;
        BigInteger bigInteger0 = BigInteger.TEN;
        assertNotNull(bigInteger0);
        assertEquals((byte) 10, bigInteger0.byteValue());
        assertEquals((short) 10, bigInteger0.shortValue());

        FormulaDecimal formulaDecimal1 = new FormulaDecimal((char[]) null);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);

        MathContext mathContext0 = MathContext.DECIMAL32;
        assertNotNull(mathContext0);

        FormulaDecimal formulaDecimal2 = new FormulaDecimal(bigInteger0, mathContext0);
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal1));
        assertNotNull(formulaDecimal2);
        assertEquals((byte) 10, bigInteger0.byteValue());
        assertEquals((short) 10, bigInteger0.shortValue());

        BigInteger bigInteger1 = formulaDecimal2.toBigInteger();
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal1));
        assertNotNull(bigInteger1);
        assertSame(bigInteger0, bigInteger1);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        assertSame(bigInteger1, bigInteger0);
        assertEquals((byte) 10, bigInteger0.byteValue());
        assertEquals((short) 10, bigInteger0.shortValue());
        assertEquals((short) 10, bigInteger1.shortValue());
        assertEquals((byte) 10, bigInteger1.byteValue());

        Moment moment0 = Moment.valueOf((Date) null);
        assertNotNull(moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        Number number0 = moment0.hour();
        assertEquals(0, number0);
        assertFalse(number0.equals((Object) int0));
        assertNotNull(number0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        Number number1 = moment0.dayOfMonth();
        assertEquals(1, number1);
        assertFalse(number1.equals((Object) int0));
        assertFalse(number1.equals((Object) number0));
        assertNotNull(number1);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        Moment moment1 = moment0.subtract(formulaDecimal1);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal2));
        assertTrue(moment1.equals((Object) moment0));
        assertNotNull(moment1);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(moment0, moment1);
        assertNotSame(moment1, moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());

        boolean boolean0 = bigInteger0.equals(moment1);
        assertFalse(boolean0);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal2));
        assertTrue(moment0.equals((Object) moment1));
        assertTrue(moment1.equals((Object) moment0));
        assertSame(bigInteger0, bigInteger1);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(moment0, moment1);
        assertNotSame(moment1, moment0);
        assertEquals((byte) 10, bigInteger0.byteValue());
        assertEquals((short) 10, bigInteger0.shortValue());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());

        Logical logical0 = formulaDecimal0.gte(formulaDecimal2);
        assertEquals(2, doubleArray0.length);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal1));
        assertNotNull(logical0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertSame(bigInteger0, bigInteger1);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        assertEquals((byte) 10, bigInteger0.byteValue());
        assertEquals((short) 10, bigInteger0.shortValue());
        assertEquals("false", logical0.toString());
        assertFalse(logical0.booleanValue());
        assertArrayEquals(new double[]{(-310.4028682), 1400.051261419}, doubleArray0, 0.01);

        BigInteger bigInteger2 = bigInteger0.clearBit(0);
        assertTrue(bigInteger2.equals((Object) bigInteger1));
        assertTrue(bigInteger2.equals((Object) bigInteger0));
        assertNotNull(bigInteger2);
        assertNotSame(bigInteger2, bigInteger0);
        assertNotSame(bigInteger2, bigInteger1);
        assertNotSame(bigInteger0, bigInteger2);
        assertSame(bigInteger0, bigInteger1);
        assertEquals((short) 10, bigInteger2.shortValue());
        assertEquals((byte) 10, bigInteger2.byteValue());
        assertEquals((byte) 10, bigInteger0.byteValue());
        assertEquals((short) 10, bigInteger0.shortValue());

        FormulaDecimal formulaDecimal3 = Financials.fv((Number) formulaDecimal1, (Number) formulaDecimal1, (Number) (-310.4028682));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal2));
        assertNotNull(formulaDecimal3);
        assertNotSame(formulaDecimal3, formulaDecimal1);
        assertNotSame(formulaDecimal3, formulaDecimal2);
        assertNotSame(formulaDecimal3, formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal3);
    }

    @Test
    public void test208() {
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        assertNotNull(bigDecimal0);
        assertEquals((short) 1, bigDecimal0.shortValue());
        assertEquals((byte) 1, bigDecimal0.byteValue());

        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);
        assertNotNull(formulaDecimal0);
        assertEquals((short) 1, bigDecimal0.shortValue());
        assertEquals((byte) 1, bigDecimal0.byteValue());

        FormulaDecimal formulaDecimal1 = formulaDecimal0.ulp();
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertEquals((short) 1, bigDecimal0.shortValue());
        assertEquals((byte) 1, bigDecimal0.byteValue());

        FormulaDecimal formulaDecimal2 = formulaDecimal1.ulp();
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal0));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal1));
        assertNotNull(formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        assertEquals((short) 1, bigDecimal0.shortValue());
        assertEquals((byte) 1, bigDecimal0.byteValue());

        CharSequence charSequence0 = null;
        int int0 = formulaDecimal0.intValue();
        assertEquals(1, int0);
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal2));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal1));
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertEquals((short) 1, bigDecimal0.shortValue());
        assertEquals((byte) 1, bigDecimal0.byteValue());

        FormulaDecimal formulaDecimal3 = Financials.amorlinc((Number) bigDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal1, (Number) bigDecimal0, (Number) formulaDecimal0, (Number) bigDecimal0);
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal2));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal2));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal2));
        assertNotNull(formulaDecimal3);
        assertNotSame(formulaDecimal0, formulaDecimal3);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal3);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal3, formulaDecimal0);
        assertNotSame(formulaDecimal3, formulaDecimal1);
        assertNotSame(formulaDecimal3, formulaDecimal2);
        assertEquals((short) 1, bigDecimal0.shortValue());
        assertEquals((byte) 1, bigDecimal0.byteValue());

        Moment moment0 = new Moment();
        assertNotNull(moment0);

        FormulaDecimal formulaDecimal4 = Financials.yieldmat((Number) formulaDecimal3, (Date) moment0, (Date) moment0, (Number) formulaDecimal2, (Number) formulaDecimal1, (Number) formulaDecimal1);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal3));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal2));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal3));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal3));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal3));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal4);
        assertNotSame(formulaDecimal0, formulaDecimal3);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal4);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal3);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal4);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        assertNotSame(formulaDecimal2, formulaDecimal4);
        assertNotSame(formulaDecimal2, formulaDecimal3);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        assertNotSame(formulaDecimal3, formulaDecimal0);
        assertNotSame(formulaDecimal3, formulaDecimal1);
        assertNotSame(formulaDecimal3, formulaDecimal4);
        assertNotSame(formulaDecimal3, formulaDecimal2);
        assertNotSame(formulaDecimal4, formulaDecimal2);
        assertNotSame(formulaDecimal4, formulaDecimal3);
        assertNotSame(formulaDecimal4, formulaDecimal1);
        assertNotSame(formulaDecimal4, formulaDecimal0);
        assertEquals((short) 1, bigDecimal0.shortValue());
        assertEquals((byte) 1, bigDecimal0.byteValue());
        // assertEquals("Fri Feb 14 20:21:21 GMT 2014", moment0.toString());

        Moment moment1 = Moment.valueOf(102, 102, 1, 102, 1);
        assertFalse(moment1.equals((Object) moment0));
        assertNotNull(moment1);
        assertNotSame(moment1, moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());

        BigInteger bigInteger0 = BigInteger.ONE;
        assertNotNull(bigInteger0);
        assertEquals((byte) 1, bigInteger0.byteValue());
        assertEquals((short) 1, bigInteger0.shortValue());

        Boolean boolean0 = Boolean.TRUE;
        assertTrue(boolean0);
        assertNotNull(boolean0);

        FormulaDecimal formulaDecimal5 = Financials.accrint((Date) moment1, (Number) formulaDecimal2, (Date) moment0, (Number) bigInteger0, (Number) bigDecimal0, (Number) bigDecimal0, (Number) formulaDecimal4, boolean0);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal3));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal2));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal4));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal3));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal4));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal4));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal3));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal4));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal2));
        assertFalse(moment0.equals((Object) moment1));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal3));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal0));
        assertFalse(moment1.equals((Object) moment0));
        assertFalse(formulaDecimal5.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal5.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal5.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal5.equals((Object) formulaDecimal4));
        assertFalse(formulaDecimal5.equals((Object) formulaDecimal3));
        assertNotNull(formulaDecimal5);
        assertNotSame(formulaDecimal0, formulaDecimal5);
        assertNotSame(formulaDecimal0, formulaDecimal3);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal4);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal3);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal4);
        assertNotSame(formulaDecimal1, formulaDecimal5);
        assertNotSame(formulaDecimal2, formulaDecimal5);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        assertNotSame(formulaDecimal2, formulaDecimal4);
        assertNotSame(formulaDecimal2, formulaDecimal3);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        assertNotSame(formulaDecimal3, formulaDecimal0);
        assertNotSame(formulaDecimal3, formulaDecimal5);
        assertNotSame(formulaDecimal3, formulaDecimal1);
        assertNotSame(formulaDecimal3, formulaDecimal4);
        assertNotSame(formulaDecimal3, formulaDecimal2);
        assertNotSame(moment0, moment1);
        assertNotSame(formulaDecimal4, formulaDecimal2);
        assertNotSame(formulaDecimal4, formulaDecimal3);
        assertNotSame(formulaDecimal4, formulaDecimal1);
        assertNotSame(formulaDecimal4, formulaDecimal5);
        assertNotSame(formulaDecimal4, formulaDecimal0);
        assertNotSame(moment1, moment0);
        assertNotSame(formulaDecimal5, formulaDecimal0);
        assertNotSame(formulaDecimal5, formulaDecimal2);
        assertNotSame(formulaDecimal5, formulaDecimal1);
        assertNotSame(formulaDecimal5, formulaDecimal4);
        assertNotSame(formulaDecimal5, formulaDecimal3);
        assertEquals((short) 1, bigDecimal0.shortValue());
        assertEquals((byte) 1, bigDecimal0.byteValue());
        // assertEquals("Fri Feb 14 20:21:21 GMT 2014", moment0.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());
        assertEquals((byte) 1, bigInteger0.byteValue());
        assertEquals((short) 1, bigInteger0.shortValue());

        Moment moment2 = new Moment(moment0);
        assertFalse(moment0.equals((Object) moment1));
        assertTrue(moment2.equals((Object) moment0));
        assertFalse(moment2.equals((Object) moment1));
        assertNotNull(moment2);

        FormulaDecimal formulaDecimal6 = new FormulaDecimal((long) 1);
        assertTrue(formulaDecimal6.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal6.equals((Object) formulaDecimal4));
        assertTrue(formulaDecimal6.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal6.equals((Object) formulaDecimal3));
        assertFalse(formulaDecimal6.equals((Object) formulaDecimal5));
        assertTrue(formulaDecimal6.equals((Object) formulaDecimal1));
        assertNotNull(formulaDecimal6);
    }

    @Test
    public void test209() {
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        assertNotNull(bigDecimal0);
        assertEquals((short) 1, bigDecimal0.shortValue());
        assertEquals((byte) 1, bigDecimal0.byteValue());

        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);
        assertNotNull(formulaDecimal0);
        assertEquals((short) 1, bigDecimal0.shortValue());
        assertEquals((byte) 1, bigDecimal0.byteValue());

        FormulaDecimal formulaDecimal1 = formulaDecimal0.ulp();
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertEquals((short) 1, bigDecimal0.shortValue());
        assertEquals((byte) 1, bigDecimal0.byteValue());

        FormulaDecimal formulaDecimal2 = formulaDecimal1.ulp();
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        assertEquals((short) 1, bigDecimal0.shortValue());
        assertEquals((byte) 1, bigDecimal0.byteValue());

        CharSequence charSequence0 = null;
        int int0 = formulaDecimal0.intValue();
        assertEquals(1, int0);
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal2));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal1));
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertEquals((short) 1, bigDecimal0.shortValue());
        assertEquals((byte) 1, bigDecimal0.byteValue());

        FormulaDecimal formulaDecimal3 = Financials.amorlinc((Number) bigDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal1, (Number) bigDecimal0, (Number) formulaDecimal0, (Number) bigDecimal0);
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal2));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal2));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal1));
        assertNotNull(formulaDecimal3);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal3);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal3);
        assertNotSame(formulaDecimal3, formulaDecimal0);
        assertNotSame(formulaDecimal3, formulaDecimal2);
        assertNotSame(formulaDecimal3, formulaDecimal1);
        assertEquals((short) 1, bigDecimal0.shortValue());
        assertEquals((byte) 1, bigDecimal0.byteValue());

        Moment moment0 = new Moment();
        assertNotNull(moment0);

        FormulaDecimal formulaDecimal4 = Financials.yieldmat((Number) formulaDecimal3, (Date) moment0, (Date) moment0, (Number) formulaDecimal2, (Number) formulaDecimal1, (Number) formulaDecimal1);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal3));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal2));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal3));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal3));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal3));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal1));
        assertNotNull(formulaDecimal4);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal3);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal4);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal3);
        assertNotSame(formulaDecimal1, formulaDecimal4);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        assertNotSame(formulaDecimal2, formulaDecimal3);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        assertNotSame(formulaDecimal2, formulaDecimal4);
        assertNotSame(formulaDecimal3, formulaDecimal4);
        assertNotSame(formulaDecimal3, formulaDecimal0);
        assertNotSame(formulaDecimal3, formulaDecimal2);
        assertNotSame(formulaDecimal3, formulaDecimal1);
        assertNotSame(formulaDecimal4, formulaDecimal3);
        assertNotSame(formulaDecimal4, formulaDecimal0);
        assertNotSame(formulaDecimal4, formulaDecimal2);
        assertNotSame(formulaDecimal4, formulaDecimal1);
        assertEquals((short) 1, bigDecimal0.shortValue());
        assertEquals((byte) 1, bigDecimal0.byteValue());
        // assertEquals("Fri Feb 14 20:21:21 GMT 2014", moment0.toString());

        float float0 = formulaDecimal4.floatValue();
//        assertEquals((-0.023177257F), float0, 0.01F);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal3));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal4));
        assertTrue(formulaDecimal0.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal3));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal4));
        assertTrue(formulaDecimal1.equals((Object) formulaDecimal0));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal1));
        assertTrue(formulaDecimal2.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal3));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal4));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal4));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal3));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal4.equals((Object) formulaDecimal1));
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal3);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal4);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal3);
        assertNotSame(formulaDecimal1, formulaDecimal4);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        assertNotSame(formulaDecimal2, formulaDecimal3);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        assertNotSame(formulaDecimal2, formulaDecimal4);
        assertNotSame(formulaDecimal3, formulaDecimal4);
        assertNotSame(formulaDecimal3, formulaDecimal0);
        assertNotSame(formulaDecimal3, formulaDecimal2);
        assertNotSame(formulaDecimal3, formulaDecimal1);
        assertNotSame(formulaDecimal4, formulaDecimal3);
        assertNotSame(formulaDecimal4, formulaDecimal0);
        assertNotSame(formulaDecimal4, formulaDecimal2);
        assertNotSame(formulaDecimal4, formulaDecimal1);
        assertEquals((short) 1, bigDecimal0.shortValue());
        assertEquals((byte) 1, bigDecimal0.byteValue());
        // assertEquals("Fri Feb 14 20:21:21 GMT 2014", moment0.toString());
    }

    @Test
    public void test210() {
        double double0 = 5.0;
        BigDecimal bigDecimal0 = new BigDecimal(5.0);
        assertNotNull(bigDecimal0);
        assertEquals((byte) 5, bigDecimal0.byteValue());
        assertEquals((short) 5, bigDecimal0.shortValue());

        Number[] numberArray0 = new Number[4];
        numberArray0[1] = (Number) bigDecimal0;
        numberArray0[2] = (Number) bigDecimal0;
        numberArray0[3] = (Number) bigDecimal0;
        FormulaDecimal formulaDecimal0 = Financials.amordegrc(numberArray0[1], numberArray0[2], numberArray0[2], numberArray0[3], numberArray0[3], numberArray0[1]);
        assertEquals(4, numberArray0.length);
        assertNotNull(formulaDecimal0);

        CharBuffer charBuffer0 = CharBuffer.allocate(16777216);
        assertNotNull(charBuffer0);
        assertEquals(0, charBuffer0.arrayOffset());
        assertTrue(charBuffer0.hasArray());
        assertTrue(charBuffer0.hasRemaining());
        assertEquals(16777216, charBuffer0.remaining());
        assertEquals(0, charBuffer0.position());
        assertEquals(16777216, charBuffer0.limit());
        assertFalse(charBuffer0.isReadOnly());
        assertFalse(charBuffer0.isDirect());
        assertEquals(16777216, charBuffer0.length());
        assertEquals(16777216, charBuffer0.capacity());

        CharBuffer charBuffer1 = CharBuffer.wrap((CharSequence) charBuffer0);
        assertTrue(charBuffer1.equals((Object) charBuffer0));
        assertNotNull(charBuffer1);
        assertEquals(0, charBuffer0.arrayOffset());
        assertTrue(charBuffer0.hasArray());
        assertTrue(charBuffer0.hasRemaining());
        assertEquals(16777216, charBuffer0.remaining());
        assertEquals(0, charBuffer0.position());
        assertEquals(16777216, charBuffer0.limit());
        assertFalse(charBuffer0.isReadOnly());
        assertFalse(charBuffer0.isDirect());
        assertEquals(16777216, charBuffer0.length());
        assertEquals(16777216, charBuffer0.capacity());
        assertTrue(charBuffer1.isReadOnly());
        assertEquals(0, charBuffer1.position());
        assertFalse(charBuffer1.hasArray());
        assertFalse(charBuffer1.isDirect());
        assertEquals(16777216, charBuffer1.length());
        assertEquals(16777216, charBuffer1.capacity());
        assertEquals(16777216, charBuffer1.limit());
        assertTrue(charBuffer1.hasRemaining());
        assertEquals(16777216, charBuffer1.remaining());

        MathContext mathContext0 = MathContext.DECIMAL64;
        assertNotNull(mathContext0);

        BigDecimal bigDecimal1 = bigDecimal0.plus(mathContext0);
        assertNotNull(bigDecimal1);
        assertSame(bigDecimal0, bigDecimal1);
        assertSame(bigDecimal1, bigDecimal0);
        assertEquals((byte) 5, bigDecimal0.byteValue());
        assertEquals((short) 5, bigDecimal0.shortValue());
        assertEquals((short) 5, bigDecimal1.shortValue());
        assertEquals((byte) 5, bigDecimal1.byteValue());

        BigDecimal bigDecimal2 = bigDecimal0.setScale(104);
        assertFalse(bigDecimal2.equals((Object) bigDecimal1));
        assertFalse(bigDecimal2.equals((Object) bigDecimal0));
        assertNotNull(bigDecimal2);
        assertNotSame(bigDecimal0, bigDecimal2);
        assertSame(bigDecimal0, bigDecimal1);
        assertNotSame(bigDecimal2, bigDecimal1);
        assertNotSame(bigDecimal2, bigDecimal0);
        assertEquals((byte) 5, bigDecimal0.byteValue());
        assertEquals((short) 5, bigDecimal0.shortValue());
        assertEquals((short) 5, bigDecimal2.shortValue());
        assertEquals((byte) 5, bigDecimal2.byteValue());
    }

    @Test
    public void test211() {
        double[] doubleArray0 = new double[2];
        doubleArray0[0] = (-310.4028682);
        doubleArray0[1] = 1400.051261419;
        FormulaDecimal formulaDecimal0 = Financials.irr_result_deriv(doubleArray0, doubleArray0, 1361.8795);
        assertEquals(2, doubleArray0.length);
        assertNotNull(formulaDecimal0);
        assertArrayEquals(new double[]{(-310.4028682), 1400.051261419}, doubleArray0, 0.01);

        int int0 = 8287;
        BigInteger bigInteger0 = BigInteger.TEN;
        assertNotNull(bigInteger0);
        assertEquals((short) 10, bigInteger0.shortValue());
        assertEquals((byte) 10, bigInteger0.byteValue());

        FormulaDecimal formulaDecimal1 = new FormulaDecimal((char[]) null);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);

        MathContext mathContext0 = MathContext.DECIMAL32;
        assertNotNull(mathContext0);

        FormulaDecimal formulaDecimal2 = new FormulaDecimal(bigInteger0, mathContext0);
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal1));
        assertNotNull(formulaDecimal2);
        assertEquals((short) 10, bigInteger0.shortValue());
        assertEquals((byte) 10, bigInteger0.byteValue());

        Moment moment0 = Moment.valueOf((Date) null);
        assertNotNull(moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        Number number0 = moment0.dayOfMonth();
        assertEquals(1, number0);
        assertFalse(number0.equals((Object) int0));
        assertNotNull(number0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        Moment moment1 = moment0.subtract(formulaDecimal1);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal2));
        assertTrue(moment1.equals((Object) moment0));
        assertNotNull(moment1);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(moment0, moment1);
        assertNotSame(moment1, moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());

        boolean boolean0 = bigInteger0.equals(moment1);
        assertFalse(boolean0);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal2));
        assertTrue(moment0.equals((Object) moment1));
        assertTrue(moment1.equals((Object) moment0));
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(moment0, moment1);
        assertNotSame(moment1, moment0);
        assertEquals((short) 10, bigInteger0.shortValue());
        assertEquals((byte) 10, bigInteger0.byteValue());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());

        Logical logical0 = formulaDecimal0.gte(formulaDecimal2);
        assertEquals(2, doubleArray0.length);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal1));
        assertNotNull(logical0);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        assertEquals((short) 10, bigInteger0.shortValue());
        assertEquals((byte) 10, bigInteger0.byteValue());
        assertEquals("false", logical0.toString());
        assertFalse(logical0.booleanValue());
        assertArrayEquals(new double[]{(-310.4028682), 1400.051261419}, doubleArray0, 0.01);

        FormulaDecimal formulaDecimal3 = Financials.fv((Number) formulaDecimal1, (Number) formulaDecimal1, (Number) (-310.4028682));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal2));
        assertFalse(formulaDecimal3.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal3);
        assertNotSame(formulaDecimal1, formulaDecimal3);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal3, formulaDecimal1);
        assertNotSame(formulaDecimal3, formulaDecimal2);
        assertNotSame(formulaDecimal3, formulaDecimal0);

    }

    @Test
    public void test213() {
        BigInteger bigInteger0 = BigInteger.ONE;
        assertNotNull(bigInteger0);
        assertEquals((byte) 1, bigInteger0.byteValue());
        assertEquals((short) 1, bigInteger0.shortValue());

        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);
        assertNotNull(formulaDecimal0);
        assertEquals((byte) 1, bigInteger0.byteValue());
        assertEquals((short) 1, bigInteger0.shortValue());

        Object[] objectArray0 = new Object[2];
        Object object0 = new Object();
        assertNotNull(object0);

        objectArray0[0] = (Object) bigInteger0;
        objectArray0[1] = (Object) formulaDecimal0;
        FormulaDecimal formulaDecimal1 = Financials.xnpv((Number) formulaDecimal0, objectArray0);
        assertEquals(2, objectArray0.length);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertEquals((byte) 1, bigInteger0.byteValue());
        assertEquals((short) 1, bigInteger0.shortValue());

        Boolean boolean0 = Boolean.FALSE;
        assertFalse(boolean0);
        assertNotNull(boolean0);

        FormulaDecimal formulaDecimal2 = Financials.accrint((Number) formulaDecimal1, (Number) bigInteger0, (Number) formulaDecimal1, (Number) bigInteger0, (Number) bigInteger0, (Number) formulaDecimal1, (Number) formulaDecimal0, boolean0);
        assertEquals(2, objectArray0.length);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal1));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal0));
        assertFalse(formulaDecimal2.equals((Object) formulaDecimal1));
        assertNotNull(formulaDecimal2);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal2);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertNotSame(formulaDecimal1, formulaDecimal2);
        assertNotSame(formulaDecimal2, formulaDecimal0);
        assertNotSame(formulaDecimal2, formulaDecimal1);
        assertEquals((byte) 1, bigInteger0.byteValue());
        assertEquals((short) 1, bigInteger0.shortValue());

        Date date0 = null;
        Charset charset0 = Charset.defaultCharset();
        assertNotNull(charset0);
        assertTrue(charset0.canEncode());
//        assertEquals("windows-1252", charset0.name());
//        assertEquals("windows-1252", charset0.displayName());
//        assertTrue(charset0.isRegistered());
//        assertEquals("windows-1252", charset0.toString());

        byte[] byteArray0 = new byte[9];
        byteArray0[0] = (byte) 10;
        byteArray0[1] = (byte) 107;
        byteArray0[2] = (byte) (-28);
        byteArray0[3] = (byte) 40;
        byteArray0[4] = (byte) (-99);
        byteArray0[5] = (byte) 52;
        byteArray0[6] = (byte) 37;
        byteArray0[7] = (byte) 2;
        byteArray0[8] = (byte) (-1);
        ByteBuffer byteBuffer0 = ByteBuffer.wrap(byteArray0);
        assertEquals(9, byteArray0.length);
        assertNotNull(byteBuffer0);
        assertEquals(9, byteBuffer0.remaining());
        assertEquals(9, byteBuffer0.capacity());
        assertEquals(0, byteBuffer0.arrayOffset());
        assertEquals(9, byteBuffer0.limit());
        assertTrue(byteBuffer0.hasRemaining());
        assertTrue(byteBuffer0.hasArray());
        assertEquals(0, byteBuffer0.position());
        assertFalse(byteBuffer0.isReadOnly());
        assertFalse(byteBuffer0.isDirect());
        assertEquals("java.nio.HeapByteBuffer[pos=0 lim=9 cap=9]", byteBuffer0.toString());
        assertArrayEquals(new byte[]{(byte) 10, (byte) 107, (byte) (-28), (byte) 40, (byte) (-99), (byte) 52, (byte) 37, (byte) 2, (byte) (-1)}, byteArray0);

        CharBuffer charBuffer0 = charset0.decode(byteBuffer0);
        assertEquals(9, byteArray0.length);
        assertNotNull(charBuffer0);
        assertEquals(9, byteBuffer0.capacity());
        assertEquals(0, byteBuffer0.arrayOffset());
        assertEquals(9, byteBuffer0.limit());
        assertTrue(byteBuffer0.hasArray());
        assertFalse(byteBuffer0.hasRemaining());
        assertEquals(0, byteBuffer0.remaining());
        assertFalse(byteBuffer0.isReadOnly());
        assertFalse(byteBuffer0.isDirect());
        assertEquals("java.nio.HeapByteBuffer[pos=9 lim=9 cap=9]", byteBuffer0.toString());
        assertEquals(9, byteBuffer0.position());
//        assertEquals("\nk\u00E4(\uFFFD4%\u0002\u00FF", charBuffer0.toString());
        assertTrue(charBuffer0.hasArray());
        assertEquals(9, charBuffer0.capacity());
        assertEquals(9, charBuffer0.remaining());
        assertEquals(9, charBuffer0.limit());
        assertTrue(charBuffer0.hasRemaining());
        assertEquals(0, charBuffer0.arrayOffset());
        assertEquals(9, charBuffer0.length());
        assertFalse(charBuffer0.isReadOnly());
        assertEquals(0, charBuffer0.position());
        assertFalse(charBuffer0.isDirect());
        assertTrue(charset0.canEncode());
//        assertEquals("windows-1252", charset0.name());
//        assertEquals("windows-1252", charset0.displayName());
        assertTrue(charset0.isRegistered());
//        assertEquals("windows-1252", charset0.toString());
        assertArrayEquals(new byte[]{(byte) 10, (byte) 107, (byte) (-28), (byte) 40, (byte) (-99), (byte) 52, (byte) 37, (byte) 2, (byte) (-1)}, byteArray0);

    }

    @Test
    public void test214() {
        int int0 = 15;
        Moment moment0 = Moment.valueOf(15, 15, 0, (-4232), (-4232));
        assertNotNull(moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        Long long0 = new Long(15);
        assertEquals(15L, (long) long0);
        assertNotNull(long0);

        Number[] numberArray0 = new Number[0];
        FormulaDecimal formulaDecimal0 = Financials.npv(long0, numberArray0);
        assertEquals(0, numberArray0.length);
        assertNotNull(formulaDecimal0);

        BigInteger bigInteger0 = formulaDecimal0.unscaledValue();
        assertEquals(0, numberArray0.length);
        assertNotNull(bigInteger0);
        assertEquals((byte) 0, bigInteger0.byteValue());
        assertEquals((short) 0, bigInteger0.shortValue());

        Moment moment1 = moment0.subtract(formulaDecimal0);
        assertEquals(0, numberArray0.length);
        assertTrue(moment1.equals((Object) moment0));
        assertNotNull(moment1);
        assertNotSame(moment0, moment1);
        assertNotSame(moment1, moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());

        Number number0 = moment1.year();
        assertEquals(0, numberArray0.length);
//        assertEquals(1970, number0);
        assertTrue(moment0.equals((Object) moment1));
        assertTrue(moment1.equals((Object) moment0));
//        assertFalse(number0.equals((Object)int0));
        assertNotNull(number0);
        assertNotSame(moment0, moment1);
        assertNotSame(moment1, moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());

        FormulaDecimal formulaDecimal1 = Financials.syd(number0, formulaDecimal0, number0, formulaDecimal0);
        assertEquals(0, numberArray0.length);
        assertTrue(moment0.equals((Object) moment1));
        assertTrue(moment1.equals((Object) moment0));
//        assertFalse(number0.equals((Object)int0));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);
        assertNotSame(moment0, moment1);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(moment1, moment0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());

        StringWriter stringWriter0 = new StringWriter(0);
        assertNotNull(stringWriter0);
        assertEquals("", stringWriter0.toString());

        StringBuffer stringBuffer0 = stringWriter0.getBuffer();
        assertNotNull(stringBuffer0);
        assertEquals("", stringWriter0.toString());
        assertEquals(0, stringBuffer0.length());
        assertEquals("", stringBuffer0.toString());
    }

    @Test
    public void test215() {
        BigInteger bigInteger0 = BigInteger.ZERO;
        assertNotNull(bigInteger0);
        assertEquals((byte) 0, bigInteger0.byteValue());
        assertEquals((short) 0, bigInteger0.shortValue());

        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);
        assertNotNull(formulaDecimal0);
        assertEquals((byte) 0, bigInteger0.byteValue());
        assertEquals((short) 0, bigInteger0.shortValue());

        Object[] objectArray0 = new Object[2];
        Object object0 = new Object();
        assertNotNull(object0);

        objectArray0[0] = (Object) bigInteger0;
        objectArray0[1] = (Object) formulaDecimal0;
        FormulaDecimal formulaDecimal1 = Financials.xnpv((Number) formulaDecimal0, objectArray0);
        assertEquals(2, objectArray0.length);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertEquals((byte) 0, bigInteger0.byteValue());
        assertEquals((short) 0, bigInteger0.shortValue());

        Boolean boolean0 = Boolean.FALSE;
        assertFalse(boolean0);
        assertNotNull(boolean0);
    }

    @Test
    public void test216() {
        int int0 = 15;
        Moment moment0 = Moment.valueOf(15, 15, 0, (-4232), (-4232));
        assertNotNull(moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        Long long0 = new Long(15);
        assertEquals(15L, (long) long0);
        assertNotNull(long0);

        Number[] numberArray0 = new Number[0];
        FormulaDecimal formulaDecimal0 = Financials.npv(long0, numberArray0);
        assertEquals(0, numberArray0.length);
        assertNotNull(formulaDecimal0);

        BigDecimal bigDecimal0 = new BigDecimal((long) 15);
        assertNotNull(bigDecimal0);
        assertEquals((byte) 15, bigDecimal0.byteValue());
        assertEquals((short) 15, bigDecimal0.shortValue());

        FormulaDecimal formulaDecimal1 = formulaDecimal0.max(bigDecimal0);
        assertEquals(0, numberArray0.length);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        assertEquals((byte) 15, bigDecimal0.byteValue());
        assertEquals((short) 15, bigDecimal0.shortValue());

        Moment moment1 = moment0.subtract(formulaDecimal0);
        assertEquals(0, numberArray0.length);
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal1));
        assertTrue(moment1.equals((Object) moment0));
        assertNotNull(moment1);
        assertNotSame(moment0, moment1);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(moment1, moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());

        Number number0 = moment1.year();
        assertEquals(0, numberArray0.length);
//        assertEquals(1970, number0);
        assertTrue(moment0.equals((Object) moment1));
        assertFalse(formulaDecimal0.equals((Object) formulaDecimal1));
        assertTrue(moment1.equals((Object) moment0));
//        assertFalse(number0.equals((Object)int0));
        assertNotNull(number0);
        assertNotSame(moment0, moment1);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(moment1, moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());
    }

    @Test
    public void test217() {
        Moment moment0 = Moment.valueOf((-1537L));
        assertNotNull(moment0);
        // assertEquals("Wed Dec 31 23:59:58 GMT 1969", moment0.toString());

        int int0 = 41;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(41);
        assertNotNull(formulaDecimal0);

        FormulaDecimal formulaDecimal1 = Financials.syd(formulaDecimal0, formulaDecimal0, formulaDecimal0, formulaDecimal0);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(formulaDecimal1, formulaDecimal0);

        char[] charArray0 = new char[5];
        charArray0[0] = '=';
        charArray0[1] = 'M';
        charArray0[2] = 'g';
        charArray0[3] = '1';
        charArray0[4] = 'v';
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        assertEquals(5, charArray0.length);
        assertNotNull(charBuffer0);
        assertEquals(0, charBuffer0.position());
        assertEquals(5, charBuffer0.length());
        assertFalse(charBuffer0.isDirect());
        assertEquals(5, charBuffer0.limit());
        assertEquals(5, charBuffer0.capacity());
        assertEquals(5, charBuffer0.remaining());
        assertFalse(charBuffer0.isReadOnly());
        assertEquals(0, charBuffer0.arrayOffset());
        assertEquals("=Mg1v", charBuffer0.toString());
        assertTrue(charBuffer0.hasRemaining());
        assertTrue(charBuffer0.hasArray());
        assertArrayEquals(new char[]{'=', 'M', 'g', '1', 'v'}, charArray0);
    }

    @Test
    public void test218() {
        Moment moment0 = Moment.valueOf(15, 15, 0, (-4217), (-4217));
        assertNotNull(moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());

        Long long0 = new Long(15);
        assertEquals(15L, (long) long0);
        assertNotNull(long0);

        Number[] numberArray0 = new Number[0];
        FormulaDecimal formulaDecimal0 = Financials.npv(long0, numberArray0);
        assertEquals(0, numberArray0.length);
        assertNotNull(formulaDecimal0);

        Moment moment1 = moment0.subtract(formulaDecimal0);
        assertEquals(0, numberArray0.length);
        assertTrue(moment1.equals((Object) moment0));
        assertNotNull(moment1);
        assertNotSame(moment0, moment1);
        assertNotSame(moment1, moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());

        Number number0 = moment1.year();
        assertEquals(0, numberArray0.length);
//        assertEquals(1970, number0);
        assertTrue(moment0.equals((Object) moment1));
        assertTrue(moment1.equals((Object) moment0));
        assertNotNull(number0);
        assertNotSame(moment0, moment1);
        assertNotSame(moment1, moment0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());

        FormulaDecimal formulaDecimal1 = Financials.syd(number0, formulaDecimal0, number0, formulaDecimal0);
        assertEquals(0, numberArray0.length);
        assertTrue(moment0.equals((Object) moment1));
        assertTrue(moment1.equals((Object) moment0));
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
        assertNotNull(formulaDecimal1);
        assertNotSame(moment0, moment1);
        assertNotSame(formulaDecimal0, formulaDecimal1);
        assertNotSame(moment1, moment0);
        assertNotSame(formulaDecimal1, formulaDecimal0);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment0.toString());
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment1.toString());

        int int0 = Integer.compareUnsigned(15, (-4217));
        assertEquals((-1), int0);

        Moment moment2 = Moment.valueOf(15, 15, (-4217));
//        assertTrue(moment2.equals((Object)moment0));
//        assertTrue(moment2.equals((Object)moment1));
        assertNotNull(moment2);
        assertNotSame(moment2, moment0);
        assertNotSame(moment2, moment1);
        // assertEquals("Thu Jan01 00:00:00 GMT 1970", moment2.toString());
    }

    @Test(timeout = 4000)
    public void test527() throws Throwable {
        int int0 = 7;
        long long0 = 973L;
        Random mockRandom0 = new Random(973L);
        BigInteger bigInteger0 = BigInteger.probablePrime(7, mockRandom0);
        Assert.assertEquals(0, Financials.npv(bigInteger0, (Number[]) null).intValue());
    }
}
