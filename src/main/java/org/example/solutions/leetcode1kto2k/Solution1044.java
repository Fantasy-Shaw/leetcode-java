package org.example.solutions.leetcode1kto2k;

import org.example.templates.RolliingHash.StringHash;

import java.util.HashSet;
import java.util.Set;


public class Solution1044 {
    class Solution {
        private StringHash hash;

        public String longestDupSubstring(String s) {
            hash = new StringHash(s);
            String ans = "";
            int l = 0, r = s.length() - 1;
            while (l <= r) {
                int mid = (l + r) >> 1;
                String t = check(s, mid);
                if (!t.isEmpty()) l = mid + 1;
                else r = mid - 1;
                if (t.length() > ans.length()) ans = t;
            }
            return ans;
        }

        private String check(String s, int len) {
            int n = s.length();
            Set<Long> set = new HashSet<>();
            for (int i = 0; i <= n - len; i++) {
                int j = i + len;
                long cur = hash.getHash(i, j + 1);
                if (set.contains(cur)) return s.substring(i, j + 1);
                set.add(cur);
            }
            return "";
        }
    }
}