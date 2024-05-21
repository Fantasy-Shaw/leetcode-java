package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1177 {
    class Solution {
        public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
            int n = s.length();
            int[] cnt = new int[n + 1];
            for (int i = 0; i < n; i++) {
                cnt[i + 1] = cnt[i];
                cnt[i + 1] ^= (1 << (s.charAt(i) - 'a'));
            }
            List<Boolean> ans = new ArrayList<>(queries.length);
            Arrays.stream(queries).forEach(q -> ans.add(Integer.bitCount(cnt[q[1] + 1] ^ cnt[q[0]]) >>> 1 <= q[2]));
            return ans;
        }
    }
}