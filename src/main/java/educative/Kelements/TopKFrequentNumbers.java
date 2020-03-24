package educative.Kelements;

import java.util.*;
import java.util.stream.*;

public class TopKFrequentNumbers {

    public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Arrays.stream(nums).forEach(num -> frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1));

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((m1, m2) -> m1.getValue() - m2.getValue());

        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            minHeap.offer(entry);

            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return Stream.generate(minHeap::poll).map(entry -> entry.getKey()).limit(minHeap.size()).collect(Collectors.toList());
    }


    public static void main(String[] args) {
        List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}
