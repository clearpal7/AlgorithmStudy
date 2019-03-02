package hackerrank;

import leetcode.domain.Node;

public class LowestCommonAncestor {

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(9);

        root.left.left = new Node(1);
        root.left.right = new Node(2);

        root.right.left = new Node(3);
        root.right.right = new Node(6);

        root.left.left.left = new Node(5);

        Node answer = lca(root, 1, 2);
        System.out.print(answer.data);
    }

    public static Node lca(Node root, int v1, int v2) {
       if(root == null) return null;

        if(root.data < v1 && root.data < v2) {
            return lca(root.right, v1, v2);
        }

        if(root.data > v1 && root.data > v2) {
            return lca(root.left, v1 ,v2);
        }

        return root;

    }

}
