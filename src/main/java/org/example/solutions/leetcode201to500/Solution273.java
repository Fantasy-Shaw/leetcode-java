package org.example.solutions.leetcode201to500;

public class Solution273 {
    private class Solution {
        private static final String[] ones = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
                "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                "Eighteen", "Nineteen"
        };

        private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty",
                "Sixty", "Seventy", "Eighty", "Ninety"
        };

        private static final String[] xxl = {"Billion", "Million", "Thousand", ""};

        private String num2Str(int x) {
            StringBuilder ans = new StringBuilder();
            if (x >= 100) {
                ans.append(ones[x / 100]).append(" Hundred ");
                x %= 100;
            }
            if (x >= 20) {
                ans.append(tens[x / 10]).append(" ");
                x %= 10;
            }
            if (x != 0) {
                ans.append(ones[x]).append(" ");
            }
            return ans.toString();
        }

        public String numberToWords(int num) {
            if (num == 0) {
                return ones[0];
            }
            StringBuilder sb = new StringBuilder();
            for (int i = (int) 1e9, j = 0; i >= 1; i /= 1000, j++) {
                if (num < i) {
                    continue;
                }
                sb.append(num2Str(num / i)).append(xxl[j]).append(" ");
                num %= i;
            }
            while (sb.charAt(sb.length() - 1) == ' ') {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        }
    }
}
