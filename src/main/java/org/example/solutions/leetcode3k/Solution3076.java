package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3076 {
    class Solution {
        public String[] shortestSubstrings(String[] arr) {
            int n = arr.length;
            List<Set<String>> sets = new ArrayList<>();
            HashMap<String, Integer> freq = new HashMap<>();
            for (int i = 0; i < n; i++) {
                var set = getAllSubs(arr[i]);
                sets.add(set);
                for (var s : set) {
                    freq.put(s, freq.getOrDefault(s, 0) + 1);
                }
            }
            String[] ans = new String[n];
            for (int i = 0; i < n; i++) {
                ans[i] = "";
                for (var s : sets.get(i)) {
                    if (freq.get(s).equals(1)) {
                        ans[i] = s;
                        break;
                    }
                }
            }
            return ans;
        }

        private Set<String> getAllSubs(String s) {
            TreeSet<String> ans = new TreeSet<>(
                    (a, b) -> a.length() == b.length() ? a.compareTo(b) : a.length() - b.length()
            );
            int n = s.length();
            for (int l = 1; l <= n; l++) {
                for (int i = 0; i + l <= n; i++) {
                    ans.add(s.substring(i, i + l));
                }
            }
            return ans;
        }
    }
}