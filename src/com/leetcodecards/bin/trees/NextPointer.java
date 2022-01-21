package com.leetcodecards.bin.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
public class NextPointer {

    public Node connect(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        int i, len;

        if(root == null) return null;

        Node curr = root;
        queue.add(root);

        while(!queue.isEmpty()) {
            len = queue.size();
            for(i = 0; i < len; i++) {
                curr = queue.pop();
                if(i < len-1)
                    curr.next = queue.peek();
                if(curr.left != null) {
                    queue.add(curr.left);
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }
            curr.next = null;
        }
        return root;
    }

    public static void main(String[] args) {
        NextPointer abc = new NextPointer();
        //System.out.println(abc.connect());
    }
}
