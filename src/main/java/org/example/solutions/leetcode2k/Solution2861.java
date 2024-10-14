package org.example.solutions.leetcode2k;

import java.util.Collections;
import java.util.List;

public class Solution2861 {
    class Solution {
        public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
            // upper_bound的前一个
            int ans = 0, mx = Collections.min(stock) + budget;
            for (var cps : composition) {
                int l = ans, r = mx + 1;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    boolean flag = true;
                    long money = 0;
                    for (int i = 0; i < n; i++) {
                        if (stock.get(i) < (long) cps.get(i) * mid) {
                            money += ((long) cps.get(i) * mid - stock.get(i)) * cost.get(i);
                            if (money > budget) {
                                flag = false;
                                break;
                            }
                        }
                    }
                    if (flag) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                ans = l;
            }
            return ans - 1;
        }
    }
}