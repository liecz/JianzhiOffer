package jianzhi.solutions;

/**
 * Q:求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数。
 * Created by liec on 2017-02-15.
 */
public class Solution_NumberOf1Between1AndN {
    public static void main(String[] args) {
        Solution_NumberOf1Between1AndN s = new Solution_NumberOf1Between1AndN();
        s.NumberOf1Between1AndN_Solution(123);
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        int ones = 0;
        for (long i = 1; i <= n; i *= 10) {
            long a = n / i, b = n % i;
            ones += (a + 8) / 10 * i + (a % 10 == 1 ? b + 1 : 0);
        }
        return ones;
    }
}
