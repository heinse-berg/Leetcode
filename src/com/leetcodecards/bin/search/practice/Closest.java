package com.leetcodecards.bin.search.practice;

import java.util.*;

public class Closest {

    public int binSearch(int[] array, int x) {
        int low = 0, high  = array.length-1, mid, ans = -1;
        while(low <= high) {
            mid = low + (high-low)/2;
            if(mid > 0 || array[mid-1] - x <= 0 && array[mid] - x >= 0)
                return Math.abs(array[mid-1] - x) > array[mid]-x ? array[mid] : array[mid-1];
            else if(array[mid-1] - x < 0 && array[mid] - x < 0) {
                low = mid + 1;
                ans = array[mid];
            }
            else {
                high = mid - 1;
                ans = array[mid-1];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Closest abc = new Closest();
        System.out.println(abc.binSearch(new int[] {1,4,6,8,10,12}, 0));
        System.out.println(abc.binSearch(new int[] {1,4,6,8,10,12}, 13));
        System.out.println(abc.binSearch(new int[] {1,4,6,8,10,12}, 1));
        System.out.println(abc.binSearch(new int[] {1,4,6,8,10,12}, 12));
        System.out.println(abc.binSearch(new int[] {1,4,6,9,10,12}, 7));
        System.out.println(abc.binSearch(new int[] {1,4,6,9,10,12}, 8));
        System.out.println(abc.binSearch(new int[] {1,4,6,9,10,12}, 10));
        System.out.println(abc.binSearch(new int[] {1,4,6,9,10,12}, 2));
    }
}
