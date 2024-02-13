package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1203 {
    class Solution {
        public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
            List<List<Integer>> groupItems = new ArrayList<>();
            for (int i = 0; i < n + m; i++) {
                groupItems.add(new ArrayList<>());
            }
            List<List<Integer>> groupGraph = new ArrayList<>(), itemGraph = new ArrayList<>();
            for (int i = 0; i < n + m; i++) {
                groupGraph.add(new ArrayList<>());
            }
            for (int i = 0; i < n; i++) {
                itemGraph.add(new ArrayList<>());
            }
            int[] grpInDeg = new int[n + m], itInDeg = new int[n];
            List<Integer> id = new ArrayList<>();
            for (int i = 0; i < n + m; i++) {
                id.add(i);
            }
            int extIdx = m;
            for (int i = 0; i < n; i++) {
                if (group[i] == -1) {
                    group[i] = extIdx++;
                }
                groupItems.get(group[i]).add(i);
            }
            for (int i = 0; i < n; i++) {
                for (int bf : beforeItems.get(i)) {
                    if (group[bf] == group[i]) {
                        itInDeg[i]++;
                        itemGraph.get(bf).add(i);
                    } else {
                        grpInDeg[group[i]]++;
                        groupGraph.get(group[bf]).add(group[i]);
                    }
                }
            }
            List<Integer> groupTpSort = tpSort(grpInDeg, groupGraph, id);
            if (groupTpSort == null) {
                return new int[0];
            }
            List<Integer> ans = new ArrayList<>();
            for (int i : groupTpSort) {
                if (groupItems.get(i).isEmpty()) {
                    continue;
                }
                List<Integer> cur = tpSort(itInDeg, itemGraph, groupItems.get(i));
                if (cur == null) {
                    return new int[0];
                }
                ans.addAll(cur);
            }
            return ans.stream().mapToInt(value -> value).toArray();
        }

        private static List<Integer> tpSort(int[] inDeg, List<List<Integer>> graph, List<Integer> items) {
            Queue<Integer> qu = new ArrayDeque<>();
            for (int i : items) {
                if (inDeg[i] == 0) {
                    qu.offer(i);
                }
            }
            List<Integer> ans = new ArrayList<>();
            while (!qu.isEmpty()) {
                int cur = qu.poll();
                ans.add(cur);
                for (int i : graph.get(cur)) {
                    if (--inDeg[i] == 0) {
                        qu.offer(i);
                    }
                }
            }
            return ans.size() == items.size() ? ans : null;
        }
    }
}