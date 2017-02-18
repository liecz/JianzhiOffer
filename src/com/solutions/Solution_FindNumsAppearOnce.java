package com.solutions;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * Created by liec on 2017-02-18.
 */
public class Solution_FindNumsAppearOnce {
    public static void main(String[] args) {
        Solution_FindNumsAppearOnce s = new Solution_FindNumsAppearOnce();
        int[] a = {1, 2, 3, 3, 1};
        int b = s.FindNumsAppearOnce(a);
        System.out.println("b = " + b);
        int[] c = {1, 2, 3, 4, 5, 4, 2, 1};
        int[] d = {0}, e = {0};
        s.FindNumsAppearOnce(c, d, e);
        System.out.println("d = " + d[0] + " e = " + e[0]);
    }

    /*
    * 找出出现了一次的2个数字
    * 根据任何2个相同数字异或为0的原理，对数组所有数字取异或，出现2次的数字异或相互抵消
    * 最终剩下2个不同数字的异或结果，切不为0。即二进制必有一位为1，也就是代表这两个数字的在那一位的
    * 二进制数值不同（一个是0，一个是1）。之后根据这位数字将数组划分为2段，对每段取异或
    * */
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        if (array == null || array.length <= 1) {
            num1[0] = num2[0];
            return;
        }
        // 对数组所有数字取异或
        int num = 0;
        for (int a : array) num ^= a;
        int bitpos = 0;
        // 对异或结果num选取二进制中第一个1值的位置，int的大小为4*8bit；
        // << 相当于对00000001中的1左移
        for (; bitpos < 4 * 8 && (num & 1 << bitpos) == 0; bitpos++) ;
        // 根据第bitpos为1将数组分为2部分（不一定长度相等），对每段取异或得最终结果
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 1 << bitpos) != 0) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    /*
    * 数组中只有一个元素出现了一次，其他元素均出现了2次
    * */
    public int FindNumsAppearOnce(int[] array) {
        int num = 0;
        for (int a : array) {
            num ^= a;
        }
        return num;
    }
}
