package educative;

import java.util.PriorityQueue;

public class SlidingWindowMedian {

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

    public double[] findSlidingWindowMedian(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a - b);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for(int i = 0; i < nums.length; i++) {
            if(maxHeap.size() == 0 || maxHeap.peek() >= nums[i]) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            }
            rebalance(minHeap, maxHeap);

            if((i - k + 1) >= 0) {
                if(maxHeap.size() == minHeap.size()) {
                    result[i-k+1] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
                } else {
                    result[i-k+1] = maxHeap.peek();
                }

                //remove
                int elementToBeRemoved = nums[i - k + 1];
                if(maxHeap.peek() >= elementToBeRemoved) {
                    maxHeap.remove(elementToBeRemoved);
                } else {
                    minHeap.remove(elementToBeRemoved);
                }
                rebalance(minHeap, maxHeap);
            }
        }

        return result;
    }

    private void rebalance(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if(maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if(minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
}
