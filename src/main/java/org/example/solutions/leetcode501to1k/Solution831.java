package org.example.solutions.leetcode501to1k;

public class Solution831 {
    class Solution {
        public String maskPII(String s) {
            return s.contains("@") ? maskedEmail(s) : maskedPhone(s);
        }

        private static String maskedEmail(String s) {
            String[] ss = s.split("@");
            StringBuilder ans = new StringBuilder();
            ans.append(Character.toLowerCase(ss[0].charAt(0)));
            ans.append("*****");
            ans.append(Character.toLowerCase(ss[0].charAt(ss[0].length() - 1)));
            ans.append('@');
            ans.append(ss[1].toLowerCase());
            return ans.toString();
        }

        private static String maskedPhone(String s) {
            StringBuilder ans = new StringBuilder();
            char[] cs = s.toCharArray();
            int cnt = 0;
            for (int i = 0; i < cs.length; i++) {
                if (Character.isDigit(cs[i])) {
                    cnt++;
                }
            }
            if (cnt > 10) {
                ans.append('+').append("*".repeat(cnt - 10)).append('-');
            }
            ans.append("***-***-");
            StringBuilder suffix = new StringBuilder();
            int j = cs.length - 1;
            while (suffix.length() < 4) {
                if (Character.isDigit(cs[j])) {
                    suffix.append(cs[j]);
                }
                j--;
            }
            ans.append(suffix.reverse());
            return ans.toString();
        }
    }
}