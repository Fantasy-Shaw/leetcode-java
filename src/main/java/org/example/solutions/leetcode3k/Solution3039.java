package org.example.solutions.leetcode3k;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution3039 {
    class Solution {
        public String lastNonEmptyString(String s) {
            int[] last = new int[26];
            Arrays.fill(last, -1);
            int[] cnt = new int[26];
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                cnt[u]++;
                last[u] = Math.max(i, last[u]);
            }
            int mx = 0;
            for (int i = 0; i < 26; i++) {
                mx = Math.max(mx, cnt[i]);
            }
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                if (cnt[i] == mx) {
                    list.add((char) (i + 'a'));
                }
            }
            list.sort(Comparator.comparingInt(a -> last[a - 'a']));
            StringBuilder ans = new StringBuilder();
            for (char ch : list) {
                ans.append(ch);
            }
            return ans.toString();
        }
    }
}