package Stacks;
import java.util.*;
public class Valid_parentheses {
    public static boolean isValid(String s){
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            } else {
                if(st.isEmpty()){
                    return false;
                }
                char top = st.pop();
                if((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')){
                    return false;
                }
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String s = "({})[";
        System.out.println(isValid(s));
    }
}
