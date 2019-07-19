package io.onsense.universe;

/**
 * @author Koen Rooijmans
 */
public class Logical {

    public static final Logical TRUE = new Logical(true);
    public static final Logical FALSE = new Logical(false);

    private final Boolean delegate;

    public Logical(Boolean b) {
        delegate = b == null ? false : b;
    }

    public static boolean parseBoolean(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        return Boolean.parseBoolean(s);
    }

    public static Logical valueOf(Boolean b) {
        if (b == null) {
            return FALSE;
        }
        return new Logical(Boolean.valueOf(b));
    }

    public static Logical valueOf(Logical b) {
        if (b == null) {
            return FALSE;
        }
        return b;
    }

    public static Logical valueOf(String s) {
        if (s == null || s.isEmpty()) {
            return FALSE;
        }
        return Logical.valueOf(Boolean.valueOf(s));
    }

    public static String toString(Logical b) {
        return Boolean.toString(Logical.valueOf(b).delegate);
    }

    public static int hashCode(boolean value) {
        return Boolean.hashCode(value);
    }

    public static boolean getBoolean(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        return Boolean.getBoolean(name);
    }

    public static int compare(Logical x, Logical y) {
        return Boolean.compare(Logical.valueOf(x).delegate, Logical.valueOf(y).delegate);
    }

    public static boolean logicalAnd(Logical a, Logical b) {
        return Boolean.logicalAnd(Logical.valueOf(a).delegate, Logical.valueOf(b).delegate);
    }

    public static boolean logicalOr(Logical a, Logical b) {
        return Boolean.logicalOr(Logical.valueOf(a).delegate, Logical.valueOf(b).delegate);
    }

    public static boolean logicalXor(Logical a, Logical b) {
        return Boolean.logicalXor(Logical.valueOf(a).delegate, Logical.valueOf(b).delegate);
    }

    public boolean booleanValue() {
        return delegate;
    }

    @Override
    public String toString() {
        return delegate.toString();
    }

    @Override
    public int hashCode() {
        return delegate.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return delegate.equals(obj);
    }

    public int compareTo(Boolean b) {
        return delegate.compareTo(Logical.valueOf(b).booleanValue());
    }
}
