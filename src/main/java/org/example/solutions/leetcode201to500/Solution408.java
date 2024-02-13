package org.example.solutions.leetcode201to500;

public class Solution408 {
    class Solution {
        public boolean validWordAbbreviation(String word, String abbr) {
            int m = word.length(), n = abbr.length();
            if (m < n) return false;
            int i, j;
            for (i = 0, j = 0; i < m && j < n; ) {
                if (word.charAt(i) == abbr.charAt(j)) {
                    i++;
                    j++;
                } else if (Character.isDigit(abbr.charAt(j))) {
                    if (abbr.charAt(j) == '0') return false;
                    int k = j;
                    while (k < n && Character.isDigit(abbr.charAt(k))) k++;
                    int nums = Integer.parseInt(abbr.substring(j, k));
                    i += nums;
                    j = k;
                } else {
                    return false;
                }
            }
            return i == m && j == n;
        }
    }
}