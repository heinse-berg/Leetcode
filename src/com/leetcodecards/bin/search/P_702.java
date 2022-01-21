package com.leetcodecards.bin.search;

class ArrayReader {
    public int get(int index) {
        return index <= 9999 && index >= 0 ? index : 2147483647;
    }
}

public class P_702 {

    public int search(ArrayReader reader, int target) {
        int high = 10000, lo = 1, mid, num, max = 2147483647, numMid = 1, numPlusOne = 1;
        boolean flag = false;
        while(lo <= high) {
            mid = lo + (high-lo)/2;
            numMid = reader.get(mid);
            numPlusOne = reader.get(mid+1);
            if(numPlusOne == max && numMid != max) {
                flag = true;
                numMid++;
                break;
            }
            else if(numMid == max)
                high = mid-1;
            else
                lo = mid+1;
        }

        lo = 0; high = numMid-1;
        while(lo <= high) {
            mid = lo + (high-lo)/2;
            if(reader.get(mid) == target)
                return mid;
            else if(reader.get(mid) < target)
                lo = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        P_702 abc = new P_702();
        System.out.println(abc.search(new ArrayReader(), 9999));
    }
}
