package educative.TwoPointers;

public class MinumumWindowSort {

    public static void main(String[] args) {
        System.out.println(sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
        System.out.println(sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
        System.out.println(sort(new int[] { 1, 2, 3 }));
        System.out.println(sort(new int[] { 3, 2, 1 }));
    }

    public static int sort(int[] arr) {

        int low = 0, high = arr.length - 1;

        while(low < arr.length - 1 && arr[low] <= arr[low + 1])
            low++;
        while(high > 0 && arr[high] >= arr[high - 1])
            high--;

        if(low == arr.length - 1)
            return 0;

        int subArrayMin = Integer.MAX_VALUE;
        int subArrayMax = Integer.MIN_VALUE;

        for(int i = low; i <= high; i++) {
            subArrayMin = Math.min(subArrayMin, arr[i]);
            subArrayMax = Math.max(subArrayMax, arr[i]);
        }

        while(low > 0 && subArrayMin < arr[low - 1])
            low--;
        while(high < arr.length - 1 && subArrayMax > arr[high + 1])
            high++;

        return high - low + 1;
    }
}
