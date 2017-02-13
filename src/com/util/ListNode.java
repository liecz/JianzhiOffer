package com.util;

/**
 * Created by liec on 17-2-9.
 */
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode generateLinkList(int size, ILink listener) {
        ListNode[] lns = new ListNode[size];
        ListNode pre = null;
        for (int i = 0; i < size; i++) {
            int val = listener.getValue(i);
            lns[i] = new ListNode(val);
            if (pre != null) {
                pre.next = lns[i];
            }
            pre = lns[i];
        }
        pre.next = null;
        return lns[0];
    }
}
