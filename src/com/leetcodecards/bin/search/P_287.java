package com.leetcodecards.bin.search;

public class P_287 {
    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length-1, curr, count, duplicate=-1;
        while(low <= high) {
            curr = (low + high)/2;
            count = 0;
            for(int num : nums) {
                if(num <= curr)
                    count++;
            }
            if(count > curr) {
                duplicate = curr;
                high = curr-1;
            }
            else
                low = curr+1;
        }
        return duplicate;
    }

    public static void main(String[] args) {
        P_287 abc = new P_287();
        System.out.println(abc.findDuplicate(new int[] {4, 3, 4, 5, 1, 2}));
    }
}
