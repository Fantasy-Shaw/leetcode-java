package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1172 {
    class DinnerPlates {
        TreeSet<Integer> notFull;
        List<Deque<Integer>> stacks;
        int capacity;

        public DinnerPlates(int capacity) {
            this.capacity = capacity;
            notFull = new TreeSet<>();
            stacks = new ArrayList<>();
        }

        public void push(int val) {
            if (!notFull.isEmpty() && notFull.first() >= stacks.size()) {
                notFull.clear();
            }
            if (notFull.isEmpty()) {
                Deque<Integer> st = new ArrayDeque<>();
                st.push(val);
                stacks.add(st);
                if (st.size() < capacity) {
                    notFull.add(stacks.size() - 1);
                }
            } else {
                var st = stacks.get(notFull.first());
                st.push(val);
                if (st.size() == capacity) {
                    notFull.pollFirst();
                }
            }
        }

        public int pop() {
            return popAtStack(stacks.size() - 1);
        }

        public int popAtStack(int index) {
            if (index < 0 || index >= stacks.size()) {
                return -1;
            }
            var st = stacks.get(index);
            if (st.isEmpty()) {
                return -1;
            }
            int ans = st.pop();
            notFull.add(index);
            while (!stacks.isEmpty() && stacks.getLast().isEmpty()) {
                stacks.removeLast();
            }
            return ans;
        }
    }
}