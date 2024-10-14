package org.example.solutions.leetcode501to1k;

import org.example.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution894 {
    class Solution {
        public List<TreeNode> allPossibleFBT(int n) {
            List<TreeNode>[] memo = new List[n + 1];
            memo[1] = List.of(new TreeNode());
            return dfs(n, memo);
        }

        private List<TreeNode> dfs(int n, List<TreeNode>[] memo) {
            if (memo[n] != null) {
                return memo[n];
            }
            List<TreeNode> ans = new ArrayList<>();
            for (int i = 0; i < n - 1; i++) {
                int j = n - i - 1;
                for (var l : dfs(i, memo)) {
                    for (var r : dfs(j, memo)) {
                        ans.add(new TreeNode(0, l, r));
                    }
                }
            }
            memo[n] = ans;
            return ans;
        }
    }
}