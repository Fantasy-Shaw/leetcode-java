package org.example.solutions.leetcode501to1k;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution638 {
    static
    class Solution {
        private static final int mask = 0xF;
        int n;

        public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            int[] p = price.stream().mapToInt(i -> i).toArray();
            n = p.length;
            List<List<Integer>> sps = new ArrayList<>();
            for (var sp : special) {
                int cur = 0;
                for (int i = 0; i < n; i++) {
                    cur += p[i] * needs.get(i);
                }
                if (cur > 0 && sp.getLast() < cur) {
                    sps.add(sp);
                }
            }
            int nd = 0;
            for (int i = 0; i < n; i++) {
                nd |= needs.get(i) << (i << 2);
            }
            Map<Integer, Integer> memo = new HashMap<>();
            return dfs(p, sps, nd, memo);
        }

        private int dfs(int[] price, List<List<Integer>> sps, int needs, Map<Integer, Integer> memo) {
            if (needs == 0) {
                return 0;
            }
            if (memo.containsKey(needs)) {
                return memo.get(needs);
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int need = (needs >> (i << 2)) & mask;
                ans += price[i] * need;
            }
            checkSp:
            for (var sp : sps) {
                int nextNeeds = 0;
                for (int i = 0; i < n; i++) {
                    int need = (int) ((needs >> (i << 2)) & mask);
                    int fromSp = sp.get(i);
                    if (fromSp > need) {
                        continue checkSp;
                    }
                    nextNeeds |= (need - fromSp) << (i << 2);
                }
                ans = Math.min(ans, dfs(price, sps, nextNeeds, memo) + sp.getLast());
            }
            memo.put(needs, ans);
            return ans;
        }
    }
}