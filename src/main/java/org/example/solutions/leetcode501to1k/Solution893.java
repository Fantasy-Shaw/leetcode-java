package org.example.solutions.leetcode501to1k;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution893 {
    static
    class Solution {
        public int numSpecialEquivGroups(String[] words) {
            Set<String> set = new HashSet<>();
            for (String word : words) {
                set.add(cnt(word));
            }
            return set.size();
        }

        private static String cnt(String word) {
            int[] cnt = new int[52];
            for (int i = 0; i < word.length(); i++) {
                cnt[word.charAt(i) - 'a' + 26 * (i & 1)]++;
            }
            return Arrays.toString(cnt);
        }
    }
}