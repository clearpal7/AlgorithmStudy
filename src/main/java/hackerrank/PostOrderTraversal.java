package hackerrank;

import leetcode.domain.Node;

import java.util.*;

public class PostOrderTraversal {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        Node levelOneLeft = root.left;
        Node levelOneRight = root.right;

        levelOneLeft.left = new Node(4);
        levelOneLeft.right = new Node(5);

        levelOneRight.left = new Node(6);
        levelOneRight.right = new Node(7);

        postOrder(root);
    }

    /*public static void postOrder(Node root) {
        if(root == null) return;

        if(root.left != null) {
            postOrder(root.left);
        }

        if(root.right != null) {
            postOrder(root.right);
        }

        System.out.print(root.data + " ");
    }*/

    /*public static void postOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node currentNode = root;

        if(currentNode.right != null) {
            stack.push(currentNode.right);
        }
        stack.push(currentNode);
        currentNode = currentNode.left;

        while(!stack.isEmpty()) {

            if(currentNode != null && currentNode.right != null) {
                stack.push(currentNode.right);
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else if(currentNode != null && currentNode.right == null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else if (currentNode == null) {
                Node tempNode = stack.pop();

                if(!stack.isEmpty() && tempNode.right != null && tempNode.right.data == stack.peek().data) {
                    currentNode = stack.pop();
                    stack.push(tempNode);
                } else {
                    System.out.print(tempNode.data + " ");
                }
            }

        }
    }*/

    public static void postOrder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node prev = null;

        stack.push(root);

        while(!stack.isEmpty()) {
            Node currentNode = stack.peek();

            if(prev == null ||  prev.left == currentNode || prev.right == currentNode) {

                if(currentNode.left != null) {
                    stack.push(currentNode.left);
                } else if(currentNode.right != null) {
                    stack.push(currentNode.right);
                } else {
                    list.add(stack.peek().data);
                    stack.pop();
                }

            } else if(currentNode.left == prev) {
                if(currentNode.right != null) {
                    stack.push(currentNode.right);
                } else {
                    list.add(currentNode.data);
                    stack.pop();
                }

            } else if(currentNode.right == prev) {
                list.add(currentNode.data);
                stack.pop();
            }

            prev = currentNode;
        }
        for(Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

}
