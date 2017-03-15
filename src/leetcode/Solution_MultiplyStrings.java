package leetcode;

/**
 * 43. Multiply Strings
 * https://leetcode.com/problems/multiply-strings/#/description
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 * Note:
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * Created by liec on 2017-03-15.
 */
public class Solution_MultiplyStrings {
    public static void main(String[] args) {
        Solution_MultiplyStrings s = new Solution_MultiplyStrings();
        String str = s.multiply("100", "10");
        System.out.println("str = " + str);
    }

    public String multiply(String num1, String num2) {
        int[] sum = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int remaining = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                // 计算单位乘法的值
                int tsum = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 将此次的值与原本的值与上位剩下的值相加
                int redundant = tsum + sum[i + j + 1] + remaining;
                // 更新当前位的值
                sum[i + j + 1] = redundant % 10;
                // 剩下的留到下一位去处理
                remaining = redundant / 10;
            }
            // 处理余留的数值
            sum[i] += remaining;
        }
        // 将数组转换为字符串
        StringBuffer sb = new StringBuffer();
        boolean zeroFlag = true;
        for (int a : sum) {
            if (a == 0 && zeroFlag)
                continue;
            sb.append(a);
            zeroFlag = false;
        }
        // 若结果是0则加一位0
        if (zeroFlag && sb.length() == 0)
            sb.append(0);
        return sb.toString();
    }
}
