package leetcode.contest123;

public class BrokenCalculator {

    public int brokenCalc(int X, int Y) {

        if(X > Y) {
            return X - Y;
        }

        int operations = 0;

        while(Y > X) {
            if(Y % 2 == 0) {
                Y = Y /2;
            } else {

            }
            operations++;
        }

        return operations + X - Y;
    }

}
