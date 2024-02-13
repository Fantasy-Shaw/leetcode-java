package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution271 {
    private class Codec {
        private final String tag = "Seed3407";
        private final String blank = "[Blank3407]";

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder stringBuilder = new StringBuilder();
            int n = strs.size();
            for (int i = 0; i < n - 1; i++) {
                String cur = strs.get(i);
                if (cur.isEmpty()) cur = blank;
                stringBuilder.append(cur).append(tag);
            }
            String cur = strs.get(n - 1);
            if (cur.isEmpty()) cur = blank;
            stringBuilder.append(cur).append(tag);
            return stringBuilder.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            String[] ans = s.split(tag);
            for (int i = 0; i < ans.length; i++) {
                if (ans[i].equals(blank)) {
                    ans[i] = "";
                }
            }
            return Arrays.asList(ans);
        }
    }
}