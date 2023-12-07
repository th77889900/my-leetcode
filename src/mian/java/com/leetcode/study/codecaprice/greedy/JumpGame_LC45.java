package com.leetcode.study.codecaprice.greedy;

/**
 * @author : Cody.Teng
 * @date : 2023-08-08 7:59 p.m.
 */
public class JumpGame_LC45 {

    public static void main(String[] args) {
        JumpGame_LC45 jumpGame = new JumpGame_LC45();
        int i = jumpGame.canJump(new int[]{2, 3, 1, 1, 4});
        System.out.println(i);
    }
    public int canJump(int[] nums) {

        int length = nums.length;
        if (length == 1) {
            return 0;
        }

        int cover = 0;
        int maxCover = 0;
        int result = 0;
        for (int i = 0; i < length; i++) {
            maxCover = Math.max(i + nums[i], maxCover);
            if (maxCover >= length - 1) {
                result++;
                break;
            }

            if (i == cover) {
                cover = maxCover;
                result++;
            }
        }
        return result;
    }
}
