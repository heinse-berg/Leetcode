package com.playground;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TryOut {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public void validMountainArray(int[] arr) {
        int i, j, len = arr.length;
        for (i = 1; i < 10; i++) {
            if(i == 5)
                break;
        }
        System.out.println(i);
    }



    public static void main(String[] args) {
        TryOut abc = new TryOut();
        /*List<Integer> list = IntStream.of(new int[60]).boxed().collect(Collectors.toList());
        list.add(4, 1);
        System.out.println(list);
        abc.removeElement(new int[] {6,4,8,9,10,4,9,8}, 8);
        abc.validMountainArray(new int[] {});
        String a = "abcd";
        StringBuilder s = new StringBuilder(a);

        s.append("a");
        String.valueOf(0);
        a.lastIndexOf("a");
        LinkedList<Integer> l = new LinkedList<>();
        l.removeLast();*/
        int a = (int) Math.floor(Math.log(20) / Math.log(2));
        int b = (int) Math.floor(Math.log(28) / Math.log(2));
        int c = (int) Math.floor(Math.log(10) / Math.log(2));
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
