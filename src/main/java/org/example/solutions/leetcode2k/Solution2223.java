package org.example.solutions.leetcode2k;

import org.example.templates.StringHash;

public class Solution2223 {
    class Solution {
        public long sumScores(String s) {
            int n = s.length();
            StringHash hash = new StringHash(s);
            long ans = 0;
            for (int i = n - 1; i >= 0; i--) {
                // l, r表示字符个数的下界和上界
                int l = 0, r = n - i;
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (hash.getHash(i, i + mid + 1) == hash.getHash(0, mid + 1)) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                ans += Math.min(l, n - i);
            }
            return ans;
        }
    }
}