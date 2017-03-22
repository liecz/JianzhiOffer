package leetcode;

/**
 * 67. Add Binary
 * https://leetcode.com/problems/add-binary/#/description
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * Created by liec on 2017-03-22.
 */
public class Solution_AddBinary {
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        int i = ca.length - 1, j = cb.length - 1, c = 0;
        while (i >= 0 || j >= 0 || c > 0) {
            c += i >= 0 ? (ca[i--] - '0') : 0;
            c += j >= 0 ? (cb[j--] - '0') : 0;
            sb.append(c % 2);
            c /= 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution_AddBinary s = new Solution_AddBinary();
        String r = s.addBinary("111", "010");
        System.out.println("r = " + r);
    }
}
