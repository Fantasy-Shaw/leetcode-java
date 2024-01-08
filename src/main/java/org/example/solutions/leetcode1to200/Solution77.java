package org.example.solutions.leetcode1to200;

import java.util.*;

public class Solution77 {
    class Solution {
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