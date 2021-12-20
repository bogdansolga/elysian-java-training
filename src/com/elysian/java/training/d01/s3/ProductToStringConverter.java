package com.elysian.java.training.d01.s3;

import com.elysian.java.training.d01.s1.Product;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class ProductToStringConverter implements Converter<Product, String> {

    @Override
    public String convertToOutput(Product product) {
        return null;
    }

    // bounds -> returning an object that has a bound (a parent class)
    public List<? extends Serializable> getElements() {
        return Collections.emptyList();
    }
}
