package com.playground;

import java.util.*;

public class RevRecursion {

    public void reverseString(char[] s) {
        int i = 0, j = s.length-1;
        reverse(s, i, j);
        System.out.println(Arrays.toString(s));
    }

    void reverse(char[] s, int i, int j) {
        if(i >= j)
            return;
        reverse(s, i+1, j-1);
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        RevRecursion abc = new RevRecursion();
        abc.reverseString(new char[] {'a', 'b', 'c', 'd', 'e'});
        abc.reverseString(new char[] {'a', 'b', 'c', 'd', 'e','f','g'});
        System.out.println();
    }
}
