package educative.twoheaps;

import java.util.PriorityQueue;

public class MaximizeCapital {


    public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
        int n = capital.length;

        PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<Integer>(n, (i1,i2) -> capital[i1] - capital[i2]);
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<Integer>(n, (p1, p2) -> profits[p2] - profits[p1]);

        for(int i = 0; i < capital.length; i++)
            minCapitalHeap.offer(i);

        int currentCapital = initialCapital;
        for(int i = 0; i < numberOfProjects; i++) {

            while(!minCapitalHeap.isEmpty() && capital[minCapitalHeap.peek()] <= currentCapital) {
                maxProfitHeap.offer(minCapitalHeap.poll());
            }

            if(maxProfitHeap.isEmpty())
                break;

            currentCapital += profits[maxProfitHeap.poll()];
        }

        return currentCapital;
    }



    public static void main(String[] args) {
        int result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2 }, new int[] { 1, 2, 3 }, 2, 1);
        System.out.println("Maximum capital: " + result);
        result = MaximizeCapital.findMaximumCapital(new int[] { 0, 1, 2, 3 }, new int[] { 1, 2, 3, 5 }, 3, 0);
        System.out.println("Maximum capital: " + result);
    }
}
