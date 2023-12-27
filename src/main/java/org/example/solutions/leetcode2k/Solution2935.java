package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2935 {
    class Solution {
        // 0-1 Trie + Sliding Window
        private static final int HIGH_BIT = 19;
        private Node root;

        public int maximumStrongPairXor(int[] nums) {
            root = new Node();
            Arrays.sort(nums);
            int ans = 0, left = 0;
            for (int n : nums) {
                insert(n);
                while ((nums[left] << 1) < n) {
                    remove(nums[left++]);
                }
                ans = Math.max(ans, maxXor(n));
            }
            return ans;
        }


        private void insert(int n) {
            Node cur = root;
            for (int i = HIGH_BIT; i >= 0; i--) {
                int bit = (n >> i) & 1;
                if (cur.children[bit] == null) {
                    cur.children[bit] = new Node();
                }
                cur = cur.children[bit];
                cur.size++;
            }
        }

        private void remove(int n) {
            Node cur = root;
            for (int i = HIGH_BIT; i >= 0; i--) {
                cur = cur.children[(n >> i) & 1];
                cur.size--;
            }
        }

        private int maxXor(int n) {
            Node cur = root;
            int ans = 0;
            for (int i = HIGH_BIT; i >= 0; i--) {
                int bit = (n >> i) & 1;
                if (cur.children[bit ^ 1] != null && cur.children[bit ^ 1].size > 0) {
                    ans |= 1 << i;
                    bit ^= 1;
                }
                cur = cur.children[bit];
            }
            return ans;
        }

        private static class Node {
            public Node[] children = new Node[2];
            public int size;
        }
    }
}