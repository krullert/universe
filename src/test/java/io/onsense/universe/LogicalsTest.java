package io.onsense.universe;

import org.junit.Before;
import org.junit.Test;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author Koen Rooijmans
 */
public class LogicalsTest {

    @Before
    public void setUp() throws Exception {
        System.setProperty("user.timezone", "UTC");
    }

    @Test(timeout = 4000)
    public void test001() throws Throwable {
        String[] stringArray0 = new String[3];
        stringArray0[0] = "";
        stringArray0[1] = "";
        ExpressionString expressionString0 = Logicals.logicalSwitch((Object) "", (Object[]) stringArray0);
        assertEquals("", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test002() throws Throwable {
        Boolean boolean0 = Boolean.FALSE;
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, (Number) null, (CharSequence) "");
        String[] stringArray0 = new String[3];
        stringArray0[0] = "";
        stringArray0[1] = "";
        ExpressionString expressionString1 = Logicals.logicalSwitch((CharSequence) expressionString0, (Object[]) stringArray0);
        assertEquals("", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test003() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        Double double0 = new Double((-1110.15));
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, (Number) double0, boolean0);
        Short short0 = new Short((short) 1970);
        ExpressionString expressionString1 = Logicals.logicalIf(boolean0, (CharSequence) expressionString0, (Number) short0);
        assertEquals("-1110.15", expressionString1.toString());
    }

    @Test(timeout = 4000)
    public void test004() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        Boolean boolean1 = Boolean.FALSE;
        ExpressionString expressionString0 = Logicals.logicalIf(boolean1, (Number) null, (CharSequence) "");
        ExpressionString expressionString1 = Logicals.logicalIf(boolean0, (CharSequence) expressionString0, (Boolean) null);
        assertSame(expressionString1, expressionString0);
    }

    @Test(timeout = 4000)
    public void test006() throws Throwable {
        Boolean boolean0 = Boolean.FALSE;
        Short short0 = new Short((short) (-13));
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, (Number) short0);
        ExpressionString expressionString1 = Logicals.logicalIf(boolean0, boolean0, (CharSequence) expressionString0);
        assertEquals("false", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test008() throws Throwable {
        Boolean boolean0 = Boolean.valueOf("");
        Logical logical0 = Logicals.logicalTrue();
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, logical0, (CharSequence) "");
        assertEquals(0, expressionString0.length());
    }

