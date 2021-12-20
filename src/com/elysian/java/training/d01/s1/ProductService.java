package com.elysian.java.training.d01.s1;

public class ProductService {

    public void processProduct() {
        Product product = new Product(12, "Coffee");
        System.out.println(product.getName());

        Product theOther = new Product(product.getId(), "Even better coffee");
    }
}
