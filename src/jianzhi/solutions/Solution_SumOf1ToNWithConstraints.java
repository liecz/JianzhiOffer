package jianzhi.solutions;

/**
 * 求1+2+3+...+n
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * Created by liec on 2017-03-05.
 */
public class Solution_SumOf1ToNWithConstraints {
    public static void main(String[] args) {
        Solution_SumOf1ToNWithConstraints s = new Solution_SumOf1ToNWithConstraints();
        System.out.println(s.Sum_Solution(5));
    }

    /*
    * 利用短路机制控制语句执行
    * */
    public int Sum_Solution(int n) {
        int ans = n;
        boolean b = ans != 0 && (ans += Sum_Solution(n - 1)) > 0;
        return ans;
    }
}
