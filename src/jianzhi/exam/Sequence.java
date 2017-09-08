package jianzhi.exam;

import java.util.Scanner;

/**
 * 小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
 * 1、将a_i放入b序列的末尾
 * 2、逆置b序列
 * 小易需要你计算输出操作n次之后的b序列。
 * 输入描述:
 * 输入包括两行,第一行包括一个整数n(2 ≤ n ≤ 2*10^5),即序列的长度。
 * 第二行包括n个整数a_i(1 ≤ a_i ≤ 10^9),即序列a中的每个整数,以空格分割。
 * <p>
 * <p>
 * 输出描述:
 * 在一行中输出操作n次之后的b序列,以空格分割,行末无空格。
 * <p>
 * 输入例子1:
 * 4
 * 1 2 3 4
 * <p>
 * 输出例子1:
 * 4 2 1 3
 * Created by liec on 2017-09-01.
 */
public class Sequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String lengthStr = sc.nextLine(), arrayStr = sc.nextLine();
        String[] array = arrayStr.split("\\s+");
        int length = Integer.valueOf(lengthStr);
        int[] x = new int[length], y = new int[length];
        for (int i = 0; i < x.length; i++) {
            x[i] = Integer.valueOf(array[i]);
        }
        int i = x.length - 1;
        int left = 0, right = x.length - 1;
        while (i > 0) {
            int a = x[i - 1], b = x[i];
            y[left++] = b;
            y[right--] = a;
            i -= 2;
        }
        if (i == 0) {
            y[left] = x[i];
        }
        StringBuffer sb = new StringBuffer();
        for (int ai : y) {
            sb.append(ai + " ");
        }
        String result = sb.substring(0, sb.length() - 1);
        System.out.println(result);
    }
}
