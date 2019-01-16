package leetcode;


import java.util.LinkedList;
import java.util.Queue;


public class Univalued_Binary_Tree_965 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(2);


        System.out.println(isUnivalTree(root));
    }

    public static boolean isUnivalTree(TreeNode root) {

        boolean result = true;
        final int fixedValue = root.val;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            if(currentNode.val != fixedValue) {
                result = false;
                break;
            }

            if(currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if(currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        return result;
    }


}
