package org.example.solutions.leetcode501to1k;

import org.example.templates.SegNodeForAccumVal;

import java.util.Comparator;
import java.util.TreeSet;


public class Solution729 {
    class MyCalendar1 {
        private SegNodeForAccumVal root;
        private static final int mn = 0, mx = (int) 1e9;

        public MyCalendar1() {
            root = new SegNodeForAccumVal();
        }

        public boolean book(int start, int end) {
            if (SegNodeForAccumVal.query(root, mn, mx, start, end - 1) >= 1) return false;
            SegNodeForAccumVal.update(root, mn, mx, start, end - 1, 1);
            return true;
        }
    }

}

class MyCalendar {
    TreeSet<int[]> set;

    public MyCalendar() {
        set = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
    }

    public boolean book(int start, int end) {
        if (set.isEmpty()) {
            set.add(new int[]{start, end});
            return true;
        }
        int[] tmp = new int[]{end, 0};
        int[] lower = set.lower(tmp); // 小于tmp的最大值
        if (lower == null || lower[1] <= start) {
            set.add(new int[]{start, end});
            return true;
        }
        return false;
    }
}