package com.RokuEng.springdata.config;

import com.RokuEng.springdata.config.wrapper.AccountWrapper;
import com.RokuEng.springdata.core.Account;
import com.RokuEng.springdata.util.BeanScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.function.Supplier;

@Configuration
//@EnableScheduling
@ComponentScan("com.RokuEng.springdata")
public class AccountConfiguration {
    @Bean
    @Scope(BeanScope.prototype)
    public Account account() {
        return new Account();
    }

    @Bean
    public AccountWrapper accountWrapper() {
        return this::account;
    }
}
