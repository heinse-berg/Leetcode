package com.leetcodecards.recursion1;

import java.util.*;

public class Pow {

    public double myPow(double x, int n) {
        if(n == 0 || x == 1) return 1;
        if(n < 0) {
            x = 1/x; n = -n;
        }
        long i;
        double ans = 1, currProduct = x;
        for(i = n; i > 0; i = i/2) {
            if(i % 2 != 0) {
                ans *= currProduct;
            }
            currProduct *= currProduct;
        }
        return ans;
    }

    public double myPowRecursive(double x, int n) {
        if(n < 0) {
            x = 1/x; n = -n;
        }
        return pow(x,n);
    }

    double pow(double x, int n) {
        if(n == 0 || x == 1) return 1;
        double half = pow(x, n/2);
        if(n % 2 != 0) return (half * half * x);
        return half * half;
    }

    public static void main(String[] args) {
        Pow abc = new Pow();
        System.out.println(abc.myPowRecursive(2, 15));
        System.out.println(abc.myPowRecursive(3, 7));
        System.out.println(abc.myPowRecursive(3, 5));
    }
}
