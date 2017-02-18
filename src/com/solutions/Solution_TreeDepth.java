package com.solutions;

import com.util.TreeNode;

import java.util.Deque;

/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 * Created by liec on 2017-02-18.
 */
public class Solution_TreeDepth {
    public static void main(String[] args) {
        Solution_TreeDepth s = new Solution_TreeDepth();
        TreeNode r = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode l2 = new TreeNode(3);
        r.left = l1;
        l1.left = l2;
        int a = s.TreeDepth1(r);
        System.out.println("a = " + a);
    }

    /*
    * 递归版本
    * */
    public int TreeDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }

    /*
    * 非递归版本，层次遍历
    * */
    public int TreeDepth1(TreeNode root) {
        if (root == null)
            return 0;
        Deque<TreeNode> deque = new java.util.ArrayDeque<>();
        deque.add(root);
        int layerCount = 1, depth = 0;
        while (!deque.isEmpty()) {
            TreeNode r = deque.pollFirst();
            if (r.left != null) deque.addLast(r.left);
            if (r.right != null) deque.addLast(r.right);
            if (--layerCount == 0) { // 上一层已经全部遍历完
                layerCount = deque.size();
                depth++;
            }
        }
        return depth;
    }
}
