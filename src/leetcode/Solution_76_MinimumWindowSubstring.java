package leetcode;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 76. Minimum Window Substring
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * <p>
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * <p>
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * https://leetcode.com/problems/minimum-window-substring/description/
 * Created by liyue on 2017/8/18.
 */
public class Solution_76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0)
            return "";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, 1);
        }
        int counter = t.length(), begin = 0, end = 0, d = Integer.MAX_VALUE, head = 0;
        while (end < s.length()) {
            char c = s.charAt(end++);
            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    counter--;
                }
                map.put(c, map.get(c) - 1);
            }
            while (counter == 0) {
                if (end - begin < d) d = end - (head = begin);
                char c1 = s.charAt(begin++);
                if (map.containsKey(c1)) {
                    if (map.get(c1) == 0) {
                        counter++;
                    }
                    map.put(c1, map.get(c1) + 1);
                }
            }
        }
        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);
    }

    public static void main(String[] args) {
        Solution_76_MinimumWindowSubstring s = new Solution_76_MinimumWindowSubstring();
        System.out.println(s.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(1503127277421l)));
    }
}
