package com.leetcode.study.codecaprice.binarytree;

import java.util.Stack;

/**
 * @author : Cody.Teng
 * @date : 2023-07-29 9:10 a.m.
 */
public class DeepTree {

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

        DeepTree deepTree = new DeepTree();

        int i = deepTree.maxDeepIterate_LC104(root);


        System.out.println(i);
    }

    public int maxDeep_LC104(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int deepLeft = maxDeep_LC104(root.left);
        int deepRight = maxDeep_LC104(root.right);

        return 1 + Math.max(deepLeft, deepRight);
    }

    public int maxDeepIterate_LC104(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> deepStack = new Stack<>();
        stack.add(root);
        deepStack.add(1);
        int maxDeep = 0;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                stack.add(node);
                stack.add(null);
                Integer level = deepStack.pop();
                maxDeep = maxDeep > level ? maxDeep : level;
                if (node.right != null) {
                    stack.add(node.right);
                    deepStack.add(level + 1);
                }
                if (node.left != null) {
                    stack.add(node.left);
                    deepStack.add(level + 1);
                }

            } else {
                stack.pop();
            }
        }

        return maxDeep;

    }

//    public static void main(String[] args) {
//        TreeNode root = new TreeNode(2);
//        TreeNode node1 = new TreeNode(3);
//        TreeNode node2 = new TreeNode(4);
//        TreeNode node3 = new TreeNode(5);
//        TreeNode node4 = new TreeNode(6);
//
//        root.right = node1;
//        node1.right = node2;
//        node2.right = node3;
//        node3.right = node4;
//
//        DeepTree tree = new DeepTree();
//        int minDeepLc111 = tree.getMinDeep_LC111(root);
//        System.out.println(minDeepLc111);
//    }

    public int getMinDeep_LC111(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int deepLeft = getMinDeep_LC111(root.left);
        int deepRight = getMinDeep_LC111(root.right);

        if (deepLeft == 0 && deepRight == 0) {
            return 1;
        } else if (deepLeft != 0 && deepRight != 0) {
            return 1 + Math.min(deepLeft, deepRight);
        }else {
            return 1 + Math.max(deepLeft, deepRight);
        }
    }

}
