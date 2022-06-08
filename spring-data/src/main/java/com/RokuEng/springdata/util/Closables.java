package com.RokuEng.springdata.util;

import lombok.experimental.UtilityClass;

import java.io.Closeable;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Function;

@UtilityClass
public class Closables {

    public <T extends Closeable, R> R handle(T closeable, Function<T, R> function) {
        try(closeable) {
            return function.apply(closeable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public <T extends Closeable> void handle(T closeable, Consumer<T> consumer) {
        try(closeable) {
            consumer.accept(closeable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}