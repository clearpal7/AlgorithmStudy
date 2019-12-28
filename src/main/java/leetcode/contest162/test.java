package leetcode.contest162;

public class test {

    public static void main(String[] args) {

        int n = 2, m = 2;
        int [][] indices = {{1,1},{0,0}};
        System.out.println(oddCells(n, m, indices));
    }

    public static int oddCells(int n, int m, int[][] indices) {
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[m];
        for(int[] indice : indices) {
            rows[indice[0]] ^= true;
            cols[indice[1]] ^= true;
        }

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <m; j++) {
                cnt += (rows[i] ^ cols[j]) ? 1 : 0;
            }
        }
        return cnt;
    }
}
