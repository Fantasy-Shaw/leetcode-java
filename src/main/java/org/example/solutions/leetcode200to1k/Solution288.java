package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution288 {
    class ValidWordAbbr {
        private Map<String, Set<String>> hashMap;

        private String getShort(String word) {
            if (word.length() < 3) {
                return word;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(word.charAt(0)).append(word.length() - 2).append(word.charAt(word.length() - 1));
                return sb.toString();
            }
        }

        public ValidWordAbbr(String[] dictionary) {
            hashMap = new HashMap<>();
            for (String word : dictionary) {
                String s = getShort(word);
                if (!hashMap.containsKey(s)) {
                    hashMap.put(s, new HashSet<>());
                }
                hashMap.get(s).add(word);
            }
        }

        public boolean isUnique(String word) {
            String s = getShort(word);
            if (!hashMap.containsKey(s)) {
                return true;
            } else if (hashMap.containsKey(s) && hashMap.get(s).contains(word) && hashMap.get(s).size() == 1) {
                return true;
            } else {
                return false;
            }
        }
    }
}
