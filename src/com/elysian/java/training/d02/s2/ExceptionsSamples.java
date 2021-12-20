package com.elysian.java.training.d02.s2;

import com.elysian.java.training.d02.s1.Product;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ExceptionsSamples {

    public static void main(String[] args) throws Exception {
        //checkedExceptionSample();

        //uncheckedExceptionSample();

        // centralized exception handling mechanism
        //final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();

        //exceptionTypeChangingExample();

        exceptionSwallowing();

        shortCircuitingExample(3);

        //tryWithResourcesExample();

        debuggingMode();
    }

    private static void debuggingMode() {
        Product product = new Product(5, "Hot Chocolate");
        Product another = new Product(20, "Chocolate");

        Set<Product> productSet = new HashSet<>();
        productSet.addAll(Set.of(product, another));

        displayProducts(productSet);
    }

    private static void displayProducts(Set<Product> productSet) {
        for (Product product : productSet) {
            System.out.println(product.getId() + ", " + product.getName());

            if (product.getId() < 10) {
                System.out.println(product);
            }
        }
    }

    private static void tryWithResourcesExample() {
        File file = new File("some.file");

        // try with resources
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void shortCircuitingExample(int productId) {
        // short-circuiting --> interrupting the execution flow as soon as possible
        // please do this as often as possible
        if (productId < 0) throw new IllegalArgumentException("Invalid id");

        // the rest of the logic --> happy path
    }

    private static void exceptionSwallowing() {
        try {
            if (true) throw new Exception("Example");
        } catch (Exception ex) {
            // don't do this
        }
    }

    private static void exceptionTypeChangingExample() {
        try {
            if (true) throw new Exception("Example");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new IllegalArgumentException(ex.getMessage());
        }
    }

    private static void uncheckedExceptionSample() {
        if (true) throw new RuntimeException("The hipster kid");
    }

    private static void checkedExceptionSample() throws Exception {
        if (true) throw new Exception("The ugly checked exceptions");
    }
}
