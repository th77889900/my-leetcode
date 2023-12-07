package com.leetcode.study.codecaprice.greedy;

import java.util.Arrays;

/**
 * @author : Cody.Teng
 * @date : 2023-08-10 9:18 a.m.
 */
public class MinArrowShots_LC452 {

    public static void main(String[] args) {
        int minArrowShots = findMinArrowShots(
                new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}});
        System.out.println(minArrowShots);
    }

    public static int findMinArrowShots(int[][] points) {

        int result = 1;
        if (points.length <= 1) {
            return points.length;
        }

        Arrays.sort(points, (int[] a,int[] b)-> {
            if (a[1]==b[1]) return a[0] - b[0];
            long i = (long) a[1] - (long) b[1];
            if (i>0) {
                return 1;
            } else if (i < 0) {
                return -1;
            }else {
                return 0;
            }
        });

        int rightBorder = points[0][1];
        for (int i = 0; i < points.length; i++) {
            if (rightBorder < points[i][0]) {
                result++;
                rightBorder = points[i][1];
            }
        }
        return result;
    }
}
