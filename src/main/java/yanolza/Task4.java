package yanolza;


import java.util.PriorityQueue;
import java.util.Queue;

public class Task4 {

    public static void main(String[] args) {
        int[] A = {1,2};
        System.out.println(solution(A));
    }
    public static int solution(int[] A) {
        Queue<ChainNumber> pq = new PriorityQueue<>(A.length);
        for(int index = 0; index < A.length; index++) {
            pq.add(new ChainNumber(index, A[index]));
        }
        int min = Integer.MAX_VALUE;
        ChainNumber first = pq.poll();
        ChainNumber second = pq.poll();
        ChainNumber third = pq.poll();
        ChainNumber fourth = pq.poll();

        return getMinValue(first, second, third, fourth);

    }

    private static int getMinValue(ChainNumber first, ChainNumber second, ChainNumber third, ChainNumber fourth) {
        int min = Integer.MAX_VALUE;
        if(rangeCheck(first, second) && (min > first.number + second.number))
            min = first.number + second.number;
        if(rangeCheck(first, third) && (min > first.number + third.number))
            min = first.number + third.number;
        if(rangeCheck(first, fourth) && (min > first.number + fourth.number))
            min = first.number + fourth.number;
        if(rangeCheck(second, third) && (min > second.number + third.number))
            min = second.number + third.number;
        if(rangeCheck(second, fourth) && (min > second.number + fourth.number))
            min = second.number + fourth.number;
        if(rangeCheck(third, fourth) && (min > third.number + fourth.number))
            min = third.number + fourth.number;
        return min;
    }

    private static boolean rangeCheck(ChainNumber prev, ChainNumber next) {
        if(prev.index != next.index - 1 && prev.index != next.index + 1)
            return true;
        return false;
    }
}
class ChainNumber implements Comparable {
    int index;
    int number;

    ChainNumber(int index, int number) {
        this.index = index;
        this.number = number;
    }


    @Override
    public int compareTo(Object o) {
        ChainNumber other = (ChainNumber) o;
        return this.number - other.number;
    }
}