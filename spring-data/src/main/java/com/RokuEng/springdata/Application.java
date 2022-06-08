package com.RokuEng.springdata;

import com.RokuEng.springdata.config.AccountConfiguration;
import com.RokuEng.springdata.config.BankConfiguration;
import com.RokuEng.springdata.core.Bank;
import com.RokuEng.springdata.core.entity.hero.Hero;
import com.RokuEng.springdata.service.HeroService;
import com.RokuEng.springdata.util.Closables;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        Closables.handle(new AnnotationConfigApplicationContext(BankConfiguration.class, AccountConfiguration.class), context -> {

            HeroService service = context.getBean(HeroService.class);

            Hero hero = new Hero();
            hero.setId(1);
            hero.setCache(BigDecimal.valueOf(100));

            service.putOnDeposit(hero);

            Bank bank = context.getBean(Bank.class);
            System.out.println(bank.getMap());

            try {
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
    }
}
