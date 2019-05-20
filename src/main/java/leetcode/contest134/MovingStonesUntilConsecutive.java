package leetcode.contest134;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovingStonesUntilConsecutive {

    public static void main(String[] args) {
        int[] result = numMovesStones(4,3,2);

        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int[] numMovesStones(int a, int b, int c) {
        List<Integer> num = new ArrayList();
        num.add(a);
        num.add(b);
        num.add(c);

        Collections.sort(num);
        a = num.get(0);
        b = num.get(1);
        c = num.get(2);

        int minimumMoves = 2;
        int maximumMoves = 0;

        if(a > b && b > c) {
            return new int[]{maximumMoves, maximumMoves};
        }

        if(b > a && b - a != 1) {
            maximumMoves += (b - a - 1);

        }

        if(c > b && c - b != 1) {
            maximumMoves += (c - b - 1);
        }

        if(b-a == 1 && c-b == 1) minimumMoves = 0;
        else if(b-a<=2 || c-b<=2) minimumMoves = 1;


        return new int[] {minimumMoves, maximumMoves};

    }
}
