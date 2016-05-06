package com.kolodiazhny.service;


import com.google.gson.Gson;

public class Util {

    public Result parse(String json) {;
        Gson gson = new Gson();
        return gson.fromJson(json, Result.class);
    }
}
