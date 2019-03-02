package hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumLoss {

    public static void main(String[] arg) {
        int N = 5;
        long[] arr = {20, 7, 8, 2, 5};
        System.out.println(minimumLoss(arr));
    }

    static int minimumLoss(long[] price) {

        Map<Long, Integer> map = new HashMap<>();
        for(int i = 0;i < price.length; i++) {
            map.put((Long)price[i], (int)i);
        }

        Arrays.sort(price);
        long min = Long.MAX_VALUE;

        for(int i = 0 ; i < price.length - 1 ; i++) {
            if(map.get(price[i+1]) < map.get(price[i])) {
                min = Math.min(price[i+1] - price[i], min);
            }
        }

        return (int)min;
    }
}
