package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2207 {
    class Solution {
        public long maximumSubsequenceCount(String text, String pattern) {
            char[] p = pattern.toCharArray();
            char[] x = (p[0] + text).toCharArray();
            if (p[0] == p[1]) {
                int cnt = 0;
                for (char c : x) {
                    if (c == x[0]) {
                        cnt++;
                    }
                }
                return (long) cnt * (cnt - 1) / 2;
            }
            char[] y = (text + p[1]).toCharArray();
            return Math.max(match(x, p), match(y, p));
        }

        private static long match(char[] text, char[] p) {
            long ans = 0;
            Deque<Integer> qu = new LinkedList<>();
            for (int i = 0; i < text.length; i++) {
                if (text[i] == p[1]) {
                    qu.offerLast(i);
                }
            }
            for (int i = 0; i < text.length; i++) {
                if (text[i] == p[0]) {
                    while (!qu.isEmpty() && qu.peekFirst() < i) {
                        qu.pollFirst();
                    }
                    ans += qu.size();
                }
            }
            return ans;
        }
    }
}