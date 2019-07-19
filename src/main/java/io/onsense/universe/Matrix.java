package io.onsense.universe;

import ch.obermuhlner.math.big.BigDecimalMath;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/**
 * @author Koen Rooijmans
 */
public class Matrix {

    protected static BigInteger[][] partitionDimensionsBigInteger(Number[] decimal) {
        if (decimal == null || decimal.length == 0) {
            return new BigInteger[0][0];
        }
        final int dimensions = getDimensions(decimal);

        BigInteger[][] matrix = new BigInteger[dimensions][dimensions];
        int k = 0;
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                matrix[j][i] = Formulas.valueOf(decimal[k]).toBigInteger();
                k++;
            }
        }
        return matrix;
    }

    protected static BigDecimal[][] partitionDimensionsBigDecimal(Number[] decimal) {
        if (decimal == null || decimal.length == 0) {
            return new BigDecimal[0][0];
        }
        final int dimensions = getDimensions(decimal);

        BigDecimal[][] matrix = new BigDecimal[dimensions][dimensions];
        int k = 0;
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                matrix[j][i] = Formulas.valueOf(decimal[k]).asBigDecimal();
                k++;
            }
        }
        return matrix;
    }

    protected static int getDimensions(Number[] decimal) {
        if (decimal == null || decimal.length == 0) {
            return 0;
        }
        int dimensions;
        if (decimal.length == 2) {
            dimensions = 1; // 1 row, 1 column
        } else if (decimal.length == 4) {
            dimensions = 2; // 2 rows, 2 columns
        } else if (decimal.length == 9) {
            dimensions = 3; // 3 rows, 3 columns
        } else if (decimal.length == 16) {
            dimensions = 4; // 4 rows, 4 columns
        } else {
            dimensions = sqrt(Formulas.valueOf(decimal.length)).intValueExact();
        }
        return dimensions;
    }

    protected static FormulaDecimal sqrt(FormulaDecimal decimal) {
        return new FormulaDecimal(BigDecimalMath.sqrt(Formulas.valueOf(decimal).delegate, MathContext.DECIMAL128));
    }

    public static BigInteger det(final BigInteger[][] A) throws ArithmeticException {
        BigInteger d = BigInteger.ZERO;
        final int rL = A == null ? 0 : A.length;
        if (rL == 0) {
            throw new ArithmeticException("zero row count in matrix");
        }
        final int cL = A[0].length;
        if (cL != rL) {
            throw new ArithmeticException("Non-square matrix dim " + rL + " by " + cL);
        }

        if (rL == 1) {
            return A[0][0];
        } else if (rL == 2) {
            d = A[0][0].multiply(A[1][1]);
            return d.subtract(A[0][1].multiply(A[1][0]));
        } else {
            for (int r = 0; r < rL; r++) {
                final BigInteger Ar0 = A[r][0];
                if (Ar0 == null) {
                    throw new ArithmeticException("matrix contains null value");
                }
                if (Ar0.compareTo(BigInteger.ZERO) != 0) {
                    final BigInteger M[][] = minor(A, r, 0);
                    final BigInteger m = Ar0.multiply(det(M));
                    d = r % 2 == 0 ? d.add(m) : d.subtract(m);
                }
            }
        }
        return d;
    }

    public static BigInteger[][] minor(final BigInteger[][] A, final int r, final int c) throws ArithmeticException {
        final int rL = A == null ? 0 : A.length;
        if (rL == 0) {
            throw new ArithmeticException("zero row count in matrix");
        }
        if (r < 0 || r >= rL) {
            throw new ArithmeticException("row number " + r + " out of range 0.." + (rL - 1));
        }
        final int cL = A[0].length;
        if (cL == 0) {
            throw new ArithmeticException("zero column count in matrix");
        }
        if (c < 0 || c >= cL) {
            throw new ArithmeticException("column number " + c + " out of range 0.." + (cL - 1));
        }
        BigInteger M[][] = new BigInteger[rL - 1][cL - 1];
        int imrow = 0;
        for (int row = 0; row < rL; row++) {
            if (row != r) {
                int imcol = 0;
                for (int col = 0; col < cL; col++) {
                    if (col != c) {
                        M[imrow][imcol] = A[row][col];
                        imcol++;
                    }
                }
                imrow++;
            }
        }
        return M;
    }
}
