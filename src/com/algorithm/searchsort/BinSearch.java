package com.algorithm.searchsort;

public class BinSearch {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1, mid;
        while(low <= high) {
            mid = low + (high-low)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }

    public int mySqrt(int x) {
        long low = 1, high = x, mid;
        long square;
        while(low <= high) {
            mid = low + (high-low)/2;
            square = mid * mid;
            if(square == x)
                return (int)mid;
            else if(square > x)
                high = mid-1;
            else
                low = mid+1;
        }
        if(low * low < high * high)
            return (int)low;
        return (int)high;
    }

    public static void main(String[] args) {
        BinSearch abc = new BinSearch();

        //System.out.println(abc.search(new int[] {-1,0,3,5,9,12}, 9));
        System.out.println(abc.mySqrt(2147395599));
    }
}
