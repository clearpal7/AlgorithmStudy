package leetcode.contest125;

public class AvailableCapturesForRook {

    public static void main(String[] args) {

    }

    public int numRookCaptures(char[][] board) {

        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                if(board[row][col] == 'R') {
                    return check(row, col, board);
                }
            }
        }
        return -1;
    }

    private static int check(int x, int y, char[][] board) {
        int[][] move = {
                {-1, 0}, {0, 1}, {1, 0}, {0, -1}
        };

        int rowSize = board.length;
        int colSize = board[0].length;
        int count = 0;

        for(int i = 0; i < move.length; i++) {
            int tempX = x;
            int tempY = y;

            while (tempX < rowSize && tempY < colSize && tempX >= 0 && tempY >= 0) {
                tempX += move[i][0];
                tempY += move[i][1];

                if (board[tempX][tempY] == 'p') {
                    count++;
                    break;
                }

                if(board[tempX][tempY] == 'B') {
                    break;
                }
            }
        }
        return count;
    }

}