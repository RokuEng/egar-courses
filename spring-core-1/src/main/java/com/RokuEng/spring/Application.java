package com.RokuEng.spring;

import com.RokuEng.spring.config.SpringConfiguration;
import com.RokuEng.spring.domain.pet.Cat;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        Cat pet = context.getBean("cat", Cat.class);
        Cat anotherPet = context.getBean("cat", Cat.class);

        pet.say();
        anotherPet.say();

        System.out.println(pet);
        System.out.println(anotherPet);

        context.close();

    }
}
