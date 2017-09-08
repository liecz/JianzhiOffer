package jianzhi.exam;

import java.util.Scanner;

/**
 * 有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，
 * 要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？
 * 输入描述:
 * 每个输入包含 1 个测试用例。每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，
 * 表示学生的个数，接下来的一行，包含 n 个整数，按顺序表示每个学生的能力值 ai（-50 <= ai <= 50）。
 * 接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。
 * 输出描述:
 * 输出一行表示最大的乘积。
 * 示例1
 * 输入
 * <p>
 * 3
 * 7 4 7
 * 2 50
 * 输出
 * <p>
 * 49
 * Created by liec on 2017-09-04.
 */
public class 合唱团 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int[] ai = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ai[i] = s.nextInt();
        }
        int K = s.nextInt(), d = s.nextInt();
        long ans = 0;
        int[][] fm = new int[K + 1][num + 1], fn = new int[K + 1][num + 1];
        for (int i = 0; i < K + 1; i++) {
            for (int j = 0; j < num + 1; j++) {
                fm[i][j] = fn[i][j] = 0;
            }
        }
        int i, k, j;
        for (i = 1; i <= num; i++) {
            fm[1][i] = fn[1][i] = ai[i];
            for (k = 2; k <= K; k++) {
                for (j = i - 1; j > 0 && i - j <= d; j--) {
                    fm[k][i] = Math.max(fm[k][i], Math.max(fm[k - 1][j] * ai[j], fn[k - 1][j] * ai[j]));
                    fn[k][i] = Math.min(fn[k][i], Math.min(fm[k - 1][j] * ai[j], fn[k - 1][j] * ai[j]));
                }
            }
            ans = Math.max(ans, fm[k][i]);
        }
        System.out.println(ans);
    }
}
