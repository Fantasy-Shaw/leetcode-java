package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution220 {
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
            int n = nums.length;
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                int u = nums[i];
                Integer l = treeSet.floor(u);
                Integer r = treeSet.ceiling(u);
                if (l != null && u - l <= valueDiff) return true;
                if (r != null && r - u <= valueDiff) return true;
                treeSet.add(u);
                if (i >= indexDiff) treeSet.remove(nums[i - indexDiff]);
            }
            return false;
        }
    }
}