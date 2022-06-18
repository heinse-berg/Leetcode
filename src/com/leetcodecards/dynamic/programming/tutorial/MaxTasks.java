package com.leetcodecards.dynamic.programming.tutorial;

public class MaxTasks {

    int n;
    int[][] memo;

    public int dp(int[] l, int[] t, int time, int i, int j) {

        if(i == n)
            return 0;

        if(memo[i][j] != 0)
                return memo[i][j];


        int ans = 0;
        if(time - t[i] - (l[i] - l[j]) >= 0)
            ans = Math.max(ans, 1+dp(l, t, time - t[i] - (l[i] - l[j]), i+1, i));

        ans = Math.max(ans, dp(l, t, time, i+1, j));

        return memo[i][j] = ans;
    }

    public int tasks(int[] l, int[] t, int time) {
        n = l.length;
        int[] l1 = new int[n+1];
        int[] t1 = new int[n+1];
        System.arraycopy(l, 0, l1, 1, n);
        System.arraycopy(t, 0, t1, 1, n++);
        memo = new int[n][n];
        return dp(l1, t1, time, 1, 0);
    }

    public static void main(String[] args) {
        MaxTasks m = new MaxTasks();
        System.out.println(m.tasks(new int[] {1,2}, new int[] {3,2}, 10));
    }
}
