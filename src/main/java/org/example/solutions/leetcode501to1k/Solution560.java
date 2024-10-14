package org.example.solutions.leetcode501to1k;

import java.util.HashMap;
import java.util.Map;

public class Solution560 {
    class Solution {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int count = 0, pre = 0;
            for (int x : nums) {
                pre += x;
                count += map.getOrDefault(pre - k, 0);
                map.put(pre, 1 + map.getOrDefault(pre, 0));
            }
            return count;
        }
    }
}