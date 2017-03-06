package jianzhi.solutions;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * Created by liec on 2017-02-18.
 */
public class Solution_FindNumbersWithSum {
    /*
    * 2个数的距离越远乘积越小
    * */
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length < 2)
            return result;
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int num = array[low] + array[high];
            if (num > sum)
                high--;
            else if (num < sum)
                low++;
            else {
                result.add(array[low]);
                result.add(array[high]);
                break;
            }
        }
        return result;
    }
}
