package org.example.solutions.leetcode3k;

import java.util.ArrayList;
import java.util.List;

public class Solution3115 {
    class Solution {
        public int maximumPrimeDifference(int[] nums) {
            List<Integer> primes = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (isPrime(nums[i])) {
                    primes.add(i);
                }
            }
            return primes.isEmpty() ? -1 : primes.getLast() - primes.getFirst();
        }

        private boolean isPrime(int n) {
            if (n <= 1) return false;
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}