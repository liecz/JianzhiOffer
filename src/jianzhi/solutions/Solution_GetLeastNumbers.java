package jianzhi.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * Created by liec on 2017-02-15.
 */
public class Solution_GetLeastNumbers {
    public static void main(String[] args) {
        Solution_GetLeastNumbers s = new Solution_GetLeastNumbers();
        int[] a = {4, 5, 1, 6, 2, 7, 3, 8};
        List<Integer> b = s.GetLeastNumbers_Solution(a, 4);

    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (input.length == 0 || k > input.length || k < 1) {
            return new ArrayList<>();
        }
        if (k == input.length) {
            ArrayList<Integer> a = new ArrayList<>();
            for (int n : input) a.add(n);
            return a;
        }
        for (int i = 1; i < input.length; i++) {
            int p;
            if (i < k) {
                p = i;
            } else if (input[k - 1] > input[i]) {
                input[k - 1] = input[i];
                p = k - 1;
            } else continue;
            int num = input[p], j = p;
            for (; j > 0 && input[j - 1] > num; j--)
                input[j] = input[j - 1];
            input[j] = num;
        }
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            a.add(input[i]);
        }
        return a;
    }
}
