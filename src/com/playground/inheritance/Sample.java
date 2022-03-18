package com.playground.inheritance;

public interface Sample {

    default void abc() {
        System.out.println("Base");
    }
}
