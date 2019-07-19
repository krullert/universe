package io.onsense.universe.format;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.*;
import java.util.Locale;

/**
 * @author Koen Rooijmans
 */
public class ExcelGeneralNumberFormat extends Format {

    private static final long serialVersionUID = 1L;

    private static final MathContext TO_10_SF = new MathContext(10, RoundingMode.HALF_UP);

    private final DecimalFormatSymbols decimalSymbols;
    private final DecimalFormat integerFormat;
    private final DecimalFormat decimalFormat;
    private final DecimalFormat scientificFormat;

    public ExcelGeneralNumberFormat(final Locale locale) {
        decimalSymbols = DecimalFormatSymbols.getInstance(locale);
        scientificFormat = new DecimalFormat("0.#####E0", decimalSymbols);
        DataFormatter.setExcelStyleRoundingMode(scientificFormat);
        integerFormat = new DecimalFormat("#", decimalSymbols);
        DataFormatter.setExcelStyleRoundingMode(integerFormat);
        decimalFormat = new DecimalFormat("#.##########", decimalSymbols);
        DataFormatter.setExcelStyleRoundingMode(decimalFormat);
    }

    public StringBuffer format(Object number, StringBuffer toAppendTo, FieldPosition pos) {
        final double value;
        if (number instanceof Number) {
            value = ((Number) number).doubleValue();
            if (Double.isInfinite(value) || Double.isNaN(value)) {
                return integerFormat.format(number, toAppendTo, pos);
            }
        } else {
            return integerFormat.format(number, toAppendTo, pos);
        }

        final double abs = Math.abs(value);
        if (abs >= 1E11 || (abs <= 1E-10 && abs > 0)) {
            return scientificFormat.format(number, toAppendTo, pos);
        } else if (Math.floor(value) == value || abs >= 1E10) {
            return integerFormat.format(number, toAppendTo, pos);
        }
        final double rounded = new BigDecimal(value).round(TO_10_SF).doubleValue();
        return decimalFormat.format(rounded, toAppendTo, pos);
    }

    public Object parseObject(String source, ParsePosition pos) {
        throw new UnsupportedOperationException();
    }

}