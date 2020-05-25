package educative.Kelements;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ConnectRopes {

    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        Arrays.stream(ropeLengths).forEach(value -> minHeap.offer(value));

        int result = 0;

        while(minHeap.size() > 1) {
            int temp = minHeap.poll() + minHeap.poll();
            result += temp;
            minHeap.offer(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
        System.out.println("Minimum cost to connect ropes: " + result);
    }
}
