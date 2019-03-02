package leetcode.domain;

public class Coordinate {
    public int x;
    public int y;
    boolean isVisited;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
        this.isVisited = false;
    }
}
