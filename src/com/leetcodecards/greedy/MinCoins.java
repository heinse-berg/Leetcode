package com.leetcodecards.greedy;

public class MinCoins {

    public int minCoins(int cost) {

        int ans = 0;
        int[] coins = new int[] {1,2,5,10,20,50,100,500,1000};

        for(int i = 8; i >= 0 && cost > 0; i--) {
            while(i >= 0 && cost < coins[i])
                i--;

            ans += cost/coins[i];
            cost = cost%coins[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        MinCoins abc = new MinCoins();
        System.out.println(abc.minCoins(4));
    }
}
