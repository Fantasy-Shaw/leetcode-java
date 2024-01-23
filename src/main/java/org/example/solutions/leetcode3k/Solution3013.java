package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3013 {
    class Solution {
        long sumL;
        int sizeL;
        TreeMap<Integer, Integer> L, R;

        public long minimumCost(int[] nums, int k, int dist) {
            L = new TreeMap<>();
            R = new TreeMap<>();
            k--;
            sumL = nums[0];
            for (int i = 1; i < dist + 2; i++) {
                sumL += nums[i];
                L.merge(nums[i], 1, Integer::sum);
            }
            sizeL = dist + 1;
            while (sizeL > k) {
                l2r();
            }
            long ans = sumL;
            for (int i = dist + 2; i < nums.length; i++) {
                int out = nums[i - dist - 1];
                if (L.containsKey(out)) {
                    sumL -= out;
                    sizeL--;
                    rmOne(L, out);
                } else {
                    rmOne(R, out);
                }
                int in = nums[i];
                if (in < L.lastKey()) {
                    sumL += in;
                    sizeL++;
                    L.merge(in, 1, Integer::sum);
                } else {
                    R.merge(in, 1, Integer::sum);
                }
                if (sizeL == k - 1) {
                    r2l();
                } else if (sizeL == k + 1) {
                    l2r();
                }
                ans = Math.min(ans, sumL);
            }
            return ans;
        }

        private void l2r() {
            int x = L.lastKey();
            rmOne(L, x);
            sumL -= x;
            sizeL--;
            R.merge(x, 1, Integer::sum);
        }

        private void r2l() {
            int x = R.firstKey();
            rmOne(R, x);
            sumL += x;
            sizeL++;
            L.merge(x, 1, Integer::sum);
        }

        private void rmOne(TreeMap<Integer, Integer> map, int key) {
            int cnt = map.get(key);
            if (cnt > 1) {
                map.put(key, cnt - 1);
            } else {
                map.remove(key);
            }
        }
    }
}