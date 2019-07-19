package io.onsense.universe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.*;

/**
 * @author Koen Rooijmans
 */
public class UniversalsTest {

    @Before
    public void setUp() throws Exception {
        System.setProperty("user.timezone", "UTC");
    }

    @Test(timeout = 4000)
    public void test00() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((BigDecimal) null);
        BigDecimal bigDecimal0 = Universals.universal((Number) formulaDecimal0);
        assertNotNull(bigDecimal0);
    }

    @Test(timeout = 4000)
    public void test01() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal((-492));
        BigDecimal bigDecimal1 = Universals.universal((Number) bigDecimal0);
        assertSame(bigDecimal0, bigDecimal1);
    }

    @Test(timeout = 4000)
    public void test02() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal(2196.708302303596);
        BigDecimal bigDecimal1 = Universals.universal((Number) bigDecimal0);
        assertSame(bigDecimal1, bigDecimal0);
    }

    @Test(timeout = 4000)
    public void test03() throws Throwable {
        ExpressionString expressionString0 = new ExpressionString((String) null);
        String string0 = Universals.universal((CharSequence) expressionString0);
        assertNotNull(string0);
    }

    @Test(timeout = 4000)
    public void test04() throws Throwable {
        Boolean boolean0 = Universals.universal((Boolean) null);
        assertNull(boolean0);
    }

    @Test(timeout = 4000)
    public void test05() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        Boolean boolean1 = Universals.universal(boolean0);
        assertTrue(boolean1);
    }

    @Ignore
    @Test(timeout = 4000)
    public void test06() throws Throwable {
        Moment moment0 = Moment.valueOf((-1L));
        Date date0 = Universals.universal(moment0);
//        assertEquals("Wed Dec 31 23:59:59 GMT 1969", date0.toString());
        assertEquals("Thu Jan 01 00:59:59 CET 1970", date0.toString());
    }

    @Test(timeout = 4000)
    public void test07() throws Throwable {
        Logical logical0 = Logical.valueOf(false);
        Boolean boolean0 = Universals.universal(logical0);
        assertFalse(boolean0);
    }

    @Test(timeout = 4000)
    public void test08() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((BigDecimal) null);
        BigDecimal bigDecimal0 = Universals.universal(formulaDecimal0);
        assertNotNull(bigDecimal0);
    }

    @Test(timeout = 4000)
    public void test09() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);
        BigDecimal bigDecimal0 = Universals.universal(formulaDecimal0);
        assertEquals((short) 1, bigDecimal0.shortValue());
    }

    @Test(timeout = 4000)
    public void test10() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-1.0));
        BigDecimal bigDecimal0 = Universals.universal(formulaDecimal0);
        assertEquals((byte) (-1), bigDecimal0.byteValue());
    }

    @Test(timeout = 4000)
    public void test11() throws Throwable {
        ExpressionString expressionString0 = new ExpressionString((String) null);
        String string0 = Universals.universal(expressionString0);
        assertNotNull(string0);
    }

    @Test(timeout = 4000)
    public void test12() throws Throwable {
        Locale locale0 = Locale.FRANCE;
        ExpressionString expressionString0 = ExpressionString.format(locale0, "uTKi\"", (Object[]) null);
        String string0 = Universals.universal(expressionString0);
        assertEquals("uTKi\"", string0);
    }

    @Test(timeout = 4000)
    public void test13() throws Throwable {
        Assert.assertNull(Universals.universal((Date) null));
    }

    @Test(timeout = 4000)
    public void test14() throws Throwable {
        Byte byte0 = new Byte((byte) 10);
        Universals.universal((Number) byte0);
    }

    @Test(timeout = 4000)
    public void test15() throws Throwable {
        Assert.assertNull(Universals.universal((CharSequence) null));
    }

    @Test(timeout = 4000)
    public void test16() throws Throwable {
        Assert.assertNull(Universals.universal((Logical) null));

    }

    @Test(timeout = 4000)
    public void test17() throws Throwable {
        Assert.assertNull(Universals.universal((FormulaDecimal) null));

    }

    @Test(timeout = 4000)
    public void test18() throws Throwable {
        Assert.assertNull(Universals.universal((ExpressionString) null));
    }

    @Test(timeout = 4000)
    public void test19() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0.0);
        BigDecimal bigDecimal0 = Universals.universal(formulaDecimal0);
        assertEquals((byte) 0, bigDecimal0.byteValue());
    }

    @Ignore
    @Test(timeout = 4000)
    public void test20() throws Throwable {
        Moment moment0 = Moment.valueOf((-1L));
        Date date0 = Universals.universal((Date) moment0);
//        assertEquals("Wed Dec 31 23:59:59 GMT 1969", date0.toString());
        assertEquals("Wed Dec 31 23:59:59 UTC 1969", date0.toString());

    }

    @Test(timeout = 4000)
    public void test21() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(false);
        String string0 = Universals.universal((CharSequence) expressionString0);
        assertEquals("false", string0);
    }

    @Test(timeout = 4000)
    public void test22() throws Throwable {
        String string0 = Universals.universal((CharSequence) "");
        assertEquals("", string0);
    }

    @Test(timeout = 4000)
    public void test23() throws Throwable {
        Universals universals0 = new Universals();
        Assert.assertNotNull(universals0);
    }

    @Test(timeout = 4000)
    public void test24() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(0L);
        BigDecimal bigDecimal0 = Universals.universal((Number) formulaDecimal0);
        BigDecimal bigDecimal1 = Universals.universal((Number) bigDecimal0);
        assertEquals((byte) 0, bigDecimal1.byteValue());
    }

    @Test(timeout = 4000)
    public void test25() throws Throwable {
        Assert.assertNull(Universals.universal((Moment) null));
    }

    @Test(timeout = 4000)
    public void test26() throws Throwable {
        char[] charArray0 = new char[0];
        ExpressionString expressionString0 = ExpressionString.copyValueOf(charArray0);
        String string0 = Universals.universal(expressionString0);
        assertEquals("", string0);
    }

    @Test(timeout = 4000)
    public void test27() throws Throwable {
        Logical logical0 = Logical.TRUE;
        Boolean boolean0 = Universals.universal(logical0);
        assertTrue(boolean0);
    }

    @Test(timeout = 4000)
    public void test28() throws Throwable {
        Boolean boolean0 = Boolean.valueOf("io.onsense.universe.FormulaDecimal");
        Boolean boolean1 = Universals.universal(boolean0);
        assertFalse(boolean1);
    }

    @Test
    public void test29() {
        Assert.assertNull(Universals.universal((Number) null));
    }

    @Test
    public void test30() {
        final Date mockDate = new Date();
        Assert.assertEquals(mockDate.getTime(), Universals.universal(mockDate).getTime());
        Assert.assertEquals(mockDate.getTime(), Universals.universal(Moment.valueOf(mockDate)).getTime());
    }
}
