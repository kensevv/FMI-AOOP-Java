package com.company;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
         list.add("aBc");
         list.add("d");
         list.add("ef");
         list.add("123456");

         List<String> result = list.stream().
                 sorted().
                 map(String::toUpperCase).
                 collect(Collectors.toList());

        System.out.print(result);
    }
}
