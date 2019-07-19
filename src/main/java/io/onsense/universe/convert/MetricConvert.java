package io.onsense.universe.convert;

import io.onsense.universe.FormulaDecimal;
import io.onsense.universe.Formulas;
import si.uom.NonSI;
import si.uom.SI;
import systems.uom.common.CGS;
import systems.uom.common.Imperial;
import systems.uom.common.USCustomary;
import systems.uom.ucum.UCUM;
import systems.uom.unicode.CLDR;
import tec.units.indriya.AbstractUnit;
import tec.units.indriya.unit.MetricPrefix;
import tec.units.indriya.unit.Units;

import javax.annotation.Nullable;
import javax.measure.Quantity;
import javax.measure.Unit;
import java.util.NoSuchElementException;
import java.util.Objects;

import static tec.units.indriya.unit.Units.MOLE;

/**
 * @author Koen Rooijmans
 */
public class MetricConvert {

    private static final double AVOGADRO_CONSTANT = 6.02214199e23; // (1/mol).
    /**
     * Holds the standard gravity constant: 9.80665 m/sÂ² exact.
     */
    private static final int STANDARD_GRAVITY_DIVIDEND = 980665;
    private static final int STANDARD_GRAVITY_DIVISOR = 100000;

    public static <Q extends Quantity<Q>> FormulaDecimal convert(Number value, CharSequence fromUnit, CharSequence toUnit) {
        if (fromUnit == null) {
            throw new NoSuchElementException();
        }

        if (toUnit == null) {
            throw new NoSuchElementException();
        }

        // @see https://github.com/apache/openoffice/blob/c014b5f2b55cff8d4b0c952d5c16d62ecde09ca1/main/scaddins/source/analysis/analysishelper.cxx#L2743
        // @see https://github.com/apache/openoffice/blob/c014b5f2b55cff8d4b0c952d5c16d62ecde09ca1/main/scaddins/source/analysis/analysishelper.cxx#L2563

        final Unit<Q> fUnit = (Unit<Q>) MetricConvert.getMetricUnit(fromUnit);
        final Unit<Q> tUnit = (Unit<Q>) MetricConvert.getMetricUnit(toUnit);

        if (fUnit == null) {
            throw new NoSuchElementException(String.valueOf(fromUnit));
        }

        if (tUnit == null) {
            throw new NoSuchElementException(String.valueOf(toUnit));
        }

        if (Objects.equals(toUnit, fromUnit)) {
            return Formulas.valueOf(value);
        }

        return Formulas.valueOf((fUnit.getConverterTo(tUnit)).convert(Formulas.valueOf(value).asBigDecimal()));
    }

    @Nullable
    public static Unit<?> getMetricUnit(CharSequence unit) {
        if (unit == null) {
            throw new NoSuchElementException();
        }

        Unit<?> metricUnit = null;

        try {
            metricUnit = getUnit(unit);
        } catch (NoSuchElementException e) {
            // deduce prefix
            MetricPrefix prefix = null;
            int i = 0;
            while (prefix == null && i < unit.length()) {
                i++;
                try {
                    prefix = getMetricPrefix(unit.subSequence(0, i));
                } catch (NoSuchElementException e2) {
                    // no-op
                }
            }
            if (prefix != null) {
                metricUnit = ((AbstractUnit<?>) getUnit(unit.subSequence(i, unit.length()))).transform(prefix.getConverter());
            }
        }
        return metricUnit;
    }

