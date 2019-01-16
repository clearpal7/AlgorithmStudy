package leetcode.contest118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PancakeSoring_969 {

    public static void main(String[] args) {
        int[] A = {3,2,4,1};
        List<Integer> result = pancakeSort(A);

        for(int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();
        int n = A.length, largest = n;
        for (int i = 0; i < n; i++) {
            int index = find(A, largest);
            flip(A, index);
            flip(A, largest - 1);
            result.add(index + 1);
            result.add(largest--);
        }
        return result;
    }
    private static int find(int[] A, int target) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] == target) {
                return i;
            }
        }
        return -1;
    }
    private static void flip(int[] A, int index) {
        int i = 0, j = index;
        while (i < j) {
            int temp = A[i];
            A[i++] = A[j];
            A[j--] = temp;
        }
    }

}
