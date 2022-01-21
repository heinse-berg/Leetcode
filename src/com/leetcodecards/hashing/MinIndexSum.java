package com.leetcodecards.hashing;

import java.util.*;

public class MinIndexSum {

    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> ans = new HashMap<>();
        int i, len = list1.length, min = Integer.MAX_VALUE, temp;
        for(i = 0; i < len; i++)
            map.put(list1[i], i);
        len = list2.length;
        for(i = 0; i < len; i++)
            if(map.containsKey(list2[i])) {
                temp = i + map.get(list2[i]);
                if (temp <= min) {
                    ans.put(list2[i], temp);
                    min = i + temp;
                }
            }
        final int m = min ;
        ans.values().removeIf(a -> a > m);
        return ans.keySet().toArray(new String[]{});
    }

    public static void main(String[] args) {
        MinIndexSum abc = new MinIndexSum();
        System.out.println(Arrays.toString(abc.findRestaurant(new String[]{"S","TEXP","BK","KFC"}, new String[]{"KFC","BK","S"})));
    }
    /*
    ["S","TEXP","BK","KFC"]
["S","TEXP","BK","KFC"]
     */
}
