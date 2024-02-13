package org.example.solutions.leetcode501to1k;

import org.example.utils.TreeNode;

import java.util.*;

public class Solution662 {
    class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int ans = 1;
            List<Pair<TreeNode, Integer>> cur = new ArrayList<>();
            cur.add(new Pair<>(root, 1));
            while (!cur.isEmpty()) {
                List<Pair<TreeNode, Integer>> next = new ArrayList<>();
                for (var pair : cur) {
                    var node = pair.first;
                    var idx = pair.second;
                    if (pair.first.left != null) {
                        next.add(new Pair<>(node.left, 2 * idx));
                    }
                    if (pair.first.right != null) {
                        next.add(new Pair<>(node.right, 2 * idx + 1));
                    }
                    ans = Math.max(ans, cur.getLast().second - cur.getFirst().second + 1);
                }
                cur = next;
            }
            return ans;
        }

        static class Pair<_Tp1, _Tp2> {
            public _Tp1 first;
            public _Tp2 second;

            public Pair(_Tp1 first, _Tp2 second) {
                this.first = first;
                this.second = second;
            }
        }
    }
}