package datastructure.threadedTree;


public class ThreadedNode {

    private int value;
    private ThreadedNode left;
    private ThreadedNode right;
    private boolean isLeftThreaded;
    private boolean isRightThreaded;

    public ThreadedNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ThreadedNode getLeft() {
        return left;
    }

    public void setLeft(ThreadedNode left) {
        this.left = left;
    }

    public ThreadedNode getRight() {
        return right;
    }

    public void setRight(ThreadedNode right) {
        this.right = right;
    }

    public boolean isLeftThreaded() {
        return isLeftThreaded;
    }

    public void setLeftThreaded(boolean leftThreaded) {
        isLeftThreaded = leftThreaded;
    }

    public boolean isRightThreaded() {
        return isRightThreaded;
    }

    public void setRightThreaded(boolean rightThreaded) {
        isRightThreaded = rightThreaded;
    }
}
