package com.leetcode.study.codecaprice.binarytree;

/**
 * @author : Cody.Teng
 * @date : 2023-07-28 12:25 a.m.
 */
public class InvertTree {

    public TreeNode invertTree_LC226(TreeNode root) {
        if (root==null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree_LC226(root.left);
        invertTree_LC226(root.right);

        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);

        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node2.right = node4;

        InvertTree invertTree = new InvertTree();
        boolean symmetric = invertTree.isSymmetric(root);


    }
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return checkMirror(root.left, root.right);
    }

    private boolean checkMirror(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }

        // post order traversal
        boolean outside = checkMirror(left.left, right.right);
        boolean inside = checkMirror(left.right, right.left);
        return outside && inside;
    }

}
