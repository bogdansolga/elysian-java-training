package com.elysian.java.training.d02.s1;

import java.io.Serializable;

// immutable class --> can only set the values once
public class Product implements Serializable, Comparable<Product> {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        return name != null ? name.equals(product.name) : product.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Product o) {
        return Integer.compare(id, o.id);
    }
}
