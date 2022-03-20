package com.leetcodecards.segment.tree;

public class NumArray {

    int[] tree;
    int n;

    public NumArray(int[] nums) {
        int len = nums.length, size;
        n = nums.length;
        size = (int) Math.ceil(Math.log(n)/Math.log(2));
        n  = (int) Math.pow(2, size);
        tree = new int[2*n];
        for(int i = n; i < n+len; i++)
            tree[i] = nums[i-len-1];

        for(int i = n-1; i > 0; i--) {
            tree[i] = tree[i*2] + tree[i*2+1];
        }
    }

    public void update(int index, int val) {
        index = index+n;
        tree[index] = val;
        index = index/2;

        while(index > 0) {
            tree[index]  = tree[index*2] + tree[index*2+1];
            index = index/2;
        }
    }

    public int sumRange(int l, int r) {
        l += n;
        // get leaf with value 'r'
        r += n;
        int sum = 0;
        while (l <= r) {
            if ((l % 2) == 1) {
                sum += tree[l];
                l++;
            }
            if ((r % 2) == 0) {
                sum += tree[r];
                r--;
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        NumArray abc = new NumArray(new int[] { 1, 3, 5});
        System.out.println(abc.sumRange(0,2));
        abc.update(1,2);
        System.out.println(abc.sumRange(0,2));
        System.out.println();
    }
}
