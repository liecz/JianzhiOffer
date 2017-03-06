package jianzhi.solutions;

/**
 * Q:HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 你会不会被他忽悠住？(子向量的长度至少是1)
 * Created by liec on 2017-02-15.
 */
public class Solution_FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0)
            return 0;
        // 从第一个元素开始
        int sum = array[0], tmpsum = array[0];
        for (int i = 1; i < array.length; i++) {
            // 如果当前tmpsum已经是负数了，那么之前的情况不能
            // 帮助结果增加，故在本轮i舍弃，若array全为负数
            // sum会选取一个最大的负数返回
            tmpsum = tmpsum < 0 ? array[i] : tmpsum + array[i];
            // 永远记录最大和的情况，若当前tmpsum减少但未来会增加，例如5,-1,5
            // 则当tmpsum变更大时记录sum，否则维持现状最大的sum
            sum = sum > tmpsum ? sum : tmpsum;
        }
        return sum;
    }
}
