package com.RokuEng.springdata.util;

import lombok.experimental.UtilityClass;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@UtilityClass
public class Nullables {
    public <T> void notNull(T object, Consumer<T> supplier) {
        if (object == null) {
            throw new NullPointerException();
        } else {
            supplier.accept(object);
        }
    }

    public <T> T notNull(T object, Function<T, T> supplier) {
        if (object == null) {
            throw new NullPointerException();
        } else {
            return supplier.apply(object);
        }
    }
}
