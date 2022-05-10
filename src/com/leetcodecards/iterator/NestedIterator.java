package com.leetcodecards.iterator;

import java.util.*;

interface NestedInteger {

     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return empty list if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
}

public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> nl;
    ArrayDeque<Iterator<NestedInteger>> stack;
    Iterator<NestedInteger> itr;

    public NestedIterator(List<NestedInteger> nestedList) {
        nl = nestedList;
        stack = new ArrayDeque<>();
        itr = nestedList.iterator();
        stack.push(itr);
    }

    @Override
    public Integer next() {

        if(stack.isEmpty())
            return null;

        if(itr.hasNext()) {
            NestedInteger curr = itr.next();
            if(curr.isInteger())
                return curr.getInteger();
            itr = curr.getList().iterator();
        }

        else {
            stack.pop();
            itr = stack.peek();
            NestedInteger curr = itr.next();
            if(curr.isInteger())
                return curr.getInteger();
            itr = curr.getList().iterator();
        }

        stack.push(itr);
        return itr.next().getInteger();

    }

    @Override
    public boolean hasNext() {
        return nl.iterator().hasNext();
    }
}
