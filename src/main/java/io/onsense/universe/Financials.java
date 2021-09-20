package io.onsense.universe;

import org.apache.commons.lang3.ArrayUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Date;
import java.util.function.Function;

/**
 * @author Koen Rooijmans
 */
public class Financials {

    public static FormulaDecimal accrint(CharSequence issueDate, CharSequence firstInterestDate, CharSequence settlementDate, Number annualCouponRate, Number parValue, Number frequency) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, 0);
    }

    public static FormulaDecimal accrint(Number issueDate, Number firstInterestDate, Number settlementDate, Number annualCouponRate, Number parValue, Number frequency) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, 0);
    }

    public static FormulaDecimal accrint(Number issueDate, CharSequence firstInterestDate, CharSequence settlementDate, Number annualCouponRate, Number parValue, Number frequency) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, 0);
    }

    public static FormulaDecimal accrint(CharSequence issueDate, Number firstInterestDate, CharSequence settlementDate, Number annualCouponRate, Number parValue, Number frequency) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, 0);
    }

    public static FormulaDecimal accrint(CharSequence issueDate, CharSequence firstInterestDate, Number settlementDate, Number annualCouponRate, Number parValue, Number frequency) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, 0);
    }

    public static FormulaDecimal accrint(Number issueDate, Number firstInterestDate, CharSequence settlementDate, Number annualCouponRate, Number parValue, Number frequency) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, 0);
    }

    public static FormulaDecimal accrint(CharSequence issueDate, Number firstInterestDate, Number settlementDate, Number annualCouponRate, Number parValue, Number frequency) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, 0);
    }

    public static FormulaDecimal accrint(Date issueDate, CharSequence firstInterestDate, CharSequence settlementDate, Number annualCouponRate, Number parValue, Number frequency) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, 0);
    }

    public static FormulaDecimal accrint(CharSequence issueDate, Date firstInterestDate, Date settlementDate, Number annualCouponRate, Number parValue, Number frequency) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, 0);
    }

    public static FormulaDecimal accrint(Date issueDate, Date firstInterestDate, CharSequence settlementDate, Number annualCouponRate, Number parValue, Number frequency) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, 0);
    }

    public static FormulaDecimal accrint(Date issueDate, CharSequence firstInterestDate, Date settlementDate, Number annualCouponRate, Number parValue, Number frequency) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, 0);
    }

    public static FormulaDecimal accrint(Date issueDate, Date firstInterestDate, Date settlementDate, Number annualCouponRate, Number parValue, Number frequency) {
        return accrint(issueDate, firstInterestDate, settlementDate, annualCouponRate, parValue, frequency, 0);
    }

    public static FormulaDecimal accrint(CharSequence issueDate, CharSequence firstInterestDate, CharSequence settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis);
    }

    public static FormulaDecimal accrint(CharSequence issueDate, Date firstInterestDate, Date settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis);
    }

    public static FormulaDecimal accrint(Date issueDate, CharSequence firstInterestDate, Date settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis);
    }

    public static FormulaDecimal accrint(Date issueDate, Date firstInterestDate, CharSequence settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis);
    }

    public static FormulaDecimal accrint(CharSequence issueDate, CharSequence firstInterestDate, Date settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis);
    }

    public static FormulaDecimal accrint(Date issueDate, CharSequence firstInterestDate, CharSequence settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis);
    }

    public static FormulaDecimal accrint(CharSequence issueDate, Date firstInterestDate, CharSequence settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis);
    }

    public static FormulaDecimal accrint(Number issueDate, Date firstInterestDate, Date settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis);
    }

    public static FormulaDecimal accrint(Date issueDate, Number firstInterestDate, Date settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis);
    }

    public static FormulaDecimal accrint(Date issueDate, Date firstInterestDate, Number settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis);
    }

    public static FormulaDecimal accrint(Number issueDate, Number firstInterestDate, Date settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis);
    }

    public static FormulaDecimal accrint(Date issueDate, Number firstInterestDate, Number settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis);
    }

    public static FormulaDecimal accrint(Number issueDate, Date firstInterestDate, Number settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis);
    }

    public static FormulaDecimal accrint(Number issueDate, Number firstInterestDate, CharSequence settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis);
    }

    public static FormulaDecimal accrint(Number issueDate, CharSequence firstInterestDate, CharSequence settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis);
    }

    public static FormulaDecimal accrint(CharSequence issueDate, Number firstInterestDate, CharSequence settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis);
    }

    public static FormulaDecimal accrint(Number issueDate, Number firstInterestDate, Number settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis);
    }

    public static FormulaDecimal accrint(CharSequence issueDate, CharSequence firstInterestDate, Number settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis);
    }

    public static FormulaDecimal accrint(Date issueDate, Date firstInterestDate, Date settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis) {
        return accrint(issueDate, firstInterestDate, settlementDate, annualCouponRate, parValue, frequency, basis, true);
    }

    public static FormulaDecimal accrint(CharSequence issueDate, Date firstInterestDate, Date settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Boolean calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, calcMethod);
    }

    public static FormulaDecimal accrint(Date issueDate, CharSequence firstInterestDate, Date settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Boolean calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, calcMethod);
    }

    public static FormulaDecimal accrint(Date issueDate, Date firstInterestDate, CharSequence settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Boolean calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, calcMethod);
    }

    public static FormulaDecimal accrint(CharSequence issueDate, CharSequence firstInterestDate, Date settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Boolean calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, calcMethod);
    }

    public static FormulaDecimal accrint(Date issueDate, CharSequence firstInterestDate, CharSequence settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Boolean calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, calcMethod);
    }

    public static FormulaDecimal accrint(CharSequence issueDate, Date firstInterestDate, CharSequence settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Boolean calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, calcMethod);
    }

    public static FormulaDecimal accrint(CharSequence issueDate, CharSequence firstInterestDate, CharSequence settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Boolean calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, calcMethod);
    }

    public static FormulaDecimal accrint(Number issueDate, Date firstInterestDate, Date settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Boolean calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, calcMethod);
    }

    public static FormulaDecimal accrint(Date issueDate, Number firstInterestDate, Date settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Boolean calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, calcMethod);
    }

    public static FormulaDecimal accrint(Date issueDate, Date firstInterestDate, Number settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Boolean calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, calcMethod);
    }

    public static FormulaDecimal accrint(Number issueDate, Number firstInterestDate, Date settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Boolean calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, Logical.valueOf(calcMethod));
    }

    public static FormulaDecimal accrint(Date issueDate, Number firstInterestDate, Number settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Boolean calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, Logical.valueOf(calcMethod));
    }

    public static FormulaDecimal accrint(Number issueDate, Number firstInterestDate, Number settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Boolean calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, Logical.valueOf(calcMethod));
    }

    public static FormulaDecimal accrint(CharSequence issueDate, Date firstInterestDate, Date settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Logical calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, calcMethod);
    }

    public static FormulaDecimal accrint(Date issueDate, CharSequence firstInterestDate, Date settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Logical calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, calcMethod);
    }

    public static FormulaDecimal accrint(Date issueDate, Date firstInterestDate, CharSequence settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Logical calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, calcMethod);
    }

    public static FormulaDecimal accrint(CharSequence issueDate, CharSequence firstInterestDate, Date settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Logical calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, calcMethod);
    }

    public static FormulaDecimal accrint(Date issueDate, CharSequence firstInterestDate, CharSequence settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Logical calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, calcMethod);
    }

    public static FormulaDecimal accrint(CharSequence issueDate, Date firstInterestDate, CharSequence settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Logical calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, calcMethod);
    }

    public static FormulaDecimal accrint(CharSequence issueDate, CharSequence firstInterestDate, CharSequence settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Logical calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, calcMethod);
    }

    public static FormulaDecimal accrint(Number issueDate, Date firstInterestDate, Date settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Logical calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, calcMethod);
    }

    public static FormulaDecimal accrint(Date issueDate, Number firstInterestDate, Date settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Logical calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, calcMethod);
    }

    public static FormulaDecimal accrint(Date issueDate, Date firstInterestDate, Number settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Logical calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, calcMethod);
    }

    public static FormulaDecimal accrint(Number issueDate, Number firstInterestDate, Date settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Logical calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, calcMethod);
    }

    public static FormulaDecimal accrint(Date issueDate, Number firstInterestDate, Number settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Logical calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, calcMethod);
    }

    public static FormulaDecimal accrint(Number issueDate, Number firstInterestDate, Number settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Logical calcMethod) {
        return accrint(Moments.valueOf(issueDate), Moments.valueOf(firstInterestDate), Moments.valueOf(settlementDate), annualCouponRate, parValue, frequency, basis, calcMethod);
    }

    public static FormulaDecimal accrint(Date issueDate, Date firstInterestDate, Date settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Boolean calcMethod) {
        return accrint(issueDate, firstInterestDate, settlementDate, annualCouponRate, parValue, frequency, basis, Logical.valueOf(calcMethod));
    }

    public static FormulaDecimal accrint(Date issueDate, Date firstInterestDate, Date settlementDate, Number annualCouponRate, Number parValue, Number frequency, Number basis, Logical calcMethod) {
        if (issueDate == null) {
            throw new UniversalException("issueDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (firstInterestDate == null) {
            throw new UniversalException("firstInterestDate", 1, UniversalException.ErrorType.VALUE);
        }
        if (settlementDate == null) {
            throw new UniversalException("settlement", 2, UniversalException.ErrorType.VALUE);
        }
        if (issueDate.compareTo(settlementDate) > 0) {
            throw new UniversalException("issueDate", 2, UniversalException.ErrorType.NUM);
        }
        if (annualCouponRate == null) {
            throw new UniversalException("annualCouponRate", 3, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(parValue).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("annualCouponRate", 3, UniversalException.ErrorType.NUM);
        }
        if (parValue == null) {
            throw new UniversalException("parValue", 4, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(parValue).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("parValue", 4, UniversalException.ErrorType.NUM);
        }
        if (basis == null) {
            throw new UniversalException("basis", 5, UniversalException.ErrorType.VALUE);
        } else if (basis.intValue() < 0 || basis.intValue() > 4) {
            throw new UniversalException("basis", 5, UniversalException.ErrorType.NUM);
        }

        // Returns the accrued interest for a security that pays periodic interest.
        return Formulas.valueOf(parValue).multiply(Formulas.valueOf(annualCouponRate)).multiply(Moments.yearfrac(issueDate, settlementDate, basis));
    }

    public static FormulaDecimal accrintm(Date issueDate, Date settlement, Number annualCouponRate, Number parValue) {
        return accrintm(issueDate, settlement, annualCouponRate, parValue, 0);
    }

    public static FormulaDecimal accrintm(CharSequence issueDate, CharSequence settlement, Number annualCouponRate, Number parValue) {
        return accrintm(Moments.valueOf(issueDate), Moments.valueOf(settlement), annualCouponRate, parValue, 0);
    }

    public static FormulaDecimal accrintm(Date issueDate, CharSequence settlement, Number annualCouponRate, Number parValue) {
        return accrintm(Moments.valueOf(issueDate), Moments.valueOf(settlement), annualCouponRate, parValue, 0);
    }

    public static FormulaDecimal accrintm(CharSequence issueDate, Date settlement, Number annualCouponRate, Number parValue) {
        return accrintm(Moments.valueOf(issueDate), Moments.valueOf(settlement), annualCouponRate, parValue, 0);
    }

    public static FormulaDecimal accrintm(Number issueDate, CharSequence settlement, Number annualCouponRate, Number parValue) {
        return accrintm(Moments.valueOf(issueDate), Moments.valueOf(settlement), annualCouponRate, parValue, 0);
    }

    public static FormulaDecimal accrintm(CharSequence issueDate, Number settlement, Number annualCouponRate, Number parValue) {
        return accrintm(Moments.valueOf(issueDate), Moments.valueOf(settlement), annualCouponRate, parValue, 0);
    }

    public static FormulaDecimal accrintm(Number issueDate, Number settlement, Number annualCouponRate, Number parValue) {
        return accrintm(Moments.valueOf(issueDate), Moments.valueOf(settlement), annualCouponRate, parValue, 0);
    }

    public static FormulaDecimal accrintm(Number issueDate, Date settlement, Number annualCouponRate, Number parValue) {
        return accrintm(Moments.valueOf(issueDate), Moments.valueOf(settlement), annualCouponRate, parValue, 0);
    }

    public static FormulaDecimal accrintm(Date issueDate, Number settlement, Number annualCouponRate, Number parValue) {
        return accrintm(Moments.valueOf(issueDate), Moments.valueOf(settlement), annualCouponRate, parValue, 0);
    }

    public static FormulaDecimal accrintm(CharSequence issueDate, CharSequence settlement, Number annualCouponRate, Number parValue, Number basis) {
        return accrintm(Moments.valueOf(issueDate), Moments.valueOf(settlement), annualCouponRate, parValue, basis);
    }

    public static FormulaDecimal accrintm(Date issueDate, CharSequence settlement, Number annualCouponRate, Number parValue, Number basis) {
        return accrintm(Moments.valueOf(issueDate), Moments.valueOf(settlement), annualCouponRate, parValue, basis);
    }

    public static FormulaDecimal accrintm(CharSequence issueDate, Date settlement, Number annualCouponRate, Number parValue, Number basis) {
        return accrintm(Moments.valueOf(issueDate), Moments.valueOf(settlement), annualCouponRate, parValue, basis);
    }

    public static FormulaDecimal accrintm(Number issueDate, CharSequence settlement, Number annualCouponRate, Number parValue, Number basis) {
        return accrintm(Moments.valueOf(issueDate), Moments.valueOf(settlement), annualCouponRate, parValue, basis);
    }

    public static FormulaDecimal accrintm(CharSequence issueDate, Number settlement, Number annualCouponRate, Number parValue, Number basis) {
        return accrintm(Moments.valueOf(issueDate), Moments.valueOf(settlement), annualCouponRate, parValue, basis);
    }

    public static FormulaDecimal accrintm(Number issueDate, Number settlement, Number annualCouponRate, Number parValue, Number basis) {
        return accrintm(Moments.valueOf(issueDate), Moments.valueOf(settlement), annualCouponRate, parValue, basis);
    }

    public static FormulaDecimal accrintm(Number issueDate, Date settlement, Number annualCouponRate, Number parValue, Number basis) {
        return accrintm(Moments.valueOf(issueDate), Moments.valueOf(settlement), annualCouponRate, parValue, basis);
    }

    public static FormulaDecimal accrintm(Date issueDate, Number settlement, Number annualCouponRate, Number parValue, Number basis) {
        return accrintm(Moments.valueOf(issueDate), Moments.valueOf(settlement), annualCouponRate, parValue, basis);
    }

    public static FormulaDecimal accrintm(Date issueDate, Date settlement, Number annualCouponRate, Number parValue, Number basis) {

        if (issueDate == null) {
            throw new UniversalException("issueDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (settlement == null) {
            throw new UniversalException("settlement", 1, UniversalException.ErrorType.VALUE);
        }
        if (issueDate.compareTo(settlement) > 0) {
            throw new UniversalException("issueDate", 0, UniversalException.ErrorType.NUM);
        }
        if (annualCouponRate == null) {
            throw new UniversalException("annualCouponRate", 2, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(parValue).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("annualCouponRate", 2, UniversalException.ErrorType.NUM);
        }
        if (parValue == null) {
            throw new UniversalException("parValue", 3, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(parValue).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("parValue", 3, UniversalException.ErrorType.NUM);
        }
        if (basis == null) {
            throw new UniversalException("basis", 4, UniversalException.ErrorType.VALUE);
        } else if (basis.intValue() < 0 || basis.intValue() > 4) {
            throw new UniversalException("basis", 4, UniversalException.ErrorType.NUM);
        }

        // Returns the accrued interest for a security that pays interest at maturity.
        return Formulas.valueOf(parValue).multiply(Formulas.valueOf(annualCouponRate)).multiply(Moments.yearfrac2(issueDate, settlement, basis));
    }

    public static FormulaDecimal amordegrc(Number cost, Date datePurchased, Date endOfFirstPeriod, Number salvageValue, Number period, Number rate) {
        return amordegrc(cost, datePurchased, endOfFirstPeriod, salvageValue, period, rate, 0);
    }

    public static FormulaDecimal amordegrc(Number cost, CharSequence datePurchased, CharSequence endOfFirstPeriod, Number salvageValue, Number period, Number rate) {
        return amordegrc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, 0);
    }

    public static FormulaDecimal amordegrc(Number cost, Date datePurchased, CharSequence endOfFirstPeriod, Number salvageValue, Number period, Number rate) {
        return amordegrc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, 0);
    }

    public static FormulaDecimal amordegrc(Number cost, CharSequence datePurchased, Date endOfFirstPeriod, Number salvageValue, Number period, Number rate) {
        return amordegrc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, 0);
    }

    public static FormulaDecimal amordegrc(Number cost, Number datePurchased, Number endOfFirstPeriod, Number salvageValue, Number period, Number rate) {
        return amordegrc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, 0);
    }

    public static FormulaDecimal amordegrc(Number cost, CharSequence datePurchased, Number endOfFirstPeriod, Number salvageValue, Number period, Number rate) {
        return amordegrc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, 0);
    }

    public static FormulaDecimal amordegrc(Number cost, Number datePurchased, CharSequence endOfFirstPeriod, Number salvageValue, Number period, Number rate) {
        return amordegrc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, 0);
    }

    public static FormulaDecimal amordegrc(Number cost, Number datePurchased, Date endOfFirstPeriod, Number salvageValue, Number period, Number rate) {
        return amordegrc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, 0);
    }

    public static FormulaDecimal amordegrc(Number cost, Date datePurchased, Number endOfFirstPeriod, Number salvageValue, Number period, Number rate) {
        return amordegrc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, 0);
    }

    public static FormulaDecimal amordegrc(Number cost, CharSequence datePurchased, CharSequence endOfFirstPeriod, Number salvageValue, Number period, Number rate, Number basis) {
        return amordegrc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, basis);
    }

    public static FormulaDecimal amordegrc(Number cost, Date datePurchased, CharSequence endOfFirstPeriod, Number salvageValue, Number period, Number rate, Number basis) {
        return amordegrc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, basis);
    }

    public static FormulaDecimal amordegrc(Number cost, CharSequence datePurchased, Date endOfFirstPeriod, Number salvageValue, Number period, Number rate, Number basis) {
        return amordegrc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, basis);
    }

    public static FormulaDecimal amordegrc(Number cost, Number datePurchased, Number endOfFirstPeriod, Number salvageValue, Number period, Number rate, Number basis) {
        return amordegrc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, basis);
    }

    public static FormulaDecimal amordegrc(Number cost, CharSequence datePurchased, Number endOfFirstPeriod, Number salvageValue, Number period, Number rate, Number basis) {
        return amordegrc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, basis);
    }

    public static FormulaDecimal amordegrc(Number cost, Number datePurchased, CharSequence endOfFirstPeriod, Number salvageValue, Number period, Number rate, Number basis) {
        return amordegrc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, basis);
    }

    public static FormulaDecimal amordegrc(Number cost, Number datePurchased, Date endOfFirstPeriod, Number salvageValue, Number period, Number rate, Number basis) {
        return amordegrc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, basis);
    }

    public static FormulaDecimal amordegrc(Number cost, Date datePurchased, Number endOfFirstPeriod, Number salvageValue, Number period, Number rate, Number basis) {
        return amordegrc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, basis);
    }

    public static FormulaDecimal amordegrc(Number cost, Date datePurchased, Date endOfFirstPeriod, Number salvageValue, Number period, Number rate, Number basis) {
        if (cost == null) {
            throw new UniversalException("cost", 0, UniversalException.ErrorType.VALUE);
        }
        if (datePurchased == null) {
            throw new UniversalException("datePurchased", 1, UniversalException.ErrorType.VALUE);
        }
        if (endOfFirstPeriod == null) {
            throw new UniversalException("endOfFirstPeriod", 2, UniversalException.ErrorType.VALUE);
        }
        if (datePurchased.compareTo(endOfFirstPeriod) > 0) {
            throw new UniversalException("datePurchased", 1, UniversalException.ErrorType.NUM);
        }
        if (salvageValue == null) {
            throw new UniversalException("salvageValue", 3, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(salvageValue).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("salvageValue", 3, UniversalException.ErrorType.NUM);
        }
        if (period == null) {
            throw new UniversalException("period", 4, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(period).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("period", 4, UniversalException.ErrorType.NUM);
        }
        if (basis == null) {
            throw new UniversalException("basis", 5, UniversalException.ErrorType.VALUE);
        } else if (basis.intValue() < 0 || basis.intValue() > 4) {
            throw new UniversalException("basis", 5, UniversalException.ErrorType.NUM);
        }

        // Returns the depreciation for each accounting period.
        // This function is provided for the French accounting system.
        // If an asset is purchased in the middle of the accounting period, the prorated depreciation is taken into account.
        // The function is similar to AMORLINC, except that a depreciation coefficient is applied in the calculation depending on the life of the assets.

        FormulaDecimal nPer = Formulas.valueOf(period.intValue());
        FormulaDecimal fUsePer = Formulas.valueOf(1.0).divide(Formulas.valueOf(rate));
        FormulaDecimal fAmorCoeff;

        if (fUsePer.doubleValue() < 3.0) {
            fAmorCoeff = Formulas.valueOf(1.0);
        } else if (fUsePer.doubleValue() < 5.0) {
            fAmorCoeff = Formulas.valueOf(1.5);
        } else if (fUsePer.doubleValue() <= 6.0) {
            fAmorCoeff = Formulas.valueOf(2.0);
        } else {
            fAmorCoeff = Formulas.valueOf(2.5);
        }

        FormulaDecimal fRate = Formulas.valueOf(rate).multiply(fAmorCoeff);
        FormulaDecimal fNRate = Formulas.round(Moments.yearfrac2(datePurchased, endOfFirstPeriod, basis).multiply(fRate).multiply(Formulas.valueOf(cost)), 0);
        FormulaDecimal fCost = Formulas.valueOf(cost).subtract(fNRate);
        FormulaDecimal fRest = fCost.subtract(Formulas.valueOf(salvageValue));

        for (int n = 0; n < nPer.intValue(); n++) {
            fNRate = Formulas.round(fRate.multiply(fCost), 0);
            fRest = fRest.subtract(fNRate);

            if (fRest.doubleValue() < 0.0) {
                switch (nPer.intValue() - n) {
                    case 0:
                    case 1:
                        return Formulas.round(fCost.multiply(Formulas.valueOf(0.5)), 0);
                    default:
                        return Formulas.valueOf(0.0);
                }
            }

            fCost = fCost.subtract(fNRate);
        }

        return fNRate;
    }

    public static FormulaDecimal amorlinc(Number cost, Date datePurchased, Date endOfFirstPeriod, Number salvageValue, Number period, Number rate) {
        return amorlinc(cost, datePurchased, endOfFirstPeriod, salvageValue, period, rate, 0);
    }

    public static FormulaDecimal amorlinc(Number cost, CharSequence datePurchased, CharSequence endOfFirstPeriod, Number salvageValue, Number period, Number rate) {
        return amorlinc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, 0);
    }

    public static FormulaDecimal amorlinc(Number cost, Date datePurchased, CharSequence endOfFirstPeriod, Number salvageValue, Number period, Number rate) {
        return amorlinc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, 0);
    }

    public static FormulaDecimal amorlinc(Number cost, CharSequence datePurchased, Date endOfFirstPeriod, Number salvageValue, Number period, Number rate) {
        return amorlinc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, 0);
    }

    public static FormulaDecimal amorlinc(Number cost, Number datePurchased, Number endOfFirstPeriod, Number salvageValue, Number period, Number rate) {
        return amorlinc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, 0);
    }

    public static FormulaDecimal amorlinc(Number cost, CharSequence datePurchased, Number endOfFirstPeriod, Number salvageValue, Number period, Number rate) {
        return amorlinc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, 0);
    }

    public static FormulaDecimal amorlinc(Number cost, Number datePurchased, CharSequence endOfFirstPeriod, Number salvageValue, Number period, Number rate) {
        return amorlinc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, 0);
    }

    public static FormulaDecimal amorlinc(Number cost, Date datePurchased, Number endOfFirstPeriod, Number salvageValue, Number period, Number rate) {
        return amorlinc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, 0);
    }

    public static FormulaDecimal amorlinc(Number cost, Number datePurchased, Date endOfFirstPeriod, Number salvageValue, Number period, Number rate) {
        return amorlinc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, 0);
    }

    public static FormulaDecimal amorlinc(Number cost, CharSequence datePurchased, CharSequence endOfFirstPeriod, Number salvageValue, Number period, Number rate, Number basis) {
        return amorlinc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, basis);
    }

    public static FormulaDecimal amorlinc(Number cost, Date datePurchased, CharSequence endOfFirstPeriod, Number salvageValue, Number period, Number rate, Number basis) {
        return amorlinc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, basis);
    }

    public static FormulaDecimal amorlinc(Number cost, CharSequence datePurchased, Date endOfFirstPeriod, Number salvageValue, Number period, Number rate, Number basis) {
        return amorlinc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, basis);
    }

    public static FormulaDecimal amorlinc(Number cost, Number datePurchased, Number endOfFirstPeriod, Number salvageValue, Number period, Number rate, Number basis) {
        return amorlinc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, basis);
    }

    public static FormulaDecimal amorlinc(Number cost, CharSequence datePurchased, Number endOfFirstPeriod, Number salvageValue, Number period, Number rate, Number basis) {
        return amorlinc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, basis);
    }

    public static FormulaDecimal amorlinc(Number cost, Number datePurchased, CharSequence endOfFirstPeriod, Number salvageValue, Number period, Number rate, Number basis) {
        return amorlinc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, basis);
    }

    public static FormulaDecimal amorlinc(Number cost, Date datePurchased, Number endOfFirstPeriod, Number salvageValue, Number period, Number rate, Number basis) {
        return amorlinc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, basis);
    }

    public static FormulaDecimal amorlinc(Number cost, Number datePurchased, Date endOfFirstPeriod, Number salvageValue, Number period, Number rate, Number basis) {
        return amorlinc(cost, Moments.valueOf(datePurchased), Moments.valueOf(endOfFirstPeriod), salvageValue, period, rate, basis);
    }

    public static FormulaDecimal amorlinc(Number cost, Date datePurchased, Date endOfFirstPeriod, Number salvageValue, Number period, Number rate, Number basis) {
        if (cost == null) {
            throw new UniversalException("cost", 0, UniversalException.ErrorType.VALUE);
        }
        if (datePurchased == null) {
            throw new UniversalException("datePurchased", 1, UniversalException.ErrorType.VALUE);
        }
        if (endOfFirstPeriod == null) {
            throw new UniversalException("endOfFirstPeriod", 2, UniversalException.ErrorType.VALUE);
        }
        if (datePurchased.compareTo(endOfFirstPeriod) > 0) {
            throw new UniversalException("datePurchased", 1, UniversalException.ErrorType.NUM);
        }
        if (salvageValue == null) {
            throw new UniversalException("salvageValue", 3, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(salvageValue).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("salvageValue", 3, UniversalException.ErrorType.NUM);
        }
        if (period == null) {
            throw new UniversalException("period", 4, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(period).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("period", 4, UniversalException.ErrorType.NUM);
        }
        if (rate == null) {
            throw new UniversalException("rate", 5, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(period).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("rate", 5, UniversalException.ErrorType.NUM);
        }
        if (basis == null) {
            throw new UniversalException("basis", 6, UniversalException.ErrorType.VALUE);
        } else if (basis.intValue() < 0 || basis.intValue() > 4) {
            throw new UniversalException("basis", 6, UniversalException.ErrorType.NUM);
        }

        // Returns the depreciation for each accounting period.
        // This function is provided for the French accounting system.
        // If an asset is purchased in the middle of the accounting period, the prorated depreciation is taken into account.
        FormulaDecimal nPer = Formulas.valueOf(period);
        FormulaDecimal fOneRate = Formulas.valueOf(cost).multiply(Formulas.valueOf(rate));
        FormulaDecimal fCostDelta = Formulas.valueOf(cost).subtract(Formulas.valueOf(salvageValue));
        FormulaDecimal f0Rate = Moments.yearfrac(datePurchased, endOfFirstPeriod, basis).multiply(Formulas.valueOf(rate)).multiply(Formulas.valueOf(cost));
        FormulaDecimal nNumOfFullPeriods = Formulas.valueOf(cost).subtract(Formulas.valueOf(salvageValue)).subtract(f0Rate).divide(Formulas.valueOf(fOneRate));

        if (nPer.intValue() == 0) {
            return f0Rate;
        } else if (nPer.intValue() <= nNumOfFullPeriods.intValue()) {
            return fOneRate;
        } else if (nPer.intValue() == nNumOfFullPeriods.intValue() + 1) {
            return Formulas.valueOf(fCostDelta).subtract(Formulas.valueOf(fOneRate).multiply(nNumOfFullPeriods)).subtract(f0Rate);
        } else {
            return Formulas.valueOf(0.0);
        }
    }

    public static FormulaDecimal coupdaybs(Date settlementDate, Date maturityDate, Number frequency) {
        return coupdaybs(settlementDate, maturityDate, frequency, 0);
    }

    public static FormulaDecimal coupdaybs(CharSequence settlementDate, CharSequence maturityDate, Number frequency) {
        return coupdaybs(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupdaybs(Date settlementDate, CharSequence maturityDate, Number frequency) {
        return coupdaybs(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupdaybs(CharSequence settlementDate, Date maturityDate, Number frequency) {
        return coupdaybs(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupdaybs(Number settlementDate, Number maturityDate, Number frequency) {
        return coupdaybs(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupdaybs(CharSequence settlementDate, Number maturityDate, Number frequency) {
        return coupdaybs(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupdaybs(Number settlementDate, CharSequence maturityDate, Number frequency) {
        return coupdaybs(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupdaybs(Date settlementDate, Number maturityDate, Number frequency) {
        return coupdaybs(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupdaybs(CharSequence settlementDate, CharSequence maturityDate, Number frequency, Number basis) {
        return coupdaybs(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupdaybs(Date settlementDate, CharSequence maturityDate, Number frequency, Number basis) {
        return coupdaybs(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupdaybs(CharSequence settlementDate, Date maturityDate, Number frequency, Number basis) {
        return coupdaybs(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupdaybs(Number settlementDate, Number maturityDate, Number frequency, Number basis) {
        return coupdaybs(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupdaybs(CharSequence settlementDate, Number maturityDate, Number frequency, Number basis) {
        return coupdaybs(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupdaybs(Number settlementDate, CharSequence maturityDate, Number frequency, Number basis) {
        return coupdaybs(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupdaybs(Date settlementDate, Number maturityDate, Number frequency, Number basis) {
        return coupdaybs(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupdaybs(Number settlementDate, Date maturityDate, Number frequency) {
        return coupdaybs(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupdaybs(Date settlementDate, Date maturityDate, Number frequency, Number basis) {
        if (settlementDate == null) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (maturityDate == null) {
            throw new UniversalException("maturityDate", 1, UniversalException.ErrorType.VALUE);
        }
        if (settlementDate.compareTo(maturityDate) >= 0) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.NUM);
        }
        if (frequency == null) {
            throw new UniversalException("frequency", 2, UniversalException.ErrorType.VALUE);
        } else if (frequency.intValue() <= 0 || frequency.intValue() > 4 || frequency.intValue() == 3) {
            throw new UniversalException("frequency", 2, UniversalException.ErrorType.NUM);
        }
        if (basis == null) {
            throw new UniversalException("basis", 3, UniversalException.ErrorType.VALUE);
        } else if (basis.intValue() < 0 || basis.intValue() > 4) {
            throw new UniversalException("basis", 3, UniversalException.ErrorType.NUM);
        }

        // The COUPDAYBS function returns the number of days from the beginning of a coupon period until its settlement date.
        Moment aSettle = Moments.valueOf(settlementDate);
        Moment aDate = lcl_GetCouppcd(aSettle, Moments.valueOf(maturityDate), frequency.intValue());
        return Moments.datedif(aDate, aSettle, "D");
    }

    public static FormulaDecimal coupdays(Date settlementDate, Date maturityDate, Number frequency) {
        return coupdays(settlementDate, maturityDate, frequency, 0);
    }

    public static FormulaDecimal coupdays(CharSequence settlementDate, CharSequence maturityDate, Number frequency) {
        return coupdays(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupdays(Date settlementDate, CharSequence maturityDate, Number frequency) {
        return coupdays(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupdays(CharSequence settlementDate, Date maturityDate, Number frequency) {
        return coupdays(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupdays(Number settlementDate, Number maturityDate, Number frequency) {
        return coupdays(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupdays(Number settlementDate, CharSequence maturityDate, Number frequency) {
        return coupdays(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupdays(CharSequence settlementDate, Number maturityDate, Number frequency) {
        return coupdays(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupdays(Date settlementDate, Number maturityDate, Number frequency) {
        return coupdays(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupdays(Number settlementDate, Date maturityDate, Number frequency) {
        return coupdays(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupdays(CharSequence settlementDate, CharSequence maturityDate, Number frequency, Number basis) {
        return coupdays(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupdays(Date settlementDate, CharSequence maturityDate, Number frequency, Number basis) {
        return coupdays(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupdays(CharSequence settlementDate, Date maturityDate, Number frequency, Number basis) {
        return coupdays(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupdays(Number settlementDate, Number maturityDate, Number frequency, Number basis) {
        return coupdays(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupdays(Number settlementDate, CharSequence maturityDate, Number frequency, Number basis) {
        return coupdays(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupdays(CharSequence settlementDate, Number maturityDate, Number frequency, Number basis) {
        return coupdays(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupdays(Date settlementDate, Number maturityDate, Number frequency, Number basis) {
        return coupdays(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupdays(Number settlementDate, Date maturityDate, Number frequency, Number basis) {
        return coupdays(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupdays(Date settlementDate, Date maturityDate, Number frequency, Number basis) {
        if (settlementDate == null) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (maturityDate == null) {
            throw new UniversalException("maturityDate", 1, UniversalException.ErrorType.VALUE);
        }
        if (settlementDate.compareTo(maturityDate) >= 0) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.NUM);
        }
        if (frequency == null) {
            throw new UniversalException("frequency", 2, UniversalException.ErrorType.VALUE);
        } else if (frequency.intValue() <= 0 || frequency.intValue() > 4 || frequency.intValue() == 3) {
            throw new UniversalException("frequency", 2, UniversalException.ErrorType.NUM);
        }
        if (basis == null) {
            throw new UniversalException("basis", 3, UniversalException.ErrorType.VALUE);
        } else if (basis.intValue() < 0 || basis.intValue() > 4) {
            throw new UniversalException("basis", 3, UniversalException.ErrorType.NUM);
        }

        // Returns the number of days in the coupon period that contains the settlement date.
        // @see https://github.com/apache/openoffice/blob/c014b5f2b55cff8d4b0c952d5c16d62ecde09ca1/main/scaddins/source/analysis/analysishelper.cxx#L1394

        if (basis.intValue() == 1) {
            Moment aDate = lcl_GetCouppcd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency.intValue());

            Moment aNextDate = Moment.valueOf(aDate.year().intValue(), (int) (aDate.month().intValue() + (12d / frequency.intValue())), aDate.dayOfMonth().intValue(), aDate.hour().intValue(), aDate.minute().intValue(), aDate.second().intValue());

            return Moments.datedif(aDate, aNextDate, "D").add(Formulas.valueOf(1));
        }

        return basis.intValue() == 1 ? Formulas.valueOf(365).divide(Formulas.valueOf(frequency)) : Formulas.valueOf(365).divide(Formulas.valueOf(frequency));
    }

    public static FormulaDecimal coupdaysnc(Date settlementDate, Date maturityDate, Number frequency) {
        return coupdaysnc(settlementDate, maturityDate, frequency, 0);
    }

    public static FormulaDecimal coupdaysnc(CharSequence settlementDate, CharSequence maturityDate, Number frequency) {
        return coupdaysnc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupdaysnc(Date settlementDate, CharSequence maturityDate, Number frequency) {
        return coupdaysnc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupdaysnc(CharSequence settlementDate, Date maturityDate, Number frequency) {
        return coupdaysnc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupdaysnc(Number settlementDate, Number maturityDate, Number frequency) {
        return coupdaysnc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupdaysnc(CharSequence settlementDate, Number maturityDate, Number frequency) {
        return coupdaysnc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupdaysnc(Number settlementDate, CharSequence maturityDate, Number frequency) {
        return coupdaysnc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupdaysnc(Number settlementDate, Date maturityDate, Number frequency) {
        return coupdaysnc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupdaysnc(Date settlementDate, Number maturityDate, Number frequency) {
        return coupdaysnc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupdaysnc(CharSequence settlementDate, CharSequence maturityDate, Number frequency, Number basis) {
        return coupdaysnc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupdaysnc(Date settlementDate, CharSequence maturityDate, Number frequency, Number basis) {
        return coupdaysnc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupdaysnc(CharSequence settlementDate, Date maturityDate, Number frequency, Number basis) {
        return coupdaysnc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupdaysnc(Number settlementDate, Number maturityDate, Number frequency, Number basis) {
        return coupdaysnc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupdaysnc(CharSequence settlementDate, Number maturityDate, Number frequency, Number basis) {
        return coupdaysnc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupdaysnc(Number settlementDate, CharSequence maturityDate, Number frequency, Number basis) {
        return coupdaysnc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupdaysnc(Number settlementDate, Date maturityDate, Number frequency, Number basis) {
        return coupdaysnc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupdaysnc(Date settlementDate, Number maturityDate, Number frequency, Number basis) {
        return coupdaysnc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupdaysnc(Date settlementDate, Date maturityDate, Number frequency, Number basis) {
        if (settlementDate == null) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (maturityDate == null) {
            throw new UniversalException("maturityDate", 1, UniversalException.ErrorType.VALUE);
        }
        if (settlementDate.compareTo(maturityDate) >= 0) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.NUM);
        }
        if (frequency == null) {
            throw new UniversalException("frequency", 2, UniversalException.ErrorType.VALUE);
        } else if (frequency.intValue() <= 0 || frequency.intValue() > 4 || frequency.intValue() == 3) {
            throw new UniversalException("frequency", 2, UniversalException.ErrorType.NUM);
        }
        if (basis == null) {
            throw new UniversalException("basis", 3, UniversalException.ErrorType.VALUE);
        } else if (basis.intValue() < 0 || basis.intValue() > 4) {
            throw new UniversalException("basis", 3, UniversalException.ErrorType.NUM);
        }


        // Returns the number of days from the settlement date to the next coupon date.
        // @see https://github.com/apache/openoffice/blob/c014b5f2b55cff8d4b0c952d5c16d62ecde09ca1/main/scaddins/source/analysis/analysishelper.cxx#L1375
        if ((basis.intValue() != 0) && (basis.intValue() != 4)) {
            Moment aSettle = Moments.valueOf(settlementDate);
            Moment aDate = lcl_GetCoupncd(aSettle, Moments.valueOf(maturityDate), frequency.intValue());
            return Moments.datedif(settlementDate, aDate, "D").add(Formulas.valueOf(1));
        }
        return coupdays(settlementDate, maturityDate, frequency, basis).subtract(coupdaybs(settlementDate, maturityDate, frequency, basis));
    }


    static Moment lcl_GetCoupncd(Moment rSettle, Moment rMat, int nFreq) {
        Moment rDate = rMat;
        rDate.setYear(rSettle.getYear());
        if (rDate.compareTo(rSettle) > 0) {
            rDate = Moment.valueOf(rDate.year().intValue() - 1, rDate.month().intValue(), rDate.dayOfMonth().intValue(), rDate.hour().intValue(), rDate.minute().intValue(), rDate.second().intValue());
        }
        // TODO refactor this while statement.. can cause infinite loops..
        while (rDate.compareTo(rSettle) <= 0) {
            rDate = Moment.valueOf(rDate.year().intValue(), (int) (rDate.month().intValue() + (12d / nFreq)), rDate.dayOfMonth().intValue(), rDate.hour().intValue(), rDate.minute().intValue(), rDate.second().intValue());
        }
        return rDate;
    }

    public static FormulaDecimal coupncd(Date settlementDate, Date maturityDate, Number frequency) {
        return coupncd(settlementDate, maturityDate, frequency, 0);
    }

    public static FormulaDecimal coupncd(CharSequence settlementDate, CharSequence maturityDate, Number frequency) {
        return coupncd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupncd(Date settlementDate, CharSequence maturityDate, Number frequency) {
        return coupncd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupncd(CharSequence settlementDate, Date maturityDate, Number frequency) {
        return coupncd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupncd(Number settlementDate, Number maturityDate, Number frequency) {
        return coupncd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupncd(CharSequence settlementDate, Number maturityDate, Number frequency) {
        return coupncd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupncd(Number settlementDate, CharSequence maturityDate, Number frequency) {
        return coupncd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupncd(Number settlementDate, Date maturityDate, Number frequency) {
        return coupncd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupncd(Date settlementDate, Number maturityDate, Number frequency) {
        return coupncd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupncd(CharSequence settlementDate, CharSequence maturityDate, Number frequency, Number basis) {
        return coupncd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupncd(Date settlementDate, CharSequence maturityDate, Number frequency, Number basis) {
        return coupncd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupncd(CharSequence settlementDate, Date maturityDate, Number frequency, Number basis) {
        return coupncd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupncd(Number settlementDate, Number maturityDate, Number frequency, Number basis) {
        return coupncd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupncd(CharSequence settlementDate, Number maturityDate, Number frequency, Number basis) {
        return coupncd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupncd(Number settlementDate, CharSequence maturityDate, Number frequency, Number basis) {
        return coupncd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupncd(Number settlementDate, Date maturityDate, Number frequency, Number basis) {
        return coupncd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupncd(Date settlementDate, Number maturityDate, Number frequency, Number basis) {
        return coupncd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupncd(Date settlementDate, Date maturityDate, Number frequency, Number basis) {
        if (settlementDate == null) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (maturityDate == null) {
            throw new UniversalException("maturityDate", 1, UniversalException.ErrorType.VALUE);
        }
        if (settlementDate.compareTo(maturityDate) >= 0) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.NUM);
        }
        if (frequency == null) {
            throw new UniversalException("frequency", 2, UniversalException.ErrorType.VALUE);
        } else if (frequency.intValue() <= 0 || frequency.intValue() > 4 || frequency.intValue() == 3) {
            throw new UniversalException("frequency", 2, UniversalException.ErrorType.NUM);
        }
        if (basis == null) {
            throw new UniversalException("basis", 3, UniversalException.ErrorType.VALUE);
        } else if (basis.intValue() < 0 || basis.intValue() > 4) {
            throw new UniversalException("basis", 3, UniversalException.ErrorType.NUM);
        }

        // Returns a number that represents the next coupon date after the settlement date.
        Moment aDate = lcl_GetCoupncd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency.intValue());
        return Moments.datevalue(aDate);
    }

    public static FormulaDecimal coupnum(Date settlementDate, Date maturityDate, Number frequency) {
        return coupnum(settlementDate, maturityDate, frequency, 0);
    }

    public static FormulaDecimal coupnum(CharSequence settlementDate, CharSequence maturityDate, Number frequency) {
        return coupnum(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupnum(Date settlementDate, CharSequence maturityDate, Number frequency) {
        return coupnum(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupnum(CharSequence settlementDate, Date maturityDate, Number frequency) {
        return coupnum(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupnum(Number settlementDate, Number maturityDate, Number frequency) {
        return coupnum(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupnum(CharSequence settlementDate, Number maturityDate, Number frequency) {
        return coupnum(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupnum(Number settlementDate, CharSequence maturityDate, Number frequency) {
        return coupnum(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupnum(Number settlementDate, Date maturityDate, Number frequency) {
        return coupnum(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupnum(Date settlementDate, Number maturityDate, Number frequency) {
        return coupnum(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal coupnum(CharSequence settlementDate, CharSequence maturityDate, Number frequency, Number basis) {
        return coupnum(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupnum(Date settlementDate, CharSequence maturityDate, Number frequency, Number basis) {
        return coupnum(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupnum(CharSequence settlementDate, Date maturityDate, Number frequency, Number basis) {
        return coupnum(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupnum(Number settlementDate, Number maturityDate, Number frequency, Number basis) {
        return coupnum(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupnum(CharSequence settlementDate, Number maturityDate, Number frequency, Number basis) {
        return coupnum(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupnum(Number settlementDate, CharSequence maturityDate, Number frequency, Number basis) {
        return coupnum(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupnum(Number settlementDate, Date maturityDate, Number frequency, Number basis) {
        return coupnum(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupnum(Date settlementDate, Number maturityDate, Number frequency, Number basis) {
        return coupnum(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal coupnum(Date settlementDate, Date maturityDate, Number frequency, Number basis) {
        if (settlementDate == null) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (maturityDate == null) {
            throw new UniversalException("maturityDate", 1, UniversalException.ErrorType.VALUE);
        }
        if (settlementDate.compareTo(maturityDate) >= 0) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.NUM);
        }
        if (frequency == null) {
            throw new UniversalException("frequency", 2, UniversalException.ErrorType.VALUE);
        } else if (frequency.intValue() <= 0 || frequency.intValue() > 4 || frequency.intValue() == 3) {
            throw new UniversalException("frequency", 2, UniversalException.ErrorType.NUM);
        }
        if (basis == null) {
            throw new UniversalException("basis", 3, UniversalException.ErrorType.VALUE);
        } else if (basis.intValue() < 0 || basis.intValue() > 4) {
            throw new UniversalException("basis", 3, UniversalException.ErrorType.NUM);
        }

        // Returns the number of coupons payable between the settlement date and maturity date, rounded up to the nearest whole coupon.
        // @see https://github.com/apache/openoffice/blob/c014b5f2b55cff8d4b0c952d5c16d62ecde09ca1/main/scaddins/source/analysis/analysishelper.cxx#L1414

        Moment aMat = Moments.valueOf(maturityDate);
        Moment aDate = lcl_GetCouppcd(Moments.valueOf(settlementDate), aMat, frequency.intValue());
        int nMonths = (aMat.year().intValue() - aDate.year().intValue()) * 12 + aMat.month().intValue() - aDate.month().intValue();
        return Formulas.valueOf(nMonths * frequency.doubleValue() / 12);
    }

    static Moment lcl_GetCouppcd(Moment rSettle, Moment rMat, int nFreq) {
        Moment rDate = Moment.valueOf(new Date(rMat.getTime()));
        rDate.setYear(rSettle.getYear());
        if (rDate.compareTo(rSettle) < 0) {
            rDate = Moment.valueOf(rDate.year().intValue() + 1, rDate.month().intValue(), rDate.dayOfMonth().intValue(), rDate.hour().intValue(), rDate.minute().intValue(), rDate.second().intValue());
        }
        // TODO refactor this while statement.. can cause infinite loops..
        while (rDate.compareTo(rSettle) > 0) {
            rDate = Moment.valueOf(rDate.year().intValue(), rDate.month().intValue() + (-12 / nFreq), rDate.dayOfMonth().intValue(), rDate.hour().intValue(), rDate.minute().intValue(), rDate.second().intValue());
        }

        return rDate;
    }

    public static FormulaDecimal couppcd(Date settlementDate, Date maturityDate, Number frequency) {
        return couppcd(settlementDate, maturityDate, frequency, 0);
    }

    public static FormulaDecimal couppcd(CharSequence settlementDate, CharSequence maturityDate, Number frequency) {
        return couppcd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal couppcd(Date settlementDate, CharSequence maturityDate, Number frequency) {
        return couppcd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal couppcd(CharSequence settlementDate, Date maturityDate, Number frequency) {
        return couppcd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal couppcd(Number settlementDate, Number maturityDate, Number frequency) {
        return couppcd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal couppcd(CharSequence settlementDate, Number maturityDate, Number frequency) {
        return couppcd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal couppcd(Number settlementDate, CharSequence maturityDate, Number frequency) {
        return couppcd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal couppcd(Number settlementDate, Date maturityDate, Number frequency) {
        return couppcd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal couppcd(Date settlementDate, Number maturityDate, Number frequency) {
        return couppcd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, 0);
    }

    public static FormulaDecimal couppcd(CharSequence settlementDate, CharSequence maturityDate, Number frequency, Number basis) {
        return couppcd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal couppcd(Date settlementDate, CharSequence maturityDate, Number frequency, Number basis) {
        return couppcd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal couppcd(CharSequence settlementDate, Date maturityDate, Number frequency, Number basis) {
        return couppcd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal couppcd(Number settlementDate, Number maturityDate, Number frequency, Number basis) {
        return couppcd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal couppcd(CharSequence settlementDate, Number maturityDate, Number frequency, Number basis) {
        return couppcd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal couppcd(Number settlementDate, CharSequence maturityDate, Number frequency, Number basis) {
        return couppcd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal couppcd(Number settlementDate, Date maturityDate, Number frequency, Number basis) {
        return couppcd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal couppcd(Date settlementDate, Number maturityDate, Number frequency, Number basis) {
        return couppcd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency, basis);
    }

    public static FormulaDecimal couppcd(Date settlementDate, Date maturityDate, Number frequency, Number basis) {
        if (settlementDate == null) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (maturityDate == null) {
            throw new UniversalException("maturityDate", 1, UniversalException.ErrorType.VALUE);
        }
        if (settlementDate.compareTo(maturityDate) >= 0) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.NUM);
        }
        if (frequency == null) {
            throw new UniversalException("frequency", 2, UniversalException.ErrorType.VALUE);
        } else if (frequency.intValue() <= 0 || frequency.intValue() > 4 || frequency.intValue() == 3) {
            throw new UniversalException("frequency", 2, UniversalException.ErrorType.NUM);
        }
        if (basis == null) {
            throw new UniversalException("basis", 3, UniversalException.ErrorType.VALUE);
        } else if (basis.intValue() < 0 || basis.intValue() > 4) {
            throw new UniversalException("basis", 3, UniversalException.ErrorType.NUM);
        }

        // Returns a number that represents the previous coupon date before the settlement date.
        Moment aDate = lcl_GetCouppcd(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), frequency.intValue());

        return Moments.datevalue(aDate);
    }

    public static FormulaDecimal cumipmt(Number interestRate, Number totalNumberOfPaymentPeriods, Number presentValue, Number startPeriod, Number endPeriod, Number timingType) {
        if (interestRate == null) {
            throw new UniversalException("interestRate", 0, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(interestRate).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("interestRate", 0, UniversalException.ErrorType.NUM);
        }
        if (totalNumberOfPaymentPeriods == null) {
            throw new UniversalException("totalNumberOfPaymentPeriods", 1, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(totalNumberOfPaymentPeriods).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("totalNumberOfPaymentPeriods", 1, UniversalException.ErrorType.NUM);
        }
        if (presentValue == null) {
            throw new UniversalException("presentValue", 2, UniversalException.ErrorType.VALUE);
        }
        if (startPeriod == null) {
            throw new UniversalException("startPeriod", 3, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(startPeriod).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("startPeriod", 3, UniversalException.ErrorType.NUM);
        }

        if (endPeriod == null) {
            throw new UniversalException("endPeriod", 4, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(startPeriod).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("endPeriod", 4, UniversalException.ErrorType.NUM);
        }

        if (Formulas.valueOf(startPeriod).compareTo(Formulas.valueOf(endPeriod)) > 0) {
            throw new UniversalException("startPeriod", 3, UniversalException.ErrorType.NUM);
        }

        if (timingType == null) {
            throw new UniversalException("timingType", 5, UniversalException.ErrorType.VALUE);
        } else if (timingType.intValue() < 0 || timingType.intValue() > 1) {
            throw new UniversalException("timingType", 5, UniversalException.ErrorType.NUM);
        }

        // Returns the cumulative interest paid on a loan between start_period and end_period.

        final FormulaDecimal payment = pmt(interestRate, totalNumberOfPaymentPeriods, presentValue, 0, timingType);
        FormulaDecimal interest = Formulas.valueOf(0);
        FormulaDecimal start = Formulas.valueOf(startPeriod);

        if (startPeriod.intValue() == 1 && timingType.intValue() == 1) {
            interest = Formulas.valueOf(presentValue).negate();
            start = start.add(Formulas.valueOf(1));
        }

        for (int i = start.intValue(); i <= endPeriod.intValue(); i++) {
            switch (timingType.intValue()) {
                case 0:
                    // Payment at the end of the period
                    interest = interest.add(fv(interestRate, i - 1, payment, presentValue, 0));
                    break;
                case 1:
                    // Payment at the beginning of the period
                    interest = interest.add(fv(interestRate, i - 2, payment, presentValue, 1).subtract(payment));
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        interest = interest.multiply(Formulas.valueOf(interestRate));

        return interest;
    }

    public static FormulaDecimal cumprinc(Number interestRate, Number totalNumberOfPaymentPeriods, Number presentValue, Number startPeriod, Number endPeriod, Number timingType) {
        if (interestRate == null) {
            throw new UniversalException("interestRate", 0, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(interestRate).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("interestRate", 0, UniversalException.ErrorType.NUM);
        }
        if (totalNumberOfPaymentPeriods == null) {
            throw new UniversalException("totalNumberOfPaymentPeriods", 1, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(totalNumberOfPaymentPeriods).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("totalNumberOfPaymentPeriods", 1, UniversalException.ErrorType.NUM);
        }
        if (presentValue == null) {
            throw new UniversalException("presentValue", 2, UniversalException.ErrorType.VALUE);
        }
        if (startPeriod == null) {
            throw new UniversalException("startPeriod", 3, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(startPeriod).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("startPeriod", 3, UniversalException.ErrorType.NUM);
        }

        if (endPeriod == null) {
            throw new UniversalException("endPeriod", 4, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(startPeriod).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("endPeriod", 4, UniversalException.ErrorType.NUM);
        }

        if (Formulas.valueOf(startPeriod).compareTo(Formulas.valueOf(endPeriod)) > 0) {
            throw new UniversalException("startPeriod", 3, UniversalException.ErrorType.NUM);
        }

        if (timingType == null) {
            throw new UniversalException("timingType", 5, UniversalException.ErrorType.VALUE);
        } else if (timingType.intValue() < 0 || timingType.intValue() > 1) {
            throw new UniversalException("timingType", 5, UniversalException.ErrorType.NUM);
        }


        // Returns the cumulative principal paid on a loan between start_period and end_period.

        final FormulaDecimal payment = pmt(interestRate, totalNumberOfPaymentPeriods, presentValue, 0, timingType);
        FormulaDecimal principal = Formulas.valueOf(0);
        FormulaDecimal start = Formulas.valueOf(startPeriod);

        if (startPeriod.intValue() == 1) {
            if (timingType.intValue() == 1) {
                principal = principal.add(payment.multiply(Formulas.valueOf(interestRate)));
            } else {
                principal = payment;
            }
            start = start.add(Formulas.valueOf(1));
        }

        for (int i = start.intValue(); i <= endPeriod.intValue(); i++) {
            switch (timingType.intValue()) {
                case 0:
                    // Payment at the end of the period
                    principal = principal.add(payment.subtract(fv(interestRate, i - 1, payment, presentValue, 0).multiply(Formulas.valueOf(interestRate))));
                    break;
                case 1:
                    // Payment at the beginning of the period
                    principal = principal.add(payment.subtract(fv(interestRate, i - 2, payment, presentValue, 1).subtract(payment).multiply(Formulas.valueOf(interestRate))));
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        return principal;
    }

    public static FormulaDecimal db(Number initialCost, Number salvageValue, Number life, Number period) {
        return db(initialCost, salvageValue, life, period, 12);
    }

    public static FormulaDecimal db(Number initialCost, Number salvageValue, Number life, Number period, Number month) {
        if (initialCost == null) {
            throw new UniversalException("initialCost", 0, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(initialCost).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("initialCost", 0, UniversalException.ErrorType.NUM);
        }
        if (salvageValue == null) {
            throw new UniversalException("salvageValue", 1, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(salvageValue).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("salvageValue", 1, UniversalException.ErrorType.NUM);
        }
        if (life == null) {
            throw new UniversalException("life", 2, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(life).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("life", 2, UniversalException.ErrorType.NUM);
        }
        if (period == null) {
            throw new UniversalException("period", 3, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(period).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("period", 3, UniversalException.ErrorType.NUM);
        }

        if (month == null) {
            throw new UniversalException("month", 4, UniversalException.ErrorType.VALUE);
        } else if (month.intValue() < 1 || month.intValue() > 12) {
            throw new UniversalException("month", 4, UniversalException.ErrorType.NUM);
        }

        if (Formulas.valueOf(period).compareTo(Formulas.valueOf(life)) > 0) {
            throw new UniversalException("month", 3, UniversalException.ErrorType.NUM);
        }

        // Returns the depreciation of an asset for a specified period using the fixed-declining balance method.
        if (Formulas.valueOf(salvageValue).compareTo(Formulas.valueOf(initialCost)) >= 0) {
            return Formulas.valueOf(0);
        }

        final FormulaDecimal rate = Formulas.valueOf(1).subtract(Formulas.power(Formulas.valueOf(salvageValue).divide(Formulas.valueOf(initialCost)), Formulas.valueOf(1).divide(Formulas.valueOf(life)))).setScale(3, RoundingMode.HALF_EVEN);

        final FormulaDecimal initial = Formulas.valueOf(initialCost).multiply(Formulas.valueOf(rate)).multiply(Formulas.valueOf(month)).divide(Formulas.valueOf(12));

        FormulaDecimal total = Formulas.valueOf(initial);
        FormulaDecimal current = Formulas.valueOf(0);
        FormulaDecimal ceiling = Formulas.valueOf(period).compareTo(Formulas.valueOf(life)) == 0 ? Formulas.valueOf(life).subtract(Formulas.valueOf(1)) : Formulas.valueOf(period);
        for (int i = 2; i <= ceiling.intValue(); i++) {
            current = Formulas.valueOf(initialCost).subtract(total).multiply(rate);
            total = total.add(current);
        }

        if (period.intValue() == 1) {
            return initial;
        }
        if (Formulas.valueOf(period).compareTo(Formulas.valueOf(life)) == 0) {
            return Formulas.valueOf(initialCost).subtract(total).multiply(rate);
        } else {
            return current;
        }
    }

    public static FormulaDecimal ddb(Number initialCost, Number salvageValue, Number life, Number period) {
        return ddb(initialCost, salvageValue, life, period, 2);
    }

    public static FormulaDecimal ddb(Number initialCost, Number salvageValue, Number life, Number period, Number factor) {
        if (initialCost == null) {
            throw new UniversalException("initialCost", 0, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(initialCost).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("initialCost", 0, UniversalException.ErrorType.NUM);
        }
        if (salvageValue == null) {
            throw new UniversalException("salvageValue", 1, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(salvageValue).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("salvageValue", 1, UniversalException.ErrorType.NUM);
        }
        if (life == null) {
            throw new UniversalException("life", 2, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(life).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("life", 2, UniversalException.ErrorType.NUM);
        }
        if (period == null) {
            throw new UniversalException("period", 3, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(period).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("period", 3, UniversalException.ErrorType.NUM);
        }

        if (factor == null) {
            throw new UniversalException("factor", 4, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(factor).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("factor", 4, UniversalException.ErrorType.NUM);
        }

        if (Formulas.valueOf(period).compareTo(Formulas.valueOf(life)) > 0) {
            throw new UniversalException("period", 3, UniversalException.ErrorType.NUM);
        }


        // Returns the depreciation of an asset for a specified period using the double-declining balance method or some other method you specify.
        if (Formulas.valueOf(salvageValue).compareTo(Formulas.valueOf(initialCost)) >= 0) {
            return Formulas.valueOf(0);
        }


        FormulaDecimal total = Formulas.valueOf(0);
        FormulaDecimal current = Formulas.valueOf(0);

        for (int i = 1; i <= period.intValue(); i++) {
            current = Formulas.min(Formulas.valueOf(initialCost).subtract(total).multiply(Formulas.valueOf(factor).divide(Formulas.valueOf(life))), Formulas.valueOf(initialCost).subtract(Formulas.valueOf(salvageValue).subtract(total)));
            total = total.add(current);
        }

        return current;
    }

    public static FormulaDecimal disc(Date settlementDate, Date maturityDate, Number price, Number redemption) {
        return disc(settlementDate, maturityDate, price, redemption, 0);
    }

    public static FormulaDecimal disc(CharSequence settlementDate, CharSequence maturityDate, Number price, Number redemption) {
        return disc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, 0);
    }

    public static FormulaDecimal disc(Date settlementDate, CharSequence maturityDate, Number price, Number redemption) {
        return disc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, 0);
    }

    public static FormulaDecimal disc(CharSequence settlementDate, Date maturityDate, Number price, Number redemption) {
        return disc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, 0);
    }

    public static FormulaDecimal disc(Number settlementDate, Number maturityDate, Number price, Number redemption) {
        return disc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, 0);
    }

    public static FormulaDecimal disc(Number settlementDate, CharSequence maturityDate, Number price, Number redemption) {
        return disc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, 0);
    }

    public static FormulaDecimal disc(CharSequence settlementDate, Number maturityDate, Number price, Number redemption) {
        return disc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, 0);
    }

    public static FormulaDecimal disc(Date settlementDate, Number maturityDate, Number price, Number redemption) {
        return disc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, 0);
    }

    public static FormulaDecimal disc(Number settlementDate, Date maturityDate, Number price, Number redemption) {
        return disc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, 0);
    }

    public static FormulaDecimal disc(CharSequence settlementDate, CharSequence maturityDate, Number price, Number redemption, Number basis) {
        return disc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, basis);
    }

    public static FormulaDecimal disc(Date settlementDate, CharSequence maturityDate, Number price, Number redemption, Number basis) {
        return disc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, basis);
    }

    public static FormulaDecimal disc(CharSequence settlementDate, Date maturityDate, Number price, Number redemption, Number basis) {
        return disc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, basis);
    }

    public static FormulaDecimal disc(Number settlementDate, Number maturityDate, Number price, Number redemption, Number basis) {
        return disc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, basis);
    }

    public static FormulaDecimal disc(Number settlementDate, CharSequence maturityDate, Number price, Number redemption, Number basis) {
        return disc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, basis);
    }

    public static FormulaDecimal disc(CharSequence settlementDate, Number maturityDate, Number price, Number redemption, Number basis) {
        return disc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, basis);
    }

    public static FormulaDecimal disc(Date settlementDate, Number maturityDate, Number price, Number redemption, Number basis) {
        return disc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, basis);
    }

    public static FormulaDecimal disc(Number settlementDate, Date maturityDate, Number price, Number redemption, Number basis) {
        return disc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, basis);
    }

    public static FormulaDecimal disc(Date settlementDate, Date maturityDate, Number price, Number redemption, Number basis) {
        if (settlementDate == null) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (maturityDate == null) {
            throw new UniversalException("maturityDate", 1, UniversalException.ErrorType.VALUE);
        }
        if (settlementDate.compareTo(maturityDate) >= 0) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.NUM);
        }
        if (price == null) {
            throw new UniversalException("price", 2, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(price).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("price", 2, UniversalException.ErrorType.NUM);
        }
        if (redemption == null) {
            throw new UniversalException("redemption", 3, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(redemption).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("redemption", 3, UniversalException.ErrorType.NUM);
        }
        if (basis == null) {
            throw new UniversalException("basis", 4, UniversalException.ErrorType.VALUE);
        } else if (basis.intValue() < 0 || basis.intValue() > 4) {
            throw new UniversalException("basis", 4, UniversalException.ErrorType.NUM);
        }


        // Returns the discount rate for a security.
        return Formulas.valueOf(1).subtract(Formulas.valueOf(price).divide(Formulas.valueOf(redemption))).divide(Moments.yearfrac(settlementDate, maturityDate, basis));
    }

    public static FormulaDecimal dollarde(Number fractionalDollar, Number fraction) {
        if (fractionalDollar == null) {
            throw new UniversalException("fractionalDollar", 0, UniversalException.ErrorType.VALUE);
        }
        if (fraction == null) {
            throw new UniversalException("fraction", 1, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(fraction).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("fraction", 0, UniversalException.ErrorType.NUM);
        }
        if (Formulas.valueOf(fraction).compareTo(BigDecimal.ZERO) >= 0 && Formulas.valueOf(fraction).compareTo(BigDecimal.ONE) < 0) {
            throw new UniversalException("fraction", 1, UniversalException.ErrorType.DIV_0);
        }

        // Converts a dollar price expressed as an integer part and a fraction part, such as 1.02, into a dollar price expressed as a decimal number. Fractional dollar numbers are sometimes used for security prices.

        // TODO refactor..
        final FormulaDecimal mod = Formulas.valueOf(fractionalDollar.doubleValue() % 1);
        FormulaDecimal result = Formulas.valueOf(fractionalDollar.intValue()).add(mod.multiply(Formulas.power(10, Formulas.ceil(Formulas.log(fraction).divide(Formulas.log(10)))).divide(Formulas.valueOf(fraction))));

        FormulaDecimal power = Formulas.power(10, Formulas.ceil(Formulas.log(fraction).divide(Formulas.log(2))).add(Formulas.valueOf(1)));

        return Formulas.round(result.multiply(power)).divide(power);
    }

    public static FormulaDecimal dollarfr(Number decimalDollar, Number fraction) {
        if (decimalDollar == null) {
            throw new UniversalException("decimalDollar", 0, UniversalException.ErrorType.VALUE);
        }
        if (fraction == null) {
            throw new UniversalException("fraction", 1, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(fraction).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("fraction", 0, UniversalException.ErrorType.NUM);
        }
        if (Formulas.valueOf(fraction).compareTo(BigDecimal.ZERO) >= 0 && Formulas.valueOf(fraction).compareTo(BigDecimal.ONE) < 0) {
            throw new UniversalException("fraction", 1, UniversalException.ErrorType.DIV_0);
        }

        // Use DOLLARFR to convert decimal numbers to fractional dollar numbers, such as securities prices.

        // TODO refactor..
        final FormulaDecimal mod = Formulas.valueOf(decimalDollar.doubleValue() % 1);
        FormulaDecimal result = Formulas.valueOf(decimalDollar.intValue()).add(mod.multiply(Formulas.power(10, Formulas.ceil(Formulas.log(fraction).divide(Formulas.log(10))).negate()).multiply(Formulas.valueOf(fraction))));

        return result;
    }

    public static FormulaDecimal duration(Date settlementDate, Date maturityDate, Number couponRate, Number annualYield, Number frequency) {
        return duration(settlementDate, maturityDate, couponRate, annualYield, frequency, 0);
    }

    public static FormulaDecimal duration(CharSequence settlementDate, CharSequence maturityDate, Number couponRate, Number annualYield, Number frequency) {
        return duration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), couponRate, annualYield, frequency, 0);
    }

    public static FormulaDecimal duration(Date settlementDate, CharSequence maturityDate, Number couponRate, Number annualYield, Number frequency) {
        return duration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), couponRate, annualYield, frequency, 0);
    }

    public static FormulaDecimal duration(CharSequence settlementDate, Date maturityDate, Number couponRate, Number annualYield, Number frequency) {
        return duration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), couponRate, annualYield, frequency, 0);
    }

    public static FormulaDecimal duration(Number settlementDate, Number maturityDate, Number couponRate, Number annualYield, Number frequency) {
        return duration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), couponRate, annualYield, frequency, 0);
    }

    public static FormulaDecimal duration(Number settlementDate, CharSequence maturityDate, Number couponRate, Number annualYield, Number frequency) {
        return duration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), couponRate, annualYield, frequency, 0);
    }

    public static FormulaDecimal duration(CharSequence settlementDate, Number maturityDate, Number couponRate, Number annualYield, Number frequency) {
        return duration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), couponRate, annualYield, frequency, 0);
    }

    public static FormulaDecimal duration(Date settlementDate, Number maturityDate, Number couponRate, Number annualYield, Number frequency) {
        return duration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), couponRate, annualYield, frequency, 0);
    }

    public static FormulaDecimal duration(Number settlementDate, Date maturityDate, Number couponRate, Number annualYield, Number frequency) {
        return duration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), couponRate, annualYield, frequency, 0);
    }

    public static FormulaDecimal duration(CharSequence settlementDate, CharSequence maturityDate, Number couponRate, Number annualYield, Number frequency, Number basis) {
        return duration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), couponRate, annualYield, frequency, basis);
    }

    public static FormulaDecimal duration(Date settlementDate, CharSequence maturityDate, Number couponRate, Number annualYield, Number frequency, Number basis) {
        return duration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), couponRate, annualYield, frequency, basis);
    }

    public static FormulaDecimal duration(CharSequence settlementDate, Date maturityDate, Number couponRate, Number annualYield, Number frequency, Number basis) {
        return duration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), couponRate, annualYield, frequency, basis);
    }

    public static FormulaDecimal duration(Number settlementDate, Number maturityDate, Number couponRate, Number annualYield, Number frequency, Number basis) {
        return duration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), couponRate, annualYield, frequency, basis);
    }

    public static FormulaDecimal duration(Number settlementDate, CharSequence maturityDate, Number couponRate, Number annualYield, Number frequency, Number basis) {
        return duration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), couponRate, annualYield, frequency, basis);
    }

    public static FormulaDecimal duration(CharSequence settlementDate, Number maturityDate, Number couponRate, Number annualYield, Number frequency, Number basis) {
        return duration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), couponRate, annualYield, frequency, basis);
    }

    public static FormulaDecimal duration(Date settlementDate, Number maturityDate, Number couponRate, Number annualYield, Number frequency, Number basis) {
        return duration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), couponRate, annualYield, frequency, basis);
    }

    public static FormulaDecimal duration(Number settlementDate, Date maturityDate, Number couponRate, Number annualYield, Number frequency, Number basis) {
        return duration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), couponRate, annualYield, frequency, basis);
    }

    public static FormulaDecimal duration(Date settlementDate, Date maturityDate, Number couponRate, Number annualYield, Number frequency, Number basis) {
        if (settlementDate == null) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (maturityDate == null) {
            throw new UniversalException("maturityDate", 1, UniversalException.ErrorType.VALUE);
        }
        if (settlementDate.compareTo(maturityDate) >= 0) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.NUM);
        }
        if (couponRate == null) {
            throw new UniversalException("couponRate", 2, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(couponRate).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("couponRate", 2, UniversalException.ErrorType.NUM);
        }
        if (annualYield == null) {
            throw new UniversalException("annualYield", 3, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(annualYield).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("annualYield", 3, UniversalException.ErrorType.NUM);
        }
        if (frequency == null) {
            throw new UniversalException("frequency", 4, UniversalException.ErrorType.VALUE);
        } else if (frequency.intValue() <= 0 || frequency.intValue() > 4 || frequency.intValue() == 3) {
            throw new UniversalException("frequency", 4, UniversalException.ErrorType.NUM);
        }
        if (basis == null) {
            throw new UniversalException("basis", 5, UniversalException.ErrorType.VALUE);
        } else if (basis.intValue() < 0 || basis.intValue() > 4) {
            throw new UniversalException("basis", 5, UniversalException.ErrorType.NUM);
        }

        // returns the Macauley duration for an assumed par value of $100.
        // Duration is defined as the weighted average of the present value of cash flows, and is used as a measure of a bond price's response to changes in yield.

        // @see https://github.com/apache/openoffice/blob/c014b5f2b55cff8d4b0c952d5c16d62ecde09ca1/main/scaddins/source/analysis/analysishelper.cxx#L963

        FormulaDecimal fYearfrac = Moments.yearfrac(settlementDate, maturityDate, basis);
        FormulaDecimal fNumOfCoups = coupnum(settlementDate, maturityDate, frequency, basis);
        FormulaDecimal fDur = Formulas.valueOf(0.0);
        FormulaDecimal f100 = Formulas.valueOf(100.0);
        FormulaDecimal fCoup = Formulas.valueOf(couponRate).multiply(f100.divide(Formulas.valueOf(frequency)));    // fCoup is used as cash flow
        FormulaDecimal fYield = Formulas.valueOf(annualYield).divide(Formulas.valueOf(frequency));
        fYield = fYield.add(Formulas.valueOf(1.0));

        FormulaDecimal nDiff = Formulas.valueOf(fYearfrac).multiply(Formulas.valueOf(frequency)).subtract(fNumOfCoups);

        for (int t = 1; t < fNumOfCoups.intValue(); t++) {
            fDur = fDur.add(Formulas.valueOf(t).add(nDiff).multiply(fCoup).divide(Formulas.power(fYield, Formulas.valueOf(t).add(nDiff))));
        }

        fDur = fDur.add(Formulas.valueOf(fNumOfCoups).add(Formulas.valueOf(nDiff)).multiply(Formulas.valueOf(fCoup).add(Formulas.valueOf(f100))).divide(Formulas.power(fYield, fNumOfCoups.add(nDiff))));

        FormulaDecimal p = Formulas.valueOf(0.0);
        for (int t = 1; t < fNumOfCoups.intValue(); t++) {
            p = p.add(fCoup.divide(Formulas.power(fYield, Formulas.valueOf(t).add(nDiff))));
        }

        p = p.add(fCoup.add(f100).divide(Formulas.power(fYield, fNumOfCoups.add(nDiff))));

        fDur = fDur.divide(p);
        fDur = fDur.divide(Formulas.valueOf(frequency));

        return fDur;
    }

    public static FormulaDecimal effect(Number nominalInterestRate, Number numberOfCompoundingPeriodsPerYear) {
        if (nominalInterestRate == null) {
            throw new UniversalException("nominalInterestRate", 0, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(nominalInterestRate).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("nominalInterestRate", 0, UniversalException.ErrorType.NUM);
        }
        if (numberOfCompoundingPeriodsPerYear == null) {
            throw new UniversalException("numberOfCompoundingPeriodsPerYear", 1, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(numberOfCompoundingPeriodsPerYear).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("numberOfCompoundingPeriodsPerYear", 1, UniversalException.ErrorType.NUM);
        }

        // Returns the effective annual interest rate, given the nominal annual interest rate and the number of compounding periods per year.

        return Formulas.power(Formulas.valueOf(1).add(Formulas.valueOf(nominalInterestRate).divide(Formulas.valueOf(numberOfCompoundingPeriodsPerYear.intValue()))), numberOfCompoundingPeriodsPerYear.intValue()).subtract(Formulas.valueOf(1));
    }

    public static FormulaDecimal fv(Number interestRate, Number totalNumberOfPaymentPeriodsInAnnuity, Number paymentPerPeriod) {
        return fv(interestRate, totalNumberOfPaymentPeriodsInAnnuity, paymentPerPeriod, 0, 0);
    }

    public static FormulaDecimal fv(Number interestRate, Number totalNumberOfPaymentPeriodsInAnnuity, Number paymentPerPeriod, Number presentValue) {
        return fv(interestRate, totalNumberOfPaymentPeriodsInAnnuity, paymentPerPeriod, presentValue, 0);
    }

    public static FormulaDecimal fv(Number interestRate, Number totalNumberOfPaymentPeriodsInAnnuity, Number paymentPerPeriod, Number presentValue, Number type) {
        if (interestRate == null) {
            throw new UniversalException("interestRate", 0, UniversalException.ErrorType.VALUE);
        }
        if (totalNumberOfPaymentPeriodsInAnnuity == null) {
            throw new UniversalException("totalNumberOfPaymentPeriodsInAnnuity", 1, UniversalException.ErrorType.VALUE);
        }
        if (paymentPerPeriod == null) {
            throw new UniversalException("paymentPerPeriod", 2, UniversalException.ErrorType.VALUE);
        }
        if (presentValue == null) {
            throw new UniversalException("presentValue", 3, UniversalException.ErrorType.VALUE);
        }
        if (type == null) {
            throw new UniversalException("type", 4, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(type).compareTo(BigDecimal.ZERO) < 0 || Formulas.valueOf(type).compareTo(BigDecimal.ONE) > 0) {
            throw new UniversalException("type", 4, UniversalException.ErrorType.NUM);
        }

        //  calculates the future value of an investment based on a constant interest rate. can use FV with either periodic, constant payments, or a single lump sum payment.

        final FormulaDecimal result;
        if (Formulas.valueOf(interestRate).compareTo(BigDecimal.ZERO) == 0) {
            // result = presentValue + paymentPerPeriod * totalNumberOfPaymentPeriodsInAnnuity;
            result = Formulas.valueOf(presentValue).add(Formulas.valueOf(paymentPerPeriod).multiply(Formulas.valueOf(totalNumberOfPaymentPeriodsInAnnuity)));
        } else {
            final FormulaDecimal term = Formulas.power(Formulas.valueOf(1).add(Formulas.valueOf(interestRate)), totalNumberOfPaymentPeriodsInAnnuity);
            switch (type.intValue()) {
                case 0:
                    // At the end of the period
                    // result = value * term + payment * (term - 1) / rate;
                    result = Formulas.valueOf(presentValue).multiply(term).add(Formulas.valueOf(paymentPerPeriod).multiply(term.subtract(Formulas.valueOf(1))).divide(Formulas.valueOf(interestRate)));
                    break;
                case 1:
                    // At the beginning of the period
                    // result = value * term + payment * (1 + rate) * (term - 1) / rate;
                    result = Formulas.valueOf(presentValue).multiply(term).add(Formulas.valueOf(paymentPerPeriod).multiply(Formulas.valueOf(1).add(Formulas.valueOf(interestRate))).multiply(term.subtract(Formulas.valueOf(1))).divide(Formulas.valueOf(interestRate)));
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        return result.negate();
    }

    public static FormulaDecimal fvschedule(Number principal, Number... schedule) {
        if (principal == null) {
            throw new UniversalException("principal", 0, UniversalException.ErrorType.VALUE);
        }
        if (schedule == null) {
            throw new UniversalException("schedule", 1, UniversalException.ErrorType.VALUE);
        }
        // Returns the future value of an initial principal after applying a series of compound interest rates.
        // Use FVSCHEDULE to calculate the future value of an investment with a variable or adjustable rate.

        FormulaDecimal future = Formulas.valueOf(principal);

        for (int i = 0; i < schedule.length; i++) {
            future = future.multiply(Formulas.valueOf(1).add(Formulas.valueOf(schedule[i])));
        }

        return future;
    }

    public static FormulaDecimal intrate(Date settlementDate, Date maturityDate, Number investmentAmount, Number redemptionAmount) {
        return intrate(settlementDate, maturityDate, investmentAmount, redemptionAmount, 0);
    }

    public static FormulaDecimal intrate(CharSequence settlementDate, CharSequence maturityDate, Number investmentAmount, Number redemptionAmount) {
        return intrate(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), investmentAmount, redemptionAmount, 0);
    }

    public static FormulaDecimal intrate(Date settlementDate, CharSequence maturityDate, Number investmentAmount, Number redemptionAmount) {
        return intrate(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), investmentAmount, redemptionAmount, 0);
    }

    public static FormulaDecimal intrate(CharSequence settlementDate, Date maturityDate, Number investmentAmount, Number redemptionAmount) {
        return intrate(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), investmentAmount, redemptionAmount, 0);
    }

    public static FormulaDecimal intrate(Number settlementDate, Number maturityDate, Number investmentAmount, Number redemptionAmount) {
        return intrate(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), investmentAmount, redemptionAmount, 0);
    }

    public static FormulaDecimal intrate(Number settlementDate, CharSequence maturityDate, Number investmentAmount, Number redemptionAmount) {
        return intrate(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), investmentAmount, redemptionAmount, 0);
    }

    public static FormulaDecimal intrate(CharSequence settlementDate, Number maturityDate, Number investmentAmount, Number redemptionAmount) {
        return intrate(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), investmentAmount, redemptionAmount, 0);
    }

    public static FormulaDecimal intrate(Date settlementDate, Number maturityDate, Number investmentAmount, Number redemptionAmount) {
        return intrate(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), investmentAmount, redemptionAmount, 0);
    }

    public static FormulaDecimal intrate(Number settlementDate, Date maturityDate, Number investmentAmount, Number redemptionAmount) {
        return intrate(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), investmentAmount, redemptionAmount, 0);
    }

    public static FormulaDecimal intrate(CharSequence settlementDate, CharSequence maturityDate, Number investmentAmount, Number redemptionAmount, Number basis) {
        return intrate(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), investmentAmount, redemptionAmount, basis);
    }

    public static FormulaDecimal intrate(Date settlementDate, CharSequence maturityDate, Number investmentAmount, Number redemptionAmount, Number basis) {
        return intrate(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), investmentAmount, redemptionAmount, basis);
    }

    public static FormulaDecimal intrate(CharSequence settlementDate, Date maturityDate, Number investmentAmount, Number redemptionAmount, Number basis) {
        return intrate(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), investmentAmount, redemptionAmount, basis);
    }

    public static FormulaDecimal intrate(Number settlementDate, Number maturityDate, Number investmentAmount, Number redemptionAmount, Number basis) {
        return intrate(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), investmentAmount, redemptionAmount, basis);
    }

    public static FormulaDecimal intrate(Number settlementDate, CharSequence maturityDate, Number investmentAmount, Number redemptionAmount, Number basis) {
        return intrate(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), investmentAmount, redemptionAmount, basis);
    }

    public static FormulaDecimal intrate(CharSequence settlementDate, Number maturityDate, Number investmentAmount, Number redemptionAmount, Number basis) {
        return intrate(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), investmentAmount, redemptionAmount, basis);
    }

    public static FormulaDecimal intrate(Date settlementDate, Number maturityDate, Number investmentAmount, Number redemptionAmount, Number basis) {
        return intrate(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), investmentAmount, redemptionAmount, basis);
    }

    public static FormulaDecimal intrate(Number settlementDate, Date maturityDate, Number investmentAmount, Number redemptionAmount, Number basis) {
        return intrate(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), investmentAmount, redemptionAmount, basis);
    }

    public static FormulaDecimal intrate(Date settlementDate, Date maturityDate, Number investmentAmount, Number redemptionAmount, Number basis) {
        if (settlementDate == null) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (maturityDate == null) {
            throw new UniversalException("maturityDate", 1, UniversalException.ErrorType.VALUE);
        }
        if (settlementDate.compareTo(maturityDate) >= 0) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.NUM);
        }
        if (investmentAmount == null) {
            throw new UniversalException("investmentAmount", 2, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(investmentAmount).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("investmentAmount", 2, UniversalException.ErrorType.NUM);
        }
        if (redemptionAmount == null) {
            throw new UniversalException("redemptionAmount", 3, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(redemptionAmount).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("redemptionAmount", 3, UniversalException.ErrorType.NUM);
        }
        if (basis == null) {
            throw new UniversalException("basis", 4, UniversalException.ErrorType.VALUE);
        } else if (basis.intValue() < 0 || basis.intValue() > 4) {
            throw new UniversalException("basis", 4, UniversalException.ErrorType.NUM);
        }

        // Returns the interest rate for a fully invested security.
        return Formulas.valueOf(redemptionAmount).divide(Formulas.valueOf(investmentAmount)).subtract(Formulas.valueOf(1))
                .divide(Moments.yearfrac(settlementDate, maturityDate, basis));
    }

    public static FormulaDecimal ipmt(Number interestRatePerPeriod, Number periodToFind, Number totalNumberOfPaymentPeriods, Number presentValue) {
        return ipmt(interestRatePerPeriod, periodToFind, totalNumberOfPaymentPeriods, presentValue, 0, 0);
    }

    public static FormulaDecimal ipmt(Number interestRatePerPeriod, Number periodToFind, Number totalNumberOfPaymentPeriods, Number presentValue, Number futureValue) {
        return ipmt(interestRatePerPeriod, periodToFind, totalNumberOfPaymentPeriods, presentValue, futureValue, 0);
    }

    public static FormulaDecimal ipmt(Number interestRatePerPeriod, Number periodToFind, Number totalNumberOfPaymentPeriods, Number presentValue, Number futureValue, Number type) {
        if (interestRatePerPeriod == null) {
            throw new UniversalException("interestRatePerPeriod", 0, UniversalException.ErrorType.VALUE);
        }
        if (periodToFind == null) {
            throw new UniversalException("periodToFind", 1, UniversalException.ErrorType.VALUE);
        }
        if (totalNumberOfPaymentPeriods == null) {
            throw new UniversalException("totalNumberOfPaymentPeriods", 2, UniversalException.ErrorType.VALUE);
        }
        if (presentValue == null) {
            throw new UniversalException("presentValue", 3, UniversalException.ErrorType.VALUE);
        }
        if (futureValue == null) {
            throw new UniversalException("futureValue", 4, UniversalException.ErrorType.VALUE);
        }
        if (type == null) {
            throw new UniversalException("type", 5, UniversalException.ErrorType.VALUE);
        } else if (type.intValue() < 0 || type.intValue() > 1) {
            throw new UniversalException("type", 5, UniversalException.ErrorType.NUM);
        }

        // Returns the interest payment for a given period for an investment based on periodic, constant payments and a constant interest rate.
        final FormulaDecimal payment = pmt(interestRatePerPeriod, totalNumberOfPaymentPeriods, presentValue, futureValue, type);

        FormulaDecimal interest;
        if (periodToFind.intValue() == 1) {
            if (type.intValue() == 1) {
                interest = Formulas.valueOf(0);
            } else {
                interest = Formulas.valueOf(presentValue).negate();
            }
        } else {
            if (type.intValue() == 1) {
                interest = fv(interestRatePerPeriod, periodToFind.intValue() - 2, payment, presentValue, 1).subtract(payment);
            } else {
                interest = fv(interestRatePerPeriod, periodToFind.intValue() - 1, payment, presentValue, 0);
            }
        }

        return interest.multiply(Formulas.valueOf(interestRatePerPeriod));
    }

    public static FormulaDecimal irr(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException("values", 0, UniversalException.ErrorType.VALUE);
        }

        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        if (Formulas.valueOf(array[array.length - 1]).compareTo(BigDecimal.ONE) <= 0) {
            return irr(Arrays.copyOfRange(array, 0, array.length - 1), array[array.length - 1]);
        } else {
            return irr(array, 0.1);
        }
    }

    public static FormulaDecimal irr(Number[] values, Number guess) {
        if (values == null || values.length == 0) {
            throw new UniversalException("values", 0, UniversalException.ErrorType.VALUE);
        }

        final Date[] dates = new Date[values.length];
        for (int i = 0; i < values.length; i++) {
            dates[i] = (i == 0) ? Moment.valueOf(2000, 1, 1) : Moment.valueOf(2000, 1, 1 + 365 * i);
        }

        return xirr(values, dates, guess);
    }

    public static FormulaDecimal ispmt(Number interestRate, Number periodToFind, Number totalNumberOfPaymentPeriods, Number presentValue) {
        if (interestRate == null) {
            throw new UniversalException("interestRate", 0, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(interestRate).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("interestRate", 0, UniversalException.ErrorType.NUM);
        }
        if (periodToFind == null) {
            throw new UniversalException("periodToFind", 1, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(periodToFind).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("periodToFind", 1, UniversalException.ErrorType.NUM);
        }
        if (totalNumberOfPaymentPeriods == null) {
            throw new UniversalException("totalNumberOfPaymentPeriods", 2, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(totalNumberOfPaymentPeriods).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("totalNumberOfPaymentPeriods", 2, UniversalException.ErrorType.NUM);
        }

        if (Formulas.valueOf(periodToFind).compareTo(Formulas.valueOf(totalNumberOfPaymentPeriods)) > 0) {
            throw new UniversalException("periodToFind", 1, UniversalException.ErrorType.NUM);
        }

        if (presentValue == null) {
            throw new UniversalException("presentValue", 3, UniversalException.ErrorType.VALUE);
        }

        // Calculates the interest paid during a specific period of an investment.

        return Formulas.valueOf(presentValue).multiply(Formulas.valueOf(interestRate)).multiply(Formulas.valueOf(periodToFind).divide(Formulas.valueOf(totalNumberOfPaymentPeriods)).subtract(Formulas.valueOf(1)));
    }

    public static FormulaDecimal mduration(Date settlementDate, Date maturityDate, Number annualCouponRate, Number annualYield, Number frequency) {
        return mduration(settlementDate, maturityDate, annualCouponRate, annualYield, frequency, 0);
    }

    public static FormulaDecimal mduration(CharSequence settlementDate, CharSequence maturityDate, Number annualCouponRate, Number annualYield, Number frequency) {
        return mduration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, frequency, 0);
    }

    public static FormulaDecimal mduration(Date settlementDate, CharSequence maturityDate, Number annualCouponRate, Number annualYield, Number frequency) {
        return mduration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, frequency, 0);
    }

    public static FormulaDecimal mduration(CharSequence settlementDate, Date maturityDate, Number annualCouponRate, Number annualYield, Number frequency) {
        return mduration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, frequency, 0);
    }

    public static FormulaDecimal mduration(Number settlementDate, Number maturityDate, Number annualCouponRate, Number annualYield, Number frequency) {
        return mduration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, frequency, 0);
    }

    public static FormulaDecimal mduration(Number settlementDate, CharSequence maturityDate, Number annualCouponRate, Number annualYield, Number frequency) {
        return mduration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, frequency, 0);
    }

    public static FormulaDecimal mduration(CharSequence settlementDate, Number maturityDate, Number annualCouponRate, Number annualYield, Number frequency) {
        return mduration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, frequency, 0);
    }

    public static FormulaDecimal mduration(Date settlementDate, Number maturityDate, Number annualCouponRate, Number annualYield, Number frequency) {
        return mduration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, frequency, 0);
    }

    public static FormulaDecimal mduration(Number settlementDate, Date maturityDate, Number annualCouponRate, Number annualYield, Number frequency) {
        return mduration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, frequency, 0);
    }

    public static FormulaDecimal mduration(CharSequence settlementDate, CharSequence maturityDate, Number annualCouponRate, Number annualYield, Number frequency, Number basis) {
        return mduration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, frequency, basis);
    }

    public static FormulaDecimal mduration(Date settlementDate, CharSequence maturityDate, Number annualCouponRate, Number annualYield, Number frequency, Number basis) {
        return mduration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, frequency, basis);
    }

    public static FormulaDecimal mduration(CharSequence settlementDate, Date maturityDate, Number annualCouponRate, Number annualYield, Number frequency, Number basis) {
        return mduration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, frequency, basis);
    }

    public static FormulaDecimal mduration(Number settlementDate, Number maturityDate, Number annualCouponRate, Number annualYield, Number frequency, Number basis) {
        return mduration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, frequency, basis);
    }

    public static FormulaDecimal mduration(Number settlementDate, CharSequence maturityDate, Number annualCouponRate, Number annualYield, Number frequency, Number basis) {
        return mduration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, frequency, basis);
    }

    public static FormulaDecimal mduration(CharSequence settlementDate, Number maturityDate, Number annualCouponRate, Number annualYield, Number frequency, Number basis) {
        return mduration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, frequency, basis);
    }

    public static FormulaDecimal mduration(Date settlementDate, Number maturityDate, Number annualCouponRate, Number annualYield, Number frequency, Number basis) {
        return mduration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, frequency, basis);
    }

    public static FormulaDecimal mduration(Number settlementDate, Date maturityDate, Number annualCouponRate, Number annualYield, Number frequency, Number basis) {
        return mduration(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, frequency, basis);
    }

    public static FormulaDecimal mduration(Date settlementDate, Date maturityDate, Number annualCouponRate, Number annualYield, Number frequency, Number basis) {
        if (settlementDate == null) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (maturityDate == null) {
            throw new UniversalException("maturityDate", 1, UniversalException.ErrorType.VALUE);
        }
        if (settlementDate.compareTo(maturityDate) >= 0) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.NUM);
        }
        if (annualCouponRate == null) {
            throw new UniversalException("annualCouponRate", 2, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(annualCouponRate).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("annualCouponRate", 2, UniversalException.ErrorType.NUM);
        }
        if (annualYield == null) {
            throw new UniversalException("annualYield", 3, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(annualYield).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("annualYield", 3, UniversalException.ErrorType.NUM);
        }
        if (frequency == null) {
            throw new UniversalException("frequency", 4, UniversalException.ErrorType.VALUE);
        } else if (frequency.intValue() <= 0 || frequency.intValue() > 4 || frequency.intValue() == 3) {
            throw new UniversalException("frequency", 4, UniversalException.ErrorType.NUM);
        }
        if (basis == null) {
            throw new UniversalException("basis", 5, UniversalException.ErrorType.VALUE);
        } else if (basis.intValue() < 0 || basis.intValue() > 4) {
            throw new UniversalException("basis", 5, UniversalException.ErrorType.NUM);
        }

        // @see https://github.com/apache/openoffice/blob/6bd6a4b4d1413e677a58562b60ce23f80775d22e/main/scaddins/source/analysis/financial.cxx#L248

        // Returns the modified Macauley duration for a security with an assumed par value of $100.
        FormulaDecimal fRet = duration(settlementDate, maturityDate, annualCouponRate, annualYield, frequency, basis);
        fRet = fRet.divide(Formulas.valueOf(1.0)).add(Formulas.valueOf(annualYield).divide(Formulas.valueOf(frequency)));
        return fRet;
    }

    public static FormulaDecimal mirr(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }

        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final Number[] values = Arrays.copyOfRange(array, 0, array.length - 2);
        final Number financeRate = array[array.length - 2];
        final Number reinvestRate = array[array.length - 1];

        return mirr(values, financeRate, reinvestRate);
    }

    public static FormulaDecimal mirr(Number[] values, Number financeRate, Number reinvestRate) {
        if (values == null || values.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }

        // Returns the modified internal rate of return for a series of periodic cash flows.
        // MIRR considers both the cost of the investment and the interest received on reinvestment of cash.

        final FormulaDecimal num = npv(reinvestRate, Arrays.stream(values)
                .map(Formulas::valueOf)
                .filter(decimal -> decimal.compareTo(BigDecimal.ZERO) >= 0)
                .toArray(FormulaDecimal[]::new))
                .negate()
                .multiply(Formulas.power(Formulas.valueOf(1).add(Formulas.valueOf(reinvestRate)), values.length - 1));

        final FormulaDecimal den = npv(financeRate, Arrays.stream(values)
                .map(Formulas::valueOf)
                .filter(decimal -> decimal.compareTo(BigDecimal.ZERO) < 0)
                .toArray(FormulaDecimal[]::new))
                .multiply(Formulas.valueOf(1).add(Formulas.valueOf(financeRate)));

        return Formulas.power(num.divide(den), Formulas.valueOf(1).divide(Formulas.valueOf(values.length - 1))).subtract(Formulas.valueOf(1));
    }

    public static FormulaDecimal nominal(Number effectRate, Number compoundingPeriodsPerYear) {
        if (effectRate == null) {
            throw new UniversalException("effectRate", 0, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(effectRate).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("effectRate", 0, UniversalException.ErrorType.NUM);
        }
        if (compoundingPeriodsPerYear == null) {
            throw new UniversalException("compoundingPeriodsPerYear", 1, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(compoundingPeriodsPerYear).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("compoundingPeriodsPerYear", 1, UniversalException.ErrorType.NUM);
        }

        // Returns the nominal annual interest rate, given the effective rate and the number of compounding periods per year.

        return Formulas.power(Formulas.valueOf(effectRate).add(Formulas.valueOf(1)), Formulas.valueOf(1).divide(Formulas.valueOf(compoundingPeriodsPerYear.intValue()))).subtract(Formulas.valueOf(1)).multiply(Formulas.valueOf(compoundingPeriodsPerYear.intValue()));
    }

    public static FormulaDecimal nper(Number interestRate, Number payment, Number presentValue) {
        return nper(interestRate, payment, presentValue, 0, 0);
    }

    public static FormulaDecimal nper(Number interestRate, Number payment, Number presentValue, Number futureValue) {
        return nper(interestRate, payment, presentValue, futureValue, 0);
    }

    public static FormulaDecimal nper(Number interestRate, Number payment, Number presentValue, Number futureValue, Number type) {
        if (interestRate == null) {
            throw new UniversalException("interestRate", 0, UniversalException.ErrorType.VALUE);
        }
        if (payment == null) {
            throw new UniversalException("payment", 1, UniversalException.ErrorType.VALUE);
        }
        if (presentValue == null) {
            throw new UniversalException("presentValue", 2, UniversalException.ErrorType.VALUE);
        }
        if (futureValue == null) {
            throw new UniversalException("futureValue", 3, UniversalException.ErrorType.VALUE);
        }
        if (type == null) {
            throw new UniversalException("type", 4, UniversalException.ErrorType.VALUE);
        } else if (type.intValue() < 0 || type.intValue() > 1) {
            throw new UniversalException("type", 4, UniversalException.ErrorType.NUM);
        }

        // Returns the number of periods for an investment based on periodic, constant payments and a constant interest rate.

        final FormulaDecimal num = Formulas.valueOf(payment).multiply(Formulas.valueOf(1).add(Formulas.valueOf(interestRate).multiply(Formulas.valueOf(type)))).subtract(Formulas.valueOf(futureValue).multiply(Formulas.valueOf(interestRate)));
        final FormulaDecimal den = Formulas.valueOf(presentValue).multiply(Formulas.valueOf(interestRate)).add(Formulas.valueOf(payment).multiply(Formulas.valueOf(1).add(Formulas.valueOf(interestRate).multiply(Formulas.valueOf(type)))));

        return Formulas.log(num.divide(den)).divide(Formulas.log(Formulas.valueOf(1).add(Formulas.valueOf(interestRate))));
    }

    public static FormulaDecimal npv(Number rate, Number... values) {
        if (rate == null && (values == null || values.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }

        // Calculates the net present value of an investment by using a discount rate and a series of future payments (negative values) and income (positive values).

        FormulaDecimal value = Formulas.valueOf(0);

        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                value = value.add(Formulas.valueOf(values[i]).divide(Formulas.power(Formulas.valueOf(1).add(Formulas.valueOf(rate)), i + 1)));
            }
        }

        return value;
    }

    public static FormulaDecimal oddfprice(Date settlementDate, Date maturityDate, Date issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(settlementDate, maturityDate, issueDate, firstCoupon, rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementDate, CharSequence maturityDate, CharSequence issueDate, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Date settlementDate, CharSequence maturityDate, CharSequence issueDate, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementDate, Date maturityDate, CharSequence issueDate, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementDate, CharSequence maturityDate, Date issueDate, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementDate, CharSequence maturityDate, CharSequence issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Date settlementDate, Date maturityDate, CharSequence issueDate, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementDate, Date maturityDate, Date issueDate, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementDate, CharSequence maturityDate, Date issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Date settlementDate, CharSequence maturityDate, Date issueDate, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementDate, Date maturityDate, CharSequence issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Date settlementDate, Date maturityDate, Date issueDate, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementDate, Date maturityDate, Date issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Date settlementDate, CharSequence maturityDate, Date issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Date settlementDate, Date maturityDate, CharSequence issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Number settlementNumber, Number maturityNumber, Number issueNumber, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Number settlementNumber, CharSequence maturityNumber, CharSequence issueNumber, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementNumber, Number maturityNumber, CharSequence issueNumber, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementNumber, CharSequence maturityNumber, Number issueNumber, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementNumber, CharSequence maturityNumber, CharSequence issueNumber, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Number settlementNumber, Number maturityNumber, CharSequence issueNumber, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementNumber, Number maturityNumber, Number issueNumber, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementNumber, CharSequence maturityNumber, Number issueNumber, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Number settlementNumber, CharSequence maturityNumber, Number issueNumber, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementNumber, Number maturityNumber, CharSequence issueNumber, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Number settlementNumber, Number maturityNumber, Number issueNumber, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementNumber, Number maturityNumber, Number issueNumber, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Number settlementNumber, CharSequence maturityNumber, Number issueNumber, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Number settlementNumber, Number maturityNumber, CharSequence issueNumber, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Date settlementDate, Number maturityDate, Number issueDate, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Number settlementDate, Date maturityDate, Number issueDate, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Number settlementDate, Number maturityDate, Date issueDate, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Number settlementDate, Number maturityDate, Number issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Date settlementDate, Date maturityDate, Number issueDate, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Number settlementDate, Date maturityDate, Date issueDate, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Number settlementDate, Number maturityDate, Date issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Date settlementDate, Number maturityDate, Date issueDate, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Number settlementDate, Date maturityDate, Number issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Date settlementDate, Date maturityDate, Date issueDate, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Number settlementDate, Date maturityDate, Date issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Date settlementDate, Number maturityDate, Date issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(Date settlementDate, Date maturityDate, Number issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementDate, CharSequence maturityDate, CharSequence issueDate, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Date settlementDate, CharSequence maturityDate, CharSequence issueDate, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementDate, Date maturityDate, CharSequence issueDate, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementDate, CharSequence maturityDate, Date issueDate, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementDate, CharSequence maturityDate, CharSequence issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Date settlementDate, Date maturityDate, CharSequence issueDate, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementDate, Date maturityDate, Date issueDate, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementDate, CharSequence maturityDate, Date issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Date settlementDate, CharSequence maturityDate, Date issueDate, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementDate, Date maturityDate, CharSequence issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Date settlementDate, Date maturityDate, Date issueDate, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementDate, Date maturityDate, Date issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Date settlementDate, CharSequence maturityDate, Date issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Date settlementDate, Date maturityDate, CharSequence issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Number settlementNumber, Number maturityNumber, Number issueNumber, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Number settlementNumber, CharSequence maturityNumber, CharSequence issueNumber, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementNumber, Number maturityNumber, CharSequence issueNumber, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementNumber, CharSequence maturityNumber, Number issueNumber, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementNumber, CharSequence maturityNumber, CharSequence issueNumber, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Number settlementNumber, Number maturityNumber, CharSequence issueNumber, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementNumber, Number maturityNumber, Number issueNumber, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementNumber, CharSequence maturityNumber, Number issueNumber, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Number settlementNumber, CharSequence maturityNumber, Number issueNumber, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementNumber, Number maturityNumber, CharSequence issueNumber, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Number settlementNumber, Number maturityNumber, Number issueNumber, CharSequence firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(CharSequence settlementNumber, Number maturityNumber, Number issueNumber, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Number settlementNumber, CharSequence maturityNumber, Number issueNumber, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Number settlementNumber, Number maturityNumber, CharSequence issueNumber, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Date settlementDate, Number maturityDate, Number issueDate, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Number settlementDate, Date maturityDate, Number issueDate, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Number settlementDate, Number maturityDate, Date issueDate, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Number settlementDate, Number maturityDate, Number issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Date settlementDate, Date maturityDate, Number issueDate, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Number settlementDate, Date maturityDate, Date issueDate, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Number settlementDate, Number maturityDate, Date issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Date settlementDate, Number maturityDate, Date issueDate, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Number settlementDate, Date maturityDate, Number issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Date settlementDate, Date maturityDate, Date issueDate, Number firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Number settlementDate, Date maturityDate, Date issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Date settlementDate, Number maturityDate, Date issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Date settlementDate, Date maturityDate, Number issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddfprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfprice(Date settlementDate, Date maturityDate, Date issueDate, Date firstCoupon, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        // Returns the price per $100 face value of a security having an odd (short or long) first period.
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal oddfyield(Date settlementDate, Date maturityDate, Date issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(settlementDate, maturityDate, issueDate, firstCoupon, rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementDate, CharSequence maturityDate, CharSequence issueDate, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Date settlementDate, CharSequence maturityDate, CharSequence issueDate, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementDate, Date maturityDate, CharSequence issueDate, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementDate, CharSequence maturityDate, Date issueDate, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementDate, CharSequence maturityDate, CharSequence issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Date settlementDate, Date maturityDate, CharSequence issueDate, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementDate, Date maturityDate, Date issueDate, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementDate, CharSequence maturityDate, Date issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Date settlementDate, CharSequence maturityDate, Date issueDate, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementDate, Date maturityDate, CharSequence issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Date settlementDate, Date maturityDate, Date issueDate, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementDate, Date maturityDate, Date issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Date settlementDate, CharSequence maturityDate, Date issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Date settlementDate, Date maturityDate, CharSequence issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Number settlementNumber, Number maturityNumber, Number issueNumber, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Number settlementNumber, CharSequence maturityNumber, CharSequence issueNumber, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementNumber, Number maturityNumber, CharSequence issueNumber, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementNumber, CharSequence maturityNumber, Number issueNumber, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementNumber, CharSequence maturityNumber, CharSequence issueNumber, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Number settlementNumber, Number maturityNumber, CharSequence issueNumber, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementNumber, Number maturityNumber, Number issueNumber, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementNumber, CharSequence maturityNumber, Number issueNumber, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Number settlementNumber, CharSequence maturityNumber, Number issueNumber, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementNumber, Number maturityNumber, CharSequence issueNumber, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Number settlementNumber, Number maturityNumber, Number issueNumber, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementNumber, Number maturityNumber, Number issueNumber, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Number settlementNumber, CharSequence maturityNumber, Number issueNumber, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Number settlementNumber, Number maturityNumber, CharSequence issueNumber, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Date settlementDate, Number maturityDate, Number issueDate, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Number settlementDate, Date maturityDate, Number issueDate, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Number settlementDate, Number maturityDate, Date issueDate, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Number settlementDate, Number maturityDate, Number issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Date settlementDate, Date maturityDate, Number issueDate, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Number settlementDate, Date maturityDate, Date issueDate, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Number settlementDate, Number maturityDate, Date issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Date settlementDate, Number maturityDate, Date issueDate, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Number settlementDate, Date maturityDate, Number issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Date settlementDate, Date maturityDate, Date issueDate, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Number settlementDate, Date maturityDate, Date issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Date settlementDate, Number maturityDate, Date issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(Date settlementDate, Date maturityDate, Number issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementDate, CharSequence maturityDate, CharSequence issueDate, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Date settlementDate, CharSequence maturityDate, CharSequence issueDate, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementDate, Date maturityDate, CharSequence issueDate, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementDate, CharSequence maturityDate, Date issueDate, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementDate, CharSequence maturityDate, CharSequence issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Date settlementDate, Date maturityDate, CharSequence issueDate, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementDate, Date maturityDate, Date issueDate, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementDate, CharSequence maturityDate, Date issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Date settlementDate, CharSequence maturityDate, Date issueDate, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementDate, Date maturityDate, CharSequence issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Date settlementDate, Date maturityDate, Date issueDate, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementDate, Date maturityDate, Date issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Date settlementDate, CharSequence maturityDate, Date issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Date settlementDate, Date maturityDate, CharSequence issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Number settlementNumber, Number maturityNumber, Number issueNumber, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Number settlementNumber, CharSequence maturityNumber, CharSequence issueNumber, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementNumber, Number maturityNumber, CharSequence issueNumber, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementNumber, CharSequence maturityNumber, Number issueNumber, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementNumber, CharSequence maturityNumber, CharSequence issueNumber, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Number settlementNumber, Number maturityNumber, CharSequence issueNumber, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementNumber, Number maturityNumber, Number issueNumber, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementNumber, CharSequence maturityNumber, Number issueNumber, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Number settlementNumber, CharSequence maturityNumber, Number issueNumber, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementNumber, Number maturityNumber, CharSequence issueNumber, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Number settlementNumber, Number maturityNumber, Number issueNumber, CharSequence firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(CharSequence settlementNumber, Number maturityNumber, Number issueNumber, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Number settlementNumber, CharSequence maturityNumber, Number issueNumber, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Number settlementNumber, Number maturityNumber, CharSequence issueNumber, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Date settlementDate, Number maturityDate, Number issueDate, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Number settlementDate, Date maturityDate, Number issueDate, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Number settlementDate, Number maturityDate, Date issueDate, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Number settlementDate, Number maturityDate, Number issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Date settlementDate, Date maturityDate, Number issueDate, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Number settlementDate, Date maturityDate, Date issueDate, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Number settlementDate, Number maturityDate, Date issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Date settlementDate, Number maturityDate, Date issueDate, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Number settlementDate, Date maturityDate, Number issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Date settlementDate, Date maturityDate, Date issueDate, Number firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Number settlementDate, Date maturityDate, Date issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Date settlementDate, Number maturityDate, Date issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Date settlementDate, Date maturityDate, Number issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddfyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), Moments.valueOf(firstCoupon), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddfyield(Date settlementDate, Date maturityDate, Date issueDate, Date firstCoupon, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        // Returns the yield of a security that has an odd (short or long) first period.
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal oddlprice(Date settlementDate, Date maturityDate, Date lastInterest, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddlprice(settlementDate, maturityDate, lastInterest, rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlprice(CharSequence settlementDate, CharSequence maturityDate, CharSequence lastInterest, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlprice(Date settlementDate, CharSequence maturityDate, CharSequence lastInterest, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlprice(CharSequence settlementDate, Date maturityDate, CharSequence lastInterest, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlprice(CharSequence settlementDate, CharSequence maturityDate, Date lastInterest, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlprice(Date settlementDate, Date maturityDate, CharSequence lastInterest, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlprice(CharSequence settlementDate, Date maturityDate, Date lastInterest, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlprice(Date settlementDate, CharSequence maturityDate, Date lastInterest, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlprice(Number settlementDate, Number maturityDate, Number lastInterest, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlprice(Number settlementDate, CharSequence maturityDate, CharSequence lastInterest, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlprice(CharSequence settlementDate, Number maturityDate, CharSequence lastInterest, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlprice(CharSequence settlementDate, CharSequence maturityDate, Number lastInterest, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlprice(Number settlementDate, Number maturityDate, CharSequence lastInterest, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlprice(CharSequence settlementDate, Number maturityDate, Number lastInterest, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlprice(Date settlementDate, Number maturityDate, Number lastInterest, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlprice(Number settlementDate, Date maturityDate, Number lastInterest, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlprice(Number settlementDate, Number maturityDate, Date lastInterest, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlprice(Date settlementDate, Date maturityDate, Number lastInterest, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlprice(Number settlementDate, Date maturityDate, Date lastInterest, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlprice(Date settlementDate, Number maturityDate, Date lastInterest, Number rate, Number annualYield, Number redemption, Number frequency) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlprice(CharSequence settlementDate, CharSequence maturityDate, CharSequence lastInterest, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlprice(Date settlementDate, CharSequence maturityDate, CharSequence lastInterest, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlprice(CharSequence settlementDate, Date maturityDate, CharSequence lastInterest, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlprice(CharSequence settlementDate, CharSequence maturityDate, Date lastInterest, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlprice(Date settlementDate, Date maturityDate, CharSequence lastInterest, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlprice(CharSequence settlementDate, Date maturityDate, Date lastInterest, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlprice(Date settlementDate, CharSequence maturityDate, Date lastInterest, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlprice(Number settlementDate, Number maturityDate, Number lastInterest, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlprice(Number settlementDate, CharSequence maturityDate, CharSequence lastInterest, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlprice(CharSequence settlementDate, Number maturityDate, CharSequence lastInterest, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlprice(CharSequence settlementDate, CharSequence maturityDate, Number lastInterest, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlprice(Number settlementDate, Number maturityDate, CharSequence lastInterest, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlprice(CharSequence settlementDate, Number maturityDate, Number lastInterest, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlprice(Date settlementDate, Number maturityDate, Number lastInterest, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlprice(Number settlementDate, Date maturityDate, Number lastInterest, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlprice(Number settlementDate, Number maturityDate, Date lastInterest, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlprice(Date settlementDate, Date maturityDate, Number lastInterest, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlprice(Number settlementDate, Date maturityDate, Date lastInterest, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlprice(Date settlementDate, Number maturityDate, Date lastInterest, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return oddlprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlprice(Date settlementDate, Date maturityDate, Date lastInterest, Number rate, Number annualYield, Number redemption, Number frequency, Number basis) {
        if (settlementDate == null) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (maturityDate == null) {
            throw new UniversalException("maturityDate", 1, UniversalException.ErrorType.VALUE);
        }
        if (lastInterest == null) {
            throw new UniversalException("lastInterest", 2, UniversalException.ErrorType.VALUE);
        }
        if (settlementDate.compareTo(maturityDate) >= 0) {
            throw new UniversalException("maturityDate", 1, UniversalException.ErrorType.NUM);
        }
        if (lastInterest.compareTo(settlementDate) >= 0) {
            throw new UniversalException("lastInterest", 2, UniversalException.ErrorType.NUM);
        }
        if (rate == null) {
            throw new UniversalException("rate", 3, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(rate).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("rate", 3, UniversalException.ErrorType.NUM);
        }
        if (annualYield == null) {
            throw new UniversalException("annualYield", 4, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(annualYield).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("annualYield", 4, UniversalException.ErrorType.NUM);
        }
        if (redemption == null) {
            throw new UniversalException("redemption", 5, UniversalException.ErrorType.VALUE);
        }
        if (frequency == null) {
            throw new UniversalException("frequency", 6, UniversalException.ErrorType.VALUE);
        } else if (frequency.intValue() <= 0 || frequency.intValue() > 4 || frequency.intValue() == 3) {
            throw new UniversalException("frequency", 6, UniversalException.ErrorType.NUM);
        }
        if (basis == null) {
            throw new UniversalException("basis", 7, UniversalException.ErrorType.VALUE);
        } else if (basis.intValue() < 0 || basis.intValue() > 4) {
            throw new UniversalException("basis", 7, UniversalException.ErrorType.NUM);
        }

        // Returns the price per $100 face value of a security having an odd (short or long) last coupon period.

        double fFreq = frequency.doubleValue();
        double fDCi = Moments.yearfrac(lastInterest, maturityDate).doubleValue() * fFreq;
        double fDSCi = Moments.yearfrac(settlementDate, maturityDate).doubleValue() * fFreq;
        double fAi = Moments.yearfrac(lastInterest, settlementDate).doubleValue() * fFreq;

        double p = redemption.doubleValue() + fDCi * 100.0 * rate.doubleValue() / fFreq;
        p /= fDSCi * annualYield.doubleValue() / fFreq + 1.0;
        p -= fAi * 100.0 * rate.doubleValue() / fFreq;

        return Formulas.valueOf(p);
    }

    public static FormulaDecimal oddlyield(Date settlementDate, Date maturityDate, Date lastInterest, Number rate, Number price, Number redemption, Number frequency) {
        return oddlyield(settlementDate, maturityDate, lastInterest, rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlyield(CharSequence settlementDate, CharSequence maturityDate, CharSequence lastInterest, Number rate, Number price, Number redemption, Number frequency) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlyield(Date settlementDate, CharSequence maturityDate, CharSequence lastInterest, Number rate, Number price, Number redemption, Number frequency) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlyield(CharSequence settlementDate, Date maturityDate, CharSequence lastInterest, Number rate, Number price, Number redemption, Number frequency) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlyield(CharSequence settlementDate, CharSequence maturityDate, Date lastInterest, Number rate, Number price, Number redemption, Number frequency) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlyield(Date settlementDate, Date maturityDate, CharSequence lastInterest, Number rate, Number price, Number redemption, Number frequency) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlyield(CharSequence settlementDate, Date maturityDate, Date lastInterest, Number rate, Number price, Number redemption, Number frequency) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlyield(Date settlementDate, CharSequence maturityDate, Date lastInterest, Number rate, Number price, Number redemption, Number frequency) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlyield(Number settlementDate, Number maturityDate, Number lastInterest, Number rate, Number price, Number redemption, Number frequency) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlyield(Number settlementDate, CharSequence maturityDate, CharSequence lastInterest, Number rate, Number price, Number redemption, Number frequency) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlyield(CharSequence settlementDate, Number maturityDate, CharSequence lastInterest, Number rate, Number price, Number redemption, Number frequency) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlyield(CharSequence settlementDate, CharSequence maturityDate, Number lastInterest, Number rate, Number price, Number redemption, Number frequency) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlyield(Number settlementDate, Number maturityDate, CharSequence lastInterest, Number rate, Number price, Number redemption, Number frequency) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlyield(CharSequence settlementDate, Number maturityDate, Number lastInterest, Number rate, Number price, Number redemption, Number frequency) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlyield(Date settlementDate, Number maturityDate, Number lastInterest, Number rate, Number price, Number redemption, Number frequency) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlyield(Number settlementDate, Date maturityDate, Number lastInterest, Number rate, Number price, Number redemption, Number frequency) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlyield(Number settlementDate, Number maturityDate, Date lastInterest, Number rate, Number price, Number redemption, Number frequency) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlyield(Date settlementDate, Date maturityDate, Number lastInterest, Number rate, Number price, Number redemption, Number frequency) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlyield(Number settlementDate, Date maturityDate, Date lastInterest, Number rate, Number price, Number redemption, Number frequency) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlyield(Date settlementDate, Number maturityDate, Date lastInterest, Number rate, Number price, Number redemption, Number frequency) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal oddlyield(CharSequence settlementDate, CharSequence maturityDate, CharSequence lastInterest, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlyield(Date settlementDate, CharSequence maturityDate, CharSequence lastInterest, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlyield(CharSequence settlementDate, Date maturityDate, CharSequence lastInterest, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlyield(CharSequence settlementDate, CharSequence maturityDate, Date lastInterest, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlyield(Date settlementDate, Date maturityDate, CharSequence lastInterest, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlyield(CharSequence settlementDate, Date maturityDate, Date lastInterest, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlyield(Date settlementDate, CharSequence maturityDate, Date lastInterest, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlyield(Number settlementDate, Number maturityDate, Number lastInterest, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlyield(Number settlementDate, CharSequence maturityDate, CharSequence lastInterest, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlyield(CharSequence settlementDate, Number maturityDate, CharSequence lastInterest, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlyield(CharSequence settlementDate, CharSequence maturityDate, Number lastInterest, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlyield(Number settlementDate, Number maturityDate, CharSequence lastInterest, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlyield(CharSequence settlementDate, Number maturityDate, Number lastInterest, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlyield(Date settlementDate, Number maturityDate, Number lastInterest, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlyield(Number settlementDate, Date maturityDate, Number lastInterest, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlyield(Number settlementDate, Number maturityDate, Date lastInterest, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlyield(Date settlementDate, Date maturityDate, Number lastInterest, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlyield(Number settlementDate, Date maturityDate, Date lastInterest, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlyield(Date settlementDate, Number maturityDate, Date lastInterest, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        return oddlyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(lastInterest), rate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal oddlyield(Date settlementDate, Date maturityDate, Date lastInterest, Number rate, Number price, Number redemption, Number frequency, Number basis) {
        if (settlementDate == null) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (maturityDate == null) {
            throw new UniversalException("maturityDate", 1, UniversalException.ErrorType.VALUE);
        }
        if (lastInterest == null) {
            throw new UniversalException("lastInterest", 2, UniversalException.ErrorType.VALUE);
        }
        if (settlementDate.compareTo(maturityDate) >= 0) {
            throw new UniversalException("maturityDate", 1, UniversalException.ErrorType.NUM);
        }
        if (lastInterest.compareTo(settlementDate) >= 0) {
            throw new UniversalException("lastInterest", 2, UniversalException.ErrorType.NUM);
        }
        if (rate == null) {
            throw new UniversalException("rate", 3, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(rate).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("rate", 3, UniversalException.ErrorType.NUM);
        }
        if (price == null) {
            throw new UniversalException("price", 4, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(price).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("price", 4, UniversalException.ErrorType.NUM);
        }
        if (redemption == null) {
            throw new UniversalException("redemption", 5, UniversalException.ErrorType.VALUE);
        }
        if (frequency == null) {
            throw new UniversalException("frequency", 6, UniversalException.ErrorType.VALUE);
        } else if (frequency.intValue() <= 0 || frequency.intValue() > 4 || frequency.intValue() == 3) {
            throw new UniversalException("frequency", 6, UniversalException.ErrorType.NUM);
        }
        if (basis == null) {
            throw new UniversalException("basis", 7, UniversalException.ErrorType.VALUE);
        } else if (basis.intValue() < 0 || basis.intValue() > 4) {
            throw new UniversalException("basis", 7, UniversalException.ErrorType.NUM);
        }

        // Returns the yield of a security that has an odd (short or long) last period.

        double fFreq = frequency.doubleValue();
        double fDCi = Moments.yearfrac(lastInterest, maturityDate).doubleValue() * fFreq;
        double fDSCi = Moments.yearfrac(settlementDate, maturityDate).doubleValue() * fFreq;
        double fAi = Moments.yearfrac(lastInterest, settlementDate).doubleValue() * fFreq;

        double y = redemption.doubleValue() + fDCi * 100.0 * rate.doubleValue() / fFreq;
        y /= price.doubleValue() + fAi * 100.0 * rate.doubleValue() / fFreq;
        y--;
        y *= fFreq / fDSCi;

        return Formulas.valueOf(y);
    }

    public static FormulaDecimal pduration(Number interestRatePerPeriod, Number presentValue, Number desiredFutureValue) {
        if (interestRatePerPeriod == null) {
            throw new UniversalException("interestRatePerPeriod", 0, UniversalException.ErrorType.VALUE);
        }
        if (presentValue == null) {
            throw new UniversalException("presentValue", 1, UniversalException.ErrorType.VALUE);
        }
        if (desiredFutureValue == null) {
            throw new UniversalException("desiredFutureValue", 2, UniversalException.ErrorType.VALUE);
        }

        // Returns the number of periods required by an investment to reach a specified value.
        return Formulas.log(desiredFutureValue).subtract(Formulas.log(presentValue)).divide(Formulas.log(Formulas.valueOf(1).add(Formulas.valueOf(interestRatePerPeriod))));
    }

    public static FormulaDecimal pmt(Number interestRate, Number numberOfPayments, Number presentValue) {
        return pmt(interestRate, numberOfPayments, presentValue, 0, 0);
    }

    public static FormulaDecimal pmt(Number interestRate, Number numberOfPayments, Number presentValue, Number futureValue) {
        return pmt(interestRate, numberOfPayments, presentValue, futureValue, 0);
    }

    public static FormulaDecimal pmt(Number interestRate, Number numberOfPayments, Number presentValue, Number futureValue, Number type) {
        if (interestRate == null) {
            throw new UniversalException("interestRate", 0, UniversalException.ErrorType.VALUE);
        }
        if (numberOfPayments == null) {
            throw new UniversalException("numberOfPayments", 1, UniversalException.ErrorType.VALUE);
        }
        if (presentValue == null) {
            throw new UniversalException("presentValue", 2, UniversalException.ErrorType.VALUE);
        }
        if (futureValue == null) {
            throw new UniversalException("futureValue", 3, UniversalException.ErrorType.VALUE);
        }
        if (type == null) {
            throw new UniversalException("type", 4, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(type).compareTo(BigDecimal.ZERO) < 0 || Formulas.valueOf(type).compareTo(BigDecimal.ONE) > 0) {
            throw new UniversalException("type", 4, UniversalException.ErrorType.NUM);
        }

        // calculates the payment for a loan based on constant payments and a constant interest rate.

        final FormulaDecimal result;
        if (Formulas.valueOf(interestRate).compareTo(BigDecimal.ZERO) == 0) {
            // result = (present + future) / periods;
            result = Formulas.valueOf(presentValue).add(Formulas.valueOf(futureValue)).divide(Formulas.valueOf(numberOfPayments));
        } else {
            final FormulaDecimal term = Formulas.power(Formulas.valueOf(1).add(Formulas.valueOf(interestRate)), numberOfPayments);
            switch (type.intValue()) {
                case 0:
                    // At the end of the period
                    // result = future * rate / (term - 1) + present * rate / (1 - 1 / term);
                    result = Formulas.valueOf(futureValue.doubleValue() * interestRate.doubleValue() / (term.doubleValue() - 1) + presentValue.doubleValue() * interestRate.doubleValue() / (1 - 1 / term.doubleValue()));
//                    result = Formulas.valueOf(futureValue).multiply(Formulas.valueOf(interestRate)).divide(term.subtract(Formulas.valueOf(1))).add(Formulas.valueOf(presentValue).multiply(Formulas.valueOf(interestRate).divide(Formulas.valueOf(1).subtract(Formulas.valueOf(1).divide(term)))));
                    break;
                case 1:
                    // At the beginning of the period
                    // result = (future * rate / (term - 1) + present * rate / (1 - 1 / term)) / (1 + rate);
                    result = Formulas.valueOf(futureValue).multiply(Formulas.valueOf(interestRate)).divide(term.subtract(Formulas.valueOf(1))).add(Formulas.valueOf(presentValue).multiply(Formulas.valueOf(interestRate).divide(Formulas.valueOf(1).subtract(Formulas.valueOf(1).divide(term)))))
                            .divide(Formulas.valueOf(1).add(Formulas.valueOf(interestRate)));
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        return result.negate();
    }

    public static FormulaDecimal ppmt(Number interestRate, Number period, Number numberOfPayments, Number presentValue) {
        return ppmt(interestRate, period, numberOfPayments, presentValue, 0, 0);
    }

    public static FormulaDecimal ppmt(Number interestRate, Number period, Number numberOfPayments, Number presentValue, Number futureValue) {
        return ppmt(interestRate, period, numberOfPayments, presentValue, presentValue, 0);
    }

    public static FormulaDecimal ppmt(Number interestRate, Number period, Number numberOfPayments, Number presentValue, Number futureValue, Number type) {
        if (interestRate == null) {
            throw new UniversalException("interestRate", 0, UniversalException.ErrorType.VALUE);
        }
        if (period == null) {
            throw new UniversalException("period", 1, UniversalException.ErrorType.VALUE);
        }
        if (numberOfPayments == null) {
            throw new UniversalException("numberOfPayments", 2, UniversalException.ErrorType.VALUE);
        }
        if (presentValue == null) {
            throw new UniversalException("presentValue", 3, UniversalException.ErrorType.VALUE);
        }
        if (futureValue == null) {
            throw new UniversalException("futureValue", 4, UniversalException.ErrorType.VALUE);
        }
        if (type == null) {
            throw new UniversalException("type", 5, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(type).compareTo(BigDecimal.ZERO) < 0 || Formulas.valueOf(type).compareTo(BigDecimal.ONE) > 0) {
            throw new UniversalException("type", 5, UniversalException.ErrorType.NUM);
        }

        // Returns the payment on the principal for a given period for an investment based on periodic, constant payments and a constant interest rate.

        return pmt(interestRate, numberOfPayments, presentValue, futureValue, type).subtract(ipmt(interestRate, period, numberOfPayments, presentValue, futureValue, type));
    }

    public static FormulaDecimal price(Date settlementDate, Date maturityDate, Number annualCouponRate, Number annualYield, Number redemption, Number frequency) {
        return price(settlementDate, maturityDate, annualCouponRate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal price(Date settlementDate, CharSequence maturityDate, Number annualCouponRate, Number annualYield, Number redemption, Number frequency) {
        return price(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal price(CharSequence settlementDate, Date maturityDate, Number annualCouponRate, Number annualYield, Number redemption, Number frequency) {
        return price(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal price(Number settlementDate, Number maturityDate, Number annualCouponRate, Number annualYield, Number redemption, Number frequency) {
        return price(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal price(Number settlementDate, CharSequence maturityDate, Number annualCouponRate, Number annualYield, Number redemption, Number frequency) {
        return price(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal price(CharSequence settlementDate, Number maturityDate, Number annualCouponRate, Number annualYield, Number redemption, Number frequency) {
        return price(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal price(Date settlementDate, Number maturityDate, Number annualCouponRate, Number annualYield, Number redemption, Number frequency) {
        return price(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal price(Number settlementDate, Date maturityDate, Number annualCouponRate, Number annualYield, Number redemption, Number frequency) {
        return price(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, redemption, frequency, 0);
    }

    public static FormulaDecimal price(Date settlementDate, CharSequence maturityDate, Number annualCouponRate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return price(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal price(CharSequence settlementDate, Date maturityDate, Number annualCouponRate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return price(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal price(Number settlementDate, Number maturityDate, Number annualCouponRate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return price(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal price(Number settlementDate, CharSequence maturityDate, Number annualCouponRate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return price(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal price(CharSequence settlementDate, Number maturityDate, Number annualCouponRate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return price(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal price(Date settlementDate, Number maturityDate, Number annualCouponRate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return price(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal price(Number settlementDate, Date maturityDate, Number annualCouponRate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return price(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal price(CharSequence settlementDate, CharSequence maturityDate, Number annualCouponRate, Number annualYield, Number redemption, Number frequency, Number basis) {
        return price(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, annualYield, redemption, frequency, basis);
    }

    public static FormulaDecimal price(Date settlementDate, Date maturityDate, Number annualCouponRate, Number annualYield, Number redemption, Number frequency, Number basis) {
        if (settlementDate == null) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (maturityDate == null) {
            throw new UniversalException("maturityDate", 1, UniversalException.ErrorType.VALUE);
        }
        if (settlementDate.compareTo(maturityDate) >= 0) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.NUM);
        }
        if (annualCouponRate == null) {
            throw new UniversalException("annualCouponRate", 2, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(annualCouponRate).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("annualCouponRate", 2, UniversalException.ErrorType.NUM);
        }
        if (annualYield == null) {
            throw new UniversalException("annualYield", 3, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(annualYield).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("annualYield", 3, UniversalException.ErrorType.NUM);
        }
        if (redemption == null) {
            throw new UniversalException("redemption", 4, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(redemption).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("redemption", 4, UniversalException.ErrorType.NUM);
        }
        if (frequency == null) {
            throw new UniversalException("frequency", 5, UniversalException.ErrorType.VALUE);
        } else if (frequency.intValue() <= 0 || frequency.intValue() > 4 || frequency.intValue() == 3) {
            throw new UniversalException("frequency", 5, UniversalException.ErrorType.NUM);
        }
        if (basis == null) {
            throw new UniversalException("basis", 6, UniversalException.ErrorType.VALUE);
        } else if (basis.intValue() < 0 || basis.intValue() > 4) {
            throw new UniversalException("basis", 6, UniversalException.ErrorType.NUM);
        }

        // @see https://github.com/apache/openoffice/blob/c014b5f2b55cff8d4b0c952d5c16d62ecde09ca1/main/scaddins/source/analysis/analysishelper.cxx#L1137
        // Returns the price per $100 face value of a security that pays periodic interest.
        FormulaDecimal fFreq = Formulas.valueOf(frequency);

        FormulaDecimal fE = coupdays(settlementDate, maturityDate, frequency, basis);
        FormulaDecimal fDSC_E = coupdaysnc(settlementDate, maturityDate, frequency, basis).divide(fE);
        FormulaDecimal fN = coupnum(settlementDate, maturityDate, frequency, basis);
        FormulaDecimal fA = coupdaybs(settlementDate, maturityDate, frequency, basis);

        FormulaDecimal fRet = Formulas.valueOf(redemption).divide(Formulas.power(Formulas.valueOf(1.0).add(Formulas.valueOf(annualYield).divide(fFreq)), Formulas.valueOf(fN).subtract(Formulas.valueOf(1.0)).add(fDSC_E)));
        fRet = fRet.subtract(Formulas.valueOf(100.0).multiply(Formulas.valueOf(annualCouponRate)).divide(fFreq).multiply(fA).divide(fE));

        FormulaDecimal fT1 = Formulas.valueOf(100.0).multiply(Formulas.valueOf(annualCouponRate)).divide(fFreq);
        FormulaDecimal fT2 = Formulas.valueOf(1.0).add(Formulas.valueOf(annualYield).divide(fFreq));

        for (int fK = 0; fK < fN.intValue(); fK++) {
            fRet = fRet.add(fT1.divide(Formulas.power(fT2, Formulas.valueOf(fK).add(fDSC_E))));
        }

        return Formulas.valueOf(fRet);
    }

    public static FormulaDecimal pricedisc(Date settlementDate, Date maturityDate, Number discount, Number redemption) {
        return pricedisc(settlementDate, maturityDate, discount, redemption, 0);
    }

    public static FormulaDecimal pricedisc(CharSequence settlementDate, CharSequence maturityDate, Number discount, Number redemption) {
        return pricedisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount, redemption, 0);
    }

    public static FormulaDecimal pricedisc(Date settlementDate, CharSequence maturityDate, Number discount, Number redemption) {
        return pricedisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount, redemption, 0);
    }

    public static FormulaDecimal pricedisc(CharSequence settlementDate, Date maturityDate, Number discount, Number redemption) {
        return pricedisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount, redemption, 0);
    }

    public static FormulaDecimal pricedisc(Number settlementDate, Number maturityDate, Number discount, Number redemption) {
        return pricedisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount, redemption, 0);
    }

    public static FormulaDecimal pricedisc(Number settlementDate, CharSequence maturityDate, Number discount, Number redemption) {
        return pricedisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount, redemption, 0);
    }

    public static FormulaDecimal pricedisc(CharSequence settlementDate, Number maturityDate, Number discount, Number redemption) {
        return pricedisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount, redemption, 0);
    }

    public static FormulaDecimal pricedisc(Date settlementDate, Number maturityDate, Number discount, Number redemption) {
        return pricedisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount, redemption, 0);
    }

    public static FormulaDecimal pricedisc(Number settlementDate, Date maturityDate, Number discount, Number redemption) {
        return pricedisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount, redemption, 0);
    }

    public static FormulaDecimal pricedisc(CharSequence settlementDate, CharSequence maturityDate, Number discount, Number redemption, Number basis) {
        return pricedisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount, redemption, basis);
    }

    public static FormulaDecimal pricedisc(Date settlementDate, CharSequence maturityDate, Number discount, Number redemption, Number basis) {
        return pricedisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount, redemption, basis);
    }

    public static FormulaDecimal pricedisc(CharSequence settlementDate, Date maturityDate, Number discount, Number redemption, Number basis) {
        return pricedisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount, redemption, basis);
    }

    public static FormulaDecimal pricedisc(Number settlementDate, Number maturityDate, Number discount, Number redemption, Number basis) {
        return pricedisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount, redemption, basis);
    }

    public static FormulaDecimal pricedisc(Number settlementDate, CharSequence maturityDate, Number discount, Number redemption, Number basis) {
        return pricedisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount, redemption, basis);
    }

    public static FormulaDecimal pricedisc(CharSequence settlementDate, Number maturityDate, Number discount, Number redemption, Number basis) {
        return pricedisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount, redemption, basis);
    }

    public static FormulaDecimal pricedisc(Date settlementDate, Number maturityDate, Number discount, Number redemption, Number basis) {
        return pricedisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount, redemption, basis);
    }

    public static FormulaDecimal pricedisc(Number settlementDate, Date maturityDate, Number discount, Number redemption, Number basis) {
        return pricedisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount, redemption, basis);
    }

    public static FormulaDecimal pricedisc(Date settlementDate, Date maturityDate, Number discount, Number redemption, Number basis) {
        if (settlementDate == null) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (maturityDate == null) {
            throw new UniversalException("maturityDate", 1, UniversalException.ErrorType.VALUE);
        }
        if (settlementDate.compareTo(maturityDate) >= 0) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.NUM);
        }
        if (discount == null) {
            throw new UniversalException("discount", 2, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(discount).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("discount", 2, UniversalException.ErrorType.NUM);
        }
        if (redemption == null) {
            throw new UniversalException("redemption", 3, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(redemption).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("redemption", 3, UniversalException.ErrorType.NUM);
        }
        if (basis == null) {
            throw new UniversalException("basis", 4, UniversalException.ErrorType.VALUE);
        } else if (basis.intValue() < 0 || basis.intValue() > 4) {
            throw new UniversalException("basis", 4, UniversalException.ErrorType.NUM);
        }

        // Returns the price per $100 face value of a discounted security.
        return Formulas.valueOf(redemption).multiply(Formulas.valueOf(1).subtract(Formulas.valueOf(discount).multiply(Moments.yearfrac(settlementDate, maturityDate, basis))));
    }

    public static FormulaDecimal pricemat(Date settlementDate, Date maturityDate, Date issueDate, Number rate, Number yield) {
        return pricemat(settlementDate, maturityDate, issueDate, rate, yield, 0);
    }

    public static FormulaDecimal pricemat(CharSequence settlementDate, CharSequence maturityDate, CharSequence issueDate, Number rate, Number yield) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, 0);
    }

    public static FormulaDecimal pricemat(Date settlementDate, CharSequence maturityDate, CharSequence issueDate, Number rate, Number yield) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, 0);
    }

    public static FormulaDecimal pricemat(CharSequence settlementDate, Date maturityDate, CharSequence issueDate, Number rate, Number yield) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, 0);
    }

    public static FormulaDecimal pricemat(CharSequence settlementDate, CharSequence maturityDate, Date issueDate, Number rate, Number yield) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, 0);
    }

    public static FormulaDecimal pricemat(Date settlementDate, Date maturityDate, CharSequence issueDate, Number rate, Number yield) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, 0);
    }

    public static FormulaDecimal pricemat(CharSequence settlementDate, Date maturityDate, Date issueDate, Number rate, Number yield) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, 0);
    }

    public static FormulaDecimal pricemat(Date settlementDate, CharSequence maturityDate, Date issueDate, Number rate, Number yield) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, 0);
    }

    public static FormulaDecimal pricemat(Number settlementNumber, CharSequence maturityNumber, CharSequence issueNumber, Number rate, Number yield) {
        return pricemat(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), rate, yield, 0);
    }

    public static FormulaDecimal pricemat(CharSequence settlementNumber, Number maturityNumber, CharSequence issueNumber, Number rate, Number yield) {
        return pricemat(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), rate, yield, 0);
    }

    public static FormulaDecimal pricemat(CharSequence settlementNumber, CharSequence maturityNumber, Number issueNumber, Number rate, Number yield) {
        return pricemat(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), rate, yield, 0);
    }

    public static FormulaDecimal pricemat(Number settlementNumber, Number maturityNumber, CharSequence issueNumber, Number rate, Number yield) {
        return pricemat(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), rate, yield, 0);
    }

    public static FormulaDecimal pricemat(CharSequence settlementNumber, Number maturityNumber, Number issueNumber, Number rate, Number yield) {
        return pricemat(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), rate, yield, 0);
    }

    public static FormulaDecimal pricemat(Number settlementNumber, CharSequence maturityNumber, Number issueNumber, Number rate, Number yield) {
        return pricemat(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), rate, yield, 0);
    }

    public static FormulaDecimal pricemat(Number settlementDate, Number maturityDate, Number issueDate, Number rate, Number yield) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, 0);
    }

    public static FormulaDecimal pricemat(Date settlementDate, Number maturityDate, Number issueDate, Number rate, Number yield) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, 0);
    }

    public static FormulaDecimal pricemat(Number settlementDate, Date maturityDate, Number issueDate, Number rate, Number yield) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, 0);
    }

    public static FormulaDecimal pricemat(Number settlementDate, Number maturityDate, Date issueDate, Number rate, Number yield) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, 0);
    }

    public static FormulaDecimal pricemat(Date settlementDate, Date maturityDate, Number issueDate, Number rate, Number yield) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, 0);
    }

    public static FormulaDecimal pricemat(Number settlementDate, Date maturityDate, Date issueDate, Number rate, Number yield) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, 0);
    }

    public static FormulaDecimal pricemat(Date settlementDate, Number maturityDate, Date issueDate, Number rate, Number yield) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, 0);
    }

    public static FormulaDecimal pricemat(CharSequence settlementDate, CharSequence maturityDate, CharSequence issueDate, Number rate, Number yield, Number basis) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, basis);
    }

    public static FormulaDecimal pricemat(Date settlementDate, CharSequence maturityDate, CharSequence issueDate, Number rate, Number yield, Number basis) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, basis);
    }

    public static FormulaDecimal pricemat(CharSequence settlementDate, Date maturityDate, CharSequence issueDate, Number rate, Number yield, Number basis) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, basis);
    }

    public static FormulaDecimal pricemat(CharSequence settlementDate, CharSequence maturityDate, Date issueDate, Number rate, Number yield, Number basis) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, basis);
    }

    public static FormulaDecimal pricemat(Date settlementDate, Date maturityDate, CharSequence issueDate, Number rate, Number yield, Number basis) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, basis);
    }

    public static FormulaDecimal pricemat(CharSequence settlementDate, Date maturityDate, Date issueDate, Number rate, Number yield, Number basis) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, basis);
    }

    public static FormulaDecimal pricemat(Date settlementDate, CharSequence maturityDate, Date issueDate, Number rate, Number yield, Number basis) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, basis);
    }

    public static FormulaDecimal pricemat(Number settlementNumber, CharSequence maturityNumber, CharSequence issueNumber, Number rate, Number yield, Number basis) {
        return pricemat(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), rate, yield, basis);
    }

    public static FormulaDecimal pricemat(CharSequence settlementNumber, Number maturityNumber, CharSequence issueNumber, Number rate, Number yield, Number basis) {
        return pricemat(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), rate, yield, basis);
    }

    public static FormulaDecimal pricemat(CharSequence settlementNumber, CharSequence maturityNumber, Number issueNumber, Number rate, Number yield, Number basis) {
        return pricemat(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), rate, yield, basis);
    }

    public static FormulaDecimal pricemat(Number settlementNumber, Number maturityNumber, CharSequence issueNumber, Number rate, Number yield, Number basis) {
        return pricemat(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), rate, yield, basis);
    }

    public static FormulaDecimal pricemat(CharSequence settlementNumber, Number maturityNumber, Number issueNumber, Number rate, Number yield, Number basis) {
        return pricemat(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), rate, yield, basis);
    }

    public static FormulaDecimal pricemat(Number settlementNumber, CharSequence maturityNumber, Number issueNumber, Number rate, Number yield, Number basis) {
        return pricemat(Moments.valueOf(settlementNumber), Moments.valueOf(maturityNumber), Moments.valueOf(issueNumber), rate, yield, basis);
    }

    public static FormulaDecimal pricemat(Number settlementDate, Number maturityDate, Number issueDate, Number rate, Number yield, Number basis) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, basis);
    }

    public static FormulaDecimal pricemat(Date settlementDate, Number maturityDate, Number issueDate, Number rate, Number yield, Number basis) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, basis);
    }

    public static FormulaDecimal pricemat(Number settlementDate, Date maturityDate, Number issueDate, Number rate, Number yield, Number basis) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, basis);
    }

    public static FormulaDecimal pricemat(Number settlementDate, Number maturityDate, Date issueDate, Number rate, Number yield, Number basis) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, basis);
    }

    public static FormulaDecimal pricemat(Date settlementDate, Date maturityDate, Number issueDate, Number rate, Number yield, Number basis) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, basis);
    }

    public static FormulaDecimal pricemat(Number settlementDate, Date maturityDate, Date issueDate, Number rate, Number yield, Number basis) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, basis);
    }

    public static FormulaDecimal pricemat(Date settlementDate, Number maturityDate, Date issueDate, Number rate, Number yield, Number basis) {
        return pricemat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), rate, yield, basis);
    }

    public static FormulaDecimal pricemat(Date settlementDate, Date maturityDate, Date issueDate, Number rate, Number yield, Number basis) {
        if (settlementDate == null) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (maturityDate == null) {
            throw new UniversalException("maturityDate", 1, UniversalException.ErrorType.VALUE);
        }
        if (issueDate == null) {
            throw new UniversalException("issueDate", 2, UniversalException.ErrorType.VALUE);
        }
        if (settlementDate.compareTo(maturityDate) >= 0) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.NUM);
        }
        if (rate == null) {
            throw new UniversalException("rate", 3, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(rate).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("rate", 3, UniversalException.ErrorType.NUM);
        }
        if (yield == null) {
            throw new UniversalException("yield", 4, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(yield).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("yield", 4, UniversalException.ErrorType.NUM);
        }
        if (basis == null) {
            throw new UniversalException("basis", 5, UniversalException.ErrorType.VALUE);
        } else if (basis.intValue() < 0 || basis.intValue() > 4) {
            throw new UniversalException("basis", 5, UniversalException.ErrorType.NUM);
        }

        // Returns the price per $100 face value of a security that pays interest at maturity.

        FormulaDecimal fIssMat = Moments.yearfrac(issueDate, maturityDate, basis);
        FormulaDecimal fIssSet = Moments.yearfrac(issueDate, settlementDate, basis);
        FormulaDecimal fSetMat = Moments.yearfrac(settlementDate, maturityDate, basis);

        FormulaDecimal fRet = Formulas.valueOf(1.0).add(Formulas.valueOf(fIssMat).multiply(Formulas.valueOf(rate)));
        fRet = Formulas.valueOf(fRet).divide(Formulas.valueOf(1.0).add(fSetMat.multiply(Formulas.valueOf(yield))));
        fRet = Formulas.valueOf(fRet).subtract(fIssSet.multiply(Formulas.valueOf(rate)));
        fRet = fRet.multiply(Formulas.valueOf(100.0));

        return fRet;
    }

    public static FormulaDecimal pv(Number rate, Number numberOfPayments, Number payment) {
        return pv(rate, numberOfPayments, payment, 0, 0);
    }

    public static FormulaDecimal pv(Number rate, Number numberOfPayments, Number payment, Number futureValue) {
        return pv(rate, numberOfPayments, payment, futureValue, 0);
    }

    public static FormulaDecimal pv(Number rate, Number numberOfPayments, Number payment, Number futureValue, Number type) {
        if (rate == null) {
            throw new UniversalException("rate", 0, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(rate).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("rate", 0, UniversalException.ErrorType.NUM);
        }
        if (numberOfPayments == null) {
            throw new UniversalException("numberOfPayments", 1, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(numberOfPayments).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("numberOfPayments", 1, UniversalException.ErrorType.NUM);
        }
        if (payment == null) {
            throw new UniversalException("payment", 2, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(payment).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("payment", 2, UniversalException.ErrorType.NUM);
        }
        if (futureValue == null) {
            throw new UniversalException("futureValue", 3, UniversalException.ErrorType.VALUE);
        }
        if (type == null) {
            throw new UniversalException("type", 4, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(type).compareTo(BigDecimal.ZERO) < 0 || Formulas.valueOf(type).compareTo(BigDecimal.ONE) > 0) {
            throw new UniversalException("type", 4, UniversalException.ErrorType.NUM);
        }

        // @see https://support.office.com/en-us/article/pv-function-23879d31-0e02-4321-be01-da16e8168cbd
        // calculates the present value of a loan or an investment, based on a constant interest rate.

        if (Formulas.valueOf(rate).compareTo(BigDecimal.ZERO) == 0) {
            return Formulas.valueOf(payment).negate().multiply(Formulas.valueOf(numberOfPayments).subtract(Formulas.valueOf(futureValue)));
        } else {
            // (((1 - Math.pow(1 + rate, periods)) / rate) * payment * (1 + rate * type) - future) / Math.pow(1 + rate, periods);
            return Formulas.valueOf(1).subtract(Formulas.power(Formulas.valueOf(1).add(Formulas.valueOf(rate)), numberOfPayments)).divide(Formulas.valueOf(rate))
                    .multiply(Formulas.valueOf(payment))
                    .multiply(Formulas.valueOf(1).add(Formulas.valueOf(rate).multiply(Formulas.valueOf(type))))
                    .subtract(Formulas.valueOf(futureValue))
                    .divide(Formulas.power(Formulas.valueOf(1).add(Formulas.valueOf(rate)), numberOfPayments));
        }
    }

    public static FormulaDecimal rate(Number numberOfPayments, Number payment, Number presentValue) {
        return rate(numberOfPayments, payment, presentValue, 0, 0);
    }

    public static FormulaDecimal rate(Number numberOfPayments, Number payment, Number presentValue, Number futureValue) {
        return rate(numberOfPayments, payment, presentValue, futureValue, 0);
    }

    public static FormulaDecimal rate(Number numberOfPayments, Number payment, Number presentValue, Number futureValue, Number type) {
        return rate(numberOfPayments, payment, presentValue, futureValue, type, 0.1);
    }

    public static FormulaDecimal rate(Number numberOfPayments, Number payment, Number presentValue, Number futureValue, Number type, Number guess) {
        if (numberOfPayments == null) {
            throw new UniversalException("numberOfPayments", 0, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(numberOfPayments).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("numberOfPayments", 0, UniversalException.ErrorType.NUM);
        }
        if (payment == null) {
            throw new UniversalException("payment", 1, UniversalException.ErrorType.VALUE);
        }
        if (presentValue == null) {
            throw new UniversalException("presentValue", 2, UniversalException.ErrorType.VALUE);
        }
        if (futureValue == null) {
            throw new UniversalException("futureValue", 3, UniversalException.ErrorType.VALUE);
        }
        if (type == null) {
            throw new UniversalException("type", 4, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(type).compareTo(BigDecimal.ZERO) < 0 || Formulas.valueOf(type).compareTo(BigDecimal.ONE) > 0) {
            throw new UniversalException("type", 4, UniversalException.ErrorType.NUM);
        }

        // Returns the interest rate per period of an annuity.
        // RATE is calculated by iteration and can have zero or more solutions.
        // If the successive results of RATE do not converge to within 0.0000001 after 20 iterations, RATE returns error.
        final FormulaDecimal epsilonMax = Formulas.valueOf(1e-6);

        int iterMax = 100;
        int iter = 0;
        boolean close = false;
        FormulaDecimal rate = Formulas.valueOf(guess);

        while (iter < iterMax && !close) {
            final FormulaDecimal t1 = Formulas.power(Formulas.valueOf(rate.add(Formulas.valueOf(1))), numberOfPayments);
            final FormulaDecimal t2 = Formulas.power(Formulas.valueOf(rate.add(Formulas.valueOf(1))), Formulas.valueOf(numberOfPayments).subtract(Formulas.valueOf(1)));

            // future + t1 * present + payment * (t1 - 1) * (rate * type + 1) / rate;
            final FormulaDecimal f1 = Formulas.valueOf(futureValue).add(t1.multiply(Formulas.valueOf(presentValue))).add(Formulas.valueOf(payment).multiply(t1.subtract(Formulas.valueOf(1))).multiply(Formulas.valueOf(rate).multiply(Formulas.valueOf(type)).add(Formulas.valueOf(1))).divide(Formulas.valueOf(rate)));
            // periods * t2 * present - payment * (t1 - 1) *(rate * type + 1) / Math.pow(rate,2);
            final FormulaDecimal f2 = Formulas.valueOf(numberOfPayments).multiply(t2).multiply(Formulas.valueOf(presentValue)).subtract(Formulas.valueOf(payment).multiply(t1.subtract(Formulas.valueOf(1))).multiply(Formulas.valueOf(rate).multiply(Formulas.valueOf(type).add(Formulas.valueOf(1)))).divide(Formulas.power(rate, 2)));
            // periods * payment * t2 * (rate * type + 1) / rate + payment * (t1 - 1) * type / rate;
            final FormulaDecimal f3 = Formulas.valueOf(numberOfPayments).multiply(Formulas.valueOf(payment)).multiply(Formulas.valueOf(t2)).multiply(Formulas.valueOf(rate).multiply(Formulas.valueOf(type).add(Formulas.valueOf(1)))).divide(Formulas.valueOf(rate)).add(Formulas.valueOf(payment).multiply(t1.subtract(Formulas.valueOf(1))).multiply(Formulas.valueOf(type).divide(Formulas.valueOf(rate))));

            FormulaDecimal newRate = rate.subtract(f1.divide(f2.add(f3)));
            if (Formulas.abs(newRate.subtract(rate)).compareTo(epsilonMax) < 0) {
                close = true;
            }
            iter++;
            rate = newRate;
        }

        if (!close) {
            // Number.NaN + rate;
            throw new UnsupportedOperationException();
        }

        return rate;
    }

    public static FormulaDecimal received(Date settlementDate, Date maturityDate, Number amountInvested, Number discountRate) {
        return received(settlementDate, maturityDate, amountInvested, discountRate, 0);
    }

    public static FormulaDecimal received(CharSequence settlementDate, CharSequence maturityDate, Number amountInvested, Number discountRate) {
        return received(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), amountInvested, discountRate, 0);
    }

    public static FormulaDecimal received(Date settlementDate, CharSequence maturityDate, Number amountInvested, Number discountRate) {
        return received(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), amountInvested, discountRate, 0);
    }

    public static FormulaDecimal received(CharSequence settlementDate, Date maturityDate, Number amountInvested, Number discountRate) {
        return received(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), amountInvested, discountRate, 0);
    }

    public static FormulaDecimal received(Number settlementDate, Number maturityDate, Number amountInvested, Number discountRate) {
        return received(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), amountInvested, discountRate, 0);
    }

    public static FormulaDecimal received(Number settlementDate, CharSequence maturityDate, Number amountInvested, Number discountRate) {
        return received(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), amountInvested, discountRate, 0);
    }

    public static FormulaDecimal received(CharSequence settlementDate, Number maturityDate, Number amountInvested, Number discountRate) {
        return received(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), amountInvested, discountRate, 0);
    }

    public static FormulaDecimal received(Date settlementDate, Number maturityDate, Number amountInvested, Number discountRate) {
        return received(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), amountInvested, discountRate, 0);
    }

    public static FormulaDecimal received(Number settlementDate, Date maturityDate, Number amountInvested, Number discountRate) {
        return received(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), amountInvested, discountRate, 0);
    }

    public static FormulaDecimal received(CharSequence settlementDate, CharSequence maturityDate, Number amountInvested, Number discountRate, Number basis) {
        return received(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), amountInvested, discountRate, basis);
    }

    public static FormulaDecimal received(Date settlementDate, CharSequence maturityDate, Number amountInvested, Number discountRate, Number basis) {
        return received(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), amountInvested, discountRate, basis);
    }

    public static FormulaDecimal received(CharSequence settlementDate, Date maturityDate, Number amountInvested, Number discountRate, Number basis) {
        return received(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), amountInvested, discountRate, basis);
    }

    public static FormulaDecimal received(Number settlementDate, Number maturityDate, Number amountInvested, Number discountRate, Number basis) {
        return received(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), amountInvested, discountRate, basis);
    }

    public static FormulaDecimal received(Number settlementDate, CharSequence maturityDate, Number amountInvested, Number discountRate, Number basis) {
        return received(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), amountInvested, discountRate, basis);
    }

    public static FormulaDecimal received(CharSequence settlementDate, Number maturityDate, Number amountInvested, Number discountRate, Number basis) {
        return received(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), amountInvested, discountRate, basis);
    }

    public static FormulaDecimal received(Date settlementDate, Number maturityDate, Number amountInvested, Number discountRate, Number basis) {
        return received(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), amountInvested, discountRate, basis);
    }

    public static FormulaDecimal received(Number settlementDate, Date maturityDate, Number amountInvested, Number discountRate, Number basis) {
        return received(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), amountInvested, discountRate, basis);
    }

    public static FormulaDecimal received(Date settlementDate, Date maturityDate, Number amountInvested, Number discountRate, Number basis) {
        if (settlementDate == null) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (maturityDate == null) {
            throw new UniversalException("maturityDate", 1, UniversalException.ErrorType.VALUE);
        }
        if (settlementDate.compareTo(maturityDate) >= 0) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.NUM);
        }
        if (amountInvested == null) {
            throw new UniversalException("amountInvested", 2, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(amountInvested).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("amountInvested", 2, UniversalException.ErrorType.NUM);
        }
        if (discountRate == null) {
            throw new UniversalException("discountRate", 3, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(discountRate).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("discountRate", 3, UniversalException.ErrorType.NUM);
        }
        if (basis == null) {
            throw new UniversalException("basis", 4, UniversalException.ErrorType.VALUE);
        } else if (basis.intValue() < 0 || basis.intValue() > 4) {
            throw new UniversalException("basis", 4, UniversalException.ErrorType.NUM);
        }

        // Returns the amount received at maturity for a fully invested security.
        return Formulas.valueOf(amountInvested).divide(Formulas.valueOf(1.0).subtract(Formulas.valueOf(discountRate).multiply(Moments.yearfrac(settlementDate, maturityDate, basis))));
    }

    public static FormulaDecimal rri(Number numberOfPeriods, Number presentValue, Number futureValue) {
        if (numberOfPeriods == null) {
            throw new UniversalException("numberOfPeriods", 0, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(numberOfPeriods).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("numberOfPeriods", 0, UniversalException.ErrorType.NUM);
        }
        if (presentValue == null) {
            throw new UniversalException("presentValue", 1, UniversalException.ErrorType.VALUE);
        }
        if (futureValue == null) {
            throw new UniversalException("futureValue", 2, UniversalException.ErrorType.VALUE);
        }

        // Returns an equivalent interest rate for the growth of an investment.
        return Formulas.power(Formulas.valueOf(futureValue).divide(Formulas.valueOf(presentValue)), Formulas.valueOf(1).divide(Formulas.valueOf(numberOfPeriods))).subtract(Formulas.valueOf(1));
    }

    public static FormulaDecimal sln(Number cost, Number salvage, Number life) {
        if (cost == null) {
            throw new UniversalException("cost", 0, UniversalException.ErrorType.VALUE);
        }
        if (salvage == null) {
            throw new UniversalException("salvage", 1, UniversalException.ErrorType.VALUE);
        }
        if (life == null) {
            throw new UniversalException("life", 2, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(life).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("life", 2, UniversalException.ErrorType.NUM);
        }

        // Returns the straight-line depreciation of an asset for one period.
        return Formulas.valueOf(cost).subtract(Formulas.valueOf(salvage)).divide(Formulas.valueOf(life));
    }

    public static FormulaDecimal syd(Number cost, Number salvage, Number life, Number period) {
        if (cost == null) {
            throw new UniversalException("cost", 0, UniversalException.ErrorType.VALUE);
        }
        if (salvage == null) {
            throw new UniversalException("salvage", 1, UniversalException.ErrorType.VALUE);
        }
        if (life == null) {
            throw new UniversalException("life", 2, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(life).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("life", 2, UniversalException.ErrorType.NUM);
        }
        if (period == null) {
            throw new UniversalException("period", 3, UniversalException.ErrorType.VALUE);
        }

        // Returns the sum-of-years' digits depreciation of an asset for a specified period.
        return Formulas.valueOf(cost).subtract(Formulas.valueOf(salvage)).multiply(Formulas.valueOf(life).subtract(Formulas.valueOf(period.intValue())).add(Formulas.valueOf(1))).multiply(Formulas.valueOf(2)).divide(Formulas.valueOf(life).multiply(Formulas.valueOf(life).add(Formulas.valueOf(1))));
    }

    public static FormulaDecimal tbilleq(CharSequence settlementDate, CharSequence maturityDate, Number discount) {
        return tbilleq(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount);
    }

    public static FormulaDecimal tbilleq(Date settlementDate, CharSequence maturityDate, Number discount) {
        return tbilleq(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount);
    }

    public static FormulaDecimal tbilleq(CharSequence settlementDate, Date maturityDate, Number discount) {
        return tbilleq(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount);
    }

    public static FormulaDecimal tbilleq(Number settlementDate, Number maturityDate, Number discount) {
        return tbilleq(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount);
    }

    public static FormulaDecimal tbilleq(Number settlementDate, CharSequence maturityDate, Number discount) {
        return tbilleq(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount);
    }

    public static FormulaDecimal tbilleq(CharSequence settlementDate, Number maturityDate, Number discount) {
        return tbilleq(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount);
    }

    public static FormulaDecimal tbilleq(Date settlementDate, Date maturityDate, Number discount) {
        if (settlementDate == null) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (maturityDate == null) {
            throw new UniversalException("maturityDate", 1, UniversalException.ErrorType.VALUE);
        }
        if (settlementDate.compareTo(maturityDate) >= 0) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.NUM);
        }
        if (discount == null) {
            throw new UniversalException("discount", 2, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(discount).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("discount", 2, UniversalException.ErrorType.NUM);
        }

        // Returns the bond-equivalent yield for a Treasury bill.
        return Formulas.valueOf(365).multiply(Formulas.valueOf(discount)).divide(Formulas.valueOf(360).subtract(Formulas.valueOf(discount).multiply(Moments.days360(settlementDate, maturityDate, false).add(Formulas.valueOf(1)))));
    }

    public static FormulaDecimal tbillprice(CharSequence settlementDate, CharSequence maturityDate, Number discount) {
        return tbillprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount);
    }

    public static FormulaDecimal tbillprice(Date settlementDate, CharSequence maturityDate, Number discount) {
        return tbillprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount);
    }

    public static FormulaDecimal tbillprice(CharSequence settlementDate, Date maturityDate, Number discount) {
        return tbillprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount);
    }

    public static FormulaDecimal tbillprice(Number settlementDate, Number maturityDate, Number discount) {
        return tbillprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount);
    }

    public static FormulaDecimal tbillprice(Number settlementDate, CharSequence maturityDate, Number discount) {
        return tbillprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount);
    }

    public static FormulaDecimal tbillprice(CharSequence settlementDate, Number maturityDate, Number discount) {
        return tbillprice(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount);
    }

    public static FormulaDecimal tbillprice(Date settlementDate, Date maturityDate, Number discount) {
        if (settlementDate == null) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (maturityDate == null) {
            throw new UniversalException("maturityDate", 1, UniversalException.ErrorType.VALUE);
        }
        if (settlementDate.compareTo(maturityDate) >= 0) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.NUM);
        }
        if (discount == null) {
            throw new UniversalException("discount", 2, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(discount).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("discount", 2, UniversalException.ErrorType.NUM);
        }

        // Returns the price per $100 face value for a Treasury bill.
        return Formulas.valueOf(100).multiply(Formulas.valueOf(1).subtract(Formulas.valueOf(discount).multiply(Moments.days360(settlementDate, maturityDate, false).add(Formulas.valueOf(1)).divide(Formulas.valueOf(360)))));
    }

    public static FormulaDecimal tbillyield(CharSequence settlementDate, CharSequence maturityDate, Number discount) {
        return tbillyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount);
    }

    public static FormulaDecimal tbillyield(Date settlementDate, CharSequence maturityDate, Number discount) {
        return tbillyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount);
    }

    public static FormulaDecimal tbillyield(CharSequence settlementDate, Date maturityDate, Number discount) {
        return tbillyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount);
    }

    public static FormulaDecimal tbillyield(Number settlementDate, Number maturityDate, Number discount) {
        return tbillyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount);
    }

    public static FormulaDecimal tbillyield(Number settlementDate, CharSequence maturityDate, Number discount) {
        return tbillyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount);
    }

    public static FormulaDecimal tbillyield(CharSequence settlementDate, Number maturityDate, Number discount) {
        return tbillyield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), discount);
    }

    public static FormulaDecimal tbillyield(Date settlementDate, Date maturityDate, Number price) {
        if (settlementDate == null) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (maturityDate == null) {
            throw new UniversalException("maturityDate", 1, UniversalException.ErrorType.VALUE);
        }
        if (settlementDate.compareTo(maturityDate) >= 0) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.NUM);
        }
        if (price == null) {
            throw new UniversalException("price", 2, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(price).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("price", 2, UniversalException.ErrorType.NUM);
        }

        // Returns the yield for a Treasury bill.
        return Formulas.valueOf(100).subtract(Formulas.valueOf(price)).multiply(Formulas.valueOf(360)).divide(Formulas.valueOf(price).multiply(Moments.days360(settlementDate, maturityDate, false).add(Formulas.valueOf(1))));
    }

    public static FormulaDecimal vdb(Number cost, Number salvage, Number life, Number startPeriod, Number endPeriod) {
        return vdb(cost, salvage, life, startPeriod, endPeriod, 2, false);
    }

    public static FormulaDecimal vdb(Number cost, Number salvage, Number life, Number startPeriod, Number endPeriod, Number factor) {
        return vdb(cost, salvage, life, startPeriod, endPeriod, factor, false);
    }

    public static FormulaDecimal vdb(Number cost, Number salvage, Number life, Number startPeriod, Number endPeriod, Number factor, Boolean noSwitch) {
        return vdb(cost, salvage, life, startPeriod, endPeriod, factor, Logical.valueOf(noSwitch));
    }

    public static FormulaDecimal vdb(Number cost, Number salvage, Number life, Number startPeriod, Number endPeriod, Number factor, Logical noSwitch) {
        // Returns the depreciation of an asset for any period you specify, including partial periods, using the double-declining balance method or some other method you specify.
        // VDB stands for variable declining balance.
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal xirr(Object object, Object... objects) {
        if (object == null && (objects == null || objects.length == 0)) {
            throw new UniversalException("values", 0, UniversalException.ErrorType.VALUE);
        }

        final Object[] array = ArrayHelper.prepend(Object.class, object, objects);
        if (array.length % 2 == 0) {
            // has no guess
            final Object[] values = Arrays.copyOfRange(array, 0, array.length / 2);
            final Object[] dates = Arrays.copyOfRange(array, array.length / 2, array.length);
            return xirr((Number[]) Arrays.stream(values)
                            .map(new Function<Object, FormulaDecimal>() {
                                @Override
                                public FormulaDecimal apply(Object o) {
                                    if (o instanceof Number) {
                                        return Formulas.valueOf((Number) o);
                                    } else if (o instanceof CharSequence) {
                                        return Formulas.valueOf(((CharSequence) o).toString());
                                    } else {
                                        throw new UnsupportedOperationException();
                                    }
                                }
                            }).toArray(Number[]::new),
                    (Date[]) Arrays.stream(dates)
                            .map(new Function<Object, Date>() {
                                @Override
                                public Date apply(Object o) {
                                    if (o instanceof Date) {
                                        return Moments.valueOf(((Date) o));
                                    } else if (o instanceof Number) {
                                        return Moments.valueOf((Number) o);
                                    } else if (o instanceof CharSequence) {
                                        return Moments.valueOf(((CharSequence) o).toString());
                                    } else {
                                        throw new UnsupportedOperationException();
                                    }
                                }
                            }).toArray(Date[]::new), 0.1);
        } else {
            // has guess
            final Number guess = Formulas.valueOfObject(array[array.length - 1]);
            final Object[] range = Arrays.copyOfRange(array, 0, array.length - 1);
            final Object[] values = Arrays.copyOfRange(range, 0, range.length / 2);
            final Object[] dates = Arrays.copyOfRange(range, range.length / 2, range.length);
            return xirr((Number[]) Arrays.stream(values)
                            .map(new Function<Object, FormulaDecimal>() {
                                @Override
                                public FormulaDecimal apply(Object o) {
                                    if (o instanceof Number) {
                                        return Formulas.valueOf((Number) o);
                                    } else if (o instanceof CharSequence) {
                                        return Formulas.valueOf(((CharSequence) o).toString());
                                    } else {
                                        return Formulas.valueOfObject(o);
                                    }
                                }
                            }).toArray(Number[]::new),
                    (Date[]) Arrays.stream(dates)
                            .map(new Function<Object, Date>() {
                                @Override
                                public Date apply(Object o) {
                                    if (o instanceof Date) {
                                        return Moments.valueOf(((Date) o));
                                    } else if (o instanceof Number) {
                                        return Moments.valueOf((Number) o);
                                    } else if (o instanceof CharSequence) {
                                        return Moments.valueOf(((CharSequence) o).toString());
                                    } else {
                                        return Moments.valueOfObject(o);
                                    }
                                }
                            }).toArray(Date[]::new), guess);
        }
    }

    public static FormulaDecimal xirr(Number[] values, Date[] dates) {
        return xirr(values, dates, 0.1);
    }

    public static FormulaDecimal xirr(Number[] values, Date[] dates, Number guess) {
        if (values == null || values.length == 0) {
            throw new UniversalException("values", 0, UniversalException.ErrorType.VALUE);
        }
        if (dates == null || dates.length == 0) {
            throw new UniversalException("dates", 1, UniversalException.ErrorType.VALUE);
        }

        // Returns the internal rate of return for a schedule of cash flows that is not necessarily periodic.
        // To calculate the internal rate of return for a series of periodic cash flows, use the IRR function.

        FormulaDecimal fResultRate = Formulas.valueOf(guess);

        FormulaDecimal fMaxEps = Formulas.valueOf(1e-10);
        int nMaxIter = 50;

        FormulaDecimal fNewRate;
        FormulaDecimal fRateEps;
        FormulaDecimal fResultValue;
        int nIter = 0;
        int nIterScan = 0;
        boolean bContLoop = false;
        boolean bResultRateScanEnd = false;

        do {
            if (nIterScan >= 1) {
                fResultRate = Formulas.valueOf("-0.99").add(Formulas.valueOf(nIterScan).subtract(Formulas.valueOf(1)).multiply(Formulas.valueOf("0.01")));
            }
            do {
                fResultValue = irr_result(
                        ArrayUtils.toPrimitive(Arrays.stream(values).filter(java.util.Objects::nonNull).map(Number::doubleValue).toArray(Double[]::new)),
                        ArrayUtils.toPrimitive(Arrays.stream(dates).filter(java.util.Objects::nonNull).map((Function<Date, Number>) Moments::datevalue).map(Number::doubleValue).toArray(Double[]::new)),
                        fResultRate.doubleValue());
                fNewRate = fResultRate.subtract(fResultValue.divide(irr_result_deriv(
                        ArrayUtils.toPrimitive(Arrays.stream(values).filter(java.util.Objects::nonNull).map(Number::doubleValue).toArray(Double[]::new)),
                        ArrayUtils.toPrimitive(Arrays.stream(dates).filter(java.util.Objects::nonNull).map((Function<Date, Number>) Moments::datevalue).map(Number::doubleValue).toArray(Double[]::new)),
                        fResultRate.doubleValue())));
                fRateEps = Formulas.abs(fNewRate.subtract(fResultRate));
                fResultRate = fNewRate;
                bContLoop = fRateEps.compareTo(fMaxEps) > 0 && Formulas.abs(fResultValue).compareTo(fMaxEps) > 0;
            }
            while (bContLoop && (++nIter < nMaxIter));
            nIter = 0;
            ++nIterScan;
            bResultRateScanEnd = (nIterScan >= 200);
        }
        while (bContLoop && !bResultRateScanEnd);

        return fResultRate;
    }

    static FormulaDecimal irr_result(double[] rValues, double[] rDates, double fRate) {
        // TODO refactor to FormulaDecimals
        double D_0 = rDates[0];
        double r = fRate + 1.0;
        double fResult = rValues[0];
        for (int i = 1, nCount = rValues.length; i < nCount; ++i)
            fResult += rValues[i] / Math.pow(r, (rDates[i] - D_0) / 365.0);
        return Formulas.valueOf(fResult);
    }

    static FormulaDecimal irr_result_deriv(double[] rValues, double[] rDates, double fRate) {
        // TODO refactor to FormulaDecimals
        double D_0 = rDates[0];
        double r = fRate + 1.0;
        double fResult = 0.0;
        for (int i = 1, nCount = rValues.length; i < nCount; ++i) {
            double E_i = (rDates[i] - D_0) / 365.0;
            fResult -= E_i * rValues[i] / Math.pow(r, E_i + 1.0);
        }
        return Formulas.valueOf(fResult);
    }

    public static FormulaDecimal xnpv(Number rate, Object... objects) {
        if (rate == null) {
            throw new UniversalException("rate", 0, UniversalException.ErrorType.VALUE);
        }
        if (objects == null || objects.length == 0) {
            throw new UniversalException("values", 1, UniversalException.ErrorType.VALUE);
        }
        if (objects.length <= 1) {
            throw new UniversalException("dates", 2, UniversalException.ErrorType.VALUE);
        }

        final Object[] values = Arrays.copyOfRange(objects, 0, objects.length / 2);
        final Object[] dates = Arrays.copyOfRange(objects, objects.length / 2, objects.length);
        return xnpv(rate, (Number[]) Arrays.stream(values)
                        .map(new Function<Object, FormulaDecimal>() {
                            @Override
                            public FormulaDecimal apply(Object o) {
                                if (o instanceof Number) {
                                    return Formulas.valueOf((Number) o);
                                } else if (o instanceof CharSequence) {
                                    return Formulas.valueOf(((CharSequence) o).toString());
                                } else {
                                    return Formulas.valueOfObject(o);
                                }
                            }
                        }).toArray(Number[]::new),
                (Date[]) Arrays.stream(dates)
                        .map(new Function<Object, Date>() {
                            @Override
                            public Date apply(Object o) {
                                if (o instanceof Date) {
                                    return Moments.valueOf(((Date) o));
                                } else if (o instanceof Number) {
                                    return Moments.valueOf((Number) o);
                                } else if (o instanceof CharSequence) {
                                    return Moments.valueOf(((CharSequence) o).toString());
                                } else {
                                    return Moments.valueOfObject(o);
                                }
                            }
                        }).toArray(Date[]::new));
    }

    public static FormulaDecimal xnpv(Number rate, Number[] values, Date[] dates) {
        if (rate == null) {
            throw new UniversalException("rate", 0, UniversalException.ErrorType.VALUE);
        }
        if (values == null || values.length == 0) {
            throw new UniversalException("values", 0, UniversalException.ErrorType.VALUE);
        }
        if (dates == null || dates.length == 0) {
            throw new UniversalException("dates", 1, UniversalException.ErrorType.VALUE);
        }
        // Returns the net present value for a schedule of cash flows that is not necessarily periodic.
        // To calculate the net present value for a series of cash flows that is periodic, use the NPV function.

        final double[] rValues = ArrayUtils.toPrimitive(Arrays.stream(values).filter(java.util.Objects::nonNull).map(Number::doubleValue).toArray(Double[]::new));
        final double[] rDates = ArrayUtils.toPrimitive(Arrays.stream(dates).filter(java.util.Objects::nonNull).map((Function<Date, Number>) Moments::datevalue).map(Number::doubleValue).toArray(Double[]::new));
        double fRate = rate.doubleValue();

        int nNum = rValues.length;

        double fRet = 0.0;
        double fNull = rDates[0];
        fRate++;

        for (int i = 0; i < nNum; i++) {
            fRet += rValues[i] / (Math.pow(fRate, (rDates[i] - fNull) / 365.0));
        }

        return Formulas.valueOf(fRet);
    }

    public static FormulaDecimal yield(Date settlementDate, Date maturityDate, Number annualCouponRate, Number price, Number redemption, Number frequency) {
        return yield(settlementDate, maturityDate, annualCouponRate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal yield(CharSequence settlementDate, CharSequence maturityDate, Number annualCouponRate, Number price, Number redemption, Number frequency) {
        return yield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal yield(Date settlementDate, CharSequence maturityDate, Number annualCouponRate, Number price, Number redemption, Number frequency) {
        return yield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal yield(CharSequence settlementDate, Date maturityDate, Number annualCouponRate, Number price, Number redemption, Number frequency) {
        return yield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal yield(Number settlementDate, Number maturityDate, Number annualCouponRate, Number price, Number redemption, Number frequency) {
        return yield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal yield(Number settlementDate, CharSequence maturityDate, Number annualCouponRate, Number price, Number redemption, Number frequency) {
        return yield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal yield(CharSequence settlementDate, Number maturityDate, Number annualCouponRate, Number price, Number redemption, Number frequency) {
        return yield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal yield(Date settlementDate, Number maturityDate, Number annualCouponRate, Number price, Number redemption, Number frequency) {
        return yield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal yield(Number settlementDate, Date maturityDate, Number annualCouponRate, Number price, Number redemption, Number frequency) {
        return yield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, price, redemption, frequency, 0);
    }

    public static FormulaDecimal yield(CharSequence settlementDate, CharSequence maturityDate, Number annualCouponRate, Number price, Number redemption, Number frequency, Number basis) {
        return yield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal yield(Date settlementDate, CharSequence maturityDate, Number annualCouponRate, Number price, Number redemption, Number frequency, Number basis) {
        return yield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal yield(CharSequence settlementDate, Date maturityDate, Number annualCouponRate, Number price, Number redemption, Number frequency, Number basis) {
        return yield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal yield(Number settlementDate, Number maturityDate, Number annualCouponRate, Number price, Number redemption, Number frequency, Number basis) {
        return yield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal yield(Number settlementDate, CharSequence maturityDate, Number annualCouponRate, Number price, Number redemption, Number frequency, Number basis) {
        return yield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal yield(CharSequence settlementDate, Number maturityDate, Number annualCouponRate, Number price, Number redemption, Number frequency, Number basis) {
        return yield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal yield(Date settlementDate, Number maturityDate, Number annualCouponRate, Number price, Number redemption, Number frequency, Number basis) {
        return yield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal yield(Number settlementDate, Date maturityDate, Number annualCouponRate, Number price, Number redemption, Number frequency, Number basis) {
        return yield(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), annualCouponRate, price, redemption, frequency, basis);
    }

    public static FormulaDecimal yield(Date settlementDate, Date maturityDate, Number annualCouponRate, Number price, Number redemption, Number frequency, Number basis) {
        if (settlementDate == null) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (maturityDate == null) {
            throw new UniversalException("maturityDate", 1, UniversalException.ErrorType.VALUE);
        }
        if (settlementDate.compareTo(maturityDate) >= 0) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.NUM);
        }
        if (annualCouponRate == null) {
            throw new UniversalException("annualCouponRate", 2, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(annualCouponRate).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("annualCouponRate", 2, UniversalException.ErrorType.NUM);
        }
        if (price == null) {
            throw new UniversalException("price", 3, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(price).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("price", 3, UniversalException.ErrorType.NUM);
        }
        if (redemption == null) {
            throw new UniversalException("redemption", 4, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(price).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("redemption", 4, UniversalException.ErrorType.NUM);
        }
        if (frequency == null) {
            throw new UniversalException("frequency", 5, UniversalException.ErrorType.VALUE);
        } else if (frequency.intValue() <= 0 || frequency.intValue() > 4 || frequency.intValue() == 3) {
            throw new UniversalException("frequency", 5, UniversalException.ErrorType.NUM);
        }
        if (basis == null) {
            throw new UniversalException("basis", 6, UniversalException.ErrorType.VALUE);
        } else if (basis.intValue() < 0 || basis.intValue() > 4) {
            throw new UniversalException("basis", 6, UniversalException.ErrorType.NUM);
        }

        // Returns the yield on a security that pays periodic interest. Use YIELD to calculate bond yield.
        // @see https://github.com/apache/openoffice/blob/c014b5f2b55cff8d4b0c952d5c16d62ecde09ca1/main/scaddins/source/analysis/analysishelper.cxx#L1085

        double fRate = annualCouponRate.doubleValue();
        double fPriceN = 0.0;
        double fYield1 = 0.0;
        double fYield2 = 1.0;
        double fPrice1 = price(settlementDate, maturityDate, fRate, fYield1, redemption, frequency, basis).doubleValue();
        double fPrice2 = price(settlementDate, maturityDate, fRate, fYield2, redemption, frequency, basis).doubleValue();
        double fYieldN = (fYield2 - fYield1) * 0.5;

        for (int nIter = 0; nIter < 100 && fPriceN != price.doubleValue(); nIter++) {
            fPriceN = price(settlementDate, maturityDate, fRate, fYieldN, redemption, frequency, basis).doubleValue();

            if (price.doubleValue() == fPrice1) {
                return Formulas.valueOf(fYield1);
            } else if (price.doubleValue() == fPrice2) {
                return Formulas.valueOf(fYield2);
            } else if (price.doubleValue() == fPriceN) {
                return Formulas.valueOf(fYieldN);
            } else if (price.doubleValue() < fPrice2) {
                fYield2 *= 2.0;
                fPrice2 = price(settlementDate, maturityDate, fRate, fYield2, redemption, frequency, basis).doubleValue();

                fYieldN = (fYield2 - fYield1) * 0.5;
            } else {
                if (price.doubleValue() < fPriceN) {
                    fYield1 = fYieldN;
                    fPrice1 = fPriceN;
                } else {
                    fYield2 = fYieldN;
                    fPrice2 = fPriceN;
                }

                fYieldN = fYield2 - (fYield2 - fYield1) * ((price.doubleValue() - fPrice2) / (fPrice1 - fPrice2));
            }
        }

        return Formulas.valueOf(fYieldN);
    }

    public static FormulaDecimal yielddisc(Date settlementDate, Date maturityDate, Number price, Number redemption) {
        return yielddisc(settlementDate, maturityDate, price, redemption, 0);
    }

    public static FormulaDecimal yielddisc(CharSequence settlementDate, CharSequence maturityDate, Number price, Number redemption) {
        return yielddisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, 0);
    }

    public static FormulaDecimal yielddisc(Date settlementDate, CharSequence maturityDate, Number price, Number redemption) {
        return yielddisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, 0);
    }

    public static FormulaDecimal yielddisc(CharSequence settlementDate, Date maturityDate, Number price, Number redemption) {
        return yielddisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, 0);
    }

    public static FormulaDecimal yielddisc(Number settlementDate, Number maturityDate, Number price, Number redemption) {
        return yielddisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, 0);
    }

    public static FormulaDecimal yielddisc(Number settlementDate, CharSequence maturityDate, Number price, Number redemption) {
        return yielddisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, 0);
    }

    public static FormulaDecimal yielddisc(CharSequence settlementDate, Number maturityDate, Number price, Number redemption) {
        return yielddisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, 0);
    }

    public static FormulaDecimal yielddisc(Date settlementDate, Number maturityDate, Number price, Number redemption) {
        return yielddisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, 0);
    }

    public static FormulaDecimal yielddisc(Number settlementDate, Date maturityDate, Number price, Number redemption) {
        return yielddisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, 0);
    }

    public static FormulaDecimal yielddisc(CharSequence settlementDate, CharSequence maturityDate, Number price, Number redemption, Number basis) {
        return yielddisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, basis);
    }

    public static FormulaDecimal yielddisc(Date settlementDate, CharSequence maturityDate, Number price, Number redemption, Number basis) {
        return yielddisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, basis);
    }

    public static FormulaDecimal yielddisc(CharSequence settlementDate, Date maturityDate, Number price, Number redemption, Number basis) {
        return yielddisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, basis);
    }

    public static FormulaDecimal yielddisc(Number settlementDate, Number maturityDate, Number price, Number redemption, Number basis) {
        return yielddisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, basis);
    }

    public static FormulaDecimal yielddisc(Number settlementDate, CharSequence maturityDate, Number price, Number redemption, Number basis) {
        return yielddisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, basis);
    }

    public static FormulaDecimal yielddisc(CharSequence settlementDate, Number maturityDate, Number price, Number redemption, Number basis) {
        return yielddisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, basis);
    }

    public static FormulaDecimal yielddisc(Date settlementDate, Number maturityDate, Number price, Number redemption, Number basis) {
        return yielddisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, basis);
    }

    public static FormulaDecimal yielddisc(Number settlementDate, Date maturityDate, Number price, Number redemption, Number basis) {
        return yielddisc(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), price, redemption, basis);
    }

    public static FormulaDecimal yielddisc(Date settlementDate, Date maturityDate, Number price, Number redemption, Number basis) {
        if (settlementDate == null) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (maturityDate == null) {
            throw new UniversalException("maturityDate", 1, UniversalException.ErrorType.VALUE);
        }
        if (settlementDate.compareTo(maturityDate) >= 0) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.NUM);
        }
        if (price == null) {
            throw new UniversalException("price", 2, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(price).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("price", 2, UniversalException.ErrorType.NUM);
        }
        if (redemption == null) {
            throw new UniversalException("redemption", 3, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(price).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("redemption", 3, UniversalException.ErrorType.NUM);
        }
        if (basis == null) {
            throw new UniversalException("basis", 4, UniversalException.ErrorType.VALUE);
        } else if (basis.intValue() < 0 || basis.intValue() > 4) {
            throw new UniversalException("basis", 4, UniversalException.ErrorType.NUM);
        }

        // Returns the annual yield for a discounted security.
        // @see https://github.com/apache/openoffice/blob/c014b5f2b55cff8d4b0c952d5c16d62ecde09ca1/main/scaddins/source/analysis/financial.cxx#L324

        // TODO refactor
        double fRet = (redemption.doubleValue() / price.doubleValue()) - 1.0;
        fRet = fRet / Moments.yearfrac(settlementDate, maturityDate, basis).doubleValue();

        return Formulas.valueOf(fRet);
    }

    public static FormulaDecimal yieldmat(Date settlementDate, Date maturityDate, Date issueDate, Number interestRate, Number price) {
        return yieldmat(settlementDate, maturityDate, issueDate, interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(CharSequence settlementDate, CharSequence maturityDate, CharSequence issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(Date settlementDate, CharSequence maturityDate, CharSequence issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(CharSequence settlementDate, Date maturityDate, CharSequence issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(CharSequence settlementDate, CharSequence maturityDate, Date issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(Date settlementDate, Date maturityDate, CharSequence issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(CharSequence settlementDate, Date maturityDate, Date issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(Date settlementDate, CharSequence maturityDate, Date issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(Number settlementDate, Number maturityDate, Number issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(Number settlementDate, CharSequence maturityDate, CharSequence issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(CharSequence settlementDate, Number maturityDate, CharSequence issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(CharSequence settlementDate, CharSequence maturityDate, Number issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(Number settlementDate, Number maturityDate, CharSequence issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(CharSequence settlementDate, Number maturityDate, Number issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(Number settlementDate, CharSequence maturityDate, Number issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(Date settlementDate, Number maturityDate, Number issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(Number settlementDate, Date maturityDate, Number issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(Number settlementDate, Number maturityDate, Date issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(Date settlementDate, Date maturityDate, Number issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(Number settlementDate, Date maturityDate, Date issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(Date settlementDate, Number maturityDate, Date issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(Date settlementDate, Number maturityDate, CharSequence issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(Date settlementDate, CharSequence maturityDate, Number issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(Number settlementDate, Date maturityDate, CharSequence issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(Number settlementDate, CharSequence maturityDate, Date issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(CharSequence settlementDate, Number maturityDate, Date issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(CharSequence settlementDate, Date maturityDate, Number issueDate, Number interestRate, Number price) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, 0);
    }

    public static FormulaDecimal yieldmat(CharSequence settlementDate, CharSequence maturityDate, CharSequence issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(Date settlementDate, CharSequence maturityDate, CharSequence issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(CharSequence settlementDate, Date maturityDate, CharSequence issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(CharSequence settlementDate, CharSequence maturityDate, Date issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(Date settlementDate, Date maturityDate, CharSequence issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(CharSequence settlementDate, Date maturityDate, Date issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(Date settlementDate, CharSequence maturityDate, Date issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(Number settlementDate, Number maturityDate, Number issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(Number settlementDate, CharSequence maturityDate, CharSequence issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(CharSequence settlementDate, Number maturityDate, CharSequence issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(CharSequence settlementDate, CharSequence maturityDate, Number issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(Number settlementDate, Number maturityDate, CharSequence issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(CharSequence settlementDate, Number maturityDate, Number issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(Number settlementDate, CharSequence maturityDate, Number issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(Date settlementDate, Number maturityDate, Number issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(Number settlementDate, Date maturityDate, Number issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(Number settlementDate, Number maturityDate, Date issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(Date settlementDate, Date maturityDate, Number issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(Number settlementDate, Date maturityDate, Date issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(Date settlementDate, Number maturityDate, Date issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(Date settlementDate, Number maturityDate, CharSequence issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(Date settlementDate, CharSequence maturityDate, Number issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(Number settlementDate, Date maturityDate, CharSequence issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(Number settlementDate, CharSequence maturityDate, Date issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(CharSequence settlementDate, Number maturityDate, Date issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(CharSequence settlementDate, Date maturityDate, Number issueDate, Number interestRate, Number price, Number basis) {
        return yieldmat(Moments.valueOf(settlementDate), Moments.valueOf(maturityDate), Moments.valueOf(issueDate), interestRate, price, basis);
    }

    public static FormulaDecimal yieldmat(Date settlementDate, Date maturityDate, Date issueDate, Number interestRate, Number price, Number basis) {
        if (settlementDate == null) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.VALUE);
        }
        if (maturityDate == null) {
            throw new UniversalException("maturityDate", 1, UniversalException.ErrorType.VALUE);
        }
        if (issueDate == null) {
            throw new UniversalException("issueDate", 2, UniversalException.ErrorType.VALUE);
        }
        if (settlementDate.compareTo(maturityDate) >= 0) {
            throw new UniversalException("settlementDate", 0, UniversalException.ErrorType.NUM);
        }
        if (interestRate == null) {
            throw new UniversalException("interestRate", 3, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(interestRate).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("interestRate", 3, UniversalException.ErrorType.NUM);
        }
        if (price == null) {
            throw new UniversalException("price", 4, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(price).compareTo(BigDecimal.ZERO) <= 0) {
            throw new UniversalException("price", 4, UniversalException.ErrorType.NUM);
        }
        if (basis == null) {
            throw new UniversalException("basis", 5, UniversalException.ErrorType.VALUE);
        } else if (basis.intValue() < 0 || basis.intValue() > 4) {
            throw new UniversalException("basis", 5, UniversalException.ErrorType.NUM);
        }

        // Returns the annual yield of a security that pays interest at maturity.
        // @see https://github.com/apache/openoffice/blob/c014b5f2b55cff8d4b0c952d5c16d62ecde09ca1/main/scaddins/source/analysis/analysishelper.cxx#L996

        double fIssMat = Moments.yearfrac(issueDate, maturityDate, basis).doubleValue();
        double fIssSet = Moments.yearfrac(issueDate, settlementDate, basis).doubleValue();
        double fSetMat = Moments.yearfrac(settlementDate, maturityDate, basis).doubleValue();

        // TODO refactor
        double y = 1.0 + fIssMat * interestRate.doubleValue();
        y /= price.doubleValue() / 100.0 + fIssSet * interestRate.doubleValue();
        y--;
        y /= fSetMat;

        return Formulas.valueOf(y);
    }
}
