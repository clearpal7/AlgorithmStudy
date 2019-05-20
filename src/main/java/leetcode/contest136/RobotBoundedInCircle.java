package leetcode.contest136;

public class RobotBoundedInCircle {

    public static void main(String[] args) {
        String sentence = "GL";
        System.out.println(isRobotBounded(sentence));
    }

    public static boolean isRobotBounded(String instructions) {
        char[] instruction = instructions.toCharArray();
        int[][] dir = {
                {0, 1}, {-1, 0}, {0, -1}, {1, 0}
        };
        int x = 0, y = 0, i = 0;
        for(int index = 0; index < instruction.length; index++) {
            if(instruction[index] == 'L') {
                i = (i + 1) % 4;
            } else if(instruction[index] == 'R') {
                i = (i + 3) % 4;
            } else {
                x += dir[i][0];
                y += dir[i][1];
            }
        }
        return (x == 0 && y == 0) || i > 0;
    }

}
