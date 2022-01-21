package com.algorithm.basic;

import java.util.*;

//https://www.geeksforgeeks.org/convert-an-array-to-reduced-form-set-1-simple-and-hashing/
public class ArrayCompress {
    class Number{
        int value;
        int prevIndex;

        Number(int value, int prevIndex) {
            this.value = value;
            this.prevIndex = prevIndex;
        }
    }

    int[] compress(int[] arr) {
        int length = arr.length, i;
        int[] ans = new int[length];

        TreeSet<Number> hashSet = new TreeSet<>(Comparator.comparingInt(a -> a.value));
        for(i = 0; i < length; i++) {
            hashSet.add(new Number(arr[i] ,i));
        }

        for(i = 0; i < length; i++) {
            ans[hashSet.first().prevIndex] = i;
            hashSet.remove(hashSet.first());
        }
        return ans;
    }

    public static void main(String[] args) {
        /*int[] arr = {5, 10, 40, 30, 20};
        System.out.println(Arrays.toString(new ArrayCompress().compress(arr)));
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.add(12);
        set.add(-1);
        set.add(14);
        set.add(-10);
        set.remove(12);

        for (Integer integer : set) {
            System.out.println(integer);
        }
        LinkedList<Integer> list = new LinkedList<>();
        int i = 8;*/
        String.valueOf(8);
        Integer.parseInt("9999999991");

        /*int a = (int) (set.toArray())[0];*/
    }
}
