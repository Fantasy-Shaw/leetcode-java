package org.example.solutions.leetcode201to500;

public class Solution306 {
    class Solution {
        public boolean isAdditiveNumber(String num) {
            int n = num.length();
            for (int i = 1; i <= n / 2; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (dfs(num, 0, i, j)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private CharSequence add(String num, int left, int mid, int right) {
            // Two numbers: num.substring(left, mid), num.substring(mid, right)
            StringBuilder ans = new StringBuilder();
            int i = mid - 1, j = right - 1;
            int sig = 0;
            while (i >= left || j >= mid || sig == 1) {
                int x = (i >= left) ? (num.charAt(i--) - '0') : 0;
                int y = (j >= mid) ? (num.charAt(j--) - '0') : 0;
                int cur = x + y + sig;
                ans.append(cur % 10);
                sig = cur >= 10 ? 1 : 0;
            }
            return ans.reverse();
        }

        private boolean dfs(String num, int left, int mid, int right) {
            // check leading zeros
            if (num.charAt(left) == '0' && mid - left != 1) {
                return false;
            }
            if (num.charAt(mid) == '0' && right - mid != 1) {
                return false;
            }
            CharSequence sum = add(num, left, mid, right);
            if (right + sum.length() > num.length()) {
                return false; // The left digits are not enough.
            }
            for (int x = 0; x < sum.length(); x++) {
                if (sum.charAt(x) != num.charAt(x + right)) {
                    return false;
                }
            }
            if (right + sum.length() == num.length()) {
                return true;
            }
            return dfs(num, mid, right, right + sum.length());
        }
    }
}