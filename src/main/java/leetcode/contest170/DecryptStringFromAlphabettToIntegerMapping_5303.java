package leetcode.contest170;

import java.util.HashMap;
import java.util.Map;

public class DecryptStringFromAlphabettToIntegerMapping_5303 {

    public static void main(String[] args) {
        String s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#";
        System.out.print(freqAlphabets(s));
    }

    public static String freqAlphabets(String s) {
        Map<String, Character> map = getInit();
        StringBuffer answer = new StringBuffer();
        int i = 0;
        while(i < s.length()) {
            if ((i + 2) < s.length() && Character.isDigit(s.charAt(i)) && '#' == s.charAt(i + 2)) {
                answer.append(map.get(s.substring(i, i + 3)));
                i = i+3;
            } else {
                answer.append(map.get(s.substring(i, i + 1)));
                ++i;
            }
        }
        return answer.toString();
    }

    private static Map<String, Character> getInit() {
        Map<String, Character> map = new HashMap<>();
        map.put("1", 'a');
        for(int i = 1; i <=9; i++) {
            map.put(Integer.toString(i), (char)('a' + (i-1)));
        }
        StringBuffer stringBuffer;
        for(int i = 10; i <=26; i++) {
           stringBuffer = new StringBuffer();
           map.put(stringBuffer.append(i).append("#").toString(), (char)('j'+ (i-10)));
        }
        return map;
    }
}
