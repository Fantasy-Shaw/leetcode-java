package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1655 {
    class Solution {
        public boolean canDistribute(int[] nums, int[] quantity) {
            // 预处理 quantity 每个子集的子集和
            int m = 1 << quantity.length;
            int[] sum = new int[m];
            for (int i = 0; i < quantity.length; i++) {
                for (int j = 0, bit = 1 << i; j < bit; j++) {
                    sum[bit | j] = sum[j] + quantity[i];
                }
            }
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int n : nums) {
                cnt.put(n, cnt.getOrDefault(n, 0) + 1);
            }
            int n = cnt.size();
            // dp[i][j] 表示 cnt 的前 i 个元素能否满足集合为 j 的顾客
            boolean[][] dp = new boolean[n + 1][m];
            for (int i = 0; i <= n; i++) {
                dp[i][0] = true;
            }
            int i = 0;
            for (var p : cnt.entrySet()) {
                int c = p.getValue();
                for (int j = 0; j < dp[i].length; j++) {
                    if (dp[i][j]) {
                        dp[i + 1][j] = true;
                        continue;
                    }
                    // 枚举 j 的子集 sub
                    for (int sub = j; sub > 0; sub = (sub - 1) & j) {
                        // 判断这 c 个数能否全部分给 sub，并且除了 sub 以外的 j 中的顾客也满足
                        if (sum[sub] <= c && dp[i][j ^ sub]) {
                            dp[i + 1][j] = true;
                            break;
                        }
                    }
                }
                i++;
            }
            return dp[n][m - 1];
        }
    }
}