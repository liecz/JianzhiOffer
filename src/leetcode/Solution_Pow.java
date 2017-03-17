package leetcode;

/**
 * 50. Pow(x, n)
 * https://leetcode.com/problems/powx-n/#/description
 * Implement pow(x, n).
 * Created by liec on 2017-03-17.
 */
public class Solution_Pow {
    public double myPow(double x, int n) {
        if (n < 0)
            return 1 / x * myPow(1 / x, -(n + 1));
        if (n == 0)
            return 1;
        if (n == 2)
            return x * x;
        if (n % 2 == 0)
            return myPow(myPow(x, n / 2), 2);
        return x * myPow(myPow(x, n / 2), 2);
    }

    public static void main(String[] args) {
        Solution_Pow s = new Solution_Pow();
        System.out.println(Math.pow(2.3, 5) + " " + s.myPow(2.3, 5));
    }
}
