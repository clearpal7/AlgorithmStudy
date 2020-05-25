package yanolza;

import java.util.Stack;

public class Task3 {

    public static void main(String[] args) {
        String S = "(())(()";
        System.out.println(solution2(S));
    }

    private static int solution2(String S) {
        if(S.charAt(0) == ')')
            return S.length();

        int count = 0;
        int index = 0;
        Stack<Character> stack = new Stack<>();
        stack.push(S.charAt(index++));

        while(!stack.isEmpty() && index < S.length()) {
            if(S.charAt(index) == '(') {
                stack.push('(');
            } else {
                if(stack.peek() == '(') {
                    ++count;
                    stack.pop();
                }
            }
            ++index;
        }

        if(index < S.length()) {
         count = 1 + S.length() - index;
        }
        return count;
    }
}
