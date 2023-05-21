package dev.manere.cmdapi.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * The AnnotationUtils class provides utility methods for working with annotations.
 */
public class AnnotationUtils {
    /**
     * Finds the specified annotation on the given method or its declaring interfaces.
     *
     * @param method           the method to search for the annotation
     * @param annotationClass  the class of the annotation to find
     * @param <T>              the type of the annotation
     * @return the found annotation or null if not found
     */
    public static <T extends Annotation> T findAnnotation(Method method, Class<T> annotationClass) {
        T annotation = method.getAnnotation(annotationClass);
        if (annotation != null) {
            return annotation;
        }
        for (Class<?> iface : method.getDeclaringClass().getInterfaces()) {
            try {
                Method interfaceMethod = iface.getMethod(method.getName(), method.getParameterTypes());
                annotation = interfaceMethod.getAnnotation(annotationClass);
                if (annotation != null) {
                    return annotation;
                }
            } catch (NoSuchMethodException ignored) {
            }
        }
        return null;
    }
}
