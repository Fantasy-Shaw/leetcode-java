package org.example.solutions.leetcode2k;

import java.util.ArrayList;
import java.util.List;

public class Solution2901 {
    class Solution {
        public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
            // len of the longest subSeq from words[i:]
            int[] f = new int[n];
            // if groups[j]!=groups[i] and check(words[i],words[j])==true and f[j]+1>f[i]: f[i]=f[j]+1, from[i]=j
            int[] from = new int[n];
            int mx = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    if (f[j] > f[i] && groups[j] != groups[i] && check(words[i], words[j])) {
                        f[i] = f[j];
                        from[i] = j;
                    }
                }
                f[i]++;
                if (f[i] > f[mx]) mx = i;
            }
            int m = f[mx];
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                ans.add(words[mx]);
                mx = from[mx];
            }
            return ans;
        }

        private static boolean check(String s1, String s2) {
            int n = s1.length();
            if (n != s2.length()) return false;
            int hammingDistance = 0;
            for (int i = 0; i < n; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if (++hammingDistance > 1) return false;
                }
            }
            return hammingDistance == 1;
        }
    }
}