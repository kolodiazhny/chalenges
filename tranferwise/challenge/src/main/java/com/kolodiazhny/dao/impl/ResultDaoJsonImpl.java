package com.kolodiazhny.dao.impl;

import com.google.gson.Gson;
import com.kolodiazhny.dao.ResultDao;
import com.kolodiazhny.model.Result;

public class ResultDaoJsonImpl implements ResultDao {

    @Override
    public String getResult(String json) {
        Result rs = new Gson().fromJson(json, Result.class);
        return rs.getResult() + "\n" +
            rs.getPoints() + "\n" +
            rs.getNextTask();
    }
}
