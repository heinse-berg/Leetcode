package com.leetcodecards.recursion1;

import java.util.*;

public class PascalTriangle {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new LinkedList<>();
        for(int i = rowIndex; i >= 0; i--) {
            list.add(pascal(rowIndex, i));
        }
        return list;
    }

    int pascal(int i, int j) {
        if(i == j || j == 0 || i == 0)
            return 1;
        return pascal(i-1, j-1) + pascal(i-1, j);
    }

    public static void main(String[] args) {
        PascalTriangle abc = new PascalTriangle();
        /*System.out.println(abc.pascal(0,0));
        System.out.println(abc.pascal(1,0));
        System.out.println(abc.pascal(1,1));
        System.out.println(abc.pascal(2,0));
        System.out.println(abc.pascal(2,1));
        System.out.println(abc.pascal(3,0));
        System.out.println(abc.pascal(3,1));
        System.out.println(abc.pascal(3,2));
        System.out.println(abc.pascal(3,1));
        System.out.println(abc.pascal(4,0));
        System.out.println(abc.pascal(4,1));
        System.out.println(abc.pascal(4,2));
        System.out.println(abc.pascal(4,3));*/
        System.out.println(abc.getRow(4));
    }
}
