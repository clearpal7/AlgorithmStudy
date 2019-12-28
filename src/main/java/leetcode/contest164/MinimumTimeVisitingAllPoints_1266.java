package leetcode.contest164;

import java.util.LinkedHashMap;
import java.util.Map;

public class MinimumTimeVisitingAllPoints_1266 {

    public static void main(String[] args) {

        int[][] points = {{1, 1}, {3, 4}, {-1, 0}};
        //System.out.print(minTimeToVisitAllPoints(points));

        Map<String, String> map = new LinkedHashMap<>(2);
        map.put("jeju", "jeju");
        map.put("seoul", "seoul");
        map.put("brazil", "brazil");
        for(Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

    public static int minTimeToVisitAllPoints(int[][] points) {
        int cnt = 0;
        int fX = points[0][0];
        int fY = points[0][1];

        for(int i = 1; i < points.length; i++) {
            int cur[] = points[i];
            int prev[] = points[i - 1];
            cnt += Math.max(Math.abs(cur[0] - prev[0]), Math.abs(cur[1] - prev[1]));
        }
        return cnt;
    }
}
