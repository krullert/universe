package io.onsense.universe;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.junit.Assert.*;

/**
 * @author Koen Rooijmans
 */
public class MatrixTest {

    @Before
    public void setUp() throws Exception {
        System.setProperty("user.timezone", "UTC");
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test00() throws Throwable {
        Number[] numberArray0 = new Number[2];
        BigDecimal bigDecimal0 = BigDecimal.TEN;
        numberArray0[0] = (Number) bigDecimal0;
        BigInteger[][] bigIntegerArray0 = Matrix.partitionDimensionsBigInteger(numberArray0);
        Matrix.minor(bigIntegerArray0, 1, (-1889));
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test01() throws Throwable {
        BigInteger[][] bigIntegerArray0 = new BigInteger[2][8];
        BigInteger[] bigIntegerArray1 = new BigInteger[0];
        bigIntegerArray0[0] = bigIntegerArray1;
        Matrix.det(bigIntegerArray0);
    }

    @Test(timeout = 4000)
    public void test02() throws Throwable {
        Number[] numberArray0 = new Number[0];

        Matrix.partitionDimensionsBigDecimal(numberArray0);
    }

    @Test(timeout = 4000)
    public void test03() throws Throwable {
        Number[] numberArray0 = new Number[9];
        Float float0 = new Float((-4537.162F));
        numberArray0[0] = (Number) float0;
        byte[] byteArray0 = new byte[2];
        BigInteger bigInteger0 = new BigInteger(byteArray0);
        numberArray0[1] = (Number) bigInteger0;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(bigInteger0);
        numberArray0[2] = (Number) formulaDecimal0;

        Matrix.partitionDimensionsBigDecimal(numberArray0);

    }

    @Test(timeout = 4000)
    public void test04() throws Throwable {
        BigInteger[][] bigIntegerArray0 = new BigInteger[1][5];
        BigInteger[][] bigIntegerArray1 = Matrix.minor(bigIntegerArray0, (byte) 0, 2);
        assertNotSame(bigIntegerArray0, bigIntegerArray1);
    }

    @Test(timeout = 4000)
    public void test05() throws Throwable {
        Number[] numberArray0 = new Number[2];
        int int0 = Matrix.getDimensions(numberArray0);
        assertEquals(1, int0);
    }

    @Test(timeout = 4000)
    public void test06() throws Throwable {
        Number[] numberArray0 = new Number[4];
        Float float0 = new Float(1.0);
        numberArray0[0] = (Number) float0;
        byte[] byteArray0 = new byte[1];
        byteArray0[0] = (byte) (-72);
        BigInteger bigInteger0 = new BigInteger(byteArray0);
        numberArray0[1] = (Number) bigInteger0;
        numberArray0[2] = (Number) bigInteger0;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(752.0118071);
        numberArray0[3] = (Number) formulaDecimal0;
        BigInteger[][] bigIntegerArray0 = Matrix.partitionDimensionsBigInteger(numberArray0);
        BigInteger bigInteger1 = Matrix.det(bigIntegerArray0);
        assertEquals((short) (-4432), bigInteger1.shortValue());
    }

    @Test(timeout = 4000)
    public void test07() throws Throwable {

        Matrix.sqrt((FormulaDecimal) null);
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test08() throws Throwable {
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-2643.26685791386));

        Matrix.sqrt(formulaDecimal0);
    }

    @Test(timeout = 4000)
    public void test09() throws Throwable {

        Matrix.partitionDimensionsBigInteger((Number[]) null);
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test10() throws Throwable {
        Number[] numberArray0 = new Number[17];

        Matrix.partitionDimensionsBigInteger(numberArray0);
    }

    @Test(timeout = 4000)
    public void test11() throws Throwable {

        Matrix.partitionDimensionsBigDecimal((Number[]) null);
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test12() throws Throwable {

        Matrix.minor((BigInteger[][]) null, 1, 0);
    }

    @Ignore
    @Test(timeout = 4000)
    public void test13() throws Throwable {
        BigInteger[][] bigIntegerArray0 = new BigInteger[4][5];
        BigInteger[] bigIntegerArray1 = new BigInteger[4];
        bigIntegerArray0[1] = bigIntegerArray1;

        Matrix.minor(bigIntegerArray0, 0, 0);
    }

    @Test(timeout = 4000)
    public void test14() throws Throwable {

        Matrix.getDimensions((Number[]) null);

    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test15() throws Throwable {
        Number[] numberArray0 = new Number[6];

        Matrix.getDimensions(numberArray0);
    }

    @Ignore
    @Test(timeout = 4000)
    public void test16() throws Throwable {
        BigInteger[][] bigIntegerArray0 = new BigInteger[5][1];
        BigInteger[] bigIntegerArray1 = new BigInteger[5];
        byte[] byteArray0 = new byte[4];
        byteArray0[3] = (byte) 57;
        BigInteger bigInteger0 = new BigInteger(byteArray0);
        bigIntegerArray1[0] = bigInteger0;
        bigIntegerArray0[0] = bigIntegerArray1;

        Matrix.det(bigIntegerArray0);
    }

    @Test(timeout = 4000)
    public void test17() throws Throwable {
        BigInteger[][] bigIntegerArray0 = new BigInteger[4][5];
        BigInteger[][] bigIntegerArray1 = Matrix.minor(bigIntegerArray0, 0, 0);
        assertEquals(3, bigIntegerArray1.length);
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test18() throws Throwable {
        BigInteger[][] bigIntegerArray0 = new BigInteger[2][4];
        Matrix.minor(bigIntegerArray0, 1, 456);
        fail("Expecting exception: ArithmeticException");
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test19() throws Throwable {
        BigInteger[][] bigIntegerArray0 = new BigInteger[3][1];
        Matrix.minor(bigIntegerArray0, (byte) 1, (-1762));
        fail("Expecting exception: ArithmeticException");
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test20() throws Throwable {
        BigInteger[][] bigIntegerArray0 = new BigInteger[3][1];
        BigInteger[] bigIntegerArray1 = new BigInteger[0];
        bigIntegerArray0[0] = bigIntegerArray1;
        Matrix.minor(bigIntegerArray0, (byte) 0, (byte) (-41));
        fail("Expecting exception: ArithmeticException");


    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test21() throws Throwable {
        Number[] numberArray0 = new Number[2];
        BigDecimal bigDecimal0 = BigDecimal.TEN;
        numberArray0[0] = (Number) bigDecimal0;
        BigInteger[][] bigIntegerArray0 = Matrix.partitionDimensionsBigInteger(numberArray0);
        Matrix.minor(bigIntegerArray0, 77, (-1889));
        fail("Expecting exception: ArithmeticException");
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test22() throws Throwable {
        Number[] numberArray0 = new Number[4];
        Float float0 = new Float(1.0);
        numberArray0[0] = (Number) float0;
        byte[] byteArray0 = new byte[1];
        BigInteger bigInteger0 = new BigInteger(byteArray0);
        numberArray0[1] = (Number) bigInteger0;
        numberArray0[2] = (Number) bigInteger0;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(752.0118071);
        numberArray0[3] = (Number) formulaDecimal0;
        BigInteger[][] bigIntegerArray0 = Matrix.partitionDimensionsBigInteger(numberArray0);
        Matrix.minor(bigIntegerArray0, (byte) (-72), 1274);
        fail("Expecting exception: ArithmeticException");

    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test23() throws Throwable {
        BigInteger[][] bigIntegerArray0 = new BigInteger[0][6];
        Matrix.minor(bigIntegerArray0, 9, 77);
        fail("Expecting exception: ArithmeticException");
    }

    @Test(timeout = 4000)
    public void test24() throws Throwable {
        BigInteger[][] bigIntegerArray0 = new BigInteger[3][5];
        BigInteger[] bigIntegerArray1 = new BigInteger[3];
        BigInteger bigInteger0 = BigInteger.TEN;
        bigIntegerArray1[0] = bigInteger0;
        bigIntegerArray1[1] = bigIntegerArray1[0];
        BigInteger bigInteger1 = BigInteger.ZERO;
        bigIntegerArray1[2] = bigInteger1;
        bigIntegerArray0[0] = bigIntegerArray1;
        BigInteger[] bigIntegerArray2 = new BigInteger[5];
        bigIntegerArray2[0] = bigInteger1;
        bigIntegerArray2[1] = bigIntegerArray2[0];
        bigIntegerArray2[2] = bigIntegerArray1[0];
        bigIntegerArray0[1] = bigIntegerArray2;
        bigIntegerArray0[2] = bigIntegerArray0[0];
        BigInteger bigInteger2 = Matrix.det(bigIntegerArray0);
        assertEquals((short) 0, bigInteger2.shortValue());
    }

    @Test(timeout = 4000)
    public void test25() throws Throwable {
        BigInteger[][] bigIntegerArray0 = new BigInteger[3][5];
        BigInteger[] bigIntegerArray1 = new BigInteger[3];
        BigInteger bigInteger0 = BigInteger.TEN;
        bigIntegerArray1[0] = bigInteger0;
        bigIntegerArray1[1] = bigIntegerArray1[0];
        bigIntegerArray1[2] = bigIntegerArray1[1];
        bigIntegerArray0[0] = bigIntegerArray1;
        bigIntegerArray0[1] = bigIntegerArray1;
        bigIntegerArray0[2] = bigIntegerArray0[1];
        BigInteger bigInteger1 = Matrix.det(bigIntegerArray0);
        assertEquals((short) 0, bigInteger1.shortValue());
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test26() throws Throwable {
        BigInteger[][] bigIntegerArray0 = new BigInteger[3][5];
        BigInteger[] bigIntegerArray1 = new BigInteger[3];
        bigIntegerArray0[0] = bigIntegerArray1;

        Matrix.det(bigIntegerArray0);

    }

    @Test(timeout = 4000)
    public void test27() throws Throwable {
        Number[] numberArray0 = new Number[4];
        Float float0 = new Float(1.0);
        numberArray0[0] = (Number) float0;
        byte[] byteArray0 = new byte[1];
        BigInteger bigInteger0 = new BigInteger(byteArray0);
        numberArray0[1] = (Number) bigInteger0;
        numberArray0[2] = (Number) bigInteger0;
        FormulaDecimal formulaDecimal0 = new FormulaDecimal(752.0118071);
        numberArray0[3] = (Number) formulaDecimal0;
        BigInteger[][] bigIntegerArray0 = Matrix.partitionDimensionsBigInteger(numberArray0);
        BigInteger bigInteger1 = Matrix.det(bigIntegerArray0);
        assertEquals(2, bigIntegerArray0.length);
        assertEquals((short) 752, bigInteger1.shortValue());
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test28() throws Throwable {
        BigInteger[][] bigIntegerArray0 = new BigInteger[2][8];
        Matrix.det(bigIntegerArray0);
    }

    @Test(timeout = 4000, expected = ArithmeticException.class)
    public void test29() throws Throwable {
        BigInteger[][] bigIntegerArray0 = new BigInteger[0][6];
        Matrix.det(bigIntegerArray0);
        fail("Expecting exception: ArithmeticException");
    }

    @Test(timeout = 4000)
    public void test30() throws Throwable {
        Number[] numberArray0 = new Number[16];

        Matrix.partitionDimensionsBigDecimal(numberArray0);
    }

    @Test(timeout = 4000)
    public void test31() throws Throwable {
        Number[] numberArray0 = new Number[4];

        Matrix.partitionDimensionsBigInteger(numberArray0);
    }

    @Test(timeout = 4000)
    public void test32() throws Throwable {
        Number[] numberArray0 = new Number[2];
        FormulaDecimal formulaDecimal0 = new FormulaDecimal((-719));
        numberArray0[0] = (Number) formulaDecimal0;
        BigDecimal[][] bigDecimalArray0 = Matrix.partitionDimensionsBigDecimal(numberArray0);
        assertEquals(1, bigDecimalArray0.length);
    }

    @Test(timeout = 4000)
    public void test33() throws Throwable {
        Number[] numberArray0 = new Number[2];
        BigDecimal bigDecimal0 = BigDecimal.TEN;
        numberArray0[0] = (Number) bigDecimal0;
        BigInteger[][] bigIntegerArray0 = Matrix.partitionDimensionsBigInteger(numberArray0);
        assertEquals(1, bigIntegerArray0.length);

        BigInteger bigInteger0 = Matrix.det(bigIntegerArray0);
        assertNotNull(bigInteger0);
        assertEquals((byte) 10, bigInteger0.byteValue());
    }

    @Test(timeout = 4000)
    public void test34() throws Throwable {
        Matrix matrix0 = new Matrix();
    }
}
