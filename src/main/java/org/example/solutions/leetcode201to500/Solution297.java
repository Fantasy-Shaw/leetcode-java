package org.example.solutions.leetcode201to500;

import org.example.utils.TreeNode;

import java.util.*;

public class Solution297 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            preOrder(root, sb);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            LinkedList<String> nodes = new LinkedList<>(Arrays.asList(data.split(" ")));
            return rebuild(nodes);
        }

        private void preOrder(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("# ");
                return;
            }
            sb.append(root.val).append(' ');
            preOrder(root.left, sb);
            preOrder(root.right, sb);
        }

        private TreeNode rebuild(LinkedList<String> nodes) {
            if (nodes.isEmpty()) return null;
            if (nodes.get(0).equals("#")) {
                nodes.remove(0);
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(nodes.get(0)));
            nodes.remove(0);
            root.left = rebuild(nodes);
            root.right = rebuild(nodes);
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}