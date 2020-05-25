package educative;

public class BinarySearch {

    public static int search(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;

        boolean isAccending = arr[left] < arr[right] ? true : false;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(arr[mid] == key) {
                return mid;
            }

            if(isAccending) {
                if(arr[mid] < key) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if(arr[mid] < key) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(BinarySearch.search(new int[] { 4, 6, 10 }, 10));
        System.out.println(BinarySearch.search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
        System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 10));
        System.out.println(BinarySearch.search(new int[] { 10, 6, 4 }, 4));
    }
}