    protected static FormulaDecimal getPrefixValue(CharSequence prefix) {
        if (prefix == null) {
            throw new NoSuchElementException();
        }

        switch (prefix.toString()) {
            // Prefix
            case "Y":
                return Formulas.valueOf(1E+24);
            case "Z":
                return Formulas.valueOf(1E+21);
            case "E":
                return Formulas.valueOf(1E+18);
            case "P":
                return Formulas.valueOf(1E+15);
            case "T":
                return Formulas.valueOf(1E+12);
            case "G":
                return Formulas.valueOf(1E+09);
            case "M":
                return Formulas.valueOf(1E+06);
            case "k":
                return Formulas.valueOf(1E+03);
            case "h":
                return Formulas.valueOf(1E+02);
            case "da":
                return Formulas.valueOf(1E+01);
            case "e":
                return Formulas.valueOf(1E+01);
            case "d":
                return Formulas.valueOf(1E-01);
            case "c":
                return Formulas.valueOf(1E-02);
            case "m":
                return Formulas.valueOf(1E-03);
            case "u":
                return Formulas.valueOf(1E-06);
            case "µ":
                return Formulas.valueOf(1E-06);
            case "n":
                return Formulas.valueOf(1E-09);
            case "p":
                return Formulas.valueOf(1E-12);
            case "f":
                return Formulas.valueOf(1E-15);
            case "a":
                return Formulas.valueOf(1E-18);
            case "z":
                return Formulas.valueOf(1E-21);
            case "y":
                return Formulas.valueOf(1E-24);
            // Binary prefix
            case "Yi":
                return Formulas.valueOf(2).pow(80);
            case "Zi":
                return Formulas.valueOf(2).pow(70);
            case "Ei":
                return Formulas.valueOf(2).pow(60);
            case "Pi":
                return Formulas.valueOf(2).pow(50);
            case "Ti":
                return Formulas.valueOf(2).pow(40);
            case "Gi":
                return Formulas.valueOf(2).pow(30);
            case "Mi":
                return Formulas.valueOf(2).pow(20);
            case "ki":
                return Formulas.valueOf(2).pow(10);
            default:
                throw new NoSuchElementException(String.valueOf(prefix));
        }
    }

    protected static MetricPrefix getMetricPrefix(CharSequence prefix) {
        if (prefix == null) {
            throw new NoSuchElementException();
        }

        switch (prefix.toString()) {
            // Metric prefix
            case "Y":
                return MetricPrefix.YOTTA;
            case "Z":
                return MetricPrefix.ZETTA;
            case "E":
                return MetricPrefix.EXA;
            case "P":
                return MetricPrefix.PETA;
            case "T":
                return MetricPrefix.TERA;
            case "G":
                return MetricPrefix.GIGA;
            case "M":
                return MetricPrefix.MEGA;
            case "k":
                return MetricPrefix.KILO;
            case "h":
                return MetricPrefix.HECTO;
            case "da":
                return MetricPrefix.DEKA;
            case "e":
                return MetricPrefix.DEKA;
            case "d":
                return MetricPrefix.DECI;
            case "c":
                return MetricPrefix.CENTI;
            case "m":
                return MetricPrefix.MILLI;
            case "µ":
                return MetricPrefix.MICRO;
            case "u":
                return MetricPrefix.MICRO;
            case "n":
                return MetricPrefix.NANO;
            case "p":
                return MetricPrefix.PICO;
            case "f":
                return MetricPrefix.FEMTO;
            case "a":
                return MetricPrefix.ATTO;
            case "z":
                return MetricPrefix.ZEPTO;
            case "y":
                return MetricPrefix.YOCTO;
            // Binary prefix
            case "Ki":
//                return BinaryPrefix.KIBI;
                throw new UnsupportedOperationException();
            case "Mi":
//                return BinaryPrefix.MEBI;
                throw new UnsupportedOperationException();
            case "Gi":
//                return BinaryPrefix.GIBI;
                throw new UnsupportedOperationException();
            case "Ti":
//                return BinaryPrefix.TEBI;
                throw new UnsupportedOperationException();
            case "Pi":
//                return BinaryPrefix.PEBI;
                throw new UnsupportedOperationException();
            case "Ei":
//                return BinaryPrefix.EXBI;
                throw new UnsupportedOperationException();
            case "Zi":
//                return BinaryPrefix.ZEBI;
                throw new UnsupportedOperationException();
            case "Yi":
//                return BinaryPrefix.YOBI;
                throw new UnsupportedOperationException();
            default:
                throw new NoSuchElementException(String.valueOf(prefix));
        }
    }

