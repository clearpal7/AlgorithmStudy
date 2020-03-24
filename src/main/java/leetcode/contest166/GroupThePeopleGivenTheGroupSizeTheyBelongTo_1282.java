package leetcode.contest166;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo_1282 {

    public static void main(String[] args) {
        int[] groupSizes = {2,1,3,3,3,2};
        List<List<Integer>> answer = groupThePeople(groupSizes);
        for(int i = 0; i < answer.size(); i++) {
            System.out.print("key : " + answer.get(i));
            for(int j = 0; j < answer.get(i).size(); j++) {
                System.out.print(answer.get(i).get(j) + ", ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> answers = new ArrayList<>();

        int size = groupSizes.length;
        Map<Integer, List<Integer>> countAndIndexes = new TreeMap<>();
        for(int index = 0; index < groupSizes.length; index++) {
            int key = groupSizes[index];
            countAndIndexes.computeIfAbsent(key, k -> new ArrayList<>()).add(index);
        }

        for(Integer key : countAndIndexes.keySet()) {
            List<Integer> index = countAndIndexes.get(key);
            int currentCount = 0;
            List<Integer> tempIndex = new ArrayList<>();

            for(int i = 0; i < index.size(); i++) {
                ++currentCount;
                tempIndex.add(index.get(i));
                if(currentCount == key) {
                    answers.add(tempIndex);
                    tempIndex = new ArrayList<>();
                    currentCount = 0;
                }
            }
        }
        return answers;
    }
}
