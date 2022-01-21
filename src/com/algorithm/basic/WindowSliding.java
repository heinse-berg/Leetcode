package com.algorithm.basic;

public class WindowSliding {

    public static int sum(int[] arr, int k) {
        int sum = 0;
        for(int j = 0; j < k; j++) {
            sum += arr[j];
        }
        int winSum = sum;
        for(int i = k; i < arr.length; i++) {
            winSum = winSum - arr[i-k]  + arr[i];
            sum = Math.max(sum, winSum);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 4, 2, 10, 23, 3, 1, 0, 20};
        System.out.println(sum(arr, 4));
    }
}