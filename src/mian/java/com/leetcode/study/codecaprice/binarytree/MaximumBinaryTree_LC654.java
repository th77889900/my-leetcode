package com.leetcode.study.codecaprice.binarytree;

/**
 * @author : Cody.Teng
 * @date : 2023-08-02 5:55 p.m.
 */
public class MaximumBinaryTree_LC654 {

    public static void main(String[] args) {
        int[] ints = {3, 2, 1, 6, 0, 5};
        MaximumBinaryTree_LC654 tree = new MaximumBinaryTree_LC654();
        TreeNode node = tree.constructMaximumBinaryTree(ints);
        System.out.println();
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }

        return constructMaxTree(nums, 0, nums.length);

    }

    public TreeNode constructMaxTree(int[] nums, int start, int end) {

        if (end - start == 1) {
            return new TreeNode(nums[start]);
        }

        int maxValue = -1;
        int index = -1;

        for (int i = start; i < end; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(maxValue);

        if (index - start > 0) {
            TreeNode left = constructMaxTree(nums, start, index);
            root.left = left;
        }

        if (end - 1 - index > 0) {
            TreeNode right = constructMaxTree(nums, index + 1, end);
            root.right = right;
        }
        return root;
    }


}
