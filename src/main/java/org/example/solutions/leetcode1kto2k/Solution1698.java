package org.example.solutions.leetcode1kto2k;

import java.util.*;

import org.example.templates.RolliingHash.StringHash;

public class Solution1698 {
    class Solution {
        public int countDistinct(String s) {
            int n = s.length();
            StringHash hash = new StringHash(s);
            Set<Long> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n + 1; j++) {
                    set.add(hash.getHash(i, j));
                }
            }
            return set.size();
        }
    }
}