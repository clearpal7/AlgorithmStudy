package review_leetcode;

import java.util.*;


public class Group_1282 {

    public static void main(String[] args) {
        int[] groupSizes = {3,3,3,3,3,1,3};
        List<List<Integer>> answer = groupThePeople2(groupSizes);
        for(List<Integer> list : answer) {
            for(Integer i : list) {
                System.out.print(i + ',');
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> groupThePeople2(int[] groupSizes) {
        Map<Integer, List<Integer>> map  = new HashMap<>();
        for(int i = 0; i < groupSizes.length; i++) {
            map.computeIfAbsent(groupSizes[i], c -> new ArrayList<>()).add(i);
        }

        List<List<Integer>> answer = new ArrayList<>();
        Set<Integer> keys = map.keySet();

        for(Integer key : keys) {
            List<Integer> temp = map.get(key);
            List<Integer> answerTemp = new ArrayList<>();
            int count = key;
            for(int i = 0; i < temp.size(); i++) {
                if(count == 0) {
                    answer.add(answerTemp);
                    count = key;
                    answerTemp = new ArrayList<>();
                } else {
                    answerTemp.add(temp.get(i));
                    --count;
                }
                if(i == temp.size() - 1) {
                    answer.add(answerTemp);
                }
            }
        }
        return answer;
    }
}
