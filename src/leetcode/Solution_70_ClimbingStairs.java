package leetcode;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * https://leetcode.com/problems/climbing-stairs/description/
 * Created by liyue on 2017/8/15.
 */
public class Solution_70_ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int n0 = 1, n1 = 2, num = 0;
        for (int step = 3; step <= n; step++){
            num = n0 + n1;
            n0 = n1;
            n1 = num;
        }
        return num;
    }

    public static void main(String[] args) {
        int n = new Solution_70_ClimbingStairs().climbStairs(44);
        System.out.println(n);
    }
}
