package educative.Kelements;

import java.util.*;

public class KClosestPointsToTheOrigin {

    public static List<Point> findClosestPoints(Point[] points, int k) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<>((p1, p2) -> p2.distFromOrigin() - p1.distFromOrigin());


        for(int i = 0; i < k; i++) {
            maxHeap.offer(points[i]);
        }

        for(int i = k; i < points.length; i++) {
            if(maxHeap.peek().distFromOrigin() > points[i].distFromOrigin()) {
                maxHeap.poll();
                maxHeap.offer(points[i]);
            }
        }

        return new ArrayList<>(maxHeap);
    }

    public static void main(String[] args) {
        Point[] points = new Point[] { new Point(1, 3), new Point(3, 4), new Point(2, -1) };
        List<Point> result = findClosestPoints(points, 2);
        System.out.print("Here are the k points closest the origin: ");
        for (Point p : result)
            System.out.print("[" + p.x + " , " + p.y + "] ");
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int distFromOrigin() {
        return (x * x) + (y * y);
    }
}
