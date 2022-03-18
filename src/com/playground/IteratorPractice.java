package com.playground;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class IteratorPractice {

    public static void main(String[] args) {
        IteratorPractice abc = new IteratorPractice();
        HashSet<Integer> set = new HashSet<>();
        set.add(2);
        set.add(3); set.add(4); set.add(5);

        Iterator<Integer> it = set.iterator();
        LinkedList<Integer> l = new LinkedList<>();
        it = l.iterator();

        while(it.hasNext()) {
            //it.remove();
            System.out.println(it.next());
        }
        System.out.println();
    }
}
