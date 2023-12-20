package org.example.solutions.leetcode2k;

class Solution2697 {
    public String makeSmallestPalindrome(String s) {
        int n = s.length();
        char[] chArr = s.toCharArray();
        int l = 0, r = n - 1;
        while (l < r) {
            if (chArr[l] != chArr[r]) {
                chArr[l] = chArr[r] = (char) Math.min(chArr[l], chArr[r]);
            }
            l++;
            r--;
        }
        return new String(chArr);
    }
}
