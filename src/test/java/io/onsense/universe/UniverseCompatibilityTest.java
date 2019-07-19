/*
 * -\-\-
 * OnSense
 * %%
 * Copyright (C) 2018 OnSense
 * %%
 * Copyright (c) 2018, OnSense.
 *          OnSense License
 *    Version 1.0, September 2018
 * https://license.onsense.io/
 * -/-/-
 */

package io.onsense.universe;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.TimeZone;

/**
 * @author Koen Rooijmans
 */
public class UniverseCompatibilityTest {

    @BeforeClass
    public static void before() throws Exception {
        System.setProperty("user.timezone", "UTC");
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    @Before
    public void setUp() throws Exception {
        System.setProperty("user.timezone", "UTC");
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    @Test
    public void testDatedifCompatibility() throws Throwable {
        eval("2", Moments.datedif("1/1/2001", "1/1/2003", "Y"));
        eval("440", Moments.datedif("6/1/2001", "8/15/2002", "D"));
        eval("75", Moments.datedif("6/1/2001", "8/15/2002", "YD"));
    }

    @Test
    public void testIsoweeknumCompatibility() throws Throwable {
        eval("10", Moments.isoweeknum(Moments.date(2012, 3, 9)));
    }

    @Test
    public void testNetworkdaysCompatibility() throws Throwable {
        eval("110", Moments.networkdays(Moments.date(2012, 10, 1), Moments.date(2013, 3, 1)));
        eval("109", Moments.networkdays(Moments.date(2012, 10, 1), Moments.date(2013, 3, 1), Moments.date(2012, 11, 22)));
    }

    @Test
    public void testHourCompatibility() throws Throwable {
        eval("18", Moments.hour(0.75));
        eval("7", Moments.hour(Moments.date(2011, 7, 18, 7, 45, 0)));
        eval("0", Moments.hour(Moments.date(2012, 4, 21)));
    }

    @Test
    public void testTimeCompatibility() throws Throwable {
        eval("0.5", Moments.time(12, 0, 0));
        eval("0.7001157", Moments.time(16, 48, 10));
    }

    @Test
    public void testTimevalueCompatibility() throws Throwable {
        eval("0.1", Moments.timevalue("2:24 AM"));
        eval("0.27431", Moments.timevalue("22-Aug-2011 6:35 AM"));
    }

    @Test
    public void testWorkdayCompatibility() throws Throwable {
        evalDateExpression(Moment.valueOf(2009, 4, 30), Moments.workday(Moments.date(2008, 10, 1), 151));
        evalDateExpression(Moment.valueOf(2009, 5, 5), Moments.workday(Moments.date(2008, 10, 1), 151, Moments.date(2008, 11, 26), Moments.date(2008, 12, 4), Moments.date(2009, 1, 21)));
    }

    @Test
    public void testEngineeringCompatibility() throws Throwable {
        eval("0.329926", Formulas.besselj(1.9, 2));
        eval("0.277388", Formulas.besselk(1.5, 1));
        eval("0.145918", Formulas.bessely(2.5, 1));
        eval("0.981666", Formulas.besseli(1.5, 1));
        eval("0.981666", Formulas.besseli(1.5, 1));
        eval("0.329926", Formulas.besselj(1.9, 2));
        eval("0.277388", Formulas.besselk(1.5, 1));
        eval("0.145918", Formulas.bessely(2.5, 1));
        eval("0.3378346183356807306736249150034441509298976277361517", Formulas.besseli(1.5, 2));
        eval("0.3378346183356807306736249150034441509298976277361517", Formulas.besseli(1.5, 2));
        eval("0.8860919793963105", Formulas.besseli(1.4, 1));
        eval("0.5419477138848564", Formulas.besselj(1.4, 1));
        eval("0.32083590550458985", Formulas.besselk(1.4, 1));
        eval("-0.47914697411134044", Formulas.bessely(1.4, 1));
        eval("100", Formulas.bin2dec("1100100"));
        eval("100", Formulas.bin2dec(1100100));
        eval("42", Formulas.bin2dec("101010"));
        eval("-512", Formulas.bin2dec(1000000000));
        evalExpression("00fb", Formulas.bin2hex(11111011, 4));
        evalExpression("e", Formulas.bin2hex(1110));
        evalExpression("2a", Formulas.bin2hex("101010"));
        evalExpression("1ff", Formulas.bin2hex(111111111));
        evalExpression("ffffffffff", Formulas.bin2hex(1111111111));
        evalExpression("fffffffe00", Formulas.bin2hex(1000000000));
        evalExpression("011", Formulas.bin2oct(1001, 3));
        evalExpression("144", Formulas.bin2oct(1100100));
        evalExpression("7777777777", Formulas.bin2oct(1111111111));
        evalExpression("52", Formulas.bin2oct("101010"));
        evalExpression("0052", Formulas.bin2oct(101010, 4.5));
        eval("1", Formulas.bitand(1, 5));
        eval("9", Formulas.bitand(13, 25));
        eval("16", Formulas.bitlshift(4, 2));
        eval("31", Formulas.bitor(23, 10));
        eval("3", Formulas.bitrshift(13, 2));
        eval("0", Formulas.bitlshift(0, 0));
        eval("6", Formulas.bitxor(5, 3));
        evalExpression("0064", Formulas.dec2hex(100, 4));
        evalExpression("1c", Formulas.dec2hex(28));
        evalExpression("ffffffffca", Formulas.dec2hex(-54));
        evalExpression("1001", Formulas.dec2bin(9));
        evalExpression("1001", Formulas.dec2bin(9, 4));
        evalExpression("72", Formulas.dec2oct(58));
        evalExpression("072", Formulas.dec2oct(58, 3));
        evalExpression("7777777634", Formulas.dec2oct(-100));
        evalExpression("1110011100", Formulas.dec2bin(-100));
        evalExpression("00001111", Formulas.dec2bin(15, 8));
        eval("0", Formulas.delta(5, 4));
        eval("1", Formulas.delta(5, 5));
        eval("0", Formulas.delta(0.5, 0));
        eval("165", Formulas.hex2dec("A5"));
        eval("-165", Formulas.hex2dec("FFFFFFFF5B"));
        eval("1034160313", Formulas.hex2dec("3DA408B9"));
        evalExpression("00001111", Formulas.hex2bin("F", 8));
        evalExpression("10110111", Formulas.hex2bin("B7"));
        evalExpression("1111111111", Formulas.hex2bin("FFFFFFFFFF"));
        evalExpression("017", Formulas.hex2oct("F", 3));
        evalExpression("35516", Formulas.hex2oct("3B4E"));
        evalExpression("7777777400", Formulas.hex2oct("FFFFFFFF00"));
        evalExpression("11", Formulas.oct2bin("3"));
        evalExpression("011", Formulas.oct2bin("3", 3));
        evalExpression("1000000000", Formulas.oct2bin("7777777000"));
        eval("44", Formulas.oct2dec("54"));
        eval("-165", Formulas.oct2dec("7777777533"));
        evalExpression("40", Formulas.oct2hex("100"));
        evalExpression("0040", Formulas.oct2hex("100", 4));
        evalExpression("ffffffff5b", Formulas.oct2hex("7777777533", 3));
        evalExpression("ffe0000000", Formulas.oct2hex("4000000000"));
        eval("0.7079289200957377", Formulas.erf(0.745));
        eval("0.8427007929497149", Formulas.erf(1));
        eval("0.1572992070502851", Formulas.erfc(1));
        eval("1", Formulas.gestep(5, 4));
        eval("1", Formulas.gestep(5, 5));
        eval("1", Formulas.gestep(-4, -5));
        eval("0", Formulas.gestep(-1));

        eval("13", Formulas.imabs("5+12i"));
        eval("4", Formulas.imaginary("3+4i"));
        eval("1", Formulas.imaginary("i"));
        eval("+1", Formulas.imaginary("+i"));
        eval("-1", Formulas.imaginary("-j"));
        eval("-1", Formulas.imaginary("0-j"));
        eval("0", Formulas.imaginary("4"));
        eval("0", Formulas.imaginary(0));
        eval("0.9272952180016122", Formulas.imargument("3+4i"));
        eval("0", Formulas.imargument("2"));
        eval("2.0344439357957027", Formulas.imargument("-1+2i"));
        eval("-2.0344439357957027", Formulas.imargument("-1-2i"));
        evalExpression("3-4i", Formulas.imconjugate("3+4i"));
        evalExpression("5+12i", Formulas.imdiv("-238+240i", "10+24i"));
        evalExpression("j", Formulas.imdiv("j", "1"));
        evalExpression("-1j", Formulas.imdiv("1", "j"));
        evalExpression("27+11i", Formulas.improduct("3+4i", "5-3i"));
        evalExpression("30+60i", Formulas.improduct("1+2i", "30+0i"));
        eval("6", Formulas.imreal("6-9i"));
        eval("0", Formulas.imreal("i"));
        eval("0", Formulas.imreal("+i"));
        eval("0", Formulas.imreal("-j"));
        eval("0", Formulas.imreal("0-j"));
        eval("4", Formulas.imreal("4"));
        eval("0", Formulas.imreal(0));
        eval("1", Formulas.imreal("+1+j"));
        eval("-1", Formulas.imreal("-1+j"));
        eval("0", Formulas.imreal("4j"));
        evalExpression("8+j", Formulas.imsub("13+4j", "5+3j"));
        evalExpression("8-3j", Formulas.imsub("13", "5+3j"));
        evalExpression("8+i", Formulas.imsum("3+4i", "5-3i"));

        evalExpression("3+4i", Formulas.complex(3, 4));
        evalExpression("3+4j", Formulas.complex(3, 4, "j"));
        evalExpression("i", Formulas.complex(0, 1));
        evalExpression("1", Formulas.complex(1, 0));
        evalExpression("0", Formulas.complex(0, 0));
        evalImaginaryExpression("0.6215180171704283-0.3039310016284264i", Formulas.imcsc("1+i"));

        // extra asserts based on docs
        eval("13", Formulas.imabs("5+12i"));
        eval("4", Formulas.imaginary("3+4i"));
        eval("-1", Formulas.imaginary("0-j"));
        eval("0", Formulas.imaginary(4));
        eval("0.92729522", Formulas.imargument("3+4i"));
        evalImaginaryExpression("3-4i", Formulas.imconjugate("3+4i"));
        evalImaginaryExpression("0.833730025131149-0.988897705762865i", Formulas.imcos("1+i"));
        evalImaginaryExpression("-27.0349456030742+3.85115333481178i", Formulas.imcosh("4+3i"));
        evalImaginaryExpression("0.00490118239430447-0.999266927805902i", Formulas.imcot("4+3i"));
        evalImaginaryExpression("-0.0754898329158637+0.0648774713706355i", Formulas.imcsc("4+3i"));
        evalImaginaryExpression("-0.036275889628626-0.0051744731840194i", Formulas.imcsch("4+3i"));
        evalImaginaryExpression("5+12i", Formulas.imdiv("-238+240i", "10+24i"));
        evalImaginaryExpression("1.46869393991589+2.28735528717884i", Formulas.imexp("1+i"));
        evalImaginaryExpression("1.6094379124341+0.927295218001612i", Formulas.imln("3+4i"));
        evalImaginaryExpression("0.698970004336019+0.402719196273373i", Formulas.imlog10("3+4i"));
        evalImaginaryExpression("-46+9.00000000000001i", Formulas.impower("2+3i", 3));
        evalImaginaryExpression("27+11i", Formulas.improduct("3+4i", "5-3i"));
        evalImaginaryExpression("30+60i", Formulas.improduct("1+2i", 30));
        eval("6", Formulas.imreal("6-9i"));
        evalImaginaryExpression("-0.0652940278579471-0.0752249603027732i", Formulas.imsec("4+3i"));
        evalImaginaryExpression("-0.0362534969158689-0.00516434460775318i", Formulas.imsech("4+3i"));
        evalImaginaryExpression("-7.61923172032141-6.548120040911i", Formulas.imsin("4+3i"));
        evalImaginaryExpression("1.09868411346781+0.455089860562227i", Formulas.imsqrt("1+i"));
        evalImaginaryExpression("8+i", Formulas.imsub("13+4i", "5+3i"));
        evalImaginaryExpression("8+i", Formulas.imsum("3+4i", "5-3i"));
        evalImaginaryExpression("3+4i", Formulas.complex(3, 4));
        evalImaginaryExpression("3+4j", Formulas.complex(3, 4, "j"));
        evalExpression("i", Formulas.complex(0, 1));
        evalExpression("1", Formulas.complex(1, 0));
        // openoffice says -27.0168132580039+3.85373803791938i
        // evalImaginaryExpression("-7.61923172032141-6.548120040911i", Expressions.IMSINH(\"4+3i\"));
        evalImaginaryExpression("-27.0168132580039+3.85373803791938i", Formulas.imsinh("4+3i"));

        evalImaginaryExpression("0.00490825806749606+1.00070953606723i", Formulas.complex(0.00490825806749606, 1.00070953606723));

        // depends on the correct functionality of imcos, imsin and imdiv
        // openoffice says: 0.00490825806749606+1.00070953606723i
        evalImaginaryExpression("0.00490825806749606+1.00070953606723i", Formulas.imtan("4+3i"));

        // openoffice: 2.32192809488736+1.33780421245098i
        evalImaginaryExpression("2.32192809488736+1.33780421245098i", Formulas.imlog2("3+4i"));

        // moved asserts that failed at one point
        // apache openoffice: 0.303931001628427-0.621518017170429i
        // depends on the correct functionality of imsinh
        evalImaginaryExpression("0.3039310016284264-0.6215180171704283i", Formulas.imcsch("1+i"));
    }

    @Test
    public void testEngineeringConvertCompatibility() throws Throwable {

        eval("1000", Formulas.convert(1, "Yg", "Zg"));
        eval("1000", Formulas.convert(1, "Zg", "Eg"));
        eval("1000", Formulas.convert(1, "Eg", "Pg"));
        eval("1000", Formulas.convert(1, "Pg", "Tg"));
        eval("1000", Formulas.convert(1, "Tg", "Gg"));
        eval("1000", Formulas.convert(1, "Gg", "Mg"));
        eval("1000", Formulas.convert(1, "Mg", "kg"));
        eval("10", Formulas.convert(1, "kg", "hg"));
        eval("100", Formulas.convert(1, "eg", "dg"));
        eval("10", Formulas.convert(1, "dg", "cg"));
        eval("10", Formulas.convert(1, "cg", "mg"));
        eval("1000", Formulas.convert(1, "mg", "ug"));
        eval("1000", Formulas.convert(1, "ug", "ng"));
        eval("1000", Formulas.convert(1, "ng", "pg"));
        eval("1000", Formulas.convert(1, "pg", "fg"));
        eval("1000", Formulas.convert(1, "fg", "ag"));
        eval("1000", Formulas.convert(1, "ag", "zg"));
        eval("1000", Formulas.convert(1, "zg", "yg"));

        // TODO see https://github.com/apache/openoffice/blob/c014b5f2b55cff8d4b0c952d5c16d62ecde09ca1/main/scaddins/source/analysis/analysishelper.cxx#L2563
        // TODO @see https://github.com/handsontable/formula.js/blob/develop/lib/engineering.js#L321
        eval("0.45359237", Formulas.convert(1, "lbm", "kg"));
        eval("30.48000", Formulas.convert(100, "ft", "m"));
        eval("0.000621371", Formulas.convert(1, "m", "mi"));
        eval("1.09361", Formulas.convert(1, "m", "yd"));
        eval("3520", Formulas.convert(2, "mi", "yd"));
        eval("0.000002", Formulas.convert(2, "nm", "mm"));
        eval("4.409245243697551", Formulas.convert(2, "kg", "lbm"));
        eval("0.004409245243697552", Formulas.convert(2, "g", "lbm"));
        eval("0.000004409245243697551", Formulas.convert(2, "mg", "lbm"));

        eval("0.4535924", Formulas.convert(1, "lbm", "kg"));
        eval("20", Formulas.convert(68, "°F", "°C"));
        eval("20", Formulas.convert(68, "fah", "cel"));
        eval("9.290304", Formulas.convert(Formulas.convert(100, "ft", "m"), "ft", "m"));

        eval("0.00220462", Formulas.convert(1, "g", "lbm")); // 1 gram to pound mass
        eval("602214179421676400000000.00000", Formulas.convert(1, "g", "u")); // 1 gram to atomic mass unit
        eval("0.035274", Formulas.convert(1, "g", "ozm")); // 1 gram to ounce mass
        eval("15.43236", Formulas.convert(1, "g", "grain")); // 1 gram to grain
        eval("0.0000196841", Formulas.convert(1, "g", "cwt")); // 1 gram to U.S. (short) hundredweight
        eval("0.0000196841", Formulas.convert(1, "g", "shweight")); // 1 gram to U.S. (short) hundredweight
        eval("0.0000196841", Formulas.convert(1, "g", "uk_cwt")); // 1 gram to Imperial hundredweight
        eval("0.0000196841", Formulas.convert(1, "g", "lcwt")); // 1 gram to Imperial hundredweight
        eval("0.0000196841", Formulas.convert(1, "g", "hweight")); // 1 gram to Imperial hundredweight
        eval("0.000157473", Formulas.convert(1, "g", "stone")); // 1 gram to Stone
        eval("0.00000110231", Formulas.convert(1, "g", "ton")); // 1 gram to Ton
        eval("0.000000984207", Formulas.convert(1, "g", "uk_ton")); // 1 gram to Imperial ton
        eval("0.000000984207", Formulas.convert(1, "g", "LTON")); // 1 gram to Imperial ton
        eval("0.000000984207", Formulas.convert(1, "g", "brton")); // 1 gram to Imperial ton
        eval("0.0685218", Formulas.convert(1, "kg", "sg")); // 1 gram to slug

        eval("14593.90294", Formulas.convert(1, "sg", "g")); // 1 slug to gram
        eval("453.59237", Formulas.convert(1, "lbm", "g")); // 1 pound mass to gram
        eval("0.00000000000000000000000166054", Formulas.convert(1, "u", "g")); // 1 atomic mass unit to gram
        eval("28.34952", Formulas.convert(1, "ozm", "g")); // 1 ounce mass to gram
        eval("0.0647989", Formulas.convert(1, "grain", "g")); // 1 grain to gram
        eval("45359.23700", Formulas.convert(1, "cwt", "g")); // 1 U.S. (short) hundredweight to gram
        eval("45359.23700", Formulas.convert(1, "shweight", "g")); // 1 U.S. (short) hundredweight to gram
        eval("50802.34544", Formulas.convert(1, "uk_cwt", "g")); // 1 Imperial hundredweight to gram
        eval("50802.34544", Formulas.convert(1, "lcwt", "g")); // 1 Imperial hundredweight to gram
        eval("50802.34544", Formulas.convert(1, "hweight", "g")); // 1 Imperial hundredweight to gram
        eval("6350.29318", Formulas.convert(1, "stone", "g")); // 1 Stone to gram
        eval("907184.74000", Formulas.convert(1, "ton", "g")); // 1 Ton to gram
        eval("1016046.90880", Formulas.convert(1, "uk_ton", "g")); // 1 Imperial ton to gram
        eval("1016046.90880", Formulas.convert(1, "LTON", "g")); // 1 Imperial ton to gram
        eval("1016046.90880", Formulas.convert(1, "brton", "g")); // 1 Imperial ton to gram
    }

    @Test
    public void testMathTrigCompatibility() throws Throwable {
        eval("1", Formulas.abs(-1));
        eval("1.0000", (Formulas.acos(1).add(FormulaDecimal.ONE)));
        eval("0", Formulas.acosh(1));
        eval("0.48121182505960347", Formulas.asinh(0.5));
        eval("0.7853981633974483", Formulas.acot(1));
//        eval("Infinity", Expressions.ACOTH(1));
        eval("0.5235987755982989", Formulas.asin(0.5));
        eval("0.7853981633974483", Formulas.atan(1));
        eval("0.7853981633974483", Formulas.atan2(1, 1));
        eval("0.42365", Formulas.atanh(0.4));
        eval("5", Formulas.ceiling(4.1));
        eval("5", Formulas.ceiling(4.9));
        eval("-4", Formulas.ceiling(-4.1));
        eval("-4", Formulas.ceiling(-4.9));
        eval("0", Formulas.ceiling(4.1, 0));
        eval("5", Formulas.ceiling(4.1, 1));
//        eval("6", Expressions.CEILING(4.1,2));
        // https://support.office.com/en-us/article/CEILING-function-0a5cd7c8-0720-4f0a-bd2c-c943e510899f
        eval("3", Formulas.ceiling(2.5, 1));
        eval("-4", Formulas.ceiling(-2.5, -2));
        eval("-2", Formulas.ceiling(-2.5, 2));
        eval("1.5", Formulas.ceiling(1.5, 0.1));
        eval("0.24", Formulas.ceiling(0.234, 0.01));

        eval("22.3", Formulas.ceiling(22.25, 0.1));
        eval("22.5", Formulas.ceiling(22.25, 0.5));
        eval("23", Formulas.ceiling(22.25, 1));
        eval("30", Formulas.ceiling(22.25, 10));
        eval("40", Formulas.ceiling(22.25, 20));
        eval("-11.09183", Formulas.ceiling(-11.12333, 0.03499));
        eval("-4", Formulas.ceiling(-4.1, 2));
        eval("1.3", Formulas.ceiling(1.234, 0.1));
        eval("-1.2", Formulas.ceiling(-1.234, 0.1));
        eval("-1.234", Formulas.ceiling(-1.234, -0.001));
        eval("28", Formulas.combin(8, 2));
        eval("1", Formulas.combin(0, 0));
        eval("1", Formulas.combin(1, 0));
        eval("1", Formulas.combin(1, 1));
        eval("2", Formulas.combin(2, 1));
        eval("1", Formulas.combin(2, 2));
        eval("3", Formulas.combin(3, 1));
        eval("3", Formulas.combin(3, 2));
        eval("1", Formulas.combin(3, 3));
        eval("120", Formulas.combin(10, 3));
        eval("20", Formulas.combina(4, 3));
        eval("220", Formulas.combina(10, 3));
        eval("1", Formulas.combina(0, 0));
        eval("1", Formulas.combina(1, 0));
        eval("1", Formulas.combina(1, 1));
        eval("2", Formulas.combina(2, 1));
        eval("3", Formulas.combina(2, 2));
        eval("3", Formulas.combina(3, 1));
        eval("6", Formulas.combina(3, 2));
        eval("10", Formulas.combina(3, 3));
        eval("220", Formulas.combina(10, 3));
        eval("1", Formulas.cos(0));
        eval("0.54030", Formulas.cos(1));
        eval("1", Formulas.cosh(0));
        eval("1.54308", Formulas.cosh(1));
        eval("0.6420926159343306", Formulas.cot(1));
        eval("1.3130352854993312", Formulas.coth(1));
//        eval("Infinity", Expressions.CSC(0));
        eval("1.00251", Formulas.csc(1.5));
        eval("1.18840", Formulas.csc(1));
        eval("0.46964", Formulas.csch(1.5));
        eval("0.85092", Formulas.csch(1));
//        eval("Infinity", UniversalParser.parse("prop", CSCH"(0));
//        eval("Infinity", UniversalParser.parse("prop", CSCH"(0));
        eval("10", Formulas.decimal(10.5));
        eval("0", Formulas.decimal("0", 2));
        eval("1", Formulas.decimal("1", 2));
        eval("2", Formulas.decimal("10", 2));
        eval("10", Formulas.decimal("10", 10));
        eval("255", Formulas.decimal("FF", 16));
        eval("1295", Formulas.decimal("ZZ", 36));
        eval("180", Formulas.degrees(Math.PI));
        eval("4", Formulas.even(3));
        eval("720", Formulas.fact(6));
        eval("120", Formulas.fact(5));
        eval("1", Formulas.fact(1.9));
        eval("1", Formulas.fact(0));
        eval("1", Formulas.fact(1));
        eval("48", Formulas.factdouble(6));
        eval("105", Formulas.factdouble(7));
        eval("3840", Formulas.factdouble(10));
        eval("2", Formulas.floor(3.7, 2));
        eval("-2", Formulas.floor(-2.5, -2));
//        eval("error.num", Expressions.FLOOR(2.5,-2));
        eval("1.5", Formulas.floor(1.58, 0.1));
        eval("0.23", Formulas.floor(0.234, 0.01));
        eval("0", Formulas.floor(0.234, 0));
        // https://support.office.com/en-us/article/floor-function-14bb497c-24f2-4e04-b327-b0b4de5a8886
        eval("2", Formulas.floor(3.7, 2));
        eval("-2", Formulas.floor(-2.5, -2));
        eval("1.5", Formulas.floor(1.58, 0.1));
        eval("0.23", Formulas.floor(0.234, 0.01));

        eval("-2", Formulas.floor(-2.5, -2));
        eval("0.23", Formulas.floor(0.234, 0.01));

        eval("1", Formulas.gcd(5, 2));
        eval("12", Formulas.gcd(24, 36));
        eval("1", Formulas.gcd(7, 1));
        eval("5", Formulas.gcd(5, 0));
        eval("5", Formulas.toInt(5.5));
        eval("8", Formulas.toInt(8.9));
        eval("-9", Formulas.toInt(-8.9));
        eval("10", Formulas.lcm(5, 2));
        eval("72", Formulas.lcm(24, 36));
        // NOTE: agreeing with wolfram alpha here instead of excel spec (thus test-case is outcommented).
        // @see http://www.wolframalpha.com/input/?i=log(10)
        // @see https://support.office.com/en-us/article/log-function-4e82f196-1ca9-4747-8fb0-6c4a3abb3280
        // eval("1", Expressions.LOG(10));
        eval("1", Formulas.log(10, 10));
        eval("3", Formulas.log(8, 2));
        eval("2.095903274289384604296567522021401250607518006797930116923", Formulas.log(10, 3));
        eval("1.660964047443681173935159714744695087932415696512290306027", Formulas.log(10, 4));
        eval("1.430676558073393050670106568763965632069791932079760449321", Formulas.log(10, 5));
        eval("1.285097208938468759943479096554289548715733213281751227870", Formulas.log(10, 6));
        eval("4.4543473", Formulas.log(86, 2.7182818));
        eval("1", Formulas.log10(10));
        eval("-3", Formulas.mdeterm(3, new Number[]{6, 1, 1}));
        eval("1", Formulas.mdeterm(3, new Number[]{6, 1, 1, 1, 0, 3, 10, 2}));
        eval("88", Formulas.mdeterm(1, new Number[]{3, 8, 5, 1, 3, 6, 1, 1, 1, 1, 0, 7, 3, 10, 2}));
        eval("-2", Formulas.mdeterm(1, new Number[]{2, 3, 4}));
        eval("1", Formulas.mod(3, 2));
        eval("1", Formulas.mod(-3, 2));
        eval("-1", Formulas.mod(3, -2));
        eval("-1", Formulas.mod(-3, -2));
        eval("9", Formulas.mround(10, 3));
        eval("-9", Formulas.mround(-10, -3));
        eval("1.4000000000000001", Formulas.mround(1.3, 0.2));
        eval("1260", Formulas.multinomial(2, 3, 4));
        eval("1260", Formulas.multinomial(2, 3, 4));
        eval("3", Formulas.odd(3));
        eval("3", Formulas.odd(2));
        eval("3", Formulas.odd(1.4));
        eval("3", Formulas.odd(2.9));
        eval("3", Formulas.odd(1.9));
        eval("3", Formulas.odd(1.6));
        eval("3", Formulas.odd(1.5));
        eval("-1", Formulas.odd(-1));
        eval("-3", Formulas.odd(-2));
        eval("-1", Formulas.odd(-1.6));
        eval("-1", Formulas.odd(-1.5));
        eval("-1", Formulas.odd(-1.4));
        eval("1", Formulas.odd(0));
        eval("25", Formulas.power(5, 2));
        eval("2401077.2220695773", Formulas.power(98.6, 3.2));
        eval("25", Formulas.power(5, 2));
        eval("2401077.2220695773", Formulas.power(98.6, 3.2));
        eval("2250", Formulas.product(5, 15, 30));
        eval("2", Formulas.quotient(5, 2));
        eval("1", Formulas.quotient(4.5, 3.1));
        eval("-3", Formulas.quotient(-10, 3));
        eval(String.valueOf(Math.PI), Formulas.radians(180));
        eval("2.2", Formulas.round(2.15, 1));
        eval("2.1", Formulas.round(2.149, 1));
        eval("20", Formulas.round(21.5, -1));
        eval("1000", Formulas.round(626.3, -3));
        eval("0", Formulas.round(1.98, -1));
        eval("-100", Formulas.round(-50.55, -2));
        eval("3", Formulas.rounddown(3.2, 0));
        eval("76", Formulas.rounddown(76.9, 0));
        eval("3.141", Formulas.rounddown(3.14159, 3));
        eval("-3.1", Formulas.rounddown(-3.14159, 1));
        eval("31400", Formulas.rounddown(31415.92654, -2));
        eval("4", Formulas.roundup(3.2, 0));
        eval("77", Formulas.roundup(76.9, 0));
        eval("3.142", Formulas.roundup(3.14159, 3));
        eval("-3.2", Formulas.roundup(-3.14159, 1));
        eval("31500", Formulas.roundup(31415.92654, -2));
        eval("1.9035944074044246", Formulas.sec(45));
        eval("6.482921234962678", Formulas.sec(30));
        eval("5.725037161098787e-20", Formulas.sech(45));
        eval("1.8715245937680347e-13", Formulas.sech(30));
        eval("0", Formulas.sign(0));
        eval("-1", Formulas.sign(-5));
        eval("1", Formulas.sign(5));
        eval("1", Formulas.sign(10));
        eval("0", Formulas.sign(4 - 4));
        eval("-1", Formulas.sign(-0.00001));
        eval("1.1752011936438014", Formulas.sinh(1));
        eval("2", Formulas.sqrt(4));
        eval("3.0699801238394655", Formulas.sqrtpi(3));
        eval("6", Formulas.sum(1, 2, 3));
        eval("6", Formulas.sum(1, 2, 3));
        eval("9", Formulas.sum(1, 2, 3, 1, 2));
        eval("9", Formulas.sum(1, 2, 3, 1, 2));
        eval("12", Formulas.sum(1, 1, 2, 2, 3, 3));
        eval("15", Formulas.sum(1, 1, 2, 2, 3, 3, 1, 2));
        eval("15", Formulas.sum(1, 1, 2, 2, 3, 3, 1, 2));
        eval("24", Formulas.sum(1, 1, 2, 2, 3, 3, 1, 1, 2, 2, 3, 3));
        eval("1", Formulas.tan(Formulas.radians(45)));
        eval("0.46211715726000974", Formulas.tanh(0.5));
        eval("8", Formulas.trunc(8.9));
        eval("-8", Formulas.trunc(-8.9));
        eval("0", Formulas.trunc(0.45));
        eval("2", Formulas.subtotal(1, 1, 2, 3));
        eval("3", Formulas.subtotal(4, 1, 2, 3));
        eval("1", Formulas.subtotal(5, 1, 2, 3));
        eval("6", Formulas.subtotal(6, 1, 2, 3));
        eval("6", Formulas.subtotal(9, 1, 2, 3));
        eval("2", Formulas.subtotal(101, 1, 2, 3));
        eval("3", Formulas.subtotal(104, 1, 2, 3));
        eval("1", Formulas.subtotal(105, 1, 2, 3));
        eval("6", Formulas.subtotal(106, 1, 2, 3));
        eval("6", Formulas.subtotal(109, 1, 2, 3));
        eval("3", Formulas.sumif(1, 2, 3, ">2"));
        eval("6", Formulas.sumif(1, 1, 2, 2, 3, 3, ">2"));
        eval("156", Formulas.sumproduct(3, 4, 8, 6, 1, 9, 2, 7, 6, 7, 5, 3));
        eval("2.75", Formulas.sumproduct(1, 4, 10, 0.55, 0.3, 0.1));
        eval("2.75", Formulas.sumproduct(1, 4, 10, 0.55, 0.3, 0.1));
        eval("14", Formulas.sumsq(1, 2, 3));
        eval("14", Formulas.sumsq(1, 2, 3));
        eval("25", Formulas.sumsq(3, 4));
        eval("-55", Formulas.sumx2my2(2, 3, 9, 1, 8, 7, 5, 6, 5, 11, 7, 5, 4, 4));
        eval("-63", Formulas.sumx2my2(1, 2, 3, 4, 5, 6));
        // invalid case: If array_x and array_y have a different number of values, SUMX2MY2 returns the #N/A error value.
        // eval("-468", Expressions.SUMX2MY2(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16));
        eval("521", Formulas.sumx2py2(2, 3, 9, 1, 8, 7, 5, 6, 5, 11, 7, 5, 4, 4));
        eval("91", Formulas.sumx2py2(1, 2, 3, 4, 5, 6));
        // eval("650", Formulas.sumx2py2(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16));
        eval("79", Formulas.sumxmy2(2, 3, 9, 1, 8, 7, 5, 6, 5, 11, 7, 5, 4, 4));
        eval("27", Formulas.sumxmy2(1, 2, 3, 4, 5, 6));
        // eval("216", Formulas.sumxmy2(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16));

        eval("2", Formulas.aggregate(1, 4, 1, 2, 3));
        eval("3", Formulas.aggregate(4, 4, 1, 2, 3));
        eval("1", Formulas.aggregate(5, 4, 1, 2, 3));
        eval("6", Formulas.aggregate(6, 4, 1, 2, 3));
        eval("6", Formulas.aggregate(9, 4, 1, 2, 3));
        eval("2", Formulas.aggregate(14, 4, 1, 2, 3, 2));
        eval("2", Formulas.aggregate(15, 4, 1, 2, 3, 2));

//        eval("5.656854249492381", Formulas.power(4, 5 / 4));
//        eval("5.656854249492381", Formulas.power(4, 5 / 4));

        // TODO SUMIFS!
    }

    @Test
    public void testTextCompatibility() throws Throwable {
        evalExpression("A", Expressions.charr(65));
        evalExpression("ÿ", Expressions.charr(255));
        evalExpression("Ϩ", Expressions.charr(1000));
        evalExpression("", Expressions.clean(""));
        evalExpression("Monthly Report", Expressions.clean("" + String.valueOf((char) 9) + "Monthly Report" + String.valueOf((char) 9) + ""));
        eval("65", Expressions.code("A"));
        eval("1000", Expressions.code("Ϩ"));
        evalExpression("hello world", Expressions.concatenate("hello", " ", "world"));
        evalExpression("hello my world", Expressions.concatenate("hello", " my ", "world"));
        evalExpression("1one", Expressions.concatenate(1, "one"));
        evalExpression("TRUEyes", Expressions.concatenate(Logical.TRUE, "yes"));
        evalExpression("FALSEno", Expressions.concatenate(Logical.FALSE, "no"));
        evalExpression("$1,234.57", Expressions.dollar(1234.567));
        evalExpression("$1,200", Expressions.dollar(1234.567, -2));
        evalExpression("$-1,200", Expressions.dollar(-1234.567, -2));
        evalExpression("$-0.1230", Expressions.dollar(-0.123, 4));
        evalExpression("$-99.89", Expressions.dollar(-99.888));
        evalLogical(true, Expressions.exact("yes", "yes"));
        eval("1", Expressions.find("M", "Miriam McGovern"));
        eval("6", Expressions.find("m", "Miriam McGovern"));
        eval("8", Expressions.find("M", "Miriam McGovern", 3));
        evalExpression("1,234.6", Expressions.fixed(1234.567, 1));
        evalExpression("1,230", Expressions.fixed(1234.567, -1));
        evalExpression("-1230", Expressions.fixed(-1234.567, -1, true));
        evalExpression("44.33", Expressions.fixed(44.332));
        evalExpression("Sale", Expressions.left("Sale Price", 4));
        evalExpression("S", Expressions.left("Sweeden"));
        eval("4", Expressions.len("four"));
        eval("5", Expressions.len(1, 2, 3, 4, 5));
        evalExpression("abcd", Expressions.lower("abcd"));
        evalExpression("abcd", Expressions.lower("ABcd"));
        evalExpression("abcd", Expressions.lower("ABCD"));
        evalExpression("", Expressions.lower(""));
        evalExpression("Fluid", Expressions.mid("Fluid Flow", 1, 5));
        evalExpression("Flow", Expressions.mid("Fluid Flow", 7, 20));
        evalExpression("", Expressions.mid("Fluid Flow", 20, 50));
        evalExpression("A Title Case", Expressions.proper("a title case"));
        evalExpression("True", Expressions.proper(true));
        evalExpression("False", Expressions.proper(false));
        evalExpression("90", Expressions.proper(90));
        evalExpression("abcde*k", Expressions.replace("abcdefghijk", 6, 5, "*"));
        evalExpression("2010", Expressions.replace("2009", 3, 2, "10"));
        evalExpression("@456", Expressions.replace("123456", 1, 3, "@"));
        evalExpression("multiple multiple multiple ", Expressions.rept("multiple ", 3));
        evalExpression("Price", Expressions.right("Sale Price", 5));
        evalExpression("r", Expressions.right("Stock Number"));
        eval("7", Expressions.search("e", "Statements", 6));
        eval("8", Expressions.search("margin", "Profit Margin"));
        eval("1", Expressions.search("ba", "bar"));
        evalExpression("James Alateras", Expressions.substitute("Jim Alateras", "im", "ames"));
        evalExpression("Jim Alateras", Expressions.substitute("Jim Alateras", "", "ames"));
        evalExpression("", Expressions.substitute("", "im", "ames"));
        evalExpression("Quarter 2, 2008", Expressions.substitute("Quarter 1, 2008", "1", "2", 1));
        evalExpression("Rainfall", Expressions.t("Rainfall"));
        evalExpression("1234.6", Expressions.text("1234.59", "####.#"));
        evalExpression("1234.5", Expressions.text("1234.52", "####.#"));
        evalExpression("1234.56", Expressions.text("1234.56", "####.##"));
        evalExpression("more spaces", Expressions.trim(" more spaces "));
        evalExpression("A", Expressions.unichar(65));
        evalExpression("ÿ", Expressions.unichar(255));
        evalExpression("Ϩ", Expressions.unichar(1000));
        eval("65", Expressions.unicode("A"));
        eval("1000", Expressions.unicode("Ϩ"));
        evalExpression("TO UPPER CASE PLEASE", Expressions.upper("to upper case please"));
        eval("1000", Expressions.value("$1,000"));
        eval("250", Expressions.numbervalue("250", ",", "."));
        eval("2500.27", Expressions.numbervalue("2.500,27", ",", "."));
    }

    @Test
    public void testNumberValueFunc() throws Throwable {
        eval("2500.27", Expressions.numbervalue("2.500,27", ",", "."));
        eval("250", Expressions.numbervalue("250", ",", "."));
        eval("0.035", Expressions.numbervalue("3.5%"));
    }

    @Test
    public void testTextCompatibilityExtended() throws Throwable {
        evalExpression("28.5%", Expressions.text(0.285, "0.0%"));
        evalExpression("$1,234.57", Expressions.text(1234.567, "$#,##0.00"));
        evalExpression("4 1/3", Expressions.text(4.34, "# ?/?"));
        evalExpression("1/3", Expressions.trim(Expressions.text(0.34, "# ?/?")));
        evalExpression("(123) 456-7898", Expressions.text(1234567898, "[<=9999999]###-####;(###) ###-####"));
        evalExpression("0001234", Expressions.text(1234, "0000000"));
        evalExpression("1.22E+07", Expressions.text(12200000, "0.00E+00"));
        evalExpression("1:03 AM", Expressions.text(Moments.date(2012, 03, 14, 1, 29), "H:MM a"));
    }

    @Test
    public void testDateTimeCompatibility() throws Throwable {
        evalDateExpression(Moment.valueOf(1900, 1, 1), Moments.date(1900, 1, 1));

        eval("36921", Moments.datevalue(Moments.date(2001, 1, 30)));
        eval("36921", Moments.datevalue("2001/1/30"));

        // @see https://support.office.com/en-us/article/datedif-function-25dba1a4-2812-480b-84dd-8b32a451b35c
        eval("2", Moments.datedif(Moments.date(2001, 1, 1), Moments.date(2003, 1, 1), "Y"));
        eval("440", Moments.datedif(Moments.date(2001, 6, 1), Moments.date(2002, 8, 15), "D"));
        eval("75", Moments.datedif(Moments.date(2001, 6, 1), Moments.date(2002, 8, 15), "YD"));

        eval("2", Moments.datedif("2001/1/1", "2003/1/1", "Y"));
        eval("440", Moments.datedif("2001/6/1", "2002/8/15", "D"));
        eval("75", Moments.datedif("2001/6/1", "2002/8/15", "YD"));
        eval("2", Moments.datedif(Moments.datevalue("2001/1/1"), Moments.datevalue("2003/1/1"), "Y"));
        eval("440", Moments.datedif(Moments.datevalue("2001/6/1"), Moments.datevalue("2002/8/15"), "D"));
        eval("75", Moments.datedif(Moments.datevalue("2001/6/1"), Moments.datevalue("2002/8/15"), "YD"));
        eval("2", Moments.datedif(36891, Moments.date(2003, 1, 1), "Y"));
        eval("2", Moments.datedif(36891, Moments.datevalue("2003/1/1"), "Y"));
        // @see https://support.office.com/en-us/article/datevalue-function-df8b07d4-7761-4a93-bc33-b7471bbff252
        eval("40597", Moments.datevalue("2011/02/23"));
        eval("40685", Moments.datevalue("22-MAY-2011"));
        eval("40777", Moments.datevalue("8/22/2011"));
        eval("40850", Moments.datevalue("11/3/2011"));
        eval("39448", Moments.datevalue("1/1/2008"));
        eval("39634", Moments.datevalue("7/5/2008"));
        eval("39634", Moments.datevalue("5-JUL-2008"));
        eval(String.valueOf(Moments.datevalue(Moment.valueOf(new Moment().year().intValue(), 7, 5))), Moments.datevalue("5-JUL"));

        eval("1", Moments.datevalue("1/1/1900"));
        eval("2958465", Moments.datevalue("12/31/9999"));

        // @see https://support.office.com/en-us/article/day-function-8a7d1cbb-6c7d-4ba1-8aea-25c134d03101
        eval("15", Moments.day("15-Apr-11"));

        eval("5", Moments.day("5-JUL-2008"));
        eval("5", Moments.day(Moments.datevalue("5-JUL-2008")));
        eval("23", Moments.day("2011/02/23"));
        eval("23", Moments.day(Moments.datevalue("2011/02/23")));
        eval("31", Moments.day(2958465));
        eval("1", Moments.day(1));
        eval("1", Moments.day("1"));
        eval("1", Moments.day("1/1/1900"));
        eval("1", Moments.day(Moments.date(1900, 0, 1)));

        // @see https://support.office.com/en-us/article/days-function-57740535-d549-4395-8728-0f07bff0b9df
        eval("42", Moments.days("3/15/11", "2/1/11"));
        eval("364", Moments.days("12/31/2011", "1/1/2011"));

        eval("1", Moments.days(2, 1));
        eval("1", Moments.days("1/2/1900", "1/1/1900"));
        eval("1", Moments.days(Moments.date(1900, 1, 2), Moments.date(1900, 1, 1)));

        // https://support.office.com/en-us/article/days360-function-b9a509fd-49ef-407e-94df-0cbda5718c2a
        eval("1", Moments.days360("30-Jan-11", "1-Feb-11"));
        eval("30", Moments.days360("1-Jan-11", "1-Feb-11"));
        eval("360", Moments.days360("1-Jan-11", "1-Jan-12"));
        eval("180", Moments.days360("1-JUN-13", "31-NOV-13"));
        eval("120", Moments.days360("1-JUN-13", "31-SEP-13"));
        eval("360", Moments.days360("1-Jan-11", "31-Dec-11"));

        eval("359", Moments.days360("1/1/1901", "12/31/1901", true));
        eval("360", Moments.days360("1/1/1901", "1/1/1902", true));
        eval("30", Moments.days360("1/1/2008", "2/1/2008", true));
        eval("1", Moments.days360("1/1/2008", "1/2/2008", true));
        eval("1", Moments.days360("1/1/1901", "1/2/1901", true));
        eval("30", Moments.days360("1/1/1901", "2/1/1901", true));
        eval("1", Moments.days360("1/1/1901", "1/2/1901", false));
        eval("360", Moments.days360("1/1/1901", "12/31/1901", false));
        eval("360", Moments.days360("1/1/1901", "1/1/1902", false));
        eval("30", Moments.days360("1/1/1901", "2/1/1901", false));
        eval("330", Moments.days360("1/30/1901", "12/31/1901", false));

        // @see https://support.office.com/en-us/article/edate-function-3c920eb2-6e66-44e7-a1f5-753ae47ee4f5
        eval(String.valueOf(Moments.datevalue(Moment.valueOf(2011, 2, 15))), Moments.edate("15-Jan-11", 1));
        eval(String.valueOf(Moments.datevalue(Moment.valueOf(2010, 12, 15))), Moments.edate("15-Jan-11", -1));
        eval(String.valueOf(Moments.datevalue(Moment.valueOf(2011, 3, 15))), Moments.edate("15-Jan-11", 2));

        eval("1", Moments.edate("1/1/1900", 0));
        eval("367", Moments.edate("1/1/1900", 12));

        // @see https://support.office.com/en-us/article/eomonth-function-7314ffa1-2bc9-4005-9d66-f49db127d628
        eval(String.valueOf(Moments.datevalue(Moment.valueOf(2011, 2, 28))), Moments.eomonth("1-Jan-11", 1));
        eval(String.valueOf(Moments.datevalue(Moment.valueOf(2010, 10, 31))), Moments.eomonth("1-Jan-11", -3));

        eval("397", Moments.eomonth("1/1/1900", 12));

        // @see https://support.office.com/en-us/article/hour-function-a3afa879-86cb-4339-b1b5-2dd2d7310ac7
        eval("18", Moments.hour(0.75));
        eval("7", Moments.hour("7/18/2011 7:45"));
        eval("0", Moments.hour("4/21/2012"));

        eval("0", Moments.hour("1/1/1900"));
        // @see https://support.office.com/en-us/article/isoweeknum-function-1c2d0afe-d25b-4ab1-8894-8d0520e90e0e
        eval("10", Moments.isoweeknum("3/9/2012"));

        eval("1", Moments.isoweeknum("1/1/1901"));
        eval("2", Moments.isoweeknum("1/8/1901"));
        eval("52", Moments.isoweeknum("12/29/1901"));
        eval("23", Moments.isoweeknum("6/6/1902"));

        // @see https://support.office.com/en-us/article/minute-function-af728df0-05c4-4b07-9eed-a84801a60589
        eval("45", Moments.minute("12:45:00 PM"));
        eval("45", Moments.minute("6:45:00 PM"));
        eval("45", Moments.minute("6:45 PM"));

        eval("0", Moments.minute("1/1/1901"));

        // @see https://support.office.com/en-us/article/month-function-579a2881-199b-48b2-ab90-ddba0eba86e8
        eval("4", Moments.month("15-Apr-11"));

        eval("1", Moments.month("1/1/1900"));
        eval("12", Moments.month("12/1/1900"));

        // @see https://support.office.com/en-us/article/networkdays-function-48e717bf-a7a3-495f-969e-5005e3eb18e7
        eval("110", Moments.networkdays("10/1/2012", "3/1/2013"));
        eval("109", Moments.networkdays("10/1/2012", "3/1/2013", "11/22/2012"));
        eval("107", Moments.networkdays("10/1/2012", "3/1/2013", "11/22/2012", "12/4/2012", "1/21/2013"));

        eval("1", Moments.networkdays("2013/12/04", "2013/12/04"));
        eval("2", Moments.networkdays("2013/12/04", "2013/12/05"));
        eval("3", Moments.networkdays("2013/12/04", "2013/12/06"));
        eval("4", Moments.networkdays("2013/12/04", "2013/12/09"));
        eval("1", Moments.networkdays("12/4/2013", "12/4/2013"));

        // @see https://support.office.com/en-us/article/networkdays-intl-function-a9b26239-4f20-46a1-9ab8-4e925bfd5e28?ui=en-US&rs=en-US&ad=US
        eval("22", Moments.networkdays_intl(Moments.date(2006, 1, 1), Moments.date(2006, 1, 31)));
        eval("22", Moments.networkdays_intl(Moments.date(2006, 1, 1), Moments.date(2006, 1, 31), "0000011"));
        eval("-21", Moments.networkdays_intl(Moments.date(2006, 2, 28), Moments.date(2006, 1, 31)));
        eval("-21", Moments.networkdays_intl(Moments.date(2006, 2, 28), Moments.date(2006, 1, 31), "0000011"));
        eval("22", Moments.networkdays_intl(Moments.date(2006, 1, 1), Moments.date(2006, 2, 1), 7, "2006/1/2", "2006/1/16"));
        eval("24", Moments.networkdays_intl(Moments.date(2006, 1, 1), Moments.date(2006, 2, 1), 7));
        eval("24", Moments.networkdays_intl(Moments.date(2006, 1, 1), Moments.date(2006, 2, 1), "0000110"));
        eval("23", Moments.networkdays_intl(Moments.date(2006, 1, 1), Moments.date(2006, 2, 1), "0010001"));

        eval("2", Moments.networkdays_intl("12/4/2013", "12/5/2013"));

        // @see https://support.office.com/en-us/article/now-function-3337fd29-145a-4347-b2e6-20c904739c46
        evalDateExpressionNear(Moment.valueOf(new Moment().year().intValue(), new Moment().month().intValue(), new Moment().day().intValue()), Moments.now());
        evalDateExpressionNear(Moment.valueOf(new Moment().year().intValue(), new Moment().month().intValue(), new Moment().day().intValue(), new Moment().hour().intValue() - 12, new Moment().minute().intValue()), Moments.now().subtract(FormulaDecimal.valueOf(0.5d)));
        evalDateExpressionNear(Moment.valueOf(new Moment().year().intValue(), new Moment().month().intValue(), new Moment().day().intValue() + 7), Moments.now().add(FormulaDecimal.valueOf(7)));
        evalDateExpressionNear(Moment.valueOf(new Moment().year().intValue(), new Moment().month().intValue(), new Moment().day().intValue() - 2, new Moment().hour().intValue() - 6, new Moment().minute().intValue()), Moments.now().subtract(FormulaDecimal.valueOf(2.25d)));

        // @see https://support.office.com/en-us/article/second-function-740d1cfc-553c-4099-b668-80eaa24e8af1
        eval("18", Moments.second("4:48:18 PM"));
        eval("0", Moments.second("4:48 PM"));

        eval("0", Moments.second("1/1/1900"));

        // @see https://support.office.com/en-us/article/time-function-9a5aff99-8f7d-4611-845e-747d0b8d5457
        eval("0.5", Moments.time(12, 0, 0));
        eval("0.7001157", Moments.time(16, 48, 10));

        eval("0", Moments.time(0, 0, 0));
        eval("0.04237268518518519", Moments.time(1, 1, 1));

        // @see https://support.office.com/en-us/article/timevalue-function-0b615c12-33d8-4431-bf3d-f3eb6d186645
        eval("0.10", Moments.timevalue("2:24 AM"));
        eval("0.27431", Moments.timevalue("22-Aug-2011 6:35 AM"));

        eval("0", Moments.timevalue("1/1/1900 00:00:00"));
        eval("0.5", Moments.timevalue("1/1/1900 12:00:00"));

        // @see https://support.office.com/en-us/article/today-function-5eb3078d-a82c-4736-8930-2f51a028fdd9
        evalDateExpressionNear(Moment.valueOf(new Moment().year().intValue(), new Moment().month().intValue(), new Moment().day().intValue()), Moments.today());
        evalDateExpressionNear(Moment.valueOf(new Moment().year().intValue(), new Moment().month().intValue(), new Moment().day().intValue() + 5), Moments.today().add(FormulaDecimal.valueOf(5)));
        // TODO not sure what should be returned here, a number or a date?
        // evalDateExpression(Moments.days(Moment.valueOf(2030, 1,1),new Moment()), Expressions.datevalue(2030,1,1)-today());
        eval(Moment.valueOf(new Moment().year().intValue(), new Moment().month().intValue(), new Moment().day().intValue()).day().toString(), Moments.day(Moments.today()));
        eval(Moment.valueOf(new Moment().year().intValue(), new Moment().month().intValue(), new Moment().day().intValue()).month().toString(), Moments.month(Moments.today()));

        // @see https://support.office.com/en-us/article/weekday-function-60e44483-2ed1-439f-8bd0-e404c190949a
        eval("5", Moments.weekday(Moments.date(2008, 2, 14)));
        eval("4", Moments.weekday(Moments.date(2008, 2, 14), 2));
        eval("3", Moments.weekday(Moments.date(2008, 2, 14), 3));
        eval("5", Moments.weekday("2/14/2008"));
        eval("4", Moments.weekday("2/14/2008", 2));
        eval("3", Moments.weekday("2/14/2008", 3));
        eval("3", Moments.weekday("1/1/1901"));
        eval("2", Moments.weekday("1/1/1901", 2));

        // @see https://support.office.com/en-us/article/weeknum-function-e5c43a03-b4ab-426c-b411-b18c13c75340
        eval("10", Moments.weeknum("3/9/2012"));
        eval("11", Moments.weeknum("3/9/2012", 2));
        eval("1", Moments.weeknum("1/1/1900"));
        eval("5", Moments.weeknum("2/1/1900"));
        eval("6", Moments.weeknum("2/1/1909", 2));
        eval("1", Moments.weeknum("1/1/1901", 21));

        // @see https://support.office.com/en-us/article/year-function-c64f017a-1354-490d-981f-578e8ec8d3b9
        eval("2008", Moments.year("7/5/2008"));
        eval("2010", Moments.year("7/5/2010"));

        eval("1900", Moments.year("1/1/1900"));

        // @see https://support.office.com/en-us/article/yearfrac-function-3844141e-c76d-4143-82b6-208454ddc6a8
        eval("0.58055556", Moments.yearfrac("1/1/2012", "7/30/2012"));

        eval("0.002777777777777778", Moments.yearfrac("1/1/1900", "1/2/1900"));
        eval("0.16666666666666666", Moments.yearfrac("1/31/1900", "3/31/1900", 0));
        eval("0.002777777777777778", Moments.yearfrac("1/31/1900", "2/1/1900", 0));
        eval("0.16666666666666666", Moments.yearfrac("1/30/1900", "3/31/1900", 0));
        eval("0.002777777777777778", Moments.yearfrac("1/1/1900", "1/2/1900", 4));

        // @see https://support.office.com/en-us/article/workday-function-f764a5b7-05fc-4494-9486-60d494efbf33
        evalDateExpression(Moment.valueOf(2009, 4, 30), Moments.workday("10/1/2008", 151));
        evalDateExpression(Moment.valueOf(2009, 5, 5), Moments.workday("10/1/2008", 151, "11/26/2008", "12/4/2008", "1/21/2009"));

        eval("2", Moments.day(Moments.workday("1/1/1900", 1)));
        eval("4", Moments.day(Moments.workday("1/1/1900", 2, "1/2/1900")));
        eval("10", Moments.day(Moments.workday("1/1/1900", 7)));

        // @see https://support.office.com/en-us/article/workday-intl-function-a378391c-9ba7-4678-8a39-39611a9bf81d?ui=en-US&rs=en-US&ad=US
        eval("41013", Moments.datevalue(Moments.workday_intl(Moments.date(2012, 1, 1), 90, 11)));
        eval("40944", Moments.datevalue(Moments.workday_intl(Moments.date(2012, 1, 1), 30, 17)));

        eval("2", Moments.day(Moments.workday_intl("1/1/1900", 1)));

//        eval("0.57808219", Moments.yearfrac("1/1/2012", "7/30/2012", 3));
//        eval("0.57650273", Moments.yearfrac("1/1/2012", "7/30/2012", 1));
    }

    @Test
    public void testYearFrac() throws Throwable {
        // @see https://support.office.com/en-us/article/yearfrac-function-3844141e-c76d-4143-82b6-208454ddc6a8
        eval("0.58055556", Moments.yearfrac("1/1/2012", "7/30/2012"));

        eval("0.002777777777777778", Moments.yearfrac("1/1/1900", "1/2/1900"));
        eval("0.16666666666666666", Moments.yearfrac("1/31/1900", "3/31/1900", 0));
        eval("0.002777777777777778", Moments.yearfrac("1/31/1900", "2/1/1900", 0));
        eval("0.16666666666666666", Moments.yearfrac("1/30/1900", "3/31/1900", 0));
        eval("0.002777777777777778", Moments.yearfrac("1/1/1900", "1/2/1900", 4));

        eval("0.57808219", Moments.yearfrac("1/1/2012", "7/30/2012", 3));
        eval("0.57650273", Moments.yearfrac("1/1/2012", "7/30/2012", 1));
    }

    @Test
    public void testStatisticalCompatibility() throws Throwable {
        eval("1.020408", Statistics.avedev(4, 5, 6, 7, 5, 4, 3));
        eval("2.5", Statistics.avedev(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        eval("0", Statistics.avedev(1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        eval("0", Statistics.avedev(0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        eval("0.5", Statistics.avedev(1, 2, 1, 2, 1, 2, 1, 2, 1, 2));
        eval("2.5", Statistics.avedev(-1, -2, -3, -4, -5, -6, -7, -8, -9, -10));
        eval("4.5", Statistics.avedev(2, 4, 8, 16));
        eval("4.5", Statistics.avedev(2, 4, 8, 16));
        eval("4.5", Statistics.avedev(2, 4, 8, 16));
        eval("4.5", Statistics.avedev(2, 4, 8, 16));
        eval("7.5", Statistics.average(2, 4, 8, 16));
        eval("7.5", Statistics.average(2, 4, 8, 16));
        eval("7.5", Statistics.average(2, 4, 8, 16));
        eval("7.5", Statistics.average(2, 4, 8, 16));
        eval("7.5", Statistics.average(2, 4, 8, 16, true, false));
        eval("7.5", Statistics.averagea(2, 4, 8, 16));
        eval("7.5", Statistics.averagea(2, 4, 8, 16));
        eval("7.5", Statistics.averagea(2, 4, 8, 16));
        eval("3.5", Statistics.averagea(2, 4, 6, 8, true, false));

        // @see https://support.office.com/en-us/article/averageif-function-faec8e2e-0dec-4308-af69-f5576d8ac642
        eval("14000", Statistics.averageif(7000, 14000, 21000, 28000, "<23000"));
        eval("150000", Statistics.averageif(100000, 200000, 300000, 400000, "<250000"));
        // eval("14000", Statistics.averageif(100000,200000,300000,400000,"<95000"));
        eval("24500", Statistics.averageif(100000, 200000, 300000, 400000, ">250000", 7000, 14000, 21000, 28000));
        eval("16733.5", Statistics.averageif("east", "west", "north", "south (new office)", "midwest", "=*west", 45678, 23789, -4789, 0, 9678));
        eval("18589", Statistics.averageif("east", "west", "north", "south (new office)", "midwest", "<>*(new office)", 45678, 23789, -4789, 0, 9678));

        eval("12", Statistics.averageif(2, 4, 8, 16, ">5"));
        eval("3.5", Statistics.averageif(2, 4, 8, 16, ">5", 1, 2, 3, 4));
        eval("3.5", Statistics.averageif(2, 4, 8, 16, ">5", 1, 2, 3, 4));

        eval("2", Statistics.beta_inv(0.685470581, 8, 10, 1, 3));
        eval("1.9999999999999998", Statistics.beta_inv(0.6854705810117458, 8, 10, 1, 3));
        eval("0.205078125", Statistics.binom_dist(6, 10, 0.5, false));
        eval("0.08397496742904752", Statistics.binom_dist_range(60, 0.75, 48));
        eval("0.5236297934718873", Statistics.binom_dist_range(60, 0.75, 45, 50));
        eval("4", Statistics.binom_inv(6, 0.5, 0.75));
        eval("0.5204998778130242", Statistics.chisq_dist(0.5, 1, true));
        eval("0.20755375", Statistics.chisq_dist(2, 3, false));
        eval("0.5578254", Statistics.chisq_dist_rt(3, 4));
        eval("3.283020286473263", Statistics.chisq_inv(0.93, 1));
        eval("1.83258146374831", Statistics.chisq_inv(0.6, 2));
        eval("6.210757195", Statistics.chisq_inv_rt(0.4, 6));
        eval("0.006376", Statistics.chisq_test(58, 11, 10, 35, 25, 23, 45.35, 17.56, 16.09, 47.65, 18.44, 16.91));
        eval("0.9970544855015815", Statistics.correl(3, 2, 4, 5, 6, 9, 7, 12, 15, 17));
        eval("0", Statistics.count());
        eval("4", Statistics.count(1, 2, 3, 4));
        eval("4", Statistics.count(1, 2, 3, 4));
        eval("4", Statistics.count(1, 2, 3, 4));
        eval("4", Statistics.count(1, 2, 3, 4));
        eval("0", Statistics.counta());
        eval("4", Statistics.counta(1, 3, "a", "", "c"));
        eval("4", Statistics.counta(1, 3, "a", "", "c"));
        eval("4", Statistics.counta(1, 3, "a", "", "c"));
        eval("4", Statistics.counta(1, 3, "a", "", "c"));
        eval("0", Statistics.countblank());
        eval("1", Statistics.countblank(1, 3, "a", "", "c"));
        eval("1", Statistics.countblank(1, 3, "a", "", "c"));
        eval("1", Statistics.countblank(1, 3, "a", "", "c"));
        eval("1", Statistics.countblank(1, 3, "a", "", "c"));
        eval("5.2", Statistics.covariance_p(3, 2, 4, 5, 6, 9, 7, 12, 15, 17));
        eval("9.666666666666668", Statistics.covariance_s(2, 4, 8, 5, 11, 12));
        eval("48", Statistics.devsq(4, 5, 8, 7, 11, 4, 3));
        eval("0.8646647167633873", Statistics.expon_dist(0.2, 10, true));
        eval("1.353352832366127", Statistics.expon_dist(0.2, 10, false));
        eval("0.9899999999985833", Statistics.f_dist(15.20686486, 6, 4, true));
        eval("0.0012237995987608916", Statistics.f_dist(15.20686486, 6, 4, false));
        eval("0.0100", Statistics.f_dist_rt(15.20686486, 6, 4));
        eval("0.10930991412457851", Statistics.f_inv(0.01, 6, 4));
        eval("15.20686486", Statistics.f_inv_rt(0.01, 6, 4));
        eval("0.1497", Statistics.f_test(4, 2, 5, 1, 3, 8, 3, 9, 0, 1));
        eval("0.9729550745276566", Statistics.fisher(0.75));
        eval("0.75", Statistics.fisherinv(0.9729550745276566));
        eval("1.3293403919101043", Statistics.gamma(2.5));
        eval("0.26786611734776916", Statistics.gamma(-3.75));
        eval("0.068094", Statistics.gamma_dist(10.00001131, 9, 2, true));
        eval("0.03263913", Statistics.gamma_dist(10.00001131, 9, 2, false));
        eval("10.000011", Statistics.gamma_inv(0.068094, 9, 2));
        eval("1.7917594692280547", Statistics.gammaln(4));
        eval("1.7917594692280547", Statistics.gammaln_precise(4));
        eval("2.453736571", Statistics.gammaln_precise(4.5));
        eval("0.4772498680518208", Statistics.gauss(2));
        eval("5.476986969656962", Statistics.geomean(4, 5, 8, 7, 11, 4, 3));
        eval("5.028375962061728", Statistics.harmean(4, 5, 8, 7, 11, 4, 3));
        eval("0.3632610939112487", Statistics.hypgeom_dist(1, 4, 8, 20, false));
        eval("0.46542827657378744", Statistics.hypgeom_dist(1, 4, 8, 20, true));
        eval("-0.15179963720841627", Statistics.kurt(3, 4, 5, 2, 3, 4, 5, 6, 4, 7));
        eval("4", Statistics.large(3, 5, 3, 5, 4, 3));
        eval("0.0390835557068005", Statistics.lognorm_dist(4, 3.5, 1.2, true));
        eval("0.01761759668181924", Statistics.lognorm_dist(4, 3.5, 1.2, false));
        eval("4.000000000000001", Statistics.lognorm_inv(0.0390835557068005, 3.5, 1.2));
        eval("0", Statistics.max());
        eval("0.8", Statistics.max(0.1, 0.2, 0.4, 0.8, true, false));
        eval("1", Statistics.max(0, 0.1, 0.2, 0.4, 0.8, 1, true, false));
        eval("0", Statistics.maxa());
        eval("1", Statistics.maxa(0.1, 0.2, 0.4, 0.8, true, false));
        eval("1", Statistics.maxa(0.1, 0.2, 0.4, 0.8, true, false));
        eval("3", Statistics.median(1, 2, 3, 4, 5));
        eval("3.5", Statistics.median(1, 2, 3, 4, 5, 6));
        eval("0", Statistics.min());
        eval("0.1", Statistics.min(0.1, 0.2, 0.4, 0.8, true, false));
        eval("0", Statistics.min(0, 0.1, 0.2, 0.4, 0.8, 1, true, false));
        eval("0", Statistics.min(10, 0, 0.1, 0.2, 10, 0.4, 0.8, 1, 10, 10, true, false));
        eval("0", Statistics.mina());
        eval("0", Statistics.mina(0.1, 0.2, 0.4, 0.8, true, false));
        eval("0", Statistics.mina(10, 0, 0.1, 0.2, 10, 0.4, 0.8, 1, 10, 10, true, false));

        // @see https://support.office.com/en-us/article/negbinom-dist-function-c8239f89-c2d0-45bd-b6af-172e570f8599?ui=en-us&rs=en-us&ad=us
        eval("0.3135141", Statistics.negbinom_dist(10, 5, 0.25, true));

        // @see https://support.office.com/en-us/article/norm-dist-function-edb1cc14-a21c-4e53-839d-8082074c9f8d?ui=en-us&rs=en-us&ad=us
        eval("0.9087888", Statistics.norm_dist(42, 40, 1.5, true));
        eval("0.10934", Statistics.norm_dist(42, 40, 1.5, false));

        // @see https://support.office.com/en-us/article/norm-inv-function-54b30935-fee7-493c-bedb-2278a9db7e13?ui=en-us&rs=en-us&ad=us
        eval("42.000002", Statistics.norm_inv(0.908789, 40, 1.5));

        // @see https://support.office.com/en-us/article/norm-s-dist-function-1e787282-3832-4520-a9ae-bd2a8d99ba88?ui=en-us&rs=en-us&ad=us
        eval("0.908788726", Statistics.norm_s_dist(1.333333, true));
        eval("0.164010148", Statistics.norm_s_dist(1.333333, false));

        // @see https://support.office.com/en-us/article/norm-s-inv-function-d6d556b4-ab7f-49cd-b526-5a20918452b1?ui=en-us&rs=en-us&ad=us
        eval("1.3333347", Statistics.norm_s_inv(0.908789));

        // @see https://support.office.com/en-us/article/pearson-function-0c3e30fc-e5af-49c4-808a-3ef66e034c18
        eval("0.699379", Statistics.pearson(9, 7, 5, 3, 1, 10, 6, 1, 5, 3));

        // @see https://support.office.com/en-us/article/percentile-exc-function-bbaa7204-e9e1-4010-85bf-c31dc5dce4ba?ui=en-us&rs=en-us&ad=us
        eval("2.5", Statistics.percentile_exc(1, 2, 3, 6, 6, 6, 7, 8, 9, 0.25));

        // @see https://support.office.com/en-us/article/percentile-inc-function-680f9539-45eb-410b-9a5e-c1355e5fe2ed?ui=en-us&rs=en-us&ad=us
        eval("1.9", Statistics.percentile_inc(1, 2, 3, 4, 0.3));

        // @see https://support.office.com/en-us/article/permut-function-3bd1cb9a-2880-41ab-a197-f246a7a602d3
        eval("970200", Statistics.permut(100, 3));
        eval("6", Statistics.permut(3, 2));

        // @see https://support.office.com/en-us/article/permutationa-function-6c7d7fdc-d657-44e6-aa19-2857b25cae4e
        eval("9", Statistics.permutationa(3, 2));
        eval("4", Statistics.permutationa(2, 2));

        // @see https://support.office.com/en-us/article/phi-function-23e49bc6-a8e8-402d-98d3-9ded87f6295c
        eval("0.30113743215480443", Statistics.phi(0.75));

        eval("0.12465201948308113", Statistics.poisson_dist(2, 5, true));
        eval("0.08422433748856833", Statistics.poisson_dist(2, 5, false));

        // @see https://support.office.com/en-us/article/prob-function-9ac30561-c81c-4259-8253-34f0a238fc49
        eval("0.1", Statistics.prob(0, 1, 2, 3, 0.2, 0.3, 0.1, 0.4, 2));
        eval("0.8", Statistics.prob(0, 1, 2, 3, 0.2, 0.3, 0.1, 0.4, 1, 3));
        eval("0", Statistics.prob(0, 1, 2, 3, 0.2, 0.3, 0.1, 0.4));

        // @see https://support.office.com/en-us/article/quartile-exc-function-5a355b7a-840b-4a01-b0f1-f538c2864cad?ui=en-us&rs=en-us&ad=us
        eval("40", Statistics.quartile_exc(6, 7, 15, 36, 39, 40, 41, 42, 43, 47, 49, 2));

        // @see https://support.office.com/en-us/article/quartile-inc-function-1bbacc80-5075-42f1-aed6-47d735c4819d?ui=en-us&rs=en-us&ad=us
        eval("7.5", Statistics.quartile_inc(1, 2, 4, 7, 8, 9, 10, 12, 2));
        eval("9.25", Statistics.quartile_inc(1, 2, 4, 7, 8, 9, 10, 12, 3));

        // todo
        eval("0.05795019157088122", Statistics.rsq(2, 3, 9, 1, 8, 7, 5, 6, 5, 11, 7, 5, 4, 4));
        eval("0.3595430714067974", Statistics.skew(3, 4, 5, 2, 3, 4, 5, 6, 4, 7));
        eval("0.3055555555555556", Statistics.slope(2, 3, 9, 1, 8, 7, 5, 6, 5, 11, 7, 5, 4, 4));
        eval("4", Statistics.small(3, 4, 5, 2, 3, 4, 6, 4, 7, 4));
        eval("1.3333333333333333", Statistics.standardize(42, 40, 1.5));
        eval("0", Statistics.standardize(10, 10, 10));
        eval("26.054558142482477", Statistics.stdev_p(1345, 1301, 1368, 1322, 1310, 1370, 1318, 1350, 1303, 1299));
        eval("27.46391571984349", Statistics.stdeva(1345, 1301, 1368, 1322, 1310, 1370, 1318, 1350, 1303, 1299));
        eval("26.054558142482477", Statistics.stdevpa(1345, 1301, 1368, 1322, 1310, 1370, 1318, 1350, 1303, 1299));
        eval("0.9946953263673741", Statistics.t_dist(60, 1, true));
        eval("0.0007369065188787021", Statistics.t_dist(8, 3, false));
        eval("0.092426312", Statistics.t_dist_2t(2, 6));
        eval("0.002490664", Statistics.t_dist_2t(20, 2));
        eval("0.025016522", Statistics.t_dist_rt(2, 60));
        eval("0.046213156", Statistics.t_dist_rt(2, 6));
        eval("1.2958210933417948", Statistics.t_inv(0.9, 60));
        eval("0.126194364", Statistics.t_inv_2t(0.9, 60));
        eval("3.7777777777777777", Statistics.trimmean(4, 5, 6, 7, 2, 3, 4, 5, 1, 2, 3, 0.2));
        eval("13.333333333333334", Statistics.var_p(1, 2, 3, 4, 10, 10));
        // @see https://support.office.com/en-us/article/var-p-function-73d1285c-108c-4843-ba5d-a51f90656f3a?ui=en-us&rs=en-us&ad=us
        eval("678.84", Statistics.var_p(1345, 1301, 1368, 1322, 1310, 1370, 1318, 1350, 1303, 1299));
        eval("754.26666666", Statistics.var_s(1345, 1301, 1368, 1322, 1310, 1370, 1318, 1350, 1303, 1299));
        eval("754.26667", Statistics.vara(1345, 1301, 1368, 1322, 1310, 1370, 1318, 1350, 1303, 1299));
        eval("678.84", Statistics.varpa(1345, 1301, 1368, 1322, 1310, 1370, 1318, 1350, 1303, 1299));

        eval("0.9295813900692769", Statistics.weibull_dist(105, 20, 100, true));
        eval("0.03558886402450435", Statistics.weibull_dist(105, 20, 100, false));
        // @see https://support.office.com/en-us/article/z-test-function-d633d5a3-2031-4614-a016-92180ad82bee?ui=en-us&rs=en-us&ad=us
        eval("0.09057419685136381", Statistics.z_test(3, 6, 7, 8, 6, 5, 4, 2, 1, 9, 4));
        eval("0.863043", Statistics.z_test(3, 6, 7, 8, 6, 5, 4, 2, 1, 9, 6));

        // @see https://support.office.com/en-us/article/t-test-function-d4e08ec3-c545-485f-962e-276f7cbed055?ui=en-us&rs=en-us&ad=us
        eval("0.196016", Statistics.t_test(3, 4, 5, 8, 9, 1, 2, 4, 5, 6, 19, 3, 2, 14, 4, 5, 17, 1, 2, 1));

//        eval("36.42176053333", Statistics.avedev(123.12, 33.3333, 2 / 3, 5.37828, 0.999));
//        eval("9.966606842186748", Statistics.beta_dist(1 / 52, 0.4, 9.6, false));
//        eval("0.5406016379941343", Statistics.beta_dist(1 / 52, 0.4, 9.6, true));
//
//        // @see https://support.office.com/en-us/article/percentrank-exc-function-d8afee96-b7e2-4a2f-8c01-8fcdedaa6314?ui=en-us&rs=en-us&ad=us
//        eval("0.7", Statistics.percentrank_exc(1, 2, 3, 6, 6, 6, 7, 8, 9, 7));
//
//        // @see https://support.office.com/en-us/article/percentrank-inc-function-149592c9-00c0-49ba-86c1-c1f45b80463a?ui=en-us&rs=en-us&ad=us
//        eval("0.555", Statistics.percentrank_inc(13, 12, 11, 8, 4, 3, 2, 1, 1, 1, 4));
//        eval("0.666", Statistics.percentrank_inc(13, 12, 11, 8, 4, 3, 2, 1, 1, 1, 8));
//        eval("0.333", Statistics.percentrank_inc(13, 12, 11, 8, 4, 3, 2, 1, 1, 1, 2));
    }

    @Test
    public void testFinancialCompatibility() throws Throwable {
        // https://support.office.com/en-us/article/accrint-function-fe45d089-6722-4fb3-9379-e1f911d8dc74
        eval("16.666667", Financials.accrint(39508, 39691, 39569, 0.1, 1000, 2, 0));
        eval("15.555556", Financials.accrint(Moments.date(2008, 3, 5), 39691, 39569, 0.1, 1000, 2, 0, false));
        eval("7.2222222", Financials.accrint(Moments.date(2008, 4, 5), 39691, 39569, 0.1, 1000, 2, 0, true));

        eval("183.88888888888889", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2012, 3, 30), Moments.date(2013, 12, 4), 0.1, 1000, 1, 0, true));
        eval("183.88888888888889", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2012, 3, 30), Moments.date(2013, 12, 4), 0.1, 1000, 1, 0, true));
        eval("183.88888888888889", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2012, 3, 30), Moments.date(2013, 12, 4), 0.1, 1000, 2, 0, true));
        eval("183.88888888888889", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2012, 3, 30), Moments.date(2013, 12, 4), 0.1, 1000, 4, 0, true));

        eval("183.88888888888889", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2012, 3, 30), Moments.date(2013, 12, 4), 0.1, 1000, 1, 4, true));
        eval("183.88888888888889", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2012, 3, 30), Moments.date(2013, 12, 4), 0.1, 1000, 2, 4, true));
        eval("183.88888888888889", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2012, 3, 30), Moments.date(2013, 12, 4), 0.1, 1000, 4, 4, true));
        eval("183.88888888888889", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2012, 3, 30), Moments.date(2013, 12, 4), 0.1, 1000, 1, 0, false));
        eval("183.88888888888889", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2012, 3, 30), Moments.date(2013, 12, 4), 0.1, 1000, 2, 0, false));
        eval("183.88888888888889", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2012, 3, 30), Moments.date(2013, 12, 4), 0.1, 1000, 4, 0, false));

        eval("183.88888888888889", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2012, 3, 30), Moments.date(2013, 12, 4), 0.1, 1000, 1, 4, false));
        eval("183.88888888888889", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2012, 3, 30), Moments.date(2013, 12, 4), 0.1, 1000, 2, 4, false));
        eval("183.88888888888889", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2012, 3, 30), Moments.date(2013, 12, 4), 0.1, 1000, 4, 4, false));
        eval("16.11111111111111", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 1, 0, true));
        eval("16.11111111111111", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 2, 0, true));
        eval("16.11111111111111", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 4, 0, true));
        eval("15.573770491803279", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 1, 1, true));
        eval("15.573770491803279", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 2, 1, true));
        eval("15.573770491803279", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 4, 1, true));
        eval("15.833333333333332", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 1, 2, true));
        eval("15.833333333333332", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 2, 2, true));
        eval("15.833333333333332", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 4, 2, true));
        eval("15.616438356164384", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 1, 3, true));
        eval("15.616438356164384", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 2, 3, true));
        eval("15.616438356164384", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 4, 3, true));
        eval("16.11111111111111", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 1, 4, true));
        eval("16.11111111111111", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 2, 4, true));
        eval("16.11111111111111", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 4, 4, true));
        eval("16.11111111111111", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 1, 0, false));
        eval("16.11111111111111", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 2, 0, false));
        eval("16.11111111111111", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 4, 0, false));
        eval("15.573770491803279", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 1, 1, false));
        eval("15.573770491803279", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 2, 1, false));
        eval("15.573770491803279", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 4, 1, false));
        eval("15.833333333333332", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 1, 2, false));
        eval("15.833333333333332", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 2, 2, false));
        eval("15.833333333333332", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 4, 2, false));
        eval("15.616438356164384", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 1, 3, false));
        eval("15.616438356164384", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 2, 3, false));
        eval("15.616438356164384", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 4, 3, false));
        eval("16.11111111111111", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 1, 4, false));
        eval("16.11111111111111", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 2, 4, false));
        eval("16.11111111111111", Financials.accrint(Moments.date(2012, 2, 2), Moments.date(2013, 12, 4), Moments.date(2012, 3, 30), 0.1, 1000, 4, 4, false));
        eval("183.88888888888889", Financials.accrint("2/2/2012", "3/30/2012", "12/4/2013", 0.1, 1000, 1, 0, true));
        eval("183.88888888888889", Financials.accrint("2/2/2012", "3/30/2012", "12/4/2013", 0.1, 1000, 1, 0, true));
        eval("183.88888888888889", Financials.accrint("2/2/2012", "3/30/2012", "12/4/2013", 0.1, 1000, 2, 0, true));
        eval("183.88888888888889", Financials.accrint("2/2/2012", "3/30/2012", "12/4/2013", 0.1, 1000, 4, 0, true));
        eval("183.88888888888889", Financials.accrint("2/2/2012", "3/30/2012", "12/4/2013", 0.1, 1000, 1, 4, true));
        eval("183.88888888888889", Financials.accrint("2/2/2012", "3/30/2012", "12/4/2013", 0.1, 1000, 2, 4, true));
        eval("183.88888888888889", Financials.accrint("2/2/2012", "3/30/2012", "12/4/2013", 0.1, 1000, 4, 4, true));
        eval("183.88888888888889", Financials.accrint("2/2/2012", "3/30/2012", "12/4/2013", 0.1, 1000, 1, 0, false));
        eval("183.88888888888889", Financials.accrint("2/2/2012", "3/30/2012", "12/4/2013", 0.1, 1000, 2, 0, false));
        eval("183.88888888888889", Financials.accrint("2/2/2012", "3/30/2012", "12/4/2013", 0.1, 1000, 4, 0, false));
        eval("183.88888888888889", Financials.accrint("2/2/2012", "3/30/2012", "12/4/2013", 0.1, 1000, 1, 4, false));
        eval("183.88888888888889", Financials.accrint("2/2/2012", "3/30/2012", "12/4/2013", 0.1, 1000, 2, 4, false));
        eval("183.88888888888889", Financials.accrint("2/2/2012", "3/30/2012", "12/4/2013", 0.1, 1000, 4, 4, false));
        eval("16.11111111111111", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 1, 0, true));
        eval("16.11111111111111", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 2, 0, true));
        eval("16.11111111111111", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 4, 0, true));
        eval("15.573770491803279", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 1, 1, true));
        eval("15.573770491803279", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 2, 1, true));
        eval("15.573770491803279", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 4, 1, true));
        eval("15.833333333333332", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 1, 2, true));
        eval("15.833333333333332", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 2, 2, true));
        eval("15.833333333333332", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 4, 2, true));
        eval("15.616438356164384", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 1, 3, true));
        eval("15.616438356164384", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 2, 3, true));
        eval("15.616438356164384", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 4, 3, true));
        eval("16.11111111111111", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 1, 4, true));
        eval("16.11111111111111", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 2, 4, true));
        eval("16.11111111111111", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 4, 4, true));
        eval("16.11111111111111", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 1, 0, false));
        eval("16.11111111111111", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 2, 0, false));
        eval("16.11111111111111", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 4, 0, false));
        eval("15.573770491803279", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 1, 1, false));
        eval("15.573770491803279", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 2, 1, false));
        eval("15.573770491803279", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 4, 1, false));
        eval("15.833333333333332", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 1, 2, false));
        eval("15.833333333333332", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 2, 2, false));
        eval("15.833333333333332", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 4, 2, false));
        eval("15.616438356164384", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 1, 3, false));
        eval("15.616438356164384", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 2, 3, false));
        eval("15.616438356164384", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 4, 3, false));
        eval("16.11111111111111", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 1, 4, false));
        eval("16.11111111111111", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 2, 4, false));
        eval("16.11111111111111", Financials.accrint("2/2/2012", "12/4/2013", "3/30/2012", 0.1, 1000, 4, 4, false));

        // @see https://support.office.com/en-us/article/fv-function-2eef9f44-a084-4c61-bdd8-4fe4bb1b71b3
        eval("2581.40337", Financials.fv(0.06 / 12, 10, -200, -500, 1));
        eval("12682.50301", Financials.fv(0.12 / 12, 12, -1000));
        eval("2301.40183", Financials.fv(0.06 / 12, 12, -100, -1000, 1));
        eval("82846.24637", Financials.fv(0.11 / 12, 35, -2000, 0, 1));

        // @see https://support.office.com/en-us/article/pmt-function-0214da64-9a63-4996-bc20-214433fa6441
        eval("1037.03209", Formulas.abs(Financials.pmt(0.08 / 12, 10, 10000, 0, 0)));
        eval("1037.03209", Formulas.abs(Financials.pmt(0.08 / 12, 10, 10000, 0)));
        eval("1037.03209", Formulas.abs(Financials.pmt(0.08 / 12, 10, 10000)));
        eval("1030.16433", Formulas.abs(Financials.pmt(0.08 / 12, 10, 10000, 0, 1)));
        eval("129.08116", Formulas.abs(Financials.pmt(0.06 / 12, 18 * 12, 0, 50000)));
        eval("129.08116", Formulas.abs(Financials.pmt(0.06 / 12, 18 * 12, 0, 50000, 0)));

        // @see https://support.office.com/en-us/article/cumipmt-function-61067bb0-9016-427d-b95b-1a752af0e606
        eval("-11135.23213", Financials.cumipmt(0.09 / 12, 30 * 12, 125000, 13, 24, 0));
        eval("-937.5", Financials.cumipmt(0.09 / 12, 30 * 12, 125000, 1, 1, 0));


        eval("-9916.77251395708", Financials.cumipmt(0.1 / 12, 30 * 12, 100000, 13, 24, 0));
        eval("-9834.815716321069", Financials.cumipmt(0.1 / 12, 30 * 12, 100000, 13, 24, 1));
        eval("-19891.752778759568", Financials.cumipmt(0.1 / 12, 30 * 12, 100000, 1, 24, 0));
        eval("-614.0863271085149", Financials.cumprinc(0.1 / 12, 30 * 12, 100000, 13, 24, 0));
        eval("-609.0112334960476", Financials.cumprinc(0.1 / 12, 30 * 12, 100000, 13, 24, 1));
