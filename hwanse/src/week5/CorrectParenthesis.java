package week5;

import java.util.Stack;

public class CorrectParenthesis {

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        if (s.charAt(0) == ')') {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char element = s.charAt(i);

            if (element == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    stack.push(element);
                }
            } else {
                stack.push(element);
            }
        }

        return stack.isEmpty();
    }

}