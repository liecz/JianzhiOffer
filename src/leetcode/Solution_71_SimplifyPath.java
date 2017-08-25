package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * <p>
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * <p>
 * https://leetcode.com/problems/simplify-path/description/
 * Created by liyue on 2017/8/15.
 */
public class Solution_71_SimplifyPath {
    public String simplifyPath(String path) {
        String[] directories = path.split("/");
        Deque<String> result = new LinkedList<>();
        for (String s : directories) {
            if (s.equals("") || s.equals(".")){
                continue;
            }else if (s.equals("..")){
                if (result.size() > 0){
                    result.removeLast();
                }
            }else {
                result.addLast(s);
            }
        }

        StringBuffer sb = new StringBuffer();
        for (String s : result){
            sb.append("/" + s);
        }
        String finalResult = sb.toString();
        return finalResult.length() == 0 ? "/" : finalResult;
    }

    public static void main(String[] args) {
        Solution_71_SimplifyPath s = new Solution_71_SimplifyPath();
        String s1 = s.simplifyPath("/a/...");
        String s2 = s.simplifyPath("/a/./b/../../c/");
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }
}
