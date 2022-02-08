package com.playground.bin.search;

import java.util.*;

public class ClosestElementToX {

    public int closestToX(int[] array, int x) {
        int low = 0, high  = array.length-1, mid, leftDiff, rightDiff;
        if(x <= array[low])
            return array[low];
        else if(x >= array[high])
            return array[high];
        while(low <= high) {
            mid = low + (high-low)/2;
            leftDiff = array[mid]-x;
            rightDiff = array[mid+1]-x;
            if(leftDiff <= 0 && rightDiff >= 0)
                return Math.abs(leftDiff) < rightDiff ? array[mid] : array[mid+1];
            else if(leftDiff < 0) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ClosestElementToX abc = new ClosestElementToX();
        System.out.println(abc.closestToX(new int[] {1,4,10,20,30,40,50,60,70}, 2));
        System.out.println(abc.closestToX(new int[] {1,4,10,20,30,40,50,60,70,80}, 5));
        System.out.println(abc.closestToX(new int[] {1,4,10,20,30,40,50,60,70,80}, 11));
        System.out.println(abc.closestToX(new int[] {1,4,10,20,30,40,50,60,70,80}, 19));
        System.out.println(abc.closestToX(new int[] {1,4,10,20,30,40,50,60,70}, 59));
        System.out.println(abc.closestToX(new int[] {1,4,10,20,30,40,50,60,70}, 61));
        System.out.println(abc.closestToX(new int[] {1,4,10,20,30,40,50,60,70}, 68));
        /*System.out.println(abc.closestToX(new int[] {}, ));
        System.out.println(abc.closestToX(new int[] {}, ));*/
    }
}
