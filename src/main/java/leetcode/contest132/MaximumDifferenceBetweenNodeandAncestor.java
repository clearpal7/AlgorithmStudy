package leetcode.contest132;

import leetcode.domain.TreeNode;

import java.util.*;

public class MaximumDifferenceBetweenNodeandAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(10);

        System.out.println(maxAncestorDiff(root));
    }

    public static int maxAncestorDiff(TreeNode root) {
        Map<Integer, List<Integer>> map = getAncestorMap(root);
        int max = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            List<Integer> ancestors = map.get(curr.val);

            if(curr.left != null) {
                for(Integer i : ancestors) {
                    max = Math.max(max, Math.abs(i - curr.left.val));
                }
                queue.add(curr.left);
            }

            if(curr.right != null) {

                for(Integer i : ancestors) {
                    max = Math.max(max, Math.abs(i - curr.right.val));
                }
                queue.add(curr.right);
            }
        }


        return max;
    }

    private static Map<Integer, List<Integer>> getAncestorMap(TreeNode root) {
        Map<Integer, List<Integer>> ancestor = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        ancestor.put(root.val, temp);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            List<Integer> parents = ancestor.get(currentNode.val);

            if(currentNode.left != null) {
                List<Integer> leftParent = new ArrayList<>();
                leftParent.addAll(parents);
                leftParent.add(currentNode.left.val);

                ancestor.putIfAbsent(currentNode.left.val, leftParent);
                queue.add(currentNode.left);
            }

            if(currentNode.right != null) {
                List<Integer> rightParent = new ArrayList<>();
                rightParent.addAll(parents);
                rightParent.add(currentNode.right.val);

                ancestor.putIfAbsent(currentNode.right.val, rightParent);
                queue.add(currentNode.right);
            }

        }
        return ancestor;
    }
}
