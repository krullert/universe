package io.onsense.universe;

import javax.annotation.Nonnull;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.stream.IntStream;

/**
 * @author Koen Rooijmans
 */
public class ExpressionString implements CharSequence, Comparable<CharSequence> {

    public static final ExpressionString EMPTY = new ExpressionString("");

    private final String delegate;

    public ExpressionString(String delegate) {
        this.delegate = delegate == null ? "" : delegate;
        if (this.delegate.length() > Short.MAX_VALUE) {
            throw new UniversalException(delegate, UniversalException.ErrorType.VALUE);
        }
    }

    public ExpressionString(byte bytes[], Charset charset) {
        this.delegate = (bytes == null || bytes.length == 0) ? "" : new String(bytes, charset);
    }

    public static ExpressionString valueOf(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return EMPTY;
        }
        if (charSequence instanceof ExpressionString) {
            return (ExpressionString) charSequence;
        } else {
            return new ExpressionString(charSequence.toString());
        }
    }

    public static ExpressionString join(CharSequence delimiter, CharSequence... elements) {
        return new ExpressionString(String.join(delimiter == null ? "" : delimiter, elements));
    }

    public static ExpressionString join(CharSequence delimiter, Iterable<? extends CharSequence> elements) {
        return new ExpressionString(String.join(delimiter == null ? "" : delimiter, elements));
    }

    public static ExpressionString format(String format, Object... args) {
        if (format == null) {
            return EMPTY;
        }
        return new ExpressionString(String.format(format, args));
    }

    public static ExpressionString format(Locale l, String format, Object... args) {
        if (format == null) {
            return EMPTY;
        }
        return new ExpressionString(String.format(l == null ? Locale.ENGLISH : l, format, args));
    }

    public static ExpressionString valueOf(Object obj) {
        if (obj == null) {
            return EMPTY;
        }
        return new ExpressionString(String.valueOf(obj));
    }

    public static ExpressionString valueOf(char[] data) {
        if (data == null || data.length == 0) {
            return EMPTY;
        }
        return new ExpressionString(String.valueOf(data));
    }

    public static ExpressionString valueOf(char[] data, int offset, int count) {
        if (data == null || data.length == 0) {
            return EMPTY;
        }
        return new ExpressionString(String.valueOf(data, offset, count));
    }

    public static ExpressionString copyValueOf(char[] data, int offset, int count) {
        if (data == null || data.length == 0) {
            return EMPTY;
        }
        return new ExpressionString(String.copyValueOf(data, offset, count));
    }

    public static ExpressionString copyValueOf(char[] data) {
        if (data == null || data.length == 0) {
            return EMPTY;
        }
        return new ExpressionString(String.copyValueOf(data));
    }

    public static ExpressionString valueOf(boolean b) {
        return new ExpressionString(String.valueOf(b));
    }

    public static ExpressionString valueOf(char c) {
        return new ExpressionString(String.valueOf(c));
    }

    public static ExpressionString valueOf(int i) {
        return new ExpressionString(String.valueOf(i));
    }

    public static ExpressionString valueOf(long l) {
        return new ExpressionString(String.valueOf(l));
    }

    public static ExpressionString valueOf(float f) {
        return new ExpressionString(String.valueOf(f));
    }

    public static ExpressionString valueOf(double d) {
        return new ExpressionString(String.valueOf(d));
    }

    public ExpressionString add(String other) {
        if (other == null) {
            return this;
        }
        return new ExpressionString(delegate + other);
    }

    public ExpressionString add(Object other) {
        if (other == null) {
            return this;
        }
        return new ExpressionString(delegate + String.valueOf(other));
    }

    public ExpressionString add(ExpressionString other) {
        if (other == null) {
            return this;
        }
        return new ExpressionString(delegate + other.delegate);
    }

    public String getDelegate() {
        return delegate;
    }

    @Override
    public int length() {
        return delegate.length();
    }

    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    @Override
    public char charAt(int index) {
        if (delegate.isEmpty()) {
            return 0;
        }
        if (delegate.length() <= index) {
            return 0;
        }
        return delegate.charAt(index);
    }

    public int codePointAt(int index) {
        return delegate.codePointAt(index);
    }

    public int codePointBefore(int index) {
        return delegate.codePointBefore(index);
    }

    public int codePointCount(int beginIndex, int endIndex) {
        return delegate.codePointCount(beginIndex, endIndex);
    }

    public int offsetByCodePoints(int index, int codePointOffset) {
        return delegate.offsetByCodePoints(index, codePointOffset);
    }

    public void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) {
        if (dst == null) {
            return;
        }
        delegate.getChars(srcBegin, srcEnd, dst, dstBegin);
    }

    @Deprecated
    public void getBytes(int srcBegin, int srcEnd, byte[] dst, int dstBegin) {
        if (dst == null) {
            return;
        }
        delegate.getBytes(srcBegin, srcEnd, dst, dstBegin);
    }

    public byte[] getBytes(String charsetName) throws UnsupportedEncodingException {
        return delegate.getBytes(charsetName == null ? "UTF-8" : charsetName);
    }

    public byte[] getBytes(Charset charset) {
        return delegate.getBytes(charset == null ? StandardCharsets.UTF_8 : charset);
    }

    public byte[] getBytes() {
        return delegate.getBytes();
    }

    @Override
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }

        if (anObject instanceof ExpressionString) {
            return delegate.equals(((ExpressionString) anObject).delegate);
        }

        return delegate.equals(anObject);
    }

    public boolean contentEquals(StringBuffer sb) {
        if (sb == null) {
            return false;
        }
        return delegate.contentEquals(sb);
    }

    public boolean contentEquals(CharSequence cs) {
        if (cs == null) {
            return false;
        }
        return delegate.contentEquals(cs);
    }

    public boolean equalsIgnoreCase(String anotherString) {
        return delegate.equalsIgnoreCase(anotherString);
    }

    public int compareTo(String anotherString) {
        return delegate.compareTo(anotherString);
    }

    public int compareToIgnoreCase(String str) {
        return delegate.compareToIgnoreCase(ExpressionString.valueOf(str).delegate);
    }

    public boolean regionMatches(int toffset, String other, int ooffset, int len) {
        if (other == null) {
            return false;
        }
        return delegate.regionMatches(toffset, other, ooffset, len);
    }

    public boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len) {
        if (other == null) {
            return false;
        }
        return delegate.regionMatches(ignoreCase, toffset, other, ooffset, len);
    }

    public boolean startsWith(String prefix, int toffset) {
        return delegate.startsWith(ExpressionString.valueOf(prefix).delegate, toffset);
    }

    public boolean startsWith(String prefix) {
        return delegate.startsWith(ExpressionString.valueOf(prefix).delegate);
    }

    public boolean endsWith(String suffix) {
        return delegate.endsWith(ExpressionString.valueOf(suffix).delegate);
    }

    @Override
    public int hashCode() {
        return delegate.hashCode();
    }

    public int indexOf(int ch) {
        return delegate.indexOf(ch);
    }

    public int indexOf(int ch, int fromIndex) {
        return delegate.indexOf(ch, fromIndex);
    }

    public int lastIndexOf(int ch) {
        return delegate.lastIndexOf(ch);
    }

