package com.solutions;

import com.util.TreeNode;

/**
 * Created by liec on 17-2-9.
 */
public class Solution_HasSubtree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return false;
        return isSubtree(root1, root2) ||
                HasSubtree(root1.left, root2) ||
                HasSubtree(root1.right, root2);
    }

    public boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 != null && root1.val == root2.val) {
            return isSubtree(root1.left, root2.left) &&
                    isSubtree(root1.right, root2.right);
        }
        return false;
    }
}
