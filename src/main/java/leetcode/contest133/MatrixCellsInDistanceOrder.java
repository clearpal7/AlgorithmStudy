package leetcode.contest133;


import java.util.*;

public class MatrixCellsInDistanceOrder {

    public static void main(String[] args) {

        int R = 3;
        int C = 4;
        int r0 = 0;
        int c0 = 1;
        int[][] r = allCellsDistOrder(R, C, r0, c0);
        for(int i = 0; i < r.length; i++) {
            for(int j = 0; j < r[i].length; j++) {
                System.out.println(i + ":" + j);
            }
        }
    }

    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        Map<Integer, Map<Integer, Integer>> distanceMap = new TreeMap<>();
        int count = 0;

        for(int row = 0; row < R; row++) {
            for(int col = 0; col < C; col++) {
                int distance = Math.abs(r0 - row) + Math.abs(c0 - col);
                distanceMap.computeIfAbsent(distance, k -> new HashMap<>());

                Map<Integer, Integer> coor = distanceMap.get(distance);
                coor.put(row, col);

                distanceMap.put(distance, coor);
                ++count;
            }
        }
        int[][] result = new int[count][2];
        int tRow = 0;
        Iterator iterator = distanceMap.keySet().iterator();

        while(iterator.hasNext()) {
            Integer key  = (Integer) iterator.next();
            Map<Integer, Integer> temp = distanceMap.get(key);
            Iterator it = temp.entrySet().iterator();
            while(it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Integer k = (Integer)entry.getKey();
                Integer v = (Integer) entry.getValue();

                result[tRow][0] = k;
                result[tRow][1] = v;
                ++tRow;
            }
        }
        return result;
    }
}
