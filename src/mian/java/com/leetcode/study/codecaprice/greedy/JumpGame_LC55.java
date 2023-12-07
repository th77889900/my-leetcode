package com.leetcode.study.codecaprice.greedy;

import java.util.zip.Inflater;

/**
 * @author : Cody.Teng
 * @date : 2023-08-08 7:59 p.m.
 */
public class JumpGame_LC55 {

    public static void main(String[] args) {

        System.out.println("what is your name: " + "zhang san");


    }

    public boolean canJump(int[] nums) {

        int length = nums.length;

        if (length == 1) {
            return true;
        }

        int cover = 0;

        for (int i = 0; i <= cover; i++) {

            cover = Math.max(nums[i] + i, cover);
            if (cover >= length - 1) {
                return true;
            }
        }

        return false;
    }
}
