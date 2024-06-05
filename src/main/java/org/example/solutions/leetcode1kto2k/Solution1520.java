package org.example.solutions.leetcode1kto2k;

import org.example.templates.Fenwick;

import java.util.*;

public class Solution1520 {
    class Solution {
        public List<String> maxNumOfSubstrings(String _s) {
            char[] s = _s.toCharArray();
            List<Integer>[] idx = new List[26];
            Arrays.setAll(idx, k -> new ArrayList<>());
            for (int i = 0; i < s.length; i++) {
                idx[s[i] - 'a'].add(i);
            }
            int[][] it = new int[26][];
            for (int i = 0; i < 26; i++) {
                if (idx[i].isEmpty()) continue;
                it[i] = new int[]{idx[i].getFirst(), idx[i].getLast()};
            }
            for (int i = 0; i < 26; i++) {
                char ch = (char) (i + 'a');
                if (it[i] == null) continue;
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
                if (a != null) merged.add(a);
            });
            merged.sort((a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
            List<int[]> vis = new ArrayList<>();
            List<String> ans = new ArrayList<>();
            for (var p : merged) {
                if (vis.isEmpty() || p[0] > vis.getLast()[1]) {
                    vis.add(p);
                    ans.add(_s.substring(p[0], p[1] + 1));
                }
            }
            return ans;
        }
    }
}