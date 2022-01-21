package com.leetcodecards.bin.search;

import java.util.*;

public class SearchRange {

    public int[] searchRange(int[] a, int target) {
        int low = 0, high = a.length-1, mid = -1; boolean flag = false;
        while(low <= high) {
            mid = low + (high-low)/2;
            if(a[mid] == target) {
                flag = true;
                break;
            }
            else if(a[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        if(flag) {
            low = mid; high = mid;
            while(low >= 0 && a[low] == a[mid])
                low--;
            while(high < a.length && a[high] == a[mid])
                high++;
            if(low < 0) low++;
            if(high > a.length) high--;
            return new int[]{a[low], a[high]};
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        SearchRange abc = new SearchRange();
        System.out.println(Arrays.toString(abc.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}
