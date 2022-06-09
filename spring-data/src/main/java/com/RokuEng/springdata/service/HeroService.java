package com.RokuEng.springdata.service;

import com.RokuEng.springdata.config.wrapper.AccountWrapper;
import com.RokuEng.springdata.core.Account;
import com.RokuEng.springdata.core.Bank;
import com.RokuEng.springdata.core.entity.hero.Hero;
import com.RokuEng.springdata.repo.HeroRepo;
import com.RokuEng.springdata.util.Nullables;
import com.RokuEng.springdata.util.Transactions;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class HeroService {
    private Bank bank;
    private AccountWrapper accountWrapper;
    private final HeroRepo heroRepo;

    public void putOnDeposit(Hero hero) {
        Transactions.transaction(() ->
        {
            Account account = accountWrapper.get();
            account.setMoney(hero.getCache());
            hero.setCache(BigDecimal.ZERO);
            bank.save(hero, account);
        });
    }

    public Account getAccount(Hero hero) {
        return Nullables.notNull(bank.getMap().get(hero), account -> {
            if (account == null) {
                throw new RuntimeException();
            }
            return account;
        });
    }

    public List<Hero> findAllHeroes() {
        return heroRepo.findAll();
    }

    public Hero findHeroByName(String name) {
        return heroRepo.findByName(name).orElseThrow();
    }

    public List<Hero> findUpdatedHeroes() {
        return heroRepo.findByComplexQuery("After%");
    }
}
