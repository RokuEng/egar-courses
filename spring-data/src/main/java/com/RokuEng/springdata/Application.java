package com.RokuEng.springdata;

import com.RokuEng.springdata.config.AccountConfiguration;
import com.RokuEng.springdata.config.BankConfiguration;
import com.RokuEng.springdata.config.JpaConfiguration;
import com.RokuEng.springdata.service.HeroService;
import com.RokuEng.springdata.util.Closables;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        Closables.handle(new AnnotationConfigApplicationContext(BankConfiguration.class, AccountConfiguration.class, JpaConfiguration.class), context -> {

            HeroService service = context.getBean(HeroService.class);

            service.findUpdatedHeroes().forEach(System.out::println);
        });
    }
}
