package com.leetcode.study.labuladong.array.doublepointer;

/**
 * @author : Cody.Teng
 * @date : 2023-07-13 7:14 p.m.
 */
public class ArrayTwoSum_LC167 {

    public int[] twoSum(int[] nums, int target) {

        if (nums == null) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            }else {
                right++;
            }
        }
        return new int[]{-1, -1};
    }

}
