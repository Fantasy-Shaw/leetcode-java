package org.example.solutions.leetcode2k;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2975 {
    class Solution {
        private static final int mod = (int) 1e9 + 7;

        public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
            int[] hArr = helper(hFences, m), vArr = helper(vFences, n);
            int i = hArr.length - 1, j = vArr.length - 1;
            while (i >= 0 && j >= 0) {
                if (hArr[i] == vArr[j]) {
                    return (int) (((long) hArr[i] * hArr[i]) % mod);
                } else if (hArr[i] > vArr[j]) {
                    i--;
                } else {
                    j--;
                }
            }
            return -1;
        }

        private int[] helper(int[] fences, int boundary) {
            Set<Integer> ans = new HashSet<>();
            Arrays.sort(fences);
            for (int i = 0; i < fences.length; i++) {
                for (int j = i + 1; j < fences.length; j++) {
                    ans.add(fences[j] - fences[i]);
                }
            }
            ans.add(boundary - 1);
            for (int fence : fences) {
                ans.add(fence - 1);
                ans.add(boundary - fence);
            }
            int[] ret = ans.stream().mapToInt(i -> i).toArray();
            Arrays.sort(ret);
            return ret;
        }
    }
}