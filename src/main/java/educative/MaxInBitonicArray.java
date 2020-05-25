package educative;

public class MaxInBitonicArray {

    public static int findMax(int[] arr) {
        int max = 0;
        int start = 0, end = arr.length - 1;
        while(start <= end) {
            int mid = start + ((end - start)>>>1);
            if(arr[start] <= arr[mid]) {
                start = mid + 1;
            }
        }
        return -1;
    }

}
