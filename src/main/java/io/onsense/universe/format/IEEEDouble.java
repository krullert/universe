package io.onsense.universe.format;

/**
 * @author Koen Rooijmans
 */
public class IEEEDouble {

    public static final long FRAC_MASK = 0x000FFFFFFFFFFFFFL;
    private static final int EXPONENT_SHIFT = 52;
    public static final long FRAC_ASSUMED_HIGH_BIT = (1L << EXPONENT_SHIFT);
}
