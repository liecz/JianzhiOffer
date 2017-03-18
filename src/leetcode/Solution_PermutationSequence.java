package leetcode;

import java.util.LinkedList;

/**
 * 60. Permutation Sequence
 * https://leetcode.com/problems/permutation-sequence/#/description
 * https://discuss.leetcode.com/topic/17348/explain-like-i-m-five-java-solution-in-o-n
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Created by liec on 2017-03-18.
 */
public class Solution_PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        // factorial[0-n] = {1,1,2,6,24,120,...,n!}
        for (int i = 1, sum = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }
        // 将1,2,...,n添加到数组中
        LinkedList<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            numbers.add(i);
        StringBuilder sb = new StringBuilder();
        // k-1 用k来表示数组的index
        k--;
        // 寻找n个数，i表示处理第i位数
        for (int i = 1, index; i <= n; i++) {
            // 已知n个数的全排列有n!种可能，那么有1+{全排列2...n}, 2+{13...n}, ... ,n+{1...n-1}共n!种可能
            //                                   n-1个数，(n-1)!种组合
            // k / (n-1) 得到第一位数
            index = k / factorial[n - i];
            sb.append(numbers.get(index));
            numbers.remove(index);
            // k原本是n个数的范围，让k落在n-1数的范围中
            k = k - index * factorial[n - i];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution_PermutationSequence s = new Solution_PermutationSequence();
        String r = s.getPermutation(3, 2);
        System.out.println("r = " + r);
    }
}
