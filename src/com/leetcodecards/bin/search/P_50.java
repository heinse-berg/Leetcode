package com.leetcodecards.bin.search;

public class P_50 {
    public double myPow(double x, int n) {
        int log = (int) Math.ceil(Math.log(x)), i;
        long pow = 1;
        double ans = x;
        for(i = 1; i <= log; i++) {
            pow *= 2;
            ans *= ans;
        }
        for(i = (int) (n-pow); i > 0; i--)
            ans *= x;
        return ans;
    }

    public static void main(String[] args) {
        P_50 abc = new P_50();
        System.out.println(abc.myPow(3, 5));
    }
}
