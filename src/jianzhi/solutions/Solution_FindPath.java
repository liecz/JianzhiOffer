package jianzhi.solutions;

import jianzhi.util.TreeNode;

import java.util.ArrayList;

/**
 * Q:输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * Created by liec on 2017-02-14.
 */
public class Solution_FindPath {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    ArrayList<Integer> tmpResult = new ArrayList<>();
    public void find(TreeNode root, int leftNum){
        // 加入当前节点
        tmpResult.add(root.val);
        // 判断是否满足条件
        if(leftNum-root.val==0&&root.left==null&&root.right==null){
            result.add((ArrayList<Integer>) tmpResult.clone());
        }else{
            // 寻找左子树
            if(root.left!=null){
                find(root.left,leftNum-root.val);
            }
            // 寻找右子树
            if(root.right!=null){
                find(root.right,leftNum-root.val);
            }
        }
        // 经过该点的所有路径都不满足条件
        tmpResult.remove(tmpResult.size()-1);
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root!=null){
            find(root,target);
        }
        return result;
    }
}
