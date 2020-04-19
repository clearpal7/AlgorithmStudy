package educative.TwoPointers;

import java.util.stream.Stream;

public class DutchNationalFlagProblem {

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 1, 0};
        sort(arr);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void sort(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        int i = 0;
        while(i<=high) {
            if(arr[i] == 0) {
                swap(arr, i, low);
                i++;
                low++;
            } else if(arr[i] == 1) {
                ++i;
            } else {
                swap(arr, i, high);

                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
