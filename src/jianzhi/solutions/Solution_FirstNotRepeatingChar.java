package jianzhi.solutions;

/**
 * 在一个字符串(1<=字符串长度<=10000，全部由大写字母组成)
 * 中找到第一个只出现一次的字符,并返回它的位置
 * Created by liec on 2017-02-16.
 */
public class Solution_FirstNotRepeatingChar {
    public static void main(String[] args) {
        Solution_FirstNotRepeatingChar s = new Solution_FirstNotRepeatingChar();
        int a = s.FirstNotRepeatingChar("google");
    }

    public int FirstNotRepeatingChar(String str) {
        if (str.length() == 0)
            return -1;
        char[] chars = str.toCharArray();
        int[] state = new int['z' - 'A' + 1];
        java.util.Arrays.fill(state, -1);
        for (int i = 0; i < chars.length; i++) {
            int pos = chars[i] - 'A';
            if (state[pos] == -1) {
                state[pos] = i;
            } else {
                state[pos] = -2;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            int pos = chars[i] - 'A';
            if (state[pos] != -1 && state[pos] != -2)
                return i;
        }
        return -1;
    }
}
