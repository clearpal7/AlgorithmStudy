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

    @Override
    public int hashCode() {
        int result = this.x;
        result = result * 31 + this.y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
       if(obj == null)
           return false;
       if(this.getClass() != obj.getClass())
           return false;

       Coordinate coordinate = (Coordinate) obj;
       if(this.x == coordinate.x && this.y == coordinate.y)
           return true;
       else
           return false;
    }
}