//        eval("-1169.9649033716187", Financials.cumprinc(0.1/12,30*12,100000,1,24,0));
//        eval("-1986.7420529305305", Financials.cumprinc(0.1/12,30*12,100000,1,24,1));

        // @see https://support.office.com/en-us/article/db-function-354e7d28-5f93-4ff1-8a52-eb4ee549d9d7
        eval("186083.33333", Financials.db(1000000, 100000, 6, 1, 7));
        eval("259639.41667", Financials.db(1000000, 100000, 6, 2, 7));
        eval("176814.44275", Financials.db(1000000, 100000, 6, 3, 7));
        eval("120410.63551", Financials.db(1000000, 100000, 6, 4, 7));
        eval("81999.64278", Financials.db(1000000, 100000, 6, 5, 7));
        eval("55841.75674", Financials.db(1000000, 100000, 6, 6, 7));

        eval("319000", Financials.db(1000000, 100000, 6, 1));
        eval("217239", Financials.db(1000000, 100000, 6, 2));
        eval("147939.759", Financials.db(1000000, 100000, 6, 3));
        eval("100746.97587900002", Financials.db(1000000, 100000, 6, 4));
        eval("68608.690573599", Financials.db(1000000, 100000, 6, 5));
        eval("46722.518280620934", Financials.db(1000000, 100000, 6, 6));
        eval("159500", Financials.db(1000000, 100000, 6, 1, 6));
        eval("268119.5", Financials.db(1000000, 100000, 6, 2, 6));
        eval("182589.3795", Financials.db(1000000, 100000, 6, 3, 6));
        eval("124343.36743949998", Financials.db(1000000, 100000, 6, 4, 6));
        eval("84677.83322629951", Financials.db(1000000, 100000, 6, 5, 6));
        eval("57665.60442710997", Financials.db(1000000, 100000, 6, 6, 6));
        eval("239250", Financials.db(1000000, 100000, 6, 1, 9));
        eval("242679.25", Financials.db(1000000, 100000, 6, 2, 9));
        eval("165264.56925", Financials.db(1000000, 100000, 6, 3, 9));
        eval("112545.17165925002", Financials.db(1000000, 100000, 6, 4, 9));
        eval("76643.26189994926", Financials.db(1000000, 100000, 6, 5, 9));
        eval("52194.061353865436", Financials.db(1000000, 100000, 6, 6, 9));
        eval("0", Financials.db(1000000, 1000000, 6, 1, 6));
        eval("0", Financials.db(100000, 1000000, 6, 1, 6));

        // @see https://support.office.com/en-us/article/ddb-function-519a7a37-8772-4c96-85c0-ed2c209717a5
        eval("1.31507", Financials.ddb(2400, 300, 10 * 365, 1));
        eval("1.31507", Financials.ddb(2400, 300, 10 * 365, 1, 2));
        eval("40.00", Financials.ddb(2400, 300, 10 * 12, 1, 2));
        eval("40.00", Financials.ddb(2400, 300, 10 * 12, 1));
        eval("480.00", Financials.ddb(2400, 300, 10, 1, 2));
        eval("480.00", Financials.ddb(2400, 300, 10, 1));
        eval("306.00", Financials.ddb(2400, 300, 10, 2, 1.5));

        eval("333333.3333333333", Financials.ddb(1000000, 100000, 6, 1));
        eval("222222.22222222225", Financials.ddb(1000000, 100000, 6, 2));
        eval("148148.14814814815", Financials.ddb(1000000, 100000, 6, 3));
        eval("98765.43209876546", Financials.ddb(1000000, 100000, 6, 4));

        eval("250000", Financials.ddb(1000000, 100000, 6, 1, 1.5));
        eval("187500", Financials.ddb(1000000, 100000, 6, 2, 1.5));
        eval("140625", Financials.ddb(1000000, 100000, 6, 3, 1.5));
        eval("105468.75", Financials.ddb(1000000, 100000, 6, 4, 1.5));
        eval("79101.5625", Financials.ddb(1000000, 100000, 6, 5, 1.5));
        eval("59326.171875", Financials.ddb(1000000, 100000, 6, 6, 1.5));
        eval("0", Financials.ddb(1000000, 1000000, 6, 1, 1.5));
        eval("0", Financials.ddb(100000, 1000000, 6, 1, 1.5));
        // @see https://support.office.com/en-us/article/dollarde-function-db85aab0-1677-428a-9dfd-a38476693427
        eval("1.125", Financials.dollarde(1.02, 16));
        eval("1.3125", Financials.dollarde(1.1, 32));

        eval("1.1", Financials.dollarde(1.1, 1));
        eval("1.5", Financials.dollarde(1.1, 2));
        eval("1.25", Financials.dollarde(1.1, 4));
        eval("1.125", Financials.dollarde(1.1, 8));
        eval("1.625", Financials.dollarde(1.1, 16));
        eval("1.3125", Financials.dollarde(1.1, 32));
        eval("-1.1", Financials.dollarde(-1.1, 1));
        eval("-1.5", Financials.dollarde(-1.1, 2));
        eval("-1.25", Financials.dollarde(-1.1, 4));
        eval("-1.125", Financials.dollarde(-1.1, 8));
        eval("-1.625", Financials.dollarde(-1.1, 16));
        eval("-1.3125", Financials.dollarde(-1.1, 32));

        // @see https://support.office.com/en-us/article/dollarfr-function-0835d163-3023-4a33-9824-3042c5d4f495
        eval("1.02", Financials.dollarfr(1.125, 16));
        eval("1.04", Financials.dollarfr(1.125, 32));

        eval("1.1", Financials.dollarfr(1.1, 1));
        eval("1.1", Financials.dollarfr(1.5, 2));
        eval("1.1", Financials.dollarfr(1.25, 4));
        eval("1.1", Financials.dollarfr(1.125, 8));
        eval("1.1", Financials.dollarfr(1.625, 16));
        eval("1.1", Financials.dollarfr(1.3125, 32));
        eval("-1.1", Financials.dollarfr(-1.1, 1));
        eval("-1.1", Financials.dollarfr(-1.5, 2));
        eval("-1.1", Financials.dollarfr(-1.25, 4));
        eval("-1.1", Financials.dollarfr(-1.125, 8));
        eval("-1.1", Financials.dollarfr(-1.625, 16));
        eval("-1.1", Financials.dollarfr(-1.3125, 32));

        // @see https://support.office.com/en-us/article/effect-function-910d4e4c-79e2-4009-95e6-507e04f11bc4
        eval("0.0535427", Financials.effect(0.0525, 4));

        eval("0.10381289062499977", Financials.effect(0.1, 4));
        eval("0.10381289062499977", Financials.effect(0.1, 4.5));
        eval("2581.4033740601185", Financials.fv(0.06 / 12, 10, -200, -500, 1));
        eval("12682.503013196976", Financials.fv(0.12 / 12, 12, -1000));
        eval("2301.4018303408993", Financials.fv(0.06 / 12, 12, -100, -1000, 1));
        eval("2200", Financials.fv(0, 12, -100, -1000, 1));

        // @see https://support.office.com/en-us/article/fvschedule-function-bec29522-bd87-4082-bab9-a241f3fb251d
        eval("1.33089", Financials.fvschedule(1, new Number[]{0.09, 0.11, 0.1}));

        eval("133.08900000000003", Financials.fvschedule(100, 0.09, 0.1, 0.11));

        // @see https://support.office.com/en-us/article/ipmt-function-5cce0ad6-8402-4a41-8d29-61a0b054cb6f
        eval("66.66667", Formulas.abs(Financials.ipmt(0.1 / 12, 1, 3 * 12, 8000)));
        eval("292.44713", Formulas.abs(Financials.ipmt(0.1, 3, 3, 8000)));

        eval("928.8235718400465", Financials.ipmt(0.1 / 12, 6, 2 * 12, 100000, 1000000, 0));
        eval("921.1473439736042", Financials.ipmt(0.1 / 12, 6, 2 * 12, 100000, 1000000, 1));
        eval("0", Financials.ipmt(0.1 / 12, 1, 2 * 12, 100000, 1000000, 1));
        eval("-833.3333333333334", Financials.ipmt(0.1 / 12, 1, 2 * 12, 100000, 1000000, 0));

        // @see https://support.office.com/en-us/article/ispmt-function-fa58adb6-9d39-4ce0-8f43-75399cea56cc
        eval("-64814.81481", Financials.ispmt(0.1 / 12, 1, 3 * 12, 8000000));
        eval("-533333.33333", Financials.ispmt(0.1, 1, 3, 8000000));

        eval("-625", Financials.ispmt(0.1 / 12, 6, 2 * 12, 100000));

        // @see https://support.office.com/en-us/article/npv-function-8672cb67-2576-4d07-b67b-ac28acf2a568
        eval("1188.44341", Financials.npv(0.1, -10000, 3000, 4200, 6800));
        eval("1922.06155", Financials.npv(0.08, 8000, 9200, 10000, 12000, 14500).add(FormulaDecimal.valueOf(-40000)));
        eval("3749.46509", Formulas.abs(Financials.npv(0.08, 8000, 9200, 10000, 12000, 14500, -9000).add(FormulaDecimal.valueOf(-40000))));

        // @see https://support.office.com/en-us/article/mirr-function-b020f038-7492-4fb4-93c1-35c345b53524
        eval("0.12609", Financials.mirr(-120000, 39000, 30000, 21000, 37000, 46000, 0.1, 0.12));
        eval("-0.04804", Financials.mirr(-120000, 39000, 30000, 21000, 0.1, 0.12));
        eval("0.13476", Financials.mirr(-120000, 39000, 30000, 21000, 37000, 46000, 0.1, 0.14));

        eval("0.07971710360838036", Financials.mirr(-75000, 12000, 15000, 18000, 21000, 24000, 0.1, 0.12));

        // @see https://support.office.com/en-us/article/nominal-function-7f1ae29b-6b92-435e-b950-ad8b190ddd2b
        eval("0.05250032", Financials.nominal(0.053543, 4));

        eval("0.09645475633778045", Financials.nominal(0.1, 4));
        eval("0.09645475633778045", Financials.nominal(0.1, 4.5));

        // @see https://support.office.com/en-us/article/nper-function-240535b5-6653-4d2d-bfcf-b6a38151d815
        eval("59.6738657", Financials.nper(0.12 / 12, -100, -1000, 10000, 1));
        eval("60.0821229", Financials.nper(0.12 / 12, -100, -1000, 10000));
        eval("-9.57859404", Financials.nper(0.12 / 12, -100, -1000));

        eval("63.39385422740764", Financials.nper(0.1 / 12, -100, -1000, 10000, 0));
        eval("63.016966422019685", Financials.nper(0.1 / 12, -100, -1000, 10000, 1));
        eval("63.39385422740764", Financials.nper(0.1 / 12, -100, -1000, 10000));
        eval("-9.645090919837394", Financials.nper(0.1 / 12, -100, -1000));
        eval("1031.3503176012546", Financials.npv(0.1, -10000, 2000, 4000, 8000));
        eval("1031.3503176012546", Financials.npv(0.1, -10000, 2000, 4000, 8000));
        eval("-68181.81818181818", Financials.npv(0.1, -75000));
        eval("62448.362521940246", Financials.npv(0.12, 12000, 15000, 18000, 21000, 24000));

        // @see https://support.office.com/en-us/article/pduration-function-44f33460-5be5-4c90-b857-22308892adaf
        eval("3.85987", Financials.pduration(0.025, 2000, 2200));
        eval("87.60548", Financials.pduration(0.025 / 12, 1000, 1200));

        eval("7.272540897341714", Financials.pduration(0.1, 1000, 2000));

        eval("-129.0811608679973", Financials.pmt(0.06 / 12, 18 * 12, 0, 50000));
        eval("-42075.45683100995", Financials.pmt(0.1 / 12, 2 * 12, 100000, 1000000, 1));
        eval("-42426.08563793503", Financials.pmt(0.1 / 12, 2 * 12, 100000, 1000000));
        eval("-37811.59300418336", Financials.pmt(0.1 / 12, 2 * 12, 0, 1000000));
        eval("-4614.49263375167", Financials.pmt(0.1 / 12, 2 * 12, 100000));
        eval("-4166.666666666667", Financials.pmt(0, 2 * 12, 100000));

        // @see https://support.office.com/en-us/article/ppmt-function-c370d9e3-7749-4ca4-beea-b06c6ac95e1b
        eval("-75.62319", Financials.ppmt(0.1 / 12, 1, 2 * 12, 2000));
        eval("-27598.05346", Financials.ppmt(0.08, 10, 10, 200000));

        eval("-75.62318600836673", Financials.ppmt(0.1 / 12, 1, 2 * 12, 2000));
        eval("-27598.05346242135", Financials.ppmt(0.08, 10, 10, 200000));
        eval("-43354.909209775076", Financials.ppmt(0.1 / 12, 6, 2 * 12, 100000, 1000000, 0));
        eval("-42996.60417498356", Financials.ppmt(0.1 / 12, 6, 2 * 12, 100000, 1000000, 1));
        eval("-3941.355382706826", Financials.ppmt(0.1 / 12, 6, 2 * 12, 100000));

        // @see https://support.office.com/en-us/article/pv-function-23879d31-0e02-4321-be01-da16e8168cbd
        // note: actual value is ($59,777,145.85), docs are incorrect. tests below are correct.
        eval("-59777145.85119", Financials.pv(0.08 / 12, 12 * 20, 500000, 0, 0));
        eval("-59777145.85119", Financials.pv(0.08 / 12, 12 * 20, 500000, 0));
        eval("-59777145.85119", Financials.pv(0.08 / 12, 12 * 20, 500000));

        eval("-29864.950264779152", Financials.pv(0.1 / 12, 2 * 12, 1000, 10000, 0));
        eval("-30045.54072173169", Financials.pv(0.1 / 12, 2 * 12, 1000, 10000, 1));

        // @see https://support.office.com/en-us/article/rate-function-9f665657-4a7e-4bb7-a030-83fc59e748ce
        eval("0.00770", Financials.rate(4 * 12, -200, 8000));
        eval("0.09243", Financials.rate(4 * 12, -200, 8000).multiply(FormulaDecimal.valueOf(12)));

        eval("0.06517891177181546", Financials.rate(2 * 12, -1000, -10000, 100000));
        eval("0.06517891177181533", Financials.rate(2 * 12, -1000, -10000, 100000, 0, 0.1));
        eval("0.0651789117718154", Financials.rate(2 * 12, -1000, -10000, 100000, 0, 0.75));
        eval("0.06517891177181524", Financials.rate(2 * 12, -1000, -10000, 100000, 0, 0.065));
        eval("0.0632395800018064", Financials.rate(2 * 12, -1000, -10000, 100000, 1, 0.1));

        // @see https://support.office.com/en-us/article/rri-function-6f5822d8-7ef1-4233-944c-79e8172930f4
        eval("0.0009933", Financials.rri(96, 10000, 11000));

        eval("0.011985024140399592", Financials.rri(8, 10000, 11000));

        // @see https://support.office.com/en-us/article/sln-function-cdb666e5-c1c6-40a7-806a-e695edc2f1c8
        eval("2250", Financials.sln(30000, 7500, 10));

        // @see https://support.office.com/en-us/article/syd-function-069f8106-b60b-4ca2-98e0-2a0f206bdb27
        eval("4090.90909", Financials.syd(30000, 7500, 10, 1));
        eval("409.09091", Financials.syd(30000, 7500, 10, 10));

        eval("4.181818181818182", Financials.syd(30, 7, 10, 1));

        // @see https://support.office.com/en-us/article/tbilleq-function-2ab72d90-9b4d-4efe-9fc2-0f81f2c19c8c
        eval("0.09415", Financials.tbilleq("03/31/2008", "06/01/2008", 0.0914));

