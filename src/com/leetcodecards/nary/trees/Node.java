package com.leetcodecards.nary.trees;

import java.util.*;

class Node {
    public int val;
    public List<Node> children;

    public static Node getNode() {
        Traversals abc = new Traversals();
        Node node = new Node(1);
        Node thre = new Node(3);
        thre.children = Arrays.asList(new Node(4), new Node(5));
        node.children = Arrays.asList(new Node(2), thre, new Node(6));
        return node;
    }

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node thre = new Node(3);
        thre.children = Arrays.asList(new Node(4), new Node(5));
        List<Node> children = Arrays.asList(new Node(2), thre, new Node(6));
    }
}
