package org.example.solutions.leetcode1kto2k;

public class Solution1017 {
    class Solution {
        public String baseNeg2(int n) {
            if (n == 0) {
                return "0";
            }
            StringBuilder ans = new StringBuilder();
            int sign = 1;
            while (n != 0) {
                if (n % 2 != 0) {
                    ans.append(1);
                    n -= sign;
                } else {
                    ans.append(0);
                }
                sign *= -1;
                n /= 2;
            }
            return ans.reverse().toString();
        }
    }
}