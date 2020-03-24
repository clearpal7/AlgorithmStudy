package educative.Kelements;


import java.util.*;

public class KLargestNumbers {

    public static List<Integer> findKLargestNumbers(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for(int i = 0; i < k; i++) {
            pq.offer(nums[i]);
        }

        for(int i = k; i < nums.length; i++) {
            if(pq.peek() < nums[i]) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }

        return new ArrayList<>(pq);
    }

    public static void main(String[] args) {
        List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
        System.out.println("Here are the top K numbers: " + result);

        result = KLargestNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Here are the top K numbers: " + result);
    }
}
