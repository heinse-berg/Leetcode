package com.leetcodecards.bin.search;

public class P_33_Rotated_Sorted {

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int pivot = findPivot(nums, low, high);
        if(pivot != -1)
            if (target <= nums[high]) low = pivot;
            else high = pivot - 1;
        while(low <= high) {
            pivot = low + (high - low) / 2;
            if(nums[pivot] == target) return pivot;
            if(target < nums[pivot]) high = pivot-1;
            else low = pivot + 1;
        }
        return -1;
    }

    public int findPivot(int[] nums, int low, int high) {
        int mid;
        if(nums.length == 1)
            return -1;
        if(nums.length == 2 && nums[1] > nums[0])
            return -1;
        if(nums.length == 2)
            return nums[1];
        while(low <= high) {
            mid = low + (high-low) / 2;
            if(mid-1 >= 0 && nums[mid-1] > nums [mid])
                return mid;
            if(mid+1 <= high && nums[mid+1] < nums[mid])
                return mid+1;
            else if(low < high && nums[low] < nums[mid])
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        P_33_Rotated_Sorted abc = new P_33_Rotated_Sorted();
        System.out.println(abc.search(new int[] {5,1,3} , 5));
    }
}
