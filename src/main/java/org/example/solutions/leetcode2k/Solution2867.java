package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2867 {
    class Sieve {
        public static final Set<Integer> set = getPrimes((int) 1e5 + 10);

        public static Set<Integer> getPrimes(int n) {
            List<Integer> primes = new ArrayList<>();
            int[] isPrime = new int[n];
            Arrays.fill(isPrime, 1);
            for (int i = 2; i < n; i++) {
                if (isPrime[i] == 1) {
                    primes.add(i);
                }
                int m = primes.size();
                for (int j = 0; j < m && i * primes.get(j) < n; j++) {
                    isPrime[i * primes.get(j)] = 0;
                    if (i % primes.get(j) == 0) break;
                }
            }
            return new HashSet<>(primes);
        }
    }

    class Solution {
        public long countPaths(int n, int[][] edges) {
            List<List<Integer>> graph = new ArrayList<>(n + 1);
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }
            for (var e : edges) {
                graph.get(e[0]).add(e[1]);
                graph.get(e[1]).add(e[0]);
            }
            long ans = 0;
            int[] size = new int[n + 1];
            for (int x = 1; x <= n; x++) {
                if (!Sieve.set.contains(x)) {
                    continue;
                }
                long cur = 0;
                for (int y : graph.get(x)) {
                    if (Sieve.set.contains(y)) {
                        continue;
                    }
                    if (size[y] == 0) {
                        List<Integer> nodes = new ArrayList<>();
                        dfs(y, -1, graph, nodes);
                        for (int z : nodes) {
                            size[z] = nodes.size();
                        }
                    }
                    ans += (long) size[y] * cur;
                    cur += size[y];
                }
                ans += cur;
            }
            return ans;
        }

        private void dfs(int node, int parent, List<List<Integer>> graph, List<Integer> nodes) {
            nodes.add(node);
            for (int y : graph.get(node)) {
                if (y != parent && !Sieve.set.contains(y)) {
                    dfs(y, node, graph, nodes);
                }
            }
        }
    }
}