package com.RokuEng.springdata.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Threads {
    public static void pause(Long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
