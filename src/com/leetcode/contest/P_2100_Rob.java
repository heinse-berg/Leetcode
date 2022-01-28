package com.leetcode.contest;

import java.util.*;
import java.util.stream.Collectors;

public class P_2100_Rob {

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, len = security.length, ct = 0, j;
        long prefixSum = 0;
        if(time >= len) return res;
        if(time == 0) {
            Arrays.stream(security).forEach(res::add);
            return res;
        }
        while(i+1 < len && ct < time-1) {
            if(security[i] < security[i+1])
                ct = 0;
            else
                ct++;
            i++;
        }
        if(ct != time-1)
            return res;
        j = i+2;
        while(j+1 < len && ct < time-1) {
            if(security[j] > security[j+1])
                ct = 0;
            else
                ct++;
            j++;
        }
        res.add(security[++i]);
        if(ct != time-1)
            return res;

        return res;
    }

    public static void main(String[] args) {
        P_2100_Rob abc = new P_2100_Rob();
        System.out.println();
    }
}