//        eval("0.09412721351734614", Financials.tbilleq("03/31/2008","06/01/2008",0.0914));

        // @see https://support.office.com/en-us/article/tbillprice-function-eacca992-c29d-425a-9eb8-0513fe6035a2
        eval("98.45", Financials.tbillprice("03/31/2008", "06/01/2008", 0.09));

//        eval("98.45127777777778", Financials.tbillprice("03/31/2008","06/01/2008",0.0914));

        // @see https://support.office.com/en-us/article/tbillyield-function-6d381232-f4b0-4cd5-8e97-45b9c03468ba
        eval("0.09142", Financials.tbillyield("03/31/2008", "06/01/2008", 98.45));

//        eval("0.09283779963354702", Financials.tbillyield("03/31/2008","06/01/2008",98.45127777777778));

        // @see https://support.office.com/en-us/article/xirr-function-de1242ec-6477-445b-b11b-a303ad9adc9d
        eval("0.373362535", Financials.xirr(-10000, 2750, 4250, 3250, 2750, "01/01/2008", "03/01/2008", "10/30/2008", "02/15/2009", "04/01/2009", 0.1));

//        eval("0.3734", Financials.xirr(-10000,2750,4250,3250,2750,"01/01/2008","03/01/2008","10/30/2008","02/15/2009","04/01/2009",0.1));
//        eval("0.3734", Financials.xirr(-10000,2750,4250,3250,2750,"01/01/08","01/03/08","30/10/08","15/02/09","01/04/09",0.1));

        // @see https://support.office.com/en-us/article/xnpv-function-1b42bbf6-370f-4532-a0eb-d67c16b664b7
        eval("2086.64760", Financials.xnpv(0.09, -10000, 2750, 4250, 3250, 2750, "01/01/2008", "03/01/2008", "10/30/2008", "02/15/2009", "04/01/2009"));

        // @see https://support.office.com/en-us/article/irr-function-64925eaa-9988-495b-b290-3ad0c163c1bc
        eval("-0.0212448482734", Financials.irr(-70000, 12000, 15000, 18000, 21000));
        eval("0.0866309480365", Financials.irr(-70000, 12000, 15000, 18000, 21000, 26000));
        eval("-0.4435069413347", Financials.irr(-70000, 12000, 15000, -0.1));

