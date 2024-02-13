package org.example.solutions.leetcode501to1k;

public class Solution621 {
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] map = new int[26];
            for (char ch : tasks) {
                map[ch - 'A']++;
            }
            int mx = 0, mxNums = 0;
            for (int i : map) {
                if (i > mx) {
                    mx = i;
                    mxNums = 1;
                } else if (i == mx) {
                    mxNums++;
                }
            }
            return Math.max(tasks.length, (mx - 1) * (n + 1) + mxNums);
        }
    }
}