package com.RokuEng.springdata.config;

import com.RokuEng.springdata.core.Bank;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankConfiguration {

    @Bean
    public Bank bank() {
        Bank bank = new Bank();
        return bank;
    }

}
