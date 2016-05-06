package com.kolodiazhny.entity;


public class NameEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("name : " + this.name + '\n');

        return stringBuilder.toString();
    }
}
