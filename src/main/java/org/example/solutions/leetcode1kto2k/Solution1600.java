package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1600 {
    class ThroneInheritance {
        String kingName;
        Map<String, List<String>> children;
        Set<String> deadPersons;

        public ThroneInheritance(String kingName) {
            this.kingName = kingName;
            children = new HashMap<>();
            deadPersons = new HashSet<>();
        }

        public void birth(String parentName, String childName) {
            children.computeIfAbsent(parentName, k -> new ArrayList<>()).add(childName);
        }

        public void death(String name) {
            deadPersons.add(name);
        }

        public List<String> getInheritanceOrder() {
            List<String> ans = new ArrayList<>();
            String p = kingName;
            dfs(ans, p);
            return ans;
        }

        private void dfs(List<String> ans, String p) {
            if (!deadPersons.contains(p)) {
                ans.add(p);
            }
            if (children.containsKey(p)) {
                for (var child : children.get(p)) {
                    dfs(ans, child);
                }
            }
        }
    }

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
}