package org.example.solutions.leetcode2k;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2808 {
    class Solution {
        public int minimumSeconds(List<Integer> nums) {
            int n = nums.size();
            Map<Integer, List<Integer>> map = new HashMap<>(n);
            for (int i = 0; i < n; i++) {
                map.putIfAbsent(nums.get(i), new ArrayList<>());
                map.get(nums.get(i)).add(i);
            }
            int ans = n;
            for (var p : map.entrySet()) {
                var v = p.getValue();
                v.add(v.getFirst() + n);
                int mx = -1;
                for (int i = 1; i < v.size(); i++) {
                    mx = Math.max(mx, (v.get(i) - v.get(i - 1)) / 2);
                }
                ans = Math.min(ans, mx);
            }
            return ans;
        }
    }
}