//        eval("-0.021", Financials.irr(-75000,12000,15000,18000,21000));
//        eval("0.087", Financials.irr(-75000,12000,15000,18000,21000,26000));
//        eval("-0.444", Financials.irr(-75000,12000,15000,18000,21000,26000, -0.1));

        eval("0.05715142887178467", Financials.irr(-75000, 12000, 15000, 18000, 21000, 24000));
        eval("0.05715142887178467", Financials.irr(-75000, 12000, 15000, 18000, 21000, 24000));
        eval("0.05715142887178467", Financials.irr(-75000, 12000, 15000, 18000, 21000, 24000, 0.1));
        eval("0.05715142887178447", Financials.irr(-75000, 12000, 15000, 18000, 21000, 24000, 0.075));
        eval("0.05715142887178453", Financials.irr(-75000, 12000, 15000, 18000, 21000, 24000, 0.05));
    }

    @Test
    public void testLogicalCompatibility() throws Throwable {
        eval("1", Integer.parseInt(Logicals.logicalIf(true, 1, 2).toString()));
        eval("2", Integer.parseInt(Logicals.logicalIf(false, 1, 2).toString()));

        evalExpression("1", Logicals.logicalIf(Logical.TRUE, "1", "2"));
        evalExpression("2", Logicals.logicalIf(Logical.FALSE, "1", "2"));

        // @see https://support.office.com/en-us/article/and-function-5f19b2e8-e1df-4408-897a-ce285a19e9d9
        evalLogical(true, Logicals.logicalAnd(50 > 1, 50 < 100));
        evalExpression("50", Logicals.logicalIf(Logicals.logicalAnd(50 < 100, 50 < 100), 50, "The value is out of range"));
        evalExpression("The value is out of range", Logicals.logicalIf(Logicals.logicalAnd(100 > 1, 100 < 100), 100, "The value is out of range"));

        evalLogical(true, Logicals.logicalAnd(true, true));
        evalLogical(false, Logicals.logicalAnd(true, false));
        evalLogical(false, Logicals.logicalFalse());
        evalLogical(false, Logicals.logicalNot(Logical.TRUE));
        evalLogical(true, Logicals.logicalNot(Logical.FALSE));
        evalLogical(true, Logicals.logicalOr(true));
        evalLogical(false, Logicals.logicalOr(false));
        evalLogical(true, Logicals.logicalOr(true, false));
        evalLogical(true, Logicals.logicalTrue());
        evalLogical(false, Logicals.logicalXor(false, false));
        evalLogical(true, Logicals.logicalXor(false, true));
        evalLogical(true, Logicals.logicalXor(true, false));
        evalLogical(false, Logicals.logicalXor(true, true));
        evalExpression("Default Expression", Logicals.logicalSwitch(7, "Default Expression"));
        evalExpression("Seven", Logicals.logicalSwitch(7, 9, "Nine", 7, "Seven"));
        evalExpression("Eight", Logicals.logicalSwitch(8, 9, "Nine", 7, "Seven", "Eight"));
    }

    @Test
    public void testChooseCompatibility() throws Throwable {
        evalExpression("jima", Formulas.choose(1 - 1, "jima"));
        evalExpression("jimc", Formulas.choose(3 - 1, "jima", "jimb", "jimc"));
    }

    protected void eval(String expect, Number parse) throws Throwable {

        DecimalFormat df = new DecimalFormat("#,###.00000");

        Assert.assertEquals(df.format(new BigDecimal(expect)), df.format(((Number) parse)));
    }

    protected void evalExpression(String expect, CharSequence parse) throws Throwable {

        Assert.assertEquals(expect.toString(), parse.toString());
    }

    protected void evalImaginaryExpression(String expect, CharSequence parse) throws Throwable {
        final FormulaDecimal actualReal = Formulas.imreal(parse.toString());
        final FormulaDecimal actualImaginary = Formulas.imaginary(parse.toString());

        final FormulaDecimal expectedReal = Formulas.imreal(expect.toString());
        final FormulaDecimal expectedImaginary = Formulas.imaginary(expect.toString());

        DecimalFormat df = new DecimalFormat("#,###.00000");

        Assert.assertEquals(df.format(expectedReal.asBigDecimal()), df.format(((Number) actualReal)));
        Assert.assertEquals(df.format(expectedImaginary.asBigDecimal()), df.format(((Number) actualImaginary)));
    }

    protected void evalDateExpression(Moment expect, Moment parse) throws Throwable {

        final Moment evaluate = parse;
        Assert.assertEquals("year not equal", expect.year(), evaluate.year());
        Assert.assertEquals("month not equal", expect.month(), evaluate.month());
        Assert.assertEquals("day not equal", expect.day(), evaluate.day());
        Assert.assertEquals("time not equal", expect.getTime(), evaluate.getTime());
    }


    protected void evalLogical(boolean expect, Logical parse) throws Throwable {

        Assert.assertEquals(expect, parse.booleanValue());
    }

    protected void evalDateExpressionNear(Moment expect, Moment parse) throws Throwable {

        final Moment evaluate = parse;
        Assert.assertEquals("year not equal", expect.year(), evaluate.year());
        Assert.assertEquals("month not equal", expect.month(), evaluate.month());
        Assert.assertEquals("day not equal", expect.day(), evaluate.day());
        Assert.assertThat("time not equal", evaluate.getTime(), Matchers.anyOf(Matchers.greaterThanOrEqualTo(expect.getTime() - 1000), Matchers.lessThanOrEqualTo(expect.getTime() + 1000)));
    }
}