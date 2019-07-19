package io.onsense.universe;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Koen Rooijmans
 */
public class ArrayHelperTest {

    @Test
    public void testConstructor() {
        Assert.assertNotNull(new ArrayHelper());
    }

    @Test(timeout = 4000)
    public void test00() throws Throwable {
        Integer[] integerArray0 = new Integer[3];
        Object[] objectArray0 = ArrayHelper.resizeForAppend((Object[]) integerArray0, 1);
        assertEquals(1, objectArray0.length);
    }

    @Test(timeout = 4000)
    public void test01() throws Throwable {
        Integer integer0 = new Integer((-2744));
        Integer[] integerArray0 = new Integer[3];
        integerArray0[2] = integer0;
        Object[] objectArray0 = ArrayHelper.prepend((Object) integerArray0[2], (Object[]) integerArray0);
        assertEquals(4, objectArray0.length);
    }

    @Test(timeout = 4000)
    public void test02() throws Throwable {
        String[][] stringArray0 = new String[1][1];
        String[] stringArray1 = ArrayHelper.join(stringArray0);
        assertEquals(1, stringArray1.length);
    }

    @Test(timeout = 4000)
    public void test03() throws Throwable {
        ArrayHelper arrayHelper0 = new ArrayHelper();
    }

    @Test(timeout = 4000)
    public void test04() throws Throwable {
        Class<Integer> class0 = Integer.class;
        Integer integer0 = new Integer((-2744));
        Integer[] integerArray0 = new Integer[3];
        Integer[] integerArray1 = ArrayHelper.append(class0, integer0, integerArray0);
        assertEquals(4, integerArray1.length);
    }

    @Test(timeout = 4000)
    public void test05() throws Throwable {
        String[] stringArray0 = new String[6];
        Class<Object> class0 = Object.class;
        Object object0 = new Object();
        Object[] objectArray0 = ArrayHelper.prepend(class0, object0, (Object[]) stringArray0);
        assertEquals(7, objectArray0.length);
    }

    @Test(timeout = 4000)
    public void test06() throws Throwable {
        String[] stringArray0 = new String[6];
        Class<Object> class0 = Object.class;
        Object[] objectArray0 = ArrayHelper.prepend(class0, (Object) stringArray0[2], (Object[]) stringArray0);
        assertEquals(6, objectArray0.length);
    }

    @Test(timeout = 4000)
    public void test07() throws Throwable {
        Class<String> class0 = String.class;
        String[] stringArray0 = ArrayHelper.prepend(class0, (String) null, (String[]) null);
        assertNotNull(stringArray0);
        assertEquals(0, stringArray0.length);
    }

    @Test(timeout = 4000)
    public void test08() throws Throwable {
        Class<Object> class0 = Object.class;
        Object[] objectArray0 = ArrayHelper.prepend(class0, (Object) class0, (Object[]) null);
        assertEquals(1, objectArray0.length);
        assertNotNull(objectArray0);
    }

    @Test(timeout = 4000)
    public void test09() throws Throwable {
        String[] stringArray0 = new String[6];
        String[] stringArray1 = ArrayHelper.prepend((String) null, stringArray0);
        assertEquals(6, stringArray1.length);
    }

    @Test(timeout = 4000)
    public void test10() throws Throwable {
        Object[] objectArray0 = ArrayHelper.prepend((Object) null, (Object[]) null);
        assertNotNull(objectArray0);
        assertEquals(0, objectArray0.length);
    }

    @Test(timeout = 4000)
    public void test11() throws Throwable {
        Integer integer0 = new Integer((-2380));
        Integer[] integerArray0 = ArrayHelper.prepend(integer0, (Integer[]) null);
        assertEquals(1, integerArray0.length);
    }

    @Test(timeout = 4000)
    public void test12() throws Throwable {
        Class<String> class0 = String.class;
        String[] stringArray0 = ArrayHelper.append(class0, (String) null, (String[]) null);
        String[][] stringArray1 = new String[1][5];
        stringArray1[0] = stringArray0;
        String[] stringArray2 = ArrayHelper.join(stringArray1);
        assertEquals(0, stringArray2.length);
        assertNotNull(stringArray2);
        assertSame(stringArray2, stringArray0);
    }

