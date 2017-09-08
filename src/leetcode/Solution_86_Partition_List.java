package leetcode;

import jianzhi.util.ListNode;

/**
 * 86. Partition List
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * https://leetcode.com/problems/partition-list/description/
 * Created by liec on 2017-09-07.
 */
public class Solution_86_Partition_List {
    public ListNode partition(ListNode head, int x) {
        ListNode p1 = new ListNode(0), p2 = new ListNode(0);
        ListNode ls = p1, gt = p2;
        for (; head != null; head = head.next) {
            if (head.val >= x) {
                p2.next = head;
                p2 = p2.next;
            } else {
                p1.next = head;
                p1 = p1.next;
            }
        }
        p2.next = null;
        p1.next = gt.next;
        return ls.next;
    }
}
