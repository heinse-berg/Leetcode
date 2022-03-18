package com.leetcodecards.bin.trees;

import com.leetcodecards.recursion1.TreeNode;
import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.HashMap;

public class Path2Nodes {

    TreeNode start, end;
    boolean first = false, last = false;

    public void populate(TreeNode child, TreeNode par, HashMap<TreeNode, TreeNode> lineage, int startValue, int destValue) {
        if(child == null || !(first && last))
            return;

        populate(child.left, child, lineage, startValue, destValue);

        if(child.val == startValue) {
            start = child;
            first = true;
        }

        if(child.val == destValue) {
            end = child;
            last = true;
        }

        lineage.put(child, par);

        populate(child.right, child, lineage, startValue, destValue);
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {

        HashMap<TreeNode, TreeNode> lineage = new HashMap<>();

        populate(root, null, lineage, startValue, destValue);
        ArrayDeque<Pair<TreeNode, StringBuilder>> q = new ArrayDeque<>();

        q.add(new Pair<>(start, new StringBuilder()));

        while(!q.isEmpty()) {
            int currSize = q.size();

            for(int i = 0; i < currSize; i++) {
                Pair<TreeNode, StringBuilder> curr = q.pollFirst();
                TreeNode c = curr.getKey(); StringBuilder path = curr.getValue();
                if(c.val == destValue)
                    return path.toString();
                if(lineage.get(c) != null)
                    q.addLast(new Pair<>(lineage.get(c), new StringBuilder(path).append("U")));
                if(c.left != null)
                    q.addLast(new Pair<>(c.left, new StringBuilder(path).append("L")));
                if(c.right != null)
                    q.addLast(new Pair<>(c.right, new StringBuilder(path).append("R")));

            }
        }

        return "";
    }

    public static void main(String[] args) {
        Path2Nodes abc = new Path2Nodes();
    }
}
