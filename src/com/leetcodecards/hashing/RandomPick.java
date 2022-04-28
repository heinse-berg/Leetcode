package com.leetcodecards.hashing;

import java.util.*;

public class RandomPick {

    int[] w, pointers;
    int pointer, n;

    public RandomPick(int[] w) {
        this.w = w;
        Arrays.sort(this.w);
        n = w.length;
        pointers = new int[n];
        System.arraycopy(w, 0, pointers, 0, n);
        pointer = n-1;
    }

    public int pickIndex() {

        if(pointers[pointer] == 0) {
            pointer = (pointer-1)%n;
            if(pointer == -1) {
                pointer = n-1;
                System.arraycopy(w, 0, pointers, 0, n);
            }
        }
        --pointers[pointer];

        return pointer;
    }

    public static void main(String[] args) {
        RandomPick abc = new RandomPick(new int[] {1,3});
        System.out.println(abc.pickIndex());
        System.out.println(abc.pickIndex());
        System.out.println(abc.pickIndex());
        System.out.println(abc.pickIndex());
        System.out.println(abc.pickIndex());
        System.out.println(abc.pickIndex());
        System.out.println(abc.pickIndex());
        System.out.println(abc.pickIndex());
        System.out.println(abc.pickIndex());
        System.out.println(abc.pickIndex());
        System.out.println(abc.pickIndex());
        System.out.println(abc.pickIndex());
        System.out.println(abc.pickIndex());

        System.out.println();
    }
}
