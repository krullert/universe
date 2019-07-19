package io.onsense.universe.format;

import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

/**
 * @author Koen Rooijmans
 */
public class BarcodeTypeTest {

    @Test
    public void lookup() {
        Assert.assertEquals(BarcodeType.AZTEC, BarcodeType.lookup("AZTEC"));
        Assert.assertEquals(BarcodeType.AZTEC, BarcodeType.lookup("aztec"));
        Assert.assertEquals(BarcodeType.CODE11, BarcodeType.lookup("CODE11"));
        Assert.assertEquals(BarcodeType.CODE11, BarcodeType.lookup("CODE-11"));
        Assert.assertEquals(BarcodeType.CODE11, BarcodeType.lookup("CODE 11"));
        Assert.assertEquals(BarcodeType.CODE11, BarcodeType.lookup("code11"));
        Assert.assertEquals(BarcodeType.CODE11, BarcodeType.lookup("code-11"));
        Assert.assertEquals(BarcodeType.CODE11, BarcodeType.lookup("code 11"));
    }

    @Test(expected = NoSuchElementException.class)
    public void invalidLookup() {
        Assert.assertEquals(BarcodeType.CODE11, BarcodeType.lookup("CODE  1337 "));
    }
}