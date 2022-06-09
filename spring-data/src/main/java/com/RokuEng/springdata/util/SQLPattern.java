package com.RokuEng.springdata.util;

import lombok.AllArgsConstructor;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class SQLPattern {

    @AllArgsConstructor
    enum Characters {
        ANY("%"),
        CHAR("_"),
        ;

        final String s;
    }

    public String of(Object... args) {
        List<String> collect = Arrays.stream(args).filter(o -> o.getClass() == String.class).map(o -> (String) o).collect(Collectors.toList());
    }
}
