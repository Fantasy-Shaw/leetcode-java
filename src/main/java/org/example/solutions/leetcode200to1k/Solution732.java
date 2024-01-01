package org.example.solutions.leetcode200to1k;

import org.example.templates.SegNodeForAccumVal;

public class Solution732 {
    class MyCalendarThree {
        private SegNodeForAccumVal root;
        private static final int mn = 1, mx = (int) 1e9 + 1;

        public MyCalendarThree() {
            root = new SegNodeForAccumVal();
        }

        public int book(int startTime, int endTime) {
            SegNodeForAccumVal.update(root, mn, mx, startTime + 1, endTime, 1);
            return SegNodeForAccumVal.query(root, mn, mx, mn, mx);
        }
    }
}