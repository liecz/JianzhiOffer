package leetcode;

/**
 * 66. Plus One
 * https://leetcode.com/problems/plus-one/#/description
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * The digits are stored such that the most significant digit is at the head of the list.
 * Created by liec on 2017-03-22.
 */
public class Solution_PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // if digits[i] == 9，加一到该位，for循环继续，对高位继续加一
            digits[i] = 0;
        }
        int[] newdigs = new int[n + 1];
        newdigs[0] = 1;
        return newdigs;
    }
}
