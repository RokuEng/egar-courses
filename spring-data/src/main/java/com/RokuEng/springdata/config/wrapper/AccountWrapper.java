package com.RokuEng.springdata.config.wrapper;

import com.RokuEng.springdata.core.Account;

import java.util.function.Supplier;

public interface AccountWrapper extends Supplier<Account> {
    Account get();
}
