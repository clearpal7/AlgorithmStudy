package hackerrank;

import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args) {

        System.out.println(isBalanced("{[()]}"));
    }

    static String isBalanced(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        if(chars[0] == '(' || chars[0] == '{' || chars[0] == '[') {
            stack.push(chars[0]);
        } else {
            return "NO";
        }

        int index = 1;
        while (index < s.length()) {
            if(chars[index] == '(' || chars[index] == '{' || chars[index] == '[') {
                stack.push(chars[index]);
            } else if(chars[index] == ')') {
                if(stack.isEmpty()) return "NO";
                char temp = stack.pop();
                if(temp !='(')
                    return "NO";
            } else if (chars[index] == '}') {
                if(stack.isEmpty()) return "NO";
                char temp = stack.pop();
                if(temp !='{')
                    return "NO";
            } else if (chars[index] == ']') {
                if(stack.isEmpty()) return "NO";
                char temp = stack.pop();
                if(temp !='[')
                    return "NO";
            }
            ++index;
        }

        if(stack.isEmpty())
            return "YES";
        else
            return "NO";
    }


}
