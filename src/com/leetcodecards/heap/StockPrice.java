package com.leetcodecards.heap;

import javafx.util.Pair;

import java.util.*;

public class StockPrice {

    TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
    TreeMap<Integer, HashSet<Integer>> values = new TreeMap<>();

    public StockPrice() {
    }

    public void update(int timestamp, int price) {

        if(map.containsKey(timestamp)) {
            int prevValue = map.get(timestamp);
            values.get(prevValue).remove(timestamp);
            if(values.get(prevValue).isEmpty())
                values.remove(prevValue);
        }

        map.put(timestamp, price);
        if(!values.containsKey(price))
            values.put(price, new HashSet<>());
        values.get(price).add(timestamp);
    }

    public int current() {
        return map.entrySet().iterator().next().getValue();
    }

    public int maximum() {
        return values.lastKey();
    }

    public int minimum() {
        return values.firstKey();
    }

    public static void main(String[] args) {
        StockPrice abc = new StockPrice();
    }
}
