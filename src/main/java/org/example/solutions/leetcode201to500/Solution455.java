package org.example.solutions.leetcode201to500;

import java.util.Arrays;

public class Solution455 {
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int ans = 0;
            for (int i = 0, j = 0; i < g.length && j < s.length; ) {
                if (g[i] <= s[j]) {
                    ans++;
                    i++;
                }
                j++;
            }
            return ans;
        }
    }
}