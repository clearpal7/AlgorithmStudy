package educative;

public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(RemoveDuplicates.remove(arr));
    }

    public static int remove(int[] arr) {
        int nextNonDuplicates = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[nextNonDuplicates] != arr[i]) {
                arr[nextNonDuplicates] = arr[i];
                ++nextNonDuplicates;
            }
        }
        return nextNonDuplicates;
    }
}
