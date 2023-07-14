package com.leetcode.study.labuladong.array.prefixsum;

import java.util.function.Predicate;

/**
 * Prefix sum method
 *
 * @author : Cody.Teng
 * @date : 2023-07-14 1:36 p.m.
 */
public class NumArray {

    private int[] prefixSum;

    public NumArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            prefixSum = nums;
            return;
        }

        prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;

        for (int i = 0; i < nums.length; i++) {

        }

    }
}
