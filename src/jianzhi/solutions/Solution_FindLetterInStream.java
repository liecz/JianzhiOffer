package jianzhi.solutions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"
 * Created by liec on 2017-02-23.
 */
public class Solution_FindLetterInStream {

    private Set<Character> set = new HashSet<>();
    private List<Character> list = new LinkedList<>();

    public static void main(String[] args) {
        Solution_FindLetterInStream s = new Solution_FindLetterInStream();
        String g = "google";
        for (char c : g.toCharArray()) {
            s.Insert(c);
            System.out.println(s.FirstAppearingOnce());
        }
    }

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (!set.contains(ch)) {
            set.add(ch);
            list.add(ch);
        } else {
            list.remove(new Character(ch));
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return list.size() == 0 ? '#' : list.get(0);
    }
}
