package leetcode.contest122;


import leetcode.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SmallestStringStartingFromLeaf {

    static List<String> stringList = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(1);

        root.left.right = new TreeNode(1);
        root.left.right.left = new TreeNode(0);

        root.right.left = new TreeNode(0);

        System.out.println(smallestFromLeaf(root));
    }

    public static String smallestFromLeaf(TreeNode root) {
        String ans = "";
        return smallWords(root, ans);
    }

    private static String smallWords(TreeNode node, String answer) {
        if(node == null) return "~";
        char c = (char)(97 + node.val);

        if(node.left == null && node.right == null) {
            return String.valueOf(c);
        }

        String lt = smallWords(node.left, answer);
        String rt = smallWords(node.right, answer);

        return (lt.compareTo(rt) > 0 ? rt : lt) + c;
    }



}
