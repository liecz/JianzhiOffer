package com.solutions;

import com.util.TreeNode;

/**
 * 二叉搜索树的第k个结点
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。
 * Created by liec on 2017-03-05.
 */
public class Solution_KthNode {

    private int count = 0;

    public TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot != null) {
            TreeNode ret = KthNode(pRoot.left, k);
            if (ret != null)
                return ret;
            if (++count == k)
                return pRoot;
            ret = KthNode(pRoot.right, k);
            if (ret != null)
                return ret;
        }
        return null;
    }
}
