package org.example.solutions.leetcode501to1k;

public class Solution849 {
    class Solution {
        public int maxDistToClosest(int[] seats) {
            if (seats.length == 2) {
                return 1;
            }
            int ans = 0;
            while (seats[ans] != 1) {
                ans++;
            }
            int i = ans;
            while (i < seats.length) {
                int j = i;
                while (j + 1 < seats.length && seats[j + 1] == 0) {
                    j++;
                }
                if (j == i) {
                    i++;
                } else {
                    if (j + 1 == seats.length) {
                        ans = Math.max(j - i, ans);
                    } else {
                        ans = Math.max((j - i + 1) / 2, ans);
                    }
                    i = j + 1;
                }
            }
            return ans;
        }
    }
}