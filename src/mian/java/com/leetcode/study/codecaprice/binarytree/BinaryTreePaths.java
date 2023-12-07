package com.leetcode.study.codecaprice.binarytree;

import java.util.*;

/**
 * @author : Cody.Teng
 * @date : 2023-07-31 12:33 p.m.
 */
public class BinaryTreePaths {

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

        List<String> treePaths = getTreePathsRe(root);
        for (String treePath : treePaths) {
            System.out.println(treePath);
        }

    }

    public static List<String> getTreePathsRe(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        pathsRecursion(root, "", result);

        return result;
    }

    public static void pathsRecursion(TreeNode root, String path, List<String> result) {

        if (root.left == null && root.right == null) {
            path = path + root.val;
            result.add(path);
            return;
        }

        path = path + root.val + "->";

        if (root.left != null) {
            pathsRecursion(root.left, path, result);
        }
        if (root.right != null) {
            pathsRecursion(root.right, path, result);
        }
    }

    public static List<String> getTreePaths(TreeNode root) {

        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }



        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        Map<TreeNode, String> map = new HashMap<>();
        map.put(root, String.valueOf(root.val));

        String mark = "->";

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) {
                    stack.push(node.right);
                    String rp = map.getOrDefault(node, "");
                    map.put(node.right, rp.equals("") ? rp : rp + mark + node.right.val);
                }
                if (node.left != null) {
                    stack.push(node.left);
                    String lp = map.getOrDefault(node, "");
                    map.put(node.left, lp.equals("") ? lp : lp + mark + node.left.val);
                }
                stack.push(node);
                stack.push(null);
            } else {
                node = stack.pop();
                if (node.left == null && node.right == null) {
                    String path = map.get(node);
                    paths.add(path);
                }
            }
        }
        return paths;
    }

}
