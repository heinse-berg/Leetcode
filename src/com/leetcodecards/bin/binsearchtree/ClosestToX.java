package com.leetcodecards.bin.binsearchtree;

import com.leetcodecards.recursion1.TreeNode;

import java.util.*;

public class ClosestToX {

    LinkedList<Integer> inOrder = new LinkedList<>();

    public void inorder(TreeNode node) {
        if(node == null)
            return;
        inorder(node.left);
        inOrder.add(node.val);
        inorder(node.right);
    }

    public int binSearch(Integer[] array, double x) {
        int low = 0, high  = array.length-1, mid;
        double leftDiff, rightDiff;
        if(x <= array[low])
            return low;
        else if(x >= array[high])
            return high;
        while(low <= high) {
            mid = low + (high-low)/2;
            leftDiff = array[mid]-x;
            rightDiff = array[mid+1]-x;
            if(leftDiff <= 0 && rightDiff >= 0)
                return Math.abs(leftDiff) <= rightDiff ? mid : mid+1;
            else if(leftDiff < 0) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return -1;
    }

    public int closestValue(TreeNode root, double target) {
        inorder(root);

        return binSearch(inOrder.toArray(new Integer[0]), target);
    }

    public static void main(String[] args) {
        ClosestToX abc = new ClosestToX();
        System.out.println();
    }
}
