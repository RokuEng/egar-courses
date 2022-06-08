package com.RokuEng.rpgbank;

import com.RokuEng.rpgbank.config.BankConfiguration;
import com.RokuEng.rpgbank.domain.Bank;
import com.RokuEng.rpgbank.domain.Hero;
import com.RokuEng.rpgbank.util.Closables;
import com.RokuEng.rpgbank.util.HeroBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        Closables.handle(new AnnotationConfigApplicationContext(BankConfiguration.class), context -> {

            Bank bank = context.getBean(Bank.class);
            Hero john = new HeroBuilder(0, "John", 0f, 0f).build();
            bank.incomeTo(john);

            System.out.println(bank.findByHero(john).orElseThrow());
        });
    }
}
