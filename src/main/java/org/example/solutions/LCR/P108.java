package org.example.solutions.LCR;

import org.example.templates.Dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P108 {
    class Solution {
        int id;
        Map<String, Integer> word2Id;
        List<List<int[]>> graph;

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            id = 0;
            word2Id = new HashMap<>();
            graph = new ArrayList<>();
            for (var word : wordList) {
                addWord(word);
            }
            addWord(beginWord);
            if (!word2Id.containsKey(endWord)) {
                return 0;
            }
            int[] dist = Dijkstra.getDistance(graph, word2Id.get(beginWord));
            int d = dist[word2Id.get(endWord)];
            return d < Integer.MAX_VALUE ? d / 2 + 1 : 0;
        }

        private int getWordId(String word) {
            if (word2Id.containsKey(word)) {
                return word2Id.get(word);
            } else {
                int ans = id;
                word2Id.put(word, id);
                id++;
                return ans;
            }
        }

        private void addWord(String word) {
            int id1 = getWordId(word);
            char[] s = word.toCharArray();
            for (int i = 0; i < s.length; i++) {
                char t = s[i];
                s[i] = '*';
                String cur = new String(s);
                int id2 = getWordId(cur);
                checkAdjList(id1, id2);
                graph.get(id1).add(new int[]{id2, 1});
                graph.get(id2).add(new int[]{id1, 1});
                s[i] = t;
            }
        }

        private void checkAdjList(int id1, int id2) {
            int n = Math.max(id1, id2) + 1;
            for (int i = graph.size(); i < n; i++) {
                graph.add(new ArrayList<>());
            }
        }
    }
}