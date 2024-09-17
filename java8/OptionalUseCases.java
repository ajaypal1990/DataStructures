package com.ajay.concepts.java8;

import java.util.Optional;

public class OptionalUseCases {
    public static void main(String[] args) {
        Optional<String> emptyOpt = Optional.empty();

        Optional<String> nullableOpt = Optional.ofNullable(null);

        //nullableOpt.isPresent()
    }
}
