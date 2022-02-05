package com.leetcodecards.trie;

import java.util.*;

public class MaxXOR {
    /*public int findMaximumXOR(int[] nums) {
        int maxNum = nums[0];
        for(int num : nums) maxNum = Math.max(maxNum, num);
        // length of max number in a binary representation
        int L = (Integer.toBinaryString(maxNum)).length();

        int maxXor = 0, currXor;
        Set<Integer> prefixes = new HashSet<>();
        for(int i = L - 1; i > -1; --i) {
            // go to the next bit by the left shift
            maxXor <<= 1;
            // set 1 in the smallest bit
            currXor = maxXor | 1;
            prefixes.clear();
            // compute all possible prefixes
            // of length (L - i) in binary representation
            for(int num: nums)
                prefixes.add(num >> i);
            // Update maxXor, if two of these prefixes could result in currXor.
            // Check if p1^p2 == currXor, i.e. p1 == currXor^p2.
            for(int p: prefixes) {
                if (prefixes.contains(currXor^p)) {
                    maxXor = currXor;
                    break;
                }
            }
        }
        return maxXor;
    }*/

    static class TrieNode {
        HashMap<Character, TrieNode> map = new HashMap<>();
    }

    TrieNode root;

    public int findMaximumXOR(int[] nums) {
        root = new TrieNode();
        int max = Integer.MIN_VALUE, L, maxXor = Integer.MIN_VALUE;

        for(int num : nums)  max = Math.max(max, num);

        L = Integer.toBinaryString(max).length();

        for(int num : nums) {
            StringBuilder sb = new StringBuilder(Integer.toBinaryString(num));
            TrieNode curr = root;
            int len = sb.length();
            if(len < L)
                while(len < L) {
                    sb.insert(0, '0');
                    len++;
                }

            for(char c : sb.toString().toCharArray()) {
                if(!curr.map.containsKey(c))
                    curr.map.put(c, new TrieNode());
                curr = curr.map.get(c);
            }
            curr = root;
            int currXor = 0;
            for(char bit : sb.toString().toCharArray()) {
                Character toggledBit = bit == '1' ? '0' : '1';
                if (curr.map.containsKey(toggledBit)) {
                    currXor = (currXor << 1) | 1;
                    curr = curr.map.get(toggledBit);
                } else {
                    currXor = currXor << 1;
                    curr = curr.map.get(bit);
                }
            }

            maxXor = Math.max(maxXor, currXor);

        }

        return maxXor;
    }

    public static void main(String[] args) {
        MaxXOR abc = new MaxXOR();
        System.out.println(abc.findMaximumXOR(new int[] {
                5,25
        }));
    }
}
