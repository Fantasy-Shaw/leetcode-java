package org.example.solutions.LCR;

import org.example.utils.TreeNode;

import java.util.*;

public class P143 {
    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null) return false;
            if (check(A, B)) return true;
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        private boolean check(TreeNode A, TreeNode B) {
            if (B == null) return true;
            if (A == null || A.val != B.val) return false;
            return check(A.left, B.left) && check(A.right, B.right);
        }
    }
}