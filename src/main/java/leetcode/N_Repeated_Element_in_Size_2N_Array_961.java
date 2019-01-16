package leetcode;

import java.util.HashMap;
import java.util.Map;

public class N_Repeated_Element_in_Size_2N_Array_961 {

    public static void main(String[] args) {
        int[] A = {5,1,5,2,5,3,5,4};

        System.out.println(repeatedNTimes(A));
    }

    public static int repeatedNTimes(int[] A) {
        int answers = 0;
        Map<Integer, Integer> numbersAndTimes = new HashMap<>();
        Map<Integer, Integer> timeAndNumbers = new HashMap<>();


        for(int i = 0; i < A.length; i++) {
            if(numbersAndTimes.containsKey(A[i])) {
                int temp = numbersAndTimes.get(A[i]) + 1;
                numbersAndTimes.put(A[i], temp);
                timeAndNumbers.put(temp, A[i]);
            } else {
                numbersAndTimes.put(A[i], 1);
                timeAndNumbers.put(1, A[i]);
            }
        }

        int size = A.length;
        int N = A.length / 2;
        if(timeAndNumbers.containsKey(N)) {
            answers = timeAndNumbers.get(N);
        }
        return answers;
    }

}
