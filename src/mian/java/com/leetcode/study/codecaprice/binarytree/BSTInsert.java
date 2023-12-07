package com.leetcode.study.codecaprice.binarytree;

/**
 * @author : Cody.Teng
 * @date : 2023-08-02 10:38 p.m.
 */
public class BSTInsert {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) {
            return new TreeNode(val);
        }

        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }

        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right == null) {
                return root.left;
            } else if (root.left == null) {
                return root.right;
            }else {
                TreeNode node = root.right;
                while (node.left != null) {
                    node = node.left;
                }
                node.left = root.left;
                return root.right;
            }
        }
        root.left = deleteNode(root.left, key);
        root.right = deleteNode(root.right, key);

        return root;
    }

    public TreeNode trimBST_LC669(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.val < low) {
            return trimBST_LC669(root.right, low, high);
        }

        if (root.val > high) {
            return trimBST_LC669(root.left, low, high);
        }

        root.left = trimBST_LC669(root.left, low, high);
        root.right = trimBST_LC669(root.right, low, high);

        return root;
    }
}
