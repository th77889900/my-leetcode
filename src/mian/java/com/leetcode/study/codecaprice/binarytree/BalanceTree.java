package com.leetcode.study.codecaprice.binarytree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author : Cody.Teng
 * @date : 2023-07-31 11:17 a.m.
 */
public class BalanceTree {

    public static boolean isBalanceTree_LC110(TreeNode root) {
        int result = checkBalance(root);

        if (result == -1) {
            return false;
        }
        return true;

    }

    private static int checkBalance(TreeNode root) {

        if (root==null) return 0;

        int deepLeft = checkBalance(root.left);
        if (deepLeft == -1) return -1;
        int deepRight = checkBalance(root.right);
        if (deepRight == -1) return -1;

        if (Math.abs(deepLeft - deepRight) > 1) {
            return -1;
        }else {
            return Math.max(deepLeft, deepRight) + 1;
        }
    }

    private static boolean checkByIterate(TreeNode root) {

        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        Map<TreeNode, Integer> nodeDeep = new HashMap<>();

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                stack.push(node);
                stack.push(null);
                if (node.right != null && !nodeDeep.containsKey(node.right)) {
                    stack.push(node.right);
                }
                if (node.left != null && !nodeDeep.containsKey(node.left)) {
                    stack.push(node.left);
                }
            }else {
                node = stack.pop();

                Integer deepRight = nodeDeep.getOrDefault(node.right, 0);
                Integer deepLeft = nodeDeep.getOrDefault(node.left, 0);

                int deepDiff = Math.abs(deepRight - deepLeft);

                if (deepDiff > 1) {
                    return false;
                }

                nodeDeep.put(node, Math.max(deepLeft, deepRight) + 1);
            }
        }

        return true;
    }
}
