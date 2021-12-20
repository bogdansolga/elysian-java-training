package com.elysian.java.training.d02.s1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class CollectionsSamples {

    public static void main(String[] args) {
        //listSample();

        //equalsAndHashCode();

        //setExamples();

        //comparatorExample();

        queuing();
    }

    private static void queuing() {
        Queue<String> strings = new LinkedList<>();
    }

    private static void comparatorExample() {
        List<Product> products = new ArrayList<>();

        // imperative iteration
        final Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            final Product product = iterator.next();

            // the only (imperative) way to remove an item during the iteration
            iterator.remove();
        }

        Collections.sort(products, new ProductComparator());
    }

    private static class ProductComparator implements Comparator<Product> {

        @Override
        public int compare(Product o1, Product o2) {
            return Integer.compare(o1.getId(), o2.getId());
        }
    }

    private static void setExamples() {
        Set<Product> products = new TreeSet<>();
        products.add(new Product(20, "Hot Chocolate"));
        System.out.println(products.size());
    }

    private static void equalsAndHashCode() {
        Product product = new Product(20, "Hot Chocolate");
        Product another = new Product(20, "Chocolate");
        System.out.println(product.equals(another));
        System.out.println(product.hashCode() + " / " + another.hashCode());
    }

    private static void listSample() {
        List<String> strings = new ArrayList<>(2);
        Vector<String> vector = new Vector<>();
        strings.add("January");
        strings.addAll(Set.of("Feb", "March"));
        strings.addAll(someStrings());
    }

    // always return the interface, not the implementation
    private static List<String> someStrings() {
        //return new ArrayList<>();
        return new LinkedList<>();
    }
}
