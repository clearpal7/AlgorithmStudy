package leetcode.contest135;

public class ValidBoomerang {

    public static void main(String[] args) {
        int arr[][] = {{0,0},{2,0},{0,2}};

        System.out.println(isBoomerang(arr));
    }

    public static boolean isBoomerang(int[][] points) {
        boolean isParallel = true;

        double x1 = points[0][0];
        double y1=  points[0][1];

        double x2 = points[1][0];
        double y2 = points[1][1];

        double x3 = points[2][0];
        double y3= points[2][1];
        double firstGrad = 0;

        try {
            if(y2 == y1) {
                if(x2 == x1) {
                    return false;
                }
                firstGrad = 0;
            } else {
                if(x2 == x1) {
                    firstGrad = Double.POSITIVE_INFINITY;
                } else {
                    firstGrad = ((x2 - x1) / (y2 - y1));
                }
            }

        } catch (Exception e) {
            firstGrad = 0;
        }
        double secondGrad = 0;

        try {
            if(y3 == y1) {
                if(x3 == x1) {
                    return false;
                }
                secondGrad = 0;
            } else {
                if(x3 == x1) {
                    secondGrad = Double.POSITIVE_INFINITY;
                } else {
                    secondGrad = ((x3 - x1) / (y3 - y1));
                }
            }
        } catch (Exception e) {
            secondGrad = 0;
        }

        if(firstGrad == secondGrad)
            isParallel = false;

        return isParallel;
    }
}
