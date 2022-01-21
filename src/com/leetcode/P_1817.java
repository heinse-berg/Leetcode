package com.leetcode;

import java.util.*;

//https://leetcode.com/contest/weekly-contest-235/problems/finding-the-users-active-minutes/
/*
You are given the logs for users' actions on LeetCode, and an integer k. The logs are represented by a 2D integer array logs where each logs[i] = [IDi, timei]
indicates that the user with IDi performed an action at the minute timei.

Multiple users can perform actions simultaneously, and a single user can perform multiple actions in the same minute.

The user active minutes (UAM) for a given user is defined as the number of unique minutes in which the user performed an action on LeetCode.
A minute can only be counted once, even if multiple actions occur during it.

You are to calculate a 1-indexed array answer of size k such that, for each j (1 <= j <= k), answer[j] is the number of users whose UAM equals j.
 */
public class P_1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, HashSet<Integer>> ans = new HashMap<>();
        for (int[] log : logs) {
            if (!ans.containsKey(log[0])) {
                ans.put(log[0], new HashSet<>(Collections.singletonList(log[1])));
            } else {
                ans.get(log[0]).add(log[1]);
            }
        }
        int[] answer = new int[k];
        for(Map.Entry<Integer, HashSet<Integer>> entry : ans.entrySet()) {
            if(entry.getValue().size() <= k && entry.getValue().size() > 0) {
                answer[entry.getValue().size() - 1] ++;
            }
        }
        return answer;
    }

    public int getNumberOfBacklogOrders(int[][] orders) {
        PriorityQueue<int[]> buy = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
        PriorityQueue<int[]> sell = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int[] o : orders) {
            if (o[2] == 0)
                buy.offer(o);
            else
                sell.offer(o);
            while (!buy.isEmpty() && !sell.isEmpty() && sell.peek()[0] <= buy.peek()[0]) {
                int k = Math.min(buy.peek()[1], sell.peek()[1]);
                buy.peek()[1] -= k;
                sell.peek()[1] -= k;
                if (buy.peek()[1] == 0) buy.poll();
                if (sell.peek()[1] == 0) sell.poll();
            }

        }
        int res = 0, mod = 1000000007;
        for (int[] o : sell)
            res = (res + o[1]) % mod;
        for (int[] o : buy)
            res = (res + o[1]) % mod;
        return res;
    }

    public static void main(String[] args) {
        //[[305589003,4136],[305589004,4139],[305589004,4141],[305589004,4137],[305589001,4139],[305589001,4139]]
        int[][] arr = {{0,5},{1,2},{0,2},{0,5},{1,3}};
        System.out.println(Arrays.toString(new P_1817().findingUsersActiveMinutes(arr, 5)));
        /*LinkedHashMap  m = new LinkedHashMap();
        m.put();
        m.remove()*/
    }
}
