package org.example.solutions.leetcode1kto2k;

public class Solution1306 {
    class Solution {
        public boolean canReach(int[] arr, int start) {
            if (arr[start] == 0) {
                return true;
            }
            int n = arr.length;
            boolean[] vis = new boolean[n];
            return dfs(arr, vis, start);
        }

        public boolean dfs(int[] arr, boolean[] vis, int cur) {
            if (cur < 0 || cur >= arr.length || vis[cur]) {
                return false;
            }
            vis[cur] = true;
            if (arr[cur] == 0) {
                return true;
            }
            return dfs(arr, vis, cur + arr[cur]) || dfs(arr, vis, cur - arr[cur]);
        }
    }
}