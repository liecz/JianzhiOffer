package leetcode;

import jianzhi.util.ListNode;

/**
 * 61. Rotate List
 * https://leetcode.com/problems/rotate-list/#/description
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * Created by liec on 2017-03-20.
 */
public class Solution_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;
        ListNode p = head, cather = head, newHead;
        int len = 1;
        for (; p.next != null; p = p.next) len++;
        k %= len;
        for (int i = 0; i < len - k - 1; i++)
            cather = cather.next;
        p.next = head;
        newHead = cather.next;
        cather.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode a = ListNode.generateLinkList(5, i -> i + 1);
        ListNode r = new Solution_RotateList().rotateRight(a, 5);
        System.out.println("r = " + r);
    }
}
