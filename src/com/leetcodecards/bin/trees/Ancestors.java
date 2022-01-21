package com.leetcodecards.bin.trees;

import com.leetcodecards.recursion1.TreeNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Ancestors {

    public List<TreeNode> findAncestorsHelper(TreeNode root, int a, List<TreeNode> list) {
        if(root == null) return null;

        if(root.val == a) {
            list.add(root);
            return list;
        }

        List<TreeNode> left = findAncestorsHelper(root.left, a, list);
        if(left != null) {
            list.add(root);
            return list;
        }

        List<TreeNode> right = findAncestorsHelper(root.right, a, list);
        if(right != null) {
            list.add(root);
            return list;
        }

        return null;
    }

    public List<TreeNode> findAncestors(TreeNode root, int a) {
        return findAncestorsHelper(root, a, new LinkedList<>());
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pAncestors = findAncestors(root, p.val);
        List<TreeNode> qAncestors = findAncestors(root, q.val);

        int i = pAncestors.size()-1, j = qAncestors.size()-1;
        for(; i >= 0 && j >= 0; i--, j--) {
            if(pAncestors.get(i) != qAncestors.get(j))
                return pAncestors.get(i+1);
        }

        return pAncestors.get(i+1);
    }

    public boolean exists(TreeNode root, int target) {
        if(root == null)    return false;
        if(root.val == target)  return true;
        return exists(root.left, target) || exists(root.right, target);
    }

    public static void main(String[] args) {
        Ancestors abc = new Ancestors();

        System.out.println(abc.findAncestors(TreeNode.getRoot(), 100));
        
        System.out.println(abc.findAncestors(TreeNode.getRoot(), 999));
        
        System.out.println(abc.findAncestors(TreeNode.getRoot(), 3500));
        
        System.out.println(abc.findAncestors(TreeNode.getRoot(), 6000));

        System.out.println(abc.exists(TreeNode.getRoot(), 700));
    }
}
