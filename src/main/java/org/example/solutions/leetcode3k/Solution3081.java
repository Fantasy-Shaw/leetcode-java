package org.example.solutions.leetcode3k;

import java.util.ArrayList;
import java.util.List;

public class Solution3081 {
    class Solution {
        public String minimizeStringValue(String s) {
            int n = s.length();
            int[] cost = new int[26];
            int[][] cnt = new int[n + 1][26];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 26; j++) {
                    cnt[i + 1][j] = cnt[i][j];
                }
                if (s.charAt(i) != '?') {
                    cnt[i + 1][s.charAt(i) - 'a']++;
                }
            }
            StringBuilder ans = new StringBuilder();
            List<Character> chs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (ch != '?') {
                    cost[ch - 'a']++;
                } else {
                    int mn = Integer.MAX_VALUE;
                    char c = '!';
                    for (int j = 0; j < 26; j++) {
                        int t = cost[j] + cnt[n][j] - cnt[i][j];
                        if (t < mn) {
                            mn = t;
                            c = (char) ('a' + j);
                        }
                    }
                    cost[c - 'a']++;
                    chs.add(c);
                }
            }
            chs.sort((a, b) -> a - b);
            int j = 0;
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (ch == '?') {
                    ans.append(chs.get(j));
                    j++;
                } else {
                    ans.append(ch);
                }
            }
            return ans.toString();
        }
    }
}