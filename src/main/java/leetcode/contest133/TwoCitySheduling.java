package leetcode.contest133;

public class TwoCitySheduling {

    public static void main(String[] args) {
        int[][] e = {
                {259, 770},
                {448, 54},
                {926, 667},
                {184,139},
                {840,118},
                {577,469}
        };
        System.out.println(twoCitySchedCost(e));
    }

    public static int twoCitySchedCost(int[][] costs) {
        int sum = 0;

        for(int row = 0; row < costs.length; row++) {
            int min = costs[row][0];
            for(int col = 1; col < costs[row].length; col++) {
                min = Math.min(min, costs[row][col]);
            }
            sum += min;
        }
        return sum;
    }
}
