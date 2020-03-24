package educative;

public class SearchInfiniteSortedArray {

    public static void main(String[] args) {
        int[] arr = {4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};
        int key = 11;
        System.out.print(search(arr, key));
    }

    public static int search(int[] arr, int key) {
        int start = 0, end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(arr[mid] == key)
                return mid;

            if(arr[mid] > key) {
                end = mid - 1;
            } else  if(arr[mid] < key) {
                start = mid + 1;

            }
        }
        return -1;
    }
}
