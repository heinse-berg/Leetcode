package com.leetcodecards.heap;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class DoubledArray {

    public int[] findOriginalArray(int[] changed) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        LinkedList<Integer> res = new LinkedList<>();

        for(int i : changed)
            map.put(i, map.getOrDefault(i, 0) + 1);

        if(map.containsKey(0)) {
            int ct = map.get(0);
            if(ct % 2 != 0)
                return new int[]{};
            ct = ct/2;
            while(ct > 0) {
                res.add(0);
                ct--;
            }
            map.remove(0);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int num = entry.getKey(); int count = entry.getValue();

            if(count != 0 && (!map.containsKey(num * 2) || map.get(num * 2) < count))
                return new int[] {};

            if(count > 0) {
                map.put(num * 2, map.get(num * 2) - count);
                while(count > 0) {
                    res.add(num);
                    count--;
                }
            }
        }

        int[] ans = new int[res.size()];
        int i = 0;
        for(int num : res)
            ans[i++] = num;

        return ans;
    }

    public static void main(String[] args) {
        DoubledArray abc = new DoubledArray();
    }
}
