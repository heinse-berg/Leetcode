package com.leetcodecards.graph.bfs;

import java.util.*;
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class NAryTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(root);
        while(!queue.isEmpty()) {
            int currentSize  = queue.size();
            LinkedList<Integer> currNodes = new LinkedList<>();
            for(int i = 0; i < currentSize; i++) {
                Node curr = queue.pollFirst();
                if(curr != null) {
                    currNodes.add(curr.val);
                    if(curr.children != null) {
                        for (Node child : curr.children) {
                            queue.addLast(child);
                        }
                    }
                }
            }
            res.add(currNodes);
        }

        return res;
    }

    public static void main(String[] args) {
        NAryTraversal abc = new NAryTraversal();
        System.out.println();
    }
}
