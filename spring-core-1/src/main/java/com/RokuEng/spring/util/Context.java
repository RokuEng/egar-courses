package com.RokuEng.spring.util;

import com.RokuEng.spring.domain.person.PetOwner;
import com.RokuEng.spring.domain.pet.Cat;
import com.RokuEng.spring.domain.pet.Pet;
import lombok.experimental.UtilityClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.function.Function;

@UtilityClass
public class Context {

    private static final String location = "applicationcontext.xml";

    public Cat cat() {
        return useContext(context -> context.getBean("cat", Cat.class));
    }

    public Pet pet() {
        return useContext(context -> context.getBean("pet", Pet.class));
    }

    public Pet anotherPet() {
        return useContext(context -> context.getBean("pet2", Pet.class));
    }

    public PetOwner person() {
        return useContext(context -> context.getBean("person", PetOwner.class));
    }

    public  <T> T useContext(Function<ClassPathXmlApplicationContext, T> function) {
        try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(location)) {
            return function.apply(context);
        }
    }
}
