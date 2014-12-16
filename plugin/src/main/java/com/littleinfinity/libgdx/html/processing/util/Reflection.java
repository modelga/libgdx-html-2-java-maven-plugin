package com.littleinfinity.libgdx.html.processing.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public final class Reflection {

    private Reflection() {
    }

    public static boolean isObjectImplementingSpecificGenericInterface(Object object, Class<?> iface, Class<?>... typeArguments) {
        List<Type> genericInterfaces = Arrays.asList(object.getClass().getGenericInterfaces());

        boolean isOnlyOneCandidate = genericInterfaces.stream().
                filter(byParameterizedType()).
                filter(byImplementingInterface(iface)).
                filter(byEqualTypeArgumentLength(typeArguments)).
                filter(byEqualArgumentType(typeArguments)).
                count() == 1;

        return isOnlyOneCandidate;
    }

    private static Predicate<Type> byParameterizedType() {
        return type -> type instanceof ParameterizedType;
    }

    private static Predicate<Type> byImplementingInterface(Class<?> iface) {
        return type -> {
            ParameterizedType parameterizedType = ((ParameterizedType) type);
            return parameterizedType.getRawType().equals(iface);
        };
    }

    private static Predicate<Type> byEqualTypeArgumentLength(Class<?>[] typeArguments) {
        return type -> {
            ParameterizedType parameterizedType = ((ParameterizedType) type);
            return parameterizedType.getActualTypeArguments().length == typeArguments.length;
        };
    }

    private static Predicate<Type> byEqualArgumentType(Class<?>[] typeArguments) {
        return type -> {
            List<Type> genericArguments = Arrays.asList(((ParameterizedType) type).getActualTypeArguments());
            return genericArguments.equals(Arrays.asList(typeArguments));
        };
    }
}
