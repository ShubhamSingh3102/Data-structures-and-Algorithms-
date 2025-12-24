package Stacks;
import java.util.Stack;
public class postfix_to_prefix {
    public static String postfixToPrefix(String str){
        Stack<String> val = new Stack<>();
        int n = str.length();
        for(int i=0;i<n;i++){
            char ch = str.charAt(i);
            int ascii = (int)ch;
            if(ascii>=48 && ascii<=57){ // string hi push krna hai val stack me...
                String s = "" + ch;
                val.push(s);
            }
            else{
                String v2 = val.pop();
                String v1 = val.pop();
                String t = ch +" "+v1+" "+v2;
                val.push(t);
            }
        }
        return val.peek()+" ";
    }
    public static void main(String[] args) {
        String str = "953+4*6/-";
        System.out.println("Postfix is : "+str);
        System.out.println("Prefix is : "+postfixToPrefix(str));
    }
}

