package com.RokuEng.spring.domain.pet;

import com.RokuEng.spring.domain.pet.Pet;

public class Empty implements Pet {
    @Override
    public void say() {
        System.out.println("Nothing");
    }
}
