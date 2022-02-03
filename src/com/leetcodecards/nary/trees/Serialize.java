package com.leetcodecards.nary.trees;

import java.util.*;

public class Serialize {

    String nullString = "null";

    public void pre(Node root, StringBuilder sb) {
        sb.append(root.val).append(",");
        if(root.children.size() == 0) {
            sb.append(nullString).append(",");
            return;
        }
        for(Node c : root.children) {
            pre(c, sb);
        }
    }

    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        if(root == null)
            return sb.toString();
        pre(root, sb);
        return sb.toString();
    }

    public Node buildNodes(LinkedList<String> nodes) {
        if(nodes.size() == 0)
            return null;

        Node root = new Node();
        root.children = new LinkedList<>();
        String val = nodes.get(0);
        if(val.equals(nullString)) {
            return null;
        }
        root.val = Integer.parseInt(val);
        while(!nodes.isEmpty()) {
            nodes.remove(0);
            Node child = buildNodes(nodes);
            root.children.add(child);
        }

        return root;
    }

    public Node deserialize(String data) {
        if(data.length() == 0)
            return null;
        LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        Node n = buildNodes(nodes);
        return n;
    }

    public static void main(String[] args) {
        Serialize abc = new Serialize();
        System.out.println(abc.deserialize("1,2,null,3,6,null,7,11,14," +
                "null,4,8,12,null,5,9,13,null,10,null,"));
    }
}
