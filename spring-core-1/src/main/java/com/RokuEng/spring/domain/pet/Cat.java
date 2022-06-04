package com.RokuEng.spring.domain.pet;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "cat")
@Scope(value = "prototype")
@Setter(Autowired)
public class Cat {

	private final String name;

	@Autowired
	public Cat(
			@Value("${cat.name}")
			String name
	) {
		this.name = name;
	}

	public void say() {
		System.out.println(name + " Meow!");
	}

	public void init() {
		System.out.println("Cat now available");
	}

	public void destroy() {
		System.out.println("Cat destroyed");
	}

	public String getName() {
		return name;
	}
}
