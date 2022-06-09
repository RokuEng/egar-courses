package com.RokuEng.springdata.core;

import lombok.Data;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Data
public class Account {
    private BigDecimal money;
    private BigDecimal rate;

    @PostConstruct
    private void init() {
        this.money = BigDecimal.TEN;
        this.rate = BigDecimal.valueOf(1d + Math.random());
    }

    public void apply(Integer seconds) {
        System.out.println(money);
        money = money.multiply(rate);
        System.out.println(money);
    }
}
