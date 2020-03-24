package educative.bfs;

import leetcode.domain.TreeNode;
import java.util.*;

public class ConnectAllSiblings {

    public static void connect(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode currentNode = null;
        TreeNode previous = null;

        while(!queue.isEmpty()) {
            currentNode = queue.poll();

            if(previous != null)
                previous.next = currentNode;
            previous = currentNode;

            if(currentNode.left != null)
                queue.offer(currentNode.left);
            if(currentNode.right != null)
                queue.offer(currentNode.right);

        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectAllSiblings.connect(root);

        // level order traversal using 'next' pointer
        TreeNode current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
