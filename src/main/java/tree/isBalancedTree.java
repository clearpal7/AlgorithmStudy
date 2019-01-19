package tree;

public class isBalancedTree {

    public static boolean isBalancedTree(TreeNode root) {
        if(root == null) return true;
        if(checkHeight(root) == - 1)
            return false;

        return true;
    }

    public static int checkHeight(TreeNode root) {
        if(root == null) return 0;

        int leftHeight = checkHeight(root.left);
        if(leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkHeight(root.right);
        if(rightHeight == -1) {
            return -1;
        }

        int diffHeight = leftHeight - rightHeight;
        if(Math.abs(diffHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}
