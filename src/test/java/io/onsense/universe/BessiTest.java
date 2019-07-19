package io.onsense.universe;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertSame;

/**
 * @author Koen Rooijmans
 */
public class BessiTest {

    @Test
    public void testConstructor() {
        Assert.assertNotNull(new Bessi());
    }

    @Test
    public void test3() throws Throwable {
        BigDecimal bigDecimal0 = BigDecimal.ZERO;
        BigDecimal bigDecimal1 = Bessi.bessi(861, bigDecimal0);
        assertSame(bigDecimal0, bigDecimal1);
    }
}