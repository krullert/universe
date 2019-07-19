package io.onsense.universe.format;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author Koen Rooijmans
 */
public class FractionFormat extends Format {

    private static final Pattern DENOM_FORMAT_PATTERN = Pattern.compile("(?:(#+)|(\\d+))");
    private static final int MAX_DENOM_POW = 4;

    private final int exactDenom;
    private final int maxDenom;

    private final String wholePartFormatString;

    public FractionFormat(String wholePartFormatString, String denomFormatString) {
        this.wholePartFormatString = wholePartFormatString;
        Matcher m = DENOM_FORMAT_PATTERN.matcher(denomFormatString);
        int tmpExact = -1;
        int tmpMax = -1;
        if (m.find()) {
            if (m.group(2) != null) {
                try {
                    tmpExact = Integer.parseInt(m.group(2));

                    if (tmpExact == 0) {
                        tmpExact = -1;
                    }
                } catch (NumberFormatException e) {
                    // no-op
                }
            } else if (m.group(1) != null) {
                int len = m.group(1).length();
                len = len > MAX_DENOM_POW ? MAX_DENOM_POW : len;
                tmpMax = (int) Math.pow(10, len);
            } else {
                tmpExact = 100;
            }
        }
        if (tmpExact <= 0 && tmpMax <= 0) {
            tmpExact = 100;
        }
        exactDenom = tmpExact;
        maxDenom = tmpMax;
    }

    public String format(Number num) {

        final double doubleValue = num.doubleValue();

        final boolean isNeg = doubleValue < 0.0f;
        final double absDoubleValue = Math.abs(doubleValue);

        final double wholePart = Math.floor(absDoubleValue);
        final double decPart = absDoubleValue - wholePart;
        if (wholePart + decPart == 0) {
            return "0";
        }

        if (Double.compare(decPart, 0) == 0) {

            StringBuilder sb = new StringBuilder();
            if (isNeg) {
                sb.append("-");
            }
            sb.append((int) wholePart);
            return sb.toString();
        }

        SimpleFraction fract = null;
        try {
            if (exactDenom > 0) {
                fract = SimpleFraction.buildFractionExactDenominator(decPart, exactDenom);
            } else {
                fract = SimpleFraction.buildFractionMaxDenominator(decPart, maxDenom);
            }
        } catch (RuntimeException e) {
            return Double.toString(doubleValue);
        }

        StringBuilder sb = new StringBuilder();

        if (isNeg) {
            sb.append("-");
        }

        if ("".equals(wholePartFormatString)) {
            int trueNum = (fract.getDenominator() * (int) wholePart) + fract.getNumerator();
            sb.append(trueNum).append("/").append(fract.getDenominator());
            return sb.toString();
        }

        if (fract.getNumerator() == 0) {
            sb.append((int) wholePart);
            return sb.toString();
        } else if (fract.getNumerator() == fract.getDenominator()) {
            sb.append(((int) wholePart + 1));
            return sb.toString();
        }
        if (wholePart > 0) {
            sb.append((int) wholePart).append(" ");
        }
        sb.append(fract.getNumerator()).append("/").append(fract.getDenominator());
        return sb.toString();
    }

    @Override
    public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
        return toAppendTo.append(format((Number) obj));
    }

    @Override
    public Object parseObject(String source, ParsePosition pos) {
        throw new UnsupportedOperationException("Reverse parsing not supported");
    }
}