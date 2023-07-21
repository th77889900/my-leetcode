package com.leetcode.study.labuladong.array.prefixsum;

import java.util.function.Predicate;

/**
 * Prefix sum method
 *
 * @author : Cody.Teng
 * @date : 2023-07-14 1:36 p.m.
 */
public class NumArray_LC303 {

    private int[] prefixSum;

    public NumArray_LC303(int[] nums) {
        if (nums == null || nums.length <= 1) {
            prefixSum = nums;
            return;
        }

        prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {

        return prefixSum[right + 1] - prefixSum[left];
    }

}
