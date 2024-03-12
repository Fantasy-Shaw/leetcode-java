package org.example.solutions.leetcode1to200;

import java.util.*;

public class Solution77 {
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> cur = new ArrayList<>();
            dfs(n, k, 1, ans, cur);
            return ans;
        }

        private void dfs(int n, int k, int i, List<List<Integer>> ans, List<Integer> cur) {
            if (cur.size() == k) {
                ans.add(new ArrayList<>(cur));
                return;
            }
            if (i == n + 1 || cur.size() > k) {
                return;
            }
            cur.add(i);
            dfs(n, k, i + 1, ans, cur);
            cur.removeLast();
            dfs(n, k, i + 1, ans, cur);
        }
    }

    class Solution1 {
        private List<Integer> temp;
        private List<List<Integer>> ans;
        private int n, k;

        public List<List<Integer>> combine(int n, int k) {
            temp = new ArrayList<>();
            ans = new ArrayList<>();
            this.n = n;
            this.k = k;
            this.dfs(1);
            return ans;
        }

        private void dfs(int cur) {
            if (temp.size() + n - cur + 1 < k) return;
            if (temp.size() == k) {
                ans.add(new ArrayList<>(temp));
                return;
            }
            temp.add(cur);
            dfs(cur + 1);
            temp.removeLast();
            dfs(cur + 1);
        }
    }
}