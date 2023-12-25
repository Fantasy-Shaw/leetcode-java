package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1276 {
    class Solution {
        public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
            List<Integer> ans = new ArrayList<>();
            if (tomatoSlices - 2 * cheeseSlices >= 0
                    && (tomatoSlices - 2 * cheeseSlices) % 2 == 0
                    && cheeseSlices - (tomatoSlices - 2 * cheeseSlices) / 2 >= 0) {
                ans.add((tomatoSlices - 2 * cheeseSlices) / 2);
                ans.add(cheeseSlices - ans.get(0));
            }
            return ans;
        }
    }
}