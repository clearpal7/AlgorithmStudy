package leetcode.contest135;

public class MinimumScoreTriangulationofPolygon {

    public static void main(String[] args) {
        int[] A = {1,3,1,4,5};
        System.out.println(minScoreTriangulation(A));
    }

    public static int minScoreTriangulation(int[] A) {
        int n = A.length;
        int[][] dp = new int[n][n];

        for(int length = 2; length < n; length++) {
            for(int start = 0; start + length < n; start++) {
                int end = start + length;
                dp[start][end] = Integer.MAX_VALUE;
                for(int middle = start + 1; middle < end; middle++) {
                    dp[start][end] = Math.min(dp[start][end], A[start] * A[middle] * A[end] + dp[start][middle] + dp[middle][end]);
                }
            }
        }
        return dp[0][n-1];
    }
}
