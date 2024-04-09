package org.example.solutions.leetcode1to200;

public class Solution43 {
    class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }
            int i = 0;
            String ans = step(num1, num2.charAt(num2.length() - 1) - '0', i++);
            while (i < num2.length()) {
                String x = step(num1, num2.charAt(num2.length() - i - 1) - '0', i);
                ans = add(ans, x);
                i++;
            }
            return ans;
        }

        private String step(String num1, int x, int zeros) {
            StringBuilder ans = new StringBuilder();
            int add = 0;
            for (int i = num1.length() - 1; i >= 0; i--) {
                int y = num1.charAt(i) - '0';
                int cur = (x * y + add) % 10;
                add = (x * y + add) / 10;
                ans.append(cur);
            }
            if (add != 0) {
                ans.append(add);
            }
            ans.reverse().repeat('0', zeros);
            return ans.toString();
        }

        private String add(String num1, String num2) {
            int i = 0;
            int add = 0;
            StringBuilder ans = new StringBuilder();
            for (; i < num1.length() && i < num2.length(); i++) {
                int x = num1.charAt(num1.length() - i - 1) - '0';
                int y = num2.charAt(num2.length() - i - 1) - '0';
                int cur = (x + y + add) % 10;
                add = (x + y + add) / 10;
                ans.append(cur);
            }
            String num = (num1.length() > num2.length()) ? num1 : num2;
            for (; i < num.length(); i++) {
                int x = num.charAt(num.length() - i - 1) - '0';
                int cur = (x + add) % 10;
                add = (x + add) / 10;
                ans.append(cur);
            }
            if (add != 0) {
                ans.append(add);
            }
            return ans.reverse().toString();
        }
    }
}