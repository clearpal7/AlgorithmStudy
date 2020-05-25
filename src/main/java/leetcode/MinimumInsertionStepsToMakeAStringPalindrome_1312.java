package leetcode;

public class MinimumInsertionStepsToMakeAStringPalindrome_1312 {

    public static void main(String[] args) {

    }

    public static int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(s.charAt(i) == s.charAt(n - j - 1))
                    dp[i+1][j+1] = dp[i][j] + 1;
                else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return n - dp[n][n];
    }
}
