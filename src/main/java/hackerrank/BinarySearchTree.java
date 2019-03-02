package hackerrank;

import leetcode.domain.Node;

import java.util.Stack;

public class BinarySearchTree {

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);

        root.left.left = new Node(1);
        root.left.right = new Node(3);

        Node temp = insert(root, 6);
        System.out.print(temp.data);
    }

    public static Node insert(Node root, int data) {

        Node temp = new Node(data);
        temp.data = data;
        temp.left = null;
        temp.right = null;

        if(root == null) {
            root = temp;
            return root;
        }

       Stack<Node> stack = new Stack<>();
       stack.push(root);

       while(!stack.isEmpty()) {
           Node node = stack.pop();

           if(node.data >= data) {
               if(node.left == null) {
                   node.left = temp;
               } else {
                   stack.push(node.left);
               }
           } else if(node.data < data){
               if(node.right == null) {
                   node.right = temp;
               } else {
                   stack.push(node.right);
               }
           }


       }
       return root;
    }
}
