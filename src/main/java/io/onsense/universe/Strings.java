package io.onsense.universe;

/**
 * @author Koen Rooijmans
 */
public class Strings {

    public static final String EMPTY = "";

    public static String removeQuotes(String string) {
        if (Strings.startsWithChar(string, '\'') && Strings.endsWithChar(string, '\'')
                || Strings.startsWithChar(string, '"') && Strings.endsWithChar(string, '"')) {
            return Strings.substring(string, 1, -1);
        }
        return string;
    }

    public static boolean startsWithChar(String s, char character) {
        return !s.isEmpty() && s.charAt(0) == character;
    }

    public static boolean endsWithChar(String s, char character) {
        return !s.isEmpty() && s.charAt(s.length() - 1) == character;
    }

    public static String substring(String string, int fromIndex, int toIndex) {
        int len = string.length();

        if (fromIndex < 0) {
            fromIndex = len + fromIndex;

            if (toIndex == 0) {
                toIndex = len;
            }
        }

        if (toIndex < 0) {
            toIndex = len + toIndex;
        }

        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (toIndex > len) {
            toIndex = len;
        }
        if (fromIndex >= toIndex) {
            return Strings.EMPTY;
        }

        return string.substring(fromIndex, toIndex);
    }
}
