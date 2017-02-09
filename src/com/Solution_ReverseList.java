package com;

/**
 * Created by liec on 17-2-9.
 */
public class Solution_ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode newHead = new ListNode(0);
        findSuccessor(head, newHead).next = null;
        return newHead.next;
    }

    public ListNode findSuccessor(ListNode node, ListNode newHead) {
        if (node.next != null) {
            ListNode successor = findSuccessor(node.next, newHead);
            successor.next = node;
        } else {
            newHead.next = node;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode[] lns = new ListNode[3];
        lns[0] = new ListNode(1);
        lns[1] = new ListNode(2);
        lns[2] = new ListNode(3);
        lns[0].next = lns[1];
        lns[1].next = lns[2];
        lns[2].next = null;
        ListNode a = lns[0];
        Solution_ReverseList s = new Solution_ReverseList();
        a = s.ReverseList(lns[2]);
        System.out.println(a);
    }
}
