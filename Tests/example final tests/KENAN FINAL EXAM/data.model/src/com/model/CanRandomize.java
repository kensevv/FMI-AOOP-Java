package com.model;

import java.util.Random;

public enum CanRandomize {
    RAND(new Random());

    public final Random generator;

    CanRandomize(Random generator) {
        this.generator = generator;
    }

    public String generateString(){

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;

        return generator.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

    }
}
