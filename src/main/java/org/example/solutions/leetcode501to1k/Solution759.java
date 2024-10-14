package org.example.solutions.leetcode501to1k;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution759 {
    static class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

    class Solution {
        public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
            List<Interval> intervals = new ArrayList<>();
            for (var list : schedule) {
                intervals.addAll(list);
            }
            intervals.sort(Comparator.comparingInt(o -> o.start));
            List<Interval> mergedIntervals = new ArrayList<>();
            for (var it : intervals) {
                if (mergedIntervals.isEmpty() || it.start > mergedIntervals.getLast().end) {
                    mergedIntervals.add(it);
                } else {
                    var x = mergedIntervals.removeLast();
                    mergedIntervals.add(new Interval(Math.min(x.start, it.start), Math.max(x.end, it.end)));
                }
            }
            List<Interval> ans = new ArrayList<>();
            for (int i = 1; i < mergedIntervals.size(); i++) {
                ans.add(new Interval(mergedIntervals.get(i - 1).end, mergedIntervals.get(i).start));
            }
            return ans;
        }
    }
}