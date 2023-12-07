package com.leetcode.study.codecaprice.binarytree;

import java.util.*;

/**
 * binary no recursion traversal
 * @author : Cody.Teng
 * @date : 2023-07-27 10:20 a.m.
 */
public class IterateTraversal {

    public static List<Integer> preorderIterate_LC144(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }

        return result;
    }
    public static List<Integer> postOrderIterate_LC145(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }

        Collections.reverse(result);

        return result;
    }

    public static List<Integer> midOrderIterate_LC94(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();

        while (cur != null || !stack.isEmpty()) {

            if (cur != null) {
                stack.add(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }

    public static List<Integer> preUnitIterate(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) {
                    stack.add(node.right);
                }
                if (node.left != null) {
                    stack.add(node.left);
                }

                stack.add(node);
                stack.add(null);

            } else {
                node = stack.pop();
                result.add(node.val);
            }
        }

        return result;
    }
    public static List<Integer> midUnitIterate(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {

                if (node.right != null) {
                    stack.add(node.right);
                }

                stack.add(node);
                stack.add(null);

                if (node.left != null) {
                    stack.add(node.left);
                }
            } else {
                node = stack.pop();
                result.add(node.val);
            }
        }

        return result;
    }
    public static List<Integer> postUnitIterate(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                stack.add(node);
                stack.add(null);
                if (node.right != null) {
                    stack.add(node.right);
                }
                if (node.left != null) {
                    stack.add(node.left);
                }
            } else {
                node = stack.pop();
                result.add(node.val);
            }
        }

        return result;
    }

}
