package com.playground;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class IteratorPractice {

    public static void main(String[] args) {
        IteratorPractice abc = new IteratorPractice();
        HashSet<Integer> list = new HashSet<>();
        list.add(2);
        list.add(3); list.add(4); list.add(5);


        Iterator<Integer> it = list.iterator();

        while(it.hasNext()) {
            //it.remove();
            System.out.println(it.next());
        }

        System.out.println();
    }
}
