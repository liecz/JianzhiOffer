package jianzhi.solutions;

import jianzhi.util.RandomListNode;

/**
 * Q.输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *  1、复制每个节点，如：复制节点A得到A1，将A1插入节点A后面
 *  2、遍历链表，A1->random = A->random->next;
 *  3、将链表拆分成原链表和复制后的链表
 * Created by liec on 2017-02-14.
 */
public class Solution_RandomListClone {
    public static void main(String[] args) {
        RandomListNode a = new RandomListNode(1);
        RandomListNode b = new RandomListNode(2);
        RandomListNode c = new RandomListNode(3);
        a.next = b;
        b.next = c;
        a.random = c;
        Solution_RandomListClone s = new Solution_RandomListClone();
        RandomListNode d = s.Clone(a);
    }

    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead==null){
            return null;
        }
        RandomListNode t,p=pHead,cloneHead;
        // part.1
        while(p!=null){
            t = p.next;
            p.next = new RandomListNode(p.label);
            p.next.next = t; // a' next
            p = t;
        }
        // part.2
        p = pHead;
        while(p!=null){
            if(p.random!=null){
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        // part.3
        cloneHead = pHead.next;
        p = pHead;
        while (p.next!=null){
            t = p.next;
            p.next = t.next;
            p = t;
        }
        return cloneHead;
    }
}
