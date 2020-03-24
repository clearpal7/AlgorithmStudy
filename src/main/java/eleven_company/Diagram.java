package eleven_company;

import java.util.HashMap;
import java.util.Map;

public class Diagram {

    public static void main(String[] args) {
        String S = "aabcaabcabda";
        System.out.println(solution(S));
    }

    public static int solution(String S) {
        int max = 0;

        Map<String, Integer> stringToFirstIndexMap = new HashMap<>();
        for(int i = 0; i < S.length() - 1; i++) {
            String sub = S.substring(i, i + 2);
            if(stringToFirstIndexMap.containsKey(sub))  {
                int diff = i - stringToFirstIndexMap.get(sub);
                max = Math.max(max, diff);
            } else {
                stringToFirstIndexMap.put(sub, i);
            }
        }
        if(max != 0)
            return max;

        return -1;
    }
}
