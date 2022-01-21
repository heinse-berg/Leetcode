package com.algorithm.basic;

public class Kadane {

    public static int sum(int[] arr) {
        int maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0;
        for (int value : arr) {
            maxEndingHere += value;
            if (maxEndingHere > maxSoFar)
                maxSoFar = maxEndingHere;
            if (maxEndingHere < 0)
                maxEndingHere = 0;
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(Kadane.sum(arr));
    }
}
