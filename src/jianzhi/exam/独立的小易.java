package jianzhi.exam;

import java.util.Scanner;

/**
 * 小易为了向他的父母表现他已经长大独立了,他决定搬出去自己居住一段时间。一个人生活增加了许多花费:
 * 小易每天必须吃一个水果并且需要每天支付x元的房屋租金。当前小易手中已经有f个水果和d元钱,
 * 小易也能去商店购买一些水果,商店每个水果售卖p元。小易为了表现他独立生活的能力,希望能独立生活的时间越长越好,
 * 小易希望你来帮他计算一下他最多能独立生活多少天。
 * 输入描述:
 * 输入包括一行,四个整数x, f, d, p(1 ≤ x,f,d,p ≤ 2 * 10^9),以空格分割
 * <p>
 * <p>
 * 输出描述:
 * 输出一个整数, 表示小易最多能独立生活多少天。
 * <p>
 * 输入例子1:
 * 3 5 100 10
 * <p>
 * 输出例子1:
 * 11
 * Created by liec on 2017-09-01.
 */
public class 独立的小易 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arrayStr = sc.nextLine();
        String[] array = arrayStr.split("\\s+");
        int[] in = new int[4];
        for (int i = 0; i < in.length; i++) {
            in[i] = Integer.valueOf(array[i]);
        }
        int x = in[0], f = in[1], d = in[2], p = in[3];
        int result = (d + f * p) / (x + p);
        System.out.println(result);
    }
}
