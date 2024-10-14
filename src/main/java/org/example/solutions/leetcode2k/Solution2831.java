package org.example.solutions.leetcode2k;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2831 {
    class Solution {
        public int longestEqualSubarray(List<Integer> nums, int k) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < nums.size(); i++) {
                map.computeIfAbsent(nums.get(i), key -> new ArrayList<>()).add(i);
            }
            int ans = nums.isEmpty() ? 0 : 1;
            for (var p : map.entrySet()) {
                var indices = p.getValue();
                int m = indices.size();
                if (m == 1) {
                    continue;
                }
                int delta = 0;
                for (int i = 0, j = 1; i < m && j < m; j++) {
                    delta += indices.get(j) - indices.get(j - 1) - 1;
                    if (delta <= k) {
                        ans = Math.max(ans, j - i + 1);
                    }
                    while (i < j && delta > k) {
                        delta -= indices.get(i + 1) - indices.get(i) - 1;
                        i++;
                    }
                    if (delta <= k) {
                        ans = Math.max(ans, j - i + 1);
                    }
                }
            }
            return ans;
        }
    }
}