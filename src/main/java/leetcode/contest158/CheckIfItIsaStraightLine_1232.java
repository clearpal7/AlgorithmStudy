package leetcode.contest158;

public class CheckIfItIsaStraightLine_1232 {

    public static void main(String[] args) {
        int[][] coordinates = {{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}};

        System.out.print(checkStraightLine(coordinates));
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        double basisIncline = (coordinates[1][1] - coordinates[0][1]) / (double)(coordinates[1][0] - coordinates[0][0]);

        for(int i = 2; i < coordinates.length; i++) {
            double temp = (coordinates[i][1] - coordinates[i - 1][1]) / (double)(coordinates[i][0] - coordinates[i - 1][0]);
            if(temp != basisIncline) {
                return false;
            }
        }
        return true;
    }
}
