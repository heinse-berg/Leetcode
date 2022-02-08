package com.leetcodecards.queueStack;

import javafx.util.Pair;

import java.util.*;

public class Decode {

    public String decodeString(String s) {
        Stack<Pair<Integer, String>> stack = new Stack<>();
        char[] arr = s.toCharArray();
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < arr.length; i++) {
            //
                ;
            StringBuilder temp = new StringBuilder();
            while(arr[i] >= 'a' && arr[i] <= 'z') {
                temp.append(arr[i]);
                i++;
            }

        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Decode abc = new Decode();
        System.out.println();
    }
}
