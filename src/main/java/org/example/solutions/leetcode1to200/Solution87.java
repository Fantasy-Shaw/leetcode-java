package org.example.solutions.leetcode1to200;

class Solution87 {
    private String s1, s2;
    private int n;
    private int[][][] cache;
    private final int N = -1, Y = 1, EMPTY = 0;


    public boolean isScramble(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        if (s1.equals(s2)) {
            return true;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        n = s1.length();
        cache = new int[n][n][n + 1];
        return dfs(0, 0, n);
    }

    private boolean dfs(int i, int j, int len) {
        if (cache[i][j][len] != EMPTY) {
            return cache[i][j][len] == Y;
        }
        String a = s1.substring(i, i + len);
        String b = s2.substring(j, j + len);
        if (a.equals(b)) {
            cache[i][j][len] = Y;
            return true;
        }
        if (!checkCharFreq(a, b)) {
            cache[i][j][len] = N;
            return false;
        }
        for (int k = 1; k < len; k++) {
            if (dfs(i, j, k) && dfs(i + k, j + k, len - k)) {
                cache[i][j][len] = Y;
                return true;
            }
            if (dfs(i, j + len - k, k) && dfs(i + k, j, len - k)) {
                cache[i][j][len] = Y;
                return true;
            }
        }
        cache[i][j][len] = N;
        return false;
    }

    private boolean checkCharFreq(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int n = s1.length();
        int[] cnt1 = new int[26], cnt2 = new int[26];
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        for (int i = 0; i < n; i++) {
            cnt1[cs1[i] - 'a']++;
            cnt2[cs2[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] != cnt2[i]) {
                return false;
            }
        }
        return true;
    }
}