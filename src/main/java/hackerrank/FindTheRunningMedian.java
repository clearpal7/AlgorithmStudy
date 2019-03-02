package hackerrank;

import java.util.*;

/*public class FindTheRunningMedian {

    public static void main(String[] args) {

        int[] a = {1,2,3 ,4 ,5 ,6 ,7 ,8 ,9 ,10};
        double[] result = runningMedian(a);
        for(int i = 0 ; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    static double[] runningMedian(int[] a) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        Comparator<Integer> minComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1.doubleValue() > o2.doubleValue()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
        Comparator<Integer> maxComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1.doubleValue() < o2.doubleValue()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };

        double[] result = new double[a.length];
        minHeap.add(a[0]);
        maxHeap.add(a[0]);
        result[0] = a[0];
        for(int i = 1; i < a.length; i++) {
            result[i] = getMedian(numbers);

        }
        return result;
    }

    public static double getMedian(List<Integer> arr) {

        double avg = 0.0;
        if(arr.size() % 2 == 0) {
            int secondIndex = arr.size() / 2;
            int firstIndex = secondIndex - 1;

            avg = (arr.get(firstIndex) + arr.get(secondIndex)) / 2.0;
        } else {
            int midIndex = arr.size() / 2;
            avg = arr.get(midIndex);
        }

        return avg;
    }
}*/
