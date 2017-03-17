package leetcode.utill;

/**
 * Created by liec on 2017-03-17.
 */
public class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "Intv{" + start + " , " + end + '}';
    }
}
