package io.onsense.universe;

import cern.jet.random.Beta;
import cern.jet.random.ChiSquare;
import cern.jet.random.Exponential;
import cern.jet.random.NegativeBinomial;
import cern.jet.random.engine.RandomEngine;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.analysis.function.Gaussian;
import org.apache.commons.math3.distribution.*;
import org.apache.commons.math3.special.Gamma;
import org.apache.commons.math3.stat.correlation.Covariance;
import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;
import org.apache.commons.math3.stat.descriptive.moment.GeometricMean;
import org.apache.commons.math3.stat.descriptive.moment.Kurtosis;
import org.apache.commons.math3.stat.descriptive.moment.Skewness;
import org.apache.commons.math3.stat.descriptive.moment.Variance;
import org.apache.commons.math3.stat.descriptive.rank.Median;
import org.apache.commons.math3.stat.inference.ChiSquareTest;
import org.apache.commons.math3.stat.inference.TTest;
import org.apache.commons.math3.stat.regression.SimpleRegression;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Koen Rooijmans
 */
public class Statistics {

    public static FormulaDecimal avedev(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        // Returns the average of the absolute deviations of data points from their mean.
        // AVEDEV is a measure of the variability in a data set.
        // (returns the mean of deviations from mean).
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);

        FormulaDecimal r = new FormulaDecimal(0);
        FormulaDecimal m = new FormulaDecimal(0);
        FormulaDecimal s = new FormulaDecimal(0);
        for (Number n : array) {
            s = s.add(Formulas.valueOf(n));
        }
        m = s.divide(Formulas.valueOf(array.length));
        s = new FormulaDecimal(0);
        for (Number n : array) {
            s = s.add(Formulas.abs(Formulas.valueOf(n).subtract(m)));
        }
        r = s.divide(Formulas.valueOf(array.length));
        return r;
    }

    public static FormulaDecimal average(Object number, Object... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        if (numbers == null || numbers.length == 0) {
            return Formulas.valueOfObject(number);
        }
        return new FormulaDecimal(Arrays.stream(ArrayHelper.prepend(number, numbers))
                .filter(o -> o instanceof Number)
                .map(n -> Formulas.valueOfObject(n).asBigDecimal())
                .collect(new Formulas.BigDecimalAverageCollector()));
    }

    public static FormulaDecimal averagea(Object number, Object... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        return new FormulaDecimal(Arrays.stream(ArrayHelper.prepend(number, numbers))
                .map(new Function<Object, Object>() {
                    @Override
                    public Object apply(Object o) {
                        return (o instanceof CharSequence) ? 0 : o;
                    }
                })
                .map(new Function<Object, Object>() {
                    @Override
                    public Object apply(Object o) {
                        return o instanceof Boolean ? Integer.valueOf(((Boolean) o).booleanValue() ? 1 : 0) : o;
                    }
                })
                .map(new Function<Object, Object>() {
                    @Override
                    public Object apply(Object o) {
                        return o instanceof Logical ? Integer.valueOf(((Logical) o).booleanValue() ? 1 : 0) : o;
                    }
                })
                .map(new Function<Object, Object>() {
                    @Override
                    public Object apply(Object o) {
                        return o instanceof Date ? 0 : o;
                    }
                })
                .map(n -> Formulas.valueOfObject(n).asBigDecimal())
                .collect(new Formulas.BigDecimalAverageCollector()));
    }

    public static FormulaDecimal averageif(Object... args) {
        if (args == null || args.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }

        int criteriaIndex = Formulas.buildIfCriteriaIndex(args);
        final CharSequence criteria = (CharSequence) args[criteriaIndex];
        final Number[] sumRange = Arrays.stream(args, criteriaIndex + 1, args.length)
                .map(o -> (Number) o)
                .toArray(Number[]::new);
        if (sumRange != null && sumRange.length > 0) {
            final Object[] range = Arrays.stream(args, 0, criteriaIndex)
                    .map(o -> (Object) o)
                    .toArray(Object[]::new);

            return averageif(range, criteria, sumRange);
        } else {
            final Number[] range = Arrays.stream(args, 0, criteriaIndex)
                    .map(o -> (Number) o)
                    .toArray(Number[]::new);

            return averageif(range, criteria, sumRange);
        }
    }

    public static FormulaDecimal averageif(Number[] range, CharSequence criteria, Number... sumRange) {
        if (range == null && (sumRange == null || sumRange.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }

        // TODO not totally according to spec (doesn't support criteria evaluation).
        final Predicate<Number> predicate = Formulas.buildNumericIfPredicate(criteria);

        if (predicate == null) {
            if (sumRange != null && sumRange.length > 0) {
                List<Number> list = new ArrayList<>();
                for (int i = 0; i < range.length; i++) {
                    Number numberToUse = sumRange[i];
                    list.add(numberToUse);
                }
                final Number[] rangeInCriteria = list.toArray(new Number[0]);

                return Formulas.avg(rangeInCriteria[0], Arrays.copyOfRange(rangeInCriteria, 1, rangeInCriteria.length));
            } else {
                return Formulas.avg(range[0], Arrays.copyOfRange(range, 1, range.length));
            }
        } else {
            if (sumRange != null && sumRange.length > 0) {
                List<Number> list = new ArrayList<>();
                for (int i = 0; i < range.length; i++) {
                    Number numberToTest = range[i];
                    Number numberToUse = sumRange[i];
                    if (predicate.test(numberToTest)) {
                        list.add(numberToUse);
                    }
                }
                final Number[] rangeInCriteria = list.toArray(new Number[0]);

                return Formulas.avg(rangeInCriteria[0], Arrays.copyOfRange(rangeInCriteria, 1, rangeInCriteria.length));
            } else {
                final Number[] rangeInCriteria = Arrays.stream(range)
                        .filter(predicate)
                        .toArray(Number[]::new);

                return Formulas.avg(rangeInCriteria[0], Arrays.copyOfRange(rangeInCriteria, 1, rangeInCriteria.length));
            }
        }
    }

    public static FormulaDecimal averageif(Object[] range, CharSequence criteria, Number... sumRange) {
        if (range == null && (sumRange == null || sumRange.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }

        // TODO not totally according to spec (doesn't support criteria evaluation).
        final Predicate<Comparable<?>> predicate = Formulas.buildIfPredicate(criteria);

        if (predicate == null) {
            if (sumRange != null && sumRange.length > 0) {
                List<Number> list = new ArrayList<>();
                for (int i = 0; i < range.length; i++) {
                    Number numberToUse = sumRange[i];
                    list.add(numberToUse);
                }
                final Number[] rangeInCriteria = list.toArray(new Number[0]);

                return Formulas.avg(rangeInCriteria[0], Arrays.copyOfRange(rangeInCriteria, 1, rangeInCriteria.length));
            } else {
                throw new UnsupportedOperationException();
            }
        } else {
            if (sumRange != null && sumRange.length > 0) {
                List<Number> list = new ArrayList<>();
                for (int i = 0; i < range.length; i++) {
                    Object objectToTest = range[i];
                    Number numberToUse = sumRange[i];
                    if (predicate.test((Comparable<?>) objectToTest)) {
                        list.add(numberToUse);
                    }
                }
                final Number[] rangeInCriteria = list.toArray(new Number[0]);

                return Formulas.avg(rangeInCriteria[0], Arrays.copyOfRange(rangeInCriteria, 1, rangeInCriteria.length));
            } else {
                throw new UnsupportedOperationException();
            }
        }
    }

    public static FormulaDecimal averageifs() {
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal beta_dist(Number x, Number alpha, Number beta, Boolean cumulative) {
        return beta_dist(x, alpha, beta, Logical.valueOf(cumulative));
    }

    public static FormulaDecimal beta_dist(Number x, Number alpha, Number beta, Logical cumulative) {
        if (x == null) {
            throw new UniversalException("x", 0, UniversalException.ErrorType.VALUE);
        }
        if (alpha == null) {
            throw new UniversalException("alpha", 1, UniversalException.ErrorType.VALUE);
        }
        if (beta == null) {
            throw new UniversalException("beta", 2, UniversalException.ErrorType.VALUE);
        }
        if (cumulative == null) {
            throw new UniversalException("cumulative", 3, UniversalException.ErrorType.VALUE);
        }

        // @see https://dst.lbl.gov/ACSSoftware/colt/api/index.html
        if (Logical.valueOf(cumulative).booleanValue()) {
            return Formulas.valueOf(new Beta(alpha.doubleValue(), beta.doubleValue(), RandomEngine.makeDefault()).cdf(x.doubleValue()));
        } else {
            return Formulas.valueOf(new Beta(alpha.doubleValue(), beta.doubleValue(), RandomEngine.makeDefault()).pdf(x.doubleValue()));
        }
    }

    public static FormulaDecimal beta_dist(Number x, Number alpha, Number beta, Boolean cumulative, Number a, Number b) {
        return beta_dist(x, alpha, beta, Logical.valueOf(cumulative), a, b);
    }

    public static FormulaDecimal beta_dist(Number x, Number alpha, Number beta, Logical cumulative, Number a, Number b) {
        return beta_dist(Formulas.valueOf(x).subtract(Formulas.valueOf(a).divide(Formulas.valueOf(b).divide(Formulas.valueOf(a)))), alpha, beta, cumulative);
    }

    public static FormulaDecimal beta_inv(Number probability, Number alpha, Number beta) {
        if (probability == null) {
            throw new UniversalException("probability", UniversalException.ErrorType.VALUE);
        }
        if (alpha == null) {
            throw new UniversalException("alpha", UniversalException.ErrorType.VALUE);
        }
        if (beta == null) {
            throw new UniversalException("beta", UniversalException.ErrorType.VALUE);
        }

        return Formulas.valueOf(new BetaDistribution(alpha.doubleValue(), beta.doubleValue()).inverseCumulativeProbability(probability.doubleValue()));
    }

    public static FormulaDecimal beta_inv(Number probability, Number alpha, Number beta, Number a, Number b) {
        return beta_inv(probability, alpha, beta).multiply(Formulas.valueOf(b).subtract(Formulas.valueOf(a))).add(Formulas.valueOf(a));
    }

    public static FormulaDecimal binom_dist(Number successes, Number independentTrials, Number probabilityOfSuccess, Boolean cumulative) {
        return binom_dist(successes, independentTrials, probabilityOfSuccess, Logical.valueOf(cumulative));
    }

    public static FormulaDecimal binom_dist(Number successes, Number independentTrials, Number probabilityOfSuccess, Logical cumulative) {
        if (successes == null) {
            throw new UniversalException("successes", 0, UniversalException.ErrorType.VALUE);
        }
        if (independentTrials == null) {
            throw new UniversalException("independentTrials", 1, UniversalException.ErrorType.VALUE);
        }
        if (probabilityOfSuccess == null) {
            throw new UniversalException("probabilityOfSuccess", 2, UniversalException.ErrorType.VALUE);
        }
        if (cumulative == null) {
            throw new UniversalException("cumulative", 3, UniversalException.ErrorType.VALUE);
        }

        // Returns the individual term binomial distribution probability.
        if (Logical.valueOf(cumulative).booleanValue()) {
            return Formulas.valueOf(new BinomialDistribution(independentTrials.intValue(), probabilityOfSuccess.doubleValue()).cumulativeProbability(successes.intValue()));
        } else {
            return Formulas.valueOf(new BinomialDistribution(independentTrials.intValue(), probabilityOfSuccess.doubleValue()).probability(successes.intValue()));
        }
    }

    public static FormulaDecimal binom_dist_range(Number trials, Number probabilityOfSuccess, Number successes) {
        return binom_dist_range(trials, probabilityOfSuccess, successes, successes);
    }

    public static FormulaDecimal binom_dist_range(Number trials, Number probabilityOfSuccess, Number successesStartRange, Number successesEndRange) {
        if (trials == null) {
            throw new UniversalException("trials", 0, UniversalException.ErrorType.VALUE);
        }
        if (probabilityOfSuccess == null) {
            throw new UniversalException("probabilityOfSuccess", 1, UniversalException.ErrorType.VALUE);
        }
        if (successesStartRange == null) {
            throw new UniversalException("successesStartRange", 2, UniversalException.ErrorType.VALUE);
        }
        if (successesEndRange == null) {
            throw new UniversalException("successesEndRange", 3, UniversalException.ErrorType.VALUE);
        }

        // Returns the probability of a trial result using a binomial distribution.
        FormulaDecimal result = new FormulaDecimal(0);
        for (int i = successesStartRange.intValue(); i <= successesEndRange.intValue(); i++) {
            result = result.add(Formulas.combin(trials, i).multiply(Formulas.power(probabilityOfSuccess, i)).multiply(Formulas.power(Formulas.valueOf(1).subtract(Formulas.valueOf(probabilityOfSuccess)), Formulas.valueOf(trials).subtract(Formulas.valueOf(i)))));
        }
        return Formulas.valueOf(result);
    }

    public static FormulaDecimal binom_inv(Number trials, Number probabilityOfSuccess, Number alpha) {
        if (trials == null) {
            throw new UniversalException("trials", 1, UniversalException.ErrorType.VALUE);
        }
        if (probabilityOfSuccess == null) {
            throw new UniversalException("probabilityOfSuccess", 2, UniversalException.ErrorType.VALUE);
        }
        if (alpha == null) {
            throw new UniversalException("alpha", 3, UniversalException.ErrorType.VALUE);
        }
        return Formulas.valueOf(new BinomialDistribution(trials.intValue(), probabilityOfSuccess.doubleValue()).inverseCumulativeProbability(alpha.doubleValue()));
    }

    public static FormulaDecimal chisq_dist(Number x, Number degreesOfFreedom, Boolean cumulative) {
        return chisq_dist(x, degreesOfFreedom, Logical.valueOf(cumulative));
    }

    public static FormulaDecimal chisq_dist(Number x, Number degreesOfFreedom, Logical cumulative) {
        if (x == null) {
            throw new UniversalException("x", 0, UniversalException.ErrorType.VALUE);
        }
        if (degreesOfFreedom == null) {
            throw new UniversalException("degreesOfFreedom", 1, UniversalException.ErrorType.VALUE);
        }
        if (cumulative == null) {
            throw new UniversalException("cumulative", 2, UniversalException.ErrorType.VALUE);
        }

        if (Logical.valueOf(cumulative).booleanValue()) {
            return Formulas.valueOf(new ChiSquare(degreesOfFreedom.doubleValue(), RandomEngine.makeDefault()).cdf(x.doubleValue()));
        } else {
            return Formulas.valueOf(new ChiSquare(degreesOfFreedom.doubleValue(), RandomEngine.makeDefault()).pdf(x.doubleValue()));
        }
    }

    public static FormulaDecimal chisq_dist_rt(Number x, Number degreesOfFreedom) {
        if (x == null) {
            throw new UniversalException("x", 0, UniversalException.ErrorType.VALUE);
        }
        if (degreesOfFreedom == null) {
            throw new UniversalException("degreesOfFreedom", 1, UniversalException.ErrorType.VALUE);
        }
        return Formulas.valueOf(1).subtract(Formulas.valueOf(new ChiSquare(degreesOfFreedom.doubleValue(), RandomEngine.makeDefault()).cdf(x.doubleValue())));
    }

    public static FormulaDecimal chisq_inv(Number probability, Number degreesOfFreedom) {
        if (probability == null) {
            throw new UniversalException("probability", 0, UniversalException.ErrorType.VALUE);
        }
        if (degreesOfFreedom == null) {
            throw new UniversalException("degreesOfFreedom", 1, UniversalException.ErrorType.VALUE);
        }
        return Formulas.valueOf(new ChiSquaredDistribution(degreesOfFreedom.doubleValue()).inverseCumulativeProbability(probability.doubleValue()));
    }

    public static FormulaDecimal chisq_inv_rt(Number probability, Number degreesOfFreedom) {
        if (probability == null) {
            throw new UniversalException("probability", 0, UniversalException.ErrorType.VALUE);
        }
        if (degreesOfFreedom == null) {
            throw new UniversalException("degreesOfFreedom", 1, UniversalException.ErrorType.VALUE);
        }
        return Formulas.valueOf(new ChiSquaredDistribution(degreesOfFreedom.doubleValue()).inverseCumulativeProbability(Formulas.valueOf(1).subtract(Formulas.valueOf(probability)).doubleValue()));
    }

    public static FormulaDecimal chisq_test(Number[] firstSeries, Number[] secondSeries) {
        if (firstSeries == null || firstSeries.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        if (secondSeries == null || secondSeries.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.join(firstSeries, secondSeries);
        final Number[] range = Arrays.copyOfRange(array, 1, array.length);
        final Number first = array[0];
        return chisq_test(first, range);
    }

    public static FormulaDecimal chisq_test(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        // Returns the test for independence.
        // CHISQ.TEST returns the value from the chi-squared (χ2) distribution for the statistic and the appropriate degrees of freedom.
        // You can use χ2 tests to determine whether hypothesized results are verified by an experiment.
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final Number[] observed = Arrays.copyOfRange(array, 0, array.length / 2);
        final Number[] expected = Arrays.copyOfRange(array, array.length / 2, array.length);
        return Formulas.valueOf(new ChiSquareTest().chiSquareTest(
                ArrayUtils.toPrimitive(Arrays.stream(expected).filter(Objects::nonNull).map(Number::doubleValue).toArray(Double[]::new)),
                ArrayUtils.toPrimitive(Arrays.stream(observed).filter(Objects::nonNull).map(Number::longValue).toArray(Long[]::new))));
    }

    public static FormulaDecimal confidence_norm(Number alpha, Number standardDeviation, Number size) {
        // (1 + abs(norm_inv(alpha/2,0,1)*stdev(standardDeviation)/sqrt(size))) - 1;
        return Formulas.valueOf(1).add(Formulas.abs(norm_inv(Formulas.valueOf(alpha).divide(Formulas.valueOf(2)), 0, 1).multiply(stdev_s(standardDeviation).divide(Formulas.sqrt(size))))).subtract(Formulas.valueOf(1));
    }

    public static FormulaDecimal confidence_t(Number alpha, Number standardDeviation, Number size) {
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal correl(Number[] firstSeries, Number[] secondSeries) {
        if (firstSeries == null || firstSeries.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        if (secondSeries == null || secondSeries.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.join(firstSeries, secondSeries);
        final Number[] range = Arrays.copyOfRange(array, 1, array.length);
        final Number first = array[0];
        return correl(first, range);
    }

    public static FormulaDecimal correl(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final Number[] left = Arrays.copyOfRange(array, 0, array.length / 2);
        final Number[] right = Arrays.copyOfRange(array, array.length / 2, array.length);
        return Formulas.valueOf(new PearsonsCorrelation().correlation(
                ArrayUtils.toPrimitive(Arrays.stream(left).filter(Objects::nonNull).map(Number::doubleValue).toArray(Double[]::new)),
                ArrayUtils.toPrimitive(Arrays.stream(right).filter(Objects::nonNull).map(Number::doubleValue).toArray(Double[]::new))));
    }


    public static FormulaDecimal count() {
        return Formulas.valueOf(0);
    }

    public static FormulaDecimal count(Object number, Object... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        // The COUNT function counts the number of cells that contain numbers, and counts numbers within the list of arguments.
        return Formulas.valueOf(Arrays.stream(ArrayHelper.prepend(number, numbers)).filter(o -> o instanceof Number).count());
    }

    public static FormulaDecimal counta() {
        return Formulas.valueOf(0);
    }

    public static FormulaDecimal counta(Object number, Object... numbers) {
        // The COUNTA function counts the number of cells that are not empty in a range.
        return Formulas.valueOf(Arrays.stream(ArrayHelper.prepend(number, numbers)).filter(new Predicate<Object>() {
            @Override
            public boolean test(Object o) {
                if (o instanceof CharSequence) {
                    return (((CharSequence) o).length() > 0);
                }
                return true;
            }
        }).count());
    }

    public static FormulaDecimal countblank() {
        return new FormulaDecimal(0);
    }

    public static FormulaDecimal countblank(Object number, Object... numbers) {
        return Formulas.valueOf(Arrays.stream(ArrayHelper.prepend(number, numbers)).filter(new Predicate<Object>() {
            @Override
            public boolean test(Object o) {
                if (o == null) {
                    return true;
                }
                if (o instanceof CharSequence) {
                    return (((CharSequence) o).length() <= 0);
                }
                return false;
            }
        }).count());
    }

    public static FormulaDecimal countif() {
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal countifs() {
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal covariance_p(Number[] firstSeries, Number[] secondSeries) {
        if (firstSeries == null || firstSeries.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        if (secondSeries == null || secondSeries.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.join(firstSeries, secondSeries);
        final Number[] range = Arrays.copyOfRange(array, 1, array.length);
        final Number first = array[0];
        return covariance_p(first, range);
    }

    public static FormulaDecimal covariance_p(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final Number[] left = Arrays.copyOfRange(array, 0, array.length / 2);
        final Number[] right = Arrays.copyOfRange(array, array.length / 2, array.length);
        return Formulas.valueOf(new Covariance().covariance(
                ArrayUtils.toPrimitive(Arrays.stream(left).filter(Objects::nonNull).map(Number::doubleValue).toArray(Double[]::new)),
                ArrayUtils.toPrimitive(Arrays.stream(right).filter(Objects::nonNull).map(Number::doubleValue).toArray(Double[]::new)), false));
    }

    public static FormulaDecimal covariance_s(Number[] firstSeries, Number[] secondSeries) {
        if (firstSeries == null || firstSeries.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        if (secondSeries == null || secondSeries.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.join(firstSeries, secondSeries);
        final Number[] range = Arrays.copyOfRange(array, 1, array.length);
        final Number first = array[0];
        return covariance_s(first, range);
    }

    public static FormulaDecimal covariance_s(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final Number[] left = Arrays.copyOfRange(array, 0, array.length / 2);
        final Number[] right = Arrays.copyOfRange(array, array.length / 2, array.length);
        return Formulas.valueOf(new Covariance().covariance(
                ArrayUtils.toPrimitive(Arrays.stream(left).filter(Objects::nonNull).map(Number::doubleValue).toArray(Double[]::new)),
                ArrayUtils.toPrimitive(Arrays.stream(right).filter(Objects::nonNull).map(Number::doubleValue).toArray(Double[]::new))));
    }

    public static FormulaDecimal devsq(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final FormulaDecimal mean = Formulas.mean(number, numbers);
        FormulaDecimal result = Formulas.valueOf(0);
        for (Number n : array) {
            result = result.add(Formulas.power(Formulas.valueOf(n).subtract(mean), 2));
        }
        return result;
    }

    public static FormulaDecimal expon_dist(Number x, Number lambda, Boolean cumulative) {
        return expon_dist(x, lambda, Logical.valueOf(cumulative));
    }

    public static FormulaDecimal expon_dist(Number x, Number lambda, Logical cumulative) {
        if (x == null) {
            throw new UniversalException("x", 0, UniversalException.ErrorType.VALUE);
        }
        if (lambda == null) {
            throw new UniversalException("lambda", 1, UniversalException.ErrorType.VALUE);
        }
        if (cumulative == null) {
            throw new UniversalException("cumulative", 2, UniversalException.ErrorType.VALUE);
        }

        if (Logical.valueOf(cumulative).booleanValue()) {
            return Formulas.valueOf(new Exponential(lambda.doubleValue(), RandomEngine.makeDefault()).cdf(x.doubleValue()));
        } else {
            return Formulas.valueOf(new Exponential(lambda.doubleValue(), RandomEngine.makeDefault()).pdf(x.doubleValue()));
        }
    }

    public static FormulaDecimal f_dist(Number x, Number numeratorDegreesOfFreedom, Number denominatorDegreesOfFreedom, Boolean cumulative) {
        return f_dist(x, numeratorDegreesOfFreedom, denominatorDegreesOfFreedom, Logical.valueOf(cumulative));
    }

    public static FormulaDecimal f_dist(Number x, Number numeratorDegreesOfFreedom, Number denominatorDegreesOfFreedom, Logical cumulative) {
        if (x == null) {
            throw new UniversalException("x", 0, UniversalException.ErrorType.VALUE);
        }
        if (numeratorDegreesOfFreedom == null) {
            throw new UniversalException("numeratorDegreesOfFreedom", 1, UniversalException.ErrorType.VALUE);
        }
        if (denominatorDegreesOfFreedom == null) {
            throw new UniversalException("denominatorDegreesOfFreedom", 2, UniversalException.ErrorType.VALUE);
        }
        if (cumulative == null) {
            throw new UniversalException("cumulative", 3, UniversalException.ErrorType.VALUE);
        }

        if (Logical.valueOf(cumulative).booleanValue()) {
            return Formulas.valueOf(new FDistribution(numeratorDegreesOfFreedom.doubleValue(), denominatorDegreesOfFreedom.doubleValue()).cumulativeProbability(x.doubleValue()));
        } else {
            return Formulas.valueOf(new FDistribution(numeratorDegreesOfFreedom.intValue(), denominatorDegreesOfFreedom.doubleValue()).density(x.doubleValue()));
        }
    }

    public static FormulaDecimal f_dist_rt(Number x, Number numeratorDegreesOfFreedom, Number denominatorDegreesOfFreedom) {
        if (x == null) {
            throw new UniversalException("x", 0, UniversalException.ErrorType.VALUE);
        }
        if (numeratorDegreesOfFreedom == null) {
            throw new UniversalException("numeratorDegreesOfFreedom", 1, UniversalException.ErrorType.VALUE);
        }
        if (denominatorDegreesOfFreedom == null) {
            throw new UniversalException("denominatorDegreesOfFreedom", 2, UniversalException.ErrorType.VALUE);
        }

        return Formulas.valueOf(1).subtract(Formulas.valueOf(new FDistribution(numeratorDegreesOfFreedom.intValue(), denominatorDegreesOfFreedom.doubleValue()).cumulativeProbability(x.doubleValue())));
    }

    public static FormulaDecimal f_inv(Number probability, Number numeratorDegreesOfFreedom, Number denominatorDegreesOfFreedom) {
        if (probability == null) {
            throw new UniversalException("probability", 0, UniversalException.ErrorType.VALUE);
        }
        if (numeratorDegreesOfFreedom == null) {
            throw new UniversalException("numeratorDegreesOfFreedom", 1, UniversalException.ErrorType.VALUE);
        }
        if (denominatorDegreesOfFreedom == null) {
            throw new UniversalException("denominatorDegreesOfFreedom", 2, UniversalException.ErrorType.VALUE);
        }

        return Formulas.valueOf(new FDistribution(numeratorDegreesOfFreedom.intValue(), denominatorDegreesOfFreedom.doubleValue()).inverseCumulativeProbability(probability.doubleValue()));
    }

    public static FormulaDecimal f_inv_rt(Number probability, Number numeratorDegreesOfFreedom, Number denominatorDegreesOfFreedom) {
        if (probability == null) {
            throw new UniversalException("probability", 0, UniversalException.ErrorType.VALUE);
        }
        if (numeratorDegreesOfFreedom == null) {
            throw new UniversalException("numeratorDegreesOfFreedom", 1, UniversalException.ErrorType.VALUE);
        }
        if (denominatorDegreesOfFreedom == null) {
            throw new UniversalException("denominatorDegreesOfFreedom", 2, UniversalException.ErrorType.VALUE);
        }

        return Formulas.valueOf(new FDistribution(numeratorDegreesOfFreedom.intValue(), denominatorDegreesOfFreedom.doubleValue()).inverseCumulativeProbability(Formulas.valueOf(1).subtract(Formulas.valueOf(probability)).doubleValue()));
    }

    public static FormulaDecimal f_test(Number[] firstSeries, Number[] secondSeries) {
        if (firstSeries == null || firstSeries.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        if (secondSeries == null || secondSeries.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.join(firstSeries, secondSeries);
        final Number[] range = Arrays.copyOfRange(array, 1, array.length);
        final Number first = array[0];
        return f_test(first, range);
    }

    public static FormulaDecimal f_test(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final Number[] left = Arrays.copyOfRange(array, 0, array.length / 2);
        final Number[] right = Arrays.copyOfRange(array, array.length / 2, array.length);

        final FormulaDecimal x1 = Formulas.sum(left[0], Arrays.copyOfRange(left, 1, left.length)).divide(Formulas.valueOf(left.length));
        final FormulaDecimal x2 = Formulas.sum(right[0], Arrays.copyOfRange(right, 1, right.length)).divide(Formulas.valueOf(right.length));

        FormulaDecimal sum1 = sumOfSquares(x1, left).divide(Formulas.valueOf(left.length - 1));
        FormulaDecimal sum2 = sumOfSquares(x2, right).divide(Formulas.valueOf(right.length - 1));

        return sum1.divide(sum2);
    }

    public static FormulaDecimal sumOfSquares(Number x, Number... numbers) {
        if (x == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        FormulaDecimal sum = Formulas.valueOf(0);
        if (numbers != null) {
            for (Number n : numbers) {
                sum = sum.add(Formulas.power(Formulas.valueOf(n).subtract(Formulas.valueOf(x)), 2));
            }
        }
        return sum;
    }

    public static FormulaDecimal fisher(Number x) {
        if (x == null) {
            throw new UniversalException("x", 0, UniversalException.ErrorType.VALUE);
        }

        return Formulas.valueOf(Formulas.log(Formulas.valueOf(1).add(Formulas.valueOf(x)).divide(Formulas.valueOf(1).subtract(Formulas.valueOf(x)))).divide(Formulas.valueOf(2)));
    }

    public static FormulaDecimal fisherinv(Number y) {
        if (y == null) {
            throw new UniversalException("y", 0, UniversalException.ErrorType.VALUE);
        }

        final FormulaDecimal e2y = Formulas.valueOf(Formulas.exp(Formulas.valueOf(2).multiply(Formulas.valueOf(y))));
        return e2y.subtract(Formulas.valueOf(1)).divide(e2y.add(Formulas.valueOf(1)));
    }

    public static FormulaDecimal forecast(Number x, Number... numbers) {
        if (x == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException("x", 0, UniversalException.ErrorType.VALUE);
        }
        if (numbers == null || numbers.length == 0) {
            throw new UniversalException("knownY", 1, UniversalException.ErrorType.VALUE);
        }
        if (numbers.length < 2) {
            throw new UniversalException("knownY", 2, UniversalException.ErrorType.VALUE);
        }

        final Number[] dataY = Arrays.copyOfRange(numbers, 0, numbers.length / 2);
        final Number[] dataX = Arrays.copyOfRange(numbers, numbers.length / 2, numbers.length);

        final FormulaDecimal xMean = Formulas.mean(dataX[0], Arrays.copyOfRange(dataX, 1, dataX.length));
        final FormulaDecimal yMean = Formulas.mean(dataY[0], Arrays.copyOfRange(dataY, 1, dataY.length));
        FormulaDecimal numerator = Formulas.valueOf(0);
        FormulaDecimal denominator = Formulas.valueOf(0);
        if (dataX.length != dataY.length) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        int n = Math.max(dataX.length, dataY.length);
        for (int i = 0; i < n; i++) {
            numerator = numerator.add(Formulas.valueOf(dataX[i]).subtract(xMean).multiply(Formulas.valueOf(dataY[i]).subtract(yMean)));
            denominator = Formulas.power(Formulas.valueOf(dataX[i]).subtract(xMean), 2);
        }
        final FormulaDecimal b = numerator.divide(denominator);
        final FormulaDecimal a = yMean.subtract(b.multiply(xMean));

        return a.add(b.multiply(Formulas.valueOf(x)));
    }

    public static FormulaDecimal forecast_ets() {
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal forecast_ets_confint() {
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal forecast_ets_seasonality() {
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal forecast_ets_stat() {
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal forecast_linear() {
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal frequency() {
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal gamma(Number number) {
        if (number == null) {
            throw new UniversalException("gamma", 0, UniversalException.ErrorType.VALUE);
        }
        return Formulas.valueOf(Gamma.gamma(number.doubleValue()));
    }

    public static FormulaDecimal gamma_dist(Number x, Number alpha, Number beta, Boolean cumulative) {
        return gamma_dist(x, alpha, beta, Logical.valueOf(cumulative));
    }

    public static FormulaDecimal gamma_dist(Number x, Number alpha, Number beta, Logical cumulative) {
        if (x == null) {
            throw new UniversalException("x", 0, UniversalException.ErrorType.VALUE);
        }
        if (alpha == null) {
            throw new UniversalException("alpha", 1, UniversalException.ErrorType.VALUE);
        }
        if (beta == null) {
            throw new UniversalException("beta", 2, UniversalException.ErrorType.VALUE);
        }
        if (cumulative == null) {
            throw new UniversalException("cumulative", 3, UniversalException.ErrorType.VALUE);
        }

        if (Logical.valueOf(cumulative).booleanValue()) {
            return Formulas.valueOf(new GammaDistribution(alpha.doubleValue(), beta.doubleValue()).cumulativeProbability(x.doubleValue()));
        } else {
            return Formulas.valueOf(new GammaDistribution(alpha.doubleValue(), beta.doubleValue()).density(x.doubleValue()));
        }
    }

    public static FormulaDecimal gamma_inv(Number probability, Number alpha, Number beta) {
        if (probability == null) {
            throw new UniversalException("probability", 0, UniversalException.ErrorType.VALUE);
        }
        if (alpha == null) {
            throw new UniversalException("alpha", 1, UniversalException.ErrorType.VALUE);
        }
        if (beta == null) {
            throw new UniversalException("beta", 2, UniversalException.ErrorType.VALUE);
        }

        return Formulas.valueOf(new GammaDistribution(alpha.doubleValue(), beta.doubleValue()).inverseCumulativeProbability(probability.doubleValue()));
    }

    public static FormulaDecimal gammaln(Number x) {
        if (x == null) {
            throw new UniversalException("x", 0, UniversalException.ErrorType.VALUE);
        }

        return Formulas.valueOf(Gamma.logGamma(x.doubleValue()));
    }

    public static FormulaDecimal gammaln_precise(Number x) {
        if (x == null) {
            throw new UniversalException("x", 0, UniversalException.ErrorType.VALUE);
        }

        return Formulas.valueOf(Gamma.logGamma(x.doubleValue()));
    }

    public static FormulaDecimal gauss(Number gauss) {
        if (gauss == null) {
            throw new UniversalException("gauss", 0, UniversalException.ErrorType.VALUE);
        }

        return Formulas.valueOf(new NormalDistribution(0, 1).cumulativeProbability(gauss.doubleValue())).subtract(Formulas.valueOf(0.5));
    }

    public static FormulaDecimal geomean(Number x, Number... numbers) {
        if (x == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, x, numbers);
        return Formulas.valueOf(new GeometricMean().evaluate(ArrayUtils.toPrimitive(Arrays.stream(array).filter(Objects::nonNull).map(Number::doubleValue).toArray(Double[]::new))));
    }

    public static FormulaDecimal growth() {
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal harmean(Number x, Number... numbers) {
        if (x == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, x, numbers);
        FormulaDecimal sum = Formulas.valueOf(0);
        for (Number n : array) {
            sum = sum.add(Formulas.valueOf(1).divide(Formulas.valueOf(n)));
        }
        return Formulas.valueOf(array.length).divide(sum);

    }

    public static FormulaDecimal hypgeom_dist(Number successesInSample, Number sizeOfSample, Number successesInPopulation, Number populationSize, Boolean cumulative) {
        return hypgeom_dist(successesInSample, sizeOfSample, successesInPopulation, populationSize, Logical.valueOf(cumulative));
    }

    public static FormulaDecimal hypgeom_dist(Number successesInSample, Number sizeOfSample, Number successesInPopulation, Number populationSize, Logical cumulative) {
        if (successesInSample == null) {
            throw new UniversalException("successesInSample", 0, UniversalException.ErrorType.VALUE);
        }
        if (sizeOfSample == null) {
            throw new UniversalException("sizeOfSample", 1, UniversalException.ErrorType.VALUE);
        }
        if (successesInPopulation == null) {
            throw new UniversalException("successesInPopulation", 2, UniversalException.ErrorType.VALUE);
        }
        if (populationSize == null) {
            throw new UniversalException("populationSize", 3, UniversalException.ErrorType.VALUE);
        }
        if (cumulative == null) {
            throw new UniversalException("cumulative", 4, UniversalException.ErrorType.VALUE);
        }

        if (Logical.valueOf(cumulative).booleanValue()) {
            return Formulas.valueOf(new HypergeometricDistribution(populationSize.intValue(), successesInPopulation.intValue(), sizeOfSample.intValue()).cumulativeProbability(successesInSample.intValue()));
        } else {
            return Formulas.valueOf(new HypergeometricDistribution(populationSize.intValue(), successesInPopulation.intValue(), sizeOfSample.intValue()).probability(successesInSample.intValue()));
        }
    }

    public static FormulaDecimal intercept(Number[] firstSeries, Number[] secondSeries) {
        if (firstSeries == null || firstSeries.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        if (secondSeries == null || secondSeries.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.join(firstSeries, secondSeries);
        final Number[] range = Arrays.copyOfRange(array, 1, array.length);
        final Number first = array[0];
        return intercept(first, range);
    }

    public static FormulaDecimal intercept(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final Number[] knownY = Arrays.copyOfRange(array, 0, array.length / 2);
        final Number[] knownX = Arrays.copyOfRange(array, array.length / 2, array.length);

        return forecast(0, ArrayHelper.join(knownY, knownX));
    }

    public static FormulaDecimal kurt(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        return Formulas.valueOf(new Kurtosis().evaluate(ArrayUtils.toPrimitive(Arrays.stream(array).filter(Objects::nonNull).map(Number::doubleValue).toArray(Double[]::new))));
    }

    public static FormulaDecimal large(Number[] numbers, Number number) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.append(Number.class, number, numbers);
        final Number[] range = Arrays.copyOfRange(array, 1, array.length);
        final Number first = array[0];
        return large(first, range);
    }

    public static FormulaDecimal large(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        if (numbers == null || numbers.length == 0) {
            return Formulas.valueOf(number);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final Number k = array[array.length - 1];
        if (k == null) {
            throw new UniversalException("k", 1, UniversalException.ErrorType.VALUE);
        }
        if (Formulas.valueOf(k).compareTo(Formulas.valueOf(numbers.length).subtract(Formulas.valueOf(1))) > 0) {
            throw new UniversalException("k", 1, UniversalException.ErrorType.VALUE, new ArrayIndexOutOfBoundsException(Formulas.valueOf(number).intValue()));
        }
        final Number[] range = Arrays.copyOfRange(array, 0, array.length - 1);
        if (Formulas.valueOf(k).compareTo(BigDecimal.ONE) == 0) {
            return max(range[0], Arrays.copyOfRange(range, 1, range.length));
        } else {
            final List<Number> sortedList = Arrays.asList(ArrayHelper.prepend(Number.class, number, numbers));
            sortedList.sort(Comparator.nullsFirst(Comparator.comparing(o -> Formulas.valueOf(o).asBigDecimal())));
            return Formulas.valueOf(sortedList.get(Math.min(sortedList.size() - 1, Math.max(0, k.intValue()))));
        }
    }

    public static FormulaDecimal linest() {
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal logest() {
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal lognorm_dist(Number x, Number mean, Number standardDeviation, Boolean cumulative) {
        return lognorm_dist(x, mean, standardDeviation, Logical.valueOf(cumulative));
    }

    public static FormulaDecimal lognorm_dist(Number x, Number mean, Number standardDeviation, Logical cumulative) {
        if (x == null) {
            throw new UniversalException("x", 0, UniversalException.ErrorType.VALUE);
        }
        if (mean == null) {
            throw new UniversalException("mean", 1, UniversalException.ErrorType.VALUE);
        }
        if (standardDeviation == null) {
            throw new UniversalException("standardDeviation", 2, UniversalException.ErrorType.VALUE);
        }
        if (cumulative == null) {
            throw new UniversalException("cumulative", 3, UniversalException.ErrorType.VALUE);
        }

        if (Logical.valueOf(cumulative).booleanValue()) {
            return Formulas.valueOf(new LogNormalDistribution(mean.doubleValue(), standardDeviation.doubleValue()).cumulativeProbability(x.doubleValue()));
        } else {
            return Formulas.valueOf(new LogNormalDistribution(mean.doubleValue(), standardDeviation.doubleValue()).density(x.doubleValue()));
        }
    }

    public static FormulaDecimal lognorm_inv(Number probability, Number mean, Number standardDeviation) {
        if (probability == null) {
            throw new UniversalException("probability", 0, UniversalException.ErrorType.VALUE);
        }
        if (mean == null) {
            throw new UniversalException("mean", 1, UniversalException.ErrorType.VALUE);
        }
        if (standardDeviation == null) {
            throw new UniversalException("standardDeviation", 2, UniversalException.ErrorType.VALUE);
        }

        return Formulas.valueOf(new LogNormalDistribution(mean.doubleValue(), standardDeviation.doubleValue()).inverseCumulativeProbability(probability.doubleValue()));
    }

    public static FormulaDecimal max() {
        return Formulas.valueOf(0);
    }

    public static FormulaDecimal max(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        if (numbers == null || numbers.length == 0) {
            return Formulas.valueOf(number);
        }
        if (number == null && numbers.length == 1) {
            return Formulas.valueOf(numbers[0]);
        }
        return Formulas.valueOf(Collections.max(Arrays.asList(ArrayHelper.prepend(Number.class, number, numbers)),
                Comparator.nullsFirst(Comparator.comparing(o -> Formulas.valueOf(o).asBigDecimal()))));
    }

    public static FormulaDecimal max(Object number, Object... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        if (numbers == null || numbers.length == 0) {
            return Formulas.valueOfObject(number);
        }
        if (number == null && numbers.length == 1) {
            return Formulas.valueOfObject(numbers[0]);
        }
        return Formulas.valueOf(Collections.max(Arrays.stream(ArrayHelper.prepend(number, numbers))
                        .filter(o -> o instanceof Number)
                        .map(o -> (Number) o)
                        .collect(Collectors.toList()),
                Comparator.nullsFirst(Comparator.nullsFirst(Comparator.comparing(o -> Formulas.valueOf(o).asBigDecimal())))));
    }

    public static FormulaDecimal maxa() {
        return Formulas.valueOf(0);
    }

    public static FormulaDecimal maxa(Object number, Object... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        if (numbers == null || numbers.length == 0) {
            return Formulas.valueOfObject(number);
        }
        if (number == null && numbers.length == 1) {
            return Formulas.valueOfObject(numbers[0]);
        }
        return Formulas.valueOf(Collections.max(Arrays.stream(ArrayHelper.prepend(number, numbers))
                        .map(new Function<Object, Object>() {
                            @Override
                            public Object apply(Object o) {
                                if (o instanceof Boolean) {
                                    return (Boolean) o ? 1 : 0;
                                } else if (o instanceof Logical) {
                                    return ((Logical) o).booleanValue() ? 1 : 0;
                                }
                                return o;
                            }
                        })
                        .filter(o -> o instanceof Number)
                        .map(o -> (Number) o)
                        .collect(Collectors.toList()),
                Comparator.nullsFirst(Comparator.comparing(o -> Formulas.valueOf(o).asBigDecimal()))));
    }

    public static FormulaDecimal maxifs() {
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal median(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        if (numbers == null || numbers.length == 0) {
            return Formulas.valueOf(number);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        return Formulas.valueOf(new Median().evaluate(ArrayUtils.toPrimitive(Arrays.stream(array).filter(Objects::nonNull).map(Number::doubleValue).toArray(Double[]::new))));
    }

    public static FormulaDecimal min() {
        return Formulas.valueOf(0);
    }

    public static FormulaDecimal min(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        if (numbers == null || numbers.length == 0) {
            return Formulas.valueOf(number);
        }
        if (number == null && numbers.length == 1) {
            return Formulas.valueOf(numbers[0]);
        }
        return Formulas.valueOf(Collections.min(Arrays.asList(ArrayHelper.prepend(Number.class, number, numbers)),
                Comparator.nullsFirst(Comparator.comparing(o -> Formulas.valueOf(o).asBigDecimal()))));
    }

    public static FormulaDecimal min(Object number, Object... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        if (numbers == null || numbers.length == 0) {
            return Formulas.valueOfObject(number);
        }
        if (number == null && numbers.length == 1) {
            return Formulas.valueOfObject(numbers[0]);
        }
        return Formulas.valueOf(Collections.min(Arrays.stream(ArrayHelper.prepend(number, numbers))
                        .filter(o -> o instanceof Number)
                        .map(o -> (Number) o)
                        .collect(Collectors.toList()),
                Comparator.nullsFirst(Comparator.comparing(o -> Formulas.valueOf(o).asBigDecimal()))));
    }

    public static FormulaDecimal mina() {
        return Formulas.valueOf(0);
    }

    public static FormulaDecimal mina(Object number, Object... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        if (numbers == null || numbers.length == 0) {
            return Formulas.valueOfObject(number);
        }
        if (number == null && numbers.length == 1) {
            return Formulas.valueOfObject(numbers[0]);
        }
        return Formulas.valueOf(Collections.min(Arrays.stream(ArrayHelper.prepend(number, numbers))
                        .map(new Function<Object, Object>() {
                            @Override
                            public Object apply(Object o) {
                                if (o instanceof Boolean) {
                                    return (Boolean) o ? 1 : 0;
                                } else if (o instanceof Logical) {
                                    return ((Logical) o).booleanValue() ? 1 : 0;
                                }
                                return o;
                            }
                        })
                        .filter(o -> o instanceof Number)
                        .map(o -> (Number) o)
                        .collect(Collectors.toList()),
                Comparator.nullsFirst(Comparator.comparing(o -> Formulas.valueOf(o).asBigDecimal()))));
    }

    public static FormulaDecimal minifs() {
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal[] mode_mult(Number number, Number... numbers) {
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal[] mode_sngl(Number number, Number... numbers) {
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal negbinom_dist(Number failures, Number numberOfSuccesses, Number probabilityOfSuccess, Boolean cumulative) {
        return negbinom_dist(failures, numberOfSuccesses, probabilityOfSuccess, Logical.valueOf(cumulative));
    }

    public static FormulaDecimal negbinom_dist(Number failures, Number thresholdNumberOfSuccesses, Number probabilityOfSuccess, Logical cumulative) {
        if (failures == null) {
            throw new UniversalException("failures", 0, UniversalException.ErrorType.VALUE);
        }
        if (thresholdNumberOfSuccesses == null) {
            throw new UniversalException("thresholdNumberOfSuccesses", 1, UniversalException.ErrorType.VALUE);
        }
        if (probabilityOfSuccess == null) {
            throw new UniversalException("probabilityOfSuccess", 2, UniversalException.ErrorType.VALUE);
        }
        if (cumulative == null) {
            throw new UniversalException("cumulative", 3, UniversalException.ErrorType.VALUE);
        }

        // @see https://dst.lbl.gov/ACSSoftware/colt/api/cern/jet/random/NegativeBinomial.html
        if (Logical.valueOf(cumulative).booleanValue()) {
            return Formulas.valueOf(new NegativeBinomial(thresholdNumberOfSuccesses.intValue(), probabilityOfSuccess.doubleValue(), RandomEngine.makeDefault()).cdf(failures.intValue()));
        } else {
            // TODO this is (probably) wrong..
            return Formulas.valueOf(new NegativeBinomial(failures.intValue(), probabilityOfSuccess.doubleValue(), RandomEngine.makeDefault()).pdf(thresholdNumberOfSuccesses.intValue()));
        }
    }

    public static FormulaDecimal norm_dist(Number x, Number mean, Number standardDeviation, Boolean cumulative) {
        return norm_dist(x, mean, standardDeviation, Logical.valueOf(cumulative));
    }

    public static FormulaDecimal norm_dist(Number x, Number mean, Number standardDeviation, Logical cumulative) {
        if (x == null) {
            throw new UniversalException("x", 0, UniversalException.ErrorType.VALUE);
        }
        if (mean == null) {
            throw new UniversalException("mean", 1, UniversalException.ErrorType.VALUE);
        }
        if (standardDeviation == null) {
            throw new UniversalException("standardDeviation", 2, UniversalException.ErrorType.VALUE);
        }
        if (cumulative == null) {
            throw new UniversalException("cumulative", 3, UniversalException.ErrorType.VALUE);
        }

        if (Logical.valueOf(cumulative).booleanValue()) {
            return Formulas.valueOf(new NormalDistribution(mean.doubleValue(), standardDeviation.doubleValue()).cumulativeProbability(x.doubleValue()));
        } else {
            return Formulas.valueOf(new NormalDistribution(mean.doubleValue(), standardDeviation.doubleValue()).density(x.doubleValue()));
        }
    }

    public static FormulaDecimal norm_inv(Number probability, Number mean, Number standardDeviation) {
        if (probability == null) {
            throw new UniversalException("probability", 0, UniversalException.ErrorType.VALUE);
        }
        if (mean == null) {
            throw new UniversalException("mean", 1, UniversalException.ErrorType.VALUE);
        }
        if (standardDeviation == null) {
            throw new UniversalException("standardDeviation", 2, UniversalException.ErrorType.VALUE);
        }

        return Formulas.valueOf(new NormalDistribution(mean.doubleValue(), standardDeviation.doubleValue()).inverseCumulativeProbability(probability.doubleValue()));
    }

    public static FormulaDecimal norm_s_dist(Number z, Boolean cumulative) {
        return norm_s_dist(z, Logical.valueOf(cumulative));
    }

    public static FormulaDecimal norm_s_dist(Number z, Logical cumulative) {
        return norm_dist(z, 0, 1, cumulative);
    }

    public static FormulaDecimal norm_s_inv(Number probability) {
        return norm_inv(probability, 0, 1);
    }

    public static FormulaDecimal pearson(Number[] firstSeries, Number[] secondSeries) {
        if (firstSeries == null || firstSeries.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        if (secondSeries == null || secondSeries.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.join(firstSeries, secondSeries);
        final Number[] range = Arrays.copyOfRange(array, 1, array.length);
        final Number first = array[0];
        return pearson(first, range);
    }

    public static FormulaDecimal pearson(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final Number[] left = Arrays.copyOfRange(array, 0, array.length / 2);
        final Number[] right = Arrays.copyOfRange(array, array.length / 2, array.length);
        return Formulas.valueOf(new PearsonsCorrelation().correlation(
                ArrayUtils.toPrimitive(Arrays.stream(left).filter(Objects::nonNull).map(Number::doubleValue).toArray(Double[]::new)),
                ArrayUtils.toPrimitive(Arrays.stream(right).filter(Objects::nonNull).map(Number::doubleValue).toArray(Double[]::new))));
    }

    public static FormulaDecimal percentile_exc(Number[] numbers, Number number) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.append(Number.class, number, numbers);
        final Number[] range = Arrays.copyOfRange(array, 1, array.length);
        final Number first = array[0];
        return percentile_exc(first, range);
    }

    public static FormulaDecimal percentile_exc(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final Number[] range = Arrays.copyOfRange(array, 0, array.length - 1);
        final Number k = array[array.length - 1];
        if (k == null) {
            throw new UniversalException("k", 1, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(k).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("k", 1, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(k).compareTo(BigDecimal.ONE) > 0) {
            throw new UniversalException("k", 1, UniversalException.ErrorType.VALUE);
        }
        final List<Number> sortedList = Arrays.asList(range);
        sortedList.sort(Comparator.nullsFirst(Comparator.comparing(o -> Formulas.valueOf(o).asBigDecimal())));
        final FormulaDecimal l = Formulas.valueOf(k).multiply(Formulas.valueOf(range.length + 1)).subtract(Formulas.valueOf(1));
        final FormulaDecimal fl = Formulas.floor(l);
        return Objects.equals(l, fl) ? Formulas.valueOf(range[l.intValue()]) : Formulas.valueOf(range[fl.intValue()]).add(l.subtract(fl)).multiply(Formulas.valueOf(range[fl.intValue() + 1]).subtract(Formulas.valueOf(range[fl.intValue()])));
    }

    public static FormulaDecimal percentile_inc(Number[] numbers, Number number) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.append(Number.class, number, numbers);
        final Number[] range = Arrays.copyOfRange(array, 1, array.length);
        final Number first = array[0];
        return percentile_inc(first, range);
    }

    public static FormulaDecimal percentile_inc(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final Number[] range = Arrays.copyOfRange(array, 0, array.length - 1);
        final Number k = array[array.length - 1];
        if (k == null) {
            throw new UniversalException("k", 1, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(k).compareTo(BigDecimal.ZERO) < 0) {
            throw new UniversalException("k", 1, UniversalException.ErrorType.VALUE);
        } else if (Formulas.valueOf(k).compareTo(BigDecimal.ONE) > 0) {
            throw new UniversalException("k", 1, UniversalException.ErrorType.VALUE);
        }
        final List<Number> sortedList = Arrays.asList(range);
        sortedList.sort(Comparator.nullsFirst(Comparator.comparing(o -> Formulas.valueOf(o).asBigDecimal())));
        final FormulaDecimal l = Formulas.valueOf(k).multiply(Formulas.valueOf(range.length - 1));
        final FormulaDecimal fl = Formulas.floor(l);
        return Objects.equals(l, fl) ? Formulas.valueOf(range[l.intValue()]) : Formulas.valueOf(range[fl.intValue()]).add(l.subtract(fl)).multiply(Formulas.valueOf(range[fl.intValue() + 1]).subtract(Formulas.valueOf(range[fl.intValue()])));
    }

    public static FormulaDecimal percentrank_exc(Number[] numbers, Number number) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.append(Number.class, number, numbers);
        final Number[] range = Arrays.copyOfRange(array, 1, array.length);
        final Number first = array[0];
        return percentrank_exc(first, range);
    }

    public static FormulaDecimal percentrank_exc(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        // TODO support Significance (@see https://support.office.com/en-us/article/percentrank-exc-function-d8afee96-b7e2-4a2f-8c01-8fcdedaa6314?ui=en-US&rs=en-US&ad=US)
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final Number[] range = Arrays.copyOfRange(array, 0, array.length - 1);
        final Number k = array[array.length - 1];
        final List<Number> sortedList = Arrays.asList(range);
        sortedList.sort(Comparator.nullsFirst(Comparator.comparing(o -> Formulas.valueOf(o).asBigDecimal())));

        FormulaDecimal[] uniques = unique(range);
        int n = range.length;
        int m = uniques.length;
        FormulaDecimal significance = Formulas.valueOf(3);
        FormulaDecimal power = Formulas.power(10, significance);
        FormulaDecimal result = Formulas.valueOf(0);
        boolean match = false;
        int i = 0;
        while (!match && i < m) {
            if (Objects.equals(Formulas.valueOf(k), uniques[i])) {
                result = Formulas.valueOf(Arrays.asList(range).indexOf(uniques[i]) + 1).divide(Formulas.valueOf(n).add(Formulas.valueOf(1)));
                match = true;
            } else if (k.doubleValue() >= uniques[i].doubleValue() && (k.doubleValue() < uniques[i + 1].doubleValue() || Objects.equals(i, m - 1))) {
                result = Formulas.valueOf(Arrays.asList(range).indexOf(uniques[i]) + 1).add(Formulas.valueOf(1)).add(Formulas.valueOf(k).subtract(uniques[i]).divide(uniques[i + 1].subtract(uniques[i]))).divide(Formulas.valueOf(n + 1));
                match = true;
            }
            i++;
        }

        return Formulas.floor(result.multiply(power)).divide(power);
    }

    public static FormulaDecimal percentrank_inc(Number[] numbers, Number number) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.append(Number.class, number, numbers);
        final Number[] range = Arrays.copyOfRange(array, 1, array.length);
        final Number first = array[0];
        return percentrank_inc(first, range);
    }

    public static FormulaDecimal percentrank_inc(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        // TODO support Significance (@see https://support.office.com/en-us/article/percentrank-inc-function-149592c9-00c0-49ba-86c1-c1f45b80463a?ui=en-US&rs=en-US&ad=US)
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final Number[] range = Arrays.copyOfRange(array, 0, array.length - 1);
        final Number k = array[array.length - 1];
        final List<Number> sortedList = Arrays.asList(range);
        sortedList.sort(Comparator.nullsFirst(Comparator.comparing(o -> Formulas.valueOf(o).asBigDecimal())));

        FormulaDecimal[] uniques = unique(range);
        int n = range.length;
        int m = uniques.length;
        FormulaDecimal significance = Formulas.valueOf(3);
        FormulaDecimal power = Formulas.power(10, significance);
        FormulaDecimal result = Formulas.valueOf(0);
        boolean match = false;
        int i = 0;
        while (!match && i < m) {
            if (Objects.equals(Formulas.valueOf(k), uniques[i])) {
                result = Formulas.valueOf(Arrays.asList(range).indexOf(uniques[i])).divide(Formulas.valueOf(n).subtract(Formulas.valueOf(1)));
                match = true;
            } else if (k.doubleValue() >= uniques[i].doubleValue() && (k.doubleValue() < uniques[i + 1].doubleValue() || Objects.equals(i, m - 1))) {
                result = Formulas.valueOf(Arrays.asList(range).indexOf(uniques[i])).add(Formulas.valueOf(1)).add(Formulas.valueOf(k).subtract(uniques[i]).divide(uniques[i + 1].subtract(uniques[i]))).divide(Formulas.valueOf(n - 1));
                match = true;
            }
            i++;
        }

        return Formulas.floor(result.multiply(power)).divide(power);
    }

    private static FormulaDecimal[] unique(Number[] range) {
        if (range == null || range.length == 0) {
            return new FormulaDecimal[0];
        }
        return Arrays.stream(range)
                .map(Formulas::valueOf)
                .distinct()
                .toArray(FormulaDecimal[]::new);
    }

    public static FormulaDecimal permut(Number number, Number numberChosen) {
        return Formulas.fact(number).divide(Formulas.fact(Formulas.valueOf(number).subtract(Formulas.valueOf(numberChosen))));
    }

    public static FormulaDecimal permutationa(Number number, Number numberChosen) {
        return Formulas.power(number, numberChosen);
    }

    public static FormulaDecimal phi(Number x) {
        if (x == null) {
            throw new UniversalException("x", 0, UniversalException.ErrorType.VALUE);
        }
        return Formulas.valueOf(new Gaussian().value(x.doubleValue()));
    }

    public static FormulaDecimal poisson_dist(Number x, Number mean, Boolean cumulative) {
        return poisson_dist(x, mean, Logical.valueOf(cumulative));
    }

    public static FormulaDecimal poisson_dist(Number x, Number mean, Logical cumulative) {
        if (x == null) {
            throw new UniversalException("x", 0, UniversalException.ErrorType.VALUE);
        }
        if (mean == null) {
            throw new UniversalException("mean", 1, UniversalException.ErrorType.VALUE);
        }
        if (cumulative == null) {
            throw new UniversalException("cumulative", 2, UniversalException.ErrorType.VALUE);
        }

        if (Logical.valueOf(cumulative).booleanValue()) {
            return Formulas.valueOf(new PoissonDistribution(mean.doubleValue()).cumulativeProbability(x.intValue()));
        } else {
            return Formulas.valueOf(new PoissonDistribution(mean.doubleValue()).probability(x.intValue()));
        }
    }

    public static FormulaDecimal prob(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final Number[] range;
        final Number lowerLimit;
        final Number upperLimit;
        if (array.length % 2 == 0) {
            // assume it has lower_limit and upper_limit
            range = Arrays.copyOfRange(array, 0, array.length - 2);
            lowerLimit = array[array.length - 2];
            upperLimit = array[array.length - 1];
        } else {
            // assume it has only the lower_limit
            range = Arrays.copyOfRange(array, 0, array.length - 1);
            lowerLimit = array[array.length - 1];
            upperLimit = lowerLimit;
        }

        if (lowerLimit == null) {
            throw new UniversalException("lowerLimit", 2, UniversalException.ErrorType.NA);
        }

        // The range of numeric values of x with which there are associated probabilities.
        final Number[] xRange = Arrays.copyOfRange(range, 0, range.length / 2);
        // A set of probabilities associated with values in x_range.
        final Number[] probRange = Arrays.copyOfRange(range, range.length / 2, range.length);

        if (Objects.equals(lowerLimit, upperLimit)) {
            return Arrays.asList(xRange).indexOf(lowerLimit) >= 0 ? Formulas.valueOf(probRange[Arrays.asList(xRange).indexOf(lowerLimit)]) : Formulas.valueOf(0);
        }

        final List<Number> sortedList = Arrays.asList(xRange);
        sortedList.sort(Comparator.nullsFirst(Comparator.comparing(o -> Formulas.valueOf(o).asBigDecimal())));

        int n = sortedList.size();

        FormulaDecimal result = Formulas.valueOf(0);

        for (int i = 0; i < n; i++) {
            final Number item = sortedList.get(i);
            if (item == null) {
                throw new UniversalException(UniversalException.ErrorType.VALUE);
            }
            if (upperLimit == null) {
                if (item.doubleValue() >= lowerLimit.doubleValue()) {
                    result = result.add(Formulas.valueOf(probRange[Arrays.asList(xRange).indexOf(item)]));
                }
            } else {
                if (item.doubleValue() >= lowerLimit.doubleValue() && item.doubleValue() <= upperLimit.doubleValue()) {
                    result = result.add(Formulas.valueOf(probRange[Arrays.asList(xRange).indexOf(item)]));
                }
            }
        }
        return result;
    }

    public static FormulaDecimal quartile_exc(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final Number[] range = Arrays.copyOfRange(array, 0, array.length - 1);
        final Number quart = array[array.length - 1];
        switch (Formulas.valueOf(quart).intValue()) {
            case 0:
                // Minimum value
                throw new UnsupportedOperationException();
            case 1:
                // First quartile (25th percentile)
                return percentile_exc(range[0], ArrayHelper.append(0.25, Arrays.copyOfRange(range, 1, range.length)));
            case 2:
                // Median value (50th percentile)
                return percentile_exc(range[0], ArrayHelper.append(0.5, Arrays.copyOfRange(range, 1, range.length)));
            case 3:
                // Third quartile (75th percentile)
                return percentile_exc(range[0], ArrayHelper.append(0.75, Arrays.copyOfRange(range, 1, range.length)));
            case 4:
                // Maximum value
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static FormulaDecimal quartile_inc(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final Number[] range = Arrays.copyOfRange(array, 0, array.length - 1);
        final Number quart = array[array.length - 1];
        switch (Formulas.valueOf(quart).intValue()) {
            case 0:
                // Minimum value
                throw new UnsupportedOperationException();
            case 1:
                // First quartile (25th percentile)
                return percentile_inc(range[0], ArrayHelper.append(0.25, Arrays.copyOfRange(range, 1, range.length)));
            case 2:
                // Median value (50th percentile)
                return percentile_inc(range[0], ArrayHelper.append(0.5, Arrays.copyOfRange(range, 1, range.length)));
            case 3:
                // Third quartile (75th percentile)
                return percentile_inc(range[0], ArrayHelper.append(0.75, Arrays.copyOfRange(range, 1, range.length)));
            case 4:
                // Maximum value
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static FormulaDecimal rank_avg(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        // TODO support order (@see https://support.office.com/en-us/article/rank-avg-function-bd406a6f-eb38-4d73-aa8e-6d1c3c72e83a?ui=en-US&rs=en-US&ad=US)
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal rank_eq(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        // TODO support order (@see https://support.office.com/en-us/article/rank-eq-function-284858ce-8ef6-450e-b662-26245be04a40?ui=en-US&rs=en-US&ad=US)
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal rsq(Number[] first, Number[] second) {
        if (first == null || first.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        if (second == null || second.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        return Formulas.power(pearson(first, second), 2);
    }

    public static FormulaDecimal rsq(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        return Formulas.power(pearson(number, numbers), 2);
    }

    public static FormulaDecimal skew(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        return Formulas.valueOf(new Skewness().evaluate(ArrayUtils.toPrimitive(Arrays.stream(array).filter(Objects::nonNull).map(Number::doubleValue).toArray(Double[]::new))));
    }

    public static FormulaDecimal skew_p(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal slope(Number[] firstSeries, Number[] secondSeries) {
        if (firstSeries == null || firstSeries.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        if (secondSeries == null || secondSeries.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.join(firstSeries, secondSeries);
        final Number[] range = Arrays.copyOfRange(array, 1, array.length);
        final Number first = array[0];
        return slope(first, range);
    }

    public static FormulaDecimal slope(Number[] numbers, Number number) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.append(Number.class, number, numbers);
        final Number[] range = Arrays.copyOfRange(array, 1, array.length);
        final Number first = array[0];
        return slope(first, range);
    }

    public static FormulaDecimal slope(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final Number[] knownY = Arrays.copyOfRange(array, 0, array.length / 2);
        final Number[] knownX = Arrays.copyOfRange(array, array.length / 2, array.length);
        final SimpleRegression simpleRegression = new SimpleRegression();
        for (int i = 0; i < Math.max(knownX.length, knownY.length); i++) {
            simpleRegression.addData(Formulas.valueOf(knownX[i]).doubleValue(), Formulas.valueOf(knownY[i]).doubleValue());
        }
        return Formulas.valueOf(simpleRegression.getSlope());
    }

    public static FormulaDecimal small(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        if (numbers == null || numbers.length == 0) {
            return Formulas.valueOf(number);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final Number k = array[array.length - 1];
        if (k == null) {
            throw new UniversalException("k", 1, UniversalException.ErrorType.VALUE);
        }
        if (Formulas.valueOf(k).compareTo(Formulas.valueOf(numbers.length).subtract(Formulas.valueOf(1))) > 0) {
            throw new UniversalException("k", 1, UniversalException.ErrorType.VALUE, new ArrayIndexOutOfBoundsException(Formulas.valueOf(number).intValue()));
        }
        final Number[] range = Arrays.copyOfRange(array, 0, array.length - 1);
        if (Formulas.valueOf(k).compareTo(BigDecimal.ONE) == 0) {
            return min(range[0], Arrays.copyOfRange(range, 1, range.length));
        } else {
            final List<Number> sortedList = Arrays.asList(ArrayHelper.prepend(Number.class, number, numbers));
            sortedList.sort(Comparator.nullsFirst(Comparator.comparing(o -> Formulas.valueOf(o).asBigDecimal())));
            return Formulas.valueOf(sortedList.get(Math.min(sortedList.size() - 1, Math.max(0, sortedList.size() - k.intValue()))));
        }
    }

    public static FormulaDecimal standardize(Number x, Number mean, Number standardDeviation) {
        if (x == null) {
            throw new UniversalException("x", 0, UniversalException.ErrorType.VALUE);
        }
        if (mean == null) {
            throw new UniversalException("mean", 1, UniversalException.ErrorType.VALUE);
        }
        if (standardDeviation == null) {
            throw new UniversalException("standardDeviation", 2, UniversalException.ErrorType.VALUE);
        }

        return Formulas.valueOf(x).subtract(Formulas.valueOf(mean)).divide(Formulas.valueOf(standardDeviation));
    }

    public static FormulaDecimal stdev_p(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        return Formulas.sqrt(var_p(number, numbers));
    }

    public static FormulaDecimal stdev_s(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        return Formulas.sqrt(var_s(number, numbers));
    }

    public static FormulaDecimal stdeva(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        return Formulas.sqrt(vara(number, numbers));
    }

    public static FormulaDecimal stdevpa(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        return Formulas.sqrt(varpa(number, numbers));
    }

    public static FormulaDecimal steyx(Number[] firstSeries, Number[] secondSeries) {
        if (firstSeries == null || firstSeries.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        if (secondSeries == null || secondSeries.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.join(firstSeries, secondSeries);
        final Number[] range = Arrays.copyOfRange(array, 1, array.length);
        final Number first = array[0];
        return steyx(first, range);
    }

    public static FormulaDecimal steyx(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final Number[] knownY = Arrays.copyOfRange(array, 0, array.length / 2);
        final Number[] knownX = Arrays.copyOfRange(array, array.length / 2, array.length);

        final FormulaDecimal xMean = Formulas.mean(knownX[0], Arrays.copyOfRange(knownX, 1, knownX.length));
        final FormulaDecimal yMean = Formulas.mean(knownY[0], Arrays.copyOfRange(knownY, 1, knownY.length));
        FormulaDecimal lft = Formulas.valueOf(0);
        FormulaDecimal numerator = Formulas.valueOf(0);
        FormulaDecimal denominator = Formulas.valueOf(0);
        if (knownY.length != knownX.length) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        int n = Math.max(knownX.length, knownY.length);
        for (int i = 0; i < n; i++) {
            lft = lft.add(Formulas.power(Formulas.valueOf(knownY[i]).subtract(yMean), 2));
            numerator = numerator.add(Formulas.valueOf(knownX[i]).subtract(xMean).multiply(Formulas.valueOf(knownY[i]).subtract(yMean)));
            denominator = Formulas.power(Formulas.valueOf(knownX[i]).subtract(xMean), 2);
        }

        return Formulas.sqrt(Formulas.valueOf(lft.subtract(numerator.multiply(numerator).divide(denominator))).divide(Formulas.valueOf(n - 2)));
    }

    public static FormulaDecimal t_dist(Number x, Number degreesOfFreedom, Boolean cumulative) {
        return t_dist(x, degreesOfFreedom, Logical.valueOf(cumulative));
    }

    public static FormulaDecimal t_dist(Number x, Number degreesOfFreedom, Logical cumulative) {
        if (x == null) {
            throw new UniversalException("x", 0, UniversalException.ErrorType.VALUE);
        }
        if (degreesOfFreedom == null) {
            throw new UniversalException("degreesOfFreedom", 1, UniversalException.ErrorType.VALUE);
        }
        if (cumulative == null) {
            throw new UniversalException("cumulative", 2, UniversalException.ErrorType.VALUE);
        }

        if (Logical.valueOf(cumulative).booleanValue()) {
            return Formulas.valueOf(new TDistribution(degreesOfFreedom.doubleValue()).cumulativeProbability(x.doubleValue()));
        } else {
            return Formulas.valueOf(new TDistribution(degreesOfFreedom.doubleValue()).density(x.doubleValue()));
        }
    }

    public static FormulaDecimal t_dist_2t(Number x, Number degreesOfFreedom) {
        if (x == null) {
            throw new UniversalException("x", 0, UniversalException.ErrorType.VALUE);
        }
        if (degreesOfFreedom == null) {
            throw new UniversalException("degreesOfFreedom", 1, UniversalException.ErrorType.VALUE);
        }

        return Formulas.valueOf(1).subtract(Formulas.valueOf(new TDistribution(degreesOfFreedom.doubleValue()).cumulativeProbability(x.doubleValue()))).multiply(Formulas.valueOf(2));
    }

    public static FormulaDecimal t_dist_rt(Number x, Number degreesOfFreedom) {
        if (x == null) {
            throw new UniversalException("x", 0, UniversalException.ErrorType.VALUE);
        }
        if (degreesOfFreedom == null) {
            throw new UniversalException("degreesOfFreedom", 1, UniversalException.ErrorType.VALUE);
        }

        return Formulas.valueOf(1).subtract(Formulas.valueOf(new TDistribution(degreesOfFreedom.doubleValue()).cumulativeProbability(x.doubleValue())));
    }

    public static FormulaDecimal t_inv(Number probability, Number degreesOfFreedom) {
        if (probability == null) {
            throw new UniversalException("probability", 0, UniversalException.ErrorType.VALUE);
        }
        if (degreesOfFreedom == null) {
            throw new UniversalException("degreesOfFreedom", 1, UniversalException.ErrorType.VALUE);
        }

        return Formulas.valueOf(new TDistribution(degreesOfFreedom.doubleValue()).inverseCumulativeProbability(probability.doubleValue()));
    }

    public static FormulaDecimal t_inv_2t(Number probability, Number degreesOfFreedom) {
        if (probability == null) {
            throw new UniversalException("probability", 0, UniversalException.ErrorType.VALUE);
        }
        if (degreesOfFreedom == null) {
            throw new UniversalException("degreesOfFreedom", 1, UniversalException.ErrorType.VALUE);
        }

        return Formulas.abs(Formulas.valueOf(new TDistribution(degreesOfFreedom.doubleValue()).inverseCumulativeProbability(Formulas.valueOf(probability).divide(Formulas.valueOf(2)).doubleValue())));
    }

    public static FormulaDecimal t_test(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        // TODO @see https://support.office.com/en-us/article/t-test-function-d4e08ec3-c545-485f-962e-276f7cbed055?ui=en-US&rs=en-US&ad=US
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final Number[] range = Arrays.copyOfRange(array, 0, array.length - 2);
        final Number[] knownY = Arrays.copyOfRange(range, 0, range.length / 2);
        final Number[] knownX = Arrays.copyOfRange(range, range.length / 2, range.length);

        final Number tails = array[array.length - 2];
        if (tails == null) {
            throw new UniversalException("tails", 2, UniversalException.ErrorType.VALUE);
        }
        if (array[array.length - 1] == null) {
            throw new UniversalException("type", 3, UniversalException.ErrorType.VALUE);
        }
        final int type = array[array.length - 1].intValue();
        // TODO test these
        switch (tails.intValue()) {
            case 1:
                // one-tailed
                switch (type) {
                    case 1:
                        // paired
                        return Formulas.valueOf(new TTest().pairedTTest(
                                ArrayUtils.toPrimitive(Arrays.stream(knownY).filter(Objects::nonNull).map(Number::doubleValue).toArray(Double[]::new)),
                                ArrayUtils.toPrimitive(Arrays.stream(knownX).filter(Objects::nonNull).map(Number::doubleValue).toArray(Double[]::new))));
                    case 2:
                        // Two-sample equal variance (homoscedastic)
                        return Formulas.valueOf(new TTest().homoscedasticT(
                                ArrayUtils.toPrimitive(Arrays.stream(knownY).filter(Objects::nonNull).map(Number::doubleValue).toArray(Double[]::new)),
                                ArrayUtils.toPrimitive(Arrays.stream(knownX).filter(Objects::nonNull).map(Number::doubleValue).toArray(Double[]::new))));
                    case 3:
                        // Two-sample unequal variance (heteroscedastic)
                        throw new UnsupportedOperationException();
                    default:
                        throw new UnsupportedOperationException();
                }
            case 2:
                // two-tailed
                switch (type) {
                    case 1:
                        // paired
                        return Formulas.valueOf(new TTest().pairedTTest(
                                ArrayUtils.toPrimitive(Arrays.stream(knownY).filter(Objects::nonNull).map(Number::doubleValue).toArray(Double[]::new)),
                                ArrayUtils.toPrimitive(Arrays.stream(knownX).filter(Objects::nonNull).map(Number::doubleValue).toArray(Double[]::new))));
                    case 2:
                        // Two-sample equal variance (homoscedastic)
                        return Formulas.valueOf(new TTest().homoscedasticT(
                                ArrayUtils.toPrimitive(Arrays.stream(knownY).filter(Objects::nonNull).map(Number::doubleValue).toArray(Double[]::new)),
                                ArrayUtils.toPrimitive(Arrays.stream(knownX).filter(Objects::nonNull).map(Number::doubleValue).toArray(Double[]::new))));
                    case 3:
                        // Two-sample unequal variance (heteroscedastic)
                        throw new UnsupportedOperationException();
                    default:
                        throw new UnsupportedOperationException();
                }
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static FormulaDecimal trend() {
        throw new UnsupportedOperationException();
    }

    public static FormulaDecimal trimmean(Number[] numbers, Number number) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.append(Number.class, number, numbers);
        final Number[] range = Arrays.copyOfRange(array, 1, array.length);
        final Number first = array[0];
        return trimmean(first, range);
    }

    public static FormulaDecimal trimmean(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final Number[] range = Arrays.copyOfRange(array, 0, array.length - 1);
        final Number percent = array[array.length - 1];

        final List<Number> sortedList = Arrays.asList(ArrayHelper.prepend(Number.class, number, numbers));
        sortedList.sort(Comparator.nullsFirst(Comparator.comparing(o -> Formulas.valueOf(o).asBigDecimal())));

        final FormulaDecimal trim = Formulas.floor(Formulas.valueOf(range.length).multiply(Formulas.valueOf(percent)), 2).divide(Formulas.valueOf(2));

        final List<Number> trimmedList = sortedList.subList(1 + trim.intValue(), range.length - trim.intValue() + 1);

        return Formulas.mean(trimmedList.get(0), trimmedList.subList(1, trimmedList.size()).toArray(new Number[0]));
    }

    public static FormulaDecimal var_p(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final FormulaDecimal mean = Formulas.avg(number, numbers);
        FormulaDecimal sigma = new FormulaDecimal(0);
        for (Number n : array) {
            sigma = sigma.add(Formulas.power(Formulas.valueOf(n).subtract(mean), 2));
        }
        return sigma.divide(Formulas.valueOf(array.length));
    }

    public static FormulaDecimal var_s(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final FormulaDecimal mean = Formulas.avg(number, numbers);
        FormulaDecimal sigma = new FormulaDecimal(0);
        for (Number n : array) {
            sigma = sigma.add(Formulas.power(Formulas.valueOf(n).subtract(mean), 2));
        }
        return sigma.divide(Formulas.valueOf(array.length - 1));
    }

    public static FormulaDecimal vara(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        return Formulas.valueOf(new Variance().evaluate(ArrayUtils.toPrimitive(Arrays.stream(array).filter(Objects::nonNull).map(Number::doubleValue).toArray(Double[]::new))));
    }

    public static FormulaDecimal varpa(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        return Formulas.valueOf(new Variance(false).evaluate(ArrayUtils.toPrimitive(Arrays.stream(array).map(Formulas::valueOf).map(Number::doubleValue).toArray(Double[]::new))));
    }

    public static FormulaDecimal weibull_dist(Number x, Number alpha, Number beta, Boolean cumulative) {
        return weibull_dist(x, alpha, beta, Logical.valueOf(cumulative));
    }

    public static FormulaDecimal weibull_dist(Number x, Number alpha, Number beta, Logical cumulative) {
        if (x == null) {
            throw new UniversalException("x", 0, UniversalException.ErrorType.VALUE);
        }
        if (alpha == null) {
            throw new UniversalException("alpha", 1, UniversalException.ErrorType.VALUE);
        }
        if (beta == null) {
            throw new UniversalException("beta", 2, UniversalException.ErrorType.VALUE);
        }
        if (cumulative == null) {
            throw new UniversalException("cumulative", 3, UniversalException.ErrorType.VALUE);
        }

        if (Logical.valueOf(cumulative).booleanValue()) {
            return Formulas.valueOf(new WeibullDistribution(alpha.doubleValue(), beta.doubleValue()).cumulativeProbability(x.doubleValue()));
        } else {
            return Formulas.valueOf(new WeibullDistribution(alpha.doubleValue(), beta.doubleValue()).density(x.doubleValue()));
        }
    }

    public static FormulaDecimal z_test(Number[] firstSeries, Number[] secondSeries) {
        if (firstSeries == null || firstSeries.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        if (secondSeries == null || secondSeries.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.join(firstSeries, secondSeries);
        final Number[] range = Arrays.copyOfRange(array, 1, array.length);
        final Number first = array[0];
        return z_test(first, range);
    }

    public static FormulaDecimal z_test(Number[] firstSeries, Number[] secondSeries, Number sigma) {
        if (firstSeries == null || firstSeries.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        if (secondSeries == null || secondSeries.length == 0) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.append(sigma, ArrayHelper.join(firstSeries, secondSeries));
        final Number[] range = Arrays.copyOfRange(array, 1, array.length);
        final Number first = array[0];
        return z_test(first, range);
    }

    public static FormulaDecimal z_test(Number[] numbers, Number number) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.append(Number.class, number, numbers);
        final Number[] range = Arrays.copyOfRange(array, 1, array.length);
        final Number first = array[0];
        return z_test(first, range);
    }

    public static FormulaDecimal z_test(Number[] numbers, Number number, Number sigma) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        final Number[] array = ArrayHelper.append(Number.class, sigma, ArrayHelper.append(Number.class, number, numbers));
        final Number[] range = Arrays.copyOfRange(array, 1, array.length);
        final Number first = array[0];
        return z_test(first, range);
    }

    public static FormulaDecimal z_test(Number number, Number... numbers) {
        if (number == null && (numbers == null || numbers.length == 0)) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        if (numbers == null || numbers.length == 0) {
            throw new UniversalException("x", 1, UniversalException.ErrorType.NA);
        }
        // TODO support for sigma (@see https://support.office.com/en-us/article/z-test-function-d633d5a3-2031-4614-a016-92180ad82bee?ui=en-US&rs=en-US&ad=US)
        final Number[] array = ArrayHelper.prepend(Number.class, number, numbers);
        final Number[] range = Arrays.copyOfRange(array, 0, array.length - 1);

        final Number x = array[array.length - 1];
        if (x == null) {
            throw new UniversalException("x", 1, UniversalException.ErrorType.VALUE);
        }
        final FormulaDecimal sigma = stdev_s(range[0], Arrays.copyOfRange(range, 1, range.length));
        return Formulas.valueOf(1).subtract(norm_s_dist((Formulas.avg(range[0], Arrays.copyOfRange(range, 1, range.length)).subtract(Formulas.valueOf(x))).divide(Formulas.valueOf(sigma).divide(Formulas.sqrt(range.length))), true));
    }
}
