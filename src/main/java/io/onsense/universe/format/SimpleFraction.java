package io.onsense.universe.format;

/**
 * @author Koen Rooijmans
 */
public class SimpleFraction {

    private final int denominator;
    private final int numerator;

    public SimpleFraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static SimpleFraction buildFractionExactDenominator(double val, int exactDenom) {
        int num = (int) Math.round(val * exactDenom);
        return new SimpleFraction(num, exactDenom);
    }

    public static SimpleFraction buildFractionMaxDenominator(double value, int maxDenominator) {
        return buildFractionMaxDenominator(value, 0, maxDenominator, 100);
    }

    private static SimpleFraction buildFractionMaxDenominator(double value, double epsilon, int maxDenominator, int maxIterations) {
        long overflow = Integer.MAX_VALUE;
        double r0 = value;
        long a0 = (long) Math.floor(r0);
        if (a0 > overflow) {
            throw new IllegalArgumentException("Overflow trying to convert " + value + " to fraction (" + a0 + "/" + 1l + ")");
        }

        if (Math.abs(a0 - value) < epsilon) {
            return new SimpleFraction((int) a0, 1);
        }

        long p0 = 1;
        long q0 = 0;
        long p1 = a0;
        long q1 = 1;

        long p2;
        long q2;

        int n = 0;
        boolean stop = false;
        do {
            ++n;
            double r1 = 1.0 / (r0 - a0);
            long a1 = (long) Math.floor(r1);
            p2 = (a1 * p1) + p0;
            q2 = (a1 * q1) + q0;
            if (epsilon == 0.0f && maxDenominator > 0 && Math.abs(q2) > maxDenominator &&
                    Math.abs(q1) < maxDenominator) {

                return new SimpleFraction((int) p1, (int) q1);
            }
            if ((p2 > overflow) || (q2 > overflow)) {
                throw new RuntimeException("Overflow trying to convert " + value + " to fraction (" + p2 + "/" + q2 + ")");
            }

            double convergent = (double) p2 / (double) q2;
            if (n < maxIterations && Math.abs(convergent - value) > epsilon && q2 < maxDenominator) {
                p0 = p1;
                p1 = p2;
                q0 = q1;
                q1 = q2;
                a0 = a1;
                r0 = r1;
            } else {
                stop = true;
            }
        } while (!stop);

        if (n >= maxIterations) {
            throw new RuntimeException("Unable to convert " + value + " to fraction after " + maxIterations + " iterations");
        }

        if (q2 < maxDenominator) {
            return new SimpleFraction((int) p2, (int) q2);
        } else {
            return new SimpleFraction((int) p1, (int) q1);
        }

    }

    public int getDenominator() {
        return denominator;
    }

    public int getNumerator() {
        return numerator;
    }
}
