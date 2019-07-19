package io.onsense.universe;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.Array;

/**
 * @author Koen Rooijmans
 */
public class ArrayHelper {

    @SuppressWarnings("unchecked")
    protected static <T> T[] resizeForPrepend(T[] buffer, int newSize) {
        final Class<T> componentType = (Class<T>) buffer.getClass().getComponentType();
        return resizeForPrepend(componentType, buffer, newSize);
    }

    @SuppressWarnings("unchecked")
    protected static <T> T[] resizeForPrepend(@Nonnull Class<T> componentType, T[] buffer, int newSize) {
        final T[] temp = (T[]) Array.newInstance(componentType, newSize);
        System.arraycopy(buffer, 0, temp, 1, buffer.length);
        return temp;
    }

    @SuppressWarnings("unchecked")
    protected static <T> T[] resizeForAppend(T[] buffer, int newSize) {
        final Class<T> componentType = (Class<T>) buffer.getClass().getComponentType();
        return resizeForAppend(componentType, buffer, newSize);
    }

    @SuppressWarnings("unchecked")
    protected static <T> T[] resizeForAppend(@Nonnull Class<T> componentType, T[] buffer, int newSize) {
        final T[] temp = (T[]) Array.newInstance(componentType, newSize);
        System.arraycopy(buffer, 0, temp, 0, buffer.length >= newSize ? newSize : buffer.length);
        return temp;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] prepend(@Nonnull Class<T> componentType, @Nullable T newElement, @Nullable T[] buffer) {
        if (newElement == null && buffer == null) {
            return (T[]) Array.newInstance(componentType, 0);
        }
        if (newElement == null) {
            return buffer;
        }
        if (buffer == null) {
            final T[] temp = (T[]) Array.newInstance(componentType, 1);
            temp[0] = newElement;
            return temp;
        }
        final T[] array = resizeForPrepend(componentType, buffer, buffer.length + 1);
        try {
            array[0] = newElement;
        } catch (ArrayStoreException e) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    @Nonnull
    public static <T> T[] prepend(@Nullable T newElement, @Nullable T[] buffer) {
        if (newElement == null && buffer == null) {
            return (T[]) new Object[0];
        }
        if (newElement == null) {
            return buffer;
        }
        if (buffer == null) {
            final Class<T> componentType = (Class<T>) newElement.getClass();
            final T[] temp = (T[]) Array.newInstance(componentType, 1);
            temp[0] = newElement;
            return temp;
        }
        final T[] array = resizeForPrepend(buffer, buffer.length + 1);
        try {
            array[0] = newElement;
        } catch (ArrayStoreException e) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    @Nonnull
    public static <T> T[] append(@Nonnull Class<T> componentType, @Nullable T newElement, @Nullable T[] buffer) {
        if (newElement == null && buffer == null) {
            return (T[]) Array.newInstance(componentType, 0);
        }
        if (newElement == null) {
            return buffer;
        }
        if (buffer == null) {
            final T[] temp = (T[]) Array.newInstance(componentType, 1);
            temp[0] = newElement;
            return temp;
        }
        final T[] array = resizeForAppend(componentType, buffer, buffer.length + 1);
        try {
            array[buffer.length] = newElement;
        } catch (ArrayStoreException e) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    @Nonnull
    public static <T> T[] append(@Nullable T newElement, @Nullable T[] buffer) {
        if (newElement == null && buffer == null) {
            return (T[]) new Object[0];
        }
        if (newElement == null) {
            return buffer;
        }
        if (buffer == null) {
            final Class<T> componentType = (Class<T>) newElement.getClass();
            final T[] temp = (T[]) Array.newInstance(componentType, 1);
            temp[0] = newElement;
            return temp;
        }
        final T[] array = resizeForAppend(buffer, buffer.length + 1);
        try {
            array[buffer.length] = newElement;
        } catch (ArrayStoreException e) {
            throw new UniversalException(UniversalException.ErrorType.VALUE);
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] join(T[]... arrays) {
        Class<T> componentType = (Class<T>) arrays.getClass().getComponentType().getComponentType();
        return join(componentType, arrays);
    }

    @SuppressWarnings("unchecked")
    protected static <T> T[] join(Class<T> componentType, T[][] arrays) {
        if (arrays.length == 1) {
            return arrays[0];
        }
        int length = 0;
        for (T[] array : arrays) {
            length += array.length;
        }
        T[] result = (T[]) Array.newInstance(componentType, length);

        length = 0;
        for (T[] array : arrays) {
            System.arraycopy(array, 0, result, length, array.length);
            length += array.length;
        }
        return result;
    }
}
