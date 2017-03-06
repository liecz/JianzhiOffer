package jianzhi.sorter;

import jianzhi.util.ListNode;

/**
 * Created by liec on 2017-03-04.
 */
public class QuickSorter {
    public static void sort(int[] array) {
        sortHelper(array, 0, array.length - 1);
    }

    private static void sortHelper(int[] array, int spos, int epos) {
        if (spos >= epos)
            return;
        int pivot = array[spos], i = spos, j = epos;
        while (i < j) {
            while (i < j && array[j] >= pivot)
                j--;
            array[i] = array[j];
            while (i < j && array[i] <= pivot)
                i++;
            array[j] = array[i];
        }
        array[i] = pivot;
        sortHelper(array, spos, i - 1);
        sortHelper(array, i + 1, epos);
    }

    public static void sort(ListNode listNode) {
        ListNode end = listNode;
        while (end.next != null)
            end = end.next;
        sortHelper(listNode, end);
    }

    private static void sortHelper(ListNode spos, ListNode epos) {
        if (spos != epos) {
            ListNode p = getPartition(spos, epos);
            sortHelper(spos, p);
            if (p.next != null) {
                sortHelper(p.next, epos);
            }
        }
    }

    private static ListNode getPartition(ListNode spos, ListNode epos) {
        int pivot = spos.val;
        ListNode i = spos, j = spos.next;
        while (j != epos.next) {
            if (j.val < pivot) {
                i = i.next;
                swap(i, j);
            }
            j = j.next;
        }
        swap(spos, i);
        return i;
    }

    private static void swap(ListNode a, ListNode b) {
        int t = a.val;
        a.val = b.val;
        b.val = t;
    }

    public static void main(String[] args) {
        int[] a = {57, 68, 59, 52, 72, 28, 96, 33, 24};
        ListNode s = ListNode.generateLinkList(a.length, i -> a[i]);
        System.out.println(s.toString());
        sort(s);
        System.out.println(s.toString());
//      sort(a);
//      System.out.println("a = " + Arrays.toString(a));
    }
}
