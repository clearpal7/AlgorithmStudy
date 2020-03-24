package educative.bfs;

import leetcode.domain.TreeNode;

import java.util.*;

public class LevelAverage {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> result = LevelAverage.findLevelAverages(root);
        System.out.print("Level averages are: " + result);
    }

    public static List<Double> findLevelAverages(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            double avg = 0.0;
            for(int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                avg += currentNode.val;

                if(currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            avg = avg / levelSize;
            result.add(avg);
        }

        return result;
    }
}
