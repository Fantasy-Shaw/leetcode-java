package org.example.solutions;

public class Solution1180 {
    class Solution {
        public int countLetters(String s) {
            char[] c = s.toCharArray();
            int count = 1, ans = 0;
            for (int i = 1; i < c.length; i++) {
                if (c[i] == c[i - 1]) {
                    count++;
                } else {
                    ans += count * (count + 1) / 2;
                    count = 1;
                }
            }
            ans += count * (count + 1) / 2;
            return ans;
        }
    }
}