package jianzhi.solutions;

import jianzhi.util.ListNode;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/253d2c59ec3e4bc68da16833f79a38e4
 * 来源：牛客网
 * <p>
 * 设起点到相遇点距离为x，起点到入口点距离为y，环长度为r，则快慢针相遇时，满足2x-x=nr，n为快针在环中转的圈数。--> x=nr
 * 快慢针相遇点距环入口点距离x-y
 * 相遇后，快针从起点重新开始以步长为1速度开始走，经过距离y到达环入口点，慢针走y步后距离环入口点距离为x-y+y=x=nr，即走到了环入口点，两个指针相遇
 * Created by liec on 2017-02-24.
 */
public class Solution_EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null)
            return null;
        ListNode slow = pHead, fast = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = pHead;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
