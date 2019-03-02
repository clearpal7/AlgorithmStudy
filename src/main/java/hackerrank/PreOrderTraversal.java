package hackerrank;

import leetcode.domain.Node;

import java.util.Stack;

public class PreOrderTraversal {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.right = new Node(2);

        Node current = root.right;
        current.right = new Node(5);

        Node level2 = current.right;
        level2.left = new Node(3);
        level2.right = new Node(6);

        Node level3 = level2.left;
        level3.right = new Node(4);

        preOrder(root);
    }

    /*public static void preOrder(Node root) {
        if(root == null) return;

        System.out.print(root.data + " ");

        if(root.left != null) {
            preOrder(root.left);
        }

        if(root.right != null) {
            preOrder(root.right);
        }
    }*/

    public static void preOrder(Node root) {
        if(root == null) return;

        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.data + " ");

            if(node.left != null && node.right != null) {
                stack.push(node.right);
                stack.push(node.left);
                node = node.left;
            } else if(node.right != null) {
                stack.push(node.right);
                node = node.right;
            } else if(node.left != null){
                stack.push(node.left);
                node = node.left;
            }
        }
    }
}
