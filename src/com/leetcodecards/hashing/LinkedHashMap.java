package com.leetcodecards.hashing;

import java.util.*;

public class LinkedHashMap {

    boolean isLRU;
    int size;
    HashMap<Integer, Integer> map;
    ArrayDeque<Integer> queue;

    public LinkedHashMap(boolean isLRU, int size) {
        this.isLRU = isLRU;
        this.size = size;
    }

    public void add(int num) {
        if(map.containsKey(num))
            queue.remove(map.get(num));
        queue.addLast(num);
        int length = queue.size();
        map.put(num, length-1);
    }

    public int getLRUItem() {
        return queue.getFirst();
    }

    public static void main(String[] args) {
        LinkedHashMap abc = new LinkedHashMap(true, 10);

        System.out.println();
    }
}
