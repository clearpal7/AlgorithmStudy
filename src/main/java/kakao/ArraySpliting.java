package kakao;

import java.util.ArrayList;
import java.util.List;

public class ArraySpliting {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(10);
        arr.add(4);
        arr.add(-8);
        arr.add(7);

        System.out.println(splitInTwo(arr));
    }

    public static int splitInTwo(List<Integer> arr) {
        List<Long> cumulativeSum = new ArrayList<>();
        Long totalSum = 0L;
        for(Integer number : arr) {
            totalSum += number;
            cumulativeSum.add(totalSum);
        }

        int count = 0;
        for(int index = 0; index < cumulativeSum.size() - 1; index++) {
            if((totalSum - cumulativeSum.get(index)) <= cumulativeSum.get(index))
                ++count;
        }
        return count;
    }
}
