package com.gfg;

import java.util.ArrayList;
import java.util.List;

public class ClosestPair2Sorted {
    List<Integer> func(int []a, int []b, int sum) {
        int j = 0, addition = 0, min = Integer.MAX_VALUE;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(; j < b.length; j++) {
            addition = Math.abs(a[0] + b[j] - sum);
            if(addition < min) {
                min = addition;
            }
        }
        arrayList.add(addition);
        return arrayList;
    }

    public static void main(String[] args) {
        ClosestPair2Sorted abc = new ClosestPair2Sorted();
        System.out.println(abc.func(new int[]{}, new int []{}, 45));
    }
}
