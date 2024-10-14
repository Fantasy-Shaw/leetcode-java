package org.example.solutions.leetcode501to1k;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution735 {
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Deque<Integer> st = new ArrayDeque<>();
            for (int i : asteroids) {
                if (st.isEmpty() || st.peekLast() * i > 0) {
                    st.offerLast(i);
                } else {
                    int n = i;
                    while (!st.isEmpty()) {
                        if (st.peekLast() * n >= 0 || st.peekLast() < 0) {
                            break;
                        } else {
                            int m = st.pollLast();
                            n = Math.abs(m) == Math.abs(n) ? 0 : (Math.abs(m) > Math.abs(n) ? m : n);
                        }
                    }
                    if (n != 0) {
                        st.offerLast(n);
                    }
                }
            }
            return st.stream().mapToInt(i -> i).toArray();
        }
    }
}