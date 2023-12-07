package com.leetcode.study.codecaprice.linklist.dualpointers;

import com.leetcode.study.codecaprice.linklist.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Merge number K sorted list
 * @author : Cody
 * @date : 2023-06-11 2:52 p.m.
 */
public class MergeKOrderList_LC23 {

    /*
    Implemented using a min-heap
     */
    public ListNode mergeKList(ListNode[] nodes) {

        if (nodes == null || nodes.length == 0) {
            return null;
        }

        ListNode tempNode = new ListNode(-1);
        ListNode p = tempNode;

        PriorityQueue<ListNode> priorityQueue =
                new PriorityQueue<>(nodes.length, Comparator.comparingInt(a -> a.val));

        for (ListNode head : nodes) {
            if (head != null) {
                priorityQueue.add(head);
            }
        }

        while (!priorityQueue.isEmpty()) {
            ListNode node = priorityQueue.poll();
            p.next = node;
            if (node.next != null) {
                priorityQueue.add(node.next);
            }
            p = p.next;
        }
        return tempNode.next;
    }

}
