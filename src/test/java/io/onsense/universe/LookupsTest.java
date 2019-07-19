package io.onsense.universe;

import org.junit.Before;
import org.junit.Test;

import java.nio.CharBuffer;
import java.util.Date;

import static org.junit.Assert.assertFalse;

/**
 * @author Koen Rooijmans
 */
public class LookupsTest {

    @Before
    public void setUp() throws Exception {
        System.setProperty("user.timezone", "UTC");
    }

    @Test(timeout = 4000)
    public void test05() throws Throwable {
        Short short0 = new Short((short) 1);
        Date Date0 = new Date((short) 1, (short) 2037, (-1899), 0, 1);
        Date[] dateArray0 = new Date[0];
        ExpressionString expressionString0 = Lookups.choose((Number) short0, (Date) Date0, dateArray0);
        assertFalse(expressionString0.isEmpty());
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test11() throws Throwable {

        Lookups.match((CharSequence) "!Z\"Fsk'}3AQyf", (Number[]) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test13() throws Throwable {
        String string0 = null;
        Number[] numberArray0 = new Number[0];

        Lookups.match((CharSequence) string0, numberArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test16() throws Throwable {
        Double double0 = new Double(0.0);
        Date Date0 = new Date((-1), (-1), (-1), 0, (-1182), (-1182));
        Date[] dateArray0 = new Date[1];

        Lookups.choose((Number) double0, (Date) Date0, dateArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test17() throws Throwable {
        Integer integer0 = new Integer((-1));

        Lookups.choose((Number) integer0, (Number) integer0, (Number[]) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test18() throws Throwable {
        Byte byte0 = new Byte((byte) 12);
        Number[] numberArray0 = new Number[7];

        Lookups.choose((Number) byte0, (Number) byte0, numberArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test19() throws Throwable {
        Long long0 = new Long(264L);
        char[] charArray0 = new char[1];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        CharSequence[] charSequenceArray0 = new CharSequence[0];

        Lookups.choose((Number) long0, (CharSequence) charBuffer0, charSequenceArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test20() throws Throwable {
        Float float0 = new Float((double) 21);
        Logical logical0 = Logical.valueOf(false);

        Lookups.choose((Number) float0, logical0, (Logical[]) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test21() throws Throwable {
        Long long0 = new Long(0L);
        Logical logical0 = Logical.valueOf(false);
        Logical[] logicalArray0 = new Logical[0];

        Lookups.choose((Number) long0, logical0, logicalArray0);
    }


    @Test(timeout = 4000)
    public void test47() throws Throwable {
        Lookups lookups0 = new Lookups();
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test56() throws Throwable {
        Date Date0 = new Date((-1297L));
        Date[] dateArray0 = new Date[6];

        Lookups.choose((Number) null, (Date) Date0, dateArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test63() throws Throwable {
        String[] stringArray0 = new String[2];

        Lookups.choose((Number) null, (CharSequence) null, (CharSequence[]) stringArray0);
    }

    @Test(timeout = 4000)
    public void test69() throws Throwable {
        Byte byte0 = new Byte((byte) 12);
        Number[] numberArray0 = new Number[12];

        Lookups.choose((Number) byte0, (Number) byte0, numberArray0);
    }
}
