package educative.slidingwindow;

import java.util.HashMap;


public class PairWithTargetSum {

    public static void main(String[] args) {
        int[] arr = {2, 5, 9, 11};
        int targetSum =11;
        int[] ans = search(arr, targetSum);

        for(int i : ans) {
            System.out.println(i);
        }
    }

    /*public static int[] search(int[] arr, int targetSum) {
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(arrList);
        List<Integer> answer = new ArrayList<>(2);
        int pointerStart = 0;
        int pointerEnd = arrList.size() - 1;

        while(pointerStart < pointerEnd) {
            int tempSum = arrList.get(pointerStart) + arrList.get(pointerEnd);
            if(tempSum > targetSum) {
                pointerEnd--;
            } else if(tempSum < targetSum) {
                pointerStart++;
            } else {
                answer.add(pointerStart);
                answer.add(pointerEnd);
                break;
            }
        }


        return answer.stream().mapToInt(i->i).toArray();
    }*/

    public static int[] search(int[] arr, int targetSum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(targetSum - arr[i])) {
                return new int[] {map.get(targetSum - arr[i]), i};
            } else {
                map.put(arr[i], i);
            }
        }
        return new int[] {-1, -1};
    }
}
