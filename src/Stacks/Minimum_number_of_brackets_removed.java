package Stacks;
import java.util.Scanner;
import java.util.Stack;
public class Minimum_number_of_brackets_removed {
    public static int minimumBracket(String str){
        Stack<Character> st = new Stack<>();
        int n = str.length();
        for(int i=0; i<n; i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else {
                if (!st.empty() && st.peek() == '(') {
                    st.pop();
                } else{
                    st.push(ch);
                }
            }
        }
        return st.size();
    }
    public static void main(String[] args) {
//        String str = "()(())";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = sc.nextLine();
        System.out.println(minimumBracket(str));
    }
}
