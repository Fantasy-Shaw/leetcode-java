package org.example.solutions.leetcode1to200;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution150 {
    class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> st = new ArrayDeque<>();
            for (var tk : tokens) {
                if (Character.isDigit(tk.charAt(tk.length() - 1))) {
                    st.push(Integer.parseInt(tk));
                } else {
                    int b = st.pop();
                    int a = st.pop();
                    if (tk.equals("+")) {
                        st.push(a + b);
                    } else if (tk.equals("-")) {
                        st.push(a - b);
                    } else if (tk.equals("*")) {
                        st.push(a * b);
                    } else {
                        st.push(a / b);
                    }
                }
            }
            return st.isEmpty() ? 0 : st.peek();
        }
    }
}