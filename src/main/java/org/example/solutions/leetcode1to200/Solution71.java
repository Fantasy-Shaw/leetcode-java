package org.example.solutions.leetcode1to200;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution71 {
    class Solution {
        public String simplifyPath(String path) {
            Deque<String> st = new ArrayDeque<>();
            String[] paths = path.split("/");
            for (String p : paths) {
                if (p.isEmpty() || p.equals(".")) continue;
                else if (p.equals("..")) {
                    if (!st.isEmpty()) {
                        st.pollLast();
                    }
                } else st.offerLast(p);
            }
            StringBuilder res = new StringBuilder();
            while (!st.isEmpty()) {
                res.append('/').append(st.pollFirst());
            }
            return res.isEmpty() ? "/" : res.toString();
        }
    }
}