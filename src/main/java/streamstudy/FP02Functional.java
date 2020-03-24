package streamstudy;

import java.util.*;
import java.util.stream.Collectors;

public class FP02Functional {

    public static void main(String[] args) {
        int[] nums = new int[] {12, 9, 13, 4, 6, 2, 4, 12, 15};
        List<Integer> numbers = new ArrayList<>();
        Arrays.stream(nums).boxed().forEach(num -> numbers.add(num));

        List<Integer> doubleNumbers = doubleList(numbers);

        List<Integer> evenNumbersOnly = numbers.stream().filter(number -> number % 2 == 0)
                                        .collect(Collectors.toList());
    }

    private static List<Integer> doubleList(List<Integer> numbers) {
        return numbers.stream().map(number -> number * number).collect(Collectors.toList());
    }


}
