package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1166 {
    class FileSystem {
        FileSysTreeNode root;

        public FileSystem() {
            root = new FileSysTreeNode();
        }

        public boolean createPath(String path, int value) {
            FileSysTreeNode t = root;
            String[] pp = path.split("/");
            for (int i = 0; i < pp.length; i++) {
                String p = pp[i];
                if (p.isEmpty()) continue;
                if (i < pp.length - 1 && !t.next.containsKey(p)) {
                    return false;
                }
                t.next.putIfAbsent(p, new FileSysTreeNode());
                t = t.next.get(p);
            }
            if (!t.next.isEmpty() || t.val != null) {
                return false;
            } else {
                t.val = value;
                return true;
            }
        }

        public int get(String path) {
            FileSysTreeNode t = root;
            String[] pp = path.split("/");
            for (int i = 0; i < pp.length; i++) {
                String p = pp[i];
                if (p.isEmpty()) continue;
                if (!t.next.containsKey(p)) {
                    return -1;
                }
                t = t.next.get(p);
            }
            return t.val == null ? -1 : t.val;
        }

        static class FileSysTreeNode {
            public Integer val = null;
            public HashMap<String, FileSysTreeNode> next = new HashMap<>();
        }
    }
}