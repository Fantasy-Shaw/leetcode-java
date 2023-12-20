package org.example.solutions.leetcode1to200;

import java.util.*;

public class Solution131 {
    class Solution {
        private List<List<String>> result = new ArrayList<>();
        private List<String> path = new ArrayList<>();

        public List<List<String>> partition(String s) {
            backTrack(s, 0);
            return result;
        }

        private void backTrack(String s, int l) {
            if (l == s.length()) {
                result.add(new ArrayList<>(path));
            }
            for (int r = l; r < s.length(); r++) {
                if (isPalindrome(s, l, r)) {
                    path.add(s.substring(l, r + 1));
                    backTrack(s, r + 1);
                    path.remove(path.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String s, int l, int r) {
            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) return false;
                l++;
                r--;
            }
            return true;
        }
    }
}