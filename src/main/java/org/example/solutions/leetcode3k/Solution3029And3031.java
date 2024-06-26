package org.example.solutions.leetcode3k;

import org.example.templates.RolliingHash.StringHash;

public class Solution3029And3031 {
    class Solution {
        public int minimumTimeToInitialState(String word, int k) {
            int n = word.length();
            StringHash hash = new StringHash(word);
            int ans = 1;
            for (int i = 1; i * k < n; i++) {
                if (hash.getHash(i * k, n) == hash.getHash(0, n - i * k)) {
                    break;
                } else {
                    ans++;
                }
            }
            return ans;
        }
    }
}