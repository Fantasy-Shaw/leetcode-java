package org.example.solutions.leetcode3k;

import org.example.templates.RollingHash;
import org.example.templates.RollingHashStream;

import java.util.*;

public class Solution3037 {
    abstract class InfiniteStream {
        public InfiniteStream(int[] bits) {
        }

        public abstract int next();
    }

    class Solution {
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
}

