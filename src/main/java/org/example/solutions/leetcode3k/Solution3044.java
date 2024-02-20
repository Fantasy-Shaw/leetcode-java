package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3044 {
    class Sieve {
        public static final Set<Integer> set = getPrimes((int) 1e6);

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
        static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
        int m, n;
        HashMap<Integer, Integer> map;

        public int mostFrequentPrime(int[][] mat) {
            m = mat.length;
            n = mat[0].length;
            map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (var dir : dirs) {
                        int num = 0;
                        int nx = i, ny = j;
                        while (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                            num = (num * 10) + mat[nx][ny];
                            if (num > 10 && Sieve.set.contains(num)) {
                                map.put(num, map.getOrDefault(num, 0) + 1);
                            }
                            nx += dir[0];
                            ny += dir[1];
                        }
                    }
                }
            }
            int ans = -1, f = -1;
            for (var p : map.entrySet()) {
                int k = p.getKey(), v = p.getValue();
                if (v > f || (v == f && k > ans)) {
                    f = v;
                    ans = k;
                }
            }
            return ans;
        }
    }
}