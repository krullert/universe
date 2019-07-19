package io.onsense.universe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.StringWriter;
import java.math.BigDecimal;
import java.nio.CharBuffer;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * @author Koen Rooijmans
 */
public class MomentTest {

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
    public void test04() throws Throwable {
        Moment moment0 = Moment.valueOf(0L);
        Number number0 = moment0.weekday(1727);
        assertEquals((-1721), number0);
    }

    @Test(timeout = 4000)
    public void test09() throws Throwable {
        Moment moment0 = Moment.valueOf((-1L));
        Number number0 = moment0.second();
        assertEquals(59, number0);
    }

    @Test(timeout = 4000)
    public void test11() throws Throwable {
        Date Date0 = new Date((-2660L));
        Moment moment0 = new Moment(Date0);
        Number number0 = moment0.minute();
        assertEquals(59, number0);
    }

    @Test(timeout = 4000)
    public void test13() throws Throwable {
        Assert.assertNotNull(Moment.valueOf((CharSequence) null));
    }

    @Test(timeout = 4000)
    public void test14() throws Throwable {
        Moment moment0 = Moment.valueOf((-824L));
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((BigDecimal) null);

        Assert.assertNotNull(moment0.subtract(formulaDecimal0));
    }

    @Test(timeout = 4000)
    public void test15() throws Throwable {

        Assert.assertNotNull(Moment.parseDate((CharSequence) null));
    }

    @Test(timeout = 4000)
    public void test16() throws Throwable {
        StringWriter stringWriter0 = new StringWriter(13);
        StringBuffer stringBuffer0 = stringWriter0.getBuffer();

        Assert.assertNotNull(Moment.parseDate(stringBuffer0));
    }

    @Test(timeout = 4000)
    public void test17() throws Throwable {
        Moment moment0 = Moment.valueOf((-1L));

        moment0.add((FormulaDecimal) null);
        Assert.assertNotNull(moment0);
    }

    @Test(timeout = 4000)
    public void test18() throws Throwable {
        Moment moment0 = new Moment(0L);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-1570.3552463));

        moment0.add(formulaDecimal0);
        Assert.assertNotNull(moment0);
    }

    @Test(timeout = 4000)
    public void test19() throws Throwable {
        Moment moment0 = null;
        moment0 = new Moment((Date) null);
        Assert.assertNotNull(moment0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test20() throws Throwable {
        char[] charArray0 = new char[1];
        charArray0[0] = '-';
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);

        Moment.valueOf((CharSequence) charBuffer0);
    }

    @Test(timeout = 4000)
    public void test22() throws Throwable {
        Date Date0 = new Date((-2955), (-2955), (-2955), 1, 16);
        Moment moment0 = new Moment(Date0);
        Number number0 = moment0.year();
        assertEquals(1311, number0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test23() throws Throwable {
        char[] charArray0 = new char[20];
        charArray0[0] = '-';
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);

        Moment.valueOf((CharSequence) charBuffer0);
    }

    @Test(timeout = 4000)
    public void test24() throws Throwable {
        Moment moment0 = Moment.valueOf(1L);
        Moment moment1 = Moment.valueOf((Date) moment0);
//        assertEquals("Thu Jan 01 01:00:00 GMT 1970", moment1.toString());
        assertSame(moment1, moment0);
    }

    @Test(timeout = 4000)
    public void test25() throws Throwable {

        Moment.valueOf((Date) null);
    }

    @Test(timeout = 4000)
    public void test29() throws Throwable {
        Moment moment0 = Moment.valueOf(1L);
        Number number0 = moment0.month();
        assertEquals(1, number0);
    }

    @Test(timeout = 4000)
    public void test30() throws Throwable {
        Moment moment0 = Moment.valueOf(0, 0, 0, 0, 0);
        Number number0 = moment0.minute();
        assertEquals(0, number0);
    }

    @Test(timeout = 4000)
    public void test31() throws Throwable {
        Moment moment0 = Moment.valueOf(0, 0, 0, 0, 0);
        Number number0 = moment0.second();
        assertEquals(0, number0);
    }

    @Test(timeout = 4000)
    public void test36() throws Throwable {
        Moment moment0 = new Moment((-866L));
        Number number0 = moment0.week();
        assertEquals(1, number0);
    }

    @Test(timeout = 4000)
    public void test37() throws Throwable {
        Moment moment0 = Moment.valueOf(1L);
        Number number0 = moment0.day();
        assertEquals(1, number0);
    }

    @Test(timeout = 4000)
    public void test41() throws Throwable {
        Moment moment0 = new Moment();
        Assert.assertNotNull(moment0);
    }
}
