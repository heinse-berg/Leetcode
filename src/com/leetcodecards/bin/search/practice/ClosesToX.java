package com.leetcodecards.bin.search.practice;

import java.util.*;

public class ClosesToX {

    public int binSearch(int[] array, int x) {
        int low = 0, high  = array.length-1, mid, leftDiff, rightDiff;
        if(x <= array[low])
            return low;
        else if(x >= array[high])
            return high;
        while(low <= high) {
            mid = low + (high-low)/2;
            leftDiff = array[mid]-x;
            rightDiff = array[mid+1]-x;
            if(leftDiff <= 0 && rightDiff >= 0)
                return Math.abs(leftDiff) <= rightDiff ? mid : mid+1;
            else if(leftDiff < 0) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return -1;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = binSearch(arr, x), j, i;
        LinkedList<Integer> ans = new LinkedList<>();
        ans.add(arr[index]);
        k--; i = index-1; j = index+1;

        while(k > 0) {
            if(i < 0 || j > arr.length-1)
                break;
            if(Math.abs(arr[i] - x) <= Math.abs(arr[j] - x))
                ans.add(arr[i--]);
            else
                ans.add(arr[j++]);
            k--;
        }

        for(; k > 0 && i >= 0; i--,k--)
            ans.add(arr[i]);

        for(; k > 0 && j < arr.length; j++,k--)
            ans.add(arr[j]);

        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        ClosesToX abc = new ClosesToX();
        System.out.println(abc.findClosestElements(new int[] {1,3}, 1,2));
    }
}
