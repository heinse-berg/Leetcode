package com.leetcodecards.bin.search;

import java.util.*;

public class P_658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0, high = arr.length-1, mid;
        while(low < high) {
            mid = low + (high-low)/2;
            if(Math.abs(x - arr[mid]) <= Math.abs(arr[mid+1]-x)) {
                high = mid;
            }
            else {
                low = mid+1;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = low; i >= 0 && k > 0; i--,k--) result.add(arr[i]);
        for(int i = low+1; k > 0; i++,k--) result.add(arr[i]);
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        P_658 abc = new P_658();
        System.out.println(abc.findClosestElements(new int[]{1, 1,1,10,10,10},1,9));
    }
}
