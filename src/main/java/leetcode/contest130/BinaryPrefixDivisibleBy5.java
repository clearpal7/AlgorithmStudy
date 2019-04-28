package leetcode.contest130;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {

    public static void main(String[] args) {
        int[] A = {1,1,0,0,0,1,0,0,1};
        System.out.println(prefixesDivBy5(A));
    }

    public static List<Boolean> prefixesDivBy5(int[] A) {
        StringBuilder stringBuilder;
        List<String> binary = new ArrayList<>();

        for(int i = 0; i < A.length; i++) {
            stringBuilder = new StringBuilder();

            for(int j = 0; j <= i; j++) {
                stringBuilder.append(A[j]);
            }
            binary.add(stringBuilder.toString());
        }

        List<Boolean> result = new ArrayList<>();
        for(int i = 0; i < binary.size(); i++) {
            result.add(isCheckDivisibleBy5(binary.get(i)));
        }
        return result;
    }

    private static boolean isCheckDivisibleBy5(String number) {
        int num = 0;
        int two = 0;
        for(Character c : number.toCharArray()) {
            if(c == '1') {
                num += 1 << two;
            }
            ++two;
        }

        if(num % 5 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
