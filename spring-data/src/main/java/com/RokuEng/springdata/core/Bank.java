package com.RokuEng.springdata.core;

import com.RokuEng.springdata.core.entity.hero.Hero;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Getter
@NoArgsConstructor
public class Bank {
    private final Map<Hero, Account> map = new HashMap<>();

    public void save(Hero hero, Account account) {
        map.put(hero, account);
    }
}
