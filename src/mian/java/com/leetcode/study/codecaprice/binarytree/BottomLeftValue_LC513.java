package com.leetcode.study.codecaprice.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author : Cody.Teng
 * @date : 2023-08-02 2:40 p.m.
 */
public class BottomLeftValue_LC513 {

    public static void main(String[] args) {
        System.out.println("what is your name");
        List<Integer> intArray = new ArrayList<>();

        Dog dog = new Dog();

    }

    private int maxDepth = Integer.MIN_VALUE;
    private int result;
    public void findBottomLeftValue(TreeNode node, int depth) {

        if (node.left == null && node.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                result = node.val;
            }
            return;
        }

        if (node.left != null) {
            depth++;
            findBottomLeftValue(node.left, depth);
            depth--;
        }
        if (node.right != null) {
            depth++;
            findBottomLeftValue(node.right, depth);
        }
    }

    public int findByIterate(TreeNode root) {

        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);
        int depth = 0;
        int maxDepth = Integer.MIN_VALUE;
        int result = root.val;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    if (depth > maxDepth) {
                        maxDepth = depth;
                        result = node.left.val;
                    }
                }
                if (node.right != null) {
                    queue.add(node.right);
                    if (depth > maxDepth) {
                        maxDepth = depth;
                        result = node.right.val;
                    }
                }
            }
        }

        return result;
    }

}
