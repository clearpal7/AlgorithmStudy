package leetcode;


import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;


//완전 이진트리에 대한 개념
public class CheckCompletenessOfABinaryTree_958 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(5);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);

        System.out.print(isCompleteTree(root));
    }


    public static boolean isCompleteTree(TreeNode root) {
        if(root == null)
            return true;

        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = false;

        queue.add(root);

        while(!queue.isEmpty()) {
            TreeNode tempNode = queue.remove();

            if(tempNode.left != null) {

                if(flag == true)
                    return false;

                queue.add(tempNode.left);
            } else {
                flag = true;
            }

            if(tempNode.right != null) {

                if(flag == true)
                    return false;

                queue.add(tempNode.right);
            }
            else {
                flag = true;
            }
        }

        return true;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
