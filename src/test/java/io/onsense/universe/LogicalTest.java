package io.onsense.universe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * @author Koen Rooijmans
 */
public class LogicalTest {

    @Before
    public void setUp() throws Exception {
        System.setProperty("user.timezone", "UTC");
    }

    @Test(timeout = 4000)
    public void test00() throws Throwable {
        Logical logical0 = new Logical(true);
        Logical logical1 = Logical.TRUE;
        Logical.logicalOr(logical1, logical0);
        assertTrue(logical0.booleanValue());
        assertEquals("true", logical0.toString());
    }

    @Test(timeout = 4000)
    public void test01() throws Throwable {
        Logical logical0 = new Logical(true);
        Logical logical1 = Logical.TRUE;
        boolean boolean0 = Logical.logicalAnd(logical0, logical1);
        assertTrue(boolean0);
    }

    @Test(timeout = 4000)
    public void test02() throws Throwable {
        Logical logical0 = Logical.valueOf("true");
        assertEquals("true", logical0.toString());
    }

    @Test(timeout = 4000)
    public void test03() throws Throwable {
        boolean boolean0 = Logical.parseBoolean("true");
        assertTrue(boolean0);
    }

    @Test(timeout = 4000)
    public void test04() throws Throwable {
        Logical logical0 = Logical.FALSE;
        Logical logical1 = Logical.TRUE;
        boolean boolean0 = Logical.logicalXor(logical0, logical1);
        assertTrue(boolean0);
    }

    @Test(timeout = 4000)
    public void test05() throws Throwable {
        Logical logical0 = new Logical(true);
        boolean boolean0 = Logical.logicalOr(logical0, logical0);
        assertTrue(boolean0);
    }

    @Test(timeout = 4000)
    public void test06() throws Throwable {
        Logical logical0 = new Logical(true);
        boolean boolean0 = Logical.logicalAnd(logical0, logical0);
        assertTrue(boolean0);
    }

    @Test(timeout = 4000)
    public void test07() throws Throwable {
        Boolean boolean0 = Boolean.valueOf(true);
        Logical logical0 = Logical.valueOf(true);
        boolean boolean1 = logical0.equals(boolean0);
        assertTrue(boolean1);
    }

    @Test(timeout = 4000)
    public void test08() throws Throwable {
        Logical logical0 = Logical.TRUE;
        Boolean boolean0 = Boolean.FALSE;
        int int0 = logical0.compareTo(boolean0);
        assertEquals(1, int0);
    }

    @Test(timeout = 4000)
    public void test09() throws Throwable {
        Logical logical0 = Logical.valueOf("94R$");
        Boolean boolean0 = Boolean.valueOf(true);
        int int0 = logical0.compareTo(boolean0);
        assertEquals((-1), int0);
    }

    @Test(timeout = 4000)
    public void test10() throws Throwable {
        Logical logical0 = Logical.TRUE;
        Logical logical1 = Logical.FALSE;
        int int0 = Logical.compare(logical0, logical1);
        assertEquals(1, int0);
    }

    @Test(timeout = 4000)
    public void test11() throws Throwable {
        Logical logical0 = Logical.TRUE;
        Logical logical1 = Logical.FALSE;
        int int0 = Logical.compare(logical1, logical0);
        assertEquals((-1), int0);
    }

    @Test(timeout = 4000)
    public void test12() throws Throwable {
        Logical logical0 = Logical.valueOf(true);
        boolean boolean0 = logical0.booleanValue();
        assertTrue(boolean0);
    }

    @Test(timeout = 4000)
    public void test13() throws Throwable {
        Logical.toString((Logical) null);
    }

    @Test(timeout = 4000)
    public void test14() throws Throwable {
        Logical logical0 = new Logical(false);

        Logical.logicalXor((Logical) null, logical0);
    }

