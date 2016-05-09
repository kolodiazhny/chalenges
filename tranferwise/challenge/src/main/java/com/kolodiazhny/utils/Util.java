package com.kolodiazhny.utils;


import com.google.gson.Gson;
import com.kolodiazhny.model.Result;

public class Util {

    public Result parse(String json) {;
        Gson gson = new Gson();
        return gson.fromJson(json, Result.class);
    }
}
