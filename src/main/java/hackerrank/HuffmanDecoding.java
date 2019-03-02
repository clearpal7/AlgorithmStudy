package hackerrank;


import hackerrank.domain.Node;

public class HuffmanDecoding {

    public static void main(String[] args) {
        Node root = new Node();
        root.left = new Node('A', 5);
        root.right = new Node();

        Node levelOne = root.right;
        levelOne.left = new Node('R', 2);
        levelOne.right = new Node();

        Node levelTwo = levelOne.right;
        levelTwo.left = new Node();
        levelTwo.right = new Node('B', 2);

        Node levelThree = levelTwo.left;
        levelThree.left = new Node('C', 1);
        levelThree.right = new Node('D', 1);

        String s = "01111001100011010111100";

        decode(s, root);
    }

    static void decode(String s, Node root) {
        int index = 0;
        char[] sentence = s.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        Node currentNode = root;
        while(index < sentence.length) {

            while(currentNode.left != null && currentNode.right != null) {
                if(sentence[index] == '0') {
                    currentNode = currentNode.left;
                    index = index + 1;
                } else if(sentence[index] == '1') {
                    currentNode= currentNode.right;
                    index = index + 1;
                }
            }

            if(currentNode.left == null && currentNode.right == null) {
                stringBuilder.append(currentNode.data);
                currentNode = root;
            }
        }

        System.out.print(stringBuilder.toString());
    }
}
