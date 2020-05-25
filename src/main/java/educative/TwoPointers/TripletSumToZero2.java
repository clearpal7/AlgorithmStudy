package educative.TwoPointers;

import java.util.*;

public class TripletSumToZero2 {

    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 }));
        System.out.println(TripletSumToZero.searchTriplets(new int[] { -5, 2, -1, -2, 3 }));
    }

    public static List<List<Integer>> searchTriplets(int[] arr) {
        List<List<Integer>> triplets = new ArrayList<>();
        Arrays.sort(arr);

        for(int i = 0; i < arr.length - 2; i++) {
            if(i > 0 && arr[i] == arr[i-1])
                continue;
            getSumZero(arr, i, -arr[i], triplets);
        }

        return triplets;
    }

    private static void getSumZero(int[] arr, int left, int targetSum, List<List<Integer>> triplets) {
        int right = arr.length - 1;

        while(left < right) {
            int currentSum = arr[left] + arr[right];
            if(currentSum == targetSum) {
                triplets.add(Arrays.asList(arr[left], arr[right], --targetSum));
                ++left;
                --right;
                while(left < right && arr[left] == arr[left - 1])
                    ++left;
                while(left < right && arr[right] == arr[right + 1])
                    --right;
            } else if(targetSum > currentSum) {
                left++;
            } else {
                right--;
            }


        }
    }
}
