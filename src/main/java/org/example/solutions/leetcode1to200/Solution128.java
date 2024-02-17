package org.example.solutions.leetcode1to200;

import java.util.*;

public class Solution128 {
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i : nums) {
                set.add(i);
            }
            int ans = 0;
            for (int i : set) {
                if (!set.contains(i - 1)) { // 避免重复枚举，否则会退化到0(n^2)
                    int cur = i;
                    int curLen = 1;
                    while (set.contains(++cur)) {
                        curLen++;
                    }
                    ans = Math.max(ans, curLen);
                }
            }
            return ans;
        }
    }
}