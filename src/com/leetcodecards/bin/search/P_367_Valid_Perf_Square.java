package com.leetcodecards.bin.search;

public class P_367_Valid_Perf_Square {
    public boolean isPerfectSquare(int n) {
        long num = n;
        if(num ==0 || num == 1)
            return true;
        long start = 2, end = num, mid, square;
        while(start <= end) {
            mid = start + (end-start)/2;
            square = mid*mid;
            if(square == num)
                return true;
            else if(square > num)
                end = mid-1;
            else
                start = mid+1;
        }
        return false;
    }

    public static void main(String[] args) {
        /*P_367_Valid_Perf_Square abc = new P_367_Valid_Perf_Square();
        System.out.println(abc.isPerfectSquare(16));
        System.out.println(abc.isPerfectSquare(25));
        System.out.println(abc.isPerfectSquare(900));
        System.out.println(abc.isPerfectSquare(576));
        System.out.println(abc.isPerfectSquare(225));
        System.out.println("ac");
        System.out.println(abc.isPerfectSquare(226));
        System.out.println(abc.isPerfectSquare(227));
        System.out.println(abc.isPerfectSquare(228));
        System.out.println(abc.isPerfectSquare(229));
        System.out.println(abc.isPerfectSquare(22));
        System.out.println(abc.isPerfectSquare(4));*/
        System.out.println(new P_367_Valid_Perf_Square().isPerfectSquare(2147483647));
    }
}
