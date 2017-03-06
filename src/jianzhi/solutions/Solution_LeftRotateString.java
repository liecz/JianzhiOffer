package jianzhi.solutions;

/**
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 * Created by liec on 2017-02-21.
 */
public class Solution_LeftRotateString {
    public static void main(String[] args) {
        Solution_LeftRotateString s = new Solution_LeftRotateString();
        String s1 = "abcXYZdef";
        String s2 = s.LeftRotateString(s1, 3);
        System.out.println("s2 = " + s2);
    }

    /*
    * 利用公式(ArBr)r = BrrArr = BA
    * 有输入s = abcdef,左移3位，设A=abc B=def
    * 套入公式得s'=defabc即最终结果
    * */
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0 || n > str.length())
            return new String("");
        if (n == str.length())
            return str;
        char[] chars = str.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, chars.length - 1);
        return String.valueOf(chars);
    }

    private void reverse(char[] arg, int i, int j) {
        char tmp;
        while (i < j) {
            tmp = arg[i];
            arg[i] = arg[j];
            arg[j] = tmp;
            i++;
            j--;
        }
    }
}
