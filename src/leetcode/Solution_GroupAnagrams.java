package leetcode;

import java.util.*;

/**
 * Created by liec on 2017-03-15.
 */
public class Solution_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        if (strs == null || strs.length == 0)
            return lists;
        Map<String, List<Integer>> dummy = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (dummy.containsKey(s)) {
                List<Integer> plist = dummy.get(s);
                plist.add(i);
            } else {
                List<Integer> plist = new ArrayList<>();
                plist.add(i);
                dummy.put(s, plist);
            }
        }
        Iterator<Map.Entry<String, List<Integer>>> it = dummy.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, List<Integer>> e = it.next();
            List<Integer> plist = e.getValue();
            List<String> tmp = new ArrayList<>(plist.size());
            for (int i : plist) {
                tmp.add(strs[i]);
            }
            lists.add(tmp);
        }
        return lists;
    }

    public static void main(String[] args) {
        Solution_GroupAnagrams s = new Solution_GroupAnagrams();
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> a = s.groupAnagrams(strs);
        System.out.println("a = " + a);
    }
}
