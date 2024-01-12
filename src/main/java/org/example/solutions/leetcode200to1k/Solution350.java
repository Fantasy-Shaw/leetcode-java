package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution350 {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            List<Integer> ans = new ArrayList<>();
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int i = 0, j = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] == nums2[j]) {
                    ans.add(nums1[i]);
                    i++;
                    j++;
                } else if (nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }
            }
            return ans.stream().mapToInt(val -> val).toArray();
        }
    }
}