package org.example.templates.interview;

import java.util.ArrayList;
import java.util.List;

public
class Heap {
    private final List<Integer> nums;

    public Heap() {
        nums = new ArrayList<>();
    }

    public Heap(List<Integer> nums) {
        this.nums = nums;
        buildHeap(nums.size());
    }

    public int top() {
        if (nums.isEmpty()) {
            return -1;
        }
        return nums.getFirst();
    }

    public void add(int x) {
        nums.add(x);
        int son = nums.size() - 1;
        int parent = (son - 1) / 2;
        while (parent >= 0 && nums.get(son) > nums.get(parent)) {
            swap(son, parent);
            son = parent;
            parent = (son - 1) / 2;
        }
    }

    public int[] heapSort() {
        int lastIdx = nums.size() - 1;
        for (int i = lastIdx; i >= 0; i--) {
            swap(0, i);
            heapify(0, i);
        }
        return nums.stream().mapToInt(i -> i).toArray();
    }

    public int pop() {
        if (nums.isEmpty()) {
            return -1;
        }
        int ans = nums.getFirst();
        swap(0, nums.size() - 1);
        nums.removeLast();
        heapify(0, nums.size());
        return ans;
    }

    private void heapify(int i, int len) {
        int l = i * 2 + 1, r = i * 2 + 2;
        int max = i;
        if (l < len && nums.get(max) < nums.get(l)) {
            max = l;
        }
        if (r < len && nums.get(max) < nums.get(r)) {
            max = r;
        }
        if (max != i) {
            swap(max, i);
            heapify(max, len);
        }
    }

    private void buildHeap(int len) {
        int lastIdx = nums.size() - 1;
        int lastParent = (lastIdx - 1) / 2;
        for (int i = lastParent; i >= 0; i--) {
            heapify(i, len);
        }
    }

    private void swap(int i, int j) {
        var t = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, t);
    }
}
