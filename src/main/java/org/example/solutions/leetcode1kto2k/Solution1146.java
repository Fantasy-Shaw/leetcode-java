package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1146 {
    class SnapshotArray {
        // idx-[snapId,elem]
        private final Map<Integer, List<int[]>> map;
        private int snapId;

        public SnapshotArray(int length) {
            map = new HashMap<>();
            snapId = 0;
        }

        public void set(int index, int val) {
            map.putIfAbsent(index, new ArrayList<>());
            var elems = map.get(index);
            if (!elems.isEmpty() && elems.getLast()[0] == snapId) {
                elems.getLast()[1] = val;
            } else {
                elems.add(new int[]{snapId, val});
            }
        }

        public int snap() {
            return snapId++;
        }

        public int get(int index, int snap_id) {
            var elems = map.get(index);
            if (elems == null) {
                return 0;
            }
            int idx = upper_bound(elems, snap_id) - 1;
            return idx >= 0 ? elems.get(idx)[1] : 0;
        }

        private static int upper_bound(List<int[]> arr, int target) {
            int l = 0, r = arr.size();
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (arr.get(mid)[0] <= target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
}