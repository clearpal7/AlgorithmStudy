package educative.binarysearch;

public class RotationCountOfRotatedArray {

    public static int countRotations(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;

            if(left < mid && arr[mid - 1] > arr[mid])
                return mid;
            if(mid < right && arr[mid + 1] < arr[mid])
                return mid + 1;

            if(arr[mid] > arr[left]) {
                left = mid;
            } else {
                right = mid;
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 10, 15, 1, 3, 8 }));
        System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
        System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 1, 3, 8, 10 }));
    }
}
