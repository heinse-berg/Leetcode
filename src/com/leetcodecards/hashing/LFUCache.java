package com.leetcodecards.hashing;

import java.util.*;

public class LFUCache {

    HashMap<Integer, int[]> map = new HashMap<>();
    TreeMap<Integer, LinkedList<Integer>> freqMap = new TreeMap<>();
    final int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int k) {
        Integer key = k;
        int[] res = map.get(key);
        if(res == null)
            return -1;
        int freq = ++res[1] - 1;
        freqMap.get(freq).remove(key);
        if(freqMap.get(freq).size() == 0)
            freqMap.remove(freq);
        if(!freqMap.containsKey(res[1]))
            freqMap.put(res[1], new LinkedList<>());
        freqMap.get(res[1]).addLast(key);
        return res[0];
    }

    public void put(int k, int value) {
        Integer key = k;

        if(!map.containsKey(key)) {

            if(map.size() == capacity) {
                int freqToEvict = freqMap.firstKey();
                int keyToEvict = freqMap.get(freqToEvict).removeFirst();
                map.remove(keyToEvict);
                if(freqMap.get(freqToEvict).size() == 0)
                    freqMap.remove(freqToEvict);
            }

            map.put(key, new int[] {value, 0});
            if(!freqMap.containsKey(0))
                freqMap.put(0, new LinkedList<>());
            freqMap.get(0).addLast(key);
        }

        else {

            int[] res = map.get(key);
            int freq = ++res[1] - 1;
            res[0] = value;
            freqMap.get(freq).remove(key);
            if(freqMap.get(freq).size() == 0)
                freqMap.remove(freq);
            if(!freqMap.containsKey(res[1]))
                freqMap.put(res[1], new LinkedList<>());
            freqMap.get(res[1]).addLast(key);
        }
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(1);
        /*cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));*/
        /*cache.put(3,1);
        cache.put(2,1);
        cache.put(2,2);
        cache.put(4,4);
        System.out.println(cache.get(2));*/
        cache.put(0,0);
        System.out.println(cache.get(0));
    }
}
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
///
//["LFUCache","put","put","put","put","get"]
//[[2],[3,1],[2,1],[2,2],[4,4],[2]]

//["LFUCache","put","get"]
//[[0],[0,0],[0]]