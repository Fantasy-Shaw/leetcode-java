package org.example.solutions;

import java.nio.file.Path;
import java.util.*;

public class Solution126 {
    class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> res = new ArrayList<>();
            Set<String> dict = new HashSet<>(wordList);
            if (!dict.contains(endWord)) {
                return res;
            }
            dict.remove(beginWord);
            Map<String, Integer> steps = new HashMap<>();
            steps.put(beginWord, 0);
            Map<String, List<String>> src = new HashMap<>();
            int step = 1;
            boolean found = false;
            int wordLen = beginWord.length();
            Queue<String> queue = new ArrayDeque<>();
            queue.offer(beginWord);
            while (!queue.isEmpty()) {
                int sz = queue.size();
                for (int i = 0; i < sz; i++) {
                    String curWord = queue.poll();
                    char[] arr = curWord.toCharArray();
                    for (int j = 0; j < wordLen; j++) {
                        char origin = arr[j];
                        for (char c = 'a'; c <= 'z'; c++) {
                            arr[j] = c;
                            String nextWord = new String(arr);
                            if (steps.containsKey(nextWord) && step == steps.get(nextWord)) {
                                src.get(nextWord).add(curWord);
                            }
                            if (!dict.contains(nextWord)) {
                                continue;
                            }
                            dict.remove(nextWord);
                            queue.offer(nextWord);
                            src.putIfAbsent(nextWord, new ArrayList<>());
                            src.get(nextWord).add(curWord);
                            steps.put(nextWord, step);
                            if (nextWord.equals(endWord)) {
                                found = true;
                            }
                        }
                        arr[j] = origin;
                    }
                }
                step++;
                if (found) {
                    break;
                }
            }
            if (found) {
                Deque<String> path = new ArrayDeque<>();
                path.add(endWord);
                backTrack(src, path, beginWord, endWord, res);
            }
            return res;
        }

        private void backTrack(
                Map<String, List<String>> src, Deque<String> path, String beginWord, String cur, List<List<String>> res
        ) {
            if (cur.equals(beginWord)) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (String precursor : src.get(cur)) {
                path.addFirst(precursor);
                backTrack(src, path, beginWord, precursor, res);
                path.removeFirst();
            }
        }
    }
}