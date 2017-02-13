package com.solutions;

import com.util.TreeNode;


/**
 * Created by liec on 2017-02-13.
 */
public class Solution_BTreeMirror {
    public void Mirror(TreeNode root) {
        if(root != null){
            TreeNode tmp;
            //switching two sub-tree
            tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            //recursive
            if(root.left!=null)
                Mirror(root.left);
            if(root.right!=null)
                Mirror(root.right);
        }
    }
    public void Mirror_1(TreeNode root) {
        if(root==null)
            return;
        java.util.Deque<TreeNode> s = new java.util.ArrayDeque<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode r = s.pop();
            TreeNode tmp;
            //switching two sub-tree
            tmp = r.left;
            r.left = r.right;
            r.right = tmp;
            if(r.left!=null)
                s.push(r.left);
            if(r.right!=null)
                s.push(r.right);
        }
    }
}
