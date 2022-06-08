package com.RokuEng.rpgbank.domain;

import com.RokuEng.rpgbank.domain.account.Account;
import com.RokuEng.rpgbank.domain.account.StarterAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class Bank {

    private static final Float INCOME_MODIFIER = 1.5f;

    private final Map<Hero, Account> map;

    @Autowired
    public Bank(Map<Hero, Account> map) {
        this.map = map;
    }

    public Optional<Account> findByHero(Hero hero) {
        return Optional.ofNullable(map.get(hero));
    }

    public void incomeTo(Hero hero) {
        Account account = findByHero(hero).orElseThrow();
        account.setMoney(
                account.getMoney() * INCOME_MODIFIER
        );
    }
}
