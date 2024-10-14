package org.example.solutions.leetcode501to1k;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution763 {
    class Solution {
        public List<Integer> partitionLabels(String s) {
            int n = s.length();
            int[] start = new int[26], end = new int[26];
            Arrays.fill(start, n);
            Arrays.fill(end, -1);
            for (int i = 0; i < n; i++) {
                int u = s.charAt(i) - 'a';
                start[u] = Math.min(start[u], i);
                end[u] = Math.max(end[u], i);
            }
            List<Integer> ans = new ArrayList<>();
            int l = 0, r = 0;
            for (int i = 0; i < n; i++) {
                r = Math.max(r, end[s.charAt(i) - 'a']);
                if (i == r) {
                    ans.add(r - l + 1);
                    l = r + 1;
                }
            }
            return ans;
        }
    }
}