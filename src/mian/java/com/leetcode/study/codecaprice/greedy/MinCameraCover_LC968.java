package com.leetcode.study.codecaprice.greedy;

import com.leetcode.study.codecaprice.binarytree.TreeNode;

/**
 * @author : Cody.Teng
 * @date : 2023-08-10 4:39 p.m.
 */
public class MinCameraCover_LC968 {

    private int result = 0;
    public int minCameraCover(TreeNode root) {
        // define state 0 none cover 1 came 2 cover
        if (cur(root) == 0) {
            return ++result;
        }
        return result;
    }

    private int cur(TreeNode root) {

        if (root == null) {
            return 2;
        }

        int stateLeft = cur(root.left);

        int stateRight = cur(root.right);

        if (stateRight == 2 && stateLeft == 2) {
            return 0;
        } else if (stateLeft == 0 || stateRight == 0) {
            result++;
            return 1;
        } else {
            return 2;
        }
    }
}
