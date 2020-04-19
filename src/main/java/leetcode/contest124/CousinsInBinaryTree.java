package leetcode.contest124;

import leetcode.domain.TreeNode;

import java.util.*;

public class CousinsInBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(isCousins(root, 5, 4));
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Map<Integer, Integer> depthMap = new HashMap<>();
        Map<Integer, Integer> parentNode = new HashMap<>();

        int depth = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        nodes.put(root.val, root);
        depthMap.put(root.val, depth);

        while(!queue.isEmpty()) {
           TreeNode node = queue.poll();
           int tempDepth = depthMap.get(node.val);

           if(node.left != null) {
              queue.add(node.left);

              nodes.put(node.left.val, node.left);
              depthMap.put(node.left.val, tempDepth + 1);
              parentNode.put(node.left.val, node.val);
           }

           if(node.right != null) {
               queue.add(node.right);

               nodes.put(node.right.val, node.right);
               depthMap.put(node.right.val, tempDepth + 1);
               parentNode.put(node.right.val, node.val);
           }
        }

        TreeNode one = nodes.get(x);
        TreeNode two = nodes.get(y);

        if(parentNode.get(one.val) == parentNode.get(two.val)) {
            return false;
        }
        else if(depthMap.get(one.val) == depthMap.get(two.val)) {
            return true;
        }
        return false;
    }
}
