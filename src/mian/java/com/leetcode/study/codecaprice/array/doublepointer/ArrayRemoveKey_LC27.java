package com.leetcode.study.codecaprice.array.doublepointer;

/**
 * remove selected key
 *
 * @author : Cody.Teng
 * @date : 2023-07-13 6:44 p.m.
 */
public class ArrayRemoveKey_LC27 {

    public int removeElement_LC27(int[] nums, int key) {
        int fast, slow;
        fast = slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != key) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    /**
     * move the value equals zero to the end of array
     * @param nums
     */
    public void moveZeros(int[] nums) {

        if (nums == null || nums.length == 1) {
            return;
        }

        int cur = removeElement_LC27(nums, 0);
        cur++;
        while (cur < nums.length) {
            nums[cur] = 0;
            cur++;
        }
    }


}
