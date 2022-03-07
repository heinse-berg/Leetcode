package com.leetcodecards.arrayandstring;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        int n = nums.length;
        AtomicInteger i = new AtomicInteger();
        String[] arr = new String[n];

        Arrays.stream(nums).forEach(a -> arr[i.getAndIncrement()] = String.valueOf(a));
        Arrays.sort(arr, (a, b) -> (a + b).compareTo(b + a));

        StringBuilder ans = new StringBuilder();
        Arrays.stream(arr).forEach(ans::append);
        return ans.toString();
    }

    public static void main(String[] args) {
        LargestNumber abc = new LargestNumber();
        System.out.println(abc.largestNumber(new int[] {3,30,34,5,9}));
        //[3,30,34,5,9]
        //3 30 34 5 9
        //"9534330"
    }
}
