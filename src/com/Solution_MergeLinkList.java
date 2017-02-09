package com;

/**
 * Created by liec on 17-2-9.
 */
public class Solution_MergeLinkList {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list2 == null)
            return list1;
        if (list1 == null)
            return list2;
        // l1 has smaller value in the first elem
        ListNode l1 = list1, head = list1, l2 = list2;
        if (list1.val > list2.val) {
            head = l1 = list2;
            l2 = list1;
        }
        ListNode prel1 = l1, t;
        while (true) {
            if (l2.val < l1.val) {
                // 将l2的第一个元素插入到l1中，并l2前进
                prel1.next = l2;
                t = l2;
                l2 = l2.next;
                t.next = l1;
            } else {
                // l1 前进
                prel1 = l1;
                l1 = l1.next;
            }
            if (l1 == null) {
                // 如果l1前进到尾端，则将最后一个元素的next链接到l2尾端
                prel1.next = l2;
                break;
            }
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode a = ListNode.generateLinkList(3, new ILink() {
            @Override
            public int getValue(int pos) {
                return pos * 2;
            }
        });
        ListNode b = ListNode.generateLinkList(3, new ILink() {
            @Override
            public int getValue(int pos) {
                return pos * 2 + 1;
            }
        });
        Solution_MergeLinkList s = new Solution_MergeLinkList();
        ListNode z = s.Merge(a, b);
    }
}
