package jianzhi.solutions;

import jianzhi.util.TreeNode;

/**
 * 对称二叉树
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * Created by liec on 2017-02-27.
 */
public class Solution_isSymmetricalTree {
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null)
            return true;
        return helper(pRoot.left, pRoot.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null)
            return right == null;
        // if(left!=null&&right==null)
        if (right == null)
            return false;
        if (left.val != right.val)
            return false;
        // 检验是否是镜像
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