    protected static Unit<?> getUnit(CharSequence unit) {
        if (unit == null) {
            throw new NoSuchElementException();
        }

        // @see https://en.wikipedia.org/wiki/SI_derived_unit
        switch (unit.toString()) {
            // Weight and mass
            case "g":
                // Gram
                return Units.GRAM;
            case "sg":
                // Slug
                return Units.KILOGRAM.multiply(1459390294).divide(100000000);
            case "lbm":
                // Pound mass (avoirdupois)
                return USCustomary.POUND;
            case "u":
                // U (atomic mass unit)
                return UCUM.ATOMIC_MASS_UNIT;
            case "ozm":
                // Ounce mass (avoirdupois)
                return USCustomary.OUNCE;
            case "grain":
                // Grain
                return UCUM.GRAIN;
            case "cwt":
                // U.S. (short) hundredweight
                return UCUM.SHORT_HUNDREDWEIGHT;
            case "shweight":
                // U.S. (short) hundredweight
                return UCUM.SHORT_HUNDREDWEIGHT;
            case "uk_cwt":
                // Imperial hundredweight
                return UCUM.LONG_HUNDREDWEIGHT;
            case "lcwt":
                // Imperial hundredweight
                return UCUM.LONG_HUNDREDWEIGHT;
            case "hweight":
                // Imperial hundredweight
                return UCUM.LONG_HUNDREDWEIGHT;
            case "stone":
                // Stone
                return Imperial.STONE;
            case "ton":
                // Ton
                return USCustomary.TON;
            case "uk_ton":
                // Imperial ton
                return Imperial.TON_UK;
            case "LTON":
                // Imperial ton
                return Imperial.TON_UK;
            case "brton":
                // Imperial ton
                return Imperial.TON_UK;
            // Distance
            case "m":
                // Meter
                return Units.METRE;
            case "mi":
                // Statute mile
                return USCustomary.MILE;
            case "Nmi":
                // Nautical mile
                return USCustomary.NAUTICAL_MILE;
            case "in":
                // Inch
                return USCustomary.INCH;
            case "ft":
                // Foot
                return USCustomary.FOOT;
            case "yd":
                // Yard
                return USCustomary.YARD;
            case "ang":
                // Angstrom
                return UCUM.ANGSTROM;
            case "ell":
                // Ell
                return USCustomary.INCH.multiply(45); // verified with excel
            case "ly":
                // Light-year
                return USCustomary.LIGHT_YEAR;
            case "parsec":
                // Parsec
                return UCUM.PARSEC;
            case "pc":
                // Parsec
                return UCUM.PARSEC;
            case "Picapt":
                // Pica (1/72 inch)
                return USCustomary.INCH.divide(72);
            case "Pica":
                // Pica (1/72 inch)
                return USCustomary.INCH.divide(72);
            case "pica":
                // Pica (1/6 inch)
                return USCustomary.INCH.divide(6);
            case "survey_mi":
                // U.S survey mile (statute mile)
                return UCUM.MILE_US_SURVEY;
            // Time
            case "yr":
                // Year
                return Units.YEAR;
            case "day":
                // Day
                return Units.DAY;
            case "d":
                // Day
                return Units.DAY;
            case "hr":
                // Hour
                return Units.HOUR;
            case "mn":
                // Minute
                return Units.MINUTE;
            case "min":
                // Minute
                return Units.MINUTE;
            case "sec":
                // Second
                return Units.SECOND;
            case "s":
                // Second
                return Units.SECOND;
            case "week":
                // Second
                return Units.WEEK;
            // Pressure
            case "Pa":
                // Pascal
                return Units.PASCAL;
            case "p":
                // Pascal
                return Units.PASCAL;
            case "atm":
                // Atmosphere
                return UCUM.ATMOSPHERE;
            case "at":
                // Atmosphere
                return UCUM.ATMOSPHERE;
            case "mmHg":
                // mm of Mercury
                return NonSI.MILLIMETRE_OF_MERCURY;
            case "inHg":
                // inch of Mercury
                return SI.PASCAL.multiply(3386.388);
            case "psi":
                // PSI
                return UCUM.POUND_PER_SQUARE_INCH;
            case "lbf/in^2":
                // PSI
                return UCUM.POUND_PER_SQUARE_INCH;
            case "lbf/in2":
                // PSI
                return UCUM.POUND_PER_SQUARE_INCH;
            case "Torr":
                // Torr
                return UCUM.ATMOSPHERE.divide(760);
            case "bar":
                // Bar (100 kPa)
                return NonSI.BAR;
            // Force
            case "N":
                // Newton
                return Units.NEWTON;
            case "dyn":
                // Dyne
                return CGS.DYNE;
            case "dy":
                // Dyne
                return CGS.DYNE;
            case "lbf":
                // Pound force
                return Imperial.POUND_FORCE;
            case "gf":
                // Gram force
                return UCUM.GRAM_FORCE;
            case "pond":
                // Pond (derived from kgf: A unit of force equal to 9.80665 N)
                return Units.NEWTON.multiply(STANDARD_GRAVITY_DIVIDEND).divide(STANDARD_GRAVITY_DIVISOR).divide(1000);
            // Energy
            case "J":
                // Joule
                return Units.JOULE;
            case "e":
                // Erg
                return CGS.ERG;
            case "c":
                // Thermodynamic calorie
                // TODO verify
                return UCUM.CALORIE;
            case "cal":
                // IT calorie
                // TODO verify
                return UCUM.CALORIE_INTERNATIONAL_TABLE;
            case "eV":
                // Electron volt
                return USCustomary.ELECTRON_VOLT;
            case "ev":
                // Electron volt
                return USCustomary.ELECTRON_VOLT;
            case "HPh":
                // Horsepower-hour (~2.685 MJ)
                return Units.JOULE.multiply(2684519538L).divide(1000);
            case "hh":
                // Horsepower-hour (~2.685 MJ)
                return Units.JOULE.multiply(2684519538L).divide(1000);
            case "Wh":
                // Watt-hour
                return Units.JOULE.multiply(3600);
            case "wh":
                // Watt-hour
                return Units.JOULE.multiply(3600);
            case "flb":
                // Foot-pound
                return Units.JOULE.multiply(13558179483314004L).divide(10000000000000000L);
            case "BTU":
                // BTU
                return UCUM.BTU_INTERNATIONAL_TABLE;
            case "btu":
                // BTU
                return UCUM.BTU_INTERNATIONAL_TABLE;
            // Power
            case "HP":
                // Horsepower
                return Units.WATT.multiply(745.69987158227022);
            case "h":
                // Horsepower
                return Units.WATT.multiply(745.69987158227022);
            case "PS":
                // Pferdestärke / metric horse power
                return Units.WATT.multiply(735.49875);
            case "W":
                // Watt
                return Units.WATT;
            case "w":
                // Watt
                return Units.WATT;
            // Magnetism
            case "T":
                // Tesla
                return Units.TESLA;
            case "ga":
                // Gauss
                return UCUM.GAUSS;
            // Temperature
            case "°C":
                // Degree Celsius
                return Units.CELSIUS;
            case "cel":
                // Degree Celsius
                return Units.CELSIUS;
            case "°F":
                // Degree Fahrenheit
                return USCustomary.FAHRENHEIT;
            case "fah":
                // Degree Fahrenheit
                return USCustomary.FAHRENHEIT;
            case "K":
                // Kelvin
                return Units.KELVIN;
            case "kel":
                // Kelvin
                return Units.KELVIN;
            case "Rank":
                // Degrees Rankine
                return USCustomary.RANKINE;
            case "Reau":
                // Degrees Réaumur
                return UCUM.REAUMUR;
            // Volume
            case "tsp":
                // Teaspoon
                return USCustomary.TEASPOON;
            case "tspm":
                // Modern teaspoon
                // TODO verify
                return UCUM.METRIC_TEASPOON_CUP_US;
            case "tbs":
                // Tablespoon
                return USCustomary.TABLESPOON;
            case "Tbsp":
                // Tablespoon
                return USCustomary.TABLESPOON;
            case "oz":
                // Fluid ounce
                // TODO or UCUM.FLUID_OUNCE_BRITISH
                return UCUM.FLUID_OUNCE_US;
            case "cup":
                // Cup
                return UCUM.CUP_US;
            case "pt":
                // U.S. pint
                return USCustomary.PINT;
            case "us_pt":
                // U.S. pint
                return USCustomary.PINT;
            case "uk_pt":
                // U.K. pint
                return Imperial.PINT;
            case "qt":
                // Quart
                return UCUM.QUART_US;
            case "us_qt":
                // Quart
                return UCUM.QUART_US;
            case "uk_qt":
                // Imperial quart (U.K.)
                return Imperial.QUART;
            case "gal":
                // Gallon
                return USCustomary.GALLON_LIQUID;
            case "us_gal":
                // Gallon
                return USCustomary.GALLON_LIQUID;
            case "uk_gal":
                // Imperial gallon (U.K.)
                return Imperial.GALLON_UK;
            case "l":
                // Liter
                return Units.LITRE;
            case "L":
                // Liter
                return Units.LITRE;
            case "lt":
                // Liter
                return Units.LITRE;
            case "ang3":
                // Cubic angstrom
                return UCUM.ANGSTROM.pow(3);
            case "ang^3":
                // Cubic angstrom
                return UCUM.ANGSTROM.pow(3);
            case "bbl":
                // Barrel
                return USCustomary.BARREL;
            case "barrel":
                // U.S. oil barrel
                return USCustomary.BARREL;
            case "us_barrel":
                // U.S. oil barrel
                return USCustomary.BARREL;
            case "bushel":
                // U.S. bushel
                return UCUM.BUSHEL_US;
            case "us_bushel":
                // U.S. bushel
                return UCUM.BUSHEL_US;
            case "uk_bushel":
                // U.S. bushel
                return UCUM.BUSHEL_BRITISH;
            case "ft3":
                // Cubic feet
                return USCustomary.CUBIC_FOOT;
            case "ft^3":
                // Cubic feet
                return USCustomary.CUBIC_FOOT;
            case "in3":
                // Cubic inch
                return USCustomary.CUBIC_INCH;
            case "in^3":
                // Cubic inch
                return USCustomary.CUBIC_INCH;
            case "ly3":
                // Cubic light-year
                return UCUM.LIGHT_YEAR.pow(3);
            case "ly^3":
                // Cubic light-year
                return UCUM.LIGHT_YEAR.pow(3);
            case "m3":
                // Cubic meter
                return Units.CUBIC_METRE;
            case "m^3":
                // Cubic meter
                return Units.CUBIC_METRE;
            case "mi3":
                // Cubic Mile
                return USCustomary.MILE.pow(3);
            case "mi^3":
                // Cubic Mile
                return USCustomary.MILE.pow(3);
            case "yd3":
                // Cubic yard
                return UCUM.CUBIC_YARD_INTERNATIONAL;
            case "yd^3":
                // Cubic yard
                return UCUM.CUBIC_YARD_INTERNATIONAL;
            case "Nmi3":
                // Cubic nautical mile
                return USCustomary.NAUTICAL_MILE.pow(3);
            case "Nmi^3":
                // Cubic nautical mile
                return USCustomary.NAUTICAL_MILE.pow(3);
            case "Picapt3":
                // Cubic Pica
                return USCustomary.INCH.divide(72).pow(3);
            case "Picapt^3":
                // Cubic Pica
                return USCustomary.INCH.divide(72).pow(3);
            case "Pica3":
                // Cubic Pica
                return USCustomary.INCH.divide(72).pow(3);
            case "Pica^3":
                // Cubic Pica
                return USCustomary.INCH.divide(72).pow(3);
            case "GRT":
                // Gross Registered Ton (equal to 100 cubic feet (2.83 m3))
                return USCustomary.CUBIC_FOOT.multiply(100);
            case "regton":
                // Gross Registered Ton
                return USCustomary.CUBIC_FOOT.multiply(100);
            case "MTON":
                // Measurement ton (freight ton)
                return USCustomary.CUBIC_FOOT.multiply(40);
            // Area
            case "acre":
                // U.S. survey/statute acre
                return USCustomary.ACRE;
            case "us_acre":
                // U.S. survey/statute acre
                return USCustomary.ACRE;
            case "uk_acre":
                // International acre
                return Imperial.ACRE;
            case "ang2":
                // Square angstrom
                return UCUM.ANGSTROM.pow(2);
            case "ang^2":
                // Square angstrom
                return UCUM.ANGSTROM.pow(2);
            case "ar":
                // Are
                return UCUM.ARE;
            case "ft2":
                // Square feet
                return UCUM.SQUARE_FOOT_INTERNATIONAL;
            case "ft^2":
                // Square feet
                return UCUM.SQUARE_FOOT_INTERNATIONAL;
            case "ha":
                // Hectare
                return SI.HECTARE;
            case "in2":
                // Square inches
                return UCUM.SQUARE_INCH_INTERNATIONAL;
            case "in^2":
                // Square inches
                return UCUM.SQUARE_INCH_INTERNATIONAL;
            case "ly2":
                // Square light-year
                return UCUM.LIGHT_YEAR.pow(2);
            case "ly^2":
                // Square light-year
                return UCUM.LIGHT_YEAR.pow(2);
            case "m2":
                // Square meters
                return Units.SQUARE_METRE;
            case "m^2":
                // Square meters
                return Units.SQUARE_METRE;
            case "Morgen":
                // Morgen (see https://de.wikipedia.org/wiki/Morgen_(Einheit))
                return SI.SQUARE_METRE.multiply(2500);
            case "mi2":
                // Square miles
                return UCUM.SQUARE_MILE_US_SURVEY;
            case "mi^2":
                // Square miles
                return UCUM.SQUARE_MILE_US_SURVEY;
            case "Nmi2":
                // Square nautical miles
                return USCustomary.NAUTICAL_MILE.pow(2);
            case "Nmi^2":
                // Square nautical miles
                return USCustomary.NAUTICAL_MILE.pow(2);
            case "Picapt2":
                // Square Pica
                return USCustomary.INCH.divide(72).pow(2);
            case "Pica2":
                // Square Pica
                return USCustomary.INCH.divide(72).pow(2);
            case "Pica^2":
                // Square Pica
                return USCustomary.INCH.divide(72).pow(2);
            case "Picapt^2":
                // Square Pica
                return USCustomary.INCH.divide(72).pow(2);
            case "yd2":
                // Square yards
                return UCUM.SQUARE_YARD_INTERNATIONAL;
            case "yd^2":
                // Square yards
                return UCUM.SQUARE_YARD_INTERNATIONAL;
            // Information
            case "bit":
                // Bit
                return UCUM.BIT;
            case "byte":
                // Byte
                return UCUM.BYTE;
            // Speed
            case "admkn":
                // Admiralty knot
                // TODO verify
                return UCUM.KNOT_BRITISH;
            case "kn":
                // Knot
                return USCustomary.KNOT;
            case "m/h":
                // Meters per hour
                return Units.METRE_PER_SECOND.divide(3600);
            case "m/hr":
                // Meters per hour
                return Units.METRE_PER_SECOND.divide(3600);
            case "m/s":
                // Meters per second
                return Units.METRE_PER_SECOND;
            case "m/sec":
                // Meters per second
                return Units.METRE_PER_SECOND;
            case "mph":
                // Miles per hour
                return USCustomary.MILE_PER_HOUR;
            // Other SI Base Units
            case "A":
                // electric current quantities
                return Units.AMPERE;
            case "cd":
                // luminous intensity quantities
                return Units.CANDELA;
            case "mol":
                // amount of substance quantities
                return Units.MOLE;
            case "rad":
                // plane angle quantities
                return Units.RADIAN;
            case "sr":
                // solid angle quantities
                return Units.STERADIAN;
            case "sphere":
                // @see si.uom.NonSI.SPHERE
                return Units.STERADIAN.multiply(4).multiply(StrictMath.PI);
            case "Hz":
                // frequency
                return Units.HERTZ;
            case "C":
                // electric charge, quantity of electricity
                return Units.COULOMB;
            case "V":
                // electric potential difference, electromotive force
                return Units.VOLT;
            case "F":
                // capacitance
                return Units.FARAD;
            case "Ω":
                // electric resistance
                return Units.OHM;
            case "S":
                // electric conductance
                return Units.SIEMENS;
            case "Wb":
                // magnetic flux
                return Units.WEBER;
            case "H":
                // electric inductance
                return Units.HENRY;
            case "lm":
                // luminous flux
                return Units.LUMEN;
            case "lx":
                // illuminance
                return Units.LUX;
            case "Bq":
                // activity of a radionuclide
                return Units.BECQUEREL;
            case "Gy":
                // absorbed dose
                return Units.GRAY;
            case "Sv":
                // dose equivalent
                return Units.SIEVERT;
            case "kat":
                // catalytic activity
                return Units.KATAL;
            case "At":
                // magnetomotive force
                return SI.AMPERE_TURN;
            case "m/s2":
                // Metre per square second
                return SI.METRE_PER_SQUARE_SECOND;
            case "m/s^2":
                // Metre per square second
                return SI.METRE_PER_SQUARE_SECOND;
            case "g-force":
                // Metre per square second
                return CLDR.G_FORCE;
            case "j.s":
                // Joule second
                return SI.JOULE_SECOND;
            case "F/m":
                // electric permittivity
                return SI.FARAD_PER_METRE;
            case "ε":
                // electric permittivity
                return SI.FARAD_PER_METRE;
            case "N/A2":
                // newton per square ampere
                return SI.NEWTON_PER_SQUARE_AMPERE;
            case "1/m":
                // The SI unit for wave number quantities, reciprocal metre
                return SI.RECIPROCAL_METRE;
            case "Pa.s":
                // The SI unit for dynamic viscosity quantities, pascal second
                return SI.PASCAL_SECOND;
            case "cd/m2":
                // Candela per square metre
                return SI.CANDELA_PER_SQUARE_METRE;
            case "m2/s":
                return SI.SQUARE_METRE_PER_SECOND;
            case "A/m":
                return SI.AMPERE_PER_METRE;
            case "C/kg":
                return SI.COULOMB_PER_KILOGRAM;
            case "W/sr":
                return SI.WATT_PER_STERADIAN;
            case "W/m2":
                return SI.WATT_PER_SQUARE_METRE;
            case "W/m^2":
                return SI.WATT_PER_SQUARE_METRE;
            case "rad/s":
                return SI.RADIAN_PER_SECOND;
            case "rad/s^2":
                return SI.RADIAN_PER_SQUARE_SECOND;
            case "rad/s2":
                return SI.RADIAN_PER_SQUARE_SECOND;
            case "UA":
                return SI.ASTRONOMICAL_UNIT;
            case "rev":
                return SI.REVOLUTION;
            // Other non-SI base units;
            case "deg":
                return NonSI.DEGREE_ANGLE;
            case "'":
                return NonSI.MINUTE_ANGLE;
            case "''":
                return NonSI.SECOND_ANGLE;
            case "t":
                return NonSI.TONNE;
            case "atom":
                return MOLE.divide(AVOGADRO_CONSTANT);
            case "fm2":
                return NonSI.BARN;
            case "Gal":
                return NonSI.GAL;
            case "Gi":
                return NonSI.GILBERT;
            case "sb":
                return NonSI.STILB;
            case "La":
                // Lambert (see si.uom.NonSI.LAMBERT)
                return NonSI.STILB.divide(StrictMath.PI);
            case "ph":
                return NonSI.PHOT;
            case "Phot":
                return NonSI.PHOT;
            case "Mx":
                return NonSI.MAXWELL;
            case "G":
                return NonSI.GAUSS;
            case "Oe":
                return NonSI.OERSTED;
            case "Ørsted":
                return NonSI.OERSTED;
            case "rd":
                return NonSI.RAD;
            case "P":
                return NonSI.POISE;
            case "St":
                return NonSI.STOKES;
            case "R":
                return NonSI.ROENTGEN;
            case "Roentgen":
                return NonSI.ROENTGEN;
            case "Bel":
                return NonSI.BEL;
            case "B":
                return NonSI.BEL;
            case "Neper":
                return NonSI.NEPER;
            case "Np":
                return NonSI.NEPER;
            case "Planck":
                return UCUM.PLANCK;
            case "grade":
                return USCustomary.GRADE;
            case "centiradian":
                return USCustomary.CENTIRADIAN;
            default:
                throw new NoSuchElementException(String.valueOf(unit));
        }
    }
}
