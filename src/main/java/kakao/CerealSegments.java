package kakao;

import java.util.*;

public class CerealSegments {

    public static void main(String[] args) {
        int x = 3;
        List<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(5);
        arr.add(4);
        arr.add(6);
        arr.add(8);
        System.out.println(segment(x, arr));
    }

   /* public static int segment(int x, List<Integer> arr) {
        Queue<Integer> minPQ = new PriorityQueue<>();
        int count = 0;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.size(); i++) {
            minPQ.add(arr.get(i));
            ++count;
            if(count == x) {
                max = Math.max(max, minPQ.peek());
                minPQ.remove(arr.get(i - x + 1));
                --count;
            }
        }
        return max;
    }*/

    public static int segment(int x, List<Integer> arr) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> minQueue = new LinkedHashMap<>();
        int max = Integer.MIN_VALUE;

        int count = 0;
        for(Integer number : arr) {
            if(!stack.isEmpty()) {
                while(!stack.isEmpty() && stack.peek() < number) {
                    minQueue.put(stack.peek(), stack.peek());
                    stack.pop();
                }
                stack.push(number);
            } else {
                stack.push(number);
            }
            ++count;
            if(count == x) {
                Integer key = minQueue.get(0);
                max = Math.max(max, minQueue.get(0));
                minQueue.remove(key);
                --count;
            }
        }
        return count;
    }
}
