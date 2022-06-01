package com.RokuEng.spring.domain.person;

import com.RokuEng.spring.domain.pet.Cat;
import com.RokuEng.spring.util.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

public class PetLover implements PetOwner {
    List<Cat> catList = new ArrayList<>();

    @Autowired
    public PetLover(Cat cat,
                    @Qualifier("cat") Cat anotherCat,
                    @Qualifier("cat") Cat thirdCat
    ) {
        catList.add(cat);
        catList.add(anotherCat);
        catList.add(thirdCat);
    }

    @Override
    public void callPet() {
        System.out.println("Come on guys!");
        catList.forEach(Cat::say);
    }
}
