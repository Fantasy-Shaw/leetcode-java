package org.example.solutions.leetcode1to200;

import java.util.*;

public class Solution229 {
    class Solution {
        public List<Integer> majorityElement(int[] nums) {
            Map<Integer, Integer> hashMap = new HashMap<>();
            for (int n : nums) {
                hashMap.put(n, hashMap.getOrDefault(n, 0) + 1);
            }
            int target = nums.length / 3;
            List<Integer> ans = new ArrayList<>();
            for (var kv : hashMap.entrySet()) {
                if (kv.getValue() > target) {
                    ans.add(kv.getKey());
                }
            }
            return ans;
        }
    }
}