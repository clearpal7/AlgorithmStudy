package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RegionsCutBySlashes_959 {

    public static void main(String[] args) {

        String[] strings = {"\\/",
                "/\\"};
        System.out.print(regionsBySlashes(strings));
    }

    public static int regionsBySlashes(String[] grid) {
        int size = grid.length;
        int[][] scaleGrid = new int[3 * size][3 * size];

        for(int i = 0 ; i < size; i++) {
            for(int j = 0; j < size; j++) {

                if(grid[i].charAt(j) == '\\') {
                    scaleGrid[3 * i][3 * j] = 1;
                    scaleGrid[3 * i + 1][3 * j + 1] = 1;
                    scaleGrid[3 * i + 2][3 * j + 2] = 1;

                } else if(grid[i].charAt(j) == '/') {
                    scaleGrid[3 * i][3 * j + 2] = 1;
                    scaleGrid[3 * i + 1][3 * j + 1] = 1;
                    scaleGrid[3 * i + 2][3 * j] = 1;
                }
            }
        }

        List<Pair> zeros = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < scaleGrid.length ; i++) {
            for (int j = 0; j < scaleGrid[i].length; j ++) {
                if(scaleGrid[i][j] == 0) {
                    Pair pair = new Pair(i, j);
                    dfs(pair, scaleGrid);
                    count++;
                }
            }
        }

        return count;
    }

    public static void dfs(Pair pair, int[][] scaleGrid) {
        int x = pair.x;
        int y = pair.y;
        int N = scaleGrid[0].length;

        if(x < 0 || x >=N || y < 0 || y>=N || scaleGrid[x][y] == 1) return;
        scaleGrid[pair.x][pair.y] = 1;
        int[] coord = {0, -1, 0, 1, 0};
        for(int index = 0; index < coord.length - 1; index++) {

            dfs(new Pair(pair.x + coord[index], pair.y + coord[index + 1]), scaleGrid);
        }
    }
}

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
