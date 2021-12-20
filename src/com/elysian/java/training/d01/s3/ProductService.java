package com.elysian.java.training.d01.s3;

import com.elysian.java.training.d01.s1.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        processElements(List.of(new Product(20, "Cookies")));
        processElements(List.of("Something"));
        processElements(List.of(23));
    }

    // type = generic inline (declared) type
    // <Type> = unbound type --> it extends (by default) Object
    // <Type extends ?> = bound type --> it extends that type / class
    public static <Type /* extends Product */> void processElements(List<Type> elements) {
        // perform magic in here
    }
}
