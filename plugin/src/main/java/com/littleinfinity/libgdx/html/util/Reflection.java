package com.littleinfinity.libgdx.html.util;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

import static com.google.common.collect.Iterables.filter;

public class Reflection {

    public static boolean isObjectImplementingSpecificGenericInterface(Object object, Class<?> iface, Class<?>... typeArguments) {
        Iterable<Type> genericInterfaces = Arrays.asList(object.getClass().getGenericInterfaces());
        genericInterfaces = Sets.newHashSet(filter(genericInterfaces, (type) -> type instanceof ParameterizedType));
        genericInterfaces = filter(genericInterfaces, (type) -> {
            ParameterizedType parameterizedType = ((ParameterizedType) type);
            return (parameterizedType.getRawType().equals(iface) && parameterizedType.getActualTypeArguments().length == typeArguments.length);
        });
        genericInterfaces = filter(genericInterfaces, (type) -> {
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            for (int i = 0; i < typeArguments.length; i++) {
                if (!actualTypeArguments[i].equals(typeArguments[i])) {
                    return false;
                }
            }
            return true;
        });
        return Iterables.size(genericInterfaces) == 1;
    }
}
