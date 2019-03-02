package hackerrank.domain;

public class Node {
    public int frequency;
    public char data;
    public Node left, right;

    public Node() {}

    public Node(char data, int freq) {
        this.data = data;
        this.frequency = freq;
    }
}
