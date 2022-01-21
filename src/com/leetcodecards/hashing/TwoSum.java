package com.leetcodecards.hashing;

import java.util.*;

public class TwoSum {

    HashMap<Integer, Integer> map;

    public TwoSum() {
        map = new HashMap<>();
    }

    public void add(int number) {
        map.merge(number, 1, Integer::sum);
    }

    public boolean find(int value) {
        for(int i : map.keySet()) {
            if(map.containsKey(value-i) && (i != value - i)) {
                return true;
            }
            else {
                if(map.get(i) > 1)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSum abc = new TwoSum();

        abc.add(4);
        abc.add(2);
        abc.add(1);
        abc.add(5);
        abc.add(6);
        abc.add(-1);
        abc.add(7);
        abc.add(100);
        abc.add(8);

        /*System.out.println(abc.find(6));
        System.out.println(abc.find(17));
        System.out.println(abc.find(0));*/
        System.out.println(abc.find(100));
    }
}
