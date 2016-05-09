package com.kolodiazhny.dao.impl;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kolodiazhny.dao.AccountDao;
import com.kolodiazhny.dao.NoResultFound;
import com.kolodiazhny.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;
import java.util.Objects;


public class AccountDaoJsonImpl implements AccountDao {

    private List<Account> accounts = new ArrayList<>();

    public AccountDaoJsonImpl(String jsonAccounts) {
        Type listType = new TypeToken<ArrayList<Account>>() {}.getType();
        accounts = new Gson().fromJson(jsonAccounts, listType);

    }

    @Override
    public Account findById(String id) {
        for (Account account: accounts) {
            if (Objects.equals(id, account.getId())) {
                return account;
            }
            return account;
        }
        throw new NoResultFound();
    }
}
