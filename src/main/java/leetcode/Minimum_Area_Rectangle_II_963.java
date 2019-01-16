package leetcode;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/minimum-area-rectangle-ii/
public class Minimum_Area_Rectangle_II_963 {

    public static void main(String[] args) {


        int[][] points = {
                {1,2},
                {2,1},
                {1,0},
                {0,1}
        };

        System.out.println(minAreaFreeRect(points));
    }


    public static double minAreaFreeRect(int[][] points) {
        int N = points.length;

        Point[] point = new Point[N];
        Set<Point> pointSet = new HashSet<>();

        for(int i = 0; i < N; i++) {
            point[i] = new Point(points[i][0], points[i][1]);
            pointSet.add(point[i]);
        }

        double answers = Double.MAX_VALUE;

        for(int firstPoint = 0 ; firstPoint < N ; firstPoint++) {
            Point p1 = point[firstPoint];
            for(int secondPoint = firstPoint + 1 ; secondPoint < N ; secondPoint++) {
                Point p2 = point[secondPoint];
                for(int thirdPoint = secondPoint + 1; thirdPoint < N; thirdPoint++) {
                    Point p3 = point[thirdPoint];
                    Point p4 = new Point(p3.x - p2.x + p1.x, p3.y - p2.y + p1.y);
                    if(pointSet.contains(p4)) {
                        int dot = ((p2.x - p1.x) * (p3.x - p2.x) + (p2.y - p1.y) * (p3.y - p2.y));
                        if(dot == 0) {
                            double area = p1.distance(p2) * p1.distance(p3);
                            answers = Math.min(answers, area);
                        }
                    }
                }
            }
        }

        return answers;
    }
}
