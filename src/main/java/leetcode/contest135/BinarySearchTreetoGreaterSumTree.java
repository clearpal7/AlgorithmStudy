package leetcode.contest135;


import leetcode.domain.TreeNode;

import java.util.*;

public class BinarySearchTreetoGreaterSumTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        TreeNode result = bstToGst(root);
        System.out.println(result.val);
    }

    public static TreeNode bstToGst(TreeNode root) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        TreeNode current = root;
        int sum = 0;

        while (true) {

            while (current.right != null) {
                stack.add(current.right);
                current = current.right;
            }
            if(stack.isEmpty()) {
                return root;
            }

            TreeNode node = stack.pop();
            sum += node.val;
            node.val = sum;

            if(node.left != null) {
                stack.add(node.left);
                current = node.left;
            }
        }

    }

}
