package com.leetcode.study.labuladong.array.doublepointer;

/**
 * remove duplicates in array
 * use slow and fast pointer
 * @author : Cody.Teng
 * @date : 2023-07-08 4:34 p.m.
 */
public class ArrayDuplicates_LC26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int fast = 0, slow = 0;

        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }

        return slow + 1;
    }
}
