package educative;

public class RemoveDuplicates2 {

    public static void main(String[] args) {

    }

    public static int remove(int[] arr, int key) {
        int nextElement = 0;
        for(int i = 0; i < arr.length; i++) {
            if(key != arr[i]) {
                arr[nextElement] = arr[i];
                nextElement++;
            }
        }
        return nextElement;
    }
}
