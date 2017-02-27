package com.solutions;

import com.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * 把二叉树打印成多行(二叉树层次遍历)
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * Created by liec on 2017-02-27.
 */
public class Solution_TreeTraversalPrint {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null)
            return new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(pRoot);
        int layerNodeCount = 1;
        ArrayList<Integer> layer = new ArrayList<>();
        // 二叉树的层次遍历
        while (!deque.isEmpty()) {
            TreeNode p = deque.pollFirst();
            layer.add(p.val);
            layerNodeCount--;
            if (p.left != null)
                deque.addLast(p.left);
            if (p.right != null)
                deque.addLast(p.right);
            if (layerNodeCount == 0) {
                result.add(layer);
                layer = new ArrayList<>();
                layerNodeCount = deque.size();
            }
        }
        return result;
    }
}
