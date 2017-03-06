package jianzhi.solutions;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'
 * 表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * Created by liec on 2017-02-23.
 */
public class solution_RegMath {
    public static void main(String[] args) {
        solution_RegMath ss = new solution_RegMath();
        String s = "aaa", p = "a*a";
        boolean b = ss.match(s.toCharArray(), p.toCharArray());
        System.out.println("b = [" + b + "]");
    }

    public boolean match(char[] str, char[] pattern) {
        return helper(str, 0, pattern, 0);
    }

    private boolean helper(char[] str, int spos, char[] pattern, int ppos) {
        // 如果坚持到末尾即完成验证
        if (spos == str.length && ppos == pattern.length) {
            return true;
        }
        // 如果忽略掉~*一个通配符还可以完成验证即完成验证，否则需要这个通配符抵消一部分str
        if (ppos < pattern.length - 1 && pattern[ppos + 1] == '*') {
            if (helper(str, spos, pattern, ppos + 2))
                return true;
        }
        // 如果当前pattern为.且str还有字符或者pattern[i]==str[i]
        if (ppos < pattern.length && pattern[ppos] == '.' && spos < str.length ||
                spos < str.length && ppos < pattern.length && str[spos] == pattern[ppos]) {
            if (helper(str, spos + 1, pattern, ppos + 1))
                return true;
            // 使用~*抵消一个str的字符
            if (ppos < pattern.length - 1 && pattern[ppos + 1] == '*' &&
                    helper(str, spos + 1, pattern, ppos))
                return true;
        }
        return false;
    }
}
