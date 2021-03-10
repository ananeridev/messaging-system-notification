package com.anabneri.messagingsystem.notfication.model;

import java.lang.reflect.Type;

public enum TypeEnum implements Type {

    INSERT("INSERT"),
    UPDATE("UPDATE"),
    DELETE("DELETE");

    private final String name;

    TypeEnum(String value) {
        this.name = value;
    }

    public String value() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getTypeName() {
        return null;
    }
}
