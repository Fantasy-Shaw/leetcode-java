package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1535 {
    class Solution {
        public int getWinner(int[] arr, int k) {
            int ans = arr[0], cnt = 0;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > ans) {
                    ans = arr[i];
                    cnt = 0;
                }
                if (++cnt == k) {
                    return ans;
                }
            }
            return ans;
        }
    }
}