package leetcode.contest119;

import java.util.PriorityQueue;

public class KClosestPointstoOrigin {

    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int K = 2;

        int[][] ans = kClosest(points, K);
        for(int i = 0 ; i < ans.length; i++) {
            System.out.println(ans[i][0]+ ", " + ans[i][1]);
        }
    }

    public static int[][] kClosest(int[][] points, int K) {
        int[][] answers = new int[K][2];

        int[] zeroPoint = {0, 0};
        PriorityQueue<PointAndDis> queue = new PriorityQueue<>();
        PointAndDis pointAndDis;
        for(int row = 0 ; row < points.length; row ++) {
            double distance = Math.sqrt((points[row][0] - zeroPoint[0]) * (points[row][0] - zeroPoint[0]) +
                    (points[row][1] - zeroPoint[1]) * (points[row][1] - zeroPoint[1]));
            pointAndDis = new PointAndDis(points[row][0], points[row][1], distance);
            queue.add(pointAndDis);
        }

        for(int i = 0 ;i < K; i++) {
            PointAndDis temp = queue.poll();
            answers[i][0] = temp.getX();
            answers[i][1] = temp.getY();
        }

        return answers;
    }
}

class PointAndDis implements Comparable<PointAndDis> {
    int x;
    int y;
    double distance;

    public PointAndDis(int x, int  y, double distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(PointAndDis o) {
        if(this.distance < o.distance) {
            return -1;
        } else if (this.distance > o.distance){
            return 1;
        }
        return 0;
    }
}