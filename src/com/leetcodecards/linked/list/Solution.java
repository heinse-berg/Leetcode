package com.leetcodecards.linked.list;

import com.leetcodecards.recursion1.ListNode;

import java.util.*;

class Solution extends ArrayList<Integer>{

    public ListNode removeZeroSumSublists(ListNode head) {
        Solution list = new Solution();
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        ListNode curr = head;
        int sum = 0;

        while(curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }

        for(int i = 0; i < list.size(); ) {
            sum += list.get(i);
            if(map.containsKey(sum)) {
                int index = map.get(sum)+1;
                list.removeRange(index, i+1);
                i = index;
            }
            else
                map.put(sum, i++);
        }

        ListNode ans = new ListNode(), dummy = ans;
        for(int num : list) {
            ans.next = new ListNode(num);
            ans = ans.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Solution abc = new Solution();
        System.out.println();
    }
}
