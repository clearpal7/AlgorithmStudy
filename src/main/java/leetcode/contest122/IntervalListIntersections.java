package leetcode.contest122;

import leetcode.domain.Interval;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

    public static void main(String[] args) {
        Interval[] intervalsA = new Interval[2];
        intervalsA[0] = new Interval(3, 5);
        intervalsA[1] = new Interval(9, 20);


        Interval[] intervalsB = new Interval[5];
        intervalsB[0] = new Interval(4, 5);
        intervalsB[1] = new Interval(7, 10);
        intervalsB[2] = new Interval(11, 12 );
        intervalsB[3] = new Interval(14, 15);
        intervalsB[4] = new Interval(16, 20);

        Interval[] result = intervalIntersection(intervalsA, intervalsB);

        for(int i = 0 ; i < result.length; i++) {
            System.out.println(result[i].start + ", " + result[i].end);
        }

    }

    public static Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        List<Interval> intervalList = new ArrayList<>();

        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B.length; j++) {
                if(A[i].start <= B[j].start && A[i].end >= B[j].start && A[i].end <= B[j].end) {
                    intervalList.add(new Interval(B[j].start, A[i].end));
                } else if(A[i].start >= B[j].start &&  A[i].start <= B[j].end && A[i].end >= B[j].end) {
                    intervalList.add(new Interval(A[i].start, B[j].end));
                } else if(A[i].start >= B[j].start && A[i].end <= B[j].end) {
                    intervalList.add(new Interval(A[i].start, A[i].end));

                } else if(B[j].start >= A[i].start && B[j].end <= A[i].end) {
                    intervalList.add(new Interval(B[j].start, B[j].end));
                }
            }
        }

        return intervalList.stream().toArray(Interval[]::new);
    }
}
