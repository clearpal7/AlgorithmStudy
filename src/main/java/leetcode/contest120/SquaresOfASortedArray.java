package leetcode.contest120;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SquaresOfASortedArray {

    public static void main(String[] args) {



    }

    public static int[] sortedSquares(int[] A) {

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < A.length; i++) {
            result.add(A[i] * A[ i]);
        }

        Collections.sort(result);
        return result.stream().mapToInt(i->i).toArray();
    }
}
