package com.leetcode;

public class P_1201UglyNumber {
    public int nthUglyNumber(int n, int a, int b, int c) {
        if(n == 1)
            return Math.min(Math.min(a, b), c);
        int i = 1, j = 1, k = 1, counter = 0;
        while(true) {
            int ans = Math.min(Math.min((a*i), (b*j)), c*k) % (2000000000) ;
            if(ans% a*i == 0)
                i++;
            if(ans%b*j == 0)
                j++;
            if(ans%c*k == 0)
                k++;
            counter++;
            if(counter == n)
                return ans;
        }
    }

    public static void main(String[] args) {
        //n = 1000000000,2, 217983653, 336916467
        System.out.println(new P_1201UglyNumber().nthUglyNumber(5, 5, 11, 13));
    }
}
