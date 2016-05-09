package com.kolodiazhny.dao;


import com.kolodiazhny.model.Account;

public interface AccountDao {
    Account findById(String id);
}
