package com.leetcodecards.arrayandstring;

public class P_67_Add_Binary {
    public static final char ZERO = '0';
    public static final char ONE = '1';

    public char[] binaryAdd(char a, char b, char carry) {
        if(carry == ZERO) {
            if(a == ZERO && b == ZERO) return new char[] {ZERO, ZERO};
            else if(a == ONE && b == ONE) return new char[] {ONE, ZERO};
            else if((a == ONE && b == ZERO) || (a == ZERO && b == ONE)) return new char[] {ZERO, ONE};
        }
        else {
            if(a == ZERO && b == ZERO) return new char[] {ZERO, ONE};
            else if(a == ONE && b == ONE) return new char[] {ONE, ONE};
            else if((a == ONE && b == ZERO) || (a == ZERO && b == ONE)) return new char[] {ONE, ZERO};
        }
        return new char[] {};
    }

    public String addBinary(String a, String b) {
        char[] a1 = a.toCharArray(), b1 = b.toCharArray(), res, ans = new char[a1.length];;
        if(b1.length > a1.length)
            return addBinary(new String(b1), new String(a1));
        int i = a1.length-1, j = b1.length-1; char carry = ZERO;
        for(; i >= 0; i--,j--) {
            if(j >= 0) res = binaryAdd(a1[i], b1[j], carry);
            else res = binaryAdd(a1[i], '0', carry);
            carry = res[0];
            ans[i] = res[1];
        }
        if(carry == ONE)
            return new StringBuilder(new String(ans)).insert(0, ONE).toString();
        return new String(ans);
    }

    public static void main(String[] args) {
        P_67_Add_Binary abc = new P_67_Add_Binary();
        System.out.println(abc.addBinary("1010111", "1100"));
    }
}
