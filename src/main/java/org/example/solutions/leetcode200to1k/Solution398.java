package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution398 {
    class Solution {
        private Random rd;
        private Map<Integer, List<Integer>> map;

        public Solution(int[] nums) {
            rd = new Random();
            map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                map.putIfAbsent(nums[i], new ArrayList<>());
                map.get(nums[i]).add(i);
            }
        }

        public int pick(int target) {
            List<Integer> list = map.get(target);
            return list.get(rd.nextInt(list.size()));
        }
    }

    class Solution1 {
        private Random rd;
        private int[] nums;

        public Solution1(int[] nums) {
            rd = new Random();
            this.nums = nums;
        }

        public int pick(int target) {
            int ans = 0;
            for (int i = 0, cnt = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    cnt++;
                    if (rd.nextInt(cnt) == 0) ans = i;
                }
            }
            return ans;
        }
    }
}