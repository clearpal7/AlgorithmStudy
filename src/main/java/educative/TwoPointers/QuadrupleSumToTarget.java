package educative.TwoPointers;

import java.util.*;

public class QuadrupleSumToTarget {

    public static void main(String[] args) {
        int[] arr = {2, 0, -1, 1, -2, 2};
        int target = 2;
        List<List<Integer>> answer = searchQuadruplets(arr, target);
        for(int i = 0; i < answer.size(); i++) {
            for(int j = 0; j < answer.get(i).size(); j++) {
                System.out.print(answer.get(i).get(j));
                System.out.print(",");

            }
            System.out.println();
        }
    }

    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        Arrays.sort(arr);

        for(int i = 0; i < arr.length - 3; i++) {
            if(i > 0 && arr[i] == arr[i-1])
                continue;
            for(int j = i + 1; j < arr.length - 2; j++) {
                if(j > i + 1 && arr[j] == arr[j-1])
                    continue;
                searchNumbers(arr, i, j, target, quadruplets);
            }
        }
        return quadruplets;
    }

    private static void searchNumbers(int[] arr, int first, int second, int target, List<List<Integer>> quadruplets) {
        int third = second + 1;
        int fourth = arr.length - 1;

        while(third < fourth) {
            int sum = arr[first] + arr[second] + arr[third] + arr[fourth];
            if(sum == target) {
                quadruplets.add(Arrays.asList(arr[first], arr[second], arr[third], arr[fourth]));
                third++;
                fourth--;
                while(third < fourth && arr[third] == arr[third-1])
                    third++;
                while(third < fourth && arr[fourth] == arr[fourth+1])
                    fourth--;
            } else if(sum < target) {
                third++;
            } else {
                fourth--;
            }
        }

    }
}
