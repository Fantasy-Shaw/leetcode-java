package org.example.solutions.leetcode501to1k;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Solution870 {
    class Solution {
        // int[2]: [num,idx]
        static Comparator<int[]> cmp = (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];

        public int[] advantageCount(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            int n = nums1.length;
            int[] ans = new int[n];
            TreeSet<int[]> set2 = new TreeSet<>(cmp);
            for (int i = 0; i < n; i++) {
                set2.add(new int[]{nums2[i], i});
            }
            for (int cur : nums1) {
                if (cur > set2.first()[0]) {
                    ans[set2.first()[1]] = cur;
                    set2.pollFirst();
                } else {
                    ans[set2.last()[1]] = cur;
                    set2.pollLast();
                }
            }
            return ans;
        }
    }
}