    @Test(timeout = 4000)
    public void test15() throws Throwable {
        Logical logical0 = Logical.FALSE;

        Logical.logicalAnd((Logical) null, logical0);
    }

    @Test(timeout = 4000)
    public void test16() throws Throwable {
        Logical logical0 = Logical.valueOf("V]dQ-Yr|(");

        logical0.compareTo((Boolean) null);

    }

    @Test(timeout = 4000)
    public void test17() throws Throwable {
        Logical logical0 = new Logical(true);

        Logical.compare(logical0, (Logical) null);

    }

    @Test(timeout = 4000)
    public void test18() throws Throwable {
        Logical logical0 = Logical.valueOf(false);

        Logical.logicalOr((Logical) null, logical0);

    }

    @Test(timeout = 4000)
    public void test19() throws Throwable {
        Logical.hashCode(false);
    }

    @Test(timeout = 4000)
    public void test20() throws Throwable {
        boolean boolean0 = Logical.parseBoolean("Z");
        assertFalse(boolean0);
    }

    @Test(timeout = 4000)
    public void test21() throws Throwable {
        Logical logical0 = Logical.TRUE;
        String string0 = Logical.toString(logical0);
        assertEquals("true", string0);
    }

    @Test(timeout = 4000)
    public void test22() throws Throwable {
        Logical logical0 = Logical.FALSE;
        String string0 = logical0.toString();
        assertEquals("false", string0);
    }

    @Test(timeout = 4000)
    public void test23() throws Throwable {
        Logical logical0 = Logical.valueOf("V]dQ-Yr|(");
        boolean boolean0 = Logical.logicalOr(logical0, logical0);
        assertFalse(boolean0);
    }

    @Test(timeout = 4000)
    public void test24() throws Throwable {
        Logical logical0 = Logical.TRUE;
        logical0.hashCode();
    }

    @Test(timeout = 4000)
    public void test25() throws Throwable {
        Logical logical0 = Logical.valueOf("V]dQ-Yr|(");
        boolean boolean0 = Logical.logicalAnd(logical0, logical0);
        assertFalse(boolean0);
    }

    @Test(timeout = 4000)
    public void test26() throws Throwable {
        Logical logical0 = Logical.valueOf("V]dQ-Yr|(");
        logical0.equals("V]dQ-Yr|(");
        assertEquals("false", logical0.toString());
    }

    @Test(timeout = 4000)
    public void test27() throws Throwable {
        Logical logical0 = Logical.valueOf("V]dQ-Yr|(");
        boolean boolean0 = logical0.booleanValue();
        assertFalse(boolean0);
    }

    @Test(timeout = 4000)
    public void test28() throws Throwable {
        Logical logical0 = Logical.valueOf("V]dQ-Yr|(");
        boolean boolean0 = Logical.logicalXor(logical0, logical0);
        assertFalse(logical0.booleanValue());
        assertFalse(boolean0);
    }

    @Test(timeout = 4000)
    public void test29() throws Throwable {
        Logical logical0 = Logical.valueOf("V]dQ-Yr|(");
        Boolean boolean0 = Boolean.FALSE;
        int int0 = logical0.compareTo(boolean0);
        assertEquals(0, int0);
    }

    @Test(timeout = 4000)
    public void test30() throws Throwable {
        Logical logical0 = Logical.valueOf("V]dQ-Yr|(");
        int int0 = Logical.compare(logical0, logical0);
        assertEquals(0, int0);
        assertFalse(logical0.booleanValue());
    }

    @Test(timeout = 4000)
    public void test31() throws Throwable {
        boolean boolean0 = Logical.getBoolean("Z");
        assertFalse(boolean0);
    }

    @Test
    public void test32() {
        assertFalse(Logical.parseBoolean(""));
        assertFalse(Logical.parseBoolean(null));
    }

    @Test
    public void test33() {
        assertFalse(Logical.getBoolean(""));
        assertFalse(Logical.getBoolean(null));
    }
}
