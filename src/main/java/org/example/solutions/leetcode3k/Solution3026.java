package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3026 {
    class Solution {
        long inf = Long.MAX_VALUE;

        public long maximumSubarraySum(int[] nums, int k) {
            long ans = Long.MIN_VALUE;
            long sum = 0;
            Map<Integer, Long> minS = new HashMap<>();
            for (int x : nums) {
                long s1 = minS.getOrDefault(x - k, inf);
                long s2 = minS.getOrDefault(x + k, inf);
                long s = Math.min(s1, s2);
                if (s != inf) {
                    ans = Math.max(ans, sum + x - s);
                }
                minS.merge(x, sum, Math::min);
                sum += x;
            }
            return ans > Long.MIN_VALUE ? ans : 0;
        }
    }

    class Solution1 {
        public long maximumSubarraySum(int[] nums, int k) {
            int n = nums.length;
            long ans = Long.MIN_VALUE;
            long[] sum = new long[n + 1];
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            HashMap<Integer, int[]> map1 = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.putIfAbsent(nums[i], new ArrayList<>());
                map.get(nums[i]).add(i);
                sum[i + 1] = sum[i] + nums[i];
            }
            for (var p : map.entrySet()) {
                map1.put(p.getKey(), p.getValue().stream().mapToInt(value -> value).toArray());
            }
            for (int i = 0; i < n; i++) {
                int x = nums[i];
                int y = x + k, z = x - k;
                if (map1.containsKey(y)) {
                    var list = map1.get(y);
                    for (int j = lowerBound(list, i); j < list.length; j++) {
                        ans = Math.max(ans, sum[list[j] + 1] - sum[i]);
                    }
                }
                if (map1.containsKey(z)) {
                    var list = map1.get(z);
                    for (int j = lowerBound(list, i); j < list.length; j++) {
                        ans = Math.max(ans, sum[list[j] + 1] - sum[i]);
                    }
                }
            }
            return ans > Long.MIN_VALUE ? ans : 0;
        }

        public static int lowerBound(int[] arr, int target) {
            int l = 0, r = arr.length;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (arr[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }
}