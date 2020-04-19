package leetcode.contest137;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }

    public static String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        int N = S.length();

        while(i < N) {
            if(!stack.isEmpty() && stack.peek() == S.charAt(i)) {
                stack.pop();

            } else {
                stack.push(S.charAt(i));
            }
            ++i;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

}
