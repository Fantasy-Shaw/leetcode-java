package org.example.solutions.leetcode1kto2k;

import org.example.templates.Fenwick;

import java.util.*;

public class Solution1520 {
    class Solution {
        private static final int inf = 0x3f3f3f3f;

        public List<String> maxNumOfSubstrings(String _s) {
            char[] s = _s.toCharArray();
            int[][] it = new int[26][];
            Arrays.setAll(it, k -> new int[]{inf, -inf});
            for (int i = 0; i < s.length; i++) {
                int u = s[i] - 'a';
                it[u][0] = Math.min(it[u][0], i);
                it[u][1] = Math.max(it[u][1], i);
            }
            for (int i = 0; i < 26; i++) {
                char ch = (char) (i + 'a');
                if (it[i][0] == inf) continue;
                for (int j = it[i][0]; j <= it[i][1]; j++) {
                    if (s[j] != ch && it[s[j] - 'a'][1] > it[i][1]) {
                        it[i][0] = Math.min(it[i][0], it[s[j] - 'a'][0]);
                        it[i][1] = Math.max(it[i][1], it[s[j] - 'a'][1]);
                        it[s[j] - 'a'] = it[i];
                    }
                    if (s[j] != ch && it[s[j] - 'a'][0] < it[i][0]) {
                        it[i][0] = Math.min(it[i][0], it[s[j] - 'a'][0]);
                        it[i][1] = Math.max(it[i][1], it[s[j] - 'a'][1]);
                        it[s[j] - 'a'] = it[i];
                        j = it[i][0];
                    }
                }
            }
            List<int[]> merged = new ArrayList<>();
            Arrays.stream(it).forEach(a -> {
                if (a[0] != inf) merged.add(a);
            });
            merged.sort((a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
            int vis = -1;
            List<String> ans = new ArrayList<>();
            for (var p : merged) {
                if (p[0] > vis) {
                    vis = p[1];
                    ans.add(_s.substring(p[0], p[1] + 1));
                }
            }
            return ans;
        }
    }
}