package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2905 {
    class Solution {
        public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
            int n = nums.length;
            TreeSet<Integer> set = new TreeSet<>(Comparator.comparingInt(a -> nums[a]));
            for (int i = indexDifference; i < n; i++) {
                set.add(i);
            }
            for (int i = 0; i < n; i++) {
                if (!set.isEmpty() && Math.abs(nums[i] - nums[set.first()]) >= valueDifference) {
                    return new int[]{i, set.first()};
                }
                if (!set.isEmpty() && Math.abs(nums[i] - nums[set.last()]) >= valueDifference) {
                    return new int[]{i, set.last()};
                }
                int l = i - indexDifference, r = i + indexDifference;
                if (isValid(l, n)) set.remove(l);
                if (isValid(r, n)) set.remove(r);
                if (isValid(l + 1, n)) set.add(l + 1);
                if (isValid(r + 1, n)) set.add(r + 1);
            }
            return new int[]{-1, -1};
        }

        private static boolean isValid(int x, int n) {
            return x >= 0 && x < n;
        }
    }
}