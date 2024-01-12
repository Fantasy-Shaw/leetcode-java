package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution294 {
    class Solution {
        // Sprague–Grundy
        public boolean canWin(String currentState) {
            currentState = currentState + '-';
            List<Integer> dec = new ArrayList<>();
            int cnt = 0, dpSize = 0;
            /* 分解原状态至多个不可分解的子态 */
            for (char c : currentState.toCharArray()) {
                if (c == '+') cnt++;
                else {
                    dec.add(cnt);
                    dpSize = Math.max(dpSize, cnt);
                    cnt = 0;
                }
            }
            if (dpSize <= 1) return false;
            /* 枚举所有不可细分的子状态（0,1时为0已经返回false，从2开始遍历） */
            int[] dp = new int[dpSize + 1];
            for (int i = 2; i <= dpSize; i++) {
                /* 子状态不可以拆分，那么子状态的值等于所有下一个状态的集合外的最小非负整数 */
                Set<Integer> set = new HashSet<>();
                for (int j = 0, l = i / 2; j < l; j++) {
                    /* 每种翻转后，形成的次态可以分解成两种状态 */
                    /* 可分解的状态（g值）等于各分解子状态（g值）的异或和 */
                    set.add(dp[j] ^ dp[i - j - 2]);
                }
                /* 找到最小的不在集合中的数字，就是本状态的g值 */
                for (int k = 0, l = i / 2; k <= l; k++) {
                    if (set.contains(k)) continue;
                    else {
                        dp[i] = k;
                        break;
                    }
                }
            }
            int ans = 0;
            for (int i : dec) {
                ans ^= dp[i];
            }
            return ans != 0;
        }
    }
}