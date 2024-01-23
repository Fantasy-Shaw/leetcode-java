package org.example.solutions.LCR;

import java.util.*;

public class P180 {
    class Solution {
        public int[][] fileCombination(int target) {
            List<List<Integer>> ans = new ArrayList<>();
            int boundary = target / 2;
            int i = 1, j = 1, sum = 0;
            while (i <= boundary) {
                if (sum < target) {
                    sum += j;
                    j++;
                } else if (sum > target) {
                    sum -= i;
                    i++;
                } else {
                    List<Integer> cur = new ArrayList<>();
                    for (int x = i; x < j; x++) {
                        cur.add(x);
                    }
                    ans.add(cur);
                    sum -= i;
                    i++;
                }
            }
            int[][] res = new int[ans.size()][];
            for (int k = 0; k < ans.size(); k++) {
                res[k] = ans.get(k).stream().mapToInt(value -> value).toArray();
            }
            return res;
        }
    }
}