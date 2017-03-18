package leetcode;

/**
 * 58. Length of Last Word
 * https://leetcode.com/problems/length-of-last-word/#/description
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example,
 * Given s = "Hello World",
 * return 5.
 * Created by liec on 2017-03-18.
 */
public class Solution_LengthofLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char[] chars = s.toCharArray();
        int len = 0, i = chars.length - 1;
        while (i >= 0 && chars[i] == ' ') i--;
        while (i >= 0 && chars[i--] != ' ') len++;
        return len;
    }

    public static void main(String[] args) {
        Solution_LengthofLastWord s = new Solution_LengthofLastWord();
        int a = s.lengthOfLastWord("hello aaa ");
        System.out.println("a = " + a);
    }
}
