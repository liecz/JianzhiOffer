package jianzhi.solutions;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
 * Created by liec on 2017-02-23.
 */
public class Solution_DuplicateNum {

    public static void main(String[] args) {
        Solution_DuplicateNum s = new Solution_DuplicateNum();
        int[] a = {0, 1, 2, 4, 4, 5}, b = {-1};
        s.duplicate(a, a.length, b);
        System.out.println("b = " + b[0]);
    }

    /*
    * 使用numbers数组自身做标记位来表示这个数是否之前出现过
    * 假设当前数是num，表示标记的是numbers[num]
    * 当前数是num，找到numbers[num]这个数，若他已被标记说明之前遇到过这个数，返回该数即可
    * */
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length == 0) {
            duplication[0] = -1;
            return false;
        }
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            //若当前该数已经被别的数标记，则减去length得到该数原本的值，
            //由于是在num上操作，所以不影响其他数利用该数做的标记
            if (num >= length) {
                num -= length;
            }
            if (numbers[num] >= length) {
                duplication[0] = num;
                return true;
            }
            numbers[num] += length;
        }
        return false;
    }
}
