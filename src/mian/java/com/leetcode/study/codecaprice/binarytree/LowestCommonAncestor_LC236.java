package com.leetcode.study.codecaprice.binarytree;

/**
 * @author : Cody.Teng
 * @date : 2023-08-02 10:11 p.m.
 */
public class LowestCommonAncestor_LC236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;

        if (root == p || root == q) {
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        if (leftNode != null && rightNode != null) {
            return root;
        } else if (leftNode == null && rightNode != null) {
            return rightNode;
        } else if (leftNode != null) {
            return leftNode;
        }else {
            return null;
        }
    }
    public TreeNode lowestCommonAncestorOfBST(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;

        if (root.val > p.val && root.val > q.val) {
            TreeNode left = lowestCommonAncestorOfBST(root.left, p, q);
            if (left != null) {
                return left;
            }
        }

        if (root.val < p.val && root.val < q.val) {
            TreeNode right = lowestCommonAncestorOfBST(root.right, p, q);
            if (right != null) {
                return right;
            }
        }

        return root;

    }
}
