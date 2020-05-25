package leetcodechallenge.firstweek;

import java.util.*;
public class HappyNumber {

    public static void main(String[] args) {
        int n = 19;
        System.out.println(isHappy(n));
    }

    public static boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();
        set.add(n);

        while(n != 1) {
            List<Integer> residuals  = divideTen(n);
            int sum = 0;
            for(Integer num : residuals) {
                sum += num * num;
            }
            if(set.contains(sum)) {
                return false;
            } else {
                set.add(sum);
            }
            n = sum;
        }
        return true;
    }

    private static List<Integer> divideTen(int sum) {
        List<Integer> list = new ArrayList<>();
        while(sum != 0) {
            int r = sum % 10;
            list.add(r);
            sum = sum / 10;
        }
        return list;
    }
}
