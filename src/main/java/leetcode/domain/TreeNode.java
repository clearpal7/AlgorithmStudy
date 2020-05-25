package leetcode.domain;

public class TreeNode {
    public int val;
    public int x;
    public int y;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;

    public TreeNode(int x) { val = x; }

    public void printLevelOrder() {
        TreeNode nextLevelRoot = this;

        while(nextLevelRoot != null) {
            TreeNode current = nextLevelRoot;
            nextLevelRoot = null;
            while(current != null) {
                System.out.println(current.val + " ");
                if(nextLevelRoot == null) {
                    if(current.left != null)
                        nextLevelRoot = current.left;
                    else if(current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
        }
    }
}