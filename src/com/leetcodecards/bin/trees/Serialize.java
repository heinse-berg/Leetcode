package com.leetcodecards.bin.trees;

import com.leetcodecards.recursion1.TreeNode;

import java.util.*;

public class Serialize {

    String nullString = "null";


    public void preOrder(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append(nullString).append(",");
            return;
        }
        sb.append(root.val).append(",");
        preOrder(root.left, sb);
        preOrder(root.right, sb);
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null)
            return sb.toString();
        preOrder(root, sb);
        return sb.toString();
    }

    public TreeNode buildNode(List<String> nodes) {
        TreeNode root = new TreeNode();
        if(nodes.size() == 0)
            return null;
        String nodeVal = nodes.get(0);
        if(nodeVal.equals(nullString))
            return null;
        root.val = Integer.parseInt(nodeVal);
        nodes.remove(0);
        root.left = buildNode(nodes);
        nodes.remove(0);
        root.right = buildNode(nodes);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> nodes = new ArrayList<>(Arrays.asList(data.split(",")));
        if(nodes.size() == 0)
            return null;
        return buildNode(nodes);
    }

    public static void main(String[] args) {
        Serialize abc = new Serialize();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        //System.out.println(abc.serialize(root));
        System.out.println(abc.deserialize(abc.serialize(root)));
    }
}
