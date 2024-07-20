package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution792 {
    class Solution {
        private static final int inf = 0x3f3f3f3f;

        public int numMatchingSubseq(String s, String[] words) {
            List<Integer>[] idx = new List[26];
            Arrays.setAll(idx, k -> new ArrayList<>());
            int n = s.length();
            for (int i = 0; i < n; i++) {
                idx[s.charAt(i) - 'a'].add(i);
            }
            int ans = 0;
            check:
            for (var word : words) {
                int pre = -1;
                for (int i = 0; i < word.length(); i++) {
                    int next = nextIdx(idx, pre, word.charAt(i));
                    if (next == inf) {
                        continue check;
                    }
                    pre = next;
                }
                ans++;
            }
            return ans;
        }

        private int nextIdx(List<Integer>[] idx, int pre, char c) {
            var list = idx[c - 'a'];
            int l = 0, r = list.size();
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (list.get(mid) <= pre) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l == list.size() ? inf : list.get(l);
        }
    }
}