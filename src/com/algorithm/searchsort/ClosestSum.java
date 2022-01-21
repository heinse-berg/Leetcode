package com.algorithm.searchsort;

import java.util.ArrayList;
import java.util.Arrays;

public class ClosestSum {
    int[] sum(int[] arr, int sum) {
        //enter code
        int i = 0;
        int j = arr.length - 1, diff = Integer.MAX_VALUE;
        int[] res = new int[]{arr[0], arr[1]};
        while( i < j) {
            int tempSum = arr[i] + arr[j];
            if(Math.abs(tempSum - sum) < diff) {
                diff = Math.abs(tempSum - sum);
                res[0] = arr[i];
                res[1] = arr[j];
            }
            if(tempSum  - diff < sum) {
                i++;
            }
            else {
                j--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //enter code
        int[] arr = {1, 3, 4, 7, 10};
        System.out.println(Arrays.toString(new ClosestSum().sum(arr, 15)));
    }
}
