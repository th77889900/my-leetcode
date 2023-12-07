package com.leetcode.study.codecaprice.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Cody.Teng
 * @date : 2023-08-10 11:50 a.m.
 */
public class DupliCollMerge_LC56 {

    public static void main(String[] args) {
        int[][] merge = merge(new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}});

        System.out.println();
    }

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (int[] a, int[] b)->{
            if (a[0]==b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int rightBorder = intervals[0][1];
        int leftBorder = intervals[0][0];
        List<int[]> result = new ArrayList<>();
        boolean update = false;
        for (int i = 0; i < intervals.length; i++) {
            if (rightBorder >= intervals[i][0]) {
                rightBorder = Math.max(rightBorder, intervals[i][1]);
                leftBorder = Math.min(leftBorder, intervals[i][0]);
                update = true;
            } else {
                result.add(new int[]{leftBorder, rightBorder});
                leftBorder = intervals[i][0];
                rightBorder = Math.max(rightBorder, intervals[i][1]);
                update = true;
            }
        }
        if (update) {
            result.add(new int[]{leftBorder, rightBorder});
        }

        return result.toArray(new int[result.size()][]);
    }

}
