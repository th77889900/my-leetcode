package com.leetcode.study.codecaprice.binarytree;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author : Cody.Teng
 * @date : 2023-08-02 10:20 a.m.
 */
public class SumLeft {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
//        TreeNode node3 = new TreeNode(4);
//        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(15);
        TreeNode node6 = new TreeNode(7);

        root.left = node1;
        root.right = node2;
//        node1.left = node3;
//        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        int i = getSumLeftIterate(root);
        System.out.println(i);

    }

    public static int sumLeftLeave(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int i = sumLeftRecur(root, 0, "root");
        System.out.println(i);
        return 0;
    }

    public static int sumLeftRecur(TreeNode node, int result, String tag) {

        if (node == null) {
            return result;
        }
        if (node.left == null && node.right == null && tag.equals("left")) {
            return result + node.val;
        }

        result = sumLeftRecur(node.left, result, "left");

        result = sumLeftRecur(node.right, result, "right");

        return result;
    }

    public static int getSumLeftIterate(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        HashMap<TreeNode, Integer> map = new HashMap<>();
        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                stack.push(node);
                stack.push(null);
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            } else {
                node = stack.pop();
                if (node.left == null & node.right == null) {
                    map.put(node, node.val);
                } else if (node.left != null) {
                    sum += map.getOrDefault(node.left, 0);
                }
            }
        }
        return sum;
    }

}
