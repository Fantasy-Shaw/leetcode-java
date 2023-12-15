package org.example.solutions;

public class Solution75 {
    private class Solution {
        public void sortColors(int[] nums) {
            int[] tb = new int[3];
            for (int n : nums) {
                tb[n]++;
            }
            for (int i = 0; i < tb[0]; i++) {
                nums[i] = 0;
            }
            for (int i = tb[0]; i < tb[0] + tb[1]; i++) {
                nums[i] = 1;
            }
            for (int i = tb[0] + tb[1]; i < nums.length; i++) {
                nums[i] = 2;
            }
        }
    }
}
