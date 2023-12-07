package com.leetcode.study.codecaprice.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * level loop
 *
 * @author : Cody.Teng
 * @date : 2023-07-27 3:34 p.m.
 */
public class LevelTraversal {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode nodeR = new TreeNode(5);
        TreeNode nodeL = new TreeNode(6);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(9);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        node3.left = nodeR;
        nodeR.left = nodeL;
        nodeL.left = node4;
        node4.left = node5;
        node5.left = node6;
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(node);
        levelOrder(node);

//        List<List<Integer>> lists = levelTraversal(node);
//
//        for (List<Integer> list : lists) {
//            for (Integer integer : list) {
//                System.out.println(integer);
//            }
//        }

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        int deep = 0;
        preLoop(root, result, deep);

        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
        return result;
    }

    public static void preLoop(TreeNode node, List<List<Integer>> result, int deep) {
        if (node==null) return;
        deep++;

        if (result.size() < deep) {
            List<Integer> item = new ArrayList<>();
            result.add(item);
        }
        result.get(deep - 1).add(node.val);

        preLoop(node.left, result, deep);
        preLoop(node.right, result, deep);
    }

    public static List<List<Integer>> levelTraversal(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> coll = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                coll.add(node.val);
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
            result.add(coll);
        }

        return result;
    }


}
