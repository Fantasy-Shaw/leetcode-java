package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution267 {
    class Solution {
        private int[] map;
        private List<String> ans;
        private int n;

        public List<String> generatePalindromes(String s) {
            map = new int[128];
            n = s.length();
            for (char ch : s.toCharArray()) {
                map[ch]++;
            }
            char ch_odd = '\0';
            for (int i = 'a'; i <= 'z'; i++) {
                if (map[i] == 0) continue;
                if (map[i] % 2 == 1) {
                    if (ch_odd == '\0') {
                        ch_odd = (char) i;
                        map[i]--;
                    } else {
                        return new ArrayList<>();
                    }
                }
            }
            ans = new ArrayList<>();
            dfs(ch_odd == '\0' ? "" : String.valueOf(ch_odd));
            return ans;
        }

        private void dfs(String cur) {
            if (cur.length() == n) {
                ans.add(cur);
                return;
            }
            for (int i = 'a'; i <= 'z'; i++) {
                if (map[i] != 0) {
                    map[i] -= 2;
                    dfs((char) i + cur + (char) i);
                    map[i] += 2;
                }
            }
        }
    }
}