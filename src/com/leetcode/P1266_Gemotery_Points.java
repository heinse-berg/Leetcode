package com.leetcode;

//https://leetcode.com/problems/minimum-time-visiting-all-points/

public class P1266_Gemotery_Points {
    public int minTimeToVisitAllPoints(int[][] points) {
        int i, dist = 0;
        for(i = 0; i < points.length - 1; i++) {
            int xDist = (points[i][0] - points[i+1][0]);
            int yDist = (points[i][1] - points[i+1][1]);
            if(Math.abs(xDist) == Math.abs(yDist)) {
                dist += xDist;
            } else{
                if(Math.abs(xDist) < Math.abs(yDist)) {
                    dist += Math.abs(xDist) + Math.abs(points[i+1][1] - (points[i][1] - xDist));
                }
                else {
                    dist += Math.abs(yDist) + Math.abs(points[i+1][0] - (points[i][0] - yDist));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1},{3,4},{-1,0}};
        System.out.println(new P1266_Gemotery_Points().minTimeToVisitAllPoints(arr));
    }
}