//    public ExpressionString[] split(String regex, int limit) {
//        return new ExpressionString(delegate.split(regex, limit));
//    }
//
//    public ExpressionString[] split(String regex) {
//        return new ExpressionString(delegate.split(regex));
//    }

    public int lastIndexOf(int ch, int fromIndex) {
        return delegate.lastIndexOf(ch, fromIndex);
    }

    public int indexOf(String str) {
        if (str == null) {
            return -1;
        }
        return delegate.indexOf(str);
    }

    public int indexOf(String str, int fromIndex) {
        if (str == null) {
            return -1;
        }
        return delegate.indexOf(str, fromIndex);
    }

    public int lastIndexOf(String str) {
        if (str == null) {
            return -1;
        }
        return delegate.lastIndexOf(str);
    }

    public int lastIndexOf(String str, int fromIndex) {
        if (str == null) {
            return -1;
        }
        return delegate.lastIndexOf(str, fromIndex);
    }

    public ExpressionString substring(int beginIndex) {
        return new ExpressionString(delegate.substring(beginIndex < 0 ? 0 : (beginIndex > delegate.length() ? delegate.length() : beginIndex)));
    }

    public ExpressionString substring(int beginIndex, int endIndex) {
        return new ExpressionString(delegate.substring(beginIndex < 0 ? 0 : (beginIndex > endIndex ? (endIndex < 0 ? 0 : (endIndex > delegate.length() ? delegate.length() : endIndex)) : (beginIndex > delegate.length() ? delegate.length() : beginIndex)), endIndex > delegate.length() ? delegate.length() : (endIndex < 0 ? 0 : endIndex)));
    }

    @Override
    public ExpressionString subSequence(int beginIndex, int endIndex) {
        return new ExpressionString(String.valueOf(delegate.subSequence(beginIndex < 0 ? 0 : (beginIndex > endIndex ? (endIndex < 0 ? 0 : (endIndex > delegate.length() ? delegate.length() : endIndex)) : (beginIndex > delegate.length() ? delegate.length() : beginIndex)), endIndex > delegate.length() ? delegate.length() : (endIndex < 0 ? 0 : endIndex))));
    }

    public ExpressionString concat(String str) {
        if (str == null) {
            return this;
        }
        return new ExpressionString(delegate.concat(str));
    }

    public ExpressionString replace(char oldChar, char newChar) {
        return new ExpressionString(delegate.replace(oldChar, newChar));
    }

    public boolean matches(String regex) {
        if (regex == null) {
            return false;
        }
        return delegate.matches(regex);
    }

    public boolean contains(CharSequence s) {
        if (s == null) {
            return true;
        }
        return delegate.contains(s);
    }

    public ExpressionString replaceFirst(String regex, String replacement) {
        if (regex == null) {
            return this;
        }
        return new ExpressionString(delegate.replaceFirst(regex, replacement == null ? "" : replacement));
    }

    public ExpressionString replaceAll(String regex, String replacement) {
        if (regex == null) {
            return this;
        }
        return new ExpressionString(delegate.replaceAll(regex, replacement == null ? "" : replacement));
    }

    public ExpressionString replace(CharSequence target, CharSequence replacement) {
        if (target == null) {
            return this;
        }
        return new ExpressionString(delegate.replace(target, replacement == null ? "" : replacement));
    }

    public ExpressionString toLowerCase(Locale locale) {
        return new ExpressionString(delegate.toLowerCase(locale == null ? Locale.ENGLISH : locale));
    }

    public ExpressionString toLowerCase() {
        return new ExpressionString(delegate.toLowerCase());
    }

    public ExpressionString toUpperCase(Locale locale) {
        return new ExpressionString(delegate.toUpperCase(locale == null ? Locale.ENGLISH : locale));
    }

    public ExpressionString toUpperCase() {
        return new ExpressionString(delegate.toUpperCase());
    }

    public ExpressionString trim() {
        return new ExpressionString(delegate.trim());
    }

    @Nonnull
    @Override
    public String toString() {
        return delegate.toString();
    }

    public char[] toCharArray() {
        return delegate.toCharArray();
    }

    public ExpressionString intern() {
        return new ExpressionString(delegate.intern());
    }

    @Override
    public IntStream chars() {
        return delegate.chars();
    }

    @Override
    public IntStream codePoints() {
        return delegate.codePoints();
    }

    public ExpressionString concat(CharSequence other) {
        if (other == null) {
            return this;
        }
        return ExpressionString.valueOf(this.toString() + other.toString());
    }

    @Override
    public int compareTo(@Nonnull CharSequence o) {
        if (o instanceof ExpressionString) {
            return delegate.compareTo(((ExpressionString) o).delegate);
        } else {
            return delegate.compareTo(o.toString());
        }
    }
}
