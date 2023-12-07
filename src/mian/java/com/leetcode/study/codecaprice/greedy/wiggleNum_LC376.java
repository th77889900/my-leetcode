package com.leetcode.study.codecaprice.greedy;

/**
 * @author : Cody.Teng
 * @date : 2023-08-06 11:49 p.m.
 */
public class wiggleNum_LC376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int preDiff = 0;
        int curDiff;

        int result = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            curDiff = nums[i] - nums[i + 1];
            if ((preDiff >= 0 && curDiff < 0) || (preDiff <= 0 && curDiff > 0)) {
                result++;
                preDiff = curDiff;
            }
        }
        return result;
    }

}
