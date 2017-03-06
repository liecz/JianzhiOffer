package jianzhi.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Q.输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 * Created by liec on 2017-02-16.
 */
public class Solution_PrintMinNumber {
    public static void main(String[] args) {
        Solution_PrintMinNumber s = new Solution_PrintMinNumber();
        int[] a = {3, 32, 321};
        String str = s.PrintMinNumber(a);
    }

    /*
    * 将numbers数组看做就是最终生成字符串的结果，调整数组中数字位置就相当于最终数字的大小，
    * 因此数字的在数组中的大小取决于它于其他数字拼接成的数字的大小
    * 将该问题转换成为自定义排序的条件排序问题
    * */
    public String PrintMinNumber(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>(numbers.length);
        for (int a : numbers)
            list.add(a);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return String.valueOf(o1 + "" + o2).compareTo(o2 + "" + o1);
            }
        });
        StringBuilder s = new StringBuilder();
        for (int a : list) {
            s.append(a);
        }
        return s.toString();
    }
}
