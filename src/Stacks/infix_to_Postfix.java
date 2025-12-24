package Stacks;
import java.util.Stack;
public class infix_to_Postfix {
    public static String infixToPostfix(String infix){
        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        for(int i=0;i<infix.length();i++){
            char ch = infix.charAt(i);
            int ascii = (int)ch; // typecasting....
            // '0'-> 48 and '9'-> 57
            if(ascii>=48 && ascii<=57){ // string hi push krna hai val stack me...
                String s = "" + ch;
                val.push(s);
            }
            else if(op.isEmpty() || ch=='(' || op.peek()=='('){ // op.size() == 0
                op.push(ch);
            }
            else if(ch==')'){
                while(op.peek()!='('){
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();
                    String t = v1+" "+v2+" "+o;
                    val.push(t);
                }
                op.pop(); // '(' hata diya...
            }
            else{
                if(ch=='+' || ch=='-' ){
                    // work...sab iske barabar ya isse jdya priority ke hi honge....
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();
                    String t = v1+" "+v2+" "+o;
                    val.push(t);
                    op.push(ch);
                }
                if(ch=='*' || ch=='/'){
                    if(op.peek()=='*' || op.peek()=='/'){
                        // work
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char o = op.pop();
                        String t = v1+" "+v2+" "+o;
                        val.push(t);
                        op.push(ch);
                    }
                    else{ // op.peek has less priority then ch
                        op.push(ch);
                    }
                }
            }
        }
        // val stack size --> 1
        while(val.size()>1){
            String v2 = val.pop();
            String v1 = val.pop();
            char o = op.pop();
            String t = v1+" "+v2+" "+o;
            val.push(t);
        }
        return val.peek()+" ";
    }
    public static void main(String[] args) {
        String infix = "9-(5+3)*4/6";
        System.out.println("Infix is : "+infix);
        System.out.println("Postfix is : "+infixToPostfix(infix));
    }
}
