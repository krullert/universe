package io.onsense.universe;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Koen Rooijmans
 */
public class Lookups {

    public static ExpressionString address(Number rowNum, Number columnNum) {
        return address(rowNum, columnNum, 1);
    }

    public static ExpressionString address(Number rowNum, Number columnNum, Number absNum) {
        throw new UnsupportedOperationException();
    }

    public static ExpressionString areas(Object reference) {
        throw new UnsupportedOperationException();
    }

    public static ExpressionString choose(Number index, CharSequence value, CharSequence... values) {
        if (index == null || Formulas.valueOf(index).compareTo(BigDecimal.ONE) < 0) {
            throw new UniversalException("index", 0, UniversalException.ErrorType.VALUE);
        }
        // Uses index_num to return a value from the list of value arguments.
        final CharSequence[] array = ArrayHelper.prepend(CharSequence.class, value, values);
        if (Formulas.valueOf(index).compareTo(Formulas.valueOf(array.length)) > 0) {
            throw new UniversalException("index", 0, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(array[index.intValue() - 1]);
    }

    public static ExpressionString choose(Number index, CharSequence value, String[] values) {
        if (index == null || Formulas.valueOf(index).compareTo(BigDecimal.ONE) < 0) {
            throw new UniversalException("index", 0, UniversalException.ErrorType.VALUE);
        }
        // Uses index_num to return a value from the list of value arguments.
        final String[] array = ArrayHelper.prepend(String.class, value.toString(), values);
        if (Formulas.valueOf(index).compareTo(Formulas.valueOf(array.length)) > 0) {
            throw new UniversalException("index", 0, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(array[index.intValue() - 1]);
    }

    public static ExpressionString choose(Number index, String[] values) {
        if (index == null || Formulas.valueOf(index).compareTo(BigDecimal.ONE) < 0) {
            throw new UniversalException("index", 0, UniversalException.ErrorType.VALUE);
        }
        // Uses index_num to return a value from the list of value arguments.
        if (Formulas.valueOf(index).compareTo(Formulas.valueOf(values.length)) > 0) {
            throw new UniversalException("index", 0, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(values[index.intValue() - 1]);
    }

    public static ExpressionString choose(Number index, Date value, Date... values) {
        if (index == null || Formulas.valueOf(index).compareTo(BigDecimal.ONE) < 0) {
            throw new UniversalException("index", 0, UniversalException.ErrorType.VALUE);
        }
        // Uses index_num to return a value from the list of value arguments.
        final Date[] array = ArrayHelper.prepend(Date.class, value, values);
        if (Formulas.valueOf(index).compareTo(Formulas.valueOf(array.length)) > 0) {
            throw new UniversalException("index", 0, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(array[index.intValue() - 1]);
    }

    public static ExpressionString choose(Number index, Date[] values) {
        if (index == null || Formulas.valueOf(index).compareTo(BigDecimal.ONE) < 0) {
            throw new UniversalException("index", 0, UniversalException.ErrorType.VALUE);
        }
        // Uses index_num to return a value from the list of value arguments.
        if (Formulas.valueOf(index).compareTo(Formulas.valueOf(values.length)) > 0) {
            throw new UniversalException("index", 0, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(values[index.intValue() - 1]);
    }

    public static ExpressionString choose(Number index, Logical value, Logical... values) {
        if (index == null || Formulas.valueOf(index).compareTo(BigDecimal.ONE) < 0) {
            throw new UniversalException("index", 0, UniversalException.ErrorType.VALUE);
        }
        // Uses index_num to return a value from the list of value arguments.
        final Logical[] array = ArrayHelper.prepend(Logical.class, value, values);
        if (Formulas.valueOf(index).compareTo(Formulas.valueOf(array.length)) > 0) {
            throw new UniversalException("index", 0, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(array[index.intValue() - 1]);
    }

    public static ExpressionString choose(Number index, Logical[] values) {
        if (index == null || Formulas.valueOf(index).compareTo(BigDecimal.ONE) < 0) {
            throw new UniversalException("index", 0, UniversalException.ErrorType.VALUE);
        }
        // Uses index_num to return a value from the list of value arguments.
        if (Formulas.valueOf(index).compareTo(Formulas.valueOf(values.length)) > 0) {
            throw new UniversalException("index", 0, UniversalException.ErrorType.VALUE);
        }
        return ExpressionString.valueOf(values[index.intValue() - 1]);
    }

    public static FormulaDecimal choose(Number index, Number number, Number... numbers) {
        if (index == null || Formulas.valueOf(index).compareTo(BigDecimal.ONE) < 0) {
            throw new UniversalException("index", 0, UniversalException.ErrorType.VALUE);
        }
        // Uses index_num to return a value from the list of value arguments.
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        if (Formulas.valueOf(index).compareTo(Formulas.valueOf(array.length)) > 0) {
            throw new UniversalException("index", 0, UniversalException.ErrorType.VALUE);
        }
        return Formulas.valueOf(array[index.intValue() - 1]);
    }

    public static FormulaDecimal choose(Number index, Number[] values) {
        if (index == null || Formulas.valueOf(index).compareTo(BigDecimal.ONE) < 0) {
            throw new UniversalException("index", 0, UniversalException.ErrorType.VALUE);
        }
        // Uses index_num to return a value from the list of value arguments.
        if (Formulas.valueOf(index).compareTo(Formulas.valueOf(values.length)) > 0) {
            throw new UniversalException("index", 0, UniversalException.ErrorType.VALUE);
        }
        return Formulas.valueOf(values[index.intValue() - 1]);
    }

    public static ExpressionString column() {
        throw new UnsupportedOperationException();
    }

    public static ExpressionString column(Object reference) {
        throw new UnsupportedOperationException();
    }

    public static ExpressionString columns(Number column, Number... columns) {
        throw new UnsupportedOperationException();
    }

    public static ExpressionString formulatext(CharSequence reference) {
        throw new UnsupportedOperationException();
    }

    public static ExpressionString getpivotdata(CharSequence dataField, Object pivotTable, Object... fieldItemParis) {
        throw new UnsupportedOperationException();
    }

    public static ExpressionString hlookup(CharSequence lookupValue, Object[] tableArray, Number rowIndexNum) {
        return hlookup(lookupValue, tableArray, rowIndexNum, true);
    }

    public static ExpressionString hlookup(CharSequence lookupValue, Object[] tableArray, Number rowIndexNum, Boolean rangeLookup) {
        return hlookup(lookupValue, tableArray, rowIndexNum, Logical.valueOf(rangeLookup));
    }

    public static ExpressionString hlookup(CharSequence lookupValue, Object[] tableArray, Number rowIndexNum, Logical rangeLookup) {
        throw new UnsupportedOperationException();
    }

    public static ExpressionString hyperlink(CharSequence linkLocation) {
        return hyperlink(linkLocation, null);
    }

    public static ExpressionString hyperlink(CharSequence linkLocation, CharSequence friendlyName) {
        throw new UnsupportedOperationException();
    }

    public static ExpressionString index(Object[] array, Number rowNum) {
        throw new UnsupportedOperationException();
    }

    public static ExpressionString index(Object[] array, Number rowNum, Number columnNum) {
        throw new UnsupportedOperationException();
    }

    public static ExpressionString indirect(Object reference) {
        throw new UnsupportedOperationException();
    }

    public static ExpressionString indirect(Object reference, Logical a1) {
        throw new UnsupportedOperationException();
    }

    public static ExpressionString lookup(CharSequence lookupValue, Object[] array) {
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal match(CharSequence lookupValue, Object[] lookupArray) {
        return match(lookupValue, lookupArray, 1);
    }

    public static FormulaDecimal match(CharSequence lookupValue, Number... array) {
        if (lookupValue == null) {
            throw new UniversalException("lookupValue", 0, UniversalException.ErrorType.VALUE);
        }
        if (array == null || array.length == 0) {
            throw new UniversalException("lookupArray", 1, UniversalException.ErrorType.VALUE);
        }
        if (Formulas.valueOf(array[array.length - 1]).compareTo(BigDecimal.ZERO) == 0
                || Formulas.valueOf(array[array.length - 1]).compareTo(BigDecimal.ONE) == 0
                || Formulas.valueOf(array[array.length - 1]).compareTo(BigDecimal.ONE.negate()) == 0) {
            return match(lookupValue, Arrays.copyOfRange(array, 0, array.length - 1), array[array.length - 1]);
        } else {
            return match(lookupValue, array, 1);
        }
    }

    public static FormulaDecimal match(CharSequence lookupValue, Object[] lookupArray, Number matchType) {
        throw new UnsupportedOperationException();
    }

    public static ExpressionString offset(Object reference, Number rows, Number cols) {
        throw new UnsupportedOperationException();
    }

    public static ExpressionString offset(Object reference, Number rows, Number cols, Number height) {
        throw new UnsupportedOperationException();
    }

    public static ExpressionString offset(Object reference, Number rows, Number cols, Number height, Number width) {
        throw new UnsupportedOperationException();
    }

    public static ExpressionString row() {
        throw new UnsupportedOperationException();
    }

    public static ExpressionString row(Object reference) {
        throw new UnsupportedOperationException();
    }

    public static ExpressionString rows(Object[] array) {
        throw new UnsupportedOperationException();
    }

    public static ExpressionString rtd(CharSequence progId, CharSequence server, CharSequence... topics) {
        throw new UnsupportedOperationException();
    }

    public static ExpressionString transpose(Object[] array) {
        throw new UnsupportedOperationException();
    }

    public static ExpressionString vlookup(CharSequence lookupValue, Object[] tableArray, Number colIndexNum) {
        return vlookup(lookupValue, tableArray, colIndexNum, true);
    }

    public static ExpressionString vlookup(CharSequence lookupValue, Object[] tableArray, Number colIndexNum, Boolean rangeLookup) {
        return vlookup(lookupValue, tableArray, colIndexNum, Logical.valueOf(rangeLookup));
    }

    public static ExpressionString vlookup(CharSequence lookupValue, Object[] tableArray, Number colIndexNum, Logical rangeLookup) {
        throw new UnsupportedOperationException();
    }
}
