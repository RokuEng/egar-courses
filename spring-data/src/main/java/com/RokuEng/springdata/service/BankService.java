package com.RokuEng.springdata.service;

import com.RokuEng.springdata.core.Account;
import com.RokuEng.springdata.core.Bank;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BankService {
    private Bank bank;

    public List<Account> findAll() {
        return new ArrayList<>(bank.getMap().values());
    }

    @Scheduled(cron = "15 * * * * *")
    public void updateCurrencies() {
        System.out.println("Update currencies. . .");
        List<Account> all = findAll();
        if (all.isEmpty()) {
            return;
        }
        all.forEach(account -> account.apply(1));
    }
}
