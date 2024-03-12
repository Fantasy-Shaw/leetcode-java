package org.example.solutions.leetcode2k;

public class Solution2129 {
    class Solution {
        public String capitalizeTitle(String title) {
            StringBuilder ans = new StringBuilder();
            String[] strs = title.split(" ");
            for (var s : strs) {
                ans.append(s.length() <= 2 ? lower(s.charAt(0)) : upper(s.charAt(0)));
                for (int i = 1; i < s.length(); i++) {
                    ans.append(lower(s.charAt(i)));
                }
                ans.append(' ');
            }
            ans.deleteCharAt(ans.length() - 1);
            return ans.toString();
        }

        static char upper(char ch) {
            return Character.isUpperCase(ch) ? ch : (char) (ch - 'a' + 'A');
        }

        static char lower(char ch) {
            return Character.isLowerCase(ch) ? ch : (char) (ch - 'A' + 'a');
        }
    }
}