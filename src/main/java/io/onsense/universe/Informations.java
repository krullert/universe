package io.onsense.universe;

import java.util.Date;
import java.util.Objects;

/**
 * @author Koen Rooijmans
 */
public class Informations {

    public static ExpressionString cell(CharSequence infoType) {
        throw new UnsupportedOperationException();
    }

    public static ExpressionString cell(CharSequence infoType, CharSequence reference) {
        switch (infoType.toString()) {
            case "address":
                throw new UnsupportedOperationException();
            case "col":
                throw new UnsupportedOperationException();
            case "color":
                return ExpressionString.valueOf(0);
            case "contents":
                throw new UnsupportedOperationException();
            case "filename":
                return ExpressionString.valueOf("");
            case "format":
                throw new UnsupportedOperationException();
            case "parentheses":
                return ExpressionString.valueOf(0);
            case "prefix":
                throw new UnsupportedOperationException();
            case "protect":
                return ExpressionString.valueOf(0);
            case "row":
                throw new UnsupportedOperationException();
            case "type":
                if (reference == null || String.valueOf(reference).isEmpty()) {
                    return ExpressionString.valueOf("b");
                } else {
                    return ExpressionString.valueOf("v");
                }
            case "width":
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static FormulaDecimal errorType(CharSequence errorVal) {
        if (errorVal == null || errorVal.length() == 0) {
            throw new UniversalException("errorVal", 0, UniversalException.ErrorType.NA);
        }
        switch (errorVal.toString()) {
            case "#NULL!":
                return Formulas.valueOf(1);
            case "#DIV/0!":
                return Formulas.valueOf(2);
            case "#VALUE!":
                return Formulas.valueOf(3);
            case "#REF!":
                return Formulas.valueOf(4);
            case "#NAME?":
                return Formulas.valueOf(5);
            case "#NUM!":
                return Formulas.valueOf(6);
            case "#N/A":
                return Formulas.valueOf(7);
            case "#GETTING_DATA":
                return Formulas.valueOf(8);
            default:
                throw new UniversalException("errorVal", 0, UniversalException.ErrorType.NA);
        }
    }

    public static ExpressionString info(CharSequence typeText) {
        if (typeText == null || typeText.length() == 0) {
            throw new UniversalException("typeText", 0, UniversalException.ErrorType.NA);
        }
        switch (typeText.toString()) {
            case "directory":
                return ExpressionString.valueOf("");
            case "numfile":
                return ExpressionString.valueOf("0");
            case "origin":
                throw new UnsupportedOperationException();
            case "osversion":
                throw new UnsupportedOperationException();
            case "recalc":
                throw new UnsupportedOperationException();
            case "release":
                throw new UnsupportedOperationException();
            case "system":
                throw new UnsupportedOperationException();
            default:
                throw new UniversalException("errorVal", 0, UniversalException.ErrorType.NA);
        }
    }

    public static Logical isBlank(Object value) {
        if (value == null) {
            return Logical.TRUE;
        } else if (value instanceof CharSequence) {
            return Logical.valueOf(value.toString().isEmpty());
        } else {
            return Logical.FALSE;
        }
    }

    public static Logical isErr(Object value) {
        return Logical.FALSE;
    }

    public static Logical isError(Object value) {
        return Logical.FALSE;
    }

    public static Logical isEven(Object value) {
        if (isNumber(value).booleanValue()) {
            try {
                return Logical.valueOf(Formulas.valueOf(value.toString()).intValueExact() % 2 == 0);
            } catch (ArithmeticException | UniversalException e) {
                return Logical.FALSE;
            }
        } else {
            return Logical.FALSE;
        }
    }

    public static Logical isFormula(Object value) {
        throw new UnsupportedOperationException();
    }

    public static Logical isLogical(Object value) {
        return Logical.valueOf(value instanceof Boolean || value instanceof Logical);
    }

    public static Logical isNa(Object value) {
        return Logical.valueOf(Objects.equals(value, na()));
    }

    public static Logical isNonText(Object value) {
        return Logical.valueOf(!(value instanceof CharSequence));
    }

    public static Logical isNumber(Object value) {
        return Logical.valueOf(value instanceof Number);
    }

    public static Logical isOdd(Number value) {
        return isOdd((Object) value);
    }

    public static Logical isOdd(Object value) {
        if (isNumber(value).booleanValue()) {
            try {
                return Logical.valueOf(Formulas.valueOf(value.toString()).intValueExact() % 2 != 0);
            } catch (ArithmeticException | UniversalException e) {
                return Logical.FALSE;
            }
        } else {
            return Logical.FALSE;
        }
    }

    public static Logical isRef(Object value) {
        throw new UnsupportedOperationException();
    }

    public static Logical isText(Object value) {
        return Logical.valueOf(value instanceof CharSequence);
    }

    public static FormulaDecimal n(CharSequence value) {
        if (value == null) {
            return FormulaDecimal.ZERO;
        }
        if (value.length() > 0 && value.charAt(0) == '#') {
            try {
                return errorType(value);
            } catch (UniversalException e) {
                // no-op
            }
        }
        try {
            return Formulas.valueOfObject(value);
        } catch (NumberFormatException | UniversalException e) {
            return FormulaDecimal.ZERO;
        }
    }

    public static FormulaDecimal n(Number value) {
        return Formulas.valueOf(value);
    }

    public static FormulaDecimal n(Date value) {
        return Moments.datevalue(Moments.valueOf(value));
    }

    public static FormulaDecimal n(Boolean value) {
        return n(Logical.valueOf(value));
    }

    public static FormulaDecimal n(Logical value) {
        return Formulas.valueOf(Logical.valueOf(value).booleanValue() ? 1 : 0);
    }

    public static ExpressionString na() {
        return ExpressionString.valueOf("#N/A");
    }

    public static FormulaDecimal sheet() {
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal sheet(Object reference) {
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal sheets() {
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal sheets(Object reference) {
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal type(Number value) {
        return Formulas.valueOf(1);
    }

    public static FormulaDecimal type(CharSequence value) {
        return Formulas.valueOf(2);
    }

    public static FormulaDecimal type(Boolean value) {
        return type(Logical.valueOf(value));
    }

    public static FormulaDecimal type(Logical value) {
        return Formulas.valueOf(4);
    }

    public static FormulaDecimal type(Object value, Object... values) {
        if (values != null && values.length != 0) {
            return Formulas.valueOf(64);
        } else {
            if (value instanceof Date) {
                return type((Date) value);
            } else if (value instanceof Boolean) {
                return type((Boolean) value);
            } else if (value instanceof Logical) {
                return type((Logical) value);
            } else if (value instanceof CharSequence) {
                return type((CharSequence) value);
            } else if (value instanceof Number) {
                return type((Number) value);
            }
        }
        throw new UnsupportedOperationException();
    }
}
