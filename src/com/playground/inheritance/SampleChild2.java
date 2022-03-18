package com.playground.inheritance;

public interface SampleChild2{

    default void abc() {
        System.out.println("Base2");
    }
}
