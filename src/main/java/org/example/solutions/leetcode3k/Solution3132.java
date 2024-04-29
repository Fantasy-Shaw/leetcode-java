package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3132 {
    class Solution {
        public int minimumAddedInteger(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            Map<Integer, Integer> cnt = new HashMap<>();
            int mx = -1, ans = -1;
            for (int i = 0; i < nums1.length; i++) {
                for (int j = i + 1; j < nums1.length; j++) {
                    cnt.clear();
                    for (int k = 0, d = 0; k < nums2.length; ) {
                        if (k + d == i || k + d == j) {
                            d++;
                            continue;
                        }
                        cnt.merge(nums2[k] - nums1[k + d], 1, Integer::sum);
                        k++;
                    }
                    for (var p : cnt.entrySet()) {
                        if (p.getValue() > mx || (p.getValue() == mx && p.getKey() < ans)) {
                            mx = p.getValue();
                            ans = p.getKey();
                        }
                    }
                }
            }
            return ans;
        }
    }
}