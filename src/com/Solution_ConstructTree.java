package com;

import java.util.HashMap;

/**
 * Created by liec on 17-2-5.
 */
public class Solution_ConstructTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inMap.put(in[i], i);
        }
        TreeNode root = new TreeNode(0);
        constructTree(root, pre, 0, pre.length - 1, inMap, 0, in.length - 1);
        return root;
    }

    protected void constructTree(TreeNode root, int[] pre, int pBegin, int pEnd
            , HashMap<Integer, Integer> in, int iBegin, int iEnd) {
        root.left = root.right = null;
        int preRootVal = pre[pBegin];
        root.val = preRootVal;
        //find root node in in sequence
        //int indexOfIn = iBegin;
        //while(indexOfIn<=iEnd&&in[indexOfIn]!=preRootVal) indexOfIn++;
        int indexOfIn = in.get(preRootVal);
        //search left and right nodes in pre sequence and in sequence
        //construct left node
        int iLeftBegin = iBegin, iLeftEnd = indexOfIn - 1;
        int pLeftBegin = pBegin + 1, pLeftEnd = pLeftBegin + iLeftEnd - iLeftBegin;
        if (iLeftBegin <= iLeftEnd) {
            TreeNode left = new TreeNode(0);
            constructTree(left, pre, pLeftBegin, pLeftEnd, in, iLeftBegin, iLeftEnd);
            root.left = left;
        }
        //construct right node
        int iRightBegin = indexOfIn + 1, iRightEnd = iEnd;
        int pRightBegin = pLeftEnd + 1, pRightEnd = pEnd;
        if (iRightBegin <= iRightEnd) {
            TreeNode right = new TreeNode(0);
            constructTree(right, pre, pRightBegin, pRightEnd, in, iRightBegin, iRightEnd);
            root.right = right;
        }
    }

    public static void main(String[] args) {
        Solution_ConstructTree s = new Solution_ConstructTree();
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode t = s.reConstructBinaryTree(pre, in);
        System.out.println(t);
    }
}
