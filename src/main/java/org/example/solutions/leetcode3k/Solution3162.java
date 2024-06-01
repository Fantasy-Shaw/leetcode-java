package org.example.solutions.leetcode3k;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3162 {
    class Solution {
        public int numberOfPairs(int[] nums1, int[] nums2, int k) {
            Map<Integer, Integer> map1 = new HashMap<>();
            Map<Integer, Integer> map2 = new HashMap<>();
            int n = nums1.length, m = nums2.length;
            for (int i = 0; i < n; i++) {
                if (nums1[i] % k == 0) {
                    int x = nums1[i] / k;
                    map1.merge(x, 1, Integer::sum);
                }
            }
            for (int i = 0; i < m; i++) {
                map2.merge(nums2[i], 1, Integer::sum);
            }
            long ans = 0;
            for (var p : map1.entrySet()) {
                int x = p.getKey(), t = p.getValue();
                Set<Integer> vis = new HashSet<>();
                for (int i = 1; i * i <= x; i++) {
                    if (x % i == 0) {
                        if (!vis.contains(i) && map2.containsKey(i)) {
                            vis.add(i);
                            ans += (long) t * map2.get(i);
                        }
                        int y = x / i;
                        if (!vis.contains(y) && map2.containsKey(y)) {
                            vis.add(y);
                            ans += (long) t * map2.get(y);
                        }
                    }
                }
            }
            return (int) ans;
        }
    }
}