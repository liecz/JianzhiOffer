package com.solutions;

/**
 * Created by liec on 2017-02-14.
 */
public class Solution_IsPopOrder {
/**
    public final static int NOTIN = 0;
    public final static int IN = 1;
    public final static int POPED = 2;

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int[] status = new int[pushA.length];
        for (int i = 0; i < popA.length; i++) {
            int state = POPED;
            boolean hasIn = false;
            for (int j = pushA.length-1; j >=0 ; j--) {
                if(pushA[j]==popA[i]){
                    if(hasIn){
                        return false;
                    }
                    // change to IN
                    status[j]=state--;
                }else if(status[j]==NOTIN){
                    status[j]=state;
                }
                if(!hasIn&&status[j]==IN){
                    hasIn = true;
                }
            }
            if(state==POPED){
                return false;
            }
        }
        return true;
    }
 */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int[] stack = new int[pushA.length];
        int top = -1;
        for (int i = 0,j=0; i < pushA.length;) {
            stack[++top] = pushA[i++];
            while (j<popA.length&&popA[j]==stack[top]){
                top--;
                j++;
            }
        }
        return top==-1;
    }
    public static void main(String[] args) {
        Solution_IsPopOrder s = new Solution_IsPopOrder();
        boolean a = s.IsPopOrder(new int[]{1,2,3,4,5},new int[]{4,5,1,2,3});
        boolean b = s.IsPopOrder(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1});

    }
}
