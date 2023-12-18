package org.example.solutions;

import java.util.*;

public class Solution139 {
    private class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int n = s.length();
            Set<String> wdSet = new HashSet<>(wordDict);
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && wdSet.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[n];
        }
    }

}
