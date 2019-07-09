package datastructure.threadedTree;

import leetcode.domain.TreeNode;

import java.util.*;

public class ThreadedTree {

    public void insert(ThreadedNode root, int value) {
        ThreadedNode current = root;
        ThreadedNode parent = null;

        while (current != null) {
            if(current.getValue() == value) {
                return;
            }

            parent = current;

            if(current.getValue() < value) {
                if(current.isLeftThreaded() == false)
                    current = current.getRight();
                else
                    break;
            } else if(current.getValue() > value) {
                if(current.isRightThreaded() == false)
                    current = current.getLeft();
                else
                    break;
            }
        }
        ThreadedNode newNode = new ThreadedNode(value);
        newNode.setLeftThreaded(true);
        newNode.setRightThreaded(true);

        /*if(parent == null) {
            root =
        }*/
    }

    static List<TreeNode> res;
    static Set<Integer> toDelete;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        res = new ArrayList<>();
        toDelete = new HashSet<>();
        for(int d : to_delete)
            toDelete.add(d);
        helper(root, true);
        return res;
    }

    private static TreeNode helper(TreeNode root, boolean is_root) {
        if(root == null) return null;
        boolean deleted = toDelete.contains(root.val);
        if(is_root && !deleted) res.add(root);
        root.left = helper(root.left, deleted);
        root.right = helper(root.right, deleted);
        return deleted  ? null : root;
    }
}
