package org.example.solutions.leetcode201to500;

public class Solution299 {
    class Solution {
        public String getHint(String secret, String guess) {
            int n = secret.length();
            int a = 0, b = 0;
            int[] map1 = new int[10], map2 = new int[10];
            for (int i = 0; i < n; i++) {
                int u = secret.charAt(i) - '0';
                int v = guess.charAt(i) - '0';
                if (u == v) {
                    a++;
                } else {
                    map1[u]++;
                    map2[v]++;
                }
            }
            for (int i = 0; i < 10; i++) {
                b += Math.min(map1[i], map2[i]);
            }
            return String.valueOf(a) + 'A' + b + 'B';
        }
    }
}