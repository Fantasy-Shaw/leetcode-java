package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution482 {
    class Solution {
        public String licenseKeyFormatting(String s, int k) {
            Queue<Character> qu = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (Objects.equals(ch, '-')) continue;
                else {
                    if ('a' <= ch && ch <= 'z') ch = (char) (ch - 'a' + 'A');
                    qu.offer(ch);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0, firstGroupSz = qu.size() % k; i < firstGroupSz; i++) {
                sb.append(qu.poll());
            }
            if (qu.isEmpty()) {
                return sb.toString();
            } else if (!sb.isEmpty()) {
                sb.append('-');
            }
            while (!qu.isEmpty()) {
                sb.append(qu.poll());
                if (!qu.isEmpty() && qu.size() % k == 0) sb.append('-');
            }
            return sb.toString();
        }
    }
}