package educative.TwoPointers;

public class SortedArraySquares {

    public static int[] makeSquares(int[] arr) {
        int n = arr.length;
        int[] sortedSquare = new int[n];
        int left = 0;
        int right = n - 1;
        int insertIndex = n - 1;

        while(left <= right) {
            int leftSq = arr[left] * arr[left];
            int rightSq = arr[right] * arr[right];

            if(leftSq < rightSq) {
                sortedSquare[insertIndex--] = rightSq;
                --right;
            } else {
                sortedSquare[insertIndex--] = leftSq;
                ++left;
            }
        }
        return sortedSquare;
    }

    public static void main(String[] args) {

        int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}