    @Test(timeout = 4000)
    public void test13() throws Throwable {
        String[] stringArray0 = new String[2];
        Class<Object> class0 = Object.class;
        Object[] objectArray0 = ArrayHelper.append(class0, (Object) stringArray0[1], (Object[]) stringArray0);
        assertEquals(2, objectArray0.length);
    }

    @Test(timeout = 4000)
    public void test14() throws Throwable {
        Class<String> class0 = String.class;
        String[] stringArray0 = ArrayHelper.append(class0, "#GETTING_DATA!", (String[]) null);
        assertEquals(1, stringArray0.length);
        assertNotNull(stringArray0);
    }

    @Test(timeout = 4000)
    public void test15() throws Throwable {
        Integer integer0 = new Integer(2);
        Object[] objectArray0 = new Object[5];
        Object[] objectArray1 = ArrayHelper.append((Object) integer0, objectArray0);
        assertEquals(6, objectArray1.length);
    }

    @Test(timeout = 4000)
    public void test16() throws Throwable {
        String[] stringArray0 = new String[2];
        Object[] objectArray0 = ArrayHelper.append((Object) null, (Object[]) stringArray0);
        assertEquals(2, objectArray0.length);
    }

    @Test(timeout = 4000)
    public void test17() throws Throwable {
        Object[] objectArray0 = ArrayHelper.append((Object) null, (Object[]) null);
        assertEquals(0, objectArray0.length);
        assertNotNull(objectArray0);
    }

    @Test(timeout = 4000)
    public void test18() throws Throwable {
        String[] stringArray0 = ArrayHelper.append("", (String[]) null);
        assertEquals(1, stringArray0.length);
    }

    @Test(timeout = 4000)
    public void test19() throws Throwable {
        Class<Object> class0 = Object.class;
        Object[][] objectArray0 = new Object[6][6];
        Object[] objectArray1 = ArrayHelper.join(class0, objectArray0);
        assertEquals(36, objectArray1.length);
    }

    @Test(timeout = 4000)
    public void test20() throws Throwable {
        Class<String> class0 = String.class;
        String[][] stringArray0 = new String[1][1];
        String[] stringArray1 = ArrayHelper.join(class0, stringArray0);
        assertEquals(1, stringArray1.length);
    }

    @Test(timeout = 4000)
    public void test35() throws Throwable {
        Class<String> class0 = String.class;
        String[][] stringArray0 = new String[1][1];
        stringArray0[0] = null;
        String[] stringArray1 = ArrayHelper.join(class0, stringArray0);
        assertNull(stringArray1);
    }

    @Test(timeout = 4000)
    public void test36() throws Throwable {
        String[][] stringArray0 = new String[1][1];
        stringArray0[0] = null;
        String[] stringArray1 = ArrayHelper.join(stringArray0);
        assertNull(stringArray1);
    }

    @Test(timeout = 4000)
    public void test37() throws Throwable {
        Class<Object> class0 = Object.class;
        Object[] objectArray0 = new Object[3];
        Object[] objectArray1 = ArrayHelper.resizeForAppend(class0, objectArray0, 0);
        assertEquals(0, objectArray1.length);
    }

    @Test(timeout = 4000)
    public void test38() throws Throwable {
        String[] stringArray0 = new String[1];
        String[] stringArray1 = ArrayHelper.resizeForAppend(stringArray0, 0);
        assertEquals(0, stringArray1.length);
    }

    @Test(timeout = 4000)
    public void test39() throws Throwable {
        Class<Integer> class0 = Integer.class;
        Integer[] integerArray0 = new Integer[0];
        Integer[] integerArray1 = ArrayHelper.resizeForPrepend(class0, integerArray0, 2);
        assertEquals(2, integerArray1.length);
    }

    @Test(timeout = 4000)
    public void test40() throws Throwable {
        Class<Object> class0 = Object.class;
        Object[] objectArray0 = new Object[6];
        Object[] objectArray1 = ArrayHelper.resizeForAppend(class0, objectArray0, 1727);
        Object[] objectArray2 = ArrayHelper.resizeForAppend(class0, objectArray1, 1727);
        assertEquals(1727, objectArray2.length);
    }
}