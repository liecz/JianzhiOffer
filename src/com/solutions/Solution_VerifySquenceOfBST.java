package com.solutions;

/**
 * BST的后序序列的合法序列是，对于一个序列S，
 * 最后一个元素是x （也就是根），如果去掉最后一个元素的序列为T，
 * 那么T满足：T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，
 * 且这两段（子树）都是合法的后序序列。完美的递归定义。
 * Created by liec on 2017-02-14.
 */
public class Solution_VerifySquenceOfBST {
    public boolean isBST(int[] seq,int l,int r){
        // 单个节点或非根空节点满足BST
        if(l>=r)
            return true;
        int rootVal = seq[r],i=r;
        // 寻找右子树的起点，满足条件右子树的所有节点均大于根节点
        while(i>l&&seq[i-1]>rootVal) i--;
        // 根据i确定剩下的部分是否为左子树，左子树满足所有节点均小于根节点
        for(int j=i-1;j>=l;j--){
            if(seq[j]>rootVal)
                return false;
        }
        // 递归确定左右子树是否满足
        return isBST(seq,l,i-1)&&isBST(seq,i,r-1);
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0){
            return false;
        }
        return isBST(sequence,0,sequence.length-1);
    }
}
