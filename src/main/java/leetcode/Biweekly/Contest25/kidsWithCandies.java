package leetcode.Biweekly.Contest25;
import java.util.*;
import java.util.stream.*;

public class kidsWithCandies {

    public static void main(String[] args) {
        int[] candies = {12,1,12};
        int extraCandies = 10;
        System.out.println(kidsWithCandies(candies, extraCandies));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Integer> candiesList = Arrays.stream(candies).boxed().collect(Collectors.toList());
        int max = candiesList.stream().max(Integer::compare).get();

        return candiesList.stream()
                .map(number -> number + extraCandies >= max)
                .collect(Collectors.toList());
    }
}
