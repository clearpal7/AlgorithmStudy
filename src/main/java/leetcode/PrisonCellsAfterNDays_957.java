package leetcode;

import java.util.HashMap;
import java.util.Map;

public class PrisonCellsAfterNDays_957 {

    public static void main(String[] args) {
        int[] cells = {0,1,1,0,1,0,1,0};
        int N =8;

        int[] result = prisonAfterNDays(cells, N);

        for (int i = 0 ; i < result.length; i++) {
            System.out.print(result[i]);
            System.out.print(" ,");
        }
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {
        int currentDays = 0;
        Map<Integer, Integer> cache = new HashMap<>();
        Map<Integer, Integer> dayToCache = new HashMap<>();
        int encoded = encode(cells, cache);
        int days = 0;
        dayToCache.put(days, encoded);
        cache.put(encoded, days);

        int rowSize = cells.length -1;
        int nextDay[] = new int[cells.length];

        while(N > currentDays) {
            currentDays++;
            for(int index = 1; index < rowSize; index++) {

                if(cells[index-1] == cells[index+1]) {
                    nextDay[index] = 1;
                } else {
                    nextDay[index] = 0;
                }
            }

            sync(cells, nextDay);
            encoded = encode(cells, cache);

            if(cache.containsKey(encoded)) {
                int cycleStart = cache.get(encoded);
                int pos = cycleStart + (N - cycleStart) % (currentDays - cycleStart);
                return decode(dayToCache.get(pos));
            }

            days++;
            dayToCache.put(days, encoded);
            cache.put(encoded, days);
        }

        return cells;
    }

    private static int encode(int[] cells, Map<Integer, Integer> cache) {
        int encoded = 0;
        for(int index = 0; index < cells.length ;index++) {
            encoded += cells[index] << index;
        }
        return encoded;
    }

    private static int[] decode(int encoded) {
        int[] cells = new int[8];
        for(int index = 0; index < cells.length ; index++) {
            cells[index] = (encoded & (1 << index)) >> index;
        }
        return cells;
    }

    private static void sync(int[] cells, int[] nextDay) {
        for(int index = 0; index < cells.length; index++) {
            cells[index] = nextDay[index];
        }
    }
}
