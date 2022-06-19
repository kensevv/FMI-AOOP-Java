package com.company;

import java.util.Random;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        double generalPrice = 0.0;
        Random random;

        TreeSet<Integer> treeSet;
        TreeSet<Integer> treeSetResult;

        random = new Random();
        treeSet = new TreeSet<>();
        treeSetResult = new TreeSet<>();

        for (int i = 0; i < 10; i++) {
            treeSetResult.add(i);
        }

        for (int i = 0; i < 1000; i++) {
            do {
                treeSet.add(random.nextInt(10));
                generalPrice += 0.5;
            } while (!treeSet.equals(treeSetResult));
            treeSet.clear();
        }
        
        System.out.println("Estimated Price for all chocolate eggs is " + generalPrice / 1000 + " lv.");
    }
}
