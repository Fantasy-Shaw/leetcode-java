package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution381 {
    class RandomizedSet {
        List<Integer> nums;
        Map<Integer, Integer> indices;

        public RandomizedSet() {
            nums = new ArrayList<>();
            indices = new HashMap<>();
        }

        public boolean insert(int val) {
            if (indices.containsKey(val)) {
                return false;
            }
            indices.put(val, nums.size());
            nums.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!indices.containsKey(val)) {
                return false;
            }
            int idx = indices.get(val);
            indices.put(nums.getLast(), idx);
            nums.set(idx, nums.getLast());
            nums.removeLast();
            indices.remove(val);
            return true;
        }

        public int getRandom() {
            return nums.get((int) (nums.size() * Math.random()));
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}