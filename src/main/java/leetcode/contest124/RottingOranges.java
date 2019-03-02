package leetcode.contest124;

import leetcode.domain.Coordinate;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {
        int[][] coor = new int[3][1];
        coor[0][0] = 1;
        coor[1][0] = 2;
        coor[2][0] = 2;

        System.out.print(orangesRotting(coor));
    }

    public static int orangesRotting(int[][] grid) {

        int minute = 0;
        int rowSize = grid.length;
        int colSize = grid[0].length;

        int freshOrangeCount = getFreshCount(grid);
        if(freshOrangeCount == 0) {
            return 0;
        }
        Queue<Coordinate> rottenCoordinate = getRottenCoor(grid);
        int[][] direction = {
                {0, -1}, {1, 0}, {0, 1}, {-1, 0}
        };


        while(freshOrangeCount > 0 && !rottenCoordinate.isEmpty()) {
            ++minute;
            int size = rottenCoordinate.size();

            for(int time = 0; time < size; time++) {
                Coordinate coordinate = rottenCoordinate.poll();

                for (int i = 0; i < direction.length; i++) {
                    int row = coordinate.x + direction[i][0];
                    int col = coordinate.y + direction[i][1];

                    if (isRange(row, col, rowSize, colSize) && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        rottenCoordinate.add(new Coordinate(row, col));
                        freshOrangeCount = freshOrangeCount - 1;
                    }

                }
            }

        }

        if(freshOrangeCount != 0) {
            return  -1;
        }

        return minute;
    }

    private static boolean isRange(int x, int y, int rowSize, int colSize) {
        if(x < 0 || y < 0) {
            return false;
        }
        if(x >= rowSize || y >= colSize) {
            return false;
        }
        return true;
    }


    private static int getFreshCount(int[][] grid) {
        int count = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) count++;
            }
        }
        return count;
    }

    private static Queue<Coordinate> getRottenCoor(int[][] grid) {
        Queue<Coordinate> coor = new LinkedList<>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 2)  {
                    coor.add(new Coordinate(i, j));
                }
            }
        }
        return coor;
    }
}
