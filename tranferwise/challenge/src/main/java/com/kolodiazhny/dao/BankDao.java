package com.kolodiazhny.dao;


import com.kolodiazhny.model.Bank;

public interface BankDao {
    Bank findByID(String id);
    Bank findByName(String name);
}
