package com.RokuEng.springdata.util;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public
interface TriFunction<T, U, V,R> {

    R apply(T t, U u, V v);

}
