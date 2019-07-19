package io.onsense.universe;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Koen Rooijmans
 */
public class StringsTest {

    @Test(timeout = 10000L)
    public void testStringsConstructor() throws Exception {
        Assert.assertNotNull(new Strings());
    }

    @Test(timeout = 10000L)
    public void testStartWith() {
        Assert.assertTrue(Strings.startsWithChar("asd", 'a'));
        Assert.assertFalse(Strings.startsWithChar("asd", 's'));
        Assert.assertFalse(Strings.startsWithChar("", 'a'));

        Assert.assertTrue(Strings.endsWithChar("asd", 'd'));
        Assert.assertFalse(Strings.endsWithChar("asd", 's'));
        Assert.assertFalse(Strings.endsWithChar("", 'd'));
    }

    @Test(timeout = 10000L)
    public void testSubstring() {
        Assert.assertEquals("2", Strings.substring("123", 1, 2));
        Assert.assertEquals("23", Strings.substring("123", 1, 2000));
        Assert.assertEquals("123", Strings.substring("123", -1000, 2000));
        Assert.assertEquals("", Strings.substring("123", 1, 1));

        Assert.assertEquals("2", Strings.substring("123", 1, -1));
        Assert.assertEquals("", Strings.substring("123", 1, -2));
        Assert.assertEquals("", Strings.substring("123", 2, -1));

        Assert.assertEquals("2", Strings.substring("123", -2, -1));

        Assert.assertEquals("23", Strings.substring("123", -2, 0));

        Assert.assertEquals("AbCdE", Strings.substring("AbCdEf", 0, -1));
        Assert.assertEquals("dEf", Strings.substring("AbCdEf", -3, 0));
        Assert.assertEquals("dE", Strings.substring("AbCdEf", -3, -1));
        Assert.assertEquals("AbCdE", Strings.substring("AbCdEf", -3000, -1));
        Assert.assertEquals("", Strings.substring("AbCdEf", 1000, 2000));
    }

    @Test(timeout = 10000L)
    public void testRemoveQuotes() {
        Assert.assertEquals("123", Strings.removeQuotes("123"));
        Assert.assertEquals("'123", Strings.removeQuotes("'123"));
        Assert.assertEquals("123", Strings.removeQuotes("'123'"));
        Assert.assertEquals("123'", Strings.removeQuotes("123'"));

        Assert.assertEquals("\"123", Strings.removeQuotes("\"123"));
        Assert.assertEquals("123", Strings.removeQuotes("\"123\""));
        Assert.assertEquals("123\"", Strings.removeQuotes("123\""));

        Assert.assertEquals("'123\"", Strings.removeQuotes("'123\""));
        Assert.assertEquals("\"123'", Strings.removeQuotes("\"123'"));
    }
}