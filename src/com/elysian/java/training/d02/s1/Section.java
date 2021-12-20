package com.elysian.java.training.d02.s1;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Section implements Serializable {

    private final String name;
    private final List<Product> products;

    public Section(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }

    // try to not include the inner collection in the
    // equals and hashCode methods --> mainly from performance reasons
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return Objects.equals(name, section.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
