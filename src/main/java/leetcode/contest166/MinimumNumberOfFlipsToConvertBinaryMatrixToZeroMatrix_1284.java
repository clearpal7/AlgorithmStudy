package leetcode.contest166;

import java.util.HashMap;
import java.util.HashSet;

public class MinimumNumberOfFlipsToConvertBinaryMatrixToZeroMatrix_1284 {

    public static void main(String[] args) {
        int[][] mat = {{1,1,1},{1,0,1},{0,0,0}};
        System.out.print(minFlips(mat));
    }

    public static int minFlips(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        HashMap<String, Integer> dp = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        int answer = func(mat, m, n, dp, set);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private static int func(int[][]mat, int m, int n, HashMap<String, Integer> dp ,HashSet<String> set) {
        if(check(mat, m, n)) return 0;
        String t = "";

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                t += Integer.toString(mat[i][j]);
            }
        }
        if(set.contains(t)) return Integer.MAX_VALUE;
        if(dp.containsKey(t)) return dp.get(t);

        set.add(t);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                flip(mat, i, j, m, n);
                int small = func(mat, m, n, dp, set);
                if(small != Integer.MAX_VALUE) min = Math.min(min, 1 + small);
                flip(mat, i, j, m, n);
            }
        }
        set.remove(t);
        dp.put(t, min);
        return min;
    }

    private static void flip(int[][]mat, int i, int j, int m, int n) {
        mat[i][j] = mat[i][j] ^ 1;
        if(i - 1 >= 0) mat[i-1][j] = mat[i-1][j] ^ 1;
        if(j - 1 >= 0) mat[i][j-1] = mat[i][j-1] ^ 1;
        if(i + 1 < m) mat[i + 1][j] = mat[i + 1][j] ^ 1;
        if(j + 1 < n) mat[i][j + 1] = mat[i][j+1] ^ 1;
    }

    private static boolean check(int[][] mat, int m, int n) {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 1) return false;
            }
        }
        return true;
    }
}
