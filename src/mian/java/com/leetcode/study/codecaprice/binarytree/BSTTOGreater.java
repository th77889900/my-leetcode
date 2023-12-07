package com.leetcode.study.codecaprice.binarytree;

/**
 * @author : Cody.Teng
 * @date : 2023-08-03 12:12 a.m.
 */
public class BSTTOGreater {

    int pre = 0;
    int cur = 0;
    public TreeNode convertBST(TreeNode root) {

        convert(root);

        return root;
    }

    private void convert(TreeNode root) {

        if (root == null) {
            return;
        }

        convert(root.right);

        cur = root.val + pre;
        pre = cur;

        root.val = cur;

        convert(root.left);


    }

}