    @Test(timeout = 4000)
    public void test009() throws Throwable {
        Logical logical0 = Logicals.logicalFalse;
        Date Date0 = new Date((short) (-1232), 0, 0);
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, (Date) Date0, (CharSequence) "");
        assertTrue(expressionString0.isEmpty());
    }

    @Test(timeout = 4000)
    public void test010() throws Throwable {
        Boolean boolean0 = Boolean.FALSE;
        Short short0 = new Short((short) (-13));
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, (Number) short0);
        Logical logical0 = Logicals.logicalTrue();
        Date Date0 = new Date();
        ExpressionString expressionString1 = Logicals.logicalIf(logical0, (Date) Date0, (CharSequence) expressionString0);
        assertNotSame(expressionString0, expressionString1);
    }

    @Test(timeout = 4000)
    public void test011() throws Throwable {
        Logical logical0 = Logical.FALSE;
        Double double0 = new Double(0.0);
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, (Number) double0, (CharSequence) "");
        assertEquals(0, expressionString0.length());
    }

    @Test(timeout = 4000)
    public void test012() throws Throwable {
        Logical logical0 = Logical.TRUE;
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, (CharSequence) "", (Date) null);
        assertEquals("", expressionString0.toString());
    }

    @Test(timeout = 4000)
    public void test013() throws Throwable {
        Logical logical0 = Logicals.logicalTrue;
        Float float0 = new Float(0.0);
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, (CharSequence) "", (Number) float0);
        assertEquals("", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test014() throws Throwable {
        Logical logical0 = Logicals.logicalTrue();
        Boolean boolean0 = Boolean.valueOf(false);
        Short short0 = new Short((short) 1787);
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, boolean0, (Number) short0);
        ExpressionString expressionString1 = Logicals.logicalIf(logical0, (CharSequence) "", (CharSequence) expressionString0);
        assertEquals(0, expressionString1.length());
    }

    @Test(timeout = 4000)
    public void test015() throws Throwable {
        Logical logical0 = Logical.FALSE;
        Logical logical1 = Logicals.logicalNot(logical0);
        ExpressionString expressionString0 = Logicals.logicalIf(logical1, (CharSequence) "", logical1);
        assertEquals("", expressionString0.toString());
    }

    @Test(timeout = 4000)
    public void test016() throws Throwable {
        Logical logical0 = Logical.valueOf("");
        Logical logical1 = Logicals.logicalNot(logical0);
        ExpressionString expressionString0 = Logicals.logicalIf(logical1, (CharSequence) "");
        assertTrue(expressionString0.isEmpty());
    }

    @Test(timeout = 4000)
    public void test017() throws Throwable {
        Logical logical0 = Logical.FALSE;
        Boolean boolean0 = new Boolean(false);
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, boolean0, (CharSequence) "");
        assertTrue(expressionString0.isEmpty());
    }

    @Test(timeout = 4000)
    public void test018() throws Throwable {
        Logical logical0 = Logical.TRUE;
        Double double0 = new Double(0);
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, logical0, (Number) double0);
        assertFalse(expressionString0.isEmpty());
    }

    @Test(timeout = 4000)
    public void test019() throws Throwable {
        Logical logical0 = Logical.FALSE;
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, logical0, (CharSequence) "");
        assertEquals("", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test025() throws Throwable {
        Logical logical0 = Logical.TRUE;
        Logical[] logicalArray0 = new Logical[0];

        Logicals.logicalXor(logical0, logicalArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test026() throws Throwable {
        Logical logical0 = Logicals.logicalFalse;
        Logical[] logicalArray0 = new Logical[2];
        logicalArray0[0] = logical0;

        Logicals.logicalSwitch((Date) null, (Object[]) logicalArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test027() throws Throwable {

        Logicals.logicalSwitch((Date) null, (Object[]) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test028() throws Throwable {
        Short short0 = new Short((short) 44);

        Logicals.logicalSwitch((Object) short0, (Object[]) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test029() throws Throwable {
        Integer integer0 = new Integer(0);
        Object[] objectArray0 = new Object[0];

        Logicals.logicalSwitch((Number) integer0, objectArray0);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test030() throws Throwable {
        Byte byte0 = new Byte((byte) (-72));

        Logicals.logicalSwitch((Number) byte0, (Object[]) null);
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test032() throws Throwable {
        Boolean boolean0 = Boolean.valueOf((String) null);
        Float float0 = new Float((-1998.449765));
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, (Number) float0, (Number) float0);

        Logicals.logicalSwitch((CharSequence) expressionString0, (Object[]) null);
    }

    @Test(timeout = 4000)
    public void test033() throws Throwable {

        Logicals.logicalNot((Logical) null);
    }

    @Test(timeout = 4000)
    public void test034() throws Throwable {
        Clock clock0 = Clock.systemDefaultZone();
        Instant instant0 = Instant.now(clock0);
        Date date0 = Date.from(instant0);
        Long long0 = new Long((-1L));

        Logicals.logicalIf((Boolean) null, date0, (Number) long0);
    }

    @Test(timeout = 4000)
    public void test035() throws Throwable {
        Boolean boolean0 = Boolean.valueOf("");
        Instant instant0 = Instant.ofEpochMilli(297L);
        Date date0 = Date.from(instant0);

        Logicals.logicalIf(boolean0, date0, (CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test036() throws Throwable {
        Date Date0 = new Date();

        Logicals.logicalIf((Boolean) null, (Date) Date0, (Boolean) null);
    }

    @Test(timeout = 4000)
    public void test037() throws Throwable {

        Logicals.logicalIf((Boolean) null, (Date) null);
    }

    @Test(timeout = 4000)
    public void test038() throws Throwable {
        Float float0 = new Float((-1358.3F));
        Date Date0 = new Date(0, 0, 0);

        Logicals.logicalIf((Boolean) null, (Number) float0, (Date) Date0);
    }

    @Test(timeout = 4000)
    public void test039() throws Throwable {
        Byte byte0 = new Byte((byte) 2);

        Logicals.logicalIf((Boolean) null, (Number) byte0, (Number) byte0);
    }

    @Test(timeout = 4000)
    public void test040() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;

        Logicals.logicalIf(boolean0, (Number) null, (CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test041() throws Throwable {
        Float float0 = new Float((-1.0F));

        Logicals.logicalIf((Boolean) null, (Number) float0, (Boolean) null);
    }

    @Test(timeout = 4000)
    public void test042() throws Throwable {
        Logical logical0 = Logical.valueOf("8");
        Double double0 = new Double(0.0);

        Logicals.logicalIf((Boolean) null, (Number) double0, logical0);
    }

    @Test(timeout = 4000)
    public void test043() throws Throwable {
        Short short0 = new Short((short) (-224));

        Logicals.logicalIf((Boolean) null, (Number) short0);
    }

    @Test(timeout = 4000)
    public void test044() throws Throwable {
        Boolean boolean0 = Boolean.valueOf(true);
        Byte byte0 = new Byte((byte) (-73));

        Logicals.logicalIf(boolean0, (CharSequence) null, (Number) byte0);
    }

    @Test(timeout = 4000)
    public void test045() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;

        Logicals.logicalIf(boolean0, (CharSequence) null, boolean0);
    }

    @Test(timeout = 4000)
    public void test046() throws Throwable {
        Logical logical0 = Logical.valueOf(false);
        Long long0 = new Long(86L);
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, (Number) long0, (Boolean) null);

        Logicals.logicalIf((Boolean) null, (CharSequence) expressionString0, logical0);
    }

    @Test(timeout = 4000)
    public void test047() throws Throwable {

        Logicals.logicalIf((Boolean) null, (CharSequence) "");
    }

    @Test(timeout = 4000)
    public void test048() throws Throwable {
        Boolean boolean0 = Boolean.FALSE;
        Logical logical0 = Logical.FALSE;
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, logical0, logical0);

        Logicals.logicalIf((Boolean) null, (Boolean) null, (CharSequence) expressionString0);
    }

    @Test(timeout = 4000)
    public void test049() throws Throwable {

        Logicals.logicalIf((Boolean) null, (Boolean) null, (Boolean) null);
    }

    @Test(timeout = 4000)
    public void test050() throws Throwable {
        Logical logical0 = new Logical(true);

        Logicals.logicalIf((Boolean) null, (Boolean) null, logical0);
    }

    @Test(timeout = 4000)
    public void test051() throws Throwable {

        Logicals.logicalIf((Boolean) null, (Boolean) null);
    }

    @Test(timeout = 4000)
    public void test052() throws Throwable {
        Logical logical0 = Logicals.logicalFalse();
        Float float0 = new Float(840.0F);

        Logicals.logicalIf((Boolean) null, logical0, (Number) float0);
    }

    @Test(timeout = 4000)
    public void test053() throws Throwable {
        Logical logical0 = Logicals.logicalTrue();
        Boolean boolean0 = Boolean.TRUE;
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, logical0, boolean0);

        Logicals.logicalIf((Boolean) null, logical0, (CharSequence) expressionString0);
    }

    @Test(timeout = 4000)
    public void test054() throws Throwable {
        Logical logical0 = Logical.TRUE;

        Logicals.logicalIf((Boolean) null, logical0, logical0);
    }

    @Test(timeout = 4000)
    public void test055() throws Throwable {
        Logical logical0 = new Logical(true);

        Logicals.logicalIf((Boolean) null, logical0);
    }

    @Test(timeout = 4000)
    public void test056() throws Throwable {
        Date Date0 = new Date(385, (-772625709), (-1594), 398, 398);

        Logicals.logicalIf((Logical) null, (Date) Date0, (Date) Date0);
    }

    @Test(timeout = 4000)
    public void test057() throws Throwable {
        Date Date0 = new Date(0, (-1), 4033, (-1067), (-986));

        Logicals.logicalIf((Logical) null, (Date) Date0);
    }

    @Test(timeout = 4000)
    public void test058() throws Throwable {
        Float float0 = new Float(0.0F);

        Logicals.logicalIf((Logical) null, (Number) float0, (Number) float0);
    }

    @Test(timeout = 4000)
    public void test059() throws Throwable {
        Float float0 = new Float((float) (-3380));

        Logicals.logicalIf((Logical) null, (Number) float0, (CharSequence) "|cuyV58c~=0R");
    }

    @Test(timeout = 4000)
    public void test060() throws Throwable {
        Short short0 = new Short((short) 3498);
        Boolean boolean0 = new Boolean(true);

        Logicals.logicalIf((Logical) null, (Number) short0, boolean0);
    }

    @Test(timeout = 4000)
    public void test061() throws Throwable {
        Logical logical0 = Logicals.logicalFalse();
        Logical[] logicalArray0 = new Logical[7];
        Float float0 = new Float(0.0F);

        Logicals.logicalIf(logicalArray0[1], (Number) float0, logical0);
    }

    @Test(timeout = 4000)
    public void test062() throws Throwable {
        Long long0 = new Long(0L);

        Logicals.logicalIf((Logical) null, (Number) long0);
    }

    @Test(timeout = 4000)
    public void test063() throws Throwable {
        Logical logical0 = Logical.TRUE;
        Float float0 = new Float((-1.0F));

        Logicals.logicalIf(logical0, (CharSequence) null, (Number) float0);
    }

    @Test(timeout = 4000)
    public void test064() throws Throwable {
        Logical logical0 = Logicals.logicalTrue();

        Logicals.logicalIf(logical0, (CharSequence) null, (CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test065() throws Throwable {
        Boolean boolean0 = Boolean.FALSE;
        Date Date0 = new Date(0, 1786, 744, 0, 626, 744);
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, (Date) Date0, (Date) Date0);

        Logicals.logicalIf((Logical) null, (CharSequence) expressionString0, boolean0);
    }

    @Test(timeout = 4000)
    public void test066() throws Throwable {
        Logical logical0 = Logical.TRUE;

        Logicals.logicalIf(logical0, (CharSequence) null, logical0);
    }

    @Test(timeout = 4000)
    public void test067() throws Throwable {
        Boolean boolean0 = new Boolean("{ZB #{coJEt&}sh");
        Date Date0 = new Date(0, 0, 0, 0, 0, 0);

        Logicals.logicalIf((Logical) null, boolean0, (Date) Date0);
    }

    @Test(timeout = 4000)
    public void test068() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        Double double0 = new Double(0.0);

        Logicals.logicalIf((Logical) null, boolean0, (Number) double0);
    }

    @Test(timeout = 4000)
    public void test069() throws Throwable {
        Logical logical0 = Logicals.logicalTrue;
        Boolean boolean0 = new Boolean((String) null);

        Logicals.logicalIf(logical0, boolean0, (CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test070() throws Throwable {
        Boolean boolean0 = new Boolean(true);

        Logicals.logicalIf((Logical) null, boolean0, boolean0);
    }

    @Test(timeout = 4000)
    public void test071() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        Logical[] logicalArray0 = new Logical[9];

        Logicals.logicalIf(logicalArray0[3], boolean0, logicalArray0[5]);
    }

    @Test(timeout = 4000)
    public void test072() throws Throwable {
        Logical logical0 = Logical.valueOf("0rVA&gSlxi~o");
        Date Date0 = new Date(1119, 3470, (-1), 1119, 1119);

        Logicals.logicalIf((Logical) null, logical0, (Date) Date0);
    }

    @Test(timeout = 4000)
    public void test073() throws Throwable {
        Logical logical0 = Logicals.logicalFalse;

        Logicals.logicalIf(logical0, logical0, (CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test074() throws Throwable {
        Boolean boolean0 = Boolean.FALSE;

        Logicals.logicalIf((Logical) null, (Logical) null, boolean0);
    }

    @Test(timeout = 4000)
    public void test076() throws Throwable {

        Logicals.logicalIf((Logical) null, (Logical) null);
    }

    @Test(timeout = 4000)
    public void test077() throws Throwable {
        String[] stringArray0 = new String[3];
        stringArray0[0] = "";
        ExpressionString expressionString0 = Logicals.logicalSwitch((Object) "", (Object[]) stringArray0);
        assertTrue(expressionString0.isEmpty());
    }

    @Test(timeout = 4000)
    public void test078() throws Throwable {
        Boolean boolean0 = Boolean.FALSE;
        Short short0 = new Short((short) (-13));
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, (Number) short0);
        Object[] objectArray0 = new Object[3];
        ExpressionString expressionString1 = Logicals.logicalSwitch((Object) expressionString0, objectArray0);
        assertNotSame(expressionString0, expressionString1);
    }

    @Test(timeout = 4000)
    public void test079() throws Throwable {
        Boolean boolean0 = new Boolean("\"ihZth/I{c|[q'H");
        Object[] objectArray0 = new Object[1];
        ExpressionString expressionString0 = Logicals.logicalSwitch((Object) boolean0, objectArray0);
        assertEquals("", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test080() throws Throwable {
        Logical logical0 = Logicals.logicalFalse;
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, (CharSequence) null, (CharSequence) null);
        assertEquals(5, expressionString0.length());
    }

    @Test(timeout = 4000, expected = UniversalException.class)
    public void test081() throws Throwable {
        Logical logical0 = Logicals.logicalTrue();
        Logical[] logicalArray0 = new Logical[6];
        logicalArray0[0] = logical0;
        logicalArray0[2] = logical0;
        logicalArray0[4] = logical0;

        Logicals.logicalSwitch((Object) null, (Object[]) logicalArray0);
    }

    @Test(timeout = 4000)
    public void test082() throws Throwable {
        Logical logical0 = new Logical(true);
        Logical logical1 = Logical.valueOf((String) null);
        Logical[] logicalArray0 = new Logical[6];
        logicalArray0[0] = logical0;
        Logical logical2 = Logicals.logicalOr(logical1, logicalArray0);
        assertEquals("true", logical2.toString());
    }

    @Test(timeout = 4000)
    public void test083() throws Throwable {
        Logical logical0 = Logical.valueOf(false);
        Logical[] logicalArray0 = new Logical[3];
        logicalArray0[0] = logical0;
        logicalArray0[1] = logical0;
        logicalArray0[2] = logical0;
        Logical logical1 = Logicals.logicalOr(logicalArray0[2], logicalArray0);
        assertFalse(logical1.booleanValue());
    }

    @Test(timeout = 4000)
    public void test084() throws Throwable {
        Logical logical0 = Logical.valueOf(false);
        Logical[] logicalArray0 = new Logical[3];
        logicalArray0[2] = logical0;

        Logicals.logicalOr(logicalArray0[2], logicalArray0);
    }

    @Test(timeout = 4000)
    public void test085() throws Throwable {
        Logical logical0 = Logicals.logicalTrue();
        Logical[] logicalArray0 = new Logical[2];
        Logical logical1 = Logicals.logicalOr(logical0, logicalArray0);
        assertEquals("true", logical1.toString());
    }

    @Test(timeout = 4000)
    public void test086() throws Throwable {
        Logical logical0 = Logicals.logicalTrue();
        Logical[] logicalArray0 = new Logical[4];
        logicalArray0[0] = logical0;
        logicalArray0[1] = logical0;
        logicalArray0[2] = logical0;
        logicalArray0[3] = logical0;
        Logical logical1 = Logicals.logicalAnd(logical0, logicalArray0);
        assertTrue(logical1.booleanValue());
    }

    @Test(timeout = 4000)
    public void test087() throws Throwable {
        Logical logical0 = Logicals.logicalTrue();
        Logical[] logicalArray0 = new Logical[4];

        Logicals.logicalAnd(logical0, logicalArray0);
    }

    @Test(timeout = 4000)
    public void test088() throws Throwable {
        Logical logical0 = Logicals.logicalFalse();
        Logical[] logicalArray0 = new Logical[7];
        Logical logical1 = Logicals.logicalAnd(logical0, logicalArray0);
        assertFalse(logical1.booleanValue());
    }

    @Test(timeout = 4000)
    public void test089() throws Throwable {
        Logical logical0 = Logical.valueOf("");
        Logical logical1 = Logicals.logicalNot(logical0);
        Logical[] logicalArray0 = new Logical[8];
        logicalArray0[0] = logical0;
        Logical logical2 = Logicals.logicalAnd(logical1, logicalArray0);
        assertEquals("false", logical2.toString());
        assertTrue(logical1.booleanValue());
    }

    @Test(timeout = 4000)
    public void test090() throws Throwable {
        Logical logical0 = Logicals.logicalTrue();
        Logical logical1 = Logicals.logicalNot(logical0);
        assertEquals("false", logical1.toString());
    }

    @Test(timeout = 4000)
    public void test091() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, (CharSequence) "", (Number) null);
        assertTrue(expressionString0.isEmpty());
    }

    @Test(timeout = 4000)
    public void test092() throws Throwable {
        Logical logical0 = Logicals.logicalFalse;
        Float float0 = new Float((-1.0F));
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, (Number) float0, logical0);
        ExpressionString expressionString1 = Logicals.logicalIf(logical0, (CharSequence) expressionString0, logical0);
        assertEquals("false", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test093() throws Throwable {
        Boolean boolean0 = Boolean.valueOf(false);
        Logical logical0 = Logicals.logicalTrue();
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, (Date) null, boolean0);
        assertEquals("", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test094() throws Throwable {
        Logical logical0 = Logicals.logicalFalse();
        Float float0 = new Float(0.0F);
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, (Number) float0);
        assertEquals("false", expressionString0.toString());
    }

    @Test(timeout = 4000)
    public void test095() throws Throwable {
        Logical logical0 = Logical.valueOf("");
        Boolean boolean0 = Boolean.TRUE;
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, boolean0, logical0);
        assertEquals("true", expressionString0.toString());
    }

    @Test(timeout = 4000)
    public void test096() throws Throwable {
        Logicals logicals0 = new Logicals();
        Boolean boolean0 = Boolean.FALSE;

        Logicals.logicalIf((Boolean) null, logicals0.logicalTrue, boolean0);
    }

    @Test(timeout = 4000)
    public void test097() throws Throwable {
        Boolean boolean0 = Boolean.FALSE;
        Short short0 = new Short((short) (-13));
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, (Number) short0);
        Logical logical0 = Logicals.logicalTrue();
        ExpressionString expressionString1 = Logicals.logicalIf(logical0, logical0, (CharSequence) expressionString0);
        assertEquals("true", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test098() throws Throwable {
        Boolean boolean0 = Boolean.FALSE;
        Float float0 = new Float((-1.0F));
        Logical logical0 = Logical.FALSE;
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, (Number) float0, logical0);
        assertEquals("false", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test099() throws Throwable {
        Logical logical0 = Logicals.logicalFalse;
        Float float0 = new Float((-1.0F));
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, (Number) float0, logical0);
        Boolean boolean0 = Boolean.valueOf(false);
        ExpressionString expressionString1 = Logicals.logicalIf(boolean0, (CharSequence) expressionString0);
        assertEquals(5, expressionString1.length());
    }

    @Test(timeout = 4000)
    public void test100() throws Throwable {
        Logical logical0 = Logicals.logicalFalse;
        Float float0 = new Float((-1.0F));
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, (Number) float0, logical0);
        ExpressionString expressionString1 = Logicals.logicalIf(logical0, (CharSequence) expressionString0, (Date) null);
        assertEquals("", expressionString1.toString());
    }

    @Test(timeout = 4000)
    public void test101() throws Throwable {
        Logical logical0 = Logical.valueOf("");
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, logical0);
        assertEquals("false", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test103() throws Throwable {
        Boolean boolean0 = Boolean.FALSE;
        Short short0 = new Short((short) (-13));
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, (Number) short0);
        Logical logical0 = Logicals.logicalTrue();
        ExpressionString expressionString1 = Logicals.logicalIf(logical0, (CharSequence) expressionString0, boolean0);
        assertEquals("false", expressionString0.toString());
        assertSame(expressionString0, expressionString1);
    }

    @Test(timeout = 4000)
    public void test104() throws Throwable {
        Boolean boolean0 = Boolean.FALSE;
        Date Date0 = new Date(0L);
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, (Date) Date0);

        Logicals.logicalIf((Boolean) null, (CharSequence) expressionString0, (Date) Date0);
    }

    @Test(timeout = 4000)
    public void test105() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, boolean0, (Number) null);
        String[] stringArray0 = new String[3];
        ExpressionString expressionString1 = Logicals.logicalSwitch((CharSequence) expressionString0, (Object[]) stringArray0);
        assertEquals("true", expressionString0.toString());
        assertFalse(expressionString1.equals((Object) expressionString0));
    }

    @Test(timeout = 4000)
    public void test106() throws Throwable {
        Boolean boolean0 = Boolean.valueOf(true);
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, boolean0, boolean0);
        assertFalse(expressionString0.isEmpty());
    }

    @Test(timeout = 4000)
    public void test107() throws Throwable {
        Logical logical0 = Logicals.logicalFalse();
        Date Date0 = new Date((-1467L));
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, (Date) Date0);
        assertEquals("false", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test108() throws Throwable {
        Boolean boolean0 = Boolean.FALSE;
        Date Date0 = new Date(0L);
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, (Date) Date0);
        ExpressionString expressionString1 = Logicals.logicalIf(boolean0, (CharSequence) expressionString0, boolean0);
        assertEquals(5, expressionString1.length());
    }

    @Test(timeout = 4000)
    public void test110() throws Throwable {
        Boolean boolean0 = Boolean.valueOf("");
        Date Date0 = new Date((-1800), 470, 470);
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, (Date) Date0, (Boolean) null);
        assertEquals("", expressionString0.toString());
    }

    @Test(timeout = 4000)
    public void test111() throws Throwable {
        Boolean boolean0 = Boolean.valueOf(false);
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, boolean0, (CharSequence) "");
        assertEquals("", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test112() throws Throwable {
        Date Date0 = new Date();

        Logicals.logicalIf((Boolean) null, (Boolean) null, (Date) Date0);
    }

    @Test(timeout = 4000)
    public void test113() throws Throwable {
        Boolean boolean0 = Boolean.valueOf("io.onsense.universe.Logicals");
        Short short0 = new Short((short) (-3191));
        Date Date0 = new Date(0L);
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, (Date) Date0, (Number) short0);
        assertEquals("-3191", expressionString0.toString());
    }

    @Test(timeout = 4000)
    public void test114() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, (Number) null, (CharSequence) "");
        assertTrue(expressionString0.isEmpty());
    }

    @Test(timeout = 4000)
    public void test115() throws Throwable {

        Logicals.logicalIf((Boolean) null, (Date) null, (Date) null);
    }

    @Test(timeout = 4000)
    public void test116() throws Throwable {
        Logical logical0 = Logicals.logicalFalse();
        Logical[] logicalArray0 = new Logical[4];

        Logicals.logicalXor(logical0, logicalArray0);
    }

    @Test(timeout = 4000)
    public void test117() throws Throwable {
        Boolean boolean0 = Boolean.FALSE;
        Logical logical0 = Logical.FALSE;
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, boolean0, logical0);
        assertEquals(5, expressionString0.length());
    }

    @Test(timeout = 4000)
    public void test118() throws Throwable {
        Date Date0 = new Date(3859, 3859, 3859, 3859, 3859);
        Logical logical0 = Logicals.logicalTrue;

        Logicals.logicalIf(logical0, (Date) Date0, (CharSequence) null);
    }

    @Test(timeout = 4000)
    public void test119() throws Throwable {
        Logical logical0 = Logicals.logicalFalse();
        Boolean boolean0 = Boolean.valueOf(true);
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, boolean0);
        assertEquals(5, expressionString0.length());
    }

    @Test(timeout = 4000)
    public void test120() throws Throwable {
        Boolean boolean0 = Boolean.FALSE;
        Double double0 = new Double((-715.9328));
        Instant instant0 = Instant.ofEpochSecond((-1L), (-1L));
        Date date0 = Date.from(instant0);
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, (Number) double0, date0);
        assertNotNull(expressionString0.toString());
    }

    @Test(timeout = 4000)
    public void test121() throws Throwable {
        Logical logical0 = Logical.valueOf(false);
        Long long0 = new Long(86L);
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, (Number) long0, (Boolean) null);
        ExpressionString expressionString1 = Logicals.logicalIf(logical0, (CharSequence) expressionString0, (CharSequence) expressionString0);
        assertEquals(0, expressionString1.length());
    }

    @Test(timeout = 4000)
    public void test122() throws Throwable {
        Logical logical0 = Logicals.logicalTrue();
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, (Boolean) null, (Date) null);
        assertEquals(0, expressionString0.length());
    }

    @Test(timeout = 4000)
    public void test123() throws Throwable {
        Logical logical0 = Logicals.logicalFalse();
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, (CharSequence) "/=v");
        assertEquals(5, expressionString0.length());
    }

    @Test(timeout = 4000)
    public void test125() throws Throwable {
        Boolean boolean0 = Boolean.valueOf("");
        Short short0 = new Short((short) 0);
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, (Number) short0, (Number) short0);
        ExpressionString expressionString1 = Logicals.logicalIf(boolean0, (Date) null, (CharSequence) expressionString0);
        assertEquals("0", expressionString1.toString());
    }

    @Test(timeout = 4000)
    public void test126() throws Throwable {
        Boolean boolean0 = Boolean.TRUE;
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, boolean0);
        assertEquals(4, expressionString0.length());
    }

    @Test(timeout = 4000)
    public void test127() throws Throwable {
        Logical logical0 = Logicals.logicalTrue();
        Date Date0 = new Date(1);
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, logical0, (Date) Date0);
        assertEquals(4, expressionString0.length());
    }

    @Test(timeout = 4000)
    public void test128() throws Throwable {
        Boolean boolean0 = Boolean.valueOf("");
        Logical logical0 = Logical.FALSE;
        Double double0 = new Double(0.0);
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, logical0, (Number) double0);
        assertEquals("0.0", expressionString0.toString());
    }

    @Test(timeout = 4000)
    public void test129() throws Throwable {
        Logical logical0 = Logicals.logicalTrue();
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, (Date) null, logical0);
        assertEquals("", expressionString0.toString());
    }

    @Test(timeout = 4000)
    public void test130() throws Throwable {
        Boolean boolean0 = Boolean.FALSE;
        Date Date0 = new Date(0L);
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, (Date) Date0);
        Logical logical0 = Logical.FALSE;
        ExpressionString expressionString1 = Logicals.logicalIf(logical0, boolean0, (CharSequence) expressionString0);
        assertEquals(5, expressionString0.length());
        assertSame(expressionString0, expressionString1);
    }

    @Test(timeout = 4000)
    public void test131() throws Throwable {
        Boolean boolean0 = Boolean.FALSE;
        Date Date0 = new Date(0L);
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, (Date) Date0);
        Float float0 = new Float((-1.0F));
        Logical logical0 = Logical.FALSE;
        ExpressionString expressionString1 = Logicals.logicalIf(logical0, (CharSequence) expressionString0, (Number) float0);
        assertEquals(4, expressionString1.length());
    }

    @Test(timeout = 4000)
    public void test134() throws Throwable {
        Boolean boolean0 = Boolean.valueOf("io.onsense.universe.Logicals");
        Short short0 = new Short((short) (-3191));
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, (Number) short0, boolean0);
        Logical logical0 = Logicals.logicalTrue();
        ExpressionString expressionString1 = Logicals.logicalIf(boolean0, (CharSequence) expressionString0, logical0);
        assertEquals("true", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test136() throws Throwable {
        Double double0 = new Double(0.0);
        Object[] objectArray0 = new Object[1];
        ExpressionString expressionString0 = Logicals.logicalSwitch((Number) double0, objectArray0);
        assertTrue(expressionString0.isEmpty());
    }

    @Test(timeout = 4000)
    public void test138() throws Throwable {
        Logical logical0 = Logicals.logicalTrue();

        Logicals.logicalIf((Boolean) null, logical0, (Date) null);
    }

    @Test(timeout = 4000)
    public void test139() throws Throwable {
        Logical logical0 = Logicals.logicalTrue();
        Boolean boolean0 = Boolean.valueOf(false);
        Short short0 = new Short((short) 1787);
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, boolean0, (Number) short0);
        ExpressionString expressionString1 = Logicals.logicalIf(boolean0, logical0, (CharSequence) expressionString0);
        assertEquals(5, expressionString1.length());
    }

    @Test(timeout = 4000)
    public void test140() throws Throwable {
        Byte byte0 = new Byte((byte) (-37));

        Logicals.logicalIf((Logical) null, (Logical) null, (Number) byte0);
    }

    @Test(timeout = 4000)
    public void test141() throws Throwable {
        Logical logical0 = Logical.valueOf("");
        Double double0 = new Double(0.0);
        ExpressionString expressionString0 = Logicals.logicalIf(logical0, (Date) null, (Number) double0);
        assertEquals(3, expressionString0.length());
    }

    @Test(timeout = 4000)
    public void test142() throws Throwable {
        Boolean boolean0 = Boolean.valueOf("");
        Logical logical0 = Logicals.logicalFalse();
        ExpressionString expressionString0 = Logicals.logicalIf(boolean0, logical0);
        assertFalse(expressionString0.isEmpty());
    }

    @Test(timeout = 4000)
    public void test143() throws Throwable {
        Logical[] logicalArray0 = new Logical[2];
        ExpressionString expressionString0 = Logicals.logicalSwitch((Date) null, (Object[]) logicalArray0);
        assertEquals(0, expressionString0.length());
    }
}
