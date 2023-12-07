package com.leetcode.study.codecaprice.greedy;

/**
 * @author : Cody.Teng
 * @date : 2023-08-09 3:17 p.m.
 */
public class CompleteCircle_LC145 {

    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                index = (i + 1);
                curSum = 0;
            }
        }
        if (totalSum < 0) {
            return -1;
        }

        return index;
    }
}
