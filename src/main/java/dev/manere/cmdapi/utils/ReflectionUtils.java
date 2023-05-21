package dev.manere.cmdapi.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * The ReflectionUtils class provides utility methods for working with reflection.
 */
public class ReflectionUtils {
    /**
     * Invokes the specified method on the given object with the provided arguments.
     *
     * @param obj    the object on which to invoke the method
     * @param method the method to invoke
     * @param args   the arguments to pass to the method
     * @return the result of the method invocation
     * @throws IllegalAccessException    if the method is inaccessible
     * @throws InvocationTargetException if the method throws an exception
     */
    public static Object invokeMethod(Object obj, Method method, Object... args) throws IllegalAccessException, InvocationTargetException, InvocationTargetException {
        method.setAccessible(true);
        return method.invoke(obj, args);
    }

    /**
     * Sets the value of the specified field on the given object.
     *
     * @param obj    the object on which to set the field value
     * @param field  the field to set the value of
     * @param value  the value to set
     * @throws IllegalAccessException if the field is inaccessible
     */
    public static void setFieldValue(Object obj, Field field, Object value) throws IllegalAccessException {
        field.setAccessible(true);
        field.set(obj, value);
    }

    /**
     * Gets the value of the specified field on the given object.
     *
     * @param obj   the object from which to get the field value
     * @param field the field to get the value of
     * @return the value of the field
     * @throws IllegalAccessException if the field is inaccessible
     */
    public static Object getFieldValue(Object obj, Field field) throws IllegalAccessException {
        field.setAccessible(true);
        return field.get(obj);
    }
}
