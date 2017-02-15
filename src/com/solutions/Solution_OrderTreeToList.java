package com.solutions;

import com.util.TreeNode;

/**
 * Q.输入一棵二叉搜索树，
 * 将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * Created by liec on 2017-02-14.
 */
public class Solution_OrderTreeToList {
    public TreeNode Convert1(TreeNode pRootOfTree) {
        if(pRootOfTree==null)
            return null;
        java.util.Stack<TreeNode> stack = new java.util.Stack<>();
        // pre 是有序序列中的上一个节点
        TreeNode p = pRootOfTree,pre=null;
        boolean isFirstNode = true;
        while(p!=null||!stack.empty()){
            // 向左深入
            while (p!=null){
                stack.push(p);
                p = p.left;
            }
            // 最左节点
            p = stack.pop();
            if(isFirstNode){
                pRootOfTree = p;
                pre = p;
                isFirstNode = false;
            }else {
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            // 若p的right为null，stack非空，则p移动到上一个节点
            p = p.right;
        }
        return pRootOfTree;
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)
            return null;
        if(pRootOfTree.left==null&&pRootOfTree==null)
            return pRootOfTree;
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode p = left;
        // 寻找最左节点的最右节点
        while(p!=null&&p.right!=null)
            p = p.right;
        // 最左节点的最右节点是当前节点的前驱
        if(left!=null){
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }
        // 最右节点的最左节点
        TreeNode right = Convert(pRootOfTree.right);
        if(right!=null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }
        // 返回当前pRootOfTree的最左节点
        return left==null?pRootOfTree:left;
    }
}
