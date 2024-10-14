package org.example.solutions.leetcode3k;

import java.util.Arrays;

public class Solution3138 {
    class Solution {
        public int minAnagramLength(String s) {
            int n = s.length();
            char[] cs = s.toCharArray();
            addK:
            for (int k = 1; k <= n; k++) {
                if (n % k != 0) continue;
                int[] cnt = new int[26];
                int i = 0;
                for (; i < k; i++) {
                    cnt[cs[i] - 'a']++;
                }
                for (; i < n; i += k) {
                    int[] cnt1 = new int[26];
                    for (int j = 0; j < k; j++) {
                        cnt1[cs[i + j] - 'a']++;
                    }
                    if (!Arrays.equals(cnt, cnt1)) {
                        continue addK;
                    }
                }
                if (i == n) {
                    return k;
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            int cnt = 0, mx = 0;
            for (int i = 1; i < 1e5 + 1; i++) {
                int cur = 0;
                for (int j = 1; j <= i / 2; j++) {
                    if (i % j == 0) {
                        cur++;
                    }
                }
                if (cur > cnt) {
                    cnt = cur;
                    mx = i;
                }
            }
            System.out.println(mx + " " + cnt);
        }
    }
}