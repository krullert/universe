package io.onsense.universe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.CharBuffer;
import java.text.*;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Koen Rooijmans
 */
public class ExpressionsTest {

    @Before
    public void setUp() throws Exception {
        System.setProperty("user.timezone", "UTC");
    }

    @Test(timeout = 4000)
    public void test000() throws Throwable {
        Float float0 = new Float(3210.8275);
        Integer integer0 = new Integer(0);
        ExpressionString expressionString0 = Expressions.fixed((Number) float0, (Number) integer0);
        Expressions.initials((CharSequence) expressionString0);
        assertEquals("3,211", expressionString0.getDelegate());
        assertEquals(5, expressionString0.length());
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test001() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        ExpressionString expressionString0 = Expressions.t(boolean0);
        // Undeclared exception!
        Expressions.text((CharSequence) "se-FI", (CharSequence) expressionString0);
    }

    @Test(timeout = 4000)
    public void test002() throws Throwable {
        ExpressionString expressionString0 = Expressions.decode((CharSequence) null);
        ExpressionString expressionString1 = Expressions.capitalize(expressionString0);
        assertNotSame(expressionString0, expressionString1);
    }

    @Test(timeout = 4000)
    public void test003() throws Throwable {
        Long long0 = new Long(0L);
        Boolean boolean0 = Boolean.valueOf(false);
        ExpressionString expressionString0 = Expressions.fixed((Number) long0, (Number) long0, boolean0);
        ExpressionString expressionString1 = Expressions.encode(expressionString0);
        assertEquals(1, expressionString1.length());
    }

    @Test(timeout = 4000)
    public void test004() throws Throwable {
        Byte byte0 = new Byte((byte) 120);
        ExpressionString expressionString0 = Expressions.unichar(byte0);
        CharSequence[] charSequenceArray0 = new CharSequence[9];
        // Undeclared exception!
        Expressions.concatenate((CharSequence) expressionString0, charSequenceArray0);
    }

    @Test(timeout = 4000)
    public void test005() throws Throwable {
        Float float0 = new Float((-2010.6));
        ExpressionString expressionString0 = Expressions.dollar((Number) float0);
        ExpressionString expressionString1 = Expressions.quote(expressionString0);
        assertEquals(12, expressionString1.length());
    }

    @Test(timeout = 4000)
    public void test006() throws Throwable {
        Expressions expressions0 = new Expressions();
    }

