package com.leetcodecards.dynamic.programming.tutorial;

import javafx.util.Pair;

import java.util.*;

public class JumpSpikes {

    HashMap<Pair<Integer, Integer>, Boolean> memo;

    public boolean dp(int i, int speed, boolean[] spikes) {
        if(speed < 0 || i >= spikes.length || i < 0 || !spikes[i])
            return false;

        Pair<Integer, Integer> p = new Pair<>(i, speed);
        if(memo.containsKey(p))
            return memo.get(p);

        if(speed == 0)
            return true;

        boolean a = dp(i+speed-1, speed-1,spikes);
        boolean b = dp(i+speed, speed, spikes);
        boolean c = dp(i+speed+1, speed+1, spikes);

        memo.put(p, a || b || c);
        return memo.get(p);
    }

    public boolean canStop(boolean[] spikes, int speed) {
        memo = new HashMap<>();
        return dp(0, speed, spikes);
    }

    public static void main(String[] args) {
        JumpSpikes abc = new JumpSpikes();
        System.out.println(abc.canStop(new boolean[]{true,true,false,true,true,false,true}, 2));
        System.out.println();
    }
}
