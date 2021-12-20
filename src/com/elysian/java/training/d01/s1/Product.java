package com.elysian.java.training.d01.s1;

import java.io.Serializable;

// immutable class --> can only set the values once
public class Product implements Serializable {

    private static final String NAME;

    static {
        NAME = "The product";
    }

    private final int id;
    private final String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String getStaticName() {
        return this.NAME;
    }
}
