package jianzhi.solutions;

/**
 * Created by liec on 17-2-9.
 */
public class Solution_RectCover {

    public int RectCover(int target) {
        if (target == 1 || target == 2) {
            return target;
        }
        int ni_1 = 2, ni_2 = 1;// 2*3 Rects
        int n = 0;
        for (int i = 3; i <= target; i++) {
            n = ni_1 + ni_2;
            ni_2 = ni_1;
            ni_1 = n;
        }
        return n;
    }
}
