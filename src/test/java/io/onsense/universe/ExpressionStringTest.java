package io.onsense.universe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.regex.PatternSyntaxException;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * @author Koen Rooijmans
 */
public class ExpressionStringTest {

    @Before
    public void setUp() throws Exception {
        System.setProperty("user.timezone", "UTC");
    }

    @Test(timeout = 4000)
    public void test000() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf((-1685.224851));
        ExpressionString expressionString1 = expressionString0.replace('r', 'v');
        assertEquals("-1685.224851", expressionString1.toString());
    }

    @Test(timeout = 4000)
    public void test001() throws Throwable {
        char[] charArray0 = new char[9];
        ExpressionString expressionString0 = ExpressionString.valueOf(charArray0, 0, 0);
        expressionString0.lastIndexOf(0, (-471));
        assertEquals("", expressionString0.toString());
    }

    @Test(timeout = 4000)
    public void test002() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(0);
        expressionString0.indexOf(0, 16);
        assertEquals("0", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test003() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(false);
        expressionString0.regionMatches(true, (-1), "(#O^cZ`53wOt/rhXvg", (-87), (-398));
        assertEquals(5, expressionString0.length());
    }

    @Test(timeout = 4000)
    public void test004() throws Throwable {
        char[] charArray0 = new char[0];

        Assert.assertNotNull(ExpressionString.copyValueOf(charArray0, 441, (-1)));
    }

    @Test(timeout = 4000)
    public void test005() throws Throwable {
        char[] charArray0 = new char[9];
        ExpressionString expressionString0 = ExpressionString.copyValueOf(charArray0);
        byte[] byteArray0 = new byte[2];
        expressionString0.getBytes(1, 1, byteArray0, (int) (byte) 0);
        assertFalse(expressionString0.isEmpty());
    }

    @Test(timeout = 4000)
    public void test006() throws Throwable {
        char[] charArray0 = new char[7];
        ExpressionString expressionString0 = ExpressionString.valueOf(charArray0, 1, 1);
        assertEquals("\u0000", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test007() throws Throwable {
        char[] charArray0 = new char[0];
        ExpressionString expressionString0 = ExpressionString.valueOf(charArray0);
        ExpressionString expressionString1 = ExpressionString.valueOf((Object) expressionString0);
        assertNotSame(expressionString0, expressionString1);
    }

    @Test(timeout = 4000)
    public void test008() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('L');
        ExpressionString expressionString1 = ExpressionString.valueOf((CharSequence) expressionString0);
        assertEquals("L", expressionString1.toString());
    }

    @Test(timeout = 4000)
    public void test009() throws Throwable {
        ExpressionString expressionString0 = new ExpressionString("");
        ExpressionString expressionString1 = expressionString0.trim();
        assertEquals(0, expressionString1.length());
    }

    @Test(timeout = 4000)
    public void test010() throws Throwable {
        char[] charArray0 = new char[0];
        ExpressionString expressionString0 = ExpressionString.valueOf(charArray0);
        Locale locale0 = Locale.TAIWAN;
        ExpressionString expressionString1 = expressionString0.toUpperCase(locale0);
        assertEquals(0, expressionString1.length());
    }

    @Test(timeout = 4000)
    public void test011() throws Throwable {
        char[] charArray0 = new char[0];
        ExpressionString expressionString0 = ExpressionString.valueOf(charArray0);
        ExpressionString expressionString1 = expressionString0.toUpperCase();
        assertNotSame(expressionString0, expressionString1);
    }

    @Test(timeout = 4000)
    public void test012() throws Throwable {
        char[] charArray0 = new char[6];
        ExpressionString expressionString0 = ExpressionString.valueOf(charArray0);
        String string0 = expressionString0.toString();
        assertEquals("\u0000\u0000\u0000\u0000\u0000\u0000", string0);
    }

    @Test(timeout = 4000)
    public void test013() throws Throwable {
        char[] charArray0 = new char[4];
        ExpressionString expressionString0 = ExpressionString.copyValueOf(charArray0, 0, 0);
        Locale locale0 = Locale.CANADA_FRENCH;
        ExpressionString expressionString1 = expressionString0.toLowerCase(locale0);
        assertEquals("", expressionString1.toString());
    }

    @Test(timeout = 4000)
    public void test014() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('%');
        Locale locale0 = Locale.CHINA;
        ExpressionString expressionString1 = expressionString0.toLowerCase(locale0);
        assertEquals("%", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test015() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(1);
        ExpressionString expressionString1 = expressionString0.subSequence(0, 0);
        ExpressionString expressionString2 = expressionString1.toLowerCase();
        assertTrue(expressionString2.isEmpty());
        assertEquals("1", expressionString0.toString());
    }

    @Test(timeout = 4000)
    public void test016() throws Throwable {
        Object[] objectArray0 = new Object[9];
        ExpressionString expressionString0 = ExpressionString.format("", objectArray0);
        char[] charArray0 = expressionString0.toCharArray();
        assertArrayEquals(new char[]{}, charArray0);
    }

    @Test(timeout = 4000)
    public void test017() throws Throwable {
        ExpressionString expressionString0 = new ExpressionString("");
        ExpressionString expressionString1 = expressionString0.concat(")_yWv");
        ExpressionString expressionString2 = expressionString1.substring(0, 1);
        assertEquals(1, expressionString2.length());
    }

    @Test(timeout = 4000)
    public void test018() throws Throwable {
        Object object0 = new Object();
        ExpressionString expressionString0 = ExpressionString.valueOf(object0);
        ExpressionString expressionString1 = expressionString0.substring(1);
        assertFalse(expressionString1.isEmpty());
    }

    @Test(timeout = 4000)
    public void test019() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(2195L);
        ExpressionString expressionString1 = expressionString0.subSequence(0, 1);
        assertEquals("2", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test020() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(true);
        expressionString0.startsWith("", 1);
        assertEquals("true", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test021() throws Throwable {
        Object[] objectArray0 = new Object[2];
        ExpressionString expressionString0 = ExpressionString.format("io.onsense.universe.ExpressionString", objectArray0);
        boolean boolean0 = expressionString0.startsWith("io.onsense.universe.ExpressionString");
        assertTrue(boolean0);
    }

    @Test(timeout = 4000)
    public void test022() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(0.0);
        expressionString0.startsWith("n/");
        assertEquals(3, expressionString0.length());
    }

    @Test(timeout = 4000)
    public void test023() throws Throwable {
        StringBuffer stringBuffer0 = new StringBuffer(0);
        ExpressionString expressionString0 = ExpressionString.valueOf((CharSequence) stringBuffer0);
        ExpressionString expressionString1 = expressionString0.replaceFirst("r:dmZ>,OGg9Gn*jd", "");
        assertTrue(expressionString1.isEmpty());
    }

    @Test(timeout = 4000)
    public void test024() throws Throwable {
        char[] charArray0 = new char[4];
        ExpressionString expressionString0 = ExpressionString.copyValueOf(charArray0, 0, 0);
        ExpressionString expressionString1 = expressionString0.replaceAll("^Uc]tGvEHy1%ToQe8}", "WlS\"Q([f'5FuBz->Z#c");
        assertTrue(expressionString1.isEmpty());
    }

    @Test(timeout = 4000)
    public void test025() throws Throwable {
        ExpressionString expressionString0 = new ExpressionString("");
        ExpressionString expressionString1 = expressionString0.replace((CharSequence) expressionString0, (CharSequence) expressionString0);
        assertEquals("", expressionString1.toString());
    }

    @Test(timeout = 4000)
    public void test026() throws Throwable {
        Locale locale0 = Locale.SIMPLIFIED_CHINESE;
        Object[] objectArray0 = new Object[3];
        ExpressionString expressionString0 = ExpressionString.format(locale0, "", objectArray0);
        ExpressionString expressionString1 = expressionString0.replace('v', 'v');
        assertNotSame(expressionString0, expressionString1);
    }

    @Test(timeout = 4000)
    public void test027() throws Throwable {
        StringBuffer stringBuffer0 = new StringBuffer();
        LinkedHashSet<String> linkedHashSet0 = new LinkedHashSet<String>(2866);
        ExpressionString expressionString0 = ExpressionString.join((CharSequence) stringBuffer0, (Iterable<? extends CharSequence>) linkedHashSet0);
        boolean boolean0 = expressionString0.regionMatches(false, 0, "", 0, 0);
        assertTrue(boolean0);
    }

    @Test(timeout = 4000)
    public void test028() throws Throwable {
        Object[] objectArray0 = new Object[2];
        ExpressionString expressionString0 = ExpressionString.format("io.onsense.universe.ExpressionString", objectArray0);
        boolean boolean0 = expressionString0.regionMatches(1, "io.onsense.universe.ExpressionString", 1, (int) (byte) 0);
        assertTrue(boolean0);
    }

    @Test(timeout = 4000)
    public void test029() throws Throwable {
        ExpressionString expressionString0 = new ExpressionString("");
        int int0 = expressionString0.offsetByCodePoints(0, 0);
        assertEquals(0, int0);
    }

    @Test(timeout = 4000)
    public void test030() throws Throwable {
        Object object0 = new Object();
        ExpressionString expressionString0 = ExpressionString.valueOf(object0);
        int int0 = expressionString0.offsetByCodePoints(1, 1);
        assertEquals(2, int0);
    }

    @Test(timeout = 4000)
    public void test031() throws Throwable {
        ExpressionString expressionString0 = new ExpressionString("");
        boolean boolean0 = expressionString0.matches("");
        assertTrue(boolean0);
    }

    @Test(timeout = 4000)
    public void test032() throws Throwable {
        Locale locale0 = Locale.FRANCE;
        Object[] objectArray0 = new Object[8];
        ExpressionString expressionString0 = ExpressionString.format(locale0, "", objectArray0);
        int int0 = expressionString0.length();
        assertEquals(0, int0);
    }

    @Test(timeout = 4000)
    public void test033() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('p');
        expressionString0.length();
        assertEquals("p", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test034() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('|');
        int int0 = expressionString0.lastIndexOf("", 1);
        assertEquals("|", expressionString0.getDelegate());
        assertEquals(1, int0);
    }

    @Test(timeout = 4000)
    public void test035() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(0.0F);
        expressionString0.lastIndexOf("F=++9>}Plp-s.ehp", (-4126));
        assertEquals("0.0", expressionString0.toString());
    }

    @Test(timeout = 4000)
    public void test036() throws Throwable {
        char[] charArray0 = new char[0];
        ExpressionString expressionString0 = ExpressionString.valueOf(charArray0);
        int int0 = expressionString0.lastIndexOf("");
        assertEquals(0, int0);
    }

    @Test(timeout = 4000)
    public void test037() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(0);
        expressionString0.lastIndexOf("io.onsense.universe.ExpressionString");
        assertEquals("0", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test038() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('u');
        int int0 = expressionString0.lastIndexOf((int) 'u');
        assertEquals(0, int0);
    }

    @Test(timeout = 4000)
    public void test039() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(0L);
        CharSequence[] charSequenceArray0 = new CharSequence[0];
        ExpressionString expressionString1 = ExpressionString.join((CharSequence) expressionString0, charSequenceArray0);
        assertEquals("", expressionString1.toString());
    }

    @Test(timeout = 4000)
    public void test040() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(true);
        PriorityQueue<ExpressionString> priorityQueue0 = new PriorityQueue<ExpressionString>();
        priorityQueue0.add(expressionString0);
        ExpressionString expressionString1 = ExpressionString.join((CharSequence) expressionString0, (Iterable<? extends CharSequence>) priorityQueue0);
        assertEquals("true", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test041() throws Throwable {
        Locale locale0 = Locale.FRANCE;
        Object[] objectArray0 = new Object[4];
        ExpressionString expressionString0 = ExpressionString.format(locale0, "", objectArray0);
        boolean boolean0 = expressionString0.isEmpty();
        assertTrue(boolean0);
    }

    @Test(timeout = 4000)
    public void test042() throws Throwable {
        Object[] objectArray0 = new Object[9];
        ExpressionString expressionString0 = ExpressionString.format("", objectArray0);
        ExpressionString expressionString1 = expressionString0.intern();
        assertEquals(0, expressionString1.length());
    }

    @Test(timeout = 4000)
    public void test043() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf((Object) null);
        int int0 = expressionString0.indexOf("", 2494);
        assertEquals(0, int0);
    }

    @Test(timeout = 4000)
    public void test044() throws Throwable {
        char[] charArray0 = new char[6];
        ExpressionString expressionString0 = ExpressionString.valueOf(charArray0);
        int int0 = expressionString0.indexOf("!Rzq/j/", (-1));
        assertEquals((-1), int0);
    }

    @Test(timeout = 4000)
    public void test045() throws Throwable {
        CharSequence[] charSequenceArray0 = new CharSequence[2];
        ExpressionString expressionString0 = ExpressionString.join((CharSequence) "io.onsense.universe.ExpressionString", charSequenceArray0);
        int int0 = expressionString0.indexOf("io.onsense.universe.ExpressionString");
        assertEquals(4, int0);
    }

    @Test(timeout = 4000)
    public void test046() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf((-172L));
        expressionString0.indexOf("\"WxiOX)m,VsH`q]YC");
        assertEquals(4, expressionString0.length());
    }

    @Test(timeout = 4000)
    public void test047() throws Throwable {
        char[] charArray0 = new char[9];
        charArray0[0] = '>';
        ExpressionString expressionString0 = ExpressionString.copyValueOf(charArray0);
        int int0 = expressionString0.indexOf(0, 0);
        assertEquals(1, int0);
    }

    @Test(timeout = 4000)
    public void test048() throws Throwable {
        Object object0 = new Object();
        ExpressionString expressionString0 = ExpressionString.valueOf(object0);
        int int0 = expressionString0.indexOf(106);
        assertEquals(0, int0);
    }

    @Test(timeout = 4000)
    public void test049() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(0.0);
        String string0 = expressionString0.getDelegate();
        assertEquals("0.0", string0);
    }

    @Test(timeout = 4000)
    public void test050() throws Throwable {
        ExpressionString expressionString0 = new ExpressionString("");
        Charset charset0 = Charset.defaultCharset();
        byte[] byteArray0 = expressionString0.getBytes(charset0);
        assertEquals(0, byteArray0.length);
    }

    @Test(timeout = 4000)
    public void test051() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf((Object) null);
        byte[] byteArray0 = expressionString0.getBytes();
        assertEquals(0, byteArray0.length);
    }

    @Test(timeout = 4000)
    public void test052() throws Throwable {
        Object[] objectArray0 = new Object[2];
        ExpressionString expressionString0 = ExpressionString.format("io.onsense.universe.ExpressionString", objectArray0);
        boolean boolean0 = expressionString0.equalsIgnoreCase("io.onsense.universe.ExpressionString");
        assertTrue(boolean0);
    }

    @Test(timeout = 4000)
    public void test053() throws Throwable {
        ExpressionString expressionString0 = new ExpressionString("");
        boolean boolean0 = expressionString0.endsWith("");
        assertTrue(boolean0);
    }

    @Test(timeout = 4000)
    public void test054() throws Throwable {
        char[] charArray0 = new char[8];
        ExpressionString expressionString0 = ExpressionString.copyValueOf(charArray0, 1, 1);
        assertEquals("\u0000", expressionString0.toString());
    }

    @Test(timeout = 4000)
    public void test055() throws Throwable {
        ExpressionString expressionString0 = new ExpressionString("");
        StringBuffer stringBuffer0 = new StringBuffer(0);
        boolean boolean0 = expressionString0.contentEquals(stringBuffer0);
        assertTrue(boolean0);
    }

    @Test(timeout = 4000)
    public void test056() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('+');
        char[] charArray0 = new char[0];
        ExpressionString expressionString1 = ExpressionString.valueOf(charArray0);
        expressionString0.contentEquals((CharSequence) expressionString1);
        assertEquals("+", expressionString0.toString());
    }

    @Test(timeout = 4000)
    public void test057() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('%');
        Object[] objectArray0 = new Object[0];
        ExpressionString expressionString1 = ExpressionString.format("([NAy|$C/{uX", objectArray0);
        expressionString0.contains(expressionString1);
        assertEquals("%", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test058() throws Throwable {
        Locale locale0 = Locale.JAPANESE;
        ExpressionString expressionString0 = ExpressionString.format(locale0, "", (Object[]) null);
        ExpressionString expressionString1 = expressionString0.concat("");
        assertTrue(expressionString1.equals((Object) expressionString0));
    }

    @Test(timeout = 4000)
    public void test059() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('A');
        StringBuffer stringBuffer0 = new StringBuffer(0);
        ExpressionString expressionString1 = expressionString0.concat((CharSequence) stringBuffer0);
        assertEquals("A", expressionString1.toString());
    }

    @Test(timeout = 4000)
    public void test060() throws Throwable {
        StringWriter stringWriter0 = new StringWriter(1);
        StringBuffer stringBuffer0 = stringWriter0.getBuffer();
        ArrayDeque<String> arrayDeque0 = new ArrayDeque<String>();
        ExpressionString expressionString0 = ExpressionString.join((CharSequence) stringBuffer0, (Iterable<? extends CharSequence>) arrayDeque0);
        int int0 = expressionString0.compareToIgnoreCase("");
        assertEquals(0, int0);
    }

    @Test(timeout = 4000)
    public void test061() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf((-172L));
        int int0 = expressionString0.compareToIgnoreCase("\"WxiOX)m,VsH`q]YC");
        assertEquals(11, int0);
    }

    @Test(timeout = 4000)
    public void test062() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('%');
        int int0 = expressionString0.compareToIgnoreCase("K(?:N;q");
        assertEquals((-70), int0);
    }

    @Test(timeout = 4000)
    public void test063() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(true);
        int int0 = expressionString0.compareTo("pKchkC;1NN`");
        assertEquals(4, int0);
    }

    @Test(timeout = 4000)
    public void test064() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('+');
        int int0 = expressionString0.compareTo("pKchkC;1NN`");
        assertEquals((-69), int0);
    }

    @Test(timeout = 4000)
    public void test065() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(false);
        ExpressionString expressionString1 = new ExpressionString("HkR*s?%0WPq");
        int int0 = expressionString0.compareTo((CharSequence) expressionString1);
        assertEquals(30, int0);
    }

    @Test(timeout = 4000)
    public void test066() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(1223L);
        Locale locale0 = Locale.JAPAN;
        Object[] objectArray0 = new Object[2];
        ExpressionString expressionString1 = ExpressionString.format(locale0, "]{lK3a1H^HPfP7Ix", objectArray0);
        int int0 = expressionString0.compareTo((CharSequence) expressionString1);
        assertEquals((-44), int0);
    }

    @Test(timeout = 4000)
    public void test067() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(0L);
        int int0 = expressionString0.codePointCount(0, 0);
        assertEquals(0, int0);
    }

    @Test(timeout = 4000)
    public void test068() throws Throwable {
        ExpressionString expressionString0 = new ExpressionString("");
        ExpressionString expressionString1 = expressionString0.concat(")_yWv");
        int int0 = expressionString1.codePointBefore(1);
        assertEquals(41, int0);
    }

    @Test(timeout = 4000)
    public void test069() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf((-1.0F));
        char char0 = expressionString0.charAt(0);
        assertEquals('-', char0);
    }

    @Test(timeout = 4000)
    public void test070() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(6039.3223F);
        char char0 = expressionString0.charAt(1);
        assertEquals('0', char0);
    }

    @Test(timeout = 4000)
    public void test071() throws Throwable {
        byte[] byteArray0 = new byte[7];
        byteArray0[0] = (byte) 73;
        Charset charset0 = Charset.defaultCharset();
        ExpressionString expressionString0 = new ExpressionString(byteArray0, charset0);
        char char0 = expressionString0.charAt(0);
        assertEquals('I', char0);
    }

    @Test(timeout = 4000)
    public void test072() throws Throwable {
        ExpressionString expressionString0 = new ExpressionString("");
        ExpressionString expressionString1 = expressionString0.add("");
        assertTrue(expressionString1.equals((Object) expressionString0));
    }

    @Test(timeout = 4000)
    public void test073() throws Throwable {
        ExpressionString expressionString0 = new ExpressionString("");
        ExpressionString expressionString1 = expressionString0.add((Object) "");
        assertTrue(expressionString1.equals((Object) expressionString0));
    }

    @Test(timeout = 4000)
    public void test074() throws Throwable {
        char[] charArray0 = new char[4];
        ExpressionString expressionString0 = ExpressionString.copyValueOf(charArray0, 0, 0);
        ExpressionString expressionString1 = expressionString0.add(expressionString0);
        assertEquals("", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test075() throws Throwable {
        char[] charArray0 = new char[7];
        // Undeclared exception!
        try {
            ExpressionString.valueOf(charArray0, 0, (-1715));
            fail("Expecting exception: StringIndexOutOfBoundsException");

        } catch (StringIndexOutOfBoundsException e) {
        }
    }

    @Test(timeout = 4000)
    public void test076() throws Throwable {
        Assert.assertNotNull(ExpressionString.valueOf((char[]) null));
    }

    @Test(timeout = 4000)
    public void test077() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('u');
        Assert.assertNotNull(expressionString0.toUpperCase((Locale) null));
    }

    @Test(timeout = 4000)
    public void test078() throws Throwable {
        Locale locale0 = Locale.CHINESE;
        Object[] objectArray0 = new Object[2];
        ExpressionString expressionString0 = ExpressionString.format(locale0, "v-uD vfk", objectArray0);
        Assert.assertEquals("", expressionString0.substring((-6701), (-6701)).toString());
    }

    @Test(timeout = 4000)
    public void test079() throws Throwable {
        ExpressionString expressionString0 = new ExpressionString((String) null);
        Assert.assertEquals("", expressionString0.substring(1, 0).toString());
    }

    @Test(timeout = 4000)
    public void test080() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(true);

        Assert.assertEquals("true", expressionString0.substring((-816)).toString());

    }

    @Test(timeout = 4000)
    public void test081() throws Throwable {
        ExpressionString expressionString0 = new ExpressionString((String) null);

        Assert.assertEquals("", expressionString0.substring((-1)).toString());
    }

    @Test(timeout = 4000)
    public void test082() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('|');

        Assert.assertFalse(expressionString0.startsWith("", (-1)));

    }

    @Test(timeout = 4000, expected = PatternSyntaxException.class)
    public void test083() throws Throwable {
        byte[] byteArray0 = new byte[6];
        Charset charset0 = Charset.defaultCharset();
        ExpressionString expressionString0 = new ExpressionString(byteArray0, charset0);
        expressionString0.replaceFirst("[*R27z4%:[Ol3M", "`$E");
        fail("Expecting exception: PatternSyntaxException");

    }

    @Test(timeout = 4000)
    public void test084() throws Throwable {
        Locale locale0 = Locale.PRC;
        ExpressionString expressionString0 = ExpressionString.format(locale0, "SzFUX/", (Object[]) null);
        Assert.assertNotNull(expressionString0.replaceFirst("SzFUX/", (String) null));
    }

    @Test(timeout = 4000, expected = PatternSyntaxException.class)
    public void test085() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf((-2928L));

        expressionString0.replaceAll("[/[!0XqJM@<UQ<Id", (String) null);
        fail("Expecting exception: PatternSyntaxException");
    }

    @Test(timeout = 4000)
    public void test086() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf((-1529L));
        expressionString0.replaceAll((String) null, (String) null);
    }

    @Test(timeout = 4000, expected = IllegalArgumentException.class)
    public void test087() throws Throwable {
        Object[] objectArray0 = new Object[2];
        ExpressionString expressionString0 = ExpressionString.format("io.onsense.universe.ExpressionString", objectArray0);

        expressionString0.replaceAll("", "$u<<P-c=!O");
        fail("Expecting exception: IllegalArgumentException");

    }

    @Test(timeout = 4000)
    public void test088() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(true);

        Assert.assertNotNull(expressionString0.replace((CharSequence) null, (CharSequence) null));
    }

    @Test(timeout = 4000)
    public void test089() throws Throwable {
        char[] charArray0 = new char[2];
        ExpressionString expressionString0 = ExpressionString.valueOf(charArray0, 0, 0);
        expressionString0.regionMatches(0, (String) null, 0, (-4209));

    }

    @Test(timeout = 4000)
    public void test090() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(0.0F);
        expressionString0.matches((String) null);

    }

    @Test(timeout = 4000)
    public void test091() throws Throwable {
        Object object0 = new Object();
        ExpressionString expressionString0 = ExpressionString.valueOf(object0);

        Assert.assertFalse(expressionString0.matches("Q^p\"uPC@"));

    }

    @Test(timeout = 4000)
    public void test092() throws Throwable {
        ExpressionString expressionString0 = new ExpressionString((String) null);

        expressionString0.lastIndexOf(0);

    }

    @Test(timeout = 4000)
    public void test093() throws Throwable {
        CharSequence[] charSequenceArray0 = new CharSequence[1];
        ExpressionString.join((CharSequence) null, charSequenceArray0);

    }

    @Test(timeout = 4000)
    public void test094() throws Throwable {
        ArrayList<String> arrayList0 = new ArrayList<String>();
        HashSet<String> hashSet0 = new HashSet<String>(arrayList0);

        ExpressionString.join((CharSequence) null, (Iterable<? extends CharSequence>) hashSet0);

    }

    @Test(timeout = 4000)
    public void test095() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('u');

        expressionString0.indexOf((String) null);

    }

    @Test(timeout = 4000)
    public void test096() throws Throwable {
        ExpressionString expressionString0 = new ExpressionString((String) null);

        expressionString0.hashCode();

    }

    @Test(timeout = 4000)
    public void test097() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf((-172L));

        expressionString0.getChars(2135, 3588, (char[]) null, (-1967));

    }

    @Test(timeout = 4000, expected = ArrayIndexOutOfBoundsException.class)
    public void test098() throws Throwable {
        char[] charArray0 = new char[6];
        ExpressionString expressionString0 = ExpressionString.copyValueOf(charArray0);

        expressionString0.getChars(0, 0, charArray0, (-3894));
        fail("Expecting exception: ArrayIndexOutOfBoundsException");

    }

    @Test(timeout = 4000)
    public void test099() throws Throwable {
        char[] charArray0 = new char[3];
        ExpressionString expressionString0 = ExpressionString.valueOf(charArray0, 0, 0);

        expressionString0.getBytes((Charset) null);

    }

    @Test(timeout = 4000)
    public void test100() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf((Object) null);

        expressionString0.getBytes((String) null);

    }

    @Test(timeout = 4000)
    public void test101() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(false);

        expressionString0.getBytes(1, 1, (byte[]) null, (-1));

    }

    @Test(timeout = 4000, expected = UnknownFormatConversionException.class)
    public void test102() throws Throwable {
        Locale locale0 = Locale.US;
        Object[] objectArray0 = new Object[1];

        ExpressionString.format(locale0, "^Uc]tGvEHy1%ToQe8}", objectArray0);
        fail("Expecting exception: UnknownFormatConversionException");

    }

    @Test(timeout = 4000, expected = IllegalFormatConversionException.class)
    public void test103() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(true);
        Locale locale0 = Locale.ROOT;
        Object[] objectArray0 = new Object[8];
        objectArray0[0] = (Object) expressionString0;

        ExpressionString.format(locale0, "%dKOB&[)<>.5ll,;|[", objectArray0);
        fail("Expecting exception: IllegalFormatConversionException");


    }

    @Test(timeout = 4000)
    public void test104() throws Throwable {
        Locale locale0 = Locale.TAIWAN;
        Object[] objectArray0 = new Object[7];

        ExpressionString.format(locale0, (String) null, objectArray0);

    }

    @Test(timeout = 4000, expected = UnknownFormatConversionException.class)
    public void test105() throws Throwable {
        Object[] objectArray0 = new Object[5];

        ExpressionString.format("q>*% ", objectArray0);
        fail("Expecting exception: UnknownFormatConversionException");


    }

    @Test(timeout = 4000)
    public void test106() throws Throwable {
        Object[] objectArray0 = new Object[4];

        ExpressionString.format((String) null, objectArray0);

    }

    @Test(timeout = 4000)
    public void test107() throws Throwable {

        ExpressionString.copyValueOf((char[]) null, 0, 0);

    }

    @Test(timeout = 4000)
    public void test108() throws Throwable {

        ExpressionString.copyValueOf((char[]) null);

    }

    @Test(timeout = 4000)
    public void test109() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('%');

        expressionString0.contains((CharSequence) null);

    }

    @Test(timeout = 4000)
    public void test110() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(0.0);

        expressionString0.concat((String) null);

    }

    @Test(timeout = 4000)
    public void test111() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('u');

        expressionString0.concat((CharSequence) null);

    }

    @Test(timeout = 4000, expected = StringIndexOutOfBoundsException.class)
    public void test113() throws Throwable {
        ExpressionString expressionString0 = new ExpressionString("VpfAV#G[5sJcXVY='");

        expressionString0.codePointAt(1993);
        fail("Expecting exception: StringIndexOutOfBoundsException");

    }

    @Test(timeout = 4000)
    public void test114() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf((-1485));

        expressionString0.add((ExpressionString) null);

    }

    @Test(timeout = 4000)
    public void test115() throws Throwable {
        Charset charset0 = Charset.defaultCharset();
        ExpressionString expressionString0 = null;

        expressionString0 = new ExpressionString((byte[]) null, charset0);

    }

    @Test(timeout = 4000)
    public void test116() throws Throwable {
        ExpressionString.valueOf((CharSequence) null);

    }

    @Test(timeout = 4000, expected = StringIndexOutOfBoundsException.class)
    public void test117() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('x');

        expressionString0.charAt((-1));
        fail("Expecting exception: StringIndexOutOfBoundsException");

    }

    @Test(timeout = 4000)
    public void test118() throws Throwable {
        ExpressionString expressionString0 = new ExpressionString("");
        String string0 = expressionString0.toString();
        assertEquals("", string0);
    }

    @Test(timeout = 4000)
    public void test119() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(1223L);
        expressionString0.compareTo((CharSequence) expressionString0);
        assertEquals("1223", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test120() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(0.0F);
        int int0 = expressionString0.compareTo((CharSequence) "0.0");
        assertEquals(0, int0);
    }

    @Test(timeout = 4000)
    public void test121() throws Throwable {
        Object[] objectArray0 = new Object[2];
        ExpressionString expressionString0 = ExpressionString.format("io.onsense.universe.ExpressionString", objectArray0);
        CharSequence[] charSequenceArray0 = new CharSequence[2];
        ExpressionString expressionString1 = ExpressionString.join((CharSequence) "io.onsense.universe.ExpressionString", charSequenceArray0);
        boolean boolean0 = expressionString0.equals(expressionString1);
        assertFalse(boolean0);
    }

    @Test(timeout = 4000)
    public void test123() throws Throwable {
        Object object0 = new Object();
        ExpressionString expressionString0 = ExpressionString.valueOf(object0);
        boolean boolean0 = expressionString0.equals(object0);
        assertFalse(boolean0);
    }

    @Test(timeout = 4000)
    public void test124() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(0);
        int int0 = expressionString0.lastIndexOf("", 0);
        assertEquals(0, int0);
        assertEquals("0", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test125() throws Throwable {
        char[] charArray0 = new char[4];
        ExpressionString expressionString0 = ExpressionString.copyValueOf(charArray0, 0, 0);
        Assert.assertEquals("", expressionString0.subSequence(1405, 1405).toString());
    }

    @Test(timeout = 4000)
    public void test126() throws Throwable {
        Object object0 = new Object();
        ExpressionString expressionString0 = ExpressionString.valueOf(object0);
        int int0 = expressionString0.codePointAt(0);
        assertEquals(106, int0);
    }

    @Test(timeout = 4000)
    public void test127() throws Throwable {
        Object[] objectArray0 = new Object[9];
        ExpressionString expressionString0 = ExpressionString.format("", objectArray0);
        // Undeclared exception!
        try {
            expressionString0.offsetByCodePoints((-1), 0);
            fail("Expecting exception: IndexOutOfBoundsException");

        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test(timeout = 4000)
    public void test128() throws Throwable {
        char[] charArray0 = new char[0];
        ExpressionString expressionString0 = ExpressionString.valueOf(charArray0);
        byte[] byteArray0 = expressionString0.getBytes();
        assertArrayEquals(new byte[]{}, byteArray0);
    }

    @Test(timeout = 4000)
    public void test129() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(3026L);
        byte[] byteArray0 = new byte[5];
        // Undeclared exception!
        try {
            expressionString0.getBytes(1, 0, byteArray0, (int) (byte) 1);
            fail("Expecting exception: StringIndexOutOfBoundsException");

        } catch (StringIndexOutOfBoundsException e) {
        }
    }

    @Test(timeout = 4000)
    public void test130() throws Throwable {
        Object[] objectArray0 = new Object[9];
        ExpressionString expressionString0 = ExpressionString.format("", objectArray0);
        String string0 = expressionString0.getDelegate();
        assertEquals("", string0);
    }

    @Test(timeout = 4000)
    public void test131() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('%');
        ExpressionString expressionString1 = expressionString0.trim();
        assertEquals("%", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test132() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(true);
        expressionString0.isEmpty();
        assertEquals("true", expressionString0.toString());
    }

    @Test(timeout = 4000)
    public void test133() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(false);
        expressionString0.regionMatches(0, "", (-1), 2431);
        assertEquals("false", expressionString0.toString());
    }

    @Test(timeout = 4000)
    public void test134() throws Throwable {
        char[] charArray0 = new char[0];
        ExpressionString expressionString0 = ExpressionString.copyValueOf(charArray0);
        assertEquals("", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test135() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('+');
        expressionString0.startsWith((String) null);
    }

    @Test(timeout = 4000)
    public void test136() throws Throwable {
        char[] charArray0 = new char[3];
        ExpressionString expressionString0 = ExpressionString.valueOf(charArray0, 0, 0);
        expressionString0.substring(0, 0);
        assertEquals(0, expressionString0.length());
    }

    @Test(timeout = 4000)
    public void test137() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('+');
        expressionString0.lastIndexOf("");
        assertEquals("+", expressionString0.toString());
    }

    @Test(timeout = 4000)
    public void test138() throws Throwable {
        char[] charArray0 = new char[0];
        ExpressionString expressionString0 = ExpressionString.valueOf(charArray0);
        int int0 = expressionString0.lastIndexOf(0);
        assertEquals((-1), int0);
    }

    @Test(timeout = 4000)
    public void test139() throws Throwable {
        Object object0 = new Object();
        ExpressionString expressionString0 = ExpressionString.valueOf(object0);
        expressionString0.indexOf(3708);
        //  // Unstable assertion: assertEquals(25, expressionString0.length());
    }

    @Test(timeout = 4000)
    public void test140() throws Throwable {
        Object object0 = new Object();
        ExpressionString expressionString0 = ExpressionString.valueOf(object0);
        String string0 = "\\";
        boolean boolean0 = expressionString0.endsWith(string0);
        assertFalse(boolean0);
    }

    @Test(timeout = 4000)
    public void test141() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('+');
        ExpressionString expressionString1 = expressionString0.toUpperCase();
        assertEquals("+", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test142() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('%');
        expressionString0.hashCode();
        assertEquals("%", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test143() throws Throwable {
        char[] charArray0 = new char[4];
        ExpressionString expressionString0 = ExpressionString.copyValueOf(charArray0, 0, 0);
        expressionString0.indexOf("");
        assertEquals(0, expressionString0.length());
    }

    @Test(timeout = 4000)
    public void test144() throws Throwable {
        Object[] objectArray0 = new Object[9];
        ExpressionString expressionString0 = ExpressionString.format("", objectArray0);
        int int0 = expressionString0.compareTo("");
        assertEquals(0, int0);
    }

    @Test(timeout = 4000)
    public void test145() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('%');
        ExpressionString expressionString1 = expressionString0.add("K(?:N;q");
        assertEquals("%K(?:N;q", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test146() throws Throwable {
        Object object0 = new Object();
        ExpressionString expressionString0 = ExpressionString.valueOf(object0);
        ExpressionString expressionString1 = expressionString0.replaceFirst("$u<<P-c=!O", "$u<<P-c=!O");
        assertNotSame(expressionString1, expressionString0);
    }

    @Test(timeout = 4000)
    public void test147() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(true);
        ExpressionString expressionString1 = expressionString0.toLowerCase();
        assertEquals("true", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test148() throws Throwable {
        ExpressionString expressionString0 = new ExpressionString("");
        // Undeclared exception!
        try {
            expressionString0.codePointBefore(1);
            fail("Expecting exception: StringIndexOutOfBoundsException");

        } catch (StringIndexOutOfBoundsException e) {
        }
    }

    @Test(timeout = 4000)
    public void test149() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('%');
        ExpressionString expressionString1 = expressionString0.intern();
        assertEquals("%", expressionString1.toString());
    }

    @Test(timeout = 4000)
    public void test150() throws Throwable {
        ExpressionString expressionString0 = new ExpressionString("");
        int int0 = expressionString0.indexOf("", 3);
        assertEquals(0, int0);
    }

    @Test(timeout = 4000)
    public void test151() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(true);
        char[] charArray0 = expressionString0.toCharArray();
        assertEquals(4, charArray0.length);
    }

    @Test(timeout = 4000)
    public void test152() throws Throwable {
        Object object0 = new Object();
        ExpressionString expressionString0 = ExpressionString.valueOf(object0);
        boolean boolean0 = expressionString0.matches("");
        assertFalse(boolean0);
    }

    @Test(timeout = 4000)
    public void test153() throws Throwable {
        Object object0 = new Object();
        ExpressionString expressionString0 = ExpressionString.valueOf(object0);
        boolean boolean0 = expressionString0.equalsIgnoreCase("$u<<P-c=!O");
        assertFalse(boolean0);
    }

    @Test(timeout = 4000)
    public void test154() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('%');
        ExpressionString expressionString1 = expressionString0.replaceAll("", "");
        assertEquals("%", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test155() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(false);
        try {
            expressionString0.getBytes("~42x0&z(+xlojywx:~42x0&z(+xlojywx:");
            fail("Expecting exception: UnsupportedEncodingException");

        } catch (UnsupportedEncodingException e) {
        }
    }

    @Test(timeout = 4000)
    public void test156() throws Throwable {
        char[] charArray0 = new char[0];
        ExpressionString expressionString0 = ExpressionString.valueOf(charArray0);
        ExpressionString expressionString1 = expressionString0.concat((CharSequence) expressionString0);
        assertEquals("", expressionString1.toString());
    }

    @Test(timeout = 4000)
    public void test157() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('L');
        char[] charArray0 = new char[1];
        expressionString0.getChars(1, 1, charArray0, 1);
        assertEquals("L", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test158() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('+');
        Locale locale0 = Locale.TAIWAN;
        ExpressionString expressionString1 = expressionString0.toUpperCase(locale0);
        assertEquals("+", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test159() throws Throwable {
        Locale locale0 = Locale.SIMPLIFIED_CHINESE;
        Object[] objectArray0 = new Object[3];
        ExpressionString expressionString0 = ExpressionString.format(locale0, "io.onsense.universe.ExpressionString", objectArray0);
        // Undeclared exception!
        try {
            expressionString0.codePointCount(1615, (-1));
            fail("Expecting exception: IndexOutOfBoundsException");

        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Test(timeout = 4000)
    public void test160() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('%');
        ExpressionString expressionString1 = expressionString0.replace((CharSequence) expressionString0, (CharSequence) "K(?:N;q");
        assertEquals("%", expressionString0.getDelegate());
        assertEquals("K(?:N;q", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test161() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('%');
        expressionString0.contains(expressionString0);
        assertEquals("%", expressionString0.toString());
    }

    @Test(timeout = 4000)
    public void test162() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(true);

        Assert.assertNotNull(expressionString0.toLowerCase((Locale) null));
    }

    @Test(timeout = 4000)
    public void test163() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(false);
        Charset charset0 = Charset.defaultCharset();
        byte[] byteArray0 = expressionString0.getBytes(charset0);
        assertEquals(5, byteArray0.length);
    }

    @Test(timeout = 4000)
    public void test164() throws Throwable {
        char[] charArray0 = new char[0];
        ExpressionString expressionString0 = ExpressionString.valueOf(charArray0);
        ExpressionString expressionString1 = expressionString0.substring(0);
        assertEquals("", expressionString1.toString());
    }

    @Test(timeout = 4000)
    public void test165() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(true);
        PriorityQueue<ExpressionString> priorityQueue0 = new PriorityQueue<ExpressionString>();
        ExpressionString expressionString1 = expressionString0.add((Object) priorityQueue0);
        assertEquals(6, expressionString1.length());
    }

    @Test(timeout = 4000)
    public void test166() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(false);
        ExpressionString expressionString1 = expressionString0.add(expressionString0);
        assertEquals("falsefalse", expressionString1.getDelegate());
    }

    @Test(timeout = 4000)
    public void test167() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(true);
        expressionString0.codePoints();
        assertEquals("true", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test168() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(true);
        expressionString0.startsWith("java.lang.Object@7ca0dbdd", 1);
        assertEquals("true", expressionString0.toString());
    }

    @Test(timeout = 4000)
    public void test169() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf(2481.2327F);
        StringBuffer stringBuffer0 = new StringBuffer();
        expressionString0.contentEquals(stringBuffer0);
        assertEquals("2481.2327", expressionString0.toString());
    }

    @Test(timeout = 4000)
    public void test170() throws Throwable {
        Object object0 = new Object();
        ExpressionString expressionString0 = ExpressionString.valueOf(object0);
        IntStream intStream0 = expressionString0.chars();
        assertNotNull(intStream0);
    }

    @Test(timeout = 4000)
    public void test171() throws Throwable {
        char[] charArray0 = new char[4];
        ExpressionString expressionString0 = ExpressionString.valueOf(charArray0, 0, 0);

        expressionString0.compareToIgnoreCase((String) null);

    }

    @Test(timeout = 4000)
    public void test172() throws Throwable {
        ExpressionString expressionString0 = ExpressionString.valueOf('+');
        expressionString0.contentEquals((CharSequence) expressionString0);
        assertEquals("+", expressionString0.getDelegate());
    }

    @Test(timeout = 4000)
    public void test173() throws Throwable {
        ExpressionString.valueOf((char[]) null, 1, 1);
    }
}
