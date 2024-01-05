package org.example.solutions.leetcode1kto2k;

import org.example.templates.StringHash;

import java.util.*;

public class Solution1316 {
    class Solution {
        public int distinctEchoSubstrings(String text) {
            StringHash hash = new StringHash(text);
            int n = text.length();
            List<Set<Long>> vis = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                vis.add(new HashSet<>());
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int len = j - i;
                    if (j + len <= n) {
                        long h = hash.getSubStrHash(i, j);
                        if (!vis.get(len).contains(h) && h == hash.getSubStrHash(j, j + len)) {
                            ans++;
                            vis.get(len).add(h);
                        }
                    }
                }
            }
            return ans;
        }
    }
}