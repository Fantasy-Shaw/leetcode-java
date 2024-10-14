package org.example.solutions.leetcode2k;

import org.example.templates.BinarySearch;

import java.util.Arrays;

public class Solution2332 {
    class Solution {
        public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
            Arrays.sort(buses);
            Arrays.sort(passengers);
            int[] p = new int[passengers.length + 1];
            int l = buses[0], r = buses[buses.length - 1] + 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                System.arraycopy(passengers, 0, p, 0, passengers.length);
                p[p.length - 1] = 0;
                int k = BinarySearch.lowerBound(passengers, mid);
                for (int i = k + 1; i < p.length; i++) {
                    p[i] = p[i - 1];
                }
                p[k] = mid;
                if (isValid(buses, p, capacity, mid)) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            int k = BinarySearch.upperBound(passengers, l - 1) - 1;
            if (k == -1 || passengers[k] != l - 1) {
                return l - 1;
            } else {
                while (k > 0 && passengers[k - 1] + 1 == passengers[k]) {
                    k--;
                }
                return passengers[k] - 1;
            }
        }

        private boolean isValid(int[] b, int[] p, int capacity, int x) {
            int i = 0, j = 0;
            while (i < b.length && j < p.length) {
                for (int k = 0; k < capacity && j < p.length; k++) {
                    if (b[i] >= p[j]) {
                        if (p[j++] == x) return true;
                    } else {
                        break;
                    }
                }
                i++;
            }
            return false;
        }
    }
}