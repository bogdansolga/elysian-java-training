package com.elysian.java.training.d01.s2.abst;

import java.util.ArrayList;
import java.util.List;

public class ProductsHierarchyService {

    public static void main(String[] args) {
        List<AbstractProduct> products = new ArrayList<>();
        products.add(new Clock());
        products.add(new Laptop());

        for (AbstractProduct product : products) {
            System.out.println(product.getType());
        }
    }
}
