package hackerrank;

public class InOrderTraversal {

    /*public static void inOrder(Node root) {

        if(root == null) return;

        if(root.left != null) {
            inOrder(root.left);
        }

        System.out.print(root.data + " ");

        if(root.right != null) {
            inOrder(root.right);
        }
    }*/

   /* public static void inOrder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        stack.push(root);

        Node prev = null;

        while(!stack.isEmpty()) {
            Node currentNode = stack.peek();

            if(prev == null || prev.left == currentNode) {

                if(currentNode.left != null) {
                    stack.push(currentNode.left);
                } else {
                    list.add(currentNode.data);
                    stack.pop();
                }
            } else if(currentNode.left == prev) {
                list.add(currentNode.data);
                stack.pop();
            } else if() {

            }

            prev = currentNode;
        }
    }*/
}
