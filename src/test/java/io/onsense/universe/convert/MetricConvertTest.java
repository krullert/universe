package io.onsense.universe.convert;

import io.onsense.universe.FormulaDecimal;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import tec.units.indriya.unit.MetricPrefix;

import javax.measure.Unit;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.text.DecimalFormat;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * @author Koen Rooijmans
 */
public class MetricConvertTest {

    @Test
    public void testSynonyms() {
        Assert.assertEquals(MetricConvert.getUnit("parsec"), MetricConvert.getUnit("pc"));
        Assert.assertEquals(MetricConvert.getUnit("Picapt"), MetricConvert.getUnit("Pica"));
        Assert.assertNotEquals(MetricConvert.getUnit("Picapt"), MetricConvert.getUnit("pica"));
        Assert.assertEquals(MetricConvert.getUnit("min"), MetricConvert.getUnit("mn"));
        Assert.assertEquals(MetricConvert.getUnit("sec"), MetricConvert.getUnit("s"));
        Assert.assertEquals(MetricConvert.getUnit("atm"), MetricConvert.getUnit("at"));
        Assert.assertEquals(MetricConvert.getUnit("psi"), MetricConvert.getUnit("lbf/in^2"));
        Assert.assertEquals(MetricConvert.getUnit("psi"), MetricConvert.getUnit("lbf/in2"));
        Assert.assertEquals(MetricConvert.getUnit("dyn"), MetricConvert.getUnit("dy"));
        Assert.assertEquals(MetricConvert.getUnit("ev"), MetricConvert.getUnit("eV"));
        Assert.assertEquals(MetricConvert.getUnit("btu"), MetricConvert.getUnit("BTU"));
        Assert.assertEquals(MetricConvert.getUnit("pt"), MetricConvert.getUnit("us_pt"));
        Assert.assertEquals(MetricConvert.getUnit("l"), MetricConvert.getUnit("lt"));
        Assert.assertEquals(MetricConvert.getUnit("l"), MetricConvert.getUnit("L"));
        Assert.assertEquals(MetricConvert.getUnit("ang3"), MetricConvert.getUnit("ang^3"));
        Assert.assertEquals(MetricConvert.getUnit("barrel"), MetricConvert.getUnit("bbl"));

        Assert.assertEquals(MetricConvert.getUnit("ft3"), MetricConvert.getUnit("ft^3"));
        Assert.assertEquals(MetricConvert.getUnit("in3"), MetricConvert.getUnit("in^3"));
        Assert.assertEquals(MetricConvert.getUnit("ly3"), MetricConvert.getUnit("ly^3"));
        Assert.assertEquals(MetricConvert.getUnit("m3"), MetricConvert.getUnit("m^3"));
        Assert.assertEquals(MetricConvert.getUnit("mi3"), MetricConvert.getUnit("mi^3"));
        Assert.assertEquals(MetricConvert.getUnit("Nmi3"), MetricConvert.getUnit("Nmi^3"));
        Assert.assertEquals(MetricConvert.getUnit("Picapt3"), MetricConvert.getUnit("Picapt^3"));
        Assert.assertEquals(MetricConvert.getUnit("GRT"), MetricConvert.getUnit("regton"));
//        Assert.assertEquals(MetricConvert.getUnit("GRT"), MetricConvert.getUnit("MTON"));

        Assert.assertEquals(MetricConvert.getUnit("ft2"), MetricConvert.getUnit("ft^2"));
        Assert.assertEquals(MetricConvert.getUnit("in2"), MetricConvert.getUnit("in^2"));
        Assert.assertEquals(MetricConvert.getUnit("ly2"), MetricConvert.getUnit("ly^2"));
        Assert.assertEquals(MetricConvert.getUnit("m2"), MetricConvert.getUnit("m^2"));
        Assert.assertEquals(MetricConvert.getUnit("mi2"), MetricConvert.getUnit("mi^2"));
        Assert.assertEquals(MetricConvert.getUnit("Nmi2"), MetricConvert.getUnit("Nmi^2"));
        Assert.assertEquals(MetricConvert.getUnit("Picapt2"), MetricConvert.getUnit("Picapt^2"));
        Assert.assertEquals(MetricConvert.getUnit("Pica2"), MetricConvert.getUnit("Pica^2"));
        Assert.assertEquals(MetricConvert.getUnit("yd2"), MetricConvert.getUnit("yd^2"));

        Assert.assertEquals(MetricConvert.getUnit("m/s"), MetricConvert.getUnit("m/sec"));
    }

