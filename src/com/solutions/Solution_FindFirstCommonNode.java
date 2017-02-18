package com.solutions;

import com.util.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 * Created by liec on 2017-02-18.
 */
public class Solution_FindFirstCommonNode {
    /*
    * p1p2指向2个链表的头，p1,p2同时向前走，若p1p2某个制作变为null则从另一个链表的
    * 头开始走，当第二次遇到null时，先走的p已经正好赶上遇到null的制作的下一个节点（链表表头）
    * */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1, p2 = pHead2;
        while (p1 != p2) {
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }
}
