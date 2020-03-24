package educative.bfs;

import leetcode.domain.TreeNode;

import java.util.*;

public class ReverseLevelOrderTraversal {

    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                list.add(current.val);
                if(current.left != null) {
                    queue.offer(current.left);
                }
                if(current.right != null) {
                    queue.offer(current.right);
                }
            }
            result.add(0, list);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
        System.out.println("Reverse level order traversal: " + result);
    }
}
