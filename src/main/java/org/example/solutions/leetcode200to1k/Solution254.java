package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution254 {
    class Solution {
        public List<List<Integer>> getFactors(int n) {
            return dfs(2, n);
        }

        private List<List<Integer>> dfs(int start, int num) {
            if (num == 1) {
                return new ArrayList<>();
            }
            int q = (int) Math.sqrt(num);
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = start; i <= q; i++) {
                if (num % i == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(num / i);
                    ans.add(list);
                    var next = dfs(i, num / i);
                    for (var l : next) {
                        l.add(i);
                        ans.add(l);
                    }
                }
            }
            return ans;
        }
    }
}