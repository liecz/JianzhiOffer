package com.solutions;

import com.util.TreeLinkNode;

/**
 * 二叉树的下一个结点
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * Created by liec on 2017-02-27.
 */
public class Solution_TreeLinkNodeGetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null)
            return null;
        if (pNode.right != null) {
            // 如果右子树的最左子树不为空则下一个节点为右子树的最左节点
            TreeLinkNode p = pNode.right;
            while (p.left != null)
                p = p.left;
            return p;
        } else {
            // 如果右子树为空且该节点为父节点的右节点则向上寻找指导该节点是父节点的左节点，返回该节点的父节点
            TreeLinkNode p = pNode;
            while (p.next != null && p.next.right == p)
                p = p.next;
            return p.next;
        }
    }
}
