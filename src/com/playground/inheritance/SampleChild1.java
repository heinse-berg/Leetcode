package com.playground.inheritance;

public interface SampleChild1 {

    default void abc() {
        System.out.println("Base1");
    }

}
