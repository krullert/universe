package io.onsense.universe;

import org.junit.Before;
import org.junit.Test;

import java.io.StringWriter;
import java.nio.CharBuffer;
import java.util.Date;

import static org.junit.Assert.*;


/**
 * @author Koen Rooijmans
 */
public class InformationsTest {

    @Before
    public void setUp() throws Exception {
        System.setProperty("user.timezone", "UTC");
    }

    @Test(timeout = 4000)
    public void test00() throws Throwable {
        Boolean boolean0 = Boolean.valueOf("filename");
        FormulaDecimal formulaDecimal0 = Informations.n(boolean0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test01() throws Throwable {
        char[] charArray0 = new char[0];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        Logical logical0 = Informations.isText(charBuffer0);
        assertTrue(logical0.booleanValue());
    }

    @Test(timeout = 4000)
    public void test02() throws Throwable {
        Boolean boolean0 = Boolean.valueOf("io.onsense.universe.Logical");
        FormulaDecimal formulaDecimal0 = Informations.type(boolean0);
        Logical logical0 = Informations.isNumber(formulaDecimal0);
        assertEquals("true", logical0.toString());
    }

    @Test(timeout = 4000)
    public void test03() throws Throwable {
        ExpressionString expressionString0 = Informations.na();
        Informations.isNa(expressionString0);
        assertEquals(4, expressionString0.length());
        assertEquals("#N/A", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test04() throws Throwable {
        Float float0 = new Float((-1.0));

        Informations.type((Object) float0, (Object[]) null);
    }

    @Test(timeout = 4000)
    public void test05() throws Throwable {

        Informations.type((Boolean) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test06() throws Throwable {

        Informations.n((Date) null);
    }

    @Test(timeout = 4000)
    public void test07() throws Throwable {

        Informations.n((Number) null);
    }

    @Test(timeout = 4000)
    public void test08() throws Throwable {

        Informations.n((CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test09() throws Throwable {

        Informations.n((Logical) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test10() throws Throwable {

        Informations.info((CharSequence) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test11() throws Throwable {

        Informations.errorType((CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test13() throws Throwable {
        FormulaDecimal formulaDecimal0 = Informations.type((Logical) null);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test15() throws Throwable {
        Integer integer0 = new Integer(2443);
        Object[] objectArray0 = new Object[0];
        Logical logical0 = Informations.isErr(integer0);
        FormulaDecimal formulaDecimal0 = Informations.type((Object) logical0, objectArray0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test16() throws Throwable {
        Object[] objectArray0 = new Object[7];
        FormulaDecimal formulaDecimal0 = Informations.type((Object) "address", objectArray0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test17() throws Throwable {
        Integer integer0 = new Integer(2443);
        Object[] objectArray0 = new Object[0];
        FormulaDecimal formulaDecimal0 = Informations.type((Object) integer0, objectArray0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test18() throws Throwable {
        Float float0 = new Float(2730.4646F);
        Logical logical0 = Informations.isErr(float0);
        FormulaDecimal formulaDecimal0 = Informations.n(logical0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test19() throws Throwable {
        Object object0 = new Object();
        Logical logical0 = Informations.isOdd(object0);
        assertEquals("false", logical0.toString());
    }

    @Test(timeout = 4000)
    public void test20() throws Throwable {
        String string0 = "address";
        Logical logical0 = Informations.isNonText(string0);
        assertEquals("false", logical0.toString());
    }

    @Test(timeout = 4000)
    public void test21() throws Throwable {
        Logical logical0 = Informations.isLogical("azg");
        assertFalse(logical0.booleanValue());
    }

    @Test(timeout = 4000)
    public void test22() throws Throwable {
        Logical logical0 = Logical.valueOf("azg");
        Logical logical1 = Informations.isLogical(logical0);
        assertTrue(logical1.booleanValue());
    }

    @Test(timeout = 4000)
    public void test23() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        Logical logical0 = Informations.isLogical(boolean0);
        assertTrue(logical0.booleanValue());
    }

    @Test(timeout = 4000)
    public void test24() throws Throwable {
        Byte byte0 = new Byte((byte) 0);

        Informations.isEven(byte0);
    }

    @Test(timeout = 4000)
    public void test25() throws Throwable {
        Logical logical0 = Informations.isEven("azg");
        assertEquals("false", logical0.toString());
    }

    @Test(timeout = 4000)
    public void test26() throws Throwable {
        ExpressionString expressionString0 = Informations.na();
        Logical logical0 = Informations.isBlank(expressionString0);
        //  // Unstable assertion: assertEquals("true", logical0.toString());
        //  // Unstable assertion: assertEquals("#N/A", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test27() throws Throwable {
        Logical logical0 = Informations.isBlank((Object) null);
        Informations.n(logical0);
        assertTrue(logical0.booleanValue());
        assertEquals("true", logical0.toString());
    }

    @Test(timeout = 4000)
    public void test28() throws Throwable {
        Boolean boolean0 = Boolean.valueOf(false);
        Logical logical0 = Informations.isBlank(boolean0);
        assertFalse(logical0.booleanValue());
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test30() throws Throwable {
        StringWriter stringWriter0 = new StringWriter();
        StringBuffer stringBuffer0 = stringWriter0.getBuffer();
        FormulaDecimal formulaDecimal0 = Informations.errorType(stringBuffer0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test31() throws Throwable {
        ExpressionString expressionString0 = Informations.na();
        Informations.errorType(expressionString0);
        assertFalse(expressionString0.isEmpty());
        assertEquals("#N/A", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test36() throws Throwable {
        Informations informations0 = new Informations();
        Logical logical0 = Informations.isNumber(informations0);
        assertFalse(logical0.booleanValue());
    }

    @Test(timeout = 4000)
    public void test37() throws Throwable {
        Short short0 = new Short((short) 12);

        Informations.isOdd((Number) short0);
    }

    @Test(timeout = 4000)
    public void test38() throws Throwable {
        FormulaDecimal formulaDecimal0 = Informations.n((CharSequence) "");
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test39() throws Throwable {

        Informations.n((Boolean) null);
    }

    @Test(timeout = 4000)
    public void test43() throws Throwable {
        Logical logical0 = Informations.isError((Object) null);
        assertEquals("false", logical0.toString());
    }

    @Test(timeout = 4000)
    public void test45() throws Throwable {
        Boolean boolean0 = new Boolean("");
        FormulaDecimal formulaDecimal0 = Informations.type(boolean0);
        FormulaDecimal formulaDecimal1 = Informations.type((Number) formulaDecimal0);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
    }

    @Test(timeout = 4000)
    public void test46() throws Throwable {
        Logical logical0 = Informations.isText((Object) null);
        assertEquals("false", logical0.toString());
    }

    @Test(timeout = 4000)
    public void test47() throws Throwable {
        Date Date0 = new Date((-1), 0, (-1), 0, 147351156);
        FormulaDecimal formulaDecimal0 = Informations.n((Date) Date0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test48() throws Throwable {
        ExpressionString expressionString0 = Informations.na();
        Informations.type((CharSequence) expressionString0);
        assertFalse(expressionString0.isEmpty());
        assertEquals("#N/A", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test50() throws Throwable {
        Long long0 = new Long(0L);

        Informations.isOdd((Object) long0);
    }

    @Test(timeout = 4000)
    public void test52() throws Throwable {
        Date Date0 = new Date((-1), 0, (-1), 0, 147351156);
        Logical logical0 = Informations.isNa(Date0);
        assertFalse(logical0.booleanValue());
    }

    @Test(timeout = 4000)
    public void test53() throws Throwable {
        Float float0 = new Float((-1.0));
        FormulaDecimal formulaDecimal0 = Informations.n((Number) float0);
        assertNotNull(formulaDecimal0);
    }
}
