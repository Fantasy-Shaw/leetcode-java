package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3085 {
    class Solution {
        public int minimumDeletions(String word, int k) {
            int n = word.length();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                map.merge(ch, 1, Integer::sum);
            }
            List<int[]> list = new ArrayList<>();
            for (var p : map.entrySet()) {
                list.add(new int[]{p.getKey(), p.getValue()});
            }
            list.sort((a, b) -> a[1] - b[1]);
            int m = list.size();
            int[][] memo = new int[m][m];
            for (var it : memo) {
                Arrays.fill(it, -1);
            }
            return dfs(list, 0, m - 1, k, memo);
        }

        private int dfs(List<int[]> list, int i, int j, int k, int[][] memo) {
            if (i >= j) {
                return 0;
            }
            if (list.get(j)[1] - list.get(i)[1] <= k) {
                return 0;
            }
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            int a = list.get(j)[1] - list.get(i)[1] - k;
            int b = list.get(i)[1];
            int ans = Math.min(
                    a + dfs(list, i, j - 1, k, memo),
                    b + dfs(list, i + 1, j, k, memo)
            );
            memo[i][j] = ans;
            return ans;
        }
    }
}