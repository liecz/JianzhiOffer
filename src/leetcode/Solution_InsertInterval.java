package leetcode;

import leetcode.utill.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * 57. Insert Interval
 * https://leetcode.com/problems/insert-interval/#/description
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * Created by liec on 2017-03-17.
 */
public class Solution_InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>(intervals.size() + 1);
        int i = 0;
        Interval intv;
        // 将所有小于newInterval的元素添加到结果中
        while (i < intervals.size() && (intv = intervals.get(i)).end < newInterval.start) {
            res.add(intv);
            i++;
        }
        // 合并包含newInterval的所有元素
        while (i < intervals.size() && (intv = intervals.get(i)).start <= newInterval.end) {
            newInterval.start = Math.min(newInterval.start, intv.start);
            newInterval.end = Math.max(newInterval.end, intv.end);
            i++;
        }
        res.add(newInterval);
        // 添加剩下的元素到结果中
        while (i < intervals.size()) {
            res.add(intervals.get(i++));
        }
        return res;
    }

    public static void main(String[] args) {
        Interval a = new Interval(1, 5);
        Interval b = new Interval(2, 3);
        List<Interval> list = new ArrayList<>();
        list.add(a);
        Solution_InsertInterval s = new Solution_InsertInterval();
        List<Interval> res = s.insert(list, b);
        System.out.println("res = " + res);
    }
}
