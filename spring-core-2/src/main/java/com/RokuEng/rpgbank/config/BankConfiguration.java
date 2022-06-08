package com.RokuEng.rpgbank.config;

import com.RokuEng.rpgbank.domain.account.Account;
import com.RokuEng.rpgbank.domain.account.StarterAccount;
import com.RokuEng.rpgbank.domain.Hero;
import com.RokuEng.rpgbank.util.HeroBuilder;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@ComponentScan("com.RokuEng.rpgbank")
public class BankConfiguration implements ApplicationContextAware {

    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    @Bean(value = "heroAccount")
    public Map<Hero, Account> heroAccount() {
        HashMap<Hero, Account> map = new HashMap<>();
        map.put(new HeroBuilder(0, "John", 1000f, 1000f).build(),
                ctx.getBean(Account.class)
        );
        return map;
    }
}
