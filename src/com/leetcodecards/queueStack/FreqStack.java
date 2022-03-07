package com.leetcodecards.queueStack;

import javafx.util.Pair;

import java.util.*;

public class FreqStack {

    HashMap<Integer, Integer> freq;
    HashMap<Integer, Stack<Integer>> occurrences;
    int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        occurrences = new HashMap<>();
        maxFreq = -1;
    }

    public void push(int val) {
        freq.put(val, freq.getOrDefault(val, 0) + 1);
        int currFreq = freq.get(val);
        maxFreq = Math.max(maxFreq, currFreq);
        if(!occurrences.containsKey(currFreq))
            occurrences.put(currFreq, new Stack<>());
        occurrences.get(currFreq).push(val);
    }

    public int pop() {
        int ans = occurrences.get(maxFreq).pop();
        if(occurrences.get(maxFreq).isEmpty())
            maxFreq--;
        freq.put(ans, freq.get(ans)-1);
        return ans;
    }

    public static void main(String[] args) {
        FreqStack abc = new FreqStack();
        abc.push(4); abc.push(0);
        abc.push(9); abc.push(3);
        abc.push(4); abc.push(2);
        abc.pop();
        abc.push(6);
        abc.pop();
        abc.push(1);;
        abc.pop();
        abc.push(1);
        abc.pop();
        abc.push(4);
        abc.pop();
        abc.pop();
        abc.pop();
        abc.pop();
        abc.pop();
        abc.pop();

        System.out.println();
        //["FreqStack","push","push","push","push","push","push","pop","push","pop","push","pop","push","pop","push","pop","pop","pop","pop","pop","pop"]
        //[[],[4],[0],[9],[3],[4],[2],[],[6],[],[1],[],[1],[],[4],[],[],[],[],[],[]]
    }
}
