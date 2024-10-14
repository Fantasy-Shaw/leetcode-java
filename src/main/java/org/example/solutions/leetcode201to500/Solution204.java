package org.example.solutions.leetcode201to500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution204 {
    class Solution {
        // Euler sieve
        public int countPrimes(int n) {
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
            return primes.size();
        }
    }
}