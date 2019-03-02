package leetcode.contest120;



public class DistributeCoinsInBinaryTree {

    static int count = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(3);
        root.right = new TreeNode(0);

        System.out.println(distributeCoins(root));
    }

    public static int distributeCoins(TreeNode root) {

        postorder(root);
        return count;
    }

    public static int postorder(TreeNode root) {
        if(root == null) return 0;
        int left = postorder(root.left);
        int right = postorder(root.right);
        int sum = root.val - 1 + left + right;
        int abs = Math.abs(sum);
        count+= abs;
        return sum;
    }


}
class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }