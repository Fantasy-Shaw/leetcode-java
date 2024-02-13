package org.example.solutions.leetcode501to1k;

import org.example.templates.UnionFind;

import java.util.*;

public class Solution721 {
    class Solution {
        static final int maxN = 1010;

        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            UnionFind uf = new UnionFind(maxN);
            int n = accounts.size();
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < accounts.get(i).size(); j++) {
                    String email = accounts.get(i).get(j);
                    if (map.containsKey(email)) {
                        uf.union(i, map.get(email));
                    }
                    map.put(email, i);
                }
            }
            Set<Integer> used = new HashSet<>();
            List<List<String>> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (used.contains(i)) {
                    continue;
                }
                used.add(i);
                Set<String> emails = new HashSet<>();
                emails.addAll(accounts.get(i));
                for (int j = i + 1; j < n; j++) {
                    if (uf.isConnected(i, j)) {
                        used.add(j);
                        emails.addAll(accounts.get(j));
                    }
                }
                String name = accounts.get(i).getFirst();
                emails.remove(name);
                List<String> sortedEmails = new ArrayList<>(emails);
                sortedEmails.sort(String::compareTo);
                List<String> cur = new ArrayList<>();
                cur.add(name);
                cur.addAll(sortedEmails);
                ans.add(cur);
            }
            return ans;
        }
    }
}