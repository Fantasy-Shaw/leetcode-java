package org.example.solutions.leetcode1to200;

import org.example.templates.Dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution127 {
    class Solution {
        Map<String, Integer> word2Id;
        List<List<int[]>> graph;
        int id;

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            id = 0;
            word2Id = new HashMap<>();
            graph = new ArrayList<>();
            for (var word : wordList) {
                addEdge(word);
            }
            addEdge(beginWord);
            if (!word2Id.containsKey(endWord)) {
                return 0;
            }
            int[] dist = Dijkstra.getDistance(graph, word2Id.get(beginWord));
            int d = dist[word2Id.get(endWord)];
            return d < Integer.MAX_VALUE ? d / 2 + 1 : 0;
        }

        private int addWord(String s) {
            if (word2Id.containsKey(s)) {
                return word2Id.get(s);
            } else {
                word2Id.put(s, id);
                return id++;
            }
        }

        private void addEdge(String s) {
            int id1 = addWord(s);
            char[] cs = s.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                char t = cs[i];
                cs[i] = '*';
                int id2 = addWord(new String(cs));
                checkAdjList(id1, id2);
                graph.get(id1).add(new int[]{id2, 1});
                graph.get(id2).add(new int[]{id1, 1});
                cs[i] = t;
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