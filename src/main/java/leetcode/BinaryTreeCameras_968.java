package leetcode;

public class BinaryTreeCameras_968 {

    public static void main(String[] args) {

    }

    static int res = 0;

    public int minCameraCover(TreeNode root) {
        return (dfs(root) < 1 ? 1 : 0) + res;
    }

    private static int dfs(TreeNode root) {
        if(root == null)
            return 2;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if(left == 0 || right == 0) {
            ++res;
            return 1;
        }

        if(left == 1 || right == 1) {
            return 2;
        }

        return 0;
    }
}
