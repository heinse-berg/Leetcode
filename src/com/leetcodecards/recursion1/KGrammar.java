package com.leetcodecards.recursion1;

import java.util.*;

public class KGrammar {

    public int kthGrammar(int n, int k) {
        StringBuilder s = new StringBuilder("0"), prev;
        int i, j;
        for(i = 2; i <= n; i++) {
            prev = s;
            s = new StringBuilder();
            for(j = 0; j < prev.length(); j++) {
                if(prev.charAt(j) == '0')
                    s.append("01");
                else
                    s.append("10");
            }
        }
        return s.charAt(k-1);
    }

    public static void main(String[] args) {
        KGrammar abc = new KGrammar();
        System.out.println(abc.kthGrammar(1,1));
    }
}
