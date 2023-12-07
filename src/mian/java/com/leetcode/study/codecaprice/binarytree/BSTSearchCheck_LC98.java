package com.leetcode.study.codecaprice.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Cody.Teng
 * @date : 2023-08-02 7:00 p.m.
 */
public class BSTSearchCheck_LC98 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(-1);

        BSTSearchCheck_LC98 tree = new BSTSearchCheck_LC98();
        boolean validBST = tree.isValidBST(node);
        System.out.println(validBST);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }

        List<Integer> result = new ArrayList<>();
        check(root, result);

        for (int i = 1; i < result.size(); i++) {
            if (result.get(i - 1) > result.get(i)) {
                return false;
            }
        }
        return true;

    }

    /**
     * in order get a list if the list is in order .that is a search tree if not it is not a search tree
     */
    private void check(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        check(root.left, result);
        result.add(root.val);
        check(root.right, result);
    }

    private TreeNode pre;
    private boolean checkByMin(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leftBoo = checkByMin(root.left);

        if (pre != null && pre.val >= root.val) {
            return false;
        }else {
            pre = root;
        }

        boolean rightBoo = checkByMin(root.right);

        return leftBoo && rightBoo;
    }

}
