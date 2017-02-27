package com.solutions;

import com.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

/**
 * 按之字形顺序打印二叉树
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * Created by liec on 2017-02-27.
 */
public class Solution_PrintTreeAsZigzag {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null)
            return new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(pRoot);
        int layerNodeCount = 1;
        boolean order = true;
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
                if (!order) {
                    Collections.reverse(layer);
                }
                result.add(layer);
                layer = new ArrayList<>();
                layerNodeCount = deque.size();
                // 下次迭代改变方向
                order = !order;
            }
        }
        return result;
    }
}
