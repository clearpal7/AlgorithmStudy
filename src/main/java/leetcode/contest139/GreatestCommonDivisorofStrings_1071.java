package leetcode.contest139;

import java.util.*;

public class GreatestCommonDivisorofStrings_1071 {

    public static void main(String[] args) {
        String str1 = "OBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNO";
        String str2 = "OBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNOOBCNO";
        System.out.println(gcdOfStrings(str1, str2));
    }

    public static String gcdOfStrings(String str1, String str2) {
        List<String> sub = getSubString(str2);
        String source = "";
        String s = "";
        for(int i = 0; i < sub.size(); i++) {
            source = str1;
            String temp = sub.get(i);
            String replace = source.replaceAll(temp, "");
            if("".equals(replace)) {
                if(temp.length() > s.length())
                    s = temp;
            }
        }
        return s;
    }

    private static List<String> getSubString(String str) {
        Set<String> isContain = new HashSet<>();
        List<String> stringList = new ArrayList<>();

        for(int i = 0; i < str.length(); i++) {
            String temp = str.substring(i, i + 1);
            if(isContain.contains(temp)) {
                break;
            } else {
                stringList.add(str.substring(0, i + 1));
                isContain.add(str.substring(0, i + 1));
            }
        }

        return stringList;
    }

}
