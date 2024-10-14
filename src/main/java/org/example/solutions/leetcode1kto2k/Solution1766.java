package org.example.solutions.leetcode1kto2k;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1766 {
    class Primes {
        public static List<Integer>[] coPrimes = getCoPrimes(51);

        private static List<Integer>[] getCoPrimes(int n) {
            List<Integer>[] ans = new List[n];
            Arrays.setAll(ans, k -> new ArrayList<>());
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    if (gcd(i, j) == 1) {
                        ans[i].add(j);
                    }
                }
            }
            return ans;
        }

        private static int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }

    class Solution {
        List<Integer>[] graph;
        int[] nums, ans, valDepth, valNodeId;

        public int[] getCoprimes(int[] nums, int[][] edges) {
            this.nums = nums;
            int n = nums.length;
            graph = new List[n];
            Arrays.setAll(graph, k -> new ArrayList<>());
            for (var e : edges) {
                graph[e[0]].add(e[1]);
                graph[e[1]].add(e[0]);
            }
            ans = new int[n];
            valDepth = new int[51];
            valNodeId = new int[51];
            Arrays.fill(ans, -1);
            dfs(0, -1, 1);
            return ans;
        }

        private void dfs(int x, int parent, int depth) {
            int val = nums[x];
            int maxDepth = 0;
            for (var j : Primes.coPrimes[val]) {
                if (valDepth[j] > maxDepth) {
                    maxDepth = valDepth[j];
                    ans[x] = valNodeId[j];
                }
            }
            int tDepth = valDepth[val], tNodeId = valNodeId[val];
            valDepth[val] = depth;
            valNodeId[val] = x;
            for (var y : graph[x]) {
                if (y != parent) {
                    dfs(y, x, depth + 1);
                }
            }
            valDepth[val] = tDepth;
            valNodeId[val] = tNodeId;
        }
    }
}