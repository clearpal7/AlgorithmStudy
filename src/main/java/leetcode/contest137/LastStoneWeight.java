package leetcode.contest137;

import java.util.*;


public class LastStoneWeight {

    public static void main(String[] args) {
        int[] arr = {2,7,4,1,8,1};
        System.out.println(lastStoneWeight(arr));
    }

    public static int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length, Comparator.reverseOrder());
        for(int i = stones.length - 1; i >=0 ; i--) {
            queue.add(stones[i]);
        }

        while(queue.size() > 1) {
            Integer one = queue.poll();
            Integer two = queue.poll();

            Integer result = one - two;
            if(result < 0) {
                result = result * -1;
            }

            if(result != 0) {
                queue.add(result);
            }
        }
        if(queue.size() == 0) {
            return 0;
        } else {
            return queue.poll();
        }
    }
}
