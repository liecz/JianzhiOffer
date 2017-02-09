package com;

/**
 * Created by liec on 17-2-9.
 */
public class Solution_FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        int i = 1;
        ListNode seeker = head, dump = head;
        while (dump.next != null) {
            dump = dump.next;
            if (++i > k) {
                seeker = seeker.next;
            }
        }
        return k > i ? null : seeker;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
