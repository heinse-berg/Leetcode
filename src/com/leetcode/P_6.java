package com.leetcode;

import java.util.ArrayList;

public class P_6 {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int len = s.length(), i, j;
        boolean down = true;
        ArrayList<StringBuilder> lists = new ArrayList<>();
        for(i = 0; i < numRows; i++) lists.add(new StringBuilder());
        lists.get(0).append(s.charAt(0));
        StringBuilder ans = new StringBuilder();
        i = 1;
        while (i < len) {
            if(down)
                for(j = 1; j < numRows && i < len; i++,j++) lists.get(j).append(s.charAt(i));
            else
                for(j = numRows-2; j >= 0 && i < len; j--,i++) lists.get(j).append(s.charAt(i));
            down = !down;
        }
        int curRow = 0;
        boolean goingDown = false;
        curRow += goingDown ? 1 : -1;
        for(i = 0; i < numRows; i++) ans.append(lists.get(i));
        return ans.toString();
    }

    public static void main(String[] args) {
        //enter code
        System.out.println(new P_6().convert("ABCDF", 2));
    }
}
