package leetcode.contest122;

import java.util.ArrayList;
import java.util.List;

public class SumofEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < queries.length; i++) {
            int addVal = queries[i][0];
            int addIndex = queries[i][1];
            A[addIndex]+= addVal;
            result.add(sumOfEvenNumbers(A));
        }
        return result.stream().mapToInt(i->i).toArray();
    }

    private Integer sumOfEvenNumbers(int[] A){
        int count = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 0) {
                count+= A[i];
            }
        }
        return count;
    }
}
