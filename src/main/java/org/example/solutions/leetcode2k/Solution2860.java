package org.example.solutions.leetcode2k;

import java.util.Arrays;
import java.util.List;

public class Solution2860 {
    class Solution {
        public int countWays(List<Integer> nums) {
            int[] arr = nums.stream().mapToInt(Integer::intValue).toArray();
            int n = arr.length;
            Arrays.sort(arr);
            int ans = arr[0] > 0 ? 1 : 0;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] < i && i < arr[i]) {
                    ans++;
                }
            }
            ans += 1;
            return ans;
        }
    }
}