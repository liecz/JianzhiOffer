package jianzhi.solutions;

/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，
 * 写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，
 * 但却读不懂它的意思。例如，“student. a am I”。后来才意识到，
 * 这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * Created by liec on 2017-02-21.
 */
public class Solution_ReverseSentence {
    public static void main(String[] args) {
        Solution_ReverseSentence s = new Solution_ReverseSentence();
        String a = "i am a student. ";
        String b = s.ReverseSentence(a);
        System.out.println("b = " + b);
    }

    /*
    * 见 Solution_LeftRotateString.java
    * */
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0)
            return "";
        char[] chars = str.toCharArray();
        int lastPos = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, lastPos, i - 1);
                lastPos = i + 1;
            }
        }
        reverse(chars, lastPos, chars.length - 1);
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
