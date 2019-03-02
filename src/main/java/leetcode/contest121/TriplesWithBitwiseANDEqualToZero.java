package leetcode.contest121;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TriplesWithBitwiseANDEqualToZero {

    public static void main(String[] args) {
        int[] A = {2, 1, 3};
        System.out.println(countTriplets(A));
    }

    public static int countTriplets(int[] A) {

        Map<Integer, List<String>> map = new HashMap<>();

        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A.length; j++) {
                if(map.containsKey(A[i] & A[j])) {
                    map.get(A[i] & A[j]).add(A[i] + ":" + A[j]);
                } else {
                    map.computeIfAbsent(A[i] & A[j], k -> new ArrayList<>())
                            .add(A[i] + ":" + A[j]);

                }
            }
        }
        int count = 0;

        for(Integer key : map.keySet()){
            for(int i = 0;i < A.length;i++){
                if((key&A[i]) == 0) count+= map.get(key).size();
            }
        }
        return count;
    }
}
