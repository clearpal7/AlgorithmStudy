package leetcode.contest164;

import java.util.LinkedHashMap;
import java.util.Map;

public class MinimumTimeVisitingAllPoints_1266 {

    public static void main(String[] args) {

        int[][] points = {{1, 1}, {3, 4}, {-1, 0}};
        System.out.print(minTimeToVisitAllPoints(points));

        /*Map<String, String> map = new LinkedHashMap<>(2);
        map.put("jeju", "jeju");
        map.put("seoul", "seoul");
        map.put("brazil", "brazil");
        for(Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey());
        }*/
    }

    public static int minTimeToVisitAllPoints(int[][] points) {
        int cnt = 0;
        int n = points.length;
        for(int i = 1 ; i < n; i++) {
            int dx = Math.abs(points[i][0] - points[i-1][0]);
            int dy = Math.abs(points[i][1] - points[i-1][1]);
            cnt += Math.max(dx, dy);
        }
        return cnt;
    }
}
