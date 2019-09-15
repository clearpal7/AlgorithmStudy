package leetcode.contest144;

import leetcode.domain.TreeNode;

import java.util.List;

public class DeleteNodesAndReturnForest_1110 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
    }

    /*public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

    }*/
}
