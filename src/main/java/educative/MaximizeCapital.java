package educative;

import java.util.PriorityQueue;

public class MaximizeCapital {

    public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
        int N = profits.length;
        PriorityQueue<Integer> minCapital = new PriorityQueue<>(N, (i1, i2) -> capital[i1] - capital[i2]);
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>(N, (i1, i2) -> profits[i2] - profits[i1]);

        for(int i = 0; i < N; i++) {
            minCapital.offer(i);
        }

        int availableCapital = initialCapital;
        for(int i = 0; i < numberOfProjects; i++) {

            while (!minCapital.isEmpty() && capital[minCapital.peek()] <= availableCapital) {
                maxProfit.offer(minCapital.poll());
            }

            if(maxProfit.isEmpty())
                break;

            availableCapital += profits[maxProfit.poll()];

        }
        return availableCapital;
    }


    public static void main(String[] args) {
        int result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
        System.out.println("Maximum capital: " + result);
        result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
        System.out.println("Maximum capital: " + result);
    }
}