package com.leetcodecards.arrayandstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P_118_Pascal_Triangle {
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 1) return Collections.singletonList(Collections.singletonList(1));
        else if(numRows == 2) return Arrays.asList(Arrays.asList(1), Arrays.asList(1, 1));
        int i, j;
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(1)); result.add(Arrays.asList(1, 1));
        for(i = 3; i <= numRows; i++) {
            Integer[] list = new Integer[i];
            list[0] = 1; list[i-1] = 1;
            List<Integer> prevRowList = result.get(i-2);
            for(j = 0; j < prevRowList.size()-1; j++)
                list[j+1] = (prevRowList.get(j) + prevRowList.get(j+1));
            result.add(Arrays.asList(list));
        }
        return result;
    }

    public static void main(String[] args) {
        P_118_Pascal_Triangle abc = new P_118_Pascal_Triangle();
        System.out.println(abc.generate(5));
    }
}
