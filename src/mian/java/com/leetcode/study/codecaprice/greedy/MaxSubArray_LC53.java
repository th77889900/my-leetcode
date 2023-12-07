package com.leetcode.study.codecaprice.greedy;

/**
 * @author : Cody.Teng
 * @date : 2023-08-08 5:38 p.m.
 */
public class MaxSubArray_LC53 {

    public static void main(String[] args) {
        int i = maxSubArray(new int[]{-1, 0});

        System.out.println(i);
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }
        int result = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (result <= 0 && num < 0) {
                if (result > num) {
                    continue;
                } else {
                    result = num;
                }
            } else if (result <= 0 && num >= 0) {
                result = num;
            } else if (result > 0) {
                result += num;
            }
            max = Math.max(result, max);
        }

        return max;
    }

}
