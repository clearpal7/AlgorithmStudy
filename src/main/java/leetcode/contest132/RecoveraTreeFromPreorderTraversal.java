package leetcode.contest132;


import leetcode.domain.TreeNode;

import java.util.Stack;


public class RecoveraTreeFromPreorderTraversal {

    public static void main(String[] args) {
        String s = "1-401--349---90--88";
        TreeNode answer = recoverFromPreorder(s);
        System.out.println("ss");
    }

    public static TreeNode recoverFromPreorder(String S) {
        char[] ch = S.toCharArray();

        int dash = 0;

        Stack<TreeNode> stack = new Stack<>();

        for(int i = 0; i < ch.length; i++) {

            for (dash = 0; S.charAt(i) == '-'; i++) {
                dash++;
            }
            int val = 0;
            while(i < ch.length && ch[i] != '-') {
                val = val * 10 + (ch[i] - '0');
                ++i;
            }
            while (stack.size() > dash) {
                stack.pop();
            }

            TreeNode treeNode = new TreeNode(val);
            if(!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    TreeNode prevNode = stack.peek();
                    prevNode.left = treeNode;
                } else {
                    TreeNode prevNode = stack.peek();
                    prevNode.right = treeNode;
                }
            }
            stack.add(treeNode);
        }
        while(stack.size() > 1) {
            stack.pop();
        }

        return stack.pop();
    }
}
