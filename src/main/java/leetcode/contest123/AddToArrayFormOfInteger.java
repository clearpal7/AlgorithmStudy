package leetcode.contest123;

import java.util.ArrayList;
import java.util.List;

public class AddToArrayFormOfInteger {

    public static void main(String[] args) {
        int[] A= {1,2,0,0};
        int K = 34;
        List<Integer> result = addToArrayForm(A, K);

        for(Integer a : result) {
            System.out.println(a);
        }
    }

    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<>();
        for(int i = A.length - 1; i >= 0 ; i--) {
            result.add(0, (A[i] + K) % 10);
            K = (A[i] + K) / 10;
        }

        while(K > 0) {
            result.add(0, K % 10);
            K = K / 10;
        }

        return result;
    }
}
