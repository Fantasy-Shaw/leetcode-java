package org.example.solutions.leetcode3k;

import org.example.templates.KMP;
import org.example.templates.RolliingHash.RollingHash;
import org.example.templates.RolliingHash.RollingHashStream;

import java.util.ArrayList;
import java.util.List;

public class Solution3037 {
    abstract class InfiniteStream {
        public InfiniteStream(int[] bits) {
        }

        public abstract int next();
    }

    class Solution1 {
        public int findPattern(InfiniteStream infiniteStream, int[] pattern) {
            int m = pattern.length;
            long p = new RollingHash(pattern).getHash(0, m);
            RollingHashStream hash = new RollingHashStream();
            int n = (int) 2e5 + 10;
            for (int i = 0; i < n; i++) {
                hash.add(infiniteStream.next());
                if (hash.size >= m && hash.getHash(hash.size - m, hash.size) == p) {
                    return hash.size - m;
                }
            }
            return -1;
        }
    }

    class Solution {
        public int findPattern(InfiniteStream infiniteStream, int[] pattern) {
            List<Integer> arr = new ArrayList<>();
            int[] maxMatchLengths = KMP.calculateMaxMatchLengths(pattern);
            int count = 0;
            int n = (int) (2e5);
            for (int x = 0; x < n; x++) {
                arr.add(infiniteStream.next());
                if (arr.size() >= pattern.length) {
                    int i = arr.size() - pattern.length;
                    while (count > 0 && pattern[count] != arr.get(i)) {
                        count = maxMatchLengths[count - 1];
                    }
                    if (pattern[count] == arr.get(i)) {
                        count++;
                    }
                    if (count == pattern.length) {
                        return i - pattern.length + 1;
                    }
                }
            }
            return -1;
        }
    }
}

