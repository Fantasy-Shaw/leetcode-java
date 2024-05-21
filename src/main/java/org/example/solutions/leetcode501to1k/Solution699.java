package org.example.solutions.leetcode501to1k;

import org.example.templates.SegTree.SegNodeForMaxVal;

import java.util.*;

public class Solution699 {
    class Solution {
        private static final int mn = 0, mx = (int) 1e8 + (int) 1e6 + 1;
        private SegNodeForMaxVal root;

        public List<Integer> fallingSquares(int[][] positions) {
            root = new SegNodeForMaxVal();
            List<Integer> ans = new ArrayList<>();
            for (int[] p : positions) {
                int x = p[0], h = p[1], cur = SegNodeForMaxVal.query(root, mn, mx, x, x + h - 1);
                SegNodeForMaxVal.update(root, mn, mx, x, x + h - 1, cur + h);
                ans.add(root.max);
            }
            return ans;
        }
    }
}