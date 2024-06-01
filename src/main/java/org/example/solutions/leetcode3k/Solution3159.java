package org.example.solutions.leetcode3k;

import java.util.ArrayList;
import java.util.List;

public class Solution3159 {
    class Solution {
        public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == x) {
                    list.add(i);
                }
            }
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int q = queries[i] - 1;
                ans[i] = q < list.size() ? list.get(q) : -1;
            }
            return ans;
        }
    }
}