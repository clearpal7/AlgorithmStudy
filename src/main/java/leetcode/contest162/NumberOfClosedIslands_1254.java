package leetcode.contest162;

import leetcode.domain.Coordinate;

import java.util.*;

public class NumberOfClosedIslands_1254 {


    private static final int[][] direction = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public static void main(String[] args) {
            int[][] grid = {{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}};

            System.out.print(closedIsland(grid));
    }

    public static int closedIsland(int[][] grid) {
        int count = 0;
        final int maxX = grid.length;
        final int maxY = grid[0].length;

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] == 0) {
                    if(dfs(row,col, grid)) count++;
                }
            }
        }


        return count;
    }

    private static boolean dfs(int row, int col, int[][] grid) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) return false;
        if(grid[row][col] == 1) return true;
        grid[row][col] = 1;
        boolean res = true;

        for(int[] dir : direction) {
            res = res && dfs(row + dir[0], col + dir[1], grid);
        }
        return res;
    }

}

