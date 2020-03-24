package educative.knapsack;

public class BottomUpKnapsack {

    public static int solveKnapsack(int[] profits, int[] weights, int capacity) {
        int[][] dp = new int[profits.length][capacity + 1];

        for(int i = 0; i < profits.length; i++) {
            dp[i][0] = 0;
        }

        for(int c = 1; c <= capacity; c++) {
            if(weights[0] <= c)
            dp[0][c] = profits[0];
        }

        for(int i = 1; i < profits.length; i++) {
            for(int c = 1; c <= capacity; c++) {
                int profit1 = 0;
                int profit2 = 0;

                if(weights[i] <= c)
                    profit1 =profits[i] + dp[i-1][c-weights[i]];
                profit2 = dp[i-1][c];

                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        printSelectedElements(dp, weights, profits, capacity);

        return dp[profits.length - 1][capacity];
    }

    private static void printSelectedElements(int dp[][], int[] weights, int[] profits, int capacity){
        int totalHit = dp[profits.length - 1][capacity];
        for(int i = weights.length - 1; i >0; i--) {
            if(dp[i-1][capacity] != totalHit) {
                System.out.println("Included : " + weights[i]);
                capacity -= weights[i];
                totalHit -= profits[i];
            }
        }

        if(totalHit != 0)
            System.out.println("Included: " + weights[0]);
    }

    public static void main(String[] args) {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
