package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution946 {
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Deque<Integer> st = new ArrayDeque<>();
            for (int i = 0, j = 0; i < pushed.length; i++) {
                st.push(pushed[i]);
                while (!st.isEmpty() && st.peek() == popped[j]) {
                    st.pop();
                    j++;
                }
            }
            return st.isEmpty();
        }
    }
}