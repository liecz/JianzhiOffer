package com.solutions;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 * Created by liec on 2017-02-23.
 */
public class Solution_StrToInt {

    public static void main(String[] args) {
        Solution_StrToInt s = new Solution_StrToInt();
        int a = s.StrToInt("1-123");
        System.out.println("a = " + a);
    }

    public int StrToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;
        char[] chars = str.toCharArray();
        int val = 0, pos = 1, i = str.length() - 1;
        boolean symbol = false;
        while (i >= 0) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                if (symbol)
                    return 0; // 1+22
                val += (chars[i] - 48) * pos;
                pos *= 10;
            } else if (chars[i] == '-') {
                val = -val;
                symbol = true;
            } else if (chars[i] == '+') {
                symbol = true;
            } else {
                return 0;
            }
            i--;
        }
        return val;
    }
}
