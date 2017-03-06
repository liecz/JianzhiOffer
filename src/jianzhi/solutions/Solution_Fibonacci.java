package jianzhi.solutions;

/**
 * Created by liec on 17-2-8.
 */
public class Solution_Fibonacci {
    public static void main(String[] args) {
        Solution_Fibonacci s = new Solution_Fibonacci();

        for (int i = 0; i < 39; i++) {
            System.out.print(s.Fibonacci(i) + " ");
        }
    }

    public int Fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int ni_2 = 0;
        int ni_1 = 1;
        int ni = 0;
        for (int i = 2; i <= n; i++) {
            ni = ni_1 + ni_2;
            ni_2 = ni_1;
            ni_1 = ni;
        }
        return ni;
    }
}
