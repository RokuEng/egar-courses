package com.RokuEng.spring.domain.person;

import com.RokuEng.spring.domain.pet.Empty;
import com.RokuEng.spring.domain.pet.Pet;
import org.springframework.beans.factory.annotation.Autowired;

public class Person implements PetOwner {
    private Pet pet = new Empty();
    private String name;
    private Integer age;

    @Autowired
    public Person(Pet pet) {
        this.pet = pet;
    }

    @Override
    public void callPet() {
        System.out.printf("Hey! I'm %s %d years old\n", name, age);
        pet.say();
    }

    @Autowired
    public void setName(String name) {
        this.name = name;
    }

    @Autowired
    public void setAge(Integer age) {
        this.age = age;
    }
}
