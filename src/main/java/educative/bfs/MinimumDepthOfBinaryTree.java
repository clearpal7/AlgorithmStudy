package educative.bfs;

import leetcode.domain.TreeNode;

import java.util.*;

public class MinimumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + findDepth(root));
    }

    public static int findDepth(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while(!queue.isEmpty()) {
            ++depth;
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if(current.left == null && current.right == null)
                    return depth;
                if(current.left != null)
                    queue.offer(current.left);
                if(current.right != null)
                    queue.offer(current.right);
            }
        }
        return depth;
    }

}
