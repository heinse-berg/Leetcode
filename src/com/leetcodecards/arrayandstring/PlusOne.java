package com.leetcodecards.arrayandstring;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1, i;
        for(i = digits.length-1; i >= 0 ; i--) {
            digits[i] += carry;
            if(digits[i] > 9) {
                digits[i] = 0;
                carry = 1;
            }
            else carry = 0;
        }
        if(carry == 1) {
            int[] res = new int[digits.length+1];
            res[0] = carry;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne abc = new PlusOne();
        System.out.println(Arrays.toString(abc.plusOne(new int[]{8, 9, 9, 9})));
    }
}
