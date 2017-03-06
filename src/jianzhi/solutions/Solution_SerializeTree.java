package jianzhi.solutions;

import jianzhi.util.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 1. 对于序列化：使用前序遍历，递归的将二叉树的值转化为字符，并且在每次二叉树的结点
 * 不为空时，在转化val所得的字符之后添加一个' ， '作为分割。对于空节点则以 '#' 代替。
 * 2. 对于反序列化：按照前序顺序，递归的使用字符串中的字符创建一个二叉树
 * Created by liec on 2017-02-27.
 */
public class Solution_SerializeTree {
    TreeNode pRoot = null;

    public String Serialize(TreeNode pRoot) {
        this.pRoot = pRoot;
        if (pRoot == null)
            return "#";
        StringBuffer result = new StringBuffer();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(pRoot);
        int layerNodeCount = 1;
        // 二叉树的层次遍历
        while (!deque.isEmpty()) {
            TreeNode p = deque.pollFirst();
            if (p != null)
                result.append(p.val);
            else
                result.append("#");
            result.append(",");
            layerNodeCount--;
            deque.addLast(p.left);
            deque.addLast(p.right);
            if (layerNodeCount == 0) {
                layerNodeCount = deque.size();
            }
        }
        return result.substring(0, result.length() - 1);
    }

    public TreeNode Deserialize(String str) {
        return pRoot;
    }
}
