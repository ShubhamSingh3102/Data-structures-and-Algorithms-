package Stacks;
import java.util.*;
public class Reverse_String_Using_Stack {
    public static String reverseString(String str){
        Stack<Character> st = new Stack<>();

        // phele puraa daal do
        for(int i = 0; i < str.length(); i++){
            st.push(str.charAt(i));
        }

        String ans = "";

        while(!st.empty()){
           ans += st.pop();
        }
        return ans;
    }
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(reverseString(str));
    }
}
