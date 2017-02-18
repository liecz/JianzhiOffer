package com.solutions;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,
 * 他马上就写出了正确答案是100。但是他并不满足于此,
 * 他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
 * Created by liec on 2017-02-18.
 */
public class Solution_FindContinuousSequence {
    public static void main(String[] args) {
        Solution_FindContinuousSequence s = new Solution_FindContinuousSequence();
        s.FindContinuousSequence(2);
    }

    /*
    * 滑动连续正整数窗口，若此时小于目标值，窗口扩大吸收更多数，反之减少窗口大小
    * */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum <= 1)
            return result;
        for (int right = 1, left = 1, tsum = 0; right <= sum / 2 + 2; ) {
            if (tsum < sum)
                tsum += right++; // 窗口右移
            else if (tsum > sum)
                tsum -= left++;  // 窗口左移
            else {
                ArrayList<Integer> l = new ArrayList<>();
                // 加入到结果集中
                for (int i = left; i < right; i++)
                    l.add(i);
                result.add(l);
                tsum += right++;
            }
        }
        return result;
    }
}
