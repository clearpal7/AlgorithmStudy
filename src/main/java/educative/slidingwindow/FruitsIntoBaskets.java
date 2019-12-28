package educative.slidingwindow;

import java.util.HashMap;

public class FruitsIntoBaskets {

    public static int findLength(char[] arr) {
        int maxLength = 0;
        int windowStart = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            char right = arr[windowEnd];
            map.put(right, map.getOrDefault(right, 0) + 1);

            while(map.size() > 2) {
                char left = arr[windowStart];
                map.put(left, map.get(left) - 1);
                if(map.get(left) == 0)
                    map.remove(left);
                windowStart++;
            }
        }
        return -1;
    }
}
