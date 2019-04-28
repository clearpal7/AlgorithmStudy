package leetcode.contest131;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RemoveOutermostParentheses {

    public static void main(String[] args) {


        String example = "()()";
        System.out.println(removeOuterParentheses(example));
    }


    public static String removeOuterParentheses(String S) {
        StringBuilder result = new StringBuilder();
        List<String> subList = getParentheses(S);

        for(String temp : subList) {
            result.append(temp);
        }
        return result.toString();
    }

    private static List<String> getParentheses(String S) {
        int firstIndex = 0;
        List<String> subList = new ArrayList<>();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '(') {
                stack.add(S.charAt(i));
            } else if(S.charAt(i) == ')') {
                if(!stack.isEmpty()) {
                    stack.pop();
                } else {
                    break;
                }
            }

            if(stack.isEmpty()) {

                subList.add(S.substring(firstIndex + 1, i));
                firstIndex = i + 1;
            }
        }
        return subList;
    }
}
