package com.solutions;

import com.util.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created by liec on 2017-02-14.
 */
public class Solution_PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        java.util.Deque<TreeNode> queue = new java.util.ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.push(root);
        while(!queue.isEmpty()){
            TreeNode t = queue.pollFirst();
            result.add(t.val);
            if(t.left!=null){
                queue.addLast(t.left);
            }
            if(t.right!=null){
                queue.addLast(t.right);
            }
        }
        return result;
    }
}
