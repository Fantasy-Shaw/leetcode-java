package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3092 {
    /**
     * [2,3,2,5,6]
     * [2,2,-2,2,1]
     *
     * [2,2,0,2,2]
     *
     * [2,3,2,5,6]
     * [2,2,-2,2,1]
     *
     * [2,2,2,2,2]
     */
    class Solution {
        public long[] mostFrequentIDs(int[] nums, int[] freq) {
            Map<Integer, Long> map = new HashMap<>();
            TreeMap<Long, Set<Integer>> treeMap = new TreeMap<>();
            int n = nums.length;
            long[] ans = new long[n];
            for (int i = 0; i < n; i++) {
                if (map.containsKey(nums[i])) {
                    long f = map.get(nums[i]);
                    var set = treeMap.get(f);
                    set.remove(nums[i]);
                    if (set.isEmpty()) {
                        treeMap.remove(f);
                    }
                }
                long f = map.getOrDefault(nums[i], 0L) + freq[i];
                if (f == 0) {
                    map.remove(nums[i]);
                } else {
                    map.put(nums[i], f);
                    treeMap.putIfAbsent(f, new HashSet<>());
                    treeMap.get(f).add(nums[i]);
                }
                ans[i] = treeMap.isEmpty() ? 0 : treeMap.lastKey();
            }
            return ans;
        }
    }
}