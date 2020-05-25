package yanolza;

import java.util.LinkedHashMap;
import java.util.Map;

public class NumDivisibleConcatenation {

    public static void main(String[] args) {
        solution(24);
    }


    public static void solution(int N) {
        Map<Integer, Integer> numAndBit = init(N);
        Map<Integer, String> bitAndString = getStringByDivisibleNumber();

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 1; i <= N; i++) {
            if(numAndBit.get(i) == 0) {
                System.out.print(String.valueOf(i));

            } else {
                String temp = bitAndString.get(numAndBit.get(i));
                System.out.print(temp);
            }
            if(i != N)
                System.out.println();

        }
    }

    private static Map<Integer, Integer> init(int N) {
        Map<Integer, Integer> numAndBit = new LinkedHashMap<>();
        numAndBit.put(1, 0);
        for(int i = 2; i <= N; i++) {
            int bit = 0;
            if(i % 2 == 0) {
                bit = 1;
            }
            if(i % 3 == 0) {
                bit = bit | (1<<1);
            }
            if(i % 5 == 0) {
                bit = bit | (1<<2);
            }
            numAndBit.put(i, bit);
        }
        return numAndBit;
    }

    private static Map<Integer, String> getStringByDivisibleNumber() {
        Map<Integer, String> bitAndString = new LinkedHashMap<>();
        bitAndString.put(1, "Codility");
        bitAndString.put(2, "Test");
        bitAndString.put(3, "CodilityTest");
        bitAndString.put(4, "Coders");
        bitAndString.put(5, "CodilityCoders");
        bitAndString.put(6, "TestCoders");
        bitAndString.put(7, "CodilityTestCoders");
        return bitAndString;
    }
}
