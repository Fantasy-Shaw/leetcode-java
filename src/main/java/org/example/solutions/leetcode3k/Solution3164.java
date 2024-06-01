package org.example.solutions.leetcode3k;

import java.util.HashMap;
import java.util.Map;

public class Solution3164 {
    class Solution {
        public long numberOfPairs(int[] nums1, int[] nums2, int k) {
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
                int i = 1;
                for (; i * i < x; i++) {
                    if (x % i == 0) {
                        ans += (long) t * map2.getOrDefault(i, 0);
                        ans += (long) t * map2.getOrDefault(x / i, 0);
                    }
                }
                if (i * i == x) {
                    ans += (long) t * map2.getOrDefault(i, 0);
                }
            }
            return ans;
        }
    }
}