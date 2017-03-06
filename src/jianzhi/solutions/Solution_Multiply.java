package jianzhi.solutions;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * Created by liec on 2017-02-23.
 */
public class Solution_Multiply {
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int[] B = new int[A.length];
        B[0] = 1;
        // 先求下三角，动态规划，本次求得的值依赖上一次结果
        // 即B[i] = B[i-1] * A[i-1] = (A[0]*A[1]*...*A[i-2])*A[i-1]
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        // 此时的值为：
        // b0 =  1
        // b1 =  a0
        // b2 =  a0 * a1
        // b3 =  a0 * a1 * a2
        // ......
        // bn-1 = a0 * a1 * a2 * ... * an-1
        // 从bn-2开始，tmp的值如下：
        // tmp = an-1                          bn-2 *= tmp
        // tmp = an-1 * an-2                   bn-3 *= tmp
        // tmp = an-1 * an-2 * an-3
        // ......
        // tmp = an-1 * an-2 * an-3 * ... * a1   b0 *= tmp
        int tmp = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            tmp *= A[i + 1];
            B[i] *= tmp;
        }
        return B;
    }
}
