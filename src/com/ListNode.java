package com;

/**
 * Created by liec on 17-2-9.
 */
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
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

interface ILink {
    public int getValue(int pos);
}