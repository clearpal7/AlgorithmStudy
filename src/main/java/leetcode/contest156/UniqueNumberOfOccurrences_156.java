package leetcode.contest156;

import java.util.HashMap;
import java.util.Map;

public class UniqueNumberOfOccurrences_156 {

    public static void main(String[] args) {
        int[] arr = {1,2};
        System.out.print(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> numberCountMap = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();

        for(int i = 0; i < arr.length ; i++) {
            if(numberCountMap.containsKey(arr[i])) {
                numberCountMap.put(arr[i], numberCountMap.get(arr[i]) + 1);
            } else {
                numberCountMap.put(arr[i], 1);
            }

        }

        for(Integer value : numberCountMap.values()) {
            if(count.containsKey(value)) {
                return false;
            }
            count.put(value, value);
        }
        return true;
    }
}
