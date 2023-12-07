package com.leetcode.study.codecaprice.greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author : Cody.Teng
 * @date : 2023-08-09 11:06 a.m.
 */
public class largestSumAfterKNegations_LC1005 {

    public static void main(String[] args) {
        largestSumAfterKNegations_LC1005 largest = new largestSumAfterKNegations_LC1005();
        int sum = largest.largestSumAfterKNegations(new int[]{5,6,9,-3,3}, 2);
        System.out.println(sum);

    }
    public int largestSumAfterKNegations(int[] nums, int k) {

        Arrays.sort(nums);
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = Math.abs(nums[i]);
                k--;
            }
        }
        if (k == 0) {
            return IntStream.of(nums).sum();
        }
        Arrays.sort(nums);
        if (k % 2 == 1) {
            sum = IntStream.of(nums).sum();
            sum -= 2 * nums[0];
            return sum;
        }
        return IntStream.of(nums).sum();
    }
}
