package com.leetcode.study.codecaprice.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Cody.Teng
 * @date : 2023-07-26 11:42 p.m.
 */
public class RecursionLoop {


    public static List<Integer> preorderTraversal_LC144(TreeNode root) {
        List<Integer> values = new ArrayList<>();

        preTraversal(root, values);

        return values;
    }

    private static void preTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preTraversal(root.left,result);
        preTraversal(root.right, result);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        midTraversal(root, result);
        return result;
    }


    private static void midTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        midTraversal(root.left,result);
        result.add(root.val);
        midTraversal(root.right, result);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postTraversal(root, result);
        return result;
    }


    private static void postTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postTraversal(root.left,result);
        postTraversal(root.right, result);
        result.add(root.val);
    }

}
