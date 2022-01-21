package com.leetcodecards.arrays101;

import java.util.*;

public class MaxSOFar {

    public int[] replaceElements(int[] arr) {
        int i, len = arr.length, maxSoFar = Integer.MIN_VALUE, temp;
        for(i = len-2; i > 0; i--) {
            if(arr[i] >= maxSoFar) {
                maxSoFar = arr[i];
            }
            arr[i-1] = maxSoFar;
        }
        arr[len-1] = -1;
        return arr;
    }

    public static void main(String[] args) {
        MaxSOFar abc = new MaxSOFar();
        System.out.println(Arrays.toString(abc.replaceElements(new int[] {17,18,5,4,6,1})));
    }
}
