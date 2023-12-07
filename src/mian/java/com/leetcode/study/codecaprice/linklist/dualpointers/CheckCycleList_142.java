package com.leetcode.study.codecaprice.linklist.dualpointers;

import com.leetcode.study.codecaprice.linklist.ListNode;

/**
 * <p>
 *  * 1。我们设链表的起点到环的起点的距离为L，环的长度为R，慢指针从环的起点到相遇点的距离为X。
 *  * 此时，快指针在环上比慢指针多走了N圈，所以我们有两者走过的路程的关系：2*(L+X) = L+ N*R + X。
 *  * 整理上面的等式，我们可以得到：L = N*R - X。
 *  * 2。也就是说从链表起点到环的起点的距离等于N圈环的长度减去慢指针从环的起点到相遇点的距离。
 *  * 当N为1时，即快指针比慢指针多走一圈的情况，我们可以得到：L = R - X。
 *  * N为1方面理解 如果N不是1 也没有问题，N不是1只是说明在环内转了 N圈 最有的一段N-X才是决定性的因素
 *  * <p>
 *  * 3。这就意味着，如果我们让一个指针从链表的起点开始走，
 *  * 走L步到达环的起点，同时另一个指针从相遇点开始走，走(R-X)步也会到达环的起点。因为(R-X)步实际上就是让指针绕环走一圈后再回到环的起点。
 *  * <p>
 *  * 所以，当两个指针以相同的速度移动时，一个从链表起点开始，另一个从相遇点开始，那么它们会在环的起点相遇，这就是这个算法原理的推导过程。
 *
 * @author : Cody.Teng
 * @date : 2023-07-07 11:07 p.m.
 */
public class CheckCycleList_142 {

    /**
     * 判断是否有环
     * @param head
     * @return
     */
    public Boolean checkCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public ListNode getIntersectionPoint(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        fast = head;

        while (fast != slow) {
            if (fast == null || slow == null) {
                throw new RuntimeException("get intersection exception ");
            }
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

}
