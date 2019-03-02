package hackerrank;

import leetcode.domain.Node;

import java.util.*;

public class TopView {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        Node level2 = root.right;
        level2.left = new Node(5);
        level2.right = new Node(6);

        Node level3 = level2.left;
        level3.left = new Node(7);
        level3.right = new Node(8);

        topView(root);
    }

    public static void topView(Node root) {

        class Obj {
            Node node;
            int x;

            public Obj(Node node, int x) {
                this.node = node;
                this.x = x;
            }
        }

        Obj ROOT = new Obj(root, 0);
        //x좌표, level
        Map<Integer, Obj> levelMap = new TreeMap<>();
        levelMap.put(0, ROOT);

        Queue<Obj> queue = new LinkedList<>();
        queue.offer(ROOT);

        while(!queue.isEmpty()) {
            Obj currentObj = queue.poll();
            Node currentNode = currentObj.node;

            if(!levelMap.containsKey(currentObj.x)) {
                levelMap.put(currentObj.x , currentObj);
            }

            if(currentNode.left != null) {
                Obj left = new Obj(currentNode.left, currentObj.x - 1);
                queue.offer(left);
            }

            if(currentNode.right != null) {
                Obj right = new Obj(currentNode.right, currentObj.x + 1);
                queue.offer(right);
            }
        }

        for(Integer key : levelMap.keySet()) {
            System.out.print(levelMap.get(key).node.data + " ");
        }
    }
}
