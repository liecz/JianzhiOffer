package com.solutions;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * Created by liec on 2017-02-21.
 */
public class Solution_NumberOf1 {
    public static void main(String[] args) {
        Solution_NumberOf1 s = new Solution_NumberOf1();
        int a = -2;
        int b = s.NumberOf1(a);
        System.out.println("b = " + b);
    }

    public int NumberOf1(int n) {
        int count = 0, flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0)
                count++;
            flag = flag << 1;
        }
        return count;
    }
}
