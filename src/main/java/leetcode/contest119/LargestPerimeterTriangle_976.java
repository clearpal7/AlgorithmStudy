package leetcode.contest119;

import java.util.*;
import java.util.stream.Collectors;

public class LargestPerimeterTriangle_976 {

    public static void main(String[] args) {
        int[] A = {3,6,2,3};

        System.out.println(largestPerimeter(A));
    }

    public static int largestPerimeter(int[] A) {
        List<Integer> AList = Arrays.stream(A).boxed().collect(Collectors.toList());
        Collections.sort(AList);

        int max = 0;

        for(int i = AList.size() - 1 ; i >=2 ;i--) {
            if(AList.get(i) < AList.get(i - 1) + AList.get(i - 2)) {
                max = Math.max(max, AList.get(i) +  AList.get(i - 1) + AList.get(i - 2));
            }
        }

        return max;
    }
}
