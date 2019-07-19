package io.onsense.universe;

import org.junit.*;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.assertFalse;

/**
 * @author Koen Rooijmans
 */
public class MomentsTest {

    @BeforeClass
    public static void before() throws Exception {
        System.setProperty("user.timezone", "UTC");
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    @Before
    public void setUp() throws Exception {
        System.setProperty("user.timezone", "UTC");
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    @Test(timeout = 4000)
    public void test000() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0);
        Moment moment0 = Moments.datetimevalue((Number) formulaDecimal0);
        Number[] numberArray0 = new Number[2];
        numberArray0[0] = (Number) formulaDecimal0;
        numberArray0[1] = (Number) formulaDecimal0;
        Moments.networkdays_intl((Number) formulaDecimal0, (Date) moment0, numberArray0);
    }

    @Test(timeout = 4000)
    public void test001() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        Moment moment0 = Moments.date((Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0);
        Number[] numberArray0 = new Number[2];
        numberArray0[0] = (Number) bigInteger0;
        numberArray0[1] = (Number) bigInteger0;
        Moments.networkdays((Date) moment0, (Number) bigInteger0, numberArray0);
    }

    @Test(timeout = 4000)
    public void test002() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal(0L);
        Moment moment0 = Moment.valueOf(1085, 2527, (-3234));
        Number[] numberArray0 = new Number[1];
        numberArray0[0] = (Number) bigDecimal0;
        Moments.networkdays((Number) bigDecimal0, (Date) moment0, numberArray0);
    }

    @Test(timeout = 4000)
    public void test003() throws Throwable {
        Long long0 = new Long(1929L);
        Date Date0 = new Date((-1L));
        Moments.networkdays((Number) long0, (Date) Date0);
    }

    @Test(timeout = 4000)
    public void test004() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal(0.0);
        Moments.days((Number) bigDecimal0, (Number) bigDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test005() throws Throwable {
        Moments.year((Number) null);
    }

    @Test(timeout = 4000)
    public void test006() throws Throwable {
        Date Date0 = new Date(0L);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1.0);
        Moments.workday_intl((Date) Date0, (Number) formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test007() throws Throwable {
        Moment moment0 = Moment.valueOf(1369, 1369, 13, 13, 1369);
        Moments.workday_intl((Date) moment0, (Number) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test008() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(6);
        Moment moment0 = Moment.valueOf(6, 6, 6);
        Moments.workday_intl((Date) moment0, (CharSequence) charBuffer0);
    }

    @Test(timeout = 4000)
    public void test009() throws Throwable {
        Moment moment0 = Moment.valueOf(0, 0, 0);
        Date[] dateArray0 = new Date[0];
        FormulaDecimal formulaDecimal0 = Moments.networkdays((Date) moment0, (Date) moment0, dateArray0);
        Number[] numberArray0 = new Number[2];
        numberArray0[0] = (Number) formulaDecimal0;
        numberArray0[1] = (Number) formulaDecimal0;
        Moments.workday_intl((Number) formulaDecimal0, (Number) formulaDecimal0, numberArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test010() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        Number[] numberArray0 = new Number[2];
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((BigDecimal) null);
        numberArray0[0] = (Number) formulaDecimal0;
        Moments.workday_intl((Number) bigInteger0, (Number) bigInteger0, numberArray0);
    }

    @Test(timeout = 4000)
    public void test011() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        Moments.workday_intl((Number) bigInteger0, (Number) bigInteger0, (CharSequence[]) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test012() throws Throwable {
        Long long0 = new Long((-12L));
        FormulaDecimal formulaDecimal0 = Moments.year((Number) long0);
        char[] charArray0 = new char[3];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        CharBuffer charBuffer1 = CharBuffer.wrap((CharSequence) charBuffer0);
        charBuffer0.compact();
        Moments.workday_intl((Number) formulaDecimal0, (CharSequence) charBuffer1);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test013() throws Throwable {
        char[] charArray0 = new char[9];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0, 0, 0);
        BigInteger bigInteger0 = BigInteger.ZERO;
        Number[] numberArray0 = new Number[3];
        Moments.workday_intl((CharSequence) charBuffer0, (Number) bigInteger0, numberArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test014() throws Throwable {
        char[] charArray0 = new char[2];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        CharBuffer charBuffer1 = CharBuffer.wrap((CharSequence) charBuffer0);
        charBuffer0.get(charArray0);
        Integer integer0 = new Integer((-126));
        Moments.workday_intl((CharSequence) charBuffer1, (Number) integer0);
    }

    @Test(timeout = 4000)
    public void test015() throws Throwable {
        char[] charArray0 = new char[6];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0, 0, 0);
        Assert.assertNotNull(Moments.workday_intl((CharSequence) charBuffer0, (CharSequence) charBuffer0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test016() throws Throwable {
        Moment moment0 = Moment.valueOf(1105, 0, 0, 0, 0);
        Date[] dateArray0 = new Date[2];
        Moments.workday((Date) moment0, (CharSequence) null, dateArray0);
    }

    @Test(timeout = 4000)
    public void test017() throws Throwable {
        Date Date0 = new Date(0, 0, 0, 0, 4, 0);
        Moments.workday((Date) Date0, (CharSequence) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test018() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        Moment moment0 = Moments.datetimevalue((Number) bigInteger0);
        Number[] numberArray0 = new Number[7];
        numberArray0[4] = (Number) bigInteger0;
        Moments.workday(numberArray0[4], (Date) moment0, numberArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test019() throws Throwable {
        Double double0 = new Double(0.0);
        Moment moment0 = Moments.date((Number) double0, (Number) double0, (Number) double0, (Number) double0, (Number) double0);
        FormulaDecimal formulaDecimal0 = Moments.days360((Date) moment0, (Number) double0);
        Date[] dateArray0 = new Date[2];
        Moments.workday((Number) null, (Number) formulaDecimal0, dateArray0);
    }

    @Test(timeout = 4000)
    public void test020() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        Number[] numberArray0 = new Number[7];
        numberArray0[0] = (Number) bigDecimal0;
        numberArray0[1] = (Number) bigDecimal0;
        numberArray0[2] = (Number) bigDecimal0;
        numberArray0[3] = (Number) bigInteger0;
        numberArray0[4] = (Number) bigInteger0;
        numberArray0[5] = (Number) bigInteger0;
        numberArray0[6] = (Number) bigDecimal0;
        Moments.workday((Number) bigDecimal0, (Number) bigInteger0, numberArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test021() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        BigDecimal bigDecimal0 = new BigDecimal(bigInteger0);
        FormulaDecimal formulaDecimal0 = Moments.hour((Number) bigDecimal0);
        CharSequence[] charSequenceArray0 = new CharSequence[5];
        charSequenceArray0[0] = (CharSequence) "0";
        Moments.workday((Number) formulaDecimal0, (CharSequence) "0", charSequenceArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test022() throws Throwable {
        Integer integer0 = new Integer(11);
        char[] charArray0 = new char[5];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        Moments.workday((Number) integer0, (CharSequence) charBuffer0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test023() throws Throwable {
        char[] charArray0 = new char[0];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0, 0, 0);
        Number[] numberArray0 = new Number[2];
        Moments.workday((CharSequence) charBuffer0, (Number) null, numberArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test024() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        CharSequence[] charSequenceArray0 = new CharSequence[1];
        Moments.workday((CharSequence) null, (Number) bigInteger0, charSequenceArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test025() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        CharBuffer charBuffer0 = CharBuffer.allocate(42);
        Moments.workday((CharSequence) charBuffer0, (Number) bigInteger0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test026() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(29);
        Date[] dateArray0 = new Date[0];
        Moments.workday((CharSequence) charBuffer0, (CharSequence) charBuffer0, dateArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test027() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(2);
        Moments.workday((CharSequence) charBuffer0, (CharSequence) charBuffer0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test028() throws Throwable {
        Moments.weekday((CharSequence) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test029() throws Throwable {
        Moments.valueOf((Number) null);
    }

    @Test(timeout = 10000)
    public void test030() throws Throwable {
        Moment moment0 = Moments.now();
        Moment moment1 = Moment.valueOf(0, 920, 0);
        Number[] numberArray0 = new Number[2];
        Short short0 = new Short((short) (-841));
        numberArray0[0] = (Number) short0;
        byte[] byteArray0 = new byte[1];
        BigInteger bigInteger0 = new BigInteger(byteArray0);
        numberArray0[1] = (Number) bigInteger0;
        // Undeclared exception!
        Moments.networkdays_intl((Date) moment0, (Date) moment1, numberArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test031() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(944);
        Moment moment0 = Moment.valueOf(944, 944, 944, 944, 944);
        BigInteger bigInteger0 = BigInteger.ONE;
        CharSequence[] charSequenceArray0 = new CharSequence[2];
        charSequenceArray0[0] = (CharSequence) charBuffer0;
        Moments.networkdays_intl((Date) moment0, (Date) moment0, (Number) bigInteger0, charSequenceArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test032() throws Throwable {
        Date[] dateArray0 = new Date[6];
        Moments.networkdays_intl((Date) null, (CharSequence) null, dateArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test033() throws Throwable {
        Long long0 = new Long((-12L));
        char[] charArray0 = new char[6];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        CharBuffer charBuffer1 = CharBuffer.wrap((CharSequence) charBuffer0);
        charBuffer0.compact();
        Number[] numberArray0 = new Number[2];
        Moments.networkdays_intl((CharSequence) charBuffer1, (Number) long0, numberArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test034() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        Moment moment0 = Moments.date((Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0);
        Number[] numberArray0 = new Number[4];
        Moments.networkdays((Date) moment0, (Number) bigInteger0, numberArray0);
    }

    @Test(timeout = 4000)
    public void test035() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(0);
        Byte byte0 = Byte.valueOf((byte) 16);
        Moments.days360((Number) byte0, (CharSequence) charBuffer0, (Logical) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test036() throws Throwable {
        Byte byte0 = Byte.valueOf((byte) (-3));
        char[] charArray0 = new char[8];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        Moments.days360((CharSequence) charBuffer0, (Number) byte0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test037() throws Throwable {
        Moments.days360((CharSequence) null, (CharSequence) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test038() throws Throwable {
        Moments.day((Date) null);
    }

    @Test(timeout = 4000)
    public void test039() throws Throwable {
        Moments.datetimevalue((Number) null);
    }

    @Test(timeout = 4000)
    public void test040() throws Throwable {
        StringWriter stringWriter0 = new StringWriter(2726);
        StringBuffer stringBuffer0 = stringWriter0.getBuffer();
        CharBuffer charBuffer0 = CharBuffer.wrap((CharSequence) stringBuffer0);
        Moments.datetimevalue((CharSequence) charBuffer0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test041() throws Throwable {
        Moments.date((CharSequence) null, (CharSequence) null, (CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test042() throws Throwable {
        Short short0 = new Short((short) 2947);
        Moments.valueOf((Number) short0);
    }

    @Test(timeout = 4000)
    public void test043() throws Throwable {
        Float float0 = new Float(0.0);
        FormulaDecimal formulaDecimal0 = Moments.edate((Number) float0, (Number) float0);
        Moments.valueOf((Number) formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test044() throws Throwable {
        Moment moment0 = new Moment();
        Moments.days((Date) moment0, (Date) moment0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test045() throws Throwable {
        Moments.valueOf((Date) null);
    }

    @Test(timeout = 4000)
    public void test046() throws Throwable {
        Short short0 = new Short((short) 2947);
        Moment moment0 = Moments.date((Number) short0, (Number) short0, (Number) short0);
        Logical logical0 = new Logical(true);
        FormulaDecimal formulaDecimal0 = Moments.days360((Date) moment0, (Number) short0, logical0);
        Moments.weekday(moment0, (Number) formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test047() throws Throwable {
        Short short0 = new Short((short) 2947);
        Moment moment0 = Moments.date((Number) short0, (Number) short0, (Number) short0);
        Boolean boolean0 = Boolean.TRUE;
        Moments.days360((Date) moment0, (Date) moment0, boolean0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test048() throws Throwable {
        Moments.day((Moment) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test049() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(3286);
        Moments.valueOf((CharSequence) charBuffer0);
    }

    @Test(timeout = 4000)
    public void test050() throws Throwable {
        Moment moment0 = Moments.now();
        Moments.isoweeknum(moment0);
    }

    @Test(timeout = 4000)
    public void test051() throws Throwable {
        Double double0 = new Double(0.0);
        Moment moment0 = Moments.date((Number) double0, (Number) double0, (Number) double0, (Number) double0, (Number) double0);
        Moments.minute(moment0);
    }

    @Ignore
    @Test(timeout = 4000)
    public void test052() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.TEN;
        FormulaDecimal formulaDecimal0 = Moments.week((Number) bigDecimal0);
        Date Date0 = new Date(0, 0, (-428));
        Date[] dateArray0 = new Date[5];
        Moments.workday_intl((Date) Date0, (Number) formulaDecimal0, (Number) bigDecimal0, dateArray0);
    }

    @Test(timeout = 4000)
    public void test053() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        Moment moment0 = Moments.date((Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0);
        Moments.datetimevalue(moment0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test054() throws Throwable {
        Moment moment0 = Moments.now();
        Short short0 = new Short((short) 5);
        Moments.yearfrac((Date) moment0, (Date) moment0, (Number) short0);
    }

    @Test(timeout = 4000)
    public void test055() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        Moments.year((Number) bigInteger0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test056() throws Throwable {
        char[] charArray0 = new char[9];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        CharSequence[] charSequenceArray0 = new CharSequence[1];
        charSequenceArray0[0] = (CharSequence) charBuffer0;
        Moments.workday_intl((Date) null, (CharSequence) charBuffer0, charSequenceArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test057() throws Throwable {
        Moment moment0 = Moment.valueOf(1085, 2527, (-3234));
        Charset charset0 = Charset.defaultCharset();
        byte[] byteArray0 = new byte[4];
        ByteBuffer byteBuffer0 = ByteBuffer.wrap(byteArray0);
        CharBuffer charBuffer0 = charset0.decode(byteBuffer0);
        CharSequence[] charSequenceArray0 = new CharSequence[0];
        Moments.workday_intl((Date) moment0, (CharSequence) charBuffer0, charSequenceArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test058() throws Throwable {
        Long long0 = new Long((-12L));
        char[] charArray0 = new char[3];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        CharSequence[] charSequenceArray0 = new CharSequence[8];
        charSequenceArray0[0] = (CharSequence) charBuffer0;
        Moments.workday_intl((Number) long0, (CharSequence) charBuffer0, charSequenceArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test059() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(365);
        CharSequence[] charSequenceArray0 = new CharSequence[0];
        Moments.workday_intl((Number) null, (CharSequence) charBuffer0, charSequenceArray0);
    }

    @Ignore
    @Test(timeout = 4000)
    public void test060() throws Throwable {
        CharSequence[] charSequenceArray0 = new CharSequence[4];
        Moments.workday_intl((CharSequence) null, (CharSequence) null, charSequenceArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test061() throws Throwable {
        char[] charArray0 = new char[5];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        CharSequence[] charSequenceArray0 = new CharSequence[0];
        Moments.workday_intl((CharSequence) charBuffer0, (CharSequence) charBuffer0, charSequenceArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test062() throws Throwable {
        Byte byte0 = new Byte((byte) 0);
        Date[] dateArray0 = new Date[0];
        Moments.networkdays_intl((Date) null, (Date) null, (Number) byte0, dateArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test063() throws Throwable {
        Moment moment0 = Moment.valueOf((-1544), (-1544), (-1544), (-1544), 7);
        FormulaDecimal formulaDecimal0 = Moments.weekday(moment0);
        char[] charArray0 = new char[0];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        CharSequence[] charSequenceArray0 = new CharSequence[9];
        charSequenceArray0[0] = (CharSequence) charBuffer0;
        Moments.networkdays_intl((Number) formulaDecimal0, (CharSequence) charBuffer0, charSequenceArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test064() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(3146);
        Moments.month((CharSequence) charBuffer0);
    }

    @Test(timeout = 4000)
    public void test065() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        Moments.minute((Number) bigInteger0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test066() throws Throwable {
        char[] charArray0 = new char[3];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        Moments.day((CharSequence) charBuffer0);
    }

    @Test(timeout = 4000)
    public void test067() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        Moment moment0 = Moments.now();
        Moments.edate((Date) moment0, (Number) bigInteger0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test068() throws Throwable {
        Date Date0 = new Date();
        Moments.datedif((Date) Date0, (Date) Date0, (CharSequence) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test069() throws Throwable {
        Integer integer0 = Integer.getInteger("", (-1294));
        Short short0 = new Short((short) 2938);
        Moments.date((Number) integer0, (Number) integer0, (Number) integer0, (Number) short0, (Number) short0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test070() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(1023);
        Date Date0 = new Date();
        Date[] dateArray0 = new Date[9];
        Moments.networkdays_intl((Date) Date0, (CharSequence) charBuffer0, dateArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test071() throws Throwable {
        StringWriter stringWriter0 = new StringWriter(0);
        StringBuffer stringBuffer0 = stringWriter0.getBuffer();
        CharBuffer charBuffer0 = CharBuffer.wrap((CharSequence) stringBuffer0);
        Number[] numberArray0 = new Number[9];
        Moments.workday((CharSequence) stringBuffer0, (CharSequence) charBuffer0, numberArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test072() throws Throwable {
        Number[] numberArray0 = new Number[0];
        Moments.networkdays_intl((Date) null, (Date) null, numberArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test073() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1L);
        BigDecimal bigDecimal0 = new BigDecimal(771.1545483845681);
        Moment moment0 = Moments.date((Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) bigDecimal0, (Number) formulaDecimal0);
        CharBuffer charBuffer0 = CharBuffer.allocate(0);
        Date[] dateArray0 = new Date[1];
        Moments.networkdays_intl((CharSequence) charBuffer0, (Date) moment0, dateArray0);
    }

    @Test(timeout = 4000)
    public void test074() throws Throwable {
        Moment moment0 = new Moment();
        Moments.weeknum((Date) moment0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test075() throws Throwable {
        char[] charArray0 = new char[1];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        Float float0 = new Float(3900.7468F);
        Moments.eomonth((CharSequence) charBuffer0, (Number) float0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test076() throws Throwable {
        Long long0 = new Long((-12L));
        FormulaDecimal formulaDecimal0 = Moments.year((Number) long0);
        char[] charArray0 = new char[3];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        Number[] numberArray0 = new Number[4];
        Moments.workday_intl((Number) formulaDecimal0, (CharSequence) charBuffer0, numberArray0);
    }

    @Test(timeout = 4000)
    public void test077() throws Throwable {
        Float float0 = new Float(0.0);
        FormulaDecimal formulaDecimal0 = Moments.edate((Number) float0, (Number) float0);
        Moments.datevalue((Number) formulaDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test078() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        Number[] numberArray0 = new Number[7];
        Moments.workday((Number) bigDecimal0, (Number) bigInteger0, numberArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test079() throws Throwable {
        Moments.days((Number) null, (Number) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test080() throws Throwable {
        Float float0 = new Float(0.0);
        FormulaDecimal formulaDecimal0 = Moments.edate((Number) float0, (Number) float0);
        Date[] dateArray0 = new Date[9];
        Moments.networkdays_intl((Number) formulaDecimal0, dateArray0[7], dateArray0);
    }

    @Test(timeout = 4000)
    public void test081() throws Throwable {
        Moments.year();
    }

    @Test(timeout = 4000)
    public void test082() throws Throwable {
        Moments.second();
    }

    @Test(timeout = 4000)
    public void test083() throws Throwable {
        Moment moment0 = Moment.valueOf((-2780), (-2780), 13, 110, 902);
        Moments.weekday((Date) moment0);
    }

    @Test(timeout = 4000)
    public void test084() throws Throwable {
        Moments.time((CharSequence) null, (CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test085() throws Throwable {
        Short short0 = new Short((short) 1013);
        CharSequence[] charSequenceArray0 = new CharSequence[0];
        Moments.networkdays((Number) short0, (Number) short0, charSequenceArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test086() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(60);
        BigDecimal bigDecimal0 = BigDecimal.TEN;
        Moments.networkdays_intl((CharSequence) charBuffer0, (Number) bigDecimal0);
    }

    @Test(timeout = 4000)
    public void test087() throws Throwable {
        Moment moment0 = new Moment((-2194L));
        Float float0 = new Float(1.0F);
        Moments.networkdays((Date) moment0, (Number) float0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test088() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.TEN;
        Moments.workday_intl((CharSequence) null, (Number) bigDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test089() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(1610);
        Moments.isoweeknum((CharSequence) charBuffer0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test090() throws Throwable {
        Moment moment0 = Moment.valueOf((-1595), 1994, 1544);
        Moments.networkdays_intl((Date) moment0, (Date) moment0, (Number) null);
    }

    @Test(timeout = 4000)
    public void test091() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        Number[] numberArray0 = new Number[0];
        Moments.workday((Number) bigInteger0, (Date) null, numberArray0);
    }

    @Test(timeout = 4000)
    public void test092() throws Throwable {
        Moments.day();
    }

    @Test(timeout = 4000)
    public void test093() throws Throwable {
        Moment moment0 = new Moment(2845L);
        Moments.hour((Date) moment0);
    }

    @Test(timeout = 4000)
    public void test094() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        Moments.weekday((Number) bigInteger0);
    }

    @Test(timeout = 4000)
    public void test095() throws Throwable {
        Moment moment0 = Moments.today();
        Number number0 = moment0.isoweeknum();
        Moments.days(number0, (Date) moment0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test096() throws Throwable {
        CharSequence[] charSequenceArray0 = new CharSequence[0];
        Moments.networkdays((CharSequence) null, (CharSequence) null, charSequenceArray0);
    }

    @Test(timeout = 4000)
    public void test097() throws Throwable {
        Moments.weekday();
    }

    @Test(timeout = 4000)
    public void test098() throws Throwable {
        Moment moment0 = Moments.today();
        Moments.hour(moment0);
    }

    @Test(timeout = 4000)
    public void test099() throws Throwable {
        StringWriter stringWriter0 = new StringWriter(0);
        StringBuffer stringBuffer0 = stringWriter0.getBuffer();
        Number[] numberArray0 = new Number[0];
        Assert.assertNotNull(Moments.workday_intl((CharSequence) stringBuffer0, (CharSequence) stringBuffer0, numberArray0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test100() throws Throwable {
        Long long0 = new Long((-12L));
        FormulaDecimal formulaDecimal0 = Moments.year((Number) long0);
        char[] charArray0 = new char[3];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        Moments.workday_intl((Number) formulaDecimal0, (CharSequence) charBuffer0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test101() throws Throwable {
        Short short0 = new Short((short) 2947);
        StringWriter stringWriter0 = new StringWriter();
        StringBuffer stringBuffer0 = stringWriter0.getBuffer();
        CharSequence[] charSequenceArray0 = new CharSequence[3];
        Moments.networkdays((Number) short0, (CharSequence) stringBuffer0, charSequenceArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test102() throws Throwable {
        Byte byte0 = new Byte((byte) (-48));
        Moments.networkdays((Number) byte0, (Date) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test103() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(1148);
        Moments.date((CharSequence) charBuffer0, (CharSequence) charBuffer0, (CharSequence) charBuffer0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test104() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ZERO;
        CharSequence[] charSequenceArray0 = new CharSequence[4];
        Moments.workday((Number) bigDecimal0, (Number) bigDecimal0, charSequenceArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test105() throws Throwable {
        Date Date0 = new Date((-1213L));
        Charset charset0 = Charset.defaultCharset();
        ByteBuffer byteBuffer0 = charset0.encode("^s<Y3CE?B-Iv#?");
        CharBuffer charBuffer0 = charset0.decode(byteBuffer0);
        Moments.datedif((Date) Date0, (CharSequence) charBuffer0, (CharSequence) charBuffer0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test106() throws Throwable {
        Moment moment0 = Moments.today();
        Charset charset0 = Charset.defaultCharset();
        byte[] byteArray0 = new byte[7];
        ByteBuffer byteBuffer0 = ByteBuffer.wrap(byteArray0);
        CharBuffer charBuffer0 = charset0.decode(byteBuffer0);
        Boolean boolean0 = Boolean.valueOf(false);
        Moments.days360((Date) moment0, (CharSequence) charBuffer0, boolean0);
    }

    @Test(timeout = 4000)
    public void test107() throws Throwable {
        Moments moments0 = new Moments();
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test108() throws Throwable {
        char[] charArray0 = new char[5];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        Float float0 = new Float(0.0F);
        Moment moment0 = Moments.date((Number) float0, (Number) float0, (Number) float0);
        CharSequence[] charSequenceArray0 = new CharSequence[7];
        Moments.networkdays((CharSequence) charBuffer0, (Date) moment0, charSequenceArray0);
    }

    @Test(timeout = 4000)
    public void test109() throws Throwable {
        Short short0 = new Short((short) 545);
        Moments.workday((Number) short0, (CharSequence) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test110() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(2);
        Boolean boolean0 = Boolean.TRUE;
        Moments.days360((CharSequence) charBuffer0, (CharSequence) charBuffer0, boolean0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test111() throws Throwable {
        Charset charset0 = Charset.defaultCharset();
        ByteBuffer byteBuffer0 = ByteBuffer.allocate(12);
        CharBuffer charBuffer0 = charset0.decode(byteBuffer0);
        CharSequence[] charSequenceArray0 = new CharSequence[0];
        Moments.workday((CharSequence) charBuffer0, (CharSequence) charBuffer0, charSequenceArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test112() throws Throwable {
        char[] charArray0 = new char[3];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        Moment moment0 = Moments.now();
        Moments.workday((Date) moment0, (CharSequence) charBuffer0);
    }

    @Test(timeout = 4000)
    public void test113() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        FormulaDecimal formulaDecimal0 = Moments.time((Number) bigInteger0, (Number) bigInteger0);
        Moments.workday_intl((Number) bigInteger0, (Number) formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test114() throws Throwable {
        StringWriter stringWriter0 = new StringWriter(2272);
        StringBuffer stringBuffer0 = stringWriter0.getBuffer();
        CharBuffer charBuffer0 = CharBuffer.wrap((CharSequence) stringBuffer0);
        Moments.weeknum((CharSequence) charBuffer0);
    }

    @Test(timeout = 4000)
    public void test115() throws Throwable {
        Moments.month((Date) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test116() throws Throwable {
        Moments.workday_intl((CharSequence) null, (CharSequence) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test117() throws Throwable {
        char[] charArray0 = new char[8];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        BigDecimal bigDecimal0 = new BigDecimal((-1833));
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigDecimal0);
        CharSequence[] charSequenceArray0 = new CharSequence[4];
        Moments.workday_intl((CharSequence) charBuffer0, (Number) formulaDecimal0, charSequenceArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test118() throws Throwable {
        Moments.workday((CharSequence) null, (CharSequence) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test119() throws Throwable {
        Short short0 = new Short((short) 2947);
        Moment moment0 = Moments.date((Number) short0, (Number) short0, (Number) short0);
        Logical logical0 = new Logical(true);
        FormulaDecimal formulaDecimal0 = Moments.days360((Date) moment0, (Number) short0, logical0);
        Number[] numberArray0 = new Number[2];
        CharBuffer charBuffer0 = CharBuffer.allocate((short) 2947);
        Moments.networkdays((CharSequence) charBuffer0, (Number) formulaDecimal0, numberArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test120() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(1372);
        Date[] dateArray0 = new Date[8];
        Moments.workday_intl((CharSequence) charBuffer0, (CharSequence) charBuffer0, dateArray0);
    }

    @Test(timeout = 4000)
    public void test121() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        Moment moment0 = Moments.datetimevalue((Number) bigInteger0);
        Date[] dateArray0 = new Date[3];
        dateArray0[0] = (Date) moment0;
        dateArray0[1] = (Date) moment0;
        dateArray0[2] = (Date) moment0;
        FormulaDecimal formulaDecimal0 = Moments.networkdays((Date) moment0, (Date) moment0, dateArray0);
        Moments.networkdays_intl((Number) formulaDecimal0, (Number) formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test122() throws Throwable {
        Short short0 = new Short((short) 3187);
        Moments.day((Number) short0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test123() throws Throwable {
        StringWriter stringWriter0 = new StringWriter(68);
        StringBuffer stringBuffer0 = stringWriter0.getBuffer();
        Double double0 = new Double(3084.518869110936);
        CharSequence[] charSequenceArray0 = new CharSequence[7];
        Moments.networkdays((CharSequence) stringBuffer0, (Number) double0, charSequenceArray0);
    }

    @Test(timeout = 4000)
    public void test124() throws Throwable {
        StringWriter stringWriter0 = new StringWriter();
        StringBuffer stringBuffer0 = stringWriter0.getBuffer();
        BigInteger bigInteger0 = BigInteger.ZERO;
        BigDecimal bigDecimal0 = new BigDecimal(bigInteger0);
        Moments.edate((CharSequence) stringBuffer0, (Number) bigDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test125() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        Number[] numberArray0 = new Number[4];
        Moments.workday_intl((Date) null, (Number) bigInteger0, numberArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test126() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(111);
        Number[] numberArray0 = new Number[7];
        Moments.networkdays_intl((CharSequence) charBuffer0, (CharSequence) charBuffer0, numberArray0);
    }

    @Test(timeout = 4000)
    public void test127() throws Throwable {
        Moments.datetimevalue((CharSequence) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test128() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(0);
        Moments.workday_intl((Date) null, (CharSequence) charBuffer0);
    }

    @Test(timeout = 4000)
    public void test129() throws Throwable {
        Moments.date();
    }

    @Test(timeout = 4000)
    public void test130() throws Throwable {
        Short short0 = new Short((short) 2947);
        Moment moment0 = Moments.date((Number) short0, (Number) short0, (Number) short0);
        Moments.weeknum(moment0);
    }

    @Test(timeout = 4000)
    public void test131() throws Throwable {
        Moments.month();
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test132() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-29.855489916078));
        Logical logical0 = Logical.FALSE;
        Moments.days360((Number) formulaDecimal0, (Date) null, logical0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test133() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        Moments.days360((CharSequence) null, (Number) bigInteger0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test134() throws Throwable {
        FormulaDecimal formulaDecimal0 = Moments.hour();
        Number[] numberArray0 = new Number[1];
        Moments.workday((CharSequence) null, (Number) formulaDecimal0, numberArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test135() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        Moments.yearfrac((CharSequence) null, (CharSequence) null, (Number) bigInteger0);
    }

    @Test(timeout = 4000)
    public void test136() throws Throwable {
        Double double0 = new Double(0.0);
        Moment moment0 = Moments.date((Number) double0, (Number) double0, (Number) double0, (Number) double0, (Number) double0);
        Number number0 = moment0.weekday(0);
        FormulaDecimal formulaDecimal0 = Moments.days360((Date) moment0, (Number) double0);
        Date[] dateArray0 = new Date[2];
        dateArray0[0] = (Date) moment0;
        dateArray0[1] = (Date) moment0;
        Moments.workday(number0, (Number) formulaDecimal0, dateArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test137() throws Throwable {
        Double double0 = new Double(0.0);
        Moment moment0 = Moments.date((Number) double0, (Number) double0, (Number) double0, (Number) double0, (Number) double0);
        Number number0 = moment0.weekday(0);
        FormulaDecimal formulaDecimal0 = Moments.days360((Date) moment0, (Number) double0);
        Date[] dateArray0 = new Date[2];
        Moments.workday(number0, (Number) formulaDecimal0, dateArray0);
    }

    @Test(timeout = 4000)
    public void test138() throws Throwable {
        Double double0 = new Double(0.0);
        Moments.workday((Number) double0, (Number) double0);
    }

    @Test(timeout = 4000)
    public void test139() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ZERO;
        Date[] dateArray0 = new Date[0];
        Moments.networkdays_intl((Number) bigDecimal0, (Number) bigDecimal0, dateArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test140() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(2);
        Moments.networkdays((CharSequence) charBuffer0, (CharSequence) charBuffer0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test141() throws Throwable {
        Date[] dateArray0 = new Date[8];
        Moments.networkdays((Number) null, (Date) null, dateArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test142() throws Throwable {
        Moments.networkdays((Date) null, (Date) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test143() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ZERO;
        Number[] numberArray0 = new Number[4];
        Moments.workday_intl((CharSequence) null, (Number) bigDecimal0, numberArray0);
    }

    @Test(timeout = 4000)
    public void test144() throws Throwable {
        Date Date0 = new Date((-1132L));
        BigInteger bigInteger0 = BigInteger.ONE;
        Moments.workday((Date) Date0, (Number) bigInteger0);
    }

    @Test(timeout = 4000)
    public void test145() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(0);
        Moments.days360((CharSequence) charBuffer0, (CharSequence) charBuffer0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test146() throws Throwable {
        Date Date0 = new Date();
        CharBuffer charBuffer0 = CharBuffer.allocate(0);
        Date[] dateArray0 = new Date[2];
        Moments.workday((Date) Date0, (CharSequence) charBuffer0, dateArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test147() throws Throwable {
        Moment moment0 = Moment.valueOf(0, 0, 0);
        Date[] dateArray0 = new Date[0];
        FormulaDecimal formulaDecimal0 = Moments.networkdays((Date) moment0, (Date) moment0, dateArray0);
        Number[] numberArray0 = new Number[2];
        Moments.workday_intl((Number) formulaDecimal0, (Number) formulaDecimal0, numberArray0);
    }

    @Test(timeout = 4000)
    public void test148() throws Throwable {
        Short short0 = new Short((short) 2186);
        Moments.workday((Number) short0, (Date) null);
    }

    @Test(timeout = 4000)
    public void test149() throws Throwable {
        Moment moment0 = Moment.valueOf(86400, 86400, 86400);
        FormulaDecimal formulaDecimal0 = Moments.year((Date) moment0);
        Moments.eomonth((Number) formulaDecimal0, (Number) formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test150() throws Throwable {
        Moment moment0 = Moment.valueOf(1085, 2527, (-3234));
        Moments.day((Date) moment0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test151() throws Throwable {
        char[] charArray0 = new char[6];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        Logical logical0 = Logical.valueOf(false);
        Moments.days360((CharSequence) charBuffer0, (CharSequence) charBuffer0, logical0);
    }

    @Test(timeout = 4000)
    public void test152() throws Throwable {
        Moment moment0 = new Moment((-613L));
        Moments.minute((Date) moment0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test153() throws Throwable {
        StringWriter stringWriter0 = new StringWriter();
        StringBuffer stringBuffer0 = stringWriter0.getBuffer();
        Moments.datedif((Number) null, (Date) null, (CharSequence) stringBuffer0);
    }

    @Test(timeout = 4000)
    public void test154() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((double) 944);
        Moments.year((Number) formulaDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test155() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ONE;
        FormulaDecimal formulaDecimal0 = Moments.time((Number) bigDecimal0, (Number) bigDecimal0);
        Moments.days360((Number) formulaDecimal0, (CharSequence) null, (Logical) null);
    }

    @Test(timeout = 4000)
    public void test156() throws Throwable {
        Integer integer0 = new Integer(14);
        Moments.isoweeknum((Number) integer0);
    }

    @Test(timeout = 4000)
    public void test157() throws Throwable {
        Moment moment0 = Moment.valueOf(1529, (-930), 1529);
        BigInteger bigInteger0 = BigInteger.ONE;
        Moments.workday_intl((Date) moment0, (Number) bigInteger0, (Number) bigInteger0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test158() throws Throwable {
        char[] charArray0 = new char[2];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        BigInteger bigInteger0 = BigInteger.ONE;
        Moments.networkdays((CharSequence) charBuffer0, (Number) bigInteger0);
    }

    @Test(timeout = 4000)
    public void test159() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);
        Moment moment0 = Moments.date((Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, (Number) formulaDecimal0);
        Boolean boolean0 = Boolean.valueOf(true);
        Moments.days360((Date) moment0, (Number) formulaDecimal0, boolean0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test160() throws Throwable {
        Float float0 = new Float(0.0F);
        Moments.workday((CharSequence) null, (Number) float0);
    }

    @Test(timeout = 4000)
    public void test161() throws Throwable {
        Moments.week();
    }

    @Test(timeout = 10000)
    public void test162() throws Throwable {
        Short short0 = new Short((short) 2947);
        Moment moment0 = Moments.date((Number) short0, (Number) short0, (Number) short0);
        Number[] numberArray0 = new Number[2];
        numberArray0[0] = (Number) short0;
        numberArray0[1] = (Number) short0;
        Moments.networkdays_intl((Date) moment0, numberArray0[0], numberArray0);
    }

    @Test(timeout = 4000)
    public void test163() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1L);
        BigDecimal bigDecimal0 = new BigDecimal(771.1545483845681);
        Moment moment0 = Moments.date((Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) formulaDecimal0, (Number) bigDecimal0, (Number) formulaDecimal0);
        StringWriter stringWriter0 = new StringWriter(0);
        StringBuffer stringBuffer0 = stringWriter0.getBuffer();
        CharSequence[] charSequenceArray0 = new CharSequence[0];
        Assert.assertNotNull(Moments.workday((Date) moment0, (CharSequence) stringBuffer0, charSequenceArray0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test164() throws Throwable {
        Integer integer0 = new Integer(14);
        char[] charArray0 = new char[8];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        Boolean boolean0 = new Boolean("|Tr+?@cPlMShO`K");
        Moments.days360((Number) integer0, (CharSequence) charBuffer0, boolean0);
    }

    @Test(timeout = 4000)
    public void test165() throws Throwable {
        Moment moment0 = Moments.today();
        Number number0 = moment0.weekday();
        Moments.weeknum(number0, number0);
    }

    @Test(timeout = 4000)
    public void test166() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);
        Moment moment0 = Moments.date((Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, (Number) formulaDecimal0);
        Moments.networkdays((Date) moment0, (Date) moment0, (Number[]) null);
    }

    @Test(timeout = 4000)
    public void test167() throws Throwable {
        Moment moment0 = Moments.today();
        Moments.datetimevalue((Date) moment0);
    }

    @Test(timeout = 4000)
    public void test168() throws Throwable {
        Moments.timenow();
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test169() throws Throwable {
        char[] charArray0 = new char[5];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        Moments.timevalue((CharSequence) charBuffer0);
    }

    @Test(timeout = 4000)
    public void test170() throws Throwable {
        Moment moment0 = Moment.valueOf((-1544), (-1544), (-1544), (-1544), 7);
        FormulaDecimal formulaDecimal0 = Moments.weekday(moment0);
        Moments.weekday((Date) moment0, (Number) formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test171() throws Throwable {
        Moments.minute();
    }

    @Test(timeout = 4000)
    public void test172() throws Throwable {
        BigInteger bigInteger0 = BigInteger.TEN;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);
        Moments.days360((Number) formulaDecimal0, (Number) bigInteger0, (Boolean) null);
    }

    @Test(timeout = 4000)
    public void test173() throws Throwable {
        Short short0 = new Short((short) 2947);
        Moment moment0 = Moments.date((Number) short0, (Number) short0, (Number) short0);
        Moments.week((Date) moment0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test174() throws Throwable {
        Moments.workday((CharSequence) null, (CharSequence) null, (Date[]) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test175() throws Throwable {
        Moments.workday_intl((Date) null, (Number) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test176() throws Throwable {
        char[] charArray0 = new char[5];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        Float float0 = new Float(133.305530496484);
        CharSequence[] charSequenceArray0 = new CharSequence[3];
        Moments.workday((CharSequence) charBuffer0, (Number) float0, charSequenceArray0);
    }

    @Test(timeout = 4000)
    public void test177() throws Throwable {
        Double double0 = new Double(0.0);
        Moment moment0 = Moments.date((Number) double0, (Number) double0, (Number) double0, (Number) double0, (Number) double0);
        FormulaDecimal formulaDecimal0 = Moments.days360((Date) moment0, (Number) double0);
        Moments.days360((Number) double0, (Number) formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test178() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        Moment moment0 = Moments.date((Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0, (Number) bigInteger0);
        Moments.weeknum((Date) moment0, (Number) bigInteger0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test179() throws Throwable {
        Date Date0 = new Date((-2478), 365, (-2478), (-2478), 2207, 23);
        Moments.workday_intl((Date) Date0, (Number) null, (Date[]) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test180() throws Throwable {
        Float float0 = new Float(0.0);
        FormulaDecimal formulaDecimal0 = Moments.edate((Number) float0, (Number) float0);
        CharBuffer charBuffer0 = CharBuffer.allocate(1023);
        Moments.networkdays_intl((Number) formulaDecimal0, (CharSequence) charBuffer0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test181() throws Throwable {
        Charset charset0 = Charset.defaultCharset();
        ByteBuffer byteBuffer0 = ByteBuffer.allocate(3);
        CharBuffer charBuffer0 = charset0.decode(byteBuffer0);
        Moments.weekday((CharSequence) charBuffer0);
    }

    @Test(timeout = 4000)
    public void test182() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ZERO;
        Moment moment0 = Moments.now();
        Number[] numberArray0 = new Number[2];
        numberArray0[0] = (Number) bigInteger0;
        numberArray0[1] = (Number) bigInteger0;
        // Undeclared exception!
        Moments.networkdays((Date) moment0, (Number) bigInteger0, numberArray0);
    }

    @Test(timeout = 4000)
    public void test183() throws Throwable {
        Moment moment0 = Moments.today();
        boolean boolean0 = Moments.feb29Between(moment0, moment0);
        assertFalse(boolean0);
    }
}
