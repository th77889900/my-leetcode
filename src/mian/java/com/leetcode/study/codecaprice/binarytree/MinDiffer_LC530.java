package com.leetcode.study.codecaprice.binarytree;

/**
 * @author : Cody.Teng
 * @date : 2023-08-02 9:05 p.m.
 */
public class MinDiffer_LC530 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        MinDiffer_LC530 minDiffer = new MinDiffer_LC530();

        int minimumDifference = minDiffer.getMinimumDifference(root);
        System.out.println(minimumDifference);

    }


        private TreeNode pre;
    private int minDiffer = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        trans(root);
        return minDiffer;
    }


    private void trans(TreeNode root){
        if (root == null) {
            return ;
        }

        trans(root.left);

        if (pre != null) {
            minDiffer = Math.min(Math.abs(root.val - pre.val), minDiffer);
        }
        pre = root;

        trans(root.right);

    }

}

