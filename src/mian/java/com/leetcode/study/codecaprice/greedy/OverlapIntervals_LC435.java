package com.leetcode.study.codecaprice.greedy;

import java.util.Arrays;

/**
 * @author : Cody.Teng
 * @date : 2023-08-10 10:50 a.m.
 */
public class OverlapIntervals_LC435 {

    public static void main(String[] args) {
        int i = eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}});
        System.out.println(i);

    }

    public static int eraseOverlapIntervals(int[][] intervals) {

        int result = 0;
        if (intervals.length <= 1) {
            return result;
        }

        Arrays.sort(intervals, (int[] a, int[] b) -> {
            if (a[1] == b[1]) return a[0] - b[0];
            long i = (long) a[1] - (long) b[1];
            if (i > 0) {
                return 1;
            } else if (i < 0) {
                return -1;
            } else {
                return 0;
            }
        });

        int rightBorder = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (rightBorder > intervals[i][0]) {
                result++;
            }else {
                rightBorder = intervals[i][1];
            }
        }
        return result;
    }
}
