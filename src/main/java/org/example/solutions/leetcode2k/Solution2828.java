package org.example.solutions.leetcode2k;

import java.util.List;

public class Solution2828 {
    class Solution {
        public boolean isAcronym(List<String> words, String s) {
            StringBuilder sb = new StringBuilder();
            for (var word : words) {
                sb.append(word.charAt(0));
            }
            return sb.toString().equals(s);
        }
    }
}