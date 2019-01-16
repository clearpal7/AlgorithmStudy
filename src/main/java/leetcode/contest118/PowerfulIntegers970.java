package leetcode.contest118;

import java.util.*;
import java.util.stream.Collectors;

public class PowerfulIntegers970 {

    public static void main(String[] args) {
        int x = 1;
        int y = 1;
        int bound  = 1;

        List<Integer> result = powerfulIntegers(x, y, bound);

        for(Integer r : result) {
            System.out.println(r);
        }
    }

    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> result = new HashSet<>();

        List<Integer> xPowerful = new ArrayList<>();
        List<Integer> yPowerful = new ArrayList<>();
        int tempX = 1;
        int tempY = 1;
        xPowerful.add(tempX);
        yPowerful.add(tempY);

        for(int i = 0; i < 1000000; i++) {
            if(tempX > bound || x == 1)
                break;
            tempX = tempX * x;
            xPowerful.add(tempX);
        }

        for(int i = 0; i < 1000000; i++) {
            if(tempY > bound || y == 1)
                break;
            tempY = tempY * y;
            yPowerful.add(tempY);
        }

        for(int i = 0 ; i < xPowerful.size(); i++) {
            for(int j = 0; j < yPowerful.size(); j++) {
                if(xPowerful.get(i) + yPowerful.get(j) <= bound)
                    result.add(xPowerful.get(i) + yPowerful.get(j));
            }
        }

        return result.stream().collect(Collectors.toList());
    }
}
