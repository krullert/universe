package io.onsense.universe;

/**
 * @author Koen Rooijmans
 */
public class UniversalException extends IllegalArgumentException {

    private final ErrorType errorType;

    public UniversalException(ErrorType errorType) {
        super(errorType.errorName);
        this.errorType = errorType;
    }

    public UniversalException(Object value, int argumentIndex, ErrorType errorType) {
        super(errorType.errorName + ":[arg" + argumentIndex + ":(" + toString(value) + ")" + "]");
        this.errorType = errorType;
    }

    public UniversalException(Object value, ErrorType errorType) {
        super(errorType.errorName + ":[:(" + toString(value) + ")" + "]");
        this.errorType = errorType;
    }

    public UniversalException(ErrorType errorType, Throwable cause) {
        super(errorType.errorName, cause);
        this.errorType = errorType;
    }

    public UniversalException(String message, ErrorType errorType) {
        super(errorType.errorName + ": " + message);
        this.errorType = errorType;
    }

    public UniversalException(String message, int argumentIndex, ErrorType errorType) {
        super(errorType.errorName + ":[arg" + argumentIndex + "] " + message);
        this.errorType = errorType;
    }

    public UniversalException(String message, int argumentIndex, ErrorType errorType, Throwable cause) {
        super(errorType.errorName + ":[arg" + argumentIndex + "] " + message, cause);
        this.errorType = errorType;
    }

    public UniversalException(Object value, String message, int argumentIndex, ErrorType errorType, Throwable cause) {
        super(errorType.errorName + ":[arg" + argumentIndex + ":(" + toString(value) + ")" + "] " + message, cause);
        this.errorType = errorType;
    }

    public UniversalException(Object value, String message, int argumentIndex, ErrorType errorType) {
        super(errorType.errorName + ":[arg" + argumentIndex + ":(" + toString(value) + ")" + "] " + message);
        this.errorType = errorType;
    }

    public UniversalException(String message, Throwable cause, ErrorType errorType) {
        super(errorType.errorName + ": " + message, cause);
        this.errorType = errorType;
    }

    protected static Object toString(Object value) {
        if (value == null) {
            return "";
        }
        try {
            return String.valueOf(value);
        } catch (StringIndexOutOfBoundsException e) {
            return "#ERR!";
        }
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public enum ErrorType {
        NULL("#NULL!", 1), // Space instead of comma is used
        DIV_0("#DIV/0!", 2), // Trying to divide by 0
        VALUE("#VALUE?", 3), // Wrong type of argument in a function
        REF("#REF!", 4), // Invalid cell reference
        NAME("#NAME?", 5), // Doesn’t recognize a name
        NUM("#NUM!", 6), // Problem with a number in the formula (invalid argument)
        NA("#N/A!", 7), // No value available
        DATA("#GETTING_DATA!", 8);

        private final String errorName;
        private final int errorType;

        ErrorType(String errorName, int errorType) {
            this.errorName = errorName;
            this.errorType = errorType;
        }

        public String getErrorName() {
            return errorName;
        }

        public int getErrorType() {
            return errorType;
        }
    }
}
