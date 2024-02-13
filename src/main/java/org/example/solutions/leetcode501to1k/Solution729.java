package org.example.solutions.leetcode501to1k;

import org.example.templates.SegNodeForAccumVal;


public class Solution729 {
    class MyCalendar {
        private SegNodeForAccumVal root;
        private static final int mn = 0, mx = (int) 1e9;

        public MyCalendar() {
            root = new SegNodeForAccumVal();
        }

        public boolean book(int start, int end) {
            if (SegNodeForAccumVal.query(root, mn, mx, start, end - 1) >= 1) return false;
            SegNodeForAccumVal.update(root, mn, mx, start, end - 1, 1);
            return true;
        }
    }

}