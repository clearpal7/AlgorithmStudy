package leetcode.contest175;

import java.util.*;

public class CheckIfNandItDoubleExist_1346 {

    public static void main(String[] args) {
        int[] arr = {0,0};
        System.out.println(checkIfExist(arr));
    }

    public static boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> numberSet = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            numberSet.put(arr[i], i);
        }

        for(int i = 0; i < arr.length; i++) {
            if(numberSet.containsKey(arr[i] * 2) && i != numberSet.get(arr[i] * 2))
                return true;
        }
        return false;
    }
}
