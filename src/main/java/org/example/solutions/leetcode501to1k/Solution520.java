package org.example.solutions.leetcode501to1k;

public class Solution520 {
    class Solution {
        public boolean detectCapitalUse(String word) {
            char[] cs = word.toCharArray();
            boolean noUpper = true, allUpper = true, capital = Character.isUpperCase(cs[0]);
            for (int i = 0; i < cs.length; i++) {
                if (Character.isUpperCase(cs[i])) {
                    noUpper = false;
                }
                if (Character.isLowerCase(cs[i])) {
                    allUpper = false;
                }
            }
            if (capital) {
                for (int i = 1; i < cs.length; i++) {
                    if (Character.isUpperCase(cs[i])) {
                        capital = false;
                        break;
                    }
                }
            }
            return noUpper || allUpper || capital;
        }
    }
}