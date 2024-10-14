package org.example.solutions.leetcode501to1k;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution504 {
    class Solution {
        public String convertToBase7(int num) {
            StringBuilder sb = new StringBuilder();
            if (num == 0) {
                sb.append(0);
                return sb.toString();
            }
            if (num < 0) {
                sb.append('-');
                num = -num;
            }
            Deque<Integer> st = new ArrayDeque<>();
            while (num > 0) {
                st.push(num % 7);
                num /= 7;
            }
            while (!st.isEmpty()) {
                sb.append(st.pop());
            }
            return sb.toString();
        }
    }
}