package com.leetcodecards.bin.search;

public class P_278 {

    boolean isBadVersion(int version) {
        return version >= 6;
    }

    public int firstBadVersion(int n) {
        int low = 1, high = n, mid;
        while(low <= high) {
            if(low == high)
                return low;
            mid = low + (high-low)/2;
            if(isBadVersion(mid))
                high = mid;
            else
                low = mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        P_278 abc = new P_278();
        //System.out.println(abc.firstBadVersion(8));
        int b = -2;
        System.out.println(b%26);
    }
}
