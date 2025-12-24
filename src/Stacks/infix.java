package Stacks;
import java.util.Stack;
public class infix {
    public static int eval(String str){
        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            int ascii = (int)ch; // typecasting....
            // '0'-> 48 and '9'-> 57
            if(ascii>=48 && ascii<=57){
                int num = ascii-48;
                val.push(num);
            }
            else if(op.isEmpty()){ // op.size() == 0
                op.push(ch);
            }
            else{
                if(ch=='+' || ch=='-' ){
                    // work...sab iske barabar ya isse jdya priority ke hi honge....
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if(op.peek()=='+' ){
                        val.push(v1+v2);
                    }
                    if(op.peek()=='-'){
                        val.push(v1-v2);
                    }
                    if(op.peek()=='*'){
                        val.push(v1*v2);
                    }
                    if(op.peek()=='/'){
                        val.push(v1/v2);
                    }
                    op.pop();
                    op.push(ch);
                }
                if(ch=='*' || ch=='/'){
                    if(op.peek()=='*' || op.peek()=='/'){
                        // work
                        int v2 = val.pop();
                        int v1 = val.pop();
                        if(op.peek()=='*'){
                            val.push(v1*v2);
                        }
                        if(op.peek()=='/'){
                            val.push(v1/v2);
                        }
                        op.pop();
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
            int v2 = val.pop();
            int v1 = val.pop();
            if(op.peek()=='+' ){
                val.push(v1+v2);
            }
            if(op.peek()=='-'){
                val.push(v1-v2);
            }
            if(op.peek()=='*'){
                val.push(v1*v2);
            }
            if(op.peek()=='/'){
                val.push(v1/v2);
            }
            op.pop();
        }
        return val.peek();
    }

    // if brackets are present...
    public static int eval2(String str){
        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            int ascii = (int)ch; // typecasting....
            // '0'-> 48 and '9'-> 57
            if(ascii>=48 && ascii<=57){
                int num = ascii-48;
                val.push(num);
            }
            else if(op.isEmpty() || ch=='(' || op.peek()=='('){ // op.size() == 0
                op.push(ch);
            }
            else if(ch==')'){
                while(op.peek()!='('){
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if(op.peek()=='+' ){
                        val.push(v1+v2);
                    }
                    if(op.peek()=='-'){
                        val.push(v1-v2);
                    }
                    if(op.peek()=='*'){
                        val.push(v1*v2);
                    }
                    if(op.peek()=='/'){
                        val.push(v1/v2);
                    }
                    op.pop();
                }
                op.pop(); // '(' hata diya...
            }
            else{
                if(ch=='+' || ch=='-' ){
                    // work...sab iske barabar ya isse jdya priority ke hi honge....
                    int v2 = val.pop();
                    int v1 = val.pop();
                    if(op.peek()=='+' ){
                        val.push(v1+v2);
                    }
                    if(op.peek()=='-'){
                        val.push(v1-v2);
                    }
                    if(op.peek()=='*'){
                        val.push(v1*v2);
                    }
                    if(op.peek()=='/'){
                        val.push(v1/v2);
                    }
                    op.pop();
                    op.push(ch);
                }
                if(ch=='*' || ch=='/'){
                    if(op.peek()=='*' || op.peek()=='/'){
                        // work
                        int v2 = val.pop();
                        int v1 = val.pop();
                        if(op.peek()=='*'){
                            val.push(v1*v2);
                        }
                        if(op.peek()=='/'){
                            val.push(v1/v2);
                        }
                        op.pop();
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
            int v2 = val.pop();
            int v1 = val.pop();
            if(op.peek()=='+' ){
                val.push(v1+v2);
            }
            if(op.peek()=='-'){
                val.push(v1-v2);
            }
            if(op.peek()=='*'){
                val.push(v1*v2);
            }
            if(op.peek()=='/'){
                val.push(v1/v2);
            }
            op.pop();
        }
        return val.peek();
    }
    public static void main(String[] args) {
//        String str = "9-5+3*4/6";
        String str = "9-(5+3)*4/6";
        System.out.println(eval2(str));
    }
}
