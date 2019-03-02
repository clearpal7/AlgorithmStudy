package hackerrank;

import java.util.*;

public class MissingNumbers {

    public static void main(String[] args) {
        int[] A = {11,4,11,7,13,4,12,11,10,14};
        int[] B = {11,4,11,7,3,7,10,13,4,8,12,11,10,14,12};

        int[] ans = missingNumbers(A, B);
        for(int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    static int[] missingNumbers(int[] arr, int[] brr) {
        Map<Integer, List<Integer>> A = new HashMap<>();
        Map<Integer, List<Integer>> B = new HashMap<>();


        for(int i = 0; i < arr.length; i++) {
            A.computeIfAbsent(arr[i], t -> new ArrayList<>())
                            .add(arr[i]);
        }

        for(int i = 0; i < brr.length; i++) {
            B.computeIfAbsent(brr[i], t -> new ArrayList<>())
                            .add(brr[i]);
        }

        List<Integer> answer = new ArrayList<>();

        for(Integer i : B.keySet()) {
            if(B.containsKey(i) && !A.containsKey(i)) {
                answer.add(i);
            } else if(B.get(i).size() != A.get(i).size()) {
               answer.add(i);
            }

        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}
