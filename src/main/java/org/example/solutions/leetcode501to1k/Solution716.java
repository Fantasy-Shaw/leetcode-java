package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution716 {
    class MaxStack {
        private TreeSet<int[]> st, vals;
        private int cnt;

        public MaxStack() {
            st = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            vals = new TreeSet<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
            cnt = 0;
        }

        public void push(int x) {
            int[] pair = new int[]{cnt, x};
            st.add(pair);
            vals.add(pair);
            cnt++;
        }

        public int pop() {
            int[] pair = st.pollLast();
            vals.remove(pair);
            return pair[1];
        }

        public int top() {
            return st.last()[1];
        }

        public int peekMax() {
            return vals.last()[1];
        }

        public int popMax() {
            int[] pair = vals.pollLast();
            st.remove(pair);
            return pair[1];
        }
    }
}