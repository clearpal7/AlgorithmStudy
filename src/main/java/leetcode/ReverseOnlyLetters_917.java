package leetcode;


import java.util.*;

public class ReverseOnlyLetters_917 {

    public static void main(String[] args) {
        String S = "ab-cd";
        System.out.println(reverseOnlyLetters(S));
    }

    public static String reverseOnlyLetters(String S) {

        char[] letters = S.toCharArray();
        List<Character> list = new ArrayList<>();
        Map<Integer, Character> indexLoc = new HashMap<>();

        for(int index = 0 ; index < letters.length; index++) {
            if(isUpperCase(letters[index]) && isLowerCase(letters[index])) {
                list.add(letters[index]);
            } else {
                indexLoc.put(index, letters[index]);
            }
        }

        Collections.reverse(list);
        StringBuilder stringBuilder = new StringBuilder();

        int pos = 0;

        for(int index = 0; index < letters.length; index++) {
            if(!indexLoc.containsKey(index)) {
                stringBuilder.append(list.get(pos));
                ++pos;
            } else {
                stringBuilder.append(indexLoc.get(index));
            }
        }
        return stringBuilder.toString();
    }

    private static boolean isUpperCase(char c) {
        if(c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }

    private static boolean isLowerCase(char c) {
        if(c >= 'a' && c <= 'z') {
            return true;
        }
        return false;
    }
}
