package org.example.solutions.leetcode200to1k;

import org.example.templates.SegNodeForAccumulatedVal;

public class Solution732 {
    class MyCalendarThree {
        private SegNodeForAccumulatedVal root;
        private static final int mn = 1, mx = (int) 1e9 + 1;

        public MyCalendarThree() {
            root = new SegNodeForAccumulatedVal();
        }

        public int book(int startTime, int endTime) {
            SegNodeForAccumulatedVal.update(root, mn, mx, startTime + 1, endTime, 1);
            return SegNodeForAccumulatedVal.query(root, mn, mx, mn, mx);
        }
    }
}