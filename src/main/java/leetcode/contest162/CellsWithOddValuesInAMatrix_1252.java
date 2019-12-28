package leetcode.contest162;

public class CellsWithOddValuesInAMatrix_1252 {

    public static void main(String[] args) {
        int n = 2;
        int m = 3;
        int[][] indices = {{0,1},{1,1}};

        System.out.println(oddCells(n, m, indices));
    }

    public static int oddCells(int n, int m, int[][] indices) {
        int[][] cells = new int[n][m];
        for(int[] index : indices) {
            int row = index[0];
            int col = index[1];

            for(int c = 0; c < m; c++)
                cells[row][c]++;
            for(int r = 0; r < n; r++)
                cells[r][col]++;
        }
        return check(n, m, cells);
    }

    private static int check(int n, int m, int[][] cells) {
        int count = 0;
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                if(cells[r][c] % 2 == 1)
                    ++count;
            }
        }
        return count;
    }
}
