package jianzhi.solutions;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，
 * 请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 * Created by liec on 2017-02-15.
 */
public class Solution_MoreThanHalfNum {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        Solution_MoreThanHalfNum s = new Solution_MoreThanHalfNum();
        int b = s.MoreThanHalfNum_Solution1(a);
    }

    public int MoreThanHalfNum_Solution(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : array) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            if (entry.getValue() > array.length / 2)
                return entry.getKey();
        }
        return 0;
    }

    /*
    * 坚守士兵发，遇到相同阵营生命加一，遇到敌人生命减一，
    * 若死亡更换当前士兵为新士兵
    * */
    public int MoreThanHalfNum_Solution1(int[] array) {
        if (array.length == 0)
            return 0;
        int num = array[0], count = 1;
        for (int i = 1; i < array.length; i++) {
            count = array[i] == num ? count + 1 : count - 1;
            if (count == 0) {
                num = array[i];
                count = 1;
            }
        }
        count = 0;
        for (int a : array) {
            if (a == num) count++;
        }
        return count > array.length / 2 ? num : 0;
    }
}
