package hackerrank;

import java.util.Comparator;
import java.util.PriorityQueue;

public class JesseAndCookies {

    public static void main(String[] args) {
        int k = 6;
        int[] A = {1,2,3,9,10,12};
        System.out.print(cookies(k, A));
    }

    static int cookies(int k, int[] A) {

        int count = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(new IComparator());

        for(int i = 0; i < A.length ; i++) {
            queue.add(A[i]);
        }

        while(queue.size() > 1) {
            if(queue.peek() >= k) {
                break;
            }
            int first = queue.poll();
            int second = queue.poll();
            int result = first * 1 + second * 2;
            queue.add(result);
            count+=1;
        }

        if(queue.peek() < k) {
            return -1;
        }
        return count;
    }
}
class IComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o1, o2);
    }
}
