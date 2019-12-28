package leetcode;

public class NumberOfClosedIslands_1254 {

    private static final int[][] dir = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public int closedIsland(int[][] grid) {
        int cnt = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    if(dfs(grid, i, j)) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    private static boolean dfs(int[][] grid, int x, int y) {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) return false;

        if(grid[x][y] == 1) return true;

        grid[x][y] = 1;

        boolean res = true;

        for(int[] d : dir) {
            res = res & dfs(grid, x + d[0], y + d[1]);
        }
        return res;
    }
}
