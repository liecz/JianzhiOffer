package jianzhi.exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 如果一个数列S满足对于所有的合法的i,都有S[i + 1] = S[i] + d, 这里的d也可以是负数和零,我们就称数列S为等差数列。
 * 小易现在有一个长度为n的数列x,小易想把x变为一个等差数列。小易允许在数列上做交换任意两个位置的数值的操作,并且交换操作允许交换多次。但是有些数列通过交换还是不能变成等差数列,小易需要判别一个数列是否能通过交换操作变成等差数列
 * 输入描述:
 * 输入包括两行,第一行包含整数n(2 ≤ n ≤ 50),即数列的长度。
 * 第二行n个元素x[i](0 ≤ x[i] ≤ 1000),即数列中的每个整数。
 * <p>
 * <p>
 * 输出描述:
 * 如果可以变成等差数列输出"Possible",否则输出"Impossible"。
 * <p>
 * 输入例子1:
 * 3
 * 3 1 2
 * <p>
 * 输出例子1:
 * Possible
 * Created by liec on 2017-09-01.
 */
public class ArithmeticProgression {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String lengthStr = sc.nextLine(), arrayStr = sc.nextLine();
        String[] array = arrayStr.split("\\s+");
        String possible = "Possible", impossible = "Impossible";
        int length = Integer.valueOf(lengthStr);
        if (length == 2) {
            System.out.println(possible);
            return;
        }

        int[] x = new int[length];
        for (int i = 0; i < x.length; i++) {
            x[i] = Integer.valueOf(array[i]);
        }
        Arrays.sort(x);
        int dvalue = x[1] - x[0];
        for (int i = 2; i < length; i++) {
            if (x[i] - x[i - 1] != dvalue) {
                System.out.println(impossible);
                return;
            }
        }
        System.out.println(possible);
    }
}
