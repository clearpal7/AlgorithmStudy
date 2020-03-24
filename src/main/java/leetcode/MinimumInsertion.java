package leetcode;

import java.util.Arrays;

public class MinimumInsertion {

    public static void main(String[] args) {

    }

    static int[][] m;
    public int minInsertions(String s) {
        int n = s.length();
        m = new int[n+1][n+1];
        for(int[] i : m)
            Arrays.fill(i, -1);
        return dp(0, s.length() - 1,s);
    }

    private static int dp(int i, int j, String s) {
        if(i>=j)
            return 0;

        if(m[i][j] != -1)
            return m[i][j];

        if(s.charAt(i) == s.charAt(j)) {
            return m[i][j] = dp(i+1, j-1, s);
        } else {
            return Math.min(1 + m[i-1][j] , 1 + m[i][j-1]);
        }
    }
}
