package org.example.solutions.contest;

import java.util.*;

public class S100150 {
    class Solution {
        public int maximumSetSize(int[] nums1, int[] nums2) {
            Set<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
            for (int x : nums1) {
                set1.add(x);
            }
            for (int x : nums2) {
                set2.add(x);
            }
            Set<Integer> common = new HashSet<>(set1);
            common.retainAll(set2);
            int commonSize = common.size();
            int n1 = set1.size(), n2 = set2.size();
            int ans = n1 + n2 - commonSize;
            int m = nums1.length / 2;
            if (n1 > m) {
                int mn = Math.min(commonSize, n1 - m);
                ans -= (n1 - mn - m);
                commonSize -= mn;
            }
            if (n2 > m) {
                int mn = Math.min(commonSize, n2 - m);
                ans -= (n2 - mn - m);
            }
            return ans;
        }
    }
}