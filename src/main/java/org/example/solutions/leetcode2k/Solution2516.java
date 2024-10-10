package org.example.solutions.leetcode2k;

public class Solution2516 {
    static
    class Solution {
        public int takeCharacters(String _s, int k) {
            int[] cnt = new int[3];
            int n = _s.length();
            char[] s = _s.toCharArray();
            int i = n - 1, j = 0;
            while (i >= 0 && !isValid(cnt, k)) {
                cnt[s[i--] - 'a']++;
            }
            if (i == -1 && !isValid(cnt, k)) {
                return -1;
            }
            i++;
            int ans = j - i + n;
            while (i < n && j < n) {
                while (i < n && isValid(cnt, k)) {
                    ans = Math.min(ans, j - i + n);
                    cnt[s[i++] - 'a']--;
                }
                while (j < n && !isValid(cnt, k)) {
                    cnt[s[j++] - 'a']++;
                }
                ans = Math.min(ans, j - i + n);
            }
            return ans;
        }

        private static boolean isValid(int[] cnt, int k) {
            return cnt[0] >= k && cnt[1] >= k && cnt[2] >= k;
        }
    }
}