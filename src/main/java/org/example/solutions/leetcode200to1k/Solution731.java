package org.example.solutions.leetcode200to1k;

import org.example.templates.SegNodeForAccumVal;

public class Solution731 {
    class MyCalendarTwo {
        private SegNodeForAccumVal root;
        private static final int mn = 0, mx = (int) 1e9;

        public MyCalendarTwo() {
            root = new SegNodeForAccumVal();
        }

        public boolean book(int start, int end) {
            if (SegNodeForAccumVal.query(root, mn, mx, start, end - 1) >= 2) return false;
            SegNodeForAccumVal.update(root, mn, mx, start, end - 1, 1);
            return true;
        }
    }
}