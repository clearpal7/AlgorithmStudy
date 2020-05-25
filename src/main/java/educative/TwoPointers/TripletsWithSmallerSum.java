package educative.TwoPointers;


import java.util.*;

public class TripletsWithSmallerSum {

    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[] { -1, 0, 2, 3 }, 3));
        System.out.println(searchTriplets(new int[] { -1, 4, 2, 1, 3 }, 5));
    }

    public static List<List<Integer>> searchTriplets(int[] arr, int target) {
        int count = 0;
        Arrays.sort(arr);
        List<List<Integer>> indices = new ArrayList<>();

        for(int i = 0; i < arr.length - 2; i++) {
            getCount(i, i + 1, target - arr[i], arr, indices);
        }

        return indices;
    }

    private static int getCount(int first, int left, int targetSum, int[] arr, List<List<Integer>> indices) {
        int count = 0;
        int right = arr.length - 1;

        while(left < right) {
            int currentSum = arr[left] + arr[right];
            if(currentSum < targetSum) {
                for(int i = right; i > left ; i--) {
                    indices.add(Arrays.asList(arr[first], arr[left], arr[i]));
                }
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}
