package com.leetcodecards.bin.search;

import java.util.*;

public class LowerBound {

    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        int lower = lowerBound(asteroids, mass), len = asteroids.length - 1;
        double mas = (double) mass;
        if(lower == -1) return false;
        for(; lower <= len; lower++) {
            if(mas < asteroids[lower])
                return false;
            mas += asteroids[lower];
        }
        return true;
    }

    public int lowerBound(int[] asteroids, int mass) {
        int low = 0, high = asteroids.length-1, mid;
        while(low+1 < high) {
            mid = low + (high-low)/2;
            if(asteroids[mid] > mass)
                high = mid - 1;
            else
                low = mid;
        }
        return asteroids[high] <= mass ? high : asteroids[low] <= mass ? low : -1;
    }

    public static void main(String[] args) {
        LowerBound abc = new LowerBound();
        /*System.out.println(abc.lowerBound(new int[] {5,10,15,20,25}, 25));
        System.out.println(abc.lowerBound(new int[] {5,10,15,20,25}, 5));
        System.out.println(abc.lowerBound(new int[] {5,10,15,20,25}, 4));
        System.out.println(abc.lowerBound(new int[] {5,10,15,20,25}, 22));
        System.out.println(abc.lowerBound(new int[] {5,10,15,20,25}, 10));
        System.out.println(abc.lowerBound(new int[] {5,10,15,20,25}, 21));
        System.out.println(abc.lowerBound(new int[] {5,10,15,20,25}, 15));
        System.out.println(abc.lowerBound(new int[] {5,10,15,20,25}, 150));
        5
[4,9,23,4]*/
        System.out.println(abc.asteroidsDestroyed(10, new int[] {3,5,9,9,21}));
    }
}
