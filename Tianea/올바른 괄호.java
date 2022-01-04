import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(char ch : chars){
            if(ch == ')'){
                if(stack.isEmpty())
                    return false;
                stack.pop();
            }
            else
                stack.add(ch);        
        }
        return stack.isEmpty()?true : false;
    }
}