package io.onsense.universe.format;

import java.math.RoundingMode;
import java.text.*;
import java.util.Date;
import java.util.Locale;

/**
 * @author Koen Rooijmans
 */
public class ExcelStyleDateFormatter extends SimpleDateFormat {

    public static final char MMMMM_START_SYMBOL = '\ue001';
    public static final char MMMMM_TRUNCATE_SYMBOL = '\ue002';
    public static final char H_BRACKET_SYMBOL = '\ue010';
    public static final char HH_BRACKET_SYMBOL = '\ue011';
    public static final char M_BRACKET_SYMBOL = '\ue012';
    public static final char MM_BRACKET_SYMBOL = '\ue013';
    public static final char S_BRACKET_SYMBOL = '\ue014';
    public static final char SS_BRACKET_SYMBOL = '\ue015';
    public static final char L_BRACKET_SYMBOL = '\ue016';
    public static final char LL_BRACKET_SYMBOL = '\ue017';

    private static final DecimalFormat format1digit;
    private static final DecimalFormat format2digits;

    private static final DecimalFormat format3digit;
    private static final DecimalFormat format4digits;

    static {
        DecimalFormatSymbols dfs = DecimalFormatSymbols.getInstance(Locale.ROOT);
        format1digit = new DecimalFormat("0", dfs);
        format2digits = new DecimalFormat("00", dfs);
        format3digit = new DecimalFormat("0", dfs);
        format4digits = new DecimalFormat("00", dfs);
        DataFormatter.setExcelStyleRoundingMode(format1digit, RoundingMode.DOWN);
        DataFormatter.setExcelStyleRoundingMode(format2digits, RoundingMode.DOWN);
        DataFormatter.setExcelStyleRoundingMode(format3digit);
        DataFormatter.setExcelStyleRoundingMode(format4digits);
    }

    private double dateToBeFormatted;

    {
        setTimeZone(LocaleUtil.getUserTimeZone());
    }

    public ExcelStyleDateFormatter(String pattern,
                                   DateFormatSymbols formatSymbols) {
        super(processFormatPattern(pattern), formatSymbols);
    }

    private static String processFormatPattern(String f) {
        String t = f.replaceAll("MMMMM", MMMMM_START_SYMBOL + "MMM" + MMMMM_TRUNCATE_SYMBOL);
        t = t.replaceAll("\\[H]", String.valueOf(H_BRACKET_SYMBOL));
        t = t.replaceAll("\\[HH]", String.valueOf(HH_BRACKET_SYMBOL));
        t = t.replaceAll("\\[m]", String.valueOf(M_BRACKET_SYMBOL));
        t = t.replaceAll("\\[mm]", String.valueOf(MM_BRACKET_SYMBOL));
        t = t.replaceAll("\\[s]", String.valueOf(S_BRACKET_SYMBOL));
        t = t.replaceAll("\\[ss]", String.valueOf(SS_BRACKET_SYMBOL));
        t = t.replaceAll("s.000", "s.SSS");
        t = t.replaceAll("s.00", "s." + LL_BRACKET_SYMBOL);
        t = t.replaceAll("s.0", "s." + L_BRACKET_SYMBOL);
        return t;
    }

    public void setDateToBeFormatted(double date) {
        this.dateToBeFormatted = date;
    }

    @Override
    public StringBuffer format(Date date,
                               StringBuffer paramStringBuffer,
                               FieldPosition paramFieldPosition) {
        String s = super.format(date, paramStringBuffer, paramFieldPosition).toString();

        if (s.indexOf(MMMMM_START_SYMBOL) != -1) {
            s = s.replaceAll(
                    MMMMM_START_SYMBOL + "(\\p{L}|\\p{P})[\\p{L}\\p{P}]+" + MMMMM_TRUNCATE_SYMBOL,
                    "$1"
            );
        }

        if (s.indexOf(H_BRACKET_SYMBOL) != -1 ||
                s.indexOf(HH_BRACKET_SYMBOL) != -1) {
            float hours = (float) dateToBeFormatted * 24;

            s = s.replaceAll(
                    String.valueOf(H_BRACKET_SYMBOL),
                    format1digit.format(hours)
            );
            s = s.replaceAll(
                    String.valueOf(HH_BRACKET_SYMBOL),
                    format2digits.format(hours)
            );
        }

        if (s.indexOf(M_BRACKET_SYMBOL) != -1 ||
                s.indexOf(MM_BRACKET_SYMBOL) != -1) {
            float minutes = (float) dateToBeFormatted * 24 * 60;
            s = s.replaceAll(
                    String.valueOf(M_BRACKET_SYMBOL),
                    format1digit.format(minutes)
            );
            s = s.replaceAll(
                    String.valueOf(MM_BRACKET_SYMBOL),
                    format2digits.format(minutes)
            );
        }
        if (s.indexOf(S_BRACKET_SYMBOL) != -1 ||
                s.indexOf(SS_BRACKET_SYMBOL) != -1) {
            float seconds = (float) (dateToBeFormatted * 24.0 * 60.0 * 60.0);
            s = s.replaceAll(
                    String.valueOf(S_BRACKET_SYMBOL),
                    format1digit.format(seconds)
            );
            s = s.replaceAll(
                    String.valueOf(SS_BRACKET_SYMBOL),
                    format2digits.format(seconds)
            );
        }

        if (s.indexOf(L_BRACKET_SYMBOL) != -1 ||
                s.indexOf(LL_BRACKET_SYMBOL) != -1) {
            float millisTemp = (float) ((dateToBeFormatted - Math.floor(dateToBeFormatted)) * 24.0 * 60.0 * 60.0);
            float millis = (millisTemp - (int) millisTemp);
            s = s.replaceAll(
                    String.valueOf(L_BRACKET_SYMBOL),
                    format3digit.format(millis * 10)
            );
            s = s.replaceAll(
                    String.valueOf(LL_BRACKET_SYMBOL),
                    format4digits.format(millis * 100)
            );
        }

        return new StringBuffer(s);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ExcelStyleDateFormatter)) {
            return false;
        }

        ExcelStyleDateFormatter other = (ExcelStyleDateFormatter) o;
        return dateToBeFormatted == other.dateToBeFormatted;
    }

    @Override
    public int hashCode() {
        return Double.valueOf(dateToBeFormatted).hashCode();
    }
}