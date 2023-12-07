package com.leetcode.study.codecaprice.binarytree;

/**
 * @author : Cody.Teng
 * @date : 2023-08-02 11:59 p.m.
 */
public class SortedArrayToBST_LC108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedToBST(nums, left, mid - 1);
        root.right = sortedToBST(nums, mid + 1, right);

        return root;
    }

}
