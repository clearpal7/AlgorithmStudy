package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    public static List<Integer> list;

    public static void main(String[] args) {
        list = new ArrayList<>();
        int[] arr = {1, 2, 3, 4};
        int n = 4;
        int k = 4;
        perm(arr, 0, n, k);
        for(Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println("Size : " + list.size());
    }

    public static void perm(int[] arr, int depth, int n, int k) {

        if(depth == n) {
            list.add(convertArrayToInt(arr));
            return;
        }

        for(int i = depth; i <n ;i++) {
            swap(arr, depth, i);
            perm(arr, depth + 1, n, k);
            swap(arr, i, depth);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int convertArrayToInt(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < arr.length; i++) {
            stringBuilder.append(arr[i]);
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}
