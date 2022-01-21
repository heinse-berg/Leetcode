package com.algorithm.greedy;

import java.util.*;

public class MinCoins {
    public static List<Integer> DENOMINATIONS = new ArrayList<>();

    static {
        DENOMINATIONS.add(1);
        DENOMINATIONS.add(2);
        DENOMINATIONS.add(5);
        DENOMINATIONS.add(10);
        DENOMINATIONS.add(20);
        DENOMINATIONS.add(50);
        DENOMINATIONS.add(100);
        DENOMINATIONS.add(500);
        DENOMINATIONS.add(1000);
    }

    public static int minCoins(int change) {
        Map<Integer, Integer> answer = new LinkedHashMap<>();
        int ans = 0, i, currVal;
        while(change !=0) {
            for(i = DENOMINATIONS.size() - 1; i >= 0; i--) {
                currVal = DENOMINATIONS.get(i);
                if (currVal <= change) {
                    int quo = change / currVal;
                    ans += quo;
                    change = change % currVal;
                    answer.put(currVal, quo);
                }
            }
        }
        answer.forEach((key, value) -> System.out.println("Deno : " + key + " Multiple : " + value));
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minCoins(426));
    }
}
