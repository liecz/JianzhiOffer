package jianzhi.solutions;

import jianzhi.util.ListNode;

/**
 * 删除链表中重复的结点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * Created by liec on 2017-02-27.
 */
public class Solution_DeleteDuplication {
    public static void main(String[] args) {
        ListNode[] ls = new ListNode[]{
                new ListNode(1), new ListNode(1), new ListNode(1), new ListNode(1),
                new ListNode(1), new ListNode(2), new ListNode(3),
        };
        for (int i = 0; i < ls.length - 1; i++) {
            ls[i].next = ls[i + 1];
        }
        Solution_DeleteDuplication s = new Solution_DeleteDuplication();
        ListNode a = s.deleteDuplication1(ls[0]);
        System.out.println(a);
    }

    public ListNode deleteDuplication(ListNode pHead) {
        ListNode p = pHead, head = new ListNode(-1), pre = head;
        head.next = pHead;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                // remove duplicates
                ListNode tmp = p.next.next;
                while (tmp != null && tmp.val == p.val) {
                    tmp = tmp.next;
                }
                pre.next = tmp;
                p = tmp;
            } else {
                pre = p;
                p = p.next;
            }
        }
        return head.next;
    }

    /*
    * 递归版本
    * */
    public ListNode deleteDuplication1(ListNode pHead) {
        if (pHead == null)
            return null;
        if (pHead != null && pHead.next == null)
            return pHead;
        if (pHead.val == pHead.next.val) {
            ListNode c = pHead.next.next;
            while (c != null && c.val == pHead.val)
                c = c.next;
            return deleteDuplication1(c);
        } else {
            pHead.next = deleteDuplication1(pHead.next);
            return pHead;
        }
    }
}
