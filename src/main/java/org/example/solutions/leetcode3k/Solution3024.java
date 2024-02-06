package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3024 {
    class Solution {
        public String triangleType(int[] nums) {
            Arrays.sort(nums);
            if (nums[0] + nums[1] <= nums[2]) {
                return "none";
            }
            if (nums[0] == nums[1] && nums[1] == nums[2]) {
                return "equilateral";
            }
            if (nums[0] == nums[1] || nums[1] == nums[2]) {
                return "isosceles";
            }
            return "scalene";
        }
    }
}