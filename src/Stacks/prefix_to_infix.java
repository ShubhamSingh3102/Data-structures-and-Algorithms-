package Stacks;
import java.util.Stack;
public class prefix_to_infix {
    public static String prefixToInfix(String str){
        Stack<String> val = new Stack<>();
        int n = str.length();
        for(int i=n-1;i>=0;i--){
            char ch = str.charAt(i);
            int ascii = (int)ch;
            if(ascii>=48 && ascii<=57){ // string hi push krna hai val stack me...
                String s = "" + ch;
                val.push(s);
            }
            else{
                String v1 = val.pop();
                String v2 = val.pop();
                String t = "("+v1+" "+ch+" "+v2+")";
                val.push(t);
            }
        }
        return val.peek()+" ";
    }
    public static void main(String[] args) {
        String str ="-9/*+5346";
        System.out.println("Prefix is : "+str);
        System.out.println("Infix is : "+prefixToInfix(str));
    }
}
