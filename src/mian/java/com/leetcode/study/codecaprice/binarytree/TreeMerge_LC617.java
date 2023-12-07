package com.leetcode.study.codecaprice.binarytree;

/**
 * @author : Cody.Teng
 * @date : 2023-08-02 6:38 p.m.
 */
public class TreeMerge_LC617 {

    public TreeNode mergeTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        int value;
        if (root1 == null ) {
            value = root2.val;
        } else if (root2 == null) {
            value = root1.val;
        }else {
            value = root1.val + root2.val;
        }
        TreeNode root = new TreeNode(value);

        root.left = mergeTree(root1==null?null:root1.left, root2==null?null:root2.left);

        root.right = mergeTree(root1==null?null:root1.right, root2==null?null:root2.right);

        return root;
    }

}
