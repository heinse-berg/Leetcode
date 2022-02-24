package com.leetcodecards.bin.search.practice;

import java.util.*;

public class Bounds {

    public int lowerBound(int[] array, int num) {
        int low = 0, high = array.length-1, mid, ans = -1;

        while(low <= high) {
            mid = low + (high-low)/2;

            if(array[mid] >= num) {
                ans = mid;
                high = mid - 1;
            }
            else
                low = mid+1;
        }
        
        return ans == -1 ? -1 : array[ans];
    }
    
    public int upperBound(int[] array, int num) {
        int low = 0, high = array.length-1, mid, ans = -1;

        while(low <= high) {
            mid = low + (high-low)/2;

            if(array[mid] <= num) {
                ans = mid;
                low = mid + 1;
            }
            else
                high = mid-1;
        }

        return ans == -1 ? -1 : array[ans];
    }

    public static void main(String[] args) {
        Bounds abc = new Bounds();
        System.out.println(abc.upperBound(new int[] {1,3,5,7,9,11,14}, 8));
        System.out.println(abc.upperBound(new int[] {1,3,5,7,9,11,14}, 0));
        System.out.println(abc.upperBound(new int[] {1,3,5,7,9,11,14}, 15));
        System.out.println(abc.upperBound(new int[] {1,3,5,7,9,11,14}, 5));
        System.out.println(abc.upperBound(new int[] {1,3,5,7,9,11,14}, 14));
    }
}
