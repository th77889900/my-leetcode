package com.leetcode.study.codecaprice.binarytree;

/**
 * @author : Cody.Teng
 * @date : 2023-08-02 3:18 p.m.
 */
public class PathSum_LC112 {

    public boolean hasPathSum(TreeNode root,int target) {

        return sum(root, 0, target);

    }

    public boolean sum(TreeNode node, int sum, int target) {
        if (node == null) {
            return false;
        }
        sum += node.val;
        if (node.left == null && node.right == null) {
            if (target == sum) {
                return true;
            }
        }
        boolean booLeft = false;
        if (node.left != null) {
            booLeft = sum(node.left, sum, target);
        }
        boolean booRight = false;
        if (node.right != null) {
            booRight = sum(node.right, sum, target);
        }
        return booLeft || booRight;
    }

}
