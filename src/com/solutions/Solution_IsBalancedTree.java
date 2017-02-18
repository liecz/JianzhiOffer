package com.solutions;

import com.util.TreeNode;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树
 * Created by liec on 2017-02-18.
 */
public class Solution_IsBalancedTree {
    private boolean isBalancedTree = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        helper(root);
        return isBalancedTree;
    }

    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        if (!isBalancedTree)
            return 1;
        int left = helper(root.left);
        int right = helper(root.right);
        if (Math.abs(left - right) > 1)
            isBalancedTree = false;
        return 1 + Math.max(left, right);
    }
}
