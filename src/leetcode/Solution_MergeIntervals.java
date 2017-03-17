package leetcode;

import leetcode.utill.Interval;

import java.util.*;

/**
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/#/description
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * Created by liec on 2017-03-17.
 */
public class Solution_MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if (intervals == null || intervals.size() == 0)
            return res;
        // intervals可能是无序的
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        Interval last = intervals.get(0), itv;
        res.add(last);
        for (int i = 1; i < intervals.size(); i++) {
            itv = intervals.get(i);
            if (last.end >= itv.start) {
                // 存在[1,4] [2,3]的情况
                last.end = Math.max(last.end, itv.end);
            } else {
                res.add(itv);
                last = itv;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution_MergeIntervals s = new Solution_MergeIntervals();
        Interval[] a = new Interval[]{
                new Interval(1, 3),
                new Interval(2, 6),
                new Interval(8, 10),
                new Interval(15, 18)
        };
        System.out.println("s = " + s.merge(Arrays.asList(a)));
    }
}
