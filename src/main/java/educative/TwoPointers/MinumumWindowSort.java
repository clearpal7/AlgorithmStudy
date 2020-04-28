package educative.TwoPointers;

public class MinumumWindowSort {

    public static void main(String[] args) {
        System.out.println(sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
        System.out.println(sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
        System.out.println(sort(new int[] { 1, 2, 3 }));
        System.out.println(sort(new int[] { 3, 2, 1 }));
    }


    public static int sort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;


        while(left < right) {

            while(left < arr.length - 1&& arr[left] <= arr[left + 1])
                left++;
            while(right > 0 && arr[right] >= arr[right - 1])
                right--;

            if(left == arr.length - 1)
                return 0;

            int subArrayMin = Integer.MAX_VALUE;
            int subArrayMax = Integer.MIN_VALUE;

            for(int i = left; i <= right; i++) {
                subArrayMin = Math.min(subArrayMin, arr[i]);
                subArrayMax = Math.min(subArrayMax, arr[i]);
            }

            while(left > 0 && subArrayMin < arr[left - 1])
                left--;
            while(right < arr.length - 1 && subArrayMax > arr[right + 1])
                right--;

            return right - left + 1;
        }
        return - 1;
    }
}