    @Test
    public void testHorsePower() {

        Assert.assertNotEquals(1, MetricConvert.convert(1, "HP", "PS"));

        DecimalFormat df = new DecimalFormat("#,###.000000000000");

        Assert.assertEquals(df.format(new BigDecimal("0.0013596216173")), df.format(MetricConvert.convert(1, "w", "PS").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal("0.0013410220896")), df.format(MetricConvert.convert(1, "w", "HP").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal("0.0013410220896")), df.format(MetricConvert.convert(1, "w", "h").asBigDecimal()));
    }

    @Test(expected = NoSuchElementException.class)
    public void testToUnitNull() {
        MetricConvert.convert(1, "bruv", null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testToUnitInvalid() {
        MetricConvert.convert(1, "g", "bruv");
    }

    @Test(expected = NoSuchElementException.class)
    public void testFromUnitNull() {
        MetricConvert.convert(1, null, "bruv");
    }

    @Test(expected = NoSuchElementException.class)
    public void testFromUnitInvalid() {
        MetricConvert.convert(1, "bruv", "g");
    }

    @Test
    public void testYoctaPrefixValue() {
        final MetricPrefix metricPrefix = MetricPrefix.YOCTO;
        Assert.assertEquals("prefix: " + metricPrefix.getSymbol(),
                new BigDecimal(BigDecimal.valueOf(MetricConvert.getMetricPrefix(metricPrefix.getSymbol()).getConverter().convert(10)).stripTrailingZeros().toPlainString()),
                new BigDecimal(MetricConvert.getPrefixValue(metricPrefix.getSymbol()).multiply(FormulaDecimal.TEN).asBigDecimal().stripTrailingZeros().toPlainString()));
    }

    @Test
    public void testPrefixValue() {
        for (MetricPrefix metricPrefix : MetricPrefix.values()) {
            if (metricPrefix == MetricPrefix.YOCTO) {
                // TODO this is actually a bug in uom lib.. (1 results into wrong value).
                Assert.assertEquals("prefix: " + metricPrefix.getSymbol(),
                        new BigDecimal(BigDecimal.valueOf(MetricConvert.getMetricPrefix(metricPrefix.getSymbol()).getConverter().convert(10)).stripTrailingZeros().toPlainString()),
                        new BigDecimal(MetricConvert.getPrefixValue(metricPrefix.getSymbol()).multiply(FormulaDecimal.TEN).asBigDecimal().stripTrailingZeros().toPlainString()));
            } else {
                Assert.assertEquals("prefix: " + metricPrefix.getSymbol(),
                        new BigDecimal(BigDecimal.valueOf(MetricConvert.getMetricPrefix(metricPrefix.getSymbol()).getConverter().convert(1)).stripTrailingZeros().toPlainString()),
                        new BigDecimal(MetricConvert.getPrefixValue(metricPrefix.getSymbol()).multiply(FormulaDecimal.ONE).asBigDecimal().stripTrailingZeros().toPlainString()));
            }
        }
    }

    @Test
    public void testCubicPica() {

        Assert.assertNotEquals(1, MetricConvert.convert(1, "in3", "Picapt3"));

        DecimalFormat df = new DecimalFormat("#,###.000000000000");

        Assert.assertEquals(df.format(new BigDecimal("373248")), df.format(MetricConvert.convert(1, "in3", "Picapt3").asBigDecimal()));
    }


    @Test
    public void testSquarePica() {

        Assert.assertNotEquals(1, MetricConvert.convert(1, "in2", "Picapt2"));

        DecimalFormat df = new DecimalFormat("#,###.000000000000");

        Assert.assertEquals(df.format(new BigDecimal("5184")), df.format(MetricConvert.convert(1, "in2", "Picapt2").asBigDecimal()));
    }

    @Test
    public void testMorgen() {

        Assert.assertNotEquals(1, MetricConvert.convert(1, "in2", "Morgen"));

        DecimalFormat df = new DecimalFormat("#,###.000000000000");

        Assert.assertEquals(df.format(new BigDecimal(2.58064E-07)), df.format(MetricConvert.convert(1, "in2", "Morgen").asBigDecimal()));
    }

    @Test
    public void testGRT() {

        Assert.assertNotEquals(1, MetricConvert.convert(1, "in3", "GRT"));

        DecimalFormat df = new DecimalFormat("#,###.00000000000");

        Assert.assertEquals(df.format(new BigDecimal(5.78704E-06)), df.format(MetricConvert.convert(1, "in3", "GRT").asBigDecimal()));
    }


    @Test
    public void testHorsepowerHour() {

        Assert.assertNotEquals(1, MetricConvert.convert(1, "J", "HPh"));

        DecimalFormat df = new DecimalFormat("#,###.000000000000000");

        Assert.assertEquals(df.format(new BigDecimal(0.000000372506136)), df.format(MetricConvert.convert(1, "J", "HPh").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(0.000000372506136)), df.format(MetricConvert.convert(1, "J", "hh").asBigDecimal()));
    }

    @Test
    public void testWattHour() {

        Assert.assertNotEquals(1, MetricConvert.convert(1, "J", "Wh"));

        DecimalFormat df = new DecimalFormat("#,###.000000000");

        Assert.assertEquals(df.format(new BigDecimal(0.000277778)), df.format(MetricConvert.convert(1, "J", "Wh").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(0.000277778)), df.format(MetricConvert.convert(1, "J", "wh").asBigDecimal()));
    }

    @Test
    public void testFootPound() {

        Assert.assertNotEquals(1, MetricConvert.convert(1, "J", "flb"));

        DecimalFormat df = new DecimalFormat("#,###.000000000");

        Assert.assertEquals(df.format(new BigDecimal(0.737562149)), df.format(MetricConvert.convert(1, "J", "flb").asBigDecimal()));
    }

    @Test
    public void testMetrePerHour() {

        Assert.assertNotEquals(1, MetricConvert.convert(1, "m/s", "m/h"));
        Assert.assertNotEquals(1, MetricConvert.convert(1, "m/s", "m/hr"));

        DecimalFormat df = new DecimalFormat("#,###.000000000");

        Assert.assertEquals(df.format(new BigDecimal(3600)), df.format(MetricConvert.convert(1, "m/s", "m/hr").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(3600)), df.format(MetricConvert.convert(1, "m/s", "m/h").asBigDecimal()));
    }

    @Test
    public void testMetricConvert() {
        DecimalFormat df = new DecimalFormat("#,###.000000000");

        Assert.assertEquals(df.format(new BigDecimal(0.000621371)), df.format(MetricConvert.convert(1, "m", "mi").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(0.000539957)), df.format(MetricConvert.convert(1, "m", "Nmi").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(39.37007874)), df.format(MetricConvert.convert(1, "m", "in").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(3.280839895)), df.format(MetricConvert.convert(1, "m", "ft").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(1.093613298)), df.format(MetricConvert.convert(1, "m", "yd").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(10000000000L)), df.format(MetricConvert.convert(1, "m", "ang").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(2834.645669291)), df.format(MetricConvert.convert(1, "m", "Pica").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(236.220472441)), df.format(MetricConvert.convert(1, "m", "pica").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(9.86923E-06)), df.format(MetricConvert.convert(1, "p", "atm").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(100000)), df.format(MetricConvert.convert(1, "N", "dyn").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(100000)), df.format(MetricConvert.convert(1, "N", "dy").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(0.224808943)), df.format(MetricConvert.convert(1, "N", "lbf").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(10000000)), df.format(MetricConvert.convert(1, "J", "e").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(0.239005736)), df.format(MetricConvert.convert(1, "J", "c").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(0.238845897)), df.format(MetricConvert.convert(1, "J", "cal").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(0.000277778)), df.format(MetricConvert.convert(1, "J", "Wh").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(0.000277778)), df.format(MetricConvert.convert(1, "J", "wh").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(0.737562149)), df.format(MetricConvert.convert(1, "J", "flb").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(0.001341022)), df.format(MetricConvert.convert(1, "w", "HP").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(0.001341022)), df.format(MetricConvert.convert(1, "w", "h").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(10000)), df.format(MetricConvert.convert(1, "T", "ga").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(-272.15)), df.format(MetricConvert.convert(1, "kel", "°C").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(-272.15)), df.format(MetricConvert.convert(1, "kel", "cel").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(-457.87)), df.format(MetricConvert.convert(1, "kel", "°F").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(-457.87)), df.format(MetricConvert.convert(1, "kel", "fah").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(1)), df.format(MetricConvert.convert(1, "kel", "K").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(1)), df.format(MetricConvert.convert(1, "kel", "kel").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(33.814022702)), df.format(MetricConvert.convert(1, "lt", "oz").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(4.226752838)), df.format(MetricConvert.convert(1, "lt", "cup").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(2.113376419)), df.format(MetricConvert.convert(1, "lt", "pt").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(2.113376419)), df.format(MetricConvert.convert(1, "lt", "us_pt").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(1.759753986)), df.format(MetricConvert.convert(1, "lt", "uk_pt").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(1.056688209)), df.format(MetricConvert.convert(1, "lt", "qt").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(0.264172052)), df.format(MetricConvert.convert(1, "lt", "gal").asBigDecimal()));

        // NOTE: excel says 0.06241457, but wolfram says otherwise (http://www.wolframalpha.com/input/?i=1E-20+J+to+eV)
        Assert.assertEquals(df.format(new BigDecimal(0.062415097)), df.format(MetricConvert.convert(0.00000000000000000001, "J", "eV").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(0.062415097)), df.format(MetricConvert.convert(1E-20, "J", "ev").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(3.72506E-07)), df.format(MetricConvert.convert(1, "J", "HPh").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(3.72506E-07)), df.format(MetricConvert.convert(1, "J", "hh").asBigDecimal()));
        // NOTE: excel says 75.00616827, but wolfram says otherwise (http://www.wolframalpha.com/input/?i=10000pa+to+mmHg&assumption=%22UnitClash%22+-%3E+%7B%22mmHg%22,+%7B%22MillimetersOfMercury0C%22%7D%7D)
        Assert.assertEquals(df.format(new BigDecimal(75.006375542)), df.format(MetricConvert.convert(10000, "p", "mmHg").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(9.478171203)), df.format(MetricConvert.convert(10000, "J", "BTU").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(9.478171203)), df.format(MetricConvert.convert(10000, "J", "btu").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(202.884135954)), df.format(MetricConvert.convert(1, "lt", "tsp").asBigDecimal()));
        Assert.assertEquals(df.format(new BigDecimal(67.628045318)), df.format(MetricConvert.convert(1, "lt", "tbs").asBigDecimal()));

    }

    @Test(timeout = 4000)
    public void test00() throws Throwable {
        BigDecimal bigDecimal0 = new BigDecimal((-1980));
        FormulaDecimal formulaDecimal0 = MetricConvert.convert((Number) bigDecimal0, (CharSequence) "Sv", (CharSequence) "Sv");
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000, expected = NoSuchElementException.class)
    public void test01() throws Throwable {
        StringBuffer stringBuffer0 = new StringBuffer();

        MetricConvert.getUnit(stringBuffer0);
        fail("Expecting exception: NoSuchElementException");
    }

    @Test(timeout = 4000, expected = NoSuchElementException.class)
    public void test02() throws Throwable {

        MetricConvert.getUnit((CharSequence) null);
        fail("Expecting exception: NoSuchElementException");
    }

    @Test(timeout = 4000, expected = NoSuchElementException.class)
    public void test03() throws Throwable {
        MetricConvert.getPrefixValue((CharSequence) null);
        fail("Expecting exception: NoSuchElementException");
    }

    @Ignore
    @Test(timeout = 4000)
    public void test04() throws Throwable {
        StringBuilder stringBuilder0 = new StringBuilder(0);
        stringBuilder0.replace(0, 1025, "wh");
        Assert.assertNotNull(MetricConvert.getMetricUnit(stringBuilder0));
    }

    @Test(timeout = 4000, expected = NoSuchElementException.class)
    public void test05() throws Throwable {

        MetricConvert.getMetricUnit((CharSequence) null);
        fail("Expecting exception: NoSuchElementException");
    }

    @Test(timeout = 4000, expected = NoSuchElementException.class)
    public void test06() throws Throwable {
        StringBuffer stringBuffer0 = new StringBuffer("(wZ^x?D]");

        MetricConvert.getMetricPrefix(stringBuffer0);
        fail("Expecting exception: NoSuchElementException");
    }

    @Test(timeout = 4000, expected = NoSuchElementException.class)
    public void test07() throws Throwable {

        MetricConvert.getMetricPrefix((CharSequence) null);
        fail("Expecting exception: NoSuchElementException");
    }

    @Test(timeout = 4000, expected = NoSuchElementException.class)
    public void test08() throws Throwable {
        BigInteger bigInteger0 = BigInteger.ONE;

        MetricConvert.convert((Number) bigInteger0, (CharSequence) null, (CharSequence) null);
        fail("Expecting exception: NoSuchElementException");
    }

    @Test(timeout = 4000)
    public void test09() throws Throwable {
        Unit<?> unit0 = MetricConvert.getMetricUnit("");
        assertNull(unit0);
    }

    @Test(timeout = 4000)
    public void test10() throws Throwable {
        Unit<?> unit0 = MetricConvert.getMetricUnit("Tbsp");
        assertNotNull(unit0);
    }

    @Test(timeout = 4000)
    public void test11() throws Throwable {
        Unit<?> unit0 = MetricConvert.getMetricUnit("min");
        assertNotNull(unit0);
    }

    @Ignore
    @Test(timeout = 4000)
    public void test12() throws Throwable {
        StringBuilder stringBuilder0 = new StringBuilder("ell");
        BigDecimal bigDecimal0 = new BigDecimal((double) 4218);
        Assert.assertNotNull(MetricConvert.convert((Number) bigDecimal0, (CharSequence) stringBuilder0, (CharSequence) stringBuilder0));
    }

    @Test(timeout = 4000)
    public void test13() throws Throwable {
        Unit<?> unit0 = MetricConvert.getMetricUnit("\u00B0C");
        assertNotNull(unit0);
    }

    @Ignore
    @Test(timeout = 4000)
    public void test14() throws Throwable {
        StringBuilder stringBuilder0 = new StringBuilder(0);
        StringBuilder stringBuilder1 = stringBuilder0.replace(0, 1025, "wh");
        Assert.assertNotNull(MetricConvert.getUnit(stringBuilder1));
    }

    @Test(timeout = 4000)
    public void test15() throws Throwable {
        Unit<?> unit0 = MetricConvert.getMetricUnit("Wb");
        assertNotNull(unit0);
    }

    @Test(timeout = 4000)
    public void test16() throws Throwable {
        StringBuilder stringBuilder0 = new StringBuilder(0);
        StringBuilder stringBuilder1 = stringBuilder0.replace(0, 1025, "p");
        Unit<?> unit0 = MetricConvert.getUnit(stringBuilder1);
        assertNotNull(unit0);
    }

    @Test(timeout = 4000)
    public void test17() throws Throwable {
        StringBuilder stringBuilder0 = new StringBuilder(0);
        StringBuilder stringBuilder1 = stringBuilder0.replace(0, 1025, "wh");
        stringBuilder0.deleteCharAt(0);
        Unit<?> unit0 = MetricConvert.getUnit(stringBuilder1);
        assertNotNull(unit0);
    }

    @Test(timeout = 4000)
    public void test18() throws Throwable {
        Unit<?> unit0 = MetricConvert.getMetricUnit("e");
        assertNotNull(unit0);
    }

    @Test(timeout = 4000)
    public void test19() throws Throwable {
        Unit<?> unit0 = MetricConvert.getMetricUnit("d");
        assertNotNull(unit0);
    }

    @Test(timeout = 4000)
    public void test20() throws Throwable {
        StringBuffer stringBuffer0 = new StringBuffer(122);
        char[] charArray0 = new char[1];
        charArray0[0] = 'c';
        StringBuffer stringBuffer1 = stringBuffer0.append(charArray0);
        Unit<?> unit0 = MetricConvert.getUnit(stringBuffer1);
        assertNotNull(unit0);
    }

    @Test(timeout = 4000)
    public void test21() throws Throwable {
        Unit<?> unit0 = MetricConvert.getMetricUnit("A");
        assertNotNull(unit0);
    }

    @Test(timeout = 4000)
    public void test22() throws Throwable {
        StringBuilder stringBuilder0 = new StringBuilder("z");
        MetricPrefix metricPrefix0 = MetricConvert.getMetricPrefix(stringBuilder0);
        assertEquals(MetricPrefix.ZEPTO, metricPrefix0);
    }

    @Test(timeout = 4000, expected = NoSuchElementException.class)
    public void test23() throws Throwable {
        StringBuilder stringBuilder0 = new StringBuilder("y@#E?X");

        MetricConvert.getMetricUnit(stringBuilder0);
        fail("Expecting exception: NoSuchElementException");

    }

    @Test(timeout = 4000, expected = NoSuchElementException.class)
    public void test24() throws Throwable {
        StringBuffer stringBuffer0 = new StringBuffer("eP'b^=*O>9Sv,vV_|Iu");
        stringBuffer0.reverse();

        MetricConvert.getMetricUnit(stringBuffer0);
        fail("Expecting exception: NoSuchElementException");
    }

    @Test(timeout = 4000, expected = NoSuchElementException.class)
    public void test25() throws Throwable {
        StringBuilder stringBuilder0 = new StringBuilder("pPecy\"qZ");
        BigDecimal bigDecimal0 = new BigDecimal((double) 4218);

        MetricConvert.convert((Number) bigDecimal0, (CharSequence) stringBuilder0, (CharSequence) stringBuilder0);
        fail("Expecting exception: NoSuchElementException");
    }

    @Test(timeout = 4000, expected = NoSuchElementException.class)
    public void test26() throws Throwable {
        StringBuilder stringBuilder0 = new StringBuilder();
        StringBuilder stringBuilder1 = stringBuilder0.append("za[=0Wiox]wtw5C{C7n");
        StringBuilder stringBuilder2 = stringBuilder1.reverse();

        MetricConvert.convert((Number) null, (CharSequence) stringBuilder2, (CharSequence) "za[=0Wiox]wtw5C{C7n");
        fail("Expecting exception: NoSuchElementException");
    }

    @Test(timeout = 4000)
    public void test27() throws Throwable {
        MetricPrefix metricPrefix0 = MetricConvert.getMetricPrefix("k");
        assertEquals(MetricPrefix.KILO, metricPrefix0);
    }

    @Test(timeout = 4000, expected = NoSuchElementException.class)
    public void test28() throws Throwable {
        StringBuffer stringBuffer0 = new StringBuffer("ej&[FQO");

        MetricConvert.getMetricUnit(stringBuffer0);
        fail("Expecting exception: NoSuchElementException");
    }

    @Test(timeout = 4000, expected = NoSuchElementException.class)
    public void test29() throws Throwable {
        StringBuilder stringBuilder0 = new StringBuilder("d");
        char[] charArray0 = new char[2];
        StringBuilder stringBuilder1 = stringBuilder0.append(charArray0);

        MetricConvert.getMetricUnit(stringBuilder1);
        fail("Expecting exception: NoSuchElementException");
    }

    @Test(timeout = 4000)
    public void test30() throws Throwable {
        StringBuffer stringBuffer0 = new StringBuffer(122);
        char[] charArray0 = new char[1];
        charArray0[0] = 'c';
        stringBuffer0.append(charArray0);
        MetricPrefix metricPrefix0 = MetricConvert.getMetricPrefix(stringBuffer0);
        assertEquals(MetricPrefix.CENTI, metricPrefix0);
    }

    @Test(timeout = 4000, expected = NoSuchElementException.class)
    public void test31() throws Throwable {
        StringBuilder stringBuilder0 = new StringBuilder(">BJ\"xDua5");
        stringBuilder0.reverse();
        StringBuilder stringBuilder1 = stringBuilder0.deleteCharAt(0);

        MetricConvert.getMetricUnit(stringBuilder1);
        fail("Expecting exception: NoSuchElementException");
    }

    @Test(timeout = 4000, expected = NoSuchElementException.class)
    public void test32() throws Throwable {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append('Z');

        MetricConvert.getMetricUnit(stringBuilder0);
        fail("Expecting exception: NoSuchElementException");
    }

    @Test(timeout = 4000, expected = NoSuchElementException.class)
    public void test33() throws Throwable {

        MetricConvert.getMetricUnit("T:bsp");
        fail("Expecting exception: NoSuchElementException");
    }

    @Test(timeout = 4000, expected = NoSuchElementException.class)
    public void test34() throws Throwable {

        MetricConvert.getMetricUnit("P^i");
        fail("Expecting exception: NoSuchElementException");
    }

    @Test(timeout = 4000, expected = NoSuchElementException.class)
    public void test35() throws Throwable {
        StringBuffer stringBuffer0 = new StringBuffer("MinLength must be an integer greater than or equal to 0.");

        MetricConvert.getMetricUnit(stringBuffer0);
        fail("Expecting exception: NoSuchElementException");
    }

    @Test(timeout = 4000, expected = NoSuchElementException.class)
    public void test36() throws Throwable {
        Float float0 = new Float((float) 1025);

        MetricConvert.convert((Number) float0, (CharSequence) "GfWLP", (CharSequence) "GfWLP");
        fail("Expecting exception: NoSuchElementException");
    }

    @Test(timeout = 4000)
    public void test37() throws Throwable {
        FormulaDecimal formulaDecimal0 = MetricConvert.getPrefixValue("z");
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test38() throws Throwable {
        StringBuffer stringBuffer0 = new StringBuffer(122);
        char[] charArray0 = new char[1];
        charArray0[0] = 'c';
        stringBuffer0.append(charArray0);
        FormulaDecimal formulaDecimal0 = MetricConvert.getPrefixValue(stringBuffer0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test39() throws Throwable {
        StringBuffer stringBuffer0 = new StringBuffer();
        char[] charArray0 = new char[1];
        charArray0[0] = 'P';
        stringBuffer0.append(charArray0);
        FormulaDecimal formulaDecimal0 = MetricConvert.getPrefixValue(stringBuffer0);
        assertNotNull(formulaDecimal0);
    }

    @Test(timeout = 4000, expected = NoSuchElementException.class)
    public void test40() throws Throwable {

        MetricConvert.getPrefixValue("");
        fail("Expecting exception: NoSuchElementException");
    }

    @Test(timeout = 4000)
    public void test41() throws Throwable {
        Unit<?> unit0 = MetricConvert.getMetricUnit("fm");
        assertNotNull(unit0);
    }

    @Test(timeout = 4000, expected = NoSuchElementException.class)
    public void test42() throws Throwable {
        Byte byte0 = new Byte((byte) 107);
        StringBuilder stringBuilder0 = new StringBuilder("#cee}xR6s77");

        MetricConvert.convert((Number) byte0, (CharSequence) stringBuilder0, (CharSequence) "#cee}xR6s77");
        fail("Expecting exception: NoSuchElementException");
    }

    @Test(timeout = 4000)
    public void test43() throws Throwable {

        Assert.assertNotNull(MetricConvert.convert((Number) null, (CharSequence) "s", (CharSequence) "s"));
    }

    @Test(timeout = 4000)
    public void test44() throws Throwable {
        MetricConvert metricConvert0 = new MetricConvert();
    }

    @Ignore
    @Test(timeout = 4000)
    public void test73() throws Throwable {
        CharBuffer charBuffer0 = CharBuffer.allocate(196);
        CharBuffer charBuffer1 = CharBuffer.wrap((CharSequence) charBuffer0);
        charBuffer0.append('d');
        MetricConvert.getUnit(charBuffer1);
    }
}
