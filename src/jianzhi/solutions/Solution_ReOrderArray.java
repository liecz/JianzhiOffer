package jianzhi.solutions;

/**
 * Created by liec on 17-2-9.
 */
public class Solution_ReOrderArray {

    public static void main(String[] args) {
        Solution_ReOrderArray s = new Solution_ReOrderArray();
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        s.reOrderArray(a);
        System.out.println(a);
    }

    public void reOrderArray(int[] array) {
        int i = -1, j = 0, size = array.length;
        while (j < size) {
            if (array[j] % 2 != 0) {
                int c = j - 1, val = array[j];
                // 向后复制
                while (c > i) {
                    array[c + 1] = array[c];
                    c--;
                }
                array[i + 1] = val;
                i++;
            }
            j++;
        }
    }
}
