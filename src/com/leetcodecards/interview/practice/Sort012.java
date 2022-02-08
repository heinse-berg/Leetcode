package com.leetcodecards.interview.practice;

import java.util.*;

public class Sort012 {

    public int[] sort012(int[] arr) {

        int zeroEnd = 0, n = arr.length, twoEnd = n-1, i = 0;

        while(i <= twoEnd) {
            if(arr[i] == 0) {
                int temp = arr[zeroEnd];
                arr[zeroEnd] = arr[i];
                arr[i] = temp;
                zeroEnd++; i++;
            }
            else if(arr[i] == 2) {
                int temp = arr[twoEnd];
                arr[twoEnd] = arr[i];
                arr[i] = temp;
                twoEnd--;
            }
            else i++;
        }

        return  arr;
    }

    public static void main(String[] args) {
        Sort012 abc = new Sort012();
        System.out.println(Arrays.toString(abc.sort012(new int[] {2,2,2,0,0,1,1} )));
        System.out.println(Arrays.toString(abc.sort012(new int[] {1,1,0,1,0,2,0,1,2,0,2,0,0} )));
        System.out.println(Arrays.toString(abc.sort012(new int[] {2,2,2,0,0,0,1,0,1,2,2,1,2,1} )));
        System.out.println(Arrays.toString(abc.sort012(new int[] {0,0,0,1,1,1,2,2,0,1,2,0,0} )));
    }
}
