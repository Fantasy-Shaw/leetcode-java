package org.example.solutions.leetcode3k;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution3289 {
    class Solution {
        public int[] getSneakyNumbers(int[] nums) {
            return Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                    .entrySet().stream()
                    .filter(p -> p.getValue() == 2)
                    .mapToInt(Map.Entry::getKey)
                    .toArray();
        }
    }
}