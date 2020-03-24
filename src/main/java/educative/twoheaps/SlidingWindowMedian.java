package educative.twoheaps;

import java.util.*;

public class SlidingWindowMedian {


    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);

    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        int windowStart = 0;

        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            insert(nums[windowEnd]);

            if(windowEnd >= k - 1) {
                result[windowStart] = getMedian();
                remove(nums[windowStart]);
                ++windowStart;
            }

        }
        return result;
    }


    private void insert(int num) {
        if(maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        if(maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if(minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    private double getMedian() {
        if(minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }

    private void remove(int num) {
        if(maxHeap.peek() >= num)
            maxHeap.remove(num);
        else
            minHeap.remove(num);
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 2);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
        System.out.println();

        slidingWindowMedian = new SlidingWindowMedian();
        result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
        System.out.print("Sliding window medians are: ");
        for (double num : result)
            System.out.print(num + " ");
    }
}
