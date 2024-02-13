package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution402 {
    class Solution {
        public String removeKdigits(String num, int k) {
            Deque<Character> monoSt = new ArrayDeque<>();
            int n = num.length();
            for (int i = 0; i < n; i++) {
                char ch = num.charAt(i);
                while (k > 0 && !monoSt.isEmpty() && monoSt.peek() > ch) {
                    monoSt.pop();   // pollFirst
                    k--;
                }
                monoSt.push(ch);
            }
            for (int i = 0; i < k; i++) {
                monoSt.pop();
            }
            StringBuilder ans = new StringBuilder();
            boolean withBeginningZero = true;
            while (!monoSt.isEmpty()) {
                char ch = monoSt.pollLast();
                if (withBeginningZero && ch == '0') continue;
                withBeginningZero = false;
                ans.append(ch);
            }
            return ans.isEmpty() ? "0" : ans.toString();
        }
    }
}