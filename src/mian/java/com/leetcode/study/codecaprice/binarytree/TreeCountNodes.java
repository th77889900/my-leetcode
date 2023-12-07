package com.leetcode.study.codecaprice.binarytree;

import java.util.Stack;

/**
 * @author : Cody.Teng
 * @date : 2023-07-29 12:45 p.m.
 */
public class TreeCountNodes {

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
//        node2.right = node6;

        int nodesByIterate = getNodesByIterate(root);

        System.out.println(nodesByIterate);

    }

    public static int countNodes_LC22(TreeNode root) {
        if (root==null) return 0;

        int deepLeft = 0;
        int deepRight = 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (left != null) {
            left = left.left;
            deepLeft++;
        }

        while (right != null) {
            right = right.right;
            deepRight++;
        }

        if (deepLeft == deepRight) {
            return (2 << deepLeft) - 1;
        }

        int leftCount = countNodes_LC22(root.left);
        int rightCount = countNodes_LC22(root.right);

        return leftCount + rightCount + 1;

    }

    /**
     * 使用迭代法完成遍历
     */
    public static int getNodesByIterate(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        int nodeCount = 0;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                int numByNode = getNumByNode(node);
                if (numByNode > 0) {
                    nodeCount += numByNode;
                    continue;
                }
                stack.add(node);
                stack.add(null);
                if (node.right != null) stack.add(node.right);
                if (node.left != null) stack.add(node.left);
            } else {
                stack.pop();
                nodeCount++;
            }
        }

        return nodeCount;
    }

    private static int getNumByNode(TreeNode node) {
        int deepLeft = 0;
        int deepRight = 0;
        TreeNode left = node.left;
        TreeNode right = node.right;
        while (left != null) {
            left = left.left;
            deepLeft++;
        }

        while (right != null) {
            right = right.right;
            deepRight++;
        }

        if (deepLeft == deepRight) {
            return (2 << deepLeft) - 1;
        }
        return 0;
    }

}
