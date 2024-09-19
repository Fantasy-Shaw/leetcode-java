package org.example.solutions.leetcode3k;

import org.example.templates.RolliingHash.DoubleStringHash;

import java.util.*;

public class Solution3292 {
    class Solution {
        public int minValidStrings(String[] words, String target) {
            int mxL = Arrays.stream(words).mapToInt(String::length).max().getAsInt();
            List<Set<Long>> sets = new ArrayList<>();
            for (int i = 0; i <= mxL; i++) {
                sets.add(new HashSet<>());
            }
            for (var w : words) {
                DoubleStringHash h = new DoubleStringHash(w);
                for (int j = 1; j <= w.length(); j++) {
                    sets.get(j).add(h.getHashcode(0, j));
                }
            }
            DoubleStringHash hash = new DoubleStringHash(target);
            int ans = 0, curR = 0, nxtR = 0;
            for (int i = 0; i < target.length(); i++) {
                int sz = calcSz(i, hash, sets);
                nxtR = Math.max(nxtR, i + sz);
                if (i == curR) {
                    if (i == nxtR) return -1;
                    curR = nxtR;
                    ans++;
                }
            }
            return ans;
        }

        private int calcSz(int i, DoubleStringHash hash, List<Set<Long>> sets) {
            int l = 0, r = Math.min(hash.size() - i + 1, sets.size());
            while (l < r) {
                int mid = l + (r - l) / 2;
                long h = hash.getHashcode(i, i + mid);
                if (sets.get(mid).contains(h)) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l - 1;
        }
    }
}