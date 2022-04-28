package com.gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSortedArrays {
    List<Integer> func(int[] a, int[]b, int[] c) {
        int k=0, cl=c.length;
        ArrayList<Integer> result = new ArrayList<>();
        HashSet<Integer> a1 = new HashSet<>(), b1 = new HashSet<>();
        Arrays.stream(a).forEach(a1::add);
        Arrays.stream(b).forEach(b1::add);
        for( ; k < cl; k++)
            if(a1.contains(c[k]) && b1.contains(c[k])) result.add(c[k]);
        return result;
    }

    public static void main(String[] args) {
        ThreeSortedArrays abc = new ThreeSortedArrays();
        int a[] = {1, 5, 10, 20, 40, 80};
        int b[] = {6, 7, 20, 80, 100};
        int c[] = {3, 4, 15, 20, 30, 70, 80, 120};
        System.out.println(abc.func(a, b, c));
    }
}