    @Test(timeout = 4000)
    public void test007() throws Throwable {
        Short short0 = new Short((short) 133);
        ExpressionString expressionString0 = Expressions.proper((Number) short0);
        ExpressionString expressionString1 = Expressions.upper(expressionString0);
        assertTrue(expressionString1.equals((Object) expressionString0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test008() throws Throwable {
        Float float0 = new Float((-1.0F));
        ExpressionString expressionString0 = Expressions.unichar(float0);
        // Undeclared exception!
        Expressions.atob(expressionString0);
    }

    @Test(timeout = 4000)
    public void test009() throws Throwable {
        ExpressionString expressionString0 = Expressions.hex("");
        assertEquals("", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test010() throws Throwable {
        Float float0 = new Float(0.0F);
        ExpressionString expressionString0 = Expressions.dollar((Number) float0, (Number) float0);
        // Undeclared exception!
        Expressions.charr((CharSequence) expressionString0);
    }

    @Test(timeout = 4000)
    public void test011() throws Throwable {
        Long long0 = new Long(1156L);
        ExpressionString expressionString0 = Expressions.unichar(long0);
        ExpressionString expressionString1 = Expressions.swap(expressionString0);
        assertNotSame(expressionString0, expressionString1);
    }

    @Test(timeout = 4000)
    public void test012() throws Throwable {
        Float float0 = new Float(1.0F);
        ExpressionString expressionString0 = Expressions.unichar(float0);
        ExpressionString expressionString1 = Expressions.suffix(expressionString0, expressionString0);
        assertEquals(1, expressionString1.length());
    }

    @Test(timeout = 4000)
    public void test013() throws Throwable {
        Boolean boolean0 = Boolean.valueOf(false);
        ExpressionString expressionString0 = Expressions.proper(boolean0);
        Integer integer0 = new Integer(67);
        FormulaDecimal formulaDecimal0 = Expressions.find((CharSequence) expressionString0, (CharSequence) expressionString0, (Number) integer0);
        Number[] numberArray0 = new Number[9];
        FormulaDecimal formulaDecimal1 = Expressions.len((Number) formulaDecimal0, numberArray0);
        assertFalse(formulaDecimal1.equals((Object) formulaDecimal0));
    }

    @Test(timeout = 4000)
    public void test014() throws Throwable {
        Short short0 = new Short((short) 14);
        Boolean boolean0 = Boolean.valueOf(false);
        ExpressionString expressionString0 = Expressions.fixed((Number) short0, (Number) short0, boolean0);
        ExpressionString expressionString1 = Expressions.concat((CharSequence) expressionString0, (CharSequence) expressionString0);
        assertEquals(34, expressionString1.length());
    }

    @Test(timeout = 4000)
    public void test015() throws Throwable {
        Boolean boolean0 = Boolean.valueOf(false);
        ExpressionString expressionString0 = Expressions.proper(boolean0);
        // Undeclared exception!
        Expressions.exact(expressionString0, expressionString0);
    }

    @Test(timeout = 4000)
    public void test016() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        ExpressionString expressionString0 = Expressions.t(boolean0);
        // Undeclared exception!
        Expressions.left((CharSequence) expressionString0);
    }

    @Test(timeout = 4000)
    public void test017() throws Throwable {
        Short short0 = new Short((short) 133);
        ExpressionString expressionString0 = Expressions.proper((Number) short0);
        // Undeclared exception!
        Expressions.substring((CharSequence) expressionString0, (Number) short0, (Number) short0);
    }

    @Test(timeout = 4000)
    public void test018() throws Throwable {
        Short short0 = new Short((short) 133);
        ExpressionString expressionString0 = Expressions.proper((Number) short0);
        ExpressionString expressionString1 = Expressions.trim(expressionString0);
        assertFalse(expressionString1.isEmpty());
    }

    @Test(timeout = 4000)
    public void test019() throws Throwable {
        Float float0 = new Float(1.0F);
        ExpressionString expressionString0 = Expressions.unichar(float0);
        ExpressionString expressionString1 = Expressions.substring((CharSequence) expressionString0, (Number) float0);
        assertNotSame(expressionString0, expressionString1);
    }

    @Test(timeout = 4000)
    public void test020() throws Throwable {
        Boolean boolean0 = Boolean.valueOf(false);
        ExpressionString expressionString0 = Expressions.text(boolean0);
        FormulaDecimal formulaDecimal0 = Expressions.find((CharSequence) expressionString0, (CharSequence) expressionString0);
        ExpressionString expressionString1 = Expressions.replace((CharSequence) expressionString0, (Number) formulaDecimal0, (Number) formulaDecimal0, (CharSequence) expressionString0);
        assertEquals(9, expressionString1.length());
    }

    @Test(timeout = 4000)
    public void test021() throws Throwable {
        // Undeclared exception!
        Expressions.text((Date) null);
    }

    @Test(timeout = 4000)
    public void test022() throws Throwable {
        Short short0 = new Short((short) 0);
        Boolean boolean0 = Boolean.valueOf(false);
        ExpressionString expressionString0 = Expressions.fixed((Number) short0, (Number) short0, boolean0);
        ExpressionString expressionString1 = Expressions.format((Number) short0, (CharSequence) expressionString0);
        assertEquals("0", expressionString1.toString());
    }

    @Test(timeout = 4000)
    public void test023() throws Throwable {
        Float float0 = new Float(1.0F);
        Assert.assertNotNull(Expressions.concat((Number) float0, (Number) float0));
    }

    @Test(timeout = 4000)
    public void test024() throws Throwable {
        Long long0 = new Long(1593L);
        ExpressionString expressionString0 = Expressions.fixed((Number) long0, (Number) long0);
        FormulaDecimal formulaDecimal0 = Expressions.numbervalue((CharSequence) expressionString0, (CharSequence) expressionString0, (CharSequence) expressionString0);
        // Undeclared exception!
        Expressions.replace((CharSequence) expressionString0, (Number) formulaDecimal0, (Number) long0, (CharSequence) expressionString0);
    }

    @Test(timeout = 4000)
    public void test025() throws Throwable {
        Boolean boolean0 = Boolean.valueOf(false);
        ExpressionString expressionString0 = Expressions.proper(boolean0);
        ExpressionString expressionString1 = Expressions.removeLast(expressionString0, expressionString0);
        assertTrue(expressionString1.isEmpty());
    }

    @Test(timeout = 4000)
    public void test026() throws Throwable {
        Logical logical0 = Logical.valueOf("##0");
        CharSequence[] charSequenceArray0 = new CharSequence[3];
        // Undeclared exception!
        Expressions.concatenate(logical0, charSequenceArray0);
    }

    @Test(timeout = 4000)
    public void test027() throws Throwable {
        Long long0 = new Long(0L);
        Boolean boolean0 = Boolean.valueOf(false);
        ExpressionString expressionString0 = Expressions.fixed((Number) long0, (Number) long0, boolean0);
        Expressions.search((CharSequence) expressionString0, (CharSequence) expressionString0);
        assertEquals(1, expressionString0.length());
        assertEquals("0", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test028() throws Throwable {
        // Undeclared exception!
        Expressions.find((CharSequence) "tt-RU", (CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test029() throws Throwable {
        Short short0 = new Short((short) 133);
        ExpressionString expressionString0 = Expressions.proper((Number) short0);
        ExpressionString expressionString1 = Expressions.md2(expressionString0);
        assertEquals(32, expressionString1.length());
    }

    @Test(timeout = 4000)
    public void test030() throws Throwable {
        Byte byte0 = new Byte((byte) 120);
        ExpressionString expressionString0 = Expressions.unichar(byte0);
        ExpressionString expressionString1 = Expressions.decapitalizeFully((CharSequence) expressionString0, (CharSequence) expressionString0);
        assertFalse(expressionString1.isEmpty());
    }

    @Test(timeout = 4000)
    public void test031() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        ExpressionString expressionString0 = Expressions.t(boolean0);
        ExpressionString expressionString1 = Expressions.replace((CharSequence) expressionString0, (CharSequence) expressionString0, (CharSequence) expressionString0);
        assertSame(expressionString1, expressionString0);
    }

    @Test(timeout = 4000)
    public void test032() throws Throwable {
        Float float0 = new Float((-1090.0F));
        // Undeclared exception!
        Expressions.concatenate((Number) float0, (Logical[]) null);
    }

    @Test(timeout = 4000)
    public void test033() throws Throwable {
        Short short0 = new Short((short) (-1));
        ExpressionString expressionString0 = Expressions.fixed((Number) short0, (Number) short0);
        Expressions.code(expressionString0);
        assertEquals("0", expressionString0.getDelegate());
        assertEquals(1, expressionString0.length());
    }

    @Test(timeout = 4000)
    public void test034() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        ExpressionString expressionString0 = Expressions.t(boolean0);
        ExpressionString expressionString1 = Expressions.prefix(expressionString0, expressionString0);
        assertTrue(expressionString1.equals((Object) expressionString0));
    }

    @Test(timeout = 4000)
    public void test035() throws Throwable {
        Float float0 = new Float(0.0F);
        ExpressionString expressionString0 = Expressions.dollar((Number) float0, (Number) float0);
        ExpressionString expressionString1 = Expressions.decapitalizeFully((CharSequence) expressionString0);
        assertEquals("$0", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test036() throws Throwable {
        Long long0 = new Long(0L);
        Boolean boolean0 = Boolean.valueOf(false);
        ExpressionString expressionString0 = Expressions.fixed((Number) long0, (Number) long0, boolean0);
        Float float0 = new Float((double) 0L);
        ExpressionString expressionString1 = Expressions.random(expressionString0, float0);
        Expressions.trimLeft(expressionString1);
        assertEquals("0", expressionString0.getDelegate());
        assertEquals("0", expressionString0.toString());
    }

    @Test(timeout = 4000)
    public void test037() throws Throwable {
        Float float0 = new Float((-1.0F));
        ExpressionString expressionString0 = Expressions.unichar(float0);
        ExpressionString expressionString1 = Expressions.decapitalize(expressionString0);
        assertEquals("\uFFFF", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test038() throws Throwable {
        ExpressionString expressionString0 = Expressions.chop((CharSequence) null);
        ExpressionString expressionString1 = Expressions.crc32(expressionString0);
        // Undeclared exception!
        Expressions.numbervalue((CharSequence) expressionString1, (CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test039() throws Throwable {
        Short short0 = new Short((short) 7);
        ExpressionString expressionString0 = Expressions.proper((Number) short0);
        ExpressionString expressionString1 = Expressions.removeFirst((CharSequence) null, expressionString0);
        assertEquals("", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test040() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        ExpressionString expressionString0 = Expressions.t(boolean0);
        FormulaDecimal formulaDecimal0 = Expressions.unicode(expressionString0);
        ExpressionString expressionString1 = Expressions.right((CharSequence) expressionString0, (Number) formulaDecimal0);
        assertEquals("", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test041() throws Throwable {
        CharSequence[] charSequenceArray0 = new CharSequence[8];
        // Undeclared exception!
        Expressions.concatenate((Number) null, charSequenceArray0);
    }

    @Test(timeout = 4000)
    public void test042() throws Throwable {
        ExpressionString expressionString0 = Expressions.capitalizeFully((CharSequence) null);
        // Undeclared exception!
        Expressions.unquote(expressionString0);
    }

    @Test(timeout = 4000)
    public void test043() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        ExpressionString expressionString0 = Expressions.t(boolean0);
        FormulaDecimal formulaDecimal0 = Expressions.unicode(expressionString0);
        ExpressionString expressionString1 = Expressions.text((Number) formulaDecimal0, (CharSequence) expressionString0);
        ExpressionString expressionString2 = Expressions.prefix(expressionString1, expressionString1);
        assertTrue(expressionString2.equals((Object) expressionString1));
    }

    @Test(timeout = 4000)
    public void test044() throws Throwable {
        Long long0 = new Long(0L);
        Boolean boolean0 = Boolean.valueOf(false);
        ExpressionString expressionString0 = Expressions.fixed((Number) long0, (Number) long0, boolean0);
        ExpressionString expressionString1 = Expressions.right((CharSequence) expressionString0);
        assertEquals("0", expressionString1.toString());
    }

    @Test(timeout = 4000)
    public void test045() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        Logical logical0 = Logical.valueOf(boolean0);
        Number[] numberArray0 = new Number[3];
        ExpressionString expressionString0 = Expressions.concatenate(logical0, numberArray0);
        ExpressionString expressionString1 = Expressions.sha256(expressionString0);
        assertEquals("DFE88090C5ED7AC2F32571F0FC822FDA4D8CD281FC7138C7CD6DB656F6E2D081", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test046() throws Throwable {
        Long long0 = new Long(0L);
        Boolean boolean0 = Boolean.valueOf(false);
        ExpressionString expressionString0 = Expressions.fixed((Number) long0, (Number) long0, boolean0);
        ExpressionString expressionString1 = Expressions.format((CharSequence) expressionString0, (CharSequence) expressionString0);
        assertEquals("0", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test047() throws Throwable {
        // Undeclared exception!
        Expressions.text((Date) null, (CharSequence) "Requesed rndom string length ");
    }

    @Test(timeout = 4000)
    public void test048() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        ExpressionString expressionString0 = Expressions.t(boolean0);
        ExpressionString expressionString1 = Expressions.remove(expressionString0, expressionString0);
        assertTrue(expressionString1.isEmpty());
    }

    @Test(timeout = 4000)
    public void test049() throws Throwable {
        Short short0 = new Short((short) 133);
        ExpressionString expressionString0 = Expressions.proper((Number) short0);
        CharSequence charSequence0 = Expressions.reverse(expressionString0);
        assertEquals("331", charSequence0);
    }

    @Test(timeout = 4000)
    public void test050() throws Throwable {
        // Undeclared exception!
        Expressions.len((CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test051() throws Throwable {
        Short short0 = new Short((short) 0);
        Boolean boolean0 = Boolean.valueOf(false);
        ExpressionString expressionString0 = Expressions.fixed((Number) short0, (Number) short0, boolean0);
        ExpressionString expressionString1 = Expressions.replaceFirst(expressionString0, expressionString0, expressionString0);
        assertEquals("0", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test052() throws Throwable {
        Short short0 = new Short((short) (-1));
        ExpressionString expressionString0 = Expressions.fixed((Number) short0, (Number) short0);
        Expressions.initials((CharSequence) expressionString0, (CharSequence) expressionString0);
        assertEquals("0", expressionString0.getDelegate());
        assertEquals(1, expressionString0.length());
    }

    @Test(timeout = 4000)
    public void test053() throws Throwable {
        Logical[] logicalArray0 = new Logical[6];
        ExpressionString expressionString0 = Expressions.concatenate((Logical) null, logicalArray0);
        // Undeclared exception!
        Expressions.replace((CharSequence) expressionString0, (CharSequence) null, (CharSequence) expressionString0);
    }

    @Test(timeout = 4000)
    public void test054() throws Throwable {
        Long long0 = new Long(0L);
        Boolean boolean0 = Boolean.valueOf(false);
        ExpressionString expressionString0 = Expressions.fixed((Number) long0, (Number) long0, boolean0);
        ExpressionString expressionString1 = Expressions.lower(expressionString0);
        assertEquals("0", expressionString1.toString());
    }

    @Test(timeout = 4000)
    public void test055() throws Throwable {
        Long long0 = new Long(0L);
        Boolean boolean0 = Boolean.valueOf(false);
        ExpressionString expressionString0 = Expressions.fixed((Number) long0, (Number) long0, boolean0);
        ExpressionString expressionString1 = Expressions.capitalizeFully((CharSequence) expressionString0, (CharSequence) expressionString0);
        assertEquals(1, expressionString1.length());
    }

    @Test(timeout = 4000)
    public void test057() throws Throwable {
        Float float0 = new Float((-1.0F));
        // Undeclared exception!
        Expressions.dollar((Number) null, (Number) float0);
    }

    @Test(timeout = 4000)
    public void test058() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        ExpressionString expressionString0 = Expressions.t(boolean0);
        FormulaDecimal formulaDecimal0 = Expressions.unicode(expressionString0);
        Logical logical0 = new Logical(boolean0);
        ExpressionString expressionString1 = Expressions.fixed((Number) formulaDecimal0, (Number) formulaDecimal0, logical0);
        assertEquals("0", expressionString1.toString());
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test059() throws Throwable {
        ExpressionString expressionString0 = Expressions.proper((Number) null);
        // Undeclared exception!
        Expressions.mid(expressionString0, (Number) null, (Number) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test060() throws Throwable {
        Float float0 = new Float(0.0);
        ExpressionString expressionString0 = Expressions.charr((Number) float0);
        // Undeclared exception!
        Expressions.mid(expressionString0, float0, float0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test061() throws Throwable {
        Float float0 = new Float((-2010.6));
        ExpressionString expressionString0 = Expressions.dollar((Number) float0);
        FormulaDecimal formulaDecimal0 = Expressions.value(expressionString0);
        // Undeclared exception!
        Expressions.mid(expressionString0, formulaDecimal0, (Number) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test062() throws Throwable {
        Float float0 = new Float((-2010.6));
        ExpressionString expressionString0 = Expressions.dollar((Number) float0);
        FormulaDecimal formulaDecimal0 = Expressions.value(expressionString0);
        // Undeclared exception!
        Expressions.mid(expressionString0, formulaDecimal0, float0);
    }

    @Test(timeout = 4000)
    public void test063() throws Throwable {
        Float float0 = new Float(0.0F);
        ExpressionString expressionString0 = Expressions.dollar((Number) float0, (Number) float0);
        ExpressionString expressionString1 = Expressions.initials((CharSequence) expressionString0, (CharSequence) expressionString0);
        Byte byte0 = new Byte((byte) 0);
        FormulaDecimal formulaDecimal0 = Expressions.find((CharSequence) expressionString1, (CharSequence) expressionString0, (Number) byte0);
        Expressions.mid(expressionString1, formulaDecimal0, float0);
        assertEquals(2, expressionString0.length());
        assertEquals("$0", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test064() throws Throwable {
        FormulaDecimal formulaDecimal0 = Expressions.numbervalue((CharSequence) null);
        Boolean boolean0 = Boolean.valueOf("tt-RU");
        // Undeclared exception!
        Expressions.fixed((Number) null, (Number) formulaDecimal0, boolean0);
    }

    @Test(timeout = 4000)
    public void test065() throws Throwable {
        FormulaDecimal formulaDecimal0 = Expressions.numbervalue((CharSequence) "");
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test066() throws Throwable {
        FormulaDecimal formulaDecimal0 = Expressions.numbervalue((CharSequence) null, (CharSequence) null);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test067() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        ExpressionString expressionString0 = Expressions.t(boolean0);
        FormulaDecimal formulaDecimal0 = Expressions.numbervalue((CharSequence) expressionString0, (CharSequence) expressionString0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test068() throws Throwable {
        FormulaDecimal formulaDecimal0 = Expressions.numbervalue((CharSequence) null, (CharSequence) null, (CharSequence) null);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test069() throws Throwable {
        Logical logical0 = Logical.TRUE;
        Number[] numberArray0 = new Number[3];
        Short short0 = new Short((short) (-2996));
        numberArray0[0] = (Number) short0;
        ExpressionString expressionString0 = Expressions.concatenate(logical0, numberArray0);
        // Undeclared exception!
        Expressions.search((CharSequence) expressionString0, (CharSequence) expressionString0, numberArray0[0]);
    }

    @Test(timeout = 4000)
    public void test070() throws Throwable {
        Long long0 = new Long(0L);
        Boolean boolean0 = Boolean.valueOf(false);
        ExpressionString expressionString0 = Expressions.fixed((Number) long0, (Number) long0, boolean0);
        ExpressionString expressionString1 = Expressions.substitute((CharSequence) expressionString0, (CharSequence) expressionString0, (CharSequence) expressionString0);
        assertEquals("0", expressionString1.getDelegate());
        assertNotSame(expressionString1, expressionString0);
    }

    @Test(timeout = 4000)
    public void test071() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        ExpressionString expressionString0 = Expressions.t(boolean0);
        ExpressionString expressionString1 = Expressions.substitute((CharSequence) expressionString0, (CharSequence) expressionString0, (CharSequence) expressionString0);
        assertEquals("", expressionString1.toString());
    }

    @Test(timeout = 4000)
    public void test072() throws Throwable {
        Float float0 = new Float(1.0F);
        ExpressionString expressionString0 = Expressions.unichar(float0);
        ExpressionString expressionString1 = Expressions.substitute((CharSequence) expressionString0, (CharSequence) expressionString0, (CharSequence) expressionString0, (Number) float0);
        assertNotSame(expressionString1, expressionString0);
        assertEquals("\u0001", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test073() throws Throwable {
        Long long0 = new Long(1593L);
        ExpressionString expressionString0 = Expressions.fixed((Number) long0, (Number) long0);
        ExpressionString expressionString1 = Expressions.substitute((CharSequence) expressionString0, (CharSequence) expressionString0, (CharSequence) expressionString0, (Number) long0);
        assertEquals("1,593.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test074() throws Throwable {
        FormulaDecimal formulaDecimal0 = Expressions.unicode((CharSequence) null);
        // Undeclared exception!
        Expressions.random((CharSequence) null, formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test075() throws Throwable {
        FormulaDecimal formulaDecimal0 = Expressions.value((CharSequence) null);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test076() throws Throwable {
        Boolean boolean0 = Boolean.FALSE;
        ExpressionString expressionString0 = Expressions.t(boolean0);
        FormulaDecimal formulaDecimal0 = Expressions.value(expressionString0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test078() throws Throwable {
        ExpressionString expressionString0 = Expressions.text((CharSequence) " {**wgHm[*");
        ExpressionString expressionString1 = Expressions.ltrim(expressionString0);
        assertEquals(9, expressionString1.length());
    }

    @Test(timeout = 4000)
    public void test079() throws Throwable {
        ExpressionString expressionString0 = Expressions.trim((CharSequence) null);
        ExpressionString expressionString1 = Expressions.rtrim(expressionString0);
        assertEquals("", expressionString1.toString());
    }

    @Test(timeout = 4000)
    public void test080() throws Throwable {
        Short short0 = new Short((short) 0);
        Boolean boolean0 = Boolean.valueOf(false);
        ExpressionString expressionString0 = Expressions.fixed((Number) short0, (Number) short0, boolean0);
        ExpressionString expressionString1 = Expressions.replaceLast(expressionString0, expressionString0, expressionString0);
        assertNotSame(expressionString1, expressionString0);
        assertEquals("0", expressionString1.toString());
    }

    @Test(timeout = 4000)
    public void test081() throws Throwable {
        Short short0 = new Short((short) 14);
        Boolean boolean0 = Boolean.valueOf(false);
        ExpressionString expressionString0 = Expressions.fixed((Number) short0, (Number) short0, boolean0);
        Logical logical0 = Logical.FALSE;
        ExpressionString expressionString1 = Expressions.proper(logical0);
        Expressions.replaceLast(expressionString1, expressionString0, expressionString0);
        assertEquals("14.00000000000000", expressionString0.toString());
        assertEquals("14.00000000000000", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test082() throws Throwable {
        Double double0 = new Double(2562.9108592957614);
        // Undeclared exception!
        Expressions.left((CharSequence) null, (Number) double0);
    }

    @Test(timeout = 4000)
    public void test083() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        Logical logical0 = Logical.valueOf(boolean0);
        ExpressionString expressionString0 = Expressions.text(logical0);
        assertFalse(expressionString0.isEmpty());
    }

    @Test(timeout = 4000)
    public void test084() throws Throwable {
        ExpressionString expressionString0 = Expressions.t((CharSequence) null);
        assertEquals(0, expressionString0.length());
    }

    @Test(timeout = 4000)
    public void test085() throws Throwable {
        ExpressionString expressionString0 = Expressions.toUpperCase("2");
        assertFalse(expressionString0.isEmpty());
    }

    @Test(timeout = 4000)
    public void test086() throws Throwable {
        Short short0 = new Short((short) 33);
        ExpressionString expressionString0 = Expressions.dollar((Number) short0, (Number) short0);
        assertEquals("$33.000000000000000000000000000000000", expressionString0.toString());
    }

    @Test(timeout = 4000)
    public void test087() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        Logical logical0 = Logical.valueOf(boolean0);
        Number[] numberArray0 = new Number[3];
        Float float0 = new Float((double) (short) (-2996));
        // Undeclared exception!
        Expressions.fixed(numberArray0[1], (Number) float0, logical0);
    }

    @Test(timeout = 4000)
    public void test088() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        Logical logical0 = Logical.valueOf(boolean0);
        Number[] numberArray0 = new Number[3];
        ExpressionString expressionString0 = Expressions.concatenate(logical0, numberArray0);
        // Undeclared exception!
        Expressions.search((CharSequence) expressionString0, (CharSequence) expressionString0, numberArray0[0]);
    }

    @Test(timeout = 4000)
    public void test089() throws Throwable {
        Boolean boolean0 = new Boolean(true);
        ExpressionString expressionString0 = Expressions.text(boolean0);
        ExpressionString expressionString1 = Expressions.trimLeft(expressionString0);
        assertEquals(4, expressionString1.length());
    }

    @Test(timeout = 4000)
    public void test090() throws Throwable {
        Short short0 = new Short((short) 0);
        Logical logical0 = Logical.FALSE;
        ExpressionString expressionString0 = Expressions.fixed((Number) short0, (Number) short0, logical0);
        ExpressionString expressionString1 = Expressions.trimRight(expressionString0);
        assertEquals("0", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test092() throws Throwable {
        // Undeclared exception!
        Expressions.capitalizeFully((CharSequence) null, (CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test093() throws Throwable {
        // Undeclared exception!
        Expressions.charr((Number) null);
    }

    @Test(timeout = 4000)
    public void test094() throws Throwable {
        // Undeclared exception!
        Expressions.code((CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test095() throws Throwable {
        ExpressionString expressionString0 = Expressions.encode((CharSequence) null);
        // Undeclared exception!
        Expressions.concat((CharSequence) expressionString0, (CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test096() throws Throwable {
        // Undeclared exception!
        Expressions.concat((Number) null, (Number) null);
    }

    @Test(timeout = 4000)
    public void test097() throws Throwable {
        Logical logical0 = new Logical((Boolean) null);
        // Undeclared exception!
        Expressions.concatenate(logical0, (Logical[]) null);
    }

    @Test(timeout = 4000)
    public void test098() throws Throwable {
        Logical logical0 = Logical.FALSE;
        // Undeclared exception!
        Expressions.concatenate(logical0, (Number[]) null);
    }

    @Test(timeout = 4000)
    public void test099() throws Throwable {
        Float float0 = new Float(1178.78181725);
        Logical logical0 = Logical.FALSE;
        ExpressionString expressionString0 = Expressions.fixed((Number) float0, (Number) float0, logical0);
        // Undeclared exception!
        Expressions.concatenate((CharSequence) expressionString0, (Logical[]) null);
    }

    @Test(timeout = 4000)
    public void test100() throws Throwable {
        // Undeclared exception!
        Expressions.concatenate((CharSequence) null, (Number[]) null);
    }

    @Test(timeout = 4000)
    public void test101() throws Throwable {
        Double double0 = new Double(1.0);
        // Undeclared exception!
        Expressions.concatenate((Number) double0, (Number[]) null);
    }

    @Test(timeout = 4000)
    public void test102() throws Throwable {
        // Undeclared exception!
        Expressions.decapitalizeFully((CharSequence) null, (CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test103() throws Throwable {
        // Undeclared exception!
        Expressions.dollar((Number) null);
    }

    @Test(timeout = 4000)
    public void test104() throws Throwable {
        Float float0 = new Float(0.0F);
        // Undeclared exception!
        Expressions.dollar((Number) null, (Number) float0);
    }

    @Test(timeout = 4000)
    public void test105() throws Throwable {
        Short short0 = new Short((short) (-2775));
        // Undeclared exception!
        Expressions.dollar((Number) short0, (Number) short0);
    }

    @Test(timeout = 4000)
    public void test106() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        ExpressionString expressionString0 = Expressions.text(boolean0);
        Byte byte0 = new Byte((byte) 1);
        // Undeclared exception!
        Expressions.find((CharSequence) expressionString0, (CharSequence) null, (Number) byte0);
    }

    @Test(timeout = 4000)
    public void test107() throws Throwable {
        // Undeclared exception!
        Expressions.fixed((Number) null);
    }

    @Test(timeout = 4000)
    public void test108() throws Throwable {
        Number[] numberArray0 = new Number[3];
        // Undeclared exception!
        Expressions.fixed(numberArray0[1], (Number) null);
    }

    @Test(timeout = 4000)
    public void test109() throws Throwable {
        Float float0 = new Float((-451.2755F));
        // Undeclared exception!
        Expressions.fixed((Number) float0, (Number) float0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test110() throws Throwable {
        Float float0 = new Float((-2010.6));
        ExpressionString expressionString0 = Expressions.dollar((Number) float0);
        FormulaDecimal formulaDecimal0 = Expressions.value(expressionString0);
        // Undeclared exception!
        Expressions.fixed((Number) formulaDecimal0, (Number) formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test111() throws Throwable {
        Short short0 = new Short((short) 133);
        Boolean boolean0 = Boolean.TRUE;
        Logical logical0 = Logical.valueOf(boolean0);
        Number[] numberArray0 = new Number[3];
        numberArray0[0] = (Number) short0;
        // Undeclared exception!
        Expressions.fixed(numberArray0[2], numberArray0[0], logical0);
    }

    @Test(timeout = 4000)
    public void test112() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        Logical logical0 = Logical.valueOf(boolean0);
        Number[] numberArray0 = new Number[3];
        Float float0 = new Float((double) (short) (-2996));
        numberArray0[2] = (Number) float0;
        // Undeclared exception!
        Expressions.fixed(numberArray0[2], (Number) float0, logical0);
    }

    @Test(timeout = 4000)
    public void test113() throws Throwable {
        Byte byte0 = new Byte((byte) (-45));
        Boolean boolean0 = new Boolean("");
        // Undeclared exception!
        Expressions.fixed((Number) byte0, (Number) null, boolean0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test114() throws Throwable {
        Float float0 = new Float(1.0E11);
        Boolean boolean0 = new Boolean(true);
        // Undeclared exception!
        Expressions.fixed((Number) float0, (Number) float0, boolean0);
    }

    @Test(timeout = 4000)
    public void test115() throws Throwable {
        Float float0 = new Float((-3596.6897F));
        Boolean boolean0 = Boolean.valueOf(">ubn0vCA!");
        // Undeclared exception!
        Expressions.fixed((Number) float0, (Number) float0, boolean0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test116() throws Throwable {
        Double double0 = new Double(8.64E7);
        Boolean boolean0 = Boolean.valueOf("");
        // Undeclared exception!
        Expressions.fixed((Number) double0, (Number) double0, boolean0);
    }

    @Test(timeout = 4000)
    public void test117() throws Throwable {
        Boolean boolean0 = Boolean.valueOf(false);
        ExpressionString expressionString0 = Expressions.proper(boolean0);
        // Undeclared exception!
        Expressions.format((CharSequence) expressionString0, (CharSequence) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test118() throws Throwable {
        Long long0 = new Long(1593L);
        ExpressionString expressionString0 = Expressions.fixed((Number) long0, (Number) long0);
        // Undeclared exception!
        Expressions.format((Number) long0, (CharSequence) expressionString0);
    }

    @Test(timeout = 4000)
    public void test119() throws Throwable {
        Float float0 = new Float(653.86F);
        // Undeclared exception!
        Expressions.format((Number) float0, (CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test120() throws Throwable {
        Float float0 = new Float(3210.8275);
        Integer integer0 = new Integer(0);
        ExpressionString expressionString0 = Expressions.fixed((Number) float0, (Number) integer0);
        ExpressionString expressionString1 = Expressions.repeat(expressionString0, float0);
        // Undeclared exception!
        Expressions.initials((CharSequence) expressionString1);
    }

    @Test(timeout = 4000)
    public void test121() throws Throwable {
        // Undeclared exception!
        Expressions.initials((CharSequence) null, (CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test122() throws Throwable {
        char[] charArray0 = new char[1];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        charBuffer0.get();
        // Undeclared exception!
        Expressions.left((CharSequence) charBuffer0);
    }

    @Test(timeout = 4000)
    public void test123() throws Throwable {
        // Undeclared exception!
        Expressions.left((CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test124() throws Throwable {
        Float float0 = new Float(1.0F);
        ExpressionString expressionString0 = Expressions.t((Number) float0);
        // Undeclared exception!
        Expressions.left((CharSequence) expressionString0, (Number) float0);
    }

    @Test(timeout = 4000)
    public void test125() throws Throwable {
        Integer integer0 = new Integer(2968);
        // Undeclared exception!
        Expressions.len((Number) integer0, (Number[]) null);
    }

    @Test(timeout = 4000)
    public void test126() throws Throwable {
        // Undeclared exception!
        Expressions.ltrim((CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test127() throws Throwable {
        Short short0 = new Short((short) 2603);
        // Undeclared exception!
        Expressions.mid((CharSequence) null, short0, short0);
    }

    @Test(timeout = 4000)
    public void test128() throws Throwable {
        Boolean boolean0 = Boolean.valueOf("s=^59>Xn{");
        ExpressionString expressionString0 = Expressions.text(boolean0);
        // Undeclared exception!
        Expressions.numbervalue((CharSequence) expressionString0);
    }

    @Test(timeout = 4000)
    public void test129() throws Throwable {
        Float float0 = new Float(2266.030158);
        ExpressionString expressionString0 = Expressions.dollar((Number) float0);
        // Undeclared exception!
        Expressions.numbervalue((CharSequence) expressionString0, (CharSequence) "3030.6622");
    }

    @Test(timeout = 4000)
    public void test130() throws Throwable {
        Float float0 = new Float(0.0F);
        ExpressionString expressionString0 = Expressions.dollar((Number) float0, (Number) float0);
        ExpressionString expressionString1 = Expressions.initials((CharSequence) expressionString0, (CharSequence) expressionString0);
        // Undeclared exception!
        Expressions.numbervalue((CharSequence) expressionString0, (CharSequence) expressionString1);
    }

    @Test(timeout = 4000)
    public void test131() throws Throwable {
        Boolean boolean0 = Boolean.valueOf("");
        ExpressionString expressionString0 = Expressions.text(boolean0);
        // Undeclared exception!
        Expressions.numbervalue((CharSequence) expressionString0, (CharSequence) expressionString0, (CharSequence) expressionString0);
    }

    @Test(timeout = 4000)
    public void test132() throws Throwable {
        Number[] numberArray0 = new Number[3];
        ExpressionString expressionString0 = Expressions.concatenate((CharSequence) null, numberArray0);
        // Undeclared exception!
        Expressions.numbervalue((CharSequence) expressionString0, (CharSequence) expressionString0, (CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test133() throws Throwable {
        Float float0 = new Float(2266.030158);
        ExpressionString expressionString0 = Expressions.proper((Number) float0);
        FormulaDecimal formulaDecimal0 = Expressions.search((CharSequence) expressionString0, (CharSequence) expressionString0, (Number) float0);
        ExpressionString expressionString1 = Expressions.left((CharSequence) expressionString0, (Number) formulaDecimal0);
        // Undeclared exception!
        Expressions.numbervalue((CharSequence) expressionString0, (CharSequence) expressionString1, (CharSequence) expressionString0);
    }

    @Test(timeout = 4000)
    public void test134() throws Throwable {
        // Undeclared exception!
        Expressions.prefix((CharSequence) null, (CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test135() throws Throwable {
        char[] charArray0 = new char[4];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        ExpressionString expressionString0 = Expressions.replace((CharSequence) charBuffer0, (CharSequence) charBuffer0, (CharSequence) charBuffer0);
        Double double0 = new Double((-6564.384));
        // Undeclared exception!
        Expressions.random(expressionString0, double0);
    }

    @Test(timeout = 4000)
    public void test136() throws Throwable {
        // Undeclared exception!
        Expressions.remove((CharSequence) null, (CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test137() throws Throwable {
        // Undeclared exception!
        Expressions.removeFirst((CharSequence) null, (CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test138() throws Throwable {
        StringBuffer stringBuffer0 = new StringBuffer("@s[j%}uD\r");
        ExpressionString expressionString0 = Expressions.capitalize(stringBuffer0);
        // Undeclared exception!
        Expressions.removeFirst(expressionString0, "@s[j%}uD\r");
    }

    @Test(timeout = 4000)
    public void test139() throws Throwable {
        // Undeclared exception!
        Expressions.removeLast((CharSequence) null, (CharSequence) null);
    }

    @Test
    public void testRemoveFuncs() {
        Assert.assertEquals("1bruv2bruv3", Expressions.removeFirst("bruv1bruv2bruv3", "bruv").toString());
        Assert.assertEquals("bruv1bruv23", Expressions.removeLast("bruv1bruv2bruv3", "bruv").toString());
        Assert.assertEquals("123", Expressions.remove("bruv1bruv2bruv3", "bruv").toString());
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test140() throws Throwable {
        Logical logical0 = Logical.valueOf((String) null);
        ExpressionString expressionString0 = Expressions.proper(logical0);
        Integer integer0 = new Integer(25626);
        // Undeclared exception!
        Expressions.repeat(expressionString0, integer0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test141() throws Throwable {
        Short short0 = new Short((short) 1563);
        Boolean boolean0 = new Boolean("' gx");
        ExpressionString expressionString0 = Expressions.fixed((Number) short0, (Number) short0, boolean0);
        // Undeclared exception!
        Expressions.repeat(expressionString0, short0);
    }

    @Test(timeout = 4000)
    public void test142() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(0);
        Integer integer0 = new Integer(0);
        // Undeclared exception!
        Expressions.replace((CharSequence) charBuffer0, (Number) integer0, (Number) integer0, (CharSequence) charBuffer0);
    }

    @Test(timeout = 4000)
    public void test143() throws Throwable {
        ExpressionString expressionString0 = Expressions.md5((CharSequence) null);
        Short short0 = new Short((short) 1805);
        Float float0 = new Float(0.0);
        // Undeclared exception!
        Expressions.replace((CharSequence) null, (Number) short0, (Number) float0, (CharSequence) expressionString0);
    }

    @Test(timeout = 4000)
    public void test144() throws Throwable {
        // Undeclared exception!
        Expressions.replaceFirst((CharSequence) null, (CharSequence) null, (CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test145() throws Throwable {
        ExpressionString expressionString0 = Expressions.decode((CharSequence) null);
        // Undeclared exception!
        Expressions.replaceLast(expressionString0, (CharSequence) null, expressionString0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test146() throws Throwable {
        Short short0 = new Short((short) 17409);
        Number[] numberArray0 = new Number[5];
        numberArray0[3] = (Number) short0;
        ExpressionString expressionString0 = Expressions.concatenate((Number) short0, numberArray0);
        // Undeclared exception!
        Expressions.rept(expressionString0, numberArray0[3]);
    }

    @Test(timeout = 4000)
    public void test147() throws Throwable {
        // Undeclared exception!
        Expressions.right((CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test148() throws Throwable {
        Float float0 = new Float(1804.839317321);
        ExpressionString expressionString0 = Expressions.t((Number) float0);
        // Undeclared exception!
        Expressions.right((CharSequence) expressionString0);
    }

    @Test(timeout = 4000)
    public void test149() throws Throwable {
        Byte byte0 = new Byte((byte) (-117));
        // Undeclared exception!
        Expressions.right((CharSequence) null, (Number) byte0);
    }

    @Test(timeout = 4000)
    public void test150() throws Throwable {
        Logical logical0 = Logical.FALSE;
        Logical[] logicalArray0 = new Logical[6];
        ExpressionString expressionString0 = Expressions.concatenate(logical0, logicalArray0);
        Short short0 = new Short((short) 1632);
        // Undeclared exception!
        Expressions.right((CharSequence) expressionString0, (Number) short0);
    }

    @Test(timeout = 4000)
    public void test151() throws Throwable {
        // Undeclared exception!
        Expressions.rtrim((CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test152() throws Throwable {
        // Undeclared exception!
        Expressions.search((CharSequence) null, (CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test153() throws Throwable {
        Byte byte0 = new Byte((byte) 0);
        Logical logical0 = Logical.valueOf((Logical) null);
        ExpressionString expressionString0 = Expressions.fixed((Number) byte0, (Number) byte0, logical0);
        // Undeclared exception!
        Expressions.substitute((CharSequence) expressionString0, (CharSequence) null, (CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test154() throws Throwable {
        // Undeclared exception!
        Expressions.substring((CharSequence) "", (Number) null);
    }

    @Test(timeout = 4000)
    public void test155() throws Throwable {
        ExpressionString expressionString0 = Expressions.proper((CharSequence) null);
        Float float0 = new Float((-1.0));
        // Undeclared exception!
        Expressions.substring((CharSequence) expressionString0, (Number) float0);
    }

    @Test(timeout = 4000)
    public void test156() throws Throwable {
        Float float0 = new Float(543.1906F);
        ExpressionString expressionString0 = Expressions.dollar((Number) float0);
        FormulaDecimal formulaDecimal0 = Expressions.unicode(expressionString0);
        // Undeclared exception!
        Expressions.substring((CharSequence) expressionString0, (Number) formulaDecimal0, (Number) null);
    }

    @Test(timeout = 4000)
    public void test157() throws Throwable {
        // Undeclared exception!
        Expressions.suffix((CharSequence) null, (CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test158() throws Throwable {
        // Undeclared exception!
        Expressions.text((Logical) null);
    }

    @Test(timeout = 4000)
    public void test159() throws Throwable {
        // Undeclared exception!
        Expressions.text((CharSequence) null, (CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test160() throws Throwable {
        // Undeclared exception!
        Expressions.text((Number) null);
    }

    @Test(timeout = 4000)
    public void test161() throws Throwable {
        Short short0 = new Short((short) 120);
        // Undeclared exception!
        Expressions.text((Number) short0, (CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test163() throws Throwable {
        // Undeclared exception!
        Expressions.trimLeft((CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test164() throws Throwable {
        // Undeclared exception!
        Expressions.trimRight((CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test165() throws Throwable {
        // Undeclared exception!
        Expressions.unichar((Number) null);
    }

    @Test(timeout = 4000)
    public void test166() throws Throwable {
        Integer integer0 = new Integer(2052);
        ExpressionString expressionString0 = Expressions.fixed((Number) integer0);
        ExpressionString expressionString1 = Expressions.btoa(expressionString0);
        ExpressionString expressionString2 = Expressions.atob(expressionString1);
        assertEquals(8, expressionString2.length());
    }

    @Test(timeout = 4000)
    public void test167() throws Throwable {
        Double double0 = new Double((-870.06026));
        ExpressionString expressionString0 = Expressions.t((Number) double0);
        ExpressionString expressionString1 = Expressions.atob(expressionString0);
        assertEquals("", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test168() throws Throwable {
        StringBuffer stringBuffer0 = new StringBuffer(2086);
        CharBuffer charBuffer0 = CharBuffer.wrap((CharSequence) stringBuffer0);
        ExpressionString expressionString0 = Expressions.btoa(charBuffer0);
        assertTrue(expressionString0.isEmpty());
    }

    @Test(timeout = 4000)
    public void test169() throws Throwable {
        Boolean boolean0 = Boolean.FALSE;
        ExpressionString expressionString0 = Expressions.proper(boolean0);
        ExpressionString expressionString1 = Expressions.capitalizeFully((CharSequence) expressionString0);
        assertEquals("False", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test170() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        ExpressionString expressionString0 = Expressions.t(boolean0);
        ExpressionString expressionString1 = Expressions.capitalizeFully((CharSequence) expressionString0, (CharSequence) expressionString0);
        assertTrue(expressionString1.isEmpty());
    }

    @Test(timeout = 4000)
    public void test171() throws Throwable {
        Float float0 = new Float((-153.8251F));
        ExpressionString expressionString0 = Expressions.proper((Number) float0);
        ExpressionString expressionString1 = Expressions.chop(expressionString0);
        assertEquals("-153.825", expressionString1.toString());
    }

    @Test(timeout = 4000)
    public void test172() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        ExpressionString expressionString0 = Expressions.t(boolean0);
        ExpressionString expressionString1 = Expressions.concat((CharSequence) expressionString0, (CharSequence) expressionString0);
        assertSame(expressionString0, expressionString1);
    }

    @Test(timeout = 4000)
    public void test173() throws Throwable {
        Float float0 = new Float((-153.8251F));
        ExpressionString expressionString0 = Expressions.proper((Number) float0);
        Boolean boolean0 = new Boolean(false);
        Logical logical0 = Logical.valueOf(boolean0);
        CharSequence[] charSequenceArray0 = new CharSequence[1];
        charSequenceArray0[0] = (CharSequence) expressionString0;
        ExpressionString expressionString1 = Expressions.concatenate(logical0, charSequenceArray0);
        assertFalse(expressionString1.isEmpty());
    }

    @Test(timeout = 4000)
    public void test174() throws Throwable {
        Float float0 = new Float(1.0F);
        ExpressionString expressionString0 = Expressions.unichar(float0);
        CharSequence[] charSequenceArray0 = new CharSequence[8];
        charSequenceArray0[0] = (CharSequence) expressionString0;
        charSequenceArray0[1] = (CharSequence) expressionString0;
        charSequenceArray0[2] = (CharSequence) expressionString0;
        charSequenceArray0[3] = (CharSequence) expressionString0;
        charSequenceArray0[4] = (CharSequence) expressionString0;
        charSequenceArray0[5] = (CharSequence) expressionString0;
        charSequenceArray0[6] = (CharSequence) expressionString0;
        charSequenceArray0[7] = (CharSequence) expressionString0;
        ExpressionString expressionString1 = Expressions.concatenate((CharSequence) expressionString0, charSequenceArray0);
        assertFalse(expressionString1.isEmpty());
    }

    @Test(timeout = 4000)
    public void test175() throws Throwable {
        StringBuilder stringBuilder0 = new StringBuilder();
        CharSequence[] charSequenceArray0 = new CharSequence[5];
        charSequenceArray0[0] = (CharSequence) stringBuilder0;
        charSequenceArray0[1] = (CharSequence) stringBuilder0;
        charSequenceArray0[2] = (CharSequence) stringBuilder0;
        charSequenceArray0[3] = (CharSequence) stringBuilder0;
        charSequenceArray0[4] = (CharSequence) stringBuilder0;
        ExpressionString expressionString0 = Expressions.concatenate((CharSequence) stringBuilder0, charSequenceArray0);
        assertTrue(expressionString0.isEmpty());
    }

    @Test(timeout = 4000)
    public void test176() throws Throwable {
        Float float0 = new Float(0.0F);
        ExpressionString expressionString0 = Expressions.dollar((Number) float0, (Number) float0);
        ExpressionString expressionString1 = Expressions.initials((CharSequence) expressionString0, (CharSequence) expressionString0);
        Number[] numberArray0 = new Number[3];
        Expressions.concatenate((CharSequence) expressionString1, numberArray0);
        assertEquals("$0", expressionString0.getDelegate());
        assertEquals("$0", expressionString0.toString());
    }

    @Test(timeout = 4000)
    public void test177() throws Throwable {
        Byte byte0 = new Byte((byte) 0);
        Logical[] logicalArray0 = new Logical[0];
        ExpressionString expressionString0 = Expressions.concatenate((Number) byte0, logicalArray0);
        assertEquals("0", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test178() throws Throwable {
        Double double0 = new Double((-870.06026));
        CharSequence[] charSequenceArray0 = new CharSequence[0];
        ExpressionString expressionString0 = Expressions.concatenate((Number) double0, charSequenceArray0);
        assertEquals("-870.06026", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test179() throws Throwable {
        Logical logical0 = new Logical((Boolean) null);
        ExpressionString expressionString0 = Expressions.t(logical0);
        ExpressionString expressionString1 = Expressions.decapitalize(expressionString0);
        assertEquals("", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test180() throws Throwable {
        Boolean boolean0 = new Boolean(false);
        ExpressionString expressionString0 = Expressions.t(boolean0);
        ExpressionString expressionString1 = Expressions.decapitalizeFully((CharSequence) expressionString0);
        assertTrue(expressionString1.isEmpty());
    }

    @Test(timeout = 4000)
    public void test181() throws Throwable {
        ExpressionString expressionString0 = Expressions.capitalizeFully((CharSequence) null);
        ExpressionString expressionString1 = Expressions.decapitalizeFully((CharSequence) expressionString0, (CharSequence) expressionString0);
        assertTrue(expressionString1.isEmpty());
    }

    @Test(timeout = 4000)
    public void test182() throws Throwable {
        Boolean boolean0 = new Boolean(true);
        ExpressionString expressionString0 = Expressions.text(boolean0);
        ExpressionString expressionString1 = Expressions.decode(expressionString0);
        assertNotSame(expressionString0, expressionString1);
    }

    @Test(timeout = 4000)
    public void test183() throws Throwable {
        Float float0 = new Float(1086.9);
        ExpressionString expressionString0 = Expressions.repeat((CharSequence) null, float0);
        ExpressionString expressionString1 = Expressions.format((CharSequence) expressionString0, (CharSequence) expressionString0);
        assertNotSame(expressionString0, expressionString1);
    }

    @Test(timeout = 4000)
    public void test184() throws Throwable {
        char[] charArray0 = new char[5];
        CharBuffer charBuffer0 = CharBuffer.wrap(charArray0);
        ExpressionString expressionString0 = Expressions.hex(charBuffer0);
        assertEquals(10, expressionString0.length());
    }

    @Test(timeout = 4000)
    public void test185() throws Throwable {
        ExpressionString expressionString0 = Expressions.initials((CharSequence) null);
        ExpressionString expressionString1 = Expressions.suffix(expressionString0, expressionString0);
        assertTrue(expressionString1.equals((Object) expressionString0));
    }

    @Test(timeout = 4000)
    public void test186() throws Throwable {
        Boolean boolean0 = Boolean.valueOf(":@dnEe_l%");
        ExpressionString expressionString0 = Expressions.text(boolean0);
        ExpressionString expressionString1 = Expressions.initials((CharSequence) expressionString0, (CharSequence) ":@dnEe_l%");
        assertEquals("F", expressionString1.toString());
    }

    @Test(timeout = 4000)
    public void test187() throws Throwable {
        Float float0 = new Float(1.0F);
        ExpressionString expressionString0 = Expressions.unichar(float0);
        ExpressionString expressionString1 = Expressions.left((CharSequence) expressionString0);
        assertEquals("\u0001", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test188() throws Throwable {
        Long long0 = new Long(1593L);
        ExpressionString expressionString0 = Expressions.fixed((Number) long0, (Number) long0);
        Short short0 = new Short((short) 111);
        ExpressionString expressionString1 = Expressions.left((CharSequence) expressionString0, (Number) short0);
        assertEquals(111, expressionString1.length());
        assertEquals(346, expressionString0.length());
    }

    @Test(timeout = 4000)
    public void test189() throws Throwable {
        Boolean boolean0 = Boolean.valueOf(false);
        ExpressionString expressionString0 = Expressions.text(boolean0);
        FormulaDecimal formulaDecimal0 = Expressions.len((CharSequence) expressionString0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test190() throws Throwable {
        ExpressionString expressionString0 = Expressions.lower((CharSequence) null);
        assertTrue(expressionString0.isEmpty());
    }

    @Test(timeout = 4000)
    public void test191() throws Throwable {
        Float float0 = new Float(1804.839317321);
        ExpressionString expressionString0 = Expressions.t((Number) float0);
        ExpressionString expressionString1 = Expressions.ltrim(expressionString0);
        assertNotSame(expressionString0, expressionString1);
    }

    @Test(timeout = 4000)
    public void test192() throws Throwable {
        Logical logical0 = Logical.FALSE;
        Logical[] logicalArray0 = new Logical[2];
        ExpressionString expressionString0 = Expressions.concatenate(logical0, logicalArray0);
        Long long0 = new Long(2);
        ExpressionString expressionString1 = Expressions.mid(expressionString0, long0, long0);
        assertEquals("A", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test193() throws Throwable {
        Float float0 = new Float(3714.51);
        ExpressionString expressionString0 = Expressions.charr((Number) float0);
        ExpressionString expressionString1 = Expressions.proper((CharSequence) expressionString0);
        assertFalse(expressionString1.isEmpty());
    }

    @Test(timeout = 4000)
    public void test194() throws Throwable {
        Float float0 = new Float(2867.8200402280636);
        ExpressionString expressionString0 = Expressions.text((Number) float0);
        ExpressionString expressionString1 = Expressions.random(expressionString0, float0);
        assertNotSame(expressionString0, expressionString1);
    }

    @Test(timeout = 4000)
    public void test195() throws Throwable {
        Float float0 = new Float(1.0F);
        ExpressionString expressionString0 = Expressions.fixed((Number) float0, (Number) float0);
        ExpressionString expressionString1 = Expressions.remove(expressionString0, "}K3yWS.jl|D");
        assertEquals("1.0", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test196() throws Throwable {
        Float float0 = new Float(2266.030158);
        ExpressionString expressionString0 = Expressions.proper((Number) float0);
        ExpressionString expressionString1 = Expressions.removeFirst("3030.6622", expressionString0);
        assertFalse(expressionString1.isEmpty());
    }

    @Test(timeout = 4000)
    public void test197() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        ExpressionString expressionString0 = Expressions.t(boolean0);
        FormulaDecimal formulaDecimal0 = Expressions.unicode(expressionString0);
        ExpressionString expressionString1 = Expressions.text((Number) formulaDecimal0);
        ExpressionString expressionString2 = Expressions.removeLast(expressionString1, expressionString0);
        assertNotSame(expressionString2, expressionString1);
    }

    @Test(timeout = 4000)
    public void test198() throws Throwable {
        Long long0 = new Long(0L);
        Boolean boolean0 = Boolean.TRUE;
        ExpressionString expressionString0 = Expressions.fixed((Number) long0, (Number) long0, boolean0);
        ExpressionString expressionString1 = Expressions.rept(expressionString0, long0);
        Expressions.replaceFirst(expressionString1, expressionString0, expressionString1);
        assertEquals("0", expressionString0.toString());
        assertEquals("0", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test199() throws Throwable {
        CharSequence[] charSequenceArray0 = new CharSequence[6];
        ExpressionString expressionString0 = Expressions.proper((Logical) null);
        charSequenceArray0[0] = (CharSequence) expressionString0;
        ExpressionString expressionString1 = Expressions.replaceLast(expressionString0, charSequenceArray0[0], expressionString0);
        assertSame(expressionString0, expressionString1);
    }

    @Test(timeout = 4000)
    public void test201() throws Throwable {
        Boolean boolean0 = Boolean.FALSE;
        ExpressionString expressionString0 = Expressions.t(boolean0);
        CharSequence charSequence0 = Expressions.reverse(expressionString0);
        assertEquals("", charSequence0);
    }

    @Test(timeout = 4000)
    public void test202() throws Throwable {
        Float float0 = new Float(0.0F);
        ExpressionString expressionString0 = Expressions.dollar((Number) float0, (Number) float0);
        Byte byte0 = new Byte((byte) 0);
        FormulaDecimal formulaDecimal0 = Expressions.find((CharSequence) expressionString0, (CharSequence) expressionString0, (Number) byte0);
        Number[] numberArray0 = new Number[3];
        numberArray0[0] = (Number) formulaDecimal0;
        ExpressionString expressionString1 = Expressions.right((CharSequence) expressionString0, numberArray0[0]);
        assertEquals("$0", expressionString0.getDelegate());
        assertEquals("0", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test203() throws Throwable {
        Boolean boolean0 = new Boolean(false);
        ExpressionString expressionString0 = Expressions.t(boolean0);
        Short short0 = new Short((short) 0);
        ExpressionString expressionString1 = Expressions.substitute((CharSequence) expressionString0, (CharSequence) expressionString0, (CharSequence) expressionString0, (Number) short0);
        assertEquals("", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test204() throws Throwable {
        Boolean boolean0 = Boolean.valueOf(false);
        ExpressionString expressionString0 = Expressions.text(boolean0);
        FormulaDecimal formulaDecimal0 = Expressions.find((CharSequence) expressionString0, (CharSequence) expressionString0);
        ExpressionString expressionString1 = Expressions.substring((CharSequence) expressionString0, (Number) formulaDecimal0);
        assertEquals(4, expressionString1.length());
    }

    @Test(timeout = 4000)
    public void test205() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        ExpressionString expressionString0 = Expressions.t(boolean0);
        FormulaDecimal formulaDecimal0 = Expressions.numbervalue((CharSequence) expressionString0, (CharSequence) expressionString0, (CharSequence) expressionString0);
        ExpressionString expressionString1 = Expressions.substring((CharSequence) expressionString0, (Number) formulaDecimal0, (Number) formulaDecimal0);
        assertEquals("", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test206() throws Throwable {
        StringBuffer stringBuffer0 = new StringBuffer();
        ExpressionString expressionString0 = Expressions.toLowerCase(stringBuffer0);
        ExpressionString expressionString1 = Expressions.swap(expressionString0);
        assertEquals("", expressionString1.toString());
    }

    @Test(timeout = 4000)
    public void test207() throws Throwable {
        Integer integer0 = new Integer(1164);
        ExpressionString expressionString0 = Expressions.dollar((Number) integer0);
        ExpressionString expressionString1 = Expressions.t((CharSequence) expressionString0);
        assertEquals("$1,164.00", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test208() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        ExpressionString expressionString0 = Expressions.t(boolean0);
        ExpressionString expressionString1 = Expressions.text((CharSequence) expressionString0);
        assertSame(expressionString0, expressionString1);
    }

    @Test(timeout = 4000)
    public void test209() throws Throwable {
        Boolean boolean0 = new Boolean(".g]>:MD&-Nav_&[T");
        ExpressionString expressionString0 = Expressions.t(boolean0);
        ExpressionString expressionString1 = Expressions.text((CharSequence) expressionString0, (CharSequence) ".g]>:MD&-Nav_&[T");
        assertEquals("0.0", expressionString1.toString());
    }

    @Test(timeout = 4000)
    public void test212() throws Throwable {
        Float float0 = new Float(0.0F);
        ExpressionString expressionString0 = Expressions.dollar((Number) float0, (Number) float0);
        ExpressionString expressionString1 = Expressions.initials((CharSequence) expressionString0, (CharSequence) expressionString0);
        Expressions.toUpperCase(expressionString1);
        assertEquals("$0", expressionString0.getDelegate());
        assertEquals("$0", expressionString0.toString());
    }

    @Test(timeout = 4000)
    public void test213() throws Throwable {
        ExpressionString expressionString0 = Expressions.upper((CharSequence) null);
        assertEquals(0, expressionString0.length());
    }

    @Test(timeout = 4000)
    public void test214() throws Throwable {
        Float float0 = new Float((double) (-1L));
        ExpressionString expressionString0 = Expressions.dollar((Number) float0, (Number) float0);
        assertEquals("$0", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test215() throws Throwable {
        Logical[] logicalArray0 = new Logical[4];
        ExpressionString expressionString0 = Expressions.concatenate((CharSequence) " 1G&tE/Sfl;}IRpxl", logicalArray0);
        ExpressionString expressionString1 = Expressions.clean(expressionString0);
        assertEquals(" 1G&tE/Sfl;}IRpxl", expressionString1.getDelegate());
    }


    @Test(timeout = 4000)
    public void test216() throws Throwable {
        StringBuilder stringBuilder0 = new StringBuilder();
        ExpressionString expressionString0 = Expressions.t((CharSequence) stringBuilder0);
        ExpressionString expressionString1 = Expressions.atob(expressionString0);
        Assert.assertNotNull(Expressions.replace((CharSequence) expressionString1, (CharSequence) expressionString1, (CharSequence) expressionString0));
        Assert.assertNotNull(Expressions.charr((Number) null));
        Assert.assertNotNull(Expressions.code(expressionString1));
    }

    @Test(timeout = 4000)
    public void test217() throws Throwable {
        StringBuffer stringBuffer0 = new StringBuffer(0);
        ExpressionString expressionString0 = Expressions.trim(stringBuffer0);
        ExpressionString expressionString1 = Expressions.upper(expressionString0);
        FormulaDecimal formulaDecimal0 = Expressions.find((CharSequence) expressionString0, (CharSequence) stringBuffer0);
        Number[] numberArray0 = new Number[2];
        numberArray0[0] = (Number) formulaDecimal0;
        numberArray0[1] = (Number) formulaDecimal0;
        Assert.assertNotNull(Expressions.concatenate((Number) formulaDecimal0, numberArray0));
        CharSequence[] charSequenceArray0 = new CharSequence[4];
        charSequenceArray0[0] = (CharSequence) expressionString0;
        charSequenceArray0[1] = (CharSequence) expressionString0;
        stringBuffer0.insert(0, 'D');
        StringBuffer stringBuffer1 = stringBuffer0.append(2479);
        charSequenceArray0[3] = (CharSequence) expressionString0;
        Assert.assertNotNull(Expressions.value(expressionString1));
        Assert.assertNotNull(Expressions.substring((CharSequence) expressionString0, (Number) formulaDecimal0, numberArray0[0]));
        Assert.assertNotNull(Expressions.rtrim(stringBuffer1));
        Assert.assertNotNull(Expressions.random(charSequenceArray0[0], numberArray0[1]));
    }

    @Test(timeout = 4000)
    public void test218() throws Throwable {
        StringBuffer stringBuffer0 = new StringBuffer(0);
        ExpressionString expressionString0 = Expressions.trim(stringBuffer0);
        ExpressionString expressionString1 = Expressions.md5(expressionString0);
        ExpressionString expressionString2 = Expressions.upper(expressionString0);
        FormulaDecimal formulaDecimal0 = Expressions.find((CharSequence) expressionString0, (CharSequence) stringBuffer0);
        Number[] numberArray0 = new Number[2];
        numberArray0[0] = (Number) formulaDecimal0;
        numberArray0[1] = (Number) formulaDecimal0;
        ExpressionString expressionString3 = Expressions.concatenate((Number) formulaDecimal0, numberArray0);
        assertEquals("111", expressionString3.toString());

        Logical logical0 = Expressions.exact(expressionString1, expressionString0);
        ExpressionString expressionString4 = Expressions.t(logical0);
        CharSequence[] charSequenceArray0 = new CharSequence[4];
        charSequenceArray0[0] = (CharSequence) expressionString0;
        charSequenceArray0[1] = (CharSequence) expressionString1;
        ExpressionString expressionString5 = Expressions.initials((CharSequence) expressionString4, (CharSequence) expressionString2);
        stringBuffer0.insert(0, 'B');
        StringBuffer stringBuffer1 = stringBuffer0.append(0);
        charSequenceArray0[3] = (CharSequence) expressionString1;
        ExpressionString expressionString6 = Expressions.capitalizeFully((CharSequence) expressionString4, charSequenceArray0[2]);
        Assert.assertNotNull(Expressions.value(expressionString6));
        ExpressionString expressionString7 = Expressions.substring((CharSequence) expressionString6, (Number) formulaDecimal0, numberArray0[0]);
        ExpressionString expressionString8 = Expressions.rtrim(stringBuffer1);
        assertEquals("B0", expressionString8.getDelegate());

        Boolean boolean0 = Boolean.valueOf("io.onsense.universe.format.ExcelStyleDateFormatter");
        Boolean.logicalXor(false, false);
        logical0.compareTo(boolean0);
        Logical[] logicalArray0 = new Logical[4];
        logicalArray0[0] = logical0;
        Logical logical1 = Logical.TRUE;
        logicalArray0[1] = logical1;
        logicalArray0[2] = logical0;
        logicalArray0[3] = logical0;
        ExpressionString expressionString9 = Expressions.concatenate((CharSequence) expressionString7, logicalArray0);
        ExpressionString expressionString10 = Expressions.decapitalizeFully((CharSequence) expressionString5);
        assertNotSame(expressionString4, expressionString9);
        assertNotSame(expressionString4, expressionString7);
        assertNotSame(expressionString4, expressionString2);
        assertNotSame(expressionString4, expressionString10);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test219() throws Throwable {
        Moment mockDate0 = Moment.valueOf(25, 25, 2006, 16, 25);
        ExpressionString expressionString0 = Expressions.text((Date) mockDate0);
        ExpressionString expressionString1 = Expressions.prefix(expressionString0, expressionString0);
        Assert.assertNotNull(Expressions.crc32(expressionString1));
        Assert.assertNotNull(Expressions.sha256(expressionString0));
        Assert.assertNotNull(Expressions.value(expressionString0));
    }

    @Test(timeout = 4000)
    public void test220() throws Throwable {
        Float float0 = new Float(0.0);
        Float.max(1271.9037F, 1271.9037F);
        Float.max(1271.9037F, 0.0F);
        Float.isFinite(0.0F);
        Float float1 = new Float(1271.9037F);
        ExpressionString expressionString0 = Expressions.right((CharSequence) null, (Number) float0);
        ExpressionString expressionString1 = Expressions.replace((CharSequence) expressionString0, (Number) float0, (Number) float0, (CharSequence) expressionString0);
        ExpressionString expressionString2 = Expressions.concat((CharSequence) expressionString0, (CharSequence) null);
        Float.min((float) float1, 1173.542F);
        ExpressionString expressionString3 = Expressions.swap((CharSequence) null);
        Expressions.t((CharSequence) expressionString0);
        Expressions.t((Number) float0);
        ExpressionString expressionString4 = Expressions.charr((Number) float0);
        ExpressionString expressionString5 = Expressions.encode((CharSequence) null);
        Boolean boolean0 = Boolean.TRUE;
        Boolean.logicalXor(true, false);
        Boolean.logicalOr(true, true);
        ExpressionString expressionString6 = Expressions.text(boolean0);
        ExpressionString expressionString7 = Expressions.replaceLast(expressionString1, expressionString2, expressionString6);
        CharSequence[] charSequenceArray0 = new CharSequence[2];
        Float.sum(1173.542F, 0.0F);
        charSequenceArray0[0] = (CharSequence) expressionString5;
        charSequenceArray0[1] = null;
        Expressions.concatenate((CharSequence) expressionString7, charSequenceArray0);
        Expressions.initials((CharSequence) expressionString6, (CharSequence) expressionString1);
        ExpressionString expressionString8 = Expressions.substitute(charSequenceArray0[0], (CharSequence) expressionString5, (CharSequence) expressionString3);
        Logical logical0 = new Logical(boolean0);
        Expressions.t(logical0);
        ExpressionString expressionString9 = Expressions.suffix(expressionString1, expressionString3);
        assertNotSame(expressionString9, expressionString8);
        assertNotSame(expressionString3, expressionString6);
        assertNotSame(expressionString3, expressionString4);
    }

    @Test(timeout = 4000)
    public void test221() throws Throwable {
        Float float0 = new Float(2203.5634762280656);
        ExpressionString expressionString0 = Expressions.fixed((Number) float0);
        ExpressionString expressionString1 = Expressions.right((CharSequence) expressionString0, (Number) float0);
        ExpressionString expressionString2 = Expressions.remove(expressionString1, expressionString0);
        ExpressionString expressionString3 = Expressions.repeat(expressionString1, float0);
        ExpressionString expressionString4 = Expressions.format((CharSequence) expressionString1, (CharSequence) expressionString3);
        ExpressionString expressionString5 = Expressions.replaceFirst(expressionString2, expressionString1, expressionString4);
        ExpressionString expressionString6 = Expressions.clean(expressionString5);
        ExpressionString expressionString7 = Expressions.charr((CharSequence) expressionString0);
        Expressions.substring((CharSequence) expressionString1, (Number) float0, (Number) float0);
        ExpressionString expressionString8 = Expressions.proper((Number) float0);
        ExpressionString expressionString9 = Expressions.trimLeft(expressionString6);
        ExpressionString expressionString10 = Expressions.substring((CharSequence) expressionString3, (Number) float0, (Number) float0);
        Expressions.reverse(expressionString9);
        Expressions.initials((CharSequence) expressionString7);
        Expressions.rept(expressionString8, float0);
        Expressions.t((CharSequence) expressionString6);
        Expressions.text((CharSequence) "", (CharSequence) expressionString7);
        Expressions.text((Number) float0);
        Expressions.find((CharSequence) expressionString6, (CharSequence) expressionString3);
        DecimalFormat decimalFormat0 = new DecimalFormat("&x");
        MessageFormat messageFormat0 = new MessageFormat("..G7=vln'QUb@\"`63Vo");
        StringBuffer stringBuffer0 = new StringBuffer("&x");
//        Format.Field format_Field0 = mock(Format.Field.class, new ViolatedAssumptionAnswer());
        messageFormat0.setFormatByArgumentIndex(37, decimalFormat0);
        Expressions.text((Number) float0, (CharSequence) expressionString10);
        Expressions.substitute((CharSequence) null, (CharSequence) "..G7=vln'QUb@\"`63Vo", (CharSequence) expressionString2, (Number) float0);
        ExpressionString expressionString11 = Expressions.decode("..G7=vln'QUb@\"`63Vo");
        assertFalse(expressionString11.equals((Object) expressionString5));
    }

    @Test(timeout = 4000)
    public void test223() throws Throwable {
        FormulaDecimal formulaDecimal0 = Expressions.search((CharSequence) null, (CharSequence) null);
        ExpressionString expressionString0 = Expressions.replaceFirst((CharSequence) null, (CharSequence) null, (CharSequence) null);
        ExpressionString expressionString1 = Expressions.replaceLast((CharSequence) null, expressionString0, (CharSequence) null);
        Expressions.isPrintable('d');
        Logical logical0 = Logical.FALSE;
        Logical logical1 = Logical.valueOf(logical0);
        CharSequence[] charSequenceArray0 = new CharSequence[0];
        ExpressionString expressionString2 = Expressions.concatenate(logical1, charSequenceArray0);
        Expressions.isPrintable('d');
        Logical.compare(logical0, logical0);
        Logical[] logicalArray0 = new Logical[1];
        logicalArray0[0] = logical1;
        Expressions.right((CharSequence) expressionString1);
        Boolean boolean0 = Boolean.TRUE;
        ExpressionString expressionString3 = Expressions.t(boolean0);
        boolean boolean1 = Expressions.isPrintable('M');
        assertTrue(boolean1);

        Expressions.removeFirst(expressionString3, (CharSequence) null);
        assertNotSame(expressionString3, expressionString2);

        ExpressionString expressionString4 = Expressions.dollar((Number) formulaDecimal0, (Number) formulaDecimal0);
        assertEquals("$0", expressionString4.toString());
    }


    @Test(timeout = 4000)
    public void test224() throws Throwable {
        Byte byte0 = new Byte((byte) 17);
        ExpressionString expressionString0 = Expressions.dollar((Number) byte0, (Number) byte0);
        Byte.toUnsignedInt((byte) 17);
        Expressions.search((CharSequence) expressionString0, (CharSequence) expressionString0);
        ExpressionString expressionString1 = Expressions.removeFirst(expressionString0, expressionString0);
        ExpressionString expressionString2 = Expressions.proper((CharSequence) expressionString1);
        Expressions.numbervalue((CharSequence) expressionString0);
        ExpressionString expressionString3 = Expressions.right((CharSequence) expressionString2);
        assertEquals("", expressionString3.toString());

        Expressions.atob(expressionString1);
        Expressions.lower((CharSequence) null);
        Logical logical0 = Logical.FALSE;
        Expressions.t(logical0);
        ExpressionString expressionString4 = Expressions.decapitalizeFully((CharSequence) expressionString0, (CharSequence) expressionString0);
        assertEquals(21, expressionString4.length());
    }


    @Test(timeout = 4000)
    public void test225() throws Throwable {
        ExpressionString expressionString0 = Expressions.dollar((Number) null, (Number) null);
        ExpressionString expressionString1 = Expressions.capitalize(expressionString0);
        ExpressionString expressionString2 = Expressions.concat((CharSequence) expressionString0, (CharSequence) expressionString1);
        Long long0 = Long.getLong(":$K", 734L);
        ExpressionString expressionString3 = Expressions.capitalizeFully((CharSequence) expressionString2);
        ExpressionString expressionString4 = Expressions.swap(expressionString3);
        ExpressionString expressionString5 = Expressions.format((Number) long0, (CharSequence) expressionString4);
        Logical logical0 = Logical.valueOf(":$K");
        Expressions.text(logical0);
        Expressions.unichar((Number) null);
        ExpressionString expressionString6 = Expressions.concatenate((Number) null, (Logical[]) null);
        ExpressionString expressionString7 = Expressions.dollar((Number) long0);
        assertEquals("$734.00", expressionString7.toString());

        Float float0 = new Float((double) 734L);
        FormulaDecimal formulaDecimal0 = Expressions.concat((Number) null, (Number) float0);
        Expressions.atob(expressionString6);
        Expressions.text((Number) null);
        StringBuilder stringBuilder0 = new StringBuilder(3473);
        ExpressionString expressionString8 = Expressions.left((CharSequence) stringBuilder0, (Number) formulaDecimal0);
        FormulaDecimal formulaDecimal1 = Expressions.search((CharSequence) expressionString2, (CharSequence) expressionString0, (Number) float0);
        Expressions.substring((CharSequence) expressionString5, (Number) formulaDecimal1);
        ExpressionString expressionString9 = Expressions.proper(logical0);
        ExpressionString expressionString10 = Expressions.text((CharSequence) expressionString8);
        ExpressionString expressionString11 = Expressions.rept(expressionString10, (Number) null);
        ExpressionString expressionString12 = Expressions.trimRight(expressionString3);
        Expressions.text(logical0);
        Expressions.remove(expressionString5, expressionString3);
        ExpressionString expressionString13 = Expressions.fixed((Number) formulaDecimal0, (Number) long0, logical0);
        assertEquals("734.0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", expressionString13.getDelegate());

        ExpressionString expressionString14 = Expressions.replace((CharSequence) expressionString0, (CharSequence) expressionString9, (CharSequence) expressionString2);
        ExpressionString expressionString15 = Expressions.concatenate(logical0, (CharSequence[]) null);
        ExpressionString expressionString16 = Expressions.charr((Number) formulaDecimal1);
        assertEquals("\u0000", expressionString16.getDelegate());

        ExpressionString expressionString17 = Expressions.btoa(expressionString12);
        assertEquals("JDAkMA==", expressionString17.getDelegate());

        ExpressionString expressionString18 = Expressions.quote((CharSequence) null);
        ExpressionString expressionString19 = Expressions.prefix(expressionString18, expressionString0);
        assertNotSame(expressionString18, expressionString9);
        assertNotSame(expressionString0, expressionString14);
        assertEquals("$0", expressionString19.toString());
        assertNotSame(expressionString18, expressionString15);
        assertNotSame(expressionString18, expressionString11);
    }


    @Test(timeout = 4000)
    public void test298() throws Throwable {
        Logical logical0 = Logical.TRUE;
        ExpressionString expressionString0 = Expressions.upper((CharSequence) null);
        ExpressionString expressionString1 = Expressions.swap(expressionString0);
        Byte byte0 = new Byte((byte) 27);
        Logical.logicalXor(logical0, logical0);
        Expressions.mid(expressionString1, byte0, byte0);
        ExpressionString expressionString2 = Expressions.substitute((CharSequence) null, (CharSequence) null, (CharSequence) null);
        Assert.assertNotNull(Expressions.swap((CharSequence) null));
        Assert.assertNotNull(Expressions.decode(expressionString0));
        Assert.assertNotNull(Expressions.t((CharSequence) expressionString2));
        Assert.assertNotNull(Expressions.capitalize((CharSequence) null));
    }

    @Test(timeout = 4000)
    public void test299() throws Throwable {
        Expressions.exact((CharSequence) null, (CharSequence) null);
        ExpressionString expressionString0 = Expressions.decode((CharSequence) null);
        ExpressionString expressionString1 = Expressions.swap(expressionString0);
        Byte byte0 = new Byte((byte) 27);
        ExpressionString expressionString2 = Expressions.mid(expressionString1, byte0, byte0);
        ExpressionString expressionString3 = Expressions.remove(expressionString2, expressionString0);
        Assert.assertNotNull(Expressions.swap((CharSequence) null));
        Assert.assertNotNull(Expressions.remove((CharSequence) null, expressionString0));
        Assert.assertNotNull(Expressions.t((CharSequence) expressionString3));
        Boolean boolean0 = Boolean.TRUE;
        Expressions.fixed((Number) byte0, (Number) byte0, boolean0);
    }

    @Test(timeout = 4000)
    public void test226() throws Throwable {
        Boolean boolean0 = Boolean.valueOf("B^A~");
        ExpressionString expressionString0 = Expressions.proper(boolean0);
        ExpressionString expressionString1 = Expressions.unquote(expressionString0);
        Float float0 = new Float(0.0);
        Logical logical0 = Logical.TRUE;
        ExpressionString expressionString2 = Expressions.fixed((Number) float0, (Number) float0, logical0);
        ExpressionString expressionString3 = Expressions.substitute((CharSequence) expressionString1, (CharSequence) expressionString1, (CharSequence) "B^A~", (Number) float0);
        ExpressionString expressionString4 = Expressions.replaceLast(expressionString3, "B^A~", expressionString1);
        Assert.assertNotNull(Expressions.suffix(expressionString1, expressionString4));
        Assert.assertNotNull(Expressions.random(expressionString2, float0));
        Assert.assertNotNull(Expressions.concatenate((Number) float0, (Logical[]) null));
        Assert.assertTrue(Expressions.isPrintable('\\'));
    }

    @Test(timeout = 4000)
    public void test227() throws Throwable {
        CharSequence charSequence0 = null;
        ExpressionString expressionString0 = Expressions.t((CharSequence) null);
        Expressions.rtrim(expressionString0);
        FormulaDecimal formulaDecimal0 = Expressions.len((CharSequence) null);
        int int0 = 4700;
        CharBuffer charBuffer0 = CharBuffer.allocate(4700);
        ExpressionString expressionString1 = Expressions.decapitalize((CharSequence) null);
        ExpressionString expressionString2 = Expressions.replaceLast(charBuffer0, (CharSequence) null, expressionString1);
        Number[] numberArray0 = new Number[1];
        numberArray0[0] = (Number) formulaDecimal0;
        Assert.assertNotNull(Expressions.concatenate((CharSequence) expressionString2, numberArray0));
        Assert.assertNotNull(Expressions.search((CharSequence) null, (CharSequence) expressionString2, (Number) formulaDecimal0));
    }

    @Test(timeout = 4000)
    public void test228() throws Throwable {
        CharSequence charSequence0 = null;
        ExpressionString expressionString0 = Expressions.clean((CharSequence) null);
        Assert.assertNotNull(Expressions.decapitalizeFully((CharSequence) expressionString0, (CharSequence) null));

    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test229() throws Throwable {
        Float float0 = new Float(790.8058199838);
        Float.isFinite(0.0F);
        StringBuffer stringBuffer0 = new StringBuffer(0);
        ExpressionString expressionString0 = Expressions.text((Number) float0, (CharSequence) stringBuffer0);
        int int0 = 0;
        String string0 = "g{%WX1\\ZMI ERs";
        stringBuffer0.insert(0, (Object) "g{%WX1ZMI ERs");
        Assert.assertNotNull(Expressions.format((CharSequence) expressionString0, (CharSequence) stringBuffer0));
    }


    @Test(timeout = 4000)
    public void test230() throws Throwable {
        StringBuffer stringBuffer0 = new StringBuffer(0);
        ExpressionString expressionString0 = Expressions.trim(stringBuffer0);
        ExpressionString expressionString1 = Expressions.md5(expressionString0);
        ExpressionString expressionString2 = Expressions.upper(expressionString0);
        FormulaDecimal formulaDecimal0 = Expressions.find((CharSequence) expressionString0, (CharSequence) stringBuffer0);
        Number[] numberArray0 = new Number[2];
        numberArray0[0] = (Number) formulaDecimal0;
        numberArray0[1] = (Number) formulaDecimal0;
        Expressions.concatenate((Number) formulaDecimal0, numberArray0);
        Logical logical0 = Expressions.exact(expressionString1, expressionString0);
        Expressions.t(logical0);
        CharSequence[] charSequenceArray0 = new CharSequence[4];
        charSequenceArray0[0] = (CharSequence) expressionString0;
        charSequenceArray0[1] = (CharSequence) expressionString1;
        ExpressionString expressionString3 = Expressions.fixed((Number) formulaDecimal0, numberArray0[1], logical0);
        charSequenceArray0[2] = (CharSequence) expressionString3;
        stringBuffer0.insert(0, 'D');
        StringBuffer stringBuffer1 = stringBuffer0.append(2479);
        charSequenceArray0[3] = (CharSequence) expressionString1;
        ExpressionString expressionString4 = Expressions.concatenate((CharSequence) expressionString2, charSequenceArray0);
        Expressions.value(expressionString4);
        Expressions.substring((CharSequence) expressionString4, (Number) formulaDecimal0, numberArray0[0]);
        Expressions.rtrim(stringBuffer1);
        Boolean boolean0 = Boolean.valueOf("io.onsense.universe.format.ExcelStyleDateFormatter");
        logical0.compareTo(boolean0);

        Assert.assertNotNull(Expressions.random(charSequenceArray0[0], numberArray0[1]));
    }

    @Test(timeout = 4000)
    public void test231() throws Throwable {
        Boolean boolean0 = Boolean.valueOf(true);
        String string0 = null;
        Boolean.logicalXor(false, true);
        Boolean.getBoolean((String) null);
        ExpressionString expressionString0 = Expressions.text(boolean0);
        FormulaDecimal formulaDecimal0 = Expressions.find((CharSequence) expressionString0, (CharSequence) null);
        ExpressionString expressionString1 = Expressions.substring((CharSequence) null, (Number) formulaDecimal0);
        Expressions.decapitalizeFully((CharSequence) expressionString1);
        ExpressionString expressionString2 = Expressions.decode(expressionString0);
        ExpressionString expressionString3 = Expressions.lower(expressionString2);
        ExpressionString expressionString4 = Expressions.text((Number) formulaDecimal0);
        Expressions.toUpperCase(expressionString4);
        Assert.assertNotNull(Expressions.search((CharSequence) null, (CharSequence) expressionString3, (Number) formulaDecimal0));
    }

    @Test(timeout = 4000)
    public void test232() throws Throwable {
        Float float0 = new Float(1.0F);
        Assert.assertNotNull(Expressions.random((CharSequence) null, float0));
    }

    @Test(timeout = 4000)
    public void test234() throws Throwable {
        StringBuilder stringBuilder0 = new StringBuilder();
        ExpressionString expressionString0 = Expressions.t((CharSequence) null);
        ExpressionString expressionString1 = Expressions.atob(expressionString0);
        Expressions.replace((CharSequence) expressionString1, (CharSequence) expressionString1, (CharSequence) expressionString0);
        Logical logical0 = Logical.TRUE;
        Assert.assertNotNull(Expressions.md2(stringBuilder0));
        ExpressionString expressionString2 = Expressions.concatenate(logical0, (CharSequence[]) null);
        Assert.assertNotNull(Expressions.crc32(expressionString2));
        Assert.assertNotNull(Expressions.proper((CharSequence) expressionString1));
        Assert.assertNotNull(Expressions.code(expressionString1));
    }


    @Test(timeout = 4000)
    public void test255() throws Throwable {
        StringBuffer stringBuffer0 = new StringBuffer(0);
        ExpressionString expressionString0 = Expressions.trim(stringBuffer0);
        ExpressionString expressionString1 = Expressions.md5(expressionString0);
        ExpressionString expressionString2 = Expressions.upper(expressionString0);
        FormulaDecimal formulaDecimal0 = Expressions.find((CharSequence) expressionString0, (CharSequence) stringBuffer0);
        Number[] numberArray0 = new Number[2];
        numberArray0[0] = (Number) formulaDecimal0;
        numberArray0[1] = (Number) formulaDecimal0;
        Expressions.concatenate((Number) formulaDecimal0, numberArray0);
        Logical logical0 = Expressions.exact(expressionString1, expressionString0);
        Expressions.t(logical0);
        CharSequence[] charSequenceArray0 = new CharSequence[4];
        charSequenceArray0[0] = (CharSequence) expressionString0;
        charSequenceArray0[1] = (CharSequence) expressionString1;
        ExpressionString expressionString3 = Expressions.fixed((Number) formulaDecimal0, numberArray0[1], logical0);
        charSequenceArray0[2] = (CharSequence) expressionString3;
        stringBuffer0.insert(0, 'D');
        StringBuffer stringBuffer1 = stringBuffer0.append(2479);
        charSequenceArray0[3] = (CharSequence) expressionString1;
        ExpressionString expressionString4 = Expressions.concatenate((CharSequence) expressionString2, charSequenceArray0);
        Expressions.value(expressionString4);
        Expressions.mid(expressionString2, formulaDecimal0, numberArray0[1]);
        Expressions.rtrim(stringBuffer1);
        Boolean boolean0 = Boolean.valueOf("io.onsense.universe.format.ExcelStyleDateFormatter");
        Logical.valueOf("zh-Hans");
        logical0.compareTo(boolean0);
        Assert.assertNotNull(Expressions.random(charSequenceArray0[0], numberArray0[1]));

    }

    @Test(timeout = 4000)
    public void test235() throws Throwable {
        Byte byte0 = new Byte((byte) 54);
        ExpressionString expressionString0 = Expressions.fixed((Number) byte0);
        ExpressionString expressionString1 = Expressions.capitalizeFully((CharSequence) expressionString0);
        Byte.compare((byte) 17, (byte) 83);
        Byte.compare((byte) 17, (byte) (-14));
        ExpressionString expressionString2 = Expressions.substitute((CharSequence) expressionString1, (CharSequence) expressionString0, (CharSequence) expressionString0, (Number) byte0);
        Expressions.text((CharSequence) expressionString2);
        DateFormatSymbols dateFormatSymbols0 = DateFormatSymbols.getInstance();
        SimpleDateFormat mockSimpleDateFormat0 = new SimpleDateFormat("", dateFormatSymbols0);
        ParsePosition parsePosition0 = new ParsePosition(1768);
        Byte.toUnsignedLong((byte) 0);
        dateFormatSymbols0.setLocalPatternChars("");
        Date date0 = mockSimpleDateFormat0.parse("ur-PK", parsePosition0);
        ExpressionString expressionString3 = Expressions.text(date0, (CharSequence) "");
        Expressions.text((CharSequence) expressionString2, (CharSequence) expressionString0);
        Expressions.lower(expressionString3);
        Expressions.fixed((Number) byte0, (Number) byte0);
        Float float0 = new Float(0.0F);
        ExpressionString expressionString4 = Expressions.fixed((Number) float0);
        Expressions.prefix(expressionString0, expressionString4);

        Assert.assertNotNull(Expressions.numbervalue((CharSequence) expressionString4, (CharSequence) ""));
    }

    @Test(timeout = 4000)
    public void test238() throws Throwable {
        Boolean boolean0 = Boolean.valueOf((String) null);
        Logical logical0 = Logical.valueOf(boolean0);
        CharSequence[] charSequenceArray0 = new CharSequence[1];
        charSequenceArray0[0] = (CharSequence) "y7pW:>Ez~f";
        ExpressionString expressionString0 = Expressions.concatenate(logical0, charSequenceArray0);
        Boolean.logicalXor(false, true);
        Logical.compare(logical0, logical0);
        Expressions.reverse(expressionString0);
        ExpressionString expressionString1 = Expressions.decapitalize(charSequenceArray0[0]);
        ExpressionString expressionString2 = Expressions.t((CharSequence) expressionString1);
        Expressions.left((CharSequence) "y7pW:>Ez~f");
        ExpressionString expressionString3 = Expressions.decapitalize("y7pW:>Ez~f");
        Float float0 = new Float(0.0);
        Expressions.charr((Number) float0);
        Expressions.repeat(expressionString2, float0);

        Assert.assertNotNull(Expressions.initials((CharSequence) expressionString3, (CharSequence) null));

    }


    @Test(timeout = 4000)
    public void test244() throws Throwable {
        long long0 = 1804L;
        Long long1 = new Long(1804L);
        Long long2 = new Long(354L);
        Long.compareUnsigned((-599L), 1804L);
        ExpressionString expressionString0 = Expressions.dollar((Number) long1);
        Expressions.decapitalize(expressionString0);
        ExpressionString expressionString1 = Expressions.trimLeft(expressionString0);
        ExpressionString expressionString2 = Expressions.md2(expressionString0);
        Expressions.suffix(expressionString1, expressionString2);
        FormulaDecimal formulaDecimal0 = Expressions.len((CharSequence) expressionString2);
        Expressions expressions0 = new Expressions();

        Assert.assertNotNull(Expressions.substring((CharSequence) expressionString1, (Number) long2, (Number) formulaDecimal0));

    }

    @Test(timeout = 4000)
    public void test245() throws Throwable {
        Expressions.text((CharSequence) null, (CharSequence) null);
        ExpressionString expressionString0 = Expressions.toUpperCase((CharSequence) null);
        ExpressionString expressionString1 = Expressions.hex((CharSequence) null);
        Expressions.capitalize(expressionString0);
        Expressions.removeLast(expressionString1, expressionString1);
        Expressions.decapitalizeFully((CharSequence) expressionString0, (CharSequence) null);
    }


    @Test(timeout = 4000)
    public void test251() throws Throwable {
        Long long0 = new Long(1804L);
        Long.remainderUnsigned(3556L, 354L);
        Long.compareUnsigned((-599L), 1804L);
        ExpressionString expressionString0 = Expressions.dollar((Number) long0);
        ExpressionString expressionString1 = Expressions.decapitalize(expressionString0);
        ExpressionString expressionString2 = Expressions.trimLeft(expressionString0);
        ExpressionString expressionString3 = Expressions.md2(expressionString0);
        ExpressionString expressionString4 = Expressions.suffix(expressionString2, expressionString3);
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(1);
        Expressions expressions0 = new Expressions();
        ExpressionString expressionString5 = Expressions.random(expressionString1, long0);
        ExpressionString expressionString6 = Expressions.t((CharSequence) expressionString2);
        FormulaDecimal formulaDecimal1 = Expressions.numbervalue((CharSequence) expressionString0, (CharSequence) expressionString5, (CharSequence) expressionString2);
        ExpressionString expressionString7 = Expressions.hex(expressionString2);
        Short short0 = new Short((short) 0);
        ExpressionString expressionString8 = Expressions.rept(expressionString4, short0);
        Expressions.initials((CharSequence) expressionString6);
        Expressions.trimRight(expressionString6);
        Expressions.prefix(expressionString5, expressionString7);
        Expressions.chop(expressionString7);
        Expressions.upper(expressionString4);
        ExpressionString expressionString9 = Expressions.sha256((CharSequence) null);
        Expressions.btoa(expressionString9);
//        System.setCurrentTimeMillis(1804L);
        Expressions.proper((CharSequence) expressionString2);
        Logical[] logicalArray0 = new Logical[0];
        Expressions.concatenate((Number) formulaDecimal1, logicalArray0);
        Expressions.decapitalizeFully((CharSequence) expressionString4, (CharSequence) expressionString8);
        Expressions.text((CharSequence) expressionString5);
        ExpressionString expressionString10 = Expressions.upper(expressionString0);

        Assert.assertNotNull(Expressions.replaceFirst(expressionString1, expressionString5, expressionString10));

    }


    @Test(timeout = 4000)
    public void test259() throws Throwable {
        Logical[] logicalArray0 = new Logical[3];
        Logical logical0 = Logical.FALSE;
        Logical logical1 = Logical.valueOf(logical0);
        logicalArray0[0] = logical1;
        CharSequence charSequence0 = null;
        Logical logical2 = Expressions.exact((CharSequence) null, (CharSequence) null);
        logicalArray0[1] = logical2;
        Logical logical3 = Logical.FALSE;
        logicalArray0[2] = logical3;
        Expressions.concatenate((Number) null, logicalArray0);
        Double double0 = new Double(0.0);
        FormulaDecimal formulaDecimal0 = Expressions.search((CharSequence) null, (CharSequence) null, (Number) double0);
        Number[] numberArray0 = new Number[4];
        numberArray0[0] = (Number) formulaDecimal0;
        Long long0 = new Long(1L);
        numberArray0[1] = (Number) long0;
        numberArray0[2] = null;
        numberArray0[3] = null;
        ExpressionString expressionString0 = Expressions.concatenate(logical0, numberArray0);
        Expressions.unquote(expressionString0);
        Expressions.right((CharSequence) null, (Number) null);

        Assert.assertNotNull(Expressions.search((CharSequence) null, (CharSequence) expressionString0));
    }

    @Test(timeout = 4000)
    public void test262() throws Throwable {
        Double double0 = new Double(198.71);
        ExpressionString expressionString0 = Expressions.fixed((Number) double0, (Number) double0);
        ExpressionString expressionString1 = Expressions.mid(expressionString0, double0, double0);
        ExpressionString expressionString2 = Expressions.sha256(expressionString1);
        Double.isFinite((-1.0));
        CharSequence[] charSequenceArray0 = new CharSequence[6];
        charSequenceArray0[0] = (CharSequence) expressionString0;
        charSequenceArray0[1] = (CharSequence) expressionString2;
        ExpressionString expressionString3 = Expressions.concatenate((Number) double0, charSequenceArray0);
        charSequenceArray0[2] = (CharSequence) expressionString3;
        Double double1 = new Double(593.51841);
        Double.sum(4.9E-324, 0.0);
        ExpressionString expressionString4 = Expressions.format((Number) double1, (CharSequence) expressionString2);
        Double.isFinite((-99.070223564847));
        Double.isFinite(0.0);
        charSequenceArray0[3] = (CharSequence) expressionString4;
        charSequenceArray0[4] = (CharSequence) expressionString1;
        charSequenceArray0[5] = (CharSequence) expressionString1;
        Expressions.concatenate((CharSequence) expressionString2, charSequenceArray0);
        Assert.assertNotNull(Expressions.substring(charSequenceArray0[3], (Number) double1, (Number) double0));
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test265() throws Throwable {
        Short.compare((short) 512, (short) 512);
        Short.toUnsignedInt((short) 512);
        ExpressionString expressionString0 = Expressions.lower((CharSequence) null);
        ExpressionString expressionString1 = Expressions.md2(expressionString0);
        ExpressionString expressionString2 = Expressions.md5((CharSequence) null);
        ExpressionString expressionString3 = Expressions.capitalize(expressionString0);
        FormulaDecimal formulaDecimal0 = Expressions.numbervalue((CharSequence) expressionString1, (CharSequence) expressionString3);
        Expressions.chop(expressionString2);
        Assert.assertNotNull(Expressions.random(expressionString1, formulaDecimal0));
    }
}
