package org.example.solutions.leetcode200to1k;

import org.example.templates.SegNodeForAccumulatedVal;


public class Solution729 {
    class MyCalendar {
        private SegNodeForAccumulatedVal root;
        private static final int mn = 0, mx = (int) 1e9;

        public MyCalendar() {
            root = new SegNodeForAccumulatedVal();
        }

        public boolean book(int start, int end) {
            if (SegNodeForAccumulatedVal.query(root, mn, mx, start, end - 1) >= 1) return false;
            SegNodeForAccumulatedVal.update(root, mn, mx, start, end - 1, 1);
            return true;
        }
    }

}