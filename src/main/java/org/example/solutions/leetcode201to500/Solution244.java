package org.example.solutions.leetcode201to500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution244 {
    class WordDistance {
        HashMap<String, List<Integer>> indices;

        public WordDistance(String[] wordsDict) {
            indices = new HashMap<>();
            for (int i = 0; i < wordsDict.length; i++) {
                indices.putIfAbsent(wordsDict[i], new ArrayList<>());
                indices.get(wordsDict[i]).add(i);
            }
        }

        public int shortest(String word1, String word2) {
            int ans = Integer.MAX_VALUE;
            for (int i1 : indices.get(word1)) {
                for (int i2 : indices.get(word2)) {
                    ans = Math.min(ans, Math.abs(i1 - i2));
                }
            }
            return ans;
        }
    }
}