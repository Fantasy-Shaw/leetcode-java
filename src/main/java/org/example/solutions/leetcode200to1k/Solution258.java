package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution258 {
    class Solution {
        public int addDigits(int num) {
            while (num >= 10) {
                int ans = 0;
                for (char c : String.valueOf(num).toCharArray()) {
                    ans += c - '0';
                }
                num = ans;
            }
            return num;
        }
    }
}