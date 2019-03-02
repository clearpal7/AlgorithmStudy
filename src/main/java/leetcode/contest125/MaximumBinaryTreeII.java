package leetcode.contest125;

import leetcode.domain.TreeNode;

public class MaximumBinaryTreeII {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root!=null && root.val > val) {
            root.right = insertIntoMaxTree(root.right, val);
            return root;
        }
        TreeNode treeNode = new TreeNode(val);
        treeNode.left = root;
        return treeNode;
    }
}
