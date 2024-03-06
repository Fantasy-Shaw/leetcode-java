package org.example.solutions.leetcode201to500;

public class Solution421 {
    class Solution {
        BinaryTrie root;

        public int findMaximumXOR(int[] nums) {
            root = new BinaryTrie();
            for (int x : nums) {
                add(x);
            }
            int ans = Integer.MIN_VALUE;
            for (int x : nums) {
                ans = Math.max(ans, getMaxXor(x));
            }
            return ans;
        }

        static class BinaryTrie {
            public BinaryTrie[] children = new BinaryTrie[2];
            public boolean isEnd = false;
        }

        private void add(int x) {
            var cur = root;
            for (int i = 31; i >= 0; i--) {
                int t = (x >> i) & 1;
                if (cur.children[t] == null) {
                    cur.children[t] = new BinaryTrie();
                }
                cur = cur.children[t];
            }
            cur.isEnd = true;
        }

        private int getMaxXor(int x) {
            int ans = x;
            var cur = root;
            for (int i = 31; i >= 0; i--) {
                int t = (x >> i) & 1;
                int next = ~t & 1;
                if (cur.children[t] == null && cur.children[next] == null) {
                    break;
                }
                int u = cur.children[next] == null ? t : next;
                ans ^= (u << i);
                cur = cur.children[u];
            }
            return ans;
        }
    }
}