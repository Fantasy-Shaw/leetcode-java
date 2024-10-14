package org.example.solutions.leetcode2k;

import org.example.templates.RolliingHash.StringHash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2261 {
    class Solution {
        public int countDistinct(int[] nums, int k, int p) {
            int[] prefixSum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % p == 0) {
                    prefixSum[i + 1] = prefixSum[i] + 1;
                } else {
                    prefixSum[i + 1] = prefixSum[i];
                }
            }
            List<int[]> pairs = new ArrayList<>();
            for (int i = 0; i < prefixSum.length; i++) {
                for (int j = i + 1; j < prefixSum.length; j++) {
                    if (prefixSum[j] - prefixSum[i] <= k) {
                        pairs.add(new int[]{i, j});
                    } else {
                        break;
                    }
                }
            }
            StringBuilder numsSeq = new StringBuilder();
            for (int i : nums) {
                numsSeq.append((char) i);
            }
            StringHash hash = new StringHash(numsSeq);
            Set<Long> set = new HashSet<>();
            for (int[] pair : pairs) {
                set.add(hash.getHash(pair[0], pair[1]));
            }
            return set.size();
        }
    }
}