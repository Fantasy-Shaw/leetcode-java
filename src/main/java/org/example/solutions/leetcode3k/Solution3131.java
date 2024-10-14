package org.example.solutions.leetcode3k;

import java.util.HashMap;
import java.util.Map;

public class Solution3131 {
    class Solution {
        public int addedInteger(int[] nums1, int[] nums2) {
            int n = nums1.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int x : nums1) {
                for (int y : nums2) {
                    map.merge(y - x, 1, Integer::sum);
                }
            }
            int mx = -1, ans = -1;
            for (var p : map.entrySet()) {
                if (p.getValue() > mx) {
                    mx = p.getValue();
                    ans = p.getKey();
                }
            }
            return ans;
        }
    }
}