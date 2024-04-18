package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution899 {
    class Solution {
        public String orderlyQueue(String s, int k) {
            char[] cs = s.toCharArray();
            int n = s.length();
            if (k > 1) {
                Arrays.sort(cs);
                return new String(cs);
            }
            String ans = s;
            for (int i = 1; i < n; i++) {
                String cur = s.substring(i) + s.substring(0, i);
                if (cur.compareTo(ans) < 0) {
                    ans = cur;
                }
            }
            return ans;
        }
    }
}