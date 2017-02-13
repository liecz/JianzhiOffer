package com.solutions;

/**
 * Created by liec on 17-2-8.
 */
public class Solution_JumpFloor {
    public int JumpFloor(int target) {
        if (target == 1 || target == 2) {
            return target;
        }
        // the sum of stairs when step back #, assuming current stair is 3
        int backStep1 = 2, backStep2 = 1;
        int sum = 0;
        for (int i = 3; i <= target; i++) {
            sum = backStep1 + backStep2;
            backStep2 = backStep1;
            backStep1 = sum;
        }
        return sum;
    }
}
