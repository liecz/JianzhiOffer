package leetcode;

/**
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game/#/description
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * Created by liec on 2017-03-17.
 */
public class Solution_JumpGame {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for (int i = 0; i < nums.length &&
                // 最远到达的元素必须大于等于当前元素，否则不能前进
                // 最远到达元素包括最尾元素则结束
                maxJump >= i && maxJump < nums.length - 1; i++) {
            maxJump = Math.max(maxJump, i + nums[i]);
        }
        return maxJump >= nums.length - 1;
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 1, 4};
        int[] b = {0, 1, 1, 0, 4};
        Solution_JumpGame s = new Solution_JumpGame();
        System.out.println("s.canJump(a) = " + s.canJump(a));
        System.out.println("s.canJump(b) = " + s.canJump(b));
    }
}
