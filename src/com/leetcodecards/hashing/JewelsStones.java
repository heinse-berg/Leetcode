package com.leetcodecards.hashing;

import java.util.*;

public class JewelsStones {

    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();
        for(char c: jewels.toCharArray())
            set.add(c);
        int sum = 0;
        for(char c : stones.toCharArray()) {
            if(set.contains(c))
                sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        JewelsStones abc = new JewelsStones();
        System.out.println();
    }
}
