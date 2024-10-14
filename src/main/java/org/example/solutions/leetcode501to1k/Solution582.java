package org.example.solutions.leetcode501to1k;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution582 {
    class Solution {
        private Map<Integer, List<Integer>> map;

        public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
            map = new HashMap<>();
            for (int i = 0; i < ppid.size(); i++) {
                if (ppid.get(i) > 0) {
                    map.putIfAbsent(ppid.get(i), new ArrayList<>());
                    map.get(ppid.get(i)).add(pid.get(i));
                }
            }
            List<Integer> l = new ArrayList<>();
            l.add(kill);
            getAllChildren(l, kill);
            return l;
        }

        private void getAllChildren(List<Integer> l, int kill) {
            if (map.containsKey(kill)) {
                for (int id : map.get(kill)) {
                    l.add(id);
                    getAllChildren(l, id);
                }
            }
        }
    }

}