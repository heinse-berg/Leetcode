package com.leetcodecards.nary.trees;

import java.util.*;

public class Traversals {

    LinkedList<Integer> res = new LinkedList<>();

    public void pre(Node root) {
        if(root == null)
            return;
        List<Node> children = root.children;
        if(children != null) {
            for(Node c : children) {
                pre(c);
            }
        }
        res.add(root.val);
    }

    public List<Integer> preorder(Node root) {
        pre(root);
        return res;
    }

    public static void main(String[] args) {
        Traversals abc = new Traversals();
        Node node = new Node(1);
        Node thre = new Node(3);
        thre.children = Arrays.asList(new Node(4), new Node(5));
        List<Node> children = Arrays.asList(new Node(2), thre, new Node(6));
        System.out.println(abc.preorder(node));
    }
}
