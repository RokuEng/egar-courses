package com.RokuEng.spring.domain.pet;

import com.RokuEng.spring.domain.pet.Pet;

public class Cat implements Pet {

	@Override
	public void say() {
		System.out.println("Meow!");
	}
}
