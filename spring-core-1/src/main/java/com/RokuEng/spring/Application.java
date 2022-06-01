package com.RokuEng.spring;

import com.RokuEng.spring.domain.pet.Pet;
import com.RokuEng.spring.util.Context;

public class Application {

    public static void main(String[] args) {
        Pet pet = Context.pet();
        Pet anotherPet = Context.anotherPet();
        pet.say();
        anotherPet.say();
    }
}
