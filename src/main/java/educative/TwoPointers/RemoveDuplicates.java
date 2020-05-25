package educative.TwoPointers;

public class RemoveDuplicates {

    public static int remove(int[] arr) {
        int nextInsert = 1;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[nextInsert - 1]) {
                arr[nextInsert] = arr[i];
                ++nextInsert;
            }
        }
        return nextInsert;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(RemoveDuplicates.remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(RemoveDuplicates.remove(arr));
    }
}
