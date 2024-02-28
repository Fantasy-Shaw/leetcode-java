package org.example.solutions.leetcode1to200;

public class Solution67 {
    class Solution {
        public String addBinary(String a, String b) {
            var x = a.length() > b.length() ? a : b;
            var y = a.length() <= b.length() ? a : b;
            StringBuilder ans = new StringBuilder();
            int i = 0;
            int carry = 0;
            for (; i < y.length(); i++) {
                int cur = x.charAt(x.length() - 1 - i) - '0' + y.charAt(y.length() - 1 - i) - '0' + carry;
                int n = cur % 2;
                carry = cur / 2;
                ans.append(n);
            }
            for (; i < x.length(); i++) {
                int cur = x.charAt(x.length() - 1 - i) - '0' + carry;
                int n = cur % 2;
                carry = cur / 2;
                ans.append(n);
            }
            if (carry == 1) {
                ans.append(carry);
            }
            return ans.reverse().toString();
        }
    }
}