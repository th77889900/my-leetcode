package com.leetcode.study.codecaprice.binarytree;

/**
 * @author : Cody.Teng
 * @date : 2023-08-02 6:53 p.m.
 */
public class BSTSearch_LC700 {

    public TreeNode searchBST(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        if (root.val == target) {
            return root;
        }

        TreeNode left = searchBST(root.left, target);
        if (left != null) {
            return left;
        }
        TreeNode right = searchBST(root.right, target);
        if (right != null) {
            return right;
        }
        return null;
    }

